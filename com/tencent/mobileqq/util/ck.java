package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.login.LoginReportConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.bm;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J:\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/util/ck;", "", "Landroid/content/Context;", "context", "", "", "dialogParams", "Lcom/tencent/mobileqq/widget/bm$c;", "onAccountClickListener", "Landroid/content/DialogInterface$OnDismissListener;", "onDismissListener", "Lcom/tencent/mobileqq/widget/bm;", "c", "tReport", "reverse", "", "f", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ck {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ck f306664a = new ck();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/util/ck$a", "Lcom/tencent/mobileqq/widget/bm$c;", "", "account", "", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements bm.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ bm.c f306665a;

        a(bm.c cVar) {
            this.f306665a = cVar;
        }

        @Override // com.tencent.mobileqq.widget.bm.c
        public void a(@NotNull Object account) {
            Intrinsics.checkNotNullParameter(account, "account");
            bm.c cVar = this.f306665a;
            if (cVar != null) {
                cVar.a(account);
                ck.f306664a.f("0X800C241", "");
            }
        }
    }

    ck() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(DialogInterface.OnDismissListener onDismissListener, com.tencent.mobileqq.widget.bm dialog, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialog);
        }
        f306664a.f("0X800C234", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String reverse, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(reverse, "$reverse");
        f306664a.f("0X800C233", reverse);
    }

    @Nullable
    public final com.tencent.mobileqq.widget.bm c(@Nullable Context context, @NotNull Map<String, Object> dialogParams, @Nullable bm.c onAccountClickListener, @Nullable final DialogInterface.OnDismissListener onDismissListener) {
        Intrinsics.checkNotNullParameter(dialogParams, "dialogParams");
        if (context == null) {
            QLog.e("SelectAccountHelper", 1, "createSelectAccountDialog param invalid");
            return null;
        }
        final com.tencent.mobileqq.widget.bm bmVar = new com.tencent.mobileqq.widget.bm(context, dialogParams, new a(onAccountClickListener));
        bmVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.util.ci
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ck.d(onDismissListener, bmVar, dialogInterface);
            }
        });
        Object obj = dialogParams.get("key_unbind_account_list");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.mobileqq.bean.AccountInfo>");
        final String valueOf = String.valueOf(Collections.unmodifiableList((List) obj).size());
        bmVar.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.mobileqq.util.cj
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                ck.e(valueOf, dialogInterface);
            }
        });
        return bmVar;
    }

    public final void f(@Nullable String tReport, @Nullable String reverse) {
        ReportController.r(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", tReport, tReport, LoginReportConstants.f241792b, 0, LoginReportConstants.f241793c, reverse, "", "");
    }
}
