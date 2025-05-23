package com.tencent.mobileqq.onlinestatus.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bR\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/utils/OnlineStatusDialogHelper;", "", "Landroid/content/Context;", "context", "Lmqq/app/AppRuntime$Status;", "status", "", "extStatus", "Landroid/content/DialogInterface$OnClickListener;", "onClickListener", "", "b", "Lmqq/util/WeakReference;", "Landroid/app/Dialog;", "a", "Lmqq/util/WeakReference;", "mCurrentDialog", "", "Lcom/tencent/mobileqq/onlinestatus/utils/d;", "Lkotlin/Lazy;", "()Ljava/util/List;", "mDialogProviderList", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class OnlineStatusDialogHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Dialog> mCurrentDialog;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mDialogProviderList;

    public OnlineStatusDialogHelper() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends d>>() { // from class: com.tencent.mobileqq.onlinestatus.utils.OnlineStatusDialogHelper$mDialogProviderList$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends d> invoke() {
                List<? extends d> listOf;
                listOf = CollectionsKt__CollectionsJVMKt.listOf(new d());
                return listOf;
            }
        });
        this.mDialogProviderList = lazy;
    }

    private final List<d> a() {
        return (List) this.mDialogProviderList.getValue();
    }

    public final boolean b(@NotNull Context context, @NotNull AppRuntime.Status status, long extStatus, @Nullable DialogInterface.OnClickListener onClickListener) {
        Dialog dialog;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(status, "status");
        WeakReference<Dialog> weakReference = this.mCurrentDialog;
        Dialog dialog2 = null;
        if (weakReference != null) {
            dialog = weakReference.get();
        } else {
            dialog = null;
        }
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        this.mCurrentDialog = null;
        Iterator<d> it = a().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d next = it.next();
            if (next.a(status, extStatus)) {
                dialog2 = next.b(context, status, extStatus, onClickListener);
                break;
            }
        }
        if (dialog2 != null) {
            this.mCurrentDialog = new WeakReference<>(dialog2);
        }
        if (dialog2 != null) {
            dialog2.setCancelable(false);
        }
        if (dialog2 != null) {
            dialog2.show();
        }
        if (dialog2 == null) {
            return false;
        }
        return true;
    }
}
