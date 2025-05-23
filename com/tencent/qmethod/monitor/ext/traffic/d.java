package com.tencent.qmethod.monitor.ext.traffic;

import android.net.Uri;
import com.tencent.qmethod.pandoraex.core.o;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qmethod/monitor/ext/traffic/d;", "", "Lcom/tencent/qmethod/monitor/ext/traffic/NetworkCaptureCheckHttpTask;", "httpTask", "", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/qmethod/monitor/ext/traffic/HostSensitiveRecorder;", "Ljava/util/concurrent/ConcurrentHashMap;", "hostMap", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    public static final d f343723b = new d();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, HostSensitiveRecorder> hostMap = new ConcurrentHashMap<>();

    d() {
    }

    public void a(@NotNull NetworkCaptureCheckHttpTask httpTask) {
        Intrinsics.checkParameterIsNotNull(httpTask, "httpTask");
        try {
            Uri u16 = Uri.parse(httpTask.getUrl());
            Intrinsics.checkExpressionValueIsNotNull(u16, "u");
            String host = u16.getHost();
            if (host != null) {
                ConcurrentHashMap<String, HostSensitiveRecorder> concurrentHashMap = hostMap;
                HostSensitiveRecorder hostSensitiveRecorder = concurrentHashMap.get(host);
                if (hostSensitiveRecorder == null) {
                    hostSensitiveRecorder = new HostSensitiveRecorder(host);
                    concurrentHashMap.put(host, hostSensitiveRecorder);
                }
                hostSensitiveRecorder.d(httpTask);
            }
        } catch (Exception e16) {
            o.b("NetworkCapture", "overCallCheck", e16);
        }
    }
}
