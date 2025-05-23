package com.tencent.mobileqq.zplan.minihome.view;

import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import yk0.FurnitureDesc;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \b2\u00020\u0001:\u0001*B^\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012M\u0010\u001e\u001aI\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00070\u0016\u00a2\u0006\u0004\b(\u0010)J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0014\u0010\f\u001a\u00020\n*\u00020\t2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u0010\u001a\u00020\u0007J\b\u0010\u0011\u001a\u0004\u0018\u00010\tR\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R[\u0010\u001e\u001aI\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00070\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/view/MiniHomeActionBtnComponent;", "", "Landroid/widget/ImageView;", "view", "", "eventKey", "elementId", "", "f", "Landroid/view/View;", "", "value", "g", "Lyk0/c;", "furniture", "j", "i", tl.h.F, "Landroidx/constraintlayout/widget/ConstraintLayout;", "a", "Landroidx/constraintlayout/widget/ConstraintLayout;", ParseCommon.CONTAINER, "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "image", "Lcom/tencent/mobileqq/zplan/minihome/view/MiniHomeActionBtnComponent$Companion$ACTION;", "action", "b", "Lkotlin/jvm/functions/Function3;", NodeProps.ON_CLICK, "Landroid/widget/RelativeLayout;", "c", "Landroid/widget/RelativeLayout;", "actionRoot", "d", "Landroid/widget/ImageView;", "deleteImage", "e", "rotateImage", "<init>", "(Landroidx/constraintlayout/widget/ConstraintLayout;Lkotlin/jvm/functions/Function3;)V", "Companion", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeActionBtnComponent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ConstraintLayout container;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Function3<View, Companion.ACTION, FurnitureDesc, Unit> onClick;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout actionRoot;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView deleteImage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView rotateImage;

    /* JADX WARN: Multi-variable type inference failed */
    public MiniHomeActionBtnComponent(ConstraintLayout container, Function3<? super View, ? super Companion.ACTION, ? super FurnitureDesc, Unit> onClick) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.container = container;
        this.onClick = onClick;
        RelativeLayout relativeLayout = new RelativeLayout(container.getContext());
        relativeLayout.setBackgroundResource(R.drawable.i3w);
        relativeLayout.setVisibility(8);
        relativeLayout.setId(View.generateViewId());
        this.actionRoot = relativeLayout;
        container.addView(relativeLayout);
        int g16 = (int) g(container, 36.0f);
        int g17 = (int) g(container, 6.0f);
        ImageView imageView = new ImageView(container.getContext());
        imageView.setId(View.generateViewId());
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageDrawable(imageView.getResources().getDrawable(R.drawable.f159906i44));
        imageView.setPadding(g17, g17, g17, g17);
        this.deleteImage = imageView;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g16, g16);
        layoutParams.leftMargin = (int) g(container, 10.0f);
        layoutParams.topMargin = (int) g(container, 4.0f);
        RelativeLayout relativeLayout2 = this.actionRoot;
        Intrinsics.checkNotNull(relativeLayout2);
        relativeLayout2.addView(this.deleteImage, layoutParams);
        ImageView imageView2 = new ImageView(container.getContext());
        imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView2.setImageDrawable(imageView2.getResources().getDrawable(R.drawable.i4e));
        imageView2.setPadding(g17, g17, g17, g17);
        this.rotateImage = imageView2;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(g16, g16);
        layoutParams2.leftMargin = (int) g(container, 6.0f);
        layoutParams2.topMargin = (int) g(container, 4.0f);
        ImageView imageView3 = this.deleteImage;
        Intrinsics.checkNotNull(imageView3);
        layoutParams2.addRule(1, imageView3.getId());
        RelativeLayout relativeLayout3 = this.actionRoot;
        Intrinsics.checkNotNull(relativeLayout3);
        relativeLayout3.addView(this.rotateImage, layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(ImageView view, String eventKey, String elementId) {
        VideoReport.setElementId(view, elementId);
        VideoReport.reportEvent(eventKey, view, null);
    }

    private final float g(View view, float f16) {
        return TypedValue.applyDimension(1, f16, view.getContext().getResources().getDisplayMetrics());
    }

    public final View h() {
        return this.actionRoot;
    }

    public final void i() {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.view.MiniHomeActionBtnComponent$hide$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RelativeLayout relativeLayout;
                RelativeLayout relativeLayout2;
                ImageView imageView;
                ImageView imageView2;
                relativeLayout = MiniHomeActionBtnComponent.this.actionRoot;
                QLog.i("MiniHomeActionBtnComponent", 1, "hide actionRoot:" + relativeLayout);
                relativeLayout2 = MiniHomeActionBtnComponent.this.actionRoot;
                if (relativeLayout2 != null) {
                    relativeLayout2.setVisibility(8);
                }
                imageView = MiniHomeActionBtnComponent.this.deleteImage;
                if (imageView != null) {
                    imageView.setOnClickListener(null);
                }
                imageView2 = MiniHomeActionBtnComponent.this.rotateImage;
                if (imageView2 != null) {
                    imageView2.setOnClickListener(null);
                }
            }
        });
    }

    public final void j(FurnitureDesc furniture) {
        CommonExKt.j(new MiniHomeActionBtnComponent$show$1(furniture, this));
    }
}
