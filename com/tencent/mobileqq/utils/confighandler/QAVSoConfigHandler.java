package com.tencent.mobileqq.utils.confighandler;

import com.tencent.av.so.ResInfo;
import com.tencent.av.so.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQAudioHelper;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QAVSoConfigHandler extends ConfigHandler<ResInfo> {
    public QAVSoConfigHandler() {
        super("AVResMgr", null);
    }

    @Override // com.tencent.mobileqq.utils.confighandler.ConfigHandler
    public int getConfigVer() {
        if (!QQAudioHelper.f()) {
            return 0;
        }
        throw new IllegalArgumentException(this.TAG + HardCodeUtil.qqStr(R.string.pr6));
    }

    @Override // com.tencent.mobileqq.utils.confighandler.ConfigHandler
    public void saveConfig(String str, int i3) {
        if (!QQAudioHelper.f()) {
            return;
        }
        throw new IllegalArgumentException(this.TAG + HardCodeUtil.qqStr(R.string.pr5));
    }

    @Override // com.tencent.mobileqq.utils.confighandler.ConfigHandler
    public void onGetConfigFinish(QQAppInterface qQAppInterface, String str, ResInfo resInfo) {
        a.e().f(qQAppInterface, str, resInfo);
    }
}
