package com.tencent.youtu.sdkkitframework.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes27.dex */
public class BytesPoolHelper {
    static IPatchRedirector $redirector_ = null;
    private static final int MAX_POOL_SIZE = 10;
    private SimplePool<byte[]> simplePool;

    /* loaded from: classes27.dex */
    public static final class ByteBufferPoolHelperHolder {
        static IPatchRedirector $redirector_;
        private static final BytesPoolHelper INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17298);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                INSTANCE = new BytesPoolHelper(null);
            }
        }

        ByteBufferPoolHelperHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public /* synthetic */ BytesPoolHelper(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) anonymousClass1);
    }

    public static BytesPoolHelper getInstance() {
        return ByteBufferPoolHelperHolder.INSTANCE;
    }

    public byte[] acquire() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        synchronized (BytesPoolHelper.class) {
            SimplePool<byte[]> simplePool = this.simplePool;
            if (simplePool == null) {
                return null;
            }
            return simplePool.acquire();
        }
    }

    public byte[] copy(byte[] bArr, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (byte[]) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bArr, (Object) bArr2);
        }
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        return bArr;
    }

    public void recycleAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.simplePool = new SimplePool<>(10);
        }
    }

    public boolean release(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr)).booleanValue();
        }
        synchronized (BytesPoolHelper.class) {
            SimplePool<byte[]> simplePool = this.simplePool;
            if (simplePool == null) {
                return false;
            }
            return simplePool.release(bArr);
        }
    }

    BytesPoolHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
