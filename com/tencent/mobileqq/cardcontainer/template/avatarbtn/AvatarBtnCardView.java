package com.tencent.mobileqq.cardcontainer.template.avatarbtn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.cardcontainer.e;
import com.tencent.mobileqq.cardcontainer.view.BaseCardView;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/template/avatarbtn/AvatarBtnCardView;", "Lcom/tencent/mobileqq/cardcontainer/view/BaseCardView;", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "data", "Landroid/view/View;", "f", "", "i", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", h.F, "a", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AvatarBtnCardView extends BaseCardView {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/template/avatarbtn/AvatarBtnCardView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.template.avatarbtn.AvatarBtnCardView$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40911);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarBtnCardView(@NotNull Context context) {
        super(context, 0.0f, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(a bizModel, AvatarBtnCardView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(bizModel, "$bizModel");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("CardContainer.AvatarBtnCardView", 1, "click AvatarBtnCardView:" + bizModel.a());
        com.tencent.mobileqq.cardcontainer.e g16 = this$0.g();
        if (g16 != null) {
            e.a.b(g16, null, 1, null);
        }
        this$0.h(bizModel.a());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(a bizModel, AvatarBtnCardView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(bizModel, "$bizModel");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("CardContainer.AvatarBtnCardView", 1, "click AvatarBtnCardView:" + bizModel.c());
        com.tencent.mobileqq.cardcontainer.e g16 = this$0.g();
        if (g16 != null) {
            e.a.a(g16, 2, null, 2, null);
        }
        this$0.h(bizModel.c());
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.cardcontainer.view.BaseCardView
    @NotNull
    public View f(@NotNull com.tencent.mobileqq.cardcontainer.data.a data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
        }
        Intrinsics.checkNotNullParameter(data, "data");
        boolean z16 = false;
        ca1.a g16 = ca1.a.g(LayoutInflater.from(getContext()), null, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), null, false)");
        if (data instanceof b) {
            final a t16 = ((b) data).t();
            if (t16 != null) {
                g16.f30486e.setText(t16.g());
                TextView textView = g16.f30485d;
                String f16 = t16.f();
                if (f16 == null) {
                    f16 = "";
                }
                textView.setText(f16);
                QQProAvatarView createContent$lambda$5$lambda$0 = g16.f30484c;
                Intrinsics.checkNotNullExpressionValue(createContent$lambda$5$lambda$0, "createContent$lambda$5$lambda$0");
                QQProAvatarView.setEnableFrame$default(createContent$lambda$5$lambda$0, 0, 0, 3, null);
                String h16 = t16.h();
                if (h16 == null || h16.length() == 0) {
                    z16 = true;
                }
                if (!z16) {
                    createContent$lambda$5$lambda$0.x(1, t16.h(), null);
                } else {
                    createContent$lambda$5$lambda$0.B(t16.d());
                }
                Button button = g16.f30483b;
                button.setText(t16.b());
                button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.cardcontainer.template.avatarbtn.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AvatarBtnCardView.m(a.this, this, view);
                    }
                });
                if (t16.c() != null) {
                    g16.getMRv().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.cardcontainer.template.avatarbtn.e
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            AvatarBtnCardView.n(a.this, this, view);
                        }
                    });
                }
            }
            ConstraintLayout mRv = g16.getMRv();
            Intrinsics.checkNotNullExpressionValue(mRv, "rootBinding.root");
            return mRv;
        }
        QLog.e("CardContainer.AvatarBtnCardView", 1, "createContent error: data is not AvatarBtnCardData");
        ConstraintLayout mRv2 = g16.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv2, "rootBinding.root");
        return mRv2;
    }

    @Override // com.tencent.mobileqq.cardcontainer.view.BaseCardView
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.d("CardContainer.AvatarBtnCardView", 1, "click close");
        com.tencent.mobileqq.cardcontainer.e g16 = g();
        if (g16 != null) {
            g16.F8();
        }
        com.tencent.mobileqq.cardcontainer.e g17 = g();
        if (g17 != null) {
            e.a.c(g17, null, 1, null);
        }
    }
}
