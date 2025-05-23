package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0013R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0018R*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u0017\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/i;", "", "", "j", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "view", "b", "c", "f", tl.h.F, "d", "g", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "stateViewContainer", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "emptyView", "netErrorView", "Landroid/app/Dialog;", "e", "Landroid/app/Dialog;", "retryDialog", "loadingDialog", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getOnRetryCallback", "()Lkotlin/jvm/functions/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "onRetryCallback", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup stateViewContainer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIEmptyState emptyView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIEmptyState netErrorView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog retryDialog;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> onRetryCallback;

    public i(@NotNull Context context, @NotNull ViewGroup stateViewContainer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(stateViewContainer, "stateViewContainer");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) stateViewContainer);
        } else {
            this.context = context;
            this.stateViewContainer = stateViewContainer;
        }
    }

    private final void b(QUIEmptyState view) {
        if (this.stateViewContainer.getChildCount() == 0 || !Intrinsics.areEqual(this.stateViewContainer.getChildAt(0), view)) {
            this.stateViewContainer.removeAllViews();
            this.stateViewContainer.addView(view);
        }
        this.stateViewContainer.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(i this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j();
        Function0<Unit> function0 = this$0.onRetryCallback;
        if (function0 != null) {
            function0.invoke();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void j() {
        if (this.retryDialog == null) {
            this.retryDialog = LoadingUtil.showLoadingDialog(this.context, HardCodeUtil.qqStr(R.string.j2_), true);
        }
        Dialog dialog = this.retryDialog;
        if (dialog != null) {
            dialog.show();
        }
    }

    public final void c() {
        boolean z16;
        Dialog dialog;
        Dialog dialog2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Dialog dialog3 = this.retryDialog;
        boolean z17 = true;
        if (dialog3 != null && dialog3.isShowing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (dialog2 = this.retryDialog) != null) {
            dialog2.dismiss();
        }
        Dialog dialog4 = this.loadingDialog;
        if (dialog4 == null || !dialog4.isShowing()) {
            z17 = false;
        }
        if (z17 && (dialog = this.loadingDialog) != null) {
            dialog.dismiss();
        }
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.stateViewContainer.setVisibility(8);
        }
    }

    public final void e(@Nullable Function0<Unit> function0) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) function0);
        } else {
            this.onRetryCallback = function0;
        }
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QUIEmptyState qUIEmptyState = this.emptyView;
        if (qUIEmptyState == null) {
            String qqStr = HardCodeUtil.qqStr(R.string.cxb);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.poi_list_no_data)");
            qUIEmptyState = l.a(this.context, new k(qqStr, null, 16, null, 10, null));
        }
        this.emptyView = qUIEmptyState;
        b(qUIEmptyState);
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.loadingDialog == null) {
            Dialog showOnlyLoadingImageDialog = LoadingUtil.showOnlyLoadingImageDialog(this.context, 1, true);
            this.loadingDialog = showOnlyLoadingImageDialog;
            if (showOnlyLoadingImageDialog != null) {
                showOnlyLoadingImageDialog.setCancelable(false);
            }
        }
        Dialog dialog = this.loadingDialog;
        if (dialog != null) {
            dialog.show();
        }
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QUIEmptyState qUIEmptyState = this.netErrorView;
        if (qUIEmptyState == null) {
            String qqStr = HardCodeUtil.qqStr(R.string.yla);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.addcontacts_loading_data_error)");
            String qqStr2 = HardCodeUtil.qqStr(R.string.yle);
            Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.addcontacts_retry_click)");
            String qqStr3 = HardCodeUtil.qqStr(R.string.yld);
            Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.addcontacts_refresh)");
            qUIEmptyState = l.a(this.context, new k(qqStr, qqStr2, 5, new j(qqStr3, new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i.i(i.this, view);
                }
            })));
        }
        this.netErrorView = qUIEmptyState;
        b(qUIEmptyState);
    }
}
