package cooperation.qlink;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qlink.QlAndQQInterface;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QlinkStandardDialogActivity extends BaseActivity {

    /* renamed from: a0, reason: collision with root package name */
    private BaseActivity f390470a0;

    /* renamed from: b0, reason: collision with root package name */
    private BroadcastReceiver f390471b0 = null;

    /* renamed from: c0, reason: collision with root package name */
    final DialogInterface.OnDismissListener f390472c0 = new b();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.tencent.qlink.finishdlg".equalsIgnoreCase(intent.getAction())) {
                QlinkStandardDialogActivity.this.finish();
                QlinkStandardDialogActivity.this.overridePendingTransition(0, 0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class b implements DialogInterface.OnDismissListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            QlinkStandardDialogActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QQProxyForQlink.P(QlinkStandardDialogActivity.this, 5, null);
            QlinkStandardDialogActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QlinkStandardDialogActivity.this.app.getQQProxyForQlink().F(new QlAndQQInterface.DailogClickInfo(4));
            QlinkStandardDialogActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f390477d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f390478e;

        e(boolean z16, boolean z17) {
            this.f390477d = z16;
            this.f390478e = z17;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (this.f390477d) {
                if (this.f390478e) {
                    FileManagerUtil.enterQlinkLocalFileBrowser(QlinkStandardDialogActivity.this, null, com.tencent.luggage.wxa.he.e.CTRL_INDEX, false, 0);
                } else {
                    FileManagerUtil.enterQlinkLocalFileBrowser(QlinkStandardDialogActivity.this, null, 888, false, 0);
                }
            } else {
                Intent intent = new Intent();
                intent.putExtra("from", "qlink");
                RouteUtils.startActivity(QlinkStandardDialogActivity.this, intent, "/qrscan/scanner");
            }
            QlinkStandardDialogActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QlinkStandardDialogActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class g implements DialogInterface.OnClickListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            String str;
            QlinkStandardDialogActivity.this.app.getQQProxyForQlink().B("0X8004750", 1);
            QlinkStandardDialogActivity.this.app.getQQProxyForQlink().F(new QlAndQQInterface.DailogClickInfo(9));
            if (QLog.isDevelopLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("topAct:");
                if (QlinkStandardDialogActivity.this.f390470a0 != null) {
                    str = QlinkStandardDialogActivity.this.f390470a0.getLocalClassName();
                } else {
                    str = "null";
                }
                sb5.append(str);
                QLog.d("QlinkStandardDialogActivity", 2, sb5.toString());
            }
            if (((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).isNeedFinish(QlinkStandardDialogActivity.this.f390470a0)) {
                return;
            }
            FileManagerUtil.enterQlinkRecentFileBrowser(QlinkStandardDialogActivity.this, false);
            QlinkStandardDialogActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class h implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f390482d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f390483e;

        h(String str, String str2) {
            this.f390482d = str;
            this.f390483e = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            Intent startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(QlinkStandardDialogActivity.this.app.getApp().getApplicationContext(), 1, this.f390482d, null, 3002, 14, this.f390483e, null, null, HardCodeUtil.qqStr(R.string.f171898lr0), null);
            startAddFriend.putExtra("_FROM_QLINK_", true);
            QlinkStandardDialogActivity.this.startActivity(startAddFriend);
            ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(QlinkStandardDialogActivity.this, startAddFriend);
            dialogInterface.dismiss();
            QlinkStandardDialogActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class i implements DialogInterface.OnClickListener {
        i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            QlinkStandardDialogActivity.this.finish();
        }
    }

    private void G2(String str, String str2) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230, getString(R.string.f3t), HardCodeUtil.qqStr(R.string.qjf) + str2 + HardCodeUtil.qqStr(R.string.qjd), R.string.f46, R.string.f3s, new h(str, str2), new i());
        createCustomDialog.setOnDismissListener(this.f390472c0);
        createCustomDialog.show();
    }

    private void H2() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230, getString(R.string.f4d), getString(R.string.f171465f40), R.string.f47, R.string.f47, new c(), (DialogInterface.OnClickListener) null);
        createCustomDialog.setOnDismissListener(this.f390472c0);
        createCustomDialog.show();
    }

    private void I2(boolean z16, boolean z17, String str) {
        int i3;
        d dVar = new d();
        e eVar = new e(z16, z17);
        if (z16) {
            i3 = R.string.f49;
        } else {
            i3 = R.string.f48;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230, getString(R.string.f4d), str, R.string.f46, i3, eVar, dVar);
        createCustomDialog.setOnDismissListener(this.f390472c0);
        createCustomDialog.show();
    }

    private void J2(boolean z16, String str, String str2, int i3, String str3, String str4) {
        String str5;
        f fVar = new f();
        g gVar = new g();
        if (str != null && str.equalsIgnoreCase(str2)) {
            str2 = ac.y(this.app, str);
        }
        if (z16) {
            str5 = getString(R.string.f56) + str2 + getString(R.string.f57) + i3 + getString(R.string.f58) + str3 + getString(R.string.f59) + str4 + "\u3002";
        } else {
            str5 = getString(R.string.f4x) + str2 + getString(R.string.f4y) + i3 + getString(R.string.f4z) + str3 + getString(R.string.f171468f50) + str4 + "\u3002";
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230, getString(R.string.f4d), str5, R.string.f5n, R.string.f5o, gVar, fVar);
        createCustomDialog.setOnDismissListener(this.f390472c0);
        createCustomDialog.show();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null && qQAppInterface.getApp() != null && this.f390471b0 != null) {
            this.app.getApp().unregisterReceiver(this.f390471b0);
        }
        super.doOnDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mNeedStatusTrans = false;
        this.f390470a0 = BaseActivity.sTopActivity;
        super.onCreate(bundle);
        if (this.app == null) {
            QLog.e("QlinkStandardDialogActivity", 2, "onCreate: app=null");
            return;
        }
        setTitle((CharSequence) null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.qlink.finishdlg");
        if (this.app.getApp() != null) {
            this.f390471b0 = new a();
            this.app.getApp().registerReceiver(this.f390471b0, intentFilter);
        } else {
            QLog.e("QlinkStandardDialogActivity", 2, "onCreate: app.getapp()=null");
        }
        switch (getIntent().getIntExtra("str_type", 0)) {
            case 7:
                I2(getIntent().getBooleanExtra("param_send", false), getIntent().getBooleanExtra("_INIT_SEND_IOS_", false), getIntent().getStringExtra("_DLG_CONTENT_"));
                this.app.getQQProxyForQlink().k();
                return;
            case 8:
                J2(getIntent().getBooleanExtra("param_send", false), getIntent().getStringExtra("param_uin"), getIntent().getStringExtra("param_nick"), getIntent().getIntExtra("param_transcount", 0), getIntent().getStringExtra("param_jsliuliang"), getIntent().getStringExtra("param_pjspeed"));
                this.app.getQQProxyForQlink().k();
                return;
            case 9:
                H2();
                return;
            case 10:
                G2(getIntent().getStringExtra("_ADD_UIN_"), getIntent().getStringExtra("_ADD_UIN_NICK_"));
                return;
            default:
                finish();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        requestWindowFeature(1);
    }
}
