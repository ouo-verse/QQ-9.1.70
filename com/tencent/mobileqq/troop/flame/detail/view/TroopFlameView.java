package com.tencent.mobileqq.troop.flame.detail.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.flame.widget.TroopLottieAnimationView;
import com.tencent.mobileqq.troop.widget.pag.TroopPagImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0002R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/troop/flame/detail/view/TroopFlameView;", "Landroid/widget/RelativeLayout;", "", "a", "", "level", WidgetCacheConstellationData.NUM, "", "needShowNumber", "c", "b", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", "rootLayout", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "bgContainer", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "numberTextView", h.F, "Z", "isUseLottie", "Lcom/tencent/mobileqq/troop/widget/pag/TroopPagImageView;", "i", "Lcom/tencent/mobileqq/troop/widget/pag/TroopPagImageView;", "pagView", "Lcom/tencent/mobileqq/troop/flame/widget/TroopLottieAnimationView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/flame/widget/TroopLottieAnimationView;", "lottieAnimationView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes19.dex */
public final class TroopFlameView extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup rootLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout bgContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView numberTextView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean isUseLottie;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TroopPagImageView pagView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TroopLottieAnimationView lottieAnimationView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopFlameView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        LayoutInflater.from(context).inflate(R.layout.fzq, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.f783646v);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.root_vg)");
        this.rootLayout = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.t68);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.bg_container)");
        FrameLayout frameLayout = (FrameLayout) findViewById2;
        this.bgContainer = frameLayout;
        View findViewById3 = findViewById(R.id.zvw);
        TextView textView = (TextView) findViewById3;
        b bVar = b.f296107a;
        Intrinsics.checkNotNullExpressionValue(textView, "this");
        bVar.f(textView);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<TextView?>(\u2026NextLTTtf(this)\n        }");
        this.numberTextView = textView;
        boolean b16 = com.tencent.mobileqq.troop.flame.widget.a.f296153a.b();
        this.isUseLottie = b16;
        if (b16) {
            a();
            return;
        }
        TroopPagImageView troopPagImageView = new TroopPagImageView(context, null, 0, 6, null);
        this.pagView = troopPagImageView;
        frameLayout.addView(troopPagImageView);
    }

    private final void a() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        TroopLottieAnimationView troopLottieAnimationView = new TroopLottieAnimationView(context, null, 0, 6, null);
        troopLottieAnimationView.setRepeatCount(com.tencent.mobileqq.troop.flame.widget.a.f296153a.a());
        this.lottieAnimationView = troopLottieAnimationView;
        this.bgContainer.addView(troopLottieAnimationView);
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        TroopPagImageView troopPagImageView = this.pagView;
        if (troopPagImageView != null) {
            troopPagImageView.setPagListener(null);
        }
        TroopPagImageView troopPagImageView2 = this.pagView;
        if (troopPagImageView2 != null) {
            troopPagImageView2.j();
        }
        TroopLottieAnimationView troopLottieAnimationView = this.lottieAnimationView;
        if (troopLottieAnimationView != null) {
            troopLottieAnimationView.cancelAnimation();
        }
        this.bgContainer.removeAllViews();
        this.lottieAnimationView = null;
    }

    public final void c(int level, int num, boolean needShowNumber) {
        TroopPagImageView troopPagImageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(level), Integer.valueOf(num), Boolean.valueOf(needShowNumber));
            return;
        }
        b bVar = b.f296107a;
        int e16 = bVar.e(num);
        this.rootLayout.getLayoutParams().width = bVar.d(level, e16, needShowNumber);
        if (needShowNumber && num > 0) {
            this.numberTextView.setText(String.valueOf(e16));
            this.numberTextView.setVisibility(0);
        } else {
            this.numberTextView.setVisibility(8);
        }
        if (this.isUseLottie) {
            if (this.lottieAnimationView == null) {
                a();
            }
            String b16 = bVar.b(level, e16, needShowNumber);
            if (b16 != null) {
                TroopLottieAnimationView troopLottieAnimationView = this.lottieAnimationView;
                if (troopLottieAnimationView != null) {
                    troopLottieAnimationView.setAnimationFromUrl(b16);
                }
                TroopLottieAnimationView troopLottieAnimationView2 = this.lottieAnimationView;
                if (troopLottieAnimationView2 != null) {
                    troopLottieAnimationView2.playAnimation();
                    return;
                }
                return;
            }
            return;
        }
        String c16 = bVar.c(level, e16, needShowNumber);
        if (c16 != null && (troopPagImageView = this.pagView) != null) {
            troopPagImageView.h(c16, true);
        }
    }
}
