package com.tencent.state.square.components.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseGroupFragment;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.ISquareViewUpdater;
import com.tencent.state.square.MoveItem;
import com.tencent.state.square.MoveResult;
import com.tencent.state.square.MoveType;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.SquareViewModel;
import com.tencent.state.square.chatland.component.ChatLandSquareComponent;
import com.tencent.state.square.components.SquareGroupFloatingComponent;
import com.tencent.state.square.components.SquareLibraryOnFocusEvent;
import com.tencent.state.square.detail.event.DetailCommonBackEvent;
import com.tencent.state.square.detail.event.DetailGuestAddToSquareEvent;
import com.tencent.state.square.detail.event.DetailGuestAddToSquareResultEvent;
import com.tencent.state.square.detail.event.DetailGuestCloseToMeEvent;
import com.tencent.state.square.detail.event.DetailGuestCloseToMeResultInfoEvent;
import com.tencent.state.square.detail.event.DetailGuestFixedEvent;
import com.tencent.state.square.detail.event.DetailGuestGetCloseToMeInfoEvent;
import com.tencent.state.square.detail.event.DetailGuestHideEvent;
import com.tencent.state.square.detail.event.DetailGuestUpdateQZoneFeedsEvent;
import com.tencent.state.square.detail.event.DetailGuestUpdateStickersEvent;
import com.tencent.state.square.detail.event.DetailGuestUpdateTargetResourceEvent;
import com.tencent.state.square.detail.event.DetailMeBackEvent;
import com.tencent.state.square.detail.event.DetailMeGetNoviceGuideConfigEvent;
import com.tencent.state.square.detail.event.DetailMeGetNoviceGuideConfigResultEvent;
import com.tencent.state.square.detail.event.DetailMeUpdateResourceEvent;
import com.tencent.state.square.detail.event.DetailMeUpdateStatusEvent;
import com.tencent.state.square.detail.event.DetailScaledAvatarVisibleEvent;
import com.tencent.state.square.event.OpenTaskEvent;
import com.tencent.state.square.event.RefreshSquareAvatarFootLabelEvent;
import com.tencent.state.square.event.UpdateBubbleSkinEvent;
import com.tencent.state.square.friendsetting.PlaceInfo;
import com.tencent.state.square.guide.SquareNoviceGuideConfig;
import com.tencent.state.square.guide.SquareNoviceGuideRecord;
import com.tencent.state.square.guide.SquareRolePageResultEvent;
import com.tencent.state.square.resource.ISquareRoleManager;
import com.tencent.state.utils.EventBusUtilsKt;
import com.tencent.state.utils.IEventHandler;
import com.tencent.state.utils.VMUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00c4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 C2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001CB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u000203H\u0002J\u0014\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000705H\u0016J\u0010\u00106\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u000207H\u0002J$\u00108\u001a\u00020\u00112\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u001a\u0010?\u001a\u00020\u00112\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<H\u0016J\u0012\u0010@\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010A\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020BH\u0002R:\u0010\u0005\u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u00a8\u0006D"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareEventBusComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "eventMap", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lcom/tencent/state/utils/IEventHandler;", "Lkotlin/collections/HashMap;", "squareGroupVM", "Lcom/tencent/state/square/SquareViewModel;", "getSquareGroupVM", "()Lcom/tencent/state/square/SquareViewModel;", "squareGroupVM$delegate", "Lkotlin/Lazy;", "doOnAddToSquare", "", "event", "Lcom/tencent/state/square/detail/event/DetailGuestAddToSquareEvent;", "doOnAvatarVisibility", "Lcom/tencent/state/square/detail/event/DetailScaledAvatarVisibleEvent;", "doOnCloseToMe", "Lcom/tencent/state/square/detail/event/DetailGuestCloseToMeEvent;", "doOnDetailMeFragmentBack", "Lcom/tencent/state/square/detail/event/DetailMeBackEvent;", "doOnFixedAvatar", "Lcom/tencent/state/square/detail/event/DetailGuestFixedEvent;", "doOnFragmentCommonBack", "Lcom/tencent/state/square/detail/event/DetailCommonBackEvent;", "doOnGetCloseToMeInfo", "Lcom/tencent/state/square/detail/event/DetailGuestGetCloseToMeInfoEvent;", "doOnGetNoviceGuideConfig", "Lcom/tencent/state/square/detail/event/DetailMeGetNoviceGuideConfigEvent;", "doOnHideAvatar", "Lcom/tencent/state/square/detail/event/DetailGuestHideEvent;", "doOnLibraryFloatingReset", "Lcom/tencent/state/square/components/SquareLibraryOnFocusEvent;", "doOnRefreshSquareAvatarFootLabel", "Lcom/tencent/state/square/event/RefreshSquareAvatarFootLabelEvent;", "doOnRolePageResult", "Lcom/tencent/state/square/guide/SquareRolePageResultEvent;", "doOnUpdateDetailGuestStickers", "Lcom/tencent/state/square/detail/event/DetailGuestUpdateStickersEvent;", "doOnUpdateMeResource", "Lcom/tencent/state/square/detail/event/DetailMeUpdateResourceEvent;", "doOnUpdateMeStatus", "Lcom/tencent/state/square/detail/event/DetailMeUpdateStatusEvent;", "doOnUpdateQZoneFeeds", "Lcom/tencent/state/square/detail/event/DetailGuestUpdateQZoneFeedsEvent;", "doOnUpdateTargetResource", "Lcom/tencent/state/square/detail/event/DetailGuestUpdateTargetResourceEvent;", "getEventClass", "Ljava/util/ArrayList;", "handleTaskEvent", "Lcom/tencent/state/square/event/OpenTaskEvent;", "onFragmentCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onFragmentDestroyed", "onReceiveEvent", "updateBubbleSkin", "Lcom/tencent/state/square/event/UpdateBubbleSkinEvent;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareEventBusComponent extends SquareBaseComponent implements SimpleEventReceiver<SimpleBaseEvent> {
    private static final String TAG = "SquareEventBusComponent";
    private final HashMap<Class<? extends SimpleBaseEvent>, IEventHandler> eventMap;

    /* renamed from: squareGroupVM$delegate, reason: from kotlin metadata */
    private final Lazy squareGroupVM;

    public SquareEventBusComponent() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SquareViewModel>() { // from class: com.tencent.state.square.components.fragment.SquareEventBusComponent$squareGroupVM$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SquareViewModel invoke() {
                VasBaseGroupFragment groupFragment;
                SquareViewModel squareViewModel;
                SquareFragment squareFragment = SquareEventBusComponent.this.getSquareFragment();
                if (squareFragment == null || (groupFragment = squareFragment.getGroupFragment()) == null || (squareViewModel = (SquareViewModel) VMUtils.INSTANCE.safelyGet(groupFragment, SquareViewModel.class)) == null) {
                    return null;
                }
                return squareViewModel;
            }
        });
        this.squareGroupVM = lazy;
        HashMap<Class<? extends SimpleBaseEvent>, IEventHandler> hashMap = new HashMap<>();
        EventBusUtilsKt.register(hashMap, DetailMeBackEvent.class, new Function1<DetailMeBackEvent, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareEventBusComponent$$special$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DetailMeBackEvent detailMeBackEvent) {
                invoke2(detailMeBackEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DetailMeBackEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareEventBusComponent.this.doOnDetailMeFragmentBack(it);
            }
        });
        EventBusUtilsKt.register(hashMap, DetailScaledAvatarVisibleEvent.class, new Function1<DetailScaledAvatarVisibleEvent, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareEventBusComponent$$special$$inlined$apply$lambda$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DetailScaledAvatarVisibleEvent detailScaledAvatarVisibleEvent) {
                invoke2(detailScaledAvatarVisibleEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DetailScaledAvatarVisibleEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareEventBusComponent.this.doOnAvatarVisibility(it);
            }
        });
        EventBusUtilsKt.register(hashMap, DetailMeUpdateStatusEvent.class, new Function1<DetailMeUpdateStatusEvent, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareEventBusComponent$$special$$inlined$apply$lambda$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DetailMeUpdateStatusEvent detailMeUpdateStatusEvent) {
                invoke2(detailMeUpdateStatusEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DetailMeUpdateStatusEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareEventBusComponent.this.doOnUpdateMeStatus(it);
            }
        });
        EventBusUtilsKt.register(hashMap, DetailMeUpdateResourceEvent.class, new Function1<DetailMeUpdateResourceEvent, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareEventBusComponent$$special$$inlined$apply$lambda$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DetailMeUpdateResourceEvent detailMeUpdateResourceEvent) {
                invoke2(detailMeUpdateResourceEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DetailMeUpdateResourceEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareEventBusComponent.this.doOnUpdateMeResource(it);
            }
        });
        EventBusUtilsKt.register(hashMap, DetailGuestUpdateQZoneFeedsEvent.class, new Function1<DetailGuestUpdateQZoneFeedsEvent, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareEventBusComponent$$special$$inlined$apply$lambda$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DetailGuestUpdateQZoneFeedsEvent detailGuestUpdateQZoneFeedsEvent) {
                invoke2(detailGuestUpdateQZoneFeedsEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DetailGuestUpdateQZoneFeedsEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareEventBusComponent.this.doOnUpdateQZoneFeeds(it);
            }
        });
        EventBusUtilsKt.register(hashMap, DetailGuestUpdateTargetResourceEvent.class, new Function1<DetailGuestUpdateTargetResourceEvent, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareEventBusComponent$$special$$inlined$apply$lambda$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DetailGuestUpdateTargetResourceEvent detailGuestUpdateTargetResourceEvent) {
                invoke2(detailGuestUpdateTargetResourceEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DetailGuestUpdateTargetResourceEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareEventBusComponent.this.doOnUpdateTargetResource(it);
            }
        });
        EventBusUtilsKt.register(hashMap, DetailGuestCloseToMeEvent.class, new Function1<DetailGuestCloseToMeEvent, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareEventBusComponent$$special$$inlined$apply$lambda$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DetailGuestCloseToMeEvent detailGuestCloseToMeEvent) {
                invoke2(detailGuestCloseToMeEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DetailGuestCloseToMeEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareEventBusComponent.this.doOnCloseToMe(it);
            }
        });
        EventBusUtilsKt.register(hashMap, DetailGuestFixedEvent.class, new Function1<DetailGuestFixedEvent, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareEventBusComponent$$special$$inlined$apply$lambda$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DetailGuestFixedEvent detailGuestFixedEvent) {
                invoke2(detailGuestFixedEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DetailGuestFixedEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareEventBusComponent.this.doOnFixedAvatar(it);
            }
        });
        EventBusUtilsKt.register(hashMap, DetailGuestHideEvent.class, new Function1<DetailGuestHideEvent, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareEventBusComponent$$special$$inlined$apply$lambda$9
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DetailGuestHideEvent detailGuestHideEvent) {
                invoke2(detailGuestHideEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DetailGuestHideEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareEventBusComponent.this.doOnHideAvatar(it);
            }
        });
        EventBusUtilsKt.register(hashMap, DetailGuestGetCloseToMeInfoEvent.class, new Function1<DetailGuestGetCloseToMeInfoEvent, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareEventBusComponent$$special$$inlined$apply$lambda$10
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DetailGuestGetCloseToMeInfoEvent detailGuestGetCloseToMeInfoEvent) {
                invoke2(detailGuestGetCloseToMeInfoEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DetailGuestGetCloseToMeInfoEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareEventBusComponent.this.doOnGetCloseToMeInfo(it);
            }
        });
        EventBusUtilsKt.register(hashMap, DetailGuestAddToSquareEvent.class, new Function1<DetailGuestAddToSquareEvent, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareEventBusComponent$$special$$inlined$apply$lambda$11
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DetailGuestAddToSquareEvent detailGuestAddToSquareEvent) {
                invoke2(detailGuestAddToSquareEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DetailGuestAddToSquareEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareEventBusComponent.this.doOnAddToSquare(it);
            }
        });
        EventBusUtilsKt.register(hashMap, DetailCommonBackEvent.class, new Function1<DetailCommonBackEvent, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareEventBusComponent$$special$$inlined$apply$lambda$12
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DetailCommonBackEvent detailCommonBackEvent) {
                invoke2(detailCommonBackEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DetailCommonBackEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareEventBusComponent.this.doOnFragmentCommonBack(it);
            }
        });
        EventBusUtilsKt.register(hashMap, RefreshSquareAvatarFootLabelEvent.class, new Function1<RefreshSquareAvatarFootLabelEvent, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareEventBusComponent$$special$$inlined$apply$lambda$13
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RefreshSquareAvatarFootLabelEvent refreshSquareAvatarFootLabelEvent) {
                invoke2(refreshSquareAvatarFootLabelEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RefreshSquareAvatarFootLabelEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareEventBusComponent.this.doOnRefreshSquareAvatarFootLabel(it);
            }
        });
        EventBusUtilsKt.register(hashMap, DetailMeGetNoviceGuideConfigEvent.class, new Function1<DetailMeGetNoviceGuideConfigEvent, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareEventBusComponent$$special$$inlined$apply$lambda$14
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DetailMeGetNoviceGuideConfigEvent detailMeGetNoviceGuideConfigEvent) {
                invoke2(detailMeGetNoviceGuideConfigEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DetailMeGetNoviceGuideConfigEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareEventBusComponent.this.doOnGetNoviceGuideConfig(it);
            }
        });
        EventBusUtilsKt.register(hashMap, SquareRolePageResultEvent.class, new Function1<SquareRolePageResultEvent, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareEventBusComponent$$special$$inlined$apply$lambda$15
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SquareRolePageResultEvent squareRolePageResultEvent) {
                invoke2(squareRolePageResultEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SquareRolePageResultEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareEventBusComponent.this.doOnRolePageResult(it);
            }
        });
        EventBusUtilsKt.register(hashMap, DetailGuestUpdateStickersEvent.class, new Function1<DetailGuestUpdateStickersEvent, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareEventBusComponent$$special$$inlined$apply$lambda$16
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DetailGuestUpdateStickersEvent detailGuestUpdateStickersEvent) {
                invoke2(detailGuestUpdateStickersEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DetailGuestUpdateStickersEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareEventBusComponent.this.doOnUpdateDetailGuestStickers(it);
            }
        });
        EventBusUtilsKt.register(hashMap, SquareLibraryOnFocusEvent.class, new Function1<SquareLibraryOnFocusEvent, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareEventBusComponent$$special$$inlined$apply$lambda$17
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SquareLibraryOnFocusEvent squareLibraryOnFocusEvent) {
                invoke2(squareLibraryOnFocusEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SquareLibraryOnFocusEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareEventBusComponent.this.doOnLibraryFloatingReset(it);
            }
        });
        EventBusUtilsKt.register(hashMap, UpdateBubbleSkinEvent.class, new Function1<UpdateBubbleSkinEvent, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareEventBusComponent$$special$$inlined$apply$lambda$18
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UpdateBubbleSkinEvent updateBubbleSkinEvent) {
                invoke2(updateBubbleSkinEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UpdateBubbleSkinEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareEventBusComponent.this.updateBubbleSkin(it);
            }
        });
        EventBusUtilsKt.register(hashMap, OpenTaskEvent.class, new Function1<OpenTaskEvent, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareEventBusComponent$$special$$inlined$apply$lambda$19
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OpenTaskEvent openTaskEvent) {
                invoke2(openTaskEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(OpenTaskEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareEventBusComponent.this.handleTaskEvent(it);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.eventMap = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doOnAddToSquare(final DetailGuestAddToSquareEvent event) {
        List listOf;
        SquareFragment squareFragment = getSquareFragment();
        if (squareFragment != null) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new MoveItem(event.getData().getUin(), event.getType(), event.getIsMale(), event.getData()));
            ISquareRoleManager.DefaultImpls.addMultiRoles$default(squareFragment, listOf, 4, event.getMainScene(), null, true, event.getNeedLocateTo(), new Function1<Map<MoveItem, ? extends MoveResult>, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareEventBusComponent$doOnAddToSquare$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Map<MoveItem, ? extends MoveResult> map) {
                    invoke2((Map<MoveItem, MoveResult>) map);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Map<MoveItem, MoveResult> item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    for (Map.Entry<MoveItem, MoveResult> entry : item.entrySet()) {
                        if (Intrinsics.areEqual(entry.getKey().getUin(), DetailGuestAddToSquareEvent.this.getData().getUin())) {
                            SimpleEventBus.getInstance().dispatchEvent(new DetailGuestAddToSquareResultEvent(DetailGuestAddToSquareEvent.this.getData().getUin(), entry.getValue().getType() == MoveType.AddToSquare || entry.getValue().getType() == MoveType.AlreadyInSquare));
                        }
                    }
                }
            }, 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doOnAvatarVisibility(DetailScaledAvatarVisibleEvent event) {
        SquareBaseKt.getSquareLog().i(TAG, "[SquareScaleDetail] doOnAvatarVisibility: " + event.getVisible());
        SquareView mapView = getMapView();
        if (mapView != null) {
            mapView.updateScaledItemViewVisible(event.getVisible());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doOnCloseToMe(DetailGuestCloseToMeEvent event) {
        ISquareViewUpdater squareViewUpdater;
        SquareFragment squareFragment = getSquareFragment();
        if (squareFragment == null || (squareViewUpdater = squareFragment.getSquareViewUpdater()) == null) {
            return;
        }
        squareViewUpdater.doAvatarCloseToMe(event.getUin());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doOnDetailMeFragmentBack(DetailMeBackEvent event) {
        SquareView mapView;
        ISquareViewUpdater updater;
        if (!event.getPublish() || (mapView = getMapView()) == null || (updater = mapView.getUpdater()) == null) {
            return;
        }
        updater.updateAvatarLocationView(event.getLocationInfo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doOnFixedAvatar(DetailGuestFixedEvent event) {
        ISquareViewUpdater squareViewUpdater;
        SquareFragment squareFragment = getSquareFragment();
        if (squareFragment == null || (squareViewUpdater = squareFragment.getSquareViewUpdater()) == null) {
            return;
        }
        squareViewUpdater.setAvatarFixed(event.getUin(), event.getFixed());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doOnFragmentCommonBack(DetailCommonBackEvent event) {
        SquareFragment squareFragment = getSquareFragment();
        if (squareFragment != null) {
            squareFragment.onBackFromDetail(event.getBundle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doOnGetCloseToMeInfo(DetailGuestGetCloseToMeInfoEvent event) {
        PlaceInfo placeInfo;
        ISquareViewUpdater squareViewUpdater;
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        SquareFragment squareFragment = getSquareFragment();
        if (squareFragment == null || (squareViewUpdater = squareFragment.getSquareViewUpdater()) == null || (placeInfo = squareViewUpdater.getCloseToMePlace(event.getUin())) == null) {
            placeInfo = null;
        }
        simpleEventBus.dispatchEvent(new DetailGuestCloseToMeResultInfoEvent(placeInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doOnGetNoviceGuideConfig(DetailMeGetNoviceGuideConfigEvent event) {
        LiveData<SquareNoviceGuideConfig> noviceGuideConfig;
        LiveData<SquareNoviceGuideRecord> noviceGuideRecord;
        SquareNoviceGuideRecord value;
        Boolean rolePageResult;
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        SquareViewModel squareGroupVM = getSquareGroupVM();
        boolean booleanValue = (squareGroupVM == null || (noviceGuideRecord = squareGroupVM.getNoviceGuideRecord()) == null || (value = noviceGuideRecord.getValue()) == null || (rolePageResult = value.getRolePageResult()) == null) ? false : rolePageResult.booleanValue();
        SquareViewModel squareGroupVM2 = getSquareGroupVM();
        simpleEventBus.dispatchEvent(new DetailMeGetNoviceGuideConfigResultEvent(booleanValue, (squareGroupVM2 == null || (noviceGuideConfig = squareGroupVM2.getNoviceGuideConfig()) == null) ? null : noviceGuideConfig.getValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doOnHideAvatar(DetailGuestHideEvent event) {
        ISquareViewUpdater squareViewUpdater;
        SquareFragment squareFragment = getSquareFragment();
        if (squareFragment == null || (squareViewUpdater = squareFragment.getSquareViewUpdater()) == null) {
            return;
        }
        squareViewUpdater.hide(event.getUin());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doOnLibraryFloatingReset(SquareLibraryOnFocusEvent event) {
        SquareGroupFloatingComponent squareGroupFloatingComponent;
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (squareGroupFloatingComponent = (SquareGroupFloatingComponent) VasBaseLifecycleFragment.getComponent$default(fragment, SquareGroupFloatingComponent.class, null, null, 6, null)) == null) {
            return;
        }
        squareGroupFloatingComponent.resetPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doOnRefreshSquareAvatarFootLabel(RefreshSquareAvatarFootLabelEvent event) {
        SquareFootLabelComponent squareFootLabelComponent;
        SquareFragment squareFragment = getSquareFragment();
        if (squareFragment == null || (squareFootLabelComponent = (SquareFootLabelComponent) VasBaseLifecycleFragment.getComponent$default(squareFragment, SquareFootLabelComponent.class, null, null, 6, null)) == null) {
            return;
        }
        squareFootLabelComponent.refreshAvatarFootLabel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doOnRolePageResult(SquareRolePageResultEvent event) {
        LiveData<SquareNoviceGuideRecord> noviceGuideRecord;
        SquareNoviceGuideRecord value;
        SquareBaseKt.getSquareLog().d(TAG, "[NoviceGuide] doOnRolePageResult, " + event.getRegistered());
        SquareViewModel squareGroupVM = getSquareGroupVM();
        if (squareGroupVM != null && (noviceGuideRecord = squareGroupVM.getNoviceGuideRecord()) != null && (value = noviceGuideRecord.getValue()) != null) {
            value.setRolePageResult(Boolean.valueOf(event.getRegistered()));
            SquareViewModel squareGroupVM2 = getSquareGroupVM();
            if (squareGroupVM2 != null) {
                Intrinsics.checkNotNullExpressionValue(value, "this");
                squareGroupVM2.updateNoviceGuideRecord(value);
            }
        }
        if (event.getRegistered()) {
            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.components.fragment.SquareEventBusComponent$doOnRolePageResult$2
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
                    QBaseActivity activity;
                    activity = SquareEventBusComponent.this.getActivity();
                    if (activity != null) {
                        ICommonUtils.DefaultImpls.showToast$default(SquareBaseKt.getSquareCommon(), activity, R.string.xdp, 0, 4, (Object) null);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doOnUpdateDetailGuestStickers(DetailGuestUpdateStickersEvent event) {
        ISquareViewUpdater updater;
        SquareView mapView = getMapView();
        if (mapView == null || (updater = mapView.getUpdater()) == null) {
            return;
        }
        updater.updateStickers(event.getUin(), event.getStickers());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doOnUpdateMeResource(DetailMeUpdateResourceEvent event) {
        SquareViewModel squareGroupVM = getSquareGroupVM();
        if (squareGroupVM != null) {
            squareGroupVM.updateMeResource(event.getResource());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doOnUpdateMeStatus(DetailMeUpdateStatusEvent event) {
        SquareViewModel squareGroupVM = getSquareGroupVM();
        if (squareGroupVM != null) {
            squareGroupVM.updateMeStatus(event.getInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doOnUpdateQZoneFeeds(DetailGuestUpdateQZoneFeedsEvent event) {
        SquareViewModel squareGroupVM = getSquareGroupVM();
        if (squareGroupVM != null) {
            squareGroupVM.updateQZoneFeeds(event.getUin(), event.getFeedsInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doOnUpdateTargetResource(DetailGuestUpdateTargetResourceEvent event) {
        SquareViewModel squareGroupVM = getSquareGroupVM();
        if (squareGroupVM != null) {
            squareGroupVM.updateTargetResource(event.getUin(), event.getResource());
        }
    }

    private final SquareViewModel getSquareGroupVM() {
        return (SquareViewModel) this.squareGroupVM.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleTaskEvent(final OpenTaskEvent event) {
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.components.fragment.SquareEventBusComponent$handleTaskEvent$1
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

            /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
            
                r0 = r3.this$0.getFragment();
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                VasBaseFragment fragment;
                SquareShareComponent squareShareComponent;
                VasBaseFragment fragment2;
                ChatLandSquareComponent chatLandSquareComponent;
                int type = event.getType();
                if (type != 1) {
                    if (type != 2 || fragment2 == null || (chatLandSquareComponent = (ChatLandSquareComponent) fragment2.getComponent(ChatLandSquareComponent.class, null, null)) == null) {
                        return;
                    }
                    chatLandSquareComponent.locateToWelcome();
                    return;
                }
                fragment = SquareEventBusComponent.this.getFragment();
                if (fragment == null || (squareShareComponent = (SquareShareComponent) fragment.getComponent(SquareShareComponent.class, null, null)) == null) {
                    return;
                }
                squareShareComponent.share();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBubbleSkin(UpdateBubbleSkinEvent event) {
        SquareBubbleSkinComponent squareBubbleSkinComponent;
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (squareBubbleSkinComponent = (SquareBubbleSkinComponent) fragment.getComponent(SquareBubbleSkinComponent.class, null, null)) == null) {
            return;
        }
        squareBubbleSkinComponent.updateTargetBubbleSkin(event.getUin(), event.getBubbleInfo());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.addAll(this.eventMap.keySet());
        return arrayList;
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentCreated(FragmentManager fm5, Fragment f16, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        super.onFragmentCreated(fm5, f16, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        super.onFragmentDestroyed(fm5, f16);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
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
