package com.tencent.mobileqq.service.message.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.e;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.api.IQMessageProtoCodecService;
import com.tencent.mobileqq.service.message.w;
import com.tencent.mobileqq.text.AbsQQText;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AccountNotMatchException;
import mqq.app.MobileQQ;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype33;
import tencent.im.msg.im_msg_body$CommonElem;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$Face;
import tencent.im.msg.im_msg_body$SmallEmoji;
import tencent.im.msg.im_msg_body$Text;

/* loaded from: classes18.dex */
public class QMessageProtoCodecServiceImpl implements IQMessageProtoCodecService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MessageProtoCodecApiImpl";

    public QMessageProtoCodecServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.service.message.api.IQMessageProtoCodecService
    public boolean needProcessEmotion(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3)).booleanValue();
        }
        if (str.charAt(i3) == 20 && i3 + 1 < str.length()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.service.message.api.IQMessageProtoCodecService
    public void processEmotion(w.b bVar) {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
            return;
        }
        if (bVar.f286350f.length() > 0) {
            w.j(bVar.f286345a, bVar.f286350f.toString());
            StringBuilder sb5 = bVar.f286350f;
            sb5.delete(0, sb5.length());
            bVar.f286348d++;
        }
        char charAt = bVar.f286346b.charAt(bVar.f286351g + 1);
        if (charAt == '\u00fa') {
            charAt = '\n';
        }
        if (QQSysFaceUtil.isValidFaceId(charAt)) {
            int convertToServer = QQSysFaceUtil.convertToServer(charAt);
            if (convertToServer >= 260) {
                hummer_commelem$MsgElemInfo_servtype33 hummer_commelem_msgeleminfo_servtype33 = new hummer_commelem$MsgElemInfo_servtype33();
                hummer_commelem_msgeleminfo_servtype33.uint32_index.set(convertToServer);
                String faceDescription = QQSysFaceUtil.getFaceDescription(charAt);
                hummer_commelem_msgeleminfo_servtype33.bytes_text.set(ByteStringMicro.copyFromUtf8(faceDescription));
                hummer_commelem_msgeleminfo_servtype33.bytes_compat.set(ByteStringMicro.copyFromUtf8(faceDescription));
                im_msg_body$CommonElem im_msg_body_commonelem = new im_msg_body$CommonElem();
                im_msg_body_commonelem.uint32_service_type.set(33);
                im_msg_body_commonelem.uint32_business_type.set(1);
                im_msg_body_commonelem.bytes_pb_elem.set(ByteStringMicro.copyFrom(hummer_commelem_msgeleminfo_servtype33.toByteArray()));
                im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
                im_msg_body_elem.common_elem.set(im_msg_body_commonelem);
                bVar.f286345a.elems.add(im_msg_body_elem);
            } else {
                im_msg_body$Face im_msg_body_face = new im_msg_body$Face();
                im_msg_body_face.index.set(convertToServer);
                im_msg_body$Elem im_msg_body_elem2 = new im_msg_body$Elem();
                im_msg_body_elem2.f435954face.set(im_msg_body_face);
                bVar.f286345a.elems.add(im_msg_body_elem2);
            }
            bVar.f286348d++;
            bVar.f286351g++;
            return;
        }
        if (bVar.f286351g + 4 < bVar.f286346b.length()) {
            char[] cArr = new char[4];
            cArr[3] = bVar.f286346b.charAt(bVar.f286351g + 1);
            cArr[2] = bVar.f286346b.charAt(bVar.f286351g + 2);
            cArr[1] = bVar.f286346b.charAt(bVar.f286351g + 3);
            cArr[0] = bVar.f286346b.charAt(bVar.f286351g + 4);
            for (int i3 = 0; i3 < 4; i3++) {
                char c16 = cArr[i3];
                if (c16 == '\u00fa') {
                    cArr[i3] = '\n';
                } else if (c16 == '\u00fe') {
                    cArr[i3] = '\r';
                }
            }
            int[] r16 = e.r(cArr);
            Emoticon emoticon = null;
            try {
                appInterface = (AppInterface) BaseApplicationImpl.getApplication().getAppRuntime(MobileQQ.sMobileQQ.getLastLoginUin());
            } catch (AccountNotMatchException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "[AccountNotMatchException]," + e16.getMessage());
                }
                appInterface = null;
            }
            String str = AbsQQText.SMALL_EMOJI_SYMBOL;
            if (appInterface != null) {
                IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) appInterface.getRuntimeService(IEmoticonManagerService.class, "");
                if (iEmoticonManagerService != null) {
                    emoticon = iEmoticonManagerService.syncFindEmoticonById(Integer.toString(r16[0]), Integer.toString(r16[1]));
                }
                if (emoticon != null) {
                    str = emoticon.character;
                }
            }
            int i16 = (r16[0] << 16) + r16[1];
            im_msg_body$SmallEmoji im_msg_body_smallemoji = new im_msg_body$SmallEmoji();
            im_msg_body_smallemoji.packIdSum.set(i16);
            char c17 = cArr[3];
            if (c17 == '\u00ff') {
                im_msg_body_smallemoji.imageType.set(1);
            } else if (c17 == '\u01ff') {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "send apng epid = " + r16[0] + " eid = " + r16[1]);
                }
                im_msg_body_smallemoji.imageType.set(2);
            }
            im_msg_body$Elem im_msg_body_elem3 = new im_msg_body$Elem();
            im_msg_body_elem3.small_emoji.set(im_msg_body_smallemoji);
            bVar.f286345a.elems.add(im_msg_body_elem3);
            bVar.f286348d++;
            im_msg_body$Text im_msg_body_text = new im_msg_body$Text();
            im_msg_body_text.str.set(ByteStringMicro.copyFromUtf8(str));
            im_msg_body$Elem im_msg_body_elem4 = new im_msg_body$Elem();
            im_msg_body_elem4.text.set(im_msg_body_text);
            bVar.f286345a.elems.add(im_msg_body_elem4);
            bVar.f286348d++;
            bVar.f286351g += 4;
        }
    }

    @Override // com.tencent.mobileqq.service.message.api.IQMessageProtoCodecService
    public void recordCookie(AppInterface appInterface, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appInterface, (Object) bArr);
        } else if (appInterface instanceof QQAppInterface) {
            ((QQAppInterface) appInterface).getParcelHooker().recordCookie(bArr);
        }
    }
}
