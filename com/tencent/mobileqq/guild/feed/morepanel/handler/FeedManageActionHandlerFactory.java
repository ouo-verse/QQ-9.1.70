package com.tencent.mobileqq.guild.feed.morepanel.handler;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.event.partevent.GuildPartPanelDismissEvent;
import com.tencent.mobileqq.guild.event.partevent.GuildPartSelectEvent;
import com.tencent.mobileqq.guild.feed.batchmanage.GuildFeedBatchManageFragment;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDeleteEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedSquareRefreshEvent;
import com.tencent.mobileqq.guild.feed.fragment.GuildPartTransFragment;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.feed.morepanel.handler.FeedManageActionHandlerFactory;
import com.tencent.mobileqq.guild.feed.morepanel.handler.x;
import com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl;
import com.tencent.mobileqq.guild.feed.publish.event.GuildFeedMoveEvent2;
import com.tencent.mobileqq.guild.feed.util.ad;
import com.tencent.mobileqq.guild.feed.util.av;
import com.tencent.mobileqq.guild.feed.util.be;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0x92331SuperAdminUnListFeedRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.er;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMoveFeedReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMoveFeedRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopFeedActionReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProMoveFeedCallback;
import com.tencent.util.QQToastUtil;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.em;
import wh2.en;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J \u0010\b\u001a\u00020\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0002J(\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\r\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000eJ\u0006\u0010\u0014\u001a\u00020\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/FeedManageActionHandlerFactory;", "", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "panelContext", "", "c", "", "channelId", "d", "", MiniChatConstants.MINI_APP_TOP_TYPE, "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/x;", "j", "g", "f", "e", "i", tl.h.F, "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedManageActionHandlerFactory {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FeedManageActionHandlerFactory f220270a = new FeedManageActionHandlerFactory();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0002J0\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J(\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/guild/feed/morepanel/handler/FeedManageActionHandlerFactory$a", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/x;", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "panelContext", "", "f", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "", "c", "", "id", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements x {
        a() {
        }

        private final void f(PanelContext<Activity, vk1.b> panelContext) {
            Long longOrNull;
            ArrayList<Long> arrayListOf;
            final Activity h16 = panelContext.h();
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(panelContext.j().r());
            if (longOrNull == null) {
                yl1.n.C(false, "\u9519\u8bef\u7684tinyId\uff1a" + longOrNull);
                return;
            }
            er erVar = new er();
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(longOrNull);
            erVar.e(arrayListOf);
            em emVar = new em() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.b
                @Override // wh2.em
                public final void onResult(int i3, String str) {
                    FeedManageActionHandlerFactory.a.g(h16, i3, str);
                }
            };
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
            ((IGPSService) S0).superAdminBanUser(erVar, emVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(Activity context, int i3, String str) {
            Intrinsics.checkNotNullParameter(context, "$context");
            if (i3 != 0) {
                com.tencent.mobileqq.guild.util.security.b.d(context, i3, str, null, 8, null);
            } else {
                be.a(100L, new Runnable() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        FeedManageActionHandlerFactory.a.h();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h() {
            yl1.n.C(true, QQGuildUIUtil.r(R.string.f147140w3) + QQGuildUIUtil.r(R.string.f145650s2));
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
        public boolean a(@NotNull String id5, @NotNull PanelContext<Activity, vk1.b> panelContext) {
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            f(panelContext);
            return true;
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
        public boolean b(@NotNull String str, @NotNull PanelContext<Activity, vk1.b> panelContext) {
            return x.a.c(this, str, panelContext);
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.x
        public boolean c(@NotNull ShareActionSheetBuilder.ActionSheetItem item, @NotNull PanelContext<Activity, vk1.b> panelContext, @NotNull ShareActionSheet shareActionSheet) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
            shareActionSheet.dismiss();
            f(panelContext);
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0002J0\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J(\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/guild/feed/morepanel/handler/FeedManageActionHandlerFactory$b", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/x;", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "panelContext", "", "f", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "", "c", "", "id", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements x {
        b() {
        }

        private final void f(final PanelContext<Activity, vk1.b> panelContext) {
            final Activity h16 = panelContext.h();
            com.tencent.mobileqq.qqguildsdk.data.genc.w wVar = new com.tencent.mobileqq.qqguildsdk.data.genc.w();
            wVar.b(panelContext.j().getFeedId());
            en enVar = new en() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.d
                @Override // wh2.en
                public final void a(int i3, String str, IGProCmd0x92331SuperAdminUnListFeedRsp iGProCmd0x92331SuperAdminUnListFeedRsp) {
                    FeedManageActionHandlerFactory.b.g(h16, panelContext, i3, str, iGProCmd0x92331SuperAdminUnListFeedRsp);
                }
            };
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
            ((IGPSService) S0).superAdminUnListFeed(wVar, enVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(Activity context, final PanelContext panelContext, int i3, String str, IGProCmd0x92331SuperAdminUnListFeedRsp rsp) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(panelContext, "$panelContext");
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            if (i3 != 0) {
                com.tencent.mobileqq.guild.util.security.b.d(context, i3, str, null, 8, null);
            } else {
                be.a(100L, new Runnable() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        FeedManageActionHandlerFactory.b.h(PanelContext.this);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(PanelContext panelContext) {
            Intrinsics.checkNotNullParameter(panelContext, "$panelContext");
            SimpleEventBus.getInstance().dispatchEvent(new GuildFeedDeleteEvent(((vk1.b) panelContext.j()).getFeedId(), String.valueOf(((vk1.b) panelContext.j()).getGuildId()), String.valueOf(((vk1.b) panelContext.j()).getChannelId())), true);
            yl1.n.C(true, QQGuildUIUtil.r(R.string.f147140w3) + QQGuildUIUtil.r(R.string.f145650s2));
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
        public boolean a(@NotNull String id5, @NotNull PanelContext<Activity, vk1.b> panelContext) {
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            f(panelContext);
            return true;
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
        public boolean b(@NotNull String str, @NotNull PanelContext<Activity, vk1.b> panelContext) {
            return x.a.c(this, str, panelContext);
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.x
        public boolean c(@NotNull ShareActionSheetBuilder.ActionSheetItem item, @NotNull PanelContext<Activity, vk1.b> panelContext, @NotNull ShareActionSheet shareActionSheet) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
            shareActionSheet.dismiss();
            f(panelContext);
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000C\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J0\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J(\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0016\u00a8\u0006\u0015"}, d2 = {"com/tencent/mobileqq/guild/feed/morepanel/handler/FeedManageActionHandlerFactory$c", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/x;", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "panelContext", "", "e", "Landroid/os/Bundle;", "bundle", "Landroid/content/Intent;", "d", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "c", "", "id", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements x {
        c() {
        }

        private final Intent d(Bundle bundle) {
            GuildFeedBaseInitBean guildFeedBaseInitBean;
            Intent intent = new Intent();
            Serializable serializable = bundle.getSerializable(com.tencent.mobileqq.guild.feed.b.f218115a);
            if (serializable instanceof GuildFeedBaseInitBean) {
                guildFeedBaseInitBean = (GuildFeedBaseInitBean) serializable;
            } else {
                guildFeedBaseInitBean = null;
            }
            if (guildFeedBaseInitBean == null) {
                return intent;
            }
            bundle.remove(com.tencent.mobileqq.guild.feed.b.f218115a);
            intent.putExtra(com.tencent.mobileqq.guild.feed.b.f218115a, GuildFeedBatchManageFragment.INSTANCE.a(guildFeedBaseInitBean));
            String guildId = guildFeedBaseInitBean.getGuildId();
            Intrinsics.checkNotNullExpressionValue(guildId, "bean.guildId");
            String channelId = guildFeedBaseInitBean.getChannelId();
            Intrinsics.checkNotNullExpressionValue(channelId, "bean.channelId");
            intent.putExtra("old_page_refresh_event", new GuildFeedSquareRefreshEvent(guildId, channelId, av.f223852a.g(guildFeedBaseInitBean.getBusinessType()), true));
            intent.putExtras(bundle);
            return intent;
        }

        private final boolean e(PanelContext<Activity, vk1.b> panelContext) {
            Bundle a16;
            Intent d16;
            FeedMorePanelBusiImpl.OperationListProvider.b bVar = (FeedMorePanelBusiImpl.OperationListProvider.b) panelContext.getApiRouter().b(FeedMorePanelBusiImpl.OperationListProvider.b.class);
            if (bVar != null && (a16 = bVar.a()) != null && (d16 = d(a16)) != null) {
                QPublicFragmentActivity.start(panelContext.h(), d16, GuildFeedBatchManageFragment.class);
                return true;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
        public boolean a(@NotNull String id5, @NotNull PanelContext<Activity, vk1.b> panelContext) {
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            return e(panelContext);
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
        public boolean b(@NotNull String str, @NotNull PanelContext<Activity, vk1.b> panelContext) {
            return x.a.c(this, str, panelContext);
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.x
        public boolean c(@NotNull ShareActionSheetBuilder.ActionSheetItem item, @NotNull PanelContext<Activity, vk1.b> panelContext, @NotNull ShareActionSheet shareActionSheet) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
            shareActionSheet.dismiss();
            return e(panelContext);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J0\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J(\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/guild/feed/morepanel/handler/FeedManageActionHandlerFactory$e", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/x;", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "panelContext", "", "isFeedTop", "d", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "c", "", "id", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements x {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f220273a;

        e(int i3) {
            this.f220273a = i3;
        }

        private final boolean d(PanelContext<Activity, vk1.b> panelContext, boolean isFeedTop) {
            long channelId;
            vk1.b j3 = panelContext.j();
            if (this.f220273a == 1) {
                IGProChannelInfo B = ch.B(String.valueOf(j3.getChannelId()));
                boolean z16 = false;
                if (B != null && B.getVisibleType() == 2) {
                    z16 = true;
                }
                if (z16) {
                    QQToastUtil.showQQToast(R.string.f145730s_);
                    return true;
                }
            }
            boolean c16 = FeedManageActionHandlerFactory.f220270a.c(panelContext);
            yl1.h hVar = yl1.h.f450607a;
            GProTopFeedActionReq gProTopFeedActionReq = new GProTopFeedActionReq();
            int i3 = this.f220273a;
            if (!c16 && j3.B()) {
                channelId = 0;
            } else {
                channelId = j3.getChannelId();
            }
            gProTopFeedActionReq.channelId = channelId;
            gProTopFeedActionReq.guildId = j3.getGuildId();
            gProTopFeedActionReq.feedId = j3.getFeedId();
            gProTopFeedActionReq.userId = j3.r();
            gProTopFeedActionReq.topType = i3;
            Unit unit = Unit.INSTANCE;
            yl1.h.i(hVar, isFeedTop, gProTopFeedActionReq, false, 4, null);
            return true;
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
        public boolean a(@NotNull String id5, @NotNull PanelContext<Activity, vk1.b> panelContext) {
            boolean areEqual;
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            if (this.f220273a == 1) {
                areEqual = Intrinsics.areEqual(id5, "uppin_homepage");
            } else {
                areEqual = Intrinsics.areEqual(id5, "uppin_section");
            }
            return d(panelContext, areEqual);
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
        public boolean b(@NotNull String str, @NotNull PanelContext<Activity, vk1.b> panelContext) {
            return x.a.c(this, str, panelContext);
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.x
        public boolean c(@NotNull ShareActionSheetBuilder.ActionSheetItem item, @NotNull PanelContext<Activity, vk1.b> panelContext, @NotNull ShareActionSheet shareActionSheet) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
            shareActionSheet.dismiss();
            boolean z16 = false;
            if (this.f220273a != 1 ? item.action == 245 : item.action == 243) {
                z16 = true;
            }
            return d(panelContext, z16);
        }
    }

    FeedManageActionHandlerFactory() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean c(PanelContext<Activity, vk1.b> panelContext) {
        if (panelContext.getExtra().getInt("src_business_type") == 7) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0.isHiddenPostChannel() == true) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean d(String channelId, PanelContext<Activity, vk1.b> panelContext) {
        boolean z16;
        FeedMorePanelBusiImpl.OperationListProvider.e eVar;
        if (Intrinsics.areEqual(channelId, "0") || Intrinsics.areEqual(channelId, "")) {
            return false;
        }
        IGProChannelInfo B = ch.B(channelId);
        if (B != null) {
            z16 = true;
        }
        z16 = false;
        if (z16 || (eVar = (FeedMorePanelBusiImpl.OperationListProvider.e) panelContext.getApiRouter().b(FeedMorePanelBusiImpl.OperationListProvider.e.class)) == null) {
            return false;
        }
        return eVar.a(channelId);
    }

    @NotNull
    public final x e() {
        return new a();
    }

    @NotNull
    public final x f() {
        return new b();
    }

    @NotNull
    public final x g() {
        return new x() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.FeedManageActionHandlerFactory$newDeleteFeedHandler$1
            private final boolean d(final PanelContext<Activity, vk1.b> panelContext) {
                final vk1.b j3 = panelContext.j();
                com.tencent.mobileqq.guild.feed.util.ad.f223828a.f(new ad.FeedDeleteArgs(panelContext.h(), 0L, 0L, j3.getFeedId(), j3.r(), j3.getCreateTime(), new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.FeedManageActionHandlerFactory$newDeleteFeedHandler$1$realHandle$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedDeleteEvent(vk1.b.this.getFeedId(), String.valueOf(vk1.b.this.getGuildId()), String.valueOf(vk1.b.this.getChannelId())), true);
                    }
                }, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.FeedManageActionHandlerFactory$newDeleteFeedHandler$1$realHandle$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        panelContext.f();
                    }
                }, 6, null));
                return true;
            }

            @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
            public boolean a(@NotNull String id5, @NotNull PanelContext<Activity, vk1.b> panelContext) {
                Intrinsics.checkNotNullParameter(id5, "id");
                Intrinsics.checkNotNullParameter(panelContext, "panelContext");
                return d(panelContext);
            }

            @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
            public boolean b(@NotNull String str, @NotNull PanelContext<Activity, vk1.b> panelContext) {
                return x.a.c(this, str, panelContext);
            }

            @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.x
            public boolean c(@NotNull ShareActionSheetBuilder.ActionSheetItem item, @NotNull PanelContext<Activity, vk1.b> panelContext, @NotNull ShareActionSheet shareActionSheet) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(panelContext, "panelContext");
                Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
                shareActionSheet.dismiss();
                return d(panelContext);
            }
        };
    }

    @NotNull
    public final x h() {
        return new c();
    }

    @NotNull
    public final x i() {
        return new d();
    }

    @NotNull
    public final x j(int topType) {
        return new e(topType);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0002\u0000\t\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0002J'\u0010\n\u001a\u00020\t2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J(\u0010\u0015\u001a\u00020\u000f2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u001c\u0010\u0019\u001a\u00020\u000f2\n\u0010\u0018\u001a\u00060\u0016j\u0002`\u00172\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J0\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J(\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001f2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0016\u00a8\u0006\""}, d2 = {"com/tencent/mobileqq/guild/feed/morepanel/handler/FeedManageActionHandlerFactory$d", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/x;", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "panelContext", "", "u", "com/tencent/mobileqq/guild/feed/morepanel/handler/FeedManageActionHandlerFactory$d$a", "t", "(Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;)Lcom/tencent/mobileqq/guild/feed/morepanel/handler/FeedManageActionHandlerFactory$d$a;", "", "feedSrcGuildId", "feedSrcChannelId", "", "v", "Landroid/os/Bundle;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/guild/event/partevent/GuildPartSelectEvent;", "event", "o", "Lqj1/d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedBasicIdDisplayable;", "feed", "k", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "c", "", "id", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements x {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b`\tH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/morepanel/handler/FeedManageActionHandlerFactory$d$a", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "a", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public static final class a implements SimpleEventReceiver<SimpleBaseEvent> {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ PanelContext<Activity, vk1.b> f220272e;

            a(PanelContext<Activity, vk1.b> panelContext) {
                this.f220272e = panelContext;
            }

            private final void a() {
                SimpleEventBus.getInstance().unRegisterReceiver(this);
                this.f220272e.d(this);
            }

            @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
            @NotNull
            public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
                ArrayList<Class<SimpleBaseEvent>> arrayListOf;
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildPartSelectEvent.class, GuildPartPanelDismissEvent.class);
                Intrinsics.checkNotNull(arrayListOf, "null cannot be cast to non-null type java.util.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>>{ kotlin.collections.TypeAliasesKt.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>> }");
                return arrayListOf;
            }

            @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
            public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
                if (event instanceof GuildPartSelectEvent) {
                    a();
                    d.this.o(this.f220272e, (GuildPartSelectEvent) event);
                } else if (event instanceof GuildPartPanelDismissEvent) {
                    a();
                }
            }
        }

        d() {
        }

        private final void k(final qj1.d feed, final GuildPartSelectEvent event) {
            final GProMoveFeedReq gProMoveFeedReq = new GProMoveFeedReq();
            gProMoveFeedReq.feedId = feed.getFeedId();
            gProMoveFeedReq.guildId = feed.getGuildId();
            gProMoveFeedReq.originalChannelId = feed.getChannelId();
            String str = event.channelUin;
            Intrinsics.checkNotNullExpressionValue(str, "event.channelUin");
            gProMoveFeedReq.channelId = Long.parseLong(str);
            com.tencent.qqnt.kernel.api.o c16 = com.tencent.mobileqq.guild.feed.util.l.c();
            if (c16 != null) {
                c16.moveFeed(gProMoveFeedReq, new IGProMoveFeedCallback() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.i
                    @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProMoveFeedCallback
                    public final void onResult(int i3, String str2, GProMoveFeedRsp gProMoveFeedRsp) {
                        FeedManageActionHandlerFactory.d.l(GProMoveFeedReq.this, feed, event, i3, str2, gProMoveFeedRsp);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(final GProMoveFeedReq request, final qj1.d feed, final GuildPartSelectEvent event, final int i3, final String str, GProMoveFeedRsp gProMoveFeedRsp) {
            Intrinsics.checkNotNullParameter(request, "$request");
            Intrinsics.checkNotNullParameter(feed, "$feed");
            Intrinsics.checkNotNullParameter(event, "$event");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.j
                @Override // java.lang.Runnable
                public final void run() {
                    FeedManageActionHandlerFactory.d.m(i3, str, request, feed, event);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(int i3, String str, GProMoveFeedReq request, qj1.d feed, GuildPartSelectEvent event) {
            Intrinsics.checkNotNullParameter(request, "$request");
            Intrinsics.checkNotNullParameter(feed, "$feed");
            Intrinsics.checkNotNullParameter(event, "$event");
            if (i3 != 0) {
                QQToast.makeText(BaseApplication.getContext(), 1, str, 0).show();
                return;
            }
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            String str2 = request.feedId;
            Intrinsics.checkNotNullExpressionValue(str2, "request.feedId");
            String valueOf = String.valueOf(request.getGuildId());
            String valueOf2 = String.valueOf(feed.getChannelId());
            String str3 = event.channelUin;
            Intrinsics.checkNotNullExpressionValue(str3, "event.channelUin");
            simpleEventBus.dispatchEvent(new GuildFeedMoveEvent2(str2, valueOf, valueOf2, str3));
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.k
                @Override // java.lang.Runnable
                public final void run() {
                    FeedManageActionHandlerFactory.d.n();
                }
            }, 100L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n() {
            yl1.n.B(true, R.string.f1503914v);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void o(final PanelContext<Activity, vk1.b> panelContext, final GuildPartSelectEvent event) {
            String string;
            final Activity h16 = panelContext.h();
            FeedManageActionHandlerFactory feedManageActionHandlerFactory = FeedManageActionHandlerFactory.f220270a;
            String str = event.sourceChannelId;
            Intrinsics.checkNotNullExpressionValue(str, "event.sourceChannelId");
            if (feedManageActionHandlerFactory.d(str, panelContext)) {
                string = h16.getString(R.string.f143890na);
            } else if (event.isSquare) {
                string = h16.getString(R.string.f143880n_);
            } else {
                string = h16.getString(R.string.f143900nb, event.channelName);
            }
            String str2 = string;
            Intrinsics.checkNotNullExpressionValue(str2, "if (isSectionTop(event.s\u2026          )\n            }");
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(h16, 230, (String) null, str2, h16.getString(R.string.cancel), h16.getString(R.string.f171151ok), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    FeedManageActionHandlerFactory.d.p(h16, this, panelContext, event, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.g
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    FeedManageActionHandlerFactory.d.q(dialogInterface, i3);
                }
            });
            createCustomDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.h
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    FeedManageActionHandlerFactory.d.r(PanelContext.this, dialogInterface);
                }
            });
            createCustomDialog.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(Activity ctx, d this$0, PanelContext panelContext, GuildPartSelectEvent event, DialogInterface dialogInterface, int i3) {
            Intrinsics.checkNotNullParameter(ctx, "$ctx");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(panelContext, "$panelContext");
            Intrinsics.checkNotNullParameter(event, "$event");
            if (!NetworkUtil.isNetworkAvailable()) {
                QQToast.makeText(ctx, 1, R.string.f144630pa, 0).show();
            } else {
                this$0.k((qj1.d) panelContext.j(), event);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r(PanelContext panelContext, DialogInterface dialogInterface) {
            Intrinsics.checkNotNullParameter(panelContext, "$panelContext");
            panelContext.f();
        }

        private final Bundle s(long feedSrcGuildId, long feedSrcChannelId) {
            return BundleKt.bundleOf(TuplesKt.to("key_guild_id", String.valueOf(feedSrcGuildId)), TuplesKt.to("key_channel_id", String.valueOf(feedSrcChannelId)), TuplesKt.to("key_channel_type", 7), TuplesKt.to("KEY_NEED_CHECK_PERMISSION_TYPE", 30002), TuplesKt.to("part_panel_biz_type", 1), TuplesKt.to("key_toast_if_only_one_section_exist", Boolean.TRUE));
        }

        private final a t(PanelContext<Activity, vk1.b> panelContext) {
            return new a(panelContext);
        }

        private final boolean u(PanelContext<Activity, vk1.b> panelContext) {
            a t16 = t(panelContext);
            SimpleEventBus.getInstance().registerReceiver(t16);
            panelContext.c(t16);
            vk1.b j3 = panelContext.j();
            v(j3.getGuildId(), j3.getChannelId());
            return false;
        }

        private final void v(long feedSrcGuildId, long feedSrcChannelId) {
            Intent intent = new Intent();
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtra("guild_key_part_selection", s(feedSrcGuildId, feedSrcChannelId));
            intent.addFlags(268435456);
            QPublicTransFragmentActivity.start(BaseApplication.getContext(), intent, GuildPartTransFragment.class);
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
        public boolean a(@NotNull String id5, @NotNull PanelContext<Activity, vk1.b> panelContext) {
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            return u(panelContext);
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
        public boolean b(@NotNull String str, @NotNull PanelContext<Activity, vk1.b> panelContext) {
            return x.a.c(this, str, panelContext);
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.x
        public boolean c(@NotNull ShareActionSheetBuilder.ActionSheetItem item, @NotNull PanelContext<Activity, vk1.b> panelContext, @NotNull ShareActionSheet shareActionSheet) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
            shareActionSheet.dismiss();
            return u(panelContext);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(DialogInterface dialogInterface, int i3) {
        }
    }
}
