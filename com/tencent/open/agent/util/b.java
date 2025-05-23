package com.tencent.open.agent.util;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.config.business.OpenSdkIFrameProcessor;
import com.tencent.mobileqq.login.aa;
import com.tencent.mobileqq.login.aj;
import com.tencent.mobileqq.login.c;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.open.model.VirtualInfo;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.protofile.getappinfo.GetAppInfoProto$MsgIconsurl;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import tencent.im.login.GatewayVerify$RspBody;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    public static com.tencent.open.model.a a(WtloginManager wtloginManager, String str, byte[] bArr, int i3, Bundle bundle) {
        String b16 = OpenSdkVirtualUtil.b(str);
        com.tencent.open.model.a aVar = new com.tencent.open.model.a();
        aVar.f341678a = b16;
        aVar.f341679b = bundle.getByteArray("st_temp");
        aVar.f341680c = bundle.getByteArray("st_temp_key");
        return aVar;
    }

    public static boolean b(Bundle bundle) {
        QLog.d("AuthModelUtil", 1, "checkIMBlockByBundle");
        if (k(bundle)) {
            return false;
        }
        WUserSigInfo wUserSigInfo = (WUserSigInfo) bundle.getParcelable("userSigInfo");
        if (l(wUserSigInfo)) {
            return false;
        }
        try {
            byte[] bArr = wUserSigInfo.loginResultTLVMap.get(1347).get_data();
            GatewayVerify$RspBody gatewayVerify$RspBody = new GatewayVerify$RspBody();
            gatewayVerify$RspBody.mergeFrom(bArr);
            if (gatewayVerify$RspBody.msg_rsp_lft_info.uint32_lft_forbid_area.get() == 1) {
                QLog.d("AuthModelUtil", 1, "checkIMBlockByBundle FORBID_AREA_IM");
                return true;
            }
            QLog.d("AuthModelUtil", 1, "checkIMBlockByBundle FORBID_AREA_ALL");
            return false;
        } catch (Exception e16) {
            QLog.e("AuthModelUtil", 1, "GatewayVerify.RspBody error: ", e16);
            return false;
        }
    }

    private static boolean c(String str, String str2, String str3, aa aaVar) {
        if (aaVar == null) {
            QLog.d("AuthModelUtil", 1, "checkParamsValid null == observer");
            return false;
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str)) {
            if ("com.tencent.mobileqq:openSdk".equals(MobileQQ.sMobileQQ.getQQProcessName())) {
                return true;
            }
            QLog.d("AuthModelUtil", 1, "checkParamsValid process = ", MobileQQ.sMobileQQ.getQQProcessName());
            aj ajVar = new aj();
            ajVar.f241864a = -1012;
            aaVar.b(ajVar);
            return false;
        }
        QLog.d("AuthModelUtil", 1, "checkParamsValid invalid params");
        aj ajVar2 = new aj();
        ajVar2.f241864a = -1012;
        aaVar.b(ajVar2);
        return false;
    }

    public static void d(Bundle bundle) {
        if (bundle == null) {
            t.e("AuthModelUtil", "createSign null == params");
            return;
        }
        String str = (System.currentTimeMillis() / 1000) + "";
        String string = bundle.getString("package_name");
        String string2 = bundle.getString("sign");
        try {
            String str2 = string + "_" + string2.replace(":", "").toLowerCase() + "_" + str;
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(str2.getBytes());
            string2 = HexUtil.bytes2HexStr(messageDigest.digest());
        } catch (Exception e16) {
            t.d("AuthModelUtil", "Exception", e16);
        }
        bundle.putString("sign", string2);
        bundle.putString("time", str);
    }

    public static void e(String str, String str2, String str3, aa aaVar) {
        QLog.d("AuthModelUtil", 1, "doWtLoginOnOpenSdk appId=", str, ", uin=", g.C(str2), ", callback=", aaVar);
        if (!c(str, str2, str3, aaVar)) {
            return;
        }
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            QLog.d("AuthModelUtil", 1, "doWtLoginOnOpenSdk app = ", peekAppRuntime);
            if (peekAppRuntime == null) {
                aj ajVar = new aj();
                ajVar.f241864a = -1012;
                aaVar.b(ajVar);
            } else {
                Bundle bundle = new Bundle();
                if (OpenSdkIFrameProcessor.a()) {
                    bundle.putInt(AppConstants.Key.KEY_PUZZLE_VERIFY_CODE, 130);
                }
                bundle.putByteArray(AppConstants.Key.KEY_CONNECT_DATA, g.u(str));
                ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).accountLogin(null, new c.a(3, 4, str2, str3).D(64).x(bundle).r(), aaVar);
            }
        } catch (Exception e16) {
            QLog.e("AuthModelUtil", 1, "Exception ", e16);
            aj ajVar2 = new aj();
            ajVar2.f241864a = -1012;
            aaVar.b(ajVar2);
        }
    }

    @Nullable
    public static String[] f(@NonNull String str, @NonNull String str2) {
        try {
            String str3 = (System.currentTimeMillis() / 1000) + "";
            String str4 = str + "_" + str2.replace(":", "").toLowerCase() + "_" + str3;
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(str4.getBytes());
            return new String[]{HexUtil.bytes2HexStr(messageDigest.digest()), str3};
        } catch (Exception e16) {
            t.d("AuthModelUtil", "getAppSignAndTime Exception", e16);
            return null;
        }
    }

    public static String g(Bundle bundle) {
        String str;
        Set<String> keySet = bundle.keySet();
        keySet.remove("sdkp");
        keySet.remove("sdkv");
        keySet.remove("sign");
        keySet.remove("time");
        StringBuilder sb5 = new StringBuilder();
        for (String str2 : keySet) {
            Object obj = bundle.get(str2);
            if (obj != null) {
                str = obj.toString();
            } else {
                str = "";
            }
            sb5.append(str2);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(URLEncoder.encode(str));
            sb5.append(ContainerUtils.FIELD_DELIMITER);
        }
        if (sb5.length() > 0) {
            sb5.delete(sb5.length() - 1, sb5.length());
        }
        return sb5.toString();
    }

    public static List<hp3.h> h(com.tencent.open.model.e eVar, boolean z16) {
        boolean z17;
        ArrayList arrayList = new ArrayList();
        ArrayList<VirtualInfo> arrayList2 = eVar.f341695c;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            Iterator<VirtualInfo> it = eVar.f341695c.iterator();
            while (it.hasNext()) {
                VirtualInfo next = it.next();
                if (next.f341677f == null || next.f341676e == null) {
                    break;
                }
                hp3.h hVar = new hp3.h(next);
                if (hVar.f405843c == eVar.f341694b && z16) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                hVar.f405844d = z17;
                arrayList.add(hVar);
            }
            return arrayList;
        }
        t.b("AuthModelUtil", "getVirtualAccountInfoList list empty");
        return arrayList;
    }

    public static void i(Intent intent, Bundle bundle, String str) {
        QLog.d("AuthModelUtil", 1, "handleAgentAppId");
        if (j(intent, bundle)) {
            return;
        }
        long j3 = bundle.getLong("dstAppid");
        if (j3 == 0) {
            j3 = BaseConstants.OPEN_SDK_BUFLAG_B1;
        }
        if (TextUtils.isEmpty(str)) {
            str = String.valueOf(j3);
        }
        intent.putExtra("im_block_sso_appid", str);
        QLog.d("AuthModelUtil", 1, "put IM_BLOCK_SSO_APPID: " + str);
    }

    private static boolean j(Intent intent, Bundle bundle) {
        if (intent != null && bundle != null) {
            return false;
        }
        QLog.e("AuthModelUtil", 1, "handleAgentAppId params empty");
        return true;
    }

    private static boolean k(Bundle bundle) {
        if (bundle != null && bundle.getParcelable("userSigInfo") != null) {
            return false;
        }
        QLog.d("AuthModelUtil", 1, "checkIMBlockByBundle not support im block check");
        return true;
    }

    private static boolean l(WUserSigInfo wUserSigInfo) {
        HashMap<Integer, tlv_t> hashMap;
        tlv_t tlv_tVar;
        if (wUserSigInfo == null || (hashMap = wUserSigInfo.loginResultTLVMap) == null || (tlv_tVar = hashMap.get(1347)) == null || tlv_tVar.get_data() == null) {
            return true;
        }
        QLog.d("AuthModelUtil", 1, "SigData is valid");
        return false;
    }

    public static List<hp3.d> m(PBRepeatMessageField<GetAppInfoProto$MsgIconsurl> pBRepeatMessageField) {
        ArrayList arrayList = new ArrayList();
        if (!pBRepeatMessageField.has()) {
            return arrayList;
        }
        int size = pBRepeatMessageField.size();
        for (int i3 = 0; i3 < size; i3++) {
            GetAppInfoProto$MsgIconsurl getAppInfoProto$MsgIconsurl = pBRepeatMessageField.get(i3);
            arrayList.add(new hp3.d(getAppInfoProto$MsgIconsurl.url, getAppInfoProto$MsgIconsurl.size));
        }
        return arrayList;
    }
}
