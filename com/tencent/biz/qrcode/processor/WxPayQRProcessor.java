package com.tencent.biz.qrcode.processor;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.k;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.pb.IQWalletPbApi;
import com.tencent.mobileqq.utils.DialogUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sk2.WalletConstantsConfig;

@KeepClassConstructor
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002JV\u0010\u0018\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0002J.\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u001b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\u001c\u001a\u00020\u0002H\u0016\u00a8\u0006$"}, d2 = {"Lcom/tencent/biz/qrcode/processor/WxPayQRProcessor;", "Lcom/tencent/biz/qrcode/processor/BaseQRScanResultProcessor;", "", "result", "Lcom/tencent/mobileqq/qrscan/ScannerParams;", "scannerParams", "", "p", "", "o", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/content/Context;", "context", "", "type", "titleText", "", "contentText", "strlbtnText", "strrBtnText", "Landroid/content/DialogInterface$OnClickListener;", "onConfirm", "onCancel", "r", "qBarType", "a", "k", "getName", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/mobileqq/qrscan/k;", "onQRHandleResultCallback", "<init>", "(Lmqq/app/AppRuntime;Lcom/tencent/mobileqq/qrscan/k;)V", "c", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class WxPayQRProcessor extends BaseQRScanResultProcessor {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WxPayQRProcessor(@NotNull AppRuntime appRuntime, @NotNull k onQRHandleResultCallback) {
        super(appRuntime, onQRHandleResultCallback);
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(onQRHandleResultCallback, "onQRHandleResultCallback");
    }

    private final List<String> o() {
        return ((WalletConstantsConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_COMMON_CONSTANT, new WalletConstantsConfig(null, 1, null))).getContent().f();
    }

    private final void p(String result, ScannerParams scannerParams) {
        boolean z16;
        int i3;
        if (scannerParams.f276518i) {
            i3 = 3;
        } else {
            String str = scannerParams.f276517h;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                i3 = 1;
            } else {
                i3 = 2;
            }
        }
        ((IQWalletPbApi) QRoute.api(IQWalletPbApi.class)).requestWxQrcodePayToken(i3, new WxPayQRProcessor$isOpenWxQrcodeSwitch$1(this, result, i3));
    }

    private final boolean q() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(Context context, int type, String titleText, CharSequence contentText, String strlbtnText, String strrBtnText, DialogInterface.OnClickListener onConfirm, DialogInterface.OnClickListener onCancel) {
        if (context != null && (context instanceof Activity)) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                DialogUtil.createCustomDialog(context, type, titleText, contentText, strlbtnText, strrBtnText, onConfirm, onCancel).show();
            }
        }
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor, com.tencent.mobileqq.qrscan.f
    public boolean a(int type, @Nullable String result, @Nullable String qBarType, @Nullable ScannerParams scannerParams) {
        boolean startsWith$default;
        boolean z16;
        if (result == null) {
            return false;
        }
        String lowerCase = result.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        if (lowerCase == null) {
            return false;
        }
        List<String> o16 = o();
        if (!q() || !m(type)) {
            return false;
        }
        List<String> list = o16;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                String lowerCase2 = ((String) it.next()).toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(lowerCase, lowerCase2, false, 2, null);
                if (startsWith$default) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (!z16) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qrscan.f
    @NotNull
    public String getName() {
        return "WxPayQRProcessor";
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    protected boolean k(@Nullable String result, @Nullable String qBarType, @Nullable ScannerParams scannerParams) {
        if (result != null && scannerParams != null) {
            this.f94980b.a(true);
            p(result, scannerParams);
            return true;
        }
        return false;
    }
}
