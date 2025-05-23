package com.tencent.mobileqq.tbstool.fileview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filebrowser.FileBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.reader.TbsReaderView;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f291435a;

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap<String, String> f291436b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f291437c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31393);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f291435a = false;
        f291436b = new HashMap<>();
        f291437c = false;
    }

    public static void a(Context context, Bundle bundle, String str, TbsReaderView tbsReaderView) {
        if (bundle == null) {
            QLog.e("TBSViewManagerUtil", 1, "downloadQQBrowser params null!");
            return;
        }
        HashMap<String, String> hashMap = f291436b;
        hashMap.put("stat_download_start", bundle.getString("stat_download_start", ""));
        hashMap.put("stat_download_downloading", bundle.getString("stat_download_downloading", ""));
        hashMap.put("stat_download_success", bundle.getString("stat_download_success", ""));
        hashMap.put("stat_download_failed", bundle.getString("stat_download_failed", ""));
        hashMap.put("stat_download_installed_success", bundle.getString("stat_download_installed_success", ""));
        hashMap.put("stat_open_qb_success", bundle.getString("stat_open_qb_success", ""));
        String string = bundle.getString("download_url", "");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if (((IUniformDownloadMgr) peekAppRuntime.getRuntimeService(IUniformDownloadMgr.class, "")).isExistedDownloadOfUrl(string)) {
            QLog.w("TBSViewManagerUtil", 1, "downloadQQBrowser isExistedDownloadOfUrl show toast!");
            QQToast.makeText(context, 0, R.string.f187703up, 0).show();
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(IUniformDownloadMgr.OPEN_WITH_QQBROWSER, str);
        bundle2.putBoolean("tbs_new_report", true);
        b(context, string, bundle2);
        e("stat_download_start", tbsReaderView);
    }

    private static void b(Context context, String str, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putString("big_brother_source_key", "biz_src_jc_file");
        Bundle bundle3 = new Bundle();
        bundle3.putString(IUniformDownloadMgr.FILENAME_FROM_DIALOG, context.getString(R.string.cm9));
        bundle3.putString("big_brother_source_key", "biz_src_jc_file");
        bundle3.putString(IUniformDownloadMgr.DOWNLOAD_BIG_BROTHER_SOURCE, "biz_src_jc_file");
        bundle3.putBundle(IUniformDownloadMgr.FILE_BUNDLE_USERDATA, bundle2);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IUniformDownloadMgr iUniformDownloadMgr = (IUniformDownloadMgr) peekAppRuntime.getRuntimeService(IUniformDownloadMgr.class, "all");
        if (iUniformDownloadMgr.getApp() == null) {
            Intent intent = new Intent(IUniformDownloadMgr.UNIDOWNLOAD_BORDCAST);
            intent.putExtra("param", bundle3);
            intent.putExtra("url", str);
            context.sendBroadcast(intent);
            QLog.i("TBSViewManagerUtil", 1, "app is null try sendBroadcast!");
            return;
        }
        iUniformDownloadMgr.startDownloadNoSzie(str, bundle3);
        QLog.i("TBSViewManagerUtil", 1, "downloadQQBrowser:" + str);
    }

    public static Bundle c(Activity activity, String str, long j3) {
        Bundle bundle = new Bundle();
        bundle.putString("filePath", str);
        String defaultRecvPath = lc1.b.a().getDefaultRecvPath();
        File file = new File(defaultRecvPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (QLog.isColorLevel()) {
            QLog.i("TBSViewManagerUtil", 1, "getTbsFileReaderOpenParams: barSwitch[" + f291435a + "]");
        }
        if (i(activity)) {
            bundle.putBoolean("enable_cquatre", com.tencent.mobileqq.tbstool.gray.b.f291450a.g(str));
            bundle.putLong("fileId", j3);
        }
        String stringExtra = activity.getIntent().getStringExtra("file_browser_extra_tbs_tool_action");
        if (!TextUtils.isEmpty(stringExtra)) {
            bundle.putString("action", stringExtra);
        }
        bundle.putString("tempPath", defaultRecvPath);
        bundle.putBoolean(TbsReaderView.FILE_READER_HIDE_TOOLBAR, !f291435a);
        bundle.putInt(TbsReaderView.FILE_READER_DOWNLOAD_TYPE, 1);
        bundle.putString("reader_tokenid", "Y29tLnRlbmNlbnQubW9iaWxlcXE=");
        bundle.putString("reader_pkgname", "com.tencent.mobileqq");
        bundle.putBoolean("file_reader_click_action_disable", true);
        bundle.putInt("style", 2);
        bundle.putInt(TbsReaderView.FILE_READER_BG_CONTENT_COLOR, -1);
        bundle.putBoolean("file_reader_add_view_to_toolbar", f291437c);
        bundle.putString("big_brother_source_key", "biz_src_jc_file");
        bundle.putBoolean("file_is_night_theme", QQTheme.isNowThemeIsNight());
        return bundle;
    }

    public static void d(Context context, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800AF73", "0X800AF73", 0, 0, "", "", "", "");
        Intent intent = (Intent) bundle.getParcelable("file_open_intent");
        if (intent != null) {
            intent.putExtra("big_brother_source_key", "biz_src_jc_file");
            context.startActivity(intent);
        }
    }

    public static void e(String str, TbsReaderView tbsReaderView) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = f291436b.get(str);
        QLog.i("TBSViewManagerUtil", 1, "reportQQBrowserDownloadEvent: reportType[" + str + "]");
        if (tbsReaderView != null && !TextUtils.isEmpty(str2)) {
            tbsReaderView.userStatistics(str2);
        }
        if (str.equals("stat_download_success")) {
            ReportController.o(null, "dc00898", "", "", "0X800AF76", "0X800AF76", 0, 0, "", "", "", "");
        } else if (str.equals("stat_open_qb_success")) {
            ReportController.o(null, "dc00898", "", "", "0X800AF73", "0X800AF73", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(boolean z16, boolean z17) {
        int i3;
        if (z16) {
            ReportController.o(null, "dc00898", "", "", "0X800B00B", "0X800B00B", 0, 0, "", "", "", "");
            return;
        }
        if (z17) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        ReportController.o(null, "dc00898", "", "", "0X800B00C", "0X800B00C", i3, 0, "", "", "", "");
    }

    public static void g(boolean z16) {
        f291437c = z16;
    }

    public static void h(boolean z16) {
        f291435a = z16;
    }

    private static boolean i(Activity activity) {
        if ((activity instanceof FileBrowserActivity) || activity.getClass().getName().equals("com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity") || activity.getClass().getName().equals("com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity")) {
            return true;
        }
        return false;
    }
}
