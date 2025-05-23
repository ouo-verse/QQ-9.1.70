package com.tencent.ecommerce.biz.showwindow.editor.ui.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ui.ECFloatGestureLayout;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.api.IECCoreSkinApi;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/editor/ui/view/ECProductCardEditorPreviewFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "Nh", "Mh", "", "getContentLayoutId", "", "getBusinessDescription", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "", "Eh", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onBackPressed", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "P", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "previewLayout", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECProductCardEditorPreviewFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private ECFloatGestureLayout previewLayout;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/showwindow/editor/ui/view/ECProductCardEditorPreviewFragment$b", "Lcom/tencent/ecommerce/base/ui/c;", "", "isFromTop", "", "deltaY", "type", "", "onPageClose", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends com.tencent.ecommerce.base.ui.c {
        b() {
        }

        @Override // com.tencent.ecommerce.base.ui.c, com.tencent.ecommerce.base.ui.ECFloatGestureLayout.FloatEventListener
        public void onPageClose(boolean isFromTop, int deltaY, int type) {
            FragmentActivity activity = ECProductCardEditorPreviewFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/showwindow/editor/ui/view/ECProductCardEditorPreviewFragment$c", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout$ContentScrollListener;", "", "getPositionState", "()I", "positionState", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements ECFloatGestureLayout.ContentScrollListener {
        c() {
        }

        @Override // com.tencent.ecommerce.base.ui.ECFloatGestureLayout.ContentScrollListener
        public int getPositionState() {
            return 1;
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007J\u0013\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/showwindow/editor/ui/view/ECProductCardEditorPreviewFragment$d", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/ParameterName;", "name", "drawable", "", "Lcom/tencent/ecommerce/base/imageloader/api/Callback;", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements Function1<Drawable, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f104469d;

        d(ImageView imageView) {
            this.f104469d = imageView;
        }

        public void a(Drawable drawable) {
            this.f104469d.setImageDrawable(drawable);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
            a(drawable);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECProductCardEditorPreviewFragment.Lh(ECProductCardEditorPreviewFragment.this).E();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static final /* synthetic */ ECFloatGestureLayout Lh(ECProductCardEditorPreviewFragment eCProductCardEditorPreviewFragment) {
        ECFloatGestureLayout eCFloatGestureLayout = eCProductCardEditorPreviewFragment.previewLayout;
        if (eCFloatGestureLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewLayout");
        }
        return eCFloatGestureLayout;
    }

    private final void Mh() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("scroll_to_top", false);
        bundle.putBoolean("need_pop_anim", true);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.getIntent();
        }
        bundle.putInt("scroll_margin_top", (int) ECDeviceUtils.f104857e.i(r1.d() * 0.4617284f));
        ECFloatGestureLayout eCFloatGestureLayout = new ECFloatGestureLayout(requireContext(), bundle);
        this.previewLayout = eCFloatGestureLayout;
        eCFloatGestureLayout.setFloatEventListener(new b());
        ECFloatGestureLayout eCFloatGestureLayout2 = this.previewLayout;
        if (eCFloatGestureLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewLayout");
        }
        eCFloatGestureLayout2.setContentScrollListener(new c());
        ECFloatGestureLayout eCFloatGestureLayout3 = this.previewLayout;
        if (eCFloatGestureLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewLayout");
        }
        ECFloatGestureLayout.D(eCFloatGestureLayout3, this, 0, 0, 6, null);
    }

    private final void Nh() {
        ((Button) yh().findViewById(R.id.nsj)).setOnClickListener(new e());
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECProductCardEditorPreviewFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cqa;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, com.tencent.ecommerce.base.ui.api.IECFragmentApi
    public boolean onBackPressed() {
        ECFloatGestureLayout eCFloatGestureLayout = this.previewLayout;
        if (eCFloatGestureLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewLayout");
        }
        eCFloatGestureLayout.E();
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Mh();
        ImageView imageView = (ImageView) view.findViewById(R.id.o6p);
        if (imageView != null) {
            IECCoreSkinApi.a.a(ECSkin.INSTANCE, "qecommerce_skin_post_cover_example", null, new d(imageView), 2, null);
        }
        Nh();
    }
}
