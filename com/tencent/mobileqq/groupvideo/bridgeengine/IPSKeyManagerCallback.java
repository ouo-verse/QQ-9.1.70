package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import java.util.Map;

@Keep
/* loaded from: classes12.dex */
public interface IPSKeyManagerCallback {
    void onFail(String str);

    void onSuccess(String str, Map<String, String> map);
}
