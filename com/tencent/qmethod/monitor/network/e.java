package com.tencent.qmethod.monitor.network;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR(\u0010\u0015\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\r\u0010\u000e\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qmethod/monitor/network/e;", "", "", "a", "Ljava/lang/String;", "testHost", "b", "host", "", "c", "Ljava/util/List;", "whiteList", "", "d", "Z", "getIS_TEST", "()Z", "setIS_TEST", "(Z)V", "IS_TEST$annotations", "()V", "IS_TEST", "<init>", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final List<String> whiteList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean IS_TEST;

    /* renamed from: e, reason: collision with root package name */
    public static final e f343757e = new e();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static String testHost = "https://test.compliance.tdos.qq.com/";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static String host = "https://compliance.tdos.qq.com/";

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf("compliance-tdos.play.aiseet.atianqi.com");
        whiteList = listOf;
    }

    e() {
    }

    @NotNull
    public final String a() {
        if (IS_TEST) {
            return testHost;
        }
        return host;
    }
}
