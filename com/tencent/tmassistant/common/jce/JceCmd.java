package com.tencent.tmassistant.common.jce;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class JceCmd implements Serializable {
    public static final int _Empty = 0;
    public static final int _GetAppDetailForSdk = 16;
    public static final int _GetAppSimpleDetail = 5;
    public static final int _GetAppUpdate = 3;
    public static final int _GetConfig = 7;
    public static final int _GetHalleyUrl = 10;
    public static final int _GetHotSdkUpdate = 11;
    public static final int _GetMobilePhoneQqApkInfo = 15;
    public static final int _GetPkgInfo = 12;
    public static final int _GetPush = 8;
    public static final int _GetRecmdIdBatch = 14;
    public static final int _GetSettings = 2;
    public static final int _ReportApkFileInfo = 4;
    public static final int _ReportLog = 1;
    public static final int _SDKDataReport = 13;
    public static final int _StatReport = 9;

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f380377a = true;
    private String __T;
    private int __value;
    private static JceCmd[] __values = new JceCmd[16];
    public static final JceCmd Empty = new JceCmd(0, 0, "Empty");
    public static final JceCmd ReportLog = new JceCmd(1, 1, "ReportLog");
    public static final JceCmd GetSettings = new JceCmd(2, 2, "GetSettings");
    public static final JceCmd GetAppUpdate = new JceCmd(3, 3, "GetAppUpdate");
    public static final JceCmd ReportApkFileInfo = new JceCmd(4, 4, "ReportApkFileInfo");
    public static final JceCmd GetAppSimpleDetail = new JceCmd(5, 5, "GetAppSimpleDetail");
    public static final JceCmd GetConfig = new JceCmd(6, 7, "GetConfig");
    public static final JceCmd GetPush = new JceCmd(7, 8, "GetPush");
    public static final JceCmd StatReport = new JceCmd(8, 9, "StatReport");
    public static final JceCmd GetHalleyUrl = new JceCmd(9, 10, "GetHalleyUrl");
    public static final JceCmd GetHotSdkUpdate = new JceCmd(10, 11, "GetHotSdkUpdate");
    public static final JceCmd GetPkgInfo = new JceCmd(11, 12, "GetPkgInfo");
    public static final JceCmd SDKDataReport = new JceCmd(12, 13, "SDKDataReport");
    public static final JceCmd GetRecmdIdBatch = new JceCmd(13, 14, "GetRecmdIdBatch");
    public static final JceCmd GetMobilePhoneQqApkInfo = new JceCmd(14, 15, "GetMobilePhoneQqApkInfo");
    public static final JceCmd GetAppDetailForSdk = new JceCmd(15, 16, "GetAppDetailForSdk");

    JceCmd(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static JceCmd convert(int i3) {
        int i16 = 0;
        while (true) {
            JceCmd[] jceCmdArr = __values;
            if (i16 < jceCmdArr.length) {
                if (jceCmdArr[i16].value() == i3) {
                    return __values[i16];
                }
                i16++;
            } else {
                if (f380377a) {
                    return null;
                }
                throw new AssertionError();
            }
        }
    }

    public String toString() {
        return this.__T;
    }

    public int value() {
        return this.__value;
    }

    public static JceCmd convert(String str) {
        int i3 = 0;
        while (true) {
            JceCmd[] jceCmdArr = __values;
            if (i3 < jceCmdArr.length) {
                if (jceCmdArr[i3].toString().equals(str)) {
                    return __values[i3];
                }
                i3++;
            } else {
                if (f380377a) {
                    return null;
                }
                throw new AssertionError();
            }
        }
    }
}
