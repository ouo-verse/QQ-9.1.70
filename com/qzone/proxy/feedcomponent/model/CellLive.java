package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.SpecialMsg;
import NS_MOBILE_FEEDS.cell_live;
import NS_MOBILE_FEEDS.liveUser;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellLive implements SmartParcelable {
    public static final String IS_PANORAMA = "1";
    public static final String IS_SCREENCAP = "1";

    @NeedParcel
    public int enterRoom;

    @NeedParcel
    public String exception_tips;

    @NeedParcel
    public int giftNum;

    @NeedParcel
    public int likeNum;

    @NeedParcel
    public int liveType;

    @NeedParcel
    public int livetime;
    public String livetimeStr;

    @NeedParcel
    public Map<Integer, String> mapExtendInfo;

    @NeedParcel
    public int roomstat;

    @NeedParcel
    public int usercount;

    @NeedParcel
    public ArrayList<liveUser> vctLiveUserList;

    @NeedParcel
    public String roomid = "";

    @NeedParcel
    public String tipsMessage = "";
    public ArrayList<SpecialMsg> vctCommentList = null;

    public String getLiveTimeStr() {
        StringBuilder sb5;
        String str;
        Object obj;
        Object obj2;
        String str2;
        if (this.livetime <= 0) {
            return null;
        }
        if (!TextUtils.isEmpty(this.livetimeStr)) {
            return this.livetimeStr;
        }
        int i3 = this.livetime;
        if (i3 >= 3600) {
            int i16 = i3 / 3600;
            int i17 = ((int) ((i3 % 3600.0f) / 3600.0f)) * 10;
            StringBuilder sb6 = new StringBuilder();
            sb6.append(i16);
            if (i17 > 0) {
                str2 = "." + i17;
            } else {
                str2 = "";
            }
            sb6.append(str2);
            sb6.append("\u5c0f\u65f6");
            this.livetimeStr = sb6.toString();
        } else if (i3 >= 60) {
            int i18 = i3 % 60;
            int i19 = i3 / 60;
            StringBuilder sb7 = new StringBuilder();
            if (i19 > 9) {
                obj = Integer.valueOf(i19);
            } else {
                obj = "0" + i19;
            }
            sb7.append(obj);
            sb7.append(":");
            if (i18 > 9) {
                obj2 = Integer.valueOf(i18);
            } else {
                obj2 = "0" + i18;
            }
            sb7.append(obj2);
            this.livetimeStr = sb7.toString();
        } else {
            if (i3 > 9) {
                sb5 = new StringBuilder();
                str = "00:";
            } else {
                sb5 = new StringBuilder();
                str = "00:0";
            }
            sb5.append(str);
            sb5.append(i3);
            this.livetimeStr = sb5.toString();
        }
        return this.livetimeStr;
    }

    public boolean isLiveAvailable() {
        int i3 = this.roomstat;
        return i3 == 1 || i3 == 3;
    }

    public String toString() {
        return "CellLive {\nroomid: " + this.roomid + "\nroomstat: " + this.roomstat + "\nusercount: " + this.usercount + "\nlivetime: " + this.livetime + "\ngiftNum: " + this.giftNum + "\nlikeNum: " + this.likeNum + "\ntipsMessage: " + this.tipsMessage + "\nexception_tips: " + this.exception_tips + "\n}mapExtendInfo: " + this.mapExtendInfo + "\n}";
    }

    public static CellLive create(l lVar) {
        if (lVar == null || lVar.f50341a0 == null) {
            return null;
        }
        CellLive cellLive = new CellLive();
        cell_live cell_liveVar = lVar.f50341a0;
        cellLive.roomid = cell_liveVar.roomid;
        cellLive.roomstat = cell_liveVar.roomstat;
        cellLive.usercount = cell_liveVar.usercount;
        cellLive.livetime = cell_liveVar.livetime;
        cellLive.giftNum = cell_liveVar.giftNum;
        cellLive.likeNum = cell_liveVar.likeNum;
        cellLive.tipsMessage = cell_liveVar.tipsMessage;
        cellLive.exception_tips = cell_liveVar.exception_tips;
        cellLive.vctCommentList = cell_liveVar.vctCommentList;
        cellLive.vctLiveUserList = cell_liveVar.vctLiveUserList;
        cellLive.liveType = cell_liveVar.liveType;
        cellLive.mapExtendInfo = cell_liveVar.mapExtendInfo;
        return cellLive;
    }
}
