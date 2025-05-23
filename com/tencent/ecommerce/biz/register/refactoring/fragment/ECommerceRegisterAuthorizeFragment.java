package com.tencent.ecommerce.biz.register.refactoring.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ui.ECFloatGestureLayout;
import com.tencent.ecommerce.biz.register.a;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u0000 02\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0016J\u001a\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020&8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010-\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010(\u00a8\u00062"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceRegisterAuthorizeFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "initUI", "Th", "initListener", "", "resultValue", "Uh", "Vh", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getBusinessDescription", "", "Eh", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "P", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "registerAuthorizeFloatWindow", "Landroid/widget/RelativeLayout;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/RelativeLayout;", "pageRootView", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/LinearLayout;", "infoContainerView", "Landroid/widget/Button;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/Button;", "cancelBtn", "T", "confirmBtn", "", "U", UserInfo.SEX_FEMALE, "viewHeight", "V", "defaultScrollViewHeight", "W", "scrollViewHeight", "<init>", "()V", "X", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECommerceRegisterAuthorizeFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private ECFloatGestureLayout registerAuthorizeFloatWindow;

    /* renamed from: Q, reason: from kotlin metadata */
    private RelativeLayout pageRootView;

    /* renamed from: R, reason: from kotlin metadata */
    private LinearLayout infoContainerView;

    /* renamed from: S, reason: from kotlin metadata */
    private Button cancelBtn;

    /* renamed from: T, reason: from kotlin metadata */
    private Button confirmBtn;

    /* renamed from: U, reason: from kotlin metadata */
    private float viewHeight = 115.0f;

    /* renamed from: V, reason: from kotlin metadata */
    private final float defaultScrollViewHeight = 250.0f;

    /* renamed from: W, reason: from kotlin metadata */
    private float scrollViewHeight = 250.0f;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceRegisterAuthorizeFragment$b", "Lcom/tencent/ecommerce/base/ui/c;", "", "isFromTop", "", "deltaY", "type", "", "onPageClose", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends com.tencent.ecommerce.base.ui.c {
        b() {
        }

        @Override // com.tencent.ecommerce.base.ui.c, com.tencent.ecommerce.base.ui.ECFloatGestureLayout.FloatEventListener
        public void onPageClose(boolean isFromTop, int deltaY, int type) {
            FragmentActivity activity = ECommerceRegisterAuthorizeFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceRegisterAuthorizeFragment$c", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout$ContentScrollListener;", "", "getPositionState", "()I", "positionState", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements ECFloatGestureLayout.ContentScrollListener {
        c() {
        }

        @Override // com.tencent.ecommerce.base.ui.ECFloatGestureLayout.ContentScrollListener
        public int getPositionState() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECommerceRegisterAuthorizeFragment.this.Uh(0);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECommerceRegisterAuthorizeFragment.this.Uh(1);
            a.f103962b.a();
            hg0.a.c(hg0.a.f404850b, "ECRegisterUserCertificationConfirm", null, 2, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static final /* synthetic */ LinearLayout Nh(ECommerceRegisterAuthorizeFragment eCommerceRegisterAuthorizeFragment) {
        LinearLayout linearLayout = eCommerceRegisterAuthorizeFragment.infoContainerView;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoContainerView");
        }
        return linearLayout;
    }

    public static final /* synthetic */ RelativeLayout Oh(ECommerceRegisterAuthorizeFragment eCommerceRegisterAuthorizeFragment) {
        RelativeLayout relativeLayout = eCommerceRegisterAuthorizeFragment.pageRootView;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageRootView");
        }
        return relativeLayout;
    }

    private final void Th() {
        LinearLayout linearLayout = this.infoContainerView;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoContainerView");
        }
        linearLayout.post(new Runnable() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceRegisterAuthorizeFragment$dynamicCalScrollViewHeight$1
            @Override // java.lang.Runnable
            public final void run() {
                float f16;
                float f17;
                float f18;
                float f19;
                float f26;
                ECommerceRegisterAuthorizeFragment.Nh(ECommerceRegisterAuthorizeFragment.this).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                ECommerceRegisterAuthorizeFragment eCommerceRegisterAuthorizeFragment = ECommerceRegisterAuthorizeFragment.this;
                ECDeviceUtils eCDeviceUtils = ECDeviceUtils.f104857e;
                eCommerceRegisterAuthorizeFragment.scrollViewHeight = eCDeviceUtils.i(ECommerceRegisterAuthorizeFragment.Nh(eCommerceRegisterAuthorizeFragment).getHeight());
                f16 = ECommerceRegisterAuthorizeFragment.this.viewHeight;
                f17 = ECommerceRegisterAuthorizeFragment.this.scrollViewHeight;
                if (f16 + f17 > eCDeviceUtils.i(eCDeviceUtils.d())) {
                    ECommerceRegisterAuthorizeFragment eCommerceRegisterAuthorizeFragment2 = ECommerceRegisterAuthorizeFragment.this;
                    f26 = eCommerceRegisterAuthorizeFragment2.defaultScrollViewHeight;
                    eCommerceRegisterAuthorizeFragment2.scrollViewHeight = f26;
                }
                ViewGroup.LayoutParams layoutParams = ECommerceRegisterAuthorizeFragment.Oh(ECommerceRegisterAuthorizeFragment.this).getLayoutParams();
                f18 = ECommerceRegisterAuthorizeFragment.this.viewHeight;
                f19 = ECommerceRegisterAuthorizeFragment.this.scrollViewHeight;
                layoutParams.height = (int) (f18 + f19);
                ECommerceRegisterAuthorizeFragment.Oh(ECommerceRegisterAuthorizeFragment.this).setLayoutParams(layoutParams);
                ECommerceRegisterAuthorizeFragment.Oh(ECommerceRegisterAuthorizeFragment.this).setVisibility(0);
                ECommerceRegisterAuthorizeFragment.this.Vh();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Uh(int resultValue) {
        Intent intent = new Intent();
        intent.putExtra("authorize_page_result_key", resultValue);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(2, intent);
        }
        ECFloatGestureLayout eCFloatGestureLayout = this.registerAuthorizeFloatWindow;
        if (eCFloatGestureLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("registerAuthorizeFloatWindow");
        }
        eCFloatGestureLayout.E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("scroll_to_top", false);
        bundle.putBoolean("need_pop_anim", true);
        bundle.putInt("container_color", R.color.f6491p);
        int i3 = (int) (ECDeviceUtils.f104857e.i(r1.d()) - (this.viewHeight + this.scrollViewHeight));
        bundle.putBoolean("disallow_pulling", true);
        bundle.putInt("scroll_margin_top", i3);
        ECFloatGestureLayout eCFloatGestureLayout = new ECFloatGestureLayout(requireContext(), bundle);
        this.registerAuthorizeFloatWindow = eCFloatGestureLayout;
        eCFloatGestureLayout.setFloatEventListener(new b());
        ECFloatGestureLayout eCFloatGestureLayout2 = this.registerAuthorizeFloatWindow;
        if (eCFloatGestureLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("registerAuthorizeFloatWindow");
        }
        eCFloatGestureLayout2.setContentScrollListener(new c());
        ECFloatGestureLayout eCFloatGestureLayout3 = this.registerAuthorizeFloatWindow;
        if (eCFloatGestureLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("registerAuthorizeFloatWindow");
        }
        eCFloatGestureLayout3.C(this, -1, R.id.nrl);
    }

    private final void initListener() {
        Button button = this.cancelBtn;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelBtn");
        }
        button.setOnClickListener(new d());
        Button button2 = this.confirmBtn;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
        }
        button2.setOnClickListener(new e());
    }

    private final void initUI() {
        yh().setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.f7153h));
        this.pageRootView = (RelativeLayout) yh().findViewById(R.id.nq9);
        this.cancelBtn = (Button) yh().findViewById(R.id.nxc);
        this.confirmBtn = (Button) yh().findViewById(R.id.nxf);
        this.infoContainerView = (LinearLayout) yh().findViewById(R.id.nq7);
        Th();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECommerceRegisterAuthorizeFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cvg;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI();
        initListener();
    }
}
