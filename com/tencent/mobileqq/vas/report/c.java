package com.tencent.mobileqq.vas.report;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;
import v23.Node;
import x23.e;
import x23.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u001b\u001a\u00020\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0006\u0012\u0006\u0010!\u001a\u00020\u001f\u0012\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"\u0012\b\b\u0002\u0010'\u001a\u00020\u000f\u0012\u0006\u0010*\u001a\u00020(\u0012\b\b\u0002\u0010,\u001a\u00020\u0017\u00a2\u0006\u0004\b;\u0010<J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016R\u0014\u0010\u001b\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001dR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010 R\u001c\u0010&\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001aR\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010)R\u0014\u0010,\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010+R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010.R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u00100R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010%R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/vas/report/c;", "Lx23/c;", "Lv23/a;", "node", "", "j", "", "endStage", "g", "k", "f", "Lx23/a;", "logProxy", "i", "(Lx23/a;)V", "", h.F, "key", "value", "a", "c", "d", "stage", "", "b", "end", "Ljava/lang/String;", "serviceName", VasCommonJsbProxy.JSON_KEY_SET_KEY, "I", "version", "Lx23/b;", "Lx23/b;", "reportImpl", "", "Lx23/e;", "e", "Ljava/util/List;", "interceptorList", "connectChainKey", "Lx23/f;", "Lx23/f;", "sample", "J", WadlProxyConsts.PARAM_TIME_OUT, "", "Z", "isEnd", "Lx23/a;", "", "nodeList", "Lorg/json/JSONObject;", "l", "Lorg/json/JSONObject;", WadlProxyConsts.EXT_JSON, "Ljava/lang/Runnable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Runnable;", "timeOutTask", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILx23/b;Ljava/util/List;Ljava/lang/String;Lx23/f;J)V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c implements x23.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String serviceName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String setKey;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int version;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final x23.b reportImpl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final List<e> interceptorList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String connectChainKey;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f sample;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final long timeOut;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isEnd;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private x23.a logProxy;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Node> nodeList;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JSONObject extJson;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable timeOutTask;

    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull String serviceName, @NotNull String setKey, int i3, @NotNull x23.b reportImpl, @Nullable List<? extends e> list, @NotNull String connectChainKey, @NotNull f sample, long j3) {
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        Intrinsics.checkNotNullParameter(reportImpl, "reportImpl");
        Intrinsics.checkNotNullParameter(connectChainKey, "connectChainKey");
        Intrinsics.checkNotNullParameter(sample, "sample");
        this.serviceName = serviceName;
        this.setKey = setKey;
        this.version = i3;
        this.reportImpl = reportImpl;
        this.interceptorList = list;
        this.connectChainKey = connectChainKey;
        this.sample = sample;
        this.timeOut = j3;
        this.nodeList = new ArrayList();
        this.extJson = new JSONObject();
        this.nodeList.add(new Node(-1));
    }

    private final void f() {
        Runnable runnable = this.timeOutTask;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
        }
    }

    private final void g(int endStage) {
        x23.a aVar;
        x23.a aVar2;
        synchronized (this.nodeList) {
            if (this.isEnd) {
                if (com.tencent.qqnt.util.b.f362976b.isDebugVersion() && (aVar2 = this.logProxy) != null) {
                    aVar2.e("call end! chain is ended!");
                }
                return;
            }
            List<Node> list = this.nodeList;
            Node node = new Node(endStage, 0L, null, null, -1, 14, null);
            j(node);
            list.add(node);
            if (com.tencent.qqnt.util.b.f362976b.isDebugVersion() && (aVar = this.logProxy) != null) {
                aVar.i(this.nodeList.toString());
            }
            this.reportImpl.a(this.serviceName, this.setKey, this.version, this.nodeList, this.connectChainKey, this.extJson, this.sample);
            this.isEnd = true;
            a.f310626a.c(this.setKey);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void j(Node node) {
        Object obj;
        boolean z16;
        Object last;
        if (!this.nodeList.isEmpty()) {
            if (node.getPreStage() == -10000) {
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.nodeList);
                node.h((Node) last);
                return;
            }
            Iterator<T> it = this.nodeList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((Node) obj).getStage() == node.getPreStage()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            Node node2 = (Node) obj;
            if (node2 != null) {
                node.h(node2);
            }
        }
    }

    private final void k() {
        if (this.timeOut <= 0) {
            return;
        }
        Runnable runnable = this.timeOutTask;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
        } else {
            runnable = new Runnable() { // from class: com.tencent.mobileqq.vas.report.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.l(c.this);
                }
            };
        }
        this.timeOutTask = ThreadManagerV2.executeDelay(runnable, 16, null, false, this.timeOut);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g(-3);
    }

    @Override // x23.c
    @NotNull
    public x23.c a(@NotNull String key, @NotNull String value) {
        x23.a aVar;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        synchronized (this.extJson) {
            if (this.isEnd) {
                x23.a aVar2 = this.logProxy;
                if (aVar2 != null) {
                    aVar2.e("appendExt! chain is ended!");
                }
                return this;
            }
            if (com.tencent.qqnt.util.b.f362976b.isDebugVersion() && (aVar = this.logProxy) != null) {
                aVar.i("k: " + this.setKey + " append ext key: " + key + " value: " + value);
            }
            this.extJson.put(key, value);
            return this;
        }
    }

    @Override // x23.c
    public long b(int stage) {
        Object obj;
        boolean z16;
        Iterator<T> it = this.nodeList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((Node) obj).getStage() == stage) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Node node = (Node) obj;
        if (node != null) {
            return node.getStartTime();
        }
        return 0L;
    }

    @Override // x23.c
    @NotNull
    public x23.c c(@NotNull Node node) {
        x23.a aVar;
        Intrinsics.checkNotNullParameter(node, "node");
        synchronized (this.nodeList) {
            if (this.isEnd) {
                if (com.tencent.qqnt.util.b.f362976b.isDebugVersion() && (aVar = this.logProxy) != null) {
                    aVar.e("append node! chain is ended!");
                }
                return this;
            }
            List<e> list = this.interceptorList;
            boolean z16 = false;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (((e) it.next()).a(this.nodeList.size(), node)) {
                        z16 = true;
                    }
                }
            }
            if (!z16) {
                j(node);
                this.nodeList.add(node);
            }
            k();
            return this;
        }
    }

    @Override // x23.c
    public int d() {
        Object last;
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.nodeList);
        return ((Node) last).getStage();
    }

    @Override // x23.c
    public void end() {
        f();
        g(-2);
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public String getSetKey() {
        return this.setKey;
    }

    public final void i(@NotNull x23.a logProxy) {
        Intrinsics.checkNotNullParameter(logProxy, "logProxy");
        this.logProxy = logProxy;
    }
}
