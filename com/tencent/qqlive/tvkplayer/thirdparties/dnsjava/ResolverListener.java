package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import java.util.EventListener;

/* compiled from: P */
@Deprecated
/* loaded from: classes23.dex */
public interface ResolverListener extends EventListener {
    void handleException(Object obj, Exception exc);

    void receiveMessage(Object obj, Message message);
}
