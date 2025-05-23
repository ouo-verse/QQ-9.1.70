package com.tencent.state.square.detail;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.compat.f;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCodeKt;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.event.AddSquareAsyncLocateTo;
import com.tencent.state.map.MapItem;
import com.tencent.state.perf.PerfMonitor;
import com.tencent.state.report.PerformanceReportConst;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.SquarePageBackgroundInfo;
import com.tencent.state.square.EntranceLink;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IRouter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.api.MessageRecordType;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.api.SquareMessageRecord;
import com.tencent.state.square.api.SquareTempMessageRecord;
import com.tencent.state.square.avatar.ISquareAvatarView;
import com.tencent.state.square.data.DressInfo;
import com.tencent.state.square.data.DressInfoResponse;
import com.tencent.state.square.data.DressType;
import com.tencent.state.square.data.QZoneFeedsInfo;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareAvatarExtra;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareAvatarItemKt;
import com.tencent.state.square.data.Stickers;
import com.tencent.state.square.detail.components.DetailFlowerComponent;
import com.tencent.state.square.detail.components.IDetailEventListener;
import com.tencent.state.square.detail.event.DetailGuestAddToSquareResultEvent;
import com.tencent.state.square.detail.event.DetailGuestCloseToMeResultInfoEvent;
import com.tencent.state.square.detail.event.DetailGuestUpdateQZoneFeedsEvent;
import com.tencent.state.square.detail.event.DetailGuestUpdateStickersEvent;
import com.tencent.state.square.detail.event.DetailGuestUpdateTargetResourceEvent;
import com.tencent.state.square.friendsetting.FriendSettingMenuController;
import com.tencent.state.square.interaction.InteractionActionDialog;
import com.tencent.state.square.invite.ISquareInviteManager;
import com.tencent.state.square.resource.SquareResourceManagerKt;
import com.tencent.state.status.SquareStatusViewModel;
import com.tencent.state.utils.BundleParamsUtils;
import com.tencent.state.utils.EventBusUtilsKt;
import com.tencent.state.utils.IEventHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import ne0.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 G2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001GB\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0014J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dH\u0016J\u0014\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0!H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u001eH\u0016J\b\u0010'\u001a\u00020\u0017H\u0016J\b\u0010(\u001a\u00020\u0017H\u0016J\u0012\u0010)\u001a\u00020\u00172\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\u0017H\u0016J\b\u0010-\u001a\u00020\u0017H\u0002J\b\u0010.\u001a\u00020\u0017H\u0016J\u0012\u0010/\u001a\u00020\u00172\b\u00100\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020\u00172\u0006\u00102\u001a\u000205H\u0016J\u001a\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020\u0017H\u0002J\u0010\u0010<\u001a\u00020\u00172\u0006\u0010=\u001a\u00020>H\u0016J\n\u0010?\u001a\u0004\u0018\u00010\u001eH\u0016J\u0018\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020\u001e2\u0006\u0010B\u001a\u00020CH\u0016J\u0018\u0010D\u001a\u00020\u00172\u0006\u0010A\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020FH\u0016R\"\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0094\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR:\u0010\f\u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\u00100\rj\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\u0010`\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006H"}, d2 = {"Lcom/tencent/state/square/detail/DetailSelectGuestFragment;", "Lcom/tencent/state/square/detail/DetailBaseSelectFragment;", "Lcom/tencent/state/square/detail/DetailGuestFragmentConfig;", "Lcom/tencent/state/square/detail/DetailGuestListener;", "()V", "eventBus", "Lcom/tencent/biz/richframework/eventbus/SimpleEventBus;", "kotlin.jvm.PlatformType", "getEventBus", "()Lcom/tencent/biz/richframework/eventbus/SimpleEventBus;", "setEventBus", "(Lcom/tencent/biz/richframework/eventbus/SimpleEventBus;)V", "eventMap", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/state/utils/IEventHandler;", "Lkotlin/collections/HashMap;", "selectedView", "Lcom/tencent/state/square/detail/DetailSelectGuestView;", "shouldHandleDressInfo", "", "afterOnCreateView", "", "endMultiMotion", "getComponents", "", "Lcom/tencent/state/FragmentComponent;", "getDetailCommonPageInfo", "", "", "", "getEventClass", "Ljava/util/ArrayList;", "getFragmentView", "Lcom/tencent/state/square/detail/IDetailParentView;", "getMainScene", "Lcom/tencent/state/square/detail/MainScene;", "getPageId", "goToInteraction", "goToMall", "goToMiniAioChat", "data", "Lcom/tencent/state/map/MapItem;", "initInviteState", "initView", "onDetailBackPressed", "onReceiveEvent", "event", "onTempUnreadMessageNotify", "message", "Lcom/tencent/state/square/api/SquareTempMessageRecord;", "onUnreadMessageNotify", "Lcom/tencent/state/square/api/SquareMessageRecord;", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "openZplanMallIfNeed", "resetTargetAvatar", "resource", "Lcom/tencent/state/square/data/Resource;", "topBarUrl", "updateQZoneFeeds", "uin", "feedsInfo", "Lcom/tencent/state/square/data/QZoneFeedsInfo;", "updateStickers", c.B, "Lcom/tencent/state/square/data/Stickers;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailSelectGuestFragment extends DetailBaseSelectFragment<DetailGuestFragmentConfig> implements DetailGuestListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "DetailSelectGuestFragment";
    private SimpleEventBus eventBus;
    private final HashMap<Class<? extends SimpleBaseEvent>, IEventHandler> eventMap;
    private DetailSelectGuestView selectedView;
    private boolean shouldHandleDressInfo;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/square/detail/DetailSelectGuestFragment$Companion;", "", "()V", "TAG", "", "newInstance", "Lcom/tencent/state/square/detail/DetailSelectGuestFragment;", "data", "Lcom/tencent/state/square/data/SquareAvatarItem;", "source", "Lcom/tencent/state/square/detail/EntranceSource;", DownloadInfo.spKey_Config, "Lcom/tencent/state/square/detail/BaseDetailFragmentConfig;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final DetailSelectGuestFragment newInstance(SquareAvatarItem data, EntranceSource source, BaseDetailFragmentConfig config) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(source, "source");
            DetailSelectGuestFragment detailSelectGuestFragment = new DetailSelectGuestFragment();
            detailSelectGuestFragment.setSquareItem(SquareAvatarItemKt.copyAvatarItem(data));
            detailSelectGuestFragment.setEntranceSource(source);
            if (!(config instanceof DetailGuestFragmentConfig)) {
                config = null;
            }
            detailSelectGuestFragment.setEntranceConfig((DetailGuestFragmentConfig) config);
            return detailSelectGuestFragment;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ DetailSelectGuestFragment newInstance$default(Companion companion, SquareAvatarItem squareAvatarItem, EntranceSource entranceSource, BaseDetailFragmentConfig baseDetailFragmentConfig, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                baseDetailFragmentConfig = null;
            }
            return companion.newInstance(squareAvatarItem, entranceSource, baseDetailFragmentConfig);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DressType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[DressType.PGC.ordinal()] = 1;
            iArr[DressType.PART_UGC.ordinal()] = 2;
            iArr[DressType.UGC.ordinal()] = 3;
        }
    }

    public DetailSelectGuestFragment() {
        HashMap<Class<? extends SimpleBaseEvent>, IEventHandler> hashMap = new HashMap<>();
        EventBusUtilsKt.register(hashMap, DetailGuestCloseToMeResultInfoEvent.class, new Function1<DetailGuestCloseToMeResultInfoEvent, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectGuestFragment$$special$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DetailGuestCloseToMeResultInfoEvent detailGuestCloseToMeResultInfoEvent) {
                invoke2(detailGuestCloseToMeResultInfoEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DetailGuestCloseToMeResultInfoEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                FriendSettingMenuController menuController = DetailSelectGuestFragment.this.getMenuController();
                if (menuController != null) {
                    menuController.doOnGetCloseToMeResultInfo(it);
                }
            }
        });
        EventBusUtilsKt.register(hashMap, DetailGuestAddToSquareResultEvent.class, new Function1<DetailGuestAddToSquareResultEvent, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectGuestFragment$$special$$inlined$apply$lambda$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DetailGuestAddToSquareResultEvent detailGuestAddToSquareResultEvent) {
                invoke2(detailGuestAddToSquareResultEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DetailGuestAddToSquareResultEvent it) {
                SquareAvatarExtra extra;
                Intrinsics.checkNotNullParameter(it, "it");
                String uin = it.getUin();
                SquareAvatarItem squareItem = DetailSelectGuestFragment.this.getSquareItem();
                if (Intrinsics.areEqual(uin, squareItem != null ? squareItem.getUin() : null) && it.getSuccess() && DetailSelectGuestFragment.this.isResumed()) {
                    SquareAvatarItem squareItem2 = DetailSelectGuestFragment.this.getSquareItem();
                    if (squareItem2 != null && (extra = squareItem2.getExtra()) != null) {
                        extra.setInSquare(true);
                    }
                    DetailSelectGuestFragment.this.initView();
                    DetailSelectGuestFragment.this.initInviteState();
                    if (DetailSelectGuestFragment.this.getEntranceSource().getMain() == MainScene.LIBRARY || DetailSelectGuestFragment.this.getEntranceSource().getMain().compareTo(MainScene.SQUARE_CHAT_BLOCK) >= 0) {
                        SimpleEventBus.getInstance().dispatchEvent(new AddSquareAsyncLocateTo(it.getUin()));
                    }
                }
            }
        });
        Unit unit = Unit.INSTANCE;
        this.eventMap = hashMap;
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        simpleEventBus.registerReceiver(this);
        this.eventBus = simpleEventBus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initView() {
        getMenuController().bindSquareView(getSquareItem());
        SquareAvatarItem squareItem = getSquareItem();
        if (squareItem != null) {
            DetailSelectGuestView detailSelectGuestView = this.selectedView;
            if (detailSelectGuestView != null) {
                detailSelectGuestView.initView(getEntranceSource(), squareItem, this);
            }
            ISquareBaseMessageService messageService = getServiceProvider().getMessageService();
            if (messageService != null) {
                ISquareBaseMessageService.DefaultImpls.getSingleUnreadMsg$default(messageService, squareItem.getUin(), false, null, new Function1<SquareBaseMessageRecord, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectGuestFragment$initView$$inlined$let$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SquareBaseMessageRecord squareBaseMessageRecord) {
                        invoke2(squareBaseMessageRecord);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SquareBaseMessageRecord squareBaseMessageRecord) {
                        DetailSelectGuestView detailSelectGuestView2;
                        detailSelectGuestView2 = DetailSelectGuestFragment.this.selectedView;
                        if (detailSelectGuestView2 != null) {
                            detailSelectGuestView2.setUnReadView(squareBaseMessageRecord, true);
                        }
                    }
                }, 6, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openZplanMallIfNeed() {
        Context ctx;
        MutableLiveData<DressInfoResponse> dressInfo;
        if (this.shouldHandleDressInfo) {
            SquareStatusViewModel viewModel = getViewModel();
            DressInfoResponse value = (viewModel == null || (dressInfo = viewModel.getDressInfo()) == null) ? null : dressInfo.getValue();
            final DressInfo dressInfo2 = value != null ? value.getDressInfo() : null;
            if (dressInfo2 != null) {
                String schema = dressInfo2.getSchema();
                if (schema != null) {
                    if ((schema.length() > 0) && (ctx = getContext()) != null) {
                        IRouter squareRouter = SquareBaseKt.getSquareRouter();
                        Intrinsics.checkNotNullExpressionValue(ctx, "ctx");
                        squareRouter.routeLink(ctx, new EntranceLink(dressInfo2.getSchema(), 2));
                        return;
                    }
                }
                final Bundle buildMallBundle = BundleParamsUtils.INSTANCE.buildMallBundle(dressInfo2);
                int i3 = WhenMappings.$EnumSwitchMapping$0[dressInfo2.getType().ordinal()];
                if (i3 == 1) {
                    FragmentActivity activity = getActivity();
                    if (activity != null) {
                        Intrinsics.checkNotNullExpressionValue(activity, "activity ?: return");
                        Square.INSTANCE.getConfig().getRouter().routeToZplanPortal(activity, buildMallBundle, SquareReportConst.SubSource.SQUARE_CUSTOM_PURCHASE_SOURCE);
                        return;
                    }
                    return;
                }
                if (i3 != 2) {
                    if (i3 != 3) {
                        ICommonUtils.DefaultImpls.showToastSafely$default(SquareBaseKt.getSquareCommon(), getContext(), WinkBaseErrorCodeKt.ERROR_MSG_UNKNOWN, 0, 4, null);
                        return;
                    } else {
                        ICommonUtils.DefaultImpls.showToastSafely$default(SquareBaseKt.getSquareCommon(), getContext(), dressInfo2.getMessage(), 0, 4, null);
                        return;
                    }
                }
                Context ctx2 = getContext();
                if (ctx2 != null) {
                    String message = dressInfo2.getMessage();
                    if (message == null) {
                        message = "\u53ef\u80fd\u65e0\u6cd5\u8d2d\u4e70\u5b8c\u6574\u540c\u6b3e";
                    }
                    ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
                    Intrinsics.checkNotNullExpressionValue(ctx2, "ctx");
                    commonUtils.showDialog(ctx2, message, "\u7ee7\u7eed\u8d2d\u4e70", "\u5173\u95ed", (String) null, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectGuestFragment$openZplanMallIfNeed$$inlined$let$lambda$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z16) {
                            FragmentActivity activity2;
                            if (!z16 || (activity2 = this.getActivity()) == null) {
                                return;
                            }
                            Intrinsics.checkNotNullExpressionValue(activity2, "activity ?: return@showDialog");
                            Square.INSTANCE.getConfig().getRouter().routeToZplanPortal(activity2, buildMallBundle, SquareReportConst.SubSource.SQUARE_CUSTOM_PURCHASE_SOURCE);
                        }
                    });
                    return;
                }
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(value != null ? value.getErrorMsg() : null);
            sb5.append('(');
            sb5.append(value != null ? value.getErrorCode() : null);
            sb5.append(')');
            ICommonUtils.DefaultImpls.showToastSafely$default(SquareBaseKt.getSquareCommon(), getContext(), sb5.toString(), 0, 4, null);
        }
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment
    public void afterOnCreateView() {
        initView();
        SquareStatusViewModel viewModel = getViewModel();
        if (viewModel != null) {
            viewModel.getDressInfo().observe(getViewLifecycleOwner(), new Observer<DressInfoResponse>() { // from class: com.tencent.state.square.detail.DetailSelectGuestFragment$afterOnCreateView$$inlined$apply$lambda$1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(DressInfoResponse dressInfoResponse) {
                    SquareBaseKt.getSquareLog().i("DetailSelectGuestFragment", "on dress info loaded");
                    DetailSelectGuestFragment.this.openZplanMallIfNeed();
                }
            });
            SquareAvatarItem squareItem = getSquareItem();
            if (squareItem != null) {
                viewModel.loadDressInfo(Long.parseLong(squareItem.getUin()));
            }
        }
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment
    public void endMultiMotion() {
        DetailSelectGuestView detailSelectGuestView = this.selectedView;
        if (detailSelectGuestView != null) {
            detailSelectGuestView.endMotionClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment, com.tencent.state.VasBaseLifecycleFragment
    public List<FragmentComponent> getComponents() {
        List listOf;
        List<FragmentComponent> plus;
        List<FragmentComponent> components = super.getComponents();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new VasBaseFragmentComponent[]{new PerfMonitor(PerformanceReportConst.Param.EM_SCENE_GUEST_STATUS, new WeakReference(getServiceProvider())), new DetailFlowerComponent()});
        plus = CollectionsKt___CollectionsKt.plus((Collection) components, (Iterable) listOf);
        return plus;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0031, code lost:
    
        if (r2.isMultiAction() == true) goto L10;
     */
    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, Object> getDetailCommonPageInfo() {
        Map<String, Object> detailCommonPageInfo = super.getDetailCommonPageInfo();
        SquareAvatarItem squareItem = getSquareItem();
        if (squareItem != null) {
            detailCommonPageInfo.put("zplan_other_user_qq", squareItem.getUin());
            detailCommonPageInfo.put(SquareReportConst.Key.KEY_IS_SET_TOP, Integer.valueOf(squareItem.getExtra().getIsFixed() ? 1 : 0));
            Resource resource = SquareResourceManagerKt.getResource(squareItem);
            int i3 = resource != null ? 1 : 0;
            detailCommonPageInfo.put("zplan_is_single_or_double_pose", Integer.valueOf(i3));
            detailCommonPageInfo.put(SquareReportConst.Key.KEY_IS_FRIEND, Integer.valueOf(squareItem.getExtra().isFriend() ? 1 : 0));
            EntranceSource entranceSource = getEntranceSource();
            detailCommonPageInfo.put(SquareReportConst.Key.KEY_SOURCE, Integer.valueOf((entranceSource != null ? Integer.valueOf(entranceSource.getReportSourceId()) : null).intValue()));
            detailCommonPageInfo.put(SquareReportConst.Key.KEY_LIKE_PANEL_IS_LIKE, Integer.valueOf(squareItem.getStickers().hasMyLike() ? 1 : 0));
        }
        return detailCommonPageInfo;
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment
    protected SimpleEventBus getEventBus() {
        return this.eventBus;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.addAll(this.eventMap.keySet());
        return arrayList;
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment
    public IDetailParentView getFragmentView() {
        DetailSelectGuestView detailSelectGuestView;
        if (this.selectedView == null) {
            Context it = getContext();
            if (it != null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                detailSelectGuestView = new DetailSelectGuestView(it);
            } else {
                detailSelectGuestView = null;
            }
            this.selectedView = detailSelectGuestView;
        }
        return this.selectedView;
    }

    @Override // com.tencent.state.VasBaseFragment
    public MainScene getMainScene() {
        return getEntranceSource().getMain();
    }

    @Override // com.tencent.state.VasBaseFragment
    public String getPageId() {
        return SquareReportConst.PageId.PAGE_ID_CUSTOM_DETAIL;
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment, com.tencent.state.square.detail.DetailGuestListener
    public void goToInteraction() {
        SquareAvatarItem squareItem = getSquareItem();
        if (squareItem == null || squareItem.isMe()) {
            return;
        }
        InteractionActionDialog.INSTANCE.showActionDialog(new WeakReference<>(this), SquareAvatarItemKt.copyAvatarItem(squareItem), false, new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailSelectGuestFragment$goToInteraction$onShow$1
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
                DetailCommonView commonView;
                ISquareAvatarView avatarView;
                IDetailParentView fragmentView = DetailSelectGuestFragment.this.getFragmentView();
                if (fragmentView == null || (commonView = fragmentView.getCommonView()) == null || (avatarView = commonView.getAvatarView()) == null) {
                    return;
                }
                avatarView.pause();
            }
        }, new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailSelectGuestFragment$goToInteraction$onDismiss$1
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
                DetailCommonView commonView;
                ISquareAvatarView avatarView;
                IDetailParentView fragmentView = DetailSelectGuestFragment.this.getFragmentView();
                if (fragmentView == null || (commonView = fragmentView.getCommonView()) == null || (avatarView = commonView.getAvatarView()) == null) {
                    return;
                }
                avatarView.resume();
            }
        }, 2, getEntranceSource());
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment
    public void initInviteState() {
        ISquareInviteManager inviter;
        SquareAvatarItem squareItem = getSquareItem();
        if (squareItem == null || (inviter = getServiceProvider().getInviter()) == null) {
            return;
        }
        inviter.getInviteStatus(squareItem.getUin(), getGetInviteStatusCallback());
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment
    public void onDetailBackPressed() {
        SquareBaseKt.getSquareLog().d(TAG, "onDetailBackPressed");
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment
    public void onTempUnreadMessageNotify(SquareTempMessageRecord message) {
        DetailSelectGuestView detailSelectGuestView;
        Intrinsics.checkNotNullParameter(message, "message");
        String uin = message.getUin();
        SquareAvatarItem squareItem = getSquareItem();
        if (!Intrinsics.areEqual(uin, squareItem != null ? squareItem.getUin() : null) || (detailSelectGuestView = this.selectedView) == null) {
            return;
        }
        DetailSelectGuestView.setUnReadView$default(detailSelectGuestView, message, false, 2, null);
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment
    public void onUnreadMessageNotify(SquareMessageRecord message) {
        DetailSelectGuestView detailSelectGuestView;
        Intrinsics.checkNotNullParameter(message, "message");
        String uin = message.getUin();
        SquareAvatarItem squareItem = getSquareItem();
        if (!Intrinsics.areEqual(uin, squareItem != null ? squareItem.getUin() : null) || (detailSelectGuestView = this.selectedView) == null) {
            return;
        }
        DetailSelectGuestView.setUnReadView$default(detailSelectGuestView, message, false, 2, null);
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        forEachComponent(IDetailEventListener.class, null, null, new Function1<IDetailEventListener, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectGuestFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IDetailEventListener iDetailEventListener) {
                invoke2(iDetailEventListener);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IDetailEventListener it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onFragmentEnter(DetailSelectGuestFragment.this.getSquareItem());
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    @Override // com.tencent.state.square.detail.DetailGuestListener
    public void resetTargetAvatar(Resource resource) {
        DetailCommonView commonView;
        Intrinsics.checkNotNullParameter(resource, "resource");
        DetailSelectGuestView detailSelectGuestView = this.selectedView;
        if (detailSelectGuestView != null && (commonView = detailSelectGuestView.getCommonView()) != null) {
            commonView.updateAvatar(resource, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectGuestFragment$resetTargetAvatar$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }
            });
        }
        SquareAvatarItem squareItem = getSquareItem();
        if (squareItem != null) {
            getEventBus().dispatchEvent(new DetailGuestUpdateTargetResourceEvent(squareItem.getUin(), resource));
        }
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment
    protected void setEventBus(SimpleEventBus simpleEventBus) {
        this.eventBus = simpleEventBus;
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment
    public String topBarUrl() {
        SquareAvatarExtra extra;
        SquarePageBackgroundInfo detailBackgroundInfo;
        SquareAvatarItem squareItem = getSquareItem();
        if (squareItem == null || (extra = squareItem.getExtra()) == null || (detailBackgroundInfo = extra.getDetailBackgroundInfo()) == null) {
            return null;
        }
        return detailBackgroundInfo.getTopUrl();
    }

    @Override // com.tencent.state.square.detail.DetailGuestListener
    public void updateQZoneFeeds(String uin, QZoneFeedsInfo feedsInfo) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(feedsInfo, "feedsInfo");
        getEventBus().dispatchEvent(new DetailGuestUpdateQZoneFeedsEvent(uin, feedsInfo));
    }

    @Override // com.tencent.state.square.detail.DetailGuestListener
    public void updateStickers(String uin, Stickers stickers) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(stickers, "stickers");
        getEventBus().dispatchEvent(new DetailGuestUpdateStickersEvent(uin, stickers));
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment, com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }

    @Override // com.tencent.state.square.detail.DetailBaseSelectFragment, com.tencent.state.square.detail.DetailCommonListener
    public void goToMall() {
        String uin;
        SquareStatusViewModel viewModel;
        this.shouldHandleDressInfo = true;
        SquareAvatarItem squareItem = getSquareItem();
        if (squareItem == null || (uin = squareItem.getUin()) == null || (viewModel = getViewModel()) == null) {
            return;
        }
        viewModel.loadDressInfo(Long.parseLong(uin));
    }

    @Override // com.tencent.state.square.detail.DetailGuestListener
    public void goToMiniAioChat(MapItem data) {
        ISquareBaseMessageService messageService;
        MessageRecordType messageRecordType;
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) (!(data instanceof SquareAvatarItem) ? null : data);
        if (squareAvatarItem == null) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "squareItem is null", null, 4, null);
            ICommonUtils.DefaultImpls.showToastSafely$default(SquareBaseKt.getSquareCommon(), getContext(), "\u597d\u53cb\u4fe1\u606f\u83b7\u53d6\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0, 4, null);
            return;
        }
        if (getActivity() != null && (messageService = getServiceProvider().getMessageService()) != null) {
            String uin = data.getUin();
            if (squareAvatarItem.getExtra().isStranger()) {
                messageRecordType = MessageRecordType.RECORD_TYPE_SQUARE_TEMP;
            } else {
                messageRecordType = MessageRecordType.RECORD_TYPE_FRIEND;
            }
            ISquareBaseMessageService.DefaultImpls.openMiniMsgAio$default(messageService, this, 0, uin, messageRecordType, true, false, null, ((SquareAvatarItem) data).getNickName(), null, 320, null);
        }
        DetailSelectGuestView detailSelectGuestView = this.selectedView;
        if (detailSelectGuestView != null) {
            DetailSelectGuestView.setUnReadView$default(detailSelectGuestView, null, false, 2, null);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        IEventHandler iEventHandler;
        if (event == null || (iEventHandler = this.eventMap.get(event.getClass())) == null) {
            return;
        }
        iEventHandler.handleEvent(event);
    }
}
