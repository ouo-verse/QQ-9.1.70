package n15;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.filter.GLSLRender;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J \u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Ln15/d;", "", "", "width", "height", "", "d", "c", "a", "target", "mag", Element.ELEMENT_NAME_MIN, "e", "b", "I", "getWidth", "()I", "setWidth", "(I)V", "getHeight", "setHeight", "framebufferName", "renderbufferName", "texName", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int width;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int height;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int framebufferName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int renderbufferName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int texName;

    public final void b(int width, int height) {
        if (!GLES20.glIsTexture(this.texName) || !GLES20.glIsFramebuffer(this.framebufferName)) {
            d(width, height);
        }
        a();
    }

    private final void c() {
        int[] iArr = {this.texName};
        GLES20.glDeleteTextures(1, iArr, 0);
        this.texName = 0;
        iArr[0] = this.renderbufferName;
        GLES20.glDeleteRenderbuffers(1, iArr, 0);
        this.renderbufferName = 0;
        iArr[0] = this.framebufferName;
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        this.framebufferName = 0;
    }

    private final void a() {
        GLES20.glBindFramebuffer(36160, this.framebufferName);
        GLES20.glViewport(0, 0, this.width, this.height);
    }

    private final void e(int target, int mag, int min) {
        GLES20.glTexParameterf(target, 10240, mag);
        GLES20.glTexParameterf(target, 10241, min);
        GLES20.glTexParameteri(target, 10242, 33071);
        GLES20.glTexParameteri(target, 10243, 33071);
    }

    private final void d(int width, int height) {
        int[] iArr = new int[1];
        GLES20.glGetIntegerv(3379, iArr, 0);
        int i3 = iArr[0];
        if (width <= i3 && height <= i3) {
            GLES20.glGetIntegerv(34024, iArr, 0);
            int i16 = iArr[0];
            if (width <= i16 && height <= i16) {
                GLES20.glGetIntegerv(36006, iArr, 0);
                int i17 = iArr[0];
                GLES20.glGetIntegerv(36007, iArr, 0);
                int i18 = iArr[0];
                GLES20.glGetIntegerv(32873, iArr, 0);
                int i19 = iArr[0];
                c();
                try {
                    this.width = width;
                    this.height = height;
                    GLES20.glGenFramebuffers(1, iArr, 0);
                    int i26 = iArr[0];
                    this.framebufferName = i26;
                    GLES20.glBindFramebuffer(36160, i26);
                    GLES20.glGenRenderbuffers(1, iArr, 0);
                    int i27 = iArr[0];
                    this.renderbufferName = i27;
                    GLES20.glBindRenderbuffer(36161, i27);
                    GLES20.glRenderbufferStorage(36161, 33189, width, height);
                    GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.renderbufferName);
                    GLES20.glGenTextures(1, iArr, 0);
                    int i28 = iArr[0];
                    this.texName = i28;
                    GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i28);
                    e(GLSLRender.GL_TEXTURE_2D, 9729, 9729);
                    GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, width, height, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
                    GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, this.texName, 0);
                    int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
                    if (glCheckFramebufferStatus == 36053) {
                        GLES20.glBindFramebuffer(36160, i17);
                        GLES20.glBindRenderbuffer(36161, i18);
                        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i19);
                        return;
                    }
                    throw new RuntimeException("Failed to initialize framebuffer object " + glCheckFramebufferStatus + " width:" + width + " height:" + height);
                } catch (RuntimeException e16) {
                    c();
                    throw e16;
                }
            }
            throw new IllegalArgumentException("GL_MAX_RENDERBUFFER_SIZE " + iArr[0]);
        }
        throw new IllegalArgumentException("GL_MAX_TEXTURE_SIZE " + iArr[0]);
    }
}
