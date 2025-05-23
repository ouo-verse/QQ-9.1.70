package com.tencent.mobileqq.shortvideo.dancemachine.tempDir;

import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.Vec3f;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class DebugModeLine {

    /* renamed from: bb, reason: collision with root package name */
    private FloatBuffer f287860bb;
    private float height;
    private int mProgram = GLES20.glCreateProgram();
    private FloatBuffer testBuffer;
    private float width;

    public DebugModeLine() {
        int loadShader = GlUtil.loadShader(35633, ShaderListFile.GL_LINE_VERTEX_CODE);
        int loadShader2 = GlUtil.loadShader(35632, ShaderListFile.GL_LINE_FRAGMENT_CODE);
        GLES20.glAttachShader(this.mProgram, loadShader);
        GLES20.glAttachShader(this.mProgram, loadShader2);
        GLES20.glLinkProgram(this.mProgram);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void draw() {
        this.f287860bb.position(0);
        GLES20.glUseProgram(this.mProgram);
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.mProgram, "position");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 0, (Buffer) this.f287860bb);
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.mProgram, "color");
        GLES20.glUniform4f(glGetUniformLocation, 0.0f, 1.0f, 0.0f, 1.0f);
        GLES20.glDrawArrays(1, 0, 40);
        this.testBuffer.position(0);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 0, (Buffer) this.testBuffer);
        GLES20.glUniform4f(glGetUniformLocation, 0.0f, 0.0f, 1.0f, 1.0f);
        GLES20.glLineWidth(8.0f);
        GLES20.glDrawArrays(1, 0, 2);
    }

    public void updateFboSize(int i3, int i16) {
        this.width = i3;
        this.height = i16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateParams(List<Vec3f> list) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            Vec3f vec3f = list.get(i3);
            float f16 = this.width;
            float f17 = (-(f16 - (vec3f.f287861x * 2.0f))) / f16;
            float f18 = this.height;
            arrayList.add(new Vec3f(f17, (f18 - (vec3f.f287862y * 2.0f)) / f18, vec3f.f287863z));
        }
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(320).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f287860bb = asFloatBuffer;
        asFloatBuffer.position(0);
        if (((Vec3f) arrayList.get(17)).f287863z > 0.0f && ((Vec3f) arrayList.get(16)).f287863z > 0.0f) {
            this.f287860bb.put(((Vec3f) arrayList.get(17)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(17)).f287862y);
            this.f287860bb.put(((Vec3f) arrayList.get(16)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(16)).f287862y);
        }
        if (((Vec3f) arrayList.get(14)).f287863z > 0.0f && ((Vec3f) arrayList.get(16)).f287863z > 0.0f) {
            this.f287860bb.put(((Vec3f) arrayList.get(14)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(14)).f287862y);
            this.f287860bb.put(((Vec3f) arrayList.get(16)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(16)).f287862y);
        }
        if (((Vec3f) arrayList.get(14)).f287863z > 0.0f && ((Vec3f) arrayList.get(0)).f287863z > 0.0f) {
            this.f287860bb.put(((Vec3f) arrayList.get(0)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(0)).f287862y);
            this.f287860bb.put(((Vec3f) arrayList.get(14)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(14)).f287862y);
        }
        if (((Vec3f) arrayList.get(15)).f287863z > 0.0f && ((Vec3f) arrayList.get(0)).f287863z > 0.0f) {
            this.f287860bb.put(((Vec3f) arrayList.get(0)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(0)).f287862y);
            this.f287860bb.put(((Vec3f) arrayList.get(15)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(15)).f287862y);
        }
        if (((Vec3f) arrayList.get(15)).f287863z > 0.0f && ((Vec3f) arrayList.get(17)).f287863z > 0.0f) {
            this.f287860bb.put(((Vec3f) arrayList.get(17)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(17)).f287862y);
            this.f287860bb.put(((Vec3f) arrayList.get(15)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(15)).f287862y);
        }
        if (((Vec3f) arrayList.get(0)).f287863z > 0.0f && ((Vec3f) arrayList.get(1)).f287863z > 0.0f) {
            this.f287860bb.put(((Vec3f) arrayList.get(0)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(0)).f287862y);
            this.f287860bb.put(((Vec3f) arrayList.get(1)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(1)).f287862y);
        }
        if (((Vec3f) arrayList.get(2)).f287863z > 0.0f && ((Vec3f) arrayList.get(1)).f287863z > 0.0f) {
            this.f287860bb.put(((Vec3f) arrayList.get(2)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(2)).f287862y);
            this.f287860bb.put(((Vec3f) arrayList.get(1)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(1)).f287862y);
        }
        if (((Vec3f) arrayList.get(5)).f287863z > 0.0f && ((Vec3f) arrayList.get(1)).f287863z > 0.0f) {
            this.f287860bb.put(((Vec3f) arrayList.get(5)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(5)).f287862y);
            this.f287860bb.put(((Vec3f) arrayList.get(1)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(1)).f287862y);
        }
        if (((Vec3f) arrayList.get(2)).f287863z > 0.0f && ((Vec3f) arrayList.get(3)).f287863z > 0.0f) {
            this.f287860bb.put(((Vec3f) arrayList.get(2)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(2)).f287862y);
            this.f287860bb.put(((Vec3f) arrayList.get(3)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(3)).f287862y);
        }
        if (((Vec3f) arrayList.get(3)).f287863z > 0.0f && ((Vec3f) arrayList.get(4)).f287863z > 0.0f) {
            this.f287860bb.put(((Vec3f) arrayList.get(3)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(3)).f287862y);
            this.f287860bb.put(((Vec3f) arrayList.get(4)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(4)).f287862y);
        }
        if (((Vec3f) arrayList.get(5)).f287863z > 0.0f && ((Vec3f) arrayList.get(6)).f287863z > 0.0f) {
            this.f287860bb.put(((Vec3f) arrayList.get(5)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(5)).f287862y);
            this.f287860bb.put(((Vec3f) arrayList.get(6)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(6)).f287862y);
        }
        if (((Vec3f) arrayList.get(6)).f287863z > 0.0f && ((Vec3f) arrayList.get(7)).f287863z > 0.0f) {
            this.f287860bb.put(((Vec3f) arrayList.get(6)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(6)).f287862y);
            this.f287860bb.put(((Vec3f) arrayList.get(7)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(7)).f287862y);
        }
        if (((Vec3f) arrayList.get(1)).f287863z > 0.0f && ((Vec3f) arrayList.get(8)).f287863z > 0.0f) {
            this.f287860bb.put(((Vec3f) arrayList.get(1)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(1)).f287862y);
            this.f287860bb.put(((Vec3f) arrayList.get(8)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(8)).f287862y);
        }
        if (((Vec3f) arrayList.get(1)).f287863z > 0.0f && ((Vec3f) arrayList.get(11)).f287863z > 0.0f) {
            this.f287860bb.put(((Vec3f) arrayList.get(1)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(1)).f287862y);
            this.f287860bb.put(((Vec3f) arrayList.get(11)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(11)).f287862y);
        }
        if (((Vec3f) arrayList.get(1)).f287863z > 0.0f && ((Vec3f) arrayList.get(8)).f287863z > 0.0f && ((Vec3f) arrayList.get(11)).f287863z > 0.0f) {
            this.f287860bb.put(((Vec3f) arrayList.get(1)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(1)).f287862y);
            this.f287860bb.put((((Vec3f) arrayList.get(11)).f287861x + ((Vec3f) arrayList.get(8)).f287861x) / 2.0f);
            this.f287860bb.put((((Vec3f) arrayList.get(11)).f287862y + ((Vec3f) arrayList.get(8)).f287862y) / 2.0f);
        }
        if (((Vec3f) arrayList.get(8)).f287863z > 0.0f && ((Vec3f) arrayList.get(11)).f287863z > 0.0f) {
            this.f287860bb.put(((Vec3f) arrayList.get(8)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(8)).f287862y);
            this.f287860bb.put(((Vec3f) arrayList.get(11)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(11)).f287862y);
        }
        if (((Vec3f) arrayList.get(8)).f287863z > 0.0f && ((Vec3f) arrayList.get(9)).f287863z > 0.0f) {
            this.f287860bb.put(((Vec3f) arrayList.get(8)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(8)).f287862y);
            this.f287860bb.put(((Vec3f) arrayList.get(9)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(9)).f287862y);
        }
        if (((Vec3f) arrayList.get(10)).f287863z > 0.0f && ((Vec3f) arrayList.get(9)).f287863z > 0.0f) {
            this.f287860bb.put(((Vec3f) arrayList.get(10)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(10)).f287862y);
            this.f287860bb.put(((Vec3f) arrayList.get(9)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(9)).f287862y);
        }
        if (((Vec3f) arrayList.get(11)).f287863z > 0.0f && ((Vec3f) arrayList.get(12)).f287863z > 0.0f) {
            this.f287860bb.put(((Vec3f) arrayList.get(11)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(11)).f287862y);
            this.f287860bb.put(((Vec3f) arrayList.get(12)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(12)).f287862y);
        }
        if (((Vec3f) arrayList.get(13)).f287863z > 0.0f && ((Vec3f) arrayList.get(12)).f287863z > 0.0f) {
            this.f287860bb.put(((Vec3f) arrayList.get(13)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(13)).f287862y);
            this.f287860bb.put(((Vec3f) arrayList.get(12)).f287861x);
            this.f287860bb.put(((Vec3f) arrayList.get(12)).f287862y);
        }
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.testBuffer = asFloatBuffer2;
        asFloatBuffer2.position(0);
        if (((Vec3f) arrayList.get(2)).f287863z <= 0.0f || ((Vec3f) arrayList.get(3)).f287863z <= 0.0f) {
            return;
        }
        this.testBuffer.put(((Vec3f) arrayList.get(2)).f287861x);
        this.testBuffer.put(((Vec3f) arrayList.get(2)).f287862y);
        this.testBuffer.put((((Vec3f) arrayList.get(2)).f287861x + ((Vec3f) arrayList.get(3)).f287861x) / 2.0f);
        this.testBuffer.put((((Vec3f) arrayList.get(2)).f287862y + ((Vec3f) arrayList.get(3)).f287862y) / 2.0f);
    }
}
