package com.tencent.mobileqq.managers;

import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.activity.recent.msgbox.receiver.TempGameMsgSettingReceiver;
import com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TempMsgInfo;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes15.dex */
public class TempMsgManager implements Manager {
    static IPatchRedirector $redirector_;
    private d C;
    private EntityManager D;
    private TempGameMsgSettingReceiver E;

    /* renamed from: d, reason: collision with root package name */
    private final String[] f243677d;

    /* renamed from: e, reason: collision with root package name */
    private final List<String> f243678e;

    /* renamed from: f, reason: collision with root package name */
    private QQAppInterface f243679f;

    /* renamed from: h, reason: collision with root package name */
    private String f243680h;

    /* renamed from: i, reason: collision with root package name */
    private final Map<String, Boolean> f243681i;

    /* renamed from: m, reason: collision with root package name */
    private final Map<String, Boolean> f243682m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements DialogInterface.OnCancelListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a61.c f243688d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.aio.api.runtime.a f243689e;

        a(a61.c cVar, com.tencent.aio.api.runtime.a aVar) {
            this.f243688d = cVar;
            this.f243689e = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TempMsgManager.this, cVar, aVar);
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TempMsgManager", 2, "dialog cancel");
            }
            a61.c cVar = this.f243688d;
            if (cVar == null) {
                TempMsgManager.this.V(this.f243689e);
            } else {
                cVar.b(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements IMsgOperateCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ short f243691a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SessionInfo f243692b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f243693c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f243694d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f243695e;

        b(short s16, SessionInfo sessionInfo, int i3, String str, int i16) {
            this.f243691a = s16;
            this.f243692b = sessionInfo;
            this.f243693c = i3;
            this.f243694d = str;
            this.f243695e = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TempMsgManager.this, Short.valueOf(s16), sessionInfo, Integer.valueOf(i3), str, Integer.valueOf(i16));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
        public void onResult(int i3, String str, ArrayList<MsgRecord> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, arrayList);
                return;
            }
            if (i3 == 0 && arrayList != null) {
                if (TempMsgManager.this.r(arrayList)) {
                    TempMsgManager tempMsgManager = TempMsgManager.this;
                    if (tempMsgManager.q(tempMsgManager.L(this.f243691a), this.f243692b)) {
                        TempMsgManager.this.l(new AIOContact(this.f243693c, this.f243692b.f178172i0, "", ""), this.f243694d, this.f243695e);
                        return;
                    }
                    return;
                }
                return;
            }
            QLog.e("TempMsgManager", 1, "checkAndAddNtGrayTipMsg result is error! error msg is " + str + " msgList is " + arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a61.c f243697d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.aio.api.runtime.a f243698e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ short f243699f;

        c(a61.c cVar, com.tencent.aio.api.runtime.a aVar, short s16) {
            this.f243697d = cVar;
            this.f243698e = aVar;
            this.f243699f = s16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TempMsgManager.this, cVar, aVar, Short.valueOf(s16));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (i3 == 0) {
                a61.c cVar = this.f243697d;
                if (cVar == null) {
                    TempMsgManager.this.V(this.f243698e);
                } else {
                    cVar.b(1);
                }
            } else if (i3 == 1) {
                TempMsgManager.this.n(this.f243699f, true, true);
                TempMsgManager.this.U(QBaseActivity.sTopActivity, this.f243699f);
                ReportController.o(TempMsgManager.this.f243679f, "dc00898", "", "", "0X8009978", "0X8009978", TempMsgManager.this.C(this.f243699f), TempMsgManager.this.C(this.f243699f), "", "", "", "");
            }
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface d {
        void k1(short s16, boolean z16, boolean z17, boolean z18);
    }

    public TempMsgManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f243677d = new String[]{AppConstants.Preferences.TEMP_MSG_SETTING_CONSULT, AppConstants.Preferences.TEMP_MSG_SETTING_CONTACT, AppConstants.Preferences.TEMP_MSG_SETTING_TROOP, AppConstants.Preferences.TEMP_MSG_SETTING_CIRCLE, AppConstants.Preferences.TEMP_MSG_SETTING_COMPANY};
        this.f243678e = new ArrayList();
        HashMap hashMap = new HashMap(8);
        this.f243681i = hashMap;
        HashMap hashMap2 = new HashMap(8);
        this.f243682m = hashMap2;
        this.f243679f = qQAppInterface;
        this.f243680h = qQAppInterface.getCurrentUin();
        hashMap.clear();
        hashMap2.clear();
        this.D = this.f243679f.getEntityManagerFactory().createEntityManager();
        this.E = new TempGameMsgSettingReceiver(this.f243679f);
        S();
        M();
    }

    private boolean D(String str, int i3) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f243679f.getApplication());
        boolean u16 = u(str);
        if (i3 == 0) {
            return defaultSharedPreferences.getBoolean(str + this.f243680h + "_setting", u16);
        }
        if (i3 != 1) {
            return false;
        }
        boolean z16 = defaultSharedPreferences.getBoolean(str + this.f243680h + "_show", u16);
        if (z16) {
            defaultSharedPreferences.edit().putBoolean(str + this.f243680h + "_show", false).apply();
        }
        return z16;
    }

    private short H(boolean z16, boolean z17) {
        if (z16 && z17) {
            return (short) 2;
        }
        if (z16) {
            return (short) 0;
        }
        if (z17) {
            return (short) 3;
        }
        return (short) 1;
    }

    private boolean I(String str) {
        QQAppInterface qQAppInterface = this.f243679f;
        if (qQAppInterface == null) {
            QLog.e("TempMsgManager", 1, "getTempSettingFromSP(), mApp is null, return false. ");
            return false;
        }
        return PreferenceManager.getDefaultSharedPreferences(qQAppInterface.getApplication()).getBoolean(str + this.f243680h + "_in_box_setting", false);
    }

    private boolean J(String str) {
        if (this.f243682m.containsKey(str)) {
            return w(this.f243682m, str);
        }
        boolean I = I(str);
        this.f243682m.put(str, Boolean.valueOf(I));
        return I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String L(short s16) {
        if (s16 != -23312) {
            if (s16 != -23168) {
                if (s16 != -23166) {
                    if (s16 != -23161) {
                        if (s16 != -23158) {
                            if (s16 != -20457 && s16 != -20455) {
                                switch (s16) {
                                    case -23310:
                                        return AppConstants.Preferences.TEMP_MSG_SETTING_CONTACT;
                                    case -23309:
                                        return AppConstants.Preferences.TEMP_MSG_SETTING_CONSULT;
                                    case -23308:
                                        return AppConstants.Preferences.TEMP_MSG_SETTING_TROOP;
                                    default:
                                        switch (s16) {
                                            case -20461:
                                                return AppConstants.Preferences.TEMP_MSG_SETTING_TROOP;
                                            case -20460:
                                                return AppConstants.Preferences.TEMP_MSG_SETTING_CONTACT;
                                            case -20459:
                                                return AppConstants.Preferences.TEMP_MSG_SETTING_CONSULT;
                                            default:
                                                throw new RuntimeException("getTypeStringFromType failed " + ((int) s16));
                                        }
                                }
                            }
                            return AppConstants.Preferences.TEMP_MSG_SETTING_COMPANY;
                        }
                        return AppConstants.Preferences.TEMP_MSG_SETTING_GAMEBUDDY;
                    }
                    return AppConstants.Preferences.TEMP_MSG_SETTING_AUDIO_ROOM;
                }
                return AppConstants.Preferences.TEMP_MSG_SETTING_INTEREST;
            }
            return AppConstants.Preferences.TEMP_MSG_SETTING_CIRCLE;
        }
        return AppConstants.Preferences.TEMP_MSG_SETTING_NEARBY;
    }

    private void M() {
        this.f243678e.add(AppConstants.Preferences.TEMP_MSG_SETTING_CIRCLE);
    }

    private void S() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_qgame_toggle_change");
        BaseApplicationImpl.getApplication().registerReceiver(this.E, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(Context context, short s16) {
        if (-23308 == s16 && ((IFeatureRuntimeService) this.f243679f.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("stranger_chat_accept_block_dialog_switch")) {
            ((IAddAcceptBlockStrategy) QRoute.api(IAddAcceptBlockStrategy.class)).checkAccountIdentity(this.f243679f, 10001, context, new IAddAcceptBlockStrategy.a() { // from class: com.tencent.mobileqq.managers.j
                @Override // com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy.a
                public final void onSuccess() {
                    TempMsgManager.N();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(com.tencent.aio.api.runtime.a aVar) {
        if (aVar != null && aVar.e() != null) {
            aVar.e().h(new ExternalCommIntent("close_aio", new Bundle()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(AIOContact aIOContact, String str, int i3) {
        if (i3 == 1000) {
            return;
        }
        String format = String.format(HardCodeUtil.qqStr(R.string.f23075700), str);
        String qqStr = HardCodeUtil.qqStr(R.string.f230746zz);
        LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder = new LocalGrayTip.LocalGrayTipBuilder(aIOContact.j(), aIOContact.e(), 1013L, 1, true, true, null);
        localGrayTipBuilder.g(format, 1).e(qqStr, String.format(HardCodeUtil.qqStr(R.string.f23076701), Integer.valueOf(i3)), 3);
        ((INtGrayTipApi) QRoute.api(INtGrayTipApi.class)).addLocalGrayTip(this.f243679f, localGrayTipBuilder.m(), null);
        if (QLog.isColorLevel()) {
            QLog.d("TempMsgManager", 2, "add gray tip =" + format + qqStr);
        }
    }

    private void p(SessionInfo sessionInfo, String str, int i3, short s16) {
        w msgService = ((IKernelService) this.f243679f.getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService == null) {
            QLog.e("TempMsgManager", 1, "checkAndAddNtGrayTipMsg result is error! msgService is null ");
        } else {
            int l3 = com.tencent.nt.adapter.session.c.l(sessionInfo.f179555d);
            msgService.getMsgs(new Contact(l3, sessionInfo.f178172i0, ""), 0L, 5, true, new b(s16, sessionInfo, l3, str, i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r(ArrayList<MsgRecord> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        Iterator<MsgRecord> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().getSendType() == 1) {
                return false;
            }
        }
        return true;
    }

    private void s(SessionInfo sessionInfo, short s16, String str, int i3, a61.c cVar, com.tencent.aio.api.runtime.a aVar) {
        if (!E(L(s16))) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(QBaseActivity.sTopActivity, 230, HardCodeUtil.qqStr(R.string.f172766u20), String.format(this.f243679f.getApplication().getResources().getString(R.string.hze), str, str), R.string.hzc, R.string.hzd, v(cVar, s16, aVar), v(cVar, s16, aVar));
            createCustomDialog.setOnCancelListener(new a(cVar, aVar));
            createCustomDialog.setCanceledOnTouchOutside(false);
            createCustomDialog.show();
            ReportController.o(this.f243679f, "dc00898", "", "", "0X8009977", "0X8009977", C(s16), C(s16), "", "", "", "");
            return;
        }
        U(QBaseActivity.sTopActivity, s16);
        p(sessionInfo, str, i3, s16);
    }

    private boolean u(String str) {
        return !this.f243678e.contains(str);
    }

    private DialogInterface.OnClickListener v(a61.c cVar, short s16, com.tencent.aio.api.runtime.a aVar) {
        return new c(cVar, aVar, s16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w(Map<String, Boolean> map, String str) {
        Boolean bool = map.get(str);
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        return false;
    }

    private short y(short s16) {
        if (s16 != -20457) {
            switch (s16) {
                case -23310:
                    return (short) -20460;
                case -23309:
                    return (short) -20459;
                case -23308:
                    return (short) -20461;
                default:
                    throw new RuntimeException("getInBoxTypeByBlockType failed " + ((int) s16));
            }
        }
        return (short) -20455;
    }

    private int z(SessionInfo sessionInfo) {
        MessageRecord messageRecord;
        List<ChatMessage> l16;
        if (this.f243679f != null) {
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106122", true)) {
                l16 = new ArrayList<>();
            } else {
                l16 = this.f243679f.getMessageFacade().l1(sessionInfo.f179557e, sessionInfo.f179555d);
            }
            int i3 = sessionInfo.f179555d;
            if (1000 != i3 && 1004 != i3 && 1022 != i3) {
                messageRecord = ChatActivityUtils.D(l16, sessionInfo, this.f243679f);
            } else {
                messageRecord = ChatActivityUtils.F(l16, sessionInfo, this.f243679f);
            }
        } else {
            messageRecord = null;
        }
        if (messageRecord == null) {
            return sessionInfo.f179555d;
        }
        return messageRecord.istroop;
    }

    public int A(short s16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, this, Short.valueOf(s16))).intValue();
        }
        if (s16 != -20457) {
            switch (s16) {
                case -23310:
                    return 2;
                case -23309:
                    return 3;
                case -23308:
                    return 1;
                default:
                    return 0;
            }
        }
        return 4;
    }

    public String B(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this, i3);
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return "";
                }
                return "0X800BB8D";
            }
            return "0X800BB8C";
        }
        return "0X800BB8B";
    }

    public int C(short s16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, this, Short.valueOf(s16))).intValue();
        }
        if (s16 == -23312) {
            return 2;
        }
        if (s16 != -23168) {
            if (s16 != -23166) {
                if (s16 != -23161) {
                    if (s16 != -23158) {
                        switch (s16) {
                            case -23310:
                                return 4;
                            case -23309:
                                return 5;
                            case -23308:
                                return 1;
                            default:
                                return 0;
                        }
                    }
                    return 7;
                }
                return 8;
            }
            return 3;
        }
        return 6;
    }

    public boolean E(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        if (this.f243681i.containsKey(str)) {
            return w(this.f243681i, str);
        }
        boolean D = D(str, 0);
        this.f243681i.put(str, Boolean.valueOf(D));
        return D;
    }

    public boolean F(short s16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, Short.valueOf(s16))).booleanValue();
        }
        return E(L(s16));
    }

    public boolean[] G(short s16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (boolean[]) iPatchRedirector.redirect((short) 22, this, Short.valueOf(s16), Integer.valueOf(i3));
        }
        if (i3 != 1) {
            if (i3 != 2) {
                return new boolean[]{true, false};
            }
            return new boolean[]{false, K(s16)};
        }
        return new boolean[]{true, true};
    }

    public boolean K(short s16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, this, Short.valueOf(s16))).booleanValue();
        }
        return J(L(s16));
    }

    public void O(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
        } else if (!StringUtil.isEmpty(str)) {
            ThreadManager.getUIHandler().post(new Runnable(str) { // from class: com.tencent.mobileqq.managers.TempMsgManager.6
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f243687d;

                {
                    this.f243687d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TempMsgManager.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        QQToast.makeText(TempMsgManager.this.f243679f.getApp(), this.f243687d, 1).show();
                    }
                }
            });
        }
    }

    public void P(SessionInfo sessionInfo, a61.c cVar, com.tencent.aio.api.runtime.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, sessionInfo, cVar, aVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TempMsgManager", 2, "onEnterChat" + sessionInfo.f179555d);
        }
        int i3 = sessionInfo.f179555d;
        if (i3 == 1000) {
            i3 = z(sessionInfo);
        }
        int i16 = i3;
        if (i16 != 1000) {
            if (i16 != 1001 && i16 != 1003) {
                if (i16 != 1024) {
                    if (i16 != 10002) {
                        if (i16 != 10008) {
                            if (i16 != 10010) {
                                if (i16 != 1005) {
                                    if (i16 == 1006) {
                                        s(sessionInfo, (short) -23310, HardCodeUtil.qqStr(R.string.u1x), i16, cVar, aVar);
                                        return;
                                    }
                                    return;
                                }
                                s(sessionInfo, (short) -23309, "QQ\u54a8\u8be2", i16, cVar, aVar);
                                return;
                            }
                            s(sessionInfo, (short) -23161, HardCodeUtil.qqStr(R.string.f168332fc), i16, cVar, aVar);
                            return;
                        }
                        s(sessionInfo, (short) -23168, HardCodeUtil.qqStr(R.string.wn7), i16, cVar, aVar);
                        return;
                    }
                    s(sessionInfo, (short) -23166, HardCodeUtil.qqStr(R.string.u1y), i16, cVar, aVar);
                    return;
                }
                if (((ITempMsgBoxManager) this.f243679f.getRuntimeService(ITempMsgBoxManager.class, "")).configContains(1024)) {
                    s(sessionInfo, (short) -20457, HardCodeUtil.qqStr(R.string.f230666zr), i16, cVar, aVar);
                    return;
                }
                return;
            }
            s(sessionInfo, (short) -23312, HardCodeUtil.qqStr(R.string.u1w), i16, cVar, aVar);
            return;
        }
        s(sessionInfo, (short) -23308, HardCodeUtil.qqStr(R.string.u1z), i16, cVar, aVar);
    }

    public void Q(short s16, boolean z16, String str, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Short.valueOf(s16), Boolean.valueOf(z16), str, Boolean.valueOf(z17), Boolean.valueOf(z18));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TempMsgManager", 2, "onSetInBoxResult t=" + ((int) s16) + " result=" + z16 + " fm=" + str + " isAllowedToReceiveMessage=" + z17 + " isInBox=" + z18);
        }
        boolean K = K(s16);
        if (!z16) {
            n(s16, z17, false);
            m(s16, z18);
            O(str);
        }
        if ((z16 || TextUtils.isEmpty(str)) && (K ^ z18)) {
            new com.tencent.mobileqq.activity.recent.msgbox.e().b(this.f243679f);
            ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).removeMsgBoxIfNecessary(this.f243679f, true);
            ((ITempMsgBoxManager) this.f243679f.getRuntimeService(ITempMsgBoxManager.class, "")).setMsgBoxRead(false);
            this.f243679f.notifyObservers(com.tencent.mobileqq.activity.recent.msgbox.h.class, 1, true, new Bundle());
        }
        ThreadManager.getUIHandler().post(new Runnable(s16, z16) { // from class: com.tencent.mobileqq.managers.TempMsgManager.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ short f243685d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f243686e;

            {
                this.f243685d = s16;
                this.f243686e = z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TempMsgManager.this, Short.valueOf(s16), Boolean.valueOf(z16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (TempMsgManager.this.C != null) {
                    d dVar = TempMsgManager.this.C;
                    short s17 = this.f243685d;
                    boolean z19 = this.f243686e;
                    TempMsgManager tempMsgManager = TempMsgManager.this;
                    boolean w3 = tempMsgManager.w(tempMsgManager.f243681i, TempMsgManager.this.L(this.f243685d));
                    TempMsgManager tempMsgManager2 = TempMsgManager.this;
                    dVar.k1(s17, z19, w3, tempMsgManager2.w(tempMsgManager2.f243682m, TempMsgManager.this.L(this.f243685d)));
                }
            }
        });
    }

    public void R(short s16, boolean z16, String str, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Short.valueOf(s16), Boolean.valueOf(z16), str, Boolean.valueOf(z17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TempMsgManager", 2, "onSetResult t=" + ((int) s16) + " result=" + z16 + " fm=" + str + " value=" + z17);
        }
        if (!z16) {
            n(s16, z17, false);
            O(str);
        }
        ThreadManager.getUIHandler().post(new Runnable(s16, z16) { // from class: com.tencent.mobileqq.managers.TempMsgManager.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ short f243683d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f243684e;

            {
                this.f243683d = s16;
                this.f243684e = z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TempMsgManager.this, Short.valueOf(s16), Boolean.valueOf(z16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (TempMsgManager.this.C != null) {
                    d dVar = TempMsgManager.this.C;
                    short s17 = this.f243683d;
                    boolean z18 = this.f243684e;
                    TempMsgManager tempMsgManager = TempMsgManager.this;
                    boolean w3 = tempMsgManager.w(tempMsgManager.f243681i, TempMsgManager.this.L(this.f243683d));
                    TempMsgManager tempMsgManager2 = TempMsgManager.this;
                    dVar.k1(s17, z18, w3, tempMsgManager2.w(tempMsgManager2.f243682m, TempMsgManager.this.L(this.f243683d)));
                }
            }
        });
    }

    public void T(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) dVar);
        } else {
            this.C = dVar;
        }
    }

    public boolean W(short s16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, this, Short.valueOf(s16))).booleanValue();
        }
        return this.f243678e.contains(L(s16));
    }

    public void m(short s16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Short.valueOf(s16), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TempMsgManager", 2, "changeInBoxSetting t=" + ((int) s16) + " isInBox=" + z16);
        }
        String L = L(s16);
        this.f243682m.put(L, Boolean.valueOf(z16));
        PreferenceManager.getDefaultSharedPreferences(this.f243679f.getApplication()).edit().putBoolean(L + this.f243680h + "_in_box_setting", z16).apply();
    }

    public void n(short s16, boolean z16, boolean z17) {
        CardHandler cardHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Short.valueOf(s16), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TempMsgManager", 2, "changeSetting t=" + ((int) s16) + " s=" + z16 + "sync=" + z17);
        }
        String L = L(s16);
        if (this.f243681i.containsKey(L)) {
            this.f243681i.remove(L);
            this.f243681i.put(L, Boolean.valueOf(z16));
        } else {
            this.f243681i.put(L, Boolean.valueOf(z16));
        }
        PreferenceManager.getDefaultSharedPreferences(this.f243679f.getApplication()).edit().putBoolean(L + this.f243680h + "_setting", z16).apply();
        if (z17 && (cardHandler = (CardHandler) this.f243679f.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)) != null) {
            cardHandler.r5(s16, !z16);
        }
    }

    public void o(short s16, int i3, int i16, boolean z16) {
        CardHandler cardHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Short.valueOf(s16), Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TempMsgManager", 2, "changeTempSetting type=" + ((int) s16) + " switchAfter=" + i3 + " switchBefore" + i16 + "sync=" + z16);
        }
        boolean[] G = G(s16, i3);
        boolean[] G2 = G(s16, i16);
        boolean z17 = G2[0];
        boolean z18 = G2[1];
        boolean z19 = G[0];
        boolean z26 = G[1];
        n(s16, z19, false);
        m(s16, z26);
        short H = H(z19, z26);
        if (z16 && (cardHandler = (CardHandler) this.f243679f.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)) != null) {
            cardHandler.s5(s16, y(s16), H, z17, z18);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        this.f243679f = null;
        this.C = null;
        EntityManager entityManager = this.D;
        if (entityManager != null) {
            entityManager.close();
        }
        try {
            if (this.E != null) {
                BaseApplicationImpl.getApplication().unregisterReceiver(this.E);
            }
        } catch (Throwable th5) {
            QLog.e("TempMsgManager", 1, "[onDestroy], th:", th5);
        }
    }

    public boolean q(String str, SessionInfo sessionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) sessionInfo)).booleanValue();
        }
        synchronized (this) {
            if (DBMethodProxy.find(this.D, (Class<? extends Entity>) TempMsgInfo.class, str + sessionInfo.f179557e) instanceof TempMsgInfo) {
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TempMsgManager", 2, "can't tempMsgInfo, insert a new tempMsgInfo! type=" + str + "curFriendUin=" + sessionInfo.f179557e);
            }
            this.D.persist(new TempMsgInfo(str + sessionInfo.f179557e, System.currentTimeMillis()));
            return true;
        }
    }

    public Map<String, Boolean> t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Map) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f243679f.getApplication());
        for (String str : this.f243677d) {
            if (!this.f243681i.containsKey(str)) {
                this.f243681i.put(str, Boolean.valueOf(defaultSharedPreferences.getBoolean(str + this.f243680h + "_setting", u(str))));
            }
        }
        return this.f243681i;
    }

    public Map<String, Boolean> x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Map) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f243679f.getApplication());
        for (String str : this.f243677d) {
            if (!this.f243682m.containsKey(str)) {
                this.f243682m.put(str, Boolean.valueOf(defaultSharedPreferences.getBoolean(str + this.f243680h + "_in_box_setting", false)));
            }
        }
        return this.f243682m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void N() {
    }
}
