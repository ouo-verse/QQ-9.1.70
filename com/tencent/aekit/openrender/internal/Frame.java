package com.tencent.aekit.openrender.internal;

import android.opengl.GLES20;
import android.util.Log;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Frame {
    static IPatchRedirector $redirector_;
    private static final String TAG;
    private List<String> backtracing;
    private boolean canUnlock;
    private int[] fbo;
    public int height;
    private int[] mRenderBufferDepth;
    private boolean needDepth;
    public boolean needReleaseFrame;
    public Frame nextFrame;
    private boolean ownDepthBuffer;
    private boolean owntexture;
    protected int[] texture;
    private Type type;
    public int width;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class Type {
        private static final /* synthetic */ Type[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final Type FRAME_CACHE;
        public static final Type NEW;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12396);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            Type type = new Type("NEW", 0);
            NEW = type;
            Type type2 = new Type("FRAME_CACHE", 1);
            FRAME_CACHE = type2;
            $VALUES = new Type[]{type, type2};
        }

        Type(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12407);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            TAG = Frame.class.getSimpleName();
        }
    }

    public Frame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.texture = new int[1];
        this.fbo = new int[1];
        this.mRenderBufferDepth = new int[1];
        this.type = Type.NEW;
        this.backtracing = new ArrayList();
    }

    public void addBackTracing(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        } else {
            this.backtracing.add(str);
        }
    }

    public void bindDepthBuffer(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 != this.width || i16 != this.height) {
            this.ownDepthBuffer = false;
        }
        if (this.needDepth && !this.ownDepthBuffer) {
            this.ownDepthBuffer = true;
            int[] iArr = this.mRenderBufferDepth;
            if (iArr[0] <= 0) {
                GLES20.glGenRenderbuffers(1, iArr, 0);
            }
            GLES20.glBindRenderbuffer(36161, this.mRenderBufferDepth[0]);
            GLES20.glRenderbufferStorage(36161, 33189, i3, i16);
            GLES20.glBindFramebuffer(36160, this.fbo[0]);
            GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.mRenderBufferDepth[0]);
        }
    }

    public void bindFrame(int i3, int i16, int i17, double d16) {
        double d17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Double.valueOf(d16));
            return;
        }
        if (i3 == 0) {
            GLES20.glBindFramebuffer(36160, 0);
            if (d16 <= 0.0d) {
                GLES20.glViewport(0, 0, i16, i17);
                return;
            }
            double d18 = i17;
            double d19 = d16 * d18;
            double d26 = i16;
            if (d26 > d19) {
                d17 = d26 / d16;
                d19 = d26;
            } else {
                d17 = d18;
            }
            GLES20.glViewport(((int) (-(d19 - d26))) / 2, ((int) (-(d17 - d18))) / 2, (int) d19, (int) d17);
            return;
        }
        if ((i3 > 0 && this.texture[0] != i3) || this.width != i16 || this.height != i17) {
            int i18 = this.fbo[0];
            if (i18 != 0) {
                GLES20.glBindFramebuffer(36160, i18);
                GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, 0, 0);
            }
            if (this.owntexture) {
                int[] iArr = this.texture;
                if (iArr[0] != 0) {
                    GLES20.glDeleteTextures(1, iArr, 0);
                }
            }
            this.texture[0] = 0;
        }
        this.width = i16;
        this.height = i17;
        int[] iArr2 = this.fbo;
        if (iArr2[0] <= 0) {
            GLES20.glGenFramebuffers(1, iArr2, 0);
        }
        if (i3 > 0) {
            int[] iArr3 = this.texture;
            if (iArr3[0] != i3) {
                this.owntexture = false;
                iArr3[0] = i3;
                GLES20.glActiveTexture(33984);
                GlUtil.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.texture[0]);
                GlUtil.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, this.width, this.height, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
                GLES20.glBindFramebuffer(36160, this.fbo[0]);
                GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, this.texture[0], 0);
                bindDepthBuffer(this.width, this.height);
                GLES20.glViewport(0, 0, this.width, this.height);
                return;
            }
        }
        if (this.texture[0] <= 0) {
            this.owntexture = true;
            GLES20.glActiveTexture(33984);
            int[] iArr4 = this.texture;
            GlUtil.glGenTextures(iArr4.length, iArr4, 0);
            GlUtil.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.texture[0]);
            GlUtil.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, this.width, this.height, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
            GLES20.glBindFramebuffer(36160, this.fbo[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, this.texture[0], 0);
            bindDepthBuffer(this.width, this.height);
            GLES20.glViewport(0, 0, this.width, this.height);
            return;
        }
        GLES20.glBindFramebuffer(36160, this.fbo[0]);
        GLES20.glViewport(0, 0, this.width, this.height);
    }

    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        int i3 = this.fbo[0];
        if (i3 != 0) {
            GLES20.glBindFramebuffer(36160, i3);
            GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, 0, 0);
            GLES20.glDeleteFramebuffers(1, this.fbo, 0);
            this.fbo[0] = 0;
        }
        int[] iArr = this.mRenderBufferDepth;
        if (iArr[0] != 0) {
            GLES20.glDeleteRenderbuffers(iArr.length, iArr, 0);
            Arrays.fill(this.mRenderBufferDepth, 0);
        }
        clearSelf();
        Frame frame = this.nextFrame;
        if (frame != null) {
            frame.clear();
        }
        GLES20.glBindFramebuffer(36160, 0);
    }

    public void clearSelf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        int[] iArr = this.texture;
        if (iArr[0] != 0) {
            if (this.owntexture) {
                GlUtil.glDeleteTextures(1, iArr, 0);
            }
            this.texture[0] = 0;
        }
    }

    public boolean getCouldLockState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.canUnlock;
    }

    public int getFBO() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.fbo[0];
    }

    public int getLastRenderTextureId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        Frame frame = this;
        while (true) {
            Frame frame2 = frame.nextFrame;
            if (frame2 == null || frame2.getTextureId() == 0) {
                break;
            }
            frame = frame.nextFrame;
        }
        return frame.getTextureId();
    }

    public int getLastTextureId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        Frame frame = this;
        while (true) {
            Frame frame2 = frame.nextFrame;
            if (frame2 != null) {
                frame = frame2;
            } else {
                return frame.getTextureId();
            }
        }
    }

    public int getTextureId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.texture[0];
    }

    public void printBackTracing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        StringBuilder sb5 = new StringBuilder("[frame backtracing] ");
        Iterator<String> it = this.backtracing.iterator();
        while (it.hasNext()) {
            sb5.append(it.next() + ", ");
        }
        Log.e(TAG, sb5.toString());
    }

    public void setCanUnlock(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        } else {
            this.canUnlock = z16;
        }
    }

    public void setNeedDepth(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.needDepth = z16;
        }
    }

    public void setSizedTexture(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.width = i16;
        this.height = i17;
        int[] iArr = this.fbo;
        if (iArr[0] <= 0) {
            GLES20.glGenFramebuffers(1, iArr, 0);
        }
        if (i3 > 0) {
            int[] iArr2 = this.texture;
            if (iArr2[0] != i3) {
                this.owntexture = false;
                iArr2[0] = i3;
                GLES20.glActiveTexture(33984);
                GlUtil.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.texture[0]);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
                GLES20.glBindFramebuffer(36160, this.fbo[0]);
                GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, this.texture[0], 0);
                GLES20.glViewport(0, 0, this.width, this.height);
                return;
            }
        }
        if (this.texture[0] <= 0) {
            this.owntexture = true;
            GLES20.glActiveTexture(33984);
            int[] iArr3 = this.texture;
            GlUtil.glGenTextures(iArr3.length, iArr3, 0);
            GlUtil.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.texture[0]);
            GlUtil.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, this.width, this.height, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
            GLES20.glBindFramebuffer(36160, this.fbo[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, this.texture[0], 0);
            GLES20.glViewport(0, 0, this.width, this.height);
            return;
        }
        GLES20.glBindFramebuffer(36160, this.fbo[0]);
        GLES20.glViewport(0, 0, this.width, this.height);
    }

    public void setTextureId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.texture[0] = i3;
        }
    }

    public boolean unlock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        if (this.owntexture && this.type == Type.FRAME_CACHE && this.canUnlock) {
            return FrameBufferCache.getInstance().put(this);
        }
        return false;
    }

    public Frame(Type type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) type);
            return;
        }
        this.texture = new int[1];
        this.fbo = new int[1];
        this.mRenderBufferDepth = new int[1];
        this.type = Type.NEW;
        this.backtracing = new ArrayList();
        this.type = type;
        this.canUnlock = type == Type.FRAME_CACHE;
    }

    public Frame(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.texture = new int[1];
        this.fbo = new int[1];
        this.mRenderBufferDepth = new int[1];
        this.type = Type.NEW;
        this.backtracing = new ArrayList();
        this.texture[0] = i16;
        this.fbo[0] = i3;
        this.width = i17;
        this.height = i18;
    }

    public void bindFrame(ByteBuffer byteBuffer, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, byteBuffer, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.width = i3;
        this.height = i16;
        int[] iArr = this.fbo;
        if (iArr[0] <= 0) {
            GLES20.glGenFramebuffers(1, iArr, 0);
        }
        if (this.texture[0] <= 0) {
            this.owntexture = true;
            GLES20.glActiveTexture(33984);
            int[] iArr2 = this.texture;
            GlUtil.glGenTextures(iArr2.length, iArr2, 0);
        }
        GlUtil.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.texture[0]);
        GlUtil.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, this.width, this.height, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, byteBuffer);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
        GLES20.glBindFramebuffer(36160, this.fbo[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, this.texture[0], 0);
        GLES20.glViewport(0, 0, this.width, this.height);
        Log.d("Frame", "new frame buffer auto");
    }
}
