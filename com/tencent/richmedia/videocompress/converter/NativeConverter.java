package com.tencent.richmedia.videocompress.converter;

import android.view.Surface;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import com.tencent.richmedia.videocompress.mediacodec.InputSurface;
import com.tencent.richmedia.videocompress.mediacodec.OutputSurface;
import com.tencent.richmedia.videocompress.utils.ConvertLog;

/* compiled from: P */
/* loaded from: classes25.dex */
public class NativeConverter implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private OutputSurface f365122d;

    /* renamed from: e, reason: collision with root package name */
    private InputSurface f365123e;

    /* renamed from: f, reason: collision with root package name */
    private VideoConverter.Processor f365124f;

    /* renamed from: h, reason: collision with root package name */
    private String f365125h;

    /* renamed from: i, reason: collision with root package name */
    private String f365126i;

    /* renamed from: m, reason: collision with root package name */
    private VideoConverterConfig f365127m;

    static {
        System.loadLibrary("native-codec-jni");
    }

    public static native boolean initDecodec(String str);

    public static native Object initEncodec(String str, VideoConverterConfig videoConverterConfig);

    public static native void setNativeLogLevel(int i3);

    public static native void setSurface(Surface surface);

    public static native void startCodec(NativeConverter nativeConverter);

    @Override // java.lang.Runnable
    public void run() {
        ConvertLog.d("NativeConverter", 1, "compress start");
        System.currentTimeMillis();
        try {
            setNativeLogLevel(ConvertLog.getLogLevel());
            Object initEncodec = initEncodec(this.f365126i, this.f365127m);
            if (initEncodec != null) {
                ConvertLog.d("NativeConverter", 1, "initEncodec");
                InputSurface inputSurface = new InputSurface((Surface) initEncodec);
                this.f365123e = inputSurface;
                inputSurface.makeCurrent();
                OutputSurface outputSurface = new OutputSurface();
                this.f365122d = outputSurface;
                setSurface(outputSurface.getSurface());
                ConvertLog.d("NativeConverter", 1, V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface);
                boolean initDecodec = initDecodec(this.f365125h);
                VideoConverter.Processor processor = this.f365124f;
                if (processor != null) {
                    processor.onProgress(0);
                }
                ConvertLog.d("NativeConverter", 1, "initDecodec, isSuccess:" + initDecodec);
                if (!initDecodec) {
                    return;
                }
                startCodec(this);
                this.f365122d.release();
                this.f365123e.release();
                System.currentTimeMillis();
                VideoConverter.Processor processor2 = this.f365124f;
                if (processor2 != null) {
                    processor2.onSuccess();
                }
            }
        } catch (Throwable th5) {
            ConvertLog.d("NativeConverter", 1, "NativeCodecUtil fail, ", th5);
            VideoConverter.Processor processor3 = this.f365124f;
            if (processor3 != null) {
                processor3.onFail(th5);
            }
        }
    }
}
