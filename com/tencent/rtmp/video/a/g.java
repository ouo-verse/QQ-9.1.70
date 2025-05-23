package com.tencent.rtmp.video.a;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rtmp.video.BaseBridge;
import com.tencent.rtmp.video.TXScreenCapture;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes25.dex */
public final /* synthetic */ class g implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final f f368847a;

    g(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar);
        } else {
            this.f368847a = fVar;
        }
    }

    public static Runnable a(f fVar) {
        return new g(fVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXScreenCapture.TXScreenCaptureAssistantActivity tXScreenCaptureAssistantActivity;
        f fVar = this.f368847a;
        WeakReference<Activity> weakReference = fVar.f368832a;
        if (weakReference != null) {
            tXScreenCaptureAssistantActivity = (TXScreenCapture.TXScreenCaptureAssistantActivity) weakReference.get();
        } else {
            tXScreenCaptureAssistantActivity = null;
        }
        if (tXScreenCaptureAssistantActivity != null && !tXScreenCaptureAssistantActivity.isStop()) {
            BaseBridge.printLog("VirtualDisplayManager", "Activity is already started:".concat(String.valueOf(tXScreenCaptureAssistantActivity)));
            return;
        }
        if (fVar.f368836e != null) {
            BaseBridge.printLog("VirtualDisplayManager", "MediaProjection is already started:" + fVar.f368836e);
        } else {
            if (tXScreenCaptureAssistantActivity != null) {
                BaseBridge.printLog("VirtualDisplayManager", "Finish old activity:".concat(String.valueOf(tXScreenCaptureAssistantActivity)));
                tXScreenCaptureAssistantActivity.finish();
            }
            f.a();
        }
    }
}
