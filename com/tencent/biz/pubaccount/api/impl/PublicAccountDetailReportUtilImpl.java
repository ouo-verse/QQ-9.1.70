package com.tencent.biz.pubaccount.api.impl;

import com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashMap;

/* loaded from: classes32.dex */
public class PublicAccountDetailReportUtilImpl implements IPublicAccountDetailReportUtil {
    public static final String TAG = "PADetailReportUtil";
    public static final String Version = "1.0";
    static ByteBuffer buffer = ByteBuffer.allocate(8);
    int curPage = 1;
    long curTime;
    int entranceID;
    int isDirectClick;
    String itemID;
    String itemList;
    int itemPos;
    int pageNum;
    String search;
    String searchID;
    int startPos;
    int superViewID;
    int thisViewID;
    int version;

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil
    public String buildSearchID(String str, String str2) {
        try {
            if (this.search.equals(str2) && this.searchID != null) {
                return null;
            }
            buffer.put(MD5.toMD5Byte(str + String.valueOf(System.currentTimeMillis()) + Math.random()), 0, 8);
            buffer.flip();
            this.curPage = 0;
            return String.valueOf(buffer.getLong());
        } catch (Exception unused) {
            return null;
        }
    }

    public void doReport(String str, HashMap<String, String> hashMap) {
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, str, true, 0L, 0L, hashMap, null);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil
    public void setAttrEntrance(int i3) {
        resetAttribute();
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(IPublicAccountDetailReportUtil.KEY_VERSION, "1.0");
        hashMap.put(IPublicAccountDetailReportUtil.KEY_THISVIEWID, String.valueOf(i3));
        hashMap.put(IPublicAccountDetailReportUtil.KEY_CURTIME, String.valueOf(currentTimeMillis));
        doReport(IPublicAccountDetailReportUtil.EVENT_ENTRANCE, hashMap);
        this.thisViewID = i3;
        this.entranceID = i3;
        this.curPage = 0;
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "start report entrance event cur view:" + i3 + ", time:" + currentTimeMillis);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil
    public void setAttrSearchAttention(int i3, String str, int i16, int i17, boolean z16) {
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(IPublicAccountDetailReportUtil.KEY_VERSION, "1.0");
        hashMap.put(IPublicAccountDetailReportUtil.KEY_SEARCHID, this.searchID);
        hashMap.put(IPublicAccountDetailReportUtil.KEY_SEARCH, this.search);
        hashMap.put(IPublicAccountDetailReportUtil.KEY_CURTIME, String.valueOf(currentTimeMillis));
        hashMap.put(IPublicAccountDetailReportUtil.KEY_SUPERVIEWID, String.valueOf(this.thisViewID));
        hashMap.put(IPublicAccountDetailReportUtil.KEY_THISVIEWID, String.valueOf(this.entranceID + i3));
        hashMap.put(IPublicAccountDetailReportUtil.KEY_ISDIRECTCLICK, String.valueOf(i16));
        hashMap.put(IPublicAccountDetailReportUtil.KEY_ITEMID, str);
        if (i17 == 12) {
            hashMap.put(IPublicAccountDetailReportUtil.KEY_ISFOLDER, "1");
        } else {
            hashMap.put(IPublicAccountDetailReportUtil.KEY_ISFOLDER, "0");
        }
        if (z16) {
            hashMap.put(IPublicAccountDetailReportUtil.KEY_ISOFFLINE, "1");
        } else {
            hashMap.put(IPublicAccountDetailReportUtil.KEY_ISOFFLINE, "0");
        }
        doReport(IPublicAccountDetailReportUtil.EVENT_ATTENTION, hashMap);
        this.superViewID = this.thisViewID;
        this.thisViewID = i3 + this.entranceID;
        this.itemID = str;
        this.isDirectClick = i16;
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "start report attention event searchID:" + this.searchID + ", superview:" + this.superViewID + ", thisview:" + this.thisViewID + ", itemID:" + this.itemID + ", isDirectClick:" + this.isDirectClick + ", time" + currentTimeMillis + ", from:" + i17 + ", isoffline:" + z16);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil
    public void setAttrSearchClick(int i3, String str, int i16, int i17) {
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(IPublicAccountDetailReportUtil.KEY_VERSION, "1.0");
        hashMap.put(IPublicAccountDetailReportUtil.KEY_SEARCHID, this.searchID);
        hashMap.put(IPublicAccountDetailReportUtil.KEY_SEARCH, this.search);
        hashMap.put(IPublicAccountDetailReportUtil.KEY_CURTIME, String.valueOf(currentTimeMillis));
        hashMap.put(IPublicAccountDetailReportUtil.KEY_ITEMID, str);
        hashMap.put(IPublicAccountDetailReportUtil.KEY_SUPERVIEWID, String.valueOf(this.thisViewID));
        hashMap.put(IPublicAccountDetailReportUtil.KEY_THISVIEWID, String.valueOf(this.entranceID + i3));
        hashMap.put(IPublicAccountDetailReportUtil.KEY_ITEMPOS, String.valueOf(i16));
        if (i17 == 12) {
            hashMap.put(IPublicAccountDetailReportUtil.KEY_ISFOLDER, "1");
        } else {
            hashMap.put(IPublicAccountDetailReportUtil.KEY_ISFOLDER, "0");
        }
        doReport(IPublicAccountDetailReportUtil.EVENT_CLICK, hashMap);
        this.superViewID = this.thisViewID;
        this.thisViewID = i3 + this.entranceID;
        this.itemPos = i16;
        this.itemID = str;
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "start report click event searchID:" + this.searchID + ", superview:" + this.superViewID + ", thisview:" + this.thisViewID + ", itemPos:" + this.itemPos + ", time:" + currentTimeMillis + ", itemID:" + this.itemID + ", from:" + i17);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil
    public void backPage() {
        this.curPage = 0;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil
    public void resetAttribute() {
        this.searchID = null;
        this.search = null;
        this.superViewID = 0;
        this.thisViewID = 0;
        this.pageNum = 0;
        this.startPos = 0;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil
    public void setAttrSearchPage(String str, String str2, int i3, boolean z16, int i16, String str3) {
        if (i3 == 3) {
            int i17 = this.curPage + 1;
            this.curPage = i17;
            this.startPos = (i17 - 1) * i16;
        } else {
            this.curPage = 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(IPublicAccountDetailReportUtil.KEY_VERSION, "1.0");
        if (str != null) {
            hashMap.put(IPublicAccountDetailReportUtil.KEY_SEARCHID, str);
        } else {
            hashMap.put(IPublicAccountDetailReportUtil.KEY_SEARCHID, this.searchID);
        }
        hashMap.put(IPublicAccountDetailReportUtil.KEY_CURTIME, String.valueOf(currentTimeMillis));
        hashMap.put(IPublicAccountDetailReportUtil.KEY_SEARCH, str2);
        hashMap.put(IPublicAccountDetailReportUtil.KEY_SUPERVIEWID, String.valueOf(this.thisViewID));
        hashMap.put(IPublicAccountDetailReportUtil.KEY_THISVIEWID, String.valueOf(this.entranceID + i3));
        int i18 = this.curPage;
        if (i18 != 0) {
            hashMap.put(IPublicAccountDetailReportUtil.KEY_PAGENUM, String.valueOf(i18));
            hashMap.put(IPublicAccountDetailReportUtil.KEY_STARTPOS, String.valueOf(i16 * (this.curPage - 1)));
        } else {
            hashMap.put(IPublicAccountDetailReportUtil.KEY_PAGENUM, "1");
            hashMap.put(IPublicAccountDetailReportUtil.KEY_STARTPOS, "0");
        }
        hashMap.put(IPublicAccountDetailReportUtil.KEY_ITEMLIST, str3);
        doReport(IPublicAccountDetailReportUtil.EVENT_PAGE, hashMap);
        this.superViewID = this.thisViewID;
        this.thisViewID = i3 + this.entranceID;
        if (str != null) {
            this.searchID = str;
        }
        this.search = str2;
        this.pageNum = this.curPage;
        this.itemList = str3;
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "start report searchpage searchID:" + this.searchID + " superview:" + this.superViewID + ", thisview:" + this.thisViewID + ", search:" + this.search);
            QLog.d(TAG, 4, "pagenum:" + this.pageNum + ", startPos:" + this.startPos + ", itemList:" + this.itemList + ", time:" + currentTimeMillis);
        }
    }
}
