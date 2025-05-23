package com.tencent.biz.qrcode.processor;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.jump.IWXQrcodePayApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "rspCode", "", "bundle", "Landroid/os/Bundle;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class WxPayQRProcessor$isOpenWxQrcodeSwitch$1 extends Lambda implements Function2<Integer, Bundle, Unit> {
    final /* synthetic */ int $channel;
    final /* synthetic */ String $result;
    final /* synthetic */ WxPayQRProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WxPayQRProcessor$isOpenWxQrcodeSwitch$1(WxPayQRProcessor wxPayQRProcessor, String str, int i3) {
        super(2);
        this.this$0 = wxPayQRProcessor;
        this.$result = str;
        this.$channel = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(WxPayQRProcessor this$0, String result, int i3, String token, DialogInterface dialogInterface, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "$result");
        IWXQrcodePayApi iWXQrcodePayApi = (IWXQrcodePayApi) QRoute.api(IWXQrcodePayApi.class);
        Intrinsics.checkNotNullExpressionValue(token, "token");
        iWXQrcodePayApi.launchQrcodePay(result, i3, token);
        this$0.f94980b.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(WxPayQRProcessor this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f94980b.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(WxPayQRProcessor this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f94980b.finish();
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Bundle bundle) {
        invoke(num.intValue(), bundle);
        return Unit.INSTANCE;
    }

    public final void invoke(int i3, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        QLog.i("WxPayQRProcessor", 1, "requestWxQrcodePayToken is success = " + i3);
        if (i3 == 1) {
            final String string = bundle.getString("token", "");
            WxPayQRProcessor wxPayQRProcessor = this.this$0;
            Context context = wxPayQRProcessor.f94980b.getContext();
            String string2 = this.this$0.f94980b.getContext().getResources().getString(R.string.f2188664v);
            String string3 = this.this$0.f94980b.getContext().getResources().getString(R.string.f2188764w);
            String string4 = this.this$0.f94980b.getContext().getResources().getString(R.string.f2188864x);
            final WxPayQRProcessor wxPayQRProcessor2 = this.this$0;
            final String str = this.$result;
            final int i16 = this.$channel;
            DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qrcode.processor.g
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i17) {
                    WxPayQRProcessor$isOpenWxQrcodeSwitch$1.d(WxPayQRProcessor.this, str, i16, string, dialogInterface, i17);
                }
            };
            final WxPayQRProcessor wxPayQRProcessor3 = this.this$0;
            wxPayQRProcessor.r(context, 230, null, string2, string3, string4, onClickListener, new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qrcode.processor.h
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i17) {
                    WxPayQRProcessor$isOpenWxQrcodeSwitch$1.e(WxPayQRProcessor.this, dialogInterface, i17);
                }
            });
            return;
        }
        String string5 = bundle.getString("extra_error_msg", "");
        if (!TextUtils.isEmpty(string5)) {
            WxPayQRProcessor wxPayQRProcessor4 = this.this$0;
            Context context2 = wxPayQRProcessor4.f94980b.getContext();
            String string6 = this.this$0.f94980b.getContext().getResources().getString(R.string.f170648xe);
            final WxPayQRProcessor wxPayQRProcessor5 = this.this$0;
            wxPayQRProcessor4.r(context2, 230, null, string5, null, string6, new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qrcode.processor.i
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i17) {
                    WxPayQRProcessor$isOpenWxQrcodeSwitch$1.f(WxPayQRProcessor.this, dialogInterface, i17);
                }
            }, null);
            return;
        }
        QQToast.makeText(MobileQQ.sMobileQQ, 0, R.string.f171155cp4, 0).show();
        this.this$0.f94980b.finish();
    }
}
