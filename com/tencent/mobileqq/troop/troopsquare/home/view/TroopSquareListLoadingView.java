package com.tencent.mobileqq.troop.troopsquare.home.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quishimmer.QUIShimmerEntity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\"\u0010#J0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0014J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0014J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\b\u0010\u0015\u001a\u00020\tH\u0014J\b\u0010\u0016\u001a\u00020\tH\u0014R\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/home/view/TroopSquareListLoadingView;", "Landroid/widget/FrameLayout;", "", "changed", "", "left", "top", "right", "bottom", "", "onLayout", "Landroid/view/View;", "changedView", "visibility", "onVisibilityChanged", "Landroid/graphics/Canvas;", PM.CANVAS, "dispatchDraw", "Landroid/graphics/drawable/Drawable;", "who", "verifyDrawable", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "d", "I", "groupItemSize", "Lcom/tencent/biz/qui/quishimmer/QUIShimmerEntity;", "e", "Lcom/tencent/biz/qui/quishimmer/QUIShimmerEntity;", "shimmerEntity", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSquareListLoadingView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int groupItemSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIShimmerEntity shimmerEntity;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopSquareListLoadingView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@Nullable Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        super.dispatchDraw(canvas);
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        QUIShimmerEntity qUIShimmerEntity = this.shimmerEntity;
        if (qUIShimmerEntity != null) {
            qUIShimmerEntity.drawLightOnCanvas(canvas, iArr);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        QUIShimmerEntity qUIShimmerEntity = this.shimmerEntity;
        if (qUIShimmerEntity != null) {
            qUIShimmerEntity.startShimmer(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        QUIShimmerEntity qUIShimmerEntity = this.shimmerEntity;
        if (qUIShimmerEntity != null) {
            qUIShimmerEntity.stopShimmer(null);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(changed), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
            return;
        }
        super.onLayout(changed, left, top, right, bottom);
        QUIShimmerEntity qUIShimmerEntity = this.shimmerEntity;
        if (qUIShimmerEntity != null) {
            qUIShimmerEntity.setBounds(getWidth(), getHeight());
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NotNull View changedView, int visibility) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) changedView, visibility);
            return;
        }
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        QUIShimmerEntity qUIShimmerEntity = this.shimmerEntity;
        if (qUIShimmerEntity != null) {
            qUIShimmerEntity.onVisibilityChanged(changedView, visibility);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NotNull Drawable who) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) who)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(who, "who");
        if (this.shimmerEntity == null) {
            return super.verifyDrawable(who);
        }
        if (!super.verifyDrawable(who)) {
            QUIShimmerEntity qUIShimmerEntity = this.shimmerEntity;
            Intrinsics.checkNotNull(qUIShimmerEntity);
            if (!qUIShimmerEntity.verifyDrawable(who)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopSquareListLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ TroopSquareListLoadingView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 10 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopSquareListLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.groupItemSize = i3;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        for (int i16 = 0; i16 < i3; i16++) {
            ImageFilterView imageFilterView = new ImageFilterView(context);
            imageFilterView.setImageResource(R.drawable.lx9);
            imageFilterView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageFilterView.setImageTintList(ColorStateList.valueOf(ie0.a.f().g(context, R.color.qui_common_fill_standard_primary, 1000) | (-16777216)));
            linearLayout.addView(imageFilterView, new FrameLayout.LayoutParams(-1, -2));
        }
        ScrollView scrollView = new ScrollView(context);
        scrollView.addView(linearLayout);
        scrollView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.troop.troopsquare.home.view.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean b16;
                b16 = TroopSquareListLoadingView.b(view, motionEvent);
                return b16;
            }
        });
        addView(scrollView, new FrameLayout.LayoutParams(-1, -1));
        QUIShimmerEntity qUIShimmerEntity = new QUIShimmerEntity(this, context, null);
        this.shimmerEntity = qUIShimmerEntity;
        qUIShimmerEntity.setBusinessTag(TroopSquareListLoadingView.class.getSimpleName());
    }
}
