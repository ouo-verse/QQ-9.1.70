package com.tencent.mobileqq.weather.servlet;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.jungle.weather.proto.weather$GetConcernWeatherReply;
import com.tencent.jungle.weather.proto.weather$GetConcernWeatherRequest;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.api.impl.PbProtocolSSoImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J@\u0010\u0013\u001a\u00020\t\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\u001c\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00170\r\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/weather/servlet/e;", "", "", "cmd", "cmdKey", "", "reqBytes", "Lcom/tencent/mobileqq/weather/servlet/c;", "callback", "", "f", "Lcom/tencent/mobileqq/pb/MessageMicro;", "T", "Lcom/tencent/mobileqq/weather/servlet/b;", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "errCode", "errMsg", "", "e", "d", "c", "Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherRequest;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/jungle/weather/proto/weather$GetConcernWeatherReply;", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f313622a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/weather/servlet/e$a", "Lcom/tencent/mobileqq/weather/servlet/c;", "", PbProtocolSSoImpl.RESP_KEY_IS_DATA, "", "b", "", "errMsg", "", "e", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b<weather$GetConcernWeatherReply> f313623a;

        a(b<weather$GetConcernWeatherReply> bVar) {
            this.f313623a = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            }
        }

        @Override // com.tencent.mobileqq.weather.servlet.c
        public void a(@NotNull String errMsg, @Nullable Throwable e16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errMsg, (Object) e16);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            e.f313622a.d(this.f313623a, VasAdvServiceCode.REQUEST_CMD_ERROR, "request ad onError: " + errMsg, e16);
        }

        @Override // com.tencent.mobileqq.weather.servlet.c
        public void b(@NotNull byte[] rspBytes) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rspBytes);
                return;
            }
            Intrinsics.checkNotNullParameter(rspBytes, "rspBytes");
            try {
                weather$GetConcernWeatherReply weather_getconcernweatherreply = new weather$GetConcernWeatherReply();
                weather_getconcernweatherreply.mergeFrom(rspBytes);
                this.f313623a.a(weather_getconcernweatherreply);
            } catch (Exception e16) {
                e.f313622a.d(this.f313623a, VasAdvServiceCode.REQUEST_RSP_PARSE_ERR, "parse rsp exception: " + e16.getMessage(), e16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43843);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f313622a = new e();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String c() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        return uuid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T extends MessageMicro<T>> void d(b<T> callback, VasAdvServiceCode errCode, String errMsg, Throwable e16) {
        callback.b(errCode, errMsg, e16);
    }

    private final void f(final String cmd, final String cmdKey, final byte[] reqBytes, final c callback) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.weather.servlet.d
            @Override // java.lang.Runnable
            public final void run() {
                e.g(cmd, cmdKey, reqBytes, callback);
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(String cmd, String cmdKey, byte[] reqBytes, c callback) {
        Intrinsics.checkNotNullParameter(cmd, "$cmd");
        Intrinsics.checkNotNullParameter(cmdKey, "$cmdKey");
        Intrinsics.checkNotNullParameter(reqBytes, "$reqBytes");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        com.tencent.mobileqq.weather.servlet.a.INSTANCE.a(cmd, cmdKey, reqBytes, callback);
    }

    public final void e(@NotNull weather$GetConcernWeatherRequest request, @NotNull b<weather$GetConcernWeatherReply> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) request, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            byte[] byteArray = request.toByteArray();
            f("trpc.qqweather.trpc_trpc_proxy.trpc_trpc_proxy.SsoGetConcernWeather", c(), byteArray, new a(callback));
        } catch (Throwable th5) {
            d(callback, VasAdvServiceCode.CREATE_REQUEST_ERR, "create request ad error, abort request ad", th5);
            QLog.e("WeatherSsoService", 1, "create request ad error, abort request ad", th5);
        }
    }
}
