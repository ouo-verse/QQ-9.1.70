package com.tencent.oskplayer.service;

import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface DNSService {
    String fastResolve(String str);

    boolean isNetReachable();

    String resolve(String str);

    String resolve(String str, long j3, TimeUnit timeUnit);
}
