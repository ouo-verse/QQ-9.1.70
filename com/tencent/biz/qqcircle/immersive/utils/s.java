package com.tencent.biz.qqcircle.immersive.utils;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/utils/s;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "anchor", "Lmc0/a;", "a", "", "hasShow", "", "c", "b", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final s f90240a = new s();

    s() {
    }

    @NotNull
    public final mc0.a a(@NotNull Context context, @NotNull View anchor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        mc0.a c16 = mc0.a.c(context, R.string.f1914644v);
        c16.setAnchor(anchor);
        c16.setPosition(1);
        c16.setAlignment(1);
        c16.setFocusable(false);
        Intrinsics.checkNotNullExpressionValue(c16, "from(context, R.string.q\u2026ocusable(false)\n        }");
        return c16;
    }

    public final boolean b() {
        return uq3.k.a().c("sp_key_has_show_live_tab_tip", false);
    }

    public final void c(boolean hasShow) {
        uq3.k.a().j("sp_key_has_show_live_tab_tip", hasShow);
    }
}
