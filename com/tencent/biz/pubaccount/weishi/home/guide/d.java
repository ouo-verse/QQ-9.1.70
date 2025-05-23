package com.tencent.biz.pubaccount.weishi.home.guide;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.home.guide.d;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J$\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eJ\u0006\u0010\u0011\u001a\u00020\u0005R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/home/guide/d;", "", "Landroid/view/View;", "contentView", "anchorView", "", "g", "Lcom/tencent/biz/pubaccount/weishi/home/guide/g;", "guideInfo", "i", tl.h.F, "", "measureSpec", "e", "Lkotlin/Function0;", NodeProps.ON_CLICK, "f", "d", "Landroid/widget/PopupWindow;", "a", "Landroid/widget/PopupWindow;", "guidePopupWindow", "<init>", "()V", "b", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private PopupWindow guidePopupWindow;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/biz/pubaccount/weishi/home/guide/d$b", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f80833d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f80834e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ WSMonoTabPopupWindowGuideInfo f80835f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f80836h;

        b(View view, d dVar, WSMonoTabPopupWindowGuideInfo wSMonoTabPopupWindowGuideInfo, Function0<Unit> function0) {
            this.f80833d = view;
            this.f80834e = dVar;
            this.f80835f = wSMonoTabPopupWindowGuideInfo;
            this.f80836h = function0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Function0 onClick, View view) {
            Intrinsics.checkNotNullParameter(onClick, "$onClick");
            onClick.invoke();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f80833d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            View contentView = LayoutInflater.from(this.f80833d.getContext()).inflate(R.layout.d1a, (ViewGroup) null);
            final Function0<Unit> function0 = this.f80836h;
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.weishi.home.guide.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.b.b(Function0.this, view);
                }
            });
            d dVar = this.f80834e;
            Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
            dVar.h(contentView, this.f80835f);
            this.f80834e.i(contentView, this.f80835f);
            this.f80834e.g(contentView, this.f80833d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(View contentView, View anchorView) {
        PopupWindow popupWindow = new PopupWindow(contentView, -2, -2);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(false);
        int measuredWidth = anchorView.getMeasuredWidth();
        contentView.measure(e(popupWindow.getWidth()), e(popupWindow.getHeight()));
        int measuredWidth2 = contentView.getMeasuredWidth();
        x.i("WSMonoTabPopupWindowGuide", "[showPopupWindow] anchorWidth:" + measuredWidth + ", contentViewWidth:" + measuredWidth2);
        popupWindow.showAsDropDown(anchorView, (measuredWidth - measuredWidth2) / 2, -ba.f81733h);
        this.guidePopupWindow = popupWindow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(View contentView, WSMonoTabPopupWindowGuideInfo guideInfo) {
        String bgColor = guideInfo.getBgColor();
        if (!ba.w(bgColor) || new Regex("#[fF]*").matches(bgColor)) {
            return;
        }
        try {
            Drawable background = contentView.getBackground();
            background.setColorFilter(Color.parseColor(bgColor), PorterDuff.Mode.SRC_IN);
            contentView.setBackground(background);
        } catch (IllegalArgumentException e16) {
            x.f("WSMonoTabPopupWindowGuide", "[updatePopupWindowBgColor] error:" + e16.getLocalizedMessage());
        }
    }

    public final void d() {
        PopupWindow popupWindow = this.guidePopupWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        popupWindow.dismiss();
    }

    public final void f(View anchorView, WSMonoTabPopupWindowGuideInfo guideInfo, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics.checkNotNullParameter(guideInfo, "guideInfo");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        PopupWindow popupWindow = this.guidePopupWindow;
        boolean z16 = false;
        if (popupWindow != null && popupWindow.isShowing()) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        anchorView.getViewTreeObserver().addOnGlobalLayoutListener(new b(anchorView, this, guideInfo, onClick));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(View contentView, WSMonoTabPopupWindowGuideInfo guideInfo) {
        TextView textView = (TextView) contentView.findViewById(R.id.p7h);
        textView.setText(guideInfo.getDesc());
        String descColor = guideInfo.getDescColor();
        if (ba.w(descColor)) {
            textView.setTextColor(Color.parseColor(descColor));
        }
    }

    private final int e(int measureSpec) {
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(measureSpec), measureSpec == -2 ? 0 : 1073741824);
    }
}
