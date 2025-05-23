package lt1;

import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.tencent.base.api.data.BaseParam;
import com.tencent.mobileqq.guild.media.thirdapp.ContentSize;
import com.tencent.mobileqq.guild.media.thirdapp.container.ContainerLifeEvent;
import com.tencent.mobileqq.guild.media.thirdapp.container.GuildOpenContainerLauncher;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.MainProcessIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.m;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\f\u0012\u0004\u0012\u00020\u00010\u0000j\u0002`\u0002\u001a\u0014\u0010\u0006\u001a\u00020\u0005*\f\u0012\u0004\u0012\u00020\u00010\u0000j\u0002`\u0002\u001a\u0014\u0010\b\u001a\u00020\u0007*\f\u0012\u0004\u0012\u00020\u00010\u0000j\u0002`\u0002\u001a\u001c\u0010\f\u001a\u00020\u000b*\f\u0012\u0004\u0012\u00020\u00010\u0000j\u0002`\u00022\u0006\u0010\n\u001a\u00020\t\u001a\n\u0010\u000e\u001a\u00020\u0005*\u00020\r\u001a\u0014\u0010\u0010\u001a\u00020\u000f*\f\u0012\u0004\u0012\u00020\u00010\u0000j\u0002`\u0002\u001a\n\u0010\u0011\u001a\u00020\u000f*\u00020\u0003\u001a\n\u0010\u0012\u001a\u00020\u0005*\u00020\u0003\u001a\n\u0010\u0015\u001a\u00020\u0014*\u00020\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/base/api/runtime/a;", "Lcom/tencent/base/api/data/BaseParam;", "Lcom/tencent/base/api/runtime/BaseContext;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "g", "", "b", "", "d", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/ContainerLifeEvent;", "event", "", "i", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "e", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$a;", "a", "f", "c", "Lcom/tencent/mobileqq/guild/media/thirdapp/a;", "Lorg/json/JSONObject;", h.F, "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {
    @NotNull
    public static final GuildOpenContainerLauncher.MiniAppConfig a(@NotNull com.tencent.base.api.runtime.a<BaseParam> aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return f(g(aVar));
    }

    @NotNull
    public static final String b(@NotNull com.tencent.base.api.runtime.a<BaseParam> aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return c(g(aVar));
    }

    @NotNull
    public static final String c(@NotNull GuildOpenContainerLauncher.StartParams startParams) {
        Intrinsics.checkNotNullParameter(startParams, "<this>");
        String builder = Uri.parse(startParams.getUrl()).buildUpon().appendQueryParameter("guild_id", startParams.getGuildId()).appendQueryParameter("channel_id", startParams.getChannelId()).appendQueryParameter("app_id", startParams.getAppId()).appendQueryParameter("open_id", startParams.getOpenId()).appendQueryParameter("channel_name", startParams.getExtra().getString("channel_name", "")).appendQueryParameter("user_type", String.valueOf(startParams.getExtra().getInt("user_type", 0))).appendQueryParameter("start_permission", String.valueOf(startParams.getExtra().getInt("start_permission", 0))).toString();
        Intrinsics.checkNotNullExpressionValue(builder, "parse(url).buildUpon()\n \u2026ng())\n        .toString()");
        return builder;
    }

    public static final boolean d(@NotNull com.tencent.base.api.runtime.a<BaseParam> aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        FragmentActivity activity = aVar.c().getActivity();
        if (activity == null) {
            return false;
        }
        if (!activity.isFinishing() && !activity.isDestroyed()) {
            return false;
        }
        return true;
    }

    @NotNull
    public static final String e(@NotNull RequestEvent requestEvent) {
        Intrinsics.checkNotNullParameter(requestEvent, "<this>");
        return "event: " + requestEvent.event + " | jsonParams: " + requestEvent.jsonParams;
    }

    @NotNull
    public static final GuildOpenContainerLauncher.MiniAppConfig f(@NotNull GuildOpenContainerLauncher.StartParams startParams) {
        Intrinsics.checkNotNullParameter(startParams, "<this>");
        return new GuildOpenContainerLauncher.MiniAppConfig(startParams.getExtra().getBoolean("guildMiniAppUserDefaultLoading", true), startParams.getExtra().getFloat("guildMiniAppHeightRatio", 0.85714287f), startParams.getExtra().getFloat("guildMiniAppHeightByDP", 0.0f), startParams.getExtra().getBoolean("guildMiniAppOpenInSameContainer", true));
    }

    @NotNull
    public static final GuildOpenContainerLauncher.StartParams g(@NotNull com.tencent.base.api.runtime.a<BaseParam> aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        BaseParam h16 = aVar.h();
        Intrinsics.checkNotNull(h16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.thirdapp.container.GuildOpenContainerLauncher.StartParams");
        return (GuildOpenContainerLauncher.StartParams) h16;
    }

    @NotNull
    public static final JSONObject h(@NotNull ContentSize contentSize) {
        Intrinsics.checkNotNullParameter(contentSize, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("left", contentSize.getLeftPlaceHolder());
        jSONObject.put("top", contentSize.getTopPlaceHolder());
        jSONObject.put("right", contentSize.getRightPlaceHolder());
        jSONObject.put("bottom", contentSize.getBottomPlaceHolder());
        JSONObject jSONObject2 = new JSONObject();
        String str = m.INSTANCE.a().get(contentSize.getScreenMode());
        if (str == null) {
            str = "-1";
        }
        jSONObject2.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SCREEN_MODE, str);
        jSONObject2.put("operateArea", jSONObject);
        return jSONObject2;
    }

    public static final void i(@NotNull com.tencent.base.api.runtime.a<BaseParam> aVar, @NotNull ContainerLifeEvent event) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
        aVar.e().h(new MainProcessIntent.ContainerLifeIntent(event));
    }
}
