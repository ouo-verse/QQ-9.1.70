package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.base.util.h;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import java.util.Locale;

/* loaded from: classes7.dex */
public class CameraCaptureParams extends CaptureSourceInterface.CaptureParams {

    /* renamed from: a, reason: collision with root package name */
    public Boolean f119574a = null;

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureParams
    public boolean equals(Object obj) {
        if (!(obj instanceof CameraCaptureParams)) {
            return false;
        }
        CameraCaptureParams cameraCaptureParams = (CameraCaptureParams) obj;
        if (!super.equals(cameraCaptureParams) || !h.a(this.f119574a, cameraCaptureParams.f119574a)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureParams
    public String toString() {
        return String.format(Locale.ENGLISH, "%s, frontCamera: %b", super.toString(), this.f119574a);
    }
}
