package com.tencent.mobileqq.activity.troop.config;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager;
import com.tencent.mobileqq.troop.data.x;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496$AioKeyword;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496$GroupMsgConfig;

/* loaded from: classes10.dex */
public class TroopConfigProcessor extends com.tencent.mobileqq.troop.api.config.g {
    static IPatchRedirector $redirector_;

    public TroopConfigProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.g
    public void a(AppInterface appInterface, oidb_0x496$AioKeyword oidb_0x496_aiokeyword) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInterface, (Object) oidb_0x496_aiokeyword);
        } else if (appInterface instanceof QQAppInterface) {
            ThreadManagerV2.post(new Runnable((QQAppInterface) appInterface, oidb_0x496_aiokeyword) { // from class: com.tencent.mobileqq.activity.troop.config.TroopConfigProcessor.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQAppInterface f186607d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ oidb_0x496$AioKeyword f186608e;

                {
                    this.f186607d = r8;
                    this.f186608e = oidb_0x496_aiokeyword;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopConfigProcessor.this, r8, oidb_0x496_aiokeyword);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ((TroopAioKeywordTipManager) this.f186607d.getManager(QQManagerFactory.TROOP_AIO_KEYWORD_TIP_MANAGER)).q(com.tencent.mobileqq.troop.data.g.a(this.f186608e), com.tencent.mobileqq.troop.data.g.b(this.f186608e));
                        com.tencent.mobileqq.troop.data.g.g(this.f186607d, this.f186608e);
                    }
                }
            }, 8, null, true);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.g
    public void b(AppInterface appInterface, oidb_0x496$GroupMsgConfig oidb_0x496_groupmsgconfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, (Object) oidb_0x496_groupmsgconfig);
            return;
        }
        if ((appInterface instanceof QQAppInterface) && oidb_0x496_groupmsgconfig != null && oidb_0x496_groupmsgconfig.has() && oidb_0x496_groupmsgconfig.bool_uin_enable.has() && oidb_0x496_groupmsgconfig.uint32_max_aio_msg.has() && oidb_0x496_groupmsgconfig.uint32_enable_helper.has() && oidb_0x496_groupmsgconfig.uint32_group_max_number.has()) {
            x G1 = ((QQAppInterface) appInterface).getMessageFacade().G1();
            G1.I = oidb_0x496_groupmsgconfig.bool_uin_enable.get();
            G1.J = oidb_0x496_groupmsgconfig.uint32_max_aio_msg.get();
            G1.L = oidb_0x496_groupmsgconfig.uint32_group_max_number.get();
            G1.M = oidb_0x496_groupmsgconfig.uint32_enable_helper.get();
        }
    }
}
