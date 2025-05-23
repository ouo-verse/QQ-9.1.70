package n24;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Ln24/b;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "Luu3/a;", "b", "Luu3/a;", "e", "()Luu3/a;", "impl", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b extends com.tencent.mobileqq.aio.input.inputbar.viewbinding.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final uu3.a impl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        uu3.a g16 = uu3.a.g(LayoutInflater.from(context));
        g16.getRoot().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026P_CONTENT\n        )\n    }");
        this.impl = g16;
    }

    @Override // com.tencent.mobileqq.aio.input.inputbar.viewbinding.a
    @NotNull
    /* renamed from: e, reason: from getter */
    public uu3.a getImpl() {
        return this.impl;
    }
}
