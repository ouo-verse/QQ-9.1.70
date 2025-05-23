package com.tencent.mobileqq.mini.utils;

import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0004J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0004J\u0016\u0010\u0015\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0007J\u0016\u0010\u0017\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\nJ\u0016\u0010\u0019\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000eJ\u0016\u0010\u001b\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/mini/utils/MiniGameMMKVUtils;", "", "()V", "BIS_KEY", "", "TAG", "getBool", "", "strKey", "getInt", "", "getKey", "key", "getLong", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getQMMkv", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "getString", "remove", "", "saveBool", "boolVal", "saveInt", "intVal", "saveLong", "longVal", "saveString", "strVal", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameMMKVUtils {
    private static final String BIS_KEY = "minigame_";
    public static final MiniGameMMKVUtils INSTANCE = new MiniGameMMKVUtils();
    private static final String TAG = "MiniGameMMKVUtils";

    MiniGameMMKVUtils() {
    }

    private final String getKey(String key) {
        return BIS_KEY + key;
    }

    private final MMKVOptionEntity getQMMkv() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        return from;
    }

    public final boolean getBool(String strKey) {
        Intrinsics.checkNotNullParameter(strKey, "strKey");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getBoolean " + strKey);
        }
        return getQMMkv().decodeBool(getKey(strKey), false);
    }

    public final int getInt(String strKey) {
        Intrinsics.checkNotNullParameter(strKey, "strKey");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getInt " + strKey);
        }
        return getQMMkv().decodeInt(getKey(strKey), 0);
    }

    public final long getLong(String strKey) {
        Intrinsics.checkNotNullParameter(strKey, "strKey");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getLong " + strKey);
        }
        return getQMMkv().decodeLong(getKey(strKey), 0L);
    }

    public final String getString(String strKey) {
        Intrinsics.checkNotNullParameter(strKey, "strKey");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getString " + strKey);
        }
        String decodeString = getQMMkv().decodeString(getKey(strKey), "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "getQMMkv().decodeString(getKey(strKey), \"\")");
        return decodeString;
    }

    public final void remove(String strKey) {
        Intrinsics.checkNotNullParameter(strKey, "strKey");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "remove " + strKey);
        }
        getQMMkv().removeKey(strKey);
    }

    public final void saveBool(String strKey, boolean boolVal) {
        Intrinsics.checkNotNullParameter(strKey, "strKey");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "saveBool " + strKey + "_" + boolVal);
        }
        getQMMkv().encodeBool(getKey(strKey), boolVal);
    }

    public final void saveInt(String strKey, int intVal) {
        Intrinsics.checkNotNullParameter(strKey, "strKey");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "saveInt " + strKey + "_" + intVal);
        }
        getQMMkv().encodeInt(getKey(strKey), intVal);
    }

    public final void saveLong(String strKey, long longVal) {
        Intrinsics.checkNotNullParameter(strKey, "strKey");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "saveLong " + strKey + "_" + longVal);
        }
        getQMMkv().encodeLong(getKey(strKey), longVal);
    }

    public final void saveString(String strKey, String strVal) {
        Intrinsics.checkNotNullParameter(strKey, "strKey");
        Intrinsics.checkNotNullParameter(strVal, "strVal");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "saveString " + strKey + "_" + strVal);
        }
        getQMMkv().encodeString(getKey(strKey), strVal);
    }

    public final long getLong(String strKey, long defaultValue) {
        Intrinsics.checkNotNullParameter(strKey, "strKey");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getLong " + strKey);
        }
        return getQMMkv().decodeLong(getKey(strKey), defaultValue);
    }
}
