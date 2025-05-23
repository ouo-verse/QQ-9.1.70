package com.tencent.gamecenter.wadl.sdk;

import android.content.Context;
import com.tencent.gamecenter.wadl.sdk.downloader.IFlowCallback;
import com.tencent.gamecenter.wadl.sdk.downloader.IThreadPool;
import com.tencent.gamecenter.wadl.sdk.downloader.pcdn.PCDNInitParam;
import com.tencent.raft.standard.log.IRLog;
import com.tencent.raft.standard.report.IRReport;
import com.tencent.raft.standard.task.IRTask;

/* loaded from: classes6.dex */
public final class InitParam {

    /* renamed from: a, reason: collision with root package name */
    private Context f106967a;
    public int appid;

    /* renamed from: b, reason: collision with root package name */
    private PCDNInitParam f106968b;
    public IFlowCallback iFlowCallback;
    public IRTask iRtaskDeleGaye;
    public IThreadPool iThreadPool;
    public IRLog iWadlLogDelegate;
    public IRReport iWadlReportDelegate;
    public boolean maskDeviceInfo = false;
    public boolean isTestMode = false;
    public int ScheduleCorePoolNum = 3;

    public InitParam(Context context, int i3) {
        this.f106967a = context.getApplicationContext();
        this.appid = i3;
    }

    public Context getContext() {
        return this.f106967a;
    }

    public PCDNInitParam getPcdnInitParam() {
        return this.f106968b;
    }

    public void initDelegate(IRReport iRReport, IRLog iRLog, IRTask iRTask) {
        initDelegate(iRReport, iRLog, iRTask, new com.tencent.gamecenter.wadl.sdk.common.b.j.a());
    }

    public void setFlowCallback(IFlowCallback iFlowCallback) {
        this.iFlowCallback = iFlowCallback;
    }

    public void setPcdnInitParam(PCDNInitParam pCDNInitParam) {
        this.f106968b = pCDNInitParam;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("[");
        sb5.append("appid:" + this.appid);
        sb5.append(",isTestMode:" + this.isTestMode);
        sb5.append(",maskDeviceInfo:" + this.maskDeviceInfo);
        sb5.append("]");
        return sb5.toString();
    }

    public void initDelegate(IRReport iRReport, IRLog iRLog, IRTask iRTask, IThreadPool iThreadPool) {
        this.iWadlReportDelegate = iRReport;
        this.iWadlLogDelegate = iRLog;
        this.iRtaskDeleGaye = iRTask;
        this.iThreadPool = iThreadPool;
    }
}
