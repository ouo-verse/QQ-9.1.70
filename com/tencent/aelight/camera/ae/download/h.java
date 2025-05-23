package com.tencent.aelight.camera.ae.download;

import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/aelight/camera/ae/download/h;", "", "", "a", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/aelight/camera/ae/download/g;", "b", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "list", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f63660a = new h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentLinkedQueue<AEResManagerDownLoadPackage> list = new ConcurrentLinkedQueue<>();

    h() {
    }

    public final void a() {
        list.clear();
    }

    public final ConcurrentLinkedQueue<AEResManagerDownLoadPackage> b() {
        return list;
    }
}
