package com.tencent.gdtad.api.banner;

import android.app.Activity;
import android.content.Context;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.api.banner.kuikly.GdtBannerAdViewWithKuikly;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0014J*\u0010\u0013\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0014R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/gdtad/api/banner/GdtBannerAdKuikly;", "Lcom/tencent/gdtad/api/GdtAd;", "Lcom/tencent/gdtad/api/banner/IGdtBannerAd;", "Landroid/content/Context;", "context", "", "width", "height", "Lcom/tencent/gdtad/api/banner/GdtBannerView;", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "", "onDisplay", "Lcom/tencent/gdtad/api/banner/GdtBannerParams;", "getParams", "Lcom/tencent/gdtad/aditem/GdtAd;", "ad", "errorCodeForSSO", "errorCodeForResponse", "errorCodeForAd", "getErrorCode", "mParams", "Lcom/tencent/gdtad/api/banner/GdtBannerParams;", "", "mRendered", "Z", "<init>", "(Lcom/tencent/gdtad/api/banner/GdtBannerParams;)V", "Companion", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GdtBannerAdKuikly extends GdtAd implements IGdtBannerAd {

    @Nullable
    private final GdtBannerParams mParams;
    private boolean mRendered;

    public GdtBannerAdKuikly(@Nullable GdtBannerParams gdtBannerParams) {
        super(gdtBannerParams);
        this.mParams = gdtBannerParams;
        super.init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.gdtad.api.GdtAd
    public int getErrorCode(@Nullable com.tencent.gdtad.aditem.GdtAd ad5, int errorCodeForSSO, int errorCodeForResponse, int errorCodeForAd) {
        qq_ad_get.QQAdGet qQAdGet;
        int errorCode = super.getErrorCode(ad5, errorCodeForSSO, errorCodeForResponse, errorCodeForAd);
        if (errorCode != 0) {
            return errorCode;
        }
        if (ad5 != null && isValid()) {
            GdtBannerParams mParams = getMParams();
            if (mParams != null) {
                qQAdGet = mParams.requestParams;
            } else {
                qQAdGet = null;
            }
            if (qQAdGet != null) {
                if (GdtBannerParams.isCreativeSizeValid(ad5)) {
                    return 0;
                }
                return 7;
            }
        }
        QLog.e("GdtBannerAdKuikly", 1, "getErrorCode error");
        return 1;
    }

    @Override // com.tencent.gdtad.api.banner.IGdtBannerAd
    public void onDisplay() {
        GdtBannerParams gdtBannerParams = this.mParams;
        if (gdtBannerParams != null && gdtBannerParams.showTime == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            gdtBannerParams.showTime = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.gdtad.api.banner.IGdtBannerAd
    @Nullable
    public GdtBannerView render(@NotNull Context context, int width, int height) {
        Intrinsics.checkNotNullParameter(context, "context");
        GdtBannerParams gdtBannerParams = this.mParams;
        Activity activity = null;
        if (gdtBannerParams != null && gdtBannerParams.isValid() && this.mParams.clickParams.isValid()) {
            if (width >= 0 && height >= 0 && isLoaded() && !this.mRendered) {
                GdtBannerParams gdtBannerParams2 = this.mParams;
                gdtBannerParams2.width = width;
                gdtBannerParams2.height = height;
                this.mRendered = true;
                WeakReference<Activity> weakReference = gdtBannerParams2.clickParams.activity;
                if (weakReference != null) {
                    activity = weakReference.get();
                }
                AdAnalysisHelperForUtil.reportForBanner(activity, this.mParams.clickParams.f108486ad);
                return new GdtBannerAdViewWithKuikly(context, this.mParams);
            }
            QLog.e("GdtBannerAdKuikly", 1, "render error");
            return null;
        }
        QLog.e("GdtBannerAdKuikly", 1, "render error: params is invalid");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.gdtad.api.GdtAd
    @Nullable
    /* renamed from: getParams, reason: from getter */
    public GdtBannerParams getMParams() {
        return this.mParams;
    }
}
