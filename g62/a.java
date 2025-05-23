package g62;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import cooperation.qzone.util.NetworkState;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static DownloadInfo f401443a;

    /* compiled from: P */
    /* renamed from: g62.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class DialogInterfaceOnClickListenerC10359a implements DialogInterface.OnClickListener {
        DialogInterfaceOnClickListenerC10359a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            DownloadManager.C().d0(a.f401443a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    private static String b(String str) {
        return null;
    }

    private static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals("video_type_videocard")) {
            return "https://act.qzone.qq.com/vip/meteor/m/p/3f04eaa353710dd5c996e09588244bf93066";
        }
        if (str.equals("video_type_videoguid")) {
            return "https://act.qzone.qq.com/vip/meteor/m/p/01e512f4384e934f8b42e30f9e16f1283064";
        }
        if (str.equals("video_type_videopublic")) {
            return "https://act.qzone.qq.com/vip/meteor/m/p/f644be070eeed9bcba017b43a8c7980a3065";
        }
        return null;
    }

    public static DownloadInfo d(String str) {
        int i3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        DownloadInfo downloadInfo = new DownloadInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            downloadInfo.f341184e = jSONObject.getString("appid");
            downloadInfo.f341186f = jSONObject.getString("url");
            downloadInfo.f341189h = jSONObject.getString("packageName");
            downloadInfo.C = jSONObject.getString("via");
            downloadInfo.T = true;
            downloadInfo.f341183d0 = true;
            downloadInfo.Z = TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE;
            String string = jSONObject.getString("isAutoInstall");
            if (string != null) {
                downloadInfo.T = string.equals("1");
            }
            String string2 = jSONObject.getString(WadlResult.WEB_KEY_IS_AUTO_INSTALL_BY_SDK);
            if (string2 != null) {
                downloadInfo.f341183d0 = string2.equals("1");
            }
            String string3 = jSONObject.getString("isShowNotification");
            if (string3 != null) {
                if (string3.equals("1")) {
                    i3 = TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE;
                } else {
                    i3 = TMAssistantDownloadConst.SHOW_NOTIFICATION_FALSE;
                }
                downloadInfo.Z = i3;
            }
            downloadInfo.X = true;
            downloadInfo.M = p62.a.a(40677);
            downloadInfo.f341191i = jSONObject.getString("appName");
            return downloadInfo;
        } catch (JSONException unused) {
            QLog.e("VideoFeedsWeiShiUtils", 4, "json err:" + str);
            return null;
        }
    }

    private static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals("video_type_videocard")) {
            return "weishi://main?goto=recommend&logsour=5001";
        }
        if (str.equals("video_type_videoguid")) {
            return "weishi://main?goto=recommend&logsour=5002";
        }
        if (str.equals("video_type_videopublic")) {
            return "weishi://main?goto=recommend&logsour=5003";
        }
        return null;
    }

    public static void f(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!TextUtils.isEmpty(b(str))) {
            f401443a = d(b(str));
        }
        if (f401443a != null) {
            if (NetworkState.getNetworkType() == 1) {
                DownloadManager.C().d0(f401443a);
                return;
            }
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230);
            createCustomDialog.setTitle((String) null);
            createCustomDialog.setMessage(HardCodeUtil.qqStr(R.string.v2u));
            createCustomDialog.setNegativeButton(HardCodeUtil.qqStr(R.string.j6l), new b()).setPositiveButton(HardCodeUtil.qqStr(R.string.v1b), new DialogInterfaceOnClickListenerC10359a());
            createCustomDialog.show();
            return;
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", c(str));
        intent.putExtra("big_brother_source_key", p62.a.a(40677));
        context.startActivity(intent);
    }

    public static void g(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.putExtra("big_brother_source_key", p62.a.a(40677));
        intent.putExtra(LaunchParam.KEY_REF_ID, p62.a.a(0));
        intent.setData(Uri.parse(e(str)));
    }
}
