package com.tencent.mobileqq.vas.pay.api.impl.view;

import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/api/impl/view/j;", "", "Landroid/view/View;", "a", "Landroid/view/View;", "b", "()Landroid/view/View;", "keyView", "Landroid/widget/Button;", "Landroid/widget/Button;", "()Landroid/widget/Button;", "btn", "<init>", "(Landroid/view/View;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View keyView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Button btn;

    public j(@NotNull View keyView) {
        Intrinsics.checkNotNullParameter(keyView, "keyView");
        this.keyView = keyView;
        View findViewById = keyView.findViewById(R.id.aek);
        Intrinsics.checkNotNullExpressionValue(findViewById, "keyView.findViewById(R.id.btn)");
        this.btn = (Button) findViewById;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final Button getBtn() {
        return this.btn;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final View getKeyView() {
        return this.keyView;
    }
}
