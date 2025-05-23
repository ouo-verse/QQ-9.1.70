package com.tencent.gdtad.impl;

import com.tencent.gdtad.IRealTimeConfigApi;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import km0.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/gdtad/impl/RealTimeConfigApiImpl;", "Lcom/tencent/gdtad/IRealTimeConfigApi;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "clearRealTimeSplashConfig", "", "getAmsOlympicShowLimitEnable", "", "getRealTimeSplashAllLimit", "", "getRealTimeSplashColdLimit", "getRealTimeSplashDelayTime", "", "getRealTimeSplashDownloadRes", "getRealTimeSplashDuration", "getRealTimeSplashHotLimit", "getRealTimeSplashIsEffectiveTime", "qqad-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class RealTimeConfigApiImpl implements IRealTimeConfigApi {

    @NotNull
    private final String TAG = "RealTimeConfigApiImpl";

    @Override // com.tencent.gdtad.IRealTimeConfigApi
    public void clearRealTimeSplashConfig() {
        g gVar = new g();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        from.encodeString(gVar.getCONTENT_KEY(), null);
    }

    @Override // com.tencent.gdtad.IRealTimeConfigApi
    public boolean getAmsOlympicShowLimitEnable() {
        g gVar = new g();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        gVar.j(from.decodeString(gVar.getCONTENT_KEY(), null));
        QLog.d(this.TAG, 1, "getAmsOlympicShowLimitEnable " + gVar.getAmsOlympicShowLimitEnable());
        return gVar.getAmsOlympicShowLimitEnable();
    }

    @Override // com.tencent.gdtad.IRealTimeConfigApi
    public int getRealTimeSplashAllLimit() {
        g gVar = new g();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        gVar.j(from.decodeString(gVar.getCONTENT_KEY(), null));
        QLog.d(this.TAG, 1, "getRealTimeSplashAllLimit " + gVar.getAmsRealTimeSelectOrderLimit());
        return gVar.getAmsRealTimeSelectOrderLimit();
    }

    @Override // com.tencent.gdtad.IRealTimeConfigApi
    public int getRealTimeSplashColdLimit() {
        g gVar = new g();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        gVar.j(from.decodeString(gVar.getCONTENT_KEY(), null));
        QLog.d(this.TAG, 1, "getRealTimeSplashColdLimit " + gVar.getAmsRealTimeSelectOrderWarmLimit());
        return gVar.getAmsRealTimeSelectOrderWarmLimit();
    }

    @Override // com.tencent.gdtad.IRealTimeConfigApi
    public long getRealTimeSplashDelayTime() {
        g gVar = new g();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        gVar.j(from.decodeString(gVar.getCONTENT_KEY(), null));
        QLog.d(this.TAG, 1, "getRealTimeSplashDelayTime " + gVar.getAmsRealTimeSelectOrderDelayTime());
        return gVar.getAmsRealTimeSelectOrderDelayTime();
    }

    @Override // com.tencent.gdtad.IRealTimeConfigApi
    public boolean getRealTimeSplashDownloadRes() {
        g gVar = new g();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        gVar.j(from.decodeString(gVar.getCONTENT_KEY(), null));
        QLog.d(this.TAG, 1, "getRealTimeSplashDownloadRes " + gVar.getAmsRealTimeSelectOrderResourceDownloadEnable());
        return gVar.getAmsRealTimeSelectOrderResourceDownloadEnable();
    }

    @Override // com.tencent.gdtad.IRealTimeConfigApi
    public int getRealTimeSplashDuration() {
        g gVar = new g();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        gVar.j(from.decodeString(gVar.getCONTENT_KEY(), null));
        QLog.d(this.TAG, 1, "getRealTimeSplashDuration " + gVar.getAmsRealTimeSelectOrderDuration());
        return gVar.getAmsRealTimeSelectOrderDuration();
    }

    @Override // com.tencent.gdtad.IRealTimeConfigApi
    public int getRealTimeSplashHotLimit() {
        g gVar = new g();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        gVar.j(from.decodeString(gVar.getCONTENT_KEY(), null));
        QLog.d(this.TAG, 1, "getRealTimeSplashHotLimit " + gVar.getAmsRealTimeSelectOrderWarmLimit());
        return gVar.getAmsRealTimeSelectOrderWarmLimit();
    }

    @Override // com.tencent.gdtad.IRealTimeConfigApi
    public boolean getRealTimeSplashIsEffectiveTime() {
        g gVar = new g();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        gVar.j(from.decodeString(gVar.getCONTENT_KEY(), null));
        QLog.d(this.TAG, 1, "getRealTimeSplashIsEffectiveTime " + gVar.i());
        return gVar.i();
    }

    @NotNull
    public final String getTAG() {
        return this.TAG;
    }
}
