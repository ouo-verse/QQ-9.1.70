package com.tencent.mobileqq.aio.msglist.holder.template;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.msglist.holder.template.n;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.aio.holder.template.BubbleLayoutCompatPress;
import com.tencent.qqnt.aio.holder.template.TemplateLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b%\u0010&J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\u0012\u0010\u0017\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0019\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u001b\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u001d\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\bH\u0016R\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010!R\u0016\u0010$\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/template/b;", "Lcom/tencent/mobileqq/aio/msglist/holder/template/n;", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "isSelf", "Landroid/view/View;", "d", "view", "", "f", "a", "g", "b", "Landroid/view/ViewStub;", "r", "Lcom/tencent/qqnt/aio/holder/template/d;", "intercepter", HippyTKDListViewAdapter.X, ReportConstant.COSTREPORT_PREFIX, "l", "c", "e", "t", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "v", "j", "Lp81/e;", "Lp81/e;", "mBinding", "Z", "mSelectInflated", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b implements n {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private p81.e mBinding;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean mSelectInflated;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/template/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.template.b$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52781);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(b this$0, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mSelectInflated = true;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @Nullable
    public View a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @NotNull
    public View b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        p81.e eVar = this.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        BubbleLayoutCompatPress bubbleLayoutCompatPress = eVar.f425727b;
        Intrinsics.checkNotNullExpressionValue(bubbleLayoutCompatPress, "mBinding.msgContent");
        return bubbleLayoutCompatPress;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void c(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @NotNull
    public View d(@NotNull Context context, @NotNull ViewGroup parent, boolean isSelf) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, context, parent, Boolean.valueOf(isSelf));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        p81.e g16 = p81.e.g(LayoutInflater.from(context), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, parent, false)");
        this.mBinding = g16;
        p81.e eVar = null;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            g16 = null;
        }
        g16.f425728c.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.template.a
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view) {
                b.B(b.this, viewStub, view);
            }
        });
        p81.e eVar2 = this.mBinding;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar = eVar2;
        }
        TemplateLayout templateLayout = eVar.f425730e;
        Intrinsics.checkNotNullExpressionValue(templateLayout, "mBinding.root");
        return templateLayout;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @Nullable
    public View e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (View) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void f(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void g(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
            return;
        }
        if (view != null) {
            p81.e eVar = this.mBinding;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar = null;
            }
            eVar.f425727b.addView(view);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @Nullable
    public ViewStub h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (ViewStub) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return n.a.a(this);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @Nullable
    public View i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (View) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return n.a.f(this);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @Nullable
    public View j(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (View) iPatchRedirector.redirect((short) 19, (Object) this, (Object) view);
        }
        Intrinsics.checkNotNullParameter(view, "view");
        return null;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @Nullable
    public ViewStub k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (ViewStub) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return n.a.e(this);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @NotNull
    public View l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        p81.e eVar = this.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        FrameLayout frameLayout = eVar.f425729d;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.msgTime");
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void m(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @Nullable
    public ViewStub n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (ViewStub) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return n.a.b(this);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @Nullable
    public ViewStub o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (ViewStub) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return n.a.c(this);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void p(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) view);
        } else {
            n.a.h(this, view);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void q(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            n.a.i(this, z16);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @NotNull
    public ViewStub r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ViewStub) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        p81.e eVar = this.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        ViewStub viewStub = eVar.f425728c;
        Intrinsics.checkNotNullExpressionValue(viewStub, "mBinding.msgMultiSelect");
        return viewStub;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void s(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
            return;
        }
        if (view != null) {
            p81.e eVar = this.mBinding;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar = null;
            }
            eVar.f425729d.addView(view);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void t(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @Nullable
    public View u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (View) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @Nullable
    public View v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (View) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @Nullable
    public ViewStub w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (ViewStub) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return n.a.d(this);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void x(@NotNull com.tencent.qqnt.aio.holder.template.d intercepter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) intercepter);
            return;
        }
        Intrinsics.checkNotNullParameter(intercepter, "intercepter");
        p81.e eVar = this.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        eVar.f425730e.setOnInterceptTouchListener(intercepter);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @Nullable
    public View y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (View) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void z(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) view);
        }
    }
}
