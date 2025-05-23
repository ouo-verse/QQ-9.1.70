package com.tenpay.sdk.helper;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tenpay.bank.BindBankModule;
import com.tenpay.idverify.IdVerifyModule;
import com.tenpay.realname.RealNameSource;
import com.tenpay.sdk.QWalletFakeUrl;
import com.tenpay.sdk.activity.TenpayUtilActivity;

/* compiled from: P */
/* loaded from: classes27.dex */
public class HBShiMingHelper {
    public static void doAction(TenpayUtilActivity tenpayUtilActivity, int i3, String str, String str2, String str3, RealNameSource realNameSource) {
        if (tenpayUtilActivity != null) {
            if (TextUtils.isEmpty(str3)) {
                str3 = tenpayUtilActivity.getResources().getString(R.string.e8h);
            }
            if (!TextUtils.isEmpty(str2)) {
                Uri parse = Uri.parse(str2);
                if (parse == null) {
                    return;
                }
                String host = parse.getHost();
                if (QWalletFakeUrl.FAKEURL_BINDCARDVERIFY.equals(host)) {
                    Intent intent = new Intent();
                    intent.putExtra("IsShiMing", true);
                    intent.putExtra("hb_shiming_tips", str3);
                    if (!TextUtils.isEmpty(str)) {
                        intent.putExtra("uin", str);
                    }
                    String queryParameter = parse.getQueryParameter("showIDCardVerify");
                    if (TextUtils.isEmpty(queryParameter)) {
                        intent.putExtra("IsIdVerifyValid", true);
                    } else if (queryParameter.equals("1")) {
                        intent.putExtra("IsIdVerifyValid", true);
                    } else if (queryParameter.equals("0")) {
                        intent.putExtra("IsIdVerifyValid", false);
                    }
                    intent.putExtra(RealNameSource.EXTRA_KEY_SOURCE, realNameSource);
                    BindBankModule.INSTANCE.startVerifyForResult(tenpayUtilActivity, intent, i3);
                    return;
                }
                if ("idCardVerify".equals(host)) {
                    IdVerifyModule.startFromHb(tenpayUtilActivity, i3, realNameSource);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("url", str2);
                intent2.putExtra("startOpenPageTime", System.currentTimeMillis());
                intent2.putExtra("hide_operation_bar", true);
                intent2.putExtra("hide_more_button", true);
                FragmentActivity activity = tenpayUtilActivity.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    RouteUtils.startActivity(activity, intent2, RouterConstants.UI_ROUTE_BROWSER);
                    return;
                }
                return;
            }
            IdVerifyModule.startFromHb(tenpayUtilActivity, i3, realNameSource);
        }
    }
}
