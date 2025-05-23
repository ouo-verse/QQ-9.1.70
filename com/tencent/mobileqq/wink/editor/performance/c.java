package com.tencent.mobileqq.wink.editor.performance;

import android.util.SparseLongArray;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0006R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/performance/c;", "", "Lcom/tencent/mobileqq/wink/editor/performance/WinkEditorPefScene;", "pefScene", "", "a", "", "b", "c", "d", "", "traceFileName", "e", "f", "Landroid/util/SparseLongArray;", "Landroid/util/SparseLongArray;", "logTimeMap", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f321449a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SparseLongArray logTimeMap = new SparseLongArray();

    c() {
    }

    private final long a(WinkEditorPefScene pefScene) {
        boolean z16;
        SparseLongArray sparseLongArray = logTimeMap;
        if (sparseLongArray.indexOfKey(pefScene.ordinal()) >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return System.currentTimeMillis() - sparseLongArray.get(pefScene.ordinal());
        }
        return -1L;
    }

    public final void b(@NotNull WinkEditorPefScene pefScene) {
        Intrinsics.checkNotNullParameter(pefScene, "pefScene");
        w53.b.f("WinkEditorPerformanceHelper", pefScene.name() + " begin");
        logTimeMap.put(pefScene.ordinal(), System.currentTimeMillis());
    }

    public final void c(@NotNull WinkEditorPefScene pefScene) {
        long a16;
        Intrinsics.checkNotNullParameter(pefScene, "pefScene");
        if (pefScene == WinkEditorPefScene.FRAGMENT_LAUNCH) {
            a16 = a(WinkEditorPefScene.FRAGMENT_ON_ATTACH);
        } else {
            a16 = a(pefScene);
        }
        if (a16 >= 0) {
            w53.b.f("WinkEditorPerformanceHelper", pefScene.name() + " end, cost " + a16 + " ms ");
        }
    }

    public final void d() {
        logTimeMap.clear();
    }

    public final void e(@NotNull String traceFileName) {
        Intrinsics.checkNotNullParameter(traceFileName, "traceFileName");
    }

    public final void f() {
    }
}
