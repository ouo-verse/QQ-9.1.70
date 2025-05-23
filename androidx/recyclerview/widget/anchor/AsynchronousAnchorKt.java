package androidx.recyclerview.widget.anchor;

import androidx.recyclerview.widget.AIOLinearLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u00a8\u0006\u0005"}, d2 = {"checkValidAnchor", "", "Landroidx/recyclerview/widget/AIOLinearLayoutManager;", "anchor", "Landroidx/recyclerview/widget/anchor/AsynchronousAnchor;", "sdk_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class AsynchronousAnchorKt {
    public static final boolean checkValidAnchor(@NotNull AIOLinearLayoutManager checkValidAnchor, @Nullable AsynchronousAnchor asynchronousAnchor) {
        Intrinsics.checkNotNullParameter(checkValidAnchor, "$this$checkValidAnchor");
        if (asynchronousAnchor == null) {
            return false;
        }
        return checkValidAnchor.checkValidPosition(asynchronousAnchor.getPosition(), asynchronousAnchor.getOffset(), asynchronousAnchor.getBaseBottom());
    }
}
