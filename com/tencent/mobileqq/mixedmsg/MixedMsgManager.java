package com.tencent.mobileqq.mixedmsg;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.image.GifDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bo;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.message.msgstorage.api.IMsgStorageApi;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pic.ac;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.pic.l;
import com.tencent.mobileqq.pic.p;
import com.tencent.mobileqq.pic.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import localpb.richMsg.MixedMsg$Elem;
import localpb.richMsg.MixedMsg$Msg;
import localpb.richMsg.RichMsg$PicRec;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body$CustomFace;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$NotOnlineImage;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MixedMsgManager implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private static final String f247171h;

    /* renamed from: d, reason: collision with root package name */
    private long f247172d;

    /* renamed from: e, reason: collision with root package name */
    public ConcurrentHashMap<Long, ChatMessage> f247173e;

    /* renamed from: f, reason: collision with root package name */
    public QQAppInterface f247174f;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.mixedmsg.MixedMsgManager$6, reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass6 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MessageForPic f247180d;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ((IPicHelper) QRoute.api(IPicHelper.class)).cachePicToDisk(this.f247180d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a extends ac.b {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f247181d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MessageForMixedMsg f247182e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f247183f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f247184h;

        a(int i3, MessageForMixedMsg messageForMixedMsg, QQAppInterface qQAppInterface, String str) {
            this.f247181d = i3;
            this.f247182e = messageForMixedMsg;
            this.f247183f = qQAppInterface;
            this.f247184h = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MixedMsgManager.this, Integer.valueOf(i3), messageForMixedMsg, qQAppInterface, str);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0127  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0145  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean a(MessageForPic messageForPic, q qVar) {
            boolean z16;
            String stringUtf8;
            im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
            im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
            Object obj = qVar.f258793d;
            boolean z17 = true;
            if (obj != null) {
                String str = "";
                if (obj instanceof im_msg_body$NotOnlineImage) {
                    im_msg_body_elem.not_online_image.set((im_msg_body$NotOnlineImage) obj);
                    if (qVar.f258795f) {
                        if (im_msg_body_elem.not_online_image.res_id.has()) {
                            stringUtf8 = im_msg_body_elem.not_online_image.res_id.get().toStringUtf8();
                        } else {
                            if (im_msg_body_elem.not_online_image.download_path.has()) {
                                stringUtf8 = im_msg_body_elem.not_online_image.download_path.get().toStringUtf8();
                            }
                            messageForPic.uuid = str;
                            messageForPic.path = str;
                            messageForPic.thumbMsgUrl = im_msg_body_elem.not_online_image.str_thumb_url.get();
                            messageForPic.thumbHeight = im_msg_body_elem.not_online_image.uint32_thumb_height.get();
                            messageForPic.thumbWidth = im_msg_body_elem.not_online_image.uint32_thumb_width.get();
                            messageForPic.md5 = FileUtils.calcMd5(MixedMsgManager.f247171h);
                            messageForPic.msgData = messageForPic.getSerialPB().toByteArray();
                        }
                        str = stringUtf8;
                        messageForPic.uuid = str;
                        messageForPic.path = str;
                        messageForPic.thumbMsgUrl = im_msg_body_elem.not_online_image.str_thumb_url.get();
                        messageForPic.thumbHeight = im_msg_body_elem.not_online_image.uint32_thumb_height.get();
                        messageForPic.thumbWidth = im_msg_body_elem.not_online_image.uint32_thumb_width.get();
                        messageForPic.md5 = FileUtils.calcMd5(MixedMsgManager.f247171h);
                        messageForPic.msgData = messageForPic.getSerialPB().toByteArray();
                    }
                    QLog.i("MixedMsgManager", 1, "updateMessageForPic, add not_online_image, to-uin-type=" + this.f247181d + ", pic-uuid=" + str);
                } else if (obj instanceof im_msg_body$CustomFace) {
                    im_msg_body_elem.custom_face.set((im_msg_body$CustomFace) obj);
                    if (qVar.f258795f) {
                        if (im_msg_body_elem.custom_face.str_file_path.has()) {
                            str = im_msg_body_elem.custom_face.str_file_path.get();
                        }
                        messageForPic.path = str;
                        messageForPic.uuid = str;
                        messageForPic.md5 = FileUtils.calcMd5(MixedMsgManager.f247171h);
                        messageForPic.msgData = messageForPic.getSerialPB().toByteArray();
                    }
                    QLog.i("MixedMsgManager", 1, "updateMessageForPic, add CustomFace, to-uin-type=" + this.f247181d + ", pic-uuid=" + str);
                } else {
                    QLog.w("MixedMsgManager", 1, "WTF, picResult.mExtraObj is " + qVar.f258793d.getClass().getSimpleName());
                }
                z16 = true;
                if (!z16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MixedMsgManager", 2, "updateMessageForPic success");
                    }
                    im_msg_body_richtext.elems.add(im_msg_body_elem);
                    if (qVar.f258790a != 0) {
                        QLog.e("MixedMsgManager", 1, "[requestUploadPics] Bad picture element");
                    }
                    messageForPic.richText = im_msg_body_richtext;
                    return z17;
                }
                QLog.e("MixedMsgManager", 1, "updateMessageForPic failed, add empty element");
                z17 = false;
                messageForPic.richText = im_msg_body_richtext;
                return z17;
            }
            z16 = false;
            if (!z16) {
            }
            z17 = false;
            messageForPic.richText = im_msg_body_richtext;
            return z17;
        }

        private boolean h(ArrayList<q> arrayList) {
            MessageForMixedMsg messageForMixedMsg = this.f247182e;
            boolean z16 = true;
            if (messageForMixedMsg.msgElemList != null) {
                int i3 = 0;
                for (int i16 = 0; i16 < messageForMixedMsg.msgElemList.size(); i16++) {
                    MessageRecord messageRecord = messageForMixedMsg.msgElemList.get(i16);
                    if (messageRecord instanceof MessageForPic) {
                        MessageForPic messageForPic = (MessageForPic) messageRecord;
                        if (QLog.isColorLevel()) {
                            QLog.d("MixedMsgManager", 2, "updateMessageForPic for MessageForMixedMsg, subMsgIndex[" + i16);
                        }
                        if (!a(messageForPic, arrayList.get(i3))) {
                            z16 = false;
                        }
                        i3++;
                    }
                }
            }
            return z16;
        }

        @Override // com.tencent.mobileqq.pic.ac
        public void e(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
        }

        @Override // com.tencent.mobileqq.pic.ac
        public void i(int i3, ArrayList<q> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) arrayList);
                return;
            }
            if (i3 == 0 && arrayList != null && arrayList.size() > 0) {
                QLog.i("MixedMsgManager", 1, "onForwardMultiMsgPicsUpload success[" + arrayList.size() + "]");
                boolean h16 = h(arrayList);
                if (!h16) {
                    QLog.e("MixedMsgManager", 2, "onForwardMultiMsgPicsUpload : isAllPicUploadSuccessful = false ");
                    MixedMsgManager.this.o(this.f247182e, false, "picUpload fail");
                    return;
                }
                MixedMsg$Msg mixedMsg$Msg = new MixedMsg$Msg();
                for (MessageRecord messageRecord : this.f247182e.msgElemList) {
                    MixedMsg$Elem mixedMsg$Elem = new MixedMsg$Elem();
                    if (messageRecord instanceof MessageForText) {
                        if (!TextUtils.isEmpty(messageRecord.f203106msg)) {
                            mixedMsg$Elem.textMsg.set(messageRecord.f203106msg);
                        }
                    } else if (messageRecord.msgtype == -2000) {
                        try {
                            mixedMsg$Elem.picMsg.set(new RichMsg$PicRec().mergeFrom(messageRecord.msgData));
                        } catch (InvalidProtocolBufferMicroException e16) {
                            QLog.e("MixedMsgManager", 1, "onForwardMultiMsgPicsUpload", e16);
                        }
                    } else if (messageRecord instanceof MessageForReplyText) {
                        try {
                            MessageForReplyText messageForReplyText = (MessageForReplyText) messageRecord;
                            MessageForReplyText.SourceMsgInfo sourceMsgInfo = messageForReplyText.mSourceMsgInfo;
                            if (sourceMsgInfo != null) {
                                sourceMsgInfo.packSourceMsg(MessageForReplyText.getAppInterface(), messageForReplyText.getSourceMessage());
                            }
                            mixedMsg$Elem.sourceMsgInfo.set(HexUtil.bytes2HexStr(MessagePkgUtils.getBytesFromObject(messageForReplyText.mSourceMsgInfo)));
                            if (!TextUtils.isEmpty(messageForReplyText.f203106msg)) {
                                mixedMsg$Elem.textMsg.set(messageForReplyText.f203106msg);
                            }
                        } catch (Exception e17) {
                            QLog.i("MixedMsgManager", 1, e17.getMessage());
                        }
                    }
                    mixedMsg$Msg.elems.get().add(mixedMsg$Elem);
                }
                this.f247182e.msgData = mixedMsg$Msg.toByteArray();
                if (QLog.isColorLevel()) {
                    QLog.d("MixedMsgManager", 2, "updateMsgRecords done, goto onPackAndSendMsg");
                }
                MixedMsgManager.this.t(this.f247183f, this.f247184h, this.f247181d, this.f247182e, h16);
                return;
            }
            QLog.i("MixedMsgManager", 1, "onForwardMultiMsgPicsUpload failed");
            MixedMsgManager.this.o(this.f247182e, false, "picUpload fail : result = " + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements ad {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        MessageForLongTextMsg f247186d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f247187e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ MessageForMixedMsg f247188f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ bo f247189h;

        b(QQAppInterface qQAppInterface, MessageForMixedMsg messageForMixedMsg, bo boVar) {
            this.f247187e = qQAppInterface;
            this.f247188f = messageForMixedMsg;
            this.f247189h = boVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MixedMsgManager.this, qQAppInterface, messageForMixedMsg, boVar);
            }
        }

        @Override // com.tencent.mobileqq.pic.ad
        public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (MessageRecord) iPatchRedirector.redirect((short) 4, (Object) this, (Object) im_msg_body_richtext);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void q(ad.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
                return;
            }
            try {
                if (aVar.f258597a == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MixedMsgManager", 2, "step3: sendLongTextMsg pack upload cost: " + (System.currentTimeMillis() - MixedMsgManager.this.f247172d) + ",mResid:" + aVar.f258602f);
                    }
                    StructMsgForGeneralShare Y = ChatActivityFacade.Y(this.f247187e.getApp().getApplicationContext(), this.f247188f, this.f247187e.getCurrentNickname());
                    Y.mResid = aVar.f258602f;
                    Y.mFileName = String.valueOf(this.f247188f.uniseq);
                    Y.multiMsgFlag = 1;
                    MessageForLongTextMsg messageForLongTextMsg = (MessageForLongTextMsg) com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_STRUCT_LONG_TEXT);
                    this.f247186d = messageForLongTextMsg;
                    messageForLongTextMsg.structingMsg = Y;
                    MessageForMixedMsg messageForMixedMsg = this.f247188f;
                    messageForLongTextMsg.frienduin = messageForMixedMsg.frienduin;
                    messageForLongTextMsg.istroop = messageForMixedMsg.istroop;
                    messageForLongTextMsg.selfuin = messageForMixedMsg.selfuin;
                    messageForLongTextMsg.senderuin = messageForMixedMsg.senderuin;
                    messageForLongTextMsg.isread = messageForMixedMsg.isread;
                    messageForLongTextMsg.time = messageForMixedMsg.time;
                    messageForLongTextMsg.msgseq = messageForMixedMsg.msgseq;
                    messageForLongTextMsg.msgUid = messageForMixedMsg.msgUid;
                    messageForLongTextMsg.shmsgseq = messageForMixedMsg.shmsgseq;
                    messageForLongTextMsg.issend = messageForMixedMsg.issend;
                    messageForLongTextMsg.uniseq = messageForMixedMsg.uniseq;
                    messageForLongTextMsg.mAnimFlag = true;
                    messageForLongTextMsg.mNewAnimFlag = true;
                    messageForLongTextMsg.longMsgCount = 1;
                    messageForLongTextMsg.longMsgIndex = 0;
                    messageForLongTextMsg.longMsgId = (short) messageForMixedMsg.shmsgseq;
                    messageForLongTextMsg.saveExtInfoToExtStr("long_text_msg_resid", aVar.f258602f);
                    com.tencent.biz.anonymous.a.h().a(this.f247186d);
                    ((IOrderMediaMsgService) this.f247187e.getRuntimeService(IOrderMediaMsgService.class)).sendOrderMsg(this.f247186d, this.f247189h);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("MixedMsgManager", 2, "upload multi msg pack failed, result.errStr=" + aVar.f258598b + ",result.errStr=" + aVar.f258599c);
                }
                MixedMsgManager.this.o(this.f247188f, true, "upload longMsg pack fail: errCode = " + aVar.f258598b);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("MixedMsgManager", 2, "upload multi msg pack failed, catch exception", e16);
                }
                MixedMsgManager.this.o(this.f247188f, true, "sendStructLongMsg fail: exception" + e16.getMessage());
            }
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void r(ad.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c extends bo {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f247191d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MessageForMixedMsg f247192e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f247193f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f247194h;

        c(QQAppInterface qQAppInterface, MessageForMixedMsg messageForMixedMsg, String str, int i3) {
            this.f247191d = qQAppInterface;
            this.f247192e = messageForMixedMsg;
            this.f247193f = str;
            this.f247194h = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MixedMsgManager.this, qQAppInterface, messageForMixedMsg, str, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.mobileqq.app.bo
        public void onNotifyResultAfterSendRich(boolean z16, long j3, StatictisInfo statictisInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), statictisInfo);
                return;
            }
            com.tencent.mobileqq.service.message.e msgCache = this.f247191d.getMsgCache();
            MessageForMixedMsg messageForMixedMsg = this.f247192e;
            msgCache.G1(messageForMixedMsg.frienduin, messageForMixedMsg.istroop, messageForMixedMsg.uniseq);
            MessageHandler msgHandler = this.f247191d.getMsgHandler();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f247192e.uniseq);
            Object obj = "";
            sb5.append("");
            msgHandler.notifyUI(6003, true, new Object[]{this.f247192e.frienduin, sb5.toString()});
            QQMessageFacade messageFacade = this.f247191d.getMessageFacade();
            String str = this.f247193f;
            int i3 = this.f247194h;
            MessageForMixedMsg messageForMixedMsg2 = this.f247192e;
            messageFacade.Y0(str, i3, messageForMixedMsg2.uniseq, messageForMixedMsg2.msgData);
            if (z16) {
                MixedMsgManager.this.p(this.f247192e, true);
                return;
            }
            MixedMsgManager mixedMsgManager = MixedMsgManager.this;
            MessageForMixedMsg messageForMixedMsg3 = this.f247192e;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("sendStructLongMsg fail : errCode = ");
            if (statictisInfo != null) {
                obj = Integer.valueOf(statictisInfo.errCode);
            }
            sb6.append(obj);
            mixedMsgManager.o(messageForMixedMsg3, true, sb6.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements ad {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        protected ArrayList<AtTroopMemberInfo> f247196d;

        /* renamed from: e, reason: collision with root package name */
        protected Map<String, List<Integer>> f247197e;

        /* renamed from: f, reason: collision with root package name */
        protected MessageForMixedMsg f247198f;

        /* renamed from: h, reason: collision with root package name */
        protected String f247199h;

        public d(MessageForMixedMsg messageForMixedMsg, Map<String, List<Integer>> map, String str, ArrayList<AtTroopMemberInfo> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MixedMsgManager.this, messageForMixedMsg, map, str, arrayList);
                return;
            }
            this.f247198f = messageForMixedMsg;
            this.f247199h = str;
            this.f247197e = map;
            this.f247196d = arrayList;
        }

        private void a(MessageForMixedMsg messageForMixedMsg) {
            if (messageForMixedMsg.msgElemList.get(0) instanceof MessageForText) {
                MessageForText messageForText = (MessageForText) messageForMixedMsg.msgElemList.get(0);
                ArrayList<AtTroopMemberInfo> arrayList = this.f247196d;
                if (arrayList != null && messageForText.atInfoList == null) {
                    messageForText.atInfoList = arrayList;
                }
            }
            if (messageForMixedMsg.istroop == 1) {
                Iterator<MessageRecord> it = messageForMixedMsg.msgElemList.iterator();
                while (it.hasNext()) {
                    com.tencent.biz.anonymous.a.h().a(it.next());
                }
            }
            MixedMsgManager mixedMsgManager = MixedMsgManager.this;
            mixedMsgManager.t(mixedMsgManager.f247174f, messageForMixedMsg.frienduin, messageForMixedMsg.istroop, messageForMixedMsg, true);
        }

        @Override // com.tencent.mobileqq.pic.ad
        public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (MessageRecord) iPatchRedirector.redirect((short) 3, (Object) this, (Object) im_msg_body_richtext);
            }
            List<Integer> list = this.f247197e.get(this.f247199h);
            if (list != null && !list.isEmpty()) {
                Iterator<Integer> it = list.iterator();
                while (it.hasNext()) {
                    MessageRecord subMessage = this.f247198f.getSubMessage(it.next().intValue());
                    if (subMessage instanceof MessageForPic) {
                        ((MessageForPic) subMessage).richText = im_msg_body_richtext;
                    }
                }
            }
            return null;
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void q(ad.a aVar) {
            byte[] bArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MixedMsgManager", 2, "reqUploadMultiPics UiCallBack success result = " + aVar + ", error = " + new ErrorMessage(aVar.f258598b, aVar.f258599c));
            }
            if (aVar.f258598b != 0) {
                MixedMsgManager.this.o(this.f247198f, false, "send Msg fail: " + aVar);
                return;
            }
            List<Integer> remove = this.f247197e.remove(this.f247199h);
            if (remove != null && !remove.isEmpty()) {
                Iterator<Integer> it = remove.iterator();
                while (it.hasNext()) {
                    MessageRecord subMessage = this.f247198f.getSubMessage(it.next().intValue());
                    if (subMessage instanceof MessageForPic) {
                        MessageForPic messageForPic = (MessageForPic) subMessage;
                        if (QLog.isColorLevel()) {
                            QLog.d("MixedMsgManager", 2, "onSend, pre MessageForPic:" + messageForPic.toLogString());
                        }
                        messageForPic.md5 = aVar.f258603g;
                        messageForPic.uuid = aVar.f258602f;
                        messageForPic.size = aVar.f258601e;
                        messageForPic.groupFileID = aVar.f258604h;
                        try {
                            PicMessageExtraData picMessageExtraData = messageForPic.picExtraData;
                            if (picMessageExtraData != null && (bArr = aVar.f258611o) != null) {
                                picMessageExtraData.mDownloadIndex = new String(bArr, "utf-8");
                            }
                        } catch (UnsupportedEncodingException e16) {
                            e16.printStackTrace();
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("MixedMsgManager", 2, "onSend, end MessageForPic:" + messageForPic.toLogString());
                        }
                        this.f247198f.prewrite();
                    }
                }
                if (this.f247197e.isEmpty()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MixedMsgManager", 2, "onSend, mMsgMap isEmpty, packAndSend..");
                    }
                    a(this.f247198f);
                }
            }
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void r(ad.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface e {
        void a();

        void b();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73086);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
            return;
        }
        f247171h = AppConstants.SDCARD_PATH + "fight/pic_expire.png";
    }

    public MixedMsgManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f247173e = new ConcurrentHashMap<>();
            this.f247174f = qQAppInterface;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void B(QQAppInterface qQAppInterface, String str, int i3, ArrayList<String> arrayList, boolean z16, String str2, ArrayList<AtTroopMemberInfo> arrayList2, MessageForReplyText.SourceMsgInfo sourceMsgInfo) {
        boolean z17;
        boolean z18;
        Iterator<String> it;
        MessageForMixedMsg h16;
        MessageForPic i16;
        if (qQAppInterface != null && arrayList != null && !arrayList.isEmpty()) {
            if (i3 == 10014) {
                Iterator<AtTroopMemberInfo> it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    it5.next().isResvAttr = true;
                }
            }
            List<MessageRecord> arrayList3 = new ArrayList<>();
            if (sourceMsgInfo != null) {
                MessageRecord z19 = com.tencent.mobileqq.service.message.q.z(qQAppInterface, str, i3, sourceMsgInfo, str2);
                z19.atInfoList = arrayList2;
                arrayList3.add(z19);
            } else if (!TextUtils.isEmpty(str2)) {
                z17 = true;
                MessageRecord B = com.tencent.mobileqq.service.message.q.B(qQAppInterface, qQAppInterface.getCurrentAccountUin(), str, str, i3, (byte) 1, (byte) 0, (short) 0, str2);
                B.atInfoList = arrayList2;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    ITroopRobotService iTroopRobotService = (ITroopRobotService) qQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
                    Iterator<AtTroopMemberInfo> it6 = B.atInfoList.iterator();
                    while (it6.hasNext()) {
                        if (iTroopRobotService.isRobotUin(it6.next().uin)) {
                            z18 = true;
                            break;
                        }
                    }
                }
                z18 = false;
                arrayList3.add(B);
                it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (com.tencent.mobileqq.filemanager.util.q.p(next) && (i16 = i(qQAppInterface, com.tencent.mobileqq.mixedmsg.d.a(next), null, str, i3)) != null) {
                        ThreadManagerV2.post(new Runnable(i16) { // from class: com.tencent.mobileqq.mixedmsg.MixedMsgManager.5
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ MessageForPic f247179d;

                            {
                                this.f247179d = i16;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MixedMsgManager.this, (Object) i16);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this);
                                } else {
                                    ((IPicHelper) QRoute.api(IPicHelper.class)).cachePicToDisk(this.f247179d);
                                }
                            }
                        }, 8, null, z17);
                        i16.subMsgId = arrayList3.size();
                        arrayList3.add(i16);
                    }
                }
                h16 = h(arrayList3, arrayList2, sourceMsgInfo, i3, z18);
                if (h16 == null) {
                    Map<String, Boolean> hashMap = new HashMap<>();
                    for (MessageRecord messageRecord : h16.msgElemList) {
                        if (messageRecord instanceof MessageForPic) {
                            MessageForPic messageForPic = (MessageForPic) messageRecord;
                            if (com.tencent.mobileqq.filemanager.util.q.p(messageForPic.path)) {
                                hashMap.put(messageForPic.path, Boolean.valueOf(z16));
                            }
                        }
                    }
                    y(h16, arrayList2, str, hashMap);
                    qQAppInterface.getMessageFacade().h1(str, i3);
                    return;
                }
                return;
            }
            z17 = true;
            z18 = false;
            it = arrayList.iterator();
            while (it.hasNext()) {
            }
            h16 = h(arrayList3, arrayList2, sourceMsgInfo, i3, z18);
            if (h16 == null) {
            }
        }
    }

    private boolean C(QQAppInterface qQAppInterface, byte[] bArr, String str, String str2, String str3, int i3, long j3, int i16, ad adVar) {
        if (QLog.isColorLevel()) {
            QLog.d("MixedMsgManager", 2, "[sendLongTextMsg]data.length = " + bArr.length);
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
        transferRequest.upMsgBusiType = n();
        ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
        return true;
    }

    public static MessageForPic i(QQAppInterface qQAppInterface, String str, String str2, String str3, int i3) {
        if (str != null) {
            MessageForPic q16 = com.tencent.mobileqq.service.message.q.q(qQAppInterface, str3, str2, i3);
            q16.path = str;
            q16.size = 0L;
            q16.uniseq = System.currentTimeMillis() + ((long) (Math.random() * 10000.0d));
            q16.type = 1;
            q16.isRead = true;
            q16.localUUID = p.i();
            File file = new File(str);
            if (file.exists()) {
                if (GifDrawable.isGifFile(file)) {
                    q16.imageType = 2000;
                } else {
                    q16.imageType = ((IPicUtil) QRoute.api(IPicUtil.class)).getImageType(str);
                }
            }
            q16.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(q16.path));
            if (BaseImageUtil.isGifFile(str)) {
                PicMessageExtraData picMessageExtraData = new PicMessageExtraData();
                picMessageExtraData.textSummary = qQAppInterface.getApp().getString(R.string.iml);
                q16.picExtraData = picMessageExtraData;
            }
            if (i3 == 10014 && q16.picExtraData != null) {
                q16.picExtraData = new PicMessageExtraData();
            }
            q16.serial();
            return q16;
        }
        return null;
    }

    private void j(boolean z16, boolean z17, MessageForMixedMsg messageForMixedMsg, String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_isresend", String.valueOf(messageForMixedMsg.mIsResend));
        if (!messageForMixedMsg.mIsResend) {
            hashMap.put("param_forwardFromUin", messageForMixedMsg.mForwardFromUin);
            hashMap.put("param_forwardFromUinType", String.valueOf(messageForMixedMsg.mForwardFromIsTroop));
        }
        hashMap.put("param_senderUin", messageForMixedMsg.senderuin);
        hashMap.put(ReportConstant.KEY_TO_UIN, messageForMixedMsg.frienduin);
        hashMap.put("param_toUinType", String.valueOf(messageForMixedMsg.istroop));
        hashMap.put("param_sendByLongStruct", String.valueOf(z17));
        hashMap.put("param_richTextLength", String.valueOf(messageForMixedMsg.mRichTextLength));
        if (str != null) {
            hashMap.put("param_errDesc", str);
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f247174f.getCurrentAccountUin(), StatisticCollector.MIX_MSG_FORWARD_REPORT_TAG, z16, 0L, 0L, hashMap, "");
    }

    @NotNull
    private bo m(String str, int i3, MessageForMixedMsg messageForMixedMsg, QQAppInterface qQAppInterface) {
        return new c(qQAppInterface, messageForMixedMsg, str, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(MessageForMixedMsg messageForMixedMsg, boolean z16, String str) {
        this.f247174f.getMessageFacade().Z0(messageForMixedMsg.frienduin, messageForMixedMsg.istroop, messageForMixedMsg.uniseq, 32768, messageForMixedMsg.sendFailCode);
        r(this.f247174f, messageForMixedMsg);
        this.f247173e.remove(Long.valueOf(messageForMixedMsg.mForwardFromUniSeq));
        ((IOrderMediaMsgService) this.f247174f.getRuntimeService(IOrderMediaMsgService.class)).removeMediaMsgByUniseq(messageForMixedMsg.frienduin, messageForMixedMsg.uniseq);
        ((IMsgStorageApi) QRoute.api(IMsgStorageApi.class)).onMsgUploadTaskEnd(messageForMixedMsg);
        j(false, z16, messageForMixedMsg, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(MessageForMixedMsg messageForMixedMsg, boolean z16) {
        int i3 = messageForMixedMsg.istroop;
        if (i3 != 3000 && i3 != 1) {
            this.f247174f.getMessageFacade().Z0(messageForMixedMsg.frienduin, messageForMixedMsg.istroop, messageForMixedMsg.uniseq, 32770, messageForMixedMsg.sendFailCode);
        }
        s(this.f247174f, messageForMixedMsg);
        this.f247173e.remove(messageForMixedMsg);
        this.f247173e.remove(Long.valueOf(messageForMixedMsg.mForwardFromUniSeq));
        j(true, z16, messageForMixedMsg, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(QQAppInterface qQAppInterface, String str, int i3, ArrayList arrayList, boolean z16, String str2, ArrayList arrayList2, MessageForReplyText.SourceMsgInfo sourceMsgInfo, e eVar) {
        B(qQAppInterface, str, i3, arrayList, z16, str2, arrayList2, sourceMsgInfo);
        if (eVar != null) {
            eVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(QQAppInterface qQAppInterface, String str, int i3, MessageForMixedMsg messageForMixedMsg, boolean z16) {
        im_msg_body$RichText z17;
        im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
        int size = messageForMixedMsg.msgElemList.size();
        for (int i16 = 0; i16 < size; i16++) {
            MessageRecord messageRecord = messageForMixedMsg.msgElemList.get(i16);
            if (messageRecord instanceof MessageForText) {
                im_msg_body$RichText A = com.tencent.mobileqq.service.message.p.A((MessageForText) messageRecord);
                if (A != null) {
                    for (int i17 = 0; i17 < A.elems.size(); i17++) {
                        im_msg_body_richtext.elems.add(A.elems.get(i17));
                    }
                }
            } else if (messageRecord instanceof MessageForRichText) {
                im_msg_body$RichText im_msg_body_richtext2 = ((MessageForPic) messageRecord).richText;
                if (im_msg_body_richtext2 != null) {
                    im_msg_body_richtext.elems.add(im_msg_body_richtext2.elems.get(0));
                }
            } else if ((messageRecord instanceof MessageForReplyText) && (z17 = com.tencent.mobileqq.service.message.p.z((MessageForReplyText) messageRecord)) != null) {
                for (int i18 = 0; i18 < z17.elems.size(); i18++) {
                    im_msg_body_richtext.elems.add(z17.elems.get(i18));
                }
            }
        }
        int length = im_msg_body_richtext.toByteArray().length;
        QLog.i("MixedMsgManager", 1, "packAndSendMsg, richTextLength : " + length);
        messageForMixedMsg.mRichTextLength = length;
        if (i3 == 10014) {
            ((IOrderMediaMsgService) qQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).sendOrderMsg(messageForMixedMsg, m(messageForMixedMsg.frienduin, 10014, messageForMixedMsg, qQAppInterface));
        } else {
            z(str, i3, messageForMixedMsg, qQAppInterface, false);
            QLog.i("MixedMsgManager", 1, "packAndSendMsg,, send by longStruct message");
        }
        ((IMsgStorageApi) QRoute.api(IMsgStorageApi.class)).onMsgUploadTaskEnd(messageForMixedMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(QQAppInterface qQAppInterface, String str, int i3, ArrayList<l> arrayList, MessageForMixedMsg messageForMixedMsg) {
        p createPicReq = ((IPicBus) QRoute.api(IPicBus.class)).createPicReq(8, 7);
        createPicReq.c(arrayList);
        createPicReq.g(new a(i3, messageForMixedMsg, qQAppInterface, str));
        ((IPicBus) QRoute.api(IPicBus.class)).launch(createPicReq);
    }

    public void A(final QQAppInterface qQAppInterface, final String str, final int i3, final ArrayList<String> arrayList, final boolean z16, final String str2, final ArrayList<AtTroopMemberInfo> arrayList2, final MessageForReplyText.SourceMsgInfo sourceMsgInfo, final e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, qQAppInterface, str, Integer.valueOf(i3), arrayList, Boolean.valueOf(z16), str2, arrayList2, sourceMsgInfo, eVar);
            return;
        }
        if (eVar != null) {
            eVar.a();
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.mixedmsg.a
            @Override // java.lang.Runnable
            public final void run() {
                MixedMsgManager.this.q(qQAppInterface, str, i3, arrayList, z16, str2, arrayList2, sourceMsgInfo, eVar);
            }
        };
        if (UiThreadUtil.isOnUiThread()) {
            ThreadManagerV2.excute(runnable, 16, null, true);
        } else {
            runnable.run();
        }
    }

    protected MessageForMixedMsg h(List<MessageRecord> list, ArrayList<AtTroopMemberInfo> arrayList, MessageForReplyText.SourceMsgInfo sourceMsgInfo, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (MessageForMixedMsg) iPatchRedirector.redirect((short) 13, this, list, arrayList, sourceMsgInfo, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        if (list.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d("MixedMsgManager", 2, "constructMixedMr, input elemList is null, return...");
                return null;
            }
            return null;
        }
        MessageForMixedMsg messageForMixedMsg = (MessageForMixedMsg) com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_MIX);
        MessageRecord messageRecord = list.get(0);
        messageRecord.longMsgId = 0;
        MessageRecord.copyMessageRecordBaseField(messageForMixedMsg, messageRecord);
        if (messageForMixedMsg.istroop == 1) {
            com.tencent.biz.anonymous.a.h().b(messageForMixedMsg);
        }
        if (sourceMsgInfo != null && arrayList != null && arrayList.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i17 = 0; i17 < arrayList.size(); i17++) {
                    jSONArray.put(i17, arrayList.get(i17).toJsonObject());
                }
                jSONObject.put("0", jSONArray);
            } catch (JSONException e16) {
                QLog.e("MixedMsgManager", 1, e16, new Object[0]);
            }
            com.tencent.mobileqq.troop.text.a.m(i3, jSONObject.toString(), messageForMixedMsg);
        }
        messageForMixedMsg.uniseq = System.currentTimeMillis() + ((long) (Math.random() * 10000.0d));
        messageForMixedMsg.issend = 1;
        messageForMixedMsg.msgtype = MessageRecord.MSG_TYPE_MIX;
        messageForMixedMsg.extraflag = 32772;
        messageForMixedMsg.msgElemList = list;
        if (!z16) {
            i16 = -1;
        }
        messageForMixedMsg.mRobotFlag = i16;
        messageForMixedMsg.atInfoList = arrayList;
        messageForMixedMsg.prewrite();
        return messageForMixedMsg;
    }

    public void k(SessionInfo sessionInfo, long j3, int i3) {
        MessageForMixedMsg messageForMixedMsg;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, sessionInfo, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        ChatMessage chatMessage = this.f247173e.get(Long.valueOf(j3));
        if (chatMessage != null) {
            if (chatMessage.msgtype == -1036) {
                messageForMixedMsg = (MessageForMixedMsg) ((MessageForLongMsg) chatMessage).rebuildLongMsg();
            } else {
                messageForMixedMsg = (MessageForMixedMsg) chatMessage;
            }
            messageForMixedMsg.mForwardFromUniSeq = j3;
            messageForMixedMsg.forwardID = i3;
            com.tencent.mobileqq.replymsg.d.c().a(this.f247174f, messageForMixedMsg, sessionInfo, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("MixedMsgManager", 2, "forwardMixedMsg, not find in cache !");
        }
    }

    public void l(SessionInfo sessionInfo, MessageForMixedMsg messageForMixedMsg, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, sessionInfo, messageForMixedMsg, Boolean.valueOf(z16), Integer.valueOf(i3));
        } else {
            this.f247174f.execute(new Runnable(sessionInfo, i3, messageForMixedMsg, z16) { // from class: com.tencent.mobileqq.mixedmsg.MixedMsgManager.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ SessionInfo f247175d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f247176e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ MessageForMixedMsg f247177f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ boolean f247178h;

                {
                    this.f247175d = sessionInfo;
                    this.f247176e = i3;
                    this.f247177f = messageForMixedMsg;
                    this.f247178h = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, MixedMsgManager.this, sessionInfo, Integer.valueOf(i3), messageForMixedMsg, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    String account = MixedMsgManager.this.f247174f.getAccount();
                    SessionInfo sessionInfo2 = this.f247175d;
                    int i16 = sessionInfo2.f179555d;
                    String str = sessionInfo2.f179557e;
                    MessageForMixedMsg p16 = com.tencent.mobileqq.service.message.q.p(MixedMsgManager.this.f247174f, str, sessionInfo2.f179559f, i16);
                    int i17 = this.f247176e;
                    if (i17 == 0) {
                        i17 = this.f247177f.forwardID;
                    }
                    com.tencent.mobileqq.activity.aio.forward.b.d().e(p16.uniseq, this.f247177f.uniseq, i17);
                    p16.extraflag = 32772;
                    MessageForMixedMsg messageForMixedMsg2 = this.f247177f;
                    p16.msgData = messageForMixedMsg2.msgData;
                    List<MessageRecord> list = messageForMixedMsg2.msgElemList;
                    p16.msgElemList = list;
                    if (!this.f247178h) {
                        p16.mForwardFromIsTroop = messageForMixedMsg2.istroop;
                        p16.mForwardFromUin = messageForMixedMsg2.frienduin;
                    } else {
                        p16.mIsResend = true;
                    }
                    for (MessageRecord messageRecord : list) {
                        if (messageRecord instanceof MessageForPic) {
                            messageRecord.istroop = i16;
                        }
                    }
                    p16.prewrite();
                    QLog.i("MixedMsgManager", 1, "forwardMixedMsg, uniseq=" + this.f247177f.uniseq + ", touin=" + this.f247177f.frienduin + ", istroop=" + this.f247177f.istroop);
                    ((IOrderMediaMsgService) MixedMsgManager.this.f247174f.getRuntimeService(IOrderMediaMsgService.class)).updateMediaMsgByUniseq(str, this.f247177f.uniseq, p16.uniseq);
                    ((IOrderMediaMsgService) MixedMsgManager.this.f247174f.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsg(p16, null);
                    MixedMsgManager.this.f247174f.getMsgHandler().notifyUI(1000, true, str);
                    ArrayList arrayList = new ArrayList();
                    ArrayList<l> createForwardPicInfos = ((IPicBus) QRoute.api(IPicBus.class)).createForwardPicInfos(7, p16, i16, account, str, MixedMsgManager.this.f247174f.getAccount());
                    if (createForwardPicInfos != null) {
                        arrayList.addAll(createForwardPicInfos);
                    } else {
                        QLog.w("MixedMsgManager", 1, "[forwardMixedMsg]createForwardPicInfos from MessageForMixedMsg failed");
                    }
                    if (arrayList.size() > 0) {
                        QLog.i("MixedMsgManager", 1, "[forwardMixedMsg]Upload pictures, count is [" + arrayList.size() + "], goto requestUploadPics");
                        MixedMsgManager mixedMsgManager = MixedMsgManager.this;
                        mixedMsgManager.x(mixedMsgManager.f247174f, str, i16, arrayList, p16);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("MixedMsgManager", 2, "[forwardMixedMsg]There's not any picture messages, goto onPackAndSendMsg");
                    }
                    MixedMsgManager mixedMsgManager2 = MixedMsgManager.this;
                    mixedMsgManager2.t(mixedMsgManager2.f247174f, str, i16, p16, true);
                }
            });
        }
    }

    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    protected void r(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) qQAppInterface, (Object) messageRecord);
            return;
        }
        messageRecord.extraflag = 32768;
        qQAppInterface.getMsgCache().G1(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq);
        qQAppInterface.getMsgHandler().notifyUI(1000, false, new Object[]{messageRecord.frienduin, Integer.valueOf(messageRecord.istroop), -1, null, 0L, Long.valueOf(messageRecord.uniseq)});
    }

    protected void s(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) qQAppInterface, (Object) messageRecord);
            return;
        }
        int i3 = messageRecord.istroop;
        if (i3 != 3000 && i3 != 1) {
            messageRecord.extraflag = 32770;
        }
        qQAppInterface.getMsgHandler().notifyUI(1000, true, new Object[]{messageRecord.frienduin, Integer.valueOf(i3), -1, null, 0L, Long.valueOf(messageRecord.uniseq)});
    }

    public void u(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_uin", this.f247174f.getCurrentAccountUin());
        hashMap.put("param_isTroop", String.valueOf(i3));
        if (z16) {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f247174f.getCurrentAccountUin(), StatisticCollector.MIX_MSG_CLIENT_AUTO_PULL_REPORT_TAG, true, 0L, 0L, hashMap, "");
        } else {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f247174f.getCurrentAccountUin(), StatisticCollector.MIX_MSG_CLIENT_MANU_PULL_REPORT_TAG, true, 0L, 0L, hashMap, "");
        }
    }

    public void v(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) messageRecord);
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_istroop", String.valueOf(messageRecord.istroop));
        hashMap.put("param_issend", String.valueOf(messageRecord.issend));
        hashMap.put("param_msgtype", String.valueOf(messageRecord.msgtype));
        hashMap.put("param_isAnonymous", String.valueOf(com.tencent.biz.anonymous.a.m(messageRecord)));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f247174f.getCurrentAccountUin(), StatisticCollector.MIX_MSG_RECEIVED_REPORT_TAG, true, 0L, 0L, hashMap, "");
    }

    protected void w(QQAppInterface qQAppInterface, MessageForPic messageForPic, boolean z16, ad adVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, qQAppInterface, messageForPic, Boolean.valueOf(z16), adVar);
            return;
        }
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mSelfUin = messageForPic.selfuin;
        transferRequest.mPeerUin = messageForPic.frienduin;
        transferRequest.mUinType = messageForPic.istroop;
        transferRequest.mFileType = 1;
        transferRequest.mUniseq = messageForPic.uniseq + messageForPic.subMsgId;
        ITransFileController iTransFileController = (ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class);
        while (iTransFileController.containsProcessor(transferRequest.mPeerUin, transferRequest.mUniseq)) {
            transferRequest.mUniseq += 100;
        }
        transferRequest.mIsUp = true;
        transferRequest.needSendMsg = false;
        TransferRequest.PicUpExtraInfo picUpExtraInfo = new TransferRequest.PicUpExtraInfo();
        picUpExtraInfo.mIsRaw = z16;
        transferRequest.mExtraObj = picUpExtraInfo;
        transferRequest.mLocalPath = messageForPic.path;
        transferRequest.mUpCallBack = adVar;
        transferRequest.mRec = messageForPic;
        ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
    }

    public void y(MessageForMixedMsg messageForMixedMsg, ArrayList<AtTroopMemberInfo> arrayList, String str, Map<String, Boolean> map) {
        boolean z16;
        Boolean bool;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, messageForMixedMsg, arrayList, str, map);
            return;
        }
        ((IOrderMediaMsgService) this.f247174f.getRuntimeService(IOrderMediaMsgService.class)).enqueueMediaMsgByUniseq(str, messageForMixedMsg.uniseq);
        ((IOrderMediaMsgService) this.f247174f.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsg(messageForMixedMsg, null);
        Map synchronizedMap = Collections.synchronizedMap(new HashMap());
        HashMap hashMap = new HashMap();
        for (MessageRecord messageRecord : messageForMixedMsg.msgElemList) {
            if (messageRecord instanceof MessageForPic) {
                MessageForPic messageForPic = (MessageForPic) messageRecord;
                if (com.tencent.mobileqq.filemanager.util.q.p(messageForPic.path)) {
                    List list = (List) synchronizedMap.get(messageForPic.path);
                    if (list == null) {
                        hashMap.put(messageForPic, new d(messageForMixedMsg, synchronizedMap, messageForPic.path, arrayList));
                        list = new ArrayList();
                    }
                    list.add(Integer.valueOf(messageForPic.subMsgId));
                    synchronizedMap.put(messageForPic.path, list);
                }
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            d dVar = (d) entry.getValue();
            if (map != null && (bool = map.get(dVar.f247199h)) != null) {
                z16 = bool.booleanValue();
            } else {
                z16 = false;
            }
            w(this.f247174f, (MessageForPic) entry.getKey(), z16, dVar);
            if (QLog.isColorLevel()) {
                QLog.d("MixedMsgManager", 2, "send pic req:" + dVar.f247199h + ", raw:" + z16);
            }
        }
    }

    public void z(String str, int i3, MessageForMixedMsg messageForMixedMsg, QQAppInterface qQAppInterface, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), messageForMixedMsg, qQAppInterface, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MixedMsgManager", 2, " sendStructLongMsg start");
        }
        if (messageForMixedMsg instanceof ChatMessage) {
            messageForMixedMsg.mPendantAnimatable = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MixedMsgManager", 2, "step2: sendStructLongMsg saveMessage end and pack StructLongMsg start currenttime:" + System.currentTimeMillis());
        }
        byte[] s16 = qQAppInterface.getProxyManager().k().s(messageForMixedMsg);
        if (s16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("MixedMsgManager", 2, "step2: sendStructLongMsg pack failed! packData is null.............................");
            }
            o(messageForMixedMsg, true, "sendStructLongMsg pack fail : packData is null");
            return;
        }
        this.f247172d = System.currentTimeMillis();
        bo m3 = m(str, i3, messageForMixedMsg, qQAppInterface);
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        String str2 = messageForMixedMsg.frienduin;
        boolean C = C(qQAppInterface, s16, currentAccountUin, str2, str2, messageForMixedMsg.istroop, messageForMixedMsg.uniseq, 1035, new b(qQAppInterface, messageForMixedMsg, m3));
        if (C) {
            if (QLog.isColorLevel()) {
                QLog.d("MixedMsgManager", 2, "sendLongTextMsg successful, uploadLongTextMsgPkg start!");
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("MixedMsgManager", 2, "sendLongTextMsg failed! isSuccess:" + C);
        }
    }
}
