package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.bean.AccountInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.bm;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.BindUinInfo;
import com.tencent.qqnt.kernel.nativeinterface.UinInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import tencent.im.login.GatewayVerify$RspBody;
import tencent.im.login.GatewayVerify$UinInfo;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bk {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f306629d;

        a(Context context) {
            this.f306629d = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QLog.d("PhoneNumLoginManager", 1, "showUnbindPhoneNumDialog okBtn click");
            com.tencent.mobileqq.register.n.f280469a.m((QBaseActivity) this.f306629d, 6, null, false, false, false, false);
            bk.k("0X800B8D7");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QLog.d("PhoneNumLoginManager", 1, "showUnbindPhoneNumDialog cancelBtn click");
        }
    }

    @Nullable
    public static com.tencent.mobileqq.widget.bm a(Context context, WUserSigInfo wUserSigInfo, int i3, bm.c cVar, DialogInterface.OnDismissListener onDismissListener) {
        List<AccountInfo> c16 = c(wUserSigInfo, i3);
        if (c16 != null && !c16.isEmpty()) {
            String f16 = f(wUserSigInfo, i3);
            HashMap hashMap = new HashMap();
            hashMap.put("key_dialog_title", context.getString(R.string.f2035650j));
            hashMap.put("key_unbind_account_list", c16);
            hashMap.put("key_unbind_account_tip", f16);
            hashMap.put("key_unbind_account_show_login_btn", Boolean.TRUE);
            return ck.f306664a.c(context, hashMap, cVar, onDismissListener);
        }
        QLog.e("PhoneNumLoginManager", 1, "createSelectAccountDialog: uinInfoList is null or empty");
        return null;
    }

    public static com.tencent.mobileqq.widget.bm b(Context context, List<AccountInfo> list, String str, bm.c cVar, DialogInterface.OnDismissListener onDismissListener) {
        if (list != null && !list.isEmpty()) {
            HashMap hashMap = new HashMap();
            hashMap.put("key_dialog_title", context.getString(R.string.f2035650j));
            hashMap.put("key_unbind_account_list", list);
            hashMap.put("key_unbind_account_tip", str);
            hashMap.put("key_unbind_account_show_login_btn", Boolean.TRUE);
            return ck.f306664a.c(context, hashMap, cVar, onDismissListener);
        }
        QLog.e("PhoneNumLoginManager", 1, "createSelectAccountDialog: uinInfoList is null or empty");
        return null;
    }

    public static List<AccountInfo> c(WUserSigInfo wUserSigInfo, int i3) {
        List<GatewayVerify$UinInfo> list;
        tlv_t tlv_tVar = wUserSigInfo.loginResultTLVMap.get(1347);
        if (tlv_tVar == null) {
            QLog.e("PhoneNumLoginManager", 1, "getUinInfo: 0x543 tlv is null");
            return null;
        }
        byte[] bArr = tlv_tVar.get_data();
        GatewayVerify$RspBody gatewayVerify$RspBody = new GatewayVerify$RspBody();
        try {
            gatewayVerify$RspBody.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("PhoneNumLoginManager", 1, "mergeFrom error", e16);
        }
        if (i3 == 4) {
            list = gatewayVerify$RspBody.msg_rsp_self_phone.msg_rsp_phone_login.rpt_bind_uin_info.get();
        } else if (i3 == 5) {
            list = gatewayVerify$RspBody.msg_rsp_cmd_18.msg_rsp_phone_sms_extend_login.rpt_bind_uin_info.get();
        } else if (i3 == 7) {
            list = gatewayVerify$RspBody.msg_rsp_cmd_25.rpt_bind_uin_info.get();
        } else {
            QLog.e("PhoneNumLoginManager", 1, "getUinInfo: scene type is error!");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (GatewayVerify$UinInfo gatewayVerify$UinInfo : list) {
            arrayList.add(new AccountInfo(gatewayVerify$UinInfo.str_nick.get(), gatewayVerify$UinInfo.str_mask_uin.get(), gatewayVerify$UinInfo.bytes_encrypt_uin.get().toByteArray(), gatewayVerify$UinInfo.str_image_url.get(), gatewayVerify$UinInfo.str_key_uin.get(), gatewayVerify$UinInfo.bytes_a1_sig.get().toByteArray()));
        }
        return arrayList;
    }

    public static List<AccountInfo> d(BindUinInfo bindUinInfo) {
        if (bindUinInfo != null && !bindUinInfo.uinInfoList.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<UinInfo> it = bindUinInfo.uinInfoList.iterator();
            while (it.hasNext()) {
                UinInfo next = it.next();
                arrayList.add(new AccountInfo(next.nick, next.maskUin, next.encryptUin, next.imageUrl, next.keyUin, next.a1Sig));
            }
            return arrayList;
        }
        QLog.e("PhoneNumLoginManager", 1, "getAccountInfoFromNT uinInfo is empty!");
        return null;
    }

    private static AppRuntime e() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    private static String f(WUserSigInfo wUserSigInfo, int i3) {
        String str;
        tlv_t tlv_tVar = wUserSigInfo.loginResultTLVMap.get(1347);
        if (tlv_tVar == null) {
            QLog.e("PhoneNumLoginManager", 1, "getUnbindWording: 0x543 tlv is null");
            return null;
        }
        byte[] bArr = tlv_tVar.get_data();
        try {
            GatewayVerify$RspBody gatewayVerify$RspBody = new GatewayVerify$RspBody();
            gatewayVerify$RspBody.mergeFrom(bArr);
            if (i3 == 4) {
                str = gatewayVerify$RspBody.msg_rsp_self_phone.msg_rsp_phone_login.str_unbind_wording.get();
            } else if (i3 == 5) {
                str = gatewayVerify$RspBody.msg_rsp_cmd_18.msg_rsp_phone_sms_extend_login.str_unbind_wording.get();
            } else if (i3 == 7) {
                str = gatewayVerify$RspBody.msg_rsp_cmd_25.str_unbind_wording.get();
            } else {
                str = null;
            }
            if (QLog.isColorLevel()) {
                QLog.d("PhoneNumLoginManager", 2, "getUnbindWording unbind_wording : ", str);
            }
            return str;
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.d("PhoneNumLoginManager", 1, "getUnbindWording error : ", e16);
            return null;
        }
    }

    public static void g(Context context) {
        String string = context.getString(R.string.f2036150o);
        String string2 = context.getString(R.string.f2036050n);
        String string3 = context.getString(R.string.nvd);
        String string4 = context.getString(R.string.f172151nv4);
        QLog.d("PhoneNumLoginManager", 1, "showUnbindPhoneNumDialog dialogMsg=", string, ", okBtnText=", string2, ", noBtnText=", string3);
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230);
        createCustomDialog.setMessage(string);
        createCustomDialog.setTitle(string4);
        createCustomDialog.getMessageTextView().setGravity(1);
        createCustomDialog.setPositiveButton(string2, new a(context));
        createCustomDialog.setNegativeButton(string3, new b());
        createCustomDialog.show();
    }

    public static void h(String str, int i3, String str2) {
        ReportController.r(e(), "dc00898", "", "", str, str, i3, 0, str2, "", "", "");
    }

    public static void i(String str) {
        h("0X800B8CF", 0, str);
    }

    public static void j(int i3, String str) {
        ReportController.r(e(), "dc00898", "", "", "0X800B8CB", "0X800B8CB", i3, 0, str, "", com.tencent.mobileqq.statistics.o.c(), "");
    }

    public static void k(String str) {
        h(str, 0, "");
    }
}
