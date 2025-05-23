package com.tencent.qmethod.monitor.ext.traffic;

import android.os.Handler;
import com.tencent.qmethod.pandoraex.core.o;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\rR\"\u0010\u0017\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qmethod/monitor/ext/traffic/HostSensitiveRecorder;", "", "", "Lcom/tencent/qmethod/monitor/ext/traffic/NetworkCaptureCheckHttpTask;", "httpTask", "Lcom/tencent/qmethod/monitor/ext/traffic/NetworkCaptureRule;", "it", "", "c", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "sensitiveCounter", "", "b", "sensitiveReportFlags", "Z", "getHasReport", "()Z", "e", "(Z)V", "hasReport", "Ljava/lang/String;", "host", "<init>", "(Ljava/lang/String;)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class HostSensitiveRecorder {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, Integer> sensitiveCounter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, Boolean> sensitiveReportFlags;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean hasReport;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String host;

    public HostSensitiveRecorder() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void c(final int i3, final NetworkCaptureCheckHttpTask networkCaptureCheckHttpTask, final NetworkCaptureRule networkCaptureRule) {
        final ArrayList arrayListOf;
        Handler c16 = f.f343729e.c();
        final String str = this.host;
        final String requestSource = networkCaptureCheckHttpTask.getRequestSource();
        final long requestTimeMills = networkCaptureCheckHttpTask.getRequestTimeMills();
        final boolean z16 = false;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(networkCaptureRule);
        c16.postDelayed(new NetworkCaptureBaseTask(str, requestSource, requestTimeMills, z16, arrayListOf, i3) { // from class: com.tencent.qmethod.monitor.ext.traffic.HostSensitiveRecorder$handleReport$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                boolean z17 = false;
                String str2 = null;
                String str3 = null;
                int i16 = 112;
                DefaultConstructorMarker defaultConstructorMarker = null;
            }

            @Override // com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureBaseTask
            @NotNull
            public String g() {
                return getUrl();
            }

            @Override // com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureBaseTask
            @NotNull
            public JSONObject i() {
                return new JSONObject();
            }

            @Override // com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureBaseTask
            @NotNull
            public String o() {
                return "host:" + super.o();
            }

            @Override // com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureBaseTask, java.lang.Runnable
            public void run() {
                ConcurrentHashMap concurrentHashMap;
                String str2;
                concurrentHashMap = HostSensitiveRecorder.this.sensitiveCounter;
                if (((Integer) concurrentHashMap.get(networkCaptureRule.getSensitiveCategory())) != null) {
                    if (f()) {
                        if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
                            o.a("NetworkCapture", "issueNetHostOver filterSameQuestion $" + o());
                        }
                    } else {
                        f fVar = f.f343729e;
                        fVar.i(this, fVar.e());
                    }
                    HostSensitiveRecorder.this.e(true);
                    if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("issueNetHostOver = ");
                        str2 = HostSensitiveRecorder.this.host;
                        sb5.append(str2);
                        o.a("NetworkCapture", sb5.toString());
                        o.a("NetworkCapture", "issueNetHostOverSensitive = " + networkCaptureRule.getSensitiveCategory());
                        o.a("NetworkCapture", "issueNetHostOverCount = " + getOverCallCount());
                    }
                }
            }

            @Override // com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureBaseTask
            public boolean t() {
                return false;
            }

            @Override // com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureBaseTask
            public void e() {
            }
        }, 30000L);
    }

    public final void d(@NotNull NetworkCaptureCheckHttpTask httpTask) {
        Boolean bool;
        Intrinsics.checkParameterIsNotNull(httpTask, "httpTask");
        for (NetworkCaptureRule networkCaptureRule : httpTask.m()) {
            Integer num = this.sensitiveCounter.get(networkCaptureRule.getSensitiveCategory());
            if (num == null) {
                this.sensitiveCounter.put(networkCaptureRule.getSensitiveCategory(), 1);
            } else {
                this.sensitiveCounter.put(networkCaptureRule.getSensitiveCategory(), Integer.valueOf(num.intValue() + 1));
            }
            Integer num2 = this.sensitiveCounter.get(networkCaptureRule.getSensitiveCategory());
            if (num2 != null && Intrinsics.compare(num2.intValue(), 2) > 0 && ((bool = this.sensitiveReportFlags.get(networkCaptureRule.getSensitiveCategory())) == null || !bool.booleanValue())) {
                this.sensitiveReportFlags.put(networkCaptureRule.getSensitiveCategory(), Boolean.TRUE);
                c(num2.intValue(), httpTask, networkCaptureRule);
            }
        }
    }

    public final void e(boolean z16) {
        this.hasReport = z16;
    }

    public HostSensitiveRecorder(@NotNull String host) {
        Intrinsics.checkParameterIsNotNull(host, "host");
        this.host = host;
        this.sensitiveCounter = new ConcurrentHashMap<>();
        this.sensitiveReportFlags = new ConcurrentHashMap<>();
    }

    public /* synthetic */ HostSensitiveRecorder(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str);
    }
}
