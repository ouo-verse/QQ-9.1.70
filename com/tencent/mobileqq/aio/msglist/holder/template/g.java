package com.tencent.mobileqq.aio.msglist.holder.template;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.AIOCoreLayoutParam;
import androidx.recyclerview.widget.AIORecycleView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b1\u00102J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0019\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u001a\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u001c\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u001e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\u0010H\u0016J\b\u0010\"\u001a\u00020\u0010H\u0016J\b\u0010#\u001a\u00020\bH\u0016J\u0012\u0010$\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010%\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010&\u001a\u00020\u0010H\u0016J\u0010\u0010(\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0006H\u0016R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010*R\u0016\u0010-\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010,R\u0016\u0010.\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010,R\u0016\u0010/\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010,R\u0016\u00100\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010,\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/template/g;", "Lcom/tencent/mobileqq/aio/msglist/holder/template/n;", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "isSelf", "Landroid/view/View;", "d", "view", "", "f", "a", "g", "b", "Landroid/view/ViewStub;", "o", "c", "e", "r", "Lcom/tencent/qqnt/aio/holder/template/d;", "intercepter", HippyTKDListViewAdapter.X, "l", ReportConstant.COSTREPORT_PREFIX, "t", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "v", "j", tl.h.F, DomainData.DOMAIN_NAME, "i", "p", "k", "w", "isWideScreen", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lw71/g;", "Lw71/g;", "mBinding", "Z", "mSelectInflated", "mLeftSwipeInflated", "mAtmosphereLayoutInflated", "mAvatarEffectLayoutInflated", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class g implements n {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private w71.g mBinding;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean mSelectInflated;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean mLeftSwipeInflated;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mAtmosphereLayoutInflated;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mAvatarEffectLayoutInflated;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/template/g$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.template.g$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64052);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(g this$0, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mSelectInflated = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(g this$0, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mLeftSwipeInflated = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(g this$0, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mAtmosphereLayoutInflated = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(g this$0, ViewStub viewStub, View view) {
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
        w71.g gVar = this.mBinding;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            gVar = null;
        }
        FrameLayout frameLayout = gVar.f444797g;
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
        w71.g gVar = this.mBinding;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            gVar = null;
        }
        return gVar.f444793c;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void c(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
            return;
        }
        if (view != null) {
            w71.g gVar = this.mBinding;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                gVar = null;
            }
            gVar.f444806p.addView(view);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @NotNull
    public View d(@NotNull Context context, @NotNull ViewGroup parent, boolean isSelf) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, context, parent, Boolean.valueOf(isSelf));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        w71.g gVar = null;
        try {
            w71.g g16 = w71.g.g(LayoutInflater.from(context), parent, false);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, parent, false)");
            this.mBinding = g16;
            if (parent instanceof AIORecycleView) {
                if (g16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    g16 = null;
                }
                TemplateLayout root = g16.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "mBinding.getRoot()");
                root.setLayoutParams(new AIOCoreLayoutParam(root.getLayoutParams()));
            }
        } catch (Exception e16) {
            QLog.e("AIOReceiverBubbleTemplate", 1, "getTemplateView", e16);
            w71.g e17 = w71.g.e(LayoutInflater.from(context).inflate(R.layout.dvl, parent, false));
            Intrinsics.checkNotNullExpressionValue(e17, "bind(view)");
            this.mBinding = e17;
        }
        w71.g gVar2 = this.mBinding;
        if (gVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            gVar2 = null;
        }
        gVar2.f444799i.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.template.c
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view) {
                g.E(g.this, viewStub, view);
            }
        });
        w71.g gVar3 = this.mBinding;
        if (gVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            gVar3 = null;
        }
        gVar3.f444795e.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.template.d
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view) {
                g.F(g.this, viewStub, view);
            }
        });
        w71.g gVar4 = this.mBinding;
        if (gVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            gVar4 = null;
        }
        gVar4.f444796f.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.template.e
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view) {
                g.G(g.this, viewStub, view);
            }
        });
        w71.g gVar5 = this.mBinding;
        if (gVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            gVar5 = null;
        }
        gVar5.f444792b.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.template.f
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view) {
                g.H(g.this, viewStub, view);
            }
        });
        if (AIOUtil.f194084a.C()) {
            w71.g gVar6 = this.mBinding;
            if (gVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                gVar6 = null;
            }
            ViewGroup.LayoutParams layoutParams = gVar6.f444797g.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.setMarginStart((int) context.getResources().getDimension(R.dimen.bzs));
            }
        }
        w71.g gVar7 = this.mBinding;
        if (gVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            gVar7 = null;
        }
        gVar7.f444797g.setImportantForAccessibility(2);
        w71.g gVar8 = this.mBinding;
        if (gVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            gVar8 = null;
        }
        gVar8.f444793c.setImportantForAccessibility(2);
        w71.g gVar9 = this.mBinding;
        if (gVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            gVar = gVar9;
        }
        TemplateLayout templateLayout = gVar.f444807q;
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
        w71.g gVar = this.mBinding;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            gVar = null;
        }
        return gVar.f444806p;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void f(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            return;
        }
        w71.g gVar = this.mBinding;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            gVar = null;
        }
        gVar.f444797g.addView(view);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void g(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
            return;
        }
        w71.g gVar = this.mBinding;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            gVar = null;
        }
        gVar.f444793c.addView(view);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @NotNull
    public ViewStub h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (ViewStub) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        w71.g gVar = this.mBinding;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            gVar = null;
        }
        ViewStub viewStub = gVar.f444796f;
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
        w71.g gVar = this.mBinding;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            gVar = null;
        }
        FrameLayout frameLayout = gVar.f444803m;
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
            w71.g gVar = this.mBinding;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                gVar = null;
            }
            View inflate = gVar.f444795e.inflate();
            if (inflate instanceof ViewGroup) {
                ((ViewGroup) inflate).addView(view);
                return inflate;
            }
            QLog.e("AIOReceiverBubbleTemplate", 1, "leftSwipeArea container err, is not ViewGroup");
        }
        return null;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @Nullable
    public ViewStub k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (ViewStub) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        w71.g gVar = this.mBinding;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            gVar = null;
        }
        return gVar.f444801k;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @Nullable
    public View l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (View) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        w71.g gVar = this.mBinding;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            gVar = null;
        }
        return gVar.f444804n;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void m(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view);
            return;
        }
        if (view != null) {
            w71.g gVar = this.mBinding;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                gVar = null;
            }
            gVar.f444798h.addView(view);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @NotNull
    public ViewStub n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (ViewStub) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        w71.g gVar = this.mBinding;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            gVar = null;
        }
        ViewStub viewStub = gVar.f444792b;
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
        w71.g gVar = this.mBinding;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            gVar = null;
        }
        ViewStub viewStub = gVar.f444794d;
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
            w71.g gVar = this.mBinding;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                gVar = null;
            }
            gVar.f444803m.addView(view);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void q(boolean isWideScreen) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, isWideScreen);
            return;
        }
        w71.g gVar = this.mBinding;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = null;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            gVar = null;
        }
        Context context = gVar.f444807q.getContext();
        if (isWideScreen) {
            w71.g gVar2 = this.mBinding;
            if (gVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                gVar2 = null;
            }
            ViewGroup.LayoutParams layoutParams = gVar2.f444797g.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.setMarginStart((int) context.getResources().getDimension(R.dimen.bzu));
            }
            w71.g gVar3 = this.mBinding;
            if (gVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                gVar3 = null;
            }
            ViewGroup.LayoutParams layoutParams2 = gVar3.f444793c.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            }
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.setMarginEnd((int) context.getResources().getDimension(R.dimen.bzv));
                return;
            }
            return;
        }
        w71.g gVar4 = this.mBinding;
        if (gVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            gVar4 = null;
        }
        ViewGroup.LayoutParams layoutParams3 = gVar4.f444797g.getLayoutParams();
        if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams3;
        }
        if (marginLayoutParams2 != null) {
            marginLayoutParams2.setMarginStart((int) context.getResources().getDimension(R.dimen.bzs));
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @NotNull
    public ViewStub r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ViewStub) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        w71.g gVar = this.mBinding;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            gVar = null;
        }
        ViewStub viewStub = gVar.f444799i;
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
            w71.g gVar = this.mBinding;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                gVar = null;
            }
            gVar.f444804n.addView(view);
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
            w71.g gVar = this.mBinding;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                gVar = null;
            }
            gVar.f444802l.addView(view);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @Nullable
    public View u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (View) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        w71.g gVar = this.mBinding;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            gVar = null;
        }
        return gVar.f444802l;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @NotNull
    public View v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (View) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        w71.g gVar = this.mBinding;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            gVar = null;
        }
        FrameLayout frameLayout = gVar.f444805o;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.msgTopTip");
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @NotNull
    public ViewStub w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (ViewStub) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        w71.g gVar = this.mBinding;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            gVar = null;
        }
        ViewStub viewStub = gVar.f444800j;
        Intrinsics.checkNotNullExpressionValue(viewStub, "mBinding.msgRecommendLayout");
        return viewStub;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void x(@NotNull com.tencent.qqnt.aio.holder.template.d intercepter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) intercepter);
            return;
        }
        Intrinsics.checkNotNullParameter(intercepter, "intercepter");
        w71.g gVar = this.mBinding;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            gVar = null;
        }
        gVar.f444807q.setOnInterceptTouchListener(intercepter);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    @Nullable
    public View y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (View) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        w71.g gVar = this.mBinding;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            gVar = null;
        }
        return gVar.f444802l;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.template.n
    public void z(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) view);
            return;
        }
        if (view != null) {
            w71.g gVar = this.mBinding;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                gVar = null;
            }
            gVar.f444805o.addView(view);
        }
    }
}
