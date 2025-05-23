package com.tencent.mobileqq.flock.layer.part;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u0010\u000e\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0011\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/flock/layer/part/b;", "Lcom/tencent/mobileqq/flock/base/d;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "v", NodeProps.ON_CLICK, "e", "Landroid/view/View;", "headerView", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "ivBack", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "tvIndicator", "i", "ivSave", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b extends com.tencent.mobileqq.flock.base.d implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View headerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView ivBack;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView tvIndicator;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView ivSave;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.du6) {
                getActivity().onBackPressed();
            } else if (num != null && num.intValue() == R.id.y8o) {
                broadcastMessage("MSG_ACTION_DOWNLOAD", null);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.flock.base.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        View view = null;
        if (rootView != null) {
            context = rootView.getContext();
        } else {
            context = null;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.e85, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.du6);
        ImageView imageView = (ImageView) findViewById;
        imageView.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<ImageView>(\u2026erPart)\n                }");
        this.ivBack = imageView;
        View findViewById2 = inflate.findViewById(R.id.f108756dz);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_indicator)");
        this.tvIndicator = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.y8o);
        ImageView imageView2 = (ImageView) findViewById3;
        imageView2.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<ImageView>(\u2026erPart)\n                }");
        this.ivSave = imageView2;
        Intrinsics.checkNotNullExpressionValue(inflate, "from(rootView?.context)\n\u2026          }\n            }");
        this.headerView = inflate;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        layoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getContext()) + cx.a(16.0f);
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) rootView;
        View view2 = this.headerView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
        } else {
            view = view2;
        }
        viewGroup.addView(view, layoutParams);
    }

    @Override // com.tencent.mobileqq.flock.base.e
    protected void onLayerStateUpdate(@NotNull RFWLayerState layerState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) layerState);
            return;
        }
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        TextView textView = this.tvIndicator;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvIndicator");
            textView = null;
        }
        textView.setText(x9(layerState) + "/" + z9(layerState));
    }
}
