package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import java.io.Serializable;

/* loaded from: classes26.dex */
public final class IPCCmd implements Serializable {
    public static final int _BatchDownloadAction = 9;
    public static final int _BatchSDKDownloadAction = 13;
    public static final int _Empty = 0;
    public static final int _GetDownloadProgress = 3;
    public static final int _GetDownloadState = 2;
    public static final int _GetInstallState = 14;
    public static final int _OperateDownloadTask = 1;
    public static final int _QueryDownloadTask = 4;
    public static final int _QueryLoginInfo = 6;
    public static final int _QueryLoginState = 7;
    public static final int _ServiceFreeAction = 8;
    public static final int _SubScribeSDKDownloadTaskByVia = 10;
    public static final int _SyncSDKDownloadTask = 11;
    public static final int _SyncSDKHandShake = 12;
    public static final int _URIAction = 5;

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f380586a = true;
    private String __T;
    private int __value;
    private static IPCCmd[] __values = new IPCCmd[15];
    public static final IPCCmd Empty = new IPCCmd(0, 0, "Empty");
    public static final IPCCmd OperateDownloadTask = new IPCCmd(1, 1, "OperateDownloadTask");
    public static final IPCCmd GetDownloadState = new IPCCmd(2, 2, "GetDownloadState");
    public static final IPCCmd GetDownloadProgress = new IPCCmd(3, 3, "GetDownloadProgress");
    public static final IPCCmd QueryDownloadTask = new IPCCmd(4, 4, "QueryDownloadTask");
    public static final IPCCmd URIAction = new IPCCmd(5, 5, "URIAction");
    public static final IPCCmd QueryLoginInfo = new IPCCmd(6, 6, "QueryLoginInfo");
    public static final IPCCmd QueryLoginState = new IPCCmd(7, 7, "QueryLoginState");
    public static final IPCCmd ServiceFreeAction = new IPCCmd(8, 8, "ServiceFreeAction");
    public static final IPCCmd BatchDownloadAction = new IPCCmd(9, 9, "BatchDownloadAction");
    public static final IPCCmd SubScribeSDKDownloadTaskByVia = new IPCCmd(10, 10, "SubScribeSDKDownloadTaskByVia");
    public static final IPCCmd SyncSDKDownloadTask = new IPCCmd(11, 11, "SyncSDKDownloadTask");
    public static final IPCCmd SyncSDKHandShake = new IPCCmd(12, 12, "SyncSDKHandShake");
    public static final IPCCmd BatchSDKDownloadAction = new IPCCmd(13, 13, "BatchSDKDownloadAction");
    public static final IPCCmd GetInstallState = new IPCCmd(14, 14, "GetInstallState");

    IPCCmd(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static IPCCmd convert(int i3) {
        int i16 = 0;
        while (true) {
            IPCCmd[] iPCCmdArr = __values;
            if (i16 < iPCCmdArr.length) {
                if (iPCCmdArr[i16].value() == i3) {
                    return __values[i16];
                }
                i16++;
            } else {
                if (f380586a) {
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

    public static IPCCmd convert(String str) {
        int i3 = 0;
        while (true) {
            IPCCmd[] iPCCmdArr = __values;
            if (i3 < iPCCmdArr.length) {
                if (iPCCmdArr[i3].toString().equals(str)) {
                    return __values[i3];
                }
                i3++;
            } else {
                if (f380586a) {
                    return null;
                }
                throw new AssertionError();
            }
        }
    }
}
