package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.open.appcommon.Common;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class cr extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public cr(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    private boolean F() {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("Jumpaction", 2, " source:" + this.f307438c + "  serverName:" + this.f307439d + "  hostName:" + this.f307440e);
        }
        if (TextUtils.isEmpty(this.f307440e)) {
            QLog.e("QappCenterJumpAction", 1, "gotoQAppcenter error: action_name is empty");
            return false;
        }
        if (this.f307440e.equals("index")) {
            Intent intent = new Intent(this.f307437b, (Class<?>) QZoneAppListActivity.class);
            intent.putExtra("goto_type", 1);
            this.f307437b.startActivity(intent);
        } else if (this.f307440e.equals("detail")) {
            if (!TextUtils.isEmpty(this.f307438c)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(Common.s());
                String str2 = File.separator;
                sb5.append(str2);
                sb5.append("qapp_center_detail.htm");
                String sb6 = sb5.toString();
                if (new File(sb6).exists()) {
                    str = "file:///" + sb6;
                } else {
                    str = Common.e() + str2 + "qapp_center_detail.htm";
                }
                Intent intent2 = new Intent(this.f307437b, (Class<?>) QZoneAppListActivity.class);
                Bundle bundle = new Bundle();
                String queryParameter = Uri.parse(this.f307438c).getQueryParameter("param");
                bundle.putString("APP_URL", str);
                bundle.putString("APP_PARAMS", ContainerUtils.FIELD_DELIMITER + queryParameter);
                bundle.putInt("goto_type", 2);
                intent2.putExtras(bundle);
                intent2.putExtra("adapter_action", "action_app_detail");
                this.f307437b.startActivity(intent2);
            }
        } else if (this.f307440e.equals("webview")) {
            if (!TextUtils.isEmpty(this.f307438c)) {
                Intent intent3 = new Intent(this.f307437b, (Class<?>) QZoneAppListActivity.class);
                Bundle bundle2 = new Bundle();
                bundle2.putString("APP_URL", Uri.parse(this.f307438c).getQueryParameter("url"));
                bundle2.putInt("goto_type", 3);
                intent3.putExtras(bundle2);
                this.f307437b.startActivity(intent3);
            }
        } else if (this.f307440e.equals("local") && !TextUtils.isEmpty(this.f307438c)) {
            Uri parse = Uri.parse(this.f307438c);
            String queryParameter2 = parse.getQueryParameter("title");
            String[] h16 = Common.h(parse.getQueryParameter("url"));
            if (h16.length > 1) {
                String str3 = h16[0];
                if (str3.startsWith("file://") && (str3.contains(Common.s()) || str3.contains("android_asset/Page/system/"))) {
                    String str4 = h16[1];
                    Intent intent4 = new Intent(this.f307437b, (Class<?>) QZoneAppListActivity.class);
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("APP_URL", str3);
                    ArrayList<String> arrayList = new ArrayList<>();
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        arrayList.add(queryParameter2);
                    }
                    bundle3.putStringArrayList("titleName", arrayList);
                    if (str4 != null && str4.length() > 0) {
                        bundle3.putString("APP_PARAMS", str4);
                    }
                    bundle3.putInt("goto_type", 4);
                    intent4.putExtras(bundle3);
                    this.f307437b.startActivity(intent4);
                }
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            return F();
        } catch (Exception e16) {
            QLog.e("QappCenterJumpAction", 1, "doAction error: " + e16.getMessage());
            i("QappCenterJumpAction");
            return false;
        }
    }
}
