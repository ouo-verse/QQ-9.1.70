package i40;

import android.content.Context;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Li40/c;", "", "Landroid/content/Context;", "context", "", QZoneDTLoginReporter.SCHEMA, "", "b", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f407182a = new c();

    c() {
    }

    public final void a(@NotNull Context context, @NotNull String schema) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schema, "schema");
        QCircleSchemeLauncher.d(context, schema);
    }

    public final void b(@NotNull Context context, @NotNull String schema) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schema, "schema");
        if (!com.tencent.biz.qqcircle.launcher.c.c(context, "0", 22)) {
            return;
        }
        com.tencent.biz.qqcircle.launcher.c.g(context, schema);
    }
}
