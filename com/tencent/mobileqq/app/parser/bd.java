package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.contact.addcontact.recommend.RecommendFriendActivity;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.oidb_0xc26$MayKnowPerson;
import tencent.im.troop.findtroop.SignChecker$CheckSignReply;
import tencent.im.troop.findtroop.SignChecker$CheckSignRequest;

/* compiled from: P */
/* loaded from: classes11.dex */
public class bd extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;
    protected static final boolean R;
    protected final boolean Q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Map f196463d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Intent f196464e;

        a(Map map, Intent intent) {
            this.f196463d = map;
            this.f196464e = intent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bd.this, map, intent);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (i3 != 0) {
                if (bd.R) {
                    QQToastUtil.showQQToast(1, "\u8bf7\u6c42\u5931\u8d25 errorcode " + i3);
                }
                QLog.i("MayKnowAction", 1, "checkSing error errorCode " + i3);
                return;
            }
            try {
                SignChecker$CheckSignReply mergeFrom = new SignChecker$CheckSignReply().mergeFrom(bArr);
                if (mergeFrom.ret.get() == 0) {
                    bd.this.G(this.f196463d, this.f196464e);
                    return;
                }
                if (bd.R) {
                    QQToastUtil.showQQToast(1, "\u6821\u9a8c\u5931\u8d25 " + mergeFrom.ret.get() + " msg " + mergeFrom.f436055msg.get());
                }
                QLog.e("MayKnowAction", 1, "errorcode: " + mergeFrom.ret.get() + " err msg: " + mergeFrom.f436055msg.get());
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("MayKnowAction", 1, e16, "checkParamValid parse CheckSignReply error.");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70533);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            R = ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).pymkTestSwitch();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public bd(BaseQQAppInterface baseQQAppInterface, Context context) {
        super(baseQQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) context);
        } else {
            this.Q = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("may_know_action_check_login_status", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(Map<String, String> map, Intent intent) {
        try {
            ArrayList<MayKnowRecommend> J = J(map.get("data"));
            if (J != null && !J.isEmpty()) {
                intent.putExtra("may_know_recmmds", J);
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("MayKnowAction", 1, e16, "addMayKnowDataAndStartActivity parseMayKnowData error.");
        }
        L(intent, map);
    }

    private boolean H(AppRuntime appRuntime, Map<String, String> map) {
        if (appRuntime == null) {
            return true;
        }
        if (!map.containsKey("_XUIN")) {
            if (R) {
                QQToastUtil.showQQToast(1, "\u6ca1\u6709XUIN\u53c2\u6570");
            }
            QLog.i("MayKnowAction", 1, "checkIsForCurrentUser fail without XUIN");
            return false;
        }
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        String str = map.get("_XUIN");
        if (TextUtils.isEmpty(currentAccountUin) || currentAccountUin.equals(str)) {
            return true;
        }
        if (R) {
            QQToastUtil.showQQToast(1, "\u975e\u5f53\u524d\u7528\u6237push");
        }
        QLog.i("MayKnowAction", 1, "checkIsForCurrentUser fail not current account current: " + currentAccountUin + " param: " + str);
        return false;
    }

    private void I(AppRuntime appRuntime, Intent intent, Map<String, String> map) {
        SignChecker$CheckSignRequest signChecker$CheckSignRequest = new SignChecker$CheckSignRequest();
        signChecker$CheckSignRequest.raw_url.set(this.f307438c);
        if (appRuntime != null && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("check_schemma_valid", false)) {
            if (!H(appRuntime, map)) {
                return;
            }
            ProtoUtils.a(appRuntime, new a(map, intent), signChecker$CheckSignRequest.toByteArray(), "OidbSvcTrpcTcp.0x9266", 37478, 1);
            return;
        }
        G(map, intent);
    }

    private ArrayList<MayKnowRecommend> J(String str) throws InvalidProtocolBufferMicroException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            oidb_0xc26$MayKnowPerson oidb_0xc26_mayknowperson = new oidb_0xc26$MayKnowPerson();
            oidb_0xc26_mayknowperson.mergeFrom(Base64.decode(str, 0));
            return MayKnowRecommend.covServerDataToLocal(new ArrayList(Collections.singleton(oidb_0xc26_mayknowperson)), ((int) System.currentTimeMillis()) / 1000);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("MayKnowAction", 1, "data= " + this.f307438c + "\n" + e16);
            return null;
        }
    }

    public static Map<String, String> K(String str) {
        HashMap hashMap = new HashMap();
        try {
            if (str.indexOf(63) != -1) {
                String substring = str.substring(str.indexOf(63) + 1);
                String[] split = substring.substring(substring.indexOf(63) + 1).split(ContainerUtils.FIELD_DELIMITER);
                for (int i3 = 0; i3 < split.length; i3++) {
                    if (split[i3].contains(ContainerUtils.KEY_VALUE_DELIMITER)) {
                        String str2 = split[i3];
                        String substring2 = str2.substring(0, str2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER));
                        String str3 = split[i3];
                        hashMap.put(substring2, str3.substring(str3.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) + 1));
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return hashMap;
    }

    private void L(Intent intent, Map<String, String> map) {
        if (map.containsKey("from")) {
            intent.putExtra("may_know_from", map.get("from"));
        }
        this.f307437b.startActivity(intent);
    }

    private boolean M() throws InvalidProtocolBufferMicroException {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (this.Q && peekAppRuntime != null && !peekAppRuntime.isLogin()) {
            QLog.i("MayKnowAction", 1, "block RecommendFriendActivity because no login");
            return false;
        }
        Intent intent = new Intent(this.f307437b, (Class<?>) RecommendFriendActivity.class);
        intent.putExtra("EntranceId", 9);
        intent.putExtra("need_show_qzone_info", true);
        intent.setFlags(603979776);
        Map<String, String> K = K(this.f307438c);
        if (K.containsKey("data")) {
            I(peekAppRuntime, intent, K);
            return true;
        }
        L(intent, K);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059 A[Catch: Exception -> 0x005e, TRY_LEAVE, TryCatch #0 {Exception -> 0x005e, blocks: (B:13:0x003e, B:19:0x0059, B:22:0x004a), top: B:12:0x003e }] */
    @Override // com.tencent.mobileqq.utils.ax
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b() {
        char c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("MayKnowAction", 2, "doAction , thread:" + Thread.currentThread().getName());
        }
        try {
            String str = this.f307440e;
            if (str.hashCode() == -485371922 && str.equals("homepage")) {
                c16 = 0;
                if (c16 == 0) {
                    return true;
                }
                return M();
            }
            c16 = '\uffff';
            if (c16 == 0) {
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("MayKnowAction", 1, "doAction error: " + e16.getMessage());
            }
            i("MayKnowAction");
            return false;
        }
    }
}
