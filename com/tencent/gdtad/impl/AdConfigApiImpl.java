package com.tencent.gdtad.impl;

import com.tencent.gdtad.IAdConfigApi;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.qphone.base.util.QLog;
import km0.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/gdtad/impl/AdConfigApiImpl;", "Lcom/tencent/gdtad/IAdConfigApi;", "()V", "TAG", "", "getCanInstallCheck", "", "getCanRefreshScheduleData", "getCanShowInstallTip", "getCanShowTabAdBanner", "getCanShowTabAdBannerGuide", "getRequestTabAdBannerDelay", "", "getTabAdBannerPullProcess", "", "qqad-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class AdConfigApiImpl implements IAdConfigApi {

    @NotNull
    private final String TAG = "AdConfigApiImpl";

    @Override // com.tencent.gdtad.IAdConfigApi
    public boolean getCanInstallCheck() {
        h hVar = new h();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        hVar.e(from.decodeString(hVar.getCONTENT_KEY(), null));
        QLog.d(this.TAG, 2, "getCanInstallCheck " + hVar.getCanCheckInstall());
        return hVar.getCanCheckInstall();
    }

    @Override // com.tencent.gdtad.IAdConfigApi
    public boolean getCanRefreshScheduleData() {
        h hVar = new h();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        hVar.e(from.decodeString(hVar.getCONTENT_KEY(), null));
        QLog.d(this.TAG, 2, "getCanRefreshData " + hVar.getCanRefreshData());
        return hVar.getCanRefreshData();
    }

    @Override // com.tencent.gdtad.IAdConfigApi
    public boolean getCanShowInstallTip() {
        h hVar = new h();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        hVar.e(from.decodeString(hVar.getCONTENT_KEY(), null));
        QLog.d(this.TAG, 2, "getCanShowInstallTip " + hVar.getCanShowInstall());
        return hVar.getCanShowInstall();
    }

    @Override // com.tencent.gdtad.IAdConfigApi
    public boolean getCanShowTabAdBanner() {
        km0.b bVar = new km0.b();
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        bVar.f(fromV2.getString(bVar.getCONTENT_KEY(), null));
        QLog.d(this.TAG, 2, "getCanShowTabAdBanner " + bVar.getCanShowTabAmsBanner());
        return bVar.getCanShowTabAmsBanner();
    }

    @Override // com.tencent.gdtad.IAdConfigApi
    public boolean getCanShowTabAdBannerGuide() {
        km0.b bVar = new km0.b();
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        bVar.f(fromV2.getString(bVar.getCONTENT_KEY(), null));
        QLog.d(this.TAG, 2, "getCanShowTabAdBannerGuide " + bVar.getCanShowTabAmsBannerGuide());
        return bVar.getCanShowTabAmsBannerGuide();
    }

    @Override // com.tencent.gdtad.IAdConfigApi
    public long getRequestTabAdBannerDelay() {
        km0.b bVar = new km0.b();
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        bVar.f(fromV2.getString(bVar.getCONTENT_KEY(), null));
        QLog.d(this.TAG, 2, "getRequestTabAdBannerDelay " + bVar.getBannerRequestDelay());
        return bVar.getBannerRequestDelay();
    }

    @Override // com.tencent.gdtad.IAdConfigApi
    public double getTabAdBannerPullProcess() {
        km0.b bVar = new km0.b();
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        bVar.f(fromV2.getString(bVar.getCONTENT_KEY(), null));
        QLog.d(this.TAG, 2, "getTabAdBannerPullProcess " + bVar.getBannerAioPullJumpProcess());
        return bVar.getBannerAioPullJumpProcess();
    }
}
