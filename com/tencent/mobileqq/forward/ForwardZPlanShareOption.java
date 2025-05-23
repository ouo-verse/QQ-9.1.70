package com.tencent.mobileqq.forward;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.forward.ForwardZPlanShareOption;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.service.api.IZootopiaPortalMallSendGiftService;
import com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService;
import com.tencent.mobileqq.zplan.friend.ForwardZPlanUserList;
import com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import qd3.ZootopiaSendArkResult;
import rd3.ShareTarget;

/* loaded from: classes12.dex */
public class ForwardZPlanShareOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private BaseHelper f210953d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class NormalHelper extends BaseHelper {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        private final String f210958b;

        /* renamed from: c, reason: collision with root package name */
        private EntityManager f210959c;

        /* renamed from: d, reason: collision with root package name */
        private final ArrayList<String> f210960d;

        /* renamed from: e, reason: collision with root package name */
        private final HashSet<String> f210961e;

        /* renamed from: f, reason: collision with root package name */
        private DialogInterface.OnClickListener f210962f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes12.dex */
        public class a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NormalHelper.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    return;
                }
                if (IZootopiaPortalMallSendGiftService.SEND_GIFT_ARK_NAME.equalsIgnoreCase(ForwardZPlanShareOption.this.mExtraData.getString("forward_ark_app_name"))) {
                    NormalHelper.this.s();
                    QQCustomDialog qQCustomDialog = ForwardZPlanShareOption.this.mConfirmDialog;
                    if (qQCustomDialog instanceof QQCustomDialogWtihEmoticonInput) {
                        ((QQCustomDialogWtihEmoticonInput) qQCustomDialog).l0();
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes12.dex */
        public class b implements Function1<Boolean, Unit> {
            static IPatchRedirector $redirector_;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NormalHelper.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(Boolean bool) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
                }
                if (bool.booleanValue()) {
                    NormalHelper.this.z();
                    return null;
                }
                return null;
            }
        }

        public NormalHelper() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardZPlanShareOption.this);
                return;
            }
            this.f210960d = new ArrayList<>();
            this.f210961e = new HashSet<>();
            this.f210958b = ForwardZPlanShareOption.this.mIntent.getStringExtra(ForwardRecentActivity.KEY_FORWARD_SHARE_FROM_ZPLAN_APPID);
        }

        private void A(List<Long> list) {
            String b16 = b();
            if (TextUtils.isEmpty(b16)) {
                return;
            }
            int i3 = ForwardZPlanShareOption.this.mExtraData.getInt("uintype");
            for (Long l3 : list) {
                SessionInfo sessionInfo = new SessionInfo();
                sessionInfo.f179555d = i3;
                sessionInfo.f179557e = String.valueOf(l3);
                com.tencent.mobileqq.forward.utils.f.f211079a.i(sessionInfo, b16);
            }
        }

        private void B() {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            List<ResultRecord> multiTargetWithoutDataLine = ForwardZPlanShareOption.this.getMultiTargetWithoutDataLine();
            if (multiTargetWithoutDataLine != null) {
                for (ResultRecord resultRecord : multiTargetWithoutDataLine) {
                    long parseLong = Long.parseLong(resultRecord.uin);
                    int i3 = 1;
                    if (resultRecord.uinType == 1) {
                        i3 = 2;
                    }
                    arrayList2.add(new ShareTarget(i3, resultRecord.uin));
                    arrayList.add(Long.valueOf(parseLong));
                }
            }
            if (f()) {
                ((IZootopiaShareArkService) QRoute.api(IZootopiaShareArkService.class)).sendZplanArkMessage(arrayList2, ForwardZPlanShareOption.this.mExtraData, new Function1() { // from class: com.tencent.mobileqq.forward.aj
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit w3;
                        w3 = ForwardZPlanShareOption.NormalHelper.this.w(arrayList, (ZootopiaSendArkResult) obj);
                        return w3;
                    }
                });
            }
        }

        private void C() {
            String string;
            int i3;
            QLog.i("ForwardZPlanShareOption", 2, "sendSingleZplanArkMessage");
            if (f()) {
                if (v()) {
                    string = ForwardZPlanShareOption.this.mExtraData.getString("troop_uin");
                    QLog.i("ForwardZPlanShareOption", 2, "sendSingleZplanArkMessage groupId by troop_uin = " + string);
                    if (TextUtils.isEmpty(string)) {
                        string = ForwardZPlanShareOption.this.mExtraData.getString("uin");
                        QLog.i("ForwardZPlanShareOption", 2, "sendSingleZplanArkMessage groupId by uin = " + string);
                        if (TextUtils.isEmpty(string)) {
                            j(ForwardZPlanShareOption.this.app, null, 300L);
                            return;
                        }
                    }
                    i3 = 2;
                } else {
                    string = ForwardZPlanShareOption.this.mExtraData.getString("uin");
                    i3 = 1;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new ShareTarget(i3, string));
                if (d()) {
                    QLog.i("ForwardZPlanShareOption", 2, "sendSingleZplanArkMessage dress");
                    ((IZootopiaShareArkService) QRoute.api(IZootopiaShareArkService.class)).sendDressArkMessage(arrayList, ForwardZPlanShareOption.this.mExtraData, new Function1() { // from class: com.tencent.mobileqq.forward.ah
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit x16;
                            x16 = ForwardZPlanShareOption.NormalHelper.this.x((ZootopiaSendArkResult) obj);
                            return x16;
                        }
                    });
                } else {
                    QLog.i("ForwardZPlanShareOption", 2, "sendSingleZplanArkMessage zplan");
                    ((IZootopiaShareArkService) QRoute.api(IZootopiaShareArkService.class)).sendZplanArkMessage(arrayList, ForwardZPlanShareOption.this.mExtraData, new Function1() { // from class: com.tencent.mobileqq.forward.ai
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit y16;
                            y16 = ForwardZPlanShareOption.NormalHelper.this.y((ZootopiaSendArkResult) obj);
                            return y16;
                        }
                    });
                }
            }
        }

        private void D(ZootopiaSendArkResult zootopiaSendArkResult, String str) {
            if (zootopiaSendArkResult.getResult() == 0) {
                ForwardUtils.s0(ForwardZPlanShareOption.this.app, 300L);
                z();
            } else {
                j(ForwardZPlanShareOption.this.app, str, 300L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E(List<String> list) {
            this.f210960d.clear();
            this.f210961e.clear();
            if (list != null) {
                this.f210960d.addAll(list);
                int size = this.f210960d.size();
                for (int i3 = 0; i3 < size; i3++) {
                    this.f210961e.add(this.f210960d.get(i3));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s() {
            IZootopiaPortalMallSendGiftService iZootopiaPortalMallSendGiftService = (IZootopiaPortalMallSendGiftService) QRoute.api(IZootopiaPortalMallSendGiftService.class);
            ForwardZPlanShareOption forwardZPlanShareOption = ForwardZPlanShareOption.this;
            iZootopiaPortalMallSendGiftService.checkAndSendGift(forwardZPlanShareOption.mActivity, forwardZPlanShareOption.mExtraData, new b());
        }

        private DialogInterface.OnClickListener t() {
            if (this.f210962f == null) {
                this.f210962f = new a();
            }
            return this.f210962f;
        }

        private void u() {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.forward.ForwardZPlanShareOption.NormalHelper.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) NormalHelper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    List<String> readFromDB = ForwardZPlanUserList.readFromDB(NormalHelper.this.f210959c, ForwardZPlanShareOption.this.app.getCurrentAccountUin(), NormalHelper.this.f210958b);
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("getZPlanFriendList read from db list.size=");
                        if (readFromDB != null) {
                            i3 = readFromDB.size();
                        } else {
                            i3 = 0;
                        }
                        sb5.append(i3);
                        QLog.d("ForwardZPlanShareOption", 2, sb5.toString());
                    }
                    if (readFromDB != null) {
                        NormalHelper.this.E(readFromDB);
                        return;
                    }
                    IZPlanRequest iZPlanRequest = (IZPlanRequest) QRoute.api(IZPlanRequest.class);
                    NormalHelper normalHelper = NormalHelper.this;
                    iZPlanRequest.getZPlanForwardRecentList(ForwardZPlanShareOption.this.app, normalHelper.f210958b);
                }
            }, 16, null, true);
        }

        private boolean v() {
            if (ForwardZPlanShareOption.this.mExtraData.getInt("uintype") == 1) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit w(List list, ZootopiaSendArkResult zootopiaSendArkResult) {
            String str;
            QLog.i("ForwardZPlanShareOption", 1, "sendMultiArK Result " + zootopiaSendArkResult.getResult());
            if (zootopiaSendArkResult.getResult() == 0) {
                ForwardUtils.s0(ForwardZPlanShareOption.this.app, 300L);
                A(list);
            } else {
                if (d()) {
                    str = zootopiaSendArkResult.getErr();
                } else {
                    str = null;
                }
                j(ForwardZPlanShareOption.this.app, str, 300L);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit x(ZootopiaSendArkResult zootopiaSendArkResult) {
            QLog.i("ForwardZPlanShareOption", 1, "sendDressArK Result " + zootopiaSendArkResult.getResult());
            D(zootopiaSendArkResult, zootopiaSendArkResult.getErr());
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit y(ZootopiaSendArkResult zootopiaSendArkResult) {
            QLog.i("ForwardZPlanShareOption", 1, "sendZplanArK Result " + zootopiaSendArkResult.getResult());
            D(zootopiaSendArkResult, null);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z() {
            String b16 = b();
            if (TextUtils.isEmpty(b16)) {
                return;
            }
            String string = ForwardZPlanShareOption.this.mExtraData.getString("uin");
            String string2 = ForwardZPlanShareOption.this.mExtraData.getString("troop_uin");
            int i3 = ForwardZPlanShareOption.this.mExtraData.getInt("uintype");
            SessionInfo sessionInfo = new SessionInfo();
            sessionInfo.f179555d = i3;
            sessionInfo.f179557e = string;
            sessionInfo.f179559f = string2;
            com.tencent.mobileqq.forward.utils.f.f211079a.i(sessionInfo, b16);
        }

        @Override // com.tencent.mobileqq.forward.ForwardZPlanShareOption.BaseHelper
        void a(int i3, Bundle bundle) {
            super.a(i3, bundle);
            if (ForwardZPlanShareOption.this.getEditTextType() == 2 && ForwardZPlanShareOption.this.mExtraData.getBoolean(IZootopiaPortalMallSendGiftService.FORWARD_ZPLAN_SEND_GIFT, false)) {
                ForwardZPlanShareOption.this.mConfirmDialog.setPositiveButton("\u8d60\u9001", t());
            }
        }

        @Override // com.tencent.mobileqq.forward.ForwardZPlanShareOption.BaseHelper
        List<RecentUser> c(List<RecentUser> list) {
            ArrayList arrayList = new ArrayList();
            for (RecentUser recentUser : list) {
                if (recentUser != null && this.f210961e.contains(recentUser.uin) && !ForwardZPlanShareOption.this.app.getCurrentAccountUin().equals(recentUser.uin) && !Utils.J(recentUser.uin) && recentUser.getType() != 1008 && recentUser.getType() != 1021 && recentUser.getType() != 10004 && recentUser.getType() != 7000 && recentUser.getType() != 6004 && recentUser.getType() != 6002 && (recentUser.getType() != 1 || !ForwardZPlanShareOption.this.isHotChat(recentUser.uin))) {
                    if (recentUser.getType() != 1006 || ForwardZPlanShareOption.this.isSupportAbility(e.U3)) {
                        if (recentUser.getType() != 9501 && (recentUser.getType() != 0 || !CrmUtils.v(ForwardZPlanShareOption.this.app, recentUser.uin, recentUser.getType()))) {
                            if ((recentUser.getType() != 1004 && recentUser.getType() != 1000) || ForwardZPlanShareOption.this.mSurpportTroopDiscussionTmpConv) {
                                arrayList.add(recentUser);
                            }
                        }
                    }
                }
            }
            return arrayList;
        }

        @Override // com.tencent.mobileqq.forward.ForwardZPlanShareOption.BaseHelper
        boolean e() {
            if (this.f210960d.size() > 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.forward.ForwardZPlanShareOption.BaseHelper
        boolean g() {
            this.f210959c = ForwardZPlanShareOption.this.app.getEntityManagerFactory().createEntityManager();
            u();
            return true;
        }

        @Override // com.tencent.mobileqq.forward.ForwardZPlanShareOption.BaseHelper
        void h() {
            if (ForwardZPlanShareOption.this.isMultiTarget2Send()) {
                B();
            } else {
                C();
            }
        }

        @Override // com.tencent.mobileqq.forward.ForwardZPlanShareOption.BaseHelper
        void i(List<String> list) {
            QQAppInterface qQAppInterface = ForwardZPlanShareOption.this.app;
            if (qQAppInterface != null) {
                ForwardZPlanUserList.updateDB(this.f210959c, qQAppInterface.getCurrentAccountUin(), this.f210958b, list);
            }
            E(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends BaseHelper {
        static IPatchRedirector $redirector_;

        /* renamed from: com.tencent.mobileqq.forward.ForwardZPlanShareOption$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        class C7619a implements Function2<Integer, String, Unit> {
            static IPatchRedirector $redirector_;

            C7619a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(Integer num, String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) num, (Object) str);
                }
                QLog.i("ForwardZPlanShareOption", 1, "sendArK to Guild Result " + num + ", " + str);
                if (num.intValue() == 0) {
                    ForwardUtils.s0(ForwardZPlanShareOption.this.app, 300L);
                } else {
                    a aVar = a.this;
                    aVar.j(ForwardZPlanShareOption.this.app, null, 300L);
                }
                return null;
            }
        }

        a() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardZPlanShareOption.this);
            }
        }

        @Override // com.tencent.mobileqq.forward.ForwardZPlanShareOption.BaseHelper
        void h() {
            if (!f()) {
                QLog.e("ForwardZPlanShareOption", 1, "is not ZootopiaGameShareArk");
            } else {
                ((IZootopiaShareArkService) QRoute.api(IZootopiaShareArkService.class)).sendZplanArkMessageToGuild(b(), ForwardZPlanShareOption.this.mExtraData, new C7619a());
            }
        }
    }

    public ForwardZPlanShareOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        } else {
            this.f210953d = l();
        }
    }

    private BaseHelper l() {
        int intExtra = this.mIntent.getIntExtra("zplan_share_type", 0);
        QLog.i("ForwardZPlanShareOption", 1, "createHelper, type=" + intExtra);
        if (intExtra != 1) {
            return new NormalHelper();
        }
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.mForwardAbilities.add(e.O3);
        if (this.mIntent.getBooleanExtra("zplan_share_need_troop", false)) {
            this.mForwardAbilities.add(e.Q3);
            this.mForwardAbilities.add(e.P3);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardDialog(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) bundle);
        } else {
            super.buildForwardDialog(i3, bundle);
            this.f210953d.a(i3, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public String getEditHint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        String stringExtra = this.mIntent.getStringExtra("key_zplan_troop_ark_share");
        if (stringExtra != null) {
            return stringExtra;
        }
        return super.getEditHint();
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public List<RecentUser> getForwardRecentList(List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        }
        return this.f210953d.c(list);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String stringExtra = this.mIntent.getStringExtra(ForwardRecentActivity.KEY_FORWARD_TITLE);
        if (TextUtils.isEmpty(stringExtra)) {
            return "\u53ef\u9009\u62e9\u7684\u597d\u53cb";
        }
        return stringExtra;
    }

    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f210953d.e();
    }

    public void n(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
        } else {
            this.f210953d.i(list);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f210953d.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean realForwardTo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        this.f210953d.h();
        return super.realForwardTo(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public abstract class BaseHelper {
        static IPatchRedirector $redirector_;

        BaseHelper() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardZPlanShareOption.this);
            }
        }

        protected String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            String inputValue = ForwardZPlanShareOption.this.mConfirmDialog.getInputValue();
            boolean booleanExtra = ForwardZPlanShareOption.this.mIntent.getBooleanExtra("key_zplan_ark_need_send_hint", false);
            if (TextUtils.isEmpty(inputValue) && booleanExtra) {
                return ForwardZPlanShareOption.this.getEditHint();
            }
            return inputValue;
        }

        List<RecentUser> c(List<RecentUser> list) {
            return new ArrayList();
        }

        public boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return IZootopiaShareArkService.ZOOTOPIA_ARK_NAME_DRESS.equalsIgnoreCase(ForwardZPlanShareOption.this.mExtraData.getString("forward_ark_app_name"));
        }

        boolean e() {
            return true;
        }

        protected boolean f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            String string = ForwardZPlanShareOption.this.mExtraData.getString("forward_ark_app_name");
            if (!IZootopiaShareArkService.ZOOTOPIA_ARK_NAME.equalsIgnoreCase(string) && !IZootopiaShareArkService.ZOOTOPIA_ARK_NAME_DRESS.equalsIgnoreCase(string)) {
                return false;
            }
            return true;
        }

        boolean g() {
            return false;
        }

        abstract void h();

        protected void j(QQAppInterface qQAppInterface, String str, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, qQAppInterface, str, Long.valueOf(j3));
            } else {
                ThreadManager.getUIHandler().postDelayed(new Runnable(str, qQAppInterface) { // from class: com.tencent.mobileqq.forward.ForwardZPlanShareOption.BaseHelper.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f210955d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ QQAppInterface f210956e;

                    {
                        this.f210955d = str;
                        this.f210956e = qQAppInterface;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, BaseHelper.this, str, qQAppInterface);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        String str2 = this.f210955d;
                        if (str2 == null || str2.isEmpty()) {
                            str2 = this.f210956e.getApp().getString(R.string.f173102he3);
                        }
                        QQToast.makeText(this.f210956e.getApp(), 1, str2, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    }
                }, j3);
            }
        }

        void i(List<String> list) {
        }

        void a(int i3, Bundle bundle) {
        }
    }
}
