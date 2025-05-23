package com.tencent.ntcompose.lifecycle.viewmodel;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002J\u0006\u0010\t\u001a\u00020\u0006R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ntcompose/lifecycle/viewmodel/j;", "", "", "key", "Lcom/tencent/ntcompose/lifecycle/viewmodel/g;", "viewModel", "", "c", "b", "a", "", "Ljava/util/Map;", "map", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<String, g> map = new LinkedHashMap();

    public final void a() {
        Iterator<g> it = this.map.values().iterator();
        while (it.hasNext()) {
            it.next().clear$ntcompose_release();
        }
        this.map.clear();
    }

    public final g b(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.map.get(key);
    }

    public final void c(String key, g viewModel) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        g put = this.map.put(key, viewModel);
        if (put != null) {
            put.clear$ntcompose_release();
        }
    }
}
