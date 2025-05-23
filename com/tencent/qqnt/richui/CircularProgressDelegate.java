package com.tencent.qqnt.richui;

import android.content.Context;
import android.view.View;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/richui/CircularProgressDelegate;", "Lcom/tencent/android/androidbypass/richui/view/d;", "Landroid/view/View;", "getView", "", "progress", "", HippyQQPagView.FunctionName.SET_PROGRESS, "", "state", "a", "Landroid/content/Context;", "b", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/circularprogress/a;", "c", "Lkotlin/Lazy;", "k", "()Lcom/tencent/qqnt/circularprogress/a;", "circularProgress", "<init>", "(Landroid/content/Context;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class CircularProgressDelegate implements com.tencent.android.androidbypass.richui.view.d {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy circularProgress;

    public CircularProgressDelegate(Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.qqnt.circularprogress.a>() { // from class: com.tencent.qqnt.richui.CircularProgressDelegate$circularProgress$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.qqnt.circularprogress.a invoke() {
                Context context2;
                context2 = CircularProgressDelegate.this.context;
                return new com.tencent.qqnt.circularprogress.a(context2);
            }
        });
        this.circularProgress = lazy;
    }

    private final com.tencent.qqnt.circularprogress.a k() {
        return (com.tencent.qqnt.circularprogress.a) this.circularProgress.getValue();
    }

    @Override // com.tencent.android.androidbypass.richui.view.d
    public void a(String state) {
        Intrinsics.checkNotNullParameter(state, "state");
        k().a(state);
    }

    @Override // com.tencent.android.androidbypass.richui.view.h
    public View getView() {
        return k().getView();
    }

    @Override // com.tencent.android.androidbypass.richui.view.d
    public void setProgress(double progress) {
        k().setProgress(progress);
    }
}
