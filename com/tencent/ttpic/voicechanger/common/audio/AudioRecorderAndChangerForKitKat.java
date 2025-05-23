package com.tencent.ttpic.voicechanger.common.audio;

import android.media.AudioRecord;
import android.os.Handler;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;

/* compiled from: P */
@Deprecated
/* loaded from: classes27.dex */
public class AudioRecorderAndChangerForKitKat extends AudioRecorderCompat {
    public static final int AUDIO_BIT_RATE;
    public static final int AUDIO_CHANNEL_COUNT = 1;
    public static final int AUDIO_INPUT_BUFFER_SIZE;
    public static final int AUDIO_OUTPUT_BUFFER_SIZE;
    public static final int AUDIO_SAMPLE_RATE_IN_HZ;
    public static final int[] BIT_RATES;
    public static final int ERROR_AUDIO_FILE_NOT_EXIST = 1;
    public static final int ERROR_AUDIO_ILLEGAL_ARGUMENT = 3;
    public static final int ERROR_AUDIO_INIT_AUDIORECORD_FAILED = 4;
    public static final int ERROR_AUDIO_OUT_OF_MEMORY = 2;
    public static final int ERROR_AUDIO_RECORD_READ_FAILED = 6;
    public static final int ERROR_AUDIO_RECORD_START_FAILED = 5;
    public static final int[] SAMPLE_RATES;
    protected AudioRecord mARecorder;
    protected AsyncPcmWriterForKitKat mAsyncPcmWriter;
    protected int mBufSize;
    protected byte[] mBuffer;
    protected State mCurrentState;
    protected int mDelay;
    protected boolean mHasDelaySet;
    protected int mHasRecordLength;
    protected OnErrorListener mOnErrorListener;
    protected RealTimePcmPacker mPcmPacker;
    protected String mPcmPath;
    protected SimpleRecordThreadForKitKat mRecThread;
    protected VoiceChanger mVoiceChanger;
    protected boolean needVoiceChange;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class AsyncPcmWriterForKitKat extends BaseHandlerThread {
        protected static final String T_TAG = "AudioRecorder.AsyncPcmWriterForKitKat";
        protected boolean canSave;
        protected final LinkedList<byte[]> fileBuffers;
        protected Handler mHandler;
        protected RandomAccessFile mMicfile;
        protected int perBufSize;

        public AsyncPcmWriterForKitKat(String str, int i3) throws FileNotFoundException {
            super("AsyncPcmWriterForKitKat-" + System.currentTimeMillis());
            this.mHandler = null;
            this.mMicfile = null;
            this.canSave = true;
            this.fileBuffers = new LinkedList<>();
            FileUtils.delete(str);
            this.perBufSize = i3;
            this.mMicfile = new RandomAccessFile(str, "rw");
            start();
            this.mHandler = new Handler(getLooper());
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
            this.mHandler.post(new Runnable() { // from class: com.tencent.ttpic.voicechanger.common.audio.AudioRecorderAndChangerForKitKat.AsyncPcmWriterForKitKat.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        long currentTimeMillis = System.currentTimeMillis();
                        AsyncPcmWriterForKitKat asyncPcmWriterForKitKat = AsyncPcmWriterForKitKat.this;
                        AudioRecorderAndChangerForKitKat audioRecorderAndChangerForKitKat = AudioRecorderAndChangerForKitKat.this;
                        if (audioRecorderAndChangerForKitKat.needVoiceChange && audioRecorderAndChangerForKitKat.mVoiceChanger != null) {
                            short[] sArr = new short[i3 / 2];
                            ByteBuffer.wrap(bArr2).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(sArr);
                            byte[] writeVoiceFrames = AudioRecorderAndChangerForKitKat.this.mVoiceChanger.writeVoiceFrames(sArr);
                            if (writeVoiceFrames != null) {
                                AsyncPcmWriterForKitKat.this.mMicfile.write(writeVoiceFrames, 0, writeVoiceFrames.length);
                            } else {
                                throw new Exception("frames is null");
                            }
                        } else {
                            RandomAccessFile randomAccessFile = asyncPcmWriterForKitKat.mMicfile;
                            byte[] bArr3 = bArr2;
                            randomAccessFile.write(bArr3, 0, bArr3.length);
                        }
                        LogUtils.d(AudioRecorderCompat.TAG, "Process 1 recorded frame: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                        synchronized (AsyncPcmWriterForKitKat.this.fileBuffers) {
                            if (AsyncPcmWriterForKitKat.this.fileBuffers.size() < 8) {
                                AsyncPcmWriterForKitKat.this.fileBuffers.add(bArr2);
                            }
                        }
                    } catch (IOException e16) {
                        LogUtils.w(AudioRecorderCompat.TAG, "", e16, new Object[0]);
                        AsyncPcmWriterForKitKat asyncPcmWriterForKitKat2 = AsyncPcmWriterForKitKat.this;
                        asyncPcmWriterForKitKat2.canSave = false;
                        try {
                            asyncPcmWriterForKitKat2.mMicfile.close();
                        } catch (IOException e17) {
                            LogUtils.d(AudioRecorderCompat.TAG, "can't close?", e17, new Object[0]);
                        }
                    } catch (Exception e18) {
                        LogUtils.d(AudioRecorderCompat.TAG, "onRecord ERROR: ", e18, new Object[0]);
                        try {
                            AsyncPcmWriterForKitKat.this.mMicfile.close();
                        } catch (IOException e19) {
                            LogUtils.d(AudioRecorderCompat.TAG, "can't close?", e19, new Object[0]);
                        }
                    }
                }
            });
        }

        public void onStop() {
            this.mHandler.post(new Runnable() { // from class: com.tencent.ttpic.voicechanger.common.audio.AudioRecorderAndChangerForKitKat.AsyncPcmWriterForKitKat.2
                @Override // java.lang.Runnable
                public void run() {
                    AudioRecorderAndChangerForKitKat.this.tryReleaseChanger();
                    AsyncPcmWriterForKitKat asyncPcmWriterForKitKat = AsyncPcmWriterForKitKat.this;
                    if (asyncPcmWriterForKitKat.canSave) {
                        try {
                            asyncPcmWriterForKitKat.mMicfile.close();
                        } catch (IOException e16) {
                            LogUtils.d(AudioRecorderCompat.TAG, "can't close?", e16, new Object[0]);
                        }
                    }
                    AudioRecorderCompat.AudioListener audioListener = AudioRecorderAndChangerForKitKat.this.mListener;
                    if (audioListener != null) {
                        audioListener.onAudioRecordFinish();
                        AudioRecorderAndChangerForKitKat.this.mListener = null;
                    }
                    AsyncPcmWriterForKitKat.this.quit();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class SimpleRecordThreadForKitKat extends BaseThread {
        protected static final String TAG = "SimpleRecordThread";

        public SimpleRecordThreadForKitKat(String str) {
            super(str);
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            LogUtils.i(TAG, getName() + " begin");
            while (true) {
                synchronized (AudioRecorderAndChangerForKitKat.this.mCurrentState) {
                    if (AudioRecorderAndChangerForKitKat.this.mCurrentState.equalState(4)) {
                        LogUtils.d(TAG, "run() - State.STATE_INITIALIZED");
                        LogUtils.i(TAG, getName() + " wait, " + AudioRecorderAndChangerForKitKat.this.mCurrentState);
                        try {
                            LockMethodProxy.wait(AudioRecorderAndChangerForKitKat.this.mCurrentState);
                        } catch (InterruptedException e16) {
                            LogUtils.w(TAG, "", e16, new Object[0]);
                        }
                        LogUtils.i(TAG, getName() + " continue, " + AudioRecorderAndChangerForKitKat.this.mCurrentState);
                    }
                }
                synchronized (AudioRecorderAndChangerForKitKat.this.mCurrentState) {
                    if (AudioRecorderAndChangerForKitKat.this.mCurrentState.equalState(16)) {
                        LogUtils.d(TAG, "run() - State.STATE_PAUSED");
                        if (AudioRecorderAndChangerForKitKat.this.mARecorder.getRecordingState() == 3) {
                            LogUtils.d(TAG, "AudioRecord.stop, " + AudioRecorderAndChangerForKitKat.this.mCurrentState);
                            AudioRecorderAndChangerForKitKat.this.mARecorder.stop();
                        }
                        LogUtils.i(TAG, getName() + " wait, " + AudioRecorderAndChangerForKitKat.this.mCurrentState);
                        try {
                            LockMethodProxy.wait(AudioRecorderAndChangerForKitKat.this.mCurrentState);
                        } catch (InterruptedException e17) {
                            LogUtils.w(TAG, "", e17, new Object[0]);
                        }
                        LogUtils.i(TAG, getName() + " continue, " + AudioRecorderAndChangerForKitKat.this.mCurrentState);
                    }
                }
                if (AudioRecorderAndChangerForKitKat.this.mCurrentState.equalState(32, 1)) {
                    break;
                }
                if (AudioRecorderAndChangerForKitKat.this.mCurrentState.equalState(8)) {
                    LogUtils.d(TAG, "run() - State.STATE_STARTED");
                    if (AudioRecorderAndChangerForKitKat.this.mARecorder.getRecordingState() == 1) {
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            AudioMonitor.startRecording(AudioRecorderAndChangerForKitKat.this.mARecorder);
                            LogUtils.d(TAG, "AudioRecord.startRecording, " + (System.currentTimeMillis() - currentTimeMillis) + ", " + AudioRecorderAndChangerForKitKat.this.mCurrentState);
                        } catch (SecurityException e18) {
                            LogUtils.w(TAG, "AudioRecord.startRecording failed", e18, new Object[0]);
                            AudioRecorderAndChangerForKitKat.this.onRecordError(5);
                            AudioRecorderAndChangerForKitKat.this.mCurrentState.transfer(1);
                        }
                        if (AudioRecorderAndChangerForKitKat.this.mARecorder.getRecordingState() == 1) {
                            LogUtils.e(TAG, "startRecording failed");
                            AudioRecorderAndChangerForKitKat.this.onRecordError(5);
                            AudioRecorderAndChangerForKitKat.this.mCurrentState.transfer(1);
                        } else {
                            AudioRecorderAndChangerForKitKat audioRecorderAndChangerForKitKat = AudioRecorderAndChangerForKitKat.this;
                            if (!audioRecorderAndChangerForKitKat.mHasDelaySet) {
                                audioRecorderAndChangerForKitKat.mDelay = (int) (System.currentTimeMillis() - currentTimeMillis);
                                LogUtils.i(TAG, "AudioRecord, delay: " + AudioRecorderAndChangerForKitKat.this.mDelay);
                                AudioRecorderAndChangerForKitKat audioRecorderAndChangerForKitKat2 = AudioRecorderAndChangerForKitKat.this;
                                audioRecorderAndChangerForKitKat2.onDelaySet(audioRecorderAndChangerForKitKat2.mDelay);
                                AudioRecorderAndChangerForKitKat.this.mHasDelaySet = true;
                            }
                        }
                    }
                    AudioRecorderAndChangerForKitKat audioRecorderAndChangerForKitKat3 = AudioRecorderAndChangerForKitKat.this;
                    int read = audioRecorderAndChangerForKitKat3.mARecorder.read(audioRecorderAndChangerForKitKat3.mBuffer, 0, AudioRecorderAndChangerForKitKat.AUDIO_INPUT_BUFFER_SIZE);
                    if (read != -3 && read != -2 && read > 0) {
                        AudioRecorderAndChangerForKitKat audioRecorderAndChangerForKitKat4 = AudioRecorderAndChangerForKitKat.this;
                        audioRecorderAndChangerForKitKat4.mHasRecordLength += read;
                        audioRecorderAndChangerForKitKat4.onRecording(audioRecorderAndChangerForKitKat4.mBuffer, read);
                    } else {
                        LogUtils.e(TAG, "AudioRecord read return count = " + read);
                        AudioRecorderAndChangerForKitKat.this.onRecordError(6);
                        AudioRecorderAndChangerForKitKat.this.mCurrentState.transfer(1);
                    }
                }
                LogUtils.d(TAG, "run() - currentState = " + AudioRecorderAndChangerForKitKat.this.mCurrentState);
            }
            LogUtils.d(TAG, "run() - State.STATE_STOPPED || State.STATE_ERROR");
            if (AudioRecorderAndChangerForKitKat.this.mARecorder.getRecordingState() == 3) {
                LogUtils.d(TAG, "AudioRecord.stop, " + AudioRecorderAndChangerForKitKat.this.mCurrentState);
                AudioRecorderAndChangerForKitKat.this.mARecorder.stop();
            }
            AudioRecorderAndChangerForKitKat.this.onRecordStop();
            AudioRecorderAndChangerForKitKat.this.mOnErrorListener = null;
            LogUtils.i(TAG, getName() + " exit");
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class State {
        public static final int STATE_ERROR = 1;
        public static final int STATE_IDLE = 2;
        public static final int STATE_INITIALIZED = 4;
        public static final int STATE_PAUSED = 16;
        public static final int STATE_STARTED = 8;
        public static final int STATE_STOPPED = 32;
        protected int state = 2;

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
            LogUtils.i(AudioRecorderCompat.TAG, "switch state: " + this.state + " -> " + i3);
            this.state = i3;
            AudioRecorderAndChangerForKitKat.this.mCurrentState.notifyAll();
        }
    }

    static {
        int[] iArr = {8000, 11025, 16000, 22050, 44100, 48000};
        SAMPLE_RATES = iArr;
        int[] iArr2 = {64000, 96000, EncoderWriter.OUTPUT_AUDIO_BIT_RATE};
        BIT_RATES = iArr2;
        int i3 = iArr[5];
        AUDIO_SAMPLE_RATE_IN_HZ = i3;
        AUDIO_BIT_RATE = iArr2[1];
        int i16 = (int) (i3 * 0.02d * 1.0d * 4.0d);
        AUDIO_INPUT_BUFFER_SIZE = i16;
        AUDIO_OUTPUT_BUFFER_SIZE = i16 * 1;
    }

    public AudioRecorderAndChangerForKitKat(String str) {
        super(str);
        this.mCurrentState = new State();
        this.mBufSize = AUDIO_OUTPUT_BUFFER_SIZE;
        this.needVoiceChange = false;
    }

    @Override // com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat
    public int getDelay() {
        return this.mDelay;
    }

    @Override // com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat
    public int init() {
        System.currentTimeMillis();
        int i3 = AUDIO_SAMPLE_RATE_IN_HZ;
        this.mBufSize = AudioRecord.getMinBufferSize(i3, 16, 2);
        String str = AudioRecorderCompat.TAG;
        LogUtils.d(str, "init() - AudioRecord.getMinBufferSize = " + this.mBufSize);
        int i16 = this.mBufSize;
        int i17 = AUDIO_OUTPUT_BUFFER_SIZE;
        if (i16 <= i17) {
            this.mBufSize = i17;
        }
        try {
            this.mBuffer = new byte[this.mBufSize];
            try {
                AudioRecord audioRecord = new AudioRecord(1, i3, 16, 2, this.mBufSize);
                this.mARecorder = audioRecord;
                if (audioRecord.getState() != 1) {
                    LogUtils.e(str, "AudioRecord is not STATE_INITIALIZED");
                    this.mCurrentState.transfer(1);
                    return 4;
                }
                if (this.mARecorder.getRecordingState() == 1) {
                    try {
                        AudioMonitor.startRecording(this.mARecorder);
                    } catch (SecurityException e16) {
                        LogUtils.w(AudioRecorderCompat.TAG, "AudioRecord.startRecording failed", e16, new Object[0]);
                        this.mCurrentState.transfer(1);
                        return 5;
                    }
                }
                if (this.mARecorder.getRecordingState() == 3) {
                    this.mARecorder.stop();
                }
                this.mCurrentState.transfer(4);
                try {
                    this.mAsyncPcmWriter = new AsyncPcmWriterForKitKat(this.mPcmPath, AUDIO_INPUT_BUFFER_SIZE);
                    SimpleRecordThreadForKitKat simpleRecordThreadForKitKat = new SimpleRecordThreadForKitKat("AudioRecorder.RecordThread-" + System.currentTimeMillis());
                    this.mRecThread = simpleRecordThreadForKitKat;
                    simpleRecordThreadForKitKat.start();
                    return 0;
                } catch (FileNotFoundException e17) {
                    LogUtils.e(AudioRecorderCompat.TAG, e17.getMessage());
                    this.mCurrentState.transfer(1);
                    return 1;
                }
            } catch (IllegalArgumentException e18) {
                LogUtils.e(AudioRecorderCompat.TAG, "Recorder init error:", e18, new Object[0]);
                this.mCurrentState.transfer(1);
                return 3;
            }
        } catch (OutOfMemoryError e19) {
            LogUtils.e(AudioRecorderCompat.TAG, e19.getMessage());
            this.mCurrentState.transfer(1);
            return 2;
        }
    }

    @Override // com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat
    public void onRecordError(int i3) {
        LogUtils.e(AudioRecorderCompat.TAG, "onRecordError() - currentState = " + this.mCurrentState);
        OnErrorListener onErrorListener = this.mOnErrorListener;
        if (onErrorListener != null) {
            onErrorListener.onError(i3);
        }
    }

    @Override // com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat
    public void onRecordStop() {
        LogUtils.d(AudioRecorderCompat.TAG, "onRecordStop() - currentState = " + this.mCurrentState);
        AsyncPcmWriterForKitKat asyncPcmWriterForKitKat = this.mAsyncPcmWriter;
        if (asyncPcmWriterForKitKat != null) {
            asyncPcmWriterForKitKat.onStop();
        }
    }

    @Override // com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat
    public void onRecording(byte[] bArr, int i3) {
        AsyncPcmWriterForKitKat asyncPcmWriterForKitKat = this.mAsyncPcmWriter;
        if (asyncPcmWriterForKitKat != null) {
            asyncPcmWriterForKitKat.onRecord(bArr, i3);
        }
    }

    @Override // com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat
    public void pause() {
        String str = AudioRecorderCompat.TAG;
        LogUtils.d(str, "pause() - currentState = " + this.mCurrentState);
        synchronized (this.mCurrentState) {
            if (this.mCurrentState.equalState(16)) {
                LogUtils.d(str, "current state has been 16");
            } else {
                if (this.mCurrentState.equalState(8, 4)) {
                    this.mCurrentState.transfer(16);
                    return;
                }
                throw new IllegalStateException("current status is: " + this.mCurrentState);
            }
        }
    }

    @Override // com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat
    public void release() {
        String str = AudioRecorderCompat.TAG;
        LogUtils.d(str, "release start");
        synchronized (this.mCurrentState) {
            if (!this.mCurrentState.equalState(32)) {
                LogUtils.i(str, "stop() is forgotten by someone, so call it now!");
                stop(null);
            }
            this.mCurrentState.transfer(2);
        }
        this.mHasRecordLength = 0;
        SimpleRecordThreadForKitKat simpleRecordThreadForKitKat = this.mRecThread;
        if (simpleRecordThreadForKitKat != null && !simpleRecordThreadForKitKat.equals(Thread.currentThread())) {
            try {
                this.mRecThread.join();
            } catch (InterruptedException e16) {
                LogUtils.e(AudioRecorderCompat.TAG, e16.getMessage());
                this.mRecThread = null;
            }
        }
        AudioRecord audioRecord = this.mARecorder;
        if (audioRecord != null) {
            audioRecord.release();
        }
        String str2 = AudioRecorderCompat.TAG;
        LogUtils.d(str2, "AduioRecord release finish");
        this.mHasRecordLength = 0;
        LogUtils.d(str2, "release finish");
    }

    @Override // com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat
    public void resume() {
        LogUtils.d(AudioRecorderCompat.TAG, "resume() - currentState = " + this.mCurrentState);
        start();
    }

    @Override // com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat
    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    @Override // com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat
    public void start() {
        String str = AudioRecorderCompat.TAG;
        LogUtils.d(str, "start() - currentState = " + this.mCurrentState);
        synchronized (this.mCurrentState) {
            if (this.mCurrentState.equalState(8)) {
                LogUtils.w(str, "current state has been 8");
            } else {
                if (this.mCurrentState.equalState(16, 4)) {
                    this.mCurrentState.transfer(8);
                    return;
                }
                throw new IllegalStateException("current status is: " + this.mCurrentState);
            }
        }
    }

    @Override // com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat
    public void stop(AudioRecorderCompat.AudioListener audioListener) {
        String str = AudioRecorderCompat.TAG;
        LogUtils.d(str, "stop() - currentState = " + this.mCurrentState);
        synchronized (this.mCurrentState) {
            if (this.mCurrentState.equalState(32)) {
                LogUtils.d(str, "current state has been 32");
                return;
            }
            this.mCurrentState.transfer(32);
            SimpleRecordThreadForKitKat simpleRecordThreadForKitKat = this.mRecThread;
            if (simpleRecordThreadForKitKat != null && !simpleRecordThreadForKitKat.equals(Thread.currentThread())) {
                this.mListener = audioListener;
                try {
                    this.mRecThread.join();
                    LogUtils.d(str, "stop() - join() - currentState = " + this.mCurrentState);
                } catch (InterruptedException e16) {
                    LogUtils.e(AudioRecorderCompat.TAG, e16.getMessage());
                }
                this.mRecThread = null;
            }
        }
    }

    @Override // com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat
    protected void tryReleaseChanger() {
        VoiceChanger voiceChanger = this.mVoiceChanger;
        if (voiceChanger != null) {
            voiceChanger.release();
        }
    }

    @Override // com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat
    protected void tryReleasePacker() {
        RealTimePcmPacker realTimePcmPacker = this.mPcmPacker;
        if (realTimePcmPacker != null) {
            realTimePcmPacker.stop();
        }
    }

    @Override // com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat
    public void onDelaySet(int i3) {
    }

    @Override // com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat
    public int init(int i3, int i16) {
        init();
        long currentTimeMillis = System.currentTimeMillis();
        this.mVoiceChanger = new VoiceChanger(this.mPcmPath, AUDIO_SAMPLE_RATE_IN_HZ, i3, i16);
        this.needVoiceChange = true;
        String str = AudioRecorderCompat.TAG;
        LogUtils.d(str, "Audio Processers: start voice changer = " + (System.currentTimeMillis() - currentTimeMillis));
        LogUtils.d(str, "init() - currentState = " + this.mCurrentState);
        return 0;
    }
}
