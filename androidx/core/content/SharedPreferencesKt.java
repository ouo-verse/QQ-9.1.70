package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\u0002\b\bH\u0087\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\t"}, d2 = {"edit", "", "Landroid/content/SharedPreferences;", "commit", "", "action", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "Lkotlin/ExtensionFunctionType;", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class SharedPreferencesKt {
    @SuppressLint({"ApplySharedPref"})
    public static final void edit(@NotNull SharedPreferences edit, boolean z16, @NotNull Function1<? super SharedPreferences.Editor, Unit> action) {
        Intrinsics.checkNotNullParameter(edit, "$this$edit");
        Intrinsics.checkNotNullParameter(action, "action");
        SharedPreferences.Editor editor = edit.edit();
        Intrinsics.checkNotNullExpressionValue(editor, "editor");
        action.invoke(editor);
        if (z16) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static /* synthetic */ void edit$default(SharedPreferences edit, boolean z16, Function1 action, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        Intrinsics.checkNotNullParameter(edit, "$this$edit");
        Intrinsics.checkNotNullParameter(action, "action");
        SharedPreferences.Editor editor = edit.edit();
        Intrinsics.checkNotNullExpressionValue(editor, "editor");
        action.invoke(editor);
        if (z16) {
            editor.commit();
        } else {
            editor.apply();
        }
    }
}
