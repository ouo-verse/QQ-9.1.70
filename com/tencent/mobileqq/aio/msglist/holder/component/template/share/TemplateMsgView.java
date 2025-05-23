package com.tencent.mobileqq.aio.msglist.holder.component.template.share;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.aio.msg.template.a;
import com.tencent.mobileqq.aio.msg.template.d;
import com.tencent.mobileqq.aio.msglist.holder.component.template.common.h;
import com.tencent.mobileqq.aio.msglist.holder.component.template.common.m;
import com.tencent.mobileqq.aio.msglist.holder.component.template.report.b;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J+\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J'\u0010\u0010\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/share/TemplateMsgView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/tencent/mobileqq/aio/msg/template/a;", "Lcom/tencent/mobileqq/aio/msg/template/d;", "templateMsgInfo", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/report/b;", "performanceReporter", "", "targetWidth", "", "B0", "(Lcom/tencent/mobileqq/aio/msg/template/d;Lcom/tencent/mobileqq/aio/msglist/holder/component/template/report/b;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "A0", "Landroid/view/View;", "d", NodeProps.MAX_WIDTH, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "(Lcom/tencent/mobileqq/aio/msg/template/d;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class TemplateMsgView extends ConstraintLayout implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/share/TemplateMsgView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.template.share.TemplateMsgView$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63515);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TemplateMsgView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0(d templateMsgInfo) {
        String str;
        com.tencent.mobileqq.aio.msglist.holder.component.template.a aVar = com.tencent.mobileqq.aio.msglist.holder.component.template.a.f191886a;
        if (aVar.c()) {
            if (templateMsgInfo == null || (str = templateMsgInfo.a()) == null) {
                str = "\u7a7aappName";
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            addView(aVar.d(context, str), new ConstraintLayout.LayoutParams(-2, -2));
        }
    }

    private final Object B0(d dVar, b bVar, int i3, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        m mVar = m.f191935a;
        String e16 = mVar.e(dVar);
        String a16 = dVar.a();
        if (a16 == null) {
            QLog.w("TemplateMsgView", 1, "show but got null appName, return");
            return Unit.INSTANCE;
        }
        String b16 = dVar.b();
        if (b16 == null) {
            QLog.w("TemplateMsgView", 1, "show but got null bizName");
            b16 = "";
        }
        String f16 = dVar.f();
        if (f16 == null) {
            QLog.w("TemplateMsgView", 1, "show but got null viewName, return");
            return Unit.INSTANCE;
        }
        h d16 = mVar.d(a16, b16, f16, e16);
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new TemplateMsgView$show$2(this, d16.a(), i3, bVar, d16, dVar, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (withContext == coroutine_suspended) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.aio.msg.template.a
    @Nullable
    public Object Q(@Nullable d dVar, @Nullable Integer num, @NotNull Continuation<? super Unit> continuation) {
        int i3;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, this, dVar, num, continuation);
        }
        b bVar = new b(dVar);
        if (dVar == null) {
            QLog.e("TemplateMsgView", 1, "show template failed for templateInfo is null");
            bVar.h("preview_ark2md_render_fail", -1, "template_is_null");
            return Unit.INSTANCE;
        }
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = -2;
        }
        QLog.d("TemplateMsgView", 1, "show for " + dVar);
        Object B0 = B0(dVar, bVar, i3, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (B0 == coroutine_suspended) {
            return B0;
        }
        return Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.aio.msg.template.a
    @NotNull
    public View d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TemplateMsgView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ TemplateMsgView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TemplateMsgView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
    }
}
