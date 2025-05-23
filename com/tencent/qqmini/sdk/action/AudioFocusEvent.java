package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AudioFocusEvent implements Action<Boolean> {
    public static final int FOCUS_GAIN = 1;
    public static final int FOCUS_LOSS = 2;
    private static final String TAG = "UpdateUIEvent";
    private int what;

    AudioFocusEvent() {
    }

    public static AudioFocusEvent obtain(int i3) {
        AudioFocusEvent audioFocusEvent = new AudioFocusEvent();
        audioFocusEvent.what = i3;
        return audioFocusEvent;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public Boolean perform(BaseRuntime baseRuntime) {
        int i3 = this.what;
        if (i3 == 1) {
            baseRuntime.handleFocusGain();
        } else if (i3 == 2) {
            baseRuntime.handleFocusLoss();
        }
        return Boolean.TRUE;
    }
}
