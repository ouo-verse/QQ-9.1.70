package com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelThirdAppHelper;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.c;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c;
import com.tencent.mobileqq.guild.media.thirdapp.container.report.GuildMediaWebJsReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.mini.servlet.GameHallAuthServerlet;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\"\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/GetAuthCodeMethod;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/o;", "", "appId", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/c;", "authResult", "", "i", "f", "b", "url", "Lorg/json/JSONObject;", "args", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/c;", "callback", "", "c", "<init>", "()V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GetAuthCodeMethod extends o {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/GetAuthCodeMethod$b", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/c;", "", "code", "", "msg", "Landroid/os/Bundle;", "extra", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.media.thirdapp.container.intent.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c f229294a;

        b(com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c cVar) {
            this.f229294a = cVar;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.c
        public void a(long code, @Nullable String msg2, @NotNull Bundle extra) {
            Intrinsics.checkNotNullParameter(extra, "extra");
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GetAuthCodeMethod", 1, "code " + code + ", msg " + msg2 + ", extra " + extra);
            GuildMediaWebJsReportTask webJsReportTask = com.tencent.mobileqq.guild.media.core.j.a().d0().getWebJsReportTask();
            if (webJsReportTask != null) {
                webJsReportTask.e(code);
            }
            com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c cVar = this.f229294a;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(GameHallAuthServerlet.AUTH_STATUS, extra.getInt(GameHallAuthServerlet.AUTH_STATUS, -1));
            jSONObject.put("auth_code", extra.getString("auth_code", ""));
            c.a.a(cVar, jSONObject, false, 2, null);
        }
    }

    private final void i(String appId, final com.tencent.mobileqq.guild.media.thirdapp.container.intent.c authResult) {
        String str;
        String str2;
        final MediaChannelThirdAppHelper d06 = com.tencent.mobileqq.guild.media.core.j.a().d0();
        IGProLobbyAppInfo thirdAppInfo = d06.getThirdAppInfo();
        if (thirdAppInfo != null) {
            str = thirdAppInfo.getAppId();
        } else {
            str = null;
        }
        if (!TextUtils.equals(str, appId)) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            if (thirdAppInfo != null) {
                str2 = thirdAppInfo.getAppId();
            } else {
                str2 = null;
            }
            String str3 = "handleGetAuthCode: error appId. appId[" + appId + "] cacheAppId[" + str2 + "]";
            if (str3 instanceof String) {
                bVar.a().add(str3);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaThirdApp.GetAuthCodeMethod", 1, (String) it.next(), null);
            }
            c.a.a(authResult, -9999L, null, null, 6, null);
            return;
        }
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GetAuthCodeMethod", 1, "handleGetAuthCode appId " + appId);
        com.tencent.mobileqq.guild.media.thirdapp.container.report.a thirdAppLoadReportTask = d06.getThirdAppLoadReportTask();
        if (thirdAppLoadReportTask != null) {
            thirdAppLoadReportTask.h();
        }
        d06.n2(appId, new Function4<Integer, String, Boolean, String, Unit>() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.GetAuthCodeMethod$handleGetAuthCode$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str4, Boolean bool, String str5) {
                invoke(num.intValue(), str4, bool.booleanValue(), str5);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String errMsg, boolean z16, @NotNull String authCode) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(authCode, "authCode");
                Logger.f235387a.d().d("QGMC.MediaThirdApp.GetAuthCodeMethod", 1, "handleGetAuthCode ret " + i3 + ", errMsg " + errMsg + ", isAuth " + z16 + ", authCode " + authCode);
                com.tencent.mobileqq.guild.media.thirdapp.container.report.a thirdAppLoadReportTask2 = MediaChannelThirdAppHelper.this.getThirdAppLoadReportTask();
                if (thirdAppLoadReportTask2 != null) {
                    thirdAppLoadReportTask2.g(i3);
                }
                com.tencent.mobileqq.guild.media.thirdapp.container.intent.c cVar = authResult;
                long j3 = i3;
                Bundle bundle = new Bundle();
                bundle.putInt(GameHallAuthServerlet.AUTH_STATUS, z16 ? 1 : 0);
                bundle.putString("auth_code", authCode);
                Unit unit = Unit.INSTANCE;
                cVar.a(j3, errMsg, bundle);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b
    @NotNull
    public String b() {
        return "getAuthCode";
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.o, com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b
    public boolean c(@NotNull String url, @Nullable JSONObject args, @NotNull com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (args == null) {
            return true;
        }
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GetAuthCodeMethod", 1, "getAuthCode [onInvoke], args: " + args);
        String appId = args.optString("app_id", "");
        b bVar = new b(callback);
        GuildMediaWebJsReportTask webJsReportTask = com.tencent.mobileqq.guild.media.core.j.a().d0().getWebJsReportTask();
        if (webJsReportTask != null) {
            webJsReportTask.f();
        }
        Intrinsics.checkNotNullExpressionValue(appId, "appId");
        i(appId, bVar);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.o
    @NotNull
    public String f() {
        return "QGMC.MediaThirdApp.GetAuthCodeMethod";
    }
}
