package com.tencent.mobileqq.haoliyou.sso;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes7.dex */
public class CheckForwardObserver implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: id, reason: collision with root package name */
    private int f236762id;
    private final SparseArray<WeakReference<OnCheckShareListener>> listeners;

    public CheckForwardObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.listeners = new SparseArray<>();
        }
    }

    private void handleCheckShareRes(boolean z16, Bundle bundle) {
        OnCheckShareListener onCheckShareListener;
        if (bundle == null) {
            return;
        }
        int i3 = bundle.getInt(CheckForwardServlet.KEY_REQ_ID);
        synchronized (this.listeners) {
            WeakReference<OnCheckShareListener> weakReference = this.listeners.get(i3);
            if (weakReference != null) {
                onCheckShareListener = weakReference.get();
                if (onCheckShareListener == null) {
                    this.listeners.delete(i3);
                    return;
                }
            } else {
                onCheckShareListener = null;
            }
            OnCheckShareListener onCheckShareListener2 = onCheckShareListener;
            int i16 = bundle.getInt("result");
            int i17 = bundle.getInt("jump_result");
            String string = bundle.getString("jump_url");
            String string2 = bundle.getString("ext_info");
            if (onCheckShareListener2 != null) {
                onCheckShareListener2.onResponse(z16, i16, i17, string, string2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int addOnCheckShareListener(OnCheckShareListener onCheckShareListener) {
        int i3;
        synchronized (this.listeners) {
            SparseArray<WeakReference<OnCheckShareListener>> sparseArray = this.listeners;
            int i16 = this.f236762id + 1;
            this.f236762id = i16;
            sparseArray.append(i16, new WeakReference<>(onCheckShareListener));
            i3 = this.f236762id;
        }
        return i3;
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
        } else if (i3 == 1) {
            handleCheckShareRes(z16, bundle);
        }
    }
}
