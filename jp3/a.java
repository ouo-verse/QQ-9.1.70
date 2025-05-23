package jp3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.filemanageraux.app.UniformDownload;
import com.tencent.open.appstore.dl.DownloadInfoReport;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a implements ip3.a {
    @Override // ip3.a
    public void a(Activity activity, Bundle bundle) {
        DownloadApi.d(activity, bundle, "biz_src_yyb", null, 0);
    }

    @Override // ip3.a
    public void b(String str, String str2, String str3, String str4, long j3, Activity activity, String str5) {
        Bundle bundle = new Bundle();
        bundle.putLong("_filesize", j3);
        bundle.putString("param_user_agent", str2);
        bundle.putString("param_content_des", str3);
        bundle.putString("param_mime_type", str4);
        bundle.putString("param_refer_url", str5);
        UniformDownload.b(activity, str, bundle);
    }

    @Override // ip3.a
    public void c(Bundle bundle, Activity activity, String str, String str2) {
        if (bundle != null) {
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("qb_info", 0);
            if (sharedPreferences != null) {
                bundle.putString("param_content_memo", sharedPreferences.getString("content_memo", null));
                bundle.putString("param_icon_path", sharedPreferences.getString("icon_url", null));
            }
            bundle.putString("param_user_agent", str2);
            bundle.putString("param_refer_url", str);
            String string = bundle.getString("qb_param_url");
            if (string != null && string.length() != 0) {
                bundle.remove("qb_param_url");
                bundle.putBoolean("param_isqbdownload", true);
                UniformDownload.b(activity, string, bundle);
            }
        }
    }

    @Override // ip3.a
    public void d(Context context, Object obj) {
        if (obj instanceof DownloadInfo) {
            DownloadInfoReport.d(context, (DownloadInfo) obj);
        }
    }

    @Override // ip3.a
    public Object e(Activity activity, AppRuntime appRuntime, Object obj, Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("fromArkAppDownload", false);
        UniformDownload.a aVar = new UniformDownload.a(appRuntime, activity, (TouchWebView) obj);
        aVar.d(booleanExtra);
        return aVar;
    }

    @Override // ip3.a
    public void f(String str, String str2, boolean z16) {
        DownloadApi.a(str, str2, z16);
    }

    @Override // ip3.a
    public Object g(String str) {
        return DownloadManager.C().w(str);
    }

    @Override // ip3.a
    public boolean h(String str) {
        return DownloadApi.j(str);
    }
}
