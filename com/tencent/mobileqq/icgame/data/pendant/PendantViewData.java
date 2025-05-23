package com.tencent.mobileqq.icgame.data.pendant;

/* loaded from: classes15.dex */
public class PendantViewData {
    public static final int LOCATION_LEFT_TOP = 0;
    public static final int LOCATION_RIGHT_BOTTOM = 2;
    public static final int LOCATION_RIGHT_TOP = 1;
    public static final int PIC_URL_NUM_TYPE = 3;
    public static final int PIC_URL_TYPE = 2;
    public static final int UNKOWN_DEFAULT_TYPE = 0;
    public static final int UNVISIBLE = 0;
    public static final int VISIBLE = 1;
    public static final int WEBVIEW_TYPE = 1;
    public String businessData;
    public int location = -1;
    public long maxUpdateDuration;
    public long minUpdateDuration;
    public String version;
    public float viewHeight;
    public long viewId;
    public long viewType;
    public float viewWidth;
    public long visible;
    public WebPendantData webPendantData;

    public String toString() {
        return "PendantViewData{viewId=" + this.viewId + ", viewType=" + this.viewType + ", version='" + this.version + "', visible=" + this.visible + ", minUpdateDuration=" + this.minUpdateDuration + ", maxUpdateDuration=" + this.maxUpdateDuration + ", viewWidth=" + this.viewWidth + ", viewHeight=" + this.viewHeight + ", webPendantBean=" + this.webPendantData + ", businessData='" + this.businessData + "'}";
    }
}
