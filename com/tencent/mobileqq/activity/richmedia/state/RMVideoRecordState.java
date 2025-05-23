package com.tencent.mobileqq.activity.richmedia.state;

import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import yq2.d;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RMVideoRecordState extends e {

    /* renamed from: a, reason: collision with root package name */
    private boolean f185884a = false;

    /* renamed from: b, reason: collision with root package name */
    private long f185885b = 0;

    private void i() {
        RMVideoStateMgr u16 = RMVideoStateMgr.u();
        if (QLog.isColorLevel()) {
            QLog.d("RMRecordState", 2, "[@] [startRecordVideo]Lock.CAPTURE_LOCK=" + com.tencent.mobileqq.shortvideo.mediadevice.b.f288186b);
        }
        if (!com.tencent.mobileqq.shortvideo.mediadevice.b.f288186b) {
            synchronized (com.tencent.mobileqq.shortvideo.mediadevice.b.f288185a) {
                com.tencent.mobileqq.shortvideo.mediadevice.b.f288186b = true;
                com.tencent.mobileqq.shortvideo.mediadevice.b.f288185a.notifyAll();
            }
            if (QLog.isColorLevel()) {
                QLog.d("RMRecordState", 2, "[@] [startRecordVideo]Lock.CAPTURE_LOCK=" + com.tencent.mobileqq.shortvideo.mediadevice.b.f288186b);
            }
            AVCodec.get().startCapture();
            u16.I.startCapture();
            if (u16.C()) {
                u16.W();
            }
            if (u16.J != null && u16.F()) {
                u16.J.s();
            }
            this.f185885b = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.e
    public void a() {
        j();
        RMVideoStateMgr u16 = RMVideoStateMgr.u();
        u16.f(2);
        u16.startWatching();
        if (QLog.isColorLevel()) {
            QLog.d("RMRecordState", 2, "[@] [RMFileEventNotify]startWatching");
        }
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.e
    public void b() {
        RMVideoStateMgr u16 = RMVideoStateMgr.u();
        u16.Q.W();
        u16.stopWatching();
        if (QLog.isColorLevel()) {
            QLog.d("RMRecordState", 2, "[@] [RMFileEventNotify]stopWatching");
        }
        this.f185884a = false;
        i();
        if (QLog.isColorLevel()) {
            QLog.d("RMRecordState", 2, "[@] initState end");
        }
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.e
    public void e() {
        a();
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.e
    public void h(d.a aVar, boolean z16, int i3, int i16) {
        RMVideoStateMgr u16 = RMVideoStateMgr.u();
        if (u16.f185893d) {
            u16.H = System.currentTimeMillis() - u16.f185895e;
        } else {
            u16.H = i3;
        }
        if (!this.f185884a) {
            this.f185884a = z16;
            if (u16.z() && !u16.J.f288066r && !u16.V) {
                u16.f185906l0.post(new Runnable() { // from class: com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.2
                    @Override // java.lang.Runnable
                    public void run() {
                        RMVideoStateMgr u17 = RMVideoStateMgr.u();
                        if (QLog.isColorLevel()) {
                            QLog.d("RMRecordState", 2, "[@] EVENT_READ_MIC [error]\u9ea6\u514b\u98ce\u8bfb\u53d6\u6570\u636e\u9519\u8bef...");
                        }
                        u17.V = true;
                        u17.L = false;
                        AudioCapture audioCapture = u17.J;
                        if (audioCapture != null) {
                            if (audioCapture.f288067s == -1) {
                                u17.b(0, HardCodeUtil.qqStr(R.string.t2d), false);
                            } else if (u17.J.f288067s == -2) {
                                u17.b(0, HardCodeUtil.qqStr(R.string.t2i), false);
                            } else if (u17.J.f288067s == -3) {
                                u17.b(0, HardCodeUtil.qqStr(R.string.t2k), false);
                            } else {
                                u17.b(0, HardCodeUtil.qqStr(R.string.t2g), false);
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("RMRecordState", 2, "[@] EVENT_READ_MIC [error]\u9ea6\u514b\u98ce\u88ab\u7981\u7528,\u97f3\u9891\u5f55\u5236\u5931\u8d25 errorcode=" + u17.J.f288067s);
                            }
                        }
                    }
                });
            }
            if (QLog.isColorLevel()) {
                QLog.d("RMRecordState", 2, "[@] timeExpire: mIsRecordOver=" + this.f185884a + " mStateMgr.mTotalTime=" + u16.H);
            }
            u16.Q.D((int) (u16.H + com.tencent.mobileqq.shortvideo.mediadevice.c.b().e().b()), this.f185884a);
            if (this.f185884a) {
                u16.f185906l0.post(new Runnable() { // from class: com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.3
                    @Override // java.lang.Runnable
                    public void run() {
                        RMVideoStateMgr u17 = RMVideoStateMgr.u();
                        if (!u17.B()) {
                            hd0.c.k("RMRecordState", "run record finish, but state is not right");
                        } else {
                            RMVideoRecordState.this.a();
                            u17.Q.M();
                        }
                    }
                });
            }
        }
    }

    public void j() {
        final RMVideoStateMgr u16 = RMVideoStateMgr.u();
        if (QLog.isColorLevel()) {
            QLog.d("RMRecordState", 2, "[@] [stopRecordVideo]Lock.CAPTURE_LOCK = " + com.tencent.mobileqq.shortvideo.mediadevice.b.f288186b);
        }
        if (com.tencent.mobileqq.shortvideo.mediadevice.b.f288186b) {
            com.tencent.mobileqq.shortvideo.mediadevice.b.f288186b = false;
            long currentTimeMillis = System.currentTimeMillis();
            this.f185885b = currentTimeMillis - this.f185885b;
            if (QLog.isColorLevel()) {
                QLog.d("RMRecordState", 2, "[@] [stopRecordVideo] current=" + currentTimeMillis + " timestamp=" + this.f185885b);
            }
            if (this.f185884a) {
                u16.H = CodecParam.RECORD_MAX_TIME;
            }
            u16.Q.U();
            u16.I.stopCapture();
            AudioCapture audioCapture = u16.J;
            if (audioCapture != null) {
                audioCapture.u();
            }
            if (u16.C()) {
                com.tencent.mobileqq.shortvideo.util.a aVar = u16.X;
                if (aVar != null) {
                    u16.Y = aVar.b(u16);
                }
                u16.X();
            }
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread, false).post(new Runnable() { // from class: com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.1
                @Override // java.lang.Runnable
                public void run() {
                    PreviewContext previewContext = u16.I;
                    if (previewContext != null) {
                        previewContext.unlockFrameSync();
                    }
                }
            });
            AVCodec.get().stopCapture();
            long q16 = u16.Q.q();
            if (QLog.isColorLevel()) {
                QLog.d("RMRecordState", 2, "[@] [stopRecordVideo] timeLimit=" + q16 + " timestamp=" + this.f185885b);
            }
            if (q16 == -1) {
                q16 = this.f185885b;
            }
            if (q16 < 500 && !this.f185884a) {
                u16.Q.m(true);
                u16.D(true);
            }
            if (QLog.isColorLevel()) {
                QLog.d("RMRecordState", 2, "[@] stopRecordVideo end Lock.CAPTURE_LOCK = " + com.tencent.mobileqq.shortvideo.mediadevice.b.f288186b);
            }
        }
    }
}
