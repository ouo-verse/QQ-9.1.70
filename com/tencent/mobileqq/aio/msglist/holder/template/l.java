package com.tencent.mobileqq.aio.msglist.holder.template;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.template.n;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.holder.template.TemplateLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w71.q;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b/\u00100J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0019\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u001a\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u001c\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u001e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\u0010H\u0016J\b\u0010\"\u001a\u00020\u0010H\u0016J\b\u0010#\u001a\u00020\bH\u0016J\u0012\u0010$\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0006H\u0016R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010(R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010*R\u0016\u0010,\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010*R\u0016\u0010-\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010*R\u0016\u0010.\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010*\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/template/l;", "Lcom/tencent/mobileqq/aio/msglist/holder/template/n;", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "isSelf", "Landroid/view/View;", "d", "view", "", "f", "a", "g", "b", "Landroid/view/ViewStub;", "o", "c", "e", "r", "Lcom/tencent/qqnt/aio/holder/template/d;", "intercepter", HippyTKDListViewAdapter.X, "l", ReportConstant.COSTREPORT_PREFIX, "t", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "v", "j", tl.h.F, DomainData.DOMAIN_NAME, "i", "p", "isWideScreen", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lw71/q;", "Lw71/q;", "mBinding", "Z", "mSelectInflated", "mLeftSwipeInflated", "mAtmosphereLayoutInflated", "mAvatarEffectLayoutInflated", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class l implements n {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private q mBinding;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean mSelectInflated;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean mLeftSwipeInflated;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mAtmosphereLayoutInflated;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mAvatarEffectLayoutInflated;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/template/l$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.template.l$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64059);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(l this$0, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mSelectInflated = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(l this$0, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mLeftSwipeInflated = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(l this$0, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mAtmosphereLayoutInflated = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(l this$0, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mAvatarEffectLayoutInflated = true;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @NotNull
    public View a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        q qVar = this.mBinding;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            qVar = null;
        }
        FrameLayout frameLayout = qVar.f444880g;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.msgAvatar");
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @Nullable
    public View b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        q qVar = this.mBinding;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            qVar = null;
        }
        return qVar.f444876c;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void c(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
            return;
        }
        if (view != null) {
            q qVar = this.mBinding;
            if (qVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                qVar = null;
            }
            qVar.f444887n.addView(view);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @NotNull
    public View d(@NotNull Context context, @NotNull ViewGroup parent, boolean isSelf) {
        q e16;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, context, parent, Boolean.valueOf(isSelf));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        try {
            e16 = q.g(LayoutInflater.from(context), parent, false);
            Intrinsics.checkNotNullExpressionValue(e16, "{\n            AioSenderB\u2026 parent, false)\n        }");
        } catch (Exception e17) {
            QLog.e("AIOSenderBubbleTemplate", 1, "getTemplateView", e17);
            e16 = q.e(LayoutInflater.from(context).inflate(R.layout.dwc, parent, false));
            Intrinsics.checkNotNullExpressionValue(e16, "{\n            QLog.e(TAG\u2026ding.bind(view)\n        }");
        }
        this.mBinding = e16;
        q qVar = null;
        if (AIOUtil.f194084a.C()) {
            q qVar2 = this.mBinding;
            if (qVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                qVar2 = null;
            }
            ViewGroup.LayoutParams layoutParams = qVar2.f444880g.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.setMarginEnd((int) context.getResources().getDimension(R.dimen.bzs));
            }
        }
        q qVar3 = this.mBinding;
        if (qVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            qVar3 = null;
        }
        qVar3.f444882i.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.template.h
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view) {
                l.E(l.this, viewStub, view);
            }
        });
        q qVar4 = this.mBinding;
        if (qVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            qVar4 = null;
        }
        qVar4.f444878e.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.template.i
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view) {
                l.F(l.this, viewStub, view);
            }
        });
        q qVar5 = this.mBinding;
        if (qVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            qVar5 = null;
        }
        qVar5.f444879f.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.template.j
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view) {
                l.G(l.this, viewStub, view);
            }
        });
        q qVar6 = this.mBinding;
        if (qVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            qVar6 = null;
        }
        qVar6.f444875b.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.template.k
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view) {
                l.H(l.this, viewStub, view);
            }
        });
        q qVar7 = this.mBinding;
        if (qVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            qVar7 = null;
        }
        qVar7.f444880g.setImportantForAccessibility(2);
        q qVar8 = this.mBinding;
        if (qVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            qVar8 = null;
        }
        qVar8.f444876c.setImportantForAccessibility(2);
        q qVar9 = this.mBinding;
        if (qVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            qVar = qVar9;
        }
        TemplateLayout templateLayout = qVar.f444888o;
        Intrinsics.checkNotNullExpressionValue(templateLayout, "mBinding.root");
        return templateLayout;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @Nullable
    public View e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        q qVar = this.mBinding;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            qVar = null;
        }
        return qVar.f444887n;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void f(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            return;
        }
        q qVar = this.mBinding;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            qVar = null;
        }
        qVar.f444880g.addView(view);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void g(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
            return;
        }
        q qVar = this.mBinding;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            qVar = null;
        }
        qVar.f444876c.addView(view);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @NotNull
    public ViewStub h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (ViewStub) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        q qVar = this.mBinding;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            qVar = null;
        }
        ViewStub viewStub = qVar.f444879f;
        Intrinsics.checkNotNullExpressionValue(viewStub, "mBinding.msgAtmosphereLayout");
        return viewStub;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @NotNull
    public View i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (View) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        q qVar = this.mBinding;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            qVar = null;
        }
        FrameLayout frameLayout = qVar.f444884k;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.msgTailContainer");
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @Nullable
    public View j(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (View) iPatchRedirector.redirect((short) 20, (Object) this, (Object) view);
        }
        Intrinsics.checkNotNullParameter(view, "view");
        if (!this.mLeftSwipeInflated) {
            q qVar = this.mBinding;
            if (qVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                qVar = null;
            }
            View inflate = qVar.f444878e.inflate();
            if (inflate instanceof ViewGroup) {
                ((ViewGroup) inflate).addView(view);
                return inflate;
            }
            QLog.e("AIOSenderBubbleTemplate", 1, "leftSwipeArea container err, is not ViewGroup");
        }
        return null;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @Nullable
    public ViewStub k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (ViewStub) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return n.a.e(this);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @Nullable
    public View l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (View) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        q qVar = this.mBinding;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            qVar = null;
        }
        return qVar.f444885l;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void m(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view);
            return;
        }
        if (view != null) {
            q qVar = this.mBinding;
            if (qVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                qVar = null;
            }
            qVar.f444881h.addView(view);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @NotNull
    public ViewStub n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (ViewStub) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        q qVar = this.mBinding;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            qVar = null;
        }
        ViewStub viewStub = qVar.f444875b;
        Intrinsics.checkNotNullExpressionValue(viewStub, "mBinding.avatarEffectLayout");
        return viewStub;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @NotNull
    public ViewStub o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ViewStub) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        q qVar = this.mBinding;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            qVar = null;
        }
        ViewStub viewStub = qVar.f444877d;
        Intrinsics.checkNotNullExpressionValue(viewStub, "mBinding.contentAreaMask");
        return viewStub;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void p(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) view);
            return;
        }
        if (view != null) {
            q qVar = this.mBinding;
            if (qVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                qVar = null;
            }
            qVar.f444884k.addView(view);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void q(boolean isWideScreen) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, isWideScreen);
            return;
        }
        q qVar = this.mBinding;
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            qVar = null;
        }
        Context context = qVar.f444888o.getContext();
        if (isWideScreen) {
            q qVar2 = this.mBinding;
            if (qVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                qVar2 = null;
            }
            ViewGroup.LayoutParams layoutParams = qVar2.f444880g.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.setMarginEnd((int) context.getResources().getDimension(R.dimen.bzu));
                return;
            }
            return;
        }
        q qVar3 = this.mBinding;
        if (qVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            qVar3 = null;
        }
        ViewGroup.LayoutParams layoutParams2 = qVar3.f444880g.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.setMarginEnd((int) context.getResources().getDimension(R.dimen.bzs));
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @NotNull
    public ViewStub r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ViewStub) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        q qVar = this.mBinding;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            qVar = null;
        }
        ViewStub viewStub = qVar.f444882i;
        Intrinsics.checkNotNullExpressionValue(viewStub, "mBinding.msgMultiSelect");
        return viewStub;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void s(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
            return;
        }
        if (view != null) {
            q qVar = this.mBinding;
            if (qVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                qVar = null;
            }
            qVar.f444885l.addView(view);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void t(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) view);
            return;
        }
        if (view != null) {
            q qVar = this.mBinding;
            if (qVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                qVar = null;
            }
            qVar.f444883j.addView(view);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @Nullable
    public View u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (View) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        q qVar = this.mBinding;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            qVar = null;
        }
        return qVar.f444883j;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @NotNull
    public View v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (View) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        q qVar = this.mBinding;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            qVar = null;
        }
        FrameLayout frameLayout = qVar.f444886m;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.msgTopTip");
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @Nullable
    public ViewStub w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (ViewStub) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return n.a.d(this);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void x(@NotNull com.tencent.qqnt.aio.holder.template.d intercepter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) intercepter);
            return;
        }
        Intrinsics.checkNotNullParameter(intercepter, "intercepter");
        q qVar = this.mBinding;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            qVar = null;
        }
        qVar.f444888o.setOnInterceptTouchListener(intercepter);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @Nullable
    public View y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (View) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        q qVar = this.mBinding;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            qVar = null;
        }
        return qVar.f444883j;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void z(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) view);
            return;
        }
        if (view != null) {
            q qVar = this.mBinding;
            if (qVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                qVar = null;
            }
            qVar.f444886m.addView(view);
        }
    }
}
