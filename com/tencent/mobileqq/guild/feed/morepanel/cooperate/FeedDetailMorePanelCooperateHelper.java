package com.tencent.mobileqq.guild.feed.morepanel.cooperate;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import androidx.core.util.Supplier;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.event.FeedEditorEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDeleteEvent;
import com.tencent.mobileqq.guild.feed.event.GuildPublishReEditEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.morepanel.FeedMorePanelLauncher;
import com.tencent.mobileqq.guild.feed.morepanel.FeedSharePanelReportHelper;
import com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl;
import com.tencent.mobileqq.guild.feed.publish.event.GuildFeedMoveEvent2;
import com.tencent.mobileqq.guild.feed.publish.event.GuildPublishSuccessGetFeedEvent;
import com.tencent.mobileqq.guild.feed.publish.event.PostFeedFailedEvent;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl1.g;
import yl1.n;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005:\u0001BB\u000f\u0012\u0006\u0010-\u001a\u00020*\u00a2\u0006\u0004\b@\u0010AJ\u001c\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\n\u0010\n\u001a\u00060\u0006j\u0002`\u0007H\u0002J\u001c\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\n\u001a\u00060\u0006j\u0002`\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u000bH\u0007J\b\u0010\u0019\u001a\u00020\u000bH\u0007J>\u0010!\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001a2\n\u0010\n\u001a\u00060\u0006j\u0002`\u00072\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001e0\u001d0\u001c2\u0006\u0010 \u001a\u00020\u001aH\u0016J\u001a\u0010$\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010%\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010)\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020'0&j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020'`(H\u0016R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R \u00102\u001a\f\u0012\u0006\b\u0001\u0012\u00020/\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010;R\u001c\u0010?\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b=\u0010>\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/cooperate/FeedDetailMorePanelCooperateHelper;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroidx/lifecycle/LifecycleObserver;", "Lwk1/j;", "Lzp1/a;", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "Landroid/os/Bundle;", "args", "feed", "", "j", "Lcom/tencent/mobileqq/guild/feed/morepanel/k;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/feed/publish/event/PostFeedFailedEvent;", "event", "l", "Lcom/tencent/mobileqq/guild/feed/event/GuildPublishReEditEvent;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "feedId", "i", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "position", "Landroidx/core/util/Supplier;", "", "", "dtParamSupplier", "mediaIndex", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "action", "msg", "c", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/richframework/part/Part;", "d", "Lcom/tencent/biz/richframework/part/Part;", "host", "Lyl1/k;", "Lcom/tencent/mobileqq/guild/feed/morepanel/f;", "e", "Lyl1/k;", "morePanelHandle", "", "f", "Z", "isDestroyed", tl.h.F, "Ljava/lang/String;", "mainTaskId", "Landroid/app/Dialog;", "Landroid/app/Dialog;", "loadingDialog", "k", "()Lqj1/h;", "servedFeed", "<init>", "(Lcom/tencent/biz/richframework/part/Part;)V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedDetailMorePanelCooperateHelper implements SimpleEventReceiver<SimpleBaseEvent>, LifecycleObserver, wk1.j, zp1.a<qj1.h> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Part host;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private yl1.k<? extends com.tencent.mobileqq.guild.feed.morepanel.f> morePanelHandle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isDestroyed;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mainTaskId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    public FeedDetailMorePanelCooperateHelper(@NotNull Part host) {
        Intrinsics.checkNotNullParameter(host, "host");
        this.host = host;
    }

    private final void i(String feedId) {
        String str;
        qj1.h k3 = k();
        if (k3 != null) {
            str = k3.getFeedId();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(feedId, str) && !this.isDestroyed) {
            GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, this.host.getPartHost().getHostActivity(), false, 2, null);
        }
    }

    private final void j(Bundle args, qj1.h feed) {
        args.putBoolean("preserve_edit_action", true);
        args.putBoolean("EXTRA_KEY_9090_IMPROVE_SHARE_ACTION", true);
        args.putBoolean("EXTRA_KEY_PRESERVE_SAVE_ACTION", false);
        args.putBoolean("EXTRA_KEY_FINISH_WHEN_FLOAT_WINDOW_OK", false);
        if (com.tencent.mobileqq.guild.discoveryv2.util.a.f217788a.a(feed.getFeedType())) {
            args.putBoolean("EXTRA_KEY_HIDE_FLOATING_WINDOW", true);
        }
        args.putBoolean("extra_key_preserve_generate_share_pic_action", true);
        args.putInt(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, GuildSharePageSource.FEED_DETAIL.ordinal());
        args.putBoolean("share_panel_show_xhs", true);
    }

    private final qj1.h k() {
        return n.p(this.host);
    }

    private final void l(PostFeedFailedEvent event) {
        Dialog dialog;
        if (Intrinsics.areEqual(event.getMainTaskId(), this.mainTaskId) && (dialog = this.loadingDialog) != null) {
            dialog.dismiss();
        }
    }

    private final void m(GuildPublishReEditEvent event) {
        Dialog dialog = this.loadingDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private final void n(com.tencent.mobileqq.guild.feed.morepanel.k launchParam, final qj1.h feed) {
        launchParam.e().getApiRouter().a(FeedMorePanelBusiImpl.OperationListProvider.e.class, new FeedMorePanelBusiImpl.OperationListProvider.e() { // from class: com.tencent.mobileqq.guild.feed.morepanel.cooperate.a
            @Override // com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl.OperationListProvider.e
            public final boolean a(String str) {
                boolean o16;
                o16 = FeedDetailMorePanelCooperateHelper.o(qj1.h.this, str);
                return o16;
            }
        });
        launchParam.e().getApiRouter().a(com.tencent.mobileqq.guild.feed.morepanel.g.class, new FeedSharePanelReportHelper(feed, launchParam.getOperationListProvider(), null, 4, null));
        launchParam.e().getApiRouter().a(l.class, new l() { // from class: com.tencent.mobileqq.guild.feed.morepanel.cooperate.b
            @Override // com.tencent.mobileqq.guild.feed.morepanel.cooperate.l
            public final GuildFeedPublishInfo provide() {
                GuildFeedPublishInfo p16;
                p16 = FeedDetailMorePanelCooperateHelper.p(FeedDetailMorePanelCooperateHelper.this);
                return p16;
            }
        });
        com.tencent.mobileqq.guild.feed.morepanel.i.c(launchParam.e().getApiRouter(), com.tencent.mobileqq.guild.feed.part.a.d(this.host));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o(qj1.h feed, String it) {
        Intrinsics.checkNotNullParameter(feed, "$feed");
        Intrinsics.checkNotNullParameter(it, "it");
        if (!Intrinsics.areEqual(it, "") && !feed.B()) {
            Boolean d16 = yl1.i.f450608a.d(String.valueOf(feed.getGuildId()), feed.getFeedId(), String.valueOf(feed.getChannelId()));
            if (d16 != null) {
                return d16.booleanValue();
            }
            if (feed.g() > 0) {
                return true;
            }
        } else {
            Boolean e16 = yl1.i.e(yl1.i.f450608a, String.valueOf(feed.getGuildId()), feed.getFeedId(), null, 4, null);
            if (e16 != null) {
                return e16.booleanValue();
            }
            if (feed.getTopTimestamp() > 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GuildFeedPublishInfo p(FeedDetailMorePanelCooperateHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return n.q(GuildSplitViewUtils.f235370a.h(this$0.host.getPartHost()));
    }

    @Override // wk1.j
    public void c(@NotNull String action, @Nullable Object msg2) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual(action, "message_data_changed_render_on_screen") && (msg2 instanceof g.OnDataChangedRenderOnScreenMessage)) {
            g.OnDataChangedRenderOnScreenMessage onDataChangedRenderOnScreenMessage = (g.OnDataChangedRenderOnScreenMessage) msg2;
            if (onDataChangedRenderOnScreenMessage.c(9) && onDataChangedRenderOnScreenMessage.getItemSize() > 0) {
                ((vi1.h) RFWIocAbilityProvider.g().getIocInterface(vi1.h.class, this.host.getPartRootView(), null)).B1(0);
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildPublishSuccessGetFeedEvent.class, PostFeedFailedEvent.class, FeedEditorEvent.OnStartPublishFeedEvent.class, GuildPublishReEditEvent.class, GuildFeedDeleteEvent.class, GuildFeedMoveEvent2.class);
        Intrinsics.checkNotNull(arrayListOf, "null cannot be cast to non-null type java.util.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>>{ kotlin.collections.TypeAliasesKt.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>> }");
        return arrayListOf;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        SimpleEventBus.getInstance().registerReceiver(this);
        this.isDestroyed = false;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        this.isDestroyed = true;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.morePanelHandle = null;
        QLog.d("MorePanelCooperateHelper", 4, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        QLog.d("MorePanelCooperateHelper", 1, "onReceiveEvent_event:", event);
        if (event instanceof GuildFeedDeleteEvent) {
            String feedId = ((GuildFeedDeleteEvent) event).getFeedId();
            Intrinsics.checkNotNullExpressionValue(feedId, "event.feedId");
            i(feedId);
        } else if (event instanceof GuildFeedMoveEvent2) {
            i(((GuildFeedMoveEvent2) event).getFeedId());
        } else if (event instanceof GuildPublishReEditEvent) {
            m((GuildPublishReEditEvent) event);
        } else if (event instanceof PostFeedFailedEvent) {
            l((PostFeedFailedEvent) event);
        }
    }

    @Override // zp1.a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void f(int position, @NotNull qj1.h feed, @NotNull Supplier<Map<String, Object>> dtParamSupplier, int mediaIndex) {
        boolean z16;
        com.tencent.mobileqq.guild.feed.morepanel.f b16;
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(dtParamSupplier, "dtParamSupplier");
        yl1.k<? extends com.tencent.mobileqq.guild.feed.morepanel.f> kVar = this.morePanelHandle;
        if (kVar != null && (b16 = kVar.b()) != null && b16.isShowing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.d("MorePanelCooperateHelper", 1, "morePanel is already showing");
            return;
        }
        QLog.d("MorePanelCooperateHelper", 1, "openMorePanel position:", Integer.valueOf(position), " mediaIndex:", Integer.valueOf(mediaIndex));
        FeedMorePanelLauncher feedMorePanelLauncher = new FeedMorePanelLauncher("pindao_feeddetail");
        Activity activity = this.host.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "host.activity");
        com.tencent.mobileqq.guild.feed.morepanel.k e16 = FeedMorePanelLauncher.e(feedMorePanelLauncher, activity, new vk1.a(feed), null, 4, null);
        j(e16.e().getExtra(), feed);
        n(e16, feed);
        e16.h(new com.tencent.mobileqq.guild.feed.morepanel.impl.a(e16.e()));
        this.morePanelHandle = feedMorePanelLauncher.h();
    }
}
