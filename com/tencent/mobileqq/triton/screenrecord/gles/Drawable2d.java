package com.tencent.mobileqq.triton.screenrecord.gles;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0011\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/triton/screenrecord/gles/Drawable2d;", "", "()V", "coordsPerVertex", "", "getCoordsPerVertex", "()I", "texCoordArray", "Ljava/nio/FloatBuffer;", "getTexCoordArray", "()Ljava/nio/FloatBuffer;", "texCoordStride", "getTexCoordStride", "vertexArray", "getVertexArray", "vertexCount", "getVertexCount", "vertexStride", "getVertexStride", "Companion", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class Drawable2d {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float[] FULL_RECTANGLE_COORDS = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] FULL_RECTANGLE_TEX_COORDS = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static final int SIZEOF_FLOAT = 4;
    private final int coordsPerVertex;

    @NotNull
    private final FloatBuffer texCoordArray;
    private final int texCoordStride;

    @NotNull
    private final FloatBuffer vertexArray;
    private final int vertexCount;
    private final int vertexStride;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/triton/screenrecord/gles/Drawable2d$Companion;", "", "()V", "FULL_RECTANGLE_COORDS", "", "FULL_RECTANGLE_TEX_COORDS", "SIZEOF_FLOAT", "", "createFloatBuffer", "Ljava/nio/FloatBuffer;", "coords", "Triton_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final FloatBuffer createFloatBuffer(@NotNull float[] coords) {
            Intrinsics.checkParameterIsNotNull(coords, "coords");
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(coords.length * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer fb5 = allocateDirect.asFloatBuffer();
            fb5.put(coords);
            fb5.position(0);
            Intrinsics.checkExpressionValueIsNotNull(fb5, "fb");
            return fb5;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Drawable2d() {
        Companion companion = INSTANCE;
        float[] fArr = FULL_RECTANGLE_COORDS;
        this.vertexArray = companion.createFloatBuffer(fArr);
        this.texCoordArray = companion.createFloatBuffer(FULL_RECTANGLE_TEX_COORDS);
        this.coordsPerVertex = 2;
        this.vertexStride = 2 * 4;
        this.vertexCount = fArr.length / 2;
        this.texCoordStride = 8;
    }

    public final int getCoordsPerVertex() {
        return this.coordsPerVertex;
    }

    @NotNull
    public final FloatBuffer getTexCoordArray() {
        return this.texCoordArray;
    }

    public final int getTexCoordStride() {
        return this.texCoordStride;
    }

    @NotNull
    public final FloatBuffer getVertexArray() {
        return this.vertexArray;
    }

    public final int getVertexCount() {
        return this.vertexCount;
    }

    public final int getVertexStride() {
        return this.vertexStride;
    }
}
