package com.tencent.luggage.wxa.f8;

import android.content.Context;
import android.view.Surface;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tR\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u001a\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/luggage/wxa/f8/s;", "Lcom/tencent/luggage/wxa/a8/d;", "Lcom/tencent/luggage/wxa/i8/c;", "Landroid/content/Context;", "context", "b", "textureImageViewLike", "Ljava/lang/Runnable;", "afterTransferToTask", "Lcom/tencent/luggage/wxa/a8/d$e;", "a", "afterTransferFromTask", "", "Lcom/tencent/luggage/wxa/f8/q;", tl.h.F, "Lcom/tencent/luggage/wxa/f8/q;", "originVideoContainer", "<init>", "(Lcom/tencent/luggage/wxa/f8/q;)V", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
final class s extends com.tencent.luggage.wxa.a8.d {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final q originVideoContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001R\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0019\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0014J\b\u0010\n\u001a\u00020\u000bH\u0014R$\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\n\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/luggage/wxa/f8/s$a;", "Lcom/tencent/luggage/wxa/a8/d$e;", "Lcom/tencent/luggage/wxa/i8/c;", "Lcom/tencent/luggage/wxa/a8/d;", "Landroid/view/Surface;", "surface", "", "width", "height", "", "a", "", "e", "Landroid/view/Surface;", "b", "()Landroid/view/Surface;", "(Landroid/view/Surface;)V", "surfaceHasSet", "textureImageViewLike", "Ljava/lang/Runnable;", "afterTransferToTask", "<init>", "(Lcom/tencent/luggage/wxa/f8/s;Lcom/tencent/luggage/wxa/i8/c;Ljava/lang/Runnable;)V", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public final class a extends com.tencent.luggage.wxa.a8.d.e {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Surface surfaceHasSet;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ s f125522f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(s sVar, @NotNull com.tencent.luggage.wxa.i8.c textureImageViewLike, @Nullable Runnable runnable) {
            super(textureImageViewLike, runnable);
            Intrinsics.checkNotNullParameter(textureImageViewLike, "textureImageViewLike");
            this.f125522f = sVar;
        }

        public void a() {
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Surface getSurfaceHasSet() {
            return this.surfaceHasSet;
        }

        public final void a(@Nullable Surface surface) {
            this.surfaceHasSet = surface;
        }

        public boolean a(@NotNull Surface surface, int width, int height) {
            boolean z16;
            Intrinsics.checkNotNullParameter(surface, "surface");
            try {
                Surface surface2 = this.surfaceHasSet;
                if (surface2 != null && surface2 == surface) {
                    surface = null;
                }
                if (surface != null) {
                    z16 = this.f125522f.originVideoContainer.a(surface);
                    if (z16) {
                        this.surfaceHasSet = surface;
                    }
                } else {
                    z16 = true;
                }
                if (!z16) {
                    return z16;
                }
                this.f125522f.originVideoContainer.a(width, height);
                return z16;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public s(@NotNull q originVideoContainer) {
        Intrinsics.checkNotNullParameter(originVideoContainer, "originVideoContainer");
        this.originVideoContainer = originVideoContainer;
    }

    @Override // com.tencent.luggage.wxa.ag.i
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.i8.c a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.luggage.wxa.tn.w.a(this.f120909a, "createVideoContainerView");
        return new com.tencent.luggage.wxa.i8.c(context);
    }

    @Override // com.tencent.luggage.wxa.a8.d
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.a8.d.e c(@NotNull com.tencent.luggage.wxa.i8.c textureImageViewLike, @Nullable Runnable afterTransferToTask) {
        Intrinsics.checkNotNullParameter(textureImageViewLike, "textureImageViewLike");
        return new a(this, textureImageViewLike, afterTransferToTask);
    }

    @Override // com.tencent.luggage.wxa.a8.d, com.tencent.luggage.wxa.ag.i
    public void b(@NotNull com.tencent.luggage.wxa.i8.c textureImageViewLike, @Nullable Runnable afterTransferFromTask) {
        Intrinsics.checkNotNullParameter(textureImageViewLike, "textureImageViewLike");
        com.tencent.luggage.wxa.tn.w.d(this.f120909a, "transferFrom, textureView: " + textureImageViewLike);
        super.b((View) textureImageViewLike, afterTransferFromTask);
        Surface m3 = this.originVideoContainer.m();
        if (m3 != null && m3.isValid()) {
            try {
                if (this.originVideoContainer.a(m3)) {
                    q qVar = this.originVideoContainer;
                    qVar.a(qVar.i(), this.originVideoContainer.k());
                }
                if (afterTransferFromTask != null) {
                    afterTransferFromTask.run();
                    return;
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        com.tencent.luggage.wxa.tn.w.f(this.f120909a, "transferFrom, originSurface is invalid");
        if (afterTransferFromTask != null) {
            afterTransferFromTask.run();
        }
    }
}
