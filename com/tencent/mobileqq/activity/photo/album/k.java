package com.tencent.mobileqq.activity.photo.album;

import NS_MOBILE_PHOTO.get_albumlist_num_rsp;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class k extends l {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<h> f184268d;

    public k(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hVar);
        } else {
            this.f184268d = new WeakReference<>(hVar);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.l
    protected void a(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
            return;
        }
        WeakReference<h> weakReference = this.f184268d;
        if (weakReference != null && weakReference.get() != null) {
            Serializable serializable = bundle.getSerializable("data");
            if (z16 && (serializable instanceof get_albumlist_num_rsp)) {
                this.f184268d.get().f184246d = ((get_albumlist_num_rsp) serializable).album_num;
                this.f184268d.get().f184247e = true;
            }
            MobileQQ.sMobileQQ.peekAppRuntime().unRegistObserver(this);
            this.f184268d.clear();
            this.f184268d = null;
        }
    }
}
