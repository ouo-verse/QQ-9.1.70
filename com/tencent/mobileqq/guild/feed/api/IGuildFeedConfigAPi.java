package com.tencent.mobileqq.guild.feed.api;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.MovementMethod;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 (2\u00020\u0001:\u0001)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&Jp\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u00192\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0017H&J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH&J\b\u0010!\u001a\u00020\u0004H&J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\fH&J\b\u0010#\u001a\u00020\bH&J\u001a\u0010'\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010&\u001a\u00020\u0011H&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedConfigAPi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/os/Bundle;", "args", "", "getTroopFeedFragment", "Landroid/content/Context;", "context", "", "troopUin", "", "launchTroopFeedActivity", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "richContents", "", "highlightWords", "", "lightColor", "channelId", "guildId", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", "Ljava/util/HashMap;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "Lkotlin/Pair;", "Landroid/text/SpannableStringBuilder;", "Landroid/text/method/MovementMethod;", "parseRichTextToSpan", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;", "data", "", "parseMVPFeedsText", "getLayoutPreloadInflateStrategy", "getFeedOptionConfig", "getPreferClickedAnimJsonPath", "Lcom/airbnb/lottie/LottieAnimationView;", "view", "pathColor", "changePreferLottieColor", "Companion", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes13.dex */
public interface IGuildFeedConfigAPi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f217978a;

    @NotNull
    public static final String PARAM_CHANNEL_ID = "PARAM_CHANNEL_ID";

    @NotNull
    public static final String PARAM_CHANNEL_NAME = "PARAM_CHANNEL_NAME";

    @NotNull
    public static final String PARAM_GUILD_ID = "PARAM_GUILD_ID";

    @NotNull
    public static final String PARAM_TRANS_DATA = "PARAM_TRANS_DATA";

    @NotNull
    public static final String PARAM_TROOP_UIN = "PARAM_TROOP_UIN";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedConfigAPi$a;", "", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.api.IGuildFeedConfigAPi$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f217978a = new Companion();

        Companion() {
        }
    }

    void changePreferLottieColor(@Nullable LottieAnimationView view, int pathColor);

    @NotNull
    List<String> getFeedOptionConfig();

    @NotNull
    Object getLayoutPreloadInflateStrategy();

    @NotNull
    String getPreferClickedAnimJsonPath();

    @NotNull
    Object getTroopFeedFragment(@NotNull Bundle args);

    void launchTroopFeedActivity(@NotNull Context context, @NotNull String troopUin);

    @NotNull
    CharSequence parseMVPFeedsText(@NotNull IGProContentRecommendFeed data);

    @NotNull
    Pair<SpannableStringBuilder, MovementMethod> parseRichTextToSpan(@NotNull List<GProStRichTextContent> richContents, @NotNull Collection<String> highlightWords, int lightColor, @Nullable String channelId, @Nullable String guildId, @Nullable JumpGuildParam.JoinInfoParam joinInfoParam, @NotNull HashMap<String, Object> reportParams);
}
