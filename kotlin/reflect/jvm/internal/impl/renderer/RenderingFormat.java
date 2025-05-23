package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public enum RenderingFormat {
    PLAIN { // from class: kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.PLAIN
        @Override // kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat
        @NotNull
        public String escape(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            return string;
        }
    },
    HTML { // from class: kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.HTML
        @Override // kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat
        @NotNull
        public String escape(@NotNull String string) {
            String replace$default;
            String replace$default2;
            Intrinsics.checkNotNullParameter(string, "string");
            replace$default = StringsKt__StringsJVMKt.replace$default(string, "<", "&lt;", false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, ">", "&gt;", false, 4, (Object) null);
            return replace$default2;
        }
    };

    /* synthetic */ RenderingFormat(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public abstract String escape(@NotNull String str);
}
