package com.tencent.mobileqq.minigame.va.download;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameDLService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.mobileqq.minigame.va.MiniGameDiffPatchInfo;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadData;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadDataWrapper;
import com.tencent.mobileqq.minigame.va.util.DiffPatchUtil;
import com.tencent.mobileqq.minigame.va.util.MiniGameVAUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/download/MiniGameVADownload;", "", "Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadDataWrapper;", "data", "Lcom/tencent/gamecenter/wadl/biz/entity/WadlParams;", "getWadlParams", "", "startDownload", "Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadData;", "resumeDownload", "pauseDownload", "deleteDownload", "queryDownload", "Lnl0/d;", "callback", "destroyDownloadService", "", "businessId", "I", "Lcom/tencent/gamecenter/wadl/api/IQQGameDLService;", "mDownloadService", "Lcom/tencent/gamecenter/wadl/api/IQQGameDLService;", "<init>", "(ILnl0/d;)V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniGameVADownload {
    private final int businessId;
    private IQQGameDLService mDownloadService;

    public MiniGameVADownload(int i3, nl0.d callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.businessId = i3;
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameDLService.class, ProcessConstant.MULTI);
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026a, ProcessConstant.MULTI)");
        IQQGameDLService iQQGameDLService = (IQQGameDLService) runtimeService;
        this.mDownloadService = iQQGameDLService;
        iQQGameDLService.registerDownloadCallBack(callback);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0051, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final WadlParams getWadlParams(MiniGameDownloadDataWrapper data) {
        Integer intOrNull;
        MiniGameDownloadData data2 = data.getData();
        WadlParams wadlParams = new WadlParams(data2.getGameId(), data2.getPkgName());
        wadlParams.setFlagDisable(1);
        wadlParams.setFlagDisable(4);
        wadlParams.packageName = data2.getPkgName();
        wadlParams.appName = data2.getGameName();
        wadlParams.iconUrl = data2.getGameIcon();
        MiniGameDiffPatchInfo diffPatchInfo = data2.getDiffPatchInfo();
        if (diffPatchInfo != null) {
            wadlParams.apkUrl = diffPatchInfo.getDiffPatchUrl();
            wadlParams.extraData = DiffPatchUtil.INSTANCE.diffPatchInfo2Json(diffPatchInfo);
        } else {
            wadlParams.apkUrl = data2.getDownloadUrl();
        }
        wadlParams.setFlags(524288);
        String versionCode = data2.getVersionCode();
        int intValue = (versionCode == null || intOrNull == null) ? 0 : intOrNull.intValue();
        wadlParams.versionCode = intValue;
        wadlParams.via = "MiniBox";
        wadlParams.isDirectUseDualWay = MiniGameVAUtil.getUseWifiAndXGSwitch() ? 1 : 0;
        if (data.getOnlyOnWifi()) {
            wadlParams.setFlags(8);
        }
        return wadlParams;
    }

    public final void deleteDownload(MiniGameDownloadData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mDownloadService.deleteDownload(this.businessId, data.getPkgName());
    }

    public final void destroyDownloadService(nl0.d callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mDownloadService.unRegisterDownloadCallBack(callback);
    }

    public final void pauseDownload(MiniGameDownloadData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mDownloadService.doPauseAction(this.businessId, data.getPkgName());
    }

    public final void queryDownload() {
        this.mDownloadService.doQueryAllTask(this.businessId);
    }

    public final void resumeDownload(MiniGameDownloadData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mDownloadService.doResumeAction(this.businessId, data.getPkgName());
    }

    public final void startDownload(MiniGameDownloadDataWrapper data) {
        Intrinsics.checkNotNullParameter(data, "data");
        WadlParams wadlParams = getWadlParams(data);
        if (TextUtils.isEmpty(wadlParams != null ? wadlParams.apkUrl : null)) {
            MiniGameVAUtil.showDebugToast("\u4e0b\u8f7durl\u4e3a\u7a7a");
            QLog.e("MiniGameVADownload", 1, "startDownload but url is empty wadlParams:" + wadlParams);
            return;
        }
        this.mDownloadService.doDownloadAction(this.businessId, wadlParams);
        MiniGameVAUtil.showDownloadToastInDebug(data);
    }
}
