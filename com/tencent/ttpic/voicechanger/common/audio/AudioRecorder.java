package com.tencent.ttpic.voicechanger.common.audio;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.ttpic.baseutils.api.ApiHelper;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;

/* compiled from: P */
@Deprecated
/* loaded from: classes27.dex */
public class AudioRecorder {
    public static final int ERROR_AUDIO_FILE_NOT_EXIST = 1;
    public static final int ERROR_AUDIO_ILLEGAL_ARGUMENT = 3;
    public static final int ERROR_AUDIO_INIT_AUDIORECORD_FAILED = 4;
    public static final int ERROR_AUDIO_OUT_OF_MEMORY = 2;
    public static final int ERROR_AUDIO_RECORD_READ_FAILED = 6;
    public static final int ERROR_AUDIO_RECORD_START_FAILED = 5;
    private static final String TAG = "AudioRecorder";
    private AudioRecord mARecorder;
    private AsyncPcmWriter mAsyncPcmWriter;
    private byte[] mBuffer;
    private int mDelay;
    private boolean mHasDelaySet;
    private int mHasRecordLength;
    private OnErrorListener mOnErrorListener;
    private String mPcmPath;
    private SimpleRecordThread mRecThread;
    private State mCurrentState = new State();
    private int mBufSize = AudioRecorderCompat.AUDIO_OUTPUT_BUFFER_SIZE;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class AsyncPcmWriter {
        private static final String T_TAG = "AudioRecorder.AsyncPcmWriter";
        private boolean canSave = true;
        private final LinkedList<byte[]> fileBuffers = new LinkedList<>();
        private Handler mHandler;
        private HandlerThread mHandlerThread;
        private RandomAccessFile mMicfile;
        private int perBufSize;

        public AsyncPcmWriter(String str, int i3) throws FileNotFoundException {
            this.mHandlerThread = null;
            this.mHandler = null;
            this.mMicfile = null;
            this.mHandlerThread = new BaseHandlerThread("ASYNC_PCM_WRITE");
            this.mHandler = new Handler(this.mHandlerThread.getLooper());
            FileUtils.delete(str);
            this.perBufSize = i3;
            this.mMicfile = new RandomAccessFile(str, "rw");
            for (int i16 = 0; i16 < 4; i16++) {
                this.fileBuffers.add(new byte[i3]);
            }
        }

        public void onRecord(byte[] bArr, final int i3) {
            final byte[] bArr2;
            if (!this.canSave) {
                return;
            }
            synchronized (this.fileBuffers) {
                if (this.fileBuffers.size() > 0) {
                    bArr2 = this.fileBuffers.peek();
                    this.fileBuffers.remove();
                } else {
                    bArr2 = new byte[this.perBufSize];
                }
            }
            System.arraycopy(bArr, 0, bArr2, 0, i3);
            this.mHandler.post(new Runnable() { // from class: com.tencent.ttpic.voicechanger.common.audio.AudioRecorder.AsyncPcmWriter.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        int i16 = i3 / 2;
                        short[] sArr = new short[i16];
                        ByteBuffer.wrap(bArr2).order(ByteOrder.BIG_ENDIAN).asShortBuffer().get(sArr);
                        for (int i17 = 0; i17 < i16; i17++) {
                            AsyncPcmWriter.this.mMicfile.writeShort(sArr[i17]);
                        }
                        synchronized (AsyncPcmWriter.this.fileBuffers) {
                            if (AsyncPcmWriter.this.fileBuffers.size() < 8) {
                                AsyncPcmWriter.this.fileBuffers.add(bArr2);
                            }
                        }
                    } catch (IOException e16) {
                        LogUtils.w(AudioRecorder.TAG, "", e16, new Object[0]);
                        AsyncPcmWriter.this.canSave = false;
                        try {
                            AsyncPcmWriter.this.mMicfile.close();
                        } catch (IOException e17) {
                            LogUtils.d(AudioRecorder.TAG, "can't close?", e17, new Object[0]);
                        }
                    } catch (Exception e18) {
                        LogUtils.d(AudioRecorder.TAG, "onRecord ERROR: ", e18, new Object[0]);
                        try {
                            AsyncPcmWriter.this.mMicfile.close();
                        } catch (IOException e19) {
                            LogUtils.d(AudioRecorder.TAG, "can't close?", e19, new Object[0]);
                        }
                    }
                }
            });
        }

        public void onStop() {
            this.mHandler.post(new Runnable() { // from class: com.tencent.ttpic.voicechanger.common.audio.AudioRecorder.AsyncPcmWriter.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AsyncPcmWriter.this.canSave) {
                        try {
                            AsyncPcmWriter.this.mMicfile.close();
                        } catch (IOException e16) {
                            LogUtils.d(AudioRecorder.TAG, "can't close?", e16, new Object[0]);
                        }
                    }
                    if (AsyncPcmWriter.this.mHandlerThread != null) {
                        if (ApiHelper.hasJellyBeanMR2()) {
                            AsyncPcmWriter.this.mHandlerThread.quitSafely();
                        } else {
                            AsyncPcmWriter.this.mHandlerThread.quit();
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class SimpleRecordThread extends BaseThread {
        private static final String TAG = "SimpleRecordThread";

        public SimpleRecordThread(String str) {
            super(str);
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            LogUtils.i(TAG, getName() + " begin");
            while (true) {
                synchronized (AudioRecorder.this.mCurrentState) {
                    if (AudioRecorder.this.mCurrentState.equalState(2)) {
                        LogUtils.i(TAG, getName() + " wait, " + AudioRecorder.this.mCurrentState);
                        try {
                            LockMethodProxy.wait(AudioRecorder.this.mCurrentState);
                        } catch (InterruptedException e16) {
                            LogUtils.w(TAG, "", e16, new Object[0]);
                        }
                        LogUtils.i(TAG, getName() + " continue, " + AudioRecorder.this.mCurrentState);
                    }
                }
                synchronized (AudioRecorder.this.mCurrentState) {
                    if (AudioRecorder.this.mCurrentState.equalState(8)) {
                        if (AudioRecorder.this.mARecorder.getRecordingState() == 3) {
                            LogUtils.d(TAG, "AudioRecord.stop, " + AudioRecorder.this.mCurrentState);
                            AudioRecorder.this.mARecorder.stop();
                        }
                        LogUtils.i(TAG, getName() + " wait, " + AudioRecorder.this.mCurrentState);
                        try {
                            LockMethodProxy.wait(AudioRecorder.this.mCurrentState);
                        } catch (InterruptedException e17) {
                            LogUtils.w(TAG, "", e17, new Object[0]);
                        }
                        LogUtils.i(TAG, getName() + " continue, " + AudioRecorder.this.mCurrentState);
                    }
                }
                if (AudioRecorder.this.mCurrentState.equalState(16, 0)) {
                    break;
                }
                if (AudioRecorder.this.mCurrentState.equalState(4)) {
                    if (AudioRecorder.this.mARecorder.getRecordingState() == 1) {
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            AudioMonitor.startRecording(AudioRecorder.this.mARecorder);
                            LogUtils.d(TAG, "AudioRecord.startRecording, " + (System.currentTimeMillis() - currentTimeMillis) + ", " + AudioRecorder.this.mCurrentState);
                            if (AudioRecorder.this.mARecorder.getRecordingState() == 1) {
                                LogUtils.e(TAG, "startRecording failed");
                                AudioRecorder.this.onRecordError(5);
                                AudioRecorder.this.mCurrentState.transfer(0);
                            } else if (!AudioRecorder.this.mHasDelaySet) {
                                AudioRecorder.this.mDelay = (int) (System.currentTimeMillis() - currentTimeMillis);
                                LogUtils.i(TAG, "AudioRecord, delay: " + AudioRecorder.this.mDelay);
                                AudioRecorder audioRecorder = AudioRecorder.this;
                                audioRecorder.onDelaySet(audioRecorder.mDelay);
                                AudioRecorder.this.mHasDelaySet = true;
                            }
                        } catch (SecurityException e18) {
                            LogUtils.w(TAG, "AudioRecord.startRecording failed", e18, new Object[0]);
                            AudioRecorder.this.onRecordError(5);
                            AudioRecorder.this.mCurrentState.transfer(0);
                        }
                    }
                    int read = AudioRecorder.this.mARecorder.read(AudioRecorder.this.mBuffer, 0, AudioRecorderCompat.AUDIO_INPUT_BUFFER_SIZE);
                    if (read != -3 && read != -2 && read > 0) {
                        AudioRecorder.this.mHasRecordLength += read;
                        AudioRecorder audioRecorder2 = AudioRecorder.this;
                        audioRecorder2.onRecording(audioRecorder2.mBuffer, read);
                    } else {
                        LogUtils.e(TAG, "AudioRecord read return count = " + read);
                        AudioRecorder.this.onRecordError(6);
                        AudioRecorder.this.mCurrentState.transfer(0);
                    }
                }
            }
            if (AudioRecorder.this.mARecorder.getRecordingState() == 3) {
                LogUtils.d(TAG, "AudioRecord.stop, " + AudioRecorder.this.mCurrentState);
                AudioRecorder.this.mARecorder.stop();
            }
            AudioRecorder.this.onRecordStop();
            AudioRecorder.this.mOnErrorListener = null;
            LogUtils.i(TAG, getName() + " exit");
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class State {
        public static final int STATE_ERROR = 0;
        public static final int STATE_IDLE = 1;
        public static final int STATE_INITIALIZED = 2;
        public static final int STATE_PAUSED = 8;
        public static final int STATE_STARTED = 4;
        public static final int STATE_STOPPED = 16;
        private int state = 1;

        public State() {
        }

        public synchronized boolean equalState(int... iArr) {
            boolean z16;
            z16 = false;
            int i3 = 0;
            for (int i16 : iArr) {
                i3 |= i16;
            }
            if ((this.state & i3) != 0) {
                z16 = true;
            }
            return z16;
        }

        public synchronized int state() {
            return this.state;
        }

        public String toString() {
            return "State[" + this.state + "]";
        }

        public synchronized void transfer(int i3) {
            LogUtils.i(AudioRecorder.TAG, "switch state: " + this.state + " -> " + i3);
            this.state = i3;
            AudioRecorder.this.mCurrentState.notifyAll();
        }
    }

    public AudioRecorder(String str) {
        this.mPcmPath = str;
    }

    public int getDelay() {
        return this.mDelay;
    }

    public int init() {
        this.mBufSize = AudioRecord.getMinBufferSize(AudioRecorderCompat.AUDIO_SAMPLE_RATE_IN_HZ, 16, 2);
        String str = TAG;
        LogUtils.d(str, "init() - AudioRecord.getMinBufferSize = " + this.mBufSize);
        int i3 = this.mBufSize;
        int i16 = AudioRecorderCompat.AUDIO_OUTPUT_BUFFER_SIZE;
        if (i3 <= i16) {
            this.mBufSize = i16;
        }
        try {
            this.mBuffer = new byte[this.mBufSize];
            try {
                AudioRecord audioRecord = new AudioRecord(1, AudioRecorderCompat.AUDIO_SAMPLE_RATE_IN_HZ, AudioRecorderCompat.AUDIO_CHANNEL_COUNT * 16, 2, this.mBufSize);
                this.mARecorder = audioRecord;
                if (audioRecord.getState() != 1) {
                    LogUtils.e(str, "AudioRecord is not STATE_INITIALIZED");
                    this.mCurrentState.transfer(0);
                    return 4;
                }
                if (this.mARecorder.getRecordingState() == 1) {
                    try {
                        AudioMonitor.startRecording(this.mARecorder);
                    } catch (SecurityException e16) {
                        LogUtils.w(TAG, "AudioRecord.startRecording failed", e16, new Object[0]);
                        this.mCurrentState.transfer(0);
                        return 5;
                    }
                }
                if (this.mARecorder.getRecordingState() == 3) {
                    this.mARecorder.stop();
                }
                this.mCurrentState.transfer(2);
                try {
                    this.mAsyncPcmWriter = new AsyncPcmWriter(this.mPcmPath, AudioRecorderCompat.AUDIO_INPUT_BUFFER_SIZE);
                    SimpleRecordThread simpleRecordThread = new SimpleRecordThread("AudioRecorder.RecordThread-" + System.currentTimeMillis());
                    this.mRecThread = simpleRecordThread;
                    simpleRecordThread.start();
                    return 0;
                } catch (FileNotFoundException e17) {
                    LogUtils.e(TAG, e17.getMessage());
                    this.mCurrentState.transfer(0);
                    return 1;
                }
            } catch (IllegalArgumentException e18) {
                LogUtils.e(TAG, "Recorder init error:", e18, new Object[0]);
                this.mCurrentState.transfer(0);
                return 3;
            }
        } catch (OutOfMemoryError e19) {
            LogUtils.e(TAG, e19.getMessage());
            this.mCurrentState.transfer(0);
            return 2;
        }
    }

    public void onRecordError(int i3) {
        OnErrorListener onErrorListener = this.mOnErrorListener;
        if (onErrorListener != null) {
            onErrorListener.onError(i3);
        }
    }

    public void onRecordStop() {
        AsyncPcmWriter asyncPcmWriter = this.mAsyncPcmWriter;
        if (asyncPcmWriter != null) {
            asyncPcmWriter.onStop();
        }
    }

    public void onRecording(byte[] bArr, int i3) {
        AsyncPcmWriter asyncPcmWriter = this.mAsyncPcmWriter;
        if (asyncPcmWriter != null) {
            asyncPcmWriter.onRecord(bArr, i3);
        }
    }

    public void pause() {
        String str = TAG;
        LogUtils.d(str, "pause");
        synchronized (this.mCurrentState) {
            if (this.mCurrentState.equalState(8)) {
                LogUtils.d(str, "current state has been 8");
            } else {
                if (this.mCurrentState.equalState(4, 2)) {
                    this.mCurrentState.transfer(8);
                    return;
                }
                throw new IllegalStateException("current status is: " + this.mCurrentState);
            }
        }
    }

    public void release() {
        String str = TAG;
        LogUtils.d(str, "release start");
        synchronized (this.mCurrentState) {
            if (!this.mCurrentState.equalState(16)) {
                LogUtils.i(str, "stop() is forgotten by someone, so call it now!");
                stop();
            }
            this.mCurrentState.transfer(1);
        }
        this.mHasRecordLength = 0;
        SimpleRecordThread simpleRecordThread = this.mRecThread;
        if (simpleRecordThread != null && !simpleRecordThread.equals(Thread.currentThread())) {
            try {
                this.mRecThread.join();
            } catch (InterruptedException e16) {
                LogUtils.e(TAG, e16.getMessage());
                this.mRecThread = null;
            }
        }
        AudioRecord audioRecord = this.mARecorder;
        if (audioRecord != null) {
            audioRecord.release();
        }
        String str2 = TAG;
        LogUtils.d(str2, "AduioRecord release finish");
        this.mHasRecordLength = 0;
        LogUtils.d(str2, "release finish");
    }

    public void resume() {
        LogUtils.d(TAG, "resume, delegate to start");
        start();
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void start() {
        String str = TAG;
        LogUtils.d(str, "start");
        synchronized (this.mCurrentState) {
            if (this.mCurrentState.equalState(4)) {
                LogUtils.w(str, "current state has been 4");
            } else {
                if (this.mCurrentState.equalState(8, 2)) {
                    this.mCurrentState.transfer(4);
                    return;
                }
                throw new IllegalStateException("current status is: " + this.mCurrentState);
            }
        }
    }

    public void stop() {
        String str = TAG;
        LogUtils.d(str, "stop");
        synchronized (this.mCurrentState) {
            if (this.mCurrentState.equalState(16)) {
                LogUtils.d(str, "current state has been 16");
                return;
            }
            this.mCurrentState.transfer(16);
            SimpleRecordThread simpleRecordThread = this.mRecThread;
            if (simpleRecordThread != null && !simpleRecordThread.equals(Thread.currentThread())) {
                try {
                    this.mRecThread.join();
                } catch (InterruptedException e16) {
                    LogUtils.e(TAG, e16.getMessage());
                }
                this.mRecThread = null;
            }
        }
    }

    public void onDelaySet(int i3) {
    }
}
