package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.BuildConfig;
import com.tencent.biz.map.DetailMapFragment;
import com.tencent.biz.map.MapUtils;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ba extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: protected */
    public ba(BaseQQAppInterface baseQQAppInterface, Context context) {
        super(baseQQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) context);
        }
    }

    public static String F(String str) {
        String str2 = "";
        while (!str2.equals(str)) {
            try {
                str2 = str;
                str = URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException e16) {
                return "Issue while decoding" + e16.getMessage();
            }
        }
        return str;
    }

    public static Map<String, Object> G(String str) {
        HashMap hashMap = new HashMap();
        try {
            String decode = URLDecoder.decode(str, "utf-8");
            if (decode.indexOf(63) != -1) {
                String substring = decode.substring(decode.indexOf(63) + 1);
                String[] split = substring.substring(substring.indexOf(63) + 1).split(ContainerUtils.FIELD_DELIMITER);
                for (int i3 = 0; i3 < split.length; i3++) {
                    if (split[i3].contains(ContainerUtils.KEY_VALUE_DELIMITER)) {
                        String str2 = split[i3];
                        String substring2 = str2.substring(0, str2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER));
                        String str3 = split[i3];
                        hashMap.put(substring2, I(split, str3.substring(str3.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) + 1), i3));
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return hashMap;
    }

    private boolean H(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Double valueOf = Double.valueOf(str);
            Double valueOf2 = Double.valueOf(str2);
            if (!Double.isNaN(valueOf.doubleValue()) && !Double.isNaN(valueOf2.doubleValue()) && Math.abs(valueOf.doubleValue()) <= 90.0d && Math.abs(valueOf2.doubleValue()) <= 180.0d) {
                return true;
            }
        }
        return false;
    }

    private static String I(String[] strArr, String str, int i3) {
        if (strArr == null) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder(str);
        while (true) {
            i3++;
            if (i3 >= strArr.length || strArr[i3].contains(ContainerUtils.KEY_VALUE_DELIMITER)) {
                break;
            }
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append(strArr[i3]);
        }
        return sb5.toString();
    }

    private boolean J() {
        if (TextUtils.isEmpty(this.f307441f.get("miniMapUrl"))) {
            return false;
        }
        Map<String, Object> G = G(F(this.f307441f.get("miniMapUrl")));
        if (G.get("latitude") == null || G.get("longitude") == null) {
            return false;
        }
        Intent className = new Intent().setClassName(BuildConfig.LIBRARY_PACKAGE_NAME, "com.map.detial");
        Bundle bundle = new Bundle();
        bundle.putString("strName", (String) G.get("strName"));
        bundle.putString("address", (String) G.get("address"));
        bundle.putString(QCircleSchemeAttr.Polymerize.LAT, (String) G.get("latitude"));
        bundle.putString("lon", (String) G.get("longitude"));
        bundle.putString("sendUin", this.f307436a.getCurrentAccountUin());
        bundle.putString("receiveUin", this.f307436a.getCurrentNickname());
        bundle.putString("receiveUinType", this.f307436a.getAccount());
        className.putExtras(bundle);
        if (!H((String) G.get("latitude"), (String) G.get("longitude"))) {
            return false;
        }
        if (MapUtils.d(this.f307437b) <= 0) {
            QQToastUtil.showQQToastInUiThread(1, this.f307437b.getString(R.string.f171143iv2));
            return false;
        }
        QPublicFragmentActivity.start(this.f307437b, className, DetailMapFragment.class);
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
            QLog.d("JumpAction", 2, "doAction , thread:" + Thread.currentThread().getName());
        }
        try {
            String str = this.f307440e;
            if (str.hashCode() == -1263181102 && str.equals("openmap")) {
                c16 = 0;
                if (c16 == 0) {
                    return true;
                }
                return J();
            }
            c16 = '\uffff';
            if (c16 == 0) {
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("JumpAction", 1, "doAction error: " + e16.getMessage());
            }
            i("JumpAction");
            return false;
        }
    }
}
