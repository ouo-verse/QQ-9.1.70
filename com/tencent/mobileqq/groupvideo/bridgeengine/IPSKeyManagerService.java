package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import java.util.List;

@Keep
/* loaded from: classes12.dex */
public interface IPSKeyManagerService extends IBaseService {
    void getPSKey(List<String> list, IPSKeyManagerCallback iPSKeyManagerCallback) throws NoSuchMethodException;

    void registerPSKeyListener(IGroupVideoPSKeyListener iGroupVideoPSKeyListener);

    void replacePSKey(List<String> list, IPSKeyManagerCallback iPSKeyManagerCallback) throws NoSuchMethodException;

    void unRegisterPSKeyListener(IGroupVideoPSKeyListener iGroupVideoPSKeyListener);
}
