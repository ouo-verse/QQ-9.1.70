package gq2;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.setting.utils.o;
import com.tencent.mobileqq.studymode.ab;
import com.tencent.mobileqq.widget.listitem.w;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0014J\u0006\u0010\u0007\u001a\u00020\u0006J \u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0006R$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lgq2/d;", "Lcom/tencent/mobileqq/widget/listitem/w;", "Landroid/view/View;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "H", "", "N", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "K", "O", "M", "P", "Lcom/tencent/mobileqq/studymode/ab;", "k", "Lcom/tencent/mobileqq/studymode/ab;", "getStudySwitchItem", "()Lcom/tencent/mobileqq/studymode/ab;", "setStudySwitchItem", "(Lcom/tencent/mobileqq/studymode/ab;)V", "studySwitchItem", "<init>", "()V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends w<View> {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private ab studySwitchItem;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(d this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ab abVar = this$0.studySwitchItem;
        if (abVar != null) {
            abVar.n();
        }
        o.k(o.f286768a, "0X800BF43", 0, null, null, null, null, 62, null);
    }

    @Override // com.tencent.mobileqq.widget.listitem.w
    protected View H(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        o.k(o.f286768a, "0X800BF42", 0, null, null, null, null, 62, null);
        x(new View.OnClickListener() { // from class: gq2.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.L(d.this, view);
            }
        });
        Context context = parent.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        ab abVar = new ab((QQAppInterface) peekAppRuntime, (QBaseActivity) context);
        abVar.q();
        this.studySwitchItem = abVar;
        Intrinsics.checkNotNull(abVar);
        View d16 = abVar.d();
        d16.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Intrinsics.checkNotNullExpressionValue(d16, "studySwitchItem!!.view.a\u2026s.WRAP_CONTENT)\n        }");
        return d16;
    }

    public final void K(int requestCode, int resultCode, Intent data) {
        ab abVar = this.studySwitchItem;
        if (abVar != null) {
            abVar.c(requestCode, resultCode, data);
        }
    }

    public final void M() {
        ab abVar = this.studySwitchItem;
        if (abVar != null) {
            abVar.onDestroy();
        }
    }

    public final void N() {
        ab abVar = this.studySwitchItem;
        if (abVar != null) {
            abVar.o();
        }
    }

    public final void O() {
        ab abVar = this.studySwitchItem;
        if (abVar != null) {
            abVar.q();
            abVar.b();
            abVar.a();
        }
    }

    public final void P() {
        ab abVar = this.studySwitchItem;
        if (abVar != null) {
            abVar.j();
            abVar.i();
        }
    }
}
