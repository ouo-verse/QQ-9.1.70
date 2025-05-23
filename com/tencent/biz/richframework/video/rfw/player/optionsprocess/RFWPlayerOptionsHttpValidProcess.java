package com.tencent.biz.richframework.video.rfw.player.optionsprocess;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager;

/* loaded from: classes5.dex */
public class RFWPlayerOptionsHttpValidProcess implements IRFWPlayerOptionsProcess {
    public static String DEFAULT_PROCESS_URL_HTTP_VALID = "DEFAULT_PROCESS_URL_HTTP_VALID";

    public /* synthetic */ String a(RFWPlayerOptions rFWPlayerOptions) {
        return a.a(this, rFWPlayerOptions);
    }

    public void enSureHttps(RFWPlayerOptions rFWPlayerOptions) {
        String realPlayUrl = rFWPlayerOptions.getRealPlayUrl();
        if (!TextUtils.isEmpty(realPlayUrl) && realPlayUrl.startsWith("http://")) {
            RFWLog.d(a(rFWPlayerOptions), RFWLog.USR, "enSureHttps ,http url:" + realPlayUrl);
            rFWPlayerOptions.setRealPlayUrl(realPlayUrl.replace("http://", "https://"));
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.optionsprocess.IRFWPlayerOptionsProcess
    public String getProcessKey() {
        return DEFAULT_PROCESS_URL_HTTP_VALID;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.optionsprocess.IRFWPlayerOptionsProcess
    public void onProcess(RFWPlayerOptions rFWPlayerOptions, RFWPlayerOptionsProcessManager.IProcessCallBack iProcessCallBack) {
        if (rFWPlayerOptions != null && iProcessCallBack != null) {
            if (rFWPlayerOptions.isVideo()) {
                RFWLog.d(a(rFWPlayerOptions), RFWLog.USR, "isVideo not need to ensureHttp");
                iProcessCallBack.onFinish(rFWPlayerOptions, true);
            } else {
                enSureHttps(rFWPlayerOptions);
                iProcessCallBack.onFinish(rFWPlayerOptions, true);
            }
        }
    }
}
