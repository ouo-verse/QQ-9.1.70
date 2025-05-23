package com.tencent.imcore.message.facade.send.sender;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes7.dex */
class f implements com.tencent.imcore.message.facade.f<QQAppInterface> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<Integer> f116642a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f116642a = new ArrayList<>(Arrays.asList(Integer.valueOf(MessageRecord.MSG_TYPE_STRUCT_MSG), -2007, -2002, -2000, Integer.valueOf(MessageRecord.MSG_TYPE_SHAKE_WINDOW), Integer.valueOf(MessageRecord.MSG_TYPE_MEDIA_SHORTVIDEO), Integer.valueOf(MessageRecord.MSG_TYPE_VAS_APOLLO), Integer.valueOf(MessageRecord.MSG_TYPE_ARK_APP), Integer.valueOf(MessageRecord.MSG_TYPE_POKE_MSG), Integer.valueOf(MessageRecord.MSG_TYPE_POKE_EMO_MSG), Integer.valueOf(MessageRecord.MSG_TYPE_STRUCT_LONG_TEXT), Integer.valueOf(MessageRecord.MSG_TYPE_QQSTORY), Integer.valueOf(MessageRecord.MSG_TYPE_MIX), Integer.valueOf(MessageRecord.MSG_TYPE_TROOP_WANT_GIFT_MSG), Integer.valueOf(MessageRecord.MSG_TYPE_TROOP_STORY), Integer.valueOf(MessageRecord.MSG_TYPE_STICKER_MSG), -7001, Integer.valueOf(MessageRecord.MSG_TYPE_FLASH_CHAT), Integer.valueOf(MessageRecord.MSG_TYPE_ARK_BABYQ_REPLY), Integer.valueOf(MessageRecord.MSG_TYPE_ARK_SDK_SHARE), Integer.valueOf(MessageRecord.MSG_TYPE_TRIBE_SHORT_VIDEO), Integer.valueOf(MessageRecord.MSG_TYPE_LIMIT_CHAT_CONFIRM), -8018, Integer.valueOf(MessageRecord.MSG_TYPE_ZPLAN), Integer.valueOf(MessageRecord.MSG_TYPE_VIDEO_EMOTICON)));
        }
    }

    @Override // com.tencent.imcore.message.facade.f
    public boolean a(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return this.f116642a.contains(Integer.valueOf(messageRecord.msgtype));
    }

    @Override // com.tencent.imcore.message.facade.f
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void b(QQAppInterface qQAppInterface, MessageRecord messageRecord, BusinessObserver businessObserver, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, qQAppInterface, messageRecord, businessObserver, Boolean.valueOf(z16));
        } else {
            qQAppInterface.getMsgHandler().j5(messageRecord, businessObserver, z16);
        }
    }
}
