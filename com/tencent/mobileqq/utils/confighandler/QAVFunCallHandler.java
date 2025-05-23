package com.tencent.mobileqq.utils.confighandler;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.confighandler.NormalConfigHandler;
import com.tencent.mobileqq.utils.confighandler.QAVFunCallConfig;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QAVFunCallHandler extends NormalConfigHandler<QAVFunCallConfig> {
    NormalConfigHandler.GetConfigListen<QAVFunCallConfig> mGetConfigListen;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements NormalConfigHandler.GetConfigListen<QAVFunCallConfig> {
        a() {
        }

        @Override // com.tencent.mobileqq.utils.confighandler.NormalConfigHandler.GetConfigListen
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onGetConfig(AppInterface appInterface, QAVFunCallConfig qAVFunCallConfig) {
            QAVFunCallHandler.this.setConfig(qAVFunCallConfig);
            QAVFunCallHandler.this.onGetConfig(appInterface);
            QAVFunCallHandler.this.requestPreDownload("onGetConfig", appInterface);
        }
    }

    public QAVFunCallHandler(String str) {
        super(QAVFunCallConfig.TAG, str, null, null, null);
        this.mGetConfigListen = new a();
    }

    @Override // com.tencent.mobileqq.utils.confighandler.ConfigHandler
    public void doOnReconnect(QQAppInterface qQAppInterface) {
        if (!isConfigReady()) {
            syncGetConfigInfo(qQAppInterface, this.mGetConfigListen);
        } else {
            requestPreDownload("doOnReconnect", qQAppInterface);
        }
    }

    @Override // com.tencent.mobileqq.utils.confighandler.NormalConfigHandler
    protected int getConfigID() {
        return 382;
    }

    void onGetConfig(AppInterface appInterface) {
        int i3;
        SharedPreferences funCallSP;
        QAVFunCallConfig config = getConfig();
        if (config == null) {
            return;
        }
        for (QAVFunCallConfig.FCItem fCItem : config.fcItems.values()) {
            if (!ConfigUtil.isExpired(fCItem.end) && (i3 = fCItem.fcid) != 0 && !TextUtils.isEmpty(fCItem.media) && (funCallSP = VipFunCallUtil.getFunCallSP(appInterface, 0, String.valueOf(i3))) != null && (funCallSP.getLong(VipFunCallConstants.KEY_LOCAL_VERSION, 0L) != config.serverVer || TextUtils.isEmpty(funCallSP.getString("_6", null)))) {
                SharedPreferences.Editor edit = funCallSP.edit();
                edit.putInt("callId", i3);
                edit.putLong(VipFunCallConstants.KEY_LOCAL_VERSION, config.serverVer);
                edit.putString("_6", fCItem.media);
                edit.commit();
            }
        }
    }

    @Override // com.tencent.mobileqq.utils.confighandler.NormalConfigHandler
    public QAVFunCallConfig getConfigDirect() {
        if (this.mConfig == 0) {
            setConfig((QAVFunCallConfig) ConfigHandler.getConfigInfoNew(this.TAG, null, getConfigID(), getConfigInfoClass(), this.mUin));
        }
        return (QAVFunCallConfig) this.mConfig;
    }

    @Override // com.tencent.mobileqq.utils.confighandler.ConfigHandler
    public void onGetConfigFinish(QQAppInterface qQAppInterface, String str, QAVFunCallConfig qAVFunCallConfig) {
        if (qAVFunCallConfig != null) {
            setConfig(qAVFunCallConfig);
        }
        if (!isConfigReady()) {
            syncGetConfigInfo(qQAppInterface, this.mGetConfigListen);
        } else {
            onGetConfig(qQAppInterface);
            requestPreDownload("onGetConfigFinish", qQAppInterface);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestPreDownload(String str, AppInterface appInterface) {
    }
}
