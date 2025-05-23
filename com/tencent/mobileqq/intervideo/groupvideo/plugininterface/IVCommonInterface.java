package com.tencent.mobileqq.intervideo.groupvideo.plugininterface;

import android.os.Bundle;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface IVCommonInterface {
    Future<Bundle> getLocation(String str);

    void setHostActivityCallback(IVHostCallback iVHostCallback);
}
