package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.aj;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountConfigApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class SubMessageManager extends BaseMessageManager {
    static IPatchRedirector $redirector_;

    public SubMessageManager(AppRuntime appRuntime, MsgPool msgPool) {
        super(appRuntime, msgPool);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) msgPool);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(int i3, boolean z16, boolean z17, boolean z18) {
        ArrayList<String> allSubUin;
        boolean z19;
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setSubAccountAssistantRead mainThread=");
            if (Looper.getMainLooper() == Looper.myLooper()) {
                z19 = true;
            } else {
                z19 = false;
            }
            sb5.append(z19);
            QLog.i("Q.msg.BaseMessageManager", 4, sb5.toString());
        }
        ISubAccountService iSubAccountService = (ISubAccountService) this.f116281d.getRuntimeService(ISubAccountService.class, "");
        if (iSubAccountService != null && (allSubUin = iSubAccountService.getAllSubUin()) != null) {
            for (String str : allSubUin) {
                if (!TextUtils.isEmpty(str)) {
                    C0(str, i3, z16, z17, z18);
                }
            }
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public long A(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, (Object) messageRecord)).longValue();
        }
        return 0L;
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void B(String str, int i3, List<MessageRecord> list, List<MessageRecord> list2, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), list, list2, bundle);
        }
    }

    public void B0(String str, int i3, boolean z16, boolean z17) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (this.f116283f.getUnreadCount(str, i3) > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setReaded clean one uin = " + str);
            }
            MessageRecord E = y(i3).E(str, i3);
            IConversationFacade iConversationFacade = this.f116283f;
            if (E != null) {
                j3 = A(E);
            } else {
                j3 = 0;
            }
            iConversationFacade.cleanUnread(str, i3, j3, z16, z17);
            b(str, i3);
            if (((IFeatureRuntimeService) this.f116281d.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("sub_accout_message_set_read_async")) {
                ThreadManagerV2.excute(new Runnable(str, i3) { // from class: com.tencent.mobileqq.app.message.SubMessageManager.3
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f195871d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f195872e;

                    {
                        this.f195871d = str;
                        this.f195872e = i3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, SubMessageManager.this, str, Integer.valueOf(i3));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            IMessageFacade iMessageFacade = SubMessageManager.this.f116282e;
                            iMessageFacade.setChangeAndNotify(iMessageFacade.getLastMessage(this.f195871d, this.f195872e));
                        }
                    }
                }, 32, null, true);
                return;
            } else {
                IMessageFacade iMessageFacade = this.f116282e;
                iMessageFacade.setChangeAndNotify(iMessageFacade.getLastMessage(str, i3));
                return;
            }
        }
        if (this.f116283f.getUnreadCountFromExtInt2(str, i3) > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setTroopReaded clean one uin = " + str);
            }
            b(str, i3);
        }
    }

    public void C0(String str, int i3, boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
        } else if (z18) {
            ThreadManagerV2.excute(new Runnable(str, i3, z16, z17) { // from class: com.tencent.mobileqq.app.message.SubMessageManager.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f195867d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f195868e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ boolean f195869f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ boolean f195870h;

                {
                    this.f195867d = str;
                    this.f195868e = i3;
                    this.f195869f = z16;
                    this.f195870h = z17;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SubMessageManager.this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        SubMessageManager.this.B0(this.f195867d, this.f195868e, this.f195869f, this.f195870h);
                    }
                }
            }, 32, null, true);
        } else {
            B0(str, i3, z16, z17);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void a(MessageRecord messageRecord, EntityManager entityManager, boolean z16, boolean z17, boolean z18, boolean z19, BaseMessageManager.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, messageRecord, entityManager, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), aVar);
            return;
        }
        if (messageRecord == null) {
            return;
        }
        if (messageRecord.time == 0) {
            messageRecord.time = com.tencent.mobileqq.service.message.e.K0();
        }
        if (messageRecord.msgseq == 0) {
            messageRecord.msgseq = (int) messageRecord.time;
        }
        o0(messageRecord, true, 1);
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void b(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3);
            return;
        }
        super.b(str, i3);
        if (((ISubAccountConfigApi) QRoute.api(ISubAccountConfigApi.class)).getIsHideSubAccountTroopMsg()) {
            return;
        }
        this.f116283f.setSubAccountTroopUnReadMsg(str, i3, 0);
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void i0(String str, int i3, boolean z16, boolean z17, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i16));
            return;
        }
        if (((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).isRemoveSubUnreadConversationDB()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setReaded uin=" + str + ",type=" + i3 + ",needDelMark=" + z17);
        }
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setReaded return : uin=null");
                return;
            }
            return;
        }
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) this.f116281d.getRuntimeService(IFeatureRuntimeService.class, "all");
        boolean isFeatureSwitchEnable = iFeatureRuntimeService.isFeatureSwitchEnable("sub_accout_message_set_read_async");
        if (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setReaded return : clean all");
            }
            if (iFeatureRuntimeService.isFeatureSwitchEnable("sub_message_set_read_get_service_async")) {
                ThreadManagerV2.excute(new Runnable(i3, z16) { // from class: com.tencent.mobileqq.app.message.SubMessageManager.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f195865d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ boolean f195866e;

                    {
                        this.f195865d = i3;
                        this.f195866e = z16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, SubMessageManager.this, Integer.valueOf(i3), Boolean.valueOf(z16));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        SubMessageManager subMessageManager = SubMessageManager.this;
                        int i17 = this.f195865d;
                        boolean z18 = this.f195866e;
                        subMessageManager.D0(i17, z18, z18, false);
                    }
                }, 32, null, true);
                return;
            } else {
                D0(i3, z16, z16, isFeatureSwitchEnable);
                return;
            }
        }
        C0(str, i3, z16, z17, isFeatureSwitchEnable);
    }

    @Override // com.tencent.imcore.message.BaseMessageManager
    public void n(String str, int i3, int i16, aj ajVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16), ajVar);
        }
    }
}
