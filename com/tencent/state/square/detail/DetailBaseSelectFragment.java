package com.tencent.state.square.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.f;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseSubFragment;
import com.tencent.state.map.MapItem;
import com.tencent.state.privacy.VasPrivacyFragment;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.SquarePageBackgroundInfo;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.IRouter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareConstants;
import com.tencent.state.square.api.ISquareMusicService;
import com.tencent.state.square.api.MusicChangeListener;
import com.tencent.state.square.api.SongInfo;
import com.tencent.state.square.api.SquareMessageRecord;
import com.tencent.state.square.api.SquareTempMessageRecord;
import com.tencent.state.square.api.p015const.LauncherConst;
import com.tencent.state.square.avatar.ISquareAvatarView;
import com.tencent.state.square.bubblesetting.BubbleSettingSheet;
import com.tencent.state.square.chatland.setting.ChatLandSettingSheet;
import com.tencent.state.square.components.SquareGroupReportComponentKt;
import com.tencent.state.square.components.SquareGroupServiceComponent;
import com.tencent.state.square.components.fragment.SquareServiceProvider;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.SpecialStatus;
import com.tencent.state.square.data.SquareAvatarExtra;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareAvatarItemKt;
import com.tencent.state.square.data.SquareMultiMotionDetailData;
import com.tencent.state.square.databinding.VasSquareFragmentBinding;
import com.tencent.state.square.detail.BaseDetailFragmentConfig;
import com.tencent.state.square.detail.components.DetailFragReportComponent;
import com.tencent.state.square.detail.event.DetailCommonBackEvent;
import com.tencent.state.square.detail.event.DetailScaledAvatarVisibleEvent;
import com.tencent.state.square.feeds.SquareQZoneFeedsManager;
import com.tencent.state.square.friendsetting.FriendSettingMenuController;
import com.tencent.state.square.media.MapPlayableSource;
import com.tencent.state.square.resource.SquareResourceManagerKt;
import com.tencent.state.status.SquareStatusViewModel;
import com.tencent.state.status.SquareStatusViewModelFactory;
import com.tencent.state.utils.BackgroundUtils;
import com.tencent.state.view.OnlineStatusBubbleViewHelper;
import com.tencent.state.view.SquareImageView;
import cooperation.qzone.QzoneIPCModule;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import ne0.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00f2\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\b\u0012\u0004\u0012\u00020\u00070\u0006B\u0005\u00a2\u0006\u0002\u0010\bJ\b\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020CH\u0002J\b\u0010E\u001a\u00020CH\u0016J\u0014\u0010F\u001a\u00020C2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010HH\u0014J&\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010N2\b\u0010O\u001a\u0004\u0018\u00010HH\u0014J\b\u0010P\u001a\u00020CH\u0016J\u000e\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0RH\u0014J\u0014\u0010T\u001a\u000e\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020W0UH\u0016J\n\u0010X\u001a\u0004\u0018\u00010YH\u0016J\b\u0010Z\u001a\u0004\u0018\u00010VJ\b\u0010[\u001a\u00020CH\u0016J\b\u0010\\\u001a\u00020CH\u0016J\u001a\u0010]\u001a\u00020C2\u0006\u0010^\u001a\u00020J2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\b\u0010a\u001a\u00020CH\u0016J\b\u0010b\u001a\u00020CH\u0016J\b\u0010c\u001a\u00020CH\u0002J\b\u0010d\u001a\u00020CH\u0002J\b\u0010e\u001a\u00020CH\u0016J\b\u0010f\u001a\u00020CH\u0016J\u0018\u0010g\u001a\u00020&2\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020&H\u0016J\b\u0010k\u001a\u00020&H\u0014J\"\u0010l\u001a\u00020C2\u0006\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020n2\b\u0010_\u001a\u0004\u0018\u00010pH\u0016J\b\u0010q\u001a\u00020CH\u0016J\b\u0010r\u001a\u00020&H\u0016J\b\u0010s\u001a\u00020CH\u0002J&\u0010s\u001a\u0004\u0018\u00010J2\u0006\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010N2\b\u0010O\u001a\u0004\u0018\u00010HH\u0007J\b\u0010t\u001a\u00020CH\u0016J\b\u0010u\u001a\u00020CH\u0016J\u0010\u0010v\u001a\u00020C2\u0006\u0010w\u001a\u00020\"H\u0014J\b\u0010x\u001a\u00020CH\u0016J\u001a\u0010y\u001a\u00020C2\u0006\u0010z\u001a\u00020V2\b\u0010{\u001a\u0004\u0018\u00010|H\u0016J\u0010\u0010}\u001a\u00020C2\u0006\u0010~\u001a\u00020VH\u0016J\b\u0010\u007f\u001a\u00020CH\u0016J\t\u0010\u0080\u0001\u001a\u00020CH\u0016J\t\u0010\u0081\u0001\u001a\u00020CH\u0016J\u0013\u0010\u0082\u0001\u001a\u00020C2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016J\u0013\u0010\u0085\u0001\u001a\u00020C2\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0016J\u001b\u0010\u0088\u0001\u001a\u00020C2\u0007\u0010\u0089\u0001\u001a\u00020&2\u0007\u0010\u008a\u0001\u001a\u00020VH\u0014J\t\u0010\u008b\u0001\u001a\u00020CH\u0002J\u000b\u0010\u008c\u0001\u001a\u0004\u0018\u00010VH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0004\u0018\u00018\u0000X\u0084\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u0012X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018X\u0094\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020(X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001d\u0010+\u001a\u0004\u0018\u00010,8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b-\u0010.R\u001b\u00101\u001a\u0002028DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00100\u001a\u0004\b3\u00104R\u001c\u00106\u001a\u0004\u0018\u000107X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u00010=X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A\u00a8\u0006\u008d\u0001"}, d2 = {"Lcom/tencent/state/square/detail/DetailBaseSelectFragment;", "T", "Lcom/tencent/state/square/detail/BaseDetailFragmentConfig;", "Lcom/tencent/state/VasBaseSubFragment;", "Lcom/tencent/state/square/detail/DetailCommonListener;", "Lcom/tencent/state/square/api/MusicChangeListener;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentBinding;", "entranceConfig", "getEntranceConfig", "()Lcom/tencent/state/square/detail/BaseDetailFragmentConfig;", "setEntranceConfig", "(Lcom/tencent/state/square/detail/BaseDetailFragmentConfig;)V", "Lcom/tencent/state/square/detail/BaseDetailFragmentConfig;", "entranceSource", "Lcom/tencent/state/square/detail/EntranceSource;", "getEntranceSource", "()Lcom/tencent/state/square/detail/EntranceSource;", "setEntranceSource", "(Lcom/tencent/state/square/detail/EntranceSource;)V", "eventBus", "Lcom/tencent/biz/richframework/eventbus/SimpleEventBus;", "kotlin.jvm.PlatformType", "getEventBus", "()Lcom/tencent/biz/richframework/eventbus/SimpleEventBus;", "setEventBus", "(Lcom/tencent/biz/richframework/eventbus/SimpleEventBus;)V", "fromPause", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getInviteStatusCallback", "Lcom/tencent/state/service/ResultCallback;", "Lcom/tencent/state/square/data/SquareMultiMotionDetailData;", "getGetInviteStatusCallback", "()Lcom/tencent/state/service/ResultCallback;", "isDestroy", "", "menuController", "Lcom/tencent/state/square/friendsetting/FriendSettingMenuController;", "getMenuController", "()Lcom/tencent/state/square/friendsetting/FriendSettingMenuController;", "messageServiceProxy", "Lcom/tencent/state/square/components/SquareGroupServiceComponent;", "getMessageServiceProxy", "()Lcom/tencent/state/square/components/SquareGroupServiceComponent;", "messageServiceProxy$delegate", "Lkotlin/Lazy;", "serviceProvider", "Lcom/tencent/state/square/components/fragment/SquareServiceProvider;", "getServiceProvider", "()Lcom/tencent/state/square/components/fragment/SquareServiceProvider;", "serviceProvider$delegate", "squareItem", "Lcom/tencent/state/square/data/SquareAvatarItem;", "getSquareItem", "()Lcom/tencent/state/square/data/SquareAvatarItem;", "setSquareItem", "(Lcom/tencent/state/square/data/SquareAvatarItem;)V", "viewModel", "Lcom/tencent/state/status/SquareStatusViewModel;", "getViewModel", "()Lcom/tencent/state/status/SquareStatusViewModel;", "setViewModel", "(Lcom/tencent/state/status/SquareStatusViewModel;)V", "afterOnCreateView", "", "bindPageInfo", "checkAndDoSchemeAction", "doBackToSquare", "bundle", "Landroid/os/Bundle;", "doOnCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "endMultiMotion", "getComponents", "", "Lcom/tencent/state/FragmentComponent;", "getDetailCommonPageInfo", "", "", "", "getFragmentView", "Lcom/tencent/state/square/detail/IDetailParentView;", "getUin", "goToInteraction", "goToMall", "goToProfile", "view", "data", "Lcom/tencent/state/map/MapItem;", "goToSmallHome", "hideSquareAvatar", "initCommonInviteState", "initCommonService", "initInviteState", "initService", "isClickAvatar", "e", "Landroid/view/MotionEvent;", "isEditor", "needTouch", "onActivityResult", "requestCode", "", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "onBackClick", "onBackPressed", "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onDetailBackPressed", "onGetInviteDetail", "detail", "onMenuClick", "onMusicInfoChange", "uin", "songInfo", "Lcom/tencent/state/square/api/SongInfo;", "onMusicPlayStateChange", "songMid", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "onSharePosterClick", "onTempUnreadMessageNotify", "messageRecord", "Lcom/tencent/state/square/api/SquareTempMessageRecord;", "onUnreadMessageNotify", "message", "Lcom/tencent/state/square/api/SquareMessageRecord;", "onVisibilityChanged", "isVisible", "from", "refreshBackground", "topBarUrl", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class DetailBaseSelectFragment<T extends BaseDetailFragmentConfig> extends VasBaseSubFragment implements DetailCommonListener, MusicChangeListener, SimpleEventReceiver<SimpleBaseEvent> {
    private VasSquareFragmentBinding binding;
    private T entranceConfig;
    private EntranceSource entranceSource = new EntranceSource(null, null, null, 7, null);
    private SimpleEventBus eventBus = SimpleEventBus.getInstance();
    private AtomicBoolean fromPause = new AtomicBoolean(false);
    private final ResultCallback<SquareMultiMotionDetailData> getInviteStatusCallback;
    private boolean isDestroy;
    private final FriendSettingMenuController menuController;

    /* renamed from: messageServiceProxy$delegate, reason: from kotlin metadata */
    private final Lazy messageServiceProxy;

    /* renamed from: serviceProvider$delegate, reason: from kotlin metadata */
    private final Lazy serviceProvider;
    private SquareAvatarItem squareItem;
    private SquareStatusViewModel viewModel;

    public DetailBaseSelectFragment() {
        Lazy lazy;
        Lazy lazy2;
        FriendSettingMenuController friendSettingMenuController = new FriendSettingMenuController();
        friendSettingMenuController.setHideCallback(new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailBaseSelectFragment$$special$$inlined$apply$lambda$1
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
                DetailBaseSelectFragment.doBackToSquare$default(DetailBaseSelectFragment.this, null, 1, null);
            }
        });
        friendSettingMenuController.setEndMultiMotionCallback(new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailBaseSelectFragment$$special$$inlined$apply$lambda$2
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
                DetailBaseSelectFragment.this.endMultiMotion();
            }
        });
        friendSettingMenuController.setPrivacyClickCallback(new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailBaseSelectFragment$$special$$inlined$apply$lambda$3
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
                DetailBaseSelectFragment.this.pushFragment(VasPrivacyFragment.INSTANCE.newInstance());
            }
        });
        friendSettingMenuController.setInteractionClickCallback(new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailBaseSelectFragment$$special$$inlined$apply$lambda$4
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
                DetailBaseSelectFragment.this.goToInteraction();
            }
        });
        friendSettingMenuController.setBubbleSettingCallback(new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailBaseSelectFragment$$special$$inlined$apply$lambda$5
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
                Map<String, Object> mutableMapOf;
                Context it = DetailBaseSelectFragment.this.getContext();
                if (it != null) {
                    IReporter squareReporter = SquareBaseKt.getSquareReporter();
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "click"));
                    squareReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_ZPLAN_BUBBLE_SETTING_BUTTON, mutableMapOf);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    new BubbleSettingSheet(it).show();
                }
            }
        });
        friendSettingMenuController.setFocusEffectsSettingCallback(new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailBaseSelectFragment$$special$$inlined$apply$lambda$6
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
                Context it = DetailBaseSelectFragment.this.getContext();
                if (it != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    new ChatLandSettingSheet(it, 0).show();
                }
            }
        });
        Unit unit = Unit.INSTANCE;
        this.menuController = friendSettingMenuController;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SquareGroupServiceComponent>() { // from class: com.tencent.state.square.detail.DetailBaseSelectFragment$messageServiceProxy$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SquareGroupServiceComponent invoke() {
                if (DetailBaseSelectFragment.this.getEntranceSource().fromSquare()) {
                    return null;
                }
                SquareGroupServiceComponent squareGroupServiceComponent = new SquareGroupServiceComponent();
                squareGroupServiceComponent.onFragmentPreCreated(DetailBaseSelectFragment.this.getFragmentManager(), DetailBaseSelectFragment.this, null);
                return squareGroupServiceComponent;
            }
        });
        this.messageServiceProxy = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<SquareServiceProvider>() { // from class: com.tencent.state.square.detail.DetailBaseSelectFragment$serviceProvider$2

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "Lcom/tencent/state/square/detail/BaseDetailFragmentConfig;", "p1", "Lcom/tencent/state/square/api/SquareMessageRecord;", "invoke"}, k = 3, mv = {1, 4, 1})
            /* renamed from: com.tencent.state.square.detail.DetailBaseSelectFragment$serviceProvider$2$1, reason: invalid class name */
            /* loaded from: classes38.dex */
            public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<SquareMessageRecord, Unit> {
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SquareMessageRecord squareMessageRecord) {
                    invoke2(squareMessageRecord);
                    return Unit.INSTANCE;
                }

                AnonymousClass1(DetailBaseSelectFragment detailBaseSelectFragment) {
                    super(1, detailBaseSelectFragment, DetailBaseSelectFragment.class, "onUnreadMessageNotify", "onUnreadMessageNotify(Lcom/tencent/state/square/api/SquareMessageRecord;)V", 0);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SquareMessageRecord p16) {
                    Intrinsics.checkNotNullParameter(p16, "p1");
                    ((DetailBaseSelectFragment) this.receiver).onUnreadMessageNotify(p16);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "Lcom/tencent/state/square/detail/BaseDetailFragmentConfig;", "p1", "Lcom/tencent/state/square/api/SquareTempMessageRecord;", "invoke"}, k = 3, mv = {1, 4, 1})
            /* renamed from: com.tencent.state.square.detail.DetailBaseSelectFragment$serviceProvider$2$2, reason: invalid class name */
            /* loaded from: classes38.dex */
            public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<SquareTempMessageRecord, Unit> {
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SquareTempMessageRecord squareTempMessageRecord) {
                    invoke2(squareTempMessageRecord);
                    return Unit.INSTANCE;
                }

                AnonymousClass2(DetailBaseSelectFragment detailBaseSelectFragment) {
                    super(1, detailBaseSelectFragment, DetailBaseSelectFragment.class, "onTempUnreadMessageNotify", "onTempUnreadMessageNotify(Lcom/tencent/state/square/api/SquareTempMessageRecord;)V", 0);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SquareTempMessageRecord p16) {
                    Intrinsics.checkNotNullParameter(p16, "p1");
                    ((DetailBaseSelectFragment) this.receiver).onTempUnreadMessageNotify(p16);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SquareServiceProvider invoke() {
                return new SquareServiceProvider(DetailBaseSelectFragment.this.getMessageServiceProxy(), new AnonymousClass1(DetailBaseSelectFragment.this), new AnonymousClass2(DetailBaseSelectFragment.this), null, 8, null);
            }
        });
        this.serviceProvider = lazy2;
        this.getInviteStatusCallback = new ResultCallback<SquareMultiMotionDetailData>() { // from class: com.tencent.state.square.detail.DetailBaseSelectFragment$getInviteStatusCallback$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(SquareMultiMotionDetailData result) {
                Intrinsics.checkNotNullParameter(result, "result");
                DetailBaseSelectFragment.this.onGetInviteDetail(result);
            }
        };
    }

    private final void bindPageInfo() {
        FrameLayout mRv;
        String str;
        VasSquareFragmentBinding vasSquareFragmentBinding = this.binding;
        if (vasSquareFragmentBinding == null || (mRv = vasSquareFragmentBinding.getMRv()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(mRv, "binding?.root ?: return");
        Map<String, Object> detailCommonPageInfo = getDetailCommonPageInfo();
        IReporter reporter = Square.INSTANCE.getConfig().getReporter();
        SquareAvatarItem squareAvatarItem = this.squareItem;
        if (squareAvatarItem != null && squareAvatarItem.isMe()) {
            str = SquareReportConst.PageId.PAGE_ID_HOST_DETAIL;
        } else {
            str = SquareReportConst.PageId.PAGE_ID_CUSTOM_DETAIL;
        }
        reporter.setPageInfo(this, mRv, str, detailCommonPageInfo);
        this.menuController.setPageInfo(detailCommonPageInfo);
    }

    private final void initCommonInviteState() {
        initInviteState();
    }

    private final void initCommonService() {
        ISquareMusicService musicService = getServiceProvider().getMusicService();
        if (musicService != null) {
            musicService.addMusicChangeListener(this);
        }
        initService();
    }

    private final void refreshBackground() {
        SquareAvatarExtra extra;
        SquarePageBackgroundInfo detailBackgroundInfo;
        SquareImageView squareImageView;
        T t16;
        SquareImageView squareImageView2;
        T t17;
        SquareImageView squareImageView3;
        if (this.entranceSource.fromSquare() && (t17 = this.entranceConfig) != null && !t17.getUserDefaultBg()) {
            VasSquareFragmentBinding vasSquareFragmentBinding = this.binding;
            if (vasSquareFragmentBinding == null || (squareImageView3 = vasSquareFragmentBinding.background) == null) {
                return;
            }
            squareImageView3.setVisibility(8);
            return;
        }
        if (!this.entranceSource.fromSquare() && (t16 = this.entranceConfig) != null && t16.getEnterWithScaleAnim()) {
            VasSquareFragmentBinding vasSquareFragmentBinding2 = this.binding;
            if (vasSquareFragmentBinding2 == null || (squareImageView2 = vasSquareFragmentBinding2.background) == null) {
                return;
            }
            squareImageView2.setVisibility(8);
            return;
        }
        VasSquareFragmentBinding vasSquareFragmentBinding3 = this.binding;
        if (vasSquareFragmentBinding3 != null && (squareImageView = vasSquareFragmentBinding3.background) != null) {
            squareImageView.setVisibility(0);
        }
        BackgroundUtils backgroundUtils = BackgroundUtils.INSTANCE;
        VasSquareFragmentBinding vasSquareFragmentBinding4 = this.binding;
        backgroundUtils.setBackgroundGradientColor(vasSquareFragmentBinding4 != null ? vasSquareFragmentBinding4.background : null, backgroundUtils.getDefaultGradient());
        SquareAvatarItem squareAvatarItem = this.squareItem;
        if (squareAvatarItem == null || (extra = squareAvatarItem.getExtra()) == null || (detailBackgroundInfo = extra.getDetailBackgroundInfo()) == null) {
            return;
        }
        VasSquareFragmentBinding vasSquareFragmentBinding5 = this.binding;
        BackgroundUtils.setBkgImage$default(backgroundUtils, vasSquareFragmentBinding5 != null ? vasSquareFragmentBinding5.background : null, detailBackgroundInfo.getBackgroundUrl(), false, 4, null);
        VasSquareFragmentBinding vasSquareFragmentBinding6 = this.binding;
        backgroundUtils.setBackgroundGradientColor(vasSquareFragmentBinding6 != null ? vasSquareFragmentBinding6.background : null, detailBackgroundInfo.getGradientArr());
    }

    public void checkAndDoSchemeAction() {
        final T t16 = this.entranceConfig;
        if (t16 != null) {
            SquareBaseKt.getSquareThread().postOnUiDelayed(t16.getEnterWithScaleAnim() ? 500L : 0L, new Function0<Unit>() { // from class: com.tencent.state.square.detail.DetailBaseSelectFragment$checkAndDoSchemeAction$$inlined$let$lambda$1
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
                    Integer playPagLikeType = BaseDetailFragmentConfig.this.getPlayPagLikeType();
                    if (playPagLikeType != null) {
                        int intValue = playPagLikeType.intValue();
                        IDetailParentView fragmentView = this.getFragmentView();
                        if (fragmentView != null) {
                            fragmentView.playLikeAnimation(intValue);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doBackToSquare(Bundle bundle) {
        T t16;
        if (!isTopFragment()) {
            SquareBaseKt.getSquareLog().i(QBaseFragment.TAG, "[SquareScaleDetail] doBackToSquare not top fragment");
            return;
        }
        if (this.isDestroy) {
            return;
        }
        this.isDestroy = true;
        if ((this.entranceSource.fromSquare() || this.entranceSource.fromChatLandSquare()) && (t16 = this.entranceConfig) != null && t16.getEnterWithScaleAnim()) {
            getEventBus().dispatchEvent(new DetailScaledAvatarVisibleEvent(true));
        }
        onDetailBackPressed();
        SquareAvatarItem squareAvatarItem = this.squareItem;
        if (squareAvatarItem != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt(SquareConstants.DETAIL_FRAGMENT_HASH, hashCode());
            T t17 = this.entranceConfig;
            bundle.putBoolean(SquareConstants.ENTER_WITH_SCALE_ANIM, t17 != null && t17.getEnterWithScaleAnim());
            bundle.putBoolean(SquareConstants.DETAIL_OPEN_IS_ME, squareAvatarItem.isMe());
            SimpleEventBus eventBus = getEventBus();
            if (eventBus != null) {
                eventBus.dispatchEvent(new DetailCommonBackEvent(bundle));
            }
            popFragment(this);
        }
        this.menuController.onBackToSquare();
    }

    protected View doOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FrameLayout frameLayout;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context it = getContext();
        if (it != null) {
            ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            commonUtils.setStandardFont(it);
        }
        VasSquareFragmentBinding inflate = VasSquareFragmentBinding.inflate(inflater);
        this.binding = inflate;
        if (inflate != null && (frameLayout = inflate.fragment) != null) {
            IDetailParentView fragmentView = getFragmentView();
            frameLayout.addView(fragmentView != null ? fragmentView.getView() : null);
        }
        bindPageInfo();
        onCreateView();
        BackgroundUtils backgroundUtils = BackgroundUtils.INSTANCE;
        VasSquareFragmentBinding vasSquareFragmentBinding = this.binding;
        backgroundUtils.updateTopBarBkg(vasSquareFragmentBinding != null ? vasSquareFragmentBinding.topBar : null, topBarUrl());
        VasSquareFragmentBinding vasSquareFragmentBinding2 = this.binding;
        if (vasSquareFragmentBinding2 != null) {
            return vasSquareFragmentBinding2.getMRv();
        }
        return null;
    }

    public Map<String, Object> getDetailCommonPageInfo() {
        String sourceFrom;
        Map<String, Object> mutableMapOf;
        SquareAvatarItem squareAvatarItem = this.squareItem;
        if (squareAvatarItem != null) {
            if (!Intrinsics.areEqual(SquareGroupReportComponentKt.getSourceFrom(getActivity()), "em_zplan_square_blind_box")) {
                if (!Intrinsics.areEqual(SquareGroupReportComponentKt.getSourceFrom(getActivity()), LauncherConst.SQUARE_SOURCE_QQ_PORTAL) && !Intrinsics.areEqual(SquareGroupReportComponentKt.getSourceFrom(getActivity()), LauncherConst.SQUARE_SOURCE_FESTIVAL)) {
                    if (this.entranceSource.getSub() == SubScene.SQUARE_AVATAR) {
                        sourceFrom = SquareReportConst.Param.EM_STATE_AVATAR;
                    } else {
                        sourceFrom = SquareReportConst.Param.EM_STATE_BUBBLE;
                    }
                } else {
                    sourceFrom = SquareGroupReportComponentKt.getSourceFrom(getActivity());
                }
            } else {
                sourceFrom = SquareGroupReportComponentKt.getSourceFrom(getActivity());
            }
            Pair[] pairArr = new Pair[5];
            OnlineStatus onlineStatus = squareAvatarItem.getExtra().getOnlineStatus();
            pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_STATE_ID, Integer.valueOf(onlineStatus != null ? onlineStatus.getTopStatusId() : 0));
            Integer richStatusId = SquareResourceManagerKt.getRichStatusId(squareAvatarItem);
            pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_RICH_STATE_ID, Integer.valueOf(richStatusId != null ? richStatusId.intValue() : 0));
            OnlineStatus onlineStatus2 = squareAvatarItem.getExtra().getOnlineStatus();
            String customText = onlineStatus2 != null ? onlineStatus2.getCustomText() : null;
            pairArr[2] = TuplesKt.to(SquareReportConst.Key.KEY_IS_SET_CUSTOMIZE_TEXT, Integer.valueOf(1 ^ ((customText == null || customText.length() == 0) ? 1 : 0)));
            OnlineStatusBubbleViewHelper onlineStatusBubbleViewHelper = OnlineStatusBubbleViewHelper.INSTANCE;
            OnlineStatus onlineStatus3 = squareAvatarItem.getExtra().getOnlineStatus();
            pairArr[3] = TuplesKt.to(SquareReportConst.Key.KEY_CUSTOMIZE_TEXT_NUM, Integer.valueOf(onlineStatusBubbleViewHelper.getEditTextLength(onlineStatus3 != null ? onlineStatus3.getCustomText() : null)));
            pairArr[4] = TuplesKt.to(SquareReportConst.Key.KEY_DETAIL_ENTRANCE_SOURCE, sourceFrom);
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            return mutableMapOf;
        }
        return new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final T getEntranceConfig() {
        return this.entranceConfig;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final EntranceSource getEntranceSource() {
        return this.entranceSource;
    }

    protected SimpleEventBus getEventBus() {
        return this.eventBus;
    }

    public IDetailParentView getFragmentView() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ResultCallback<SquareMultiMotionDetailData> getGetInviteStatusCallback() {
        return this.getInviteStatusCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final FriendSettingMenuController getMenuController() {
        return this.menuController;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SquareGroupServiceComponent getMessageServiceProxy() {
        return (SquareGroupServiceComponent) this.messageServiceProxy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SquareServiceProvider getServiceProvider() {
        return (SquareServiceProvider) this.serviceProvider.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SquareAvatarItem getSquareItem() {
        return this.squareItem;
    }

    public final String getUin() {
        SquareAvatarItem squareAvatarItem = this.squareItem;
        if (squareAvatarItem != null) {
            return squareAvatarItem.getUin();
        }
        return null;
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.state.square.detail.DetailCommonListener
    public void goToProfile(View view, MapItem data) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(data instanceof SquareAvatarItem)) {
            data = null;
        }
        SquareAvatarItem squareAvatarItem = (SquareAvatarItem) data;
        if (squareAvatarItem != null) {
            Square square = Square.INSTANCE;
            square.getConfig().getReporter().reportEvent("clck", view, new LinkedHashMap());
            Context it = getContext();
            if (it != null) {
                IRouter router = square.getConfig().getRouter();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                router.routeToProfilePage(it, squareAvatarItem.isMe(), squareAvatarItem.getUin());
            }
        }
    }

    @Override // com.tencent.state.square.detail.DetailCommonListener
    public void goToSmallHome() {
        FragmentActivity it12;
        SquareAvatarItem squareAvatarItem = this.squareItem;
        if (squareAvatarItem == null || (it12 = getActivity()) == null) {
            return;
        }
        IRouter router = Square.INSTANCE.getConfig().getRouter();
        Intrinsics.checkNotNullExpressionValue(it12, "it1");
        router.routeToSmallHomeTransition(it12, squareAvatarItem.getUin());
    }

    @Override // com.tencent.state.square.detail.DetailCommonListener
    public void hideSquareAvatar() {
        T t16;
        SquareBaseKt.getSquareLog().i(QBaseFragment.TAG, "[SquareScaleDetail] hideSquareAvatar");
        if ((this.entranceSource.fromSquare() || this.entranceSource.fromChatLandSquare()) && (t16 = this.entranceConfig) != null && t16.getEnterWithScaleAnim()) {
            SquareBaseKt.getSquareLog().i(QBaseFragment.TAG, "[SquareScaleDetail] doHideSquareAvatar");
            getEventBus().dispatchEvent(new DetailScaledAvatarVisibleEvent(false));
        }
    }

    @Override // com.tencent.state.square.detail.DetailCommonListener
    public boolean isClickAvatar(MotionEvent e16, boolean isEditor) {
        DetailCommonView commonView;
        Intrinsics.checkNotNullParameter(e16, "e");
        IDetailParentView fragmentView = getFragmentView();
        return (fragmentView == null || (commonView = fragmentView.getCommonView()) == null || !commonView.isClickAvatar(e16, isEditor)) ? false : true;
    }

    protected boolean needTouch() {
        return false;
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        SquareBaseKt.getSquareLog().d(QBaseFragment.TAG, "onActivityResult");
        super.onActivityResult(requestCode, resultCode, data);
        SquareGroupServiceComponent messageServiceProxy = getMessageServiceProxy();
        if (messageServiceProxy != null) {
            SquareBaseKt.getSquareLog().d(QBaseFragment.TAG, "onActivityResult proxy");
            messageServiceProxy.doOnActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.state.VasBaseFragment
    public boolean onBackPressed() {
        super.onBackPressed();
        doBackToSquare$default(this, null, 1, null);
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View doOnCreateView = doOnCreateView(inflater, container, savedInstanceState);
        refreshBackground();
        if (needTouch() && doOnCreateView != null) {
            doOnCreateView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.state.square.detail.DetailBaseSelectFragment$onCreateView$1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    DetailBaseSelectFragment.this.onBackPressed();
                    return false;
                }
            });
        }
        return doOnCreateView;
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Context it = getContext();
        if (it != null) {
            ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            commonUtils.unSetStandardFont(it);
        }
        ISquareMusicService musicService = getServiceProvider().getMusicService();
        if (musicService != null) {
            musicService.removeMusicChangeListener(this);
        }
        SquareGroupServiceComponent messageServiceProxy = getMessageServiceProxy();
        if (!(messageServiceProxy instanceof SquareGroupServiceComponent)) {
            messageServiceProxy = null;
        }
        if (messageServiceProxy != null) {
            messageServiceProxy.onFragmentDestroyed(getFragmentManager(), this);
        }
        DetailFragmentLauncher.INSTANCE.trySyncCloseActivityIfNeeded(getActivity(), getGroupFragment(), "back");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetInviteDetail(SquareMultiMotionDetailData detail) {
        Intrinsics.checkNotNullParameter(detail, "detail");
        IDetailParentView fragmentView = getFragmentView();
        if (fragmentView != null) {
            fragmentView.onInviteStateChanged(detail);
        }
    }

    @Override // com.tencent.state.square.detail.DetailCommonListener
    public void onMenuClick() {
        IDetailParentView fragmentView = getFragmentView();
        if (fragmentView != null) {
            fragmentView.onMenuClick();
        }
        Context context = getContext();
        if (context != null) {
            FriendSettingMenuController friendSettingMenuController = this.menuController;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            friendSettingMenuController.showMenu(context);
        }
    }

    @Override // com.tencent.state.square.api.MusicChangeListener
    public void onMusicInfoChange(String uin, SongInfo songInfo) {
        IDetailParentView fragmentView;
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareAvatarItem squareAvatarItem = this.squareItem;
        if (!(!Intrinsics.areEqual(uin, squareAvatarItem != null ? squareAvatarItem.getUin() : null)) && SquareAvatarItemKt.isMusicStatus(squareAvatarItem)) {
            OnlineStatus onlineStatus = squareAvatarItem.getExtra().getOnlineStatus();
            if (onlineStatus != null) {
                onlineStatus.setExtraData(new SpecialStatus(null, null, null, null, songInfo, 15, null));
            }
            OnlineStatus onlineStatus2 = squareAvatarItem.getExtra().getOnlineStatus();
            if (onlineStatus2 == null || (fragmentView = getFragmentView()) == null) {
                return;
            }
            fragmentView.updateBubbleView(onlineStatus2);
        }
    }

    @Override // com.tencent.state.square.api.MusicChangeListener
    public void onMusicPlayStateChange(String songMid) {
        IDetailParentView fragmentView;
        SquareAvatarExtra extra;
        OnlineStatus onlineStatus;
        SpecialStatus extraData;
        SongInfo songInfo;
        Intrinsics.checkNotNullParameter(songMid, "songMid");
        SquareAvatarItem squareAvatarItem = this.squareItem;
        if (!Intrinsics.areEqual(songMid, (squareAvatarItem == null || (extra = squareAvatarItem.getExtra()) == null || (onlineStatus = extra.getOnlineStatus()) == null || (extraData = onlineStatus.getExtraData()) == null || (songInfo = extraData.getSongInfo()) == null) ? null : songInfo.getSongId()) || (fragmentView = getFragmentView()) == null) {
            return;
        }
        fragmentView.updatePlayState(squareAvatarItem);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        DetailCommonView commonView;
        ISquareAvatarView avatarView;
        super.onPause();
        this.fromPause.set(true);
        IDetailParentView fragmentView = getFragmentView();
        if (fragmentView == null || (commonView = fragmentView.getCommonView()) == null || (avatarView = commonView.getAvatarView()) == null) {
            return;
        }
        avatarView.stop();
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IDetailParentView fragmentView;
        MapPlayableSource currentMapPlayableSource;
        IDetailParentView fragmentView2;
        DetailCommonView commonView;
        ISquareAvatarView avatarView;
        super.onResume();
        if (!this.fromPause.compareAndSet(true, false) || (fragmentView = getFragmentView()) == null || (currentMapPlayableSource = fragmentView.getCurrentMapPlayableSource()) == null || (fragmentView2 = getFragmentView()) == null || (commonView = fragmentView2.getCommonView()) == null || (avatarView = commonView.getAvatarView()) == null) {
            return;
        }
        avatarView.setAnimSource(currentMapPlayableSource, null, false);
    }

    public void onTempUnreadMessageNotify(SquareTempMessageRecord messageRecord) {
        Intrinsics.checkNotNullParameter(messageRecord, "messageRecord");
    }

    public void onUnreadMessageNotify(SquareMessageRecord message) {
        Intrinsics.checkNotNullParameter(message, "message");
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.VasBaseLifecycleFragment
    public void onVisibilityChanged(boolean isVisible, String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        super.onVisibilityChanged(isVisible, from);
        if (isVisible) {
            SquareQZoneFeedsManager.INSTANCE.checkAndShowQZonePrivacyDialog(getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setEntranceConfig(T t16) {
        this.entranceConfig = t16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setEntranceSource(EntranceSource entranceSource) {
        Intrinsics.checkNotNullParameter(entranceSource, "<set-?>");
        this.entranceSource = entranceSource;
    }

    protected void setEventBus(SimpleEventBus simpleEventBus) {
        this.eventBus = simpleEventBus;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setSquareItem(SquareAvatarItem squareAvatarItem) {
        this.squareItem = squareAvatarItem;
    }

    protected final void setViewModel(SquareStatusViewModel squareStatusViewModel) {
        this.viewModel = squareStatusViewModel;
    }

    public String topBarUrl() {
        return null;
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.VasBaseLifecycleFragment
    public List<FragmentComponent> getComponents() {
        List<FragmentComponent> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new VasBaseFragmentComponent[]{getServiceProvider(), new DetailFragReportComponent()});
        return listOf;
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SquareStatusViewModel getViewModel() {
        return this.viewModel;
    }

    @Override // com.tencent.state.square.detail.DetailCommonListener
    public void onBackClick() {
        doBackToSquare$default(this, null, 1, null);
    }

    private final void onCreateView() {
        this.viewModel = (SquareStatusViewModel) new ViewModelProvider(this, new SquareStatusViewModelFactory()).get(SquareStatusViewModel.class);
        initCommonService();
        initCommonInviteState();
        afterOnCreateView();
        checkAndDoSchemeAction();
    }

    public static /* synthetic */ void doBackToSquare$default(DetailBaseSelectFragment detailBaseSelectFragment, Bundle bundle, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                bundle = null;
            }
            detailBaseSelectFragment.doBackToSquare(bundle);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doBackToSquare");
    }

    public void afterOnCreateView() {
    }

    public void endMultiMotion() {
    }

    public void goToInteraction() {
    }

    @Override // com.tencent.state.square.detail.DetailCommonListener
    public void goToMall() {
    }

    public void initInviteState() {
    }

    public void initService() {
    }

    public void onDetailBackPressed() {
    }

    @Override // com.tencent.state.square.detail.DetailCommonListener
    public void onSharePosterClick() {
    }
}
