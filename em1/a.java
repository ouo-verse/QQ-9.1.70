package em1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.os.BundleKt;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.feed.b;
import com.tencent.mobileqq.guild.feed.feedsquare.data.l;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedNativePublishInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedSchemeBean;
import com.tencent.mobileqq.guild.feed.nativepublish.fragment.ShortFeedEditorFragment;
import com.tencent.mobileqq.guild.feed.nativepublish.launcher.compat.FeedPublishEditorLaunchCompat;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.p;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b.\u0010/J`\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062>\u0010\u0011\u001a:\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bj\u0004\u0018\u0001`\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J$\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0007J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0019H\u0007JP\u0010%\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#H\u0007JH\u0010(\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u0004H\u0007J\u0010\u0010)\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001e\u0010*\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J^\u0010+\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022>\u0010\u0011\u001a:\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bj\u0004\u0018\u0001`\u0010J\u0012\u0010-\u001a\u00020\u000f*\u00020\u00132\u0006\u0010,\u001a\u00020\u0013\u00a8\u00060"}, d2 = {"Lem1/a;", "", "Landroid/os/Bundle;", "argument", "", "sceneType", "Landroid/content/Context;", "context", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedNativePublishInitBean;", "Lkotlin/ParameterName;", "name", "bean", "Landroid/content/Intent;", "intent", "", "Lcom/tencent/mobileqq/guild/feed/nativepublish/launcher/compat/EditorLaunchCompatAction;", "compatLogic", "f", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "initBean", "j", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/l;", "channelInfo", "b", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "c", "", "guildId", "channelId", "feedJson", "feedId", "businessType", "troopUin", "troopRole", "Lcom/tencent/mobileqq/guild/mainframe/GuildFeedReportSourceInfo;", "jumpExtraInfo", "d", "jsonFeed", "mainTaskId", "e", "a", "i", h.F, "src", "g", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f396585a = new a();

    a() {
    }

    private final GuildFeedNativePublishInitBean a(Context context) {
        GuildFeedNativePublishInitBean guildFeedNativePublishInitBean = new GuildFeedNativePublishInitBean();
        if (!(context instanceof Activity)) {
            return guildFeedNativePublishInitBean;
        }
        Intent intent = ((Activity) context).getIntent();
        if (intent != null && intent.hasExtra(b.f218115a)) {
            try {
                GuildFeedSchemeBean guildFeedSchemeBean = (GuildFeedSchemeBean) intent.getSerializableExtra(b.f218115a);
                if (guildFeedSchemeBean != null) {
                    QLog.d("GuildFeedPublishLauncher", 1, "publishInitBean sourceType = " + guildFeedSchemeBean.getSourceType() + ", businessType = " + guildFeedSchemeBean.getBusinessType() + "  !!");
                    guildFeedNativePublishInitBean.setSourceType(guildFeedSchemeBean.getSourceType());
                    guildFeedNativePublishInitBean.setBusinessType(guildFeedSchemeBean.getBusinessType());
                    guildFeedNativePublishInitBean.setTroopUin(guildFeedSchemeBean.getTroopUin());
                    guildFeedNativePublishInitBean.setTroopRole(guildFeedSchemeBean.getTroopRole());
                }
            } catch (Throwable th5) {
                QLog.e("GuildFeedPublishLauncher", 1, "trySetJoinSigForGuest getSerializableExtra error !!", th5);
            }
        }
        return guildFeedNativePublishInitBean;
    }

    @Deprecated(message = "\u5b9a\u5236\u4e86\u8fc7\u591a\u903b\u8f91\uff0c\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "startPublishEditorCompat", imports = {"com.tencent.mobileqq.guild.feed.nativepublish.launcher.GuildFeedPublishLauncher"}))
    @JvmStatic
    public static final void b(@NotNull Context context, @NotNull GuildFeedBaseInitBean initBean, @Nullable l channelInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        GuildFeedBaseInitBean guildFeedBaseInitBean = new GuildFeedBaseInitBean();
        a aVar = f396585a;
        aVar.g(guildFeedBaseInitBean, initBean);
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to(b.f218115a, guildFeedBaseInitBean));
        FeedPublishEditorLaunchCompat feedPublishEditorLaunchCompat = FeedPublishEditorLaunchCompat.f222113a;
        aVar.h(context, 1, bundleOf, feedPublishEditorLaunchCompat.e(feedPublishEditorLaunchCompat.e(feedPublishEditorLaunchCompat.d(channelInfo), feedPublishEditorLaunchCompat.f("publish new feed")), feedPublishEditorLaunchCompat.c()));
    }

    @Deprecated(message = "\u5b9a\u5236\u4e86\u8fc7\u591a\u903b\u8f91\uff0c\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "startPublishEditorCompat", imports = {"com.tencent.mobileqq.guild.feed.nativepublish.launcher.GuildFeedPublishLauncher"}))
    @JvmStatic
    public static final void c(@NotNull Context context, @NotNull GuildFeedMainInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        b(context, initBean, null);
    }

    @Deprecated(message = "\u51fd\u6570\u53c2\u6570\u589e\u957f\u8fc7\u591a\uff0c\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "startPublishEditorCompat", imports = {"com.tencent.mobileqq.guild.feed.nativepublish.launcher.GuildFeedPublishLauncher"}))
    @JvmStatic
    public static final void d(@NotNull Context context, @NotNull String guildId, @NotNull String channelId, @NotNull String feedJson, @NotNull String feedId, int businessType, @NotNull String troopUin, int troopRole, @NotNull GuildFeedReportSourceInfo jumpExtraInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(feedJson, "feedJson");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(jumpExtraInfo, "jumpExtraInfo");
        GuildFeedBaseInitBean guildFeedBaseInitBean = new GuildFeedBaseInitBean();
        guildFeedBaseInitBean.setBusinessType(businessType);
        guildFeedBaseInitBean.setGuildId(guildId);
        guildFeedBaseInitBean.setChannelId(channelId);
        guildFeedBaseInitBean.setTroopUin(troopUin);
        guildFeedBaseInitBean.setTroopRole(troopRole);
        guildFeedBaseInitBean.setFeedReportSourceInfo(jumpExtraInfo);
        a aVar = f396585a;
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("launch_feed_id", feedId), TuplesKt.to("launch_json_feed_store_id", feedId), TuplesKt.to("launch_json_feed", feedJson), TuplesKt.to(b.f218115a, guildFeedBaseInitBean));
        FeedPublishEditorLaunchCompat feedPublishEditorLaunchCompat = FeedPublishEditorLaunchCompat.f222113a;
        aVar.h(context, 2, bundleOf, feedPublishEditorLaunchCompat.e(feedPublishEditorLaunchCompat.f("reedit feed from h5"), feedPublishEditorLaunchCompat.c()));
    }

    @Deprecated(message = "\u51fd\u6570\u53c2\u6570\u589e\u957f\u8fc7\u591a\uff0c\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "startPublishEditorCompat", imports = {"com.tencent.mobileqq.guild.feed.nativepublish.launcher.GuildFeedPublishLauncher"}))
    @JvmStatic
    public static final void e(@NotNull Context context, @NotNull String guildId, @NotNull String channelId, @NotNull String feedId, int sceneType, @NotNull String jsonFeed, @NotNull String mainTaskId, int businessType) {
        boolean z16;
        String str;
        String str2;
        boolean z17;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(jsonFeed, "jsonFeed");
        Intrinsics.checkNotNullParameter(mainTaskId, "mainTaskId");
        a aVar = f396585a;
        GuildFeedNativePublishInitBean a16 = aVar.a(context);
        a16.setGuildId(guildId);
        a16.setChannelId(channelId);
        a16.setBusinessType(businessType);
        GuildFeedBaseInitBean q16 = ax.q(context);
        if (q16 != null) {
            a16.setTroopUin(q16.getTroopUin());
            a16.setTroopRole(q16.getTroopRole());
            a16.setFeedReportSourceInfo(q16.getFeedReportSourceInfo());
        }
        if (feedId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str3 = null;
        if (z16) {
            str = feedId;
        } else {
            str = null;
        }
        if (str == null) {
            if (mainTaskId.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                str3 = mainTaskId;
            }
            if (str3 == null) {
                str = String.valueOf(jsonFeed.hashCode());
            } else {
                str = str3;
            }
        }
        if (TextUtils.isEmpty(feedId)) {
            str2 = mainTaskId;
        } else {
            str2 = feedId;
        }
        jj1.b c16 = jj1.b.c();
        Intrinsics.checkNotNullExpressionValue(c16, "getInstance()");
        p.a(c16, str, jsonFeed);
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("launch_main_task_id", mainTaskId), TuplesKt.to("launch_json_feed_store_id", str), TuplesKt.to("launch_feed_id", feedId), TuplesKt.to(b.f218115a, a16), TuplesKt.to("launch_draft_key", str2));
        FeedPublishEditorLaunchCompat feedPublishEditorLaunchCompat = FeedPublishEditorLaunchCompat.f222113a;
        aVar.h(context, sceneType, bundleOf, feedPublishEditorLaunchCompat.e(feedPublishEditorLaunchCompat.f("reedit feed of republish failed"), feedPublishEditorLaunchCompat.c()));
    }

    private final Intent f(Bundle argument, int sceneType, Context context, Function2<? super GuildFeedNativePublishInitBean, ? super Intent, Unit> compatLogic) {
        Serializable serializable = argument.getSerializable(b.f218115a);
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean");
        argument.remove(b.f218115a);
        GuildFeedNativePublishInitBean j3 = j((GuildFeedBaseInitBean) serializable);
        Intent intent = new Intent();
        intent.putExtras(argument);
        intent.putExtra("launch_scene_type", sceneType);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (compatLogic != null) {
            compatLogic.invoke(j3, intent);
        }
        intent.putExtra(b.f218115a, j3);
        return intent;
    }

    private final GuildFeedNativePublishInitBean j(GuildFeedBaseInitBean initBean) {
        GuildFeedNativePublishInitBean guildFeedNativePublishInitBean = new GuildFeedNativePublishInitBean();
        f396585a.g(guildFeedNativePublishInitBean, initBean);
        if (initBean instanceof GuildFeedSchemeBean) {
            guildFeedNativePublishInitBean.setSourceType(((GuildFeedSchemeBean) initBean).getSourceType());
        }
        return guildFeedNativePublishInitBean;
    }

    public final void g(@NotNull GuildFeedBaseInitBean guildFeedBaseInitBean, @NotNull GuildFeedBaseInitBean src) {
        Intrinsics.checkNotNullParameter(guildFeedBaseInitBean, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        guildFeedBaseInitBean.setBusinessType(src.getBusinessType());
        guildFeedBaseInitBean.setGuildId(src.getGuildId());
        guildFeedBaseInitBean.setChannelId(src.getChannelId());
        guildFeedBaseInitBean.setChannelName(src.getChannelName());
        guildFeedBaseInitBean.setImmersiveSource(src.getImmersiveSource());
        guildFeedBaseInitBean.setFeedReportSourceInfo(src.getFeedReportSourceInfo());
        guildFeedBaseInitBean.setTroopUin(src.getTroopUin());
        guildFeedBaseInitBean.setTroopRole(src.getTroopRole());
    }

    public final void h(@NotNull Context context, int sceneType, @NotNull Bundle argument, @Nullable Function2<? super GuildFeedNativePublishInitBean, ? super Intent, Unit> compatLogic) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(argument, "argument");
        ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).initGuildTaskQueueManager();
        Intent f16 = f(argument, sceneType, context, compatLogic);
        f16.putExtra("launch_blueprint_class", dm1.b.class);
        f16.putExtra("public_fragment_window_feature", 1);
        km1.a.f412694a.c(f16);
        QPublicFragmentActivity.b.b(context, f16, QPublicTransFragmentActivity.class, ShortFeedEditorFragment.class);
    }

    public final void i(@NotNull Context context, int sceneType, @NotNull Bundle argument) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(argument, "argument");
        h(context, sceneType, argument, null);
    }
}
