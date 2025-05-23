package bl2;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.qwallet.hb.send.impl.SendHbActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tenpay.payment.qrcodehb.QrCodeHbFragment;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private SendHbActivity f28624a;

    public g(SendHbActivity sendHbActivity) {
        this.f28624a = sendHbActivity;
    }

    public void a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            jSONObject.put("userId", str2);
            jSONObject.put(HippyHeaderListViewController.VIEW_TAG, "qrcodeHb");
            jSONObject.put(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, 1);
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject2.putOpt(QrCodeHbFragment.KEY_IN_QR_TOKEN, str);
            }
            jSONObject2.putOpt("comeFrom", 1);
            jSONObject.put("extra_data", jSONObject2.toString());
            Bundle bundle = new Bundle();
            bundle.putString(ark.ARKMETADATA_JSON, jSONObject.toString());
            bundle.putString("callbackSn", "0");
            PayBridgeActivity.tenpay(this.f28624a, 5, bundle);
        } catch (JSONException e16) {
            QLog.e("SendHbLogic", 1, "error msg in qqpay-impl module: ", e16);
        }
    }

    public void b(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject(map);
        Map<String, String> mapPacketJson = this.f28624a.getMapPacketJson();
        mapPacketJson.put("extra_data", jSONObject.toString());
        Bundle bundle = new Bundle();
        bundle.putString(ark.ARKMETADATA_JSON, new JSONObject(mapPacketJson).toString());
        bundle.putString("callbackSn", "0");
        PayBridgeActivity.tenpay(this.f28624a, 5, bundle);
    }

    public void c() {
        Map<String, String> mapPacketExtra = this.f28624a.getMapPacketExtra();
        mapPacketExtra.put(WadlProxyConsts.CHANNEL, this.f28624a.nChannel + "");
        mapPacketExtra.put("bus_type", "1");
        mapPacketExtra.put("type", "1");
        b(mapPacketExtra);
    }
}
