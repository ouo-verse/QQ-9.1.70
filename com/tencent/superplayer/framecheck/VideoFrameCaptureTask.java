package com.tencent.superplayer.framecheck;

import android.graphics.Bitmap;
import com.tencent.superplayer.utils.LogUtil;

/* compiled from: P */
/* loaded from: classes26.dex */
public class VideoFrameCaptureTask {
    public static final String TAG = "SuperPlayer-.VideoFrameCaptureTask";
    public static final int TARGET_BITMAP_LENGTH = 32;
    public static final int TASK_INTERVAL = 1000;
    public boolean isEndTask;
    private IFrameCaptureTaskRunner mTaskRunner;

    public VideoFrameCaptureTask(IFrameCaptureTaskRunner iFrameCaptureTaskRunner) {
        this(iFrameCaptureTaskRunner, false);
    }

    public Bitmap doTask() {
        IFrameCaptureTaskRunner iFrameCaptureTaskRunner = this.mTaskRunner;
        if (iFrameCaptureTaskRunner == null) {
            return null;
        }
        try {
            return iFrameCaptureTaskRunner.doCapture(32, 32);
        } catch (Throwable th5) {
            LogUtil.e(TAG, "doTask error," + th5.getLocalizedMessage());
            return null;
        }
    }

    public int getTaskDelay() {
        return 1000;
    }

    public VideoFrameCaptureTask(IFrameCaptureTaskRunner iFrameCaptureTaskRunner, boolean z16) {
        this.mTaskRunner = iFrameCaptureTaskRunner;
        this.isEndTask = z16;
    }
}
