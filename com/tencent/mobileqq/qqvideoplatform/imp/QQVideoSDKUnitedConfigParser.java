package com.tencent.mobileqq.qqvideoplatform.imp;

import androidx.annotation.Keep;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u000b\b\u0007\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqvideoplatform/imp/QQVideoSDKUnitedConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/qqvideoplatform/imp/QQVideoSDKUnitedConfigParser$b;", "", "version", "", "onSend", "", "content", "parse", "defaultConfig", DownloadInfo.spKey_Config, "doOnConfigUpdate", "<init>", "()V", "Companion", "a", "b", "QQCommon_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQVideoSDKUnitedConfigParser extends BaseConfigParser<b> {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "QQVideoSDKUnitedConfigParser";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqvideoplatform/imp/QQVideoSDKUnitedConfigParser$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "QQCommon_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqvideoplatform.imp.QQVideoSDKUnitedConfigParser$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\nJ\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002R#\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qqvideoplatform/imp/QQVideoSDKUnitedConfigParser$b;", "Lcom/tencent/freesia/IConfigData;", "", "jsonString", "Lorg/json/JSONObject;", "f", "key", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "c", "", "b", "d", "content", "", "e", "", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "allConfig", "<init>", "()V", "QQCommon_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements IConfigData {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Map<String, String> allConfig;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqvideoplatform/imp/QQVideoSDKUnitedConfigParser$b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "QQCommon_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.qqvideoplatform.imp.QQVideoSDKUnitedConfigParser$b$a, reason: from kotlin metadata */
        /* loaded from: classes17.dex */
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
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34437);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 9)) {
                redirector.redirect((short) 9);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.allConfig = new LinkedHashMap();
            }
        }

        private final JSONObject f(String jsonString) {
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
            } catch (JSONException unused) {
                return new JSONObject();
            }
        }

        @NotNull
        public final Map<String, String> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.allConfig;
        }

        public final int b(@NotNull String key, int defaultValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) key, defaultValue)).intValue();
            }
            Intrinsics.checkNotNullParameter(key, "key");
            try {
                String str = this.allConfig.get(key);
                if (str != null) {
                    return Integer.parseInt(str);
                }
                return defaultValue;
            } catch (Exception unused) {
                QLog.e("QQVideoSDKUnitedConfigParser.Config", 1, "[getInt] key = " + key + " config = " + ((Object) this.allConfig.get(key)));
                return defaultValue;
            }
        }

        public final long c(@NotNull String key, long defaultValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, this, key, Long.valueOf(defaultValue))).longValue();
            }
            Intrinsics.checkNotNullParameter(key, "key");
            try {
                String str = this.allConfig.get(key);
                if (str != null) {
                    return Long.parseLong(str);
                }
                return defaultValue;
            } catch (Exception unused) {
                QLog.e("QQVideoSDKUnitedConfigParser.Config", 1, "[getLong] key = " + key + " config = " + ((Object) this.allConfig.get(key)));
                return defaultValue;
            }
        }

        @NotNull
        public final String d(@NotNull String key, @NotNull String defaultValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) key, (Object) defaultValue);
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
                QLog.e("QQVideoSDKUnitedConfigParser.Config", 1, "[getString] key = " + key + " config = " + ((Object) this.allConfig.get(key)));
                return defaultValue;
            }
        }

        public final void e(@NotNull String content) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) content);
                return;
            }
            Intrinsics.checkNotNullParameter(content, "content");
            JSONObject f16 = f(content);
            Iterator keys = f16.keys();
            while (keys.hasNext()) {
                Object next = keys.next();
                Object opt = f16.opt(String.valueOf(next));
                if (opt != null) {
                    this.allConfig.put(String.valueOf(next), opt.toString());
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34443);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQVideoSDKUnitedConfigParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    public void doOnConfigUpdate(@Nullable b config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) config);
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onSend(@NotNull String version) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) version);
        } else {
            Intrinsics.checkNotNullParameter(version, "version");
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    public b defaultConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? new b() : (b) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    public b parse(@NotNull byte[] content) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) content);
        }
        Intrinsics.checkNotNullParameter(content, "content");
        if (!(content.length == 0)) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            str = new String(content, UTF_8);
        } else {
            str = "";
        }
        QLog.d(TAG, 1, "parse config=" + str);
        b bVar = new b();
        if (str.length() > 0) {
            bVar.e(str);
        }
        return bVar;
    }
}
