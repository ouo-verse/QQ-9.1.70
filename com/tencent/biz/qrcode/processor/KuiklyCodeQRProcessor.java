package com.tencent.biz.qrcode.processor;

import android.content.DialogInterface;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qrcode.processor.KuiklyCodeQRProcessor;
import com.tencent.biz.subscribe.comment.ActionSheetDialog;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyForTest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.k;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rdelivery.reshub.api.h;
import com.tencent.rdelivery.reshub.api.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u000bB\u0019\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\f\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/biz/qrcode/processor/KuiklyCodeQRProcessor;", "Lcom/tencent/biz/qrcode/processor/BaseQRScanResultProcessor;", "", "getName", "", "type", "result", "qBarType", "Lcom/tencent/mobileqq/qrscan/ScannerParams;", "scannerParams", "", "a", "k", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/mobileqq/qrscan/k;", "callback", "<init>", "(Lmqq/app/AppRuntime;Lcom/tencent/mobileqq/qrscan/k;)V", "c", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class KuiklyCodeQRProcessor extends BaseQRScanResultProcessor {

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/biz/qrcode/processor/KuiklyCodeQRProcessor$b", "Lcom/tencent/rdelivery/reshub/api/h;", "", "isSuccess", "Lcom/tencent/rdelivery/reshub/api/g;", "result", "Lcom/tencent/rdelivery/reshub/api/n;", "error", "", "onComplete", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b implements com.tencent.rdelivery.reshub.api.h {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f94986b;

        b(String str) {
            this.f94986b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(final KuiklyCodeQRProcessor this$0, String str, final com.tencent.rdelivery.reshub.api.g gVar) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QQToast.makeText(this$0.f94980b.getContext(), 0, "\u8d44\u6e90\u4e0b\u8f7d\u6210\u529f", 1).show();
            ActionSheetDialog actionSheetDialog = new ActionSheetDialog(Foreground.getTopActivity());
            actionSheetDialog.setTitle("Kuikly\u6d4b\u8bd5");
            actionSheetDialog.W(1, "\u4f7f\u7528 " + str + " version:" + (gVar != null ? Long.valueOf(gVar.getVersion()) : null), 1, new View.OnClickListener() { // from class: com.tencent.biz.qrcode.processor.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    KuiklyCodeQRProcessor.b.g(com.tencent.rdelivery.reshub.api.g.this, this$0, view);
                }
            });
            actionSheetDialog.W(2, "\u6e05\u9664\u7f13\u5b58", 2, new View.OnClickListener() { // from class: com.tencent.biz.qrcode.processor.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    KuiklyCodeQRProcessor.b.h(KuiklyCodeQRProcessor.this, view);
                }
            });
            actionSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.biz.qrcode.processor.d
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    KuiklyCodeQRProcessor.b.i(KuiklyCodeQRProcessor.this, dialogInterface);
                }
            });
            actionSheetDialog.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(com.tencent.rdelivery.reshub.api.g gVar, KuiklyCodeQRProcessor this$0, View view) {
            String str;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            IQQKuiklyForTest iQQKuiklyForTest = (IQQKuiklyForTest) QRoute.api(IQQKuiklyForTest.class);
            if (gVar == null || (str = gVar.getResId()) == null) {
                str = "";
            }
            iQQKuiklyForTest.cacheQRResult(str, gVar != null ? gVar.getVersion() : 0L);
            QQToast.makeText(this$0.f94980b.getContext(), 0, "\u52a0\u8f7d\u8d44\u6e90\u5df2\u66ff\u6362", 1).show();
            this$0.f94980b.finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(KuiklyCodeQRProcessor this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ((IQQKuiklyForTest) QRoute.api(IQQKuiklyForTest.class)).clear();
            this$0.f94980b.finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(KuiklyCodeQRProcessor this$0, DialogInterface dialogInterface) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.f94980b.finish();
        }

        @Override // com.tencent.rdelivery.reshub.api.h
        public void onComplete(boolean isSuccess, final com.tencent.rdelivery.reshub.api.g result, n error) {
            Intrinsics.checkNotNullParameter(error, "error");
            QLog.i("KuiklyCodeQRProcessor", 1, "code:" + error.b() + " msg: " + error.message() + " exception: " + error.a());
            if (result != null) {
                QLog.i("KuiklyCodeQRProcessor", 1, "res: " + result.getVersion());
            }
            if (isSuccess) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final KuiklyCodeQRProcessor kuiklyCodeQRProcessor = KuiklyCodeQRProcessor.this;
                final String str = this.f94986b;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.biz.qrcode.processor.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        KuiklyCodeQRProcessor.b.f(KuiklyCodeQRProcessor.this, str, result);
                    }
                });
                return;
            }
            QQToast.makeText(KuiklyCodeQRProcessor.this.f94980b.getContext(), 0, "\u8d44\u6e90\u4e0b\u8f7d\u5931\u8d25", 1).show();
        }

        @Override // com.tencent.rdelivery.reshub.api.h
        public void onProgress(float f16) {
            h.a.a(this, f16);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KuiklyCodeQRProcessor(AppRuntime appRuntime, k callback) {
        super(appRuntime, callback);
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor, com.tencent.mobileqq.qrscan.f
    public boolean a(int type, String result, String qBarType, ScannerParams scannerParams) {
        return false;
    }

    @Override // com.tencent.mobileqq.qrscan.f
    public String getName() {
        return "KuiklyCodeQRProcessor";
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    protected boolean k(String result, String qBarType, ScannerParams scannerParams) {
        try {
            JSONObject jSONObject = new JSONObject(result);
            String optString = jSONObject.optString("data_type");
            String resId = jSONObject.optString(IPreloadServiceProxy.KEY_RESID);
            String resTask = jSONObject.optString("res_task");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(resId) && !TextUtils.isEmpty(resTask)) {
                com.tencent.rdelivery.reshub.api.i resHubInstance = ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).getResHubInstance();
                Intrinsics.checkNotNullExpressionValue(resId, "resId");
                Intrinsics.checkNotNullExpressionValue(resTask, "resTask");
                resHubInstance.a(resId, Long.parseLong(resTask), new b(resId));
                return true;
            }
        } catch (NumberFormatException | JSONException unused) {
        }
        return false;
    }
}
