package com.tencent.bugly.crashreport.crash.jni;

import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface NativeExceptionHandler {
    boolean clearPreDumpAnrInfo();

    void handleNativeException(int i3, int i16, long j3, long j16, String str, String str2, String str3, String str4, String str5, int i17, String str6, int i18, int i19, int i26, String str7, String str8);

    void handleNativeException2(int i3, int i16, long j3, long j16, String str, String str2, String str3, String str4, String str5, int i17, String str6, int i18, int i19, int i26, String str7, String str8, String[] strArr);

    CrashDetailBean packageCrashBasicDatas(String str, long j3, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11);

    void packageCrashDetailDatas(CrashDetailBean crashDetailBean, String str, byte[] bArr, Map<String, String> map, boolean z16, long j3, long j16, long j17, long j18);

    boolean preDumpAnrInfo();

    boolean updateStateAndHandleAnr();
}
