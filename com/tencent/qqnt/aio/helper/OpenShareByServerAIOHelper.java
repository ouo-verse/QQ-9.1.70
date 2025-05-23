package com.tencent.qqnt.aio.helper;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseForwardUtil;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.mini.share.opensdk.OpenSdkShareModel;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body$RichText;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77$ReqBody;

/* compiled from: P */
/* loaded from: classes34.dex */
public class OpenShareByServerAIOHelper implements Handler.Callback {
    public static final String P = HardCodeUtil.qqStr(R.string.vrk);
    private OpenSdkShareModel G;
    private int H;
    private BroadcastReceiver I;
    private com.tencent.aio.api.runtime.a L;
    private Activity M;
    private Bundle N;

    /* renamed from: e, reason: collision with root package name */
    private Dialog f350369e;

    /* renamed from: h, reason: collision with root package name */
    private QQCustomDialog f350371h;

    /* renamed from: i, reason: collision with root package name */
    private long f350372i;

    /* renamed from: d, reason: collision with root package name */
    final long f350368d = 10000;

    /* renamed from: f, reason: collision with root package name */
    private QQCustomDialog f350370f = null;

    /* renamed from: m, reason: collision with root package name */
    private final MqqHandler f350373m = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
    private boolean C = false;
    private long D = -1;
    private volatile boolean E = false;
    private volatile boolean F = false;
    final com.tencent.mobileqq.pic.ad J = new a();
    final DialogInterface.OnClickListener K = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (OpenShareByServerAIOHelper.this.M == null || OpenShareByServerAIOHelper.this.M.isFinishing()) {
                return;
            }
            String a16 = com.tencent.mobileqq.forward.i.a(intent.getStringExtra("key_share_image_by_server"));
            QLog.d("OpenShareByServerAIOHelper", 1, "initBroadcastReceiver errorMsg=", a16);
            if (a16 != null) {
                if (!TextUtils.isEmpty(a16)) {
                    OpenShareByServerAIOHelper.this.P(a16);
                } else {
                    OpenShareByServerAIOHelper openShareByServerAIOHelper = OpenShareByServerAIOHelper.this;
                    openShareByServerAIOHelper.Q(openShareByServerAIOHelper.N);
                    jq3.a.m(OpenShareByServerAIOHelper.this.N, OpenShareByServerAIOHelper.this.H, OpenShareByServerAIOHelper.this.f350372i);
                }
            }
            if (OpenShareByServerAIOHelper.this.I != null) {
                OpenShareByServerAIOHelper.this.M.unregisterReceiver(OpenShareByServerAIOHelper.this.I);
                OpenShareByServerAIOHelper.this.I = null;
            }
        }
    }

    public OpenShareByServerAIOHelper(com.tencent.aio.api.runtime.a aVar, Activity activity) {
        this.L = aVar;
        this.M = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AbsStructMsg B() {
        Bundle bundle = this.N;
        if (bundle == null) {
            return null;
        }
        return com.tencent.mobileqq.structmsg.i.d(bundle.getByteArray(AppConstants.Key.STRUCT_MSG_BYTES));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(String str) {
        if (!TextUtils.isEmpty(str)) {
            I(str, this.M);
        }
        ForwardStatisticsReporter.k("KEY_STAGE_2_TOTAL", false);
        com.tencent.mobileqq.forward.x.n(this.N, this.H, this.f350372i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        Bundle bundle = this.N;
        if (bundle != null) {
            String string = bundle.getString("app_name");
            if (!this.N.getBoolean("refuse_show_share_result_dialog", false)) {
                AbsStructMsg e16 = com.tencent.mobileqq.structmsg.i.e(this.N);
                AbsShareMsg absShareMsg = e16 instanceof AbsShareMsg ? (AbsShareMsg) e16 : null;
                if (absShareMsg == null) {
                    return;
                } else {
                    this.f350370f = com.tencent.mobileqq.forward.x.o(this.M, this.f350370f, this.L, absShareMsg.mSourceAppid, absShareMsg.mMsgServiceID, string);
                }
            }
        }
        com.tencent.mobileqq.forward.x.n(this.N, this.H, this.f350372i, true);
    }

    private void H() {
        if (this.I == null) {
            c cVar = new c();
            this.I = cVar;
            this.M.registerReceiver(cVar, new IntentFilter("action_notify_aio_activity"));
        }
    }

    private void I(String str, Context context) {
        if (QLog.isColorLevel()) {
            QLog.i("OpenShareByServerAIOHelper", 2, "jumpToErrorWeb: invoked. info: jumpUrl = " + str);
        }
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        try {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str);
            context.startActivity(intent);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("OpenShareByServerAIOHelper", 2, "jumpToErrorWeb: Failed. info: exception = ", th5);
            }
        }
    }

    private void L(com.tencent.mobileqq.pic.ad adVar, AbsStructMsg absStructMsg) {
        Activity activity;
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        WeakReference weakReference = new WeakReference(adVar);
        if (this.N != null && qQAppInterface != null && (activity = this.M) != null) {
            if (!NetworkUtil.isNetSupport(activity)) {
                P(HardCodeUtil.qqStr(R.string.mpz));
                QLog.e("OpenShareByServerAIOHelper", 1, " requestShareMessage net error");
                return;
            }
            String string = this.N.getString("uin");
            int i3 = this.N.getInt("uintype");
            String string2 = this.N.getString("troop_uin");
            this.f350372i = this.N.getLong("req_share_id");
            if (absStructMsg == null) {
                QLog.e("OpenShareByServerAIOHelper", 1, " requestShareMessage error structMsg = null ");
                return;
            }
            QLog.i("OpenShareByServerAIOHelper", 1, "requestShareMessage structMsg=" + absStructMsg.getXml());
            com.tencent.mobileqq.pic.ad adVar2 = (com.tencent.mobileqq.pic.ad) weakReference.get();
            MqqHandler mqqHandler = this.f350373m;
            mqqHandler.sendMessageDelayed(mqqHandler.obtainMessage(95), 500L);
            ForwardStatisticsReporter.m("KEY_STAGE_2_SEND_MSG_BY_SERVER");
            AbsShareMsg.sendSdkShareMessageByServer(qQAppInterface, (AbsShareMsg) absStructMsg, string, i3, string2, adVar2);
            return;
        }
        QLog.e("OpenShareByServerAIOHelper", 1, " requestShareMessage error mExtra = " + this.N + ", app=" + qQAppInterface + ", mActivity =" + this.M);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(Bundle bundle) {
        int i3 = bundle.getInt("uintype");
        String string = bundle.getString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE_FOR_SERVER);
        if (this.M == null || TextUtils.isEmpty(string)) {
            if (QLog.isColorLevel()) {
                QLog.e("OpenShareByServerAIOHelper", 2, "sendCommentMsg null ");
            }
        } else if (i3 != 10014) {
            N(string);
        } else {
            ForwardUtils.l0(bundle);
        }
    }

    private void N(String str) {
        try {
            SessionInfo p06 = ForwardUtils.p0(this.N);
            com.tencent.biz.anonymous.a.h().f78364c = true;
            com.tencent.mobileqq.forward.utils.f.f211079a.i(p06, str);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("OpenShareByServerAIOHelper", 2, "sendCommentMsgToC2C exception", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(Bundle bundle) {
        final String string = bundle.getString("app_name");
        AbsStructMsg e16 = com.tencent.mobileqq.structmsg.i.e(bundle);
        final AbsShareMsg absShareMsg = e16 instanceof AbsShareMsg ? (AbsShareMsg) e16 : null;
        if (absShareMsg == null) {
            return;
        }
        this.f350373m.post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.OpenShareByServerAIOHelper.5
            @Override // java.lang.Runnable
            public void run() {
                OpenShareByServerAIOHelper openShareByServerAIOHelper = OpenShareByServerAIOHelper.this;
                Activity activity = openShareByServerAIOHelper.M;
                QQCustomDialog qQCustomDialog = OpenShareByServerAIOHelper.this.f350370f;
                com.tencent.aio.api.runtime.a aVar = OpenShareByServerAIOHelper.this.L;
                AbsShareMsg absShareMsg2 = absShareMsg;
                openShareByServerAIOHelper.f350370f = com.tencent.mobileqq.forward.x.o(activity, qQCustomDialog, aVar, absShareMsg2.mSourceAppid, absShareMsg2.mMsgServiceID, string);
            }
        });
    }

    private void S() {
        Activity activity = this.M;
        if (activity != null && activity.getIntent() != null) {
            this.N = this.M.getIntent().getExtras();
        }
        this.F = false;
    }

    public void C() {
        QLog.i("OpenShareByServerAIOHelper", 1, "forwardShare");
        S();
        Bundle bundle = this.N;
        if (bundle == null) {
            return;
        }
        boolean z16 = bundle.getBoolean(AppConstants.Key.SHARE_SEND_MSG_BY_SERVER, false);
        this.H = this.N.getInt(AppConstants.Key.SHARE_REQ_TYPE, Integer.MAX_VALUE);
        QLog.i("OpenShareByServerAIOHelper", 1, "forwardShare sendMsgByServer =" + z16 + ", mForwardSubType=" + this.H);
        this.G = (OpenSdkShareModel) this.N.getParcelable("KEY_MINI_PROGRAM_SHARE_OBJ");
        if (z16) {
            AbsStructMsg B = B();
            jq3.a.l(B, this.N);
            L(this.J, B);
            return;
        }
        if (this.N.getBoolean("refuse_show_share_result_dialog", false)) {
            return;
        }
        String string = this.N.getString("key_share_image_by_server");
        if (TextUtils.isEmpty(string)) {
            Q(this.N);
            jq3.a.m(this.N, this.H, this.f350372i);
            return;
        }
        String a16 = com.tencent.mobileqq.forward.i.a(string);
        QLog.d("OpenShareByServerAIOHelper", 1, "forwardShare errorMsg = ", a16);
        if (a16 == null) {
            H();
        } else if (a16.length() == 0) {
            Q(this.N);
            jq3.a.m(this.N, this.H, this.f350372i);
        } else {
            P(a16);
        }
    }

    public void K() {
        this.f350373m.removeMessages(96);
        G();
        QQCustomDialog qQCustomDialog = this.f350370f;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        this.F = false;
        this.C = false;
        this.E = false;
        this.D = -1L;
        BroadcastReceiver broadcastReceiver = this.I;
        if (broadcastReceiver != null) {
            this.M.unregisterReceiver(broadcastReceiver);
            this.I = null;
        }
    }

    protected void O(int i3, String str, String str2) {
        ForwardStatisticsReporter.k("KEY_STAGE_2_TOTAL", false);
        if (this.f350371h == null) {
            this.f350371h = DialogUtil.createCustomDialog(this.M, 230);
        }
        this.f350371h.setMessage(str);
        this.f350371h.setPositiveButton(R.string.f171151ok, new d(i3, str2));
        try {
            this.f350371h.show();
        } catch (Throwable th5) {
            QLog.e("OpenShareByServerAIOHelper", 1, "showErrorDialog, ", th5);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements com.tencent.mobileqq.pic.ad {
        a() {
        }

        @Override // com.tencent.mobileqq.pic.ad
        public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
            return null;
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void q(ad.a aVar) {
            Object obj;
            String string = OpenShareByServerAIOHelper.this.N.getString("uin");
            HashMap hashMap = new HashMap();
            String str = "1";
            if (OpenShareByServerAIOHelper.this.C) {
                obj = "1";
            } else {
                obj = "0";
            }
            hashMap.put("param_time_out", obj);
            if (!OpenShareByServerAIOHelper.this.E) {
                str = "0";
            }
            hashMap.put("param_is_first_show", str);
            if (string == null) {
                string = "";
            }
            ForwardStatisticsReporter.i("KEY_STAGE_2_SEND_MSG_BY_SERVER", string, hashMap, ForwardUtils.P(aVar));
            QLog.d("OpenShareByServerAIOHelper", 1, "UpCallBack onSend result =", aVar, ", isTimeOut=", Boolean.valueOf(OpenShareByServerAIOHelper.this.C), ", isFirstShow =", Boolean.valueOf(OpenShareByServerAIOHelper.this.E));
            if (OpenShareByServerAIOHelper.this.E && !OpenShareByServerAIOHelper.this.C) {
                int i3 = aVar.f258597a;
                if (i3 == 0) {
                    String[] strArr = (String[]) aVar.f258608l;
                    if (strArr != null && strArr.length == 2) {
                        QLog.i("OpenShareByServerAIOHelper", 1, "UpCallBack onSend urls=" + strArr[0] + " ," + strArr[1]);
                        OpenShareByServerAIOHelper openShareByServerAIOHelper = OpenShareByServerAIOHelper.this;
                        openShareByServerAIOHelper.J(openShareByServerAIOHelper.N, strArr[0], strArr[1]);
                        return;
                    }
                    QLog.e("OpenShareByServerAIOHelper", 1, "onSend updateMsg error !");
                    return;
                }
                if (-1 == i3) {
                    int i16 = aVar.f258598b;
                    boolean b16 = BaseForwardUtil.b(OpenShareByServerAIOHelper.this.M);
                    String[] strArr2 = (String[]) aVar.f258608l;
                    QLog.i("OpenShareByServerAIOHelper", 1, "UpCallBack onSend failed errCode=" + i16 + ", hasSDPermission=" + b16);
                    if (i16 != 9402 || b16 || strArr2 == null || strArr2.length != 2) {
                        OpenShareByServerAIOHelper.this.P(OpenShareByServerAIOHelper.P);
                        return;
                    }
                    QLog.i("OpenShareByServerAIOHelper", 1, "UpCallBack onSend failed urls=" + strArr2[0] + " ," + strArr2[1]);
                    OpenShareByServerAIOHelper openShareByServerAIOHelper2 = OpenShareByServerAIOHelper.this;
                    openShareByServerAIOHelper2.J(openShareByServerAIOHelper2.N, strArr2[0], strArr2[1]);
                }
            }
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void r(ad.a aVar) {
            if (aVar != null) {
                QLog.d("OpenShareByServerAIOHelper", 1, "upCallBack updateMsg info =" + aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(int i3, String str, String str2) {
        Bundle bundle = this.N;
        if (bundle != null && bundle.getBoolean(AppConstants.Key.FORWARD_MINI_PROGRAM_ARK_FROM_SDK, false)) {
            ReportController.o((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", "0X8009F7C", "0X8009F7C", 0, 0, "2", String.valueOf(i3), "", "");
        }
        O(i3, str, str2);
        com.tencent.mobileqq.forward.x.n(this.N, this.H, this.f350372i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        QLog.d("OpenShareByServerAIOHelper", 1, "hideWaiteDialog");
        Dialog dialog = this.f350369e;
        if (dialog == null || !dialog.isShowing() || this.M.isFinishing()) {
            return;
        }
        this.f350373m.post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.OpenShareByServerAIOHelper.7
            @Override // java.lang.Runnable
            public void run() {
                OpenShareByServerAIOHelper.this.f350369e.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(Bundle bundle, String str, String str2) {
        oidb_cmd0xb77$ReqBody h16 = com.tencent.mobileqq.forward.x.h(bundle, str, str2, null);
        com.tencent.mobileqq.forward.x.g(this.G, bundle, h16);
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null) {
            QLog.e("OpenShareByServerAIOHelper", 1, "notifyServerSendMessage send runtime = null ");
            P(P);
            return;
        }
        this.D = System.currentTimeMillis();
        Bundle bundle2 = new Bundle();
        bundle2.putLong("0xb77_9_sendTime", this.D);
        QLog.i("OpenShareByServerAIOHelper", 1, "notifyServerSendMessage sendOIDBRequest");
        ForwardStatisticsReporter.m("KEY_STAGE_2_NORMAL_B77");
        ProtoUtils.c(runtime, new e(bundle), h16.toByteArray(), "OidbSvc.0xb77_9", 2935, 9, bundle2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(final String str) {
        QLog.d("OpenShareByServerAIOHelper", 1, "showOtherErrorDialog ", str);
        this.f350373m.post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.OpenShareByServerAIOHelper.4
            @Override // java.lang.Runnable
            public void run() {
                ForwardStatisticsReporter.k("KEY_STAGE_2_TOTAL", false);
                if (OpenShareByServerAIOHelper.this.f350371h == null) {
                    OpenShareByServerAIOHelper openShareByServerAIOHelper = OpenShareByServerAIOHelper.this;
                    openShareByServerAIOHelper.f350371h = DialogUtil.createCustomDialog(openShareByServerAIOHelper.M, 230);
                }
                OpenShareByServerAIOHelper.this.f350371h.setMessage(str);
                OpenShareByServerAIOHelper.this.f350371h.setPositiveButton(R.string.f171151ok, OpenShareByServerAIOHelper.this.K);
                try {
                    OpenShareByServerAIOHelper.this.f350371h.show();
                } catch (Throwable th5) {
                    QLog.e("OpenShareByServerAIOHelper", 1, "showOtherErrorDialog, ", th5);
                }
            }
        });
    }

    private void R() {
        QLog.d("OpenShareByServerAIOHelper", 1, "showWaitDialog");
        this.f350373m.post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.OpenShareByServerAIOHelper.6
            @Override // java.lang.Runnable
            public void run() {
                if (OpenShareByServerAIOHelper.this.M == null || OpenShareByServerAIOHelper.this.M.isFinishing()) {
                    return;
                }
                if (OpenShareByServerAIOHelper.this.f350369e == null) {
                    OpenShareByServerAIOHelper.this.f350369e = new Dialog(OpenShareByServerAIOHelper.this.M, R.style.qZoneInputDialog);
                }
                OpenShareByServerAIOHelper.this.f350369e.setCancelable(false);
                OpenShareByServerAIOHelper.this.f350369e.setContentView(R.layout.f168383uh);
                ((TextView) OpenShareByServerAIOHelper.this.f350369e.findViewById(R.id.photo_prievew_progress_dialog_text)).setText(R.string.cuv);
                try {
                    OpenShareByServerAIOHelper.this.f350369e.show();
                } catch (Throwable th5) {
                    QLog.e("OpenShareByServerAIOHelper", 1, "showWaitDialog, ", th5);
                }
            }
        });
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 == 1) {
                ForwardSdkBaseOption.F(OpenShareByServerAIOHelper.this.M, false, "shareToQQ", OpenShareByServerAIOHelper.this.f350372i);
                com.tencent.biz.common.util.k.k(OpenShareByServerAIOHelper.this.M, 0, "", "");
                if (OpenShareByServerAIOHelper.this.L != null) {
                    OpenShareByServerAIOHelper.this.L.e().h(new ExternalCommIntent("close_aio", new Bundle()));
                }
                OpenShareByServerAIOHelper.this.M.moveTaskToBack(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f350380d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f350381e;

        d(int i3, String str) {
            this.f350380d = i3;
            this.f350381e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 == 1) {
                com.tencent.mobileqq.forward.x.p(OpenShareByServerAIOHelper.this.M, "shareToQQ", OpenShareByServerAIOHelper.this.f350372i, this.f350380d, this.f350381e);
                com.tencent.biz.common.util.k.k(OpenShareByServerAIOHelper.this.M, 0, "", "");
                if (OpenShareByServerAIOHelper.this.L != null) {
                    OpenShareByServerAIOHelper.this.L.e().h(new ExternalCommIntent("close_aio", new Bundle()));
                }
                OpenShareByServerAIOHelper.this.M.moveTaskToBack(true);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 95) {
            if (i3 == 96 && !this.M.isFinishing() && this.E) {
                QLog.d("OpenShareByServerAIOHelper", 1, "MSG_SDK_SHARE_REQUEST_TIMEOUT_STATUS");
                ReportController.o(null, "dc00898", "", "", "0X8009CF9", "0X8009CF9", 0, 0, "", "", "", "");
                this.C = true;
                G();
                P(HardCodeUtil.qqStr(R.string.mpy));
            }
        } else if (!this.F && this.E) {
            R();
            MqqHandler mqqHandler = this.f350373m;
            mqqHandler.sendMessageDelayed(mqqHandler.obtainMessage(96), 10000L);
        } else if (QLog.isColorLevel()) {
            QLog.i("OpenShareByServerAIOHelper", 2, "isRequestDone do not show dialog");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class e extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f350383d;

        e(Bundle bundle) {
            this.f350383d = bundle;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int i3, String str, Bundle bundle) {
            if (!TextUtils.isEmpty(str) && QLog.isColorLevel()) {
                QLog.e("OpenShareByServerAIOHelper", 2, "onError msg =" + str);
            }
            return super.onError(i3, str, bundle);
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            String str;
            ForwardStatisticsReporter.k("KEY_STAGE_2_NORMAL_B77", i3 == 0);
            QLog.d("OpenShareByServerAIOHelper", 1, "notifyServerSendMessage() onResult errorCode=", Integer.valueOf(i3), ", isTimeOut=", Boolean.valueOf(OpenShareByServerAIOHelper.this.C), ", isFirstShow =", Boolean.valueOf(OpenShareByServerAIOHelper.this.E));
            if (OpenShareByServerAIOHelper.this.E) {
                if (!OpenShareByServerAIOHelper.this.C) {
                    if (bundle != null) {
                        long j3 = bundle.getLong("0xb77_9_sendTime", -1L);
                        QLog.d("OpenShareByServerAIOHelper", 1, "notifyServerSendMessage currentRequestTime =" + OpenShareByServerAIOHelper.this.D + ", sendStamp = " + j3);
                        if (j3 == -1 || j3 != OpenShareByServerAIOHelper.this.D) {
                            QLog.d("OpenShareByServerAIOHelper", 1, "notifyServerSendMessage return for sendStamp");
                            return;
                        }
                    }
                    OpenShareByServerAIOHelper.this.F = true;
                    Object[] b06 = ForwardUtils.b0(bArr);
                    int intValue = ((Integer) b06[0]).intValue();
                    String str2 = (String) b06[1];
                    String str3 = (String) b06[2];
                    String str4 = (String) b06[3];
                    OpenShareByServerAIOHelper.this.f350373m.removeMessages(96);
                    OpenShareByServerAIOHelper.this.G();
                    AbsStructMsg B = OpenShareByServerAIOHelper.this.B();
                    String q16 = jq3.a.q(OpenShareByServerAIOHelper.this.N.getInt(AppConstants.Key.SHARE_REQ_TYPE));
                    String r16 = jq3.a.r(OpenShareByServerAIOHelper.this.N.getInt("uintype"));
                    if (!(B instanceof AbsShareMsg)) {
                        str = "";
                    } else {
                        str = ((AbsShareMsg) B).mContentTitle;
                    }
                    ReportController.o(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, "" + i3, q16, r16, str);
                    if (i3 != 0 || bArr == null) {
                        OpenShareByServerAIOHelper.this.E(i3, str3, str4);
                        return;
                    }
                    if (intValue != 0) {
                        OpenShareByServerAIOHelper.this.D(str2);
                    } else {
                        OpenShareByServerAIOHelper.this.F();
                    }
                    OpenShareByServerAIOHelper.this.M(this.f350383d);
                    return;
                }
                QLog.d("OpenShareByServerAIOHelper", 1, "notifyServerSendMessage return for isTimeOut =" + OpenShareByServerAIOHelper.this.C);
                return;
            }
            QLog.d("OpenShareByServerAIOHelper", 1, "notifyServerSendMessage return for isFirstShow =" + OpenShareByServerAIOHelper.this.E);
        }
    }
}
