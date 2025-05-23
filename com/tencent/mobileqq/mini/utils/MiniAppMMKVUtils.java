package com.tencent.mobileqq.mini.utils;

import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007H\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\rH\u0002J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0007J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000bH\u0007J\u001a\u0010\u0013\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0004H\u0007J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0004H\u0007J\f\u0010\u0017\u001a\u00020\u0004*\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/mini/utils/MiniAppMMKVUtils;", "", "()V", "KEY_PREFIX", "", "TAG", "getInt", "", "key", "defaultVal", "getLong", "", "getQMMKV", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "getString", "putInt", "", "value", "putLong", "putString", "removeKeyPrefix", "keyPrefix", "removeValue", "toFinalKey", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppMMKVUtils {
    public static final MiniAppMMKVUtils INSTANCE = new MiniAppMMKVUtils();
    private static final String KEY_PREFIX = "miniapp_";
    private static final String TAG = "MiniAppMMKVUtils";

    MiniAppMMKVUtils() {
    }

    @JvmStatic
    public static final int getInt(String key, int defaultVal) {
        Intrinsics.checkNotNullParameter(key, "key");
        MiniAppMMKVUtils miniAppMMKVUtils = INSTANCE;
        int decodeInt = miniAppMMKVUtils.getQMMKV().decodeInt(miniAppMMKVUtils.toFinalKey(key), defaultVal);
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 2, "getInt: key=" + key + ", value=" + decodeInt);
        }
        return decodeInt;
    }

    @JvmStatic
    public static final long getLong(String key, long defaultVal) {
        Intrinsics.checkNotNullParameter(key, "key");
        MiniAppMMKVUtils miniAppMMKVUtils = INSTANCE;
        long decodeLong = miniAppMMKVUtils.getQMMKV().decodeLong(miniAppMMKVUtils.toFinalKey(key), defaultVal);
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 2, "getLong: key=" + key + ", value=" + decodeLong);
        }
        return decodeLong;
    }

    private final MMKVOptionEntity getQMMKV() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        return from;
    }

    @JvmStatic
    public static final String getString(String key, String defaultVal) {
        Intrinsics.checkNotNullParameter(key, "key");
        MiniAppMMKVUtils miniAppMMKVUtils = INSTANCE;
        String decodeString = miniAppMMKVUtils.getQMMKV().decodeString(miniAppMMKVUtils.toFinalKey(key), defaultVal);
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 2, "getString: key=" + key + ", value=" + decodeString);
        }
        return decodeString;
    }

    @JvmStatic
    public static final void putInt(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 2, "putInt: key=" + key + ", value=" + value);
        }
        MiniAppMMKVUtils miniAppMMKVUtils = INSTANCE;
        miniAppMMKVUtils.getQMMKV().encodeInt(miniAppMMKVUtils.toFinalKey(key), value);
    }

    @JvmStatic
    public static final void putLong(String key, long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 2, "putLong: key=" + key + ", value=" + value);
        }
        MiniAppMMKVUtils miniAppMMKVUtils = INSTANCE;
        miniAppMMKVUtils.getQMMKV().encodeLong(miniAppMMKVUtils.toFinalKey(key), value);
    }

    @JvmStatic
    public static final void putString(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 2, "putString: key=" + key + ", value=" + value);
        }
        MiniAppMMKVUtils miniAppMMKVUtils = INSTANCE;
        miniAppMMKVUtils.getQMMKV().encodeString(miniAppMMKVUtils.toFinalKey(key), value);
    }

    @JvmStatic
    public static final void removeKeyPrefix(String keyPrefix) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(keyPrefix, "keyPrefix");
        String[] allKeyArr = INSTANCE.getQMMKV().allKeyArr();
        ArrayList arrayList = null;
        if (allKeyArr != null) {
            ArrayList arrayList2 = new ArrayList();
            for (String it : allKeyArr) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(it, INSTANCE.toFinalKey(keyPrefix), false, 2, null);
                if (startsWith$default) {
                    arrayList2.add(it);
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            INSTANCE.getQMMKV().removeKeyList(arrayList);
        }
    }

    @JvmStatic
    public static final void removeValue(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        MiniAppMMKVUtils miniAppMMKVUtils = INSTANCE;
        miniAppMMKVUtils.getQMMKV().removeKey(miniAppMMKVUtils.toFinalKey(key));
    }

    private final String toFinalKey(String str) {
        return KEY_PREFIX + str;
    }
}
