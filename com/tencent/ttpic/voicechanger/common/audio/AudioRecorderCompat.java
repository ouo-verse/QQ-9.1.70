package com.tencent.ttpic.voicechanger.common.audio;

import android.content.Context;
import android.media.AudioRecord;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.logic.watermark.FFTData;
import com.tencent.ttpic.util.AudioUtil;
import com.tencent.ttpic.voicechanger.common.audio.VoiceTextRecognizer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AudioRecorderCompat {
    public static int AUDIO_BIT_RATE = 0;
    public static int AUDIO_CHANNEL_COUNT = 0;
    public static int AUDIO_INPUT_BUFFER_SIZE = 0;
    public static int AUDIO_OUTPUT_BUFFER_SIZE = 0;
    public static int AUDIO_SAMPLE_RATE_IN_HZ = 0;
    public static final int[] BIT_RATES;
    public static final int ERROR_AUDIO_FILE_NOT_EXIST = 1;
    public static final int ERROR_AUDIO_ILLEGAL_ARGUMENT = 3;
    public static final int ERROR_AUDIO_INIT_AUDIORECORD_FAILED = 4;
    public static final int ERROR_AUDIO_OUT_OF_MEMORY = 2;
    public static final int ERROR_AUDIO_REAL_PACKER_FAILED = 7;
    public static final int ERROR_AUDIO_RECORD_READ_FAILED = 6;
    public static final int ERROR_AUDIO_RECORD_START_FAILED = 5;
    public static final int[] SAMPLE_RATES;
    protected static final String TAG = "AudioRecorderCompat";
    public static final int WX_VOICE_HTTP_ERROR_NETWORK = -201;
    protected AudioRecord mARecorder;
    protected AsyncPcmWriter mAsyncPcmWriter;
    protected String mAudioPath;
    protected byte[] mBuffer;
    private int mDecibel;
    protected int mDelay;
    protected boolean mHasDelaySet;
    protected int mHasRecordLength;
    protected AudioListener mListener;
    protected OnErrorListener mOnErrorListener;
    protected RealTimePcmPacker mPcmPacker;
    protected boolean mRealPackerEnable;
    protected SimpleRecordThread mRecThread;
    protected boolean mVoice2TextEnable;
    protected boolean mVoiceChangeEnable;
    protected VoiceChanger mVoiceChanger;
    protected boolean mWrite2FileEnable;
    private boolean needDB = false;
    protected State mCurrentState = new State();
    protected int mBufSize = AUDIO_OUTPUT_BUFFER_SIZE;
    private int mLastBufferSize = AUDIO_INPUT_BUFFER_SIZE;
    private int mLastSampleRate = AUDIO_SAMPLE_RATE_IN_HZ;
    private FFTData mFFTDataResult = new FFTData(AUDIO_INPUT_BUFFER_SIZE, AUDIO_SAMPLE_RATE_IN_HZ / 2);
    private short[] mfftbuffer = new short[AUDIO_INPUT_BUFFER_SIZE];

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class AsyncPcmWriter extends BaseHandlerThread {
        private static final String T_TAG = "AudioRecorder.AsyncPcmWriter";
        private final LinkedList<byte[]> fileBuffers;
        private Handler mHandler;
        private RandomAccessFile mMicfile;
        private int perBufSize;

        public AsyncPcmWriter(String str, int i3) throws FileNotFoundException {
            super("AudioRecorder.AsyncPcmWriter-" + System.currentTimeMillis());
            this.mHandler = null;
            this.mMicfile = null;
            this.fileBuffers = new LinkedList<>();
            FileUtils.delete(str);
            if (AudioRecorderCompat.this.mWrite2FileEnable) {
                this.mMicfile = new RandomAccessFile(str, "rw");
            }
            this.perBufSize = i3;
            start();
            this.mHandler = new Handler(getLooper());
            for (int i16 = 0; i16 < 4; i16++) {
                this.fileBuffers.add(new byte[i3]);
            }
        }

        public void onPrepare() {
            this.mHandler.post(new Runnable() { // from class: com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat.AsyncPcmWriter.1
                @Override // java.lang.Runnable
                public void run() {
                    AudioRecorderCompat.this.mPcmPacker.prepare();
                }
            });
        }

        public void onRecord(byte[] bArr, final int i3) {
            final byte[] bArr2;
            if (!AudioRecorderCompat.this.mWrite2FileEnable) {
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
            this.mHandler.post(new Runnable() { // from class: com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat.AsyncPcmWriter.2
                @Override // java.lang.Runnable
                public void run() {
                    RealTimePcmPacker realTimePcmPacker;
                    try {
                        long currentTimeMillis = System.currentTimeMillis();
                        byte[] bArr3 = bArr2;
                        AudioRecorderCompat audioRecorderCompat = AudioRecorderCompat.this;
                        if (audioRecorderCompat.mVoiceChangeEnable && audioRecorderCompat.mVoiceChanger != null) {
                            short[] sArr = new short[i3 / 2];
                            ByteBuffer.wrap(bArr3).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(sArr);
                            bArr3 = AudioRecorderCompat.this.mVoiceChanger.writeVoiceFrames(sArr);
                            if (bArr3 == null) {
                                throw new Exception("frames is null");
                            }
                        }
                        AsyncPcmWriter asyncPcmWriter = AsyncPcmWriter.this;
                        AudioRecorderCompat audioRecorderCompat2 = AudioRecorderCompat.this;
                        if (audioRecorderCompat2.mRealPackerEnable && (realTimePcmPacker = audioRecorderCompat2.mPcmPacker) != null) {
                            realTimePcmPacker.encodeBytes(bArr3);
                        } else {
                            asyncPcmWriter.mMicfile.write(bArr3, 0, bArr3.length);
                        }
                        LogUtils.d(AudioRecorderCompat.TAG, "Process 1 recorded frame: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                        synchronized (AsyncPcmWriter.this.fileBuffers) {
                            if (AsyncPcmWriter.this.fileBuffers.size() < 8) {
                                AsyncPcmWriter.this.fileBuffers.add(bArr2);
                            }
                        }
                    } catch (Exception e16) {
                        LogUtils.e(AudioRecorderCompat.TAG, "onRecord() - ERROR", e16.getMessage());
                        try {
                            AsyncPcmWriter.this.mMicfile.close();
                        } catch (IOException e17) {
                            LogUtils.d(AudioRecorderCompat.TAG, "can't close?", e17, new Object[0]);
                        }
                    }
                }
            });
        }

        public void onStop() {
            this.mHandler.post(new Runnable() { // from class: com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat.AsyncPcmWriter.3
                @Override // java.lang.Runnable
                public void run() {
                    AudioRecorderCompat.this.tryReleaseChanger();
                    AudioRecorderCompat.this.tryReleasePacker();
                    AudioRecorderCompat.this.tryReleaseRecognizer();
                    try {
                        AsyncPcmWriter asyncPcmWriter = AsyncPcmWriter.this;
                        if (AudioRecorderCompat.this.mWrite2FileEnable && asyncPcmWriter.mMicfile != null) {
                            AsyncPcmWriter.this.mMicfile.close();
                        }
                    } catch (IOException e16) {
                        LogUtils.d(AudioRecorderCompat.TAG, "can't close?", e16, new Object[0]);
                    }
                    AudioListener audioListener = AudioRecorderCompat.this.mListener;
                    if (audioListener != null) {
                        audioListener.onAudioRecordFinish();
                        AudioRecorderCompat.this.mListener = null;
                    }
                    AsyncPcmWriter.this.quit();
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface AudioListener {
        void onAudioRecordFinish();
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
                synchronized (AudioRecorderCompat.this.mCurrentState) {
                    if (AudioRecorderCompat.this.mCurrentState.equalState(4)) {
                        LogUtils.d(TAG, "run() - State.STATE_INITIALIZED");
                        LogUtils.i(TAG, getName() + " wait, " + AudioRecorderCompat.this.mCurrentState);
                        try {
                            LockMethodProxy.wait(AudioRecorderCompat.this.mCurrentState);
                        } catch (InterruptedException e16) {
                            LogUtils.w(TAG, "", e16, new Object[0]);
                        }
                        LogUtils.i(TAG, getName() + " continue, " + AudioRecorderCompat.this.mCurrentState);
                    }
                }
                synchronized (AudioRecorderCompat.this.mCurrentState) {
                    if (AudioRecorderCompat.this.mCurrentState.equalState(16)) {
                        LogUtils.d(TAG, "run() - State.STATE_PAUSED");
                        if (AudioRecorderCompat.this.mARecorder.getRecordingState() == 3) {
                            LogUtils.d(TAG, "AudioRecord.stop, " + AudioRecorderCompat.this.mCurrentState);
                            AudioRecorderCompat.this.mARecorder.stop();
                        }
                        LogUtils.i(TAG, getName() + " wait, " + AudioRecorderCompat.this.mCurrentState);
                        try {
                            LockMethodProxy.wait(AudioRecorderCompat.this.mCurrentState);
                        } catch (InterruptedException e17) {
                            LogUtils.w(TAG, "", e17, new Object[0]);
                        }
                        LogUtils.i(TAG, getName() + " continue, " + AudioRecorderCompat.this.mCurrentState);
                    }
                }
                if (AudioRecorderCompat.this.mCurrentState.equalState(32, 1)) {
                    break;
                }
                if (AudioRecorderCompat.this.mCurrentState.equalState(8)) {
                    LogUtils.v(TAG, "run() - State.STATE_STARTED");
                    if (AudioRecorderCompat.this.mARecorder.getRecordingState() == 1) {
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            AudioMonitor.startRecording(AudioRecorderCompat.this.mARecorder);
                            LogUtils.d(TAG, "AudioRecord.startRecording, " + (System.currentTimeMillis() - currentTimeMillis) + ", " + AudioRecorderCompat.this.mCurrentState);
                        } catch (SecurityException e18) {
                            LogUtils.w(TAG, "AudioRecord.startRecording failed", e18, new Object[0]);
                            AudioRecorderCompat.this.onRecordError(5);
                            AudioRecorderCompat.this.mCurrentState.transfer(1);
                        }
                        if (AudioRecorderCompat.this.mARecorder.getRecordingState() == 1) {
                            LogUtils.e(TAG, "startRecording failed");
                            AudioRecorderCompat.this.onRecordError(5);
                            AudioRecorderCompat.this.mCurrentState.transfer(1);
                        } else {
                            AudioRecorderCompat audioRecorderCompat = AudioRecorderCompat.this;
                            if (!audioRecorderCompat.mHasDelaySet) {
                                audioRecorderCompat.mDelay = (int) (System.currentTimeMillis() - currentTimeMillis);
                                LogUtils.i(TAG, "AudioRecord, delay: " + AudioRecorderCompat.this.mDelay);
                                AudioRecorderCompat audioRecorderCompat2 = AudioRecorderCompat.this;
                                audioRecorderCompat2.onDelaySet(audioRecorderCompat2.mDelay);
                                AudioRecorderCompat.this.mHasDelaySet = true;
                            }
                        }
                    }
                    AudioRecorderCompat audioRecorderCompat3 = AudioRecorderCompat.this;
                    int read = audioRecorderCompat3.mARecorder.read(audioRecorderCompat3.mBuffer, 0, AudioRecorderCompat.AUDIO_INPUT_BUFFER_SIZE);
                    if (AudioRecorderCompat.this.needDB) {
                        AudioRecorderCompat audioRecorderCompat4 = AudioRecorderCompat.this;
                        audioRecorderCompat4.mDecibel = AudioUtil.getPcmDB16Bit(audioRecorderCompat4.mBuffer, read);
                        AudioRecorderCompat audioRecorderCompat5 = AudioRecorderCompat.this;
                        audioRecorderCompat5.mfftbuffer = AudioUtil.pcm16BitToShort(audioRecorderCompat5.mBuffer, read);
                        if (AudioRecorderCompat.this.mfftbuffer != null) {
                            AudioUtil.getPcmFFTFromShortBuffer(AudioRecorderCompat.this.mfftbuffer, AudioRecorderCompat.this.mfftbuffer.length, AudioRecorderCompat.this.mFFTDataResult);
                        }
                    }
                    if (read != -3 && read != -2 && read > 0) {
                        AudioRecorderCompat audioRecorderCompat6 = AudioRecorderCompat.this;
                        audioRecorderCompat6.mHasRecordLength += read;
                        audioRecorderCompat6.onRecording(audioRecorderCompat6.mBuffer, read);
                    } else {
                        LogUtils.e(TAG, "AudioRecord read return count = " + read);
                        AudioRecorderCompat.this.onRecordError(6);
                        AudioRecorderCompat.this.mCurrentState.transfer(1);
                    }
                }
                LogUtils.v(TAG, "run() - currentState = " + AudioRecorderCompat.this.mCurrentState);
            }
            LogUtils.d(TAG, "run() - State.STATE_STOPPED || State.STATE_ERROR");
            if (AudioRecorderCompat.this.mARecorder.getRecordingState() == 3) {
                LogUtils.d(TAG, "AudioRecord.stop, " + AudioRecorderCompat.this.mCurrentState);
                AudioRecorderCompat.this.mARecorder.stop();
            }
            AudioRecorderCompat.this.onRecordStop();
            AudioRecorderCompat.this.mOnErrorListener = null;
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

        private String getStateName(int i3) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 != 8) {
                        if (i3 != 16) {
                            if (i3 != 32) {
                                return "STATE_ERROR";
                            }
                            return "STATE_STOPPED";
                        }
                        return "STATE_PAUSED";
                    }
                    return "STATE_STARTED";
                }
                return "STATE_INITIALIZED";
            }
            return "STATE_IDLE";
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
            return "State[" + getStateName(this.state) + "]";
        }

        public synchronized void transfer(int i3) {
            LogUtils.i(AudioRecorderCompat.TAG, "switch state: " + getStateName(this.state) + " -> " + getStateName(i3));
            this.state = i3;
            AudioRecorderCompat.this.mCurrentState.notifyAll();
        }
    }

    static {
        int[] iArr = {8000, 11025, 16000, 22050, 44100, 48000};
        SAMPLE_RATES = iArr;
        int[] iArr2 = {64000, 96000, EncoderWriter.OUTPUT_AUDIO_BIT_RATE};
        BIT_RATES = iArr2;
        int i3 = iArr[2];
        AUDIO_SAMPLE_RATE_IN_HZ = i3;
        AUDIO_CHANNEL_COUNT = 1;
        AUDIO_BIT_RATE = iArr2[1];
        int i16 = (int) (i3 * 0.02d * 1 * 4.0d);
        AUDIO_INPUT_BUFFER_SIZE = i16;
        AUDIO_OUTPUT_BUFFER_SIZE = i16 * 1;
    }

    public AudioRecorderCompat(String str) {
        boolean z16 = false;
        this.mAudioPath = str;
        this.mWrite2FileEnable = !TextUtils.isEmpty(str);
        if (!TextUtils.isEmpty(str) && this.mAudioPath.endsWith(".m4a")) {
            z16 = true;
        }
        this.mRealPackerEnable = z16;
    }

    public void enableVoice2Text(Context context, final OnErrorListener onErrorListener) {
        VoiceTextRecognizer.getInstance().init(context, true);
        VoiceTextRecognizer.getInstance().setVRErrorListener(new VoiceTextRecognizer.VRErrorListener() { // from class: com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat.1
            @Override // com.tencent.ttpic.voicechanger.common.audio.VoiceTextRecognizer.VRErrorListener
            public void onError(int i3) {
                OnErrorListener onErrorListener2 = onErrorListener;
                if (onErrorListener2 != null) {
                    onErrorListener2.onError(i3);
                }
            }
        });
        VoiceTextRecognizer.getInstance().start();
        this.mVoice2TextEnable = true;
    }

    public int getDecibel() {
        return this.mDecibel;
    }

    public int getDelay() {
        return this.mDelay;
    }

    public FFTData getFFTResult() {
        return this.mFFTDataResult;
    }

    public int init() {
        return initWithAudioSource(1);
    }

    public int initWithAudioSource(int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        this.mBufSize = AudioRecord.getMinBufferSize(AUDIO_SAMPLE_RATE_IN_HZ, 16, 2);
        String str = TAG;
        LogUtils.d(str, "init() - AudioRecord.getMinBufferSize = " + this.mBufSize);
        int i16 = this.mBufSize;
        int i17 = AUDIO_OUTPUT_BUFFER_SIZE;
        if (i16 <= i17) {
            this.mBufSize = i17;
        }
        try {
            this.mBuffer = new byte[this.mBufSize];
            try {
                AudioRecord audioRecord = new AudioRecord(i3, AUDIO_SAMPLE_RATE_IN_HZ, AUDIO_CHANNEL_COUNT * 16, 2, this.mBufSize);
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
                        LogUtils.w(TAG, "AudioRecord.startRecording failed", e16, new Object[0]);
                        this.mCurrentState.transfer(1);
                        return 5;
                    }
                }
                if (this.mARecorder.getRecordingState() == 3) {
                    this.mARecorder.stop();
                }
                this.mCurrentState.transfer(4);
                try {
                    this.mAsyncPcmWriter = new AsyncPcmWriter(this.mAudioPath, AUDIO_INPUT_BUFFER_SIZE);
                    SimpleRecordThread simpleRecordThread = new SimpleRecordThread("AudioRecorder.RecordThread-" + System.currentTimeMillis());
                    this.mRecThread = simpleRecordThread;
                    simpleRecordThread.start();
                    long currentTimeMillis2 = System.currentTimeMillis();
                    LogUtils.d(str, "Audio Processers: start recorder = " + (currentTimeMillis2 - currentTimeMillis));
                    try {
                        if (this.mRealPackerEnable) {
                            RealTimePcmPacker realTimePcmPacker = new RealTimePcmPacker(AUDIO_BIT_RATE, AUDIO_SAMPLE_RATE_IN_HZ, AUDIO_CHANNEL_COUNT);
                            this.mPcmPacker = realTimePcmPacker;
                            realTimePcmPacker.setOutputPath(this.mAudioPath);
                            this.mAsyncPcmWriter.onPrepare();
                            LogUtils.d(str, "Audio Processers: start pcm packer = " + (System.currentTimeMillis() - currentTimeMillis2));
                        }
                        return 0;
                    } catch (Exception e17) {
                        LogUtils.e(TAG, e17.getMessage());
                        this.mCurrentState.transfer(1);
                        return 7;
                    }
                } catch (FileNotFoundException e18) {
                    LogUtils.e(TAG, e18.getMessage());
                    this.mCurrentState.transfer(1);
                    return 1;
                }
            } catch (IllegalArgumentException e19) {
                LogUtils.e(TAG, "Recorder init error:", e19, new Object[0]);
                this.mCurrentState.transfer(1);
                return 3;
            }
        } catch (OutOfMemoryError e26) {
            LogUtils.e(TAG, e26.getMessage());
            this.mCurrentState.transfer(1);
            return 2;
        }
    }

    public void onRecordError(int i3) {
        LogUtils.e(TAG, "onRecordError() - currentState = " + this.mCurrentState);
        OnErrorListener onErrorListener = this.mOnErrorListener;
        if (onErrorListener != null) {
            onErrorListener.onError(i3);
        }
    }

    public void onRecordStop() {
        LogUtils.d(TAG, "onRecordStop() - currentState = " + this.mCurrentState);
        AsyncPcmWriter asyncPcmWriter = this.mAsyncPcmWriter;
        if (asyncPcmWriter != null) {
            asyncPcmWriter.onStop();
        }
    }

    public void onRecording(byte[] bArr, int i3) {
        AsyncPcmWriter asyncPcmWriter;
        if (this.mWrite2FileEnable && (asyncPcmWriter = this.mAsyncPcmWriter) != null) {
            asyncPcmWriter.onRecord(bArr, i3);
        }
        if (this.mVoice2TextEnable) {
            VoiceTextRecognizer.getInstance().recognizeFromPCMBuffer(bArr, i3);
        }
    }

    public void pause() {
        String str = TAG;
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

    public void release() {
        String str = TAG;
        LogUtils.d(str, "release start");
        synchronized (this.mCurrentState) {
            if (!this.mCurrentState.equalState(32)) {
                LogUtils.i(str, "stop() is forgotten by someone, so call it now!");
                stop(null);
            }
            this.mCurrentState.transfer(2);
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
        LogUtils.d(TAG, "resume() - currentState = " + this.mCurrentState);
        start();
    }

    public void setNeedDB(boolean z16) {
        this.needDB = z16;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void setSampleRate(int i3) {
        AUDIO_SAMPLE_RATE_IN_HZ = i3;
        int i16 = AUDIO_CHANNEL_COUNT;
        int i17 = (int) (i3 * 0.02d * i16 * 4.0d);
        AUDIO_INPUT_BUFFER_SIZE = i17;
        AUDIO_OUTPUT_BUFFER_SIZE = i16 * i17;
        if (this.mLastBufferSize != i17 || this.mLastSampleRate != i3) {
            this.mFFTDataResult = new FFTData(AUDIO_INPUT_BUFFER_SIZE, AUDIO_SAMPLE_RATE_IN_HZ);
            this.mfftbuffer = new short[AUDIO_INPUT_BUFFER_SIZE];
        }
    }

    public void start() {
        String str = TAG;
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

    public void stop(AudioListener audioListener) {
        String str = TAG;
        LogUtils.d(str, "stop() - currentState = " + this.mCurrentState);
        synchronized (this.mCurrentState) {
            if (this.mCurrentState.equalState(32)) {
                LogUtils.d(str, "current state has been 32");
                return;
            }
            this.mCurrentState.transfer(32);
            SimpleRecordThread simpleRecordThread = this.mRecThread;
            if (simpleRecordThread != null && !simpleRecordThread.equals(Thread.currentThread())) {
                this.mListener = audioListener;
                try {
                    this.mRecThread.join();
                    LogUtils.d(str, "stop() - join() - currentState = " + this.mCurrentState);
                } catch (InterruptedException e16) {
                    LogUtils.e(TAG, e16.getMessage());
                }
                this.mRecThread = null;
            }
        }
    }

    protected void tryReleaseChanger() {
        VoiceChanger voiceChanger = this.mVoiceChanger;
        if (voiceChanger != null) {
            voiceChanger.release();
        }
    }

    protected void tryReleasePacker() {
        RealTimePcmPacker realTimePcmPacker = this.mPcmPacker;
        if (realTimePcmPacker != null) {
            realTimePcmPacker.stop();
        }
    }

    protected void tryReleaseRecognizer() {
        if (this.mVoice2TextEnable) {
            VoiceTextRecognizer.getInstance().destroy();
            this.mVoice2TextEnable = false;
        }
    }

    public int init(int i3, int i16) {
        return initWithAudioSource(1, i3, i16);
    }

    public void onDelaySet(int i3) {
    }

    public int initWithAudioSource(int i3, int i16, int i17) {
        int initWithAudioSource = initWithAudioSource(i3);
        if (initWithAudioSource != 0) {
            return initWithAudioSource;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.mVoiceChanger = new VoiceChanger(this.mAudioPath, AUDIO_SAMPLE_RATE_IN_HZ, i16, i17);
        String str = TAG;
        LogUtils.d(str, "Audio Processers: start voice changer = " + (System.currentTimeMillis() - currentTimeMillis));
        LogUtils.d(str, "init() - currentState = " + this.mCurrentState);
        this.mVoiceChangeEnable = true;
        return initWithAudioSource;
    }
}
