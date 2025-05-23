package com.tencent.av.video.effect.core;

import android.opengl.GLES20;
import com.tencent.av.video.effect.utils.CommonUtils;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes3.dex */
public class BaseRender {
    private static final String TAG = "BaseRender";
    private final Queue<Runnable> mTaskListBeforeProcess = new LinkedList();
    protected int mWidth = 0;
    protected int mHeight = 0;
    protected int mOutTextureId = -1;
    protected int mOutFbo = -1;

    private void runAll(Queue<Runnable> queue) {
        synchronized (queue) {
            while (!queue.isEmpty()) {
                queue.poll().run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addTaskBeforeProcess(Runnable runnable) {
        synchronized (this.mTaskListBeforeProcess) {
            this.mTaskListBeforeProcess.add(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void baseProcess(int i3, int i16) {
        runAllTaskBeforeProcess();
        onSizeChange(i3, i16);
    }

    public void destroy() {
        this.mWidth = 0;
        this.mHeight = 0;
        int i3 = this.mOutTextureId;
        if (i3 != -1) {
            GLES20.glDeleteTextures(1, new int[]{i3}, 0);
            this.mOutTextureId = -1;
        }
        int i16 = this.mOutFbo;
        if (i16 != -1) {
            GLES20.glDeleteFramebuffers(1, new int[]{i16}, 0);
            this.mOutFbo = -1;
        }
    }

    protected void onSizeChange(int i3, int i16) {
        if (this.mWidth != i3 || this.mHeight != i16) {
            this.mWidth = i3;
            this.mHeight = i16;
            int i17 = this.mOutTextureId;
            if (i17 != -1) {
                GLES20.glDeleteTextures(1, new int[]{i17}, 0);
                this.mOutTextureId = -1;
            }
            int i18 = this.mOutFbo;
            if (i18 != -1) {
                GLES20.glDeleteFramebuffers(1, new int[]{i18}, 0);
                this.mOutFbo = -1;
            }
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i19 = iArr[0];
            this.mOutTextureId = i19;
            this.mOutFbo = CommonUtils.initFrameBuffer(this.mWidth, this.mHeight, i19);
        }
    }

    public EffectTexture process(int i3, int i16, int i17, int i18) {
        baseProcess(i17, i18);
        return new EffectTexture(i3, i16, this.mWidth, this.mHeight);
    }

    protected void runAllTaskBeforeProcess() {
        runAll(this.mTaskListBeforeProcess);
    }
}
