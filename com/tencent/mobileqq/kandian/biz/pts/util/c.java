package com.tencent.mobileqq.kandian.biz.pts.util;

import android.content.Context;
import android.os.HandlerThread;
import android.view.View;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.pts.ui.PTSNodeGif;
import com.tencent.mobileqq.kandian.biz.pts.ui.PTSNodeImage;
import com.tencent.mobileqq.kandian.biz.pts.ui.PTSNodeRichText;
import com.tencent.mobileqq.kandian.biz.pts.util.f;
import com.tencent.mobileqq.util.cu;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.utils.PTSConfig;
import com.tencent.pts.utils.PTSConstant;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSNodeVirtualUtil;
import com.tencent.pts.utils.PTSReportUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static HandlerThread f239401a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a extends PTSReportUtil.DefaultPTSReport {
        a() {
        }

        @Override // com.tencent.pts.utils.PTSReportUtil.DefaultPTSReport, com.tencent.pts.utils.PTSReportUtil.IPTSReport
        public void reportEvent(String str, String str2, int i3) {
            f.a("0X800B241", "", "", "", new f.a().a("tag", str).a("msg", str2).a(AdMetricTag.Report.TYPE, "" + i3).b());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class b implements PTSNodeVirtualUtil.INodeVirtualOnViewClick {
        b() {
        }

        @Override // com.tencent.pts.utils.PTSNodeVirtualUtil.INodeVirtualOnViewClick
        public void onViewClicked(View view) {
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.kandian.biz.pts.util.c$c, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    public class C7957c implements PTSConfig.a {
        C7957c() {
        }

        @Override // com.tencent.pts.utils.PTSConfig.a
        public Context getApplicationContext() {
            return BaseApplicationImpl.getApplication().getApplicationContext();
        }
    }

    public static void a(b62.a aVar) {
        PTSLiteSwitchManager.c().d(aVar);
    }

    private static PTSNodeVirtualUtil.INodeVirtualOnBindNodeInfo b() {
        return new d();
    }

    private static void c() {
        if (f239401a == null) {
            HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("readinjoy-common-pts-sub", 0);
            f239401a = newFreeHandlerThread;
            newFreeHandlerThread.start();
            QLog.i("PTSHelper", 1, "[initPtsConfig] init sHandlerThread");
        }
        a aVar = new a();
        PTSNodeVirtualUtil.INodeVirtualOnBindNodeInfo b16 = b();
        try {
            PTSConfig.init(new PTSConfig.PTSConfigBuilder().withHandlerThread(f239401a).withLogger(new e()).withPtsReport(aVar).withOnBindNodeInfo(b16).withOnViewClick(new b()).build());
        } catch (Throwable th5) {
            QLog.e("PTSHelper", 2, "initPtsConfig e:", th5);
        }
        PTSConfig.setApplicationContextFetcher(new C7957c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d() {
        if (cu.g()) {
            PTSDeviceUtil.setTextHeightOffsetPerLine(0.11764706f);
            PTSDeviceUtil.setTextWidthOffsetPerLength(0.029411765f);
        }
        PTSNodeFactory.registerNodeVirtual("img", new PTSNodeImage.Builder());
        PTSNodeFactory.registerCustomViewNodeVirtual("view", "qq-rij-gif", new PTSNodeGif.Builder());
        PTSNodeFactory.registerNodeVirtual(PTSConstant.VNT_RICH_TEXT, new PTSNodeRichText.Builder());
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class d implements PTSNodeVirtualUtil.INodeVirtualOnBindNodeInfo {
        d() {
        }

        @Override // com.tencent.pts.utils.PTSNodeVirtualUtil.INodeVirtualOnBindNodeInfo
        public void onBindNodeInfoFinished(String str, View view, String str2, Map<String, Object> map, Map<String, Object> map2) {
        }
    }
}
