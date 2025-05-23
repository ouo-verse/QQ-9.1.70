package com.tencent.mobileqq.aio.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.x;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w71.t;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b3\u00104J\u001c\u0010\u0006\u001a\u00020\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u001c\u0010\u0007\u001a\u00020\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\f\u0010\b\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\t\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\n\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u000b\u001a\u00020\u0003*\u00020\u0002H\u0002J\u000e\u0010\f\u001a\u0004\u0018\u00010\u0002*\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0014\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003J.\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010\u001fR\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010\u001fR\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010\u001fR\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010\u001fR\u0016\u0010+\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001fR\u0016\u0010,\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001fR\u0018\u0010-\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001fR\u0018\u0010.\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001fR\u0018\u0010/\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001fR\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/aio/widget/h;", "", "Landroid/view/View;", "", "widthMeasureSpec", "heightMeasureSpec", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", DomainData.DOMAIN_NAME, "k", "j", "", "i", "Lw71/t;", "titleBinding", "", "o", "child", tl.h.F, HippyTKDListViewAdapter.X, "changed", "left", "top", "right", "bottom", "w", "a", "Lw71/t;", "b", "Landroid/view/View;", "leftUserInfoView", "c", "troopSquareView", "d", "titleTabView", "e", "vipView", "f", "vipDivider", "g", "centerRight1View", "centerRight2View", "earView", "right3View", "frameView", "talkbackView", "Lcom/tencent/mobileqq/aio/widget/NTViewFlipper;", "Lcom/tencent/mobileqq/aio/widget/NTViewFlipper;", "filipperView", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private t titleBinding;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private View leftUserInfoView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private View troopSquareView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View titleTabView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View vipView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View vipDivider;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private View centerRight1View;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View centerRight2View;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View earView;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View right3View;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View frameView;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View talkbackView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private NTViewFlipper filipperView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/aio/widget/h$a;", "", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public interface a {
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean i() {
        NTViewFlipper nTViewFlipper = this.filipperView;
        if (nTViewFlipper == null || nTViewFlipper == null || nTViewFlipper.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    private final View j(View view) {
        if (view.getVisibility() == 8) {
            return null;
        }
        return view;
    }

    private final int k(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        return ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
    }

    private final int l(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        return ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
    }

    private final int m(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        return ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    private final int n(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(h this$0, ViewStub viewStub, View inflated) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(inflated, "inflated");
        this$0.leftUserInfoView = inflated;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(h this$0, ViewStub viewStub, View inflated) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(inflated, "inflated");
        this$0.troopSquareView = inflated;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(h this$0, ViewStub viewStub, View inflated) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(inflated, "inflated");
        this$0.titleTabView = inflated;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(h this$0, ViewStub viewStub, View inflated) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(inflated, "inflated");
        this$0.vipView = inflated;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(h this$0, ViewStub viewStub, View inflated) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(inflated, "inflated");
        this$0.centerRight1View = inflated;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(h this$0, ViewStub viewStub, View inflated) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(inflated, "inflated");
        this$0.centerRight2View = inflated;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(h this$0, ViewStub viewStub, View inflated) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(inflated, "inflated");
        this$0.earView = inflated;
    }

    private final int y(View view, int i3, int i16) {
        if (j(view) == null) {
            return 0;
        }
        com.tencent.aio.base.tool.b.d(com.tencent.aio.base.tool.b.f69219a, view, i3, 0, i16, 0, 0, 0, 0, 0, 480, null);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + view.getMeasuredWidth();
    }

    private final int z(View view, int i3, int i16) {
        com.tencent.aio.base.tool.b.d(com.tencent.aio.base.tool.b.f69219a, view, i3, 0, i16, 0, 0, 0, 0, 0, 480, null);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + view.getMeasuredWidth();
    }

    public final void h(@Nullable View child) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) child);
            return;
        }
        if (child instanceof NTViewFlipper) {
            this.filipperView = (NTViewFlipper) child;
            return;
        }
        if (child instanceof a) {
            this.frameView = child;
            return;
        }
        if (child != null && child.getId() == R.id.f74353w1) {
            this.right3View = child;
        } else if (child != null && child.getId() == R.id.f98885oa) {
            this.talkbackView = child;
        }
    }

    public final void o(@NotNull t titleBinding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) titleBinding);
            return;
        }
        Intrinsics.checkNotNullParameter(titleBinding, "titleBinding");
        this.titleBinding = titleBinding;
        ViewStub viewStub = titleBinding.f444906g;
        Intrinsics.checkNotNullExpressionValue(viewStub, "titleBinding.leftUserInfo");
        this.leftUserInfoView = viewStub;
        t tVar = this.titleBinding;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
            tVar = null;
        }
        tVar.f444906g.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.mobileqq.aio.widget.a
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub2, View view) {
                h.p(h.this, viewStub2, view);
            }
        });
        ViewStub viewStub2 = titleBinding.f444915p;
        Intrinsics.checkNotNullExpressionValue(viewStub2, "titleBinding.troopSquare");
        this.troopSquareView = viewStub2;
        titleBinding.f444915p.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.mobileqq.aio.widget.b
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub3, View view) {
                h.q(h.this, viewStub3, view);
            }
        });
        ViewStub viewStub3 = titleBinding.f444912m;
        Intrinsics.checkNotNullExpressionValue(viewStub3, "titleBinding.titleTab");
        this.titleTabView = viewStub3;
        titleBinding.f444912m.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.mobileqq.aio.widget.c
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub4, View view) {
                h.r(h.this, viewStub4, view);
            }
        });
        ViewStub viewStub4 = titleBinding.f444918s;
        Intrinsics.checkNotNullExpressionValue(viewStub4, "titleBinding.vipIvStub");
        this.vipView = viewStub4;
        titleBinding.f444918s.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.mobileqq.aio.widget.d
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub5, View view) {
                h.s(h.this, viewStub5, view);
            }
        });
        View view = titleBinding.f444917r;
        Intrinsics.checkNotNullExpressionValue(view, "titleBinding.vipDivider");
        this.vipDivider = view;
        ViewStub viewStub5 = titleBinding.f444901b;
        Intrinsics.checkNotNullExpressionValue(viewStub5, "titleBinding.centerRight1IvStub");
        this.centerRight1View = viewStub5;
        titleBinding.f444901b.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.mobileqq.aio.widget.e
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub6, View view2) {
                h.t(h.this, viewStub6, view2);
            }
        });
        ViewStub viewStub6 = titleBinding.f444902c;
        Intrinsics.checkNotNullExpressionValue(viewStub6, "titleBinding.centerRight2IvStub");
        this.centerRight2View = viewStub6;
        titleBinding.f444902c.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.mobileqq.aio.widget.f
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub7, View view2) {
                h.u(h.this, viewStub7, view2);
            }
        });
        ViewStub viewStub7 = titleBinding.f444904e;
        Intrinsics.checkNotNullExpressionValue(viewStub7, "titleBinding.earIconRightStub");
        this.earView = viewStub7;
        titleBinding.f444904e.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.mobileqq.aio.widget.g
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub8, View view2) {
                h.v(h.this, viewStub8, view2);
            }
        });
    }

    public final void w(boolean changed, int left, int top, int right, int bottom) {
        int i3;
        View j3;
        View j16;
        View j17;
        View j18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(changed), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
            return;
        }
        int i16 = bottom - top;
        t tVar = this.titleBinding;
        t tVar2 = null;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
            tVar = null;
        }
        TextView textView = tVar.f444905f;
        Intrinsics.checkNotNullExpressionValue(textView, "titleBinding.ivTitleBtnLeft");
        View j19 = j(textView);
        if (j19 != null) {
            int l3 = l(j19) + 0;
            int measuredHeight = ((i16 - j19.getMeasuredHeight()) >> 1) + n(j19);
            j19.layout(l3, measuredHeight, j19.getMeasuredWidth() + l3, j19.getMeasuredHeight() + measuredHeight);
            i3 = l3 + m(j19) + j19.getMeasuredWidth();
        } else {
            i3 = 0;
        }
        View view = this.leftUserInfoView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftUserInfoView");
            view = null;
        }
        View j26 = j(view);
        if (j26 != null) {
            int l16 = l(j26) + i3;
            int measuredHeight2 = ((i16 - j26.getMeasuredHeight()) >> 1) + n(j26);
            j26.layout(l16, measuredHeight2, j26.getMeasuredWidth() + l16, j26.getMeasuredHeight() + measuredHeight2);
        }
        t tVar3 = this.titleBinding;
        if (tVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
            tVar3 = null;
        }
        QUIBadgeMosaic qUIBadgeMosaic = tVar3.f444916q;
        Intrinsics.checkNotNullExpressionValue(qUIBadgeMosaic, "titleBinding.unreadTv");
        View j27 = j(qUIBadgeMosaic);
        if (j27 != null) {
            int l17 = i3 + l(j27);
            int measuredHeight3 = ((i16 - j27.getMeasuredHeight()) >> 1) + n(j27);
            j27.layout(l17, measuredHeight3, j27.getMeasuredWidth() + l17, j27.getMeasuredHeight() + measuredHeight3);
            i3 = l17 + m(j27) + j27.getMeasuredWidth();
        }
        t tVar4 = this.titleBinding;
        if (tVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
            tVar4 = null;
        }
        CommonTextView commonTextView = tVar4.f444914o;
        Intrinsics.checkNotNullExpressionValue(commonTextView, "titleBinding.titleTv");
        View j28 = j(commonTextView);
        if (j28 != null) {
            int l18 = i3 + l(j28);
            int n3 = n(j28) + (i() ? 0 : (i16 - j28.getMeasuredHeight()) >> 1);
            j28.layout(l18, n3, j28.getMeasuredWidth() + l18, j28.getMeasuredHeight() + n3);
            int measuredHeight4 = j28.getMeasuredHeight() + k(j28) + n3;
            t tVar5 = this.titleBinding;
            if (tVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                tVar5 = null;
            }
            ImageView imageView = tVar5.f444909j;
            Intrinsics.checkNotNullExpressionValue(imageView, "titleBinding.subTitleIcon");
            View j29 = j(imageView);
            if (j29 != null) {
                t tVar6 = this.titleBinding;
                if (tVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                    tVar6 = null;
                }
                int left2 = tVar6.f444914o.getLeft();
                t tVar7 = this.titleBinding;
                if (tVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                    tVar7 = null;
                }
                int top2 = tVar7.f444914o.getTop();
                j29.layout(left2, top2, j29.getMeasuredWidth() + left2, j29.getMeasuredHeight() + top2);
            }
            NTViewFlipper nTViewFlipper = this.filipperView;
            if (nTViewFlipper != null && (j18 = j(nTViewFlipper)) != null) {
                int n16 = measuredHeight4 + n(j18);
                t tVar8 = this.titleBinding;
                if (tVar8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                    tVar8 = null;
                }
                if (tVar8.f444909j.getVisibility() == 0) {
                    t tVar9 = this.titleBinding;
                    if (tVar9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                        tVar9 = null;
                    }
                    int right2 = tVar9.f444909j.getRight();
                    t tVar10 = this.titleBinding;
                    if (tVar10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                        tVar10 = null;
                    }
                    ImageView imageView2 = tVar10.f444909j;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "titleBinding.subTitleIcon");
                    int m3 = right2 + m(imageView2) + l(j18);
                    j18.layout(m3, n16, j18.getMeasuredWidth() + m3, j18.getMeasuredHeight() + n16);
                } else {
                    int l19 = l(j18) + l18;
                    j18.layout(l19, n16, j18.getMeasuredWidth() + l19, j18.getMeasuredHeight() + n16);
                }
            }
            View view2 = this.talkbackView;
            if (view2 != null && (j17 = j(view2)) != null) {
                j17.layout(l18, n3, j17.getMeasuredWidth() + l18, j17.getMeasuredHeight() + n3);
            }
            i3 = l18 + m(j28) + j28.getMeasuredWidth();
        }
        t tVar11 = this.titleBinding;
        if (tVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
            tVar11 = null;
        }
        CommonTextView commonTextView2 = tVar11.f444913n;
        Intrinsics.checkNotNullExpressionValue(commonTextView2, "titleBinding.titleTailTv");
        View j36 = j(commonTextView2);
        if (j36 != null) {
            int l26 = i3 + l(j36);
            t tVar12 = this.titleBinding;
            if (tVar12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                tVar12 = null;
            }
            int bottom2 = tVar12.f444914o.getBottom();
            t tVar13 = this.titleBinding;
            if (tVar13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                tVar13 = null;
            }
            int measuredHeight5 = bottom2 - ((tVar13.f444914o.getMeasuredHeight() - j36.getMeasuredHeight()) >> 1);
            j36.layout(l26, measuredHeight5 - j36.getMeasuredHeight(), j36.getMeasuredWidth() + l26, measuredHeight5);
            i3 = l26 + m(j36) + j36.getMeasuredWidth();
        }
        View view3 = this.frameView;
        if (view3 != null && (j16 = j(view3)) != null) {
            int l27 = i3 + l(j16);
            t tVar14 = this.titleBinding;
            if (tVar14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                tVar14 = null;
            }
            int top3 = tVar14.f444913n.getTop();
            int measuredWidth = j16.getMeasuredWidth() + l27;
            t tVar15 = this.titleBinding;
            if (tVar15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                tVar15 = null;
            }
            j16.layout(l27, top3, measuredWidth, tVar15.f444913n.getBottom());
            i3 = l27 + m(j16) + j16.getMeasuredWidth();
        }
        View view4 = this.vipView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vipView");
            view4 = null;
        }
        View j37 = j(view4);
        if (j37 != null) {
            int l28 = i3 + l(j37);
            t tVar16 = this.titleBinding;
            if (tVar16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                tVar16 = null;
            }
            int bottom3 = tVar16.f444914o.getBottom();
            t tVar17 = this.titleBinding;
            if (tVar17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                tVar17 = null;
            }
            int measuredHeight6 = bottom3 - ((tVar17.f444914o.getMeasuredHeight() - j37.getMeasuredHeight()) >> 1);
            j37.layout(l28, measuredHeight6 - j37.getMeasuredHeight(), j37.getMeasuredWidth() + l28, measuredHeight6);
            i3 = l28 + m(j37) + j37.getMeasuredWidth();
        }
        View view5 = this.vipDivider;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vipDivider");
            view5 = null;
        }
        View j38 = j(view5);
        if (j38 != null) {
            int l29 = i3 + l(j38);
            t tVar18 = this.titleBinding;
            if (tVar18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                tVar18 = null;
            }
            int bottom4 = tVar18.f444914o.getBottom();
            t tVar19 = this.titleBinding;
            if (tVar19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                tVar19 = null;
            }
            int measuredHeight7 = bottom4 - ((tVar19.f444914o.getMeasuredHeight() - j38.getMeasuredHeight()) >> 1);
            j38.layout(l29, measuredHeight7 - j38.getMeasuredHeight(), j38.getMeasuredWidth() + l29, measuredHeight7);
            i3 = l29 + m(j38) + j38.getMeasuredWidth();
        }
        View view6 = this.centerRight1View;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerRight1View");
            view6 = null;
        }
        View j39 = j(view6);
        if (j39 != null) {
            int l36 = i3 + l(j39);
            t tVar20 = this.titleBinding;
            if (tVar20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                tVar20 = null;
            }
            int bottom5 = tVar20.f444914o.getBottom();
            t tVar21 = this.titleBinding;
            if (tVar21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                tVar21 = null;
            }
            int measuredHeight8 = bottom5 - ((tVar21.f444914o.getMeasuredHeight() - j39.getMeasuredHeight()) >> 1);
            j39.layout(l36, measuredHeight8 - j39.getMeasuredHeight(), j39.getMeasuredWidth() + l36, measuredHeight8);
            i3 = l36 + m(j39) + j39.getMeasuredWidth();
        }
        View view7 = this.centerRight2View;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerRight2View");
            view7 = null;
        }
        View j46 = j(view7);
        if (j46 != null) {
            int l37 = i3 + l(j46);
            t tVar22 = this.titleBinding;
            if (tVar22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                tVar22 = null;
            }
            int bottom6 = tVar22.f444914o.getBottom();
            t tVar23 = this.titleBinding;
            if (tVar23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                tVar23 = null;
            }
            int measuredHeight9 = bottom6 - ((tVar23.f444914o.getMeasuredHeight() - j46.getMeasuredHeight()) >> 1);
            j46.layout(l37, measuredHeight9 - j46.getMeasuredHeight(), j46.getMeasuredWidth() + l37, measuredHeight9);
            i3 = l37 + m(j46) + j46.getMeasuredWidth();
        }
        View view8 = this.earView;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("earView");
            view8 = null;
        }
        View j47 = j(view8);
        if (j47 != null) {
            int l38 = i3 + l(j47);
            t tVar24 = this.titleBinding;
            if (tVar24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                tVar24 = null;
            }
            int bottom7 = tVar24.f444914o.getBottom();
            t tVar25 = this.titleBinding;
            if (tVar25 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                tVar25 = null;
            }
            int measuredHeight10 = bottom7 - ((tVar25.f444914o.getMeasuredHeight() - j47.getMeasuredHeight()) >> 1);
            j47.layout(l38, measuredHeight10 - j47.getMeasuredHeight(), j47.getMeasuredWidth() + l38, measuredHeight10);
            m(j47);
            j47.getMeasuredWidth();
        }
        int i17 = right - left;
        t tVar26 = this.titleBinding;
        if (tVar26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
            tVar26 = null;
        }
        RedDotImageView redDotImageView = tVar26.f444907h;
        Intrinsics.checkNotNullExpressionValue(redDotImageView, "titleBinding.right1Iv");
        View j48 = j(redDotImageView);
        if (j48 != null) {
            int m16 = i17 - m(j48);
            int measuredHeight11 = ((i16 - j48.getMeasuredHeight()) >> 1) + n(j48);
            j48.layout(m16 - j48.getMeasuredWidth(), measuredHeight11, m16, j48.getMeasuredHeight() + measuredHeight11);
            i17 = m16 - (l(j48) + j48.getMeasuredWidth());
        }
        View view9 = this.troopSquareView;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopSquareView");
            view9 = null;
        }
        View j49 = j(view9);
        if (j49 != null) {
            int m17 = i17 - m(j49);
            int measuredHeight12 = ((i16 - j49.getMeasuredHeight()) >> 1) + n(j49);
            j49.layout(m17 - j49.getMeasuredWidth(), measuredHeight12, m17, j49.getMeasuredHeight() + measuredHeight12);
        }
        View view10 = this.titleTabView;
        if (view10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTabView");
            view10 = null;
        }
        View j56 = j(view10);
        if (j56 != null) {
            int m18 = i17 - m(j56);
            int n17 = n(j56);
            j56.layout(m18 - j56.getMeasuredWidth(), n17, m18, j56.getMeasuredHeight() + n17);
        }
        t tVar27 = this.titleBinding;
        if (tVar27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
        } else {
            tVar2 = tVar27;
        }
        RedDotImageView redDotImageView2 = tVar2.f444908i;
        Intrinsics.checkNotNullExpressionValue(redDotImageView2, "titleBinding.right2Iv");
        View j57 = j(redDotImageView2);
        if (j57 != null) {
            int m19 = i17 - m(j57);
            int measuredHeight13 = ((i16 - j57.getMeasuredHeight()) >> 1) + n(j57);
            j57.layout(m19 - j57.getMeasuredWidth(), measuredHeight13, m19, j57.getMeasuredHeight() + measuredHeight13);
            i17 = m19 - (l(j57) + j57.getMeasuredWidth());
        }
        View view11 = this.right3View;
        if (view11 == null || (j3 = j(view11)) == null) {
            return;
        }
        int m26 = i17 - m(j3);
        int measuredHeight14 = ((i16 - j3.getMeasuredHeight()) >> 1) + n(j3);
        j3.layout(m26 - j3.getMeasuredWidth(), measuredHeight14, m26, j3.getMeasuredHeight() + measuredHeight14);
        l(j3);
        j3.getMeasuredWidth();
    }

    public final void x(int widthMeasureSpec, int heightMeasureSpec) {
        int i3;
        int i16;
        View j3;
        View j16;
        int coerceAtLeast;
        int measuredWidth;
        int measuredWidth2;
        View j17;
        View j18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
            return;
        }
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        t tVar = this.titleBinding;
        t tVar2 = null;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
            tVar = null;
        }
        TextView textView = tVar.f444905f;
        Intrinsics.checkNotNullExpressionValue(textView, "titleBinding.ivTitleBtnLeft");
        int y16 = y(textView, widthMeasureSpec, heightMeasureSpec) + 0;
        t tVar3 = this.titleBinding;
        if (tVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
            tVar3 = null;
        }
        QUIBadgeMosaic qUIBadgeMosaic = tVar3.f444916q;
        Intrinsics.checkNotNullExpressionValue(qUIBadgeMosaic, "titleBinding.unreadTv");
        int y17 = y16 + y(qUIBadgeMosaic, widthMeasureSpec, heightMeasureSpec);
        t tVar4 = this.titleBinding;
        if (tVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
            tVar4 = null;
        }
        CommonTextView commonTextView = tVar4.f444913n;
        Intrinsics.checkNotNullExpressionValue(commonTextView, "titleBinding.titleTailTv");
        int z16 = y17 + z(commonTextView, widthMeasureSpec, heightMeasureSpec);
        View view = this.vipView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vipView");
            view = null;
        }
        int y18 = z16 + y(view, widthMeasureSpec, heightMeasureSpec);
        View view2 = this.vipDivider;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vipDivider");
            view2 = null;
        }
        int y19 = y18 + y(view2, widthMeasureSpec, heightMeasureSpec);
        View view3 = this.centerRight1View;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerRight1View");
            view3 = null;
        }
        int y26 = y19 + y(view3, widthMeasureSpec, heightMeasureSpec);
        View view4 = this.centerRight2View;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerRight2View");
            view4 = null;
        }
        int y27 = y26 + y(view4, widthMeasureSpec, heightMeasureSpec);
        View view5 = this.earView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("earView");
            view5 = null;
        }
        t tVar5 = this.titleBinding;
        if (tVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
            tVar5 = null;
        }
        int y28 = y27 + y(view5, widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(tVar5.f444913n.getMeasuredHeight(), 1073741824));
        t tVar6 = this.titleBinding;
        if (tVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
            tVar6 = null;
        }
        RedDotImageView redDotImageView = tVar6.f444907h;
        Intrinsics.checkNotNullExpressionValue(redDotImageView, "titleBinding.right1Iv");
        int y29 = y28 + y(redDotImageView, widthMeasureSpec, heightMeasureSpec);
        t tVar7 = this.titleBinding;
        if (tVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
            tVar7 = null;
        }
        RedDotImageView redDotImageView2 = tVar7.f444908i;
        Intrinsics.checkNotNullExpressionValue(redDotImageView2, "titleBinding.right2Iv");
        int y36 = y29 + y(redDotImageView2, widthMeasureSpec, heightMeasureSpec);
        View view6 = this.right3View;
        if (view6 != null && (j18 = j(view6)) != null) {
            i3 = y(j18, widthMeasureSpec, heightMeasureSpec);
        } else {
            i3 = 0;
        }
        int i17 = y36 + i3;
        View view7 = this.frameView;
        if (view7 != null && (j17 = j(view7)) != null) {
            t tVar8 = this.titleBinding;
            if (tVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                tVar8 = null;
            }
            i16 = y(j17, widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(tVar8.f444913n.getMeasuredHeight(), 1073741824));
        } else {
            i16 = 0;
        }
        int i18 = i17 + i16;
        View view8 = this.troopSquareView;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopSquareView");
            view8 = null;
        }
        View j19 = j(view8);
        if (j19 != null && j19.getVisibility() != 8) {
            t tVar9 = this.titleBinding;
            if (tVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                tVar9 = null;
            }
            RedDotImageView redDotImageView3 = tVar9.f444907h;
            if (redDotImageView3.getVisibility() == 8) {
                measuredWidth2 = 0;
            } else {
                ViewGroup.LayoutParams layoutParams = redDotImageView3.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                measuredWidth2 = redDotImageView3.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            }
            j19.measure(View.MeasureSpec.makeMeasureSpec(size - measuredWidth2, Integer.MIN_VALUE), heightMeasureSpec);
            i18 += j19.getMeasuredWidth();
        }
        View view9 = this.titleTabView;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTabView");
            view9 = null;
        }
        View j26 = j(view9);
        if (j26 != null && j26.getVisibility() != 8) {
            t tVar10 = this.titleBinding;
            if (tVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                tVar10 = null;
            }
            RedDotImageView redDotImageView4 = tVar10.f444907h;
            if (redDotImageView4.getVisibility() == 8) {
                measuredWidth = 0;
            } else {
                ViewGroup.LayoutParams layoutParams2 = redDotImageView4.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                measuredWidth = redDotImageView4.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
            }
            j26.measure(View.MeasureSpec.makeMeasureSpec(size - measuredWidth, Integer.MIN_VALUE), heightMeasureSpec);
            i18 += j26.getMeasuredWidth();
        }
        int a16 = (size - i18) - x.a(8.0f);
        t tVar11 = this.titleBinding;
        if (tVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
            tVar11 = null;
        }
        CommonTextView commonTextView2 = tVar11.f444914o;
        Intrinsics.checkNotNullExpressionValue(commonTextView2, "titleBinding.titleTv");
        View j27 = j(commonTextView2);
        if (j27 != null) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(a16, 0);
            y(j27, View.MeasureSpec.makeMeasureSpec(coerceAtLeast, Integer.MIN_VALUE), heightMeasureSpec);
        }
        t tVar12 = this.titleBinding;
        if (tVar12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
            tVar12 = null;
        }
        ImageView imageView = tVar12.f444909j;
        Intrinsics.checkNotNullExpressionValue(imageView, "titleBinding.subTitleIcon");
        y(imageView, widthMeasureSpec, heightMeasureSpec);
        View view10 = this.leftUserInfoView;
        if (view10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftUserInfoView");
            view10 = null;
        }
        View j28 = j(view10);
        if (j28 != null && j28.getVisibility() != 8) {
            t tVar13 = this.titleBinding;
            if (tVar13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                tVar13 = null;
            }
            TextView textView2 = tVar13.f444905f;
            int measuredWidth3 = textView2.getMeasuredWidth();
            ViewGroup.LayoutParams layoutParams3 = textView2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            int i19 = measuredWidth3 + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin;
            ViewGroup.LayoutParams layoutParams4 = textView2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            int i26 = 0 + i19 + ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin;
            t tVar14 = this.titleBinding;
            if (tVar14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                tVar14 = null;
            }
            RedDotImageView redDotImageView5 = tVar14.f444907h;
            int measuredWidth4 = redDotImageView5.getMeasuredWidth();
            ViewGroup.LayoutParams layoutParams5 = redDotImageView5.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            int i27 = measuredWidth4 + ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin;
            ViewGroup.LayoutParams layoutParams6 = redDotImageView5.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams6, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            y(j28, View.MeasureSpec.makeMeasureSpec(size - (i26 + (i27 + ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin)), Integer.MIN_VALUE), heightMeasureSpec);
        }
        NTViewFlipper nTViewFlipper = this.filipperView;
        if (nTViewFlipper != null && (j16 = j(nTViewFlipper)) != null) {
            y(j16, widthMeasureSpec, heightMeasureSpec);
        }
        t tVar15 = this.titleBinding;
        if (tVar15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
            tVar15 = null;
        }
        int width = tVar15.f444914o.getWidth();
        t tVar16 = this.titleBinding;
        if (tVar16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
            tVar16 = null;
        }
        int width2 = width + tVar16.f444913n.getWidth();
        t tVar17 = this.titleBinding;
        if (tVar17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
        } else {
            tVar2 = tVar17;
        }
        int height = tVar2.f444914o.getHeight();
        View view11 = this.talkbackView;
        if (view11 != null && (j3 = j(view11)) != null) {
            y(j3, View.MeasureSpec.makeMeasureSpec(width2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE));
        }
    }
}
