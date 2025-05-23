package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.route.QZoneUserHomeBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/feedx/part/bj;", "Lcom/qzone/reborn/base/k;", "", "F9", "", "args", "D9", "E9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "", "action", "handleBroadcastMessage", "Lcom/qzone/reborn/feedx/viewmodel/w;", "d", "Lcom/qzone/reborn/feedx/viewmodel/w;", "viewModel", "e", "Landroid/view/View;", "bubbleRoot", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "bubbleText", "<init>", "()V", tl.h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class bj extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.w viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View bubbleRoot;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView bubbleText;

    private final void D9(Object args) {
        if (!(args instanceof x6.a)) {
            QLog.e("QZoneFeedxMoodListGuideBubblePart", 1, "not BusinessUserInfoData");
            return;
        }
        View view = this.bubbleRoot;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
    }

    private final void E9() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor("#FFE03E"), Color.parseColor("#FB4545"), Color.parseColor("#FC49D5")});
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(ef.d.a(Double.valueOf(19.5d)));
        View view = this.bubbleRoot;
        if (view == null) {
            return;
        }
        view.setBackground(gradientDrawable);
    }

    private final void F9() {
        com.qzone.reborn.feedx.viewmodel.w wVar = this.viewModel;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            wVar = null;
        }
        if (wVar.O2()) {
            E9();
            com.qzone.reborn.feedx.viewmodel.w wVar2 = this.viewModel;
            if (wVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                wVar2 = null;
            }
            QZoneUserHomeBean initBean = wVar2.getInitBean();
            if (!TextUtils.isEmpty(initBean != null ? initBean.getBottomBubbleText() : null)) {
                TextView textView = this.bubbleText;
                if (textView != null) {
                    com.qzone.reborn.feedx.viewmodel.w wVar3 = this.viewModel;
                    if (wVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        wVar3 = null;
                    }
                    QZoneUserHomeBean initBean2 = wVar3.getInitBean();
                    textView.setText(initBean2 != null ? initBean2.getBottomBubbleText() : null);
                }
            } else {
                TextView textView2 = this.bubbleText;
                if (textView2 != null) {
                    textView2.setText(BaseApplication.getContext().getString(R.string.f169539rg3));
                }
            }
            View view = this.bubbleRoot;
            if (view != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.bi
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        bj.G9(bj.this, view2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(bj this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        com.qzone.reborn.feedx.viewmodel.w wVar = this$0.viewModel;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            wVar = null;
        }
        QZoneUserHomeBean initBean = wVar.getInitBean();
        ho.i.q(context, initBean != null ? initBean.getBottomBubbleUrl() : null);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        super.handleBroadcastMessage(action, args);
        if (TextUtils.equals("user_home_business_info", action)) {
            D9(args);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(com.qzone.reborn.feedx.viewmodel.w.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneUserHomeViewModel::class.java)");
        this.viewModel = (com.qzone.reborn.feedx.viewmodel.w) viewModel;
        View inflate = LayoutInflater.from(rootView != null ? rootView.getContext() : null).inflate(R.layout.cfy, (ViewGroup) null);
        this.bubbleRoot = inflate;
        this.bubbleText = inflate != null ? (TextView) inflate.findViewById(R.id.f196267) : null;
        if (this.bubbleRoot == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, com.qzone.util.ar.e(40.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = com.qzone.util.ar.e(120.0f);
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) rootView).addView(this.bubbleRoot, layoutParams);
        View view = this.bubbleRoot;
        Intrinsics.checkNotNull(view);
        view.setVisibility(8);
        fo.c.n(this.bubbleRoot, "em_qz_mobile_entrance");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        F9();
    }
}
