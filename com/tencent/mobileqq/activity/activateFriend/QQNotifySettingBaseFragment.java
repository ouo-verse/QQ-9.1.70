package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsGetMsgRsp;
import Wallet.AcsMsg;
import Wallet.AcsSubNoticeRsp;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.ipc.IComIPCUtils;
import com.tencent.mobileqq.reminder.api.IQQReminderCalendarService;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.reminder.api.IQQReminderService;
import com.tencent.mobileqq.reminder.biz.entity.CalendarEntity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.mobileqq.webview.swift.ao;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qwallet.plugin.FakeUrl;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.mobilereport.ReportParamsConst;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class QQNotifySettingBaseFragment extends PublicBaseFragment implements View.OnClickListener, com.tencent.mobileqq.activity.activateFriend.biz.a {
    static IPatchRedirector $redirector_;
    private static final String T;
    public static final int U;
    private final Handler C;
    protected View D;
    protected TextView E;
    protected TextView F;
    protected Button G;
    protected CheckBox H;
    private ab I;
    private IQQReminderDataService J;
    private CalendarEntity K;
    protected boolean L;
    boolean M;
    private String N;
    private String P;
    private String Q;
    protected int R;
    protected String S;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67676);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            T = QQNotifySettingBaseFragment.class.getSimpleName();
            U = ao.b(QWalletMixJsPlugin.OBJECT_NAME_QWALLET_MIX) << 8;
        }
    }

    public QQNotifySettingBaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.C = new Handler(Looper.getMainLooper());
        this.R = 9;
        this.S = "user cancel";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QQAppInterface Bh() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            return (QQAppInterface) runtime;
        }
        return null;
    }

    private void Dh() {
        IQQReminderService iQQReminderService = (IQQReminderService) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IQQReminderService.class, "");
        if (iQQReminderService == null) {
            return;
        }
        iQQReminderService.sendGetMsgs(this.N, this.Q, new BusinessObserver() { // from class: com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQNotifySettingBaseFragment.this);
                }
            }

            @Override // mqq.observer.BusinessObserver
            public void onReceive(int i3, boolean z16, Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                    return;
                }
                if (QQNotifySettingBaseFragment.this.I.isShowing() && QQNotifySettingBaseFragment.this.I != null) {
                    QQNotifySettingBaseFragment.this.I.dismiss();
                }
                if (i3 == 2005) {
                    if (QLog.isColorLevel()) {
                        QLog.d(QQNotifySettingBaseFragment.T, 2, "acs msg succ");
                    }
                    if (z16) {
                        AcsGetMsgRsp acsGetMsgRsp = (AcsGetMsgRsp) bundle.getSerializable("rsp");
                        if (acsGetMsgRsp != null) {
                            QQNotifySettingBaseFragment qQNotifySettingBaseFragment = QQNotifySettingBaseFragment.this;
                            qQNotifySettingBaseFragment.K = qQNotifySettingBaseFragment.zh(acsGetMsgRsp);
                            QQNotifySettingBaseFragment.this.C.post(new Runnable(acsGetMsgRsp) { // from class: com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment.1.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ AcsGetMsgRsp f177872d;

                                {
                                    this.f177872d = acsGetMsgRsp;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) acsGetMsgRsp);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                    } else {
                                        QQNotifySettingBaseFragment.this.Eh(this.f177872d);
                                    }
                                }
                            });
                            return;
                        }
                        QQNotifySettingBaseFragment.this.C.post(new Runnable() { // from class: com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment.1.2
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    QQNotifySettingBaseFragment.this.Jf();
                                }
                            }
                        });
                        return;
                    }
                    QQNotifySettingBaseFragment.this.Jf();
                }
            }
        });
    }

    private void Fh() {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        IQQReminderService iQQReminderService = (IQQReminderService) qQAppInterface.getRuntimeService(IQQReminderService.class, "");
        if (iQQReminderService == null) {
            return;
        }
        iQQReminderService.sendSubscribeReminder(this.N, this.Q, new BusinessObserver(qQAppInterface) { // from class: com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f177875d;

            {
                this.f177875d = qQAppInterface;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQNotifySettingBaseFragment.this, (Object) qQAppInterface);
                }
            }

            @Override // mqq.observer.BusinessObserver
            public void onReceive(int i3, boolean z16, Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                    return;
                }
                if (i3 == 2002) {
                    try {
                        if (z16) {
                            QQNotifySettingBaseFragment.this.C.post(new Runnable(bundle) { // from class: com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment.2.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ Bundle f177877d;

                                /* compiled from: P */
                                /* renamed from: com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment$2$1$a */
                                /* loaded from: classes9.dex */
                                class a implements DialogInterface.OnClickListener {
                                    static IPatchRedirector $redirector_;

                                    a() {
                                        IPatchRedirector iPatchRedirector = $redirector_;
                                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                        }
                                    }

                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i3) {
                                        IPatchRedirector iPatchRedirector = $redirector_;
                                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                                        } else {
                                            QLog.w(QQNotifySettingBaseFragment.T, 1, "subNotifyMsg dialog onClick");
                                        }
                                    }
                                }

                                {
                                    this.f177877d = bundle;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) bundle);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    JSONObject jSONObject;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    AcsSubNoticeRsp acsSubNoticeRsp = (AcsSubNoticeRsp) this.f177877d.getSerializable("rsp");
                                    if (acsSubNoticeRsp == null) {
                                        QQNotifySettingBaseFragment.this.T6(3, "system error");
                                        return;
                                    }
                                    int i16 = acsSubNoticeRsp.ret_code;
                                    String str = acsSubNoticeRsp.err_str;
                                    QLog.i(QQNotifySettingBaseFragment.T, 1, "QQReminderServlet.sendSubscribeReminder retCode: " + i16 + " msg: " + str);
                                    if (i16 != 0) {
                                        if (i16 == 2) {
                                            QLog.i(QQNotifySettingBaseFragment.T, 1, "subNotifyMsg occur SUBSCRIBE_LIMIT: " + acsSubNoticeRsp.err_str);
                                            try {
                                                jSONObject = new JSONObject(acsSubNoticeRsp.err_str);
                                            } catch (JSONException e16) {
                                                QLog.w(QQNotifySettingBaseFragment.T, 1, "subNotifyMsg fail: ", e16);
                                                jSONObject = null;
                                            }
                                            if (jSONObject != null) {
                                                QQCustomDialog qQCustomDialog = new QQCustomDialog(QQNotifySettingBaseFragment.this.getActivity(), R.style.qZoneInputDialog);
                                                qQCustomDialog.setContentView(R.layout.f167856jn);
                                                qQCustomDialog.setTitle(jSONObject.optString("title"));
                                                qQCustomDialog.setMessageWithoutAutoLink(jSONObject.optString("retmsg"));
                                                qQCustomDialog.setPositiveButton(jSONObject.optString(FakeUrl.FAKE_RBUTTON), new a());
                                                qQCustomDialog.setCanceledOnTouchOutside(true);
                                                qQCustomDialog.setCancelable(false);
                                                qQCustomDialog.setCanceledOnTouchOutside(false);
                                                qQCustomDialog.show();
                                            }
                                        }
                                    } else {
                                        AcsMsg acsMsg = acsSubNoticeRsp.f25141msg;
                                        QLog.i(QQNotifySettingBaseFragment.T, 1, "QQReminderServlet.sendSubscribeReminder subscribe succ acsMsg: " + acsMsg);
                                        if (acsMsg != null && p.c(acsMsg.notice_time * 1000)) {
                                            QQNotifySettingBaseFragment.this.J.saveReminderMsg(acsMsg);
                                        }
                                        CheckBox checkBox = QQNotifySettingBaseFragment.this.H;
                                        if (checkBox != null) {
                                            checkBox.setClickable(false);
                                            if (QQNotifySettingBaseFragment.this.H.isChecked()) {
                                                ((IQQReminderCalendarService) AnonymousClass2.this.f177875d.getRuntimeService(IQQReminderCalendarService.class, "")).setCalendarAlarm(QQNotifySettingBaseFragment.this.getQBaseActivity(), QQNotifySettingBaseFragment.this.K);
                                            }
                                        }
                                        boolean isNetSupport = NetworkUtil.isNetSupport(QQNotifySettingBaseFragment.this.getBaseActivity());
                                        QLog.i(QQNotifySettingBaseFragment.T, 1, "QQReminderServlet.sendSubscribeReminder isNerSupport: " + isNetSupport);
                                        if (isNetSupport) {
                                            if (QQNotifySettingBaseFragment.this.Bh() != null) {
                                                ActivateFriendsManager activateFriendsManager = (ActivateFriendsManager) QQNotifySettingBaseFragment.this.Bh().getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
                                                if (activateFriendsManager != null) {
                                                    boolean u16 = activateFriendsManager.u(true);
                                                    QLog.i(QQNotifySettingBaseFragment.T, 1, "QQReminderServlet.sendSubscribeReminder prepare open notify switch isOpened: " + u16);
                                                    if (!u16) {
                                                        QLog.i(QQNotifySettingBaseFragment.T, 1, "QQReminderServlet.sendSubscribeReminder setQQReminderSwitch");
                                                        activateFriendsManager.L(true, true);
                                                    }
                                                }
                                            } else {
                                                boolean isQQReminderOpen = ((IComIPCUtils) QRoute.api(IComIPCUtils.class)).isQQReminderOpen();
                                                QLog.i(QQNotifySettingBaseFragment.T, 1, "QQReminderServlet.sendSubscribeReminder prepare open notify switch isOpened: " + isQQReminderOpen);
                                                if (!isQQReminderOpen) {
                                                    QLog.i(QQNotifySettingBaseFragment.T, 1, "QQReminderServlet.sendSubscribeReminder setQQReminderSwitch");
                                                    ((IComIPCUtils) QRoute.api(IComIPCUtils.class)).setQQReminderSwitch(true);
                                                }
                                            }
                                        }
                                        if (QLog.isColorLevel()) {
                                            QLog.d(QQNotifySettingBaseFragment.T, 2, "do report: QQnotice.set.add");
                                        }
                                        ReportController.o(null, "P_CliOper", "QQnotice", "", "", "QQnotice.set.add", 0, 0, "", "", QQNotifySettingBaseFragment.this.P, QQNotifySettingBaseFragment.this.N);
                                        MobileReportManager.getInstance().reportActionOfNotice(ReportParamsConst.APP_ID_QQNOTICE, "1", "2", 102, QQNotifySettingBaseFragment.this.N, "15", 1);
                                    }
                                    QQNotifySettingBaseFragment.this.T6(i16, str);
                                }
                            });
                        } else {
                            QQNotifySettingBaseFragment.this.T6(3, "system error");
                        }
                    } catch (Throwable th5) {
                        QLog.e(QQNotifySettingBaseFragment.T, 1, QLog.getStackTraceString(th5));
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CalendarEntity zh(AcsGetMsgRsp acsGetMsgRsp) {
        CalendarEntity calendarEntity = new CalendarEntity();
        calendarEntity.content = "";
        calendarEntity.msg_id = this.N;
        calendarEntity.notice_time = acsGetMsgRsp.notice_time;
        calendarEntity.title = acsGetMsgRsp.title;
        calendarEntity.jump_url = acsGetMsgRsp.jump_url;
        return calendarEntity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ah(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3, (Object) str);
        } else if (getBaseActivity() != null) {
            id(i3, str);
            getBaseActivity().finish();
        }
    }

    public abstract View Ch(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public void Eh(AcsGetMsgRsp acsGetMsgRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) acsGetMsgRsp);
            return;
        }
        if (acsGetMsgRsp != null) {
            if (acsGetMsgRsp.ret_code == 0) {
                this.E.setText(acsGetMsgRsp.content);
                long j3 = acsGetMsgRsp.notice_time;
                if (j3 == 0) {
                    this.F.setText(HardCodeUtil.qqStr(R.string.qy9));
                } else {
                    this.F.setText(p.a(j3 * 1000, "yyyy-MM-dd HH:mm:ss"));
                }
                boolean z16 = true;
                this.G.setEnabled(true);
                if (acsGetMsgRsp.calendar != 1) {
                    z16 = false;
                }
                CheckBox checkBox = this.H;
                if (checkBox != null && z16 && this.M) {
                    checkBox.setVisibility(0);
                    this.H.setChecked(false);
                    return;
                }
                return;
            }
            Jf();
            this.G.setEnabled(false);
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 == 4) {
            Ah(this.R, this.S);
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle);
            return;
        }
        super.onActivityCreated(bundle);
        this.M = ((IQQReminderCalendarService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQReminderCalendarService.class, "")).isCalendarOpen(getActivity());
        ab abVar = new ab(getBaseActivity());
        this.I = abVar;
        abVar.show();
        Dh();
        MobileReportManager.getInstance().reportActionOfNotice(ReportParamsConst.APP_ID_QQNOTICE, "1", "1", 100, this.N, "15", 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.f164682ak4) {
                String str = (String) view.getTag();
                if ("0".equals(str)) {
                    y.b(Bh(), "open_click", this.P, this.N, null, null);
                    Fh();
                } else if ("1".equals(str)) {
                    Ah(this.R, this.S);
                }
            } else if (id5 == R.id.aga) {
                y.b(Bh(), "pending_click", this.P, this.N, null, null);
                Ah(this.R, this.S);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            view = (View) iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
        } else {
            this.D = Ch(layoutInflater, viewGroup);
            new ul2.a(getBaseActivity(), 0, this.D.findViewById(R.id.j1w));
            this.E = (TextView) this.D.findViewById(R.id.mdh);
            this.F = (TextView) this.D.findViewById(R.id.mdi);
            this.H = (CheckBox) this.D.findViewById(R.id.checkBoxConfirm);
            Button button = (Button) this.D.findViewById(R.id.f164682ak4);
            this.G = button;
            button.setOnClickListener(this);
            this.N = getArguments().getString("key_msgid");
            this.P = getArguments().getString("key_busid");
            this.Q = getArguments().getString("key_domain");
            this.J = (IQQReminderDataService) Bh().getRuntimeService(IQQReminderDataService.class, "");
            y.b(Bh(), "authorizepage_exp", this.P, this.N, null, null);
            view = this.D;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onDestroyView();
        ab abVar = this.I;
        if (abVar != null && abVar.isShowing()) {
            this.I.dismiss();
        }
        Handler handler = this.C;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }
}
