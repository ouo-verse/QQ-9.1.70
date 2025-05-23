package com.tencent.sqshow.zootopia.friendsdressup.datasrouce;

import com.tencent.mobileqq.zootopia.api.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R \u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/sqshow/zootopia/friendsdressup/datasrouce/b;", "T", "Lcom/tencent/mobileqq/zootopia/api/e;", "result", "", "onResultSuccess", "(Ljava/lang/Object;)V", "", "error", "", "message", "onResultFailure", "Lmqq/util/WeakReference;", "d", "Lmqq/util/WeakReference;", "weakReal", "real", "<init>", "(Lcom/tencent/mobileqq/zootopia/api/e;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b<T> implements e<T> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<e<T>> weakReal;

    public b(e<T> real) {
        Intrinsics.checkNotNullParameter(real, "real");
        this.weakReal = new WeakReference<>(real);
    }

    @Override // com.tencent.mobileqq.zootopia.api.e
    public void onResultFailure(int error, String message) {
        e<T> eVar = this.weakReal.get();
        if (eVar != null) {
            eVar.onResultFailure(error, message);
        }
    }

    @Override // com.tencent.mobileqq.zootopia.api.e
    public void onResultSuccess(T result) {
        e<T> eVar = this.weakReal.get();
        if (eVar != null) {
            eVar.onResultSuccess(result);
        }
    }
}
