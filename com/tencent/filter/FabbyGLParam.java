package com.tencent.filter;

import android.opengl.GLES20;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.view.RendererUtils;

/* loaded from: classes6.dex */
public class FabbyGLParam {
    static IPatchRedirector $redirector_;

    /* loaded from: classes6.dex */
    public static class FloatV2Param extends UniformParam {
        static IPatchRedirector $redirector_;
        private float[] value;

        public FloatV2Param(String str, float[] fArr) {
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
            if (i16 >= 0) {
                float[] fArr = this.value;
                if (fArr.length > 0 && fArr.length % 2 == 0) {
                    GLES20.glUniform2fv(i16, fArr.length / 2, fArr, 0);
                    RendererUtils.checkGlError("FloatsParam setParams");
                    return;
                }
                throw new IllegalStateException("floats length can't be divided by 4");
            }
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.name + ContainerUtils.KEY_VALUE_DELIMITER + this.value.toString();
        }
    }

    /* loaded from: classes6.dex */
    public static class FloatV4Param extends UniformParam {
        static IPatchRedirector $redirector_;
        private float[] value;

        public FloatV4Param(String str, float[] fArr) {
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
            if (i16 >= 0) {
                float[] fArr = this.value;
                if (fArr.length > 0 && fArr.length % 4 == 0) {
                    GLES20.glUniform4fv(i16, fArr.length / 4, fArr, 0);
                    RendererUtils.checkGlError("FloatsParam setParams");
                    return;
                }
                throw new IllegalStateException("floats length can't be divided by 4");
            }
        }

        @Override // com.tencent.aekit.openrender.UniformParam
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.name + ContainerUtils.KEY_VALUE_DELIMITER + this.value.toString();
        }
    }

    public FabbyGLParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
