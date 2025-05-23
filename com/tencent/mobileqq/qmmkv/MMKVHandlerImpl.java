package com.tencent.mobileqq.qmmkv;

import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.mmkv.MMKVLogLevel;
import com.tencent.mmkv.MMKVRecoverStrategic;
import com.tencent.mobileqq.activity.recent.MsgSummary;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes16.dex */
public class MMKVHandlerImpl implements MMKVHandlerBase {
    private static final String TAG = "MMKVHandlerImpl";

    @Override // com.tencent.mobileqq.qmmkv.MMKVHandlerBase
    public boolean isFileAvailable(String str) {
        return true;
    }

    @Override // com.tencent.mobileqq.qmmkv.MMKVHandlerBase
    public void logDebug(String str, String str2) {
        Log.d(str, str2);
    }

    @Override // com.tencent.mobileqq.qmmkv.MMKVHandlerBase
    public void logError(String str, String str2) {
        Log.e(str, str2);
    }

    @Override // com.tencent.mobileqq.qmmkv.MMKVHandlerBase
    public void logInfo(String str, String str2) {
        Log.i(str, str2);
    }

    @Override // com.tencent.mobileqq.qmmkv.MMKVHandlerBase
    public void logWarn(String str, String str2) {
        Log.w(str, str2);
    }

    @Override // com.tencent.mobileqq.qmmkv.MMKVHandlerBase, com.tencent.mmkv.b
    public void mmkvLog(MMKVLogLevel mMKVLogLevel, String str, int i3, String str2, String str3) {
        String str4 = "<" + str + ":" + mMKVLogLevel + "::" + str2 + ":>" + str3;
        if (mMKVLogLevel != MMKVLogLevel.LevelWarning && mMKVLogLevel != MMKVLogLevel.LevelError) {
            logDebug(TAG, str4);
        } else {
            logError(TAG, str4);
        }
    }

    @Override // com.tencent.mobileqq.qmmkv.MMKVHandlerBase, com.tencent.mmkv.a
    public void onContentChangedByOuterProcess(String str) {
        logDebug(TAG, "mmkvContentChangedByOuterProcess:" + str);
    }

    @Override // com.tencent.mobileqq.qmmkv.MMKVHandlerBase, com.tencent.mobileqq.qmmkv.j
    public void onDecode(String str, String str2) {
        logDebug("onDecode", "[" + str + "]" + str2);
    }

    @Override // com.tencent.mobileqq.qmmkv.MMKVHandlerBase, com.tencent.mobileqq.qmmkv.j
    public <T> void onEncode(String str, String str2, T t16) {
        logDebug("onEncode", "[" + str + "]" + str2 + MsgSummary.STR_COLON + t16);
    }

    @Override // com.tencent.mobileqq.qmmkv.MMKVHandlerBase, com.tencent.mmkv.b
    public MMKVRecoverStrategic onMMKVCRCCheckFail(String str) {
        return MMKVRecoverStrategic.OnErrorRecover;
    }

    @Override // com.tencent.mobileqq.qmmkv.MMKVHandlerBase, com.tencent.mmkv.b
    public MMKVRecoverStrategic onMMKVFileLengthError(String str) {
        return MMKVRecoverStrategic.OnErrorRecover;
    }

    @Override // com.tencent.mobileqq.qmmkv.MMKVHandlerBase, com.tencent.mobileqq.qmmkv.j
    public void onSync(String str, boolean z16) {
        logDebug("onSync", "[" + str + "] force: " + z16);
    }

    @Override // com.tencent.mobileqq.qmmkv.MMKVHandlerBase
    @NonNull
    public com.tencent.mobileqq.qmmkv.v2.k provideMemoryCache() {
        return new com.tencent.mobileqq.qmmkv.v2.d(4L);
    }

    @Override // com.tencent.mobileqq.qmmkv.MMKVHandlerBase, com.tencent.mmkv.b
    public boolean wantLogRedirecting() {
        return true;
    }
}
