package com.tencent.biz.richframework.video;

import android.media.AudioManager;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWAudioFocusManager {
    private static volatile RFWAudioFocusManager sInstance;
    private AudioManager mAudioManger;
    private boolean mHasFocus;
    private final AudioManager.OnAudioFocusChangeListener mListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.tencent.biz.richframework.video.RFWAudioFocusManager.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i3) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.video.RFWAudioFocusManager.1.1
                @Override // java.lang.Runnable
                public void run() {
                    int i16 = i3;
                    if (i16 == -3 || i16 == -2 || i16 == -1) {
                        RFWAudioFocusManager.this.mHasFocus = false;
                        QLog.d("RFWAudioFocusManager", 1, "onAudioFocusChange, loss focus:" + i3);
                        return;
                    }
                    if (i16 == 1 || i16 == 2 || i16 == 3) {
                        RFWAudioFocusManager.this.mHasFocus = true;
                        QLog.d("RFWAudioFocusManager", 1, "onAudioFocusChange, gain focus:" + i3);
                        return;
                    }
                    QLog.d("RFWAudioFocusManager", 1, "onAudioFocusChange:" + i3);
                }
            });
        }
    };

    RFWAudioFocusManager() {
    }

    public static RFWAudioFocusManager g() {
        if (sInstance == null) {
            synchronized (RFWAudioFocusManager.class) {
                if (sInstance == null) {
                    sInstance = new RFWAudioFocusManager();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void initAudioManger() {
        this.mAudioManger = (AudioManager) RFWApplication.getApplication().getSystemService("audio");
    }

    public void releaseAudioFocus() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.video.RFWAudioFocusManager.3
            @Override // java.lang.Runnable
            public void run() {
                if (RFWAudioFocusManager.this.mAudioManger == null) {
                    QLog.d("RFWAudioFocusManager", 1, "releaseAudioFocus mAudioManger == null");
                    return;
                }
                if (!RFWAudioFocusManager.this.mHasFocus) {
                    QLog.d("RFWAudioFocusManager", 1, "releaseAudioFocus not has focus ");
                    return;
                }
                QLog.d("RFWAudioFocusManager", 1, "releaseAudioFocus \uff1a" + RFWAudioFocusManager.this.mListener);
                int abandonAudioFocus = RFWAudioFocusManager.this.mAudioManger.abandonAudioFocus(RFWAudioFocusManager.this.mListener);
                QLog.d("RFWAudioFocusManager", 1, "releaseAudioFocus result:" + abandonAudioFocus + RFWAudioFocusManager.this.mListener);
                if (abandonAudioFocus == 1) {
                    RFWAudioFocusManager.this.mHasFocus = false;
                }
            }
        });
    }

    public void requestAudioFocus() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.video.RFWAudioFocusManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (RFWAudioFocusManager.this.mAudioManger == null) {
                    RFWAudioFocusManager.this.initAudioManger();
                }
                if (RFWAudioFocusManager.this.mAudioManger == null) {
                    return;
                }
                if (RFWAudioFocusManager.this.mHasFocus) {
                    QLog.d("RFWAudioFocusManager", 1, "requestAudioFocus hasFocus ");
                    return;
                }
                int requestAudioFocus = RFWAudioFocusManager.this.mAudioManger.requestAudioFocus(RFWAudioFocusManager.this.mListener, 3, 2);
                QLog.d("RFWAudioFocusManager", 1, "requestAudioFocus result:" + requestAudioFocus + RFWAudioFocusManager.this.mListener);
                if (requestAudioFocus == 1) {
                    RFWAudioFocusManager.this.mHasFocus = true;
                }
            }
        });
    }
}
