package com.tencent.mobileqq.minigame.utils;

import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0002J\u001c\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/minigame/utils/MiniGameStorageUtil;", "", "()V", "TAG", "", "closeMMKVEntity", "", "getMMKVEntity", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "getString", "key", "defaultVal", "putString", "value", "removeKey", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameStorageUtil {
    public static final MiniGameStorageUtil INSTANCE = new MiniGameStorageUtil();
    private static final String TAG = "MiniGameStorageUtil";

    MiniGameStorageUtil() {
    }

    private final MMKVOptionEntity getMMKVEntity() {
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_MINI_GAME);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026QMMKVFile.FILE_MINI_GAME)");
        return from;
    }

    @JvmStatic
    public static final String getString(String key, String defaultVal) {
        Intrinsics.checkNotNullParameter(key, "key");
        String decodeString = INSTANCE.getMMKVEntity().decodeString(key, defaultVal);
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 2, "getString: key=" + key + ", value=" + decodeString);
        }
        return decodeString;
    }

    @JvmStatic
    public static final void putString(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 2, "putString: key=" + key + ", value=" + value);
        }
        INSTANCE.getMMKVEntity().encodeString(key, value);
    }

    @JvmStatic
    public static final void removeKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 2, "removeKey: key=" + key);
        }
        INSTANCE.getMMKVEntity().removeKey(key);
    }

    @JvmStatic
    public static final void closeMMKVEntity() {
        QLog.i(TAG, 1, "closeMMKVEntity");
        INSTANCE.getMMKVEntity().closeEntity();
    }
}
