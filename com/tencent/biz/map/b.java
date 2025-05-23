package com.tencent.biz.map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.map.trpcprotocol.LbsSendInfo$SendMessageReq;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.util.QQCustomArkDialogUtil;
import com.tencent.util.QQToastUtil;
import cooperation.qqfav.QfavUtil;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    public static String f78680d = "com.tencent.map";

    /* renamed from: e, reason: collision with root package name */
    public static String f78681e = "LocationShare";

    /* renamed from: f, reason: collision with root package name */
    public static String f78682f = "0.0.0.1";

    /* renamed from: a, reason: collision with root package name */
    private String f78683a;

    /* renamed from: b, reason: collision with root package name */
    private String f78684b;

    /* renamed from: c, reason: collision with root package name */
    private LatLng f78685c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ InterfaceC0795b f78686d;

        a(InterfaceC0795b interfaceC0795b) {
            this.f78686d = interfaceC0795b;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            if (i3 == 0 && bArr != null) {
                InterfaceC0795b interfaceC0795b = this.f78686d;
                if (interfaceC0795b != null) {
                    interfaceC0795b.a();
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MapDetailShareUtils", 2, "getArkMessageFromNet, server error:" + i3);
            }
            QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.b1u));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.biz.map.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0795b {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, String str2, LatLng latLng) {
        this.f78683a = str;
        this.f78684b = str2;
        this.f78685c = latLng;
    }

    private static String a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("forward", 1);
        jSONObject.put("autosize", 1);
        jSONObject.put("type", IndividuationUrlHelper.UrlId.CARD_HOME);
        return jSONObject.toString();
    }

    private static String c(String str, String str2, String str3, String str4, String str5) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("id", str);
        jSONObject2.put("name", str2);
        jSONObject2.put("address", str3);
        jSONObject2.put(QCircleSchemeAttr.Polymerize.LAT, str4);
        jSONObject2.put("lng", str5);
        jSONObject2.put("from", "plusPanel");
        jSONObject.put("Location.Search", jSONObject2);
        return jSONObject.toString();
    }

    public static void d(AppRuntime appRuntime, String str, String str2, String str3, String str4, String str5, int i3, InterfaceC0795b interfaceC0795b) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            LbsSendInfo$SendMessageReq lbsSendInfo$SendMessageReq = new LbsSendInfo$SendMessageReq();
            lbsSendInfo$SendMessageReq.str_name.set(str);
            lbsSendInfo$SendMessageReq.str_address.set(str2);
            lbsSendInfo$SendMessageReq.str_lat.set(str3);
            lbsSendInfo$SendMessageReq.str_lng.set(str4);
            lbsSendInfo$SendMessageReq.uint64_peer_account.set(Long.parseLong(str5));
            if (i3 == 0) {
                lbsSendInfo$SendMessageReq.enum_relation_type.set(0);
            } else if (i3 == 1) {
                lbsSendInfo$SendMessageReq.enum_relation_type.set(1);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("MapDetailShareUtils", 2, "UIN_TYPE_ERROR");
                    return;
                }
                return;
            }
            if (appRuntime == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("MapDetailShareUtils", 2, "app is null");
                    return;
                }
                return;
            }
            ProtoUtils.d(appRuntime, new a(interfaceC0795b), lbsSendInfo$SendMessageReq.toByteArray(), "trpc.qq_lbs.qq_lbs_ark.LocationArk.SsoSendMessage");
            return;
        }
        QfavUtil.Q(BaseApplication.getContext(), R.string.b4a, 0);
    }

    public Intent b(Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) ForwardRecentActivity.class);
        try {
            intent.putExtra("forward_type", 55);
            intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 1);
            intent.putExtra(ForwardRecentActivity.KEY_FORWARD_SHARE_MATCH_FRIEND_LIST, false);
            intent.putExtra("key_forward_finish_when_multi_select", true);
            intent.putExtra("is_ark_display_share", true);
            intent.putExtra("forward_ark_app_name", f78680d);
            intent.putExtra("forward_ark_app_view", f78681e);
            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_DESC, HardCodeUtil.qqStr(R.string.f171708kc1));
            intent.putExtra("forward_ark_app_ver", 1);
            intent.putExtra("forward_ark_app_ver", f78682f);
            intent.putExtra("forward_ark_app_prompt", activity.getString(R.string.f1630021y) + this.f78683a);
            String c16 = c("", this.f78683a, this.f78684b, String.valueOf(this.f78685c.latitude), String.valueOf(this.f78685c.longitude));
            intent.putExtra("forward_ark_app_meta", c16);
            Bundle zipArgs = QQCustomArkDialogUtil.zipArgs(f78680d, f78681e, f78682f, c16, MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics().density, null, null);
            zipArgs.putString(AppConstants.Key.FORWARD_ARK_APP_CONFIG, a());
            intent.putExtras(zipArgs);
        } catch (Exception e16) {
            QLog.e("MapDetailShareUtils", 1, "getPartyRoomShareIntent exception message: " + e16.getMessage());
        }
        return intent;
    }
}
