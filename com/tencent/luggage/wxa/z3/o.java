package com.tencent.luggage.wxa.z3;

import android.hardware.Camera;
import com.tencent.luggage.scanner.camera.ScanUtil;
import com.tencent.luggage.wxa.tn.w;
import java.util.List;
import kotlinx.coroutines.DebugKt;

/* compiled from: P */
/* loaded from: classes9.dex */
public class o extends a {
    public void b(boolean z16) {
        try {
            Camera camera2 = this.f146219a;
            if (camera2 != null) {
                Camera.Parameters parameters = camera2.getParameters();
                String str = parameters.get("zoom-supported");
                if (!ScanUtil.isNullOrNil(str) && Boolean.parseBoolean(str)) {
                    List<Integer> zoomRatios = parameters.getZoomRatios();
                    if (zoomRatios != null && zoomRatios.size() > 0) {
                        if (z16) {
                            int size = zoomRatios.size() / 5;
                            this.f146232n = size;
                            if (zoomRatios.get(size).intValue() > 150) {
                                this.f146232n = a(zoomRatios, 150);
                            }
                        } else {
                            this.f146232n = 0;
                        }
                        this.f146233o = (int) (zoomRatios.size() / 1.5d);
                        w.a("Luggage.WxScanCamera", "divideRatio: %f,max zoom: %d", Double.valueOf(1.5d), Integer.valueOf(this.f146233o));
                        int i3 = this.f146233o;
                        int i16 = this.f146232n;
                        if (i3 < i16) {
                            this.f146233o = i16;
                        } else if (zoomRatios.get(i3).intValue() > 400) {
                            this.f146233o = a(zoomRatios, 400);
                        }
                        w.d("Luggage.WxScanCamera", "default zoom:%d,default ratio:%d,max zoom:%d,max ratio:%d", Integer.valueOf(this.f146232n), zoomRatios.get(this.f146232n), Integer.valueOf(this.f146233o), zoomRatios.get(this.f146233o));
                        return;
                    }
                    return;
                }
                w.d("Luggage.WxScanCamera", "not support zoom");
            }
        } catch (Exception e16) {
            w.b("Luggage.WxScanCamera", "init zoom exception! " + e16.getMessage());
        }
    }

    public void k() {
        w.d("Luggage.WxScanCamera", String.format("closeFlash, camera: %s, isPreviewing: %s", this.f146219a, Boolean.valueOf(e())));
        if (this.f146219a != null && e()) {
            try {
                this.f146229k = false;
                Camera.Parameters parameters = this.f146219a.getParameters();
                List<String> supportedFlashModes = parameters.getSupportedFlashModes();
                if (supportedFlashModes != null && supportedFlashModes.contains(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                    parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                    this.f146219a.setParameters(parameters);
                    w.d("Luggage.WxScanCamera", "close flash");
                } else {
                    w.d("Luggage.WxScanCamera", "camera not support close flash!!");
                }
            } catch (Exception e16) {
                w.b("Luggage.WxScanCamera", "closeFlash error: " + e16.getMessage());
            }
        }
    }

    public int l() {
        return this.f146219a.getParameters().getPreviewFormat();
    }

    public boolean m() {
        return this.f146229k;
    }

    public boolean n() {
        if (this.f146230l < 0) {
            this.f146230l = o() ? 1 : 0;
        }
        if (this.f146230l == 1) {
            return true;
        }
        return false;
    }

    public final boolean o() {
        if (this.f146219a != null && e()) {
            try {
                List<String> supportedFlashModes = this.f146219a.getParameters().getSupportedFlashModes();
                if (supportedFlashModes != null && supportedFlashModes.contains("torch")) {
                    return true;
                }
                w.d("Luggage.WxScanCamera", "camera not support flash!!");
                return false;
            } catch (Exception e16) {
                w.b("Luggage.WxScanCamera", "isFlashSupported error: " + e16.getMessage());
                return false;
            }
        }
        return false;
    }

    public void p() {
        w.d("Luggage.WxScanCamera", String.format("openFlash, camera: %s, isPreviewing: %s", this.f146219a, Boolean.valueOf(e())));
        if (this.f146219a != null && e()) {
            try {
                this.f146229k = true;
                Camera.Parameters parameters = this.f146219a.getParameters();
                List<String> supportedFlashModes = parameters.getSupportedFlashModes();
                if (supportedFlashModes != null && supportedFlashModes.contains("torch")) {
                    parameters.setFlashMode("torch");
                    this.f146219a.setParameters(parameters);
                    w.d("Luggage.WxScanCamera", "open flash");
                } else {
                    w.d("Luggage.WxScanCamera", "camera not support flash!!");
                }
            } catch (Exception e16) {
                w.b("Luggage.WxScanCamera", "openFlash error: " + e16.getMessage());
            }
        }
    }
}
