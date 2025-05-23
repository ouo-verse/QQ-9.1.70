package com.tencent.mobileqq.zootopia.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;

/* compiled from: P */
@ServletImpl(impl = ZootopiaEnterAvatarSceneManagerImpl.class)
/* loaded from: classes35.dex */
public interface r {
    void enterAvatarResidence();

    void enterAvatarScene(int i3, String str, Boolean bool, q qVar);

    void enterPortal(ZootopiaSource zootopiaSource, Bundle bundle, s sVar);

    void registerEnterAvatarSceneListener(com.tencent.mobileqq.zootopia.lua.i iVar);

    void unRegisterEnterAvatarSceneListener(com.tencent.mobileqq.zootopia.lua.i iVar);
}
