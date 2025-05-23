package com.tencent.tavkit.ciimage;

import android.opengl.GLES20;
import com.tencent.avcore.jni.audiodevice.TraeAudioManager;
import com.tencent.tav.decoder.logger.Logger;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes26.dex */
class GLBlendStateCache {
    private static final String TAG = "GLBlendStateCache";
    private boolean isEnabled;
    private final int[] pNames = {TraeAudioManager.CustomHandler.MSG_VOICE_CALL_POST_PROCESS, TraeAudioManager.CustomHandler.MSG_VOICE_CALL_POST_PROCESS, 34877, 32969, 32968, 32971, 32970};
    private final int[] params = new int[7];

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void cache() {
        boolean glIsEnabled = GLES20.glIsEnabled(3042);
        this.isEnabled = glIsEnabled;
        if (!glIsEnabled) {
            return;
        }
        int i3 = 0;
        while (true) {
            int[] iArr = this.pNames;
            if (i3 < iArr.length) {
                GLES20.glGetIntegerv(iArr[i3], this.params, i3);
                i3++;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void restore() {
        Logger.v(TAG, "restore: params = " + Arrays.toString(this.params));
        if (this.isEnabled) {
            GLES20.glEnable(3042);
            GLES20.glBlendEquation(this.params[0]);
            int[] iArr = this.params;
            GLES20.glBlendEquationSeparate(iArr[1], iArr[2]);
            int[] iArr2 = this.params;
            GLES20.glBlendFuncSeparate(iArr2[3], iArr2[4], iArr2[5], iArr2[6]);
        } else {
            GLES20.glDisable(3042);
        }
    }
}
