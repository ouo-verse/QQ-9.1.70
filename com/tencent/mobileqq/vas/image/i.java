package com.tencent.mobileqq.vas.image;

import android.graphics.Canvas;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002R$\u0010\u000b\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00030\u00030\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/image/i;", "", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "block", "a", "Lmqq/util/WeakReference;", "kotlin.jvm.PlatformType", "b", "Lmqq/util/WeakReference;", "fakeCanvas", "<init>", "()V", "vas_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f309597a = new i();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static WeakReference<Canvas> fakeCanvas = new WeakReference<>(new Canvas());

    i() {
    }

    public final void a(@NotNull Function1<? super Canvas, Unit> block) {
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
