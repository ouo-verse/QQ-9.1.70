package com.tencent.mobileqq.hermes.layer.part;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/hermes/layer/part/i;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "A9", "", NodeProps.VISIBLE, "C9", "D9", "z9", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "updateLayerState", "onInitView", "d", "Landroid/view/View;", "headView", "e", "mImageButtonLayout", "f", "mOriginPicLayout", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", tl.h.F, "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mPreSelectedItem", "Ljava/lang/Runnable;", "i", "Ljava/lang/Runnable;", "mHideControlRunnable", "<init>", "()V", "hermes-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public class i extends RFWLayerBasePart {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View headView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mImageButtonLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mOriginPicLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RFWLayerItemMediaInfo mPreSelectedItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable mHideControlRunnable;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mHideControlRunnable = new Runnable() { // from class: com.tencent.mobileqq.hermes.layer.part.h
                @Override // java.lang.Runnable
                public final void run() {
                    i.B9(i.this);
                }
            };
        }
    }

    private final void A9(View rootView) {
        this.headView = LayoutInflater.from(rootView.getContext()).inflate(R.layout.f_w, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        layoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getContext());
        View view = this.headView;
        if (view != null) {
            view.setClickable(false);
        }
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) rootView).addView(this.headView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(i this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.mImageButtonLayout;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this$0.mOriginPicLayout;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    private final void C9(boolean visible) {
        if (visible) {
            D9();
        } else {
            z9();
        }
    }

    private final void D9() {
        View view = this.mImageButtonLayout;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.mOriginPicLayout;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        getMainHandler().removeCallbacks(this.mHideControlRunnable);
        getMainHandler().postDelayed(this.mHideControlRunnable, 5000L);
    }

    private final void z9() {
        this.mHideControlRunnable.run();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        A9(rootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart
    public void updateLayerState(@NotNull RFWLayerState layerState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) layerState);
            return;
        }
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.updateLayerState(layerState);
        if (!Intrinsics.areEqual(this.mPreSelectedItem, layerState.getSelectedItemMedia())) {
            this.mPreSelectedItem = layerState.getSelectedItemMedia();
            C9(true);
        }
    }
}
