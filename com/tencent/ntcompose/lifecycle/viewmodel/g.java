package com.tencent.ntcompose.lifecycle.viewmodel;

import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\t\b\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0005B\u001d\b\u0016\u0012\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0013\"\u00020\t\u00a2\u0006\u0004\b\u0012\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u000f\u0010\u0006\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J!\u0010\r\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\f*\u00020\t2\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ntcompose/lifecycle/viewmodel/g;", "", "", "onCleared", "clear$ntcompose_release", "()V", QCircleLpReportDc05507.KEY_CLEAR, "", "key", "Lcom/tencent/ntcompose/lifecycle/viewmodel/a;", "closeable", "addCloseable", "T", "getCloseable", "(Ljava/lang/String;)Lcom/tencent/ntcompose/lifecycle/viewmodel/a;", "Lxo3/b;", "impl", "Lxo3/b;", "<init>", "", "closeables", "([Lcom/tencent/ntcompose/lifecycle/viewmodel/a;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class g {
    public static final int $stable = 8;
    private final xo3.b impl;

    public g() {
        this.impl = new xo3.b();
    }

    public final void addCloseable(String key, a closeable) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(closeable, "closeable");
        this.impl.b(key, closeable);
    }

    public final void clear$ntcompose_release() {
        this.impl.c();
        onCleared();
    }

    public final <T extends a> T getCloseable(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (T) this.impl.e(key);
    }

    public void addCloseable(a closeable) {
        Intrinsics.checkNotNullParameter(closeable, "closeable");
        this.impl.a(closeable);
    }

    public g(a... closeables) {
        Intrinsics.checkNotNullParameter(closeables, "closeables");
        this.impl = new xo3.b((a[]) Arrays.copyOf(closeables, closeables.length));
    }

    protected void onCleared() {
    }
}
