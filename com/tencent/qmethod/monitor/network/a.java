package com.tencent.qmethod.monitor.network;

import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u0000 \b2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qmethod/monitor/network/a;", "", "Ljava/net/URL;", "url", "", "a", "<init>", "()V", "d", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public abstract class a {
    public final int a(@Nullable URL url) {
        if (url == null) {
            return 1;
        }
        return 1 ^ (Intrinsics.areEqual(url.getProtocol(), "http") ? 1 : 0);
    }
}
