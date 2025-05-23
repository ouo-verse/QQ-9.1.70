package com.tencent.freesia;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public interface HTTPObserverCenter {
    public static final IPatchRedirector $redirector_ = null;

    /* loaded from: classes6.dex */
    public static final class CppProxy implements HTTPObserverCenter {
        public static final /* synthetic */ boolean $assertionsDisabled;
        static IPatchRedirector $redirector_;
        private final AtomicBoolean destroyed;
        private final long nativeRef;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8251);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                $assertionsDisabled = true;
            }
        }

        CppProxy(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, j3);
                return;
            }
            this.destroyed = new AtomicBoolean(false);
            if (j3 != 0) {
                this.nativeRef = j3;
                return;
            }
            throw new RuntimeException("nativeRef is zero");
        }

        @Nullable
        public static native HTTPObserverCenter getInstance();

        private native void nativeDestroy(long j3);

        private native void native_onResult(long j3, int i3, boolean z16, HTTPResponse hTTPResponse);

        public void _djinni_private_destroy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        public void finalize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                _djinni_private_destroy();
                super.finalize();
            }
        }

        @Override // com.tencent.freesia.HTTPObserverCenter
        public void onResult(int i3, boolean z16, HTTPResponse hTTPResponse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16), hTTPResponse);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_onResult(this.nativeRef, i3, z16, hTTPResponse);
            }
        }
    }

    void onResult(int i3, boolean z16, @NonNull HTTPResponse hTTPResponse);
}
