package org.light.bean;

import org.light.Controller;

/* compiled from: P */
/* loaded from: classes29.dex */
public class WMElement {
    public static final int CHECK_IN_ERR_CODE_DUPLICATE = 11;
    public static final int CHECK_IN_ERR_CODE_SUCCESS = 0;
    private static final String TAG = "WMElement";
    public static final String TYPE_CHECK_IN = "CHECK_IN";
    public static final String TYPE_COUNTDOWN = "COUNTDOWN";
    public static final String TYPE_EDITABLE_LOCATION = "EDITABLE_LOCATION";
    public static final String TYPE_PLAIN_TEXT = "PLAIN_TEXT";
    public static final String TYPE_SINCE = "SINCE";
    public Controller controller;
    public final String elementId;
    public final String key;
    public final String materialId;
    public final String type;

    public WMElement(String str, String str2, String str3) {
        this.materialId = str;
        this.elementId = str2;
        this.type = str3;
        this.key = str + "_" + str2;
    }

    private native String getCustomInnerValue(String str, String str2);

    private native int nativeDoCheckIn(String str, String str2);

    private native void nativeResetCheckIn(String str);

    private void setCustomData(String str, String str2) {
        setCustomData(str, str2, true);
    }

    private native void setCustomData(String str, String str2, boolean z16);

    public int doCheckIn() {
        return doCheckIn(this.key, this.type);
    }

    public String getInnerValue() {
        return getCustomInnerValue(this.key, this.type);
    }

    public void resetCheckIn() {
        nativeResetCheckIn(this.key);
    }

    public void setDate(long j3) {
        setCustomData(this.key, String.valueOf(j3));
    }

    public void setLocation(String str) {
        setCustomData(this.key, str, false);
    }

    public void setText(String str) {
        setCustomData(this.key, str);
    }

    public int doCheckIn(String str, String str2) {
        return nativeDoCheckIn(str, str2);
    }
}
