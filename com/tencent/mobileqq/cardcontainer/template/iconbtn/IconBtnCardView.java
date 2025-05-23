package com.tencent.mobileqq.cardcontainer.template.iconbtn;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.cardcontainer.e;
import com.tencent.mobileqq.cardcontainer.view.BaseCardView;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0017B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0017J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/template/iconbtn/IconBtnCardView;", "Lcom/tencent/mobileqq/cardcontainer/view/BaseCardView;", "Lcom/tencent/theme/SkinnableView;", "", "p", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "data", "Landroid/view/View;", "f", "i", "onThemeChanged", "Lcom/tencent/mobileqq/cardcontainer/template/iconbtn/a;", h.F, "Lcom/tencent/mobileqq/cardcontainer/template/iconbtn/a;", "bizModel", "Lca1/c;", "Lca1/c;", "rootBinding", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class IconBtnCardView extends BaseCardView implements SkinnableView {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a bizModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ca1.c rootBinding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/template/iconbtn/IconBtnCardView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.template.iconbtn.IconBtnCardView$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41381);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IconBtnCardView(@NotNull Context context) {
        super(context, 0.0f, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(a bizModel, IconBtnCardView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(bizModel, "$bizModel");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("CardContainer.IconBtnCardView", 1, "click IconBtnCardView:" + bizModel.c());
        com.tencent.mobileqq.cardcontainer.e g16 = this$0.g();
        if (g16 != null) {
            e.a.b(g16, null, 1, null);
        }
        this$0.h(bizModel.c());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(a bizModel, IconBtnCardView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(bizModel, "$bizModel");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("CardContainer.IconBtnCardView", 1, "click IconBtnCardView:" + bizModel.e());
        com.tencent.mobileqq.cardcontainer.e g16 = this$0.g();
        if (g16 != null) {
            e.a.a(g16, 2, null, 2, null);
        }
        this$0.h(bizModel.e());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void p() {
        String str;
        String b16;
        RFWRoundImageView rFWRoundImageView;
        if (je0.a.a(getContext())) {
            a aVar = this.bizModel;
            if (aVar != null) {
                str = aVar.f();
            } else {
                str = null;
            }
            a aVar2 = this.bizModel;
            if (aVar2 != null) {
                b16 = aVar2.a();
            }
            b16 = null;
        } else {
            a aVar3 = this.bizModel;
            if (aVar3 != null) {
                str = aVar3.g();
            } else {
                str = null;
            }
            a aVar4 = this.bizModel;
            if (aVar4 != null) {
                b16 = aVar4.b();
            }
            b16 = null;
        }
        if (str != null) {
            Option obtain = Option.obtain();
            ca1.c cVar = this.rootBinding;
            if (cVar != null) {
                rFWRoundImageView = cVar.f30499c;
            } else {
                rFWRoundImageView = null;
            }
            Option option = obtain.setTargetView(rFWRoundImageView).setUrl(str).setLoadingDrawable(new ColorDrawable(0)).setFailDrawable(new ColorDrawable(0));
            QQPicLoader qQPicLoader = QQPicLoader.f201806a;
            Intrinsics.checkNotNullExpressionValue(option, "option");
            qQPicLoader.e(option, null);
        }
        if (b16 != null) {
            Drawable drawable = getContext().getDrawable(R.drawable.jb9);
            Option option2 = Option.obtain().setUrl(b16).setLoadingDrawable(drawable).setFailDrawable(drawable);
            QQPicLoader qQPicLoader2 = QQPicLoader.f201806a;
            Intrinsics.checkNotNullExpressionValue(option2, "option");
            qQPicLoader2.e(option2, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.cardcontainer.template.iconbtn.d
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option3) {
                    IconBtnCardView.q(IconBtnCardView.this, loadState, option3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(IconBtnCardView this$0, LoadState loadState, Option option) {
        ConstraintLayout constraintLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (loadState == LoadState.STATE_SUCCESS) {
            ca1.c cVar = this$0.rootBinding;
            if (cVar != null) {
                constraintLayout = cVar.getRoot();
            } else {
                constraintLayout = null;
            }
            if (constraintLayout != null) {
                constraintLayout.setBackground(new BitmapDrawable(this$0.getContext().getResources(), option.getResultBitMap()));
            }
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.view.BaseCardView
    @SuppressLint({"UseCompatLoadingForDrawables"})
    @NotNull
    public View f(@NotNull com.tencent.mobileqq.cardcontainer.data.a data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
        }
        Intrinsics.checkNotNullParameter(data, "data");
        ca1.c g16 = ca1.c.g(LayoutInflater.from(getContext()), null, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), null, false)");
        this.rootBinding = g16;
        if (data instanceof b) {
            final a t16 = ((b) data).t();
            if (t16 != null) {
                this.bizModel = t16;
                g16.f30501e.setText(t16.j());
                TextView textView = g16.f30500d;
                String i3 = t16.i();
                if (i3 == null) {
                    i3 = "";
                }
                textView.setText(i3);
                Button button = g16.f30498b;
                button.setText(t16.d());
                button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.cardcontainer.template.iconbtn.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        IconBtnCardView.n(a.this, this, view);
                    }
                });
                if (t16.e() != null) {
                    g16.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.cardcontainer.template.iconbtn.f
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            IconBtnCardView.o(a.this, this, view);
                        }
                    });
                }
                p();
            }
            ConstraintLayout root = g16.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "rootBinding.root");
            return root;
        }
        QLog.e("CardContainer.IconBtnCardView", 1, "createContent error: data is not AvatarBtnCardData");
        ConstraintLayout root2 = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "rootBinding.root");
        return root2;
    }

    @Override // com.tencent.mobileqq.cardcontainer.view.BaseCardView
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.d("CardContainer.IconBtnCardView", 1, "click close");
        com.tencent.mobileqq.cardcontainer.e g16 = g();
        if (g16 != null) {
            g16.F8();
        }
        com.tencent.mobileqq.cardcontainer.e g17 = g();
        if (g17 != null) {
            e.a.c(g17, null, 1, null);
        }
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            p();
        }
    }
}
