package com.tencent.biz.qqcircle.richframework.video.player.process;

import com.tencent.biz.qqcircle.immersive.manager.g;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.IRFWPlayerOptionsProcess;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager;
import com.tencent.biz.richframework.video.rfw.player.report.RFWVideoUrlBean;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWStVideoUrl;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements IRFWPlayerOptionsProcess {

    /* renamed from: a, reason: collision with root package name */
    public static String f92042a = "QFS_BUSINESS_PROCESS_URL_HTTP_ADD_SCENE";

    private void a(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.setRealPlayUrl(g.e().c(rFWPlayerOptions, rFWPlayerOptions.getRealPlayUrl()));
        rFWPlayerOptions.setPlayUrl(g.e().c(rFWPlayerOptions, rFWPlayerOptions.getPlayUrl()));
        rFWPlayerOptions.setExchangedUrl(g.e().c(rFWPlayerOptions, rFWPlayerOptions.getExchangedUrl()));
        rFWPlayerOptions.setTargetDualStackV4IpUrl(g.e().c(rFWPlayerOptions, rFWPlayerOptions.getTargetDualStackV4IpUrl()));
        rFWPlayerOptions.setTargetIPURl(g.e().c(rFWPlayerOptions, rFWPlayerOptions.getTargetIPURL()));
        rFWPlayerOptions.setDirectIPBackUpList(g.e().d(rFWPlayerOptions, rFWPlayerOptions.getDirectIPBackUpList()));
    }

    private void b(RFWPlayerOptions rFWPlayerOptions) {
        for (RFWStVideoUrl rFWStVideoUrl : rFWPlayerOptions.getStVideo().getVecVideoUrl()) {
            rFWStVideoUrl.setPlayUrl(g.e().c(rFWPlayerOptions, rFWStVideoUrl.getPlayUrl()));
        }
        List<RFWVideoUrlBean> vecUrlBean = rFWPlayerOptions.getVecUrlBean();
        if (vecUrlBean == null) {
            return;
        }
        for (RFWVideoUrlBean rFWVideoUrlBean : vecUrlBean) {
            rFWVideoUrlBean.mUrl = g.e().c(rFWPlayerOptions, rFWVideoUrlBean.mUrl);
        }
        rFWPlayerOptions.getServerPlayBean().mUrl = g.e().c(rFWPlayerOptions, rFWPlayerOptions.getServerPlayBean().mUrl);
    }

    public /* synthetic */ String c(RFWPlayerOptions rFWPlayerOptions) {
        return com.tencent.biz.richframework.video.rfw.player.optionsprocess.a.a(this, rFWPlayerOptions);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.optionsprocess.IRFWPlayerOptionsProcess
    public String getProcessKey() {
        return f92042a;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.optionsprocess.IRFWPlayerOptionsProcess
    public void onProcess(RFWPlayerOptions rFWPlayerOptions, RFWPlayerOptionsProcessManager.IProcessCallBack iProcessCallBack) {
        if (rFWPlayerOptions != null && iProcessCallBack != null) {
            a(rFWPlayerOptions);
            b(rFWPlayerOptions);
            iProcessCallBack.onFinish(rFWPlayerOptions, true);
            RFWLog.d(c(rFWPlayerOptions), RFWLog.USR, "add scene success");
        }
    }
}
