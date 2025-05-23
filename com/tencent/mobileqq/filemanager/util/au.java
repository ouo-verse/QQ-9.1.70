package com.tencent.mobileqq.filemanager.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.view.View;
import com.tencent.biz.qui.toast.QUIBottomToast;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SdCardUtil;
import com.tencent.mobileqq.utils.StringUtils;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LoadingUtil;
import cooperation.qzone.QZoneHelper;
import java.io.File;

/* compiled from: P */
/* loaded from: classes12.dex */
public class au {

    /* renamed from: a, reason: collision with root package name */
    private Dialog f209358a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static au f209359a = new au();
    }

    au() {
    }

    public static au g() {
        return a.f209359a;
    }

    private boolean j(Context context, Intent intent) {
        if (InstalledAppListMonitor.queryIntentActivities(context.getPackageManager(), intent, 0).size() <= 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(String str, String str2, Activity activity, String str3, Uri uri) {
        String e16 = g().e(str);
        g().t(activity, FileUtils.copyFile(str2, e16, true));
        g().i();
        QLog.d("SaveToOtherPathHelper", 1, "strFilePath:" + str2 + " copyToSdcardFileTotalPath:" + e16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(final Activity activity, final String str, final String str2) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(SdCardUtil.getSdCardDirectory());
        String str3 = File.separator;
        sb5.append(str3);
        sb5.append(Environment.DIRECTORY_DOWNLOADS);
        sb5.append(str3);
        sb5.append("QQ");
        sb5.append(str3);
        MediaScannerConnection.scanFile(activity, new String[]{sb5.toString()}, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.tencent.mobileqq.filemanager.util.ar
            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public final void onScanCompleted(String str4, Uri uri) {
                au.l(str, str2, activity, str4, uri);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(Activity activity, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        p(activity);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(boolean z16, final Activity activity) {
        if (z16) {
            QUIBottomToast.g(activity, 2, activity.getString(R.string.f1353801a), activity.getString(R.string.f13536019), new View.OnClickListener() { // from class: com.tencent.mobileqq.filemanager.util.at
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    au.this.n(activity, view);
                }
            }, 0).n();
        } else {
            QUIBottomToast.g(activity, 1, activity.getString(R.string.f13535018), "", null, 0).n();
        }
    }

    private void p(Activity activity) {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.setFlags(268435456);
        if (Build.VERSION.SDK_INT >= 26) {
            intent.putExtra("android.provider.extra.INITIAL_URI", Uri.parse("content://com.android.externalstorage.documents/document/primary:Download%2fQQ"));
        }
        if (j(activity, intent)) {
            activity.startActivity(intent);
        } else {
            QUIBottomToast.g(activity, 1, activity.getString(R.string.f1353901b), "", null, 0);
            QLog.e("SaveToOtherPathHelper", 1, "activity not exist\uff0copenQQDownloadDirectory failed!");
        }
    }

    public String e(String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(SdCardUtil.getSdCardDirectory());
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(Environment.DIRECTORY_DOWNLOADS);
        sb5.append(str2);
        sb5.append("QQ");
        sb5.append(str2);
        sb5.append(str);
        String sb6 = sb5.toString();
        if (!new File(sb6).exists()) {
            return sb6;
        }
        int lastIndexOf = sb6.lastIndexOf(".");
        if (lastIndexOf > 0) {
            return f(sb6, lastIndexOf);
        }
        return h(sb6);
    }

    public String f(String str, int i3) {
        String substring = str.substring(0, i3);
        String substring2 = str.substring(i3 + 1);
        String q16 = q(substring);
        String str2 = q16 + "(1)." + substring2;
        int i16 = 1;
        while (new File(str2).exists()) {
            i16++;
            str2 = q16 + "(" + i16 + ")." + substring2;
        }
        return str2;
    }

    public String h(String str) {
        String q16 = q(str);
        String str2 = q16 + ".(1)";
        int i3 = 1;
        while (new File(str2).exists()) {
            i3++;
            str2 = q16 + ".(" + i3 + ")";
        }
        return str2;
    }

    public void i() {
        Dialog dialog = this.f209358a;
        if (dialog != null && dialog.isShowing()) {
            this.f209358a.dismiss();
            this.f209358a = null;
        }
    }

    public boolean k() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("file_menu_save_other_path_switch", true);
    }

    public String q(String str) {
        int lastIndexOf = str.lastIndexOf("(");
        int lastIndexOf2 = str.lastIndexOf(")");
        if (lastIndexOf2 == str.length() - 1 && lastIndexOf >= 0 && lastIndexOf2 >= 0) {
            if (!StringUtils.isNumeric(str.substring(lastIndexOf + 1, lastIndexOf2))) {
                QLog.d("SaveToOtherPathHelper", 1, "repeat index is not numeric!");
                return str;
            }
            return str.substring(0, lastIndexOf);
        }
        QLog.d("SaveToOtherPathHelper", 1, "not need remove repeat file suffix str!");
        return str;
    }

    public void r(final Activity activity, final String str, final String str2, long j3) {
        g().s(activity, j3);
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.aq
            @Override // java.lang.Runnable
            public final void run() {
                au.m(activity, str, str2);
            }
        });
    }

    public void s(Context context, long j3) {
        boolean z16;
        if (j3 > QZoneHelper.Constants.SUPPORT_MIX_MUSIC_DEFAULT) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Dialog showOnlyLoadingImageDialog = LoadingUtil.showOnlyLoadingImageDialog(context, 2, true);
            this.f209358a = showOnlyLoadingImageDialog;
            showOnlyLoadingImageDialog.show();
            return;
        }
        this.f209358a = null;
    }

    public void t(final Activity activity, final boolean z16) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.as
            @Override // java.lang.Runnable
            public final void run() {
                au.this.o(z16, activity);
            }
        });
    }
}
