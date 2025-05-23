package com.tencent.aelight.camera.zplan.api.impl;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/aelight/camera/zplan/api/impl/b;", "", "<init>", "()V", "a", "b", "Lcom/tencent/aelight/camera/zplan/api/impl/b$a;", "Lcom/tencent/aelight/camera/zplan/api/impl/b$b;", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public abstract class b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/aelight/camera/zplan/api/impl/b$a;", "Lcom/tencent/aelight/camera/zplan/api/impl/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "()I", "colorInt", "<init>", "(I)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.aelight.camera.zplan.api.impl.b$a, reason: from toString */
    /* loaded from: classes32.dex */
    public static final /* data */ class ColorBackground extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int colorInt;

        /* renamed from: a, reason: from getter */
        public final int getColorInt() {
            return this.colorInt;
        }

        public int hashCode() {
            return this.colorInt;
        }

        public String toString() {
            return "ColorBackground(colorInt=" + this.colorInt + ")";
        }

        public ColorBackground(int i3) {
            super(null);
            this.colorInt = i3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ColorBackground) && this.colorInt == ((ColorBackground) other).colorInt;
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    b() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/aelight/camera/zplan/api/impl/b$b;", "Lcom/tencent/aelight/camera/zplan/api/impl/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/graphics/Bitmap;", "a", "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", "backgroundPic", "<init>", "(Landroid/graphics/Bitmap;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.aelight.camera.zplan.api.impl.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes32.dex */
    public static final /* data */ class PicBackground extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final Bitmap backgroundPic;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PicBackground(Bitmap backgroundPic) {
            super(null);
            Intrinsics.checkNotNullParameter(backgroundPic, "backgroundPic");
            this.backgroundPic = backgroundPic;
        }

        /* renamed from: a, reason: from getter */
        public final Bitmap getBackgroundPic() {
            return this.backgroundPic;
        }

        public int hashCode() {
            return this.backgroundPic.hashCode();
        }

        public String toString() {
            return "PicBackground(backgroundPic=" + this.backgroundPic + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PicBackground) && Intrinsics.areEqual(this.backgroundPic, ((PicBackground) other).backgroundPic);
        }
    }
}
