package com.tencent.mobileqq.qqgift.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import nh2.c;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGiftManagerImpl implements IQQGiftManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQGiftManagerImpl";
    private ConcurrentHashMap<Integer, c> mSdkImpls;

    public QQGiftManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mSdkImpls = new ConcurrentHashMap<>();
        }
    }

    @Override // com.tencent.mobileqq.qqgift.api.IQQGiftManager
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Iterator<c> it = this.mSdkImpls.values().iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
        this.mSdkImpls.clear();
    }

    @Override // com.tencent.mobileqq.qqgift.api.IQQGiftManager
    public void destroySDKImpl(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        c remove = this.mSdkImpls.remove(Integer.valueOf(i3));
        if (remove != null) {
            remove.destroy();
        }
    }

    @Override // com.tencent.mobileqq.qqgift.api.IQQGiftManager
    public c getSDKImpl(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        c cVar = this.mSdkImpls.get(Integer.valueOf(i3));
        if (cVar == null) {
            a43.a aVar = new a43.a();
            this.mSdkImpls.put(Integer.valueOf(i3), aVar);
            return aVar;
        }
        return cVar;
    }

    @Override // com.tencent.mobileqq.qqgift.api.IQQGiftManager
    public c removeSDKImpl(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (c) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        return this.mSdkImpls.remove(Integer.valueOf(i3));
    }
}
