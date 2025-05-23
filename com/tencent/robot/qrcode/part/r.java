package com.tencent.robot.qrcode.part;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0003J\u0012\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/robot/qrcode/part/r;", "Lcom/tencent/biz/richframework/part/Part;", "", "z9", "Landroid/content/Context;", "context", "Landroid/widget/RelativeLayout;", "titlePart", "", "A9", "C9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "backButton", "<init>", "()V", "e", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class r extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView backButton;

    private final void A9(Context context, RelativeLayout titlePart) {
        ImageView imageView = new ImageView(context);
        this.backButton = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.qrcode.part.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.B9(r.this, view);
            }
        });
        int dip2px = ViewUtils.dip2px(24.0f);
        int dip2px2 = ViewUtils.dip2px(16.0f);
        if (z9() > 1.0f) {
            dip2px = (int) (dip2px / z9());
            dip2px2 = (int) (dip2px2 / z9());
        }
        ImageView imageView2 = this.backButton;
        View view = null;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
            imageView2 = null;
        }
        imageView2.setImageResource(R.drawable.qui_arrow_left_selector);
        ImageView imageView3 = this.backButton;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
            imageView3 = null;
        }
        ImageView imageView4 = this.backButton;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
            imageView4 = null;
        }
        AccessibilityUtil.c(imageView3, imageView4.getResources().getString(R.string.f170549u3), Button.class.getName());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
        layoutParams.addRule(9);
        layoutParams.addRule(14);
        layoutParams.setMargins(dip2px2, 0, 0, 0);
        View view2 = this.backButton;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
        } else {
            view = view2;
        }
        titlePart.addView(view, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(r this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @SuppressLint({"InflateParams"})
    private final void C9(Context context, RelativeLayout titlePart) {
        A9(context, titlePart);
    }

    private final float z9() {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "context.resources.displayMetrics");
        return displayMetrics.density / FontSettingManager.systemMetrics.density;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        RelativeLayout relativeLayout;
        super.onInitView(rootView);
        if (rootView != null) {
            relativeLayout = (RelativeLayout) rootView.findViewById(R.id.f98745nx);
        } else {
            relativeLayout = null;
        }
        if (relativeLayout == null) {
            QLog.i("robot.qr.QRDisplayRobotTitlePart", 1, "card part is null");
            return;
        }
        Context context = getContext();
        if (context != null) {
            C9(context, relativeLayout);
        }
    }
}
