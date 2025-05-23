package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.jx;
import com.tencent.mapsdk.internal.ka;
import com.tencent.mapsdk.internal.kp;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class jy<D extends ka> extends kh<D> implements jx<D> {
    @Override // com.tencent.mapsdk.internal.jx
    public final jx<D> a() {
        return this;
    }

    @Override // com.tencent.mapsdk.internal.jx
    public final void b(jx.a<Long> aVar) {
        kp.a((kp.g) new kp.g<Long>() { // from class: com.tencent.mapsdk.internal.jy.5
            private Long a() {
                return Long.valueOf(jy.this.k());
            }

            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() throws Exception {
                return Long.valueOf(jy.this.k());
            }
        }).a((kp.d) new kp.e(0L)).b(aVar);
    }

    @Override // com.tencent.mapsdk.internal.jx
    public final void c(jx.a<Long> aVar) {
        kp.a((kp.g) new kp.g<Long>() { // from class: com.tencent.mapsdk.internal.jy.6
            private Long a() {
                return Long.valueOf(jy.this.l());
            }

            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() throws Exception {
                return Long.valueOf(jy.this.l());
            }
        }).a((kp.d) new kp.e(0L)).b(aVar);
    }

    @Override // com.tencent.mapsdk.internal.jx
    public final void d(jx.a<Long> aVar) {
        kp.a((kp.g) new kp.g<Long>() { // from class: com.tencent.mapsdk.internal.jy.7
            private Long a() {
                return Long.valueOf(jy.this.e());
            }

            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() throws Exception {
                return Long.valueOf(jy.this.e());
            }
        }).a((kp.d) new kp.e(0L)).b(aVar);
    }

    @Override // com.tencent.mapsdk.internal.jx
    public final void a(final String str, final D d16, jx.a<Boolean> aVar) {
        kp.a((kp.g) new kp.g<Boolean>() { // from class: com.tencent.mapsdk.internal.jy.1
            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() {
                jy.this.b(str, (String) d16);
                return Boolean.TRUE;
            }
        }).a((kp.d) new kp.e(Boolean.FALSE)).b(aVar);
    }

    @Override // com.tencent.mapsdk.internal.jx
    public final void a(final String str, final Class<D> cls, jx.a<D> aVar) {
        try {
            kp.a((kp.g) new kp.g<D>() { // from class: com.tencent.mapsdk.internal.jy.2
                private D a() {
                    return (D) jy.this.b(str, cls);
                }

                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() throws Exception {
                    return jy.this.b(str, cls);
                }
            }).a((kp.d) new kp.e(cls.newInstance())).b(aVar);
        } catch (IllegalAccessException e16) {
            throw new Error("The " + cls.getSimpleName() + " must have a empty construct. #" + e16.getMessage(), e16);
        } catch (InstantiationException e17) {
            throw new Error("The " + cls.getSimpleName() + " must have a empty construct. #" + e17.getMessage(), e17);
        }
    }

    @Override // com.tencent.mapsdk.internal.jx
    public final void a(final String str, jx.a<Boolean> aVar) {
        kp.a((kp.g) new kp.g<Boolean>() { // from class: com.tencent.mapsdk.internal.jy.3
            private Boolean a() {
                return Boolean.valueOf(jy.this.b(str));
            }

            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() throws Exception {
                return Boolean.valueOf(jy.this.b(str));
            }
        }).a((kp.d) new kp.e(Boolean.FALSE)).b(aVar);
    }

    @Override // com.tencent.mapsdk.internal.jx
    public final void a(jx.a<Boolean> aVar) {
        kp.a((kp.g) new kp.g<Boolean>() { // from class: com.tencent.mapsdk.internal.jy.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() {
                jy.this.j();
                return Boolean.TRUE;
            }
        }).a((kp.d) new kp.e(Boolean.FALSE)).b(aVar);
    }
}
