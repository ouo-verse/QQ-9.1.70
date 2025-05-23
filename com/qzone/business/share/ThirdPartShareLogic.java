package com.qzone.business.share;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.event.EventCenter;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* loaded from: classes39.dex */
public class ThirdPartShareLogic {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f44747a;

    /* renamed from: b, reason: collision with root package name */
    private com.qzone.business.share.h f44748b = null;

    /* renamed from: c, reason: collision with root package name */
    private ProgressDialog f44749c = null;

    /* renamed from: d, reason: collision with root package name */
    private QQCustomDialog f44750d = null;

    /* renamed from: e, reason: collision with root package name */
    public String f44751e = null;

    /* renamed from: f, reason: collision with root package name */
    private boolean f44752f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f44753g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f44754h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f44755i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f44756j = true;

    /* renamed from: k, reason: collision with root package name */
    private boolean f44757k = true;

    /* renamed from: l, reason: collision with root package name */
    private Intent f44758l;

    /* renamed from: m, reason: collision with root package name */
    public QZoneShareManager.ShareResultCallBack f44759m;

    /* renamed from: n, reason: collision with root package name */
    protected Handler f44760n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements DialogInterface.OnCancelListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppRuntime f44766d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f44767e;

        b(AppRuntime appRuntime, Activity activity) {
            this.f44766d = appRuntime;
            this.f44767e = activity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
            AppRuntime appRuntime = this.f44766d;
            statisticCollector.reportActionCountCliOper(appRuntime, appRuntime.getAccount(), "", "multi_account", "click_cancel", 0, 1, 0);
            Activity activity = this.f44767e;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            ForwardSdkBaseOption.G(this.f44767e, ThirdPartShareLogic.this.s(), ThirdPartShareLogic.this.f44752f);
            this.f44767e.setResult(0);
            this.f44767e.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class g implements DialogInterface.OnCancelListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f44775d;

        g(Activity activity) {
            this.f44775d = activity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            ForwardSdkBaseOption.G(this.f44775d, ThirdPartShareLogic.this.s(), ThirdPartShareLogic.this.f44752f);
            Activity activity = this.f44775d;
            if (activity != null) {
                activity.setResult(0);
                this.f44775d.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class h implements DialogInterface.OnDismissListener {
        h() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ThirdPartShareLogic.this.f44753g = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class j implements DialogInterface.OnCancelListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f44782d;

        j(Activity activity) {
            this.f44782d = activity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Activity activity = this.f44782d;
            if (activity != null) {
                activity.setResult(0);
                this.f44782d.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity r() {
        WeakReference<Activity> weakReference = this.f44747a;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.f44747a.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent s() {
        return this.f44758l;
    }

    private void u() {
        if (this.f44760n == null) {
            this.f44760n = new e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.f44759m == null) {
            this.f44759m = new d();
        }
    }

    public void A(Intent intent) {
        this.f44758l = intent;
    }

    protected final void B(Activity activity, AppRuntime appRuntime) {
        QQCustomDialog qQCustomDialog = this.f44750d;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
            this.f44750d = null;
        }
        a aVar = new a(appRuntime, activity);
        b bVar = new b(appRuntime, activity);
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230);
        this.f44750d = createCustomDialog;
        createCustomDialog.setMessage(R.string.d65);
        this.f44750d.setTitle(R.string.b1v);
        this.f44750d.setNegativeButton(R.string.cancel, aVar);
        this.f44750d.setPositiveButton(R.string.hin, aVar);
        this.f44750d.setOnCancelListener(bVar);
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            this.f44750d.show();
        } catch (Exception e16) {
            QZLog.e("QZoneFriendFeedActivity", e16.toString());
        }
    }

    protected final void C(String str, boolean z16, int i3, String str2) {
        Activity r16 = r();
        if (r16 == null) {
            return;
        }
        com.qzone.business.share.h hVar = this.f44748b;
        if (hVar != null) {
            hVar.dismiss();
            this.f44748b = null;
        }
        ProgressDialog progressDialog = this.f44749c;
        if (progressDialog != null) {
            progressDialog.dismiss();
            this.f44749c = null;
        }
        this.f44752f = z16;
        i iVar = new i(z16, r16, str);
        j jVar = new j(r16);
        this.f44748b = new com.qzone.business.share.h(r16);
        if (z16) {
            Object[] objArr = new Object[1];
            if (str == null) {
                str = "";
            }
            objArr[0] = str;
            String string = r16.getString(R.string.hj5, objArr);
            String string2 = r16.getString(R.string.hj7);
            this.f44748b.N(string, iVar);
            this.f44748b.Q(r16, R.drawable.clm, R.string.hik);
            this.f44748b.P(null);
            this.f44748b.O(string2, iVar);
        } else {
            String string3 = r16.getString(R.string.hj5, "");
            String string4 = r16.getString(R.string.hj6);
            this.f44748b.N(string3, iVar);
            this.f44748b.Q(r16, 0, R.string.hij);
            this.f44748b.O(string4, iVar);
            this.f44748b.setOnCancelListener(jVar);
            if (i3 == -1) {
                str2 = r16.getString(R.string.go7);
            } else if (TextUtils.isEmpty(str2)) {
                str2 = r16.getString(R.string.goa);
            }
            this.f44748b.P(r16.getString(R.string.go6, str2, Integer.valueOf(i3)));
        }
        try {
            this.f44748b.show();
        } catch (Exception e16) {
            QZLog.e("QZoneFriendFeedActivity", e16.toString());
        }
    }

    public void m() {
        Activity r16 = r();
        if (r16 == null) {
            return;
        }
        ForwardSdkBaseOption.G(r16, s(), false);
        r16.setResult(0);
        r16.finish();
    }

    protected final void n(Activity activity, Intent intent, QZoneShareManager.ShareResultCallBack shareResultCallBack) {
        if (this.f44753g) {
            return;
        }
        this.f44753g = true;
        f fVar = new f(activity, shareResultCallBack);
        g gVar = new g(activity);
        Bundle bundleExtra = intent.getBundleExtra(QZoneShareManager.KEY_SAHRE_DATA);
        this.f44751e = null;
        if (bundleExtra != null) {
            QQCustomDialogWtihEmoticonInput b16 = com.qzone.business.share.e.b(activity, bundleExtra, fVar, fVar, gVar);
            b16.setOnDismissListener(new h());
            if (activity.isFinishing()) {
                return;
            }
            try {
                b16.show();
                return;
            } catch (Exception e16) {
                QZLog.e("QZoneFriendFeedActivity", e16.toString());
                return;
            }
        }
        QZLog.e(QZLog.TO_DEVICE_TAG, "createQzoneShareConfirmDialg params is NULL----------------");
    }

    public void p() {
        if (this.f44755i) {
            this.f44754h = true;
            Handler handler = this.f44760n;
            if (handler != null) {
                handler.removeMessages(QZoneShareManager.MSG_QZONE_SHARE_LATER_CREATE_DIALOG);
                this.f44760n.removeMessages(QZoneShareManager.MSG_QZONE_SHARE_OPEN_ID_OK);
                this.f44760n.removeMessages(QZoneShareManager.MSG_QZONE_SHARE_UPLOAD_IMAGE_SKEY_ERROR);
                this.f44760n.removeMessages(999908);
                this.f44760n.removeMessages(QZoneShareManager.MSG_QZONE_SHARE_IMAGE_UPLOAD_OK);
            }
            com.qzone.business.share.h hVar = this.f44748b;
            if (hVar != null) {
                hVar.dismiss();
                this.f44748b = null;
            }
            ProgressDialog progressDialog = this.f44749c;
            if (progressDialog != null) {
                progressDialog.dismiss();
                this.f44749c = null;
            }
        }
    }

    public void q() {
        if (this.f44755i) {
            Activity r16 = r();
            if (r16 != null) {
                if (this.f44752f) {
                    r16.setResult(-1);
                } else {
                    r16.setResult(0);
                }
            }
            ForwardSdkBaseOption.G(r(), s(), this.f44752f);
        }
    }

    public boolean t() {
        return this.f44756j;
    }

    public void y() {
        com.qzone.business.share.h hVar;
        if (this.f44755i && this.f44752f && (hVar = this.f44748b) != null) {
            hVar.dismiss();
            this.f44748b = null;
        }
    }

    public void z(boolean z16) {
        this.f44756j = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class e extends Handler {
        e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            if (message == null || ThirdPartShareLogic.this.f44754h) {
                return;
            }
            int i3 = message.what;
            if (i3 == 999908) {
                if (ThirdPartShareLogic.this.f44749c != null) {
                    ThirdPartShareLogic.this.f44749c.dismiss();
                    ThirdPartShareLogic.this.f44749c = null;
                }
                QZoneResult unpack = QZoneResult.unpack(message);
                r2 = unpack != null ? unpack.getSucceed() : false;
                if (r2) {
                    EventCenter.getInstance().post("Feed", 14);
                }
                QZoneShareManager.ShareResultCallBack shareResultCallBack = ThirdPartShareLogic.this.f44759m;
                if (shareResultCallBack == null || unpack == null) {
                    return;
                }
                shareResultCallBack.onShareResult(r2, unpack.getReturnCode(), unpack.getMessage());
                return;
            }
            switch (i3) {
                case QZoneShareManager.MSG_QZONE_SHARE_IMAGE_UPLOAD_OK /* 55555 */:
                    ThirdPartShareLogic thirdPartShareLogic = ThirdPartShareLogic.this;
                    Intent s16 = thirdPartShareLogic.s();
                    ThirdPartShareLogic thirdPartShareLogic2 = ThirdPartShareLogic.this;
                    thirdPartShareLogic.D(s16, thirdPartShareLogic2.f44751e, thirdPartShareLogic2.f44759m);
                    return;
                case QZoneShareManager.MSG_QZONE_SHARE_LATER_CREATE_DIALOG /* 55556 */:
                    Handler handler = ThirdPartShareLogic.this.f44760n;
                    if (handler != null) {
                        handler.removeMessages(QZoneShareManager.MSG_QZONE_SHARE_OPEN_ID_OK);
                    }
                    ThirdPartShareLogic.this.o(false);
                    return;
                case QZoneShareManager.MSG_QZONE_SHARE_OPEN_ID_OK /* 55557 */:
                    Handler handler2 = ThirdPartShareLogic.this.f44760n;
                    if (handler2 != null) {
                        handler2.removeMessages(QZoneShareManager.MSG_QZONE_SHARE_LATER_CREATE_DIALOG);
                    }
                    Object obj = message.obj;
                    if (obj instanceof OpenID) {
                        OpenID openID = (OpenID) obj;
                        Bundle bundleExtra = ThirdPartShareLogic.this.s().getBundleExtra(QZoneShareManager.KEY_SAHRE_DATA);
                        if (bundleExtra != null) {
                            String string = bundleExtra.getString("open_id");
                            if (!TextUtils.isEmpty(string)) {
                                r2 = !string.equals(openID.openID);
                            }
                        }
                    }
                    ThirdPartShareLogic.this.o(r2);
                    return;
                case QZoneShareManager.MSG_QZONE_SHARE_UPLOAD_IMAGE_SKEY_ERROR /* 55558 */:
                    Bundle bundleExtra2 = ThirdPartShareLogic.this.s().getBundleExtra(QZoneShareManager.KEY_SAHRE_DATA);
                    if (bundleExtra2 != null) {
                        str = bundleExtra2.getString("app_name");
                    } else {
                        str = "";
                    }
                    int i16 = QZoneShareManager.QZONE_UPLOAD_FAIL_RESULT_CODE;
                    if (i16 != 0) {
                        ThirdPartShareLogic.this.C(str, false, i16, QZoneShareManager.QZONE_UPLOAD_FAIL_RESULT_TEXT);
                        return;
                    } else {
                        ThirdPartShareLogic.this.C(str, false, -2, QZoneShareManager.QZONE_UPLOAD_FAIL_RESULT_TEXT);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c implements BusinessObserver {
        c() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (i3 == 1 && (obj instanceof OpenID)) {
                Handler handler = ThirdPartShareLogic.this.f44760n;
                if (handler != null) {
                    Message obtainMessage = handler.obtainMessage(QZoneShareManager.MSG_QZONE_SHARE_OPEN_ID_OK);
                    obtainMessage.obj = obj;
                    ThirdPartShareLogic.this.f44760n.sendMessage(obtainMessage);
                }
            }
        }
    }

    protected void o(boolean z16) {
        if (z16) {
            B(r(), LoginData.getInstance().getQZoneRuntime());
            return;
        }
        QQCustomDialog qQCustomDialog = this.f44750d;
        if (qQCustomDialog == null || !qQCustomDialog.isShowing()) {
            Intent s16 = s();
            v();
            n(r(), s16, this.f44759m);
            ReportController.o(null, "P_CliOper", "qqconnect", "", "connect_share2qzone", "pageview", 0, 0, String.valueOf(QZoneShareManager.getShareAppId(s())), "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class d implements QZoneShareManager.ShareResultCallBack {
        d() {
        }

        @Override // cooperation.qzone.QZoneShareManager.ShareResultCallBack
        public void onShareResult(boolean z16, int i3, String str) {
            String str2;
            String str3;
            Bundle bundleExtra = ThirdPartShareLogic.this.s().getBundleExtra(QZoneShareManager.KEY_SAHRE_DATA);
            String str4 = "";
            if (bundleExtra == null) {
                str2 = "";
            } else {
                str2 = bundleExtra.getString("app_name");
            }
            if (!ThirdPartShareLogic.this.f44754h) {
                ThirdPartShareLogic.this.C(str2, z16, i3, str);
            }
            int i16 = !z16 ? 1 : 0;
            try {
                com.tencent.open.business.viareport.c a16 = com.tencent.open.business.viareport.c.a();
                if (bundleExtra == null) {
                    str3 = "";
                } else {
                    str3 = bundleExtra.getString("share_uin");
                }
                if (bundleExtra != null) {
                    str4 = String.valueOf(bundleExtra.getLong("req_share_id", 0L));
                }
                a16.b(i16, "SHARE_TO_QZONE", str3, str4, "4", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
            } catch (Exception e16) {
                QZLog.w(e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class i implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f44778d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f44779e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f44780f;

        i(boolean z16, Activity activity, String str) {
            this.f44778d = z16;
            this.f44779e = activity;
            this.f44780f = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 != -2) {
                if (i3 != -1) {
                    return;
                }
                if (this.f44778d) {
                    if (ThirdPartShareLogic.this.f44755i) {
                        ReportCenter.f().p(String.valueOf(LoginData.getInstance().getUin()), "", String.valueOf(QZoneShareManager.getShareAppId(ThirdPartShareLogic.this.s())), "1000", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE, "0", false);
                    }
                    ReportController.o(null, "P_CliOper", "qqconnect", "", "connect_share2qzone", "choose", 0, 0, String.valueOf(QZoneShareManager.getShareAppId(ThirdPartShareLogic.this.s())), QCircleDaTongConstant.ElementParamValue.STAY, "", "");
                    return;
                } else {
                    if (NetworkState.isNetSupport()) {
                        Intent s16 = ThirdPartShareLogic.this.s();
                        if (s16 != null) {
                            ThirdPartShareLogic.this.v();
                            ThirdPartShareLogic thirdPartShareLogic = ThirdPartShareLogic.this;
                            thirdPartShareLogic.D(s16, thirdPartShareLogic.f44751e, thirdPartShareLogic.f44759m);
                            return;
                        } else {
                            this.f44779e.setResult(0);
                            this.f44779e.finish();
                            return;
                        }
                    }
                    ThirdPartShareLogic thirdPartShareLogic2 = ThirdPartShareLogic.this;
                    String str = this.f44780f;
                    thirdPartShareLogic2.C(str != null ? str : "", false, -1, null);
                    return;
                }
            }
            if (ThirdPartShareLogic.this.f44755i) {
                ReportCenter.f().p(String.valueOf(LoginData.getInstance().getUin()), "", String.valueOf(QZoneShareManager.getShareAppId(ThirdPartShareLogic.this.s())), "1000", "51", "0", false);
            }
            ForwardSdkBaseOption.G(ThirdPartShareLogic.this.r(), ThirdPartShareLogic.this.s(), this.f44778d);
            if (this.f44778d) {
                ReportController.o(null, "P_CliOper", "qqconnect", "", "connect_share2qzone", "choose", 0, 0, String.valueOf(QZoneShareManager.getShareAppId(ThirdPartShareLogic.this.s())), "back", "", "");
            }
            if (this.f44778d) {
                this.f44779e.setResult(-1);
            } else {
                this.f44779e.setResult(0);
            }
            if (ThirdPartShareLogic.this.s() != null && ThirdPartShareLogic.this.s().getBundleExtra(QZoneShareManager.KEY_SAHRE_DATA) != null && ThirdPartShareLogic.this.s().getBundleExtra(QZoneShareManager.KEY_SAHRE_DATA).getBoolean(QZoneShareManager.QZONE_SHARE_FROM_WEB) && ThirdPartShareLogic.this.f44757k) {
                String string = ThirdPartShareLogic.this.s().getBundleExtra(QZoneShareManager.KEY_SAHRE_DATA).getString("detail_url");
                if (!TextUtils.isEmpty(string)) {
                    yo.g gVar = new yo.g("", "");
                    gVar.f450709b = string;
                    gVar.m(ThirdPartShareLogic.this.r());
                    return;
                }
                this.f44779e.finish();
                return;
            }
            this.f44779e.finish();
        }
    }

    public static boolean x(Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.getBooleanExtra(QZoneShareManager.KEY_IS_THIRDPARTYSHARE, false);
    }

    public void D(Intent intent, String str, QZoneShareManager.ShareResultCallBack shareResultCallBack) {
        long j3;
        if (intent == null) {
            return;
        }
        ProgressDialog progressDialog = this.f44749c;
        if (progressDialog != null) {
            progressDialog.dismiss();
            this.f44749c = null;
        }
        try {
            this.f44749c = DialogUtil.showProgressDialog(r(), R.string.go9);
        } catch (Exception e16) {
            QZLog.e("QZoneFriendFeedActivity", e16.toString());
        }
        try {
            j3 = Long.parseLong(intent.getStringExtra("uin"));
        } catch (NumberFormatException e17) {
            e17.printStackTrace();
            j3 = 0;
        }
        final Bundle bundleExtra = intent.getBundleExtra(QZoneShareManager.KEY_SAHRE_DATA);
        if (bundleExtra == null) {
            return;
        }
        long j16 = bundleExtra.getLong("req_share_id", 0L);
        String string = bundleExtra.getString("app_name");
        String string2 = bundleExtra.getString("title");
        String string3 = bundleExtra.getString("desc");
        String string4 = bundleExtra.getString("detail_url");
        String string5 = bundleExtra.getString(AppConstants.Key.SHARE_REQ_EXT_STR);
        ArrayList<String> stringArrayList = bundleExtra.getStringArrayList("image_url");
        int i3 = bundleExtra.getInt(AppConstants.Key.SHARE_REQ_URL_INFO_FROM, -1);
        boolean z16 = stringArrayList == null || stringArrayList.size() <= 0 || HttpUtil.isValidUrl(stringArrayList.get(0));
        if (!NetworkState.isNetSupport()) {
            C(string, false, -1, null);
            return;
        }
        if (z16) {
            u();
            QZoneWriteOperationService.v0().h0(string, string4, QZoneShareManager.THIRD_PART_SHARE_APPID, j3, string2, string3, str, stringArrayList, null, j16, string5, i3, this.f44760n);
        } else if (this.f44755i) {
            final String stringExtra = intent.getStringExtra("uin");
            u();
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.business.share.ThirdPartShareLogic.2
                @Override // java.lang.Runnable
                public void run() {
                    Message obtainMessage;
                    ArrayList<String> arrayList = new ArrayList<>();
                    Bundle bundle = bundleExtra;
                    if (bundle != null) {
                        arrayList = bundle.getStringArrayList("image_url");
                    }
                    ArrayList arrayList2 = new ArrayList(arrayList);
                    ArrayList<String> batchUploadImages = QZoneShareManager.batchUploadImages(arrayList, stringExtra, "1");
                    if (batchUploadImages.equals(arrayList2)) {
                        obtainMessage = ThirdPartShareLogic.this.f44760n.obtainMessage(QZoneShareManager.MSG_QZONE_SHARE_UPLOAD_IMAGE_SKEY_ERROR);
                    } else {
                        obtainMessage = ThirdPartShareLogic.this.f44760n.obtainMessage(QZoneShareManager.MSG_QZONE_SHARE_IMAGE_UPLOAD_OK);
                    }
                    Bundle bundle2 = bundleExtra;
                    if (bundle2 != null) {
                        bundle2.putStringArrayList("image_url", batchUploadImages);
                        Intent s16 = ThirdPartShareLogic.this.s();
                        if (s16 != null) {
                            s16.putExtra(QZoneShareManager.KEY_SAHRE_DATA, bundleExtra);
                        }
                    }
                    ThirdPartShareLogic.this.f44760n.sendMessage(obtainMessage);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class f implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f44772d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QZoneShareManager.ShareResultCallBack f44773e;

        f(Activity activity, QZoneShareManager.ShareResultCallBack shareResultCallBack) {
            this.f44772d = activity;
            this.f44773e = shareResultCallBack;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            String str;
            String str2;
            String str3;
            if (i3 != 0) {
                if (i3 == 1 && (dialogInterface instanceof QQCustomDialogWtihEmoticonInput)) {
                    QQCustomDialogWtihEmoticonInput qQCustomDialogWtihEmoticonInput = (QQCustomDialogWtihEmoticonInput) dialogInterface;
                    Intent s16 = ThirdPartShareLogic.this.s();
                    Bundle bundleExtra = s16.getBundleExtra(QZoneShareManager.KEY_SAHRE_DATA);
                    if (bundleExtra == null) {
                        str = "";
                        str2 = str;
                    } else {
                        str = bundleExtra.getString("app_name");
                        str2 = bundleExtra.getString(AppConstants.Key.SHARE_REQ_BIZNAME);
                        if (bundleExtra.getBoolean(IPublicAccountDetailActivity.FROMADCARD, false)) {
                            String string = bundleExtra.getString(IPublicAccountJavascriptInterface.KEY_PUB_UIN);
                            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, string == null ? "" : string, "0X8005A2C", "0X8005A2C", 0, 0, "", "", "", "", false);
                        }
                        if (bundleExtra.getBoolean(QZoneShareManager.QZONE_SHARE_FROM_WEB, false)) {
                            String string2 = bundleExtra.getString("struct_uin");
                            String str4 = string2 == null ? "" : string2;
                            String string3 = bundleExtra.getString("struct_url");
                            if (string3 == null) {
                                string3 = "";
                            }
                            String string4 = bundleExtra.getString("strurt_msgid");
                            String str5 = string4 == null ? "" : string4;
                            String articleId = ((IPublicAccountDetailActivity) QRoute.api(IPublicAccountDetailActivity.class)).getArticleId(string3);
                            String string5 = bundleExtra.getString("source_puin");
                            if (string5 != null && !"".equals(string5)) {
                                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005B07", "0X8005B07", 1002, 0, string5, str5, string3, articleId, false);
                            } else {
                                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X80059DC", "0X80059DC", 1002, 0, str4, str5, string3, articleId, false);
                            }
                        }
                    }
                    if (!NetworkState.isNetSupport()) {
                        ThirdPartShareLogic.this.C(str, false, -1, null);
                        return;
                    }
                    ThirdPartShareLogic.this.f44751e = com.qzone.business.share.e.d(qQCustomDialogWtihEmoticonInput.j0());
                    if (str2 != null && str2.equals("JoinTroopLink") && bundleExtra != null && ((str3 = ThirdPartShareLogic.this.f44751e) == null || str3.equals(""))) {
                        ThirdPartShareLogic.this.f44751e = bundleExtra.getString(AppConstants.Key.SHARE_REQ_TROOP_WORDING);
                    }
                    if (ThirdPartShareLogic.this.f44755i) {
                        ReportCenter.f().p(String.valueOf(LoginData.getInstance().getUin()), "", String.valueOf(QZoneShareManager.getShareAppId(ThirdPartShareLogic.this.s())), "1000", "60", "0", false);
                    }
                    if (str2 != null && str2.equals(AppConstants.SHARE_REQ_BIZNAME_STAR_BLESS_LINK)) {
                        ReportController.o(null, "CliOper", "", "", "0X8005404", "0X8005404", 0, 0, "", "", "", "");
                    }
                    ThirdPartShareLogic thirdPartShareLogic = ThirdPartShareLogic.this;
                    thirdPartShareLogic.D(s16, thirdPartShareLogic.f44751e, this.f44773e);
                    ReportController.o(null, "P_CliOper", "qqconnect", "", "connect_share2qzone", "send", 0, 0, String.valueOf(QZoneShareManager.getShareAppId(s16)), "", "", "");
                    return;
                }
                return;
            }
            ForwardSdkBaseOption.G(this.f44772d, ThirdPartShareLogic.this.s(), ThirdPartShareLogic.this.f44752f);
            dialogInterface.dismiss();
            Activity activity = this.f44772d;
            if (activity != null) {
                activity.setResult(0);
                if (ThirdPartShareLogic.this.s() != null && ThirdPartShareLogic.this.s().getBundleExtra(QZoneShareManager.KEY_SAHRE_DATA) != null && ThirdPartShareLogic.this.s().getBundleExtra(QZoneShareManager.KEY_SAHRE_DATA).getBoolean(QZoneShareManager.QZONE_SHARE_FROM_WEB) && ThirdPartShareLogic.this.f44757k) {
                    String string6 = ThirdPartShareLogic.this.s().getBundleExtra(QZoneShareManager.KEY_SAHRE_DATA).getString("detail_url");
                    if (!TextUtils.isEmpty(string6)) {
                        yo.g gVar = new yo.g("", "");
                        gVar.f450709b = string6;
                        gVar.m(ThirdPartShareLogic.this.r());
                        return;
                    }
                    this.f44772d.finish();
                    return;
                }
                this.f44772d.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppRuntime f44763d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f44764e;

        a(AppRuntime appRuntime, Activity activity) {
            this.f44763d = appRuntime;
            this.f44764e = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    return;
                }
                if (ThirdPartShareLogic.this.f44750d != null) {
                    ThirdPartShareLogic.this.f44750d.dismiss();
                    ThirdPartShareLogic.this.f44750d = null;
                }
                StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
                AppRuntime appRuntime = this.f44763d;
                statisticCollector.reportActionCountCliOper(appRuntime, appRuntime.getAccount(), "", "multi_account", "click_next", 0, 1, 0);
                ThirdPartShareLogic.this.o(false);
                return;
            }
            StatisticCollector statisticCollector2 = StatisticCollector.getInstance(BaseApplication.getContext());
            AppRuntime appRuntime2 = this.f44763d;
            statisticCollector2.reportActionCountCliOper(appRuntime2, appRuntime2.getAccount(), "", "multi_account", "click_cancel", 0, 1, 0);
            ForwardSdkBaseOption.G(this.f44764e, ThirdPartShareLogic.this.s(), ThirdPartShareLogic.this.f44752f);
            Activity activity = this.f44764e;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            this.f44764e.setResult(0);
            this.f44764e.finish();
        }
    }

    public void w(Activity activity) {
        Bundle bundleExtra;
        Intent intent;
        if (activity == null || this.f44758l == null) {
            return;
        }
        this.f44747a = new WeakReference<>(activity);
        boolean booleanExtra = this.f44758l.getBooleanExtra(QZoneShareManager.KEY_IS_THIRDPARTYSHARE, false);
        this.f44755i = booleanExtra;
        if (booleanExtra && (bundleExtra = this.f44758l.getBundleExtra(QZoneShareManager.KEY_SAHRE_DATA)) != null) {
            this.f44758l.putExtra(QZoneShareManager.KEY_SAHRE_DATA, QZoneShareManager.checkQzoneShareParams(bundleExtra));
            int i3 = bundleExtra.getInt(AppConstants.Key.SHARE_REQ_TYPE, 0);
            if (i3 != 3 && i3 != 4) {
                if ("login".equals(bundleExtra.getString(AppConstants.Key.SHARE_REQ_SHARE_JFROM))) {
                    o(false);
                } else {
                    AppRuntime qZoneRuntime = LoginData.getInstance().getQZoneRuntime();
                    String string = bundleExtra.getString("share_uin");
                    String string2 = bundleExtra.getString("open_id");
                    if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                        o(false);
                    } else if (!TextUtils.isEmpty(string)) {
                        o(!string.equals(String.valueOf(LoginData.getInstance().getUin())));
                    } else {
                        if (QZoneShareManager.getOpenID(qZoneRuntime, String.valueOf(bundleExtra.getLong("req_share_id", 0L)), new c()) != null) {
                            o(!string2.equals(r1.openID));
                        } else {
                            u();
                            this.f44760n.sendEmptyMessageDelayed(QZoneShareManager.MSG_QZONE_SHARE_LATER_CREATE_DIALOG, 3000L);
                        }
                    }
                }
                if (i3 == 5) {
                    Intent intent2 = new Intent();
                    intent2.setAction(JumpActivity.BROCAST_RECEIVER_ACTION);
                    WeakReference<Activity> weakReference = this.f44747a;
                    if (weakReference == null || weakReference.get() == null) {
                        return;
                    }
                    this.f44747a.get().sendBroadcast(intent2);
                    QZLog.i("ThirdPartShareLogic", "sendBroadcast to finish the last activity.");
                    return;
                }
                return;
            }
            v();
            ArrayList<String> stringArrayList = bundleExtra.getStringArrayList("images");
            if (stringArrayList != null && stringArrayList.size() > 9) {
                intent = new Intent(activity, (Class<?>) QZoneUploadPhotoRealActivity.class);
            } else {
                intent = new Intent(activity, lc.b.b());
            }
            if (!QZoneConfigHelper.M0(bundleExtra.getString(QZoneShareManager.QZONE_SHARE_HULIAN_APPID))) {
                String string3 = bundleExtra.getString("file_send_path");
                if ((stringArrayList != null && stringArrayList.size() > 0) || !TextUtils.isEmpty(string3)) {
                    bundleExtra.putString("summary", "");
                    bundleExtra.putString(QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, "");
                }
            }
            intent.putExtra(PerfTracer.PARAM_CLICK_TIME, System.currentTimeMillis());
            if (TextUtils.equals(intent.getComponent().getClassName(), QZoneUploadPhotoRealActivity.class.getName()) && lc.b.d()) {
                QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean = new QZAlbumxUploadAlbumInitBean(LoginData.getInstance().getUinString(), 0, true, null, 0);
                qZAlbumxUploadAlbumInitBean.setRequestCode(103);
                ho.i.x().l(activity, qZAlbumxUploadAlbumInitBean, this.f44758l);
            } else {
                intent.putExtras(bundleExtra);
                activity.startActivityForResult(intent, 103);
            }
            if (i3 == 4) {
                ClickReport.q("48", "4", "", true);
            } else if (stringArrayList != null && stringArrayList.size() > 9) {
                ClickReport.q("47", "4", "", true);
            } else {
                ClickReport.q("46", "4", "", true);
            }
        }
    }
}
