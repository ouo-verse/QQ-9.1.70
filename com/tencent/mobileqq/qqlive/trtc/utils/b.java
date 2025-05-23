package com.tencent.mobileqq.qqlive.trtc.utils;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, a> f273377a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<ViewGroup> f273378a;

        /* renamed from: b, reason: collision with root package name */
        public TXCloudVideoView f273379b;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public TXCloudVideoView a(WeakReference<ViewGroup> weakReference, Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (TXCloudVideoView) iPatchRedirector.redirect((short) 3, (Object) this, (Object) weakReference, (Object) context);
            }
            this.f273378a = weakReference;
            if (weakReference != null && weakReference.get() != null) {
                if (this.f273379b == null && context != null) {
                    this.f273379b = new TXCloudVideoView(context);
                }
                weakReference.get().addView(this.f273379b);
                return this.f273379b;
            }
            return null;
        }

        public void b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            WeakReference<ViewGroup> weakReference = this.f273378a;
            if (weakReference != null && weakReference.get() != null) {
                this.f273378a.get().removeView(this.f273379b);
            }
            if (z16) {
                this.f273379b = null;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61772);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f273377a = new ConcurrentHashMap<>();
        }
    }

    public static void a() {
        Iterator<String> it = f273377a.keySet().iterator();
        while (it.hasNext()) {
            d(it.next(), true);
        }
        f273377a.clear();
    }

    public static void b(String str) {
        QLog.i("RTCRemoteViewManager", 1, "clearView. " + str);
        d(str, true);
        f273377a.remove(str);
    }

    public static TXCloudVideoView c(String str, WeakReference<ViewGroup> weakReference, Context context) {
        Integer valueOf;
        ConcurrentHashMap<String, a> concurrentHashMap = f273377a;
        a aVar = concurrentHashMap.get(str);
        if (aVar != null) {
            aVar.b(false);
        } else {
            aVar = new a();
            concurrentHashMap.put(str, aVar);
        }
        TXCloudVideoView a16 = aVar.a(weakReference, context);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getTxCloudVideoView:  userid: ");
        sb5.append(str);
        sb5.append(" viewid: ");
        if (a16 == null) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(a16.hashCode());
        }
        sb5.append(valueOf);
        QLog.i("RTCRemoteViewManager", 1, sb5.toString());
        return a16;
    }

    private static void d(String str, boolean z16) {
        a aVar = f273377a.get(str);
        if (aVar != null) {
            QLog.i("RTCRemoteViewManager", 1, "internalResetView. " + aVar + " deleteTxVideoView: " + z16);
            aVar.b(z16);
        }
    }

    public static void e(String str) {
        QLog.i("RTCRemoteViewManager", 1, "resetView. " + str);
        d(str, false);
    }
}
