package com.tencent.freesia;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface MSFObserverCenter {
    public static final IPatchRedirector $redirector_ = null;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class CppProxy implements MSFObserverCenter {
        public static final /* synthetic */ boolean $assertionsDisabled;
        static IPatchRedirector $redirector_;
        private final AtomicBoolean destroyed;
        private final long nativeRef;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12245);
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
        public static native MSFObserverCenter getInstance();

        private native void nativeDestroy(long j3);

        private native void native_onReceive(long j3, boolean z16, int i3, String str, String str2, int i16, GetConfigRsp getConfigRsp);

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

        @Override // com.tencent.freesia.MSFObserverCenter
        public void onReceive(boolean z16, int i3, String str, String str2, int i16, GetConfigRsp getConfigRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, str2, Integer.valueOf(i16), getConfigRsp);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_onReceive(this.nativeRef, z16, i3, str, str2, i16, getConfigRsp);
            }
        }
    }

    void onReceive(boolean z16, int i3, @NonNull String str, @NonNull String str2, int i16, @NonNull GetConfigRsp getConfigRsp);
}
