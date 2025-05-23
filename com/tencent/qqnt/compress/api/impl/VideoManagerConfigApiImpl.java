package com.tencent.qqnt.compress.api.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.compress.api.IVideoManagerConfigApi;
import com.tencent.qqnt.compress.video.config.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import zq2.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/compress/api/impl/VideoManagerConfigApiImpl;", "Lcom/tencent/qqnt/compress/api/IVideoManagerConfigApi;", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/qqnt/compress/video/config/a$a;", "getConfig", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class VideoManagerConfigApiImpl implements IVideoManagerConfigApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "VideoCompressConfigApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/compress/api/impl/VideoManagerConfigApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.compress.api.impl.VideoManagerConfigApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63924);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public VideoManagerConfigApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.compress.api.IVideoManagerConfigApi
    @NotNull
    public a.C9606a getConfig(@Nullable AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a.C9606a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        }
        if (appRuntime == null) {
            return new a.C9606a(0, 0.0d, 0.0d, 0L, 0L, 0L, 0, 127, null);
        }
        a.Companion companion = zq2.a.INSTANCE;
        Context applicationContext = appRuntime.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "appRuntime.applicationContext");
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "appRuntime.currentAccountUin");
        String a16 = companion.a(applicationContext, currentAccountUin);
        if (TextUtils.isEmpty(a16)) {
            QLog.i(TAG, 1, "managerConfig is empty, return");
            return new a.C9606a(0, 0.0d, 0.0d, 0L, 0L, 0L, 0, 127, null);
        }
        try {
            a.C9606a c9606a = new a.C9606a(0, 0.0d, 0.0d, 0L, 0L, 0L, 0, 127, null);
            JSONObject jSONObject = new JSONObject(a16);
            c9606a.k(jSONObject.optInt("maxLength", c9606a.d()));
            c9606a.j(jSONObject.optInt("maxFPS", c9606a.c()));
            c9606a.i(jSONObject.optDouble("density", c9606a.b()));
            c9606a.n(jSONObject.optDouble("minDensity", c9606a.g()));
            if (jSONObject.has("compressLargeMaxSize")) {
                String string = jSONObject.getString("compressLargeMaxSize");
                Intrinsics.checkNotNullExpressionValue(string, "json.getString(\"compressLargeMaxSize\")");
                long j3 = 1024;
                c9606a.l(Long.parseLong(string) * j3 * j3 * 8);
            }
            c9606a.h(jSONObject.optLong("maxBitRate", c9606a.a()));
            c9606a.m(jSONObject.optLong("minBitRate", c9606a.f()));
            QLog.i(TAG, 1, "parsed manager config:" + c9606a);
            return c9606a;
        } catch (NumberFormatException e16) {
            QLog.e(TAG, 2, "loadManagerConfigs, exception is", e16);
            return new a.C9606a(0, 0.0d, 0.0d, 0L, 0L, 0L, 0, 127, null);
        } catch (JSONException e17) {
            QLog.e(TAG, 2, "loadManagerConfigs, exception is", e17);
            return new a.C9606a(0, 0.0d, 0.0d, 0L, 0L, 0L, 0, 127, null);
        }
    }
}
