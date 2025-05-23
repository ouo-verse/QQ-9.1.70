package com.tencent.mobileqq.zootopia.ipc;

import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;

/* compiled from: P */
@ServletImpl(impl = ZootopiaOpenIdRemoteManagerImpl.class)
/* loaded from: classes35.dex */
public interface ac {
    void getOpenIdInfo(ZootopiaSource zootopiaSource, String str, ab abVar);

    void getOpenIdInfoSilent(ab abVar);

    void reAuthOpenId(ZootopiaSource zootopiaSource, String str, ab abVar);

    void reAuthOpenIdSilent(ab abVar);

    void reAuthorization(ab abVar);
}
