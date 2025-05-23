package com.tencent.ecommerce.biz.coupon.myshopping;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ui.ECFloatGestureLayout;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import qh0.ECMyShoppingActionSheetItemData;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/ecommerce/biz/coupon/myshopping/ECMyShoppingActionSheetFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "Lqh0/a;", "itemsData", "", "Ph", "(Landroid/view/View;[Lqh0/a;)V", "Landroid/content/Context;", "context", "data", "Mh", "", "itemCount", "Oh", "Nh", "()[Lqh0/a;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "onBackPressed", "getContentLayoutId", "", "getBusinessDescription", "Eh", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "P", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "floatGestureLayout", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECMyShoppingActionSheetFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private ECFloatGestureLayout floatGestureLayout;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ECMyShoppingActionSheetItemData f101967e;

        b(ECMyShoppingActionSheetItemData eCMyShoppingActionSheetItemData) {
            this.f101967e = eCMyShoppingActionSheetItemData;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECMyShoppingActionSheetFragment.Lh(ECMyShoppingActionSheetFragment.this).E();
            ECMyShoppingActionSheetItemData eCMyShoppingActionSheetItemData = this.f101967e;
            ECScheme.g(eCMyShoppingActionSheetItemData != null ? eCMyShoppingActionSheetItemData.scheme : null, null, 2, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/coupon/myshopping/ECMyShoppingActionSheetFragment$c", "Lcom/tencent/ecommerce/base/ui/c;", "", "isFromTop", "", "deltaY", "type", "", "onPageClose", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c extends com.tencent.ecommerce.base.ui.c {
        c() {
        }

        @Override // com.tencent.ecommerce.base.ui.c, com.tencent.ecommerce.base.ui.ECFloatGestureLayout.FloatEventListener
        public void onPageClose(boolean isFromTop, int deltaY, int type) {
            FragmentActivity activity = ECMyShoppingActionSheetFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public static final /* synthetic */ ECFloatGestureLayout Lh(ECMyShoppingActionSheetFragment eCMyShoppingActionSheetFragment) {
        ECFloatGestureLayout eCFloatGestureLayout = eCMyShoppingActionSheetFragment.floatGestureLayout;
        if (eCFloatGestureLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
        }
        return eCFloatGestureLayout;
    }

    private final View Mh(Context context, ECMyShoppingActionSheetItemData data) {
        ECMyShoppingActionSheetItem eCMyShoppingActionSheetItem = new ECMyShoppingActionSheetItem(context, null);
        eCMyShoppingActionSheetItem.setItemData(data);
        eCMyShoppingActionSheetItem.setOnClickListener(new b(data));
        return eCMyShoppingActionSheetItem;
    }

    private final void Oh(int itemCount) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("scroll_to_top", false);
        bundle.putInt("scroll_margin_top", (int) (ECDeviceUtils.f104857e.i(r1.d()) - ((itemCount * 56) + 16)));
        ECFloatGestureLayout eCFloatGestureLayout = new ECFloatGestureLayout(requireContext(), bundle);
        this.floatGestureLayout = eCFloatGestureLayout;
        eCFloatGestureLayout.setFloatEventListener(new c());
        ECFloatGestureLayout eCFloatGestureLayout2 = this.floatGestureLayout;
        if (eCFloatGestureLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
        }
        eCFloatGestureLayout2.C(this, -1, -1);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECMyShoppingActionSheetFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cq8;
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

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ECMyShoppingActionSheetItemData[] Nh = Nh();
        Ph(view, Nh);
        Oh(Nh.length);
    }

    private final ECMyShoppingActionSheetItemData[] Nh() {
        return new ECMyShoppingActionSheetItemData[]{new ECMyShoppingActionSheetItemData(R.drawable.e9u, "\u6211\u7684\u8ba2\u5355", "mqqapi://ecommerce/open?target=2"), new ECMyShoppingActionSheetItemData(R.drawable.e9u, "\u6211\u7684\u4f18\u60e0\u5238", "mqqapi://ecommerce/open?target=52&page_name=my_coupon_list")};
    }

    private final void Ph(View rootView, ECMyShoppingActionSheetItemData[] itemsData) {
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.o4y);
        for (ECMyShoppingActionSheetItemData eCMyShoppingActionSheetItemData : itemsData) {
            linearLayout.addView(Mh(requireContext(), eCMyShoppingActionSheetItemData));
        }
    }
}
