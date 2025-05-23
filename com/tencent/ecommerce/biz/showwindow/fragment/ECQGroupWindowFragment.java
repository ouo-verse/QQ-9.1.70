package com.tencent.ecommerce.biz.showwindow.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.showwindow.viewmodel.ECQGroupWindowViewModel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import fj0.a;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$\u00a8\u0006,"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/fragment/ECQGroupWindowFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "Oh", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initUI", "initData", "Ph", "Qh", "showLoadingView", "hideLoadingView", "", "getContentLayoutId", "", "getBusinessDescription", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/ecommerce/biz/showwindow/viewmodel/ECQGroupWindowViewModel;", "P", "Lkotlin/Lazy;", "Nh", "()Lcom/tencent/ecommerce/biz/showwindow/viewmodel/ECQGroupWindowViewModel;", "groupWindowViewModel", "Landroid/widget/LinearLayout;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/LinearLayout;", "containerView", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/ImageView;", "loadingView", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/String;", "groupId", "T", "showWindowScheme", "<init>", "()V", "U", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECQGroupWindowFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy groupWindowViewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    private LinearLayout containerView;

    /* renamed from: R, reason: from kotlin metadata */
    private ImageView loadingView;

    /* renamed from: S, reason: from kotlin metadata */
    private String groupId;

    /* renamed from: T, reason: from kotlin metadata */
    private String showWindowScheme;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b<T> implements Observer<String> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(String str) {
            ECQGroupWindowFragment.this.hideLoadingView();
            if (TextUtils.isEmpty(ECQGroupWindowFragment.this.showWindowScheme)) {
                ECScheme.g(str, null, 2, null);
            }
            ECQGroupWindowFragment.this.requireActivity().finish();
        }
    }

    public ECQGroupWindowFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECQGroupWindowFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.groupWindowViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECQGroupWindowViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECQGroupWindowFragment$$special$$inlined$viewModels$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).get_viewModelStore();
                Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        this.groupId = "";
        this.showWindowScheme = "";
    }

    private final ECQGroupWindowViewModel Nh() {
        return (ECQGroupWindowViewModel) this.groupWindowViewModel.getValue();
    }

    private final void Oh() {
        String string;
        Bundle arguments = getArguments();
        String str = "";
        if (arguments != null && (string = arguments.getString("group_id", "")) != null) {
            str = string;
        }
        this.groupId = str;
    }

    private final void Ph() {
        Nh().Q1().observe(getViewLifecycleOwner(), new b());
    }

    private final void Qh() {
        Nh().R1(this.groupId);
        a.f399472a.a(this.groupId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideLoadingView() {
        ImageView imageView = this.loadingView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        }
        imageView.clearAnimation();
        LinearLayout linearLayout = this.containerView;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        }
        linearLayout.setVisibility(8);
    }

    private final void initData() {
        showLoadingView();
        Qh();
    }

    private final void showLoadingView() {
        LinearLayout linearLayout = this.containerView;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        }
        linearLayout.setVisibility(0);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000L);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setFillAfter(true);
        ImageView imageView = this.loadingView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        }
        imageView.startAnimation(rotateAnimation);
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECQGroupLinkFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cqn;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Oh();
        this.showWindowScheme = Nh().P1(this.groupId);
        cg0.a.b("ECQGroupLinkFragment", "[onCreate] group_id=" + this.groupId + " showWindowScheme=" + this.showWindowScheme);
        if (TextUtils.isEmpty(this.showWindowScheme)) {
            return;
        }
        ECScheme.g(this.showWindowScheme, null, 2, null);
        Qh();
        requireActivity().finish();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        Ph();
        initData();
    }

    private final void initUI(View rootView) {
        this.containerView = (LinearLayout) rootView.findViewById(R.id.o0m);
        this.loadingView = (ImageView) rootView.findViewById(R.id.o0n);
    }
}
