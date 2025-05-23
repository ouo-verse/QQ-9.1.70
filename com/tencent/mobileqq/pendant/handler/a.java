package com.tencent.mobileqq.pendant.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.pendant.view.PendantAvatarShopLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.inject.IAvatarPendantView;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends Handler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<IAvatarPendantView> f257512a;

    public a(IAvatarPendantView iAvatarPendantView) {
        super(Looper.getMainLooper());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iAvatarPendantView);
        } else {
            this.f257512a = new WeakReference<>(iAvatarPendantView);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            return;
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    int i16 = message.arg2;
                    Object obj = message.obj;
                    if (obj instanceof PendantAvatarShopLayout) {
                        PendantAvatarShopLayout pendantAvatarShopLayout = (PendantAvatarShopLayout) obj;
                        pendantAvatarShopLayout.r(pendantAvatarShopLayout.u(i16));
                        PendantAvatarShopLayout.D = false;
                        return;
                    }
                    return;
                }
                return;
            }
            int i17 = message.arg1;
            int i18 = message.arg2;
            IAvatarPendantView iAvatarPendantView = this.f257512a.get();
            if (iAvatarPendantView != null && i17 != 0) {
                if (i18 == 23) {
                    Object obj2 = message.obj;
                    if (obj2 instanceof String) {
                        str = (String) obj2;
                    } else {
                        str = "";
                    }
                    iAvatarPendantView.setAvatar(i17, str);
                    return;
                }
                if (i18 == 4) {
                    iAvatarPendantView.setPendant(i17);
                    return;
                }
                return;
            }
            return;
        }
        PendantAvatarShopLayout.D = false;
    }
}
