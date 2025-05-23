package com.tencent.liteav.base;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class a implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private static final a f118877a = new a();

    a() {
    }

    public static Callable a() {
        return f118877a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String[] privateDataDirectorySuffixInternal;
        privateDataDirectorySuffixInternal = PathUtils.setPrivateDataDirectorySuffixInternal();
        return privateDataDirectorySuffixInternal;
    }
}
