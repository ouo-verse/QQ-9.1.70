package com.tencent.open.downloadnew;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.ToastUtil;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import java.io.File;
import java.text.DecimalFormat;

/* compiled from: P */
/* loaded from: classes22.dex */
public class YybHandleUtil {

    /* renamed from: a, reason: collision with root package name */
    public static String f341433a = "YybHandleUtil";

    /* renamed from: b, reason: collision with root package name */
    public static String f341434b = "yyb.apk";

    /* renamed from: c, reason: collision with root package name */
    public static final String f341435c = HardCodeUtil.qqStr(R.string.vnt);

    public static String a(int i3) {
        char c16;
        String str;
        if (i3 < 0) {
            return null;
        }
        float f16 = i3;
        float f17 = f16 / 1048576.0f;
        if (f17 > 1.0f) {
            f16 = f17;
            c16 = 2;
        } else {
            float f18 = f16 / 1024.0f;
            if (f18 > 1.0f) {
                f16 = f18;
                c16 = 1;
            } else {
                c16 = 0;
            }
        }
        String format = new DecimalFormat("#.#").format(f16);
        if (c16 == 2) {
            str = "MB";
        } else if (c16 == 1) {
            str = "KB";
        } else {
            str = "B";
        }
        return format + str;
    }

    public static void b() {
        com.tencent.open.base.f.a(f341433a, "---deleteYYBApkPackage--");
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.YybHandleUtil.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                DownloadInfo f16 = com.tencent.open.downloadnew.common.b.g().f(SDKConst.SELF_PACKAGENAME);
                if (f16 != null) {
                    str = f16.L;
                } else {
                    str = "";
                }
                if (!TextUtils.isEmpty(str)) {
                    File file = new File(str);
                    com.tencent.open.base.f.a(YybHandleUtil.f341433a, "---localFilePath = " + str);
                    if (file.exists()) {
                        com.tencent.open.base.f.a(YybHandleUtil.f341433a, "---delete apk ");
                        file.delete();
                    }
                }
            }
        });
    }

    public static boolean c() {
        return com.tencent.open.business.base.a.o(com.tencent.open.adapter.a.f().e(), com.tencent.open.adapter.a.f().e().getFilesDir().getAbsolutePath() + File.separator + f341434b);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class a extends AsyncTask<Void, Long, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        ProgressDialog f341436a;

        /* renamed from: b, reason: collision with root package name */
        Activity f341437b;

        /* renamed from: c, reason: collision with root package name */
        String f341438c;

        public a(Activity activity, String str) {
            this.f341437b = activity;
            this.f341438c = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void a() {
            ProgressDialog progressDialog = this.f341436a;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.f341436a.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            return Boolean.FALSE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            a();
            if (bool.booleanValue()) {
                if (YybHandleUtil.c() && TextUtils.isEmpty(this.f341438c)) {
                    com.tencent.open.business.base.e.d("311", this.f341438c, "1101070898");
                    return;
                }
                return;
            }
            ToastUtil.a().f(HardCodeUtil.qqStr(R.string.vnu), 1);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onCancelled() {
            super.onCancelled();
            a();
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            Activity activity = this.f341437b;
            if (activity != null && !activity.isFinishing()) {
                ReportProgressDialog reportProgressDialog = new ReportProgressDialog(this.f341437b);
                this.f341436a = reportProgressDialog;
                reportProgressDialog.show();
            }
        }

        public a(Activity activity) {
            this.f341437b = activity;
        }
    }
}
