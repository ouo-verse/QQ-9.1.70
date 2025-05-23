package com.tencent.gdtad.api.interstitial;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u0003B\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J$\u0010\u0012\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/gdtad/api/interstitial/c;", "Lcom/tencent/gdtad/api/interstitial/IGdtInterstitialAd;", "Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;", "a", "", TianShuMMKVConstant.LicenseInfoKey.CAN_SHOW, "Lorg/json/JSONObject;", "antiSpamParams", "", "setAntiSpamParamsForDisplayOnReportServer", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "show", "close", "", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "intent", "onClose", "Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;", "mParams", "b", "Z", "mDisplayed", "<init>", "(Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;)V", "c", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c implements IGdtInterstitialAd {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final GdtInterstitialParams mParams;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean mDisplayed;

    public c(@Nullable GdtInterstitialParams gdtInterstitialParams) {
        this.mParams = gdtInterstitialParams;
    }

    /* renamed from: a, reason: from getter */
    private final GdtInterstitialParams getMParams() {
        return this.mParams;
    }

    @Override // com.tencent.gdtad.api.interstitial.IGdtInterstitialAd
    public boolean canShow() {
        boolean z16;
        if (this.mDisplayed || getMParams() == null) {
            return false;
        }
        GdtInterstitialParams mParams = getMParams();
        if (mParams != null && mParams.canShow()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.gdtad.api.interstitial.IGdtInterstitialAd
    public void close(@Nullable Activity activity) {
        QLog.d("GdtInterstitialAdKuikly", 1, "close");
    }

    @Override // com.tencent.gdtad.api.interstitial.IGdtInterstitialAd
    public void onClose(@Nullable Activity activity, int resultCode, @Nullable Intent intent) {
        QLog.d("GdtInterstitialAdKuikly", 1, "close");
    }

    @Override // com.tencent.gdtad.api.interstitial.IGdtInterstitialAd
    public void setAntiSpamParamsForDisplayOnReportServer(@Nullable JSONObject antiSpamParams) {
        GdtInterstitialParams gdtInterstitialParams = this.mParams;
        if (gdtInterstitialParams != null) {
            gdtInterstitialParams.antiSpamParamsForDisplayOnReportServer = antiSpamParams;
        }
    }

    @Override // com.tencent.gdtad.api.interstitial.IGdtInterstitialAd
    public boolean show(@Nullable Activity activity) {
        int i3;
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) || !canShow()) {
            i3 = 1;
        } else {
            i3 = GdtInterstitialFragmentWithKuikly.INSTANCE.b(activity, getMParams());
            if (i3 == 0) {
                this.mDisplayed = true;
                i3 = 0;
            }
        }
        QLog.d("GdtInterstitialAdKuikly", 1, "show");
        GdtAnalysisHelperForInterstitial.reportFortShowInterstitialStart(activity, getMParams(), i3);
        if (i3 != 0) {
            return false;
        }
        return true;
    }
}
