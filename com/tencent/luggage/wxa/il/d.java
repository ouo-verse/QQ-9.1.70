package com.tencent.luggage.wxa.il;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import com.tencent.luggage.wxa.wj.c;
import com.tencent.mm.ui.statusbar.DrawStatusBarFrameLayout;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d extends DrawStatusBarFrameLayout {
    public com.tencent.luggage.wxa.wj.c F;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mm.ui.statusbar.DrawStatusBarFrameLayout
    public boolean c(boolean z16) {
        c.C6887c c6887c;
        com.tencent.luggage.wxa.wj.c cVar = this.F;
        if (cVar != null) {
            c6887c = cVar.getStatusBar();
        } else {
            c6887c = null;
        }
        if (c6887c == null) {
            return super.c(z16);
        }
        return c6887c.a(getContext(), z16);
    }

    @Nullable
    public final com.tencent.luggage.wxa.wj.c getWindowAndroid() {
        return this.F;
    }

    @Override // com.tencent.mm.ui.statusbar.DrawStatusBarFrameLayout
    public void j() {
        c.C6887c c6887c;
        com.tencent.luggage.wxa.wj.c cVar = this.F;
        if (cVar != null) {
            c6887c = cVar.getStatusBar();
        } else {
            c6887c = null;
        }
        if (c6887c == null) {
            super.j();
        } else {
            c6887c.b(getContext());
        }
    }

    @Override // com.tencent.mm.ui.statusbar.DrawStatusBarFrameLayout
    public void l() {
        super.l();
        setWindowAndroid(this.F);
    }

    public final void setWindowAndroid(@Nullable com.tencent.luggage.wxa.wj.c cVar) {
        c.C6887c statusBar;
        this.F = cVar;
        if (!(getContext() instanceof Activity) && cVar != null && (statusBar = cVar.getStatusBar()) != null) {
            a(statusBar.f144267a);
        }
    }

    public /* synthetic */ d(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
