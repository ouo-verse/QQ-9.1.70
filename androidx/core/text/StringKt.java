package androidx.core.text;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0086\b\u00a8\u0006\u0002"}, d2 = {"htmlEncode", "", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class StringKt {
    @NotNull
    public static final String htmlEncode(@NotNull String htmlEncode) {
        Intrinsics.checkNotNullParameter(htmlEncode, "$this$htmlEncode");
        String htmlEncode2 = TextUtils.htmlEncode(htmlEncode);
        Intrinsics.checkNotNullExpressionValue(htmlEncode2, "TextUtils.htmlEncode(this)");
        return htmlEncode2;
    }
}
