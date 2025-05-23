package i2;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.search.model.ac;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
import com.tencent.open.business.base.MobileInfoUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final List<String> f407087a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private static String[] f407088b = {"userid", NotificationActivity.PASSWORD, "siteid", "plmn", "mobilephone", "deviceinfo", "uuid", "deviceid2", "secretdigest", "salt", "emmcid", "secretdigesttype", "clientip", "deviceid", "device_id", "securityphone", "securityemail", "cookie", "devicetype", "useremail", "email", "servicetoken", "oldpassword", "newpassword", "thirdtoken", "smsauthcode", "phone", QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN, "sc", "sso_st", "token", ac.f283467k0, "pw", "dvid", "pl", "dvid2", "sc", "emid", "sct", "c", "st", "app", "uid", MobileInfoUtil.IMSI, "thirdopenid", "thirdaccesstoken", VasLiveIPCModule.KEY_GET_ACCOUNT_NICK_NAME, "useraccount", "fulluseraccount", "nickName", "uniquelynickname", "loginusername", "thirdnickname", "fingerST"};

    static {
        c();
    }

    private static String a(char c16, int i3) {
        StringBuffer stringBuffer = new StringBuffer(i3);
        for (int i16 = 0; i16 < i3; i16++) {
            stringBuffer.append(c16);
        }
        return stringBuffer.toString();
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.length() == 1) {
            return "*";
        }
        int ceil = (int) Math.ceil((str.length() * 50) / 100.0d);
        return a('*', ceil) + str.substring(ceil);
    }

    private static void c() {
        String[] strArr = f407088b;
        if (strArr != null) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    f407087a.add(str.toLowerCase(Locale.ENGLISH));
                }
            }
        }
    }
}
