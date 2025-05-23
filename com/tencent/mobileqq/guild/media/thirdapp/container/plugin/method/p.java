package com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.AppAuthResult;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.AppInfo;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.AuthInfo;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.MiniAppIntent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/p;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/o;", "", "url", "Lorg/json/JSONObject;", "args", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/c;", "callback", "", "c", "f", "b", "<init>", "()V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class p extends o {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/p$a;", "", "Lorg/json/JSONObject;", "args", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/a;", "a", "", "METHOD_TAG", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.p$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final AppAuthResult a(@NotNull JSONObject args) {
            JSONObject optJSONObject;
            Intrinsics.checkNotNullParameter(args, "args");
            Logger.f235387a.d().d("NotifyAppAuthResultMethod", 1, "parseAppAuthResult " + args);
            JSONObject optJSONObject2 = args.optJSONObject("appInfo");
            if (optJSONObject2 == null || (optJSONObject = args.optJSONObject("ticket")) == null) {
                return null;
            }
            String optString = optJSONObject2.optString(WadlProxyConsts.KEY_JUMP_URL);
            String optString2 = optJSONObject2.optString("appName");
            String optString3 = optJSONObject2.optString("appIcon");
            String optString4 = optJSONObject2.optString("appId");
            int optInt = optJSONObject2.optInt(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SCREEN_MODE);
            int optInt2 = optJSONObject2.optInt("minMembers");
            int optInt3 = optJSONObject2.optInt("maxMembers");
            int optInt4 = optJSONObject2.optInt("maxMembers");
            int optInt5 = optJSONObject2.optInt("perLoadingMaterialType");
            String optString5 = optJSONObject2.optString("perLoadingMaterialUrl");
            Intrinsics.checkNotNullExpressionValue(optString, "optString(\"jumpUrl\")");
            Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"appName\")");
            Intrinsics.checkNotNullExpressionValue(optString3, "optString(\"appIcon\")");
            Intrinsics.checkNotNullExpressionValue(optString4, "optString(\"appId\")");
            Intrinsics.checkNotNullExpressionValue(optString5, "optString(\"perLoadingMaterialUrl\")");
            AppInfo appInfo = new AppInfo(optString, optString2, optString3, optString4, optInt4, optInt, optInt2, optInt3, optString5, optInt5);
            String optString6 = optJSONObject.optString("openId");
            Intrinsics.checkNotNullExpressionValue(optString6, "authInfoJson.optString(\"openId\")");
            return new AppAuthResult(appInfo, new AuthInfo(optString6, null, 2, null));
        }

        Companion() {
        }
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b
    @NotNull
    public String b() {
        return "notifyAppAuthResult";
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.o, com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b
    public boolean c(@NotNull String url, @Nullable JSONObject args, @NotNull com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c callback) {
        AppAuthResult appAuthResult;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (args == null) {
            return true;
        }
        int optInt = args.optInt("code", -1);
        if (optInt == 0) {
            appAuthResult = INSTANCE.a(args);
        } else {
            appAuthResult = null;
        }
        g(new MiniAppIntent.AppAuthResultIntent(optInt, appAuthResult));
        return true;
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.o
    @NotNull
    public String f() {
        return "NotifyAppAuthResultMethod";
    }
}
