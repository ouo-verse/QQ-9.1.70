package com.tencent.qmethod.monitor.ext.traffic;

import android.util.Base64;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qmethod.monitor.report.PMonitorReporter;
import com.tencent.qmethod.pandoraex.core.o;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\b&\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\u0006\u0010!\u001a\u00020\u001d\u0012\b\b\u0002\u0010&\u001a\u00020\u0004\u0012\b\b\u0002\u0010(\u001a\u00020\u0004\u0012\b\b\u0002\u0010*\u001a\u00020\u0006\u0012\b\b\u0002\u0010-\u001a\u00020\u0006\u0012\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020/0.\u0012\b\b\u0002\u0010;\u001a\u000204\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0006\u0010\b\u001a\u00020\u0004J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0006\u0010\n\u001a\u00020\u0004J\"\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0016\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0012H&R\u001a\u0010\u001a\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001c\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010!\u001a\u00020\u001d8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010&\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010(\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b'\u0010%R\u001a\u0010*\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b)\u0010\u0017\u001a\u0004\b\"\u0010\u0019R\u001a\u0010-\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b+\u0010\u0017\u001a\u0004\b,\u0010\u0019R\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020/0.8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b)\u00102R\"\u0010;\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:\u00a8\u0006>"}, d2 = {"Lcom/tencent/qmethod/monitor/ext/traffic/NetworkCaptureBaseTask;", "Ljava/lang/Runnable;", "Lorg/json/JSONObject;", "i", "", "t", "", "g", ReportConstant.COSTREPORT_PREFIX, "o", "f", "value", "Lkotlin/Pair;", "", "Lcom/tencent/qmethod/monitor/ext/traffic/g;", "a", "oldJson", "newJson", "", "b", TencentLocation.RUN_MODE, "e", "d", "Ljava/lang/String;", "p", "()Ljava/lang/String;", "url", "k", "requestSource", "", "J", "l", "()J", "requestTimeMills", tl.h.F, "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Z", "isAgreeBefore", "r", "isBackground", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "monitorMethod", BdhLogUtil.LogTag.Tag_Conn, DomainData.DOMAIN_NAME, "stack", "", "Lcom/tencent/qmethod/monitor/ext/traffic/NetworkCaptureRule;", "D", "Ljava/util/Collection;", "()Ljava/util/Collection;", "sensitiveIssues", "", "E", "I", "j", "()I", "setOverCallCount", "(I)V", "overCallCount", "<init>", "(Ljava/lang/String;Ljava/lang/String;JZZLjava/lang/String;Ljava/lang/String;Ljava/util/Collection;I)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public abstract class NetworkCaptureBaseTask implements Runnable {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String stack;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Collection<NetworkCaptureRule> sensitiveIssues;

    /* renamed from: E, reason: from kotlin metadata */
    private int overCallCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String url;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String requestSource;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long requestTimeMills;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean isAgreeBefore;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final boolean isBackground;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String monitorMethod;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public static final class a<T> implements Comparator<T> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues((String) t16, (String) t17);
            return compareValues;
        }
    }

    public NetworkCaptureBaseTask(@NotNull String url, @NotNull String requestSource, long j3, boolean z16, boolean z17, @NotNull String monitorMethod, @NotNull String stack, @NotNull Collection<NetworkCaptureRule> sensitiveIssues, int i3) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(requestSource, "requestSource");
        Intrinsics.checkParameterIsNotNull(monitorMethod, "monitorMethod");
        Intrinsics.checkParameterIsNotNull(stack, "stack");
        Intrinsics.checkParameterIsNotNull(sensitiveIssues, "sensitiveIssues");
        this.url = url;
        this.requestSource = requestSource;
        this.requestTimeMills = j3;
        this.isAgreeBefore = z16;
        this.isBackground = z17;
        this.monitorMethod = monitorMethod;
        this.stack = stack;
        this.sensitiveIssues = sensitiveIssues;
        this.overCallCount = i3;
    }

    @NotNull
    public Pair<List<g>, String> a(@NotNull String value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        List<g> b16 = b.b(value);
        if (b16.isEmpty() && value.length() > 4) {
            try {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("RBase64D(");
                byte[] decode = Base64.decode(value, 2);
                Intrinsics.checkExpressionValueIsNotNull(decode, "Base64.decode(value, Base64.NO_WRAP)");
                sb5.append(new String(decode, Charsets.UTF_8));
                sb5.append(')');
                String sb6 = sb5.toString();
                List<g> b17 = b.b(sb6);
                if (!b17.isEmpty()) {
                    value = sb6;
                    b16 = b17;
                }
            } catch (Exception unused) {
            }
        }
        return new Pair<>(b16, value);
    }

    public final void b(@NotNull JSONObject oldJson, @NotNull JSONObject newJson) {
        String str;
        String obj;
        List<g> list;
        String str2;
        boolean contains$default;
        String replace;
        NetworkCaptureBaseTask networkCaptureBaseTask = this;
        JSONObject oldJson2 = oldJson;
        Intrinsics.checkParameterIsNotNull(oldJson2, "oldJson");
        Intrinsics.checkParameterIsNotNull(newJson, "newJson");
        Iterator keys = oldJson.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            Object obj2 = oldJson2.get(key);
            if (obj2 instanceof JSONObject) {
                JSONObject jSONObject = new JSONObject();
                newJson.put(key, jSONObject);
                networkCaptureBaseTask.b((JSONObject) obj2, jSONObject);
            } else {
                Intrinsics.checkExpressionValueIsNotNull(key, "key");
                if (key != null) {
                    String lowerCase = key.toLowerCase();
                    Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
                    NetworkCaptureRule a16 = b.a(lowerCase);
                    if (a16 != null) {
                        str = "###" + key + "###";
                        networkCaptureBaseTask.sensitiveIssues.add(a16);
                    } else {
                        str = key;
                    }
                    if (obj2 instanceof String) {
                        obj = (String) obj2;
                    } else {
                        obj = obj2.toString();
                    }
                    if (obj != null) {
                        Pair<List<g>, String> a17 = networkCaptureBaseTask.a(obj);
                        List<g> first = a17.getFirst();
                        String second = a17.getSecond();
                        if (!first.isEmpty()) {
                            str2 = second;
                            for (g gVar : first) {
                                networkCaptureBaseTask.sensitiveIssues.add(gVar.getMatchRule());
                                if (gVar.getMatchType() != 8 && gVar.getMatchType() != 4) {
                                    str2 = "###" + c.e(second) + "###";
                                } else if (str2 != null) {
                                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) ("###" + gVar.getMatchValue()), false, 2, (Object) null);
                                    if (!contains$default) {
                                        replace = StringsKt__StringsJVMKt.replace(str2, gVar.getMatchValue(), "###" + c.e(gVar.getMatchValue()) + "###", true);
                                        str2 = replace;
                                    }
                                    Unit unit = Unit.INSTANCE;
                                    networkCaptureBaseTask = this;
                                }
                                networkCaptureBaseTask = this;
                            }
                        } else {
                            str2 = c.d(second);
                        }
                        list = first;
                    } else {
                        list = null;
                        str2 = null;
                    }
                    if (a16 == null && list == null) {
                        newJson.put(key, obj2);
                    } else {
                        newJson.put(str, str2);
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
            networkCaptureBaseTask = this;
            oldJson2 = oldJson;
        }
    }

    public abstract void e();

    public final boolean f() {
        return PMonitorReporter.INSTANCE.a(o());
    }

    @NotNull
    public abstract String g();

    @NotNull
    /* renamed from: h, reason: from getter */
    public String getMonitorMethod() {
        return this.monitorMethod;
    }

    @NotNull
    public abstract JSONObject i();

    /* renamed from: j, reason: from getter */
    public final int getOverCallCount() {
        return this.overCallCount;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public String getRequestSource() {
        return this.requestSource;
    }

    /* renamed from: l, reason: from getter */
    public long getRequestTimeMills() {
        return this.requestTimeMills;
    }

    @NotNull
    public final Collection<NetworkCaptureRule> m() {
        return this.sensitiveIssues;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public String getStack() {
        return this.stack;
    }

    @NotNull
    public String o() {
        List distinct;
        int collectionSizeOrDefault;
        List sortedWith;
        String joinToString$default;
        com.tencent.qmethod.monitor.base.util.e eVar = com.tencent.qmethod.monitor.base.util.e.f343535a;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(g());
        sb5.append('.');
        distinct = CollectionsKt___CollectionsKt.distinct(this.sensitiveIssues);
        List list = distinct;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((NetworkCaptureRule) it.next()).getSensitiveCategory());
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new a());
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(sortedWith, "", null, null, 0, null, null, 62, null);
        sb5.append(joinToString$default);
        String sb6 = sb5.toString();
        Charset defaultCharset = Charset.defaultCharset();
        Intrinsics.checkExpressionValueIsNotNull(defaultCharset, "Charset.defaultCharset()");
        if (sb6 != null) {
            byte[] bytes = sb6.getBytes(defaultCharset);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            return eVar.b(bytes);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @NotNull
    /* renamed from: p, reason: from getter */
    public String getUrl() {
        return this.url;
    }

    /* renamed from: q, reason: from getter */
    public boolean getIsAgreeBefore() {
        return this.isAgreeBefore;
    }

    /* renamed from: r, reason: from getter */
    public boolean getIsBackground() {
        return this.isBackground;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j3;
        com.tencent.qmethod.monitor.ext.traffic.a aVar = com.tencent.qmethod.monitor.ext.traffic.a.f343721k;
        boolean e16 = aVar.e();
        if (e16) {
            if (aVar.i()) {
                j3 = System.currentTimeMillis();
            } else {
                j3 = 0;
            }
            NetworkCaptureSample.f343708b.d();
            e();
            aVar.f().decrementAndGet();
            if (aVar.i()) {
                o.e("NetworkCapture", "doRequestAnalyse cost " + (System.currentTimeMillis() - j3) + " left " + aVar.f().get());
            }
        }
        boolean d16 = aVar.d();
        if (d16 && s()) {
            if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
                o.a("NetworkCapture", "issueNet" + getMonitorMethod() + "HttpInSec = " + getUrl() + TokenParser.SP + " method = " + getMonitorMethod() + " stack = " + getStack());
            }
            NetworkHttpPlainSample.f343710b.e();
            f fVar = f.f343729e;
            fVar.i(this, fVar.d());
        }
        if (aVar.i()) {
            o.e("NetworkCapture", "plain=" + d16 + " sensitive=" + e16 + TokenParser.SP + getUrl());
        }
    }

    public final boolean s() {
        boolean startsWith$default;
        if (getUrl() != null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(getUrl(), "http://", false, 2, null);
            if (!startsWith$default) {
                return false;
            }
            return true;
        }
        return false;
    }

    public abstract boolean t();

    public /* synthetic */ NetworkCaptureBaseTask(String str, String str2, long j3, boolean z16, boolean z17, String str3, String str4, Collection collection, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j3, (i16 & 8) != 0 ? false : z16, (i16 & 16) != 0 ? false : z17, (i16 & 32) != 0 ? "" : str3, (i16 & 64) != 0 ? "" : str4, (i16 & 128) != 0 ? new ArrayList() : collection, (i16 & 256) != 0 ? 0 : i3);
    }
}
