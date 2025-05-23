package com.tencent.ecommerce.biz.showwindow.editor.ui.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ui.ECFloatGestureLayout;
import com.tencent.ecommerce.biz.showwindow.editor.ui.ECProductCardEditorViewModel;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 A2\u00020\u0001:\u0001BB\u0007\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R&\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u001bj\b\u0012\u0004\u0012\u00020\u0013`\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u0010-R\u0016\u00106\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u0010-R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006C"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/editor/ui/view/ECProductCardEditorPickCoverImgFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "Sh", "Th", "initArguments", "view", "Rh", "", "Bh", "Eh", "Dh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getContentLayoutId", "", "getBusinessDescription", "Lcom/tencent/ecommerce/biz/showwindow/editor/ui/ECProductCardEditorViewModel;", "P", "Lkotlin/Lazy;", "Qh", "()Lcom/tencent/ecommerce/biz/showwindow/editor/ui/ECProductCardEditorViewModel;", "ecProductCardEditorViewModel", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/ArrayList;", "imageUrlList", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/String;", "selectedURL", "Lcom/tencent/ecommerce/biz/showwindow/editor/ui/view/a;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/ecommerce/biz/showwindow/editor/ui/view/a;", "imageItemAdapter", "Landroid/widget/GridView;", "T", "Landroid/widget/GridView;", "imageGridView", "Landroid/widget/LinearLayout;", "U", "Landroid/widget/LinearLayout;", "imageContainer", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "V", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "floatGestureLayout", "W", "titleBarContainer", "X", "bottomBarContainer", "Landroid/widget/ImageView;", "Y", "Landroid/widget/ImageView;", "closeIcon", "Landroid/widget/Button;", "Z", "Landroid/widget/Button;", "confirmBtn", "<init>", "()V", "a0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECProductCardEditorPickCoverImgFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy ecProductCardEditorViewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    private ArrayList<String> imageUrlList;

    /* renamed from: R, reason: from kotlin metadata */
    private String selectedURL;

    /* renamed from: S, reason: from kotlin metadata */
    private a imageItemAdapter;

    /* renamed from: T, reason: from kotlin metadata */
    private GridView imageGridView;

    /* renamed from: U, reason: from kotlin metadata */
    private LinearLayout imageContainer;

    /* renamed from: V, reason: from kotlin metadata */
    private ECFloatGestureLayout floatGestureLayout;

    /* renamed from: W, reason: from kotlin metadata */
    private LinearLayout titleBarContainer;

    /* renamed from: X, reason: from kotlin metadata */
    private LinearLayout bottomBarContainer;

    /* renamed from: Y, reason: from kotlin metadata */
    private ImageView closeIcon;

    /* renamed from: Z, reason: from kotlin metadata */
    private Button confirmBtn;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/showwindow/editor/ui/view/ECProductCardEditorPickCoverImgFragment$b", "Lcom/tencent/ecommerce/base/ui/c;", "", "isFromTop", "", "deltaY", "type", "", "onPageClose", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends com.tencent.ecommerce.base.ui.c {
        b() {
        }

        @Override // com.tencent.ecommerce.base.ui.c, com.tencent.ecommerce.base.ui.ECFloatGestureLayout.FloatEventListener
        public void onPageClose(boolean isFromTop, int deltaY, int type) {
            FragmentActivity activity = ECProductCardEditorPickCoverImgFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intent intent = new Intent();
            intent.putExtra("selectedURL", ECProductCardEditorPickCoverImgFragment.this.selectedURL);
            FragmentActivity activity = ECProductCardEditorPickCoverImgFragment.this.getActivity();
            if (activity != null) {
                activity.setResult(100, intent);
            }
            FragmentActivity activity2 = ECProductCardEditorPickCoverImgFragment.this.getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/showwindow/editor/ui/view/ECProductCardEditorPickCoverImgFragment$d", "Lcom/tencent/ecommerce/biz/showwindow/editor/ui/view/ECSelectedIndexListener;", "", "position", "", "onSelectedIndex", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements ECSelectedIndexListener {
        d() {
        }

        @Override // com.tencent.ecommerce.biz.showwindow.editor.ui.view.ECSelectedIndexListener
        public void onSelectedIndex(int position) {
            ECProductCardEditorPickCoverImgFragment.this.Qh().Z1(position);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e<T> implements Observer<T> {
        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            int intValue = ((Number) t16).intValue();
            ECProductCardEditorPickCoverImgFragment eCProductCardEditorPickCoverImgFragment = ECProductCardEditorPickCoverImgFragment.this;
            eCProductCardEditorPickCoverImgFragment.selectedURL = (String) ECProductCardEditorPickCoverImgFragment.Nh(eCProductCardEditorPickCoverImgFragment).get(intValue);
            cg0.a.b("ECProductCardEditorPickCoverImgFragment", "SelectedURL " + ECProductCardEditorPickCoverImgFragment.this.selectedURL);
            ECProductCardEditorPickCoverImgFragment.Mh(ECProductCardEditorPickCoverImgFragment.this).c(intValue);
        }
    }

    public ECProductCardEditorPickCoverImgFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.showwindow.editor.ui.view.ECProductCardEditorPickCoverImgFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.ecProductCardEditorViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECProductCardEditorViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.showwindow.editor.ui.view.ECProductCardEditorPickCoverImgFragment$$special$$inlined$viewModels$2
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
        this.selectedURL = "";
    }

    public static final /* synthetic */ a Mh(ECProductCardEditorPickCoverImgFragment eCProductCardEditorPickCoverImgFragment) {
        a aVar = eCProductCardEditorPickCoverImgFragment.imageItemAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageItemAdapter");
        }
        return aVar;
    }

    public static final /* synthetic */ ArrayList Nh(ECProductCardEditorPickCoverImgFragment eCProductCardEditorPickCoverImgFragment) {
        ArrayList<String> arrayList = eCProductCardEditorPickCoverImgFragment.imageUrlList;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageUrlList");
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECProductCardEditorViewModel Qh() {
        return (ECProductCardEditorViewModel) this.ecProductCardEditorViewModel.getValue();
    }

    private final void Rh(View view) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("scroll_to_top", false);
        bundle.putInt("scroll_margin_top", (int) ECDeviceUtils.f104857e.i(r0.d() * 0.3160494f));
        ECFloatGestureLayout eCFloatGestureLayout = new ECFloatGestureLayout(requireContext(), bundle);
        this.floatGestureLayout = eCFloatGestureLayout;
        eCFloatGestureLayout.setFloatEventListener(new b());
        ECFloatGestureLayout eCFloatGestureLayout2 = this.floatGestureLayout;
        if (eCFloatGestureLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
        }
        eCFloatGestureLayout2.C(this, -1, -1);
    }

    private final void Th() {
        Qh().S1().observe(getViewLifecycleOwner(), new e());
    }

    private final void initArguments() {
        Bundle arguments = getArguments();
        ArrayList<String> stringArrayList = arguments != null ? arguments.getStringArrayList("bundle_key_candidate_pic_list") : null;
        if (stringArrayList != null) {
            if (!stringArrayList.isEmpty()) {
                this.imageUrlList = stringArrayList;
            }
            cg0.a.b("ECProductCardEditorPickCoverImgFragment", "Image list from ECProductCardEditorFragment, data size: " + stringArrayList.size());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Bh() {
        return false;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Dh() {
        return false;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECProductCardEditorPickCoverImgFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cul;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initArguments();
        Sh(view);
        Rh(view);
        Th();
    }

    private final void Sh(View rootView) {
        this.imageGridView = (GridView) rootView.findViewById(R.id.o0p);
        this.closeIcon = (ImageView) rootView.findViewById(R.id.o1e);
        this.titleBarContainer = (LinearLayout) rootView.findViewById(R.id.nzl);
        ECDeviceUtils eCDeviceUtils = ECDeviceUtils.f104857e;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(eCDeviceUtils.f(), (int) (eCDeviceUtils.d() * 0.054320987f));
        LinearLayout linearLayout = this.titleBarContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        }
        linearLayout.setLayoutParams(layoutParams);
        this.imageContainer = (LinearLayout) rootView.findViewById(R.id.o3e);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(eCDeviceUtils.f(), (int) (eCDeviceUtils.d() * 0.5555556f));
        LinearLayout linearLayout2 = this.imageContainer;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageContainer");
        }
        linearLayout2.setLayoutParams(layoutParams2);
        this.bottomBarContainer = (LinearLayout) rootView.findViewById(R.id.o2w);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(eCDeviceUtils.f(), (int) (eCDeviceUtils.d() * 0.074074075f));
        LinearLayout linearLayout3 = this.bottomBarContainer;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBarContainer");
        }
        linearLayout3.setLayoutParams(layoutParams3);
        Button button = (Button) rootView.findViewById(R.id.f163014nu4);
        this.confirmBtn = button;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
        }
        button.setOnClickListener(new c());
        Context requireContext = requireContext();
        ArrayList<String> arrayList = this.imageUrlList;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageUrlList");
        }
        this.imageItemAdapter = new a(requireContext, R.layout.cum, arrayList, new d());
        GridView gridView = this.imageGridView;
        if (gridView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageGridView");
        }
        a aVar = this.imageItemAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageItemAdapter");
        }
        gridView.setAdapter((ListAdapter) aVar);
    }
}
