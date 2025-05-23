package com.tencent.state.square.mmkv;

import android.content.Context;
import android.os.Parcelable;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.state.square.SquareBaseKt;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0010\u0018\u0000 72\u00020\u0001:\u00017B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nJ\u0006\u0010\u000b\u001a\u00020\u0000J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J(\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J(\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J(\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J(\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J(\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016JE\u0010 \u001a\u0002H!\"\b\b\u0000\u0010!*\u00020\"2\u0006\u0010\u0011\u001a\u00020\t2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$2\u0006\u0010\u0015\u001a\u0002H!2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016\u00a2\u0006\u0002\u0010%J(\u0010&\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J4\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0(2\u0006\u0010\u0011\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0(2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J(\u0010)\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J(\u0010+\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J(\u0010,\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J(\u0010-\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J(\u0010.\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J(\u0010/\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J(\u00100\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010*\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J(\u00101\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J.\u00102\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\t2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0(2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0006\u00103\u001a\u00020\u0010J\u0006\u00104\u001a\u00020\tJ \u00105\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J$\u00106\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u0010H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"Lcom/tencent/state/square/mmkv/SMMKV;", "Lcom/tencent/state/square/mmkv/IMMKV;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "entity", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "allKeyArr", "", "", "()[Ljava/lang/String;", "clearAll", "commitAsync", "", "commitSync", "containsKey", "", "key", "postFix", "ignoreFillUin", "decodeBool", RemoteHandleConst.PARAM_DEFAULT_VALUE, "decodeBytes", "", "decodeDouble", "", "decodeFloat", "", "decodeInt", "", "decodeLong", "", "decodeParcelable", "T", "Landroid/os/Parcelable;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;Landroid/os/Parcelable;Ljava/lang/String;Z)Landroid/os/Parcelable;", "decodeString", "decodeStringSet", "", "encodeBool", "value", "encodeBytes", "encodeDouble", "encodeFloat", "encodeInt", "encodeLong", "encodeParcelable", "encodeString", "encodeStringSet", "isAccessible", "mmapId", "removeKey", "targetKey", "Companion", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class SMMKV implements IMMKV {
    private static final String FILE_DOV = "dov_mmkv_configurations";
    private final MMKVOptionEntity entity;

    public SMMKV(@Nullable Context context) {
        MMKVOptionEntity mMKVOptionEntity;
        if (context != null) {
            mMKVOptionEntity = QMMKV.from(context, "dov_mmkv_configurations");
        } else {
            mMKVOptionEntity = null;
        }
        this.entity = mMKVOptionEntity;
    }

    private final String targetKey(String key, String postFix, boolean ignoreFillUin) {
        StringBuilder sb5;
        if (ignoreFillUin) {
            sb5 = new StringBuilder();
            sb5.append(key);
            sb5.append("__");
        } else {
            sb5 = new StringBuilder();
            sb5.append(key);
            sb5.append(util.base64_pad_url);
            sb5.append(SquareBaseKt.getSquareCommon().getCurrentAccountUin());
            sb5.append(util.base64_pad_url);
        }
        sb5.append(postFix);
        return sb5.toString();
    }

    static /* synthetic */ String targetKey$default(SMMKV smmkv, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        return smmkv.targetKey(str, str2, z16);
    }

    @NotNull
    public final String[] allKeyArr() {
        String[] allKeyArr;
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity == null || (allKeyArr = mMKVOptionEntity.allKeyArr()) == null) {
            return new String[0];
        }
        return allKeyArr;
    }

    @NotNull
    public final SMMKV clearAll() {
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            mMKVOptionEntity.clearAll();
        }
        return this;
    }

    public final void commitAsync() {
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            mMKVOptionEntity.commitAsync();
        }
    }

    public final void commitSync() {
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            mMKVOptionEntity.commitSync();
        }
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    public boolean containsKey(@NotNull String key, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            return mMKVOptionEntity.containsKey(targetKey(key, postFix, ignoreFillUin));
        }
        return false;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    public boolean decodeBool(@NotNull String key, boolean defaultValue, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            return mMKVOptionEntity.decodeBool(targetKey(key, postFix, ignoreFillUin), defaultValue);
        }
        return defaultValue;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public byte[] decodeBytes(@NotNull String key, @NotNull byte[] defaultValue, @NotNull String postFix, boolean ignoreFillUin) {
        byte[] decodeBytes;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null && (decodeBytes = mMKVOptionEntity.decodeBytes(targetKey(key, postFix, ignoreFillUin), defaultValue)) != null) {
            return decodeBytes;
        }
        return defaultValue;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    public double decodeDouble(@NotNull String key, double defaultValue, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            return mMKVOptionEntity.decodeDouble(targetKey(key, postFix, ignoreFillUin), defaultValue);
        }
        return defaultValue;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    public float decodeFloat(@NotNull String key, float defaultValue, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            return mMKVOptionEntity.decodeFloat(targetKey(key, postFix, ignoreFillUin), defaultValue);
        }
        return defaultValue;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    public int decodeInt(@NotNull String key, int defaultValue, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            return mMKVOptionEntity.decodeInt(targetKey(key, postFix, ignoreFillUin), defaultValue);
        }
        return defaultValue;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    public long decodeLong(@NotNull String key, long defaultValue, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            return mMKVOptionEntity.decodeLong(targetKey(key, postFix, ignoreFillUin), defaultValue);
        }
        return defaultValue;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public <T extends Parcelable> T decodeParcelable(@NotNull String key, @NotNull Class<T> clazz, @NotNull T defaultValue, @NotNull String postFix, boolean ignoreFillUin) {
        T t16;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null && (t16 = (T) mMKVOptionEntity.decodeParcelable(targetKey(key, postFix, ignoreFillUin), clazz, defaultValue)) != null) {
            return t16;
        }
        return defaultValue;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public String decodeString(@NotNull String key, @NotNull String defaultValue, @NotNull String postFix, boolean ignoreFillUin) {
        String decodeString;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null && (decodeString = mMKVOptionEntity.decodeString(targetKey(key, postFix, ignoreFillUin), defaultValue)) != null) {
            return decodeString;
        }
        return defaultValue;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public Set<String> decodeStringSet(@NotNull String key, @NotNull Set<String> defaultValue, @NotNull String postFix, boolean ignoreFillUin) {
        Set<String> decodeStringSet;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null && (decodeStringSet = mMKVOptionEntity.decodeStringSet(targetKey(key, postFix, ignoreFillUin), defaultValue)) != null) {
            return decodeStringSet;
        }
        return defaultValue;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    public /* bridge */ /* synthetic */ IMMKV encodeStringSet(String str, Set set, String str2, boolean z16) {
        return encodeStringSet(str, (Set<String>) set, str2, z16);
    }

    public final boolean isAccessible() {
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            return mMKVOptionEntity.isAccessible();
        }
        return false;
    }

    @NotNull
    public final String mmapId() {
        String mmapId;
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity == null || (mmapId = mMKVOptionEntity.mmapId()) == null) {
            return "";
        }
        return mmapId;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public SMMKV encodeBool(@NotNull String key, boolean value, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            mMKVOptionEntity.encodeBool(targetKey(key, postFix, ignoreFillUin), value);
        }
        return this;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public SMMKV encodeBytes(@NotNull String key, @NotNull byte[] value, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            mMKVOptionEntity.encodeBytes(targetKey(key, postFix, ignoreFillUin), value);
        }
        return this;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public SMMKV encodeDouble(@NotNull String key, double value, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            mMKVOptionEntity.encodeDouble(targetKey(key, postFix, ignoreFillUin), value);
        }
        return this;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public SMMKV encodeFloat(@NotNull String key, float value, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            mMKVOptionEntity.encodeFloat(targetKey(key, postFix, ignoreFillUin), value);
        }
        return this;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public SMMKV encodeInt(@NotNull String key, int value, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            mMKVOptionEntity.encodeInt(targetKey(key, postFix, ignoreFillUin), value);
        }
        return this;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public SMMKV encodeLong(@NotNull String key, long value, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            mMKVOptionEntity.encodeLong(targetKey(key, postFix, ignoreFillUin), value);
        }
        return this;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public SMMKV encodeParcelable(@NotNull String key, @NotNull Parcelable value, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            mMKVOptionEntity.encodeParcelable(targetKey(key, postFix, ignoreFillUin), value);
        }
        return this;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public SMMKV encodeString(@NotNull String key, @NotNull String value, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            mMKVOptionEntity.encodeString(targetKey(key, postFix, ignoreFillUin), value);
        }
        return this;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public SMMKV encodeStringSet(@NotNull String key, @NotNull Set<String> value, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            mMKVOptionEntity.encodeStringSet(targetKey(key, postFix, ignoreFillUin), value);
        }
        return this;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public SMMKV removeKey(@NotNull String key, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            mMKVOptionEntity.removeKey(targetKey(key, postFix, ignoreFillUin));
        }
        return this;
    }
}
