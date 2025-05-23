package com.tencent.mobileqq.nearbypro.avatar;

import android.os.Parcelable;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.state.square.mmkv.IMMKV;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J \u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016JG\u0010\u0018\u001a\u00028\u0000\"\b\b\u0000\u0010\u0015*\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J(\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J4\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010 \u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010!\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010\"\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010#\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010$\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010%\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J.\u0010&\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010'\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/avatar/e;", "Lcom/tencent/state/square/mmkv/IMMKV;", "", "key", "postFix", "", "ignoreFillUin", "containsKey", RemoteHandleConst.PARAM_DEFAULT_VALUE, "decodeBool", "", "decodeBytes", "", "decodeDouble", "", "decodeFloat", "", "decodeInt", "", "decodeLong", "Landroid/os/Parcelable;", "T", "Ljava/lang/Class;", "clazz", "decodeParcelable", "(Ljava/lang/String;Ljava/lang/Class;Landroid/os/Parcelable;Ljava/lang/String;Z)Landroid/os/Parcelable;", "decodeString", "", "decodeStringSet", "value", "encodeBool", "encodeBytes", "encodeDouble", "encodeFloat", "encodeInt", "encodeLong", "encodeParcelable", "encodeString", "encodeStringSet", "removeKey", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class e implements IMMKV {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f253209a = new e();

    e() {
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    public boolean containsKey(@NotNull String key, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        return j.d().containsKey(key, postFix, ignoreFillUin);
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    public boolean decodeBool(@NotNull String key, boolean defaultValue, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        return j.d().decodeBool(key, defaultValue, postFix, ignoreFillUin);
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public byte[] decodeBytes(@NotNull String key, @NotNull byte[] defaultValue, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        return j.d().decodeBytes(key, defaultValue, postFix, ignoreFillUin);
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    public double decodeDouble(@NotNull String key, double defaultValue, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        return j.d().decodeDouble(key, defaultValue, postFix, ignoreFillUin);
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    public float decodeFloat(@NotNull String key, float defaultValue, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        return j.d().decodeFloat(key, defaultValue, postFix, ignoreFillUin);
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    public int decodeInt(@NotNull String key, int defaultValue, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        return j.d().decodeInt(key, defaultValue, postFix, ignoreFillUin);
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    public long decodeLong(@NotNull String key, long defaultValue, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        return j.d().decodeLong(key, defaultValue, postFix, ignoreFillUin);
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public <T extends Parcelable> T decodeParcelable(@NotNull String key, @NotNull Class<T> clazz, @NotNull T defaultValue, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        return (T) j.d().decodeParcelable(key, clazz, defaultValue, postFix, ignoreFillUin);
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public String decodeString(@NotNull String key, @NotNull String defaultValue, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        return j.d().decodeString(key, defaultValue, postFix, ignoreFillUin);
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public Set<String> decodeStringSet(@NotNull String key, @NotNull Set<String> defaultValue, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        return j.d().decodeStringSet(key, defaultValue, postFix, ignoreFillUin);
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public IMMKV encodeBool(@NotNull String key, boolean value, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        j.d().encodeBool(key, value, postFix, ignoreFillUin);
        return this;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public IMMKV encodeBytes(@NotNull String key, @NotNull byte[] value, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        j.d().encodeBytes(key, value, postFix, ignoreFillUin);
        return this;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public IMMKV encodeDouble(@NotNull String key, double value, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        j.d().encodeDouble(key, value, postFix, ignoreFillUin);
        return this;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public IMMKV encodeFloat(@NotNull String key, float value, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        j.d().encodeFloat(key, value, postFix, ignoreFillUin);
        return this;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public IMMKV encodeInt(@NotNull String key, int value, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        j.d().encodeInt(key, value, postFix, ignoreFillUin);
        return this;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public IMMKV encodeLong(@NotNull String key, long value, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        j.d().encodeLong(key, value, postFix, ignoreFillUin);
        return this;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public IMMKV encodeParcelable(@NotNull String key, @NotNull Parcelable value, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        j.d().encodeParcelable(key, value, postFix, ignoreFillUin);
        return this;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public IMMKV encodeString(@NotNull String key, @NotNull String value, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        j.d().encodeString(key, value, postFix, ignoreFillUin);
        return this;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public IMMKV encodeStringSet(@NotNull String key, @NotNull Set<String> value, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        j.d().encodeStringSet(key, value, postFix, ignoreFillUin);
        return this;
    }

    @Override // com.tencent.state.square.mmkv.IMMKV
    @NotNull
    public IMMKV removeKey(@NotNull String key, @NotNull String postFix, boolean ignoreFillUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(postFix, "postFix");
        j.d().removeKey(key, postFix, ignoreFillUin);
        return this;
    }
}
