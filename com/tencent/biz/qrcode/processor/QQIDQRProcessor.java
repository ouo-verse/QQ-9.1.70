package com.tencent.biz.qrcode.processor;

import android.content.Intent;
import android.net.Uri;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.k;
import com.tencent.mobileqq.timiqqid.api.ITimiQQIDApi;
import com.tencent.mobileqq.timiqqid.constants.QQIDConstants;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@KeepClassConstructor
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u0012\u0006\u0010\u001e\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\"\u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u0011\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\"\u0010\u0012\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/biz/qrcode/processor/QQIDQRProcessor;", "Lcom/tencent/mobileqq/qrscan/f;", "", "getName", "", "type", "result", "qBarType", "Lcom/tencent/mobileqq/qrscan/ScannerParams;", "scannerParams", "", "a", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "c", "d", "b", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lmqq/app/AppRuntime;", "Lmqq/app/AppRuntime;", "getAppRuntime", "()Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/mobileqq/qrscan/k;", "Lcom/tencent/mobileqq/qrscan/k;", "getOnQRHandleResultCallback", "()Lcom/tencent/mobileqq/qrscan/k;", "onQRHandleResultCallback", "<init>", "(Lmqq/app/AppRuntime;Lcom/tencent/mobileqq/qrscan/k;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QQIDQRProcessor implements com.tencent.mobileqq.qrscan.f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppRuntime appRuntime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final k onQRHandleResultCallback;

    public QQIDQRProcessor(@NotNull AppRuntime appRuntime, @NotNull k onQRHandleResultCallback) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(onQRHandleResultCallback, "onQRHandleResultCallback");
        this.appRuntime = appRuntime;
        this.onQRHandleResultCallback = onQRHandleResultCallback;
    }

    @Override // com.tencent.mobileqq.qrscan.f
    public boolean a(int type, @Nullable String result, @Nullable String qBarType, @Nullable ScannerParams scannerParams) {
        Uri uri;
        String queryParameter;
        if (result != null && (uri = Uri.parse(result)) != null) {
            Intrinsics.checkNotNullExpressionValue(uri, "uri");
            if (uri.isHierarchical() && (queryParameter = uri.getQueryParameter(QQIDConstants.QQID_QR_URL_KEY)) != null && Intrinsics.areEqual(QQIDConstants.QQID_QR_URL_VALUE, queryParameter)) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qrscan.f
    public boolean b(int requestCode, int resultCode, @Nullable Intent data) {
        return false;
    }

    @Override // com.tencent.mobileqq.qrscan.f
    public boolean c(int requestCode, int resultCode, @Nullable Intent data) {
        return false;
    }

    @Override // com.tencent.mobileqq.qrscan.f
    public boolean d(@Nullable String result, @Nullable String qBarType, @Nullable ScannerParams scannerParams) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
        int i3 = 0;
        if (Foreground.getTopActivity() == null) {
            return false;
        }
        try {
            Uri parse = Uri.parse(result);
            parse.getQueryParameter(QQIDConstants.QQID_QR_URL_KEY);
            String queryParameter = parse.getQueryParameter("appId");
            String queryParameter2 = parse.getQueryParameter("entryPath");
            String queryParameter3 = parse.getQueryParameter(WadlProxyConsts.EXTRA_DATA);
            String queryParameter4 = parse.getQueryParameter("envVersion");
            String queryParameter5 = parse.getQueryParameter("reportData");
            String queryParameter6 = parse.getQueryParameter("scene");
            IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (queryParameter6 != null) {
                i3 = Integer.parseInt(queryParameter6);
            }
            iMiniAppService.launchMiniAppById(mobileQQ, queryParameter, queryParameter2, queryParameter3, queryParameter4, queryParameter5, i3, null);
            ((ITimiQQIDApi) QRoute.api(ITimiQQIDApi.class)).setQQIDAlphaUser("", null);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        this.onQRHandleResultCallback.finish();
        return true;
    }

    @Override // com.tencent.mobileqq.qrscan.f
    @NotNull
    public String getName() {
        return "QQIDQRProcessor";
    }

    @Override // com.tencent.mobileqq.qrscan.f
    public void onDestroy() {
    }
}
