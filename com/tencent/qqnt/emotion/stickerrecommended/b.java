package com.tencent.qqnt.emotion.stickerrecommended;

import com.tencent.aio.data.AIOParam;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.emotion.stickerrecommended.impl.StickerRecManagerImpl;

/* compiled from: P */
/* loaded from: classes24.dex */
public abstract class b implements h<AIOParam> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected BaseQQAppInterface f356489a;

    public b(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        } else {
            this.f356489a = baseQQAppInterface;
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.h
    public boolean a(BaseQQAppInterface baseQQAppInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseQQAppInterface, (Object) str)).booleanValue();
        }
        IStickerRecManager iStickerRecManager = StickerRecManagerImpl.get(baseQQAppInterface);
        if (iStickerRecManager != null) {
            return iStickerRecManager.isHandleKeyword(str);
        }
        return false;
    }
}
