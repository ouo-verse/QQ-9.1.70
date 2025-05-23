package com.tencent.mobileqq.vas;

import android.os.Parcelable;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bJ\u0011\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0082\bJ\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\r\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\fJ\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0014J\u0018\u0010\u0015\u001a\u00020\u00162\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0018J9\u0010\u0019\u001a\u0004\u0018\u0001H\u001a\"\b\b\u0000\u0010\u001a*\u00020\u001b2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u001d2\b\u0010\u000e\u001a\u0004\u0018\u0001H\u001a\u00a2\u0006\u0002\u0010\u001eJ\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005J,\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010!2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010!J\u0018\u0010\"\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\fJ\u001a\u0010$\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0010J\u0018\u0010&\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u0012J\u0018\u0010'\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u0014J\u0018\u0010(\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u0016J\u0018\u0010)\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u0018J\u001a\u0010*\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010#\u001a\u0004\u0018\u00010\u001bJ\u001a\u0010+\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010#\u001a\u0004\u0018\u00010\u0005J\"\u0010,\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0010\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010!J\u0013\u0010-\u001a\u0004\u0018\u00010\u00052\u0006\u0010.\u001a\u00020\u0005H\u0082\bJ\u0010\u0010/\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0014\u00100\u001a\u00020\u00032\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00050\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/vas/VasMMKVProxy;", "", "entity", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "prefix", "", "(Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;Ljava/lang/String;)V", "allKey", "", "buildRealKey", "key", "containsKey", "", "decodeBool", RemoteHandleConst.PARAM_DEFAULT_VALUE, "decodeBytes", "", "decodeDouble", "", "decodeFloat", "", "decodeInt", "", "decodeLong", "", "decodeParcelable", "T", "Landroid/os/Parcelable;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;Landroid/os/Parcelable;)Landroid/os/Parcelable;", "decodeString", "decodeStringSet", "", "encodeBool", "value", "encodeBytes", "bytes", "encodeDouble", "encodeFloat", "encodeInt", "encodeLong", "encodeParcelable", "encodeString", "encodeStringSet", "getFakeKey", "realKey", "removeKey", "removeKeyList", "keyList", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasMMKVProxy {

    @NotNull
    private final MMKVOptionEntity entity;

    @NotNull
    private final String prefix;

    public VasMMKVProxy(@NotNull MMKVOptionEntity entity, @NotNull String prefix) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        this.entity = entity;
        this.prefix = prefix;
    }

    private final String buildRealKey(String key) {
        return this.prefix + "_" + key;
    }

    private final String getFakeKey(String realKey) {
        boolean startsWith$default;
        String replace$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(realKey, this.prefix + "_", false, 2, null);
        if (!startsWith$default) {
            return null;
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(realKey, this.prefix + "_", "", false, 4, (Object) null);
        return replace$default;
    }

    @NotNull
    public final List<String> allKey() {
        List<String> emptyList;
        boolean startsWith$default;
        boolean z16;
        String[] allKeyArr = this.entity.allKeyArr();
        if (allKeyArr == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        for (String it : allKeyArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            String str = null;
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(it, this.prefix + "_", false, 2, null);
            if (startsWith$default) {
                str = StringsKt__StringsJVMKt.replace$default(it, this.prefix + "_", "", false, 4, (Object) null);
            }
            if (str != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(it);
            }
        }
        return arrayList;
    }

    public final boolean containsKey(@Nullable String key) {
        if (key == null) {
            return false;
        }
        return this.entity.containsKey(this.prefix + "_" + key);
    }

    public final boolean decodeBool(@Nullable String key, boolean defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        return this.entity.decodeBool(this.prefix + "_" + key, defaultValue);
    }

    @Nullable
    public final byte[] decodeBytes(@Nullable String key, @Nullable byte[] defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        return this.entity.decodeBytes(this.prefix + "_" + key, defaultValue);
    }

    public final double decodeDouble(@Nullable String key, double defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        return this.entity.decodeDouble(this.prefix + "_" + key, defaultValue);
    }

    public final float decodeFloat(@Nullable String key, float defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        return this.entity.decodeFloat(this.prefix + "_" + key, defaultValue);
    }

    public final int decodeInt(@Nullable String key, int defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        return this.entity.decodeInt(this.prefix + "_" + key, defaultValue);
    }

    public final long decodeLong(@Nullable String key, long defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        return this.entity.decodeLong(this.prefix + "_" + key, defaultValue);
    }

    @Nullable
    public final <T extends Parcelable> T decodeParcelable(@Nullable String key, @NotNull Class<T> clazz, @Nullable T defaultValue) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (key == null) {
            return defaultValue;
        }
        return (T) this.entity.decodeParcelable(this.prefix + "_" + key, clazz, defaultValue);
    }

    @Nullable
    public final String decodeString(@Nullable String key, @Nullable String defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        return this.entity.decodeString(this.prefix + "_" + key, defaultValue);
    }

    @Nullable
    public final Set<String> decodeStringSet(@Nullable String key, @Nullable Set<String> defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        return this.entity.decodeStringSet(this.prefix + "_" + key, defaultValue);
    }

    @NotNull
    public final MMKVOptionEntity encodeBool(@Nullable String key, boolean value) {
        if (key == null) {
            return this.entity;
        }
        MMKVOptionEntity encodeBool = this.entity.encodeBool(this.prefix + "_" + key, value);
        Intrinsics.checkNotNullExpressionValue(encodeBool, "entity.encodeBool(buildRealKey(key), value)");
        return encodeBool;
    }

    @NotNull
    public final MMKVOptionEntity encodeBytes(@Nullable String key, @Nullable byte[] bytes) {
        if (key == null) {
            return this.entity;
        }
        MMKVOptionEntity encodeBytes = this.entity.encodeBytes(this.prefix + "_" + key, bytes);
        Intrinsics.checkNotNullExpressionValue(encodeBytes, "entity.encodeBytes(buildRealKey(key), bytes)");
        return encodeBytes;
    }

    @NotNull
    public final MMKVOptionEntity encodeDouble(@Nullable String key, double value) {
        if (key == null) {
            return this.entity;
        }
        MMKVOptionEntity encodeDouble = this.entity.encodeDouble(this.prefix + "_" + key, value);
        Intrinsics.checkNotNullExpressionValue(encodeDouble, "entity.encodeDouble(buildRealKey(key), value)");
        return encodeDouble;
    }

    @NotNull
    public final MMKVOptionEntity encodeFloat(@Nullable String key, float value) {
        if (key == null) {
            return this.entity;
        }
        MMKVOptionEntity encodeFloat = this.entity.encodeFloat(this.prefix + "_" + key, value);
        Intrinsics.checkNotNullExpressionValue(encodeFloat, "entity.encodeFloat(buildRealKey(key), value)");
        return encodeFloat;
    }

    @NotNull
    public final MMKVOptionEntity encodeInt(@Nullable String key, int value) {
        if (key == null) {
            return this.entity;
        }
        MMKVOptionEntity encodeInt = this.entity.encodeInt(this.prefix + "_" + key, value);
        Intrinsics.checkNotNullExpressionValue(encodeInt, "entity.encodeInt(buildRealKey(key), value)");
        return encodeInt;
    }

    @NotNull
    public final MMKVOptionEntity encodeLong(@Nullable String key, long value) {
        if (key == null) {
            return this.entity;
        }
        MMKVOptionEntity encodeLong = this.entity.encodeLong(this.prefix + "_" + key, value);
        Intrinsics.checkNotNullExpressionValue(encodeLong, "entity.encodeLong(buildRealKey(key), value)");
        return encodeLong;
    }

    @NotNull
    public final MMKVOptionEntity encodeParcelable(@Nullable String key, @Nullable Parcelable value) {
        if (key == null) {
            return this.entity;
        }
        MMKVOptionEntity encodeParcelable = this.entity.encodeParcelable(this.prefix + "_" + key, value);
        Intrinsics.checkNotNullExpressionValue(encodeParcelable, "entity.encodeParcelable(buildRealKey(key), value)");
        return encodeParcelable;
    }

    @NotNull
    public final MMKVOptionEntity encodeString(@Nullable String key, @Nullable String value) {
        if (key == null) {
            return this.entity;
        }
        MMKVOptionEntity encodeString = this.entity.encodeString(this.prefix + "_" + key, value);
        Intrinsics.checkNotNullExpressionValue(encodeString, "entity.encodeString(buildRealKey(key), value)");
        return encodeString;
    }

    @NotNull
    public final MMKVOptionEntity encodeStringSet(@Nullable String key, @Nullable Set<String> value) {
        if (key == null) {
            return this.entity;
        }
        MMKVOptionEntity encodeStringSet = this.entity.encodeStringSet(this.prefix + "_" + key, value);
        Intrinsics.checkNotNullExpressionValue(encodeStringSet, "entity.encodeStringSet(buildRealKey(key), value)");
        return encodeStringSet;
    }

    @NotNull
    public final MMKVOptionEntity removeKey(@Nullable String key) {
        if (key == null) {
            return this.entity;
        }
        MMKVOptionEntity removeKey = this.entity.removeKey(this.prefix + "_" + key);
        Intrinsics.checkNotNullExpressionValue(removeKey, "entity.removeKey(buildRealKey(key))");
        return removeKey;
    }

    @NotNull
    public final MMKVOptionEntity removeKeyList(@NotNull List<String> keyList) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(keyList, "keyList");
        if (keyList.isEmpty()) {
            return this.entity;
        }
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        List<String> list = keyList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (String str : list) {
            arrayList.add(this.prefix + "_" + str);
        }
        MMKVOptionEntity removeKeyList = mMKVOptionEntity.removeKeyList(arrayList);
        Intrinsics.checkNotNullExpressionValue(removeKeyList, "entity.removeKeyList(key\u2026map { buildRealKey(it) })");
        return removeKeyList;
    }
}
