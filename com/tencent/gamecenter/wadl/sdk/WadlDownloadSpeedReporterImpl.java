package com.tencent.gamecenter.wadl.sdk;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.gamecenter.wadl.sdk.downloader.IFlowCallback;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.qqgame.QQGameDownloadSpeedReporter$GameDownloadInfo;
import tencent.im.qqgame.QQGameDownloadSpeedReporter$ReportDownloadSpeedRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J@\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J.\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/gamecenter/wadl/sdk/WadlDownloadSpeedReporterImpl;", "Lcom/tencent/gamecenter/wadl/biz/listener/WadlTrpcListener;", "Lcom/tencent/gamecenter/wadl/sdk/downloader/IFlowCallback;", "()V", "cmdMap", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "nextDuration", "", "getFilterCmds", "getIntervalTime", "onFlow", "", "globalSpeed", "", "appId", "useTime", "countLen", "reportDefLen", "mobileLen", "p2pLen", "onTrpcRsp", Const.BUNDLE_KEY_REQUEST, "Landroid/content/Intent;", "cmd", "ret", "rsp", "Lcom/tencent/gamecenter/wadl/biz/entity/TrpcProxy$TrpcInovkeRsp;", "Companion", "qqgamedownloader-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class WadlDownloadSpeedReporterImpl implements WadlTrpcListener, IFlowCallback {

    @NotNull
    public static final String TAG = "WadlDownloadSpeedReporterImpl";

    @NotNull
    private HashSet<String> cmdMap = new HashSet<>();
    private int nextDuration = 5000;

    public WadlDownloadSpeedReporterImpl() {
        QLog.i(TAG, 1, "[init]+++++++++++");
        this.cmdMap.add(WadlProxyConsts.CMD_REPORT_REAL_DOWNLOAD_SPEED);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFlow$lambda$1(long j3, long j16, String appId, long j17, long j18, long j19, long j26) {
        Intrinsics.checkNotNullParameter(appId, "$appId");
        try {
            QQGameDownloadSpeedReporter$GameDownloadInfo qQGameDownloadSpeedReporter$GameDownloadInfo = new QQGameDownloadSpeedReporter$GameDownloadInfo();
            qQGameDownloadSpeedReporter$GameDownloadInfo.p2p_downloaded.set(j16);
            if (!TextUtils.isEmpty(appId)) {
                qQGameDownloadSpeedReporter$GameDownloadInfo.appid.set(appId);
            }
            qQGameDownloadSpeedReporter$GameDownloadInfo.total_downloaded.set(j17);
            qQGameDownloadSpeedReporter$GameDownloadInfo.mobile_downloaded.set(j18);
            qQGameDownloadSpeedReporter$GameDownloadInfo.wifi_downloaded.set(j19);
            qQGameDownloadSpeedReporter$GameDownloadInfo.duration.set(j26);
            qQGameDownloadSpeedReporter$GameDownloadInfo.user_current_time.set(NetConnInfoCenter.getServerTimeMillis());
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).reportRealDownloadSpeed(j3, qQGameDownloadSpeedReporter$GameDownloadInfo);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[onFlow], err:", th5);
        }
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    @NotNull
    public HashSet<String> getFilterCmds() {
        return this.cmdMap;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.IFlowCallback
    /* renamed from: getIntervalTime, reason: from getter */
    public int getNextDuration() {
        return this.nextDuration;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.IFlowCallback
    public void onFlow(final long globalSpeed, @NotNull final String appId, final long useTime, final long countLen, final long reportDefLen, final long mobileLen, final long p2pLen) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 1, "globalSpeed:" + globalSpeed + ",appId:" + appId + ",countLen:" + countLen + ",reportDefLen:" + reportDefLen + ",mobileLen:" + mobileLen + ",p2pLen:" + p2pLen);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.sdk.a
            @Override // java.lang.Runnable
            public final void run() {
                WadlDownloadSpeedReporterImpl.onFlow$lambda$1(globalSpeed, p2pLen, appId, countLen, mobileLen, reportDefLen, useTime);
            }
        }, 128, null, true);
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public void onTrpcRsp(@Nullable Intent request, @Nullable String cmd, long ret, @Nullable TrpcProxy.TrpcInovkeRsp rsp) {
        try {
            if (rsp == null) {
                QLog.d(TAG, 1, "[onTrpcRsp] cmd=" + cmd + ",ret=" + ret + " rsp is null");
                return;
            }
            if (!Intrinsics.areEqual(WadlProxyConsts.CMD_REPORT_REAL_DOWNLOAD_SPEED, cmd) || ret != 0) {
                return;
            }
            QQGameDownloadSpeedReporter$ReportDownloadSpeedRsp qQGameDownloadSpeedReporter$ReportDownloadSpeedRsp = new QQGameDownloadSpeedReporter$ReportDownloadSpeedRsp();
            qQGameDownloadSpeedReporter$ReportDownloadSpeedRsp.mergeFrom(rsp.data.get().toByteArray());
            int i3 = (int) qQGameDownloadSpeedReporter$ReportDownloadSpeedRsp.next_duration.get();
            this.nextDuration = i3;
            QLog.i(TAG, 1, "[onTrpcRsp], nextDuration:" + i3);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[onTrpcRsp], error:" + th5);
        }
    }
}
