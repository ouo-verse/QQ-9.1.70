package com.tencent.mobileqq.activity.specialcare;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.newsetting.business.view.c2c.SpecialCareSettingView;
import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.cn;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ca;
import com.tencent.mobileqq.utils.eb;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.settings.NTFriendSettingHelper;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QQSpecialCareSettingActivity extends IphoneTitleBarActivity implements View.OnClickListener, MessageNotificationSettingManager.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private QQProgressDialog f186384a0;

    /* renamed from: b0, reason: collision with root package name */
    private SpecialCareSettingView f186385b0;

    /* renamed from: c0, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.business.group.c2c.special.b f186386c0;

    /* renamed from: d0, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.business.group.c2c.special.a f186387d0;

    /* renamed from: e0, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.business.group.c2c.special.c f186388e0;

    /* renamed from: f0, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.business.group.c2c.special.d f186389f0;

    /* renamed from: g0, reason: collision with root package name */
    private FriendListHandler f186390g0;

    /* renamed from: h0, reason: collision with root package name */
    private IQvipSpecialSoundManager f186391h0;

    /* renamed from: i0, reason: collision with root package name */
    private FriendsManager f186392i0;

    /* renamed from: j0, reason: collision with root package name */
    private com.tencent.qqnt.ntrelation.friendsinfo.bean.d f186393j0;

    /* renamed from: k0, reason: collision with root package name */
    private String f186394k0;

    /* renamed from: l0, reason: collision with root package name */
    private String f186395l0;

    /* renamed from: m0, reason: collision with root package name */
    private int f186396m0;

    /* renamed from: n0, reason: collision with root package name */
    private Toast f186397n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f186398o0;

    /* renamed from: p0, reason: collision with root package name */
    private MessageNotificationSettingManager f186399p0;

    /* renamed from: q0, reason: collision with root package name */
    private hx3.b<String> f186400q0;

    /* renamed from: r0, reason: collision with root package name */
    final Handler f186401r0;

    /* renamed from: s0, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f186402s0;

    /* renamed from: t0, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f186403t0;

    /* renamed from: u0, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f186404u0;

    /* renamed from: v0, reason: collision with root package name */
    private ar f186405v0;

    /* renamed from: w0, reason: collision with root package name */
    private cn f186406w0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements com.tencent.mobileqq.activity.specialcare.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSpecialCareSettingActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.specialcare.c
        public void onResult(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQSpecialCareSettingActivity", 2, "loadSpecialSoundConfig onResult: " + z16);
            }
            try {
                try {
                    if (z16) {
                        QQSpecialCareSettingActivity.this.g3();
                    } else if (QLog.isColorLevel()) {
                        QLog.d("QQSpecialCareSettingActivity", 2, "loadSpecialSoundConfig fail.");
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            } finally {
                QQSpecialCareSettingActivity.this.stopTitleProgress();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b extends Handler {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSpecialCareSettingActivity.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            switch (message.what) {
                case 8193:
                    if (QQSpecialCareSettingActivity.this.f186384a0 == null) {
                        QQSpecialCareSettingActivity qQSpecialCareSettingActivity = QQSpecialCareSettingActivity.this;
                        QQSpecialCareSettingActivity qQSpecialCareSettingActivity2 = QQSpecialCareSettingActivity.this;
                        qQSpecialCareSettingActivity.f186384a0 = new QQProgressDialog(qQSpecialCareSettingActivity2, qQSpecialCareSettingActivity2.getTitleBarHeight());
                        Object obj = message.obj;
                        if (obj != null && (obj instanceof String)) {
                            QQSpecialCareSettingActivity.this.f186384a0.setMessage((String) message.obj);
                        }
                    }
                    if (!QQSpecialCareSettingActivity.this.isFinishing() && !QQSpecialCareSettingActivity.this.f186384a0.isShowing()) {
                        try {
                            QQSpecialCareSettingActivity.this.f186384a0.show();
                            return;
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e("QQSpecialCareSettingActivity", 2, "QQProgressDialog show exception.", e16);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                case 8194:
                    if (QQSpecialCareSettingActivity.this.f186384a0 != null && QQSpecialCareSettingActivity.this.f186384a0.isShowing()) {
                        QQSpecialCareSettingActivity.this.f186384a0.dismiss();
                        QQSpecialCareSettingActivity.this.f186384a0 = null;
                        return;
                    }
                    return;
                case 8195:
                    if (QQSpecialCareSettingActivity.this.f186397n0 != null) {
                        QQSpecialCareSettingActivity.this.f186397n0.cancel();
                    }
                    QQSpecialCareSettingActivity qQSpecialCareSettingActivity3 = QQSpecialCareSettingActivity.this;
                    qQSpecialCareSettingActivity3.f186397n0 = QQToast.makeText(qQSpecialCareSettingActivity3, message.arg1, message.arg2, 0).show(QQSpecialCareSettingActivity.this.getTitleBarHeight());
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSpecialCareSettingActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(boolean z16, com.tencent.mobileqq.app.msgnotify.f fVar, DialogInterface dialogInterface) {
            String str;
            if (NetworkUtil.isNetworkAvailable(QQSpecialCareSettingActivity.this)) {
                if (TextUtils.isEmpty(QQSpecialCareSettingActivity.this.f186395l0)) {
                    QQSpecialCareSettingActivity.this.f186390g0.setSpecialCareSwitch(1, new String[]{QQSpecialCareSettingActivity.this.f186394k0}, new boolean[]{true});
                } else {
                    NTFriendSettingHelper nTFriendSettingHelper = NTFriendSettingHelper.f352067a;
                    QQSpecialCareSettingActivity qQSpecialCareSettingActivity = QQSpecialCareSettingActivity.this;
                    nTFriendSettingHelper.U(new NTFriendSettingHelper.a(qQSpecialCareSettingActivity.app, qQSpecialCareSettingActivity.f186394k0, QQSpecialCareSettingActivity.this.f186395l0, true, 0), true, true, null);
                }
                QQSpecialCareSettingActivity.this.f186401r0.sendMessage(QQSpecialCareSettingActivity.this.f186401r0.obtainMessage(8193));
            } else {
                Message obtainMessage = QQSpecialCareSettingActivity.this.f186401r0.obtainMessage(8195);
                obtainMessage.arg1 = 0;
                obtainMessage.arg2 = R.string.b3j;
                QQSpecialCareSettingActivity.this.f186401r0.sendMessage(obtainMessage);
                QQSpecialCareSettingActivity qQSpecialCareSettingActivity2 = QQSpecialCareSettingActivity.this;
                qQSpecialCareSettingActivity2.e3(qQSpecialCareSettingActivity2.f186386c0.j(), true ^ QQSpecialCareSettingActivity.this.f186386c0.j().W(), QQSpecialCareSettingActivity.this.f186402s0);
            }
            String currentAccountUin = QQSpecialCareSettingActivity.this.app.getCurrentAccountUin();
            if (z16) {
                str = "SwitchOn";
            } else {
                str = "SwitchOff";
            }
            VasWebviewUtil.reportCommercialDrainage(currentAccountUin, "Care", str, Integer.toString(QQSpecialCareSettingActivity.this.f186396m0), 1, 0, 0, null, null, null);
            fVar.R();
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, final boolean z16) {
            String str;
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("QQSpecialCareSettingActivity", 2, "onCheckedChanged isCheck: " + z16 + ", switched by user.");
                }
                if (QQAppInterface.isNotificationEnabled() == 0 && z16) {
                    QQSpecialCareSettingActivity qQSpecialCareSettingActivity = QQSpecialCareSettingActivity.this;
                    final com.tencent.mobileqq.app.msgnotify.f fVar = new com.tencent.mobileqq.app.msgnotify.f(qQSpecialCareSettingActivity, qQSpecialCareSettingActivity.app, qQSpecialCareSettingActivity.f186394k0);
                    fVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.activity.specialcare.d
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            QQSpecialCareSettingActivity.c.this.b(z16, fVar, dialogInterface);
                        }
                    });
                    fVar.show();
                    ReportController.o(null, "dc00898", "", "", "0X8009ACB", "0X8009ACB", 0, 0, "", "", "", "");
                } else {
                    if (NetworkUtil.isNetworkAvailable(QQSpecialCareSettingActivity.this)) {
                        if (TextUtils.isEmpty(QQSpecialCareSettingActivity.this.f186395l0)) {
                            QQSpecialCareSettingActivity.this.f186390g0.setSpecialCareSwitch(1, new String[]{QQSpecialCareSettingActivity.this.f186394k0}, new boolean[]{z16});
                        } else {
                            NTFriendSettingHelper nTFriendSettingHelper = NTFriendSettingHelper.f352067a;
                            QQSpecialCareSettingActivity qQSpecialCareSettingActivity2 = QQSpecialCareSettingActivity.this;
                            nTFriendSettingHelper.U(new NTFriendSettingHelper.a(qQSpecialCareSettingActivity2.app, qQSpecialCareSettingActivity2.f186394k0, QQSpecialCareSettingActivity.this.f186395l0, z16, 0), z16, z16, null);
                        }
                        QQSpecialCareSettingActivity.this.f186401r0.sendMessage(QQSpecialCareSettingActivity.this.f186401r0.obtainMessage(8193));
                        boolean W = QQSpecialCareSettingActivity.this.f186386c0.j().W();
                        QQSpecialCareSettingActivity.this.f186389f0.j().h0(0);
                        QQSpecialCareSettingActivity.this.d3(W);
                    } else {
                        Message obtainMessage = QQSpecialCareSettingActivity.this.f186401r0.obtainMessage(8195);
                        obtainMessage.arg1 = 0;
                        obtainMessage.arg2 = R.string.b3j;
                        QQSpecialCareSettingActivity.this.f186401r0.sendMessage(obtainMessage);
                        QQSpecialCareSettingActivity qQSpecialCareSettingActivity3 = QQSpecialCareSettingActivity.this;
                        qQSpecialCareSettingActivity3.e3(qQSpecialCareSettingActivity3.f186386c0.j(), true ^ QQSpecialCareSettingActivity.this.f186386c0.j().W(), QQSpecialCareSettingActivity.this.f186402s0);
                    }
                    String currentAccountUin = QQSpecialCareSettingActivity.this.app.getCurrentAccountUin();
                    if (z16) {
                        str = "SwitchOn";
                    } else {
                        str = "SwitchOff";
                    }
                    VasWebviewUtil.reportCommercialDrainage(currentAccountUin, "Care", str, Integer.toString(QQSpecialCareSettingActivity.this.f186396m0), 1, 0, 0, null, null, null);
                }
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class d implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSpecialCareSettingActivity.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("QQSpecialCareSettingActivity", 2, "onCheckedChanged isCheck: " + z16 + ", switched by user.");
                }
                if (NetworkUtil.isNetworkAvailable(QQSpecialCareSettingActivity.this)) {
                    if (TextUtils.isEmpty(QQSpecialCareSettingActivity.this.f186395l0)) {
                        QQSpecialCareSettingActivity.this.f186390g0.setSpecialCareSwitch(2, new String[]{QQSpecialCareSettingActivity.this.f186394k0}, new boolean[]{z16});
                    } else {
                        NTFriendSettingHelper nTFriendSettingHelper = NTFriendSettingHelper.f352067a;
                        QQSpecialCareSettingActivity qQSpecialCareSettingActivity = QQSpecialCareSettingActivity.this;
                        nTFriendSettingHelper.U(new NTFriendSettingHelper.a(qQSpecialCareSettingActivity.app, qQSpecialCareSettingActivity.f186394k0, QQSpecialCareSettingActivity.this.f186395l0, QQSpecialCareSettingActivity.this.f186386c0.j().W(), 1), QQSpecialCareSettingActivity.this.f186387d0.j().W(), QQSpecialCareSettingActivity.this.f186388e0.j().W(), null);
                    }
                } else {
                    Message obtainMessage = QQSpecialCareSettingActivity.this.f186401r0.obtainMessage(8195);
                    obtainMessage.arg1 = 0;
                    obtainMessage.arg2 = R.string.b3j;
                    QQSpecialCareSettingActivity.this.f186401r0.sendMessage(obtainMessage);
                    QQSpecialCareSettingActivity qQSpecialCareSettingActivity2 = QQSpecialCareSettingActivity.this;
                    qQSpecialCareSettingActivity2.e3(qQSpecialCareSettingActivity2.f186387d0.j(), true ^ QQSpecialCareSettingActivity.this.f186387d0.j().W(), QQSpecialCareSettingActivity.this.f186403t0);
                }
                boolean W = QQSpecialCareSettingActivity.this.f186386c0.j().W();
                QQSpecialCareSettingActivity.this.f186389f0.j().h0(0);
                QQSpecialCareSettingActivity.this.d3(W);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class e implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSpecialCareSettingActivity.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("QQSpecialCareSettingActivity", 2, "onCheckedChanged isCheck: " + z16 + ", switched by user.");
                }
                if (NetworkUtil.isNetworkAvailable(QQSpecialCareSettingActivity.this)) {
                    if (TextUtils.isEmpty(QQSpecialCareSettingActivity.this.f186395l0)) {
                        QQSpecialCareSettingActivity.this.f186390g0.setSpecialCareSwitch(3, new String[]{QQSpecialCareSettingActivity.this.f186394k0}, new boolean[]{z16});
                    } else {
                        NTFriendSettingHelper nTFriendSettingHelper = NTFriendSettingHelper.f352067a;
                        QQSpecialCareSettingActivity qQSpecialCareSettingActivity = QQSpecialCareSettingActivity.this;
                        nTFriendSettingHelper.U(new NTFriendSettingHelper.a(qQSpecialCareSettingActivity.app, qQSpecialCareSettingActivity.f186394k0, QQSpecialCareSettingActivity.this.f186395l0, QQSpecialCareSettingActivity.this.f186386c0.j().W(), 2), QQSpecialCareSettingActivity.this.f186387d0.j().W(), QQSpecialCareSettingActivity.this.f186388e0.j().W(), null);
                    }
                } else {
                    Message obtainMessage = QQSpecialCareSettingActivity.this.f186401r0.obtainMessage(8195);
                    obtainMessage.arg1 = 0;
                    obtainMessage.arg2 = R.string.b3j;
                    QQSpecialCareSettingActivity.this.f186401r0.sendMessage(obtainMessage);
                    QQSpecialCareSettingActivity qQSpecialCareSettingActivity2 = QQSpecialCareSettingActivity.this;
                    qQSpecialCareSettingActivity2.e3(qQSpecialCareSettingActivity2.f186388e0.j(), true ^ QQSpecialCareSettingActivity.this.f186388e0.j().W(), QQSpecialCareSettingActivity.this.f186404u0);
                }
                boolean W = QQSpecialCareSettingActivity.this.f186386c0.j().W();
                QQSpecialCareSettingActivity.this.f186389f0.j().h0(0);
                QQSpecialCareSettingActivity.this.d3(W);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class f extends ar {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSpecialCareSettingActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSetSpecialCareSwitch_global(boolean z16, Object[] objArr) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 1;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), objArr);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQSpecialCareSettingActivity", 2, "onSetSpecialCareSwith_global isSuccess: " + z16);
            }
            if (!z16) {
                QQSpecialCareSettingActivity qQSpecialCareSettingActivity = QQSpecialCareSettingActivity.this;
                qQSpecialCareSettingActivity.e3(qQSpecialCareSettingActivity.f186386c0.j(), !QQSpecialCareSettingActivity.this.f186386c0.j().W(), QQSpecialCareSettingActivity.this.f186402s0);
            }
            QQSpecialCareSettingActivity.this.f186401r0.sendEmptyMessage(8194);
            QQSpecialCareSettingActivity.this.f3();
            ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).cleanReqSubAccountSpecialCareListSysTime(QQSpecialCareSettingActivity.this.app);
            if (fb0.a.a("QQSpecialCareSettingActivity")) {
                return;
            }
            Message obtainMessage = QQSpecialCareSettingActivity.this.f186401r0.obtainMessage(8195);
            if (z16) {
                i16 = 2;
            }
            obtainMessage.arg1 = i16;
            if (z16) {
                if (Boolean.valueOf(((boolean[]) objArr[2])[0]).booleanValue()) {
                    i3 = R.string.fu7;
                } else {
                    i3 = R.string.fu6;
                }
            } else if (((boolean[]) objArr[2])[0]) {
                i3 = R.string.fua;
            } else {
                i3 = R.string.f171529fu2;
            }
            obtainMessage.arg2 = i3;
            QQSpecialCareSettingActivity.this.f186401r0.sendMessage(obtainMessage);
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSetSpecialCareSwitch_qzone(boolean z16, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), objArr);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQSpecialCareSettingActivity", 2, "onSetSpecialCareSwith_qzone isSuccess: " + z16);
            }
            if (!z16) {
                QQSpecialCareSettingActivity qQSpecialCareSettingActivity = QQSpecialCareSettingActivity.this;
                qQSpecialCareSettingActivity.e3(qQSpecialCareSettingActivity.f186388e0.j(), !QQSpecialCareSettingActivity.this.f186388e0.j().W(), QQSpecialCareSettingActivity.this.f186404u0);
            }
            QQSpecialCareSettingActivity.this.f3();
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSetSpecialCareSwitch_specialRing(boolean z16, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), objArr);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQSpecialCareSettingActivity", 2, "onSetSpecialCareSwith_specialRing isSuccess: " + z16);
            }
            QQSpecialCareSettingActivity.this.f3();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateDelFriend(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQSpecialCareSettingActivity", 2, "onUpdateDelFriend isSuccess: " + z16 + ", uin: " + obj);
            }
            QQSpecialCareSettingActivity.this.f3();
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateSpecialCareList(boolean z16, boolean z17, ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList, ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.c> arrayList2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Boolean.valueOf(z17), arrayList, arrayList2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQSpecialCareSettingActivity", 2, "onUpdateSpecialCareList isSuccess: " + z16 + ", isComplete: " + z17);
            }
            QQSpecialCareSettingActivity.this.f3();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class g extends cn {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSpecialCareSettingActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.cn
        public void b(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, obj);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQSpecialCareSettingActivity", 2, "onSpecialSoundEvent data: " + obj);
            }
            if (obj != null) {
                QQSpecialCareSettingActivity.this.stopTitleProgress();
                int intValue = ((Integer) obj).intValue();
                if (intValue == 2 || intValue == 3 || intValue == 4) {
                    QQSpecialCareSettingActivity.this.g3();
                }
            }
        }
    }

    public QQSpecialCareSettingActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f186400q0 = new hx3.b<String>() { // from class: com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSpecialCareSettingActivity.this);
                }
            }

            @Override // hx3.b
            public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<String> eVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) eVar);
                    return;
                }
                if (eVar.a() == -1) {
                    QLog.d("QQSpecialCareSettingActivity", 2, "code return error");
                    return;
                }
                ArrayList<String> b16 = eVar.b();
                if (!TextUtils.isEmpty(QQSpecialCareSettingActivity.this.f186394k0) && b16.contains(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(QQSpecialCareSettingActivity.this.f186394k0))) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                QLog.d("QQSpecialCareSettingActivity", 2, "mAnyFriendDataCallback notify data change");
                                QQSpecialCareSettingActivity.this.f3();
                            }
                        }
                    });
                } else {
                    QLog.d("QQSpecialCareSettingActivity", 2, "uidList not contain uid");
                }
            }
        };
        this.f186401r0 = new b();
        this.f186402s0 = new c();
        this.f186403t0 = new d();
        this.f186404u0 = new e();
        this.f186405v0 = new f();
        this.f186406w0 = new g();
    }

    private void b3() {
        SharedPreferences sharedPreferences = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
        String str = "special_care_voice_red_dot" + this.app.getCurrentAccountUin();
        Set a16 = eb.a(sharedPreferences, str, null);
        if (a16 == null) {
            a16 = new HashSet();
        }
        if (a16.add(this.f186394k0)) {
            this.f186398o0 = true;
            SharedPreferences.Editor edit = sharedPreferences.edit();
            eb.c(edit, str, a16.toArray());
            edit.commit();
            VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "Care", "RedShow", "", 1, 0, 0, null, null, null);
        }
    }

    private void c3() {
        if (QLog.isColorLevel()) {
            QLog.d("QQSpecialCareSettingActivity", 2, "loadSpecialSoundConfig start loading...");
        }
        startTitleProgress();
        this.f186391h0.loadSpecialSoundConfig(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d3(boolean z16) {
        if (z16) {
            this.f186389f0.j().d0(getString(R.string.hou));
        } else {
            this.f186389f0.j().d0(getString(R.string.imo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f3() {
        int i3;
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f186394k0);
        this.f186393j0 = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "QQSpecialCareSettingActivity");
        if (QLog.isColorLevel()) {
            QLog.d("QQSpecialCareSettingActivity", 2, "showItems NtFriendSimpleInfo: " + this.f186393j0);
        }
        boolean z16 = true;
        int i16 = 8;
        if (this.f186393j0 == null) {
            if (!this.f186392i0.i0()) {
                this.f186386c0.j().h0(8);
                this.f186386c0.i(false);
                this.f186387d0.j().h0(8);
                this.f186388e0.j().h0(8);
                this.f186389f0.j().h0(8);
                return;
            }
            this.f186386c0.j().h0(0);
            this.f186386c0.i(true);
            this.f186387d0.j().h0(8);
            this.f186388e0.j().h0(8);
            e3(this.f186386c0.j(), false, this.f186402s0);
            return;
        }
        this.f186386c0.j().h0(0);
        this.f186386c0.i(true);
        e3(this.f186386c0.j(), this.f186393j0.F().booleanValue(), this.f186402s0);
        boolean W = this.f186386c0.j().W();
        com.tencent.mobileqq.activity.newsetting.custom.config.b j3 = this.f186387d0.j();
        if (W) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        j3.h0(i3);
        this.f186387d0.j().h0(8);
        com.tencent.mobileqq.activity.newsetting.custom.config.b j16 = this.f186388e0.j();
        if (W) {
            i16 = 0;
        }
        j16.h0(i16);
        com.tencent.qqnt.ntrelation.otherinfo.bean.c otherSimpleInfoWithUid = ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).getOtherSimpleInfoWithUid(uidFromUin, "QQSpecialCareSettingActivity");
        com.tencent.mobileqq.activity.newsetting.custom.config.b j17 = this.f186387d0.j();
        if (otherSimpleInfoWithUid.e() == 0) {
            z16 = false;
        }
        e3(j17, z16, this.f186403t0);
        e3(this.f186388e0.j(), this.f186393j0.G().booleanValue(), this.f186404u0);
        if (this.f186398o0) {
            this.f186389f0.j().j0(getResources().getDrawable(R.drawable.skin_tips_new));
        } else {
            this.f186389f0.j().j0(null);
        }
        this.f186389f0.j().h0(0);
        d3(W);
        if (this.f186389f0.j().Y()) {
            VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "bell", "care_show", "", 1, 0, 0, "", "", "");
        }
        g3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g3() {
        int a16 = com.tencent.mobileqq.notification.util.a.a(this.f186394k0);
        Pair<String, String> t16 = this.f186399p0.t(a16, this.f186394k0, 0);
        QLog.i("QQSpecialCareSettingActivity", 1, "[updatePersonalVoice] uin:" + this.f186394k0 + " ringId:" + a16 + " ringName:" + t16.first);
        this.f186389f0.j().f0(t16.first);
        this.f186389f0.j().c0(t16.second);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        String currentAccountUin;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        ca.a(this);
        setContentView(R.layout.fom);
        setTitle(R.string.fuh);
        setLeftViewName(R.string.button_back);
        SpecialCareSettingView specialCareSettingView = (SpecialCareSettingView) findViewById(R.id.f87174tn);
        this.f186385b0 = specialCareSettingView;
        com.tencent.mobileqq.activity.newsetting.business.group.c2c.special.b l3 = specialCareSettingView.l();
        this.f186386c0 = l3;
        l3.j().e0(this.f186402s0);
        com.tencent.mobileqq.activity.newsetting.business.group.c2c.special.a k3 = this.f186385b0.k();
        this.f186387d0 = k3;
        k3.j().e0(this.f186403t0);
        com.tencent.mobileqq.activity.newsetting.business.group.c2c.special.c m3 = this.f186385b0.m();
        this.f186388e0 = m3;
        m3.j().e0(this.f186404u0);
        com.tencent.mobileqq.activity.newsetting.business.group.c2c.special.d n3 = this.f186385b0.n();
        this.f186389f0 = n3;
        n3.j().h0(0);
        this.f186389f0.j().x(this);
        this.f186394k0 = getIntent().getStringExtra("key_friend_uin");
        this.f186396m0 = getIntent().getIntExtra("key_start_from", 5);
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null) {
            this.f186390g0 = (FriendListHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
            this.f186392i0 = (FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
            this.app.addObserver(this.f186405v0);
            this.app.addObserver(this.f186406w0);
        }
        IQvipSpecialSoundManager specialSoundManager = VasUtil.getService().getSpecialSoundManager();
        this.f186391h0 = specialSoundManager;
        if (!specialSoundManager.isCacheData()) {
            if (QLog.isColorLevel()) {
                QLog.d("QQSpecialCareSettingActivity", 2, "QvipSpecialSoundManager no cache data.");
            }
            c3();
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQSpecialCareSettingActivity", 2, "doOnCreate mFriUin: " + this.f186394k0);
        }
        QQAppInterface qQAppInterface2 = this.app;
        if (qQAppInterface2 == null) {
            currentAccountUin = "";
        } else {
            currentAccountUin = qQAppInterface2.getCurrentAccountUin();
        }
        VasWebviewUtil.reportCommercialDrainage(currentAccountUin, "Care", "PageView", Integer.toString(this.f186396m0), 1, 0, 0, null, null, null);
        b3();
        this.f186386c0.j().c0(getString(R.string.f172976g92));
        MessageNotificationSettingManager l16 = MessageNotificationSettingManager.l(this.app);
        this.f186399p0 = l16;
        l16.V(this);
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).addChangeFriendUidsCallBack("QQSpecialCareSettingActivity", this.f186400q0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnDestroy();
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.f186406w0);
            this.app.removeObserver(this.f186405v0);
            MessageNotificationSettingManager.l(this.app).P(this);
        }
        if (this.f186400q0 != null) {
            this.f186400q0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnResume();
        this.f186399p0.f(this.f186394k0, 0);
        f3();
        d3(this.f186386c0.j().W());
        g3();
    }

    void e3(com.tencent.mobileqq.activity.newsetting.custom.config.b bVar, boolean z16, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        bVar.e0(null);
        bVar.a0(z16);
        bVar.e0(onCheckedChangeListener);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (getIntent().getBooleanExtra("key_is_from_management_activity", false)) {
            setResult(-1);
        }
        super.finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else if (this.f186389f0.j().X(view)) {
            String buildTraceDetailUrl = com.tencent.mobileqq.vip.api.e.a().buildTraceDetailUrl(IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.SPECIALCARE_MALL_URL).replace("[uid]", this.f186394k0).replace("[lType]", "2"), IVipTraceDetailReport.FROM.SPECIALCARE_MALL_C2C_SPECIALCARE_SETTINGS);
            if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
                ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(this, buildTraceDetailUrl);
            } else {
                Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", buildTraceDetailUrl);
                startActivity(intent);
            }
            this.f186398o0 = false;
            ReportController.o(null, "dc00898", "", "", "0X800A3C5", "0X800A3C5", 2, 0, "", "", "", "");
            VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "bell", " care_click", "", 1, 0, 0, "", "", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.chat.MessageNotificationSettingManager.c
    public void r8(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        Pair<String, String> t16 = this.f186399p0.t(i3, this.f186394k0, 0);
        QLog.i("QQSpecialCareSettingActivity", 1, "onRingDownloaded ringId:" + i3 + " ringName:" + t16.first);
        this.f186389f0.j().f0(t16.first);
        this.f186389f0.j().c0(t16.second);
    }
}
