package com.tencent.mobileqq.nearbypro.base;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u00020\u0004J#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00028\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0001H&\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00028\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/base/f;", "Op", "Listener", "ExtInterface", "", "op", "listener", "", "b", "(Ljava/lang/Object;Ljava/lang/Object;)V", "a", "()Ljava/lang/Object;", "extInterface", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface f<Op, Listener, ExtInterface> {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(f fVar, Object obj, Object obj2, int i3, Object obj3) {
            if (obj3 == null) {
                if ((i3 & 2) != 0) {
                    obj2 = null;
                }
                fVar.b(obj, obj2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadImage");
        }
    }

    ExtInterface a();

    void b(Op op5, @Nullable Listener listener);
}
