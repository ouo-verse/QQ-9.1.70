package com.tencent.mobileqq.guild.feed.morepanel.cooperate;

import android.app.Activity;
import android.os.Bundle;
import androidx.core.util.Supplier;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDeleteEvent;
import com.tencent.mobileqq.guild.feed.feedoption.GuildFeedOptionDialogFragment;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.morepanel.FeedMorePanelLauncher;
import com.tencent.mobileqq.guild.feed.morepanel.FeedSharePanelReportHelper;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.feed.morepanel.cooperate.FeedListPartMorePanelCooperateHelper;
import com.tencent.mobileqq.guild.feed.morepanel.handler.x;
import com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl;
import com.tencent.mobileqq.guild.feed.morepanel.impl.NewFeedMorePanelBusiImpl;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.guild.feed.util.av;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u001b\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001/B\u001d\u0012\u0006\u0010%\u001a\u00020\"\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015\u00a2\u0006\u0004\b-\u0010.J4\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002JI\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0018\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00170\u00160\u00152\u0006\u0010\u001a\u001a\u00020\u0019H\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u000eH\u0007J:\u0010!\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00022\u0018\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00170\u00160\u00152\u0006\u0010 \u001a\u00020\bH\u0016R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00100\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010&R \u0010,\u001a\f\u0012\u0006\b\u0001\u0012\u00020)\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/cooperate/FeedListPartMorePanelCooperateHelper;", "Lzp1/a;", "Lij1/g;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/mobileqq/guild/feed/morepanel/k;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "initBean", "", "position", "Lvk1/a;", "feedSourceDataProvider", "Lcom/tencent/mobileqq/guild/feed/morepanel/cooperate/l;", "feedPublishInfoProvider", "", "j", "", "feedId", "Landroid/os/Bundle;", "e", "feedBlockData", "Landroidx/core/util/Supplier;", "", "", "dtParamSupplier", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "com/tencent/mobileqq/guild/feed/morepanel/cooperate/FeedListPartMorePanelCooperateHelper$b", "g", "(ILij1/g;Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;Landroidx/core/util/Supplier;Landroidx/fragment/app/FragmentManager;)Lcom/tencent/mobileqq/guild/feed/morepanel/cooperate/FeedListPartMorePanelCooperateHelper$b;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "feed", "mediaIndex", tl.h.F, "Lcom/tencent/biz/richframework/part/Part;", "d", "Lcom/tencent/biz/richframework/part/Part;", "hostPart", "Landroidx/core/util/Supplier;", "feedListDataSurfaceKeyProvider", "Lyl1/k;", "Lcom/tencent/mobileqq/guild/feed/morepanel/f;", "f", "Lyl1/k;", "morePanelHandle", "<init>", "(Lcom/tencent/biz/richframework/part/Part;Landroidx/core/util/Supplier;)V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedListPartMorePanelCooperateHelper implements zp1.a<ij1.g>, LifecycleObserver {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final a f220216h = new a(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Part hostPart;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Supplier<String> feedListDataSurfaceKeyProvider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private yl1.k<? extends com.tencent.mobileqq.guild.feed.morepanel.f> morePanelHandle;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/cooperate/FeedListPartMorePanelCooperateHelper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0002J0\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J(\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/guild/feed/morepanel/cooperate/FeedListPartMorePanelCooperateHelper$b", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/x;", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "panelContext", "", "e", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "c", "", "id", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements x {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GuildFeedBaseInitBean f220220a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ij1.g f220221b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f220222c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Supplier<Map<String, Object>> f220223d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FragmentManager f220224e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ FeedListPartMorePanelCooperateHelper f220225f;

        b(GuildFeedBaseInitBean guildFeedBaseInitBean, ij1.g gVar, int i3, Supplier<Map<String, Object>> supplier, FragmentManager fragmentManager, FeedListPartMorePanelCooperateHelper feedListPartMorePanelCooperateHelper) {
            this.f220220a = guildFeedBaseInitBean;
            this.f220221b = gVar;
            this.f220222c = i3;
            this.f220223d = supplier;
            this.f220224e = fragmentManager;
            this.f220225f = feedListPartMorePanelCooperateHelper;
        }

        private final boolean e(PanelContext<Activity, vk1.b> panelContext) {
            GuildFeedOptionDialogFragment.Companion companion = GuildFeedOptionDialogFragment.INSTANCE;
            String f16 = av.f223852a.f(this.f220220a.getBusinessType());
            GProStFeed b16 = this.f220221b.b();
            Intrinsics.checkNotNullExpressionValue(b16, "feedBlockData.sourceData");
            GProStFeed gProStFeed = b16;
            GuildFeedBaseInitBean guildFeedBaseInitBean = this.f220220a;
            int i3 = this.f220222c;
            Object obj = this.f220223d.get();
            Intrinsics.checkNotNullExpressionValue(obj, "dtParamSupplier.get()");
            Map<String, ? extends Object> map = (Map) obj;
            FragmentManager fragmentManager = this.f220224e;
            final FeedListPartMorePanelCooperateHelper feedListPartMorePanelCooperateHelper = this.f220225f;
            companion.a(1, f16, gProStFeed, guildFeedBaseInitBean, i3, map, fragmentManager, new com.tencent.mobileqq.guild.feed.feedoption.a() { // from class: com.tencent.mobileqq.guild.feed.morepanel.cooperate.g
                @Override // com.tencent.mobileqq.guild.feed.feedoption.a
                public final void a(String str) {
                    FeedListPartMorePanelCooperateHelper.b.f(FeedListPartMorePanelCooperateHelper.this, str);
                }
            });
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(FeedListPartMorePanelCooperateHelper this$0, String feedId) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            QLog.i("FeedListPartMorePanelCooperateHelper", 1, "[removeDataFormList] feedId:" + feedId);
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            GuildFeedDeleteEvent guildFeedDeleteEvent = new GuildFeedDeleteEvent(feedId, "", "");
            guildFeedDeleteEvent.setNeedReFetchTopFeeds(false);
            co1.d dVar = co1.d.f31167a;
            Object obj = this$0.feedListDataSurfaceKeyProvider.get();
            Intrinsics.checkNotNullExpressionValue(obj, "feedListDataSurfaceKeyProvider.get()");
            guildFeedDeleteEvent.setDataDisplaySurfacePrefixKey(dVar.n((String) obj));
            simpleEventBus.dispatchEvent(guildFeedDeleteEvent);
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
        public boolean a(@NotNull String id5, @NotNull PanelContext<Activity, vk1.b> panelContext) {
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            if (!Intrinsics.areEqual(id5, "not_interested")) {
                return false;
            }
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
            if (item.action != 223) {
                return false;
            }
            shareActionSheet.dismiss();
            return e(panelContext);
        }
    }

    public FeedListPartMorePanelCooperateHelper(@NotNull Part hostPart, @NotNull Supplier<String> feedListDataSurfaceKeyProvider) {
        Intrinsics.checkNotNullParameter(hostPart, "hostPart");
        Intrinsics.checkNotNullParameter(feedListDataSurfaceKeyProvider, "feedListDataSurfaceKeyProvider");
        this.hostPart = hostPart;
        this.feedListDataSurfaceKeyProvider = feedListDataSurfaceKeyProvider;
    }

    private final Bundle e(int position, GuildFeedBaseInitBean initBean, String feedId) {
        initBean.setChannelName(ax.p((xj1.e) RFWIocAbilityProvider.g().getIocInterface(xj1.e.class, this.hostPart.getPartRootView(), null), initBean.getChannelId(), av.f223852a.g(initBean.getBusinessType())));
        Bundle bundle = new Bundle();
        bundle.putSerializable(com.tencent.mobileqq.guild.feed.b.f218115a, initBean);
        bundle.putString("default_select_feed_id", feedId);
        bundle.putInt("default_select_feed_position", position);
        bundle.putString("data_surface_key_feed_list_data", this.feedListDataSurfaceKeyProvider.get());
        bundle.putString("data_surface_key_data_type", "data_type_feed_list");
        bundle.putString("source", "source_from_feed_square");
        return bundle;
    }

    private final b g(int position, ij1.g feedBlockData, GuildFeedBaseInitBean initBean, Supplier<Map<String, Object>> dtParamSupplier, FragmentManager fragmentManager) {
        return new b(initBean, feedBlockData, position, dtParamSupplier, fragmentManager, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GuildFeedPublishInfo i(ij1.g feed) {
        Intrinsics.checkNotNullParameter(feed, "$feed");
        return com.tencent.mobileqq.guild.feed.feedsquare.data.g.b(feed);
    }

    private final void j(com.tencent.mobileqq.guild.feed.morepanel.k launchParam, final GuildFeedBaseInitBean initBean, final int position, final vk1.a feedSourceDataProvider, l feedPublishInfoProvider) {
        PanelContext<Activity, vk1.b> e16 = launchParam.e();
        e16.getExtra().putInt("src_business_type", initBean.getBusinessType());
        Bundle extra = e16.getExtra();
        GuildSharePageSource guildSharePageSource = GuildSharePageSource.FEED_LIST;
        extra.putInt(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, guildSharePageSource.ordinal());
        e16.getExtra().putBoolean("preserve_edit_action", true);
        e16.getExtra().putBoolean("extra_key_is_whole_feed", false);
        e16.getApiRouter().a(FeedMorePanelBusiImpl.OperationListProvider.b.class, new FeedMorePanelBusiImpl.OperationListProvider.b() { // from class: com.tencent.mobileqq.guild.feed.morepanel.cooperate.d
            @Override // com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl.OperationListProvider.b
            public final Bundle a() {
                Bundle k3;
                k3 = FeedListPartMorePanelCooperateHelper.k(FeedListPartMorePanelCooperateHelper.this, position, initBean, feedSourceDataProvider);
                return k3;
            }
        });
        e16.getApiRouter().a(FeedMorePanelBusiImpl.OperationListProvider.e.class, new FeedMorePanelBusiImpl.OperationListProvider.e() { // from class: com.tencent.mobileqq.guild.feed.morepanel.cooperate.e
            @Override // com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl.OperationListProvider.e
            public final boolean a(String str) {
                boolean l3;
                l3 = FeedListPartMorePanelCooperateHelper.l(vk1.a.this, initBean, str);
                return l3;
            }
        });
        e16.getApiRouter().a(FeedMorePanelBusiImpl.OperationListProvider.c.class, new f(initBean));
        e16.getApiRouter().a(com.tencent.mobileqq.guild.feed.morepanel.g.class, new FeedSharePanelReportHelper(feedSourceDataProvider, launchParam.getOperationListProvider(), guildSharePageSource));
        if (feedPublishInfoProvider != null) {
            e16.getApiRouter().a(l.class, feedPublishInfoProvider);
        }
        com.tencent.mobileqq.guild.feed.morepanel.i.c(e16.getApiRouter(), com.tencent.mobileqq.guild.feed.part.a.d(this.hostPart));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle k(FeedListPartMorePanelCooperateHelper this$0, int i3, GuildFeedBaseInitBean initBean, vk1.a feedSourceDataProvider) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(initBean, "$initBean");
        Intrinsics.checkNotNullParameter(feedSourceDataProvider, "$feedSourceDataProvider");
        return this$0.e(i3, initBean, feedSourceDataProvider.getFeedId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l(vk1.a feedSourceDataProvider, GuildFeedBaseInitBean initBean, String it) {
        String str;
        Intrinsics.checkNotNullParameter(feedSourceDataProvider, "$feedSourceDataProvider");
        Intrinsics.checkNotNullParameter(initBean, "$initBean");
        Intrinsics.checkNotNullParameter(it, "it");
        String str2 = "";
        if (!Intrinsics.areEqual(it, "") && !feedSourceDataProvider.B()) {
            yl1.i iVar = yl1.i.f450608a;
            String guildId = initBean.getGuildId();
            if (guildId != null) {
                str2 = guildId;
            }
            Boolean d16 = iVar.d(str2, feedSourceDataProvider.getFeedId(), String.valueOf(feedSourceDataProvider.getChannelId()));
            if (d16 != null) {
                return d16.booleanValue();
            }
            if (feedSourceDataProvider.g() > 0) {
                return true;
            }
        } else {
            yl1.i iVar2 = yl1.i.f450608a;
            String guildId2 = initBean.getGuildId();
            if (guildId2 == null) {
                str = "";
            } else {
                str = guildId2;
            }
            Boolean e16 = yl1.i.e(iVar2, str, feedSourceDataProvider.getFeedId(), null, 4, null);
            if (e16 != null) {
                return e16.booleanValue();
            }
            if (feedSourceDataProvider.getTopTimestamp() > 0) {
                return true;
            }
        }
        return false;
    }

    @Override // zp1.a
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void f(int position, @NotNull final ij1.g feed, @NotNull Supplier<Map<String, Object>> dtParamSupplier, int mediaIndex) {
        Activity activity;
        FragmentActivity fragmentActivity;
        GuildFeedBaseInitBean o16;
        FeedMorePanelBusiImpl.a aVar;
        List<x> c16;
        List<x> a16;
        com.tencent.mobileqq.guild.feed.morepanel.f b16;
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(dtParamSupplier, "dtParamSupplier");
        yl1.k<? extends com.tencent.mobileqq.guild.feed.morepanel.f> kVar = this.morePanelHandle;
        boolean z16 = false;
        if (kVar != null && (b16 = kVar.b()) != null && b16.isShowing()) {
            z16 = true;
        }
        if (z16) {
            QLog.i("FeedListPartMorePanelCooperateHelper", 1, "morePanel is already showing");
            return;
        }
        IPartHost partHost = this.hostPart.getPartHost();
        NewFeedMorePanelBusiImpl.a aVar2 = null;
        if (partHost != null) {
            activity = partHost.getHostActivity();
        } else {
            activity = null;
        }
        if (activity instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) activity;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity == null || (o16 = ax.o(this.hostPart.getHostFragment())) == null) {
            return;
        }
        GProStFeed b17 = feed.b();
        Intrinsics.checkNotNullExpressionValue(b17, "feed.sourceData");
        vk1.a aVar3 = new vk1.a(new GProStFeedDetailRspWrapper(b17, null, 2, null));
        FeedMorePanelLauncher feedMorePanelLauncher = new FeedMorePanelLauncher("pindao_feed");
        com.tencent.mobileqq.guild.feed.morepanel.k e16 = FeedMorePanelLauncher.e(feedMorePanelLauncher, fragmentActivity, aVar3, null, 4, null);
        j(e16, o16, position, aVar3, new l() { // from class: com.tencent.mobileqq.guild.feed.morepanel.cooperate.c
            @Override // com.tencent.mobileqq.guild.feed.morepanel.cooperate.l
            public final GuildFeedPublishInfo provide() {
                GuildFeedPublishInfo i3;
                i3 = FeedListPartMorePanelCooperateHelper.i(ij1.g.this);
                return i3;
            }
        });
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        b g16 = g(position, feed, o16, dtParamSupplier, supportFragmentManager);
        ShareActionSheet.c itemClickListener = e16.getItemClickListener();
        if (itemClickListener instanceof FeedMorePanelBusiImpl.a) {
            aVar = (FeedMorePanelBusiImpl.a) itemClickListener;
        } else {
            aVar = null;
        }
        if (aVar != null && (a16 = aVar.a()) != null) {
            a16.add(g16);
        }
        com.tencent.mobileqq.sharepanel.j newItemClickListener = e16.getNewItemClickListener();
        if (newItemClickListener instanceof NewFeedMorePanelBusiImpl.a) {
            aVar2 = (NewFeedMorePanelBusiImpl.a) newItemClickListener;
        }
        if (aVar2 != null && (c16 = aVar2.c()) != null) {
            c16.add(g16);
        }
        e16.h(new com.tencent.mobileqq.guild.feed.morepanel.impl.d(e16.e()));
        this.morePanelHandle = feedMorePanelLauncher.h();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        this.morePanelHandle = null;
    }
}
