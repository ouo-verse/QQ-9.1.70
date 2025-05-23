package com.tencent.aekit.openrender;

import android.opengl.GLES20;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class AttributeParam {
    static IPatchRedirector $redirector_ = null;
    private static final int PER_FLOAT_BYTE = 4;
    private FloatBuffer buffer;
    private int[] glBuffer;
    public int handle;
    public String name;
    public int perVertexFloat;
    private boolean update;
    private boolean useVBO;
    public float[] vertices;

    public AttributeParam(String str, float[] fArr) {
        this(str, fArr, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) fArr);
    }

    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.vertices = null;
        this.buffer = null;
        int[] iArr = this.glBuffer;
        if (iArr != null) {
            GLES20.glDeleteBuffers(iArr.length, iArr, 0);
        }
    }

    public void initialParams(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.handle = GLES20.glGetAttribLocation(i3, this.name);
        }
    }

    public void setParams(int i3) {
        int[] iArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        if (this.vertices == null) {
            return;
        }
        FloatBuffer floatBuffer = this.buffer;
        if (floatBuffer == null || floatBuffer.capacity() < this.vertices.length) {
            this.buffer = ByteBuffer.allocateDirect(this.vertices.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        if (this.useVBO && this.glBuffer == null) {
            int[] iArr2 = new int[1];
            this.glBuffer = iArr2;
            GLES20.glGenBuffers(iArr2.length, iArr2, 0);
        }
        if (this.update) {
            this.buffer.put(this.vertices).position(0);
            int[] iArr3 = this.glBuffer;
            if (iArr3 != null) {
                GLES20.glBindBuffer(34962, iArr3[0]);
                GLES20.glBufferData(34962, this.buffer.capacity() * 4, this.buffer, 35044);
            }
            this.update = false;
        }
        if (this.useVBO && (iArr = this.glBuffer) != null) {
            GLES20.glBindBuffer(34962, iArr[0]);
            GLES20.glEnableVertexAttribArray(this.handle);
            int i16 = this.handle;
            int i17 = this.perVertexFloat;
            GLES20.glVertexAttribPointer(i16, i17, 5126, false, i17 * 4, 0);
            GLES20.glBindBuffer(34962, 0);
            return;
        }
        GLES20.glEnableVertexAttribArray(this.handle);
        int i18 = this.handle;
        int i19 = this.perVertexFloat;
        GLES20.glVertexAttribPointer(i18, i19, 5126, false, i19 * 4, (Buffer) this.buffer);
    }

    public void setVertices(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) fArr);
        } else {
            this.vertices = fArr;
            this.update = true;
        }
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.name + " = " + Arrays.toString(this.vertices);
    }

    public AttributeParam(String str, float[] fArr, boolean z16) {
        this(str, fArr, 2, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, fArr, Boolean.valueOf(z16));
    }

    public AttributeParam(String str, float[] fArr, int i3) {
        this(str, fArr, i3, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, str, fArr, Integer.valueOf(i3));
    }

    public AttributeParam(String str, float[] fArr, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, fArr, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.name = str;
        this.vertices = fArr;
        this.handle = -1;
        this.perVertexFloat = i3;
        this.useVBO = z16;
    }
}
