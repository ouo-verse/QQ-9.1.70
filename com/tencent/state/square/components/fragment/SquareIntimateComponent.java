package com.tencent.state.square.components.fragment;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.map.IMapItemViewManager;
import com.tencent.state.map.MapContainer;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.SquareViewModel;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.api.ISquarePagViewListener;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareIntimateInfo;
import com.tencent.state.square.holder.AvatarViewHolder;
import com.tencent.state.utils.SquareIntimateUtil;
import com.tencent.state.utils.SquareSwitchUtils;
import com.tencent.state.utils.VMUtils;
import com.tencent.state.utils.ViewUtils;
import com.tencent.state.view.SquareImageView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 )2\u00020\u0001:\u0001)B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J\u0006\u0010\u0017\u001a\u00020\rJ*\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001eH\u0016J2\u0010\u001f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u00030 j\u0002`!2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\"\u001a\u00020\u001dH\u0016J*\u0010#\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u00030 j\u0002`!2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001eH\u0016J*\u0010$\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u00030 j\u0002`!2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001eH\u0016J \u0010%\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0011H\u0002J\u0010\u0010'\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010(\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareIntimateComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "()V", "hardware", "", "kotlin.jvm.PlatformType", "getHardware", "()Ljava/lang/String;", "hardware$delegate", "Lkotlin/Lazy;", "squareGroupVM", "Lcom/tencent/state/square/SquareViewModel;", "addPagViewInScreen", "", "vh", "Lcom/tencent/state/square/holder/AvatarViewHolder;", NodeProps.VISIBLE, "", "bindIntimate", "data", "Lcom/tencent/state/square/data/SquareAvatarItem;", "hidePagView", "stop", "initialize", "onCenterScaled", "isScaleToCenter", "view", "Landroid/view/View;", "index", "", "Lcom/tencent/state/map/MapItem;", "onDoubleClick", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "viewId", "onItemBind", "onVisible", "playIntimateAnimation", "auto", "preparePagEnv", "tryPlayIntimateAnimation", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareIntimateComponent extends SquareBaseComponent {
    private static final String TAG = "SquareIntimateComponent";

    /* renamed from: hardware$delegate, reason: from kotlin metadata */
    private final Lazy hardware;
    private SquareViewModel squareGroupVM;

    public SquareIntimateComponent() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.state.square.components.fragment.SquareIntimateComponent$hardware$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return Build.HARDWARE;
            }
        });
        this.hardware = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addPagViewInScreen(AvatarViewHolder vh5, boolean visible) {
        SquareView mapView;
        MapContainer container;
        VasBaseFragment fragment = getFragment();
        if (!(fragment instanceof SquareFragment)) {
            fragment = null;
        }
        SquareFragment squareFragment = (SquareFragment) fragment;
        if (squareFragment == null || (mapView = squareFragment.getMapView()) == null || (container = mapView.getContainer()) == null) {
            return;
        }
        FrameLayout mContainer = vh5.getBinding().getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "vh.binding.root");
        ISquarePagView intimateBackPagView = vh5.getIntimateBackPagView();
        if (intimateBackPagView != null) {
            View view = intimateBackPagView.getView();
            view.setVisibility(visible ? 0 : 8);
            if (view.getParent() == null) {
                view.setLayoutParams(mContainer.getLayoutParams());
                container.addView(view, 0);
            }
        }
        ISquarePagView intimateFrontPagView = vh5.getIntimateFrontPagView();
        if (intimateFrontPagView != null) {
            View view2 = intimateFrontPagView.getView();
            view2.setVisibility(visible ? 0 : 8);
            if (view2.getParent() == null) {
                view2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                mContainer.addView(view2);
            }
        }
    }

    private final String getHardware() {
        return (String) this.hardware.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hidePagView(AvatarViewHolder vh5, boolean stop) {
        ISquarePagView intimateBackPagView = vh5.getIntimateBackPagView();
        if (intimateBackPagView != null) {
            if (stop) {
                intimateBackPagView.stop();
            }
            View pagView = intimateBackPagView.getPagView();
            if (pagView != null) {
                pagView.setVisibility(8);
            }
            intimateBackPagView.getView().setVisibility(8);
        }
        ISquarePagView intimateFrontPagView = vh5.getIntimateFrontPagView();
        if (intimateFrontPagView != null) {
            if (stop) {
                intimateFrontPagView.stop();
            }
            View pagView2 = intimateFrontPagView.getPagView();
            if (pagView2 != null) {
                pagView2.setVisibility(8);
            }
            intimateFrontPagView.getView().setVisibility(8);
        }
    }

    private final void playIntimateAnimation(AvatarViewHolder vh5, SquareAvatarItem data, boolean auto) {
        Map<String, Object> mutableMapOf;
        boolean startsWith$default;
        if (SquareSwitchUtils.INSTANCE.disableIntimateMTK()) {
            String hardware = getHardware();
            Intrinsics.checkNotNullExpressionValue(hardware, "hardware");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(hardware, "mt", false, 2, null);
            if (startsWith$default) {
                SquareBaseKt.getSquareLog().w(TAG, "Can not play intimate animation: " + getHardware());
                return;
            }
        }
        if (data.isMe() || data.getExtra().getIntimateExtra() == null) {
            return;
        }
        preparePagEnv(vh5);
        SquareIntimateUtil squareIntimateUtil = SquareIntimateUtil.INSTANCE;
        ISquarePagView intimateFrontPagView = vh5.getIntimateFrontPagView();
        Intrinsics.checkNotNull(intimateFrontPagView);
        ISquarePagView intimateBackPagView = vh5.getIntimateBackPagView();
        Intrinsics.checkNotNull(intimateBackPagView);
        SquareIntimateInfo intimateExtra = data.getExtra().getIntimateExtra();
        Intrinsics.checkNotNull(intimateExtra);
        squareIntimateUtil.showAnimation(intimateFrontPagView, intimateBackPagView, intimateExtra);
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_INTIMATE_UIN, data.getUin());
        pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_INTIMATE_ANIMATION_TYPE, Integer.valueOf(auto ? 1 : 2));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        squareReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_INTIMATE_ANIMATION, mutableMapOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void preparePagEnv(final AvatarViewHolder vh5) {
        Context context;
        SquareView mapView;
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (context = fragment.getContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "fragment?.context ?: return");
        VasBaseFragment fragment2 = getFragment();
        if (!(fragment2 instanceof SquareFragment)) {
            fragment2 = null;
        }
        SquareFragment squareFragment = (SquareFragment) fragment2;
        if (squareFragment == null || (mapView = squareFragment.getMapView()) == null || mapView.getContainer() == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(vh5.getBinding().getMContainer(), "vh.binding.root");
        if (vh5.getIntimateBackPagView() == null) {
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("preparePagEnv-back: ");
            SquareAvatarItem squareAvatarItem = (SquareAvatarItem) vh5.getData();
            sb5.append(squareAvatarItem != null ? squareAvatarItem.getUin() : null);
            squareLog.d(TAG, sb5.toString());
            vh5.setIntimateBackPagView(Square.INSTANCE.getConfig().getCommonUtils().getPagView(context));
        }
        if (vh5.getIntimateFrontPagView() == null) {
            SquareLogger squareLog2 = SquareBaseKt.getSquareLog();
            StringBuilder sb6 = new StringBuilder();
            sb6.append("preparePagEnv-front: ");
            SquareAvatarItem squareAvatarItem2 = (SquareAvatarItem) vh5.getData();
            sb6.append(squareAvatarItem2 != null ? squareAvatarItem2.getUin() : null);
            squareLog2.d(TAG, sb6.toString());
            vh5.setIntimateFrontPagView(Square.INSTANCE.getConfig().getCommonUtils().getPagView(context));
            ISquarePagView intimateFrontPagView = vh5.getIntimateFrontPagView();
            if (intimateFrontPagView != null) {
                intimateFrontPagView.setPagViewListener(new ISquarePagViewListener() { // from class: com.tencent.state.square.components.fragment.SquareIntimateComponent$preparePagEnv$1
                    @Override // com.tencent.state.square.api.ISquarePagViewListener
                    public void onAnimationCancel(ISquarePagView iSquarePagView) {
                        ISquarePagViewListener.DefaultImpls.onAnimationCancel(this, iSquarePagView);
                    }

                    @Override // com.tencent.state.square.api.ISquarePagViewListener
                    public void onAnimationEnd(ISquarePagView squarePagView) {
                        ViewPropertyAnimator alpha = vh5.getBinding().avatarTopContentContainer.animate().alpha(1.0f);
                        Intrinsics.checkNotNullExpressionValue(alpha, "vh.binding.avatarTopCont\u2026ner.animate().alpha(1.0f)");
                        alpha.setDuration(250L);
                        ViewPropertyAnimator alpha2 = vh5.getBinding().squareAvatarHeartContainer.animate().alpha(1.0f);
                        Intrinsics.checkNotNullExpressionValue(alpha2, "vh.binding.squareAvatarH\u2026ner.animate().alpha(1.0f)");
                        alpha2.setDuration(250L);
                        SquareIntimateComponent.this.hidePagView(vh5, false);
                    }

                    @Override // com.tencent.state.square.api.ISquarePagViewListener
                    public void onAnimationRepeat(ISquarePagView iSquarePagView) {
                        ISquarePagViewListener.DefaultImpls.onAnimationRepeat(this, iSquarePagView);
                    }

                    @Override // com.tencent.state.square.api.ISquarePagViewListener
                    public void onAnimationStart(ISquarePagView squarePagView) {
                        ViewPropertyAnimator alpha = vh5.getBinding().avatarTopContentContainer.animate().alpha(0.0f);
                        Intrinsics.checkNotNullExpressionValue(alpha, "vh.binding.avatarTopCont\u2026ner.animate().alpha(0.0f)");
                        alpha.setDuration(250L);
                        ViewPropertyAnimator alpha2 = vh5.getBinding().squareAvatarHeartContainer.animate().alpha(0.0f);
                        Intrinsics.checkNotNullExpressionValue(alpha2, "vh.binding.squareAvatarH\u2026ner.animate().alpha(0.0f)");
                        alpha2.setDuration(250L);
                        SquareIntimateComponent.this.addPagViewInScreen(vh5, true);
                    }

                    @Override // com.tencent.state.square.api.ISquarePagViewListener
                    public void onAnimationUpdate(ISquarePagView iSquarePagView) {
                        ISquarePagViewListener.DefaultImpls.onAnimationUpdate(this, iSquarePagView);
                    }
                });
            }
        }
        addPagViewInScreen(vh5, false);
    }

    private final void tryPlayIntimateAnimation(AvatarViewHolder vh5, SquareAvatarItem data) {
        LiveData<Boolean> isScaleAnimDone;
        if (data.getExtra().getNeedIntimateAnim()) {
            SquareViewModel squareViewModel = this.squareGroupVM;
            if (Intrinsics.areEqual((squareViewModel == null || (isScaleAnimDone = squareViewModel.isScaleAnimDone()) == null) ? null : isScaleAnimDone.getValue(), Boolean.TRUE)) {
                data.getExtra().setNeedIntimateAnim(false);
                playIntimateAnimation(vh5, data, true);
            }
        }
    }

    public final void initialize() {
        final VasBaseFragment fragment;
        LiveData<Boolean> isScaleAnimDone;
        VasBaseFragment parentFragment = getParentFragment();
        if (parentFragment == null || (fragment = getFragment()) == null) {
            return;
        }
        SquareViewModel squareViewModel = (SquareViewModel) VMUtils.INSTANCE.safelyGet(parentFragment, SquareViewModel.class);
        this.squareGroupVM = squareViewModel;
        if (squareViewModel == null || (isScaleAnimDone = squareViewModel.isScaleAnimDone()) == null) {
            return;
        }
        isScaleAnimDone.observe(fragment, new Observer<Boolean>() { // from class: com.tencent.state.square.components.fragment.SquareIntimateComponent$initialize$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Boolean flag) {
                Intrinsics.checkNotNullExpressionValue(flag, "flag");
                if (flag.booleanValue()) {
                    SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.components.fragment.SquareIntimateComponent$initialize$1.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r5v0, types: [com.tencent.state.map.MapItem] */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IMapItemViewManager screenViewManager;
                            Set<Integer> visibleIndexSet;
                            VasBaseFragment vasBaseFragment = fragment;
                            if (!(vasBaseFragment instanceof SquareFragment)) {
                                vasBaseFragment = null;
                            }
                            SquareFragment squareFragment = (SquareFragment) vasBaseFragment;
                            if (squareFragment == null || (screenViewManager = squareFragment.getScreenViewManager()) == null || (visibleIndexSet = screenViewManager.getVisibleIndexSet()) == null) {
                                return;
                            }
                            Iterator<T> it = visibleIndexSet.iterator();
                            while (it.hasNext()) {
                                int intValue = ((Number) it.next()).intValue();
                                SquareView mapView = SquareIntimateComponent.this.getMapView();
                                MapViewHolder<?> viewHolder = mapView != null ? mapView.getViewHolder(intValue) : null;
                                if (viewHolder != null) {
                                    SquareIntimateComponent.this.onVisible(viewHolder, intValue, viewHolder.getData());
                                }
                            }
                        }
                    });
                }
            }
        });
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.map.IMapViewListener
    public void onCenterScaled(boolean isScaleToCenter, View view, int index, MapItem data) {
        Intrinsics.checkNotNullParameter(view, "view");
        SquareView mapView = getMapView();
        MapViewHolder<?> viewHolder = mapView != null ? mapView.getViewHolder(index) : null;
        if (viewHolder instanceof AvatarViewHolder) {
            hidePagView((AvatarViewHolder) viewHolder, true);
        }
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.map.IMapViewListener
    public void onDoubleClick(MapViewHolder<?> vh5, int index, MapItem data, int viewId) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        if (viewId == 8 && (data instanceof SquareAvatarItem) && (vh5 instanceof AvatarViewHolder)) {
            playIntimateAnimation((AvatarViewHolder) vh5, (SquareAvatarItem) data, false);
        }
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.map.IMapViewListener
    public void onItemBind(MapViewHolder<?> vh5, int index, MapItem data) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        if ((data instanceof SquareAvatarItem) && (vh5 instanceof AvatarViewHolder)) {
            bindIntimate((AvatarViewHolder) vh5, (SquareAvatarItem) data);
        }
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.map.IMapViewListener
    public void onVisible(MapViewHolder<?> vh5, int index, MapItem data) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        if ((data instanceof SquareAvatarItem) && (vh5 instanceof AvatarViewHolder)) {
            tryPlayIntimateAnimation((AvatarViewHolder) vh5, (SquareAvatarItem) data);
        }
    }

    private final void bindIntimate(AvatarViewHolder vh5, SquareAvatarItem data) {
        Map<String, Object> mutableMapOf;
        IMapItemViewManager screenViewManager;
        String iconUrl;
        hidePagView(vh5, true);
        SquareImageView intimateIcon = vh5.getBinding().composedAvatar.getIntimateIcon();
        if (!data.isMe() && data.getExtra().getIntimateExtra() != null) {
            SquareIntimateInfo intimateExtra = data.getExtra().getIntimateExtra();
            if (intimateExtra != null && (iconUrl = intimateExtra.getIconUrl()) != null) {
                intimateIcon.setVisibility(0);
                ViewUtils.INSTANCE.loadImageDrawable(iconUrl, intimateIcon);
            }
            SquareBaseKt.getSquareReporter().setElementInfo(intimateIcon, SquareReportConst.ElementId.ELEMENT_ID_INTIMATE_ICON, new LinkedHashMap(), false, false);
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_INTIMATE_UIN, data.getUin()));
            squareReporter.reportEvent("imp", intimateIcon, mutableMapOf);
            VasBaseFragment fragment = getFragment();
            if (!(fragment instanceof SquareFragment)) {
                fragment = null;
            }
            SquareFragment squareFragment = (SquareFragment) fragment;
            if (squareFragment == null || (screenViewManager = squareFragment.getScreenViewManager()) == null || !screenViewManager.isMostInScreen(data.getUin())) {
                return;
            }
            tryPlayIntimateAnimation(vh5, data);
            return;
        }
        intimateIcon.setVisibility(8);
        data.getExtra().setNeedIntimateAnim(false);
    }
}
