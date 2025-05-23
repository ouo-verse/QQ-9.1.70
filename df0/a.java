package df0;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.e;
import com.tencent.mobileqq.forward.k;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    protected static a f393663c;

    /* renamed from: a, reason: collision with root package name */
    protected HashMap<String, Object> f393664a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    protected SessionInfo f393665b;

    public static a a() {
        if (f393663c == null) {
            f393663c = new a();
        }
        return f393663c;
    }

    public static void d(String str, String str2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ReportController.r(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "aio_app", str2, 0, 0, str, str3, str4, str5);
    }

    public boolean b(String str) {
        return this.f393664a.containsKey(str);
    }

    public boolean c(Intent intent, Activity activity, QQAppInterface qQAppInterface) {
        if (!"thridapp".equals(intent.getStringExtra(WinkDaTongReportConstant.ElementParamKey.SHARE_FROM))) {
            return false;
        }
        intent.removeExtra(WinkDaTongReportConstant.ElementParamKey.SHARE_FROM);
        a a16 = a();
        Long valueOf = Long.valueOf(intent.getLongExtra("req_share_id", 0L));
        if (!a16.b(String.valueOf(valueOf))) {
            return true;
        }
        intent.putExtra("share_from_aio", true);
        intent.putExtra("forward_type", 11);
        intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 1);
        if (!intent.hasExtra("pkg_name")) {
            intent.putExtra("pkg_name", "");
        }
        intent.putExtra("refuse_show_share_result_dialog", true);
        SessionInfo sessionInfo = a16.f393665b;
        if (sessionInfo != null) {
            ForwardBaseOption d16 = k.d(intent, qQAppInterface, activity);
            Bundle bundle = new Bundle();
            bundle.putString("uin", sessionInfo.f179557e);
            bundle.putInt("uintype", sessionInfo.f179555d);
            bundle.putString("troop_uin", sessionInfo.f179559f);
            bundle.putString("uinname", sessionInfo.f179563i);
            d16.buildForwardDialog(e.N3.intValue(), bundle);
            d(String.valueOf(valueOf), "app_share_view", "", "", "");
        }
        return true;
    }
}
