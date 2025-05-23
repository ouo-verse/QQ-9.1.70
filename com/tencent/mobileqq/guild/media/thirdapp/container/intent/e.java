package com.tencent.mobileqq.guild.media.thirdapp.container.intent;

import android.view.Surface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/e;", "Lol3/b;", "<init>", "()V", "a", "b", "c", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/e$a;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/e$b;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/e$c;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class e implements ol3.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/e$a;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/e;", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/view/Surface;", "d", "Landroid/view/Surface;", "b", "()Landroid/view/Surface;", "surface", "e", "I", "c", "()I", "width", "f", "a", "height", "<init>", "(Landroid/view/Surface;II)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.thirdapp.container.intent.e$a, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class SurfaceChanged extends e {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Surface surface;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int width;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int height;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SurfaceChanged(@NotNull Surface surface, int i3, int i16) {
            super(null);
            Intrinsics.checkNotNullParameter(surface, "surface");
            this.surface = surface;
            this.width = i3;
            this.height = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final Surface getSurface() {
            return this.surface;
        }

        /* renamed from: c, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SurfaceChanged)) {
                return false;
            }
            SurfaceChanged surfaceChanged = (SurfaceChanged) other;
            if (Intrinsics.areEqual(this.surface, surfaceChanged.surface) && this.width == surfaceChanged.width && this.height == surfaceChanged.height) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.surface.hashCode() * 31) + this.width) * 31) + this.height;
        }

        @NotNull
        public String toString() {
            return "SurfaceChanged(surface=" + this.surface + ", width=" + this.width + ", height=" + this.height + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/e$b;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/e;", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/view/Surface;", "d", "Landroid/view/Surface;", "b", "()Landroid/view/Surface;", "surface", "e", "I", "c", "()I", "width", "f", "a", "height", "<init>", "(Landroid/view/Surface;II)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.thirdapp.container.intent.e$b, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class SurfaceCreated extends e {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Surface surface;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int width;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int height;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SurfaceCreated(@NotNull Surface surface, int i3, int i16) {
            super(null);
            Intrinsics.checkNotNullParameter(surface, "surface");
            this.surface = surface;
            this.width = i3;
            this.height = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final Surface getSurface() {
            return this.surface;
        }

        /* renamed from: c, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SurfaceCreated)) {
                return false;
            }
            SurfaceCreated surfaceCreated = (SurfaceCreated) other;
            if (Intrinsics.areEqual(this.surface, surfaceCreated.surface) && this.width == surfaceCreated.width && this.height == surfaceCreated.height) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.surface.hashCode() * 31) + this.width) * 31) + this.height;
        }

        @NotNull
        public String toString() {
            return "SurfaceCreated(surface=" + this.surface + ", width=" + this.width + ", height=" + this.height + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/e$c;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/e;", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/view/Surface;", "d", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "surface", "<init>", "(Landroid/view/Surface;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.thirdapp.container.intent.e$c, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class SurfaceDestroy extends e {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Surface surface;

        public SurfaceDestroy() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof SurfaceDestroy) && Intrinsics.areEqual(this.surface, ((SurfaceDestroy) other).surface)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Surface surface = this.surface;
            if (surface == null) {
                return 0;
            }
            return surface.hashCode();
        }

        @NotNull
        public String toString() {
            return "SurfaceDestroy(surface=" + this.surface + ")";
        }

        public SurfaceDestroy(@Nullable Surface surface) {
            super(null);
            this.surface = surface;
        }

        public /* synthetic */ SurfaceDestroy(Surface surface, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : surface);
        }
    }

    public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    e() {
    }
}
