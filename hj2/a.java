package hj2;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0003\u001a\u00020\u0001*\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0000j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001`\u0002\u00a8\u0006\u0004"}, d2 = {"Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "a", "qqshop-feature-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    @NotNull
    public static final String a(@NotNull HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<this>");
        String str = hashMap.get("_origin");
        if (str == null) {
            String str2 = hashMap.get("_source");
            if (str2 == null) {
                return "";
            }
            return str2;
        }
        return str;
    }
}
