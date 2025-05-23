package com.tencent.ams.fusion.widget.tma;

import android.content.Context;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.OnActivityLifecycleChanged;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.ams.music.widget.blowingdetection.blow.BlowingDetector;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VoiceRecorder implements OnActivityLifecycleChanged.OnActivityLifecycleChangedListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "VoiceRecorder";
    private final BlowingDetector mBlowingDetector;
    private final Context mContext;
    private int mCurrentActivityState;
    private final AtomicBoolean mIsStart;

    public VoiceRecorder(Context context, int i3, int i16, int i17, BlowingDetector.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), cVar);
            return;
        }
        this.mIsStart = new AtomicBoolean(false);
        this.mContext = context;
        this.mBlowingDetector = new BlowingDetector(i3, i16, i17, cVar);
        OnActivityLifecycleChanged.addListener(context, this);
        Logger.d(TAG, "sampleRate:" + i3 + " t1:" + i16 + " count:" + i17);
    }

    private void startRecordIfNeed() {
        int i3 = this.mCurrentActivityState;
        if (i3 != 3 && i3 != 5 && i3 != 6 && Utils.isAppOnForeground(this.mContext)) {
            if (this.mIsStart.getAndSet(true)) {
                Logger.d(TAG, "startRecordIfNeed has started");
                return;
            } else {
                if (this.mBlowingDetector != null) {
                    Logger.d(TAG, "startRecordIfNeed start");
                    this.mBlowingDetector.l();
                    return;
                }
                return;
            }
        }
        Logger.d(TAG, "startRecordIfNeed failed: in background");
    }

    @Override // com.tencent.ams.fusion.widget.utils.OnActivityLifecycleChanged.OnActivityLifecycleChangedListener
    public void onChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        Logger.i(TAG, "onChanged, state: " + i3);
        this.mCurrentActivityState = i3;
    }

    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        BlowingDetector blowingDetector = this.mBlowingDetector;
        if (blowingDetector != null) {
            blowingDetector.k();
        }
        OnActivityLifecycleChanged.removeListener(this);
    }

    public void startDetect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (this.mBlowingDetector != null) {
            startRecordIfNeed();
        }
    }

    public void stopDetect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        BlowingDetector blowingDetector = this.mBlowingDetector;
        if (blowingDetector != null) {
            blowingDetector.m();
        }
        this.mIsStart.set(false);
    }
}
