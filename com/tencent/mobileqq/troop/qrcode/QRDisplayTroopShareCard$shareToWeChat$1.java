package com.tencent.mobileqq.troop.qrcode;

import android.graphics.Bitmap;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "filePath", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class QRDisplayTroopShareCard$shareToWeChat$1 extends Lambda implements Function1<String, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Bitmap $snapshot;
    final /* synthetic */ boolean $toWeChatCircle;
    final /* synthetic */ QRDisplayTroopShareCard this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QRDisplayTroopShareCard$shareToWeChat$1(QRDisplayTroopShareCard qRDisplayTroopShareCard, Bitmap bitmap, boolean z16) {
        super(1);
        this.this$0 = qRDisplayTroopShareCard;
        this.$snapshot = bitmap;
        this.$toWeChatCircle = z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qRDisplayTroopShareCard, bitmap, Boolean.valueOf(z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 tmp0, BaseResp baseResp) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(baseResp);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull String filePath) {
        final Function1 function1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) filePath);
            return;
        }
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (filePath.length() == 0) {
            QLog.e("QRDisplayTroopShareCard", 1, "shareToWeChat failed, path empty");
            com.tencent.biz.qrcode.util.h.T(1, R.string.dzy);
        } else {
            WXShareHelper b06 = WXShareHelper.b0();
            function1 = this.this$0.wxShareListener;
            b06.A(new WXShareHelper.a() { // from class: com.tencent.mobileqq.troop.qrcode.ac
                @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
                public final void onWXShareResp(BaseResp baseResp) {
                    QRDisplayTroopShareCard$shareToWeChat$1.b(Function1.this, baseResp);
                }
            });
            WXShareHelper.b0().u0(filePath, this.$snapshot, this.$toWeChatCircle ? 1 : 0);
        }
    }
}
