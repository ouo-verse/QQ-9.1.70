package com.tencent.mobileqq.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.app.nthiddenchat.NTHiddenChatFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.h;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQSettingChatOperationFragment extends IphoneTitleBarFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener, Observer {
    static IPatchRedirector $redirector_;
    private QQAppInterface C;
    private String D;
    private BounceScrollView E;
    private FormSwitchItem F;
    private FormSimpleItem G;
    private TextView H;
    private TextView I;
    private View J;
    private View K;
    QQProgressDialog L;
    private long M;
    private SVIPObserver N;
    com.tencent.mobileqq.troop.roamsetting.b P;
    ar Q;
    private QQProgressDialog R;
    Handler S;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends SVIPObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingChatOperationFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.SVIPObserver
        public void onGetRoamType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QQSettingChatOperationFragment.this.Gh();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b extends com.tencent.mobileqq.troop.roamsetting.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingChatOperationFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.roamsetting.b
        protected void b(boolean z16, String str, Map<String, Integer> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, map);
                return;
            }
            if (!TextUtils.isEmpty(str) && str.startsWith(AppConstants.RoamingMapPath.C2C_ROAMING_MSG)) {
                if (QLog.isColorLevel()) {
                    QLog.d("SecuritySettingActivity", 2, "onSetGeneralSettingsC2CRoaming issuc =" + z16);
                }
                QQSettingChatOperationFragment.this.Dh();
                BaseActivity baseActivity = QQSettingChatOperationFragment.this.getBaseActivity();
                if (baseActivity == null) {
                    QLog.e("QQSettingChatOperationFragment", 1, "onSetGeneralSettingsC2CRoaming: activity is null");
                    return;
                }
                if (z16) {
                    QQToast.makeText(baseActivity.getApplicationContext(), 2, R.string.d0h, 0).show(QQSettingChatOperationFragment.this.getBaseActivity().getTitleBarHeight());
                    return;
                }
                if (QQSettingChatOperationFragment.this.F != null) {
                    QQSettingChatOperationFragment.this.F.setOnCheckedChangeListener(null);
                    FormSwitchItem formSwitchItem = QQSettingChatOperationFragment.this.F;
                    if (QQSettingChatOperationFragment.this.C.getC2CRoamingSetting() != 1) {
                        z17 = false;
                    }
                    formSwitchItem.setChecked(z17);
                    QQSettingChatOperationFragment.this.F.setOnCheckedChangeListener(QQSettingChatOperationFragment.this);
                }
                QQToast.makeText(baseActivity.getApplicationContext(), R.string.d0f, 0).show(baseActivity.getTitleBarHeight());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c extends ar {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingChatOperationFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSetMessageRaoam(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else if (z16) {
                QQSettingChatOperationFragment.this.Gh();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class d extends Handler {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingChatOperationFragment.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            super.handleMessage(message);
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        QQSettingChatOperationFragment.this.Ih();
                        return;
                    }
                    return;
                }
                QQProgressDialog qQProgressDialog = QQSettingChatOperationFragment.this.L;
                if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                    QQSettingChatOperationFragment.this.L.cancel();
                    QQSettingChatOperationFragment qQSettingChatOperationFragment = QQSettingChatOperationFragment.this;
                    qQSettingChatOperationFragment.L.setMessage(qQSettingChatOperationFragment.getString(R.string.a3f));
                    QQSettingChatOperationFragment.this.L.setBackAndSearchFilter(true);
                    QQSettingChatOperationFragment.this.L.showTipImageView(false);
                    QQSettingChatOperationFragment.this.L.showProgerss(true);
                    return;
                }
                return;
            }
            if (QQSettingChatOperationFragment.this.getBaseActivity() != null && !QQSettingChatOperationFragment.this.getBaseActivity().isFinishing()) {
                QQSettingChatOperationFragment qQSettingChatOperationFragment2 = QQSettingChatOperationFragment.this;
                qQSettingChatOperationFragment2.L.setMessage(qQSettingChatOperationFragment2.getString(R.string.a3d));
                QQSettingChatOperationFragment.this.L.setTipImageView(R.drawable.setting_icons_correct);
                QQSettingChatOperationFragment.this.L.showProgerss(false);
            }
            QQSettingChatOperationFragment.this.S.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    public QQSettingChatOperationFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.D = "";
        this.M = 0L;
        this.N = new a();
        this.P = new b();
        this.Q = new c();
        this.S = new d();
    }

    public static void Ah(String str, boolean z16) {
        int i3 = 0;
        while (true) {
            Vector<Integer> vector = CardHandler.F;
            if (i3 < vector.size()) {
                xh(CardHandler.E + vector.get(i3).intValue() + "/");
                i3++;
            } else {
                StringBuilder sb5 = new StringBuilder();
                String str2 = CardHandler.E;
                sb5.append(str2);
                sb5.append("background");
                sb5.append("/");
                xh(sb5.toString());
                xh(AppConstants.SDCARD_PATH + FaceUtil.IMG_TEMP + "/");
                xh(str2 + FaceUtil.IMG_TEMP + "/");
                xh(str2 + FaceUtil.PORTRAIT_HDAVATAR + "/");
                xh(AppConstants.PATH_CARD_QZONE);
                xh(str2 + "voice/");
                StringBuilder sb6 = new StringBuilder();
                sb6.append(com.tencent.gamecenter.common.util.a.J());
                sb6.append("/");
                xh(sb6.toString());
                xh(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_SCREENSHOTS);
                xh(com.tencent.mobileqq.hotpic.b.f237006d);
                xh(com.tencent.mobileqq.scribble.e.a());
                return;
            }
        }
    }

    private void Bh() {
        xh(AppConstants.SDCARD_PATH + this.D + "/" + FileMsg.FILE_PTT_DIR);
    }

    private static void Ch(QQAppInterface qQAppInterface) {
        File file = URLDrawableHelper.diskCachePath;
        if (file != null) {
            xh(file.getAbsolutePath());
            if (qQAppInterface.getApp() instanceof BaseApplicationImpl) {
                ImageCacheHelper.f98636a.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh(boolean z16) {
        QQProgressDialog qQProgressDialog = this.L;
        if (qQProgressDialog != null) {
            if (z16 && !qQProgressDialog.isShowing()) {
                this.L.show();
            } else if (!z16 && this.L.isShowing()) {
                this.L.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gh() {
        String string;
        if (getBaseActivity() == null) {
            QLog.e("QQSettingChatOperationFragment", 1, "syncMessageRoamFlag: activity is null");
            return;
        }
        int i3 = this.C.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + this.C.getCurrentAccountUin(), 0);
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            string = null;
                        } else {
                            string = getResources().getString(R.string.g3r);
                        }
                    } else {
                        string = getResources().getString(R.string.g3p);
                    }
                } else {
                    string = getResources().getString(R.string.g3q);
                }
            } else {
                string = getResources().getString(R.string.g3s);
            }
        } else {
            string = getResources().getString(R.string.f172963g45);
        }
        if (!TextUtils.isEmpty(string)) {
            this.G.setRightText(string);
        } else if (QLog.isColorLevel()) {
            QLog.d("QQSettingMsgHistoryActivity", 2, "messge roam flag is error ,is : " + i3);
        }
    }

    private void Hh() {
        int i3;
        Intent intent = getBaseActivity().getIntent();
        if (intent != null && intent.hasExtra("set_display_type")) {
            i3 = intent.getIntExtra("set_display_type", 0);
        } else {
            i3 = 0;
        }
        if (i3 == 2) {
            this.F.setVisibility(8);
            this.G.setVisibility(8);
            this.I.setVisibility(8);
        } else {
            this.F.setVisibility(0);
            this.G.setVisibility(0);
            this.I.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih() {
        QLog.d(LogTag.TAG_HIDDEN_CHAT, 1, "QQSettingChatOperationFragment\u662f\u5426\u5df2\u7ecf\u65e0\u7528");
    }

    private void initUI() {
        boolean z16;
        this.E = (BounceScrollView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.ii_);
        this.D = this.C.getCurrentAccountUin();
        View findViewById = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.lkz);
        TextView textView = (TextView) findViewById.findViewById(R.id.kik);
        this.H = textView;
        textView.setVisibility(8);
        findViewById.setOnClickListener(this);
        FormSwitchItem formSwitchItem = (FormSwitchItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.qq_setting_sync_msg_switch);
        this.F = formSwitchItem;
        if (this.C.getC2CRoamingSetting() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        formSwitchItem.setChecked(z16);
        this.F.setOnCheckedChangeListener(this);
        FormSimpleItem formSimpleItem = (FormSimpleItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.eqs);
        this.G = formSimpleItem;
        formSimpleItem.setRightTextColor(2);
        this.G.setOnClickListener(this);
        this.I = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.jjt);
        this.J = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.delRecentList);
        this.K = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.delChatHistory);
        this.J.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.J.setContentDescription(getString(R.string.ajt));
        this.K.setContentDescription(getString(R.string.ajf));
        this.C.addObserver(this.Q);
        this.C.addObserver(this.P);
        this.C.addObserver(this.N);
        this.C.getMessageFacade().addObserver(this);
        Hh();
        if (VersionUtils.isGingerBread()) {
            this.E.setOverScrollMode(0);
        }
        if (this.L == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
            this.L = qQProgressDialog;
            qQProgressDialog.setMessage(getString(R.string.a3f));
            this.L.setCanceledOnTouchOutside(true);
            this.L.setBackAndSearchFilter(true);
            this.L.showTipImageView(false);
            this.L.showProgerss(true);
        }
    }

    private static void xh(String str) {
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                file.delete();
            }
        }
    }

    static void yh() {
        xh(AppConstants.SDCARD_PATH + "photo/");
    }

    private void zh() {
        try {
            this.C.getMessageFacade().p();
            this.C.getMessageFacade().i1();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        this.C.getMessageFacade().s();
    }

    void Dh() {
        try {
            QQProgressDialog qQProgressDialog = this.R;
            if (qQProgressDialog != null) {
                qQProgressDialog.dismiss();
                this.R.cancel();
                this.R = null;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    void Eh(String str) {
        if (this.R == null) {
            this.R = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
        }
        this.R.setCancelable(true);
        this.R.setMessage(str);
        this.R.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        if (getBaseActivity().getAppRuntime() instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) getBaseActivity().getAppRuntime();
            this.C = qQAppInterface;
            if (qQAppInterface != null) {
                initUI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.cea;
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        boolean onBackEvent = super.onBackEvent();
        com.tencent.mobileqq.app.nthiddenchat.b.a(getBaseActivity(), GeneralSettingActivity.class);
        return onBackEvent;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, compoundButton, Boolean.valueOf(z16));
        } else if (!NetworkUtil.isNetSupport(this.C.getApplication().getApplicationContext())) {
            QQToast.makeText(getBaseActivity().getApplicationContext(), R.string.f171139ci4, 1).show();
            this.F.setOnCheckedChangeListener(null);
            FormSwitchItem formSwitchItem = this.F;
            if (this.C.getC2CRoamingSetting() == 1) {
                z17 = true;
            }
            formSwitchItem.setChecked(z17);
            this.F.setOnCheckedChangeListener(this);
        } else {
            ReportController.o(this.C, "CliOper", "", "", "Setting_tab", "Latest_chatlog_syn", 0, z16 ? 1 : 0, "0", "0", "", "");
            Eh(getBaseActivity().getApplication().getResources().getString(R.string.hfh));
            this.C.setC2CRoamingSetting(z16 ? 1 : 0);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else if (view.getId() == R.id.eqs) {
            Intent intent = new Intent(getBaseActivity(), (Class<?>) QQBrowserActivity.class);
            String url = IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.VIP_CHAT_ROAM_CELL);
            if (TextUtils.isEmpty(url)) {
                QLog.e("QQSettingChatOperationFragment", 1, "gotoRoamMessageSettingUrl ! url empty");
            } else {
                if (url.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                    str = url + "&ADTAG=msgRoam";
                } else {
                    str = url + "?ADTAG=msgRoam";
                }
                intent.putExtra("url", str);
                startActivity(intent);
                ff.T(this.C, "chat_history", "ChatHistory", "Clk_RoamMsgSetting", 2, 0, "0", "0", MessageRoamJsPlugin.PKGNAME);
            }
        } else if (view.getId() == R.id.lkz) {
            NTHiddenChatFragment.rh(getBaseActivity(), 1, new Intent());
        } else {
            int i16 = 0;
            if (view.getId() == R.id.delChatHistory) {
                long currentTimeMillis = System.currentTimeMillis();
                long j3 = currentTimeMillis - this.M;
                if (!getBaseActivity().isFinishing() && j3 >= 500) {
                    this.M = currentTimeMillis;
                    com.tencent.mobileqq.widget.h hVar = new com.tencent.mobileqq.widget.h(getBaseActivity(), this.C, false);
                    hVar.S(new h.a() { // from class: com.tencent.mobileqq.fragment.QQSettingChatOperationFragment.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingChatOperationFragment.this);
                            }
                        }

                        @Override // com.tencent.mobileqq.widget.h.a
                        public void a(Dialog dialog, View view2, boolean z16) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, this, dialog, view2, Boolean.valueOf(z16));
                                return;
                            }
                            ReportController.o(QQSettingChatOperationFragment.this.C, "CliOper", "", "", "Setting_tab", "Clean_chat_log", 0, 0, "0", "0", "", "");
                            ReportController.o(null, "dc00898", "", "", "0X800A0C4", "0X800A0C4", 0, 0, "", "", "", "");
                            if (!QQSettingChatOperationFragment.this.getBaseActivity().isFinishing()) {
                                QQSettingChatOperationFragment.this.Fh(true);
                            }
                            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.fragment.QQSettingChatOperationFragment.1.1
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
                                        QQSettingChatOperationFragment.this.vh();
                                        QQSettingChatOperationFragment.this.S.sendEmptyMessageDelayed(0, 1000L);
                                    }
                                }
                            }, 64, null, true);
                        }
                    });
                    hVar.U(HardCodeUtil.qqStr(R.string.r2o));
                    hVar.Q(HardCodeUtil.qqStr(R.string.r2d));
                    hVar.W(4);
                }
            } else {
                long currentTimeMillis2 = System.currentTimeMillis();
                long j16 = currentTimeMillis2 - this.M;
                if (!getBaseActivity().isFinishing() && j16 >= 500) {
                    this.M = currentTimeMillis2;
                    ActionSheet.OnButtonClickListener onButtonClickListener = null;
                    ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(getBaseActivity(), null);
                    if (view.getId() == R.id.delRecentList) {
                        onButtonClickListener = new ActionSheet.OnButtonClickListener(actionSheet) { // from class: com.tencent.mobileqq.fragment.QQSettingChatOperationFragment.2
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ ActionSheet f211184d;

                            {
                                this.f211184d = actionSheet;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingChatOperationFragment.this, (Object) actionSheet);
                                }
                            }

                            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                            public void onClick(View view2, int i17) {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view2, i17);
                                    return;
                                }
                                ReportController.o(QQSettingChatOperationFragment.this.C, "CliOper", "", "", "Setting_tab", "Clk_clean_msg", 0, 0, "0", "0", "", "");
                                ReportController.o(QQSettingChatOperationFragment.this.C, "dc00898", "", "", "0X800A0C3", "0X800A0C3", 0, 0, "", "", "", "");
                                if (!QQSettingChatOperationFragment.this.getBaseActivity().isFinishing()) {
                                    this.f211184d.cancel();
                                    QQSettingChatOperationFragment.this.Fh(true);
                                }
                                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.fragment.QQSettingChatOperationFragment.2.1
                                    static IPatchRedirector $redirector_;

                                    {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            iPatchRedirector3.redirect((short) 2, (Object) this);
                                            return;
                                        }
                                        QQSettingChatOperationFragment.this.C.getMsgHandler().c5(true);
                                        QQSettingChatOperationFragment.this.C.getMessageFacade().i1();
                                        QQSettingChatOperationFragment.this.S.sendEmptyMessageDelayed(0, 1000L);
                                        MqqHandler handler = QQSettingChatOperationFragment.this.C.getHandler(Conversation.class);
                                        if (handler != null) {
                                            handler.sendEmptyMessage(1009);
                                        }
                                    }
                                }, 64, null, true);
                            }
                        };
                        i16 = R.string.ajt;
                        i3 = R.string.a3e;
                    } else {
                        i3 = 0;
                    }
                    actionSheet.addButton(i16, 3);
                    actionSheet.addCancelButton(getString(R.string.cancel));
                    actionSheet.setOnButtonClickListener(onButtonClickListener);
                    actionSheet.setMainTitle(i3);
                    actionSheet.show();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public View onCreateCenterView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        View onCreateCenterView = super.onCreateCenterView();
        setTitle(getBaseActivity().getString(R.string.f169954u));
        return onCreateCenterView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.L;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            Fh(false);
        }
        QQAppInterface qQAppInterface = this.C;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.Q);
            this.C.removeObserver(this.P);
            this.C.removeObserver(this.N);
            this.C.getMessageFacade().deleteObserver(this);
        }
        this.S.removeCallbacksAndMessages(null);
        super.onDestroy();
        QQSettingMsgHistoryActivity.H2();
        com.tencent.mobileqq.qrscan.utils.b.c(getBaseActivity());
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.onResume();
            Ih();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onStart();
        if (this.C != null) {
            Gh();
            ((com.tencent.mobileqq.apollo.handler.b) this.C.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).j2(new String[]{this.C.getCurrentAccountUin()}, new int[]{42255});
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) observable, obj);
        }
    }

    void vh() {
        this.C.getMessageFacade().i1();
        Ah(this.D, true);
        Bh();
        yh();
        zh();
        Ch(this.C);
        wh();
        ((IStickerRecManager) this.C.getRuntimeService(IStickerRecManager.class)).deletePicCache();
        MqqHandler handler = this.C.getHandler(Conversation.class);
        if (handler != null) {
            handler.sendEmptyMessage(1009);
        }
    }

    void wh() {
    }
}
