package com.tencent.open.filedownload.ui;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.base.f;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.filedownload.a;
import com.tencent.open.filedownload.b;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SafeDownloadButton extends ApkFileDownloadButton {
    private static final String M = HardCodeUtil.qqStr(R.string.f172653t34);
    private static final String N = HardCodeUtil.qqStr(R.string.t37);
    private b I;
    private boolean J;
    private boolean K;
    private long L;

    public SafeDownloadButton(Context context) {
        this(context, null);
    }

    private String F() {
        try {
            return "tmast://download?downl_url=" + URLEncoder.encode(this.I.f341566e, "UTF-8") + "&down_ticket=" + URLEncoder.encode(this.I.f341566e, "UTF-8") + "&oplist=1;2&via=" + this.I.f341565d;
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        String F = F();
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.setData(Uri.parse(F));
        intent.addFlags(268435456);
        try {
            BaseApplication.getContext().startActivity(intent);
            f.e("SafeDownloadButton_", "goToYYBByTmast success! jumpUrl=" + F);
        } catch (ActivityNotFoundException e16) {
            f.c("SafeDownloadButton_", "ActivityNotFoundException e=" + e16.getMessage());
        }
    }

    private void H() {
        b bVar = this.I;
        if (bVar != null && !TextUtils.isEmpty(bVar.f341566e)) {
            AppCenterReporter.o(com.tencent.open.appstore.report.b.u().v("200").n(this.I.f341562a).l(this.I.f341563b).o(this.I.f341564c).t(this.I.f341565d).i(this.I.f341570i).m(this.I.f341567f).r(this.I.f341566e));
            QQAppInterface qQAppInterface = ((BaseActivity) getContext()).app;
            String str = this.C.f341570i;
            if (str == null) {
                str = "";
            }
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X8009AC4", "0X8009AC4", 0, 0, "1", "", str, "");
            G();
        }
    }

    private void J() {
        String F = F();
        Bundle bundle = new Bundle();
        bundle.putString("url", F);
        DownloadApi.p(bundle);
        DownloadApi.q(bundle);
        f.e("SafeDownloadButton_", "writeTmastCmd success! jumpUrl=" + F);
    }

    public void I() {
        long currentTimeMillis = System.currentTimeMillis();
        f.e("SafeDownloadButton_", "onResume " + this.K + ",currentTimestamp=" + currentTimeMillis + ",mYYBInstallSuccessTimestamp= " + this.L);
        if (this.K) {
            if (currentTimeMillis - this.L < 5000) {
                G();
            }
            this.K = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.open.filedownload.ui.ApkFileDownloadButton
    public void e() {
        this.J = true;
        J();
        super.e();
    }

    @Override // com.tencent.open.filedownload.ui.ApkFileDownloadButton
    protected String f(int i3) {
        if (i3 == 4) {
            return HardCodeUtil.qqStr(R.string.t38);
        }
        return HardCodeUtil.qqStr(R.string.f172654t35);
    }

    @Override // com.tencent.open.filedownload.ui.ApkFileDownloadButton
    protected String g(int i3) {
        if (i3 == 1) {
            return M;
        }
        return N;
    }

    @Override // com.tencent.open.filedownload.ui.ApkFileDownloadButton
    protected String h() {
        return HardCodeUtil.qqStr(R.string.t39);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.open.filedownload.ui.ApkFileDownloadButton
    public void m(DownloadInfo downloadInfo) {
        this.J = true;
        J();
        super.m(downloadInfo);
    }

    @Override // com.tencent.open.filedownload.ui.ApkFileDownloadButton
    protected void n(String str) {
        if (TextUtils.equals(str, SDKConst.SELF_PACKAGENAME)) {
            f.e("SafeDownloadButton_", HardCodeUtil.qqStr(R.string.t36) + this.J);
            if (this.J) {
                this.K = true;
                this.L = System.currentTimeMillis();
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.filedownload.ui.SafeDownloadButton.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SafeDownloadButton.this.t();
                        SafeDownloadButton.this.G();
                    }
                });
            }
        }
    }

    @Override // com.tencent.open.filedownload.ui.ApkFileDownloadButton
    protected void o(String str, boolean z16) {
        if (z16) {
            if ("900".equals(str) || IndividuationPlugin.Business_Pendant.equals(str)) {
                QQAppInterface qQAppInterface = ((BaseActivity) getContext()).app;
                String str2 = this.C.f341570i;
                if (str2 == null) {
                    str2 = "";
                }
                ReportController.o(qQAppInterface, "dc00898", "", "", "0X8009AC4", "0X8009AC4", 0, 0, "2", "", str2, "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.open.filedownload.ui.ApkFileDownloadButton
    public void p(boolean z16) {
        if (a.d()) {
            this.C.f341572k = 1;
            D();
            H();
            return;
        }
        super.p(z16);
    }

    public void setOriApkInfo(b bVar) {
        this.I = b.a(bVar);
    }

    public SafeDownloadButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SafeDownloadButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.J = false;
        this.K = false;
        this.L = 0L;
    }
}
