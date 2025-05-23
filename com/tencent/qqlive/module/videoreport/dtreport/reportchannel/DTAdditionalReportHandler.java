package com.tencent.qqlive.module.videoreport.dtreport.reportchannel;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqlive.module.videoreport.IAdditionalReportListener;
import com.tencent.qqlive.module.videoreport.ISessionChangeListener;
import com.tencent.qqlive.module.videoreport.SessionChangeReason;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DTAdditionalReportHandler implements IAdditionalReportListener, ISessionChangeListener {
    private static final String TAG = "app.AdditionalReport";
    private String mLastCallFrom;
    private String mLastCallScheme;
    private int mLastStartType;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class InstanceHolder {
        static final DTAdditionalReportHandler INSTANCE = new DTAdditionalReportHandler();

        InstanceHolder() {
        }
    }

    public static DTAdditionalReportHandler getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private boolean handleAppVstEvent() {
        boolean z16;
        IDTParamProvider dTParamProvider = DTEventDynamicParams.getInstance().getDTParamProvider();
        if (dTParamProvider == null) {
            return false;
        }
        int startType = dTParamProvider.getStartType();
        String callFrom = dTParamProvider.getCallFrom();
        String callScheme = dTParamProvider.getCallScheme();
        if (VideoReport.isDebugMode()) {
            Log.d(TAG, "handleAppVstEvent: startType=" + startType + ", callFrom=" + callFrom + ", callScheme=" + callScheme);
        }
        boolean isStartParamsChanged = isStartParamsChanged(startType, callFrom, callScheme);
        if (startType == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || !isStartParamsChanged) {
            return false;
        }
        this.mLastStartType = startType;
        this.mLastCallFrom = callFrom;
        this.mLastCallScheme = callScheme;
        return true;
    }

    private boolean isStartParamsChanged(int i3, String str, String str2) {
        if (this.mLastStartType == i3 && TextUtils.equals(this.mLastCallFrom, str) && TextUtils.equals(this.mLastCallScheme, str2)) {
            return false;
        }
        return true;
    }

    private void updateAppStartParams() {
        IDTParamProvider dTParamProvider = DTEventDynamicParams.getInstance().getDTParamProvider();
        if (dTParamProvider == null) {
            return;
        }
        this.mLastStartType = dTParamProvider.getStartType();
        this.mLastCallFrom = dTParamProvider.getCallFrom();
        this.mLastCallScheme = dTParamProvider.getCallScheme();
        if (VideoReport.isDebugMode()) {
            Log.d(TAG, "updateAppStartParams: mLastStartType=" + this.mLastStartType + "\uff0c mLastCallFrom=" + this.mLastCallFrom + "\uff0c mLastCallScheme=" + this.mLastCallScheme);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.ISessionChangeListener
    public void changeSession(SessionChangeReason sessionChangeReason) {
        if (VideoReport.isDebugMode()) {
            Log.d(TAG, "changeSession: reason=" + sessionChangeReason);
        }
        updateAppStartParams();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getCallFrom() {
        return this.mLastCallFrom;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getCallScheme() {
        return this.mLastCallScheme;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getStartType() {
        return this.mLastStartType;
    }

    @Override // com.tencent.qqlive.module.videoreport.IAdditionalReportListener
    public boolean shouldAdditionalReport(String str) {
        if (VideoReport.isDebugMode()) {
            Log.d(TAG, "shouldAdditionalReport: eventKey=" + str);
        }
        if (EventKey.ORIGIN_VST.equals(str)) {
            return handleAppVstEvent();
        }
        return false;
    }

    DTAdditionalReportHandler() {
        this.mLastStartType = -1;
        this.mLastCallFrom = "";
        this.mLastCallScheme = "";
        VideoReport.registerSessionChangeListener(this);
    }
}
