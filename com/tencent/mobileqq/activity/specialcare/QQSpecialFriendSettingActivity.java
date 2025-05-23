package com.tencent.mobileqq.activity.specialcare;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.cn;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.dt;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QQSpecialFriendSettingActivity extends IphoneTitleBarActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private FormSimpleItem f186416a0;

    /* renamed from: b0, reason: collision with root package name */
    private FormSwitchItem f186417b0;

    /* renamed from: c0, reason: collision with root package name */
    private FormSwitchItem f186418c0;

    /* renamed from: d0, reason: collision with root package name */
    private View f186419d0;

    /* renamed from: e0, reason: collision with root package name */
    private QQProgressDialog f186420e0;

    /* renamed from: f0, reason: collision with root package name */
    private View f186421f0;

    /* renamed from: g0, reason: collision with root package name */
    private ImageView f186422g0;

    /* renamed from: h0, reason: collision with root package name */
    private TextView f186423h0;

    /* renamed from: i0, reason: collision with root package name */
    private FriendListHandler f186424i0;

    /* renamed from: j0, reason: collision with root package name */
    private IQvipSpecialSoundManager f186425j0;

    /* renamed from: k0, reason: collision with root package name */
    private FriendsManager f186426k0;

    /* renamed from: l0, reason: collision with root package name */
    private String f186427l0;

    /* renamed from: m0, reason: collision with root package name */
    private int f186428m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f186429n0;

    /* renamed from: o0, reason: collision with root package name */
    private IFaceDecoder f186430o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f186431p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f186432q0;

    /* renamed from: r0, reason: collision with root package name */
    final Handler f186433r0;

    /* renamed from: s0, reason: collision with root package name */
    private ar f186434s0;

    /* renamed from: t0, reason: collision with root package name */
    private cn f186435t0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        class DialogInterfaceOnDismissListenerC7211a implements DialogInterface.OnDismissListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.app.msgnotify.f f186437d;

            DialogInterfaceOnDismissListenerC7211a(com.tencent.mobileqq.app.msgnotify.f fVar) {
                this.f186437d = fVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) fVar);
                }
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QQSpecialFriendSettingActivity", 2, "finish all settings when dialog dismiss");
                }
                if (NetworkUtil.isNetworkAvailable(QQSpecialFriendSettingActivity.this)) {
                    boolean isChecked = QQSpecialFriendSettingActivity.this.f186417b0.isChecked();
                    boolean isChecked2 = QQSpecialFriendSettingActivity.this.f186418c0.isChecked();
                    QQSpecialFriendSettingActivity.this.f186424i0.setSpecialCareSwitchesOfAPerson(QQSpecialFriendSettingActivity.this.f186427l0, new int[]{2, 3}, new boolean[]{isChecked, isChecked2}, new String[]{String.valueOf(QQSpecialFriendSettingActivity.this.f186428m0), null});
                    Message obtainMessage = QQSpecialFriendSettingActivity.this.f186433r0.obtainMessage(8193);
                    obtainMessage.obj = QQSpecialFriendSettingActivity.this.getString(R.string.f171531fu4);
                    QQSpecialFriendSettingActivity.this.f186433r0.sendMessage(obtainMessage);
                    if (isChecked && isChecked2) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    ReportController.o(null, "CliOper", "", "", "0X80050E2", "0X80050E2", 0, 0, str, "", "", "");
                } else {
                    Message obtainMessage2 = QQSpecialFriendSettingActivity.this.f186433r0.obtainMessage(8195);
                    obtainMessage2.arg1 = 0;
                    obtainMessage2.arg2 = R.string.b3j;
                    QQSpecialFriendSettingActivity.this.f186433r0.sendMessage(obtainMessage2);
                }
                this.f186437d.R();
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSpecialFriendSettingActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (QQAppInterface.isNotificationEnabled() == 0) {
                QQSpecialFriendSettingActivity qQSpecialFriendSettingActivity = QQSpecialFriendSettingActivity.this;
                com.tencent.mobileqq.app.msgnotify.f fVar = new com.tencent.mobileqq.app.msgnotify.f(qQSpecialFriendSettingActivity, qQSpecialFriendSettingActivity.app, qQSpecialFriendSettingActivity.f186427l0);
                fVar.setOnDismissListener(new DialogInterfaceOnDismissListenerC7211a(fVar));
                fVar.show();
                ReportController.o(null, "dc00898", "", "", "0X8009ACB", "0X8009ACB", 0, 0, "", "", "", "");
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("QQSpecialFriendSettingActivity", 2, "finish all setings");
                }
                if (NetworkUtil.isNetworkAvailable(QQSpecialFriendSettingActivity.this)) {
                    boolean isChecked = QQSpecialFriendSettingActivity.this.f186417b0.isChecked();
                    boolean isChecked2 = QQSpecialFriendSettingActivity.this.f186418c0.isChecked();
                    QQSpecialFriendSettingActivity.this.f186424i0.setSpecialCareSwitchesOfAPerson(QQSpecialFriendSettingActivity.this.f186427l0, new int[]{2, 3}, new boolean[]{isChecked, isChecked2}, new String[]{String.valueOf(QQSpecialFriendSettingActivity.this.f186428m0), null});
                    Message obtainMessage = QQSpecialFriendSettingActivity.this.f186433r0.obtainMessage(8193);
                    obtainMessage.obj = QQSpecialFriendSettingActivity.this.getString(R.string.f171531fu4);
                    QQSpecialFriendSettingActivity.this.f186433r0.sendMessage(obtainMessage);
                    if (isChecked && isChecked2) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    ReportController.o(null, "CliOper", "", "", "0X80050E2", "0X80050E2", 0, 0, str, "", "", "");
                } else {
                    Message obtainMessage2 = QQSpecialFriendSettingActivity.this.f186433r0.obtainMessage(8195);
                    obtainMessage2.arg1 = 0;
                    obtainMessage2.arg2 = R.string.b3j;
                    QQSpecialFriendSettingActivity.this.f186433r0.sendMessage(obtainMessage2);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements com.tencent.mobileqq.activity.specialcare.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSpecialFriendSettingActivity.this);
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
                QLog.d("QQSpecialFriendSettingActivity", 2, "loadSpecialSoundConfig onResult: " + z16);
            }
            try {
                try {
                    if (z16) {
                        QQSpecialFriendSettingActivity.this.W2();
                    } else if (QLog.isColorLevel()) {
                        QLog.i("QQSpecialFriendSettingActivity", 2, "loadSpecialSoundConfig fail.");
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            } finally {
                QQSpecialFriendSettingActivity.this.stopTitleProgress();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c extends Handler {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSpecialFriendSettingActivity.this);
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
                    if (QQSpecialFriendSettingActivity.this.f186420e0 == null) {
                        QQSpecialFriendSettingActivity qQSpecialFriendSettingActivity = QQSpecialFriendSettingActivity.this;
                        QQSpecialFriendSettingActivity qQSpecialFriendSettingActivity2 = QQSpecialFriendSettingActivity.this;
                        qQSpecialFriendSettingActivity.f186420e0 = new QQProgressDialog(qQSpecialFriendSettingActivity2, qQSpecialFriendSettingActivity2.getTitleBarHeight());
                        Object obj = message.obj;
                        if (obj != null && (obj instanceof String)) {
                            QQSpecialFriendSettingActivity.this.f186420e0.setMessage((String) message.obj);
                        }
                    }
                    if (!QQSpecialFriendSettingActivity.this.isFinishing() && !QQSpecialFriendSettingActivity.this.f186420e0.isShowing()) {
                        try {
                            QQSpecialFriendSettingActivity.this.f186420e0.show();
                            return;
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e("QQSpecialFriendSettingActivity", 2, "QQProgressDialog show exception.", e16);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                case 8194:
                    if (QQSpecialFriendSettingActivity.this.f186420e0 != null && QQSpecialFriendSettingActivity.this.f186420e0.isShowing()) {
                        QQSpecialFriendSettingActivity.this.f186420e0.dismiss();
                        QQSpecialFriendSettingActivity.this.f186420e0 = null;
                        return;
                    }
                    return;
                case 8195:
                    QQToast.makeText(QQSpecialFriendSettingActivity.this, message.arg1, message.arg2, 0).show(QQSpecialFriendSettingActivity.this.getTitleBarHeight());
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class d extends ar {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSpecialFriendSettingActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSetSpecialCareSwitch_global(boolean z16, Object[] objArr) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 1;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), objArr);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQSpecialFriendSettingActivity", 2, "onSetSpecialCareSwith_global isSuccess: " + z16 + ",isFromForwardFriendActivity=" + QQSpecialFriendSettingActivity.this.f186429n0);
            }
            if (QQSpecialFriendSettingActivity.this.f186429n0) {
                return;
            }
            QQSpecialFriendSettingActivity.this.f186433r0.sendEmptyMessage(8194);
            Message obtainMessage = QQSpecialFriendSettingActivity.this.f186433r0.obtainMessage(8195);
            if (z16) {
                i16 = 2;
            }
            obtainMessage.arg1 = i16;
            if (z16) {
                i3 = R.string.b1d;
            } else {
                i3 = R.string.f171529fu2;
            }
            obtainMessage.arg2 = i3;
            QQSpecialFriendSettingActivity.this.f186433r0.sendMessage(obtainMessage);
            if (z16) {
                QQSpecialFriendSettingActivity.this.finish();
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSetSpecialCareSwitch_qzone(boolean z16, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), objArr);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQSpecialFriendSettingActivity", 2, "onSetSpecialCareSwith_qzone isSuccess: " + z16);
            }
            if (!QQSpecialFriendSettingActivity.this.f186429n0 && !z16) {
                QQSpecialFriendSettingActivity qQSpecialFriendSettingActivity = QQSpecialFriendSettingActivity.this;
                qQSpecialFriendSettingActivity.U2(qQSpecialFriendSettingActivity.f186418c0, !QQSpecialFriendSettingActivity.this.f186418c0.isChecked());
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSetSpecialCareSwitch_specialRing(boolean z16, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), objArr);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQSpecialFriendSettingActivity", 2, "onSetSpecialCareSwith_specialRing isSuccess: " + z16);
            }
            if (!QQSpecialFriendSettingActivity.this.f186429n0) {
                QQSpecialFriendSettingActivity.this.V2();
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSetSpecialCareSwitchesOfAPerson(boolean z16, Object[] objArr) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), objArr);
                return;
            }
            if (fb0.a.a("QQSpecialFriendSettingActivity")) {
                return;
            }
            int intValue = ((Integer) objArr[0]).intValue();
            if (QLog.isColorLevel()) {
                QLog.d("QQSpecialFriendSettingActivity", 2, "onSetSpecialCareSwitchesOfAPerson isSuccess: " + z16 + ",isFromForwardFriendActivity=" + QQSpecialFriendSettingActivity.this.f186429n0 + ",result=" + intValue);
            }
            if (!QQSpecialFriendSettingActivity.this.f186429n0) {
                return;
            }
            QQSpecialFriendSettingActivity.this.f186433r0.sendEmptyMessage(8194);
            if (!z16 || intValue != 0) {
                i16 = 1;
            }
            if (z16 && intValue == 0) {
                i3 = R.string.b1d;
            } else {
                i3 = R.string.ftz;
            }
            QQToastUtil.showQQToastInUiThread(i16, HardCodeUtil.qqStr(i3));
            if (z16 && intValue == 0) {
                if (!QQSpecialFriendSettingActivity.this.f186431p0) {
                    QQSpecialFriendSettingActivity.this.f186432q0 = true;
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(QQSpecialFriendSettingActivity.this, SpecailCareListActivity.class);
                intent.addFlags(67108864);
                intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, QQSpecialFriendSettingActivity.this.getString(R.string.d5c));
                QQSpecialFriendSettingActivity.this.startActivity(intent);
                QQSpecialFriendSettingActivity.this.finish();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateDelFriend(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQSpecialFriendSettingActivity", 2, "onUpdateDelFriend isSuccess: " + z16 + ", uin: " + obj);
            }
            if (z16 && QQSpecialFriendSettingActivity.this.f186427l0.equals(String.valueOf(obj))) {
                QQSpecialFriendSettingActivity.this.finish();
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateSpecialCareList(boolean z16, boolean z17, ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList, ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.c> arrayList2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Boolean.valueOf(z17), arrayList, arrayList2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQSpecialFriendSettingActivity", 2, "onUpdateSpecialCareList isSuccess: " + z16 + ", isComplete: " + z17);
            }
            QQSpecialFriendSettingActivity.this.V2();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class e extends cn {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSpecialFriendSettingActivity.this);
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
                QLog.d("QQSpecialFriendSettingActivity", 2, "onSpecialSoundEvent data: " + obj);
            }
            if (obj != null) {
                QQSpecialFriendSettingActivity.this.stopTitleProgress();
                int intValue = ((Integer) obj).intValue();
                if (intValue == 2 || intValue == 3 || intValue == 4) {
                    QQSpecialFriendSettingActivity.this.W2();
                }
            }
        }
    }

    public QQSpecialFriendSettingActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f186431p0 = true;
        this.f186432q0 = false;
        this.f186433r0 = new c();
        this.f186434s0 = new d();
        this.f186435t0 = new e();
    }

    private void T2() {
        if (QLog.isColorLevel()) {
            QLog.d("QQSpecialFriendSettingActivity", 2, "loadSpecialSoundConfig start loading...");
        }
        startTitleProgress();
        this.f186425j0.loadSpecialSoundConfig(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V2() {
        boolean z16;
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f186427l0);
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        boolean specialCareGlobalSwitch = iFriendsInfoService.getSpecialCareGlobalSwitch(uidFromUin, "QQSpecialFriendSettingActivity");
        if (QLog.isColorLevel()) {
            QLog.d("QQSpecialFriendSettingActivity", 2, "showItems isSpecialFriend: " + specialCareGlobalSwitch);
        }
        int i3 = 8;
        if (!specialCareGlobalSwitch) {
            if (!this.f186429n0) {
                this.f186417b0.setVisibility(8);
                this.f186418c0.setVisibility(8);
                this.f186419d0.setVisibility(8);
                this.f186416a0.setVisibility(8);
                this.f186421f0.setVisibility(8);
                return;
            }
            this.f186421f0.setVisibility(8);
            W2();
            return;
        }
        this.f186417b0.setVisibility(8);
        this.f186418c0.setVisibility(0);
        this.f186419d0.setVisibility(0);
        if (!this.f186429n0) {
            this.f186421f0.setVisibility(0);
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = iFriendsInfoService.getFriendsSimpleInfoWithUid(uidFromUin, "QQSpecialFriendSettingActivity");
        com.tencent.qqnt.ntrelation.otherinfo.bean.c otherSimpleInfoWithUid = ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).getOtherSimpleInfoWithUid(uidFromUin, "QQSpecialFriendSettingActivity");
        FormSwitchItem formSwitchItem = this.f186417b0;
        if (otherSimpleInfoWithUid.e() == 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        U2(formSwitchItem, z16);
        U2(this.f186418c0, friendsSimpleInfoWithUid.G().booleanValue());
        FormSimpleItem formSimpleItem = this.f186416a0;
        if (this.f186417b0.isChecked()) {
            i3 = 0;
        }
        formSimpleItem.setVisibility(i3);
        this.f186416a0.setVisibility(0);
        W2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W2() {
        String str;
        if (this.f186429n0) {
            int i3 = dt.a(BaseApplication.getContext(), "com.tencent.mobileqq_preferences").getInt(AppConstants.Preferences.SPECIAL_ID_CACHE + this.f186427l0, 1);
            this.f186428m0 = i3;
            String soundName = this.f186425j0.getSoundName(i3);
            FormSimpleItem formSimpleItem = this.f186416a0;
            if (TextUtils.isEmpty(soundName)) {
                str = getString(R.string.ck5);
            } else {
                str = soundName;
            }
            formSimpleItem.setRightText(str);
            if (QLog.isColorLevel()) {
                QLog.d("QQSpecialFriendSettingActivity", 2, "updatePersonalVoice FromForwardFriendActivity mFriUin: " + this.f186427l0 + ", soundId: " + this.f186428m0 + ", soundName: " + soundName);
                return;
            }
            return;
        }
        if (com.tencent.mobileqq.activity.specialcare.e.p(this.f186427l0, this.app)) {
            if (!this.f186425j0.isCacheData()) {
                T2();
            }
            int o16 = com.tencent.mobileqq.activity.specialcare.e.o(this.f186427l0, this.app);
            String soundName2 = this.f186425j0.getSoundName(o16);
            if (QLog.isColorLevel()) {
                QLog.d("QQSpecialFriendSettingActivity", 2, "updatePersonalVoice mFriUin: " + this.f186427l0 + ", soundId: " + o16 + ", soundName: " + soundName2);
            }
            FormSimpleItem formSimpleItem2 = this.f186416a0;
            if (TextUtils.isEmpty(soundName2)) {
                soundName2 = getString(R.string.ck5);
            }
            formSimpleItem2.setRightText(soundName2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQSpecialFriendSettingActivity", 2, "updatePersonalVoice not contain friend: " + this.f186427l0);
        }
        this.f186416a0.setRightText(getString(R.string.ck5));
    }

    private void initData() {
        IQvipSpecialSoundManager specialSoundManager = VasUtil.getService().getSpecialSoundManager();
        this.f186425j0 = specialSoundManager;
        if (!specialSoundManager.isCacheData()) {
            if (QLog.isColorLevel()) {
                QLog.d("QQSpecialFriendSettingActivity", 2, "QvipSpecialSoundManager no cache data.");
            }
            T2();
        }
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
        this.f186430o0 = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
        Bitmap bitmapFromCache = this.f186430o0.getBitmapFromCache(1, this.f186427l0, 0);
        if (bitmapFromCache == null) {
            if (!this.f186430o0.isPausing()) {
                this.f186430o0.requestDecodeFace(this.f186427l0, 1, true);
            }
            this.f186422g0.setBackgroundDrawable((BitmapDrawable) BaseImageUtil.getDefaultFaceDrawable140_140());
        } else {
            this.f186422g0.setBackgroundDrawable(new BitmapDrawable(bitmapFromCache));
        }
        com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
        aVar.d(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f186427l0));
        String nameWithConfig = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
        if (TextUtils.isEmpty(nameWithConfig)) {
            this.f186423h0.setText(this.f186427l0);
        } else {
            this.f186423h0.setText(nameWithConfig);
        }
    }

    private void initUI() {
        FormSimpleItem formSimpleItem = (FormSimpleItem) findViewById(R.id.flz);
        this.f186416a0 = formSimpleItem;
        formSimpleItem.setOnClickListener(this);
        this.f186416a0.setVisibility(0);
        FormSwitchItem formSwitchItem = (FormSwitchItem) findViewById(R.id.co7);
        this.f186417b0 = formSwitchItem;
        formSwitchItem.setVisibility(8);
        this.f186417b0.setOnCheckedChangeListener(this);
        FormSwitchItem formSwitchItem2 = (FormSwitchItem) findViewById(R.id.cof);
        this.f186418c0 = formSwitchItem2;
        formSwitchItem2.setOnCheckedChangeListener(this);
        this.f186419d0 = findViewById(R.id.hlc);
        View findViewById = findViewById(R.id.aoq);
        this.f186421f0 = findViewById;
        findViewById.setOnClickListener(this);
        this.f186422g0 = (ImageView) findViewById(R.id.f165128c23);
        this.f186423h0 = (TextView) findViewById(R.id.nickname);
        if (this.f186429n0) {
            setLeftViewName(R.string.f170028dd);
            setRightButton(R.string.b9f, new a());
            this.f186421f0.setVisibility(8);
        } else {
            setLeftViewName(R.string.c7a);
        }
        if (AppSetting.f99565y) {
            this.f186417b0.setContentDescription(getString(R.string.fuc));
            this.f186418c0.setContentDescription(getString(R.string.fud));
        }
    }

    void U2(FormSwitchItem formSwitchItem, boolean z16) {
        formSwitchItem.setOnCheckedChangeListener(null);
        formSwitchItem.setChecked(z16);
        formSwitchItem.setOnCheckedChangeListener(this);
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        setContentView(R.layout.f168879b35);
        setTitle(R.string.fuh);
        Intent intent = getIntent();
        this.f186427l0 = intent.getStringExtra("key_friend_uin");
        this.f186429n0 = intent.getBooleanExtra("key_is_from_friendsforward_activity", false);
        initUI();
        this.f186424i0 = (FriendListHandler) this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        this.f186426k0 = (FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        this.app.addObserver(this.f186434s0);
        this.app.addObserver(this.f186435t0);
        initData();
        ReportController.o(null, "CliOper", "", "", "0X80050E5", "0X80050E5", 0, 0, "0", "", "", "");
        if (QLog.isColorLevel()) {
            QLog.d("QQSpecialFriendSettingActivity", 2, "doOnCreate mFriUin: " + this.f186427l0);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        SharedPreferences a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnDestroy();
        IFaceDecoder iFaceDecoder = this.f186430o0;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.f186435t0);
            this.app.removeObserver(this.f186434s0);
        }
        if (this.f186429n0 && (a16 = dt.a(BaseApplication.getContext(), "com.tencent.mobileqq_preferences")) != null) {
            a16.edit().remove(AppConstants.Preferences.SPECIAL_ID_CACHE + this.f186427l0).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.doOnPause();
            this.f186431p0 = false;
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
        V2();
        this.f186431p0 = true;
        if (this.f186432q0) {
            this.f186432q0 = false;
            Intent intent = new Intent();
            intent.setClass(this, SpecailCareListActivity.class);
            intent.addFlags(67108864);
            intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, getString(R.string.d5c));
            startActivity(intent);
            finish();
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        FormSwitchItem formSwitchItem;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 3;
        int i16 = 8;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, compoundButton, Boolean.valueOf(z16));
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("QQSpecialFriendSettingActivity", 2, "onCheckedChanged isCheck: " + z16 + ", switched by user.");
            }
            FormSimpleItem formSimpleItem = this.f186416a0;
            if (this.f186417b0.isChecked()) {
                i16 = 0;
            }
            formSimpleItem.setVisibility(i16);
            if (!this.f186429n0) {
                if (compoundButton == this.f186417b0.getSwitch()) {
                    formSwitchItem = this.f186417b0;
                    i3 = 2;
                } else if (compoundButton == this.f186418c0.getSwitch()) {
                    formSwitchItem = this.f186418c0;
                }
                if (NetworkUtil.isNetworkAvailable(this)) {
                    this.f186424i0.setSpecialCareSwitch(i3, new String[]{this.f186427l0}, new boolean[]{z16});
                } else {
                    Message obtainMessage = this.f186433r0.obtainMessage(8195);
                    obtainMessage.arg1 = 0;
                    obtainMessage.arg2 = R.string.b3j;
                    this.f186433r0.sendMessage(obtainMessage);
                    U2(formSwitchItem, !formSwitchItem.isChecked());
                }
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id5;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            if (view == null) {
                id5 = 0;
            } else {
                id5 = view.getId();
            }
            if (id5 == R.id.flz) {
                Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", (IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.SPECIALCARE_MALL_URL) + "&suin=" + this.f186427l0 + "&uin=" + this.app.getCurrentAccountUin() + "&_bid=279&lazy=" + this.f186429n0).replace("[uid]", this.f186427l0).replace("[lType]", "2"));
                intent.putExtra("uin", this.f186427l0);
                intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                startActivity(intent);
            } else if (id5 == R.id.aoq) {
                if (NetworkUtil.isNetworkAvailable(this)) {
                    this.f186424i0.setSpecialCareSwitch(1, new String[]{this.f186427l0}, new boolean[]{false});
                    Message obtainMessage = this.f186433r0.obtainMessage(8193);
                    obtainMessage.obj = getString(R.string.f171530fu3);
                    this.f186433r0.sendMessage(obtainMessage);
                } else {
                    Message obtainMessage2 = this.f186433r0.obtainMessage(8195);
                    obtainMessage2.arg1 = 0;
                    obtainMessage2.arg2 = R.string.b3j;
                    this.f186433r0.sendMessage(obtainMessage2);
                }
                ReportController.o(null, "CliOper", "", "", "0X80050E6", "0X80050E6", 0, 0, "0", "", "", "");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQSpecialFriendSettingActivity", 2, "uin=" + str + ", type=" + i16 + ",avatar= " + bitmap);
        }
        if (bitmap != null && !this.f186430o0.isPausing()) {
            this.f186422g0.setBackgroundDrawable(new BitmapDrawable(bitmap));
        }
    }
}
