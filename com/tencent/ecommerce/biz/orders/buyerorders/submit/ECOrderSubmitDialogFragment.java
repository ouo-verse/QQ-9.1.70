package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.ecommerce.base.ui.ECFloatGestureLayout;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\f\u0010\b\u001a\u00020\u0005*\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016R\u0016\u0010\u001b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitDialogFragment;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitFragment;", "", "aj", "bj", "", "Yi", "Landroid/os/Bundle;", "Zi", "", "onBackPressed", Constants.FILE_INSTANCE_STATE, "onCreate", "onActivityCreated", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Pi", "Hi", "Ri", "isVisible", "bottomBarHeightPx", "Qi", "", "getBusinessDescription", "w0", "I", NodeProps.MARGIN_TOP, "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "x0", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "floatGestureLayout", "<init>", "()V", "y0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderSubmitDialogFragment extends ECOrderSubmitFragment {

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private int marginTop = 224;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    private ECFloatGestureLayout floatGestureLayout;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitDialogFragment$b", "Lcom/tencent/ecommerce/base/ui/c;", "", "isFromTop", "", "deltaY", "type", "", "onPageClose", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends com.tencent.ecommerce.base.ui.c {
        b() {
        }

        @Override // com.tencent.ecommerce.base.ui.c, com.tencent.ecommerce.base.ui.ECFloatGestureLayout.FloatEventListener
        public void onPageClose(boolean isFromTop, int deltaY, int type) {
            FragmentActivity activity = ECOrderSubmitDialogFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitDialogFragment$c", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout$ContentScrollListener;", "", "getPositionState", "()I", "positionState", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements ECFloatGestureLayout.ContentScrollListener {
        c() {
        }

        @Override // com.tencent.ecommerce.base.ui.ECFloatGestureLayout.ContentScrollListener
        public int getPositionState() {
            return 1;
        }
    }

    private final int Yi() {
        return ((ECDeviceUtils.f104857e.d() - com.tencent.ecommerce.biz.util.e.c(this.marginTop)) - wh()) - com.tencent.ecommerce.base.device.a.d(com.tencent.ecommerce.base.device.a.f100685b, requireActivity(), false, 2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        r4 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(java.lang.String.valueOf(r4.get(com.tencent.ditto.shell.LayoutAttrDefine.MARGIN_TOP)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
    
        r4 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int Zi(Bundle bundle) {
        Integer intOrNull;
        Integer intOrNull2;
        if (bundle.containsKey(LayoutAttrDefine.MARGIN_TOP)) {
            String string = bundle.getString(LayoutAttrDefine.MARGIN_TOP);
            if (string == null || intOrNull2 == null) {
                return 224;
            }
            return intOrNull2.intValue();
        }
        Map<Object, Object> extUserDataMap = com.tencent.ecommerce.base.ktx.a.a(bundle, "ext_userdata").getExtUserDataMap();
        if (!extUserDataMap.containsKey(LayoutAttrDefine.MARGIN_TOP) || intOrNull == null) {
            return 224;
        }
        return intOrNull.intValue();
    }

    private final void bj() {
        ECStateCenterView Ki = Ki();
        ViewGroup.LayoutParams layoutParams = Ki().getLayoutParams();
        layoutParams.height = Yi();
        Unit unit = Unit.INSTANCE;
        Ki.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment
    /* renamed from: Hi, reason: from getter */
    public int getMarginTop() {
        return this.marginTop;
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment
    public boolean Pi() {
        return false;
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment
    public void Ri() {
        ECFloatGestureLayout eCFloatGestureLayout = this.floatGestureLayout;
        if (eCFloatGestureLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
        }
        eCFloatGestureLayout.E();
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment, com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECOrderSubmitDialogFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        yh().setFitsSystemWindows(false);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, com.tencent.ecommerce.base.ui.api.IECFragmentApi
    public boolean onBackPressed() {
        ECFloatGestureLayout eCFloatGestureLayout = this.floatGestureLayout;
        if (eCFloatGestureLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
        }
        eCFloatGestureLayout.E();
        return true;
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment, com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        int intValue;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null || (intValue = Integer.valueOf(Zi(arguments)).intValue()) <= 0) {
            return;
        }
        this.marginTop = intValue;
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment, com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        aj();
        bj();
    }

    private final void aj() {
        Boolean bool = Boolean.TRUE;
        ECFloatGestureLayout eCFloatGestureLayout = new ECFloatGestureLayout(requireContext(), BundleKt.bundleOf(TuplesKt.to("mask_view_trans", bool), TuplesKt.to("scroll_to_top", Boolean.FALSE), TuplesKt.to("disallow_pulling", bool), TuplesKt.to("scroll_margin_top", Integer.valueOf(this.marginTop)), TuplesKt.to("margin_top_ignore_bottom_bar", bool)));
        this.floatGestureLayout = eCFloatGestureLayout;
        eCFloatGestureLayout.setFloatEventListener(new b());
        ECFloatGestureLayout eCFloatGestureLayout2 = this.floatGestureLayout;
        if (eCFloatGestureLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
        }
        eCFloatGestureLayout2.setContentScrollListener(new c());
        ECFloatGestureLayout eCFloatGestureLayout3 = this.floatGestureLayout;
        if (eCFloatGestureLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
        }
        eCFloatGestureLayout3.C(this, -1, R.id.nrj);
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment
    public void Qi(boolean isVisible, int bottomBarHeightPx) {
        if (!isVisible) {
            bottomBarHeightPx = 0;
        }
        int Yi = Yi() - bottomBarHeightPx;
        RecyclerView recyclerView = getRecyclerView();
        ViewGroup.LayoutParams layoutParams = getRecyclerView().getLayoutParams();
        layoutParams.height = Yi;
        Unit unit = Unit.INSTANCE;
        recyclerView.setLayoutParams(layoutParams);
    }
}
