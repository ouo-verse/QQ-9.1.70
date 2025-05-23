package com.tencent.mmkv;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface b {
    void mmkvLog(MMKVLogLevel mMKVLogLevel, String str, int i3, String str2, String str3);

    MMKVRecoverStrategic onMMKVCRCCheckFail(String str);

    MMKVRecoverStrategic onMMKVFileLengthError(String str);

    boolean wantLogRedirecting();
}
