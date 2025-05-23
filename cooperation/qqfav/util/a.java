package cooperation.qqfav.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardArkMsgOption;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqcollect.arkshare.oidb0x11bf.oidb0x11bf$ArkShareReq;
import com.tencent.trpcprotocol.qqcollect.arkshare.oidb0x11bf.oidb0x11bf$ArkShareRsp;
import com.tencent.util.QQCustomArkDialogUtil;
import com.tencent.util.QQToastUtil;
import cooperation.qqfav.QfavUtil;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* compiled from: P */
    /* renamed from: cooperation.qqfav.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    class C10115a extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f390662d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Bundle f390663e;

        C10115a(Activity activity, Bundle bundle) {
            this.f390662d = activity;
            this.f390663e = bundle;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            if (i3 == 0 && bArr != null) {
                oidb0x11bf$ArkShareRsp oidb0x11bf_arksharersp = new oidb0x11bf$ArkShareRsp();
                try {
                    oidb0x11bf_arksharersp.mergeFrom(bArr);
                    int i16 = oidb0x11bf_arksharersp.ret.get();
                    String str = oidb0x11bf_arksharersp.f381595msg.get();
                    if (i16 != 0) {
                        QLog.e("FavArkShareUtils", 1, "getArkMessageFromNet fail, recode: " + i16 + " msg: " + str);
                        return;
                    }
                    String str2 = new String(oidb0x11bf_arksharersp.ark.get().toByteArray());
                    Activity activity = this.f390662d;
                    ForwardBaseOption.startForwardActivityForResult(activity, a.b(activity, str2, this.f390663e), (Class<?>) ForwardRecentTranslucentActivity.class, 21, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, "biz_src_jc_shoucang");
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("FavArkShareUtils", 1, "getArkMessageFromNet fail", e16);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("FavArkShareUtils", 2, "getArkMessageFromNet, server error:" + i3);
            }
            QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.b1u));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f390664d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f390665e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f390666f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f390667h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f390668i;

        b(Activity activity, QQAppInterface qQAppInterface, String str, int i3, String str2) {
            this.f390664d = activity;
            this.f390665e = qQAppInterface;
            this.f390666f = str;
            this.f390667h = i3;
            this.f390668i = str2;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            if (i3 == 0 && bArr != null) {
                oidb0x11bf$ArkShareRsp oidb0x11bf_arksharersp = new oidb0x11bf$ArkShareRsp();
                try {
                    oidb0x11bf_arksharersp.mergeFrom(bArr);
                    int i16 = oidb0x11bf_arksharersp.ret.get();
                    String str = oidb0x11bf_arksharersp.f381595msg.get();
                    if (i16 != 0) {
                        QLog.e("FavArkShareUtils", 1, "getArkMessageFromNet fail, recode: " + i16 + " msg: " + str);
                        return;
                    }
                    ForwardArkMsgOption.n(a.b(this.f390664d, new String(oidb0x11bf_arksharersp.ark.get().toByteArray()), null).getExtras(), this.f390665e, this.f390666f, this.f390667h, this.f390668i, 0);
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("FavArkShareUtils", 1, "getArkMessageFromNet fail", e16);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("FavArkShareUtils", 2, "getArkMessageFromNet, server error:" + i3);
            }
            QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.b1u));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Intent b(Activity activity, String str, Bundle bundle) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Intent intent;
        JSONObject jSONObject;
        String str8 = "";
        try {
            jSONObject = new JSONObject(str);
            str2 = jSONObject.getString("app");
        } catch (JSONException e16) {
            e = e16;
            str2 = "";
            str3 = str2;
        }
        try {
            str3 = jSONObject.getString("view");
        } catch (JSONException e17) {
            e = e17;
            str3 = "";
            str4 = str3;
            str5 = str4;
            str6 = str5;
            str7 = str6;
            e.printStackTrace();
            intent = new Intent(activity, (Class<?>) ForwardRecentActivity.class);
            intent.putExtra("forward_type", 53);
            intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 1);
            intent.putExtra("is_ark_display_share", true);
            intent.putExtra("forward_ark_app_name", str2);
            intent.putExtra("forward_ark_app_view", str3);
            intent.putExtra("forward_ark_biz_src", str4);
            intent.putExtra("forward_ark_app_ver", str5);
            intent.putExtra("forward_ark_app_prompt", str6);
            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, str8);
            intent.putExtra("k_dataline", false);
            intent.putExtra("forward_ark_app_meta", str7);
            intent.putExtras(QQCustomArkDialogUtil.zipArgs(str2, str3, str5, str7, MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics().density, null, null));
            if (bundle != null) {
            }
            return intent;
        }
        try {
            str4 = jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC);
        } catch (JSONException e18) {
            e = e18;
            str4 = "";
            str5 = str4;
            str6 = str5;
            str7 = str6;
            e.printStackTrace();
            intent = new Intent(activity, (Class<?>) ForwardRecentActivity.class);
            intent.putExtra("forward_type", 53);
            intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 1);
            intent.putExtra("is_ark_display_share", true);
            intent.putExtra("forward_ark_app_name", str2);
            intent.putExtra("forward_ark_app_view", str3);
            intent.putExtra("forward_ark_biz_src", str4);
            intent.putExtra("forward_ark_app_ver", str5);
            intent.putExtra("forward_ark_app_prompt", str6);
            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, str8);
            intent.putExtra("k_dataline", false);
            intent.putExtra("forward_ark_app_meta", str7);
            intent.putExtras(QQCustomArkDialogUtil.zipArgs(str2, str3, str5, str7, MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics().density, null, null));
            if (bundle != null) {
            }
            return intent;
        }
        try {
            str5 = jSONObject.getString("ver");
            try {
                str6 = jSONObject.optString("prompt");
                try {
                    str7 = jSONObject.optString(PublicAccountMessageUtilImpl.META_NAME);
                } catch (JSONException e19) {
                    e = e19;
                    str7 = "";
                }
            } catch (JSONException e26) {
                e = e26;
                str6 = "";
                str7 = str6;
                e.printStackTrace();
                intent = new Intent(activity, (Class<?>) ForwardRecentActivity.class);
                intent.putExtra("forward_type", 53);
                intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 1);
                intent.putExtra("is_ark_display_share", true);
                intent.putExtra("forward_ark_app_name", str2);
                intent.putExtra("forward_ark_app_view", str3);
                intent.putExtra("forward_ark_biz_src", str4);
                intent.putExtra("forward_ark_app_ver", str5);
                intent.putExtra("forward_ark_app_prompt", str6);
                intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, str8);
                intent.putExtra("k_dataline", false);
                intent.putExtra("forward_ark_app_meta", str7);
                intent.putExtras(QQCustomArkDialogUtil.zipArgs(str2, str3, str5, str7, MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics().density, null, null));
                if (bundle != null) {
                }
                return intent;
            }
            try {
                str8 = jSONObject.optString(DownloadInfo.spKey_Config);
            } catch (JSONException e27) {
                e = e27;
                e.printStackTrace();
                intent = new Intent(activity, (Class<?>) ForwardRecentActivity.class);
                intent.putExtra("forward_type", 53);
                intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 1);
                intent.putExtra("is_ark_display_share", true);
                intent.putExtra("forward_ark_app_name", str2);
                intent.putExtra("forward_ark_app_view", str3);
                intent.putExtra("forward_ark_biz_src", str4);
                intent.putExtra("forward_ark_app_ver", str5);
                intent.putExtra("forward_ark_app_prompt", str6);
                intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, str8);
                intent.putExtra("k_dataline", false);
                intent.putExtra("forward_ark_app_meta", str7);
                intent.putExtras(QQCustomArkDialogUtil.zipArgs(str2, str3, str5, str7, MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics().density, null, null));
                if (bundle != null) {
                }
                return intent;
            }
        } catch (JSONException e28) {
            e = e28;
            str5 = "";
            str6 = str5;
            str7 = str6;
            e.printStackTrace();
            intent = new Intent(activity, (Class<?>) ForwardRecentActivity.class);
            intent.putExtra("forward_type", 53);
            intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 1);
            intent.putExtra("is_ark_display_share", true);
            intent.putExtra("forward_ark_app_name", str2);
            intent.putExtra("forward_ark_app_view", str3);
            intent.putExtra("forward_ark_biz_src", str4);
            intent.putExtra("forward_ark_app_ver", str5);
            intent.putExtra("forward_ark_app_prompt", str6);
            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, str8);
            intent.putExtra("k_dataline", false);
            intent.putExtra("forward_ark_app_meta", str7);
            intent.putExtras(QQCustomArkDialogUtil.zipArgs(str2, str3, str5, str7, MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics().density, null, null));
            if (bundle != null) {
            }
            return intent;
        }
        intent = new Intent(activity, (Class<?>) ForwardRecentActivity.class);
        try {
            intent.putExtra("forward_type", 53);
            intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 1);
            intent.putExtra("is_ark_display_share", true);
            intent.putExtra("forward_ark_app_name", str2);
            intent.putExtra("forward_ark_app_view", str3);
            intent.putExtra("forward_ark_biz_src", str4);
            intent.putExtra("forward_ark_app_ver", str5);
            intent.putExtra("forward_ark_app_prompt", str6);
            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, str8);
            intent.putExtra("k_dataline", false);
            intent.putExtra("forward_ark_app_meta", str7);
            intent.putExtras(QQCustomArkDialogUtil.zipArgs(str2, str3, str5, str7, MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics().density, null, null));
        } catch (Exception e29) {
            QLog.e("FavArkShareUtils", 1, "getShareArkIntent exception", e29);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        return intent;
    }

    public static boolean c() {
        return true;
    }

    public static void d(QQAppInterface qQAppInterface, Activity activity, String str, String str2, int i3, String str3) {
        if (TextUtils.isEmpty(str)) {
            QfavUtil.Q(activity, R.string.b4a, 0);
            return;
        }
        oidb0x11bf$ArkShareReq oidb0x11bf_arksharereq = new oidb0x11bf$ArkShareReq();
        oidb0x11bf_arksharereq.cid.set(str);
        ProtoUtils.a(qQAppInterface, new b(activity, qQAppInterface, str2, i3, str3), oidb0x11bf_arksharereq.toByteArray(), "OidbSvcTrpcTcp.0x11bf_1", 4543, 1);
    }

    public static void e(AppRuntime appRuntime, Activity activity, String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str) && appRuntime != null && activity != null) {
            oidb0x11bf$ArkShareReq oidb0x11bf_arksharereq = new oidb0x11bf$ArkShareReq();
            oidb0x11bf_arksharereq.cid.set(str);
            ProtoUtils.a(appRuntime, new C10115a(activity, bundle), oidb0x11bf_arksharereq.toByteArray(), "OidbSvcTrpcTcp.0x11bf_1", 4543, 1);
            return;
        }
        QfavUtil.Q(activity, R.string.b4a, 0);
    }
}
