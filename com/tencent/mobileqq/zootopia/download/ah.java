package com.tencent.mobileqq.zootopia.download;

import com.tencent.mobileqq.zootopia.download.y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ah;", "Lcom/tencent/mobileqq/zootopia/download/y;", "Lcom/tencent/mobileqq/zootopia/download/x;", "task", "", "d", "b", "a", "c", "e", "", "code", tl.h.F, "", "progress", "f", "", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "id", "<init>", "(Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class ah implements y {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String id;

    public ah() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.mobileqq.zootopia.download.y
    public void a(x task) {
        Intrinsics.checkNotNullParameter(task, "task");
    }

    @Override // com.tencent.mobileqq.zootopia.download.y
    public void b(x task) {
        Intrinsics.checkNotNullParameter(task, "task");
    }

    @Override // com.tencent.mobileqq.zootopia.download.y
    public void c(x task) {
        Intrinsics.checkNotNullParameter(task, "task");
    }

    @Override // com.tencent.mobileqq.zootopia.download.y
    public void d(x task) {
        Intrinsics.checkNotNullParameter(task, "task");
    }

    @Override // com.tencent.mobileqq.zootopia.download.y
    public void e(x task) {
        Intrinsics.checkNotNullParameter(task, "task");
    }

    @Override // com.tencent.mobileqq.zootopia.download.y
    public void f(float progress, x task) {
        Intrinsics.checkNotNullParameter(task, "task");
    }

    @Override // com.tencent.mobileqq.zootopia.download.y
    public void g(x xVar) {
        y.a.b(this, xVar);
    }

    @Override // com.tencent.mobileqq.zootopia.download.y
    public void h(int code, x task) {
        Intrinsics.checkNotNullParameter(task, "task");
    }

    @Override // com.tencent.mobileqq.zootopia.download.y
    public void i(long j3, x xVar) {
        y.a.a(this, j3, xVar);
    }

    /* renamed from: j, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public ah(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        this.id = id5;
    }

    public /* synthetic */ ah(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "all" : str);
    }
}
