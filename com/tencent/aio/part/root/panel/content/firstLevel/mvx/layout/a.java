package com.tencent.aio.part.root.panel.content.firstLevel.mvx.layout;

import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.aio.api.b;
import com.tencent.aio.api.c;
import com.tencent.aio.part.root.panel.content.thirdLevel.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0014B#\u0012\u001a\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00160\u0015\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0016J0\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0016R(\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/mvx/layout/a;", "Lcom/tencent/aio/api/b;", "Lcom/tencent/aio/part/root/panel/content/thirdLevel/a;", "type", "Landroid/view/View;", "d", "Landroid/graphics/Canvas;", PM.CANVAS, "Lcom/tencent/aio/api/c;", "parentPadding", "", "b", "", "parentWidthMeasureSpec", "parentHeightMeasureSpec", "c", "parentLeft", "parentTop", "parentRight", "parentBottom", "a", "", "Lcom/tencent/aio/base/mvvm/a;", "Ljava/util/Map;", "childrenVB", "<init>", "(Ljava/util/Map;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<com.tencent.aio.part.root.panel.content.thirdLevel.a, com.tencent.aio.base.mvvm.a<?, ?>> childrenVB;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/mvx/layout/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.mvx.layout.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53218);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull Map<com.tencent.aio.part.root.panel.content.thirdLevel.a, ? extends com.tencent.aio.base.mvvm.a<?, ?>> childrenVB) {
        Intrinsics.checkNotNullParameter(childrenVB, "childrenVB");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) childrenVB);
        } else {
            this.childrenVB = childrenVB;
        }
    }

    private final View d(com.tencent.aio.part.root.panel.content.thirdLevel.a type) {
        com.tencent.aio.base.mvvm.a<?, ?> aVar = this.childrenVB.get(type);
        if (aVar != null) {
            return aVar.safetyGetHostView();
        }
        return null;
    }

    @Override // com.tencent.aio.api.b
    public void a(int parentLeft, int parentTop, int parentRight, int parentBottom, @NotNull c parentPadding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(parentLeft), Integer.valueOf(parentTop), Integer.valueOf(parentRight), Integer.valueOf(parentBottom), parentPadding);
            return;
        }
        Intrinsics.checkNotNullParameter(parentPadding, "parentPadding");
        int d16 = parentPadding.d();
        int a16 = (parentBottom - parentTop) - parentPadding.a();
        int d17 = parentPadding.d();
        com.tencent.aio.base.mvvm.a<?, ?> aVar = this.childrenVB.get(a.C0650a.f69705b);
        if (aVar != null) {
            View hostView = aVar.getHostView();
            int measuredWidth = hostView.getMeasuredWidth();
            int measuredHeight = hostView.getMeasuredHeight();
            ViewGroup.LayoutParams layoutParams = hostView.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                int i3 = a16 + marginLayoutParams.bottomMargin;
                int i16 = i3 - measuredHeight;
                hostView.layout(0, i16, measuredWidth + 0, i3);
                a16 = i16 - marginLayoutParams.topMargin;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
        }
        com.tencent.aio.base.mvvm.a<?, ?> aVar2 = this.childrenVB.get(a.c.f69707b);
        if (aVar2 != null) {
            View hostView2 = aVar2.getHostView();
            int measuredWidth2 = hostView2.getMeasuredWidth();
            int measuredHeight2 = hostView2.getMeasuredHeight();
            ViewGroup.LayoutParams layoutParams2 = hostView2.getLayoutParams();
            if (layoutParams2 != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                int i17 = d16 - marginLayoutParams2.topMargin;
                int i18 = measuredHeight2 + i17;
                hostView2.layout(0, i17, measuredWidth2 + 0, i18);
                d17 = i18 + marginLayoutParams2.bottomMargin;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
        }
        com.tencent.aio.base.mvvm.a<?, ?> aVar3 = this.childrenVB.get(a.b.f69706b);
        if (aVar3 != null) {
            View hostView3 = aVar3.getHostView();
            ViewGroup.LayoutParams layoutParams3 = hostView3.getLayoutParams();
            if (layoutParams3 != null) {
                FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
                int i19 = d17 + layoutParams4.topMargin;
                int i26 = a16 - layoutParams4.bottomMargin;
                int measuredWidth3 = hostView3.getMeasuredWidth();
                int measuredHeight3 = hostView3.getMeasuredHeight();
                if (com.tencent.aio.base.a.f69150c.a()) {
                    com.tencent.aio.base.log.a.f69187b.d("DefaultFirstLayoutImpl", "width  " + measuredWidth3 + " height " + measuredHeight3);
                }
                hostView3.layout(0, i19, measuredWidth3 + 0, i26);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }

    @Override // com.tencent.aio.api.b
    public void b(@Nullable Canvas canvas, @NotNull c parentPadding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) canvas, (Object) parentPadding);
        } else {
            Intrinsics.checkNotNullParameter(parentPadding, "parentPadding");
            b.a.a(this, canvas, parentPadding);
        }
    }

    @Override // com.tencent.aio.api.b
    public void c(int parentWidthMeasureSpec, int parentHeightMeasureSpec, @NotNull c parentPadding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(parentWidthMeasureSpec), Integer.valueOf(parentHeightMeasureSpec), parentPadding);
            return;
        }
        Intrinsics.checkNotNullParameter(parentPadding, "parentPadding");
        View.MeasureSpec.getSize(parentWidthMeasureSpec);
        int size = View.MeasureSpec.getSize(parentHeightMeasureSpec);
        com.tencent.aio.base.a aVar = com.tencent.aio.base.a.f69150c;
        if (aVar.a()) {
            com.tencent.aio.base.log.a.f69187b.d("DefaultFirstLayoutImpl", "measureChildren");
        }
        int d16 = (size - parentPadding.d()) - parentPadding.a();
        View d17 = d(a.c.f69707b);
        if (d17 != null) {
            com.tencent.aio.base.tool.b.d(com.tencent.aio.base.tool.b.f69219a, d17, parentWidthMeasureSpec, 0, parentHeightMeasureSpec, 0, 0, 0, parentPadding.d(), parentPadding.a(), 116, null);
            if (aVar.a()) {
                com.tencent.aio.base.log.a.f69187b.d("DefaultFirstLayoutImpl", "MsgTopAea  height " + d17.getMeasuredHeight());
            }
            d16 -= d17.getMeasuredHeight();
        }
        View d18 = d(a.C0650a.f69705b);
        if (d18 != null) {
            com.tencent.aio.base.tool.b.d(com.tencent.aio.base.tool.b.f69219a, d18, parentWidthMeasureSpec, 0, parentHeightMeasureSpec, 0, 0, 0, parentPadding.d(), parentPadding.a(), 116, null);
            if (aVar.a()) {
                com.tencent.aio.base.log.a.f69187b.d("DefaultFirstLayoutImpl", "msgBottomArea  height " + d18.getMeasuredHeight());
            }
            d16 -= d18.getMeasuredHeight();
        }
        View d19 = d(a.b.f69706b);
        if (d19 != null) {
            d19.measure(parentWidthMeasureSpec, View.MeasureSpec.makeMeasureSpec(d16, 1073741824));
            if (aVar.a()) {
                com.tencent.aio.base.log.a.f69187b.d("DefaultFirstLayoutImpl", "inputArea param " + d19.getLayoutParams() + " needHeight " + d16 + " measureHeight " + d19.getMeasuredHeight());
            }
        }
    }
}
