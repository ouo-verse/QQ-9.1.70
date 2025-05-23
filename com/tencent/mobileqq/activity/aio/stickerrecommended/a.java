package com.tencent.mobileqq.activity.aio.stickerrecommended;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class a implements d<com.tencent.mobileqq.activity.aio.p> {

    /* renamed from: a, reason: collision with root package name */
    protected BaseQQAppInterface f179902a;

    public a(BaseQQAppInterface baseQQAppInterface) {
        this.f179902a = baseQQAppInterface;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.d
    public boolean a(BaseQQAppInterface baseQQAppInterface, String str) {
        StickerRecManagerImpl stickerRecManagerImpl = StickerRecManagerImpl.get(baseQQAppInterface);
        if (stickerRecManagerImpl != null) {
            return stickerRecManagerImpl.isHandleKeyword(str);
        }
        return false;
    }
}
