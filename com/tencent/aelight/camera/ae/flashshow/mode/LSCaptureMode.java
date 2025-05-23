package com.tencent.aelight.camera.ae.flashshow.mode;

import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public enum LSCaptureMode {
    NORMAL(0, R.string.ihw, "camera"),
    PLAY(1, R.string.ihx, "play") { // from class: com.tencent.aelight.camera.ae.flashshow.mode.LSCaptureMode.1
        @Override // com.tencent.aelight.camera.ae.flashshow.mode.LSCaptureMode
        public boolean shouldStartCamera() {
            return false;
        }
    },
    GIF(2, R.string.ihv, "gif"),
    ARCAKE(3, R.string.ihv, AECameraConstants.AECAMERA_MODE_ARCAKE);

    private boolean hasCountDown;
    public final int index;
    public final String name;
    public final int textId;

    LSCaptureMode(int i3, int i16, String str) {
        this.index = i3;
        this.textId = i16;
        this.name = str;
    }

    public static LSCaptureMode fromName(String str) {
        for (LSCaptureMode lSCaptureMode : values()) {
            if (lSCaptureMode.name.equals(str)) {
                return lSCaptureMode;
            }
        }
        return null;
    }

    public boolean getHasCountDown() {
        return this.hasCountDown;
    }

    public void setHasCountDown(boolean z16) {
        this.hasCountDown = z16;
    }

    public boolean shouldStartCamera() {
        return true;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name() + " index=" + this.index;
    }
}
