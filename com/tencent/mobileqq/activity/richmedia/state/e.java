package com.tencent.mobileqq.activity.richmedia.state;

import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.qphone.base.util.QLog;
import yq2.d;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class e {
    public abstract void a();

    public abstract void b();

    public void c(Object obj, int i3, Object... objArr) {
        g gVar;
        if (QLog.isColorLevel()) {
            QLog.d("RMVideoState", 2, "[@] notify called eventId=" + i3);
        }
        RMVideoStateMgr u16 = RMVideoStateMgr.u();
        if (obj instanceof AudioCapture) {
            if (i3 == 9) {
                u16.O();
                return;
            }
            return;
        }
        if (obj instanceof CameraProxy.CameraPreviewObservable) {
            QLog.d("faceuu", 2, " notify EVENT_SET_CAMERA_PARAM eventId" + i3 + ", rmStateMgr:" + u16);
            if (u16 != null) {
                if (i3 != 2) {
                    if (i3 == 10) {
                        if (QLog.isColorLevel()) {
                            QLog.d("faceuu", 2, "RMVideoState viewST:" + u16.Q);
                        }
                        g gVar2 = u16.Q;
                        if (gVar2 != null) {
                            gVar2.C();
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (objArr != null && (gVar = u16.Q) != null) {
                    Object obj2 = objArr[0];
                    if (obj2 instanceof CameraControl.b) {
                        CameraControl.b bVar = (CameraControl.b) obj2;
                        try {
                            gVar.e0(bVar.f288111a, bVar.f288112b);
                            QLog.d("RMVideoState", 2, "[@] EVENT_SET_CAMERA_PARAM[success]");
                            return;
                        } catch (NullPointerException e16) {
                            e16.printStackTrace();
                            QLog.d("RMVideoState", 2, "[@] EVENT_SET_CAMERA_PARAM:rmStateMgr=" + u16 + " viewST=" + u16.Q);
                            return;
                        }
                    }
                    QLog.d("RMVideoState", 2, "[@] EVENT_SET_CAMERA_PARAM: no CustomSize obj[0]=" + objArr[0]);
                    return;
                }
                QLog.d("RMVideoState", 2, "[@] EVENT_SET_CAMERA_PARAM[2]:obj=" + objArr);
                if (u16 != null) {
                    QLog.d("RMVideoState", 2, "[@] EVENT_SET_CAMERA_PARAM[2]:viewST=" + u16.Q);
                    return;
                }
                return;
            }
            QLog.d("faceuu", 2, " notify EVENT_SET_CAMERA_PARAM  rmStateMgr==null");
        }
    }

    public void e() {
    }

    public void f() {
    }

    public void g(boolean z16) {
    }

    public void d(AVCodec.AVCodecCallback aVCodecCallback, MessageStruct messageStruct) {
    }

    public void h(d.a aVar, boolean z16, int i3, int i16) {
    }
}
