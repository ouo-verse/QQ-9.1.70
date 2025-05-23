package com.tencent.mobileqq.troop.teamup.preview.parts;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quisecnavbar.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0014R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/preview/parts/e;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Landroid/view/View;", "z9", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "", "A9", "B9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "updateLayerState", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "troopIndicator", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class e extends RFWLayerBasePart {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView troopIndicator;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int A9(RFWLayerState layerState) {
        if (layerState == null) {
            return 1;
        }
        return 1 + layerState.getSelectedPosition() + layerState.getPositionOffset();
    }

    private final int B9(RFWLayerState layerState) {
        if (layerState == null) {
            return 1;
        }
        if (layerState.getRichMediaDataList() == null) {
            return layerState.getMediaSum();
        }
        int mediaSum = layerState.getMediaSum();
        List<RFWLayerItemMediaInfo> richMediaDataList = layerState.getRichMediaDataList();
        Intrinsics.checkNotNull(richMediaDataList);
        return Math.max(mediaSum, richMediaDataList.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final View z9() {
        View view = new View(getContext());
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#B2000000"), 0});
        gradientDrawable.setShape(0);
        gradientDrawable.setGradientType(0);
        view.setBackground(gradientDrawable);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.b(150));
        layoutParams.gravity = 48;
        view.setLayoutParams(layoutParams);
        return view;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView instanceof ViewGroup) {
            viewGroup = (ViewGroup) rootView;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.addView(z9());
            View inflate = LayoutInflater.from(((ViewGroup) rootView).getContext()).inflate(R.layout.i0k, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.f10395620);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.troop_tv_indicator)");
            this.troopIndicator = (TextView) findViewById;
            ImageView onInitView$lambda$6$lambda$4$lambda$3 = (ImageView) inflate.findViewById(R.id.f102305xj);
            onInitView$lambda$6$lambda$4$lambda$3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.preview.parts.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.C9(e.this, view);
                }
            });
            Intrinsics.checkNotNullExpressionValue(onInitView$lambda$6$lambda$4$lambda$3, "onInitView$lambda$6$lambda$4$lambda$3");
            ge0.b.c(onInitView$lambda$6$lambda$4$lambda$3, onInitView$lambda$6$lambda$4$lambda$3, onInitView$lambda$6$lambda$4$lambda$3.getDrawable());
            onInitView$lambda$6$lambda$4$lambda$3.setBackgroundResource(R.drawable.f162590lv2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f.d(), f.d());
            layoutParams.setMargins(f.j(), 0, 0, 0);
            onInitView$lambda$6$lambda$4$lambda$3.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 48;
            layoutParams2.topMargin = ImmersiveUtils.getStatusBarHeight(viewGroup.getContext()) + ViewUtils.dip2px(16.0f);
            Unit unit = Unit.INSTANCE;
            viewGroup.addView(inflate, layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart
    public void updateLayerState(@NotNull RFWLayerState layerState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) layerState);
            return;
        }
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        if (this.troopIndicator != null) {
            String str = A9(layerState) + "/" + B9(layerState);
            TextView textView = this.troopIndicator;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopIndicator");
                textView = null;
            }
            textView.setText(str);
        }
    }
}
