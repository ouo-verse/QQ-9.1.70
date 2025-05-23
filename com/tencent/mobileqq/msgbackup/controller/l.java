package com.tencent.mobileqq.msgbackup.controller;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.api.IMsgMixed;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class l implements d {
    static IPatchRedirector $redirector_;

    public l(BaseQQAppInterface baseQQAppInterface) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
    }

    public static com.tencent.mobileqq.msgbackup.msgprocess.i h(MessageRecord messageRecord) {
        if (messageRecord instanceof MessageForPic) {
            return new com.tencent.mobileqq.msgbackup.msgprocess.e((MessageForPic) messageRecord);
        }
        if (messageRecord instanceof MessageForShortVideo) {
            return new com.tencent.mobileqq.msgbackup.msgprocess.j((MessageForShortVideo) messageRecord);
        }
        if (messageRecord instanceof MessageForPtt) {
            return new com.tencent.mobileqq.msgbackup.msgprocess.g((MessageForPtt) messageRecord);
        }
        if (messageRecord instanceof MessageForMarketFace) {
            return new com.tencent.mobileqq.msgbackup.msgprocess.a(messageRecord);
        }
        if (((IMsgMixed) QRoute.api(IMsgMixed.class)).isMessageForMixedMsg(messageRecord)) {
            return new com.tencent.mobileqq.msgbackup.msgprocess.d(messageRecord);
        }
        if (messageRecord instanceof MessageForAniSticker) {
            return new com.tencent.mobileqq.msgbackup.msgprocess.a(messageRecord);
        }
        return null;
    }

    public static com.tencent.mobileqq.msgbackup.msgprocess.c i(MsgBackupResEntity msgBackupResEntity) {
        com.tencent.mobileqq.msgbackup.msgprocess.c fVar;
        int i3 = msgBackupResEntity.msgType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return null;
                }
                fVar = new com.tencent.mobileqq.msgbackup.msgprocess.h(msgBackupResEntity);
            } else {
                fVar = new com.tencent.mobileqq.msgbackup.msgprocess.k(msgBackupResEntity);
            }
        } else {
            fVar = new com.tencent.mobileqq.msgbackup.msgprocess.f(msgBackupResEntity);
        }
        return fVar;
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.d
    public boolean a(MessageRecord messageRecord) {
        com.tencent.mobileqq.msgbackup.msgprocess.i h16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) messageRecord)).booleanValue();
        }
        if (messageRecord != null && (h16 = h(messageRecord)) != null) {
            return h16.c();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.d
    public k b(MessageRecord messageRecord, MsgBackupResEntity msgBackupResEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (k) iPatchRedirector.redirect((short) 9, (Object) this, (Object) messageRecord, (Object) msgBackupResEntity);
        }
        com.tencent.mobileqq.msgbackup.msgprocess.c i3 = i(msgBackupResEntity);
        if (i3 != null) {
            return i3.d();
        }
        return new k();
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.d
    public boolean c(MsgBackupResEntity msgBackupResEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) msgBackupResEntity)).booleanValue();
        }
        int i3 = msgBackupResEntity.msgType;
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.d
    public void d(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) messageRecord);
            return;
        }
        com.tencent.mobileqq.msgbackup.msgprocess.i h16 = h(messageRecord);
        if (h16 != null) {
            h16.d();
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.d
    public String e(MessageRecord messageRecord, MsgBackupResEntity msgBackupResEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) messageRecord, (Object) msgBackupResEntity);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.d
    public void f(MessageRecord messageRecord, List<MsgBackupResEntity> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) messageRecord, (Object) list);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.controller.d
    public void g(MsgBackupResEntity msgBackupResEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) msgBackupResEntity);
            return;
        }
        com.tencent.mobileqq.msgbackup.msgprocess.c i3 = i(msgBackupResEntity);
        if (i3 != null) {
            i3.i();
        }
    }

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
