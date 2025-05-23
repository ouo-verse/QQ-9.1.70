package com.tencent.mobileqq.vas.flashname.impl;

import android.graphics.Canvas;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/vas/flashname/impl/c;", "Lcom/tencent/qqnt/classadapter/c;", "Lx03/b;", "", "repeatCount", "", "c", "a", "", "d", "Landroid/graphics/Canvas;", PM.CANVAS, "b", "width", "height", "", "colorValue", "isSingle", "Landroid/view/View;", "view", "<init>", "(IILjava/lang/String;ZLandroid/view/View;)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c extends com.tencent.qqnt.classadapter.c implements x03.b {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i3, int i16, @NotNull String colorValue, boolean z16, @NotNull View view) {
        super(i3, i16, colorValue, z16, view);
        Intrinsics.checkNotNullParameter(colorValue, "colorValue");
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // x03.b
    public void a() {
        n();
    }

    @Override // x03.b
    public void b(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        h(canvas);
    }

    @Override // x03.b
    public void c(int repeatCount) {
        l(repeatCount);
    }

    @Override // x03.b
    public boolean d() {
        return k();
    }
}
