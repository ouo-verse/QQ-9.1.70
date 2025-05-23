package com.tencent.mobileqq.aio.config;

import androidx.annotation.Keep;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\t\b\u0017\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J#\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00028\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000bJ\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\rJ\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000fJ\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0011J\u0016\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0002R#\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/aio/config/AIOUnitedConfig;", "Lcom/tencent/freesia/IConfigData;", "", "jsonString", "Lorg/json/JSONObject;", "toSafeJson", "T", "key", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getConfig", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "", "getLong", "", "getFloat", "", "getInt", "", "getBoolean", "getString", "content", "", "parse", "", "allConfig", "Ljava/util/Map;", "getAllConfig", "()Ljava/util/Map;", "<init>", "()V", "Companion", "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public class AIOUnitedConfig implements IConfigData {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "AIOUnitedConfig";

    @NotNull
    private final Map<String, String> allConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/config/AIOUnitedConfig$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.config.AIOUnitedConfig$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32894);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOUnitedConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.allConfig = new LinkedHashMap();
        }
    }

    private final JSONObject toSafeJson(String jsonString) {
        boolean z16;
        if (jsonString != null && jsonString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return new JSONObject();
        }
        try {
            return new JSONObject(jsonString);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "toSafeJson JSONException: " + e16);
            return new JSONObject();
        }
    }

    @NotNull
    public final Map<String, String> getAllConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.allConfig;
    }

    public final boolean getBoolean(@NotNull String key, boolean defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, key, Boolean.valueOf(defaultValue))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            String str = this.allConfig.get(key);
            if (str != null) {
                return Boolean.parseBoolean(str);
            }
            return defaultValue;
        } catch (Exception unused) {
            QLog.e(TAG, 1, "[getBoolean] key = " + key + " config = " + ((Object) this.allConfig.get(key)));
            return defaultValue;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T getConfig(@NotNull String key, T defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this, (Object) key, (Object) defaultValue);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        if (defaultValue instanceof Long) {
            return (T) Long.valueOf(getLong(key, ((Number) defaultValue).longValue()));
        }
        if (defaultValue instanceof Float) {
            return (T) Float.valueOf(getFloat(key, ((Number) defaultValue).floatValue()));
        }
        if (defaultValue instanceof Integer) {
            return (T) Integer.valueOf(getInt(key, ((Number) defaultValue).intValue()));
        }
        if (defaultValue instanceof Boolean) {
            return (T) Boolean.valueOf(getBoolean(key, ((Boolean) defaultValue).booleanValue()));
        }
        if (defaultValue instanceof String) {
            return (T) getString(key, (String) defaultValue);
        }
        return defaultValue;
    }

    public final float getFloat(@NotNull String key, float defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, this, key, Float.valueOf(defaultValue))).floatValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            String str = this.allConfig.get(key);
            if (str != null) {
                return Float.parseFloat(str);
            }
            return defaultValue;
        } catch (Exception unused) {
            QLog.e(TAG, 1, "[getFloat] key = " + key + " config = " + ((Object) this.allConfig.get(key)));
            return defaultValue;
        }
    }

    public final int getInt(@NotNull String key, int defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) key, defaultValue)).intValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            String str = this.allConfig.get(key);
            if (str != null) {
                return Integer.parseInt(str);
            }
            return defaultValue;
        } catch (Exception unused) {
            QLog.e(TAG, 1, "[getInt] key = " + key + " config = " + ((Object) this.allConfig.get(key)));
            return defaultValue;
        }
    }

    public final long getLong(@NotNull String key, long defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, this, key, Long.valueOf(defaultValue))).longValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            String str = this.allConfig.get(key);
            if (str != null) {
                return Long.parseLong(str);
            }
            return defaultValue;
        } catch (Exception unused) {
            QLog.e(TAG, 1, "[getLong] key = " + key + " config = " + ((Object) this.allConfig.get(key)));
            return defaultValue;
        }
    }

    @NotNull
    public final String getString(@NotNull String key, @NotNull String defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) key, (Object) defaultValue);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        try {
            String str = this.allConfig.get(key);
            if (str != null) {
                return str;
            }
            return defaultValue;
        } catch (Exception unused) {
            QLog.e(TAG, 1, "[getString] key = " + key + " config = " + ((Object) this.allConfig.get(key)));
            return defaultValue;
        }
    }

    public final void parse(@NotNull String content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) content);
            return;
        }
        Intrinsics.checkNotNullParameter(content, "content");
        JSONObject safeJson = toSafeJson(content);
        Iterator keys = safeJson.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object opt = safeJson.opt(str.toString());
            if (opt != null) {
                this.allConfig.put(str, opt.toString());
            }
        }
    }
}
