package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lkotlin/collections/CollectionSystemProperties;", "", "()V", "brittleContainsOptimizationEnabled", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class CollectionSystemProperties {

    @NotNull
    public static final CollectionSystemProperties INSTANCE = new CollectionSystemProperties();

    @JvmField
    public static final boolean brittleContainsOptimizationEnabled;

    static {
        boolean z16;
        String property = System.getProperty("kotlin.collections.convert_arg_to_set_in_removeAll");
        if (property != null) {
            z16 = Boolean.parseBoolean(property);
        } else {
            z16 = false;
        }
        brittleContainsOptimizationEnabled = z16;
    }

    CollectionSystemProperties() {
    }
}
