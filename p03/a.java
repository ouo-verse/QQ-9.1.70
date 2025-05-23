package p03;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcelable;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\r\u0018\u0000 \u000e2\u00020\u0001:\u0001\u001cB\u0019\b\u0002\u0012\u0006\u0010!\u001a\u00020\b\u0012\u0006\u0010%\u001a\u00020\u0002\u00a2\u0006\u0004\b&\u0010'J\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\nJ\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\nJ\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\rJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\rJ\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002J9\u0010\u0016\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0013*\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002J\u0015\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010!\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010%\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lp03/a;", "", "", "key", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "d", "value", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "i", "", "e", "j", "", "c", h.F, "g", "l", "Landroid/os/Parcelable;", "T", "Ljava/lang/Class;", "clazz", "f", "(Ljava/lang/String;Ljava/lang/Class;Landroid/os/Parcelable;)Landroid/os/Parcelable;", "k", "r", "b", "", "a", "()[Ljava/lang/String;", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "getEntity", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "Ljava/lang/String;", DomainData.DOMAIN_NAME, "()Ljava/lang/String;", "keyPrefix", "<init>", "(Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;Ljava/lang/String;)V", "qqvas-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MMKVOptionEntity entity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String keyPrefix;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001c\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J\b\u0010\u000e\u001a\u00020\u0005H\u0007J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0002H\u0007R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lp03/a$a;", "", "", "id", "uin", "Lp03/a;", "b", "Landroid/content/Context;", "context", "originSpName", "Landroid/content/SharedPreferences;", "f", "a", "g", "d", "originName", "e", "BRIDGE_FLAG", "Ljava/lang/String;", "MMKV_ID_GAMENCENTER_COMMON", "MMKV_ID_GAME_PUBLICACCOUNT", "MMKV_ID_QQ_RESHUB", "MMKV_ID_QQ_SO_CONFIG", "MMKV_ID_WADL_DOWNLOADER", "MMKV_ID_WADL_DOWNLOADER_STEP_REPORT", "TAG", "<init>", "()V", "qqvas-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: p03.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final a b(String id5, String uin) {
            boolean z16;
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            if (uin != null && uin.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                id5 = id5 + "_" + uin;
            }
            return new a(from, id5, null);
        }

        static /* synthetic */ a c(Companion companion, String str, String str2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                str2 = "";
            }
            return companion.b(str, str2);
        }

        private final SharedPreferences f(Context context, String originSpName) {
            SharedPreferences newSp = QMMKV.fromSpAdapter(MobileQQ.sMobileQQ, originSpName, "common_mmkv_configurations");
            if (!newSp.getBoolean("gamecenter_bridge_flag", false)) {
                QLog.i("GameCenterMMKV", 1, "isMigrateToSpAdapterSuccess: " + QMMKV.migrateToSpAdapter(context, originSpName, 4, "vas_mmkv_configurations"));
                newSp.edit().putBoolean("gamecenter_bridge_flag", true).apply();
            }
            Intrinsics.checkNotNullExpressionValue(newSp, "newSp");
            return newSp;
        }

        @JvmStatic
        @NotNull
        public final a a(@Nullable String uin) {
            return b("gamecenter_common", uin);
        }

        @JvmStatic
        @NotNull
        public final a d() {
            return c(this, "qq_so_config", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final SharedPreferences e(@NotNull Context context, @NotNull String originName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(originName, "originName");
            return f(context, originName);
        }

        @JvmStatic
        @NotNull
        public final a g(@Nullable String uin) {
            return b("wadl_downloader", uin);
        }

        Companion() {
        }
    }

    public /* synthetic */ a(MMKVOptionEntity mMKVOptionEntity, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(mMKVOptionEntity, str);
    }

    @JvmStatic
    @NotNull
    public static final a m(@Nullable String str) {
        return INSTANCE.a(str);
    }

    @JvmStatic
    @NotNull
    public static final a o() {
        return INSTANCE.d();
    }

    @JvmStatic
    @NotNull
    public static final SharedPreferences p(@NotNull Context context, @NotNull String str) {
        return INSTANCE.e(context, str);
    }

    @JvmStatic
    @NotNull
    public static final a q(@Nullable String str) {
        return INSTANCE.g(str);
    }

    @Nullable
    public final String[] a() {
        return this.entity.allKeyArr();
    }

    public final boolean b(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.entity.containsKey(this.keyPrefix + "_" + key);
    }

    public final boolean c(@NotNull String key, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.entity.decodeBool(this.keyPrefix + "_" + key, defaultValue);
    }

    public final int d(@NotNull String key, int defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.entity.decodeInt(this.keyPrefix + "_" + key, defaultValue);
    }

    public final long e(@NotNull String key, long defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.entity.decodeLong(this.keyPrefix + "_" + key, defaultValue);
    }

    @Nullable
    public final <T extends Parcelable> T f(@NotNull String key, @NotNull Class<T> clazz, @Nullable T defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) this.entity.decodeParcelable(this.keyPrefix + "_" + key, clazz, defaultValue);
    }

    @Nullable
    public final String g(@NotNull String key, @Nullable String defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.entity.decodeString(this.keyPrefix + "_" + key, defaultValue);
    }

    @NotNull
    public final MMKVOptionEntity h(@NotNull String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKVOptionEntity encodeBool = this.entity.encodeBool(this.keyPrefix + "_" + key, value);
        Intrinsics.checkNotNullExpressionValue(encodeBool, "entity.encodeBool(buildRealKey(key), value)");
        return encodeBool;
    }

    @NotNull
    public final MMKVOptionEntity i(@NotNull String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKVOptionEntity encodeInt = this.entity.encodeInt(this.keyPrefix + "_" + key, value);
        Intrinsics.checkNotNullExpressionValue(encodeInt, "entity.encodeInt(buildRealKey(key), value)");
        return encodeInt;
    }

    @NotNull
    public final MMKVOptionEntity j(@NotNull String key, long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKVOptionEntity encodeLong = this.entity.encodeLong(this.keyPrefix + "_" + key, value);
        Intrinsics.checkNotNullExpressionValue(encodeLong, "entity.encodeLong(buildRealKey(key), value)");
        return encodeLong;
    }

    @NotNull
    public final MMKVOptionEntity k(@NotNull String key, @Nullable Parcelable value) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKVOptionEntity encodeParcelable = this.entity.encodeParcelable(this.keyPrefix + "_" + key, value);
        Intrinsics.checkNotNullExpressionValue(encodeParcelable, "entity.encodeParcelable(buildRealKey(key), value)");
        return encodeParcelable;
    }

    @NotNull
    public final MMKVOptionEntity l(@NotNull String key, @Nullable String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKVOptionEntity encodeString = this.entity.encodeString(this.keyPrefix + "_" + key, value);
        Intrinsics.checkNotNullExpressionValue(encodeString, "entity.encodeString(buildRealKey(key), value)");
        return encodeString;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final String getKeyPrefix() {
        return this.keyPrefix;
    }

    @NotNull
    public final MMKVOptionEntity r(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKVOptionEntity removeKey = this.entity.removeKey(this.keyPrefix + "_" + key);
        Intrinsics.checkNotNullExpressionValue(removeKey, "entity.removeKey(buildRealKey(key))");
        return removeKey;
    }

    a(MMKVOptionEntity mMKVOptionEntity, String str) {
        this.entity = mMKVOptionEntity;
        this.keyPrefix = str;
    }
}
