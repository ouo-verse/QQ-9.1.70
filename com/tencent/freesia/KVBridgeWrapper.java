package com.tencent.freesia;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.ArrayList;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b!\u0018\u0000 D2\u00020\u0001:\u0001DB\u0017\u0012\u0006\u0010<\u001a\u00020\u0003\u0012\u0006\u0010>\u001a\u00020\u0001\u00a2\u0006\u0004\bB\u0010CJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0019H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010 H\u0016\u00a2\u0006\u0004\b!\u0010\"J\u001f\u0010%\u001a\u00020$2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b%\u0010&J\u001f\u0010'\u001a\u00020$2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b'\u0010(J\u001f\u0010)\u001a\u00020$2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b)\u0010*J\u001f\u0010+\u001a\u00020$2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b+\u0010,J\u001f\u0010-\u001a\u00020$2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b-\u0010.J\u001f\u0010/\u001a\u00020$2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b/\u00100J\u001f\u00101\u001a\u00020$2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0019H\u0016\u00a2\u0006\u0004\b1\u00102J'\u00103\u001a\u00020$2\u0006\u0010\u0006\u001a\u00020\u00032\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020$2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b5\u00106J\u001d\u00108\u001a\u00020$2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00030 H\u0016\u00a2\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020$H\u0016\u00a2\u0006\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\u00038\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u001e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006E"}, d2 = {"Lcom/tencent/freesia/KVBridgeWrapper;", "Lcom/tencent/freesia/KVBridge;", "Ljava/util/HashSet;", "", "getKeysNoLogin", "()Ljava/util/HashSet;", "key", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "decodeInt", "(Ljava/lang/String;I)I", "", "decodeLong", "(Ljava/lang/String;J)J", "", "decodeFloat", "(Ljava/lang/String;F)F", "", "decodeDouble", "(Ljava/lang/String;D)D", "", "decodeBool", "(Ljava/lang/String;Z)Z", "decodeString", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "decodeBytes", "(Ljava/lang/String;[B)[B", "decodeStringSet", "(Ljava/lang/String;Ljava/util/HashSet;)Ljava/util/HashSet;", "containsKey", "(Ljava/lang/String;)Z", "Ljava/util/ArrayList;", "allKeys", "()Ljava/util/ArrayList;", "value", "", "encodeInt", "(Ljava/lang/String;I)V", "encodeLong", "(Ljava/lang/String;J)V", "encodeFloat", "(Ljava/lang/String;F)V", "encodeDouble", "(Ljava/lang/String;D)V", "encodeBool", "(Ljava/lang/String;Z)V", "encodeString", "(Ljava/lang/String;Ljava/lang/String;)V", "encodeBytes", "(Ljava/lang/String;[B)V", "encodeStringSet", "(Ljava/lang/String;Ljava/util/HashSet;)V", "removeValueForKey", "(Ljava/lang/String;)V", "keys", "removeValuesForKeys", "(Ljava/util/ArrayList;)V", "clearAll", "()V", "uin", "Ljava/lang/String;", "kv", "Lcom/tencent/freesia/KVBridge;", "keysNoLogin", "Ljava/util/HashSet;", "<init>", "(Ljava/lang/String;Lcom/tencent/freesia/KVBridge;)V", "Companion", "unitedconfig-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class KVBridgeWrapper implements KVBridge {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String KEYS_NO_LOGIN = "key_all_keys_no_login";
    private HashSet<String> keysNoLogin;
    private final KVBridge kv;
    private final String uin;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/freesia/KVBridgeWrapper$Companion;", "", "", "KEYS_NO_LOGIN", "Ljava/lang/String;", "<init>", "()V", "unitedconfig-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12074);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public KVBridgeWrapper(@NotNull String uin, @NotNull KVBridge kv5) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(kv5, "kv");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) uin, (Object) kv5);
        } else {
            this.uin = uin;
            this.kv = kv5;
        }
    }

    @Override // com.tencent.freesia.KVBridge
    @Nullable
    public ArrayList<String> allKeys() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (ArrayList) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.kv.allKeys();
    }

    @Override // com.tencent.freesia.KVBridge
    public void clearAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else {
            this.kv.clearAll();
        }
    }

    @Override // com.tencent.freesia.KVBridge
    public boolean containsKey(@NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) key)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        return this.kv.containsKey(key);
    }

    @Override // com.tencent.freesia.KVBridge
    public boolean decodeBool(@NotNull String key, boolean defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, key, Boolean.valueOf(defaultValue))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        return this.kv.decodeBool(key, defaultValue);
    }

    @Override // com.tencent.freesia.KVBridge
    @Nullable
    public byte[] decodeBytes(@NotNull String key, @NotNull byte[] defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (byte[]) iPatchRedirector.redirect((short) 10, (Object) this, (Object) key, (Object) defaultValue);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return this.kv.decodeBytes(key, defaultValue);
    }

    @Override // com.tencent.freesia.KVBridge
    public double decodeDouble(@NotNull String key, double defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Double) iPatchRedirector.redirect((short) 7, this, key, Double.valueOf(defaultValue))).doubleValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        return this.kv.decodeDouble(key, defaultValue);
    }

    @Override // com.tencent.freesia.KVBridge
    public float decodeFloat(@NotNull String key, float defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, this, key, Float.valueOf(defaultValue))).floatValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        return this.kv.decodeFloat(key, defaultValue);
    }

    @Override // com.tencent.freesia.KVBridge
    public int decodeInt(@NotNull String key, int defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) key, defaultValue)).intValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        return this.kv.decodeInt(key, defaultValue);
    }

    @Override // com.tencent.freesia.KVBridge
    public long decodeLong(@NotNull String key, long defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, this, key, Long.valueOf(defaultValue))).longValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        return this.kv.decodeLong(key, defaultValue);
    }

    @Override // com.tencent.freesia.KVBridge
    @Nullable
    public String decodeString(@NotNull String key, @NotNull String defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) key, (Object) defaultValue);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return this.kv.decodeString(key, defaultValue);
    }

    @Override // com.tencent.freesia.KVBridge
    @Nullable
    public HashSet<String> decodeStringSet(@NotNull String key, @Nullable HashSet<String> defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (HashSet) iPatchRedirector.redirect((short) 11, (Object) this, (Object) key, (Object) defaultValue);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        return this.kv.decodeStringSet(key, defaultValue);
    }

    @Override // com.tencent.freesia.KVBridge
    public void encodeBool(@NotNull String key, boolean value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, key, Boolean.valueOf(value));
        } else {
            Intrinsics.checkNotNullParameter(key, "key");
            this.kv.encodeBool(key, value);
        }
    }

    @Override // com.tencent.freesia.KVBridge
    public void encodeBytes(@NotNull String key, @NotNull byte[] value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) key, (Object) value);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.kv.encodeBytes(key, value);
    }

    @Override // com.tencent.freesia.KVBridge
    public void encodeDouble(@NotNull String key, double value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, key, Double.valueOf(value));
        } else {
            Intrinsics.checkNotNullParameter(key, "key");
            this.kv.encodeDouble(key, value);
        }
    }

    @Override // com.tencent.freesia.KVBridge
    public void encodeFloat(@NotNull String key, float value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, key, Float.valueOf(value));
        } else {
            Intrinsics.checkNotNullParameter(key, "key");
            this.kv.encodeFloat(key, value);
        }
    }

    @Override // com.tencent.freesia.KVBridge
    public void encodeInt(@NotNull String key, int value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) key, value);
        } else {
            Intrinsics.checkNotNullParameter(key, "key");
            this.kv.encodeInt(key, value);
        }
    }

    @Override // com.tencent.freesia.KVBridge
    public void encodeLong(@NotNull String key, long value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, key, Long.valueOf(value));
        } else {
            Intrinsics.checkNotNullParameter(key, "key");
            this.kv.encodeLong(key, value);
        }
    }

    @Override // com.tencent.freesia.KVBridge
    public void encodeString(@NotNull String key, @NotNull String value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) key, (Object) value);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.kv.encodeString(key, value);
    }

    @Override // com.tencent.freesia.KVBridge
    public void encodeStringSet(@NotNull String key, @Nullable HashSet<String> value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) key, (Object) value);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        if (Intrinsics.areEqual(KEYS_NO_LOGIN, key)) {
            this.keysNoLogin = value;
        }
        this.kv.encodeStringSet(key, value);
    }

    @NotNull
    public final HashSet<String> getKeysNoLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HashSet) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.keysNoLogin == null) {
            this.keysNoLogin = decodeStringSet(KEYS_NO_LOGIN, new HashSet<>());
        }
        HashSet<String> hashSet = this.keysNoLogin;
        Intrinsics.checkNotNull(hashSet);
        return hashSet;
    }

    @Override // com.tencent.freesia.KVBridge
    public void removeValueForKey(@NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) key);
        } else {
            Intrinsics.checkNotNullParameter(key, "key");
            this.kv.removeValueForKey(key);
        }
    }

    @Override // com.tencent.freesia.KVBridge
    public void removeValuesForKeys(@NotNull ArrayList<String> keys) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) keys);
        } else {
            Intrinsics.checkNotNullParameter(keys, "keys");
            this.kv.removeValuesForKeys(keys);
        }
    }
}
