package com.tencent.biz.pubaccount.util;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.p;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.vas.at;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QZoneConfigHelper;
import java.net.URL;
import java.util.List;
import java.util.regex.Pattern;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes4.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static m f80362a;

    m() {
    }

    private static String a(byte[] bArr) {
        String str = "";
        for (byte b16 : bArr) {
            String hexString = Integer.toHexString(b16 & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            str = str + " " + hexString;
        }
        return str;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("ShareStructLongMessageManager", 2, "url is empty");
            }
            return null;
        }
        try {
            return Uri.parse(str).getQueryParameter(AppConstants.Key.SHARE_REQ_ARTICLE_ID);
        } catch (Exception unused) {
            return null;
        }
    }

    public static m c() {
        if (f80362a == null) {
            f80362a = new m();
        }
        return f80362a;
    }

    public static String e(AbsStructMsg absStructMsg) {
        String[] f16;
        if ((absStructMsg instanceof StructMsgForGeneralShare) && ((StructMsgForGeneralShare) absStructMsg).mIsPAVideoStructMsg) {
            if (QLog.isColorLevel()) {
                QLog.d("ShareStructLongMessageManager", 2, "is video struct msg");
            }
            return null;
        }
        if (!TextUtils.isEmpty(absStructMsg.mMsgUrl)) {
            return absStructMsg.mMsgUrl;
        }
        if (!com.tencent.mobileqq.richmediabrowser.j.e(absStructMsg.mMsgActionData) || (f16 = com.tencent.mobileqq.richmediabrowser.j.f(absStructMsg.mMsgActionData)) == null || f16.length <= 2) {
            return null;
        }
        return f16[1];
    }

    public static boolean f(AbsStructMsg absStructMsg) {
        String[] f16;
        if (com.tencent.mobileqq.richmediabrowser.j.e(absStructMsg.mMsgActionData) && (f16 = com.tencent.mobileqq.richmediabrowser.j.f(absStructMsg.mMsgActionData)) != null && f16.length > 2) {
            String str = f16[1];
            if (!TextUtils.isEmpty(str)) {
                if (Pattern.compile("http://.*.mp.qq.com.*").matcher(str).matches()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ShareStructLongMessageManager", 2, "matches!");
                    }
                    return true;
                }
                if (Pattern.compile("https://.*.mp.qq.com.*").matcher(str).matches()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ShareStructLongMessageManager", 2, "matches!");
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static boolean i(AbsStructMsg absStructMsg) {
        if (absStructMsg instanceof StructMsgForGeneralShare) {
            if ("micro_app".equals(absStructMsg.mMsg_A_ActionData)) {
                return true;
            }
            StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) absStructMsg;
            if (structMsgForGeneralShare.needSendLongMsgWhenFailed) {
                return true;
            }
            if (structMsgForGeneralShare.mIsPAVideoStructMsg) {
                if (QLog.isColorLevel()) {
                    QLog.d("ShareStructLongMessageManager", 2, "matches!");
                }
                return true;
            }
            int i3 = structMsgForGeneralShare.mMsgServiceID;
            if (i3 == 118) {
                if (QLog.isColorLevel()) {
                    QLog.d("ShareStructLongMessageManager", 2, "tribe matches!");
                }
                return true;
            }
            if (i3 == 35) {
                if (QLog.isColorLevel()) {
                    QLog.d("ShareStructLongMessageManager", 2, "MULTI_MSG matches!");
                }
                return true;
            }
            if (i3 == 83) {
                if (QLog.isColorLevel()) {
                    QLog.d("ShareStructLongMessageManager", 2, "gallery matches!");
                }
                return true;
            }
            if (i3 == 123) {
                if (QLog.isColorLevel()) {
                    QLog.d("ShareStructLongMessageManager", 2, "confess general share msg matches!");
                }
                return true;
            }
            if (i3 != 151 && i3 != 156) {
                if (!TextUtils.isEmpty(absStructMsg.mMsgUrl)) {
                    String str = absStructMsg.mMsgUrl;
                    try {
                        Uri parse = Uri.parse(str);
                        if (at.a().b(parse.getHost())) {
                            return true;
                        }
                        if (QZoneConfigHelper.e(parse.getHost())) {
                            return true;
                        }
                    } catch (Exception e16) {
                        QLog.e("ShareStructLongMessageManager", 1, "shouldShareStructLongMessage vip url exception, url = " + str, e16);
                    }
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("ShareStructLongMessageManager", 2, "STRUCT_TYPE_NEW_SUBSCRIBE_ACCOUNT_NEWS share msg matches!");
                }
                return true;
            }
        }
        if (!TextUtils.isEmpty(absStructMsg.mMsgUrl)) {
            if (Pattern.compile("http://.*.mp.qq.com.*").matcher(absStructMsg.mMsgUrl).matches()) {
                if (QLog.isColorLevel()) {
                    QLog.d("ShareStructLongMessageManager", 2, "matches!");
                }
                return true;
            }
            if (Pattern.compile("https://.*.mp.qq.com.*").matcher(absStructMsg.mMsgUrl).matches()) {
                if (QLog.isColorLevel()) {
                    QLog.d("ShareStructLongMessageManager", 2, "matches!");
                }
                return true;
            }
            try {
                if (((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).checkNeedLongMessageChannel(new URL(absStructMsg.mMsgUrl).getHost())) {
                    return true;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        if (!TextUtils.isEmpty(absStructMsg.mMsgActionData)) {
            return f(absStructMsg);
        }
        return false;
    }

    private boolean j(QQAppInterface qQAppInterface, byte[] bArr, String str, String str2, String str3, int i3, long j3, int i16, ad adVar) {
        if (QLog.isColorLevel()) {
            QLog.d("ShareStructLongMessageManager", 2, "[sendLongTextMsg]data.length = " + bArr.length);
        }
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = true;
        transferRequest.mFileType = FileMsg.TRANSFILE_TYPE_MULTIMSG;
        transferRequest.multiMsgType = 1;
        transferRequest.toSendData = bArr;
        transferRequest.mSelfUin = str;
        transferRequest.mPeerUin = str2;
        transferRequest.mSecondId = str3;
        transferRequest.mUinType = i3;
        transferRequest.mUniseq = j3;
        transferRequest.mBusiType = i16;
        transferRequest.mUpCallBack = adVar;
        transferRequest.upMsgBusiType = d();
        ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
        return true;
    }

    public int d() {
        return 3;
    }

    public void g(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        messageRecord.extraflag = 32768;
        qQAppInterface.getMsgCache().G1(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq);
        ((MessageHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.k3(messageRecord.istroop), false, new Object[]{messageRecord.frienduin, Integer.valueOf(messageRecord.istroop), -1, null, 0L, Long.valueOf(messageRecord.uniseq)});
    }

    public void h(QQAppInterface qQAppInterface, MessageRecord messageRecord, bs bsVar, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("ShareStructLongMessageManager", 2, "step2: sendShareStructLongMessage saveMessage end and pack ShareStructLongMessage start currenttime:" + System.currentTimeMillis());
        }
        if (!(messageRecord instanceof MessageForStructing)) {
            QLog.d("ShareStructLongMessageManager", 2, "is not MessageForStructing");
            return;
        }
        byte[] xmlBytes = ((MessageForStructing) messageRecord).structingMsg.getXmlBytes();
        if (QLog.isColorLevel()) {
            QLog.d("ShareStructLongMessageManager", 2, "buff is " + xmlBytes);
        }
        String a16 = a(xmlBytes);
        if (QLog.isColorLevel()) {
            QLog.d("ShareStructLongMessageManager", 2, "buffer is " + a16);
        }
        if (xmlBytes == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ShareStructLongMessageManager", 2, "step2: sendShareStructLongMessage pack failed! packData is null.............................");
            }
            messageRecord.extraflag = 32768;
            qQAppInterface.getMsgCache().G1(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq);
            ((MessageHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.k3(messageRecord.istroop), false, new Object[]{messageRecord.frienduin, Integer.valueOf(messageRecord.istroop), -1, null, 0L, Long.valueOf(messageRecord.uniseq)});
            return;
        }
        boolean j3 = j(qQAppInterface, xmlBytes, qQAppInterface.getCurrentAccountUin(), messageRecord.frienduin, messageRecord.selfuin, messageRecord.istroop, messageRecord.uniseq + 1, 1035, new a(messageRecord, qQAppInterface, bsVar, z16));
        if (j3) {
            if (QLog.isColorLevel()) {
                QLog.d("ShareStructLongMessageManager", 2, "sendShareStructLongMessage successful, uploadShareStructLongMessagePkg start!");
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("ShareStructLongMessageManager", 2, "sendShareStructLongMessage failed! isSuccess:" + j3);
            }
            g(qQAppInterface, messageRecord);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements ad {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MessageRecord f80363d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f80364e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ bs f80365f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f80366h;

        a(MessageRecord messageRecord, QQAppInterface qQAppInterface, bs bsVar, boolean z16) {
            this.f80363d = messageRecord;
            this.f80364e = qQAppInterface;
            this.f80365f = bsVar;
            this.f80366h = z16;
        }

        @Override // com.tencent.mobileqq.pic.ad
        public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
            return null;
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void q(ad.a aVar) {
            try {
                if (aVar.f258597a == 0) {
                    MessageRecord messageRecord = this.f80363d;
                    if (messageRecord instanceof MessageForStructing) {
                        MessageForStructing messageForStructing = (MessageForStructing) messageRecord;
                        im_msg_body$RichText im_msg_body_richtext = messageForStructing.richText;
                        if (im_msg_body_richtext == null) {
                            im_msg_body$RichText y16 = p.y(messageForStructing);
                            if (y16 != null) {
                                List<im_msg_body$Elem> list = y16.elems.get();
                                if (QLog.isColorLevel()) {
                                    QLog.d("ShareStructLongMessageManager", 2, "current uid is" + aVar.f258602f);
                                }
                                for (im_msg_body$Elem im_msg_body_elem : list) {
                                    if (im_msg_body_elem.rich_msg.has()) {
                                        im_msg_body_elem.rich_msg.bytes_msg_resid.set(ByteStringMicro.copyFrom(aVar.f258602f.getBytes()));
                                        im_msg_body_elem.rich_msg.bytes_template_1.set(ByteStringMicro.EMPTY);
                                    } else if (im_msg_body_elem.text.has() && im_msg_body_elem.text.str.has()) {
                                        String stringUtf8 = im_msg_body_elem.text.str.get().toStringUtf8();
                                        if (stringUtf8.length() > 500) {
                                            im_msg_body_elem.text.str.set(ByteStringMicro.copyFromUtf8(stringUtf8.substring(0, 500)));
                                        }
                                    }
                                }
                                messageForStructing.richText = y16;
                            }
                        } else {
                            List<im_msg_body$Elem> list2 = im_msg_body_richtext.elems.get();
                            if (QLog.isColorLevel()) {
                                QLog.d("ShareStructLongMessageManager", 2, "current uid is" + aVar.f258602f);
                            }
                            if (list2 != null && m.f(messageForStructing.structingMsg)) {
                                for (im_msg_body$Elem im_msg_body_elem2 : list2) {
                                    if (im_msg_body_elem2.rich_msg.has()) {
                                        im_msg_body_elem2.rich_msg.bytes_msg_resid.set(ByteStringMicro.copyFrom(aVar.f258602f.getBytes()));
                                        im_msg_body_elem2.rich_msg.bytes_template_1.set(ByteStringMicro.EMPTY);
                                        im_msg_body_elem2.rich_msg.uint32_service_id.set(messageForStructing.structingMsg.mMsgServiceID);
                                    } else if (im_msg_body_elem2.text.has() && im_msg_body_elem2.text.str.has()) {
                                        String stringUtf82 = im_msg_body_elem2.text.str.get().toStringUtf8();
                                        if (stringUtf82.length() > 500) {
                                            im_msg_body_elem2.text.str.set(ByteStringMicro.copyFromUtf8(stringUtf82.substring(0, 500)));
                                        }
                                    }
                                }
                            }
                        }
                        this.f80364e.getMessageFacade().E0(this.f80363d, this.f80365f, this.f80366h);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ShareStructLongMessageManager", 2, "upload  msg pack failed, result.errStr=" + aVar.f258598b + ",result.errStr=" + aVar.f258599c);
                }
                m.this.g(this.f80364e, this.f80363d);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ShareStructLongMessageManager", 2, "upload  msg pack failed, catch exception", e16);
                }
                m.this.g(this.f80364e, this.f80363d);
            }
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void r(ad.a aVar) {
        }
    }
}
