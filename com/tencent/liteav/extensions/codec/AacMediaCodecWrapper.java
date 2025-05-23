package com.tencent.liteav.extensions.codec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AacMediaCodecWrapper {

    /* renamed from: a, reason: collision with root package name */
    MediaFormat f119049a;

    /* renamed from: b, reason: collision with root package name */
    int f119050b = 0;

    /* renamed from: c, reason: collision with root package name */
    private final String f119051c;

    /* renamed from: d, reason: collision with root package name */
    private final int f119052d;

    /* renamed from: e, reason: collision with root package name */
    private MediaCodec f119053e;

    /* renamed from: f, reason: collision with root package name */
    private final MediaCodec.BufferInfo f119054f;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final int f119055a = 1;

        /* renamed from: b, reason: collision with root package name */
        public static final int f119056b = 2;

        /* renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ int[] f119057c = {1, 2};
    }

    public AacMediaCodecWrapper(int i3) {
        String str;
        this.f119052d = i3;
        if (i3 == a.f119055a) {
            str = "HardwareAacEncoder";
        } else {
            str = "HardwareAacDecoder";
        }
        this.f119051c = str;
        this.f119054f = new MediaCodec.BufferInfo();
    }

    private ByteBuffer b() {
        ByteBuffer byteBuffer;
        try {
            int dequeueOutputBuffer = this.f119053e.dequeueOutputBuffer(this.f119054f, TimeUnit.MILLISECONDS.toMicros(5L));
            if (dequeueOutputBuffer == -1) {
                return null;
            }
            if (dequeueOutputBuffer == -3) {
                Log.i(this.f119051c, "codec output buffers changed.", new Object[0]);
                return null;
            }
            if (dequeueOutputBuffer == -2) {
                this.f119049a = this.f119053e.getOutputFormat();
                Log.i(this.f119051c, "codec output format changed: " + this.f119049a, new Object[0]);
                return null;
            }
            if (dequeueOutputBuffer < 0) {
                Log.e(this.f119051c, "unexpected result from dequeueOutputBuffer: ".concat(String.valueOf(dequeueOutputBuffer)), new Object[0]);
                return null;
            }
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
                byteBuffer = this.f119053e.getOutputBuffer(dequeueOutputBuffer);
            } else {
                byteBuffer = this.f119053e.getOutputBuffers()[dequeueOutputBuffer];
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f119054f.size);
            allocateDirect.put(byteBuffer);
            this.f119053e.releaseOutputBuffer(dequeueOutputBuffer, false);
            int i3 = this.f119050b;
            if (i3 > 0) {
                this.f119050b = i3 - 1;
            }
            return allocateDirect;
        } catch (Exception e16) {
            Log.e(this.f119051c, "dequeueOutputBuffer failed. ".concat(String.valueOf(e16)), new Object[0]);
            return null;
        }
    }

    public final boolean a(MediaFormat mediaFormat) {
        if (this.f119053e == null && mediaFormat != null) {
            try {
                boolean z16 = this.f119052d == a.f119055a;
                if (z16) {
                    this.f119053e = MediaCodec.createEncoderByType("audio/mp4a-latm");
                } else {
                    this.f119053e = MediaCodec.createDecoderByType("audio/mp4a-latm");
                }
                this.f119053e.configure(mediaFormat, (Surface) null, (MediaCrypto) null, z16 ? 1 : 0);
                this.f119053e.start();
                return true;
            } catch (IOException e16) {
                Log.e(this.f119051c, "create codec failed. ".concat(String.valueOf(e16)), new Object[0]);
                a();
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0065 -> B:14:0x005b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ByteBuffer processFrame(ByteBuffer byteBuffer) {
        ByteBuffer[] inputBuffers;
        MediaCodec mediaCodec = this.f119053e;
        if (mediaCodec != null && byteBuffer != null) {
            int i3 = 0;
            try {
                inputBuffers = mediaCodec.getInputBuffers();
            } catch (Exception e16) {
                Log.e(this.f119051c, "feedData failed. ".concat(String.valueOf(e16)), new Object[i3]);
            }
            if (inputBuffers != null && inputBuffers.length > 0) {
                int dequeueInputBuffer = this.f119053e.dequeueInputBuffer(TimeUnit.MILLISECONDS.toMicros(5L));
                if (dequeueInputBuffer >= 0) {
                    int remaining = byteBuffer.remaining();
                    inputBuffers[dequeueInputBuffer].put(byteBuffer);
                    this.f119053e.queueInputBuffer(dequeueInputBuffer, 0, remaining, 0L, 0);
                    this.f119050b++;
                }
                if (i3 < 3) {
                    ByteBuffer b16 = b();
                    if (b16 != null) {
                        return b16;
                    }
                    i3++;
                    if (i3 < 3) {
                    }
                }
            }
            Log.e(this.f119051c, "get invalid input buffers.", new Object[0]);
            if (i3 < 3) {
            }
        }
        return null;
    }

    public final void a() {
        MediaCodec mediaCodec = this.f119053e;
        if (mediaCodec == null) {
            return;
        }
        try {
            mediaCodec.stop();
        } catch (Exception e16) {
            Log.e(this.f119051c, "codec stop failed.".concat(String.valueOf(e16)), new Object[0]);
        }
        try {
            this.f119053e.release();
        } catch (Exception e17) {
            Log.e(this.f119051c, "codec release failed.".concat(String.valueOf(e17)), new Object[0]);
        }
        this.f119053e = null;
        this.f119050b = 0;
    }
}
