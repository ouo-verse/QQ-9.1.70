package d2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.hihonor.cloudservice.common.ApiException;
import com.hihonor.cloudservice.support.account.request.SignInOptions;
import com.hihonor.cloudservice.support.account.result.SignInAccountInfo;
import com.hihonor.cloudservice.support.api.clients.Status;
import com.hihonor.cloudservice.tasks.f;
import com.hihonor.cloudservice.tasks.g;
import com.hihonor.honorid.core.data.HonorAccount;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import h45.d;
import j2.b;
import q.q.q.e.w.e;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {
    public static f<SignInAccountInfo> a(int i3, Intent intent) {
        e.c("AccountAuthUtil", "getSignInResultFromIntent : resultCode" + i3, true);
        g gVar = new g();
        String str = "intent is null";
        if (intent != null) {
            if (-2 != i3 && -1 != i3) {
                if (57 == i3) {
                    str = "mcp check fail";
                } else if (56 == i3) {
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        int i16 = extras.getInt(CheckForwardServlet.KEY_ERR_CODE, 56);
                        str = extras.getString("server_err_desc", "access server return error");
                        i3 = i16;
                    } else {
                        i3 = 56;
                    }
                    e.c("AccountAuthUtil", "loginResult : errCode = " + i3 + " errMsg = " + str, true);
                    if (1101 != i3) {
                        if (1202 == i3) {
                            i3 = 68;
                        }
                    }
                    i3 = 67;
                } else if (2005 == i3) {
                    i3 = 5;
                    str = "network unaviable!";
                } else {
                    str = "other error!";
                }
            } else {
                HonorAccount b16 = new HonorAccount().b(intent.getExtras());
                m2.a.b(com.hihonor.honorid.a.c().a()).c(b16);
                gVar.d(SignInAccountInfo.f(b16.i0(), "", null, b16.l0(), b16.J0(), b16.M()));
                return gVar.b();
            }
        } else if (i3 == 2) {
            i3 = 30;
            str = "serviceToken invalid!";
        } else if (i3 == 0) {
            i3 = 3002;
            str = "user cancel login!";
        } else {
            if (2012 == i3) {
                i3 = 70;
                str = "user cancel auth!";
            }
            i3 = 67;
        }
        gVar.c(new ApiException(new Status(i3, str)));
        return gVar.b();
    }

    public static Intent b(Context context, SignInOptions signInOptions) {
        if (context == null) {
            Log.e("AccountAuthUtil", "getSignInIntent : context is null");
            return null;
        }
        e.a(context);
        e.c("AccountAuthUtil", "getSignInIntent", true);
        if (h45.g.d(context, 60000000)) {
            return null;
        }
        if (!b.a(context)) {
            if (!d(context)) {
                return null;
            }
        } else if (h45.g.a(context, 60300360)) {
            e.c("AccountAuthUtil", "HonorAPK version is too low", true);
            return null;
        }
        String f16 = j2.a.f(context);
        c(context, 907114522, 100, "getSignInIntent entry", f16, "api_entry");
        h45.a.a(context, "AccountAuthUtil : Null context is not permitted.");
        String packageName = context.getPackageName();
        if (!TextUtils.equals(packageName, j2.a.h(context))) {
            e.c("AccountAuthUtil", "packageName is not equals current's!", true);
            c(context, 907114522, 100, "packageName is not equals current's!", f16, "api_ret");
            return null;
        }
        String a16 = signInOptions.a();
        h45.a.b(a16, "AccountAuthUtil : Null clientId is not permitted.");
        Intent intent = new Intent();
        try {
            intent.setAction("com.hihonor.id.ACTION.WEBAUTH");
            intent.setPackage("com.hihonor.id");
            intent.putExtra(CommonConstant.ReqAccessTokenParam.CLIENT_ID, a16);
            intent.putExtra("scope", d.a(signInOptions.f()));
            intent.putExtra("loginChannel", signInOptions.b());
            intent.putExtra("packageName", packageName);
            intent.putExtra("requireAuthCode", signInOptions.j());
            intent.putExtra("requireToken", signInOptions.k());
            intent.putExtra("callType", "openSDK");
            intent.putExtra("reqClientType", signInOptions.e());
        } catch (IllegalArgumentException e16) {
            e.b("AccountAuthUtil", "getSignInIntent Exception : " + e16.getMessage(), true);
        }
        return intent;
    }

    private static boolean d(Context context) {
        if (!h45.g.a(context, 50120345) && ((!h45.g.c(context, 60100316) || !h45.g.d(context, 60100318)) && ((!h45.g.c(context, 60100301) || !h45.g.d(context, 60100303)) && h45.g.b(context) != 60130300))) {
            return true;
        }
        e.c("AccountAuthUtil", "HonorAPK version is too low", true);
        return false;
    }

    private static void c(Context context, int i3, int i16, String str, String str2, String str3) {
    }
}
