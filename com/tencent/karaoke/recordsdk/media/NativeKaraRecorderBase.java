package com.tencent.karaoke.recordsdk.media;

import android.media.AudioManager;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.IKaraResampler;
import com.tencent.karaoke.audiobasesdk.KaraResampler;
import com.tencent.karaoke.recordsdk.media.audio.AbstractKaraRecorder;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class NativeKaraRecorderBase extends AbstractKaraRecorder {
    public static final String FEEDBACK_VENDOR_SOFT = "SoftFeedback";
    private static final int INVALID_SEEK_POSITION = -1;
    private static final String TAG = "NativeKaraRecorderBase";
    protected boolean isHuaweiAPIAbove26SystemEarback;
    protected boolean isUseNewResampler;
    protected a mBufferRing;
    protected BufferThread mBufferThread;
    protected int mDefaultFramesPerBuffer;
    protected int mDefaultSampleRate;
    protected boolean mIsFeedback;
    protected volatile boolean mIsRecord;
    protected KaraResampler mKaraResampler;
    protected int mMode;
    protected ByteBuffer mNativeBuffer;
    protected byte[] mNewResampleBuffer;
    protected ByteBuffer mOriginalBuffer;
    protected ByteBuffer mResampleBuffer;
    protected IKaraResampler mSimpleKaraResampler;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    protected class BufferThread extends BaseHandlerThread {

        /* renamed from: m, reason: collision with root package name */
        private Handler f116963m;

        public BufferThread(String str) {
            super(str);
            this.f116963m = null;
            start();
            this.f116963m = new Handler(getLooper());
        }

        public void d(final byte[] bArr) {
            this.f116963m.post(new Runnable() { // from class: com.tencent.karaoke.recordsdk.media.NativeKaraRecorderBase.BufferThread.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!((AbstractKaraRecorder) NativeKaraRecorderBase.this).mCurrentState.a(4)) {
                        return;
                    }
                    synchronized (NativeKaraRecorderBase.this.mOriginalBuffer) {
                        ByteBuffer byteBuffer = NativeKaraRecorderBase.this.mOriginalBuffer;
                        byteBuffer.limit(byteBuffer.capacity());
                        int remaining = NativeKaraRecorderBase.this.mOriginalBuffer.remaining();
                        byte[] bArr2 = bArr;
                        if (remaining >= bArr2.length) {
                            NativeKaraRecorderBase.this.mOriginalBuffer.put(bArr2);
                        } else {
                            LogUtil.i("NativeKaraRecorder_BufferThread", "mOriginalBuffer remaining (" + NativeKaraRecorderBase.this.mOriginalBuffer.remaining() + ") is less than data's length (" + bArr.length + "), must drop it");
                        }
                        NativeKaraRecorderBase.this.mOriginalBuffer.notifyAll();
                    }
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    protected class a {

        /* renamed from: a, reason: collision with root package name */
        private int f116966a;

        /* renamed from: b, reason: collision with root package name */
        private int f116967b;

        /* renamed from: c, reason: collision with root package name */
        private byte[][] f116968c;

        /* renamed from: d, reason: collision with root package name */
        private int f116969d = 0;

        public a(int i3, int i16) {
            this.f116967b = i3;
            this.f116966a = i16;
            this.f116968c = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i16, i3);
        }

        public byte[] a() {
            byte[][] bArr = this.f116968c;
            int i3 = this.f116969d;
            byte[] bArr2 = bArr[i3];
            int i16 = i3 + 1;
            this.f116969d = i16;
            if (i16 >= this.f116966a) {
                this.f116969d = 0;
            }
            return bArr2;
        }
    }

    public NativeKaraRecorderBase() {
        this.mIsFeedback = false;
        this.mIsRecord = false;
        this.mDefaultSampleRate = 48000;
        this.mDefaultFramesPerBuffer = 512;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setDefaultStreamValues() {
        int parseInt;
        String property;
        int parseInt2;
        AudioManager b16 = uz0.e.b();
        String property2 = b16.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
        if (!TextUtils.isEmpty(property2)) {
            try {
                parseInt = Integer.parseInt(property2);
            } catch (NumberFormatException e16) {
                LogUtil.e(TAG, "Cast to Integer failed:" + e16.getMessage());
            }
            property = b16.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
            int i3 = 512;
            if (!TextUtils.isEmpty(property)) {
                try {
                    parseInt2 = Integer.parseInt(property);
                } catch (NumberFormatException e17) {
                    LogUtil.e(TAG, "Cast to Integer failed:" + e17.getMessage());
                }
                if (parseInt2 > 0) {
                    i3 = parseInt2;
                }
                this.mDefaultSampleRate = parseInt;
                this.mDefaultFramesPerBuffer = i3;
                LogUtil.i(TAG, "init -> defaultSampleRate:" + parseInt + ", framesPerBuffer:" + i3);
                if (com.tme.karaoke.lib_earback.base.c.d()) {
                    LogUtil.i(TAG, "setDefaultStreamValues: because earbackBlueToothFullbandRecordSupport,so increase sample to 48k");
                    this.mDefaultSampleRate = 48000;
                    if (this.mDefaultFramesPerBuffer < 480) {
                        this.mDefaultFramesPerBuffer = 480;
                        return;
                    }
                    return;
                }
                return;
            }
            parseInt2 = 512;
            if (parseInt2 > 0) {
            }
            this.mDefaultSampleRate = parseInt;
            this.mDefaultFramesPerBuffer = i3;
            LogUtil.i(TAG, "init -> defaultSampleRate:" + parseInt + ", framesPerBuffer:" + i3);
            if (com.tme.karaoke.lib_earback.base.c.d()) {
            }
        }
        parseInt = 48000;
        property = b16.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
        int i36 = 512;
        if (!TextUtils.isEmpty(property)) {
        }
        parseInt2 = 512;
        if (parseInt2 > 0) {
        }
        this.mDefaultSampleRate = parseInt;
        this.mDefaultFramesPerBuffer = i36;
        LogUtil.i(TAG, "init -> defaultSampleRate:" + parseInt + ", framesPerBuffer:" + i36);
        if (com.tme.karaoke.lib_earback.base.c.d()) {
        }
    }

    @Override // com.tencent.karaoke.recordsdk.media.audio.AbstractKaraRecorder
    public int getDelay() {
        return 0;
    }

    @Override // com.tencent.karaoke.recordsdk.media.audio.AbstractKaraRecorder
    public int init(i iVar) {
        setDefaultStreamValues();
        return super.init(iVar);
    }

    public NativeKaraRecorderBase(c cVar, int i3) {
        super(cVar, i3);
        this.mIsFeedback = false;
        this.mIsRecord = false;
        this.mDefaultSampleRate = 48000;
        this.mDefaultFramesPerBuffer = 512;
    }
}
