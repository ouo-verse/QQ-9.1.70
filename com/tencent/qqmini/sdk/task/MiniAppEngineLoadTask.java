package com.tencent.qqmini.sdk.task;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCodeKt;
import com.tencent.qqmini.sdk.launcher.action.EngineChannel;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.InstalledEngine;
import com.tencent.qqmini.sdk.manager.MiniLoadManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniAppEngineLoadTask extends AsyncTask implements EngineChannel.Receiver {
    public static final int ERR_ENGINE_NEED_UPDATE = 101;
    public static final int ERR_ENGINE_TIMEOUT = 103;
    public static final int ERR_INTERNAL = 102;
    public static final int ERR_INVALID_OP = 1;
    public static final int ERR_UNKNOWN = 100;
    private static final int INSTALL_ENGINE_REQUEST_COUNT_MAX = 2;
    public static final String LOG_TAG = "MiniAppEngineLoadTask";
    private int installEngineRequestCount;
    private InstalledEngine mEngine;
    private EngineChannel mEngineChannel;
    private int mLibType;
    private MiniAppInfo mMiniAppInfo;
    private MiniLoadManager.MiniLoadListener mMiniLibLoadListener;

    public MiniAppEngineLoadTask(Context context, BaseRuntimeLoader baseRuntimeLoader) {
        super(context, baseRuntimeLoader);
        this.mLibType = 3;
        this.installEngineRequestCount = 0;
    }

    private boolean isMiniAppSatisfy(InstalledEngine installedEngine, MiniAppInfo miniAppInfo) {
        if (installedEngine == null) {
            return false;
        }
        return true;
    }

    private synchronized void loadEngine(InstalledEngine installedEngine) {
        if (this.mEngine == null) {
            QMLog.i(LOG_TAG, "[MiniEng]mEngine == null, loadEngineTask is reset?");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        QMLog.i(LOG_TAG, "[MiniEng]initEngine");
        if (installedEngine != null) {
            MiniAppSoLoader.g().setEngine(installedEngine);
        }
        if (!MiniAppSoLoader.g().loadAllMiniSo()) {
            QMLog.e(LOG_TAG, "[MiniEng]initEngine fail");
            onTaskFailed();
            return;
        }
        QMLog.e(LOG_TAG, "[MiniEng]loadSo cost time " + (System.currentTimeMillis() - currentTimeMillis));
        onTaskSucceed();
    }

    private void sendCommand(int i3, Bundle bundle) {
        bundle.putInt("baseLibType", this.mLibType);
        bundle.putInt("enginePid", Process.myPid());
        QMLog.i(LOG_TAG, "[MiniEng]installEngineRequestCount " + this.installEngineRequestCount);
        if (this.installEngineRequestCount >= 2) {
            QMLog.i(LOG_TAG, "[MiniEng]GET_INSTALLED_ENGINE_LIST requestCount reaches max 2");
            onTaskFailed(103, "\u52a0\u8f7d\u5f15\u64ce\u8d85\u65f6");
        } else {
            this.mEngineChannel.send(i3, bundle);
            if (i3 == 3) {
                this.installEngineRequestCount++;
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.task.AsyncTask
    public void executeAsync() {
        if (this.mEngineChannel == null) {
            onTaskFailed(1, "\u53c2\u6570\u9519\u8bef, channel\u4e3a\u7a7a");
            return;
        }
        EngineChannel engineChannel = new EngineChannel();
        engineChannel.setName("AppEngine(" + Process.myPid() + ")");
        engineChannel.setReceiver(this);
        Bundle bundle = new Bundle();
        bundle.putParcelable("engineChannel", engineChannel);
        sendCommand(1, bundle);
    }

    public InstalledEngine getEngine() {
        return this.mEngine;
    }

    @Override // com.tencent.qqmini.sdk.launcher.action.EngineChannel.Receiver
    public void onReceiveData(int i3, Bundle bundle) {
        QMLog.i(LOG_TAG, "[MiniEng] onReceiveData what=" + i3);
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        if (i3 == 51) {
            if (bundle != null) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("installedEngineList");
                if (parcelableArrayList != null) {
                    int size = parcelableArrayList.size();
                    QMLog.i(LOG_TAG, "[MiniEng] getInstalledEngineList success " + size);
                    if (size > 0) {
                        InstalledEngine installedEngine = (InstalledEngine) parcelableArrayList.get(0);
                        if (isMiniAppSatisfy(installedEngine, this.mMiniAppInfo)) {
                            this.mEngine = installedEngine;
                            loadEngine(installedEngine);
                            return;
                        } else {
                            onTaskFailed(101, WinkBaseErrorCodeKt.ERROR_MSG_UNKNOWN);
                            return;
                        }
                    }
                    QMLog.i(LOG_TAG, "[MiniEng] no engine installed, send cmd WHAT_INSTALL_LATEST_ENGINE");
                    sendCommand(3, new Bundle());
                    return;
                }
                QMLog.i(LOG_TAG, "[MiniEng] getInstalledEngineList miniAppEngineList is null");
                onTaskFailed(102, "\u83b7\u53d6\u5f15\u64ce\u4fe1\u606f\u5931\u8d25");
                return;
            }
            QMLog.i(LOG_TAG, "[MiniEng] getInstalledEngineList data is null");
            onTaskFailed(102, "\u83b7\u53d6\u5f15\u64ce\u4fe1\u606f\u5931\u8d25");
            return;
        }
        if (i3 == 52) {
            QMLog.i(LOG_TAG, "[MiniEng]EVENT_INSTALL_LATEST_ENGINE_BEGIN");
            return;
        }
        if (i3 == 53) {
            if (bundle != null) {
                QMLog.i(LOG_TAG, "[MiniEng]EVENT_INSTALL_LATEST_ENGINE_PROCESS " + bundle.getString("engineInstallerMessage"));
                return;
            }
            return;
        }
        if (i3 == 54) {
            QMLog.i(LOG_TAG, "[MiniEng]EVENT_INSTALL_LATEST_ENGINE_FINISH");
            sendCommand(1, new Bundle());
        }
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask
    public synchronized void reset() {
        QMLog.i(LOG_TAG, "[MiniEng]" + this + " reset ");
        this.installEngineRequestCount = 0;
        this.mMiniAppInfo = null;
        this.mEngine = null;
        super.reset();
    }

    public void setDownloadListener(MiniLoadManager.MiniLoadListener miniLoadListener) {
        this.mMiniLibLoadListener = miniLoadListener;
    }

    public void setEngineChannel(EngineChannel engineChannel) {
        this.mEngineChannel = engineChannel;
    }

    public void setMiniAppInfo(MiniAppInfo miniAppInfo) {
        this.mMiniAppInfo = miniAppInfo;
    }
}
