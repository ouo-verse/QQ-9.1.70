package cooperation.qlink;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.bannerprocessor.QLinkTransingBannerProcessor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.filemanager.api.IQlinkUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.k;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import cooperation.qlink.QlAndQQInterface;
import cooperation.qlink.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import mqq.app.AppActivity;
import mqq.app.NewIntent;

/* loaded from: classes28.dex */
public class QQProxyForQlink {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f390400a;

    /* renamed from: b, reason: collision with root package name */
    private Timer f390401b;

    /* renamed from: e, reason: collision with root package name */
    private QQCustomDialog f390404e;

    /* renamed from: c, reason: collision with root package name */
    private int f390402c = 0;

    /* renamed from: d, reason: collision with root package name */
    private QlAndQQInterface.WorkState f390403d = new QlAndQQInterface.WorkState(false, 1, null, null, 0, 0, false);

    /* renamed from: f, reason: collision with root package name */
    private BroadcastReceiver f390405f = null;

    /* renamed from: g, reason: collision with root package name */
    private int f390406g = -1;

    /* renamed from: h, reason: collision with root package name */
    private BroadcastReceiver f390407h = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action == null) {
                return;
            }
            if (action.equals(NewIntent.ACTION_ACCOUNT_CHANGED) || action.equals(NewIntent.ACTION_ACCOUNT_KICKED) || action.equals(NewIntent.ACTION_ACCOUNT_EXPIRED) || action.equals(NewIntent.ACTION_LOGOUT)) {
                QLog.w("QQProxyForQlink", 1, "receive qqAccountbroacast action=" + action);
                QQProxyForQlink.this.f390403d = new QlAndQQInterface.WorkState(false, 1, null, null, 0, 0, false);
                QQProxyForQlink.this.j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.tencent.qlink.finishworkingdlg".equalsIgnoreCase(intent.getAction()) && QQProxyForQlink.this.f390404e != null) {
                QQProxyForQlink.this.f390404e.dismiss();
                QQProxyForQlink.this.f390404e = null;
            }
        }
    }

    /* loaded from: classes28.dex */
    class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f390413d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f390414e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f390415f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f390416h;

        c(ArrayList arrayList, Activity activity, int i3, boolean z16) {
            this.f390413d = arrayList;
            this.f390414e = activity;
            this.f390415f = i3;
            this.f390416h = z16;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QQProxyForQlink.this.B("0X8004855", 1);
            QQProxyForQlink qQProxyForQlink = QQProxyForQlink.this;
            qQProxyForQlink.H(qQProxyForQlink.f390403d.mPeerUin, this.f390413d);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("string_filepaths", this.f390413d);
            bundle.putBoolean("STRING_CONTINUE_SEND_TO_", true);
            QQProxyForQlink.P(this.f390414e, this.f390415f, bundle);
            dialogInterface.dismiss();
            if (this.f390416h) {
                this.f390414e.finish();
            }
        }
    }

    /* loaded from: classes28.dex */
    class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes28.dex */
    class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QQProxyForQlink.this.B("0X8004857", 1);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class f implements DialogInterface.OnDismissListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            QQProxyForQlink.this.f390404e = null;
        }
    }

    /* loaded from: classes28.dex */
    class g implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ k f390421d;

        g(k kVar) {
            this.f390421d = kVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f390421d.c();
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes28.dex */
    class h implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ k f390423d;

        h(k kVar) {
            this.f390423d = kVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f390423d.c();
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class i implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ k f390425d;

        i(k kVar) {
            this.f390425d = kVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f390425d.c();
            dialogInterface.dismiss();
        }
    }

    public QQProxyForQlink(QQAppInterface qQAppInterface) {
        this.f390400a = qQAppInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void A() {
        BaseApplication baseApplication;
        if (this.f390405f == null) {
            this.f390405f = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.qlink.finishworkingdlg");
            QQAppInterface qQAppInterface = this.f390400a;
            if (qQAppInterface != null) {
                baseApplication = qQAppInterface.getApp();
            } else {
                baseApplication = null;
            }
            if (baseApplication != null) {
                baseApplication.registerReceiver(this.f390405f, intentFilter);
            } else {
                QLog.e("QQProxyForQlink", 1, "registerFinishWorkingDlgReceiver error.fail");
                this.f390405f = null;
            }
        }
    }

    private synchronized void L() {
        if (this.f390401b != null) {
            return;
        }
        QLog.i("QQProxyForQlink", 1, "[QLINK]-QQ setQlinkHeartTimer");
        BaseTimer baseTimer = new BaseTimer();
        this.f390401b = baseTimer;
        baseTimer.schedule(new TimerTask() { // from class: cooperation.qlink.QQProxyForQlink.10
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                QQProxyForQlink.this.f390402c++;
                if (QQProxyForQlink.this.f390402c > 1) {
                    QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ qlink pulgin is dead:");
                    QQProxyForQlink.this.f390403d = new QlAndQQInterface.WorkState(false, 1, null, null, 0, 0, false);
                    QQProxyForQlink.this.j();
                    return;
                }
                QQProxyForQlink.this.I();
            }
        }, 0L, 5000L);
    }

    private static void M(final Context context, final CharSequence charSequence, final int i3) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            QQToast.makeText(context, charSequence, i3).show();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: cooperation.qlink.QQProxyForQlink.6
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(context, charSequence, i3).show();
                }
            });
        }
    }

    private void N(Activity activity, int i3, String str, k kVar) {
        String qqStr;
        if (activity == null) {
            return;
        }
        String qqStr2 = HardCodeUtil.qqStr(R.string.r1l);
        if (1 == i3) {
            qqStr = qqStr2 + HardCodeUtil.qqStr(R.string.r1o) + str + HardCodeUtil.qqStr(R.string.r1j);
        } else if (2 == i3) {
            qqStr = qqStr2 + HardCodeUtil.qqStr(R.string.r1n) + str + HardCodeUtil.qqStr(R.string.r1i);
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.r1k);
        }
        DialogUtil.createCustomDialog(activity, 230, activity.getString(R.string.f4c), qqStr, R.string.f47, R.string.f47, new i(kVar), (DialogInterface.OnClickListener) null).show();
    }

    public static void P(Context context, int i3, Bundle bundle) {
        if (!t()) {
            M(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.f196654hw), 0);
            return;
        }
        if (context == null) {
            if (QLog.isColorLevel()) {
                QLog.e("QQProxyForQlink", 2, "[QLINK] QQ - startQlink failed context=null!");
            }
            M(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.r1m), 0);
            return;
        }
        Intent intent = new Intent(context, (Class<?>) QlinkBridgeActivity.class);
        intent.putExtra("_from_", i3);
        if (bundle != null) {
            intent.putExtra("_param_", bundle);
        }
        if (9 == i3 || 10 == i3) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    private void R() {
        if (this.f390407h != null) {
            QQAppInterface qQAppInterface = this.f390400a;
            if (qQAppInterface != null && qQAppInterface.getApp() != null) {
                try {
                    this.f390400a.getApp().unregisterReceiver(this.f390407h);
                } catch (Exception unused) {
                }
                this.f390407h = null;
            } else {
                QLog.e("QQProxyForQlink", 1, "unregisterAccountReceiver error.");
            }
        }
    }

    private synchronized void S() {
        if (this.f390405f != null) {
            QQAppInterface qQAppInterface = this.f390400a;
            if (qQAppInterface != null && qQAppInterface.getApp() != null) {
                try {
                    this.f390400a.getApp().unregisterReceiver(this.f390405f);
                } catch (Exception unused) {
                }
                this.f390405f = null;
            } else {
                QLog.e("QQProxyForQlink", 1, "unregisterFinishWorkingDlgReceiver error.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j() {
        if (this.f390401b != null) {
            QLog.i("QQProxyForQlink", 1, "[QLINK]-QQ cancelQlinkHeartTimer");
            this.f390401b.cancel();
            this.f390401b = null;
        }
    }

    public static boolean t() {
        return ((IQlinkUtils) QRoute.api(IQlinkUtils.class)).isAllowToQLink();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        BaseApplication baseApplication;
        if (this.f390407h == null) {
            this.f390407h = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
            intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
            intentFilter.addAction(NewIntent.ACTION_ACCOUNT_EXPIRED);
            intentFilter.addAction(NewIntent.ACTION_LOGOUT);
            QQAppInterface qQAppInterface = this.f390400a;
            if (qQAppInterface != null) {
                baseApplication = qQAppInterface.getApp();
            } else {
                baseApplication = null;
            }
            if (baseApplication != null) {
                baseApplication.registerReceiver(this.f390407h, intentFilter);
            } else {
                QLog.e("QQProxyForQlink", 1, "registerAccountReceiver error. fail");
                this.f390407h = null;
            }
        }
    }

    public void B(String str, int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.d("QQProxyForQlink", 4, "QLINK_CLICK_EVENT: act=" + str + " count:" + i3);
        }
        ReportController.n(this.f390400a, "CliOper", "", "", str, str, 0, i3, 0, "", "", "", "");
    }

    public void C(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap) {
        if (QLog.isDevelopLevel()) {
            String str3 = "";
            if (hashMap != null && hashMap.size() > 0) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    str3 = str3 + " " + entry.getKey() + ":" + entry.getValue();
                }
            }
            QLog.d("QQProxyForQlink", 4, "QLINK_PERFORMANCE: tagName=" + str2 + " uin:" + str + " success:" + z16 + str3);
        }
        QlinkReliableReport.d(str, str2, z16, j3, j16, hashMap);
    }

    public void D(Activity activity, ArrayList<String> arrayList, int i3, int i16, boolean z16, String str) {
        Bundle bundle;
        if (activity == null) {
            return;
        }
        switch (i16) {
            case 1:
                B("0X800484F", 1);
                break;
            case 2:
                B("0X800485B", 1);
                break;
            case 3:
                B("0X800485E", 1);
                break;
            case 4:
                B("0X8004858", 1);
                break;
            case 5:
            case 6:
                B("0X800566F", 1);
                break;
        }
        if (!this.f390403d.mWorking) {
            if (arrayList != null && arrayList.size() > 0) {
                bundle = new Bundle();
                bundle.putStringArrayList("string_filepaths", arrayList);
            } else {
                bundle = null;
            }
            P(activity, i3, bundle);
            if (z16) {
                activity.finish();
                return;
            }
            return;
        }
        if (15 == i3 && (arrayList == null || arrayList.size() == 0)) {
            P(activity, i3, new Bundle());
            if (z16) {
                activity.finish();
                return;
            }
            return;
        }
        O(activity, new c(arrayList, activity, i3, z16), new d(), new e(), str);
    }

    public void E(Bundle bundle) {
        if (bundle != null) {
            if (bundle.getBoolean("qlinkexit", false)) {
                QLog.i("QQProxyForQlink", 1, "[QLINK]-QQ qlink is exit:");
                this.f390403d = new QlAndQQInterface.WorkState(false, 1, null, null, 0, 0, false);
                j();
                return;
            }
            QlAndQQInterface.WorkState workState = (QlAndQQInterface.WorkState) bundle.getSerializable("wstate");
            if (workState != null) {
                QlAndQQInterface.WorkState workState2 = this.f390403d;
                workState2.mForIphone = workState.mForIphone;
                workState2.mMode = workState.mMode;
                workState2.mPeerNick = workState.mPeerNick;
                workState2.mPeerUin = workState.mPeerUin;
                workState2.mState = workState.mState;
                workState2.mTransferingCount = workState.mTransferingCount;
                workState2.mWorking = workState.mWorking;
            } else {
                QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ respHeart. no wstate error");
            }
        } else {
            QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ respHeart. info = null");
        }
        this.f390402c = 0;
    }

    public void F(QlAndQQInterface.DailogClickInfo dailogClickInfo) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(QlAndQQInterface.f390427a, dailogClickInfo);
        int g16 = this.f390400a.getQlinkServiceMgr().g("cmd.senddailogclickinfo", bundle);
        if (QLog.isDevelopLevel()) {
            QLog.d("QQProxyForQlink", 4, "[QLINK]-QQ sendDailogClick:" + g16);
        }
    }

    public boolean G(QlAndQQInterface.SendFileInfos sendFileInfos) {
        this.f390400a.getQQProxyForQlink().B("0X8004763", 1);
        Bundle bundle = new Bundle();
        bundle.putSerializable(QlAndQQInterface.f390427a, sendFileInfos);
        int g16 = this.f390400a.getQlinkServiceMgr().g("cmd.sendfilemsgs", bundle);
        if (QLog.isDevelopLevel()) {
            QLog.d("QQProxyForQlink", 4, "[QLINK]-QQ QQ2QlSendFileMsgs:" + g16);
        }
        if (g16 != -1) {
            return true;
        }
        return false;
    }

    public boolean H(String str, List<String> list) {
        if (list != null && str != null) {
            if (list.size() <= 0) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQProxyForQlink", 2, "[QLINK]-QQ sendFileMsgs. no any file");
                }
                return false;
            }
            QlAndQQInterface.SendFileInfos sendFileInfos = new QlAndQQInterface.SendFileInfos();
            sendFileInfos.strUin = str;
            for (String str2 : list) {
                QlAndQQInterface.SendFileInfo sendFileInfo = new QlAndQQInterface.SendFileInfo();
                sendFileInfo.sessionid = FileManagerUtil.genSessionId().longValue();
                sendFileInfo.filePath = str2;
                sendFileInfo.fileSize = FileManagerUtil.getFileSizes(str2);
                sendFileInfos.infos.add(sendFileInfo);
            }
            return G(sendFileInfos);
        }
        if (QLog.isColorLevel()) {
            QLog.e("QQProxyForQlink", 2, "[QLINK]-QQ sendFileMsgs. param error");
        }
        return false;
    }

    public void I() {
        Bundle bundle = new Bundle();
        bundle.putInt("param", 1);
        QQAppInterface qQAppInterface = this.f390400a;
        if (qQAppInterface != null && qQAppInterface.getQlinkServiceMgr() != null) {
            this.f390400a.getQlinkServiceMgr().g("cmd.sendheart", bundle);
        }
    }

    public void J(int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("cmd", i3);
        this.f390400a.getQlinkServiceMgr().g("cmd.sendsimplecmd", bundle);
    }

    public void K(QlAndQQInterface.UserInfo userInfo) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(QlAndQQInterface.f390427a, userInfo);
        int g16 = this.f390400a.getQlinkServiceMgr().g("cmd.senduserinfo", bundle);
        if (QLog.isDevelopLevel()) {
            QLog.d("QQProxyForQlink", 4, "[QLINK]-QQ sendUserInfo:" + g16);
        }
    }

    public void O(Activity activity, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnClickListener onClickListener3, String str) {
        if (this.f390404e != null) {
            return;
        }
        String y16 = ac.y(this.f390400a, this.f390403d.mPeerUin);
        if (y16 == null || this.f390403d.mPeerUin.equalsIgnoreCase(y16)) {
            QlAndQQInterface.WorkState workState = this.f390403d;
            String str2 = workState.mPeerNick;
            if (str2 != null) {
                y16 = str2;
            } else {
                y16 = workState.mPeerUin;
            }
        }
        int i3 = this.f390403d.mMode;
        if (i3 == 1) {
            B("0X8004854", 1);
            String str3 = activity.getResources().getString(R.string.f5f) + y16 + activity.getResources().getString(R.string.f5g);
            if (str != null && !str.equalsIgnoreCase(this.f390403d.mPeerUin)) {
                this.f390404e = DialogUtil.createCustomDialog(activity, 230, activity.getResources().getString(R.string.f4d), str3, activity.getResources().getString(R.string.f5h), activity.getResources().getString(R.string.f5h), onClickListener2, (DialogInterface.OnClickListener) null);
            } else {
                this.f390404e = DialogUtil.createCustomDialog(activity, 230, activity.getResources().getString(R.string.f4d), str3, activity.getResources().getString(R.string.f5h), activity.getResources().getString(R.string.f5i), onClickListener, onClickListener2);
            }
            this.f390404e.show();
        } else if (i3 == 2) {
            B("0X8004856", 1);
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, activity.getResources().getString(R.string.f4d), y16 + activity.getResources().getString(R.string.f5e), activity.getResources().getString(R.string.f5d), activity.getResources().getString(R.string.f5d), onClickListener3, (DialogInterface.OnClickListener) null);
            this.f390404e = createCustomDialog;
            createCustomDialog.show();
        } else if (QLog.isColorLevel()) {
            QLog.e("QQProxyForQlink", 2, "[QLINK] QQ - working but op err");
        }
        QQCustomDialog qQCustomDialog = this.f390404e;
        if (qQCustomDialog != null) {
            qQCustomDialog.setOnDismissListener(new f());
        }
    }

    public void Q(Bundle bundle) {
        QlAndQQInterface.WorkState workState = (QlAndQQInterface.WorkState) bundle.getSerializable("wstate");
        QlAndQQInterface.WorkState workState2 = this.f390403d;
        workState2.mForIphone = workState.mForIphone;
        workState2.mMode = workState.mMode;
        workState2.mPeerNick = workState.mPeerNick;
        workState2.mPeerUin = workState.mPeerUin;
        workState2.mState = workState.mState;
        workState2.mTransferingCount = workState.mTransferingCount;
        workState2.mWorking = workState.mWorking;
    }

    public void k() {
        QQCustomDialog qQCustomDialog = this.f390404e;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
            this.f390404e = null;
        }
    }

    public int m() {
        return this.f390403d.mTransferingCount;
    }

    public void n(String str) {
        String G = ac.G(this.f390400a, str);
        QlAndQQInterface.UserInfo userInfo = new QlAndQQInterface.UserInfo();
        userInfo.uin = str;
        if (G != null) {
            userInfo.nick = G;
        } else {
            userInfo.nick = str;
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "QQProxyForQlink");
        userInfo.isFriend = false;
        if (friendsSimpleInfoWithUid != null) {
            userInfo.isFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "QQProxyForQlink");
        }
        K(userInfo);
    }

    public QlAndQQInterface.WorkState o() {
        return this.f390403d;
    }

    public void p(AppActivity appActivity, String str, k kVar) {
        if (appActivity != null && str != null) {
            b.a b16 = cooperation.qlink.b.b(str);
            if (b16 == null) {
                DialogUtil.createCustomDialog(appActivity, 230, appActivity.getString(R.string.f4c), appActivity.getString(R.string.f4w), R.string.f47, R.string.f47, new g(kVar), (DialogInterface.OnClickListener) null).show();
                return;
            }
            QlAndQQInterface.WorkState workState = this.f390403d;
            if (workState.mWorking) {
                N(appActivity, workState.mMode, workState.mPeerNick, kVar);
                return;
            }
            boolean equalsIgnoreCase = "qlink".equalsIgnoreCase(appActivity.getIntent().getStringExtra("from"));
            if (equalsIgnoreCase) {
                J(1);
            }
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putString("key", b16.f390493a);
            bundle.putString("peerUin", b16.f390494b);
            bundle.putString("peerNick", b16.f390495c);
            bundle.putString("peerOS", b16.f390496d);
            bundle.putString("apSSID", b16.f390497e);
            bundle.putString("preSharedKey", b16.f390498f);
            bundle.putBoolean("fromqlink", equalsIgnoreCase);
            String stringExtra = appActivity.getIntent().getStringExtra("subfrom");
            if (stringExtra != null) {
                bundle.putString("subfrom", stringExtra);
            }
            this.f390400a.getQQProxyForQlink();
            P(appActivity, 11, bundle);
            kVar.finish();
        }
    }

    public void q(AppActivity appActivity, k kVar) {
        if (appActivity == null) {
            return;
        }
        DialogUtil.createCustomDialog(appActivity, 230, appActivity.getString(R.string.f4u), appActivity.getString(R.string.f4v), R.string.f47, R.string.f47, new h(kVar), (DialogInterface.OnClickListener) null).show();
    }

    public void r(Bundle bundle) {
        int i3 = bundle.getInt("Event", 0);
        switch (i3) {
            case 15:
                s((QlAndQQInterface.InsertFMFileInfo) bundle.getSerializable(QlAndQQInterface.f390427a));
                return;
            case 16:
                v(bundle.getInt(QlAndQQInterface.f390427a));
                return;
            case 17:
                n(bundle.getString(QlAndQQInterface.f390427a));
                return;
            case 18:
                B(bundle.getString("action_name"), bundle.getInt(QlAndQQInterface.f390427a));
                return;
            case 19:
                Serializable serializable = ((QlAndQQInterface.ReportInfo) bundle.getSerializable(QlAndQQInterface.f390427a)).data;
                if (serializable instanceof QlAndQQInterface.ReportPerformanceInfo) {
                    QlAndQQInterface.ReportPerformanceInfo reportPerformanceInfo = (QlAndQQInterface.ReportPerformanceInfo) serializable;
                    C(reportPerformanceInfo.mUin, reportPerformanceInfo.mTagName, reportPerformanceInfo.mSuccess, reportPerformanceInfo.mDuration, reportPerformanceInfo.mSize, reportPerformanceInfo.mParams);
                    return;
                }
                return;
            case 20:
                QlinkReliableReport.l();
                return;
            case 21:
                QlinkReliableReport.m();
                return;
            case 22:
                u();
                return;
            case 23:
                Q(bundle.getBundle(QlAndQQInterface.f390427a));
                return;
            case 24:
                E(bundle.getBundle(QlAndQQInterface.f390427a));
                return;
            case 25:
                y(bundle.getInt(QlAndQQInterface.f390427a));
                return;
            default:
                if (QLog.isColorLevel()) {
                    QLog.e("QQProxyForQlink", 2, "[QLINK] QQ - unimplement event[" + i3 + "]");
                    return;
                }
                return;
        }
    }

    public void s(QlAndQQInterface.InsertFMFileInfo insertFMFileInfo) {
        if (insertFMFileInfo == null) {
            return;
        }
        String fileName = FileManagerUtil.getFileName(insertFMFileInfo.filePath);
        long fileSizes = FileManagerUtil.getFileSizes(insertFMFileInfo.filePath);
        FileManagerEntity i3 = this.f390400a.getFileManagerDataCenter().i(q.d(-1000).uniseq, insertFMFileInfo.uin, 0);
        i3.setCloudType(5);
        i3.nSessionId = insertFMFileInfo.sessionId;
        i3.setFilePath(insertFMFileInfo.filePath);
        i3.nFileType = FileManagerUtil.getFileType(insertFMFileInfo.filePath);
        i3.strThumbPath = insertFMFileInfo.thumbPath;
        i3.fileName = fileName;
        i3.fileSize = fileSizes;
        i3.srvTime = com.tencent.mobileqq.service.message.e.K0() * 1000;
        i3.msgSeq = FileManagerUtil.genMsgSeq();
        i3.msgUid = FileManagerUtil.genMsgUid();
        i3.isReaded = true;
        i3.peerUin = insertFMFileInfo.uin;
        i3.nOlSenderProgress = insertFMFileInfo.transSeq;
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(i3.peerUin));
        if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "QQProxyForQlink") != null) {
            i3.peerType = 0;
        } else {
            i3.peerType = 1003;
        }
        i3.peerNick = FileManagerUtil.getPeerNick(this.f390400a, insertFMFileInfo.uin, null, 0);
        i3.status = 1;
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "QQProxyForQlink");
        if (insertFMFileInfo.bSend) {
            i3.nOpType = 0;
            i3.bSend = true;
            TransfileUtile.makeTransFileProtocolData(insertFMFileInfo.filePath, 0L, 0, true);
            this.f390400a.getFileManagerDataCenter().t(i3);
        } else {
            i3.nOpType = 1;
            i3.bSend = false;
            TransfileUtile.makeTransFileProtocolData(insertFMFileInfo.filePath, fileSizes, 0, false, null);
            TransFileUtil.getTransferFilePath(this.f390400a.getAccount(), fileName, 0, null);
            this.f390400a.getFileManagerDataCenter().t(i3);
        }
        this.f390400a.getFileManagerDataCenter().f0(i3);
        QLog.d("QQProxyForQlink", 4, "insertFM sessionid:" + insertFMFileInfo.sessionId + " transeq:" + i3.nOlSenderProgress + " filePath:" + insertFMFileInfo.filePath);
    }

    public void u() {
        QLog.d("QQProxyForQlink", 4, "[QLINK]-QQ nofityQlinkStart");
        L();
    }

    public void v(int i3) {
        int i16;
        QlAndQQInterface.WorkState workState = this.f390403d;
        int i17 = workState.mTransferingCount;
        workState.mTransferingCount = i3;
        if (i17 != i3) {
            if (QLog.isDevelopLevel()) {
                QLog.i("QQProxyForQlink", 4, "[QLINK]-QQ UI_LOG:notifyGoingonTransChanged.count:" + i3);
            }
            BannerManager l3 = BannerManager.l();
            int i18 = QLinkTransingBannerProcessor.f185263d;
            if (this.f390400a.getQQProxyForQlink().m() != 0) {
                i16 = 2;
            } else {
                i16 = 0;
            }
            l3.O(i18, i16, null);
        }
    }

    public void w() {
        QLog.i("QQProxyForQlink", 1, "[QLINK]-QQ UI_LOG:QQProxyForQlink. onAppDestroy");
        R();
        S();
        j();
        this.f390400a = null;
    }

    public void x() {
        QLog.i("QQProxyForQlink", 1, "[QLINK]-QQ UI_LOG:QQProxyForQlink. onAppInit");
        QQAppInterface qQAppInterface = this.f390400a;
        if (qQAppInterface != null && qQAppInterface.getApp() != null) {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: cooperation.qlink.QQProxyForQlink.1
                @Override // java.lang.Runnable
                public void run() {
                    QLog.i("QQProxyForQlink", 1, "[QLINK]-QQ UI_LOG:QQProxyForQlink. onAppInit....");
                    QQProxyForQlink.this.A();
                    QQProxyForQlink.this.z();
                }
            });
        }
    }

    public void y(int i3) {
        if (1 == i3) {
            FileManagerUtil.clearRememberPicSelectForQlink(this.f390400a.getApplication().getApplicationContext());
        }
    }

    public void l() {
    }
}
