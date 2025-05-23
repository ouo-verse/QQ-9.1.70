package com.tencent.state.template.map.component;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.common.tag.CommonTagInfo;
import com.tencent.state.event.Event;
import com.tencent.state.map.BaseMapView;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.MapItem;
import com.tencent.state.publicchat.component.PublicChatUIComponent;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.detail.DetailBaseSelectFragment;
import com.tencent.state.template.activity.TemplateActivityViewModel;
import com.tencent.state.template.data.CommonRoomInfo;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.SeatButtonState;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.SitDownUpdateData;
import com.tencent.state.template.data.User;
import com.tencent.state.template.item.TemplateAvatarItem;
import com.tencent.state.template.map.ITemplateViewUpdater;
import com.tencent.state.template.map.TemplateMapFragment;
import com.tencent.state.template.map.TemplateMapView;
import com.tencent.state.template.map.TemplateMapViewKt;
import com.tencent.state.template.map.TemplateMapViewModel;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001AB\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH$J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH$J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH$J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000eH$J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H$J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\u0015\u001a\u00020\tH\u0002J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aJ*\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020&H\u0016J,\u0010'\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\"\u0010,\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u001dH\u0016J\u0018\u0010.\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000eH&J\b\u0010/\u001a\u00020\tH\u0002J\u0016\u00100\u001a\u00020\t2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204J\u000e\u00105\u001a\u00020\t2\u0006\u0010!\u001a\u000206J\u0016\u00105\u001a\u00020\t2\u0006\u00101\u001a\u0002022\u0006\u0010\u0019\u001a\u000202J\u0006\u00107\u001a\u00020\tJ\u001e\u00108\u001a\u00020\t2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00109\u001a\u00020\u001dJ\u0006\u0010:\u001a\u00020\tJ\u0016\u0010;\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020=J\u0010\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020@H$R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006B"}, d2 = {"Lcom/tencent/state/template/map/component/TemplateUiComponent;", "Lcom/tencent/state/template/map/component/TemplateMapBaseComponent;", "Landroid/view/View$OnClickListener;", "()V", "activityVm", "Lcom/tencent/state/template/activity/TemplateActivityViewModel;", "vm", "Lcom/tencent/state/template/map/TemplateMapViewModel;", "backToMySeat", "", "getActivityViewModel", "f", "Landroidx/fragment/app/Fragment;", "getBackIcon", "Landroid/view/View;", "getMapViewModel", "getSeatButton", "getTitleContainer", "Landroid/view/ViewGroup;", "initActivityViewModel", "initFragmentViewModel", "initReport", "initViews", "v", "locateToAndScale", "uin", "", "onCenterScaled", "isScaleToCenter", "", "view", "index", "", "data", "Lcom/tencent/state/map/MapItem;", NodeProps.ON_CLICK, "onEnterRoom", "info", "Lcom/tencent/state/template/data/EnterRoomInfo;", "onFragmentViewCreated", "fm", "Landroidx/fragment/app/FragmentManager;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onFragmentVisibilityChanged", "isVisible", "onInitView", "onSeatButtonClick", "sitDown", "tableId", "", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "standUp", "Lcom/tencent/state/template/item/TemplateAvatarItem;", "standUpOfMe", "switchSelfTable", "fromFocusFragment", "toggleSeatButtonVisible", "updateDeskMateTag", "tag", "Lcom/tencent/state/common/tag/CommonTagInfo;", "updateSeatButtonState", "state", "Lcom/tencent/state/template/data/SeatButtonState;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class TemplateUiComponent extends TemplateMapBaseComponent implements View.OnClickListener {
    private static final String TAG = "TemplateUiComponent";
    private TemplateActivityViewModel activityVm;
    private TemplateMapViewModel vm;

    private final void initActivityViewModel(Fragment f16) {
        LiveData<Event<SitDownUpdateData>> scaledVisibility;
        TemplateActivityViewModel activityViewModel = getActivityViewModel(f16);
        this.activityVm = activityViewModel;
        if (activityViewModel == null || (scaledVisibility = activityViewModel.getScaledVisibility()) == null) {
            return;
        }
        scaledVisibility.observe(f16.getViewLifecycleOwner(), new Observer<Event<SitDownUpdateData>>() { // from class: com.tencent.state.template.map.component.TemplateUiComponent$initActivityViewModel$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Event<SitDownUpdateData> event) {
                SitDownUpdateData content;
                TemplateMapView<?> mapView;
                if (event == null || (content = event.getContent()) == null || (mapView = TemplateUiComponent.this.getMapView()) == null) {
                    return;
                }
                mapView.updateItemViewVisible(content.getId(), content.getType(), content.getVisible());
            }
        });
    }

    private final void initFragmentViewModel(final Fragment f16) {
        TemplateMapViewModel mapViewModel = getMapViewModel(f16);
        if (mapViewModel != null) {
            mapViewModel.getSeatButtonState().observe(f16.getViewLifecycleOwner(), new Observer<SeatButtonState>() { // from class: com.tencent.state.template.map.component.TemplateUiComponent$initFragmentViewModel$$inlined$also$lambda$1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(SeatButtonState it) {
                    TemplateActivityViewModel templateActivityViewModel;
                    SquareBaseKt.getSquareLog().i("TemplateUiComponent", "updateSeatButtonState: meSeated:" + it.isMeSeated() + ", roomFull:" + it.isRoomFull());
                    TemplateUiComponent templateUiComponent = TemplateUiComponent.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    templateUiComponent.updateSeatButtonState(it);
                    templateActivityViewModel = TemplateUiComponent.this.activityVm;
                    if (templateActivityViewModel != null) {
                        templateActivityViewModel.updateIsMySeat(it.isMeSeated());
                    }
                }
            });
            Unit unit = Unit.INSTANCE;
        } else {
            mapViewModel = null;
        }
        this.vm = mapViewModel;
    }

    private final void initReport() {
        final View backIcon = getBackIcon();
        if (backIcon != null) {
            SquareBaseKt.getSquareReporter().setElementInfo(backIcon, "em_zplan_back", new LinkedHashMap(), false, false);
            backIcon.post(new Runnable() { // from class: com.tencent.state.template.map.component.TemplateUiComponent$initReport$$inlined$let$lambda$1
                @Override // java.lang.Runnable
                public final void run() {
                    Map<String, Object> mutableMapOf;
                    IReporter squareReporter = SquareBaseKt.getSquareReporter();
                    View view = backIcon;
                    Pair[] pairArr = new Pair[1];
                    TemplateMapView<?> mapView = this.getMapView();
                    pairArr[0] = TuplesKt.to("zplan_is_focus", Integer.valueOf((mapView == null || !TemplateMapViewKt.isMeSeated(mapView)) ? 0 : 1));
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
                    squareReporter.reportEvent("imp", view, mutableMapOf);
                }
            });
        }
    }

    private final void initViews(Fragment f16, View v3) {
        onInitView(f16, v3);
        ViewGroup titleContainer = getTitleContainer();
        if (titleContainer != null) {
            ViewExtensionsKt.updateLayoutParams(titleContainer, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.template.map.component.TemplateUiComponent$initViews$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                    invoke2(layoutParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(FrameLayout.LayoutParams receiver) {
                    QBaseActivity activity;
                    int coerceAtLeast;
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    activity = TemplateUiComponent.this.getActivity();
                    if (activity != null) {
                        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(SquareUtil.INSTANCE.getStatusBarHeight(activity), com.tencent.state.square.common.ViewExtensionsKt.dip((Context) activity, 20.0f));
                        receiver.topMargin = coerceAtLeast;
                    }
                }
            });
        }
        View backIcon = getBackIcon();
        if (backIcon != null) {
            backIcon.setOnClickListener(this);
        }
        View seatButton = getSeatButton();
        if (seatButton != null) {
            seatButton.setOnClickListener(this);
        }
    }

    private final void onSeatButtonClick() {
        LiveData<SeatButtonState> seatButtonState;
        final SeatButtonState value;
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        WeakReference<VasBaseFragmentComponentGroup> parent2;
        VasBaseFragment vasBaseFragment2;
        FragmentComponent component$default2;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2;
        TemplateMapViewModel templateMapViewModel = this.vm;
        if (templateMapViewModel == null || (seatButtonState = templateMapViewModel.getSeatButtonState()) == null || (value = seatButtonState.getValue()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(value, "vm?.seatButtonState?.value ?: return");
        Function1<ITemplateMapEvent, Unit> function1 = new Function1<ITemplateMapEvent, Unit>() { // from class: com.tencent.state.template.map.component.TemplateUiComponent$onSeatButtonClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ITemplateMapEvent iTemplateMapEvent) {
                invoke2(iTemplateMapEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ITemplateMapEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onSeatButtonClicked(SeatButtonState.this);
            }
        };
        VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) this).fragment;
        if (vasBaseFragment3 != null) {
            vasBaseFragment3.forEachComponent(ITemplateMapEvent.class, null, null, function1);
        }
        if (value.isMeSeated()) {
            backToMySeat();
            return;
        }
        if (value.isRoomFull()) {
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
            if ((vasBaseFragmentComponentGroup3 == null || (component$default2 = vasBaseFragmentComponentGroup3.getComponent(TemplateRoomComponent.class, null)) == null) && (((parent2 = getParent()) == null || (vasBaseFragmentComponentGroup2 = parent2.get()) == null || (component$default2 = vasBaseFragmentComponentGroup2.getComponent(TemplateRoomComponent.class, null)) == null) && ((vasBaseFragment2 = ((VasBaseFragmentComponent) this).fragment) == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, TemplateRoomComponent.class, null, null, 2, null)) == null))) {
                VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) this).parentFragment;
                component$default2 = vasBaseFragment4 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, TemplateRoomComponent.class, null, null, 6, null) : null;
            }
            TemplateRoomComponent templateRoomComponent = (TemplateRoomComponent) component$default2;
            if (templateRoomComponent != null) {
                TemplateRoomComponent.switchRoom$default(templateRoomComponent, null, null, 3, null);
                return;
            }
            return;
        }
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup4 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup4 == null || (component$default = vasBaseFragmentComponentGroup4.getComponent(TemplateSitComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(TemplateSitComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, TemplateSitComponent.class, null, null, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment5 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default = vasBaseFragment5 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment5, TemplateSitComponent.class, null, null, 6, null) : null;
        }
        TemplateSitComponent templateSitComponent = (TemplateSitComponent) component$default;
        if (templateSitComponent != null) {
            templateSitComponent.showSitDownPanel(null, true);
        }
    }

    public final void backToMySeat() {
        TemplateMapView<?> mapView = getMapView();
        if (mapView != null) {
            BaseMapView.scaleToMeDetail$default(mapView, null, 1, null);
        }
    }

    protected abstract TemplateActivityViewModel getActivityViewModel(Fragment f16);

    protected abstract View getBackIcon();

    protected abstract TemplateMapViewModel getMapViewModel(Fragment f16);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract View getSeatButton();

    protected abstract ViewGroup getTitleContainer();

    public final void locateToAndScale(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        TemplateMapView<?> mapView = getMapView();
        if (mapView != null) {
            mapView.scaleToDetail(uin);
        }
    }

    @Override // com.tencent.state.template.map.component.TemplateMapBaseComponent, com.tencent.state.map.IMapViewListener
    public void onCenterScaled(boolean isScaleToCenter, View view, int index, MapItem data) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        Intrinsics.checkNotNullParameter(view, "view");
        SquareBaseKt.getSquareLog().d(TAG, "onCenterScaled " + isScaleToCenter);
        View seatButton = getSeatButton();
        if (seatButton != null) {
            ViewExtensionsKt.setVisibility(seatButton, !isScaleToCenter);
        }
        FragmentComponent fragmentComponent2 = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(PublicChatUIComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(PublicChatUIComponent.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, PublicChatUIComponent.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, PublicChatUIComponent.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        PublicChatUIComponent publicChatUIComponent = (PublicChatUIComponent) fragmentComponent;
        if (publicChatUIComponent != null) {
            publicChatUIComponent.setVisibility(!isScaleToCenter);
        }
    }

    @Override // com.tencent.state.template.map.component.TemplateMapBaseComponent, com.tencent.state.template.map.component.ITemplateMapEvent
    public void onEnterRoom(EnterRoomInfo info) {
        List<User> users;
        Intrinsics.checkNotNullParameter(info, "info");
        CommonRoomInfo room = info.getRoom();
        Object obj = null;
        if (room != null && (users = room.getUsers()) != null) {
            Iterator<T> it = users.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                User user = (User) next;
                if (user.isMe() && user.getSitDown() != null) {
                    obj = next;
                    break;
                }
            }
            obj = (User) obj;
        }
        SquareUtil.INSTANCE.setKeepScreen(getActivity(), obj != null);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        initViews(f16, v3);
        initActivityViewModel(f16);
        initFragmentViewModel(f16);
        initReport();
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentVisibilityChanged(FragmentManager fm5, Fragment f16, boolean isVisible) {
        ViewGroup titleContainer;
        Intrinsics.checkNotNullParameter(f16, "f");
        TemplateMapFragment<?, ?> templateFragment = getTemplateFragment();
        if (((templateFragment != null ? templateFragment.getTopFragment() : null) instanceof DetailBaseSelectFragment) || (titleContainer = getTitleContainer()) == null) {
            return;
        }
        ViewExtensionsKt.setVisibility(titleContainer, isVisible);
    }

    public abstract void onInitView(Fragment f16, View v3);

    public final void sitDown(long tableId, User user) {
        SeatButtonState copy$default;
        ITemplateViewUpdater iTemplateViewUpdater;
        Intrinsics.checkNotNullParameter(user, "user");
        TemplateMapView<?> mapView = getMapView();
        if (mapView != null && (iTemplateViewUpdater = (ITemplateViewUpdater) mapView.getComponent(ITemplateViewUpdater.class)) != null) {
            iTemplateViewUpdater.sitDown(tableId, user);
        }
        TemplateMapViewModel templateMapViewModel = this.vm;
        if (templateMapViewModel != null) {
            if (user.isMe()) {
                copy$default = templateMapViewModel.m254getSeatButtonState().copy(TemplateMapViewKt.isRoomFull(getMapView()), true);
            } else {
                copy$default = SeatButtonState.copy$default(templateMapViewModel.m254getSeatButtonState(), TemplateMapViewKt.isRoomFull(getMapView()), false, 2, null);
            }
            templateMapViewModel.updateSeatButtonState(copy$default);
            SquareBaseKt.getSquareLog().i(TAG, "sitDown: buttonState=" + copy$default);
        }
    }

    public final void standUp(long tableId, long uin) {
        SeatButtonState copy$default;
        ITemplateViewUpdater iTemplateViewUpdater;
        TemplateMapView<?> mapView = getMapView();
        if (mapView != null && (iTemplateViewUpdater = (ITemplateViewUpdater) mapView.getComponent(ITemplateViewUpdater.class)) != null) {
            iTemplateViewUpdater.standUp(tableId, uin);
        }
        TemplateMapViewModel templateMapViewModel = this.vm;
        if (templateMapViewModel != null) {
            if (SquareBaseKt.getSquareCommon().isCurrentAccount(String.valueOf(uin))) {
                copy$default = templateMapViewModel.m254getSeatButtonState().copy(TemplateMapViewKt.isRoomFull(getMapView()), false);
            } else {
                copy$default = SeatButtonState.copy$default(templateMapViewModel.m254getSeatButtonState(), TemplateMapViewKt.isRoomFull(getMapView()), false, 2, null);
            }
            templateMapViewModel.updateSeatButtonState(copy$default);
            SquareBaseKt.getSquareLog().i(TAG, "standUp: buttonState=" + copy$default);
        }
    }

    public final void standUpOfMe() {
        MapAdapter adapter;
        TemplateMapView<?> mapView = getMapView();
        if (mapView == null || (adapter = mapView.getAdapter()) == null) {
            return;
        }
        MapItem itemData = adapter.getItemData(adapter.getMeIndex());
        if (!(itemData instanceof TemplateAvatarItem)) {
            itemData = null;
        }
        TemplateAvatarItem templateAvatarItem = (TemplateAvatarItem) itemData;
        if (templateAvatarItem != null) {
            standUp(templateAvatarItem);
        }
    }

    public final void switchSelfTable(long tableId, User user, boolean fromFocusFragment) {
        Intrinsics.checkNotNullParameter(user, "user");
        standUpOfMe();
        sitDown(tableId, user);
        if (fromFocusFragment) {
            return;
        }
        backToMySeat();
    }

    public final void toggleSeatButtonVisible() {
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.template.map.component.TemplateUiComponent$toggleSeatButtonVisible$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
            
                if (r1.isTopFragment() == true) goto L10;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                VasBaseFragment fragment;
                View seatButton = TemplateUiComponent.this.getSeatButton();
                if (seatButton != null) {
                    fragment = TemplateUiComponent.this.getFragment();
                    boolean z16 = fragment != null;
                    ViewExtensionsKt.setVisibility(seatButton, z16);
                }
            }
        });
    }

    public final void updateDeskMateTag(String uin, CommonTagInfo tag) {
        ITemplateViewUpdater iTemplateViewUpdater;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(tag, "tag");
        TemplateMapView<?> mapView = getMapView();
        if (mapView == null || (iTemplateViewUpdater = (ITemplateViewUpdater) mapView.getComponent(ITemplateViewUpdater.class)) == null) {
            return;
        }
        iTemplateViewUpdater.updateDeskMateTag(uin, tag);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void updateSeatButtonState(SeatButtonState state);

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        Map<String, Object> mutableMapOf;
        if (v3 != null) {
            int id5 = v3.getId();
            View backIcon = getBackIcon();
            if (backIcon != null && id5 == backIcon.getId()) {
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                Pair[] pairArr = new Pair[1];
                TemplateMapView<?> mapView = getMapView();
                pairArr[0] = TuplesKt.to("zplan_is_focus", Integer.valueOf((mapView == null || !TemplateMapViewKt.isMeSeated(mapView)) ? 0 : 1));
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
                squareReporter.reportEvent("clck", v3, mutableMapOf);
                QBaseActivity activity = getActivity();
                if (activity != null) {
                    activity.doOnBackPressed();
                    return;
                }
                return;
            }
            View seatButton = getSeatButton();
            if (seatButton == null || id5 != seatButton.getId()) {
                return;
            }
            onSeatButtonClick();
        }
    }

    public final void standUp(TemplateAvatarItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        SitDownInfo sitDown = data.getUser().getSitDown();
        if (sitDown != null) {
            standUp(sitDown.getTableId(), data.getUser().getInfo().getUin());
        }
    }
}
