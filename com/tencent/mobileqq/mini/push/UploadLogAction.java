package com.tencent.mobileqq.mini.push;

import com.tencent.mobileqq.mini.utils.ReportLogUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class UploadLogAction implements PushAction {
    public static final String KEY_APPID = "appid";
    public static final String TAG = "UploadLogAction";

    @Override // com.tencent.mobileqq.mini.push.PushAction
    public void exec(MiniAppControlInfo miniAppControlInfo) {
        if (miniAppControlInfo.data.containsKey("appid")) {
            String str = miniAppControlInfo.data.get("appid");
            QLog.d(TAG, 1, "UploadLogAction appid:" + str);
            ReportLogUtil.compressAndUploadLog(str);
            return;
        }
        QLog.d(TAG, 1, "UploadLogAction has no appid parameter! " + miniAppControlInfo);
    }
}
