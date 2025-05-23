package b12;

import android.view.View;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u0014\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001*\u00020\u0000H\u0002\u00a8\u0006\u0005"}, d2 = {"Landroid/view/View;", "", "b", "kotlin.jvm.PlatformType", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {
    private static final String a(View view) {
        Object m476constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(view.getResources().getResourceEntryName(view.getId()));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = "\u672a\u8bbe\u7f6e";
        }
        return (String) m476constructorimpl;
    }

    @NotNull
    public static final String b(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getClass().getSimpleName() + "(id=" + a(view) + ")";
    }
}
