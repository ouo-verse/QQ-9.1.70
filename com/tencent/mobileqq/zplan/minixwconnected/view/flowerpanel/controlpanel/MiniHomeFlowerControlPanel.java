package com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerBasicInfo;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerData;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerOpRspData;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerOpType;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerProp;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerStatus;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerUserInfo;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.minihome.view.j;
import com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController;
import com.tencent.mobileqq.zplan.minixwconnected.report.ZPlanMiniHomeConnectReporter;
import com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel.MiniHomeFlowerControlPanel;
import com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.MiniHomeFlowerPlantingPanelViewModel;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import fi3.bf;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import t74.n;
import tl.h;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 @2\u00020\u0001:\u0003ABCB)\u0012\u0006\u0010=\u001a\u00020<\u0012\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 \u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\u0012\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u0014\u001a\u00020\bJ\u0010\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u001b\u001a\u00020\bJ\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\rR\u001f\u0010&\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\u000e\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b\u000e\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010-R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010/R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/MiniHomeFlowerControlPanel;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/ExperienceTextView;", "f", "experienceView", "Landroid/graphics/Point;", "startPoint", "endPoint", "", "p", "", "width", "i", "", IProfileProtocolConst.PARAM_IS_FRIEND, DomainData.DOMAIN_NAME, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "g", h.F, "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/a;", "callback", IECSearchBar.METHOD_SET_CALLBACK, "Lcom/tencent/filament/zplan/scene/xwconnect/data/b;", "flowerUiData", "j", "o", "Lcom/tencent/filament/zplan/scene/xwconnect/data/c;", "data", "needAnimator", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;", "d", "Lmqq/util/WeakReference;", "getController", "()Lmqq/util/WeakReference;", "controller", "e", "Z", "()Z", "Landroid/view/View;", "contentView", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/MiniHomeFlowerControlPanel$b;", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/MiniHomeFlowerControlPanel$b;", "itemDecoration", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/a;", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/MiniHomeFlowerControlPanel$MiniHomeFlowerActionAdapter;", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/MiniHomeFlowerControlPanel$MiniHomeFlowerActionAdapter;", "flowerActionAdapter", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/filament/zplan/scene/xwconnect/data/b;", "flowerData", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/MiniHomeFlowerProgressBar;", "D", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/MiniHomeFlowerProgressBar;", "progressBar", "E", "Landroid/graphics/Point;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lmqq/util/WeakReference;Z)V", UserInfo.SEX_FEMALE, "a", "MiniHomeFlowerActionAdapter", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeFlowerControlPanel extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private FlowerData flowerData;

    /* renamed from: D, reason: from kotlin metadata */
    private MiniHomeFlowerProgressBar progressBar;

    /* renamed from: E, reason: from kotlin metadata */
    private Point startPoint;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<MiniHomeConnectedController> controller;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isFriend;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View contentView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private b itemDecoration;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private a callback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MiniHomeFlowerActionAdapter flowerActionAdapter;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003!\"#B;\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0015\u0012\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000e0\u0019\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0017J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\tH\u0016R\u001c\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R&\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000e0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/MiniHomeFlowerControlPanel$MiniHomeFlowerActionAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/tencent/filament/zplan/scene/xwconnect/data/d;", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/MiniHomeFlowerControlPanel$MiniHomeFlowerActionAdapter$ActionViewHolder;", "data", "", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "m0", "holder", "position", "", "l0", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lmqq/util/WeakReference;", "controllerRef", "", BdhLogUtil.LogTag.Tag_Conn, "Z", IProfileProtocolConst.PARAM_IS_FRIEND, "Lkotlin/Function2;", "Landroid/graphics/Point;", "D", "Lkotlin/jvm/functions/Function2;", "onSelect", "<init>", "(Lmqq/util/WeakReference;ZLkotlin/jvm/functions/Function2;)V", "E", "ActionViewHolder", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class MiniHomeFlowerActionAdapter extends ListAdapter<FlowerProp, ActionViewHolder> {

        /* renamed from: C, reason: from kotlin metadata */
        private final boolean isFriend;

        /* renamed from: D, reason: from kotlin metadata */
        private final Function2<FlowerProp, Point, Unit> onSelect;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<MiniHomeConnectedController> controllerRef;

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u001f\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010!\u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/MiniHomeFlowerControlPanel$MiniHomeFlowerActionAdapter$ActionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "", DomainData.DOMAIN_NAME, "Lcom/tencent/filament/zplan/scene/xwconnect/data/d;", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;", "E", "Lmqq/util/WeakReference;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lmqq/util/WeakReference;", "controllerRef", "Lfi3/bf;", UserInfo.SEX_FEMALE, "Lfi3/bf;", "p", "()Lfi3/bf;", "binding", "", "G", "Z", ReportConstant.COSTREPORT_PREFIX, "()Z", IProfileProtocolConst.PARAM_IS_FRIEND, "Lcom/tencent/mobileqq/zplan/api/IZPlanMMKVApi;", "H", "Lkotlin/Lazy;", "r", "()Lcom/tencent/mobileqq/zplan/api/IZPlanMMKVApi;", "zplanMMKV", "<init>", "(Lmqq/util/WeakReference;Lfi3/bf;Z)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes34.dex */
        public static final class ActionViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: E, reason: from kotlin metadata */
            private final WeakReference<MiniHomeConnectedController> controllerRef;

            /* renamed from: F, reason: from kotlin metadata */
            private final bf binding;

            /* renamed from: G, reason: from kotlin metadata */
            private final boolean isFriend;

            /* renamed from: H, reason: from kotlin metadata */
            private final Lazy zplanMMKV;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ActionViewHolder(WeakReference<MiniHomeConnectedController> weakReference, bf binding, boolean z16) {
                super(binding.getRoot());
                Lazy lazy;
                Intrinsics.checkNotNullParameter(binding, "binding");
                this.controllerRef = weakReference;
                this.binding = binding;
                this.isFriend = z16;
                lazy = LazyKt__LazyJVMKt.lazy(new Function0<IZPlanMMKVApi>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel.MiniHomeFlowerControlPanel$MiniHomeFlowerActionAdapter$ActionViewHolder$zplanMMKV$2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final IZPlanMMKVApi invoke() {
                        QRouteApi api = QRoute.api(IZPlanMMKVApi.class);
                        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanMMKVApi::class.java)");
                        return (IZPlanMMKVApi) api;
                    }
                });
                this.zplanMMKV = lazy;
                int screenWidth = (int) (ViewUtils.getScreenWidth() * 0.14f);
                View view = this.itemView;
                RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(screenWidth, (int) (screenWidth * 1.0f));
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = ViewUtils.dpToPx(10.0f);
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = ViewUtils.dpToPx(10.0f);
                view.setLayoutParams(layoutParams);
            }

            private final void n(final View view) {
                ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniHomeFlowerControlPanel.MiniHomeFlowerActionAdapter.ActionViewHolder.o(MiniHomeFlowerControlPanel.MiniHomeFlowerActionAdapter.ActionViewHolder.this, view);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void o(final ActionViewHolder this$0, final View view) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(view, "$view");
                if (this$0.r().getBoolean("zplan_show_friend_water_bubble", true)) {
                    CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel.MiniHomeFlowerControlPanel$MiniHomeFlowerActionAdapter$ActionViewHolder$checkNeedShowBubble$1$1
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
                            MiniHomeConnectedController miniHomeConnectedController;
                            ZPlanMiniHomeConnectReporter U;
                            com.tencent.mobileqq.widget.tip.a r16 = QUIDefaultBubbleTip.r(view.getContext());
                            r16.S(view);
                            r16.o0("\u5feb\u5e2e\u4ed6\u6d47\u6c34\u9664\u866b\u5427");
                            r16.k0(0);
                            r16.R(0);
                            r16.m0(1);
                            r16.s0();
                            WeakReference<MiniHomeConnectedController> q16 = this$0.q();
                            if (q16 == null || (miniHomeConnectedController = q16.get()) == null || (U = miniHomeConnectedController.U()) == null) {
                                return;
                            }
                            ZPlanMiniHomeConnectReporter.f(U, view, "em_zplan_remind_bubble", "dt_imp", null, false, false, 40, null);
                        }
                    });
                    this$0.r().setBoolean("zplan_show_friend_water_bubble", false);
                }
            }

            private final IZPlanMMKVApi r() {
                return (IZPlanMMKVApi) this.zplanMMKV.getValue();
            }

            public final void m(FlowerProp data) {
                Intrinsics.checkNotNullParameter(data, "data");
                String iconUrl = data.getIconUrl();
                if (iconUrl != null) {
                    URLImageView uRLImageView = this.binding.f399082b;
                    Intrinsics.checkNotNullExpressionValue(uRLImageView, "binding.propImage");
                    n.e(uRLImageView, iconUrl, R.drawable.gym, null, 4, null);
                }
                if (this.isFriend && data.getOp() == FlowerOpType.WATER) {
                    URLImageView uRLImageView2 = this.binding.f399082b;
                    Intrinsics.checkNotNullExpressionValue(uRLImageView2, "binding.propImage");
                    n(uRLImageView2);
                }
            }

            /* renamed from: p, reason: from getter */
            public final bf getBinding() {
                return this.binding;
            }

            public final WeakReference<MiniHomeConnectedController> q() {
                return this.controllerRef;
            }

            /* renamed from: s, reason: from getter */
            public final boolean getIsFriend() {
                return this.isFriend;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/MiniHomeFlowerControlPanel$MiniHomeFlowerActionAdapter$b;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/filament/zplan/scene/xwconnect/data/d;", "oldItem", "newItem", "", "b", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes34.dex */
        private static final class b extends DiffUtil.ItemCallback<FlowerProp> {
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean areContentsTheSame(FlowerProp oldItem, FlowerProp newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return false;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public boolean areItemsTheSame(FlowerProp oldItem, FlowerProp newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem.getId() == newItem.getId();
            }
        }

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes34.dex */
        public /* synthetic */ class c {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f334666a;

            static {
                int[] iArr = new int[FlowerOpType.values().length];
                try {
                    iArr[FlowerOpType.WATER.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FlowerOpType.REMOVE_BUGS.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[FlowerOpType.SUPPORT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[FlowerOpType.ADD_BUGS.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f334666a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public MiniHomeFlowerActionAdapter(WeakReference<MiniHomeConnectedController> weakReference, boolean z16, Function2<? super FlowerProp, ? super Point, Unit> onSelect) {
            super(new b());
            Intrinsics.checkNotNullParameter(onSelect, "onSelect");
            this.controllerRef = weakReference;
            this.isFriend = z16;
            this.onSelect = onSelect;
        }

        private final String k0(FlowerProp data) {
            int i3 = c.f334666a[data.getOp().ordinal()];
            if (i3 == 1) {
                return "em_zplan_water_btn";
            }
            if (i3 == 2) {
                return "em_zplan_pesticide_btn";
            }
            if (i3 == 3) {
                return "em_zplan_request_help_btn";
            }
            if (i3 != 4) {
                return "";
            }
            return "em_zplan_put_pest";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n0(MiniHomeFlowerActionAdapter this$0, ActionViewHolder this_apply, View it) {
            MiniHomeConnectedController miniHomeConnectedController;
            ZPlanMiniHomeConnectReporter U;
            String str;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            FlowerProp item = this$0.getItem(this_apply.getAdapterPosition());
            if (item != null) {
                QLog.i("MiniHomeFlowerActionAdapter", 1, "action click data=" + item);
                int[] iArr = new int[2];
                it.getLocationOnScreen(iArr);
                Point point = new Point(iArr[0], iArr[1]);
                point.x += it.getWidth() / 2;
                point.y += it.getHeight() / 4;
                this$0.onSelect.invoke(item, point);
                WeakReference<MiniHomeConnectedController> q16 = this_apply.q();
                if (q16 == null || (miniHomeConnectedController = q16.get()) == null || (U = miniHomeConnectedController.U()) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                String k06 = this$0.k0(item);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("zplan_action_type", 0);
                if (this_apply.getIsFriend()) {
                    str = "1";
                } else {
                    str = "0";
                }
                linkedHashMap.put("zplan_zhutai_ketai", str);
                Unit unit = Unit.INSTANCE;
                ZPlanMiniHomeConnectReporter.f(U, it, k06, "dt_clck", linkedHashMap, false, false, 32, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean o0(View v3, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                qi3.b bVar = qi3.b.f428962a;
                Intrinsics.checkNotNullExpressionValue(v3, "v");
                qi3.b.f(bVar, v3, 0.95f, 0L, 4, null);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            qi3.b bVar2 = qi3.b.f428962a;
            Intrinsics.checkNotNullExpressionValue(v3, "v");
            qi3.b.f(bVar2, v3, 1.0f, 0L, 4, null);
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(ActionViewHolder holder, int position) {
            MiniHomeConnectedController miniHomeConnectedController;
            ZPlanMiniHomeConnectReporter U;
            String str;
            Intrinsics.checkNotNullParameter(holder, "holder");
            FlowerProp item = getItem(position);
            if (item == null) {
                return;
            }
            holder.m(item);
            WeakReference<MiniHomeConnectedController> weakReference = this.controllerRef;
            if (weakReference == null || (miniHomeConnectedController = weakReference.get()) == null || (U = miniHomeConnectedController.U()) == null) {
                return;
            }
            View view = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            String k06 = k0(item);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("zplan_action_type", 0);
            if (this.isFriend) {
                str = "1";
            } else {
                str = "0";
            }
            linkedHashMap.put("zplan_zhutai_ketai", str);
            Unit unit = Unit.INSTANCE;
            ZPlanMiniHomeConnectReporter.f(U, view, k06, "dt_imp", linkedHashMap, false, false, 32, null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public ActionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            WeakReference<MiniHomeConnectedController> weakReference = this.controllerRef;
            bf g16 = bf.g(LayoutInflater.from(parent.getContext()));
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n               \u2026ontext)\n                )");
            final ActionViewHolder actionViewHolder = new ActionViewHolder(weakReference, g16, this.isFriend);
            actionViewHolder.getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniHomeFlowerControlPanel.MiniHomeFlowerActionAdapter.n0(MiniHomeFlowerControlPanel.MiniHomeFlowerActionAdapter.this, actionViewHolder, view);
                }
            });
            actionViewHolder.getBinding().getRoot().setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel.c
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean o06;
                    o06 = MiniHomeFlowerControlPanel.MiniHomeFlowerActionAdapter.o0(view, motionEvent);
                    return o06;
                }
            });
            return actionViewHolder;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/MiniHomeFlowerControlPanel$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "spanCount", "e", "spacing", "<init>", "(II)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int spanCount;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int spacing;

        public b(int i3, int i16) {
            this.spanCount = i3;
            this.spacing = i16;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (childAdapterPosition < 0) {
                return;
            }
            int i3 = this.spanCount;
            int i16 = childAdapterPosition % i3;
            int i17 = this.spacing;
            outRect.left = (i16 * i17) / i3;
            outRect.right = i17 - (((i16 + 1) * i17) / i3);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f334669a;

        static {
            int[] iArr = new int[FlowerStatus.values().length];
            try {
                iArr[FlowerStatus.Dead.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FlowerStatus.MaxLevel.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f334669a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeFlowerControlPanel(Context context, WeakReference<MiniHomeConnectedController> weakReference, boolean z16) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.controller = weakReference;
        this.isFriend = z16;
        this.startPoint = new Point();
    }

    private final ExperienceTextView f() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ExperienceTextView experienceTextView = new ExperienceTextView(context, null, 0, 6, null);
        experienceTextView.c();
        experienceTextView.setLayoutParams(new RelativeLayout.LayoutParams(-2, ViewUtils.dpToPx(16.0f)));
        return experienceTextView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Point i(int width) {
        RelativeLayout relativeLayout;
        Point point = new Point();
        View view = this.contentView;
        if (view != null && (relativeLayout = (RelativeLayout) view.findViewById(R.id.f163491qe4)) != null) {
            int[] iArr = new int[2];
            relativeLayout.getLocationOnScreen(iArr);
            point.y = iArr[1];
            point.x = ((iArr[0] + relativeLayout.getWidth()) - width) - ViewUtils.dpToPx(2.0f);
        }
        Point point2 = new Point();
        View view2 = this.contentView;
        if (view2 != null) {
            int[] iArr2 = new int[2];
            view2.getLocationOnScreen(iArr2);
            point2.y = iArr2[1];
            point2.x = iArr2[0];
        }
        return new Point(point.x - point2.x, point.y - point2.y);
    }

    private final void l() {
        FlowerStatus flowerStatus;
        String str;
        FlowerUserInfo userInfo;
        FlowerUserInfo userInfo2;
        FlowerUserInfo userInfo3;
        FlowerBasicInfo basicInfo;
        String flowerName;
        FlowerUserInfo userInfo4;
        String levelIcon;
        View view = this.contentView;
        if (view == null) {
            return;
        }
        URLImageView initProgressBar$lambda$5 = (URLImageView) view.findViewById(R.id.q4v);
        FlowerData flowerData = this.flowerData;
        if (flowerData != null && (userInfo4 = flowerData.getUserInfo()) != null && (levelIcon = userInfo4.getLevelIcon()) != null) {
            Intrinsics.checkNotNullExpressionValue(initProgressBar$lambda$5, "initProgressBar$lambda$5");
            n.f(initProgressBar$lambda$5, levelIcon, null, null, 6, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.pus);
        FlowerData flowerData2 = this.flowerData;
        if (flowerData2 != null && (basicInfo = flowerData2.getBasicInfo()) != null && (flowerName = basicInfo.getFlowerName()) != null) {
            textView.setText(MiniHomeFlowerPlantingPanelViewModel.Companion.b(MiniHomeFlowerPlantingPanelViewModel.INSTANCE, flowerName, 0, 1, null));
        }
        View findViewById = view.findViewById(R.id.f163488qe1);
        MiniHomeFlowerProgressBar miniHomeFlowerProgressBar = (MiniHomeFlowerProgressBar) findViewById;
        FlowerData flowerData3 = this.flowerData;
        if (flowerData3 != null && (userInfo2 = flowerData3.getUserInfo()) != null) {
            int currentExp = userInfo2.getCurrentExp();
            FlowerData flowerData4 = this.flowerData;
            if (flowerData4 != null && (userInfo3 = flowerData4.getUserInfo()) != null) {
                miniHomeFlowerProgressBar.g(currentExp, userInfo3.getLevelUpExp());
            }
        }
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById<MiniHo\u2026current, total)\n        }");
        this.progressBar = miniHomeFlowerProgressBar;
        View findViewById2 = view.findViewById(R.id.put);
        TextView textView2 = (TextView) findViewById2;
        FlowerData flowerData5 = this.flowerData;
        if (flowerData5 == null || (userInfo = flowerData5.getUserInfo()) == null || (flowerStatus = userInfo.getStatus()) == null) {
            flowerStatus = FlowerStatus.Growing;
        }
        int i3 = c.f334669a[flowerStatus.ordinal()];
        if (i3 == 1) {
            str = "\u5df2\u67af\u840e";
        } else if (i3 != 2) {
            str = "\u751f\u957f\u4e2d";
        } else {
            str = "\u5df2\u6ee1\u7ea7";
        }
        textView2.setText(str);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById<TextVi\u2026\"\n            }\n        }");
        ((RelativeLayout) view.findViewById(R.id.f163489qe2)).setVisibility(8);
        ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.rightMargin = 0;
        textView2.setLayoutParams(layoutParams2);
    }

    private final void m(boolean isFriend) {
        FlowerData flowerData;
        FlowerUserInfo userInfo;
        List<FlowerProp> d16;
        View view = this.contentView;
        if (view == null || (flowerData = this.flowerData) == null || (userInfo = flowerData.getUserInfo()) == null || (d16 = userInfo.d()) == null) {
            return;
        }
        MiniHomeFlowerActionAdapter miniHomeFlowerActionAdapter = new MiniHomeFlowerActionAdapter(this.controller, isFriend, new Function2<FlowerProp, Point, Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel.MiniHomeFlowerControlPanel$initRecyclerView$plantingAdapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(FlowerProp flowerProp, Point point) {
                invoke2(flowerProp, point);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FlowerProp flowerProp, Point point) {
                View view2;
                Point point2;
                Point point3;
                a aVar;
                Intrinsics.checkNotNullParameter(flowerProp, "flowerProp");
                Intrinsics.checkNotNullParameter(point, "point");
                QLog.i("MiniHomeFlowerControlPanel", 1, "action text=" + flowerProp.getName() + ", action id=" + flowerProp.getId());
                Point point4 = new Point();
                view2 = MiniHomeFlowerControlPanel.this.contentView;
                if (view2 != null) {
                    int[] iArr = new int[2];
                    view2.getLocationOnScreen(iArr);
                    point4.y = iArr[1];
                    point4.x = iArr[0];
                }
                point2 = MiniHomeFlowerControlPanel.this.startPoint;
                point2.x = point.x - point4.x;
                point3 = MiniHomeFlowerControlPanel.this.startPoint;
                point3.y = point.y - point4.y;
                aVar = MiniHomeFlowerControlPanel.this.callback;
                if (aVar != null) {
                    aVar.a(flowerProp);
                }
            }
        });
        int size = d16.size() <= 4 ? d16.size() : 4;
        int screenWidth = (int) (ViewUtils.getScreenWidth() * 0.05f);
        View findViewById = view.findViewById(R.id.qgo);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.recyclerView)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), size, 1, false));
        recyclerView.setItemAnimator(new j());
        recyclerView.setAdapter(miniHomeFlowerActionAdapter);
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        layoutParams.width = (((int) (ViewUtils.getScreenWidth() * 0.14f)) * size) + ((size - 1) * screenWidth);
        recyclerView.setLayoutParams(layoutParams);
        b bVar = this.itemDecoration;
        if (bVar != null) {
            recyclerView.removeItemDecoration(bVar);
        }
        b bVar2 = new b(size, screenWidth);
        recyclerView.addItemDecoration(bVar2);
        this.itemDecoration = bVar2;
        this.flowerActionAdapter = miniHomeFlowerActionAdapter;
        miniHomeFlowerActionAdapter.submitList(d16);
    }

    private final void n(boolean isFriend) {
        l();
        m(isFriend);
    }

    public final View g() {
        View view = this.contentView;
        if (view != null) {
            return view;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dde, this);
        this.contentView = inflate;
        return inflate;
    }

    public final void h() {
        MiniHomeFlowerProgressBar miniHomeFlowerProgressBar = this.progressBar;
        if (miniHomeFlowerProgressBar != null) {
            miniHomeFlowerProgressBar.d();
        }
    }

    public final void j(FlowerData flowerUiData, boolean isFriend) {
        Intrinsics.checkNotNullParameter(flowerUiData, "flowerUiData");
        this.flowerData = flowerUiData;
        n(isFriend);
    }

    public final void o() {
        WeakReference<MiniHomeConnectedController> weakReference;
        MiniHomeConnectedController miniHomeConnectedController;
        ZPlanMiniHomeConnectReporter U;
        String str;
        Map mutableMapOf;
        MiniHomeFlowerProgressBar miniHomeFlowerProgressBar = this.progressBar;
        if (miniHomeFlowerProgressBar == null || (weakReference = this.controller) == null || (miniHomeConnectedController = weakReference.get()) == null || (U = miniHomeConnectedController.U()) == null) {
            return;
        }
        Pair[] pairArr = new Pair[1];
        if (this.isFriend) {
            str = "1";
        } else {
            str = "0";
        }
        pairArr[0] = TuplesKt.to("zplan_zhutai_ketai", str);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        ZPlanMiniHomeConnectReporter.f(U, miniHomeFlowerProgressBar, "em_zplan_progress_bar", "dt_imp", mutableMapOf, false, false, 32, null);
    }

    public final void q(FlowerOpRspData data, boolean needAnimator) {
        FlowerUserInfo userInfo;
        FlowerUserInfo userInfo2;
        Intrinsics.checkNotNullParameter(data, "data");
        this.flowerData = data.getFlowerData();
        FlowerData flowerData = data.getFlowerData();
        if (flowerData == null || (userInfo = flowerData.getUserInfo()) == null) {
            return;
        }
        int currentExp = userInfo.getCurrentExp();
        FlowerData flowerData2 = data.getFlowerData();
        if (flowerData2 == null || (userInfo2 = flowerData2.getUserInfo()) == null) {
            return;
        }
        int levelUpExp = userInfo2.getLevelUpExp();
        QLog.i("MiniHomeFlowerControlPanel", 1, "updateProgress  " + currentExp + ", " + levelUpExp + ", " + needAnimator);
        MiniHomeFlowerProgressBar miniHomeFlowerProgressBar = this.progressBar;
        int currentProgress = miniHomeFlowerProgressBar != null ? miniHomeFlowerProgressBar.getCurrentProgress() : 0;
        QLog.i("MiniHomeFlowerControlPanel", 1, "updateProgress  " + currentExp + ", " + levelUpExp + ", " + needAnimator + ", preValue: " + currentProgress);
        l();
        MiniHomeFlowerProgressBar miniHomeFlowerProgressBar2 = this.progressBar;
        if (miniHomeFlowerProgressBar2 != null) {
            miniHomeFlowerProgressBar2.l(currentExp, levelUpExp, needAnimator);
        }
        if (needAnimator) {
            final ExperienceTextView f16 = f();
            addView(f16);
            f16.b(currentProgress, currentExp, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel.MiniHomeFlowerControlPanel$updateProgress$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    Point point;
                    Point i16;
                    MiniHomeFlowerControlPanel miniHomeFlowerControlPanel = MiniHomeFlowerControlPanel.this;
                    ExperienceTextView experienceTextView = f16;
                    point = miniHomeFlowerControlPanel.startPoint;
                    i16 = MiniHomeFlowerControlPanel.this.i(i3);
                    miniHomeFlowerControlPanel.p(experienceTextView, point, i16);
                }
            });
        }
    }

    public final void setCallback(a callback) {
        this.callback = callback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(ExperienceTextView experienceView, Point startPoint, Point endPoint) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(experienceView, "translationX", startPoint.x, endPoint.x);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(experienceView, "translationY", startPoint.y, endPoint.y);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(experienceView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.2f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(experienceView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.2f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(experienceView, BasicAnimation.KeyPath.SCALE_X, 1.2f, 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(experienceView, BasicAnimation.KeyPath.SCALE_Y, 1.2f, 0.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(experienceView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).before(ofFloat3);
        animatorSet.play(ofFloat3).with(ofFloat4);
        animatorSet.play(ofFloat5).with(ofFloat6).with(ofFloat7).after(ofFloat3);
        animatorSet.setDuration(500L);
        animatorSet.start();
        animatorSet.addListener(new d(new WeakReference(this), experienceView));
    }

    public static /* synthetic */ void k(MiniHomeFlowerControlPanel miniHomeFlowerControlPanel, FlowerData flowerData, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        miniHomeFlowerControlPanel.j(flowerData, z16);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/MiniHomeFlowerControlPanel$d", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference<MiniHomeFlowerControlPanel> f334670d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ExperienceTextView f334671e;

        d(WeakReference<MiniHomeFlowerControlPanel> weakReference, ExperienceTextView experienceTextView) {
            this.f334670d = weakReference;
            this.f334671e = experienceTextView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator p06) {
            MiniHomeFlowerControlPanel miniHomeFlowerControlPanel = this.f334670d.get();
            if (miniHomeFlowerControlPanel != null) {
                miniHomeFlowerControlPanel.removeView(this.f334671e);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator p06) {
            MiniHomeFlowerControlPanel miniHomeFlowerControlPanel = this.f334670d.get();
            if (miniHomeFlowerControlPanel != null) {
                miniHomeFlowerControlPanel.removeView(this.f334671e);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator p06) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator p06) {
        }
    }
}
