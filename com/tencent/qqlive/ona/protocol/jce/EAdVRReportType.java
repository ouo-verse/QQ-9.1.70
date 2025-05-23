package com.tencent.qqlive.ona.protocol.jce;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class EAdVRReportType implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _EAdVRReportTypeActionBtnClick = 3;
    public static final int _EAdVRReportTypeCommonDownload = 6;
    public static final int _EAdVRReportTypeCommonExposureClick = 1;
    public static final int _EAdVRReportTypeCommonParams = 9;
    public static final int _EAdVRReportTypeCommonPlay = 5;
    public static final int _EAdVRReportTypeHeaderClick = 2;
    public static final int _EAdVRReportTypePosterClick = 4;
    public static final int _EAdVRReportTypeSkipClick = 7;
    public static final int _EAdVRReportTypeSplashChain = 8;
    public static final int _EAdVRReportTypeUnknown = 0;
    private String __T;
    private int __value;

    /* renamed from: d, reason: collision with root package name */
    private static EAdVRReportType[] f345339d = new EAdVRReportType[10];
    public static final EAdVRReportType EAdVRReportTypeUnknown = new EAdVRReportType(0, 0, "EAdVRReportTypeUnknown");
    public static final EAdVRReportType EAdVRReportTypeCommonExposureClick = new EAdVRReportType(1, 1, "EAdVRReportTypeCommonExposureClick");
    public static final EAdVRReportType EAdVRReportTypeHeaderClick = new EAdVRReportType(2, 2, "EAdVRReportTypeHeaderClick");
    public static final EAdVRReportType EAdVRReportTypeActionBtnClick = new EAdVRReportType(3, 3, "EAdVRReportTypeActionBtnClick");
    public static final EAdVRReportType EAdVRReportTypePosterClick = new EAdVRReportType(4, 4, "EAdVRReportTypePosterClick");
    public static final EAdVRReportType EAdVRReportTypeCommonPlay = new EAdVRReportType(5, 5, "EAdVRReportTypeCommonPlay");
    public static final EAdVRReportType EAdVRReportTypeCommonDownload = new EAdVRReportType(6, 6, "EAdVRReportTypeCommonDownload");
    public static final EAdVRReportType EAdVRReportTypeSkipClick = new EAdVRReportType(7, 7, "EAdVRReportTypeSkipClick");
    public static final EAdVRReportType EAdVRReportTypeSplashChain = new EAdVRReportType(8, 8, "EAdVRReportTypeSplashChain");
    public static final EAdVRReportType EAdVRReportTypeCommonParams = new EAdVRReportType(9, 9, "EAdVRReportTypeCommonParams");

    EAdVRReportType(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        f345339d[i3] = this;
    }

    public static EAdVRReportType convert(int i3) {
        int i16 = 0;
        while (true) {
            EAdVRReportType[] eAdVRReportTypeArr = f345339d;
            if (i16 >= eAdVRReportTypeArr.length) {
                return null;
            }
            if (eAdVRReportTypeArr[i16].value() == i3) {
                return f345339d[i16];
            }
            i16++;
        }
    }

    public String toString() {
        return this.__T;
    }

    public int value() {
        return this.__value;
    }

    public static EAdVRReportType convert(String str) {
        int i3 = 0;
        while (true) {
            EAdVRReportType[] eAdVRReportTypeArr = f345339d;
            if (i3 >= eAdVRReportTypeArr.length) {
                return null;
            }
            if (eAdVRReportTypeArr[i3].toString().equals(str)) {
                return f345339d[i3];
            }
            i3++;
        }
    }
}
