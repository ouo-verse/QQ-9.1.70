package com.tencent.ntcompose.core;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002R0\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ntcompose/core/d;", "", "", "viewType", "Lcom/tencent/ntcompose/core/e;", "creator", "", "c", "", "b", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "factoryRegistry", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f339209a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, e> factoryRegistry = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public static final int f339211c = 8;

    d() {
    }

    public final ComposeRenderView a(String viewType) {
        ComposeRenderView createComposeView;
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        e eVar = factoryRegistry.get(viewType);
        if (eVar != null && (createComposeView = eVar.createComposeView(viewType)) != null) {
            return createComposeView;
        }
        throw new RuntimeException("View not register:" + viewType + ", please check IComposeViewCreator");
    }

    public final boolean b(String viewType) {
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        return factoryRegistry.containsKey(viewType);
    }

    public final void c(String viewType, e creator) {
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        Intrinsics.checkNotNullParameter(creator, "creator");
        factoryRegistry.put(viewType, creator);
    }
}
