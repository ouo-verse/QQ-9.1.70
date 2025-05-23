package com.tencent.mobileqq.pic;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes16.dex */
public class x extends Handler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<PresendPicMgr> f258865a;

    public x(Looper looper, PresendPicMgr presendPicMgr) {
        super(looper);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper, (Object) presendPicMgr);
        } else {
            this.f258865a = new WeakReference<>(presendPicMgr);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            return;
        }
        PresendPicMgr presendPicMgr = this.f258865a.get();
        if (presendPicMgr != null) {
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    super.handleMessage(message);
                    return;
                } else {
                    f.b("PresendPicMgr", "PresendHandler", "handleMessage MSG_UNREGISTER_CLIENT_HANDLER");
                    presendPicMgr.f258575f = null;
                    return;
                }
            }
            f.b("PresendPicMgr", "PresendHandler", "handleMessage MSG_REGISTER_CLIENT_HANDLER");
            presendPicMgr.f258575f = message.replyTo;
            Message obtain = Message.obtain((Handler) null, 2);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator it = new ArrayList(presendPicMgr.f258571b).iterator();
            while (it.hasNext()) {
                arrayList.add(((z) it.next()).f258880e);
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(PeakConstants.FLAG_COMPRESSINFOLIST, arrayList);
            obtain.setData(bundle);
            try {
                presendPicMgr.f258575f.send(obtain);
            } catch (RemoteException e16) {
                presendPicMgr.f258575f = null;
                if (QLog.isColorLevel()) {
                    QLog.e("PresendPicMgr", 2, e16.getMessage(), e16);
                }
                e16.printStackTrace();
            }
            presendPicMgr.f258575f = null;
            presendPicMgr.m();
            presendPicMgr.l();
            return;
        }
        f.d("PresendPicMgr", "handleMessage", "PresendPicMgr == null!");
    }
}
