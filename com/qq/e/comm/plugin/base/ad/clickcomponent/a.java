package com.qq.e.comm.plugin.base.ad.clickcomponent;

import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.interceptor.APKDownloadInterceptor;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.interceptor.InvalidParamsInterceptor;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.node.AppInstallationStateReport;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.node.C2SReportNode;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.node.CGINode;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.node.DirectLauncherNode;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.node.InterPageNode;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.node.LinkReportStartNode;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.node.MarketDownLoadNode;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.node.QQMiniGameNode;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.node.QuickAppLaunchNode;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.node.WXNode;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.node.WebPageNode;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    public static List<AbsJumpNode> a(ClickInfo clickInfo) {
        switch (clickInfo != null ? clickInfo.g() : 0) {
            case 2:
                return b(clickInfo);
            case 3:
                return d(clickInfo);
            case 4:
                return e(clickInfo);
            case 5:
                return f(clickInfo);
            case 6:
                return h(clickInfo);
            case 7:
                return j(clickInfo);
            case 8:
                return g(clickInfo);
            case 9:
                return c(clickInfo);
            case 10:
                return k(clickInfo);
            default:
                return i(clickInfo);
        }
    }

    private static List<AbsJumpNode> b(ClickInfo clickInfo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new InvalidParamsInterceptor(clickInfo));
        arrayList.add(new APKDownloadInterceptor(clickInfo));
        arrayList.add(new LinkReportStartNode(clickInfo));
        arrayList.add(new CGINode(clickInfo));
        arrayList.add(new C2SReportNode(clickInfo));
        return arrayList;
    }

    private static List<AbsJumpNode> c(ClickInfo clickInfo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new InvalidParamsInterceptor(clickInfo));
        arrayList.add(new LinkReportStartNode(clickInfo));
        arrayList.add(new CGINode(clickInfo));
        arrayList.add(new C2SReportNode(clickInfo));
        return arrayList;
    }

    private static List<AbsJumpNode> d(ClickInfo clickInfo) {
        return i(clickInfo);
    }

    private static List<AbsJumpNode> e(ClickInfo clickInfo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new InvalidParamsInterceptor(clickInfo));
        arrayList.add(new APKDownloadInterceptor(clickInfo));
        arrayList.add(new LinkReportStartNode(clickInfo));
        arrayList.add(new AppInstallationStateReport(clickInfo));
        arrayList.add(new QQMiniGameNode(clickInfo));
        arrayList.add(new DirectLauncherNode(clickInfo));
        arrayList.add(new QuickAppLaunchNode(clickInfo));
        arrayList.add(new WXNode(clickInfo));
        arrayList.add(new MarketDownLoadNode(clickInfo));
        return arrayList;
    }

    private static List<AbsJumpNode> f(ClickInfo clickInfo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new InvalidParamsInterceptor(clickInfo));
        arrayList.add(new APKDownloadInterceptor(clickInfo));
        arrayList.add(new LinkReportStartNode(clickInfo));
        arrayList.add(new MarketDownLoadNode(clickInfo));
        arrayList.add(new CGINode(clickInfo));
        arrayList.add(new C2SReportNode(clickInfo));
        return arrayList;
    }

    private static List<AbsJumpNode> g(ClickInfo clickInfo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new InvalidParamsInterceptor(clickInfo));
        arrayList.add(new APKDownloadInterceptor(clickInfo));
        arrayList.add(new MarketDownLoadNode(clickInfo));
        return arrayList;
    }

    private static List<AbsJumpNode> h(ClickInfo clickInfo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new InvalidParamsInterceptor(clickInfo));
        arrayList.add(new LinkReportStartNode(clickInfo));
        arrayList.add(new WebPageNode(clickInfo));
        return arrayList;
    }

    private static List<AbsJumpNode> i(ClickInfo clickInfo) {
        if (clickInfo != null && clickInfo.r()) {
            return a(clickInfo, true);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new InvalidParamsInterceptor(clickInfo));
        arrayList.add(new APKDownloadInterceptor(clickInfo));
        arrayList.add(new LinkReportStartNode(clickInfo));
        arrayList.add(new AppInstallationStateReport(clickInfo));
        arrayList.add(new QQMiniGameNode(clickInfo));
        arrayList.add(new DirectLauncherNode(clickInfo));
        arrayList.add(new QuickAppLaunchNode(clickInfo));
        arrayList.add(new InterPageNode(clickInfo));
        arrayList.add(new WXNode(clickInfo));
        arrayList.add(new MarketDownLoadNode(clickInfo));
        arrayList.add(new WebPageNode(clickInfo));
        return arrayList;
    }

    private static List<AbsJumpNode> j(ClickInfo clickInfo) {
        if (clickInfo != null && clickInfo.r()) {
            return a(clickInfo, false);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new InvalidParamsInterceptor(clickInfo));
        arrayList.add(new LinkReportStartNode(clickInfo));
        arrayList.add(new AppInstallationStateReport(clickInfo));
        arrayList.add(new QQMiniGameNode(clickInfo));
        arrayList.add(new DirectLauncherNode(clickInfo));
        arrayList.add(new QuickAppLaunchNode(clickInfo));
        arrayList.add(new WXNode(clickInfo));
        arrayList.add(new WebPageNode(clickInfo));
        return arrayList;
    }

    private static List<AbsJumpNode> k(ClickInfo clickInfo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new InvalidParamsInterceptor(clickInfo));
        arrayList.add(new WXNode(clickInfo));
        arrayList.add(new WebPageNode(clickInfo));
        return arrayList;
    }

    private static List<AbsJumpNode> a(ClickInfo clickInfo, boolean z16) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new InvalidParamsInterceptor(clickInfo));
        if (z16) {
            arrayList.add(new APKDownloadInterceptor(clickInfo));
        }
        arrayList.add(new LinkReportStartNode(clickInfo));
        arrayList.add(new AppInstallationStateReport(clickInfo));
        arrayList.add(new WebPageNode(clickInfo));
        arrayList.add(new DirectLauncherNode(clickInfo));
        arrayList.add(new WXNode(clickInfo));
        return arrayList;
    }
}
