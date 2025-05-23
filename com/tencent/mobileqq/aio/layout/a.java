package com.tencent.mobileqq.aio.layout;

import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.b;
import com.tencent.mobileqq.aio.layout.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.lazy.FrameLayoutLazyVB;
import com.tencent.qqnt.aio.utils.ViewUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00052\u00020\u0001:\u0001\u0014B#\u0012\u001a\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00180\u0017\u00a2\u0006\u0004\b \u0010!J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016J0\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0006\u0010\u0016\u001a\u00020\u0015R(\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/aio/layout/a;", "Lcom/tencent/aio/api/b;", "Lcom/tencent/mobileqq/aio/layout/d;", "type", "Landroid/view/View;", "d", "Lcom/tencent/mobileqq/aio/layout/c;", "listener", "", "f", "", "parentWidthMeasureSpec", "parentHeightMeasureSpec", "Lcom/tencent/aio/api/c;", "parentPadding", "c", "parentLeft", "parentTop", "parentRight", "parentBottom", "a", "Lcom/tencent/mobileqq/aio/layout/b;", "e", "", "Lcom/tencent/aio/base/mvvm/a;", "Ljava/util/Map;", "childrenVB", "b", "Lcom/tencent/mobileqq/aio/layout/c;", "mLayoutListener", "Lcom/tencent/mobileqq/aio/layout/b;", "mBottom", "<init>", "(Ljava/util/Map;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a implements com.tencent.aio.api.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<d, com.tencent.aio.base.mvvm.a<?, ?>> childrenVB;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c mLayoutListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mBottom;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/layout/a$a;", "", "", "TAG", "Ljava/lang/String;", "", "UNDER_TITLE_AREA_GAP_DP", UserInfo.SEX_FEMALE, "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.layout.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57065);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull Map<d, ? extends com.tencent.aio.base.mvvm.a<?, ?>> childrenVB) {
        Intrinsics.checkNotNullParameter(childrenVB, "childrenVB");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) childrenVB);
        } else {
            this.childrenVB = childrenVB;
            this.mBottom = new b(0);
        }
    }

    private final View d(d type) {
        View view;
        com.tencent.aio.base.mvvm.a<?, ?> aVar = this.childrenVB.get(type);
        if (aVar instanceof FrameLayoutLazyVB) {
            view = ((FrameLayoutLazyVB) aVar).d1();
        } else if (aVar != null) {
            view = aVar.getHostView();
        } else {
            view = null;
        }
        if (view == null || view.getVisibility() == 8) {
            return null;
        }
        return view;
    }

    @Override // com.tencent.aio.api.b
    public void a(int parentLeft, int parentTop, int parentRight, int parentBottom, @NotNull com.tencent.aio.api.c parentPadding) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(parentLeft), Integer.valueOf(parentTop), Integer.valueOf(parentRight), Integer.valueOf(parentBottom), parentPadding);
            return;
        }
        Intrinsics.checkNotNullParameter(parentPadding, "parentPadding");
        int i17 = parentRight - 0;
        int i18 = parentBottom - 0;
        View d16 = d(d.e.f189939b);
        if (d16 != null) {
            ViewGroup.LayoutParams layoutParams = d16.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i19 = marginLayoutParams.leftMargin + 0;
            int i26 = marginLayoutParams.topMargin + 0;
            d16.layout(i19, i26, d16.getMeasuredWidth() + i19, d16.getMeasuredHeight() + i26);
            i3 = marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + d16.getMeasuredHeight() + 0;
        } else {
            i3 = 0;
        }
        View d17 = d(d.h.f189942b);
        if (d17 != null) {
            d17.setPadding(0, i3 - ViewUtils.f352270a.a(1.0f), 0, 0);
            d17.layout(0, 0, i17, i18);
        }
        View d18 = d(d.f.f189940b);
        if (d18 != null) {
            ViewGroup.LayoutParams layoutParams2 = d18.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            int i27 = marginLayoutParams2.leftMargin + 0;
            int measuredHeight = (i3 - d18.getMeasuredHeight()) + marginLayoutParams2.topMargin;
            d18.layout(i27, measuredHeight, d18.getMeasuredWidth() + i27, d18.getMeasuredHeight() + measuredHeight);
        }
        View d19 = d(d.g.f189941b);
        if (d19 != null) {
            ViewGroup.LayoutParams layoutParams3 = d19.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
            int i28 = marginLayoutParams3.leftMargin + 0;
            int i29 = i3 + marginLayoutParams3.topMargin;
            d19.layout(i28, i29, d19.getMeasuredWidth() + i28, d19.getMeasuredHeight() + i29);
        }
        View d26 = d(d.C7289d.f189938b);
        if (d26 != null) {
            ViewGroup.LayoutParams layoutParams4 = d26.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
            int i36 = marginLayoutParams4.leftMargin + 0;
            int i37 = i18 - marginLayoutParams4.bottomMargin;
            d26.layout(i36, i37 - d26.getMeasuredHeight(), d26.getMeasuredWidth() + i36, i37);
            i16 = ((i18 - marginLayoutParams4.bottomMargin) - marginLayoutParams4.topMargin) - d26.getMeasuredHeight();
        } else {
            i16 = i18;
        }
        View d27 = d(d.b.f189936b);
        if (d27 != null) {
            ViewGroup.LayoutParams layoutParams5 = d27.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams5;
            int i38 = marginLayoutParams5.leftMargin + 0;
            int i39 = i16 - marginLayoutParams5.bottomMargin;
            d27.layout(i38, i39 - d27.getMeasuredHeight(), d27.getMeasuredWidth() + i38, i39);
            i16 = ((i16 - marginLayoutParams5.bottomMargin) - marginLayoutParams5.topMargin) - d27.getMeasuredHeight();
        }
        View d28 = d(d.a.f189935b);
        if (d28 != null) {
            ViewGroup.LayoutParams layoutParams6 = d28.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams6, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams6 = (ViewGroup.MarginLayoutParams) layoutParams6;
            int i46 = marginLayoutParams6.leftMargin + 0;
            int i47 = i16 - marginLayoutParams6.bottomMargin;
            d28.layout(i46, i47 - d28.getMeasuredHeight(), d28.getMeasuredWidth() + i46, i47);
            i16 = ((i16 - marginLayoutParams6.bottomMargin) - marginLayoutParams6.topMargin) - d28.getMeasuredHeight();
        }
        if (i16 != this.mBottom.a()) {
            this.mBottom.b(i16);
            c cVar = this.mLayoutListener;
            if (cVar != null) {
                cVar.a(0, 0, i17, i18);
            }
        }
        View d29 = d(d.c.f189937b);
        if (d29 != null) {
            ViewGroup.LayoutParams layoutParams7 = d29.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams7, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            int i48 = 0 + ((ViewGroup.MarginLayoutParams) layoutParams7).leftMargin;
            d29.layout(i48, i18 - d29.getMeasuredHeight(), d29.getMeasuredWidth() + i48, i18);
        }
    }

    @Override // com.tencent.aio.api.b
    public void b(@Nullable Canvas canvas, @NotNull com.tencent.aio.api.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas, (Object) cVar);
        } else {
            b.a.a(this, canvas, cVar);
        }
    }

    @Override // com.tencent.aio.api.b
    public void c(int parentWidthMeasureSpec, int parentHeightMeasureSpec, @NotNull com.tencent.aio.api.c parentPadding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(parentWidthMeasureSpec), Integer.valueOf(parentHeightMeasureSpec), parentPadding);
            return;
        }
        Intrinsics.checkNotNullParameter(parentPadding, "parentPadding");
        if (QLog.isDebugVersion()) {
            QLog.d("AIOThirdLayoutImpl", 4, "measureChildren");
        }
        View d16 = d(d.e.f189939b);
        if (d16 != null) {
            com.tencent.aio.base.tool.b.d(com.tencent.aio.base.tool.b.f69219a, d16, parentWidthMeasureSpec, 0, parentHeightMeasureSpec, 0, 0, 0, parentPadding.d(), parentPadding.a(), 116, null);
        }
        View d17 = d(d.h.f189942b);
        if (d17 != null) {
            com.tencent.aio.base.tool.b.d(com.tencent.aio.base.tool.b.f69219a, d17, parentWidthMeasureSpec, 0, parentHeightMeasureSpec, 0, 0, 0, parentPadding.d(), parentPadding.a(), 116, null);
        }
        View d18 = d(d.f.f189940b);
        if (d18 != null) {
            com.tencent.aio.base.tool.b.d(com.tencent.aio.base.tool.b.f69219a, d18, parentWidthMeasureSpec, 0, parentHeightMeasureSpec, 0, 0, 0, parentPadding.d(), parentPadding.a(), 116, null);
        }
        View d19 = d(d.g.f189941b);
        if (d19 != null) {
            com.tencent.aio.base.tool.b.d(com.tencent.aio.base.tool.b.f69219a, d19, parentWidthMeasureSpec, 0, parentHeightMeasureSpec, 0, 0, 0, parentPadding.d(), parentPadding.a(), 116, null);
        }
        View d26 = d(d.C7289d.f189938b);
        if (d26 != null) {
            com.tencent.aio.base.tool.b.d(com.tencent.aio.base.tool.b.f69219a, d26, parentWidthMeasureSpec, 0, parentHeightMeasureSpec, 0, 0, 0, parentPadding.d(), parentPadding.a(), 116, null);
        }
        View d27 = d(d.b.f189936b);
        if (d27 != null) {
            com.tencent.aio.base.tool.b.d(com.tencent.aio.base.tool.b.f69219a, d27, parentWidthMeasureSpec, 0, parentHeightMeasureSpec, 0, 0, 0, parentPadding.d(), parentPadding.a(), 116, null);
        }
        View d28 = d(d.a.f189935b);
        if (d28 != null) {
            com.tencent.aio.base.tool.b.d(com.tencent.aio.base.tool.b.f69219a, d28, parentWidthMeasureSpec, 0, parentHeightMeasureSpec, 0, 0, 0, parentPadding.d(), parentPadding.a(), 116, null);
        }
        View d29 = d(d.c.f189937b);
        if (d29 != null) {
            com.tencent.aio.base.tool.b.d(com.tencent.aio.base.tool.b.f69219a, d29, parentWidthMeasureSpec, 0, parentHeightMeasureSpec, 0, 0, 0, parentPadding.d(), parentPadding.a(), 116, null);
        }
    }

    @NotNull
    public final b e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (b) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mBottom;
    }

    public final void f(@NotNull c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.mLayoutListener = listener;
        }
    }
}
