package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import android.os.Bundle;
import com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVCommonInterface;
import com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVHostCallback;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes33.dex */
public class IVCommonImpl implements IVCommonInterface {
    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVCommonInterface
    public Future<Bundle> getLocation(String str) {
        return IVCommonInterfaceImpl.getInstance().getLocation(str);
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVCommonInterface
    public void setHostActivityCallback(IVHostCallback iVHostCallback) {
        IVCommonInterfaceImpl.getInstance().setHostActivityCallback(iVHostCallback);
    }
}
