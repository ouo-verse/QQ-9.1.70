package com.tencent.biz.richframework.video.rfw.player.optionsprocess;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager;
import com.tencent.biz.richframework.video.rfw.player.report.RFWVideoUrlBean;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import uq3.c;

/* loaded from: classes5.dex */
public class RFWPlayerOptionH264ReSelectedProcess implements IRFWPlayerOptionsProcess {
    public static String DEFAULT_PROCESS_URL_H264_RE_SELECTED = "DEFAULT_PROCESS_URL_H264_RE_SELECTED";

    private List<RFWVideoUrlBean> filterH264(RFWPlayerOptions rFWPlayerOptions) {
        ArrayList arrayList = new ArrayList();
        if (rFWPlayerOptions == null) {
            return arrayList;
        }
        for (RFWVideoUrlBean rFWVideoUrlBean : rFWPlayerOptions.getVecUrlBean()) {
            int i3 = rFWVideoUrlBean.mLevelType;
            if (i3 != 9 && i3 != 20 && rFWVideoUrlBean.mVideoEncode == 1) {
                arrayList.add(rFWVideoUrlBean);
            }
        }
        QLog.d(a(rFWPlayerOptions), 1, "filterH264, list size: " + arrayList.size());
        return arrayList;
    }

    private void selectedMinH264(RFWPlayerOptions rFWPlayerOptions, RFWPlayerOptionsProcessManager.IProcessCallBack iProcessCallBack) {
        List<RFWVideoUrlBean> filterH264 = filterH264(rFWPlayerOptions);
        if (filterH264.isEmpty()) {
            iProcessCallBack.onFinish(rFWPlayerOptions, true);
            RFWLog.d(a(rFWPlayerOptions), RFWLog.USR, "no h264 url,");
            return;
        }
        RFWVideoUrlBean rFWVideoUrlBean = filterH264.get(0);
        for (RFWVideoUrlBean rFWVideoUrlBean2 : filterH264) {
            if (rFWVideoUrlBean.mRate > rFWVideoUrlBean2.mRate) {
                rFWVideoUrlBean = rFWVideoUrlBean2;
            }
        }
        RFWLog.d(a(rFWPlayerOptions), RFWLog.USR, "find target h264 Url:" + rFWVideoUrlBean);
        rFWPlayerOptions.setRealPlayBean(rFWVideoUrlBean).setRealPlayUrl(rFWVideoUrlBean.mUrl);
        iProcessCallBack.onFinish(rFWPlayerOptions, true);
    }

    public /* synthetic */ String a(RFWPlayerOptions rFWPlayerOptions) {
        return a.a(this, rFWPlayerOptions);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.optionsprocess.IRFWPlayerOptionsProcess
    public String getProcessKey() {
        return DEFAULT_PROCESS_URL_H264_RE_SELECTED;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.optionsprocess.IRFWPlayerOptionsProcess
    public void onProcess(RFWPlayerOptions rFWPlayerOptions, RFWPlayerOptionsProcessManager.IProcessCallBack iProcessCallBack) {
        if (!c.r0()) {
            iProcessCallBack.onFinish(rFWPlayerOptions, true);
            RFWLog.d(a(rFWPlayerOptions), RFWLog.USR, "not enable user default player");
            return;
        }
        if (QQVideoPlaySDKManager.needUseSystemPlayer() && !QQVideoPlaySDKManager.isTpCoreSoExits()) {
            if (rFWPlayerOptions.getStVideo() == null) {
                RFWLog.i(a(rFWPlayerOptions), RFWLog.USR, " null video");
                iProcessCallBack.onFinish(rFWPlayerOptions, true);
                return;
            }
            if (rFWPlayerOptions.getVecUrlBean() == null) {
                rFWPlayerOptions.setVecUrlBean(RFWVideoUrlBean.getUrlBeans(rFWPlayerOptions.getStVideo().getVecVideoUrl()));
            }
            if (rFWPlayerOptions.getServerPlayBean() == null) {
                rFWPlayerOptions.setServerPlayBean(new RFWVideoUrlBean(rFWPlayerOptions.getStVideo()));
            }
            selectedMinH264(rFWPlayerOptions, iProcessCallBack);
            return;
        }
        iProcessCallBack.onFinish(rFWPlayerOptions, true);
        RFWLog.d(a(rFWPlayerOptions), RFWLog.USR, "sdk ready not need to selected h264");
    }
}
