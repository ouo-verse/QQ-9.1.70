package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;
import java.util.Locale;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public abstract class CaptureSourceInterface {
    private static final String TAG = "CaptureSourceInterface";

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class CaptureParams {

        /* renamed from: b, reason: collision with root package name */
        public int f119580b;

        /* renamed from: c, reason: collision with root package name */
        public int f119581c;

        /* renamed from: d, reason: collision with root package name */
        public int f119582d;

        public boolean equals(Object obj) {
            if (!(obj instanceof CaptureParams)) {
                return false;
            }
            CaptureParams captureParams = (CaptureParams) obj;
            if (this.f119580b != captureParams.f119580b || this.f119581c != captureParams.f119581c || this.f119582d != captureParams.f119582d) {
                return false;
            }
            return true;
        }

        public String toString() {
            return String.format(Locale.ENGLISH, "size: %dx%d, fps: %d", Integer.valueOf(this.f119581c), Integer.valueOf(this.f119582d), Integer.valueOf(this.f119580b));
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface CaptureSourceListener {
    }

    public abstract void pause();

    public abstract void resume();

    public abstract void start(Object obj, CaptureParams captureParams, CaptureSourceListener captureSourceListener);

    public abstract void stop();

    public abstract void updateParams(CaptureParams captureParams);

    public void setServerConfig(ServerVideoProducerConfig serverVideoProducerConfig) {
    }
}
