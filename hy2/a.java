package hy2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import uq3.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lhy2/a;", "", "", "skipHeadTail", "b", "()Z", "d", "(Z)V", "", "definition", "a", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f406605a = new a();

    a() {
    }

    @NotNull
    public final String a() {
        String h16 = k.a().h("TVideoSettingManager_Definition", "shd");
        Intrinsics.checkNotNullExpressionValue(h16, "g().getString(DEFINITION_KEY, DEFAULT_DEFINITION)");
        return h16;
    }

    public final boolean b() {
        return k.a().c("TVideoSettingManager_SkipHeadTail", true);
    }

    public final void c(@NotNull String definition) {
        Intrinsics.checkNotNullParameter(definition, "definition");
        k.a().p("TVideoSettingManager_Definition", definition);
    }

    public final void d(boolean z16) {
        k.a().j("TVideoSettingManager_SkipHeadTail", z16);
    }
}
