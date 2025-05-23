package com.tencent.util;

import android.content.SharedPreferences;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import cooperation.qzone.panorama.util.PanoramaConfig;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0007J\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00132\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0007J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00152\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0007J\"\u0010\u0016\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0007J\"\u0010\u0017\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0007J\"\u0010\u001a\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00132\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0007J\"\u0010\u001b\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0007J\"\u0010\u001c\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0007J\u001a\u0010\u001d\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0007R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/util/CommonMMKVUtils;", "", "()V", PanoramaConfig.KEY_CURRENT_UIN, "", "getCurrentUin", "()Ljava/lang/String;", "entity", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "formatSpKeyWithUin", "key", "fromSpAdapter", "Landroid/content/SharedPreferences;", "oldSpName", "getBoolean", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "isAccountRelated", "getInt", "", "getLong", "", "getString", "putBoolean", "", "value", "putInt", "putLong", "putString", "removeKey", "QQCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class CommonMMKVUtils {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final CommonMMKVUtils INSTANCE;

    @NotNull
    private static final MMKVOptionEntity entity;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34689);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        INSTANCE = new CommonMMKVUtils();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        entity = from;
    }

    CommonMMKVUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String formatSpKeyWithUin(String key) {
        return getCurrentUin() + "_" + key;
    }

    @JvmStatic
    @NotNull
    public static final SharedPreferences fromSpAdapter(@NotNull String oldSpName) {
        Intrinsics.checkNotNullParameter(oldSpName, "oldSpName");
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(MobileQQ.sMobileQQ, oldSpName, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromSpAdapter, "fromSpAdapter(MobileQQ.s\u2026e, QMMKVFile.FILE_COMMON)");
        return fromSpAdapter;
    }

    @JvmStatic
    public static final boolean getBoolean(@NotNull String key, boolean defaultValue, boolean isAccountRelated) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (isAccountRelated) {
            key = INSTANCE.formatSpKeyWithUin(key);
        }
        return entity.decodeBool(key, defaultValue);
    }

    public static /* synthetic */ boolean getBoolean$default(String str, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        return getBoolean(str, z16, z17);
    }

    private final String getCurrentUin() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return peekAppRuntime.getCurrentUin();
        }
        return null;
    }

    @JvmStatic
    public static final int getInt(@NotNull String key, int defaultValue, boolean isAccountRelated) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (isAccountRelated) {
            key = INSTANCE.formatSpKeyWithUin(key);
        }
        return entity.decodeInt(key, defaultValue);
    }

    public static /* synthetic */ int getInt$default(String str, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = true;
        }
        return getInt(str, i3, z16);
    }

    @JvmStatic
    public static final long getLong(@NotNull String key, long defaultValue, boolean isAccountRelated) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (isAccountRelated) {
            key = INSTANCE.formatSpKeyWithUin(key);
        }
        return entity.decodeLong(key, defaultValue);
    }

    public static /* synthetic */ long getLong$default(String str, long j3, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = 0;
        }
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        return getLong(str, j3, z16);
    }

    @JvmStatic
    @NotNull
    public static final String getString(@NotNull String key, @NotNull String defaultValue, boolean isAccountRelated) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (isAccountRelated) {
            key = INSTANCE.formatSpKeyWithUin(key);
        }
        String decodeString = entity.decodeString(key, defaultValue);
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(finalKey, defaultValue)");
        return decodeString;
    }

    public static /* synthetic */ String getString$default(String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        return getString(str, str2, z16);
    }

    @JvmStatic
    public static final void putBoolean(@NotNull String key, boolean value, boolean isAccountRelated) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (isAccountRelated) {
            key = INSTANCE.formatSpKeyWithUin(key);
        }
        entity.encodeBool(key, value);
    }

    public static /* synthetic */ void putBoolean$default(String str, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        putBoolean(str, z16, z17);
    }

    @JvmStatic
    public static final void putInt(@NotNull String key, int value, boolean isAccountRelated) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (isAccountRelated) {
            key = INSTANCE.formatSpKeyWithUin(key);
        }
        entity.encodeInt(key, value);
    }

    public static /* synthetic */ void putInt$default(String str, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = true;
        }
        putInt(str, i3, z16);
    }

    @JvmStatic
    public static final void putLong(@NotNull String key, long value, boolean isAccountRelated) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (isAccountRelated) {
            key = INSTANCE.formatSpKeyWithUin(key);
        }
        entity.encodeLong(key, value);
    }

    public static /* synthetic */ void putLong$default(String str, long j3, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        putLong(str, j3, z16);
    }

    @JvmStatic
    public static final void putString(@NotNull String key, @NotNull String value, boolean isAccountRelated) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (isAccountRelated) {
            key = INSTANCE.formatSpKeyWithUin(key);
        }
        entity.encodeString(key, value);
    }

    public static /* synthetic */ void putString$default(String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        putString(str, str2, z16);
    }

    @JvmStatic
    public static final void removeKey(@NotNull String key, boolean isAccountRelated) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (isAccountRelated) {
            key = INSTANCE.formatSpKeyWithUin(key);
        }
        entity.removeKey(key);
    }

    public static /* synthetic */ void removeKey$default(String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        removeKey(str, z16);
    }
}
