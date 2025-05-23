package com.tencent.superplayer.framecheck;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.superplayer.utils.BitmapHashUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

/* loaded from: classes26.dex */
public class FrameComparePipeLine {
    public static final int BLACK_SCREEN_HASH = -2;
    public static final int HAMMING_DISTANCE_LIMIT = 0;
    private static final String TAG = "SuperPlayer-.FrameComparePipeLine";
    private Handler mHandler;
    private Queue<VideoFrameCaptureTask> mQueue = new ArrayDeque();
    private HandlerThread mHandlerThread = new BaseHandlerThread("FrameComparePipeLine");
    private Random mRandom = new Random();
    private List<TaskResult> mTaskResultList = new ArrayList();
    private OnVideoFrameCheckListener mOnVideoFrameCheckListener = null;

    /* loaded from: classes26.dex */
    public interface OnVideoFrameCheckListener {
        void onVideoFrameCheckResult(int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class TaskResult {
        public static final int BLACK_SCREEN = 2;
        public static final int FRAME_SAME = 3;
        public static final int TASK_PASS = 0;
        public static final int TEXTUREVIEW_NOT_AVAILABLE = 5;
        public static final int TEXTUREVIEW_NULL = 4;
        public static final int TRANS_SCREEN = 1;
        public boolean isBlack;
        public boolean isTransparent;
        public long pHash;

        TaskResult() {
        }

        public String toString() {
            return "TaskResult{isBlack=" + this.isBlack + ", isTransparent=" + this.isTransparent + ", pHash=" + this.pHash + '}';
        }
    }

    public FrameComparePipeLine() {
        this.mHandlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
    }

    private boolean checkBitmapIsColor(Bitmap bitmap, int i3) {
        int min = Math.min(Math.min(bitmap.getWidth(), bitmap.getHeight()), 32);
        for (int i16 = 0; i16 < min; i16++) {
            if (bitmap.getPixel(i16, this.mRandom.nextInt(min)) != i3) {
                return false;
            }
        }
        return true;
    }

    private int checkTaskResultList() {
        TaskResult taskResult = null;
        boolean z16 = true;
        boolean z17 = true;
        boolean z18 = true;
        for (TaskResult taskResult2 : this.mTaskResultList) {
            if (z17 && taskResult2.isBlack) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z16 && taskResult2.isTransparent) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (taskResult != null) {
                if (z18 && BitmapHashUtil.hammingDistance(taskResult2.pHash, taskResult.pHash) <= 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
            }
            taskResult = taskResult2;
        }
        if (z16) {
            return 1;
        }
        if (z17) {
            return 2;
        }
        if (!z18) {
            return 0;
        }
        return 3;
    }

    private void fetchOneTaskAndRun() {
        final VideoFrameCaptureTask poll = this.mQueue.poll();
        final boolean isEmpty = this.mQueue.isEmpty();
        if (poll != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.superplayer.framecheck.FrameComparePipeLine.2
                @Override // java.lang.Runnable
                public void run() {
                    FrameComparePipeLine.this.innerHandleTask(poll, isEmpty);
                }
            }, poll.getTaskDelay());
        }
    }

    private String getResultListStr() {
        StringBuilder sb5 = new StringBuilder("mTaskResultList:");
        for (TaskResult taskResult : this.mTaskResultList) {
            sb5.append("\n");
            sb5.append(taskResult);
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerHandleTask(VideoFrameCaptureTask videoFrameCaptureTask, boolean z16) {
        runTask(videoFrameCaptureTask);
        fetchOneTaskAndRun();
        if (videoFrameCaptureTask.isEndTask) {
            int checkTaskResultList = checkTaskResultList();
            LogUtil.d(TAG, "checkTaskResultList resultCode:" + checkTaskResultList + "\n" + getResultListStr());
            OnVideoFrameCheckListener onVideoFrameCheckListener = this.mOnVideoFrameCheckListener;
            if (onVideoFrameCheckListener != null) {
                onVideoFrameCheckListener.onVideoFrameCheckResult(checkTaskResultList);
                return;
            }
            return;
        }
        if (z16) {
            LogUtil.w(TAG, "No end task, when mQueue is empty.");
        }
    }

    private void onTaskException() {
        this.mTaskResultList.clear();
    }

    private void runTask(VideoFrameCaptureTask videoFrameCaptureTask) {
        Bitmap doTask = videoFrameCaptureTask.doTask();
        if (doTask == null) {
            onTaskException();
            return;
        }
        TaskResult taskResult = new TaskResult();
        if (checkBitmapIsColor(doTask, 0)) {
            LogUtil.d(TAG, "checkTransparentBitmap unPass, " + videoFrameCaptureTask);
            taskResult.isTransparent = true;
        }
        try {
            taskResult.pHash = BitmapHashUtil.dctImageHash(doTask, true);
        } catch (IOException e16) {
            LogUtil.e(TAG, "dctImageHash exception", e16);
        }
        if (BitmapHashUtil.hammingDistance(-2L, taskResult.pHash) == 0) {
            LogUtil.d(TAG, "checkBlackBitmap unPass, " + videoFrameCaptureTask);
            taskResult.isBlack = true;
        }
        this.mTaskResultList.add(taskResult);
        if (!doTask.isRecycled()) {
            doTask.recycle();
        }
    }

    public void addTask(VideoFrameCaptureTask videoFrameCaptureTask) {
        if (videoFrameCaptureTask instanceof FirstFrameCaptureTask) {
            ArrayList arrayList = new ArrayList(this.mQueue);
            this.mQueue.clear();
            this.mQueue.add(videoFrameCaptureTask);
            this.mQueue.addAll(arrayList);
            return;
        }
        this.mQueue.add(videoFrameCaptureTask);
    }

    public void release() {
        this.mHandlerThread.quitSafely();
    }

    public void reset() {
        this.mHandler.removeCallbacks(null);
        this.mQueue.clear();
        this.mHandler.post(new Runnable() { // from class: com.tencent.superplayer.framecheck.FrameComparePipeLine.1
            @Override // java.lang.Runnable
            public void run() {
                FrameComparePipeLine.this.mTaskResultList.clear();
            }
        });
    }

    public void setOnVideoFrameCheckListener(OnVideoFrameCheckListener onVideoFrameCheckListener) {
        this.mOnVideoFrameCheckListener = onVideoFrameCheckListener;
    }

    public void start() {
        LogUtil.d(TAG, "start");
        fetchOneTaskAndRun();
    }

    public void stop() {
        reset();
    }
}
