package com.tencent.mobileqq.data;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qqcommon.api.IViewUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes10.dex */
public class GrayTipsMessageConstants$HighlightItem {
    public int actionType;
    public int color;
    public int end;
    public int groupId;
    public String icon;
    public String iconAlt;
    private int iconSize;
    public Bitmap mBitmap;
    public String mMsgAActionData;
    public String mMsgActionData;
    public boolean needUpdateNick;
    public String remark;
    public int start;
    public int textColor;
    public long uin;

    GrayTipsMessageConstants$HighlightItem(int i3, int i16, long j3, int i17, int i18, String str, String str2) {
        this.iconSize = ((IViewUtilsApi) QRoute.api(IViewUtilsApi.class)).dpToPx(16.0f);
        this.remark = null;
        this.mMsgActionData = null;
        this.mMsgAActionData = null;
        this.mBitmap = null;
        this.start = i3;
        this.end = i16;
        this.uin = j3;
        this.needUpdateNick = i17 != 0;
        this.actionType = i18;
        this.mMsgActionData = str;
        this.mMsgAActionData = str2;
    }

    public String toString() {
        return "HighlightItem{start=" + this.start + ", end=" + this.end + ", uin=" + this.uin + ", needUpdateNick=" + this.needUpdateNick + ", actionType=" + this.actionType + ", color=" + this.color + ", icon='" + this.icon + "', iconSize=" + this.iconSize + ", iconAlt='" + this.iconAlt + "', textColor=" + this.textColor + ", remark='" + this.remark + "', groupId=" + this.groupId + ", mMsgActionData='" + this.mMsgActionData + "', mMsg_A_ActionData='" + this.mMsgAActionData + "'}";
    }

    public GrayTipsMessageConstants$HighlightItem(int i3, int i16, long j3, int i17, int i18, String str, String str2, String str3, String str4, int i19) {
        this(i3, i16, j3, i17, i18, str, str2);
        this.icon = str3;
        this.iconAlt = str4;
        this.textColor = i19;
    }

    public GrayTipsMessageConstants$HighlightItem(int i3, int i16, long j3, int i17, int i18, String str, String str2, String str3, String str4, int i19, String str5, int i26, Bitmap bitmap) {
        this(i3, i16, j3, i17, i18, str, str2, str3, str4, i19);
        this.remark = str5;
        this.groupId = i26;
        this.mBitmap = bitmap;
    }
}
