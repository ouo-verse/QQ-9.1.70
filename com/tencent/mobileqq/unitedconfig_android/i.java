package com.tencent.mobileqq.unitedconfig_android;

import com.tencent.freesia.KVBridge;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010'\u001a\u00020\u0002\u00a2\u0006\u0004\b,\u0010-J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\rH\u0016J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0010H\u0016J(\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015H\u0016J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\u0018\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\tH\u0016J\u0018\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\rH\u0016J\u0018\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0018\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J \u0010 \u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012H\u0016J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010#\u001a\u00020\u00182\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0016J\b\u0010$\u001a\u00020\u0018H\u0016R\u0014\u0010'\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/unitedconfig_android/i;", "Lcom/tencent/freesia/KVBridge;", "", "key", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "decodeInt", "", "decodeLong", "", "decodeFloat", "", "decodeDouble", "", "decodeBool", "decodeString", "", "decodeBytes", "Ljava/util/HashSet;", "decodeStringSet", "containsKey", "Ljava/util/ArrayList;", "allKeys", "value", "", "encodeInt", "encodeLong", "encodeFloat", "encodeDouble", "encodeBool", "encodeString", "encodeBytes", "encodeStringSet", "removeValueForKey", "keys", "removeValuesForKeys", "clearAll", "a", "Ljava/lang/String;", "uin", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "b", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mmkvEntity", "<init>", "(Ljava/lang/String;)V", "UnitedConfig-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class i implements KVBridge {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MMKVOptionEntity mmkvEntity;

    public i(@NotNull String uin) {
        String str;
        Intrinsics.checkNotNullParameter(uin, "uin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) uin);
            return;
        }
        this.uin = uin;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (!(uin.length() == 0) && !Intrinsics.areEqual("-1", uin)) {
            str = "united_config_mmkv_" + uin;
        } else {
            str = QMMKVFile.FILE_UNITED_CONFIG;
        }
        MMKVOptionEntity from = QMMKV.from(mobileQQ, str);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ,\u2026NITED_CONFIG + \"_\" + uin)");
        this.mmkvEntity = from;
    }

    @Override // com.tencent.freesia.KVBridge
    @Nullable
    public ArrayList<String> allKeys() {
        Collection collection;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ArrayList) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        String[] allKeyArr = this.mmkvEntity.allKeyArr();
        if (allKeyArr != null) {
            collection = ArraysKt___ArraysKt.toCollection(allKeyArr, new ArrayList());
            return (ArrayList) collection;
        }
        return null;
    }

    @Override // com.tencent.freesia.KVBridge
    public void clearAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            this.mmkvEntity.clearAll();
        }
    }

    @Override // com.tencent.freesia.KVBridge
    public boolean containsKey(@NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) key)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mmkvEntity.containsKey(key);
    }

    @Override // com.tencent.freesia.KVBridge
    public boolean decodeBool(@NotNull String key, boolean defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, key, Boolean.valueOf(defaultValue))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mmkvEntity.decodeBool(key, defaultValue);
    }

    @Override // com.tencent.freesia.KVBridge
    @Nullable
    public byte[] decodeBytes(@NotNull String key, @NotNull byte[] defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (byte[]) iPatchRedirector.redirect((short) 8, (Object) this, (Object) key, (Object) defaultValue);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return this.mmkvEntity.decodeBytes(key, defaultValue);
    }

    @Override // com.tencent.freesia.KVBridge
    public double decodeDouble(@NotNull String key, double defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Double) iPatchRedirector.redirect((short) 5, this, key, Double.valueOf(defaultValue))).doubleValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mmkvEntity.decodeDouble(key, defaultValue);
    }

    @Override // com.tencent.freesia.KVBridge
    public float decodeFloat(@NotNull String key, float defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, this, key, Float.valueOf(defaultValue))).floatValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mmkvEntity.decodeFloat(key, defaultValue);
    }

    @Override // com.tencent.freesia.KVBridge
    public int decodeInt(@NotNull String key, int defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) key, defaultValue)).intValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mmkvEntity.decodeInt(key, defaultValue);
    }

    @Override // com.tencent.freesia.KVBridge
    public long decodeLong(@NotNull String key, long defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, this, key, Long.valueOf(defaultValue))).longValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mmkvEntity.decodeLong(key, defaultValue);
    }

    @Override // com.tencent.freesia.KVBridge
    @Nullable
    public String decodeString(@NotNull String key, @NotNull String defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) key, (Object) defaultValue);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return this.mmkvEntity.decodeString(key, defaultValue);
    }

    @Override // com.tencent.freesia.KVBridge
    @Nullable
    public HashSet<String> decodeStringSet(@NotNull String key, @Nullable HashSet<String> defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (HashSet) iPatchRedirector.redirect((short) 9, (Object) this, (Object) key, (Object) defaultValue);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Set<String> decodeStringSet = this.mmkvEntity.decodeStringSet(key, defaultValue);
        if (decodeStringSet == null) {
            return null;
        }
        return new HashSet<>(decodeStringSet);
    }

    @Override // com.tencent.freesia.KVBridge
    public void encodeBool(@NotNull String key, boolean value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, key, Boolean.valueOf(value));
        } else {
            Intrinsics.checkNotNullParameter(key, "key");
            this.mmkvEntity.encodeBool(key, value);
        }
    }

    @Override // com.tencent.freesia.KVBridge
    public void encodeBytes(@NotNull String key, @NotNull byte[] value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) key, (Object) value);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.mmkvEntity.encodeBytes(key, value);
    }

    @Override // com.tencent.freesia.KVBridge
    public void encodeDouble(@NotNull String key, double value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, key, Double.valueOf(value));
        } else {
            Intrinsics.checkNotNullParameter(key, "key");
            this.mmkvEntity.encodeDouble(key, value);
        }
    }

    @Override // com.tencent.freesia.KVBridge
    public void encodeFloat(@NotNull String key, float value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, key, Float.valueOf(value));
        } else {
            Intrinsics.checkNotNullParameter(key, "key");
            this.mmkvEntity.encodeFloat(key, value);
        }
    }

    @Override // com.tencent.freesia.KVBridge
    public void encodeInt(@NotNull String key, int value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) key, value);
        } else {
            Intrinsics.checkNotNullParameter(key, "key");
            this.mmkvEntity.encodeInt(key, value);
        }
    }

    @Override // com.tencent.freesia.KVBridge
    public void encodeLong(@NotNull String key, long value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, key, Long.valueOf(value));
        } else {
            Intrinsics.checkNotNullParameter(key, "key");
            this.mmkvEntity.encodeLong(key, value);
        }
    }

    @Override // com.tencent.freesia.KVBridge
    public void encodeString(@NotNull String key, @NotNull String value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) key, (Object) value);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.mmkvEntity.encodeString(key, value);
    }

    @Override // com.tencent.freesia.KVBridge
    public void encodeStringSet(@NotNull String key, @Nullable HashSet<String> value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) key, (Object) value);
        } else {
            Intrinsics.checkNotNullParameter(key, "key");
            this.mmkvEntity.encodeStringSet(key, value);
        }
    }

    @Override // com.tencent.freesia.KVBridge
    public void removeValueForKey(@NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) key);
        } else {
            Intrinsics.checkNotNullParameter(key, "key");
            this.mmkvEntity.removeKey(key);
        }
    }

    @Override // com.tencent.freesia.KVBridge
    public void removeValuesForKeys(@NotNull ArrayList<String> keys) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) keys);
        } else {
            Intrinsics.checkNotNullParameter(keys, "keys");
            this.mmkvEntity.removeKeyList(keys);
        }
    }
}
