package com.tencent.aekit.openrender;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Arrays;

/* loaded from: classes3.dex */
public abstract class UniformParam {
    static IPatchRedirector $redirector_;
    public int handle;
    public String name;

    /* loaded from: classes3.dex */
    public static class Float1sParam extends UniformParam {
        static IPatchRedirector $redirector_;
        float[] value;

        public Float1sParam(String str, float[] fArr) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) fArr);
                return;
            }
            this.value = new float[fArr.length];
            for (int i3 = 0; i3 < fArr.length; i3++) {
                this.value[i3] = fArr[i3];
            }
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public void setParams(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            int i16 = this.handle;
            if (i16 < 0) {
                return;
            }
            float[] fArr = this.value;
            GLES20.glUniform1fv(i16, fArr.length, fArr, 0);
            GlUtil.checkGlError("FloatParam setParams");
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.name + " = " + this.value;
        }
    }

    /* loaded from: classes3.dex */
    public static class Float2fParam extends UniformParam {
        static IPatchRedirector $redirector_;

        /* renamed from: x, reason: collision with root package name */
        public float f61801x;

        /* renamed from: y, reason: collision with root package name */
        public float f61802y;

        public Float2fParam(String str, float f16, float f17) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Float.valueOf(f16), Float.valueOf(f17));
            } else {
                this.f61801x = f16;
                this.f61802y = f17;
            }
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public void setParams(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            int i16 = this.handle;
            if (i16 < 0) {
                return;
            }
            GLES20.glUniform2f(i16, this.f61801x, this.f61802y);
            GlUtil.checkGlError("Float2fParam setParams");
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.name + " = " + this.f61801x + ", " + this.f61802y;
        }
    }

    /* loaded from: classes3.dex */
    public static class Float2sParam extends UniformParam {
        static IPatchRedirector $redirector_;
        float[] value;

        public Float2sParam(String str, float[] fArr) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) fArr);
                return;
            }
            this.value = new float[fArr.length];
            for (int i3 = 0; i3 < fArr.length; i3++) {
                this.value[i3] = fArr[i3];
            }
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public void setParams(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            int i16 = this.handle;
            if (i16 < 0) {
                return;
            }
            float[] fArr = this.value;
            GLES20.glUniform2fv(i16, fArr.length / 2, fArr, 0);
            GlUtil.checkGlError("Float2sParam setParams");
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.name + " = " + this.value;
        }
    }

    /* loaded from: classes3.dex */
    public static class Float3fParam extends UniformParam {
        static IPatchRedirector $redirector_;

        /* renamed from: x, reason: collision with root package name */
        float f61803x;

        /* renamed from: y, reason: collision with root package name */
        float f61804y;

        /* renamed from: z, reason: collision with root package name */
        float f61805z;

        public Float3fParam(String str, float f16, float f17, float f18) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
                return;
            }
            this.f61803x = f16;
            this.f61804y = f17;
            this.f61805z = f18;
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public void setParams(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            int i16 = this.handle;
            if (i16 < 0) {
                return;
            }
            GLES20.glUniform3f(i16, this.f61803x, this.f61804y, this.f61805z);
            GlUtil.checkGlError("Float3fParam setParams");
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.name + " = " + this.f61803x + ", " + this.f61804y + ", " + this.f61805z;
        }
    }

    /* loaded from: classes3.dex */
    public static class Float4fParam extends UniformParam {
        static IPatchRedirector $redirector_;

        /* renamed from: w, reason: collision with root package name */
        float f61806w;

        /* renamed from: x, reason: collision with root package name */
        float f61807x;

        /* renamed from: y, reason: collision with root package name */
        float f61808y;

        /* renamed from: z, reason: collision with root package name */
        float f61809z;

        public Float4fParam(String str, float f16, float f17, float f18, float f19) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
                return;
            }
            this.f61807x = f16;
            this.f61808y = f17;
            this.f61809z = f18;
            this.f61806w = f19;
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public void setParams(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            int i16 = this.handle;
            if (i16 < 0) {
                return;
            }
            GLES20.glUniform4f(i16, this.f61807x, this.f61808y, this.f61809z, this.f61806w);
            GlUtil.checkGlError("Float4fParam setParams: " + toString());
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.name + " = " + this.f61807x + ", " + this.f61808y + ", " + this.f61809z + ", " + this.f61806w;
        }
    }

    /* loaded from: classes3.dex */
    public static class Float4sParam extends UniformParam {
        static IPatchRedirector $redirector_;
        float[] value;

        public Float4sParam(String str, float[] fArr) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) fArr);
                return;
            }
            this.value = new float[fArr.length];
            for (int i3 = 0; i3 < fArr.length; i3++) {
                this.value[i3] = fArr[i3];
            }
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public void setParams(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            int i16 = this.handle;
            if (i16 < 0) {
                return;
            }
            float[] fArr = this.value;
            GLES20.glUniform4fv(i16, fArr.length / 4, fArr, 0);
            GlUtil.checkGlError("Float4sParam setParams");
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.name + " = " + this.value;
        }
    }

    /* loaded from: classes3.dex */
    public static class FloatParam extends UniformParam {
        static IPatchRedirector $redirector_;
        float value;

        public FloatParam(String str, float f16) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Float.valueOf(f16));
            } else {
                this.value = f16;
            }
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public void setParams(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            int i16 = this.handle;
            if (i16 < 0) {
                return;
            }
            GLES20.glUniform1f(i16, this.value);
            GlUtil.checkGlError("FloatParam setParams");
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.name + " = " + this.value;
        }

        public float value() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Float) iPatchRedirector.redirect((short) 2, (Object) this)).floatValue();
            }
            return this.value;
        }
    }

    /* loaded from: classes3.dex */
    public static class FloatsParam extends UniformParam {
        static IPatchRedirector $redirector_;
        float[] value;

        public FloatsParam(String str, float[] fArr) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) fArr);
                return;
            }
            this.value = new float[fArr.length];
            for (int i3 = 0; i3 < fArr.length; i3++) {
                this.value[i3] = fArr[i3];
            }
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public void setParams(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            int i16 = this.handle;
            if (i16 < 0) {
                return;
            }
            float[] fArr = this.value;
            int length = fArr.length;
            if (length != 1) {
                if (length != 2) {
                    if (length != 3) {
                        if (length != 4) {
                            if (length != 9) {
                                if (length != 16) {
                                    GLES20.glUniform1fv(i16, fArr.length, fArr, 0);
                                } else {
                                    GLES20.glUniformMatrix4fv(i16, 1, false, fArr, 0);
                                }
                            } else {
                                GLES20.glUniformMatrix3fv(i16, 1, false, fArr, 0);
                            }
                        } else {
                            GLES20.glUniform4fv(i16, 1, fArr, 0);
                        }
                    } else {
                        GLES20.glUniform3fv(i16, 1, fArr, 0);
                    }
                } else {
                    GLES20.glUniform2fv(i16, 1, fArr, 0);
                }
            } else {
                GLES20.glUniform1f(i16, fArr[0]);
            }
            GlUtil.checkGlError("FloatsParam setParams");
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.name + " = " + Arrays.toString(this.value);
        }
    }

    /* loaded from: classes3.dex */
    public static class Int1sParam extends UniformParam {
        static IPatchRedirector $redirector_;
        int[] value;

        public Int1sParam(String str, int[] iArr) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) iArr);
                return;
            }
            this.value = new int[iArr.length];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                this.value[i3] = iArr[i3];
            }
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public void setParams(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            int i16 = this.handle;
            if (i16 < 0) {
                return;
            }
            int[] iArr = this.value;
            GLES20.glUniform1iv(i16, iArr.length, iArr, 0);
            GlUtil.checkGlError("FloatParam setParams");
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.name + " = " + this.value;
        }
    }

    /* loaded from: classes3.dex */
    public static class Int2iParam extends UniformParam {
        static IPatchRedirector $redirector_;

        /* renamed from: x, reason: collision with root package name */
        int f61810x;

        /* renamed from: y, reason: collision with root package name */
        int f61811y;

        public Int2iParam(String str, int i3, int i16) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.f61810x = i3;
                this.f61811y = i16;
            }
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public void setParams(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            int i16 = this.handle;
            if (i16 < 0) {
                return;
            }
            GLES20.glUniform2i(i16, this.f61810x, this.f61811y);
            GlUtil.checkGlError("IntParam setParams");
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (String) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return this.name + " = [ x = " + this.f61810x + ", y = " + this.f61811y + "]";
        }
    }

    /* loaded from: classes3.dex */
    public static class IntParam extends UniformParam {
        static IPatchRedirector $redirector_;
        int value;

        public IntParam(String str, int i3) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
            } else {
                this.value = i3;
            }
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public void setParams(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            int i16 = this.handle;
            if (i16 < 0) {
                return;
            }
            GLES20.glUniform1i(i16, this.value);
            GlUtil.checkGlError("IntParam setParams: " + toString());
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (String) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return this.name + " = " + this.value;
        }
    }

    /* loaded from: classes3.dex */
    public static class Mat4Param extends UniformParam {
        static IPatchRedirector $redirector_;
        private final float[] mMatrix;

        public Mat4Param(String str, float[] fArr) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) fArr);
            } else {
                this.mMatrix = fArr;
            }
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public void setParams(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                GLES20.glUniformMatrix4fv(this.handle, 1, false, this.mMatrix, 0);
            }
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.name + " = " + Arrays.toString(this.mMatrix);
        }
    }

    /* loaded from: classes3.dex */
    public static class TextureBitmapParam extends TextureParam {
        static IPatchRedirector $redirector_;
        boolean needRecycle;
        Bitmap textureBitmap;
        boolean update;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextureBitmapParam(String str, Bitmap bitmap, int i3, boolean z16) {
            super(str, 0, i3);
            boolean z17 = false;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, bitmap, Integer.valueOf(i3), Boolean.valueOf(z16));
                return;
            }
            this.needRecycle = z16;
            this.textureBitmap = bitmap;
            if (bitmap != null && !bitmap.isRecycled()) {
                z17 = true;
            }
            this.update = z17;
        }

        @Override // com.tencent.aekit.openrender.UniformParam.TextureParam, com.tencent.aekit.openrender.UniformParam
        public void clear() {
            Bitmap bitmap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            GLES20.glActiveTexture(this.textureId);
            GlUtil.glDeleteTextures(1, this.texture, 0);
            super.clear();
            if (this.needRecycle && (bitmap = this.textureBitmap) != null) {
                bitmap.recycle();
                this.textureBitmap = null;
            }
        }

        public Bitmap getTextureBitmap() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Bitmap) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.textureBitmap;
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public void initialParams(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            super.initialParams(i3);
            GLES20.glActiveTexture(this.textureId);
            GlUtil.glGenTextures(1, this.texture, 0);
        }

        @Override // com.tencent.aekit.openrender.UniformParam.TextureParam, com.tencent.aekit.openrender.UniformParam
        public void setParams(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
                return;
            }
            if (this.update) {
                GLES20.glActiveTexture(this.textureId);
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.texture[0]);
                try {
                    GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, this.textureBitmap, 0);
                } catch (IllegalArgumentException e16) {
                    e16.printStackTrace();
                }
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
            }
            super.setParams(i3);
            this.update = false;
        }

        public void swapTextureBitmap(Bitmap bitmap) {
            boolean z16;
            Bitmap bitmap2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) bitmap);
                return;
            }
            if (this.needRecycle && (bitmap2 = this.textureBitmap) != null && !bitmap2.isRecycled()) {
                this.textureBitmap.recycle();
            }
            this.textureBitmap = bitmap;
            if (bitmap != null && !bitmap.isRecycled()) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.update = z16;
        }
    }

    /* loaded from: classes3.dex */
    public static class TextureParam extends UniformParam {
        static IPatchRedirector $redirector_;
        public int[] texture;
        public int textureId;

        public TextureParam(String str, int i3, int i16) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            int[] iArr = {0};
            this.texture = iArr;
            this.textureId = i16;
            iArr[0] = i3;
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public void clear() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.clear();
                this.texture[0] = 0;
            }
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public void setParams(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 3;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            if (this.handle >= 0 && this.texture[0] != 0) {
                GLES20.glActiveTexture(this.textureId);
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.texture[0]);
                switch (this.textureId) {
                    case 33984:
                    default:
                        i16 = 0;
                        break;
                    case 33985:
                        i16 = 1;
                        break;
                    case 33986:
                        i16 = 2;
                        break;
                    case 33987:
                        break;
                    case 33988:
                        i16 = 4;
                        break;
                    case 33989:
                        i16 = 5;
                        break;
                    case 33990:
                        i16 = 6;
                        break;
                    case 33991:
                        i16 = 7;
                        break;
                }
                GLES20.glUniform1i(this.handle, i16);
                GlUtil.checkGlError("TextureParam setParams");
            }
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.name + " = " + this.texture[0];
        }
    }

    public UniformParam(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.name = str;
            this.handle = -1;
        }
    }

    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.handle = -1;
        }
    }

    public void initialParams(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.handle = GLES20.glGetUniformLocation(i3, this.name);
        }
    }

    public abstract void setParams(int i3);

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.name;
    }
}
