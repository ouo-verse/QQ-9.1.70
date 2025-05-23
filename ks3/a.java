package ks3;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.minibox.business.api.MiniBoxSDK;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxLauncher;
import fs3.MiniBoxInfo;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a extends ax {
    public a(BaseQQAppInterface baseQQAppInterface, Context context) {
        super(baseQQAppInterface, context);
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        QLog.i("MiniBoxJumpAction", 1, "doAction: server_name: " + this.f307439d + ", action_name: " + this.f307440e);
        if ("open_pay_result".equals(this.f307440e)) {
            ((IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class)).launchVirtualApp(this.f307437b, this.f307441f.get("app_id"), this.f307441f.get("pkg_name"), this.f307441f.get("app_version"));
        } else if ("open_share_result".equals(this.f307440e)) {
            String str = this.f307441f.get("app_id");
            String str2 = this.f307441f.get("app_version");
            String str3 = this.f307441f.get("pkg_name");
            QLog.i("MiniBoxJumpAction", 1, "open_share_result appId:" + str + ", appVersion:" + str2 + ", packageName:" + str3);
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            MiniBoxInfo miniBoxInfo = new MiniBoxInfo();
            if (!TextUtils.isEmpty(str2)) {
                try {
                    miniBoxInfo.o(Integer.parseInt(str2));
                } catch (Throwable unused) {
                    QLog.e("MiniBoxJumpAction", 1, "parse app version error");
                }
            }
            miniBoxInfo.n(str3);
            miniBoxInfo.m(true);
            ((IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class)).launchVirtualApp(str, miniBoxInfo, null);
        } else if ("qqmusic_auth_callback".equals(this.f307440e)) {
            String str4 = this.f307441f.get("callbackUrl");
            String str5 = this.f307441f.get("minibox_pid");
            if (TextUtils.isEmpty(str5)) {
                QLog.e("MiniBoxJumpAction", 1, "qq auth: pid is empty");
                return true;
            }
            int parseInt = Integer.parseInt(str5);
            QLog.i("MiniBoxJumpAction", 1, "qq auth: " + str4 + " , pid:" + parseInt);
            Bundle bundle = new Bundle();
            bundle.putString("minibox_action", CommonConstant.ACTION.HWID_SCHEME_URL);
            bundle.putString("minibox_data", Uri.parse(str4).toString());
            ((IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class)).launchVirtualApp(this.f307437b, "", "com.tencent.letsgo", "");
            MiniBoxSDK.notifyClient(parseInt, "minibox_start_activity", bundle);
        }
        return true;
    }
}
