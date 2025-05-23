package com.tencent.tedger;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.api.IInitStateManager;
import com.tencent.tedger.outapi.api.ITEdgeRSServer;
import com.tencent.tedger.outapi.delegate.f;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static ITEdgeRSServer a(@NonNull ITEdgeRSServer.a aVar, @NonNull f fVar, IInitStateManager.a aVar2) {
        return new TEdgeBusinessCenter(aVar, fVar, aVar2);
    }
}
