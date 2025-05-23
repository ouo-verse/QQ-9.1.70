package com.tencent.mobileqq.minigame.data;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import java.util.ArrayList;
import java.util.List;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes33.dex */
public class BlockAdInfo {
    public static final int BLOCK_UPDATE_SIZE_LEFT = 1;
    public static final int BLOCK_UPDATE_SIZE_NO = -1;
    public static final int BLOCK_UPDATE_SIZE_TOP = 2;
    private static final String TAG = "BlockAdPositionInfo";
    private String mAdUnitId;
    private int mId;
    private int mLeft;
    private int mOri;
    private int mRealHeight;
    private int mRealWidth;
    private int mSize;
    private int mTop;
    private ArrayList<MiniAppInfo> mAdMiniAppInfoList = new ArrayList<>();
    private List<GdtAd> mGdtAdInfoList = new ArrayList();
    private String mCurrentMiniAppId = "";

    public BlockAdInfo(String str, int i3, int i16, int i17, int i18, int i19) {
        this.mAdUnitId = "";
        this.mAdUnitId = str;
        this.mLeft = i3;
        this.mTop = i16;
        this.mSize = i17;
        this.mOri = i18;
        this.mId = i19;
    }

    public String getAdUnitId() {
        return this.mAdUnitId;
    }

    public ArrayList<MiniAppInfo> getBlockAdInfo() {
        return this.mAdMiniAppInfoList;
    }

    public int getCompId() {
        return this.mId;
    }

    public String getCurrentMiniAppId() {
        return this.mCurrentMiniAppId;
    }

    public List<GdtAd> getGdtAdInfoList() {
        return this.mGdtAdInfoList;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public int getOri() {
        return this.mOri;
    }

    public int getRealHeight() {
        return this.mRealHeight;
    }

    public int getRealWidth() {
        return this.mRealWidth;
    }

    public int getSize() {
        return this.mSize;
    }

    public int getTop() {
        return this.mTop;
    }

    public boolean isValid() {
        int i3;
        return this.mLeft >= 0 && this.mTop >= 0 && this.mSize > 0 && ((i3 = this.mOri) == 0 || i3 == 90);
    }

    public void setCurrentMiniAppId(String str) {
        this.mCurrentMiniAppId = str;
    }

    public void setLeft(int i3) {
        this.mLeft = i3;
    }

    public void setRealHeight(int i3) {
        this.mRealHeight = i3;
    }

    public void setRealWidth(int i3) {
        this.mRealWidth = i3;
    }

    public void setTop(int i3) {
        this.mTop = i3;
    }

    public void setAdMiniAppInfo(List<GdtAd> list) {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo displayInfo;
        String str;
        if (list == null || list.size() < 1) {
            return;
        }
        this.mGdtAdInfoList = list;
        this.mAdMiniAppInfoList.clear();
        for (GdtAd gdtAd : list) {
            if (gdtAd != null && (adInfo = gdtAd.info) != null && (displayInfo = adInfo.display_info) != null) {
                qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo basicInfo = displayInfo.basic_info;
                if (basicInfo != null) {
                    str = basicInfo.img.get();
                } else {
                    str = "";
                }
                if (!TextUtils.isEmpty(str)) {
                    String str2 = gdtAd.info.display_info.mini_program_id.get();
                    String str3 = gdtAd.info.display_info.mini_program_name.get();
                    MiniAppInfo miniAppInfo = new MiniAppInfo();
                    miniAppInfo.appId = str2;
                    miniAppInfo.iconUrl = str;
                    miniAppInfo.name = str3;
                    this.mAdMiniAppInfoList.add(miniAppInfo);
                }
            }
        }
        this.mSize = this.mGdtAdInfoList.size();
    }
}
