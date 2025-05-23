package com.tencent.qqnt.qwallet.aio;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\n\u001a\u00020\u00058\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/AIOContentView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View;", "getView", "z0", "", "d", "Ljava/lang/String;", "A0", "()Ljava/lang/String;", "TAG", "Lcom/tencent/qqnt/qwallet/aio/c;", "B0", "()Lcom/tencent/qqnt/qwallet/aio/c;", "viewModel", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class AIOContentView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOContentView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "WalletNT-" + getClass().getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: A0, reason: from getter */
    public final String getTAG() {
        return this.TAG;
    }

    @NotNull
    public abstract c B0();

    @NotNull
    public final View getView() {
        return this;
    }

    @Nullable
    public View z0() {
        return this;
    }
}
