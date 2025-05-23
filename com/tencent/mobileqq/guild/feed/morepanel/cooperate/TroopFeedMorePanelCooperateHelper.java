package com.tencent.mobileqq.guild.feed.morepanel.cooperate;

import android.app.Activity;
import android.app.Dialog;
import androidx.core.util.Supplier;
import androidx.lifecycle.LifecycleObserver;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDeleteEvent;
import com.tencent.mobileqq.guild.feed.event.GuildPublishReEditEvent;
import com.tencent.mobileqq.guild.feed.morepanel.FeedMorePanelLauncher;
import com.tencent.mobileqq.guild.feed.morepanel.FeedSharePanelReportHelper;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.feed.morepanel.handler.t;
import com.tencent.mobileqq.guild.feed.morepanel.handler.x;
import com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl;
import com.tencent.mobileqq.guild.feed.morepanel.impl.NewFeedMorePanelBusiImpl;
import com.tencent.mobileqq.guild.feed.publish.event.GuildPublishSuccessGetFeedEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildTriggerPublishOperationEvent;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl1.g;
import yl1.n;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 G2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005:\u0001HB!\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u00103\u001a\u00020\u0018\u0012\b\b\u0002\u00107\u001a\u000204\u00a2\u0006\u0004\bE\u0010FJ \u0010\u000e\u001a\u00020\r2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u0002`\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001c\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0013\u001a\u00060\u0006j\u0002`\u0007H\u0002J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0006\u0010\u001b\u001a\u00020\u0011J\u0006\u0010\u001c\u001a\u00020\u0011J>\u0010$\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001d2\n\u0010\u0013\u001a\u00060\u0006j\u0002`\u00072\u0018\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020!0 0\u001f2\u0006\u0010#\u001a\u00020\u001dH\u0016J\u001a\u0010'\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010(\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010,\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020*0)j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020*`+H\u0016R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00103\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R \u0010<\u001a\f\u0012\u0006\b\u0001\u0012\u000209\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00106R\u0018\u0010A\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010@R\u001c\u0010D\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bB\u0010C\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/cooperate/TroopFeedMorePanelCooperateHelper;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroidx/lifecycle/LifecycleObserver;", "Lwk1/j;", "Lzp1/a;", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "morePanelContext", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/FeedMorePanelBusiImpl$OperationListProvider;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/feed/morepanel/k;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "", "t", "feed", "p", "Lcom/tencent/mobileqq/guild/feed/event/GuildPublishReEditEvent;", "event", "o", "", "feedId", "l", "r", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "position", "Landroidx/core/util/Supplier;", "", "", "dtParamSupplier", "mediaIndex", ReportConstant.COSTREPORT_PREFIX, "action", "msg", "c", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/richframework/part/Part;", "d", "Lcom/tencent/biz/richframework/part/Part;", "host", "e", "Ljava/lang/String;", "troopUin", "", "f", "Z", "fromImageGallery", "Lyl1/k;", "Lcom/tencent/mobileqq/guild/feed/morepanel/f;", tl.h.F, "Lyl1/k;", "morePanelHandle", "i", "isDestroyed", "Landroid/app/Dialog;", "Landroid/app/Dialog;", "loadingDialog", DomainData.DOMAIN_NAME, "()Lqj1/h;", "servedFeed", "<init>", "(Lcom/tencent/biz/richframework/part/Part;Ljava/lang/String;Z)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TroopFeedMorePanelCooperateHelper implements SimpleEventReceiver<SimpleBaseEvent>, LifecycleObserver, wk1.j, zp1.a<qj1.h> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Part host;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean fromImageGallery;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private yl1.k<? extends com.tencent.mobileqq.guild.feed.morepanel.f> morePanelHandle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isDestroyed;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/guild/feed/morepanel/cooperate/TroopFeedMorePanelCooperateHelper$b", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/FeedMorePanelBusiImpl$OperationListProvider;", "", "isManager", "isAuthor", "isAnnouncement", "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "o", "", "", "p", "f", "b", "()Ljava/util/List;", "secondaryPaths", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends FeedMorePanelBusiImpl.OperationListProvider {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TroopFeedMorePanelCooperateHelper f220237e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(PanelContext<Activity, vk1.b> panelContext, TroopFeedMorePanelCooperateHelper troopFeedMorePanelCooperateHelper) {
            super(panelContext);
            this.f220237e = troopFeedMorePanelCooperateHelper;
        }

        private final List<ShareActionSheetBuilder.ActionSheetItem> o(boolean isManager, boolean isAuthor, boolean isAnnouncement) {
            List<Integer> mutableListOf;
            int[] intArray;
            int i3 = 243;
            if (isManager && !isAuthor) {
                Integer[] numArr = new Integer[2];
                if (!isAnnouncement) {
                    i3 = 242;
                }
                numArr[0] = Integer.valueOf(i3);
                numArr[1] = 40;
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(numArr);
            } else if (isManager) {
                Integer[] numArr2 = new Integer[3];
                numArr2[0] = 94;
                if (!isAnnouncement) {
                    i3 = 242;
                }
                numArr2[1] = Integer.valueOf(i3);
                numArr2[2] = 40;
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(numArr2);
            } else {
                mutableListOf = isAuthor ? CollectionsKt__CollectionsKt.mutableListOf(94, 40) : new ArrayList<>();
            }
            if (!isAuthor) {
                mutableListOf.add(11);
            }
            if (this.f220237e.fromImageGallery) {
                mutableListOf.remove((Object) 94);
                mutableListOf.add(p(mutableListOf) ? 1 : 0, 39);
            }
            intArray = CollectionsKt___CollectionsKt.toIntArray(mutableListOf);
            return c(intArray);
        }

        private final boolean p(List<Integer> list) {
            List listOf;
            Object firstOrNull;
            boolean contains;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{243, 242});
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            contains = CollectionsKt___CollectionsKt.contains(listOf, firstOrNull);
            return contains;
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl.OperationListProvider, com.tencent.mobileqq.guild.feed.morepanel.k.a
        @NotNull
        public List<ShareActionSheetBuilder.ActionSheetItem> b() {
            return new ArrayList();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl.OperationListProvider
        @NotNull
        public List<ShareActionSheetBuilder.ActionSheetItem> f() {
            AppInterface appInterface;
            IRuntimeService iRuntimeService;
            String str;
            boolean z16;
            String r16 = k().j().r();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Boolean bool = null;
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
            } else {
                iRuntimeService = null;
            }
            IGPSService iGPSService = (IGPSService) iRuntimeService;
            if (iGPSService != null) {
                str = iGPSService.getSelfTinyId();
            } else {
                str = null;
            }
            boolean areEqual = Intrinsics.areEqual(r16, str);
            FeedMorePanelBusiImpl.OperationListProvider.e eVar = (FeedMorePanelBusiImpl.OperationListProvider.e) k().getApiRouter().b(FeedMorePanelBusiImpl.OperationListProvider.e.class);
            boolean z17 = false;
            if (eVar != null) {
                z16 = eVar.a("");
            } else {
                z16 = false;
            }
            AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime2 != null) {
                TroopInfo findTroopInfo = ((ITroopInfoService) peekAppRuntime2.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(this.f220237e.troopUin);
                if (findTroopInfo != null) {
                    bool = Boolean.valueOf(findTroopInfo.isOwnerOrAdmin(peekAppRuntime2.getCurrentAccountUin()));
                }
                if (bool != null) {
                    z17 = bool.booleanValue();
                }
            }
            return o(z17, areEqual, z16);
        }
    }

    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J(\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/guild/feed/morepanel/cooperate/TroopFeedMorePanelCooperateHelper$c", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/x;", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "panelContext", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "", "c", "", "id", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements x {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
        public boolean a(@NotNull String id5, @NotNull PanelContext<Activity, vk1.b> panelContext) {
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            if (Intrinsics.areEqual(id5, "save_to_phone")) {
                return new t(TroopFeedMorePanelCooperateHelper.this.host.getPartManager()).a(id5, panelContext);
            }
            return false;
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
            if (item.action == 39) {
                return new t(TroopFeedMorePanelCooperateHelper.this.host.getPartManager()).c(item, panelContext, shareActionSheet);
            }
            return false;
        }
    }

    public TroopFeedMorePanelCooperateHelper(@NotNull Part host, @NotNull String troopUin, boolean z16) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        this.host = host;
        this.troopUin = troopUin;
        this.fromImageGallery = z16;
    }

    private final void l(String feedId) {
        String str;
        qj1.h n3 = n();
        if (n3 != null) {
            str = n3.getFeedId();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(feedId, str) && !this.isDestroyed) {
            GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, this.host.getPartHost().getHostActivity(), false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FeedMorePanelBusiImpl.OperationListProvider m(PanelContext<Activity, vk1.b> morePanelContext) {
        return new b(morePanelContext, this);
    }

    private final qj1.h n() {
        return n.p(this.host);
    }

    private final void o(GuildPublishReEditEvent event) {
        Dialog dialog = this.loadingDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private final void p(com.tencent.mobileqq.guild.feed.morepanel.k launchParam, final qj1.h feed) {
        launchParam.e().getApiRouter().a(FeedMorePanelBusiImpl.OperationListProvider.e.class, new FeedMorePanelBusiImpl.OperationListProvider.e() { // from class: com.tencent.mobileqq.guild.feed.morepanel.cooperate.m
            @Override // com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl.OperationListProvider.e
            public final boolean a(String str) {
                boolean q16;
                q16 = TroopFeedMorePanelCooperateHelper.q(qj1.h.this, str);
                return q16;
            }
        });
        launchParam.e().getApiRouter().a(com.tencent.mobileqq.guild.feed.morepanel.g.class, new FeedSharePanelReportHelper(feed, launchParam.getOperationListProvider(), null, 4, null));
        com.tencent.mobileqq.guild.feed.morepanel.i.c(launchParam.e().getApiRouter(), com.tencent.mobileqq.guild.feed.part.a.d(this.host));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q(qj1.h feed, String it) {
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

    private final void t(com.tencent.mobileqq.guild.feed.morepanel.k launchParam) {
        List<x> c16;
        List<x> a16;
        c cVar = new c();
        FeedMorePanelBusiImpl.a aVar = (FeedMorePanelBusiImpl.a) launchParam.getItemClickListener();
        if (aVar != null && (a16 = aVar.a()) != null) {
            a16.add(cVar);
        }
        NewFeedMorePanelBusiImpl.a aVar2 = (NewFeedMorePanelBusiImpl.a) launchParam.getNewItemClickListener();
        if (aVar2 != null && (c16 = aVar2.c()) != null) {
            c16.add(cVar);
        }
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
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildPublishSuccessGetFeedEvent.class, GuildTriggerPublishOperationEvent.class, GuildPublishReEditEvent.class, GuildFeedDeleteEvent.class);
        Intrinsics.checkNotNull(arrayListOf, "null cannot be cast to non-null type java.util.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>>{ kotlin.collections.TypeAliasesKt.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>> }");
        return arrayListOf;
    }

    public final void onDestroy() {
        this.isDestroyed = true;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.morePanelHandle = null;
        QLog.d("TroopFeedMorePanelCooperateHelper", 4, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        QLog.d("TroopFeedMorePanelCooperateHelper", 1, "onReceiveEvent_event:", event);
        if (event instanceof GuildFeedDeleteEvent) {
            String feedId = ((GuildFeedDeleteEvent) event).getFeedId();
            Intrinsics.checkNotNullExpressionValue(feedId, "event.feedId");
            l(feedId);
        } else if (event instanceof GuildPublishReEditEvent) {
            o((GuildPublishReEditEvent) event);
        }
    }

    public final void r() {
        SimpleEventBus.getInstance().registerReceiver(this);
        this.isDestroyed = false;
    }

    @Override // zp1.a
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void f(int position, @NotNull qj1.h feed, @NotNull Supplier<Map<String, Object>> dtParamSupplier, int mediaIndex) {
        boolean z16;
        com.tencent.mobileqq.guild.feed.morepanel.f b16;
        com.tencent.mobileqq.guild.feed.morepanel.f b17;
        com.tencent.mobileqq.guild.feed.morepanel.f b18;
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(dtParamSupplier, "dtParamSupplier");
        yl1.k<? extends com.tencent.mobileqq.guild.feed.morepanel.f> kVar = this.morePanelHandle;
        if (kVar != null && (b18 = kVar.b()) != null && b18.isShowing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.d("TroopFeedMorePanelCooperateHelper", 1, "morePanel is already showing");
        }
        QLog.d("TroopFeedMorePanelCooperateHelper", 1, "openMorePanel position:", Integer.valueOf(position), " mediaIndex:", Integer.valueOf(mediaIndex));
        FeedMorePanelLauncher feedMorePanelLauncher = new FeedMorePanelLauncher("group_feedimmersion");
        Activity activity = this.host.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "host.activity");
        com.tencent.mobileqq.guild.feed.morepanel.k d16 = feedMorePanelLauncher.d(activity, new vk1.a(feed), new Function2<com.tencent.mobileqq.guild.feed.morepanel.k, PanelContext<Activity, vk1.b>, Unit>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.cooperate.TroopFeedMorePanelCooperateHelper$openMorePanel$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.guild.feed.morepanel.k kVar2, PanelContext<Activity, vk1.b> panelContext) {
                invoke2(kVar2, panelContext);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.mobileqq.guild.feed.morepanel.k buildLaunchParam, @NotNull PanelContext<Activity, vk1.b> it) {
                FeedMorePanelBusiImpl.OperationListProvider m3;
                Intrinsics.checkNotNullParameter(buildLaunchParam, "$this$buildLaunchParam");
                Intrinsics.checkNotNullParameter(it, "it");
                m3 = TroopFeedMorePanelCooperateHelper.this.m(it);
                buildLaunchParam.i(m3);
                buildLaunchParam.f(new FeedMorePanelBusiImpl.a(it));
            }
        });
        d16.e().getExtra().putBoolean("EXTRA_KEY_FINISH_WHEN_FLOAT_WINDOW_OK", false);
        d16.e().getExtra().putInt(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, GuildSharePageSource.FEED_DETAIL.ordinal());
        d16.e().getExtra().putInt("src_business_type", 7);
        p(d16, feed);
        t(d16);
        d16.h(new com.tencent.mobileqq.guild.feed.morepanel.impl.l(d16, this.troopUin, this.fromImageGallery));
        yl1.k<? extends com.tencent.mobileqq.guild.feed.morepanel.f> h16 = feedMorePanelLauncher.h();
        this.morePanelHandle = h16;
        if (h16 != null && (b17 = h16.b()) != null) {
            b17.hideTitle();
        }
        yl1.k<? extends com.tencent.mobileqq.guild.feed.morepanel.f> kVar2 = this.morePanelHandle;
        if (kVar2 != null && (b16 = kVar2.b()) != null) {
            b16.a(false, false, true);
        }
    }

    public /* synthetic */ TroopFeedMorePanelCooperateHelper(Part part, String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(part, str, (i3 & 4) != 0 ? false : z16);
    }
}
