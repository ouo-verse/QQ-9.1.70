package pa3;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a8\u0006\r"}, d2 = {"Lpa3/c;", "", "Landroid/content/Context;", "context", "", "tip", "Lkotlin/Function0;", "", "dismiss", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "b", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f425850a = new c();

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function0 dismiss, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(dismiss, "$dismiss");
        dismiss.invoke();
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public final QCircleCommonLoadingDialog b(@NotNull Context context, @Nullable String tip, @NotNull final Function0<Unit> dismiss) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dismiss, "dismiss");
        QCircleCommonLoadingDialog a16 = new QCircleCommonLoadingDialog.c(context).n(false).h(new View.OnClickListener() { // from class: pa3.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.c(Function0.this, view);
            }
        }).p(tip).g(false).a();
        Intrinsics.checkNotNullExpressionValue(a16, "Builder(context)\n       \u2026lse)\n            .build()");
        return a16;
    }
}
