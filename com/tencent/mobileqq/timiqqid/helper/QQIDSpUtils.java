package com.tencent.mobileqq.timiqqid.helper;

import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\bH\u0007J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\u0010\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\bH\u0007J\u001a\u0010\u0010\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\fH\u0007J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0007R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/timiqqid/helper/QQIDSpUtils;", "", "()V", "IS_ALPHA_USER", "", "SCENE_RECOGNITION_ENABLE_STATUS", "SCENE_RECOGNITION_OPEN_ID", "getBoolean", "", "key", "defValue", "getInt", "", "getMMKVOptionEntity", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "getString", "save", "", "value", "status", "timi-qqid-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class QQIDSpUtils {

    @NotNull
    public static final QQIDSpUtils INSTANCE = new QQIDSpUtils();

    @JvmField
    @NotNull
    public static String SCENE_RECOGNITION_ENABLE_STATUS = "timi_qqid_scene_recognition_enable_status";

    @JvmField
    @NotNull
    public static String SCENE_RECOGNITION_OPEN_ID = "timi_qqid_scene_recognition_open_id";

    @JvmField
    @NotNull
    public static String IS_ALPHA_USER = "timi_qqid_is_alpha_user";

    QQIDSpUtils() {
    }

    @JvmStatic
    public static final boolean getBoolean(@Nullable String key, boolean defValue) {
        return getMMKVOptionEntity().decodeBool(key, defValue);
    }

    @JvmStatic
    public static final int getInt(@Nullable String key, int defValue) {
        return getMMKVOptionEntity().decodeInt(key, defValue);
    }

    @JvmStatic
    @NotNull
    public static final MMKVOptionEntity getMMKVOptionEntity() {
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.getContext(), QMMKVFile.FILE_COMMON)");
        return from;
    }

    @JvmStatic
    @Nullable
    public static final String getString(@Nullable String key, @Nullable String defValue) {
        return getMMKVOptionEntity().decodeString(key, defValue);
    }

    @JvmStatic
    public static final void save(@Nullable String key, int status) {
        getMMKVOptionEntity().encodeInt(key, status).commitSync();
    }

    @JvmStatic
    public static final void save(@Nullable String key, boolean value) {
        getMMKVOptionEntity().encodeBool(key, value).commitSync();
    }

    @JvmStatic
    public static final void save(@Nullable String key, @Nullable String value) {
        getMMKVOptionEntity().encodeString(key, value).commitSync();
    }
}
