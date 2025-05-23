package com.tencent.mobileqq.zplan.authorize.impl.checker.mod;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.data.ZootopiaMapLoadingParams;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManagerIpc;
import com.tencent.mobileqq.zootopia.download.data.ZootopiaDownloadData;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J&\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/checker/mod/ModNativeStatusChecker;", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/BaseChecker;", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/mod/a;", "Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/mobileqq/zootopia/download/data/ZootopiaDownloadData;", "downloadData", "lastCheckResult", "Lcom/tencent/mobileqq/zplan/authorize/api/a;", "callback", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", DomainData.DOMAIN_NAME, "", "b", "l", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ModNativeStatusChecker extends BaseChecker<EnterModCheckRequest, EnterModCheckResult> {
    /* JADX INFO: Access modifiers changed from: private */
    public final void m(EnterModCheckRequest request, ZootopiaDownloadData downloadData, EnterModCheckResult lastCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback) {
        ZootopiaEnterParams enterParams = request.getEnterParams();
        request.c(com.tencent.mobileqq.zootopia.download.c.f328029a.n(downloadData, null));
        request.getEnterParams().setStartTime(enterParams.getStartTime());
        request.getEnterParams().setLoadingId(enterParams.getLoadingId());
        request.getEnterParams().setSource(enterParams.getSource());
        request.getEnterParams().setUeParams(enterParams.getUeParams());
        request.getEnterParams().setDownloaded(enterParams.getIsDownloaded());
        request.getEnterParams().setProgress(enterParams.getProgress());
        lastCheckResult.setEnterParamsAfterCheck(request.getEnterParams());
        d(request, lastCheckResult, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100472", true);
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker
    public String b() {
        return "ModNativeStatusChecker";
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void a(final EnterModCheckRequest request, final EnterModCheckResult lastCheckResult, final com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(lastCheckResult, "lastCheckResult");
        Intrinsics.checkNotNullParameter(callback, "callback");
        super.a(request, lastCheckResult, callback);
        if (!NetworkUtil.isNetworkAvailable()) {
            lastCheckResult.setResultCode(1);
            i("\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8bbe\u7f6e\u3002");
            callback.b(lastCheckResult);
            return;
        }
        ZootopiaDownloadManagerIpc.f328013a.g(request.getEnterParams().getMapId(), new Function1<ZootopiaDownloadData, Unit>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.checker.mod.ModNativeStatusChecker$check$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ZootopiaDownloadData zootopiaDownloadData) {
                invoke2(zootopiaDownloadData);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:11:0x0051, code lost:
            
                if (r1.getIsUseNewLoading() == true) goto L13;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(ZootopiaDownloadData zootopiaDownloadData) {
                boolean z16;
                boolean n3;
                if (zootopiaDownloadData != null) {
                    ModNativeStatusChecker.this.f("downloadStatus = " + zootopiaDownloadData.getResData().getDownloadStatus());
                    if (zootopiaDownloadData.getResData().getDownloadStatus() == 5) {
                        ModNativeStatusChecker.this.f("check pass");
                        ModNativeStatusChecker.this.m(request, zootopiaDownloadData, lastCheckResult, callback);
                        return;
                    }
                    ZootopiaMapLoadingParams loadingParams = zootopiaDownloadData.getExtraData().getLoadingParams();
                    if (loadingParams != null) {
                        z16 = true;
                    }
                    z16 = false;
                    n3 = ModNativeStatusChecker.this.n();
                    if (n3 && z16 && (zootopiaDownloadData.getResData().getDownloadStatus() == 2 || zootopiaDownloadData.getResData().getDownloadStatus() == 4)) {
                        ModNativeStatusChecker.this.f("check pass new loading");
                        request.getEnterParams().setDownloaded(Boolean.FALSE);
                        request.getEnterParams().setProgress(Float.valueOf(zootopiaDownloadData.getResData().getProgress()));
                        lastCheckResult.setResultCode(25);
                        lastCheckResult.setProcessInner(false);
                        ModNativeStatusChecker.this.m(request, zootopiaDownloadData, lastCheckResult, callback);
                        return;
                    }
                    ModNativeStatusChecker.this.f("check no complete");
                    lastCheckResult.setResultCode(16);
                    lastCheckResult.setProcessInner(false);
                    callback.b(lastCheckResult);
                    return;
                }
                ModNativeStatusChecker.this.f("check no download res");
                lastCheckResult.setProcessInner(false);
                lastCheckResult.setResultCode(17);
                callback.b(lastCheckResult);
            }
        });
    }
}
