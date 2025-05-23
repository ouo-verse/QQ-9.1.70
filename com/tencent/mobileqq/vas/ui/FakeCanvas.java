package com.tencent.mobileqq.vas.ui;

import android.graphics.Canvas;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\nR\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/FakeCanvas;", "", "()V", "fakeCanvas", "Lmqq/util/WeakReference;", "Landroid/graphics/Canvas;", "kotlin.jvm.PlatformType", TransFileControllerImpl.VALUE_USE_PRE_CONN, "", "block", "Lkotlin/Function1;", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class FakeCanvas {

    @NotNull
    public static final FakeCanvas INSTANCE = new FakeCanvas();

    @NotNull
    private static WeakReference<Canvas> fakeCanvas = new WeakReference<>(new Canvas());

    FakeCanvas() {
    }

    public final void use(@NotNull Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            Canvas canvas = fakeCanvas.get();
            if (canvas == null) {
                canvas = new Canvas();
                fakeCanvas = new WeakReference<>(canvas);
            }
            synchronized (canvas) {
                block.invoke(canvas);
                Unit unit = Unit.INSTANCE;
            }
        } catch (Exception e16) {
            QLog.e("FakeCanvas", 1, "FakeCanvas use", e16);
        }
    }
}
