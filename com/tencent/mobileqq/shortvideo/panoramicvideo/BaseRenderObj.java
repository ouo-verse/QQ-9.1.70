package com.tencent.mobileqq.shortvideo.panoramicvideo;

import android.opengl.GLES20;
import com.tencent.mobileqq.shortvideo.panoramicvideo.GL.FBO;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class BaseRenderObj {
    protected static final String TAG = "BaseRenderObj";
    private final LinkedList<Runnable> mPreDrawTaskList = new LinkedList<>();
    protected int surfaceHeight;
    protected int surfaceWidth;

    public void addPreDrawTask(Runnable runnable) {
        synchronized (this.mPreDrawTaskList) {
            this.mPreDrawTaskList.addLast(runnable);
        }
    }

    public FBO createFBO() {
        return FBO.newInstance().create(this.surfaceWidth, this.surfaceHeight);
    }

    public abstract void destroy();

    public abstract void init();

    public abstract void onDrawFrame(int i3);

    public void onPreDrawElements() {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
    }

    public void onRenderObjChanged(int i3, int i16) {
        this.surfaceWidth = i3;
        this.surfaceHeight = i16;
    }

    public void runPreDrawTasks() {
        while (!this.mPreDrawTaskList.isEmpty()) {
            this.mPreDrawTaskList.removeFirst().run();
        }
    }

    public void setUniform1f(int i3, String str, float f16) {
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i3, str), f16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setViewport() {
        GLES20.glViewport(0, 0, this.surfaceWidth, this.surfaceHeight);
    }
}
