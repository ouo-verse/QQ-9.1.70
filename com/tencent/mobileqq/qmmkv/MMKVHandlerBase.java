package com.tencent.mobileqq.qmmkv;

import com.tencent.mmkv.MMKVLogLevel;
import com.tencent.mmkv.MMKVRecoverStrategic;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface MMKVHandlerBase extends com.tencent.mmkv.b, com.tencent.mmkv.a, j {
    boolean isFileAvailable(String str);

    void logDebug(String str, String str2);

    void logError(String str, String str2);

    void logInfo(String str, String str2);

    void logWarn(String str, String str2);

    @Override // com.tencent.mmkv.b
    /* synthetic */ void mmkvLog(MMKVLogLevel mMKVLogLevel, String str, int i3, String str2, String str3);

    /* synthetic */ void onContentChangedByOuterProcess(String str);

    /* synthetic */ void onDecode(String str, String str2);

    /* synthetic */ <T> void onEncode(String str, String str2, T t16);

    @Override // com.tencent.mmkv.b
    /* synthetic */ MMKVRecoverStrategic onMMKVCRCCheckFail(String str);

    @Override // com.tencent.mmkv.b
    /* synthetic */ MMKVRecoverStrategic onMMKVFileLengthError(String str);

    /* synthetic */ void onSync(String str, boolean z16);

    @NotNull
    /* synthetic */ com.tencent.mobileqq.qmmkv.v2.k provideMemoryCache();

    @Override // com.tencent.mmkv.b
    /* synthetic */ boolean wantLogRedirecting();
}
