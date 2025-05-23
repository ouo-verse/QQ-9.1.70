package com.tencent.hippykotlin.demo.pages.vas_base.report.chain;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.vas_base.report.chain.bean.Node;
import com.tencent.hippykotlin.demo.pages.vas_base.report.chain.impl.ReportConfig;
import com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.ILogProxy;
import com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.IReport;
import com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.IReportChain;
import com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.IReportConfig;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ReportChainImpl implements IReportChain {
    public final IReportConfig config;
    public volatile boolean isEnd;
    public ILogProxy logProxy;
    public String timeOutTask;
    public List<Node> nodeList = new ArrayList();
    public final e extJson = new e();

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List<com.tencent.hippykotlin.demo.pages.vas_base.report.chain.bean.Node>, java.util.ArrayList] */
    public ReportChainImpl(IReportConfig iReportConfig) {
        this.config = iReportConfig;
        this.nodeList.add(new Node(-1, ((ReportConfig) iReportConfig).timestamp()));
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List<com.tencent.hippykotlin.demo.pages.vas_base.report.chain.bean.Node>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.IReportChain
    public final IReportChain append(Node node) {
        if (this.isEnd) {
            ILogProxy iLogProxy = this.logProxy;
            if (iLogProxy != null) {
                iLogProxy.e("append node! chain is ended!");
            }
            return this;
        }
        ILogProxy iLogProxy2 = this.logProxy;
        if (iLogProxy2 != null) {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("k: ");
            m3.append(this.config.key());
            m3.append(" append nodeV: ");
            m3.append(node);
            iLogProxy2.i(m3.toString());
        }
        this.config.interceptor();
        setPreNode(node);
        this.nodeList.add(node);
        if (this.config.timeOut() > 0) {
            String str = this.timeOutTask;
            if (str != null) {
                TimerKt.b(str);
            }
            this.timeOutTask = TimerKt.d((int) this.config.timeOut(), new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.chain.ReportChainImpl$startTimeOutTask$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    ReportChainImpl reportChainImpl = ReportChainImpl.this;
                    reportChainImpl.end(reportChainImpl.config.timestamp(), -3);
                    return Unit.INSTANCE;
                }
            });
        }
        return this;
    }

    public final IReportChain appendExt(String str) {
        if (this.isEnd) {
            ILogProxy iLogProxy = this.logProxy;
            if (iLogProxy != null) {
                iLogProxy.e("appendExt! chain is ended!");
            }
            return this;
        }
        ILogProxy iLogProxy2 = this.logProxy;
        if (iLogProxy2 != null) {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("k: ");
            m3.append(this.config.key());
            m3.append(" append ext key: ");
            m3.append("is_first_open");
            m3.append(" value: ");
            m3.append(str);
            iLogProxy2.i(m3.toString());
        }
        this.extJson.v("is_first_open", str);
        return this;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List<com.tencent.hippykotlin.demo.pages.vas_base.report.chain.bean.Node>, java.util.ArrayList] */
    public final void end(long j3, int i3) {
        if (this.isEnd) {
            ILogProxy iLogProxy = this.logProxy;
            if (iLogProxy != null) {
                iLogProxy.e("call end! chain is ended!");
                return;
            }
            return;
        }
        ?? r06 = this.nodeList;
        Node node = new Node(i3, j3, (e) null, -1, 12);
        setPreNode(node);
        r06.add(node);
        ILogProxy iLogProxy2 = this.logProxy;
        if (iLogProxy2 != null) {
            iLogProxy2.i(this.nodeList.toString());
        }
        IReport reportImpl = this.config.getReportImpl();
        String serviceName = this.config.serviceName();
        String key = this.config.key();
        int version = this.config.version();
        List<Node> list = this.nodeList;
        this.config.connectChain();
        reportImpl.report(serviceName, key, version, list, "", this.extJson, this.config.sample(), this.config.vasCommonReportImpl());
        this.isEnd = true;
        CollectReport collectReport = CollectReport.INSTANCE;
        String key2 = this.config.key();
        synchronized (collectReport) {
            CollectReport.reportChainMap.remove(key2);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.vas_base.report.chain.bean.Node>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<com.tencent.hippykotlin.demo.pages.vas_base.report.chain.bean.Node>, java.util.ArrayList] */
    public final void setPreNode(Node node) {
        Object obj;
        Object last;
        if (!this.nodeList.isEmpty()) {
            if (node.preStage == -10000) {
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.nodeList);
                node.preNode = (Node) last;
                return;
            }
            Iterator it = this.nodeList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (((Node) obj).stage == node.preStage) {
                        break;
                    }
                }
            }
            Node node2 = (Node) obj;
            if (node2 != null) {
                node.preNode = node2;
            }
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.IReportChain
    public final void end(long j3) {
        String str = this.timeOutTask;
        if (str != null) {
            TimerKt.b(str);
        }
        end(j3, -2);
    }
}
