package com.tencent.could.aicamare.enums;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes5.dex */
public final class CameraZoom {
    private static final /* synthetic */ CameraZoom[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final CameraZoom ZOOM_1X;
    public static final CameraZoom ZOOM_1_5X;
    public static final CameraZoom ZOOM_2X;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13851);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        CameraZoom cameraZoom = new CameraZoom("ZOOM_1X", 0);
        ZOOM_1X = cameraZoom;
        CameraZoom cameraZoom2 = new CameraZoom("ZOOM_1_5X", 1);
        ZOOM_1_5X = cameraZoom2;
        CameraZoom cameraZoom3 = new CameraZoom("ZOOM_2X", 2);
        ZOOM_2X = cameraZoom3;
        $VALUES = new CameraZoom[]{cameraZoom, cameraZoom2, cameraZoom3};
    }

    CameraZoom(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static CameraZoom valueOf(String str) {
        return (CameraZoom) Enum.valueOf(CameraZoom.class, str);
    }

    public static CameraZoom[] values() {
        return (CameraZoom[]) $VALUES.clone();
    }
}
