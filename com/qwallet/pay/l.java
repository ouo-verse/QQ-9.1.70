package com.qwallet.pay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tenpay.api.TenpayInterface;

/* compiled from: P */
/* loaded from: classes3.dex */
public class l extends a {

    /* renamed from: k, reason: collision with root package name */
    private static boolean f41658k = false;

    public l(Context context, Intent intent) {
        super(context, intent);
    }

    public static boolean o() {
        return f41658k;
    }

    public static void p() {
        f41658k = true;
    }

    @Override // com.qwallet.pay.a, com.qwallet.pay.b
    public boolean b() {
        return true;
    }

    @Override // com.qwallet.pay.a
    public void g(Context context) {
        super.g(context);
        String string = this.f41632d.getString("tag");
        String string2 = this.f41632d.getString("uin");
        String string3 = this.f41632d.getString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
        Bundle bundle = this.f41632d.getBundle("params");
        if (this.f41632d.getBoolean(PayProxy.Source.PAY_IS_LOCK_WITHDRAW, false)) {
            string3 = "";
        }
        if (string.compareTo("graphb") == 0) {
            p();
            Bundle bundle2 = this.f41632d.getBundle("extra_ext_data");
            if (bundle2 != null && bundle2.getInt("extra_ext_data_type", 0) == 1 && bundle2.getBoolean("extra_ext_f2fredpack_is_anim", true)) {
                Intent intent = new Intent();
                intent.setAction("qwallet.facetoface");
                this.f41629a.sendBroadcast(intent);
            }
            t.a().c(-1, null, false);
        } else if (string.compareTo("payCode") == 0) {
            t.a().c(-1, null, false);
        } else if (string.compareTo("qrcodeHb") == 0) {
            this.f41634f = true;
        }
        TenpayInterface.gotoView(this.f41629a, string, string2, string3, bundle, new OpenTenpayResultReceiver(new Handler(), this, string));
    }

    @Override // com.qwallet.pay.a
    protected boolean j() {
        return false;
    }
}
