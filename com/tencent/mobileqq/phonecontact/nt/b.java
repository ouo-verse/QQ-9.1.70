package com.tencent.mobileqq.phonecontact.nt;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bJ\u0016\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bJ\u0016\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0012J\u0016\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0012R#\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/phonecontact/nt/b;", "", "", "key", "", "j", "", "i", "a", "Landroid/content/SharedPreferences;", "c", "", "defValue", "d", "value", "g", "b", "f", "", "e", h.F, "", "Ljava/util/Map;", "getSMigrateCache", "()Ljava/util/Map;", "sMigrateCache", "<init>", "()V", "qq-phonecontact-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f258483a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Boolean> sMigrateCache;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24291);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f258483a = new b();
            sMigrateCache = new ConcurrentHashMap();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String a() {
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin, "sMobileQQ.peekAppRuntime().currentUin");
        return currentUin;
    }

    private final boolean i(String key) {
        Map<String, Boolean> map = sMigrateCache;
        if (map.containsKey(key)) {
            Boolean bool = map.get(key);
            Intrinsics.checkNotNull(bool);
            return bool.booleanValue();
        }
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool(key, false);
    }

    private final void j(String key) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool(key, true);
        Map<String, Boolean> map = sMigrateCache;
        if (!map.containsKey(key)) {
            MapsKt__MapsKt.plus(map, new Pair(key, Boolean.TRUE));
        }
    }

    public final long b(@NotNull String key, long defValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, this, key, Long.valueOf(defValue))).longValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        if (!i("SpTransferMMKVUtil" + key)) {
            QMMKV.migrateToSpAdapter(BaseApplication.getContext(), "contact_bind_info_global", "common_mmkv_configurations");
            j("SpTransferMMKVUtil" + key);
        }
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(BaseApplication.getContext(), "contact_bind_info_global", "common_mmkv_configurations");
        if (fromSpAdapter == null) {
            return defValue;
        }
        return fromSpAdapter.getLong(key, defValue);
    }

    @Nullable
    public final SharedPreferences c(@NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 3, (Object) this, (Object) key);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        if (!i("SpTransferMMKVUtil" + key)) {
            QMMKV.migrateToSpAdapter(BaseApplication.getContext(), AppConstants.Preferences.CONTACT_BIND_INFO + a(), "common_mmkv_configurations");
            j("SpTransferMMKVUtil" + key);
        }
        return QMMKV.fromSpAdapter(BaseApplication.getContext(), AppConstants.Preferences.CONTACT_BIND_INFO + a(), "common_mmkv_configurations");
    }

    public final long d(@NotNull String key, long defValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, this, key, Long.valueOf(defValue))).longValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        if (!i("SpTransferMMKVUtil" + key)) {
            QMMKV.migrateToSpAdapter(BaseApplication.getContext(), AppConstants.Preferences.CONTACT_BIND_INFO + a(), "common_mmkv_configurations");
            j("SpTransferMMKVUtil" + key);
        }
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(BaseApplication.getContext(), AppConstants.Preferences.CONTACT_BIND_INFO + a(), "common_mmkv_configurations");
        if (fromSpAdapter == null) {
            return defValue;
        }
        return fromSpAdapter.getLong(key, 0L);
    }

    public final int e(@NotNull String key, int defValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) key, defValue)).intValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        if (!i("SpTransferMMKVUtil" + key)) {
            QMMKV.migrateToSpAdapter(BaseApplication.getContext(), PhoneContactServiceImpl.SP_NEW_FRIEND, "common_mmkv_configurations");
            j("SpTransferMMKVUtil" + key);
        }
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(BaseApplication.getContext(), PhoneContactServiceImpl.SP_NEW_FRIEND, "common_mmkv_configurations");
        if (fromSpAdapter == null) {
            return defValue;
        }
        return fromSpAdapter.getInt(key, defValue);
    }

    public final void f(@NotNull String key, long value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, key, Long.valueOf(value));
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        if (!i("SpTransferMMKVUtil" + key)) {
            QMMKV.migrateToSpAdapter(BaseApplication.getContext(), "contact_bind_info_global", "common_mmkv_configurations");
            j("SpTransferMMKVUtil" + key);
        }
        QMMKV.fromSpAdapter(BaseApplication.getContext(), "contact_bind_info_global", "common_mmkv_configurations").edit().putLong(key, value).apply();
    }

    public final void g(@NotNull String key, long value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, key, Long.valueOf(value));
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        if (!i("SpTransferMMKVUtil" + key)) {
            QMMKV.migrateToSpAdapter(BaseApplication.getContext(), AppConstants.Preferences.CONTACT_BIND_INFO + a(), "common_mmkv_configurations");
            j("SpTransferMMKVUtil" + key);
        }
        QMMKV.fromSpAdapter(BaseApplication.getContext(), AppConstants.Preferences.CONTACT_BIND_INFO + a(), "common_mmkv_configurations").edit().putLong(key, value).apply();
    }

    public final void h(@NotNull String key, int value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) key, value);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        if (!i("SpTransferMMKVUtil" + key)) {
            QMMKV.migrateToSpAdapter(BaseApplication.getContext(), PhoneContactServiceImpl.SP_NEW_FRIEND, "common_mmkv_configurations");
            j("SpTransferMMKVUtil" + key);
        }
        QMMKV.fromSpAdapter(BaseApplication.getContext(), PhoneContactServiceImpl.SP_NEW_FRIEND, "common_mmkv_configurations").edit().putInt(key, value).apply();
    }
}
