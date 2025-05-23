package com.tencent.mobileqq.multimsg;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.w;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ArkMsgUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.IMultiMsgRecordOp;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForWriteTogether;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.dpc.IDPCApiConstant;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.pic.ac;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pic.c;
import com.tencent.mobileqq.pic.m;
import com.tencent.mobileqq.pic.p;
import com.tencent.mobileqq.pic.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.receipt.ReceiptMsgManager;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ab;
import com.tencent.mobileqq.shortvideo.v;
import com.tencent.mobileqq.shortvideo.y;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.fav.NtMultiFavUtils;
import com.tencent.util.LongSparseArray;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.manager.ServerConfigManager;
import tencent.im.msg.im_msg_body$CustomFace;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$NotOnlineImage;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MultiMsgManager implements Comparator<ChatMessage> {
    static IPatchRedirector $redirector_;
    public static final String N;
    private static byte[] P;
    private static MultiMsgManager Q;
    private static long R;
    private int C;
    private int D;
    private int E;
    private int F;
    private SessionInfo G;
    private int H;
    private HashMap<Long, List<MultiMsgNick>> I;
    public HashMap<ChatMessage, Boolean> J;
    public ArrayList<ChatMessage> K;
    public HashMap<String, String> L;
    public int M;

    /* renamed from: d, reason: collision with root package name */
    private int f251536d;

    /* renamed from: e, reason: collision with root package name */
    private LongSparseArray<Integer> f251537e;

    /* renamed from: f, reason: collision with root package name */
    private int f251538f;

    /* renamed from: h, reason: collision with root package name */
    private int f251539h;

    /* renamed from: i, reason: collision with root package name */
    private int f251540i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f251541m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.multimsg.MultiMsgManager$5, reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass5 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f251552d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f251553e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f251554f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f251555h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f251556i;
        final /* synthetic */ MultiMsgManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            List<ChatMessage> A;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            MessageRecord P = this.f251552d.getMessageFacade().P(this.f251553e, this.f251554f, this.f251555h);
            if (P != null && (P instanceof MessageForStructing) && "viewMultiMsg".equals(((MessageForStructing) P).structingMsg.mMsgAction) && (A = MultiMsgManager.w().A(this.f251552d, this.f251555h)) != null) {
                int size = A.size();
                int E = MultiMsgManager.w().E(A);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("result", (!this.f251556i ? 1 : 0) + "");
                hashMap.put("msgCount", size + "");
                hashMap.put("picCount", E + "");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f251552d.getCurrentAccountUin(), StatisticCollector.MULTI_MSG_SEND, this.f251556i, 30000L, 0L, hashMap, "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a extends ac.b {
        static IPatchRedirector $redirector_;
        final /* synthetic */ HashMap C;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f251557d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f251558e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ MessageRecord f251559f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ArrayList f251560h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f251561i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f251562m;

        a(int i3, int i16, MessageRecord messageRecord, ArrayList arrayList, QQAppInterface qQAppInterface, String str, HashMap hashMap) {
            this.f251557d = i3;
            this.f251558e = i16;
            this.f251559f = messageRecord;
            this.f251560h = arrayList;
            this.f251561i = qQAppInterface;
            this.f251562m = str;
            this.C = hashMap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MultiMsgManager.this, Integer.valueOf(i3), Integer.valueOf(i16), messageRecord, arrayList, qQAppInterface, str, hashMap);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x019a  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x01b8  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean a(MessageForPic messageForPic, q qVar) {
            boolean z16;
            im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
            im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
            Object obj = qVar.f258793d;
            boolean z17 = true;
            if (obj != null) {
                String str = "";
                if (obj instanceof im_msg_body$NotOnlineImage) {
                    im_msg_body_elem.not_online_image.set((im_msg_body$NotOnlineImage) obj);
                    PicMessageExtraData picMessageExtraData = messageForPic.picExtraData;
                    if (picMessageExtraData != null) {
                        im_msg_body_elem.not_online_image.bytes_pb_reserve.set(ByteStringMicro.copyFrom(picMessageExtraData.getOfflineImageResvAttr().get().toByteArray()), true);
                    }
                    if (qVar.f258795f || this.f251557d == 5) {
                        if (im_msg_body_elem.not_online_image.res_id.has()) {
                            str = im_msg_body_elem.not_online_image.res_id.get().toStringUtf8();
                        } else if (im_msg_body_elem.not_online_image.download_path.has()) {
                            str = im_msg_body_elem.not_online_image.download_path.get().toStringUtf8();
                        }
                        messageForPic.uuid = str;
                        if (this.f251557d != 5) {
                            messageForPic.path = str;
                            messageForPic.md5 = FileUtils.calcMd5(MultiMsgManager.N);
                        }
                        messageForPic.thumbMsgUrl = im_msg_body_elem.not_online_image.str_thumb_url.get();
                        messageForPic.thumbHeight = im_msg_body_elem.not_online_image.uint32_thumb_height.get();
                        messageForPic.thumbWidth = im_msg_body_elem.not_online_image.uint32_thumb_width.get();
                        messageForPic.msgData = messageForPic.getSerialPB().toByteArray();
                    }
                    QLog.i("MultiMsg_TAG", 1, "add not_online_image, to-uin-type=" + this.f251558e + ", uuid=" + str + ", md5=" + messageForPic.md5);
                } else if (obj instanceof im_msg_body$CustomFace) {
                    im_msg_body_elem.custom_face.set((im_msg_body$CustomFace) obj);
                    PicMessageExtraData picMessageExtraData2 = messageForPic.picExtraData;
                    if (picMessageExtraData2 != null) {
                        im_msg_body_elem.custom_face.bytes_pb_reserve.set(ByteStringMicro.copyFrom(picMessageExtraData2.getCustomFaceResvAttr().get().toByteArray()), true);
                    }
                    if (qVar.f258795f || this.f251557d == 5) {
                        if (im_msg_body_elem.custom_face.str_file_path.has()) {
                            str = im_msg_body_elem.custom_face.str_file_path.get();
                        }
                        messageForPic.uuid = str;
                        if (this.f251557d != 5) {
                            messageForPic.path = str;
                            messageForPic.md5 = FileUtils.calcMd5(MultiMsgManager.N);
                        }
                        messageForPic.msgData = messageForPic.getSerialPB().toByteArray();
                    }
                    if (im_msg_body_elem.custom_face.uint32_file_id.get() == 0 && this.f251557d == 5 && this.f251559f.istroop != 0) {
                        QLog.i("MultiMsg_TAG", 1, "updateMessageForPic but custom_face's file id is 0");
                    } else {
                        QLog.i("MultiMsg_TAG", 1, "add custom_face, to-uin-type=" + this.f251558e + ", uuid=" + str + ", md5=" + messageForPic.md5);
                    }
                } else {
                    QLog.w("MultiMsg_TAG", 1, "WTF, picResult.mExtraObj is " + qVar.f258793d.getClass().getSimpleName());
                }
                z16 = true;
                if (!z16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", 2, "updateMessageForPic success");
                    }
                    im_msg_body_richtext.elems.add(im_msg_body_elem);
                    if (qVar.f258790a != 0) {
                        QLog.i("MultiMsg_TAG", 1, "[requestUploadPics] Bad picture element");
                    }
                    messageForPic.richText = im_msg_body_richtext;
                    return z17;
                }
                QLog.w("MultiMsg_TAG", 1, "updateMessageForPic failed, add empty element");
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
            boolean z16;
            MessageForStructing messageForStructing;
            AbsStructMsg absStructMsg;
            com.tencent.mobileqq.structmsg.view.e firstImageElement;
            MessageForPic messageForPic;
            int i3;
            String str;
            boolean z17;
            int i16 = 0;
            boolean z18 = false;
            int i17 = 0;
            boolean z19 = true;
            while (i16 < this.f251560h.size()) {
                MessageRecord messageRecord = (MessageRecord) this.f251560h.get(i16);
                if (i17 < arrayList.size() && (arrayList.get(i17).f258795f || this.f251557d == 5)) {
                    z18 = true;
                }
                if (messageRecord instanceof MessageForPic) {
                    if (i17 >= arrayList.size() && QLog.isColorLevel()) {
                        QLog.e("MultiMsg_TAG", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
                    }
                    MessageForPic messageForPic2 = (MessageForPic) messageRecord;
                    if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", 2, "updateMessageForPic for MessageForPic, MsgIndex[" + i16 + "], resultIndex[" + i17 + "]");
                    }
                    if (!a(messageForPic2, arrayList.get(i17))) {
                        z19 = false;
                    }
                    i17++;
                } else {
                    String str2 = ", resultIndex[";
                    if (messageRecord instanceof MessageForMixedMsg) {
                        MessageForMixedMsg messageForMixedMsg = (MessageForMixedMsg) messageRecord;
                        if (messageForMixedMsg.msgElemList != null) {
                            int i18 = 0;
                            while (i18 < messageForMixedMsg.msgElemList.size()) {
                                MessageRecord messageRecord2 = messageForMixedMsg.msgElemList.get(i18);
                                if (messageRecord2 instanceof MessageForPic) {
                                    if (i17 >= arrayList.size() && QLog.isColorLevel()) {
                                        QLog.e("MultiMsg_TAG", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
                                    }
                                    MessageForPic messageForPic3 = (MessageForPic) messageRecord2;
                                    if (QLog.isColorLevel()) {
                                        z17 = z18;
                                        QLog.d("MultiMsg_TAG", 2, "updateMessageForPic for MessageForMixedMsg, MsgIndex[" + i16 + "], subMsgIndex[" + i18 + ", resultIndex[" + i17 + "]");
                                    } else {
                                        z17 = z18;
                                    }
                                    if (!a(messageForPic3, arrayList.get(i17))) {
                                        z19 = false;
                                    }
                                    i17++;
                                } else {
                                    z17 = z18;
                                }
                                i18++;
                                z18 = z17;
                            }
                        }
                    } else {
                        z16 = z18;
                        if (messageRecord.msgtype == -1036) {
                            for (MessageRecord messageRecord3 : ((MessageForLongMsg) messageRecord).longMsgFragmentList) {
                                if (messageRecord3 instanceof MessageForMixedMsg) {
                                    MessageForMixedMsg messageForMixedMsg2 = (MessageForMixedMsg) messageRecord3;
                                    if (messageForMixedMsg2.msgElemList != null) {
                                        int i19 = 0;
                                        while (i19 < messageForMixedMsg2.msgElemList.size()) {
                                            MessageRecord messageRecord4 = messageForMixedMsg2.msgElemList.get(i19);
                                            if (messageRecord4 instanceof MessageForPic) {
                                                if (i17 >= arrayList.size() && QLog.isColorLevel()) {
                                                    QLog.e("MultiMsg_TAG", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
                                                }
                                                MessageForPic messageForPic4 = (MessageForPic) messageRecord4;
                                                if (QLog.isColorLevel()) {
                                                    str = str2;
                                                    QLog.d("MultiMsg_TAG", 2, "updateMessageForPic for MessageForMixedMsg, MsgIndex[" + i16 + "], subMsgIndex[" + i19 + str2 + i17 + "]");
                                                } else {
                                                    str = str2;
                                                }
                                                if (!a(messageForPic4, arrayList.get(i17))) {
                                                    z19 = false;
                                                }
                                                i17++;
                                            } else {
                                                str = str2;
                                            }
                                            i19++;
                                            str2 = str;
                                        }
                                    }
                                }
                                str2 = str2;
                            }
                        } else if ((messageRecord instanceof MessageForStructing) && (absStructMsg = (messageForStructing = (MessageForStructing) messageRecord).structingMsg) != null && (absStructMsg instanceof StructMsgForImageShare) && (firstImageElement = ((StructMsgForImageShare) absStructMsg).getFirstImageElement()) != null && (messageForPic = firstImageElement.f290638c1) != null) {
                            if (QLog.isColorLevel()) {
                                i3 = 2;
                                QLog.d("MultiMsg_TAG", 2, "updateMessageForPic for MessageForPic, MsgIndex[" + i16 + "], resultIndex[" + i17 + "]");
                            } else {
                                i3 = 2;
                            }
                            if (messageForStructing.isHotPicsStruct()) {
                                PicMessageExtraData picMessageExtraData = new PicMessageExtraData();
                                picMessageExtraData.imageBizType = i3;
                                messageForPic.picExtraData = picMessageExtraData;
                            }
                            if (!a(messageForPic, arrayList.get(i17))) {
                                z19 = false;
                            } else {
                                firstImageElement.S0 = messageForPic.uuid;
                                firstImageElement.T0 = messageForPic.md5;
                                firstImageElement.R0 = messageForPic.path;
                                messageRecord.msgData = absStructMsg.getBytes();
                            }
                            i17++;
                        }
                        i16++;
                        z18 = z16;
                    }
                }
                z16 = z18;
                i16++;
                z18 = z16;
            }
            if (z18) {
                if (this.f251559f.isReMultiMsg) {
                    ReportController.n(this.f251561i, "CliOper", "", "", "0X800662B", "0X800662B", 0, 1, 0, "", "", "", "");
                }
                if (QLog.isColorLevel()) {
                    QLog.e("MultiMsg_TAG", 2, "requestUploadPics isPicMsgModify");
                }
                this.f251561i.getProxyManager().k().O(this.f251560h, null);
            }
            if (this.f251559f.isReMultiMsg) {
                ReportController.n(this.f251561i, "CliOper", "", "", "0X800662A", "0X800662A", 0, 1, 0, "", "", "", "");
            }
            return z19;
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
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) arrayList);
                return;
            }
            if (i3 == 0 && arrayList != null && arrayList.size() > 0) {
                QLog.i("MultiMsg_TAG", 1, "onForwardMultiMsgPicsUpload success[" + arrayList.size() + "]");
                z16 = h(arrayList);
                if (QLog.isColorLevel()) {
                    QLog.d("MultiMsg_TAG", 2, "updateMsgRecords done, goto onPackAndSendMsg");
                }
            } else {
                QLog.w("MultiMsg_TAG", 1, "onForwardMultiMsgPicsUpload failed");
                z16 = false;
            }
            boolean z17 = z16;
            if (this.f251557d == 5) {
                MultiMsgManager.this.a0(this.f251559f.uniseq, 1);
            } else {
                MultiMsgManager.this.Z(1);
            }
            if (this.f251557d != 5 && MultiMsgManager.this.f251536d == 0) {
                MultiMsgManager.this.L(this.f251561i, this.f251562m, this.f251558e, this.C, this.f251559f, null, this.f251560h, z17, this.f251557d);
                return;
            }
            if (this.f251557d == 5 && MultiMsgManager.this.J(this.f251559f.uniseq)) {
                if (z17) {
                    MultiMsgManager.this.L(this.f251561i, this.f251562m, this.f251558e, this.C, this.f251559f, null, this.f251560h, true, this.f251557d);
                } else {
                    MultiMsgManager.this.K(this.f251559f, this.f251561i, this.f251562m, this.f251558e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b extends ab.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f251563a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MessageRecord f251564b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f251565c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f251566d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f251567e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ HashMap f251568f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f251569g;

        b(ArrayList arrayList, MessageRecord messageRecord, QQAppInterface qQAppInterface, String str, int i3, HashMap hashMap, int i16) {
            this.f251563a = arrayList;
            this.f251564b = messageRecord;
            this.f251565c = qQAppInterface;
            this.f251566d = str;
            this.f251567e = i3;
            this.f251568f = hashMap;
            this.f251569g = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MultiMsgManager.this, arrayList, messageRecord, qQAppInterface, str, Integer.valueOf(i3), hashMap, Integer.valueOf(i16));
            }
        }

        @Override // com.tencent.mobileqq.shortvideo.ab
        public void b(int i3, ArrayList<y> arrayList) {
            m.a aVar;
            Object obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) arrayList);
                return;
            }
            int i16 = 0;
            if (i3 == 0 && arrayList != null && arrayList.size() > 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("MultiMsg_TAG", 2, "onMultiForwardVideoUploadResult success[" + arrayList.size() + "]");
                }
                int i17 = 0;
                int i18 = 0;
                while (i16 < this.f251563a.size()) {
                    MessageRecord messageRecord = (MessageRecord) this.f251563a.get(i16);
                    if (messageRecord instanceof MessageForShortVideo) {
                        if (i18 >= arrayList.size()) {
                            QLog.e("MultiMsg_TAG", 1, "MultiForwardVideo: error index!");
                        } else {
                            y yVar = arrayList.get(i18);
                            if (yVar != null) {
                                int i19 = yVar.f288328a;
                                if (i19 == 0 && (obj = yVar.f288331d) != null && (obj instanceof im_msg_body$RichText)) {
                                    ((MessageForShortVideo) messageRecord).richText = (im_msg_body$RichText) obj;
                                } else if (i19 == -1 && (aVar = yVar.f288329b) != null && "cancel".equals(aVar.f258737b)) {
                                    i17 = 1;
                                }
                            }
                            i18++;
                        }
                    }
                    i16++;
                }
                i16 = i17;
            } else if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, "onMultiForwardVideoUploadResult failed!");
            }
            if (i16 != 0) {
                MultiMsgManager.this.K(this.f251564b, this.f251565c, this.f251566d, this.f251567e);
                return;
            }
            MultiMsgManager.this.Z(2);
            if (MultiMsgManager.this.f251536d == 0) {
                MultiMsgManager.this.L(this.f251565c, this.f251566d, this.f251567e, this.f251568f, this.f251564b, null, this.f251563a, false, this.f251569g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class c implements ad {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        WeakReference<QQAppInterface> f251571d;

        /* renamed from: e, reason: collision with root package name */
        MessageRecord f251572e;

        /* renamed from: f, reason: collision with root package name */
        String f251573f;

        /* renamed from: h, reason: collision with root package name */
        int f251574h;

        /* renamed from: i, reason: collision with root package name */
        ArrayList<MessageRecord> f251575i;

        /* renamed from: m, reason: collision with root package name */
        HashMap<String, String> f251576m;

        public c(QQAppInterface qQAppInterface, MessageRecord messageRecord, String str, int i3, ArrayList<MessageRecord> arrayList, HashMap<String, String> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQAppInterface, messageRecord, str, Integer.valueOf(i3), arrayList, hashMap);
                return;
            }
            this.f251571d = new WeakReference<>(qQAppInterface);
            this.f251572e = messageRecord;
            this.f251573f = str;
            this.f251574h = i3;
            this.f251575i = arrayList;
            this.f251576m = hashMap;
        }

        private Bitmap a(Bitmap bitmap) {
            Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
            Canvas canvas = new Canvas(copy);
            canvas.drawColor(-1);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            return copy;
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
            String format;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
                return;
            }
            if (aVar.f258597a == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("MultiMsg_TAG", 2, "send real struct msg for weixin done, cost : " + (System.currentTimeMillis() - MultiMsgManager.R));
                }
                try {
                    int i3 = 1;
                    if (this.f251574h == 0) {
                        format = String.format(this.f251571d.get().getApplication().getString(R.string.cd_), com.tencent.mobileqq.utils.ac.B(this.f251571d.get(), this.f251571d.get().getCurrentUin()), com.tencent.mobileqq.utils.ac.B(this.f251571d.get(), this.f251573f));
                    } else {
                        format = String.format(this.f251571d.get().getApplication().getString(R.string.cda), com.tencent.mobileqq.utils.ac.Q(this.f251571d.get(), this.f251573f, this.f251574h));
                    }
                    String str = format;
                    String str2 = this.f251572e.f203106msg;
                    String str3 = "https://mma.qq.com/jumpqq/forward2.html?rId=" + aVar.f258602f + "&fName=" + aVar.f258603g;
                    int i16 = this.f251574h;
                    if (i16 == 1) {
                        i3 = 4;
                    } else if (i16 == 3000) {
                        i3 = 101;
                    }
                    Bitmap faceBitmap = this.f251571d.get().getFaceBitmap(i3, this.f251573f, (byte) 1, false, 0);
                    if (faceBitmap == null) {
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", 2, "send to weixin icon != null  ");
                    }
                    if (this.f251574h == 3000) {
                        faceBitmap = a(faceBitmap);
                    }
                    Bitmap bitmap = faceBitmap;
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    WXShareHelper.b0().M0(valueOf, str, bitmap, str2, str3);
                    long hashCode = aVar.f258602f.hashCode();
                    Iterator<MessageRecord> it = this.f251575i.iterator();
                    while (it.hasNext()) {
                        it.next().msgseq = hashCode;
                    }
                    this.f251571d.get().getProxyManager().k().O(this.f251575i, null);
                    MultiMsgManager.w().T(this.f251576m, hashCode, this.f251571d.get());
                    ((MessageHandler) this.f251571d.get().getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandlerConstants.NOTIFY_TYPE_MSGFORWARD_WX, false, 0);
                    if (QLog.isColorLevel()) {
                        QLog.i("MultiMsg_TAG", 2, "shareToWXFriend.transaction: " + valueOf + ", shareLink:" + str3);
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, "upload multi msg pack failed, result.errStr=" + aVar.f258598b + ",result.errStr=" + aVar.f258599c);
            }
            ((MessageHandler) this.f251571d.get().getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandlerConstants.NOTIFY_TYPE_MSGFORWARD_WX, false, 5);
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void r(ad.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class d implements ad {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        WeakReference<QQAppInterface> f251577d;

        /* renamed from: e, reason: collision with root package name */
        MessageRecord f251578e;

        /* renamed from: f, reason: collision with root package name */
        String f251579f;

        /* renamed from: h, reason: collision with root package name */
        int f251580h;

        public d(QQAppInterface qQAppInterface, MessageRecord messageRecord, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQAppInterface, messageRecord, str, Integer.valueOf(i3));
                return;
            }
            this.f251577d = new WeakReference<>(qQAppInterface);
            this.f251578e = messageRecord;
            this.f251579f = str;
            this.f251580h = i3;
        }

        @Override // com.tencent.mobileqq.pic.ad
        public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (MessageRecord) iPatchRedirector.redirect((short) 4, (Object) this, (Object) im_msg_body_richtext);
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.pic.ad
        public void q(ad.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
                return;
            }
            if (aVar.f258597a == 0) {
                MessageRecord messageRecord = this.f251578e;
                if (messageRecord instanceof IMultiMsgRecordOp) {
                    ((IMultiMsgRecordOp) messageRecord).updateFilename(String.valueOf(messageRecord.uniseq));
                }
                MessageRecord messageRecord2 = this.f251578e;
                if (messageRecord2 instanceof MessageForStructing) {
                    MessageForStructing messageForStructing = (MessageForStructing) messageRecord2;
                    messageForStructing.structingMsg.mResid = aVar.f258602f;
                    this.f251577d.get().getMessageFacade().Y0(this.f251579f, this.f251580h, messageForStructing.uniseq, messageForStructing.structingMsg.getBytes());
                } else if (messageRecord2 instanceof MessageForArkApp) {
                    MessageForArkApp messageForArkApp = (MessageForArkApp) messageRecord2;
                    messageForArkApp.ark_app_message.updateMultiInfo(aVar.f258602f, messageRecord2.uniseq);
                    this.f251577d.get().getMessageFacade().Y0(this.f251579f, this.f251580h, messageForArkApp.uniseq, messageForArkApp.ark_app_message.toBytes());
                }
                this.f251577d.get().getMessageFacade().D0(this.f251578e, null);
                if (QLog.isColorLevel()) {
                    QLog.d("MultiMsg_TAG", 2, "send real struct msg done, cost : " + (System.currentTimeMillis() - MultiMsgManager.R));
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, "upload multi msg pack failed, result.errStr=" + aVar.f258598b + ",result.errStr=" + aVar.f258599c);
            }
            this.f251578e.extraflag = 32768;
            this.f251577d.get().getMsgCache().G1(this.f251579f, this.f251580h, this.f251578e.uniseq);
            Message lastMessage = this.f251577d.get().getMessageFacade().getLastMessage(this.f251579f, this.f251580h);
            if (lastMessage != null && lastMessage.uniseq == this.f251578e.uniseq) {
                lastMessage.extraflag = 32768;
            }
            ((MessageHandler) this.f251577d.get().getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.k3(this.f251580h), false, new Object[]{this.f251579f, Integer.valueOf(this.f251580h), -1, null, 0L, Long.valueOf(this.f251578e.uniseq)});
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void r(ad.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class e implements ad {
        static IPatchRedirector $redirector_;
        private ArrayList<MessageRecord> C;

        /* renamed from: d, reason: collision with root package name */
        private MessageRecord f251581d;

        /* renamed from: e, reason: collision with root package name */
        private QQAppInterface f251582e;

        /* renamed from: f, reason: collision with root package name */
        private String f251583f;

        /* renamed from: h, reason: collision with root package name */
        private int f251584h;

        /* renamed from: i, reason: collision with root package name */
        private MultiMsgManager f251585i;

        /* renamed from: m, reason: collision with root package name */
        private int f251586m;

        e(MessageRecord messageRecord, ArrayList<MessageRecord> arrayList, QQAppInterface qQAppInterface, String str, int i3, int i16, MultiMsgManager multiMsgManager) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, messageRecord, arrayList, qQAppInterface, str, Integer.valueOf(i3), Integer.valueOf(i16), multiMsgManager);
                return;
            }
            this.f251581d = messageRecord;
            this.f251582e = qQAppInterface;
            this.f251583f = str;
            this.f251584h = i3;
            this.f251585i = multiMsgManager;
            this.f251586m = i16;
            this.C = arrayList;
        }

        @Override // com.tencent.mobileqq.pic.ad
        public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (MessageRecord) iPatchRedirector.redirect((short) 2, (Object) this, (Object) im_msg_body_richtext);
            }
            if (im_msg_body_richtext != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("MultiMsg_TAG", 2, "mPttUpCallBack attachRichText2Msg with " + im_msg_body_richtext.toString());
                }
                if ((this.C.get(0) instanceof MessageForRichText) && ((MessageForRichText) this.C.get(0)).richText == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", 2, "PttUploadCallback.attachRichText2Msg return but mr.richtext is null");
                    }
                    ((MessageForRichText) this.C.get(0)).richText = im_msg_body_richtext;
                }
                if (this.C.get(0) instanceof MessageForPtt) {
                    if (((MessageForPtt) this.C.get(0)).fileSize < 0) {
                        QLog.d("MultiMsg_TAG", 1, "PttUploadCallback attachRichText2Msg with fileSize < 0");
                        if (QLog.isColorLevel()) {
                            QLog.d("MultiMsg_TAG", 2, "start print stack trace ---------");
                            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                                QLog.d("MultiMsg_TAG", 2, stackTraceElement);
                            }
                        }
                        ((MessageForPtt) this.C.get(0)).fileSize = 1L;
                    }
                } else {
                    QLog.d("MultiMsg_TAG", 1, "PttUploadCallback attachRichText2Msg but not message for ptt");
                }
                this.f251582e.getProxyManager().k().O(this.C, null);
                this.f251585i.L(this.f251582e, this.f251583f, this.f251584h, new HashMap(), this.f251581d, null, this.C, true, this.f251586m);
            } else {
                QLog.d("MultiMsg_TAG", 1, "mPttUpCallBack attachRichText2Msg with null");
            }
            return null;
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void q(ad.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
                return;
            }
            if (aVar.f258597a != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("MultiMsg_TAG", 2, "mPttUpCallBack onSend fail with " + aVar.toString());
                }
                if (this.C.get(0) instanceof MessageForPtt) {
                    if (((MessageForPtt) this.C.get(0)).fileSize < 0) {
                        QLog.d("MultiMsg_TAG", 1, "PttUploadCallback onSend with fileSize < 0");
                        if (QLog.isColorLevel()) {
                            QLog.d("MultiMsg_TAG", 2, "start print stack trace ---------");
                            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                                QLog.d("MultiMsg_TAG", 2, stackTraceElement);
                            }
                        }
                    }
                } else {
                    QLog.d("MultiMsg_TAG", 1, "PttUploadCallback onSend but no message for ptt");
                }
                this.f251582e.getProxyManager().k().O(this.C, null);
                this.f251585i.K(this.f251581d, this.f251582e, this.f251583f, this.f251584h);
                return;
            }
            QLog.d("MultiMsg_TAG", 1, "mPttUpCallBack onSend result ok");
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void r(ad.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            } else if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, "mPttUpCallBack updateMsg with " + aVar.toString());
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73184);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 47)) {
            redirector.redirect((short) 47);
            return;
        }
        N = AppConstants.SDCARD_PATH + "fight/pic_expire.png";
        P = new byte[0];
    }

    public MultiMsgManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f251536d = 0;
        this.f251538f = 100;
        this.f251539h = 20;
        this.f251540i = 10;
        this.f251541m = true;
        this.C = 100;
        this.D = 10;
        this.E = 0;
        this.F = 0;
        this.I = new HashMap<>();
        this.J = new HashMap<>();
        this.K = new ArrayList<>();
        this.L = new HashMap<>();
        this.M = 0;
    }

    public static String F(QQAppInterface qQAppInterface) {
        String str = N;
        if (!new File(str).exists()) {
            FileUtils.copyResToFile(qQAppInterface.getApp(), R.drawable.haq, str);
            FileUtils.copyFile(str, AbsDownloader.getFilePath("chatthumb:" + FileUtils.calcMd5(str)));
        }
        return str;
    }

    public static long G() {
        File file = new File(N);
        if (file.exists()) {
            return file.length();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean J(long j3) {
        LongSparseArray<Integer> longSparseArray = this.f251537e;
        boolean z16 = false;
        if (longSparseArray == null) {
            if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, "isReceiptMessageFinished map null and res: false");
            }
            return false;
        }
        if (longSparseArray.get(j3, 0).intValue() == 0) {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "isReceiptMessageFinished res: " + z16);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(MessageRecord messageRecord, QQAppInterface qQAppInterface, String str, int i3) {
        messageRecord.extraflag = 32768;
        qQAppInterface.getMsgCache().G1(str, i3, messageRecord.uniseq);
        qQAppInterface.getMessageFacade().Z0(str, i3, messageRecord.uniseq, 32768, -1);
        ((MessageHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.k3(i3), false, new Object[]{str, Integer.valueOf(i3), -1, null, 0L, Long.valueOf(messageRecord.uniseq)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void L(QQAppInterface qQAppInterface, String str, int i3, HashMap<String, String> hashMap, MessageRecord messageRecord, bs bsVar, ArrayList<MessageRecord> arrayList, boolean z16, int i16) {
        ad aVar;
        ad cVar;
        if (QLog.isDevelopLevel()) {
            QLog.d("MultiMsg_TAG", 4, "pack multi msg start.............................");
            QLog.d("MultiMsg_TAG", 4, arrayList.toString());
        }
        byte[] t16 = qQAppInterface.getProxyManager().k().t(arrayList, hashMap, z16);
        if (t16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, "pack multi msg failed.............................");
            }
            if (i16 == 2) {
                ((MessageHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandlerConstants.NOTIFY_TYPE_MSGFORWARD_WX, false, 4);
                return;
            }
            messageRecord.extraflag = 32768;
            qQAppInterface.getMsgCache().G1(str, i3, messageRecord.uniseq);
            ((MessageHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.k3(i3), false, new Object[]{str, Integer.valueOf(i3), -1, null, 0L, Long.valueOf(messageRecord.uniseq)});
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "pack multi msg done.............................");
        }
        if (i16 == 0) {
            aVar = new d(qQAppInterface, messageRecord, str, i3);
        } else {
            if (i16 == 2) {
                cVar = new c(qQAppInterface, messageRecord, str, i3, arrayList, hashMap);
                if (!b0(qQAppInterface, t16, qQAppInterface.getCurrentAccountUin(), str, str, i3, messageRecord.uniseq, 1035, cVar)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", 2, "sendMultiMsg successful, upload multi msg pack start.......................");
                        return;
                    }
                    return;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", 2, "sendMultiMsg failed.......................");
                        return;
                    }
                    return;
                }
            }
            if (i16 == 5) {
                aVar = new ReceiptMsgManager.a(qQAppInterface, messageRecord, str, i3);
            } else {
                QLog.e("MultiMsg_TAG", 1, "not support forwardMode:" + i16);
                return;
            }
        }
        cVar = aVar;
        if (!b0(qQAppInterface, t16, qQAppInterface.getCurrentAccountUin(), str, str, i3, messageRecord.uniseq, 1035, cVar)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(QQAppInterface qQAppInterface, String str, int i3, HashMap<String, String> hashMap, MessageRecord messageRecord, ArrayList<MessageRecord> arrayList, ArrayList<com.tencent.mobileqq.pic.l> arrayList2, int i16) {
        p createPicReq = ((IPicBus) QRoute.api(IPicBus.class)).createPicReq(8, 7);
        createPicReq.c(arrayList2);
        createPicReq.g(new a(i16, i3, messageRecord, arrayList, qQAppInterface, str, hashMap));
        ((IPicBus) QRoute.api(IPicBus.class)).launch(createPicReq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(QQAppInterface qQAppInterface, String str, int i3, MessageRecord messageRecord, ArrayList<MessageRecord> arrayList, int i16, @Nullable Bundle bundle) {
        String str2;
        int i17;
        MessageForPtt messageForPtt = (MessageForPtt) arrayList.get(0);
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mSelfUin = qQAppInterface.getAccount();
        transferRequest.mPeerUin = str;
        transferRequest.mUinType = i3;
        transferRequest.mFileType = 2;
        transferRequest.mUniseq = arrayList.get(0).uniseq;
        boolean z16 = true;
        transferRequest.mIsUp = true;
        if (bundle != null) {
            str2 = bundle.getString("ReceiptMsgManager.EXTRA_KEY_PTT_PATH");
        } else {
            str2 = messageForPtt.fullLocalPath;
        }
        transferRequest.mLocalPath = str2;
        transferRequest.mBusiType = 1002;
        if (bundle != null && !bundle.getBoolean("ReceiptMsgManager.EXTRA_KEY_PTT_COMPRESS_FINISHED")) {
            z16 = false;
        }
        transferRequest.mPttCompressFinish = z16;
        if (bundle != null) {
            i17 = t(bundle.getInt("ReceiptMsgManager.EXTRA_KEY_PTT_SEND_SOURCE"));
        } else {
            i17 = 0;
        }
        transferRequest.mPttUploadPanel = i17;
        transferRequest.mRec = arrayList.get(0);
        messageForPtt.mInputContent = "";
        transferRequest.mUpCallBack = new e(messageRecord, arrayList, qQAppInterface, str, i3, i16, this);
        transferRequest.needSendMsg = false;
        ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(QQAppInterface qQAppInterface, String str, int i3, HashMap<String, String> hashMap, MessageRecord messageRecord, ArrayList<MessageRecord> arrayList, ArrayList<com.tencent.mobileqq.shortvideo.p> arrayList2, v vVar, int i16) {
        ArrayList<com.tencent.mobileqq.shortvideo.p> arrayList3;
        v vVar2;
        if (vVar == null) {
            vVar2 = com.tencent.mobileqq.shortvideo.h.b(5, 5);
            arrayList3 = arrayList2;
        } else {
            arrayList3 = arrayList2;
            vVar2 = vVar;
        }
        vVar2.f(arrayList3);
        vVar2.h(new b(arrayList, messageRecord, qQAppInterface, str, i3, hashMap, i16));
        com.tencent.mobileqq.shortvideo.l.e(vVar2, qQAppInterface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "updateFinishMask mask: " + i3);
        }
        this.f251536d = i3 ^ this.f251536d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a0(long j3, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "updateFinishMaskForReceiptMessage uniseq: " + j3 + " mask:" + i3);
        }
        LongSparseArray<Integer> longSparseArray = this.f251537e;
        if (longSparseArray != null) {
            int intValue = i3 ^ longSparseArray.get(j3, 0).intValue();
            if (intValue != 0) {
                this.f251537e.put(j3, Integer.valueOf(intValue));
            } else {
                this.f251537e.remove(j3);
            }
        }
    }

    private boolean b0(QQAppInterface qQAppInterface, byte[] bArr, String str, String str2, String str3, int i3, long j3, int i16, ad adVar) {
        return c0(qQAppInterface, bArr, str, str2, str3, i3, j3, i16, false, adVar);
    }

    private boolean c0(QQAppInterface qQAppInterface, byte[] bArr, String str, String str2, String str3, int i3, long j3, int i16, boolean z16, ad adVar) {
        if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "[sendMultiMsg]data.length = " + bArr.length);
        }
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = true;
        transferRequest.mFileType = FileMsg.TRANSFILE_TYPE_MULTIMSG;
        transferRequest.multiMsgType = 0;
        transferRequest.toSendData = bArr;
        transferRequest.mSelfUin = str;
        transferRequest.mPeerUin = str2;
        transferRequest.mSecondId = str3;
        transferRequest.mUinType = i3;
        transferRequest.mUniseq = j3;
        transferRequest.mBusiType = i16;
        transferRequest.upMsgBusiType = D();
        transferRequest.mUpCallBack = adVar;
        if (z16) {
            transferRequest.isJubaoMsgType = true;
        }
        ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void s() {
        if (this.f251537e == null) {
            this.f251537e = new LongSparseArray<>();
        }
    }

    private int t(int i3) {
        if (i3 == 1 || i3 == 2) {
            return 1;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                return 3;
            }
            if (i3 != 6) {
                return 0;
            }
        }
        return 2;
    }

    public static MultiMsgManager w() {
        if (Q == null) {
            synchronized (P) {
                if (Q == null) {
                    Q = new MultiMsgManager();
                }
            }
        }
        return Q;
    }

    private int y(ChatMessage chatMessage) {
        int i3 = this.M;
        if (i3 != 7 && i3 != 10) {
            return i.e(chatMessage);
        }
        return 1;
    }

    public List<ChatMessage> A(QQAppInterface qQAppInterface, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, this, qQAppInterface, Long.valueOf(j3));
        }
        return B(qQAppInterface, j3, null, 0);
    }

    public List<ChatMessage> B(QQAppInterface qQAppInterface, long j3, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (List) iPatchRedirector.redirect((short) 12, this, qQAppInterface, Long.valueOf(j3), str, Integer.valueOf(i3));
        }
        ArrayList<MessageRecord> z16 = qQAppInterface.getProxyManager().k().z(j3);
        if (str != null) {
            com.tencent.imcore.message.ad.P(str, i3, z16, qQAppInterface.getMsgCache());
        }
        ArrayList arrayList = new ArrayList();
        for (MessageRecord messageRecord : z16) {
            if (messageRecord instanceof MessageForStructing) {
                MessageForStructing messageForStructing = (MessageForStructing) messageRecord;
                if (messageForStructing.structingMsg == null) {
                    messageForStructing.structingMsg = com.tencent.mobileqq.structmsg.i.d(messageRecord.msgData);
                }
            }
            arrayList.add((ChatMessage) messageRecord);
            if (QLog.isColorLevel() && (messageRecord instanceof MessageForPic)) {
                MessageForPic messageForPic = (MessageForPic) messageRecord;
                QLog.d("MultiMsg_TAG", 2, "[chatPie.getMultiMsgList] = " + messageForPic.toLogString() + " mr = " + messageForPic.toString());
            }
        }
        return arrayList;
    }

    public boolean C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.f251541m;
    }

    public int D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Integer) iPatchRedirector.redirect((short) 46, (Object) this)).intValue();
        }
        return 0;
    }

    public int E(Collection<ChatMessage> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this, (Object) collection)).intValue();
        }
        int i3 = 0;
        for (ChatMessage chatMessage : collection) {
            if (chatMessage instanceof MessageForPic) {
                i3++;
            } else if (chatMessage instanceof MessageForMixedMsg) {
                Iterator<MessageRecord> it = ((MessageForMixedMsg) chatMessage).msgElemList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof MessageForPic) {
                        i3++;
                    }
                }
            } else if (chatMessage.msgtype == -1036) {
                for (MessageRecord messageRecord : ((MessageForLongMsg) chatMessage).longMsgFragmentList) {
                    if (messageRecord instanceof MessageForMixedMsg) {
                        Iterator<MessageRecord> it5 = ((MessageForMixedMsg) messageRecord).msgElemList.iterator();
                        while (it5.hasNext()) {
                            if (it5.next() instanceof MessageForPic) {
                                i3++;
                            }
                        }
                    }
                }
            }
        }
        return i3;
    }

    public SessionInfo H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (SessionInfo) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.G;
    }

    public void I(QQAppInterface qQAppInterface) {
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) qQAppInterface);
            return;
        }
        if (qQAppInterface != null) {
            ServerConfigManager.ConfigType configType = ServerConfigManager.ConfigType.user;
            String serverConfigValue = qQAppInterface.getServerConfigValue(configType, "MMF_enable");
            qQAppInterface.getServerConfigValue(configType, "MMF_maxMsgNum");
            String serverConfigValue2 = qQAppInterface.getServerConfigValue(configType, "MMF_maxPicNum");
            String serverConfigValue3 = qQAppInterface.getServerConfigValue(configType, "MMF_maxVideoNum");
            int f16 = NtMultiFavUtils.f();
            if (f16 > 0) {
                this.f251538f = f16;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, "initLimitCount enable = " + serverConfigValue + " maxMsgNum = " + f16 + " maxPicNum " + serverConfigValue2);
            }
            if (!TextUtils.isEmpty(serverConfigValue2)) {
                try {
                    this.f251539h = Integer.parseInt(serverConfigValue2);
                } catch (NumberFormatException unused) {
                    this.f251539h = 20;
                }
            }
            if (!TextUtils.isEmpty(serverConfigValue3)) {
                try {
                    this.f251540i = Integer.parseInt(serverConfigValue3);
                } catch (NumberFormatException unused2) {
                    this.f251540i = 10;
                }
            }
            String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.MultiMsgConfig.name(), IDPCApiConstant.MULTI_MSG_CONFIG);
            if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, "initLimitCount delayConfi = " + featureValue);
            }
            if (!TextUtils.isEmpty(featureValue)) {
                Integer[] numArr = new Integer[4];
                Arrays.fill((Object[]) numArr, (Object) 0);
                if (((IDPCApi) QRoute.api(IDPCApi.class)).parseComplexParamsByStringToIntParser(featureValue, numArr) >= 4) {
                    if (numArr[0].intValue() >= 0) {
                        this.C = numArr[0].intValue();
                        if (numArr[1].intValue() > 0) {
                            i17 = numArr[1].intValue();
                        } else {
                            i17 = this.D;
                        }
                        this.D = i17;
                    }
                    if (numArr[2].intValue() >= 0) {
                        i3 = numArr[2].intValue();
                    } else {
                        i3 = this.E;
                    }
                    this.E = i3;
                    if (numArr[3].intValue() >= 0) {
                        i16 = numArr[3].intValue();
                    } else {
                        i16 = this.F;
                    }
                    this.F = i16;
                }
            }
        }
        this.f251541m = true;
    }

    public void M(MessageRecord messageRecord, QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) messageRecord, (Object) qQAppInterface);
            return;
        }
        if (this.F != 0) {
            return;
        }
        if (this.E != 0 && ((IPicPreDownload) qQAppInterface.getRuntimeService(IPicPreDownload.class, "")).calcUinType(qQAppInterface, messageRecord.istroop, messageRecord.frienduin) == 1) {
            return;
        }
        String g16 = i.g(messageRecord);
        if (TextUtils.isEmpty(g16)) {
            if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, "preDownloadRes failed by empty resid!");
                return;
            }
            return;
        }
        String str = messageRecord.frienduin;
        int i3 = messageRecord.istroop;
        long j3 = messageRecord.uniseq;
        if (i.k()) {
            QLog.d("MultiMsg_TAG", 1, "preDownloadRes begin! touin:" + str + ",touinType:" + i3 + ",uniseq:" + j3 + ",fileKey:" + g16);
        }
        w().N(qQAppInterface, g16, qQAppInterface.getCurrentAccountUin(), str, str, i3, j3, 1035, null);
    }

    public boolean N(QQAppInterface qQAppInterface, String str, String str2, String str3, String str4, int i3, long j3, int i16, com.tencent.mobileqq.pic.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, qQAppInterface, str, str2, str3, str4, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), cVar)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            QLog.isColorLevel();
            if (cVar != null && ArkMsgUtils.isFailHandleEnabled()) {
                c.a aVar = new c.a();
                aVar.f258655b = -1;
                aVar.f258665l = j3;
                aVar.f258666m = str;
                cVar.h(aVar);
            }
            return false;
        }
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = false;
        transferRequest.mFileType = FileMsg.TRANSFILE_TYPE_MULTIMSG;
        transferRequest.resIdStr = str;
        transferRequest.mSelfUin = str2;
        transferRequest.mPeerUin = str3;
        transferRequest.mSecondId = str4;
        transferRequest.mUinType = i3;
        transferRequest.mUniseq = j3;
        transferRequest.mBusiType = i16;
        transferRequest.mDownCallBack = cVar;
        ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
        return true;
    }

    public void O(QQAppInterface qQAppInterface, String str, int i3, ArrayList<ChatMessage> arrayList, HashMap<String, String> hashMap, MessageRecord messageRecord, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, qQAppInterface, str, Integer.valueOf(i3), arrayList, hashMap, messageRecord, Integer.valueOf(i16));
        } else {
            P(qQAppInterface, str, i3, arrayList, hashMap, messageRecord, i16, null);
        }
    }

    public void P(QQAppInterface qQAppInterface, String str, int i3, ArrayList<ChatMessage> arrayList, HashMap<String, String> hashMap, MessageRecord messageRecord, int i16, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, qQAppInterface, str, Integer.valueOf(i3), arrayList, hashMap, messageRecord, Integer.valueOf(i16), bundle);
        } else if (messageRecord != null && arrayList != null && arrayList.size() != 0) {
            qQAppInterface.execute(new Runnable(arrayList, i16, hashMap, messageRecord, qQAppInterface, str, i3, bundle) { // from class: com.tencent.mobileqq.multimsg.MultiMsgManager.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ int C;
                final /* synthetic */ Bundle D;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ArrayList f251546d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f251547e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ HashMap f251548f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ MessageRecord f251549h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ QQAppInterface f251550i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ String f251551m;

                {
                    this.f251546d = arrayList;
                    this.f251547e = i16;
                    this.f251548f = hashMap;
                    this.f251549h = messageRecord;
                    this.f251550i = qQAppInterface;
                    this.f251551m = str;
                    this.C = i3;
                    this.D = bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, MultiMsgManager.this, arrayList, Integer.valueOf(i16), hashMap, messageRecord, qQAppInterface, str, Integer.valueOf(i3), bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    int i17;
                    int i18;
                    int i19;
                    int i26;
                    ArrayList arrayList2;
                    int i27;
                    StructMsgForImageShare structMsgForImageShare;
                    com.tencent.mobileqq.structmsg.view.e firstImageElement;
                    ArrayList<com.tencent.mobileqq.pic.l> createForwardPicInfos;
                    int i28;
                    int i29;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ArrayList<? extends MessageRecord> arrayList3 = new ArrayList<>(this.f251546d);
                    MultiMsgManager.R = System.currentTimeMillis();
                    int i36 = 5;
                    int i37 = 0;
                    if (this.f251547e == 5) {
                        MultiMsgManager.this.s();
                    } else {
                        MultiMsgManager.this.f251536d = 0;
                    }
                    if (this.f251547e != 2) {
                        MultiMsgManager.this.T(this.f251548f, this.f251549h.uniseq, this.f251550i);
                    }
                    MultiMsgProxy k3 = this.f251550i.getProxyManager().k();
                    MessageRecord messageRecord2 = this.f251549h;
                    if (this.f251547e != 5) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    ArrayList<MessageRecord> v3 = k3.v(messageRecord2, arrayList3, null, true, z16);
                    if (this.f251547e == 5) {
                        com.tencent.mobileqq.receipt.a.d(this.f251550i);
                    }
                    v vVar = null;
                    if (v3 == null) {
                        if (this.f251547e == 2) {
                            ((MessageHandler) this.f251550i.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandlerConstants.NOTIFY_TYPE_MSGFORWARD_WX, false, 3);
                            return;
                        }
                        this.f251549h.extraflag = 32768;
                        this.f251550i.getMsgCache().G1(this.f251551m, this.C, this.f251549h.uniseq);
                        ((MessageHandler) this.f251550i.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.k3(this.C), false, new Object[]{this.f251551m, Integer.valueOf(this.C), -1, null, 0L, Long.valueOf(this.f251549h.uniseq)});
                        return;
                    }
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    ArrayList arrayList6 = new ArrayList();
                    ArrayList arrayList7 = new ArrayList();
                    String account = this.f251550i.getAccount();
                    if (this.f251547e == 2) {
                        i17 = 0;
                    } else {
                        i17 = this.C;
                    }
                    Iterator<MessageRecord> it = v3.iterator();
                    while (it.hasNext()) {
                        MessageRecord next = it.next();
                        if (next instanceof MessageForPic) {
                            com.tencent.mobileqq.pic.l createForwardPicInfo = ((IPicBus) QRoute.api(IPicBus.class)).createForwardPicInfo(7, (MessageForPic) next, i17, account, this.f251551m, this.f251550i.getAccount());
                            if (createForwardPicInfo != null) {
                                if (this.f251547e == i36) {
                                    Bundle bundle2 = this.D;
                                    if (bundle2 != null) {
                                        i28 = bundle2.getInt("ReceiptMsgManager.EXTRA_KEY_PHOTO_SIZE_SPEC", 0);
                                    } else {
                                        try {
                                            i28 = Integer.valueOf(ReceiptMsgManager.q(next)).intValue();
                                        } catch (NumberFormatException unused) {
                                            i28 = 0;
                                        }
                                    }
                                    createForwardPicInfo.f258734m = i28;
                                    com.tencent.mobileqq.pic.v vVar2 = createForwardPicInfo.f258731f;
                                    if (i28 == 2) {
                                        i29 = 1;
                                    } else {
                                        i29 = 0;
                                    }
                                    vVar2.f258818d0 = i29;
                                }
                                arrayList4.add(createForwardPicInfo);
                            } else if (QLog.isColorLevel()) {
                                QLog.e("MultiMsg_TAG", 2, "[requestSendMultiMsg]createForwardPicInfo from MessageForPic failed");
                            }
                        } else if (next instanceof MessageForMixedMsg) {
                            ArrayList<com.tencent.mobileqq.pic.l> createForwardPicInfos2 = ((IPicBus) QRoute.api(IPicBus.class)).createForwardPicInfos(7, (MessageForMixedMsg) next, i17, account, this.f251551m, this.f251550i.getAccount());
                            if (createForwardPicInfos2 != null) {
                                arrayList4.addAll(createForwardPicInfos2);
                            } else if (QLog.isColorLevel()) {
                                QLog.e("MultiMsg_TAG", 2, "[requestSendMultiMsg]createForwardPicInfos from MessageForMixedMsg failed");
                            }
                        } else if (next.msgtype == -1036) {
                            for (MessageRecord messageRecord3 : ((MessageForLongMsg) next).longMsgFragmentList) {
                                if ((messageRecord3 instanceof MessageForMixedMsg) && (createForwardPicInfos = ((IPicBus) QRoute.api(IPicBus.class)).createForwardPicInfos(7, (MessageForMixedMsg) messageRecord3, i17, account, this.f251551m, this.f251550i.getAccount())) != null) {
                                    arrayList4.addAll(createForwardPicInfos);
                                }
                            }
                        } else if (next instanceof MessageForStructing) {
                            AbsStructMsg absStructMsg = ((MessageForStructing) next).structingMsg;
                            if (absStructMsg != null && (absStructMsg instanceof StructMsgForImageShare) && (firstImageElement = (structMsgForImageShare = (StructMsgForImageShare) absStructMsg).getFirstImageElement()) != null) {
                                if (firstImageElement.f290638c1 == null) {
                                    if (firstImageElement.f290637b1 == null) {
                                        firstImageElement.f290637b1 = structMsgForImageShare;
                                    }
                                    firstImageElement.f290638c1 = firstImageElement.m();
                                }
                                com.tencent.mobileqq.pic.l createForwardPicInfo2 = ((IPicBus) QRoute.api(IPicBus.class)).createForwardPicInfo(7, firstImageElement.f290638c1, this.C, account, this.f251551m, this.f251550i.getAccount());
                                if (createForwardPicInfo2 != null) {
                                    arrayList4.add(createForwardPicInfo2);
                                } else if (QLog.isColorLevel()) {
                                    QLog.e("MultiMsg_TAG", 2, "[requestSendMultiMsg]createForwardPicInfo from MessageForPic failed");
                                }
                            }
                        } else if (next instanceof MessageForShortVideo) {
                            MessageForShortVideo messageForShortVideo = (MessageForShortVideo) next;
                            messageForShortVideo.videoFileName = ShortVideoUtils.findVideoPathIfExists(messageForShortVideo);
                            if (vVar == null) {
                                vVar = com.tencent.mobileqq.shortvideo.h.b(5, 5);
                            }
                            com.tencent.mobileqq.shortvideo.p a16 = com.tencent.mobileqq.shortvideo.l.a(5, next, vVar);
                            if (a16 != null) {
                                arrayList5.add(a16);
                            } else if (QLog.isColorLevel()) {
                                QLog.e("MultiMsg_TAG", 2, "[requestSendMultiMsg]createShortVideoForwardInfo failed");
                            }
                        } else if ((next instanceof MessageForPtt) && this.f251547e == 5) {
                            arrayList6.add((MessageForPtt) next);
                        } else if (next instanceof MessageForFile) {
                            arrayList7.add(next);
                        } else if (next instanceof MessageForTroopFile) {
                            arrayList7.add(next);
                        }
                        i36 = 5;
                        i37 = 0;
                    }
                    int i38 = i37;
                    ChatMessage chatMessage = (ChatMessage) arrayList3.get(i38);
                    if (chatMessage != null) {
                        i18 = chatMessage.istroop;
                    } else {
                        i18 = i38;
                    }
                    if (i18 == 0) {
                        i19 = 1;
                        i26 = 1;
                    } else if (i18 == 3000) {
                        i19 = 1;
                        i26 = 2;
                    } else {
                        i19 = 1;
                        if (i18 == 1) {
                            i26 = 3;
                        } else {
                            i26 = 4;
                        }
                    }
                    int i39 = this.C;
                    if (i39 != 0) {
                        if (i39 == 3000) {
                            i19 = 2;
                        } else if (i39 == i19) {
                            i19 = 3;
                        } else {
                            i19 = 4;
                        }
                    }
                    ReportController.o(this.f251550i, "CliOper", "", "", "0X8004660", "0X8004660", 0, 0, i26 + "", i19 + "", "" + arrayList3.size(), "" + arrayList4.size());
                    if (arrayList4.size() == 0 && arrayList5.size() == 0 && arrayList6.size() == 0 && arrayList7.size() == 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d("MultiMsg_TAG", 2, "[requestSendMultiMsg]There's not any picture messages, goto onPackAndSendMsg");
                        }
                        MultiMsgManager.this.L(this.f251550i, this.f251551m, this.C, this.f251548f, this.f251549h, null, v3, true, this.f251547e);
                        return;
                    }
                    if (arrayList4.size() > 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d("MultiMsg_TAG", 2, "[requestSendMultiMsg]Upload pictures, count is [" + arrayList4.size() + "], goto requestUploadPics");
                        }
                        if (this.f251547e == 5) {
                            MultiMsgManager.this.a0(this.f251549h.uniseq, 1);
                        } else {
                            MultiMsgManager.this.Z(1);
                        }
                        arrayList2 = arrayList7;
                        MultiMsgManager.this.Q(this.f251550i, this.f251551m, this.C, this.f251548f, this.f251549h, v3, arrayList4, this.f251547e);
                    } else {
                        arrayList2 = arrayList7;
                    }
                    if (arrayList5.size() > 0) {
                        if (QLog.isColorLevel()) {
                            i27 = 2;
                            QLog.d("MultiMsg_TAG", 2, "[requestSendMultiMsg]Upload videos, count is [" + arrayList5.size() + "], goto requestUploadVideos");
                        } else {
                            i27 = 2;
                        }
                        MultiMsgManager.this.Z(i27);
                        MultiMsgManager.this.S(this.f251550i, this.f251551m, this.C, this.f251548f, this.f251549h, v3, arrayList5, vVar, this.f251547e);
                    }
                    if (arrayList6.size() > 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d("MultiMsg_TAG", 2, "[requestSendMultiMsg]Upload ptts, count is [" + arrayList6.size() + "], goto requestUploadPtts");
                        }
                        MultiMsgManager.this.R(this.f251550i, this.f251551m, this.C, this.f251549h, v3, this.f251547e, this.D);
                    }
                    if (arrayList2.size() > 0 && QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", 2, "[requestSendMultiMsg]Upload files, count is [" + arrayList2.size() + "], goto requestUploadFiles");
                    }
                }
            });
        }
    }

    public void T(HashMap<String, String> hashMap, long j3, QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, hashMap, Long.valueOf(j3), qQAppInterface);
            return;
        }
        if (hashMap != null && hashMap.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                MultiMsgNick multiMsgNick = new MultiMsgNick();
                multiMsgNick.uin = key;
                multiMsgNick.uniseq = j3;
                multiMsgNick.nick = value;
                arrayList.add(multiMsgNick);
            }
            EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
            ArrayList arrayList2 = new ArrayList();
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new PersistOrReplaceTransaction((MultiMsgNick) it.next()));
                }
                createEntityManager.doMultiDBOperateByTransaction(arrayList2);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            createEntityManager.close();
        }
    }

    public void U(QQAppInterface qQAppInterface, String str, int i3, String str2, AbsStructMsg absStructMsg, long j3, boolean z16, int i16, int i17, Bundle bundle) {
        String str3;
        String str4;
        String str5;
        int i18;
        QQAppInterface qQAppInterface2;
        boolean z17;
        ArrayList<ChatMessage> arrayList;
        HashMap<String, String> hashMap;
        int i19;
        AbsStructMsg absStructMsg2;
        MessageRecord messageRecord;
        int i26;
        Bundle bundle2;
        int i27;
        int i28;
        int i29;
        int i36;
        String str6;
        String str7;
        QQAppInterface qQAppInterface3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, qQAppInterface, str, Integer.valueOf(i3), str2, absStructMsg, Long.valueOf(j3), Boolean.valueOf(z16), Integer.valueOf(i16), Integer.valueOf(i17), bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 4, " sendMultiMsg start uniseq =  " + j3);
        }
        MessageForStructing messageForStructing = null;
        if (j3 == 0) {
            Iterator<ChatMessage> it = this.K.iterator();
            boolean z18 = true;
            while (it.hasNext()) {
                ChatMessage next = it.next();
                if (!(next instanceof MessageForText) && !(next instanceof MessageForLongMsg)) {
                    z18 = false;
                }
            }
            if (z18) {
                str3 = "MultiMsg_TAG";
                bundle2 = bundle;
                i27 = i17;
                ReportController.n(qQAppInterface, "CliOper", "", "", "0X800662C", "0X800662C", 0, 1, 0, "", "", "", "");
            } else {
                str3 = "MultiMsg_TAG";
                bundle2 = bundle;
                i27 = i17;
            }
            arrayList = new ArrayList<>();
            arrayList.addAll(this.K);
            hashMap = new HashMap<>();
            hashMap.putAll(this.L);
            if (i16 == 0) {
                i29 = 3;
                i28 = 1;
            } else {
                i28 = 1;
                i29 = i16 == 1 ? 2 : 0;
            }
            new x61.e().g(qQAppInterface, str, arrayList, i29);
            if (i16 == i28) {
                SessionInfo sessionInfo = new SessionInfo();
                sessionInfo.f179555d = i3;
                sessionInfo.f179557e = str;
                sessionInfo.f179559f = str2;
                sessionInfo.f(bundle2);
                X(qQAppInterface, sessionInfo, arrayList, i27);
                return;
            }
            if (i16 == 2) {
                String currentAccountUin = qQAppInterface.getCurrentAccountUin();
                int i37 = MobileQQServiceBase.seq;
                MobileQQServiceBase.seq = i37 + 1;
                i36 = i16;
                str6 = str2;
                str7 = str;
                qQAppInterface3 = qQAppInterface;
                MessageForStructing A = com.tencent.mobileqq.service.message.q.A(qQAppInterface, currentAccountUin, str, currentAccountUin, 1040, i37, absStructMsg);
                A.f203106msg = ChatActivityFacade.a0(arrayList, hashMap);
                messageForStructing = A;
            } else {
                i36 = i16;
                str6 = str2;
                str7 = str;
                qQAppInterface3 = qQAppInterface;
            }
            str4 = str7;
            str5 = str6;
            i18 = i36;
            qQAppInterface2 = qQAppInterface3;
            z17 = true;
        } else {
            str3 = "MultiMsg_TAG";
            ArrayList<ChatMessage> arrayList2 = new ArrayList<>();
            Iterator<MessageRecord> it5 = qQAppInterface.getProxyManager().k().z(j3).iterator();
            boolean z19 = true;
            while (it5.hasNext()) {
                MessageRecord next2 = it5.next();
                if (next2 instanceof ChatMessage) {
                    arrayList2.add((ChatMessage) next2);
                }
                if (!(next2 instanceof MessageForText) && !(next2 instanceof MessageForLongMsg)) {
                    z19 = false;
                }
            }
            if (z19) {
                str4 = str;
                str5 = str2;
                i18 = i16;
                qQAppInterface2 = qQAppInterface;
                z17 = true;
                ReportController.n(qQAppInterface, "CliOper", "", "", "0X800662C", "0X800662C", 0, 1, 0, "", "", "", "");
            } else {
                str4 = str;
                str5 = str2;
                i18 = i16;
                qQAppInterface2 = qQAppInterface;
                z17 = true;
            }
            HashMap<String, String> hashMap2 = new HashMap<>();
            Iterator<ChatMessage> it6 = arrayList2.iterator();
            while (it6.hasNext()) {
                ChatMessage next3 = it6.next();
                if (!hashMap2.containsKey(next3.senderuin)) {
                    String extInfoFromExtStr = next3.getExtInfoFromExtStr("self_nickname");
                    if (TextUtils.isEmpty(extInfoFromExtStr)) {
                        extInfoFromExtStr = z(next3.senderuin, next3.msgseq, qQAppInterface2);
                    }
                    if (extInfoFromExtStr == null || extInfoFromExtStr.trim().length() == 0) {
                        extInfoFromExtStr = i.d(next3.senderuin);
                    }
                    hashMap2.put(next3.senderuin, extInfoFromExtStr);
                }
            }
            arrayList = arrayList2;
            hashMap = hashMap2;
        }
        if (messageForStructing == null) {
            absStructMsg2 = absStructMsg;
            absStructMsg2.forwardID = i17;
            i19 = i3;
            messageRecord = ShareMsgHelper.a(qQAppInterface2, str4, i19, absStructMsg2);
        } else {
            i19 = i3;
            absStructMsg2 = absStructMsg;
            messageRecord = messageForStructing;
        }
        if (messageRecord != null) {
            messageRecord.isReMultiMsg = z17;
            String str8 = str5;
            int i38 = i18;
            String str9 = str4;
            com.tencent.mobileqq.activity.aio.forward.b.d().e(messageRecord.uniseq, 0L, i17);
            if (z16) {
                i26 = 1;
                qQAppInterface.getMessageFacade().T1(str9, i19, j3);
            } else {
                i26 = 1;
            }
            if (i38 != 0 && i38 != 2) {
                O(qQAppInterface, str, i3, arrayList, hashMap, messageRecord, i16);
                return;
            }
            h hVar = new h();
            SessionInfo sessionInfo2 = new SessionInfo();
            sessionInfo2.f179557e = str9;
            sessionInfo2.f179555d = i19;
            if (i38 == 2) {
                sessionInfo2.f179555d = 1040;
                sessionInfo2.Z = i19;
            }
            sessionInfo2.f179559f = str8;
            hVar.f251624h = 0;
            hVar.f251617a = sessionInfo2;
            hVar.f251618b = arrayList;
            hVar.f251619c = hashMap;
            hVar.f251625i = i38;
            hVar.f251620d = absStructMsg2;
            hVar.f251621e = messageRecord;
            qQAppInterface.getMultiMsgController().u(hVar);
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[i26];
                objArr[0] = Integer.valueOf(arrayList.size());
                QLog.d(str3, 2, String.format("step.sendRequest:msglistSize = %d", objArr));
            }
        }
    }

    protected void V(ChatMessage chatMessage, QQAppInterface qQAppInterface, int i3, SessionInfo sessionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, chatMessage, qQAppInterface, Integer.valueOf(i3), sessionInfo);
            return;
        }
        Intent fileForwardIntent = FileManagerUtil.getFileForwardIntent(qQAppInterface, chatMessage);
        if (fileForwardIntent != null && fileForwardIntent.getExtras() != null) {
            ForwardFileInfo forwardFileInfo = (ForwardFileInfo) fileForwardIntent.getExtras().getParcelable("fileinfo");
            String stringExtra = fileForwardIntent.getStringExtra(AppConstants.Key.FORWARD_FILEPATH);
            if (forwardFileInfo != null) {
                forwardFileInfo.V(chatMessage.uniseq);
                forwardFileInfo.L = i3;
                ChatActivityFacade.Q(qQAppInterface, BaseActivity.sTopActivity, sessionInfo, fileForwardIntent, stringExtra, forwardFileInfo, false);
            }
        }
    }

    public void W(QQAppInterface qQAppInterface, SessionInfo sessionInfo, ArrayList<ChatMessage> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, qQAppInterface, sessionInfo, arrayList);
        } else {
            X(qQAppInterface, sessionInfo, arrayList, 0);
        }
    }

    public void X(QQAppInterface qQAppInterface, SessionInfo sessionInfo, ArrayList<ChatMessage> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, qQAppInterface, sessionInfo, arrayList, Integer.valueOf(i3));
        } else if (arrayList != null && arrayList.size() != 0) {
            ArrayList arrayList2 = new ArrayList(arrayList);
            ((IOrderMediaMsgService) qQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).enqueueMediaMsgByMsgList(sessionInfo.f179557e, arrayList);
            qQAppInterface.execute(new Runnable(sessionInfo, arrayList2, qQAppInterface, i3) { // from class: com.tencent.mobileqq.multimsg.MultiMsgManager.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ SessionInfo f251542d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ ArrayList f251543e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ QQAppInterface f251544f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ int f251545h;

                {
                    this.f251542d = sessionInfo;
                    this.f251543e = arrayList2;
                    this.f251544f = qQAppInterface;
                    this.f251545h = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, MultiMsgManager.this, sessionInfo, arrayList2, qQAppInterface, Integer.valueOf(i3));
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:120:0x035b  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    int i16;
                    int i17;
                    int i18;
                    int i19;
                    Iterator it;
                    int i26;
                    MessageForMixedMsg messageForMixedMsg;
                    int i27;
                    AbsStructMsg absStructMsg;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean[] booleanArray = this.f251542d.b().getBooleanArray(AppConstants.Key.FORWARD_WRITE_TOGETHER_IS_EXPIRED);
                    Iterator it5 = this.f251543e.iterator();
                    char c16 = 0;
                    int i28 = 0;
                    int i29 = 0;
                    while (true) {
                        char c17 = 1;
                        if (!it5.hasNext()) {
                            break;
                        }
                        ChatMessage chatMessage = (ChatMessage) it5.next();
                        if (!(chatMessage instanceof MessageForWriteTogether) || !chatMessage.frienduin.equals(this.f251542d.f179557e) || this.f251542d.f179555d != 1 || booleanArray == null || booleanArray[this.f251543e.indexOf(chatMessage)]) {
                            int i36 = chatMessage.msgtype;
                            if (i36 == -2000) {
                                ChatActivityFacade.V(this.f251544f, this.f251542d, (MessageForPic) chatMessage, this.f251545h);
                                i27 = i28 + 1;
                                i26 = i29;
                            } else {
                                if (i36 == -2011) {
                                    boolean z16 = chatMessage instanceof MessageForStructing;
                                    if (z16 && (absStructMsg = ((MessageForStructing) chatMessage).structingMsg) != null && (absStructMsg instanceof StructMsgForImageShare)) {
                                        absStructMsg.forwardID = this.f251545h;
                                        QQAppInterface qQAppInterface2 = this.f251544f;
                                        StructMsgForImageShare structMsgForImageShare = (StructMsgForImageShare) absStructMsg;
                                        SessionInfo sessionInfo2 = this.f251542d;
                                        StructMsgForImageShare.sendAndUploadImageShare(qQAppInterface2, structMsgForImageShare, sessionInfo2.f179557e, sessionInfo2.f179555d, sessionInfo2.f179559f, 0);
                                    } else {
                                        c17 = c16;
                                    }
                                    if (c17 == 0 && z16) {
                                        AbsStructMsg absStructMsg2 = ((MessageForStructing) chatMessage).structingMsg;
                                        absStructMsg2.parentUniseq = chatMessage.uniseq;
                                        absStructMsg2.forwardID = this.f251545h;
                                        QQAppInterface qQAppInterface3 = this.f251544f;
                                        SessionInfo sessionInfo3 = this.f251542d;
                                        ShareMsgHelper.g(qQAppInterface3, sessionInfo3.f179557e, sessionInfo3.f179555d, absStructMsg2, null);
                                    }
                                } else if (i36 == -5008) {
                                    ArkAppMessage arkAppMessage = ((MessageForArkApp) chatMessage).ark_app_message;
                                    arkAppMessage.uniSeq = chatMessage.uniseq;
                                    arkAppMessage.forwardID = this.f251545h;
                                    ChatActivityFacade.w0(this.f251544f, this.f251542d, arkAppMessage);
                                } else if (i36 == -5017) {
                                    ArkAppMessage arkAppMessage2 = ((MessageForArkApp) chatMessage).ark_app_message;
                                    arkAppMessage2.uniSeq = chatMessage.uniseq;
                                    arkAppMessage2.forwardID = this.f251545h;
                                    ChatActivityFacade.B0(this.f251544f, this.f251542d, arkAppMessage2);
                                } else if (i36 == -5016) {
                                    QLog.e("MultiMsg_TAG", 1, "MSG_TYPE_ARK_BABYQ_REPLY no longer supported");
                                } else if (i36 == -5013) {
                                    ArkFlashChatMessage arkFlashChatMessage = ((MessageForArkFlashChat) chatMessage).ark_app_message;
                                    arkFlashChatMessage.uniSeq = chatMessage.uniseq;
                                    int i37 = this.f251545h;
                                    arkFlashChatMessage.forwardID = i37;
                                    ChatActivityFacade.z0(this.f251544f, this.f251542d, arkFlashChatMessage, i37);
                                } else {
                                    if (i36 != -1035 && i36 != -1036) {
                                        if (i36 == -2022) {
                                            MessageForShortVideo messageForShortVideo = (MessageForShortVideo) chatMessage;
                                            messageForShortVideo.forwardID = this.f251545h;
                                            ChatActivityFacade.X(this.f251544f, this.f251542d, messageForShortVideo);
                                        } else if (!(chatMessage instanceof MessageForFile) && !(chatMessage instanceof MessageForTroopFile)) {
                                            if (i36 == -3017) {
                                                MessageForDLFile messageForDLFile = (MessageForDLFile) chatMessage;
                                                DataLineMsgRecord d16 = this.f251544f.getMessageFacade().t1(messageForDLFile.deviceType).d(messageForDLFile.associatedId);
                                                if (d16 != null && FileUtils.fileExistsAndNotEmpty(d16.path)) {
                                                    MultiMsgManager.this.V(chatMessage, this.f251544f, this.f251545h, this.f251542d);
                                                }
                                            } else if (chatMessage instanceof MessageForReplyText) {
                                                com.tencent.mobileqq.replymsg.d.c().d(this.f251544f, (MessageForReplyText) chatMessage, this.f251542d, 0, this.f251545h, true);
                                            } else if (!MultiMsgManager.this.p(chatMessage, false, this.f251542d, this.f251544f, this.f251545h)) {
                                                String str = chatMessage.f203106msg;
                                                ChatActivityFacade.d dVar = new ChatActivityFacade.d();
                                                dVar.f175155s = true;
                                                dVar.f175158v = true;
                                                long[] M0 = ChatActivityFacade.M0(this.f251544f, null, this.f251542d, str, null, dVar);
                                                if (M0 != null && M0.length > 0) {
                                                    i26 = i29;
                                                    com.tencent.mobileqq.activity.aio.forward.b.d().e(M0[c16], chatMessage.uniseq, this.f251545h);
                                                    com.tencent.mobileqq.activity.aio.forward.b.d().l(this.f251544f, chatMessage.uniseq, this.f251545h);
                                                }
                                            }
                                        } else {
                                            i26 = i29;
                                            MultiMsgManager.this.V(chatMessage, this.f251544f, this.f251545h, this.f251542d);
                                        }
                                    } else {
                                        i26 = i29;
                                        if (i36 == -1036) {
                                            messageForMixedMsg = (MessageForMixedMsg) ((MessageForLongMsg) chatMessage).rebuildLongMsg();
                                            com.tencent.mobileqq.activity.aio.forward.b.d().m(chatMessage, messageForMixedMsg, this.f251545h);
                                        } else {
                                            messageForMixedMsg = (MessageForMixedMsg) chatMessage;
                                        }
                                        messageForMixedMsg.mForwardFromUniSeq = chatMessage.uniseq;
                                        messageForMixedMsg.forwardID = this.f251545h;
                                        com.tencent.mobileqq.replymsg.d.c().a(this.f251544f, messageForMixedMsg, this.f251542d, this.f251545h);
                                    }
                                    i27 = i28;
                                }
                                i26 = i29;
                                i27 = i28;
                            }
                            i29 = i26;
                            if (i29 < MultiMsgManager.this.D) {
                                try {
                                    LockMethodProxy.sleep(MultiMsgManager.this.C);
                                } catch (InterruptedException e16) {
                                    e16.printStackTrace();
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("MultiMsg_TAG", 2, "sendMultuMsgSeperaterFromLocal delay  i = " + i29 + " mDelayTime = " + MultiMsgManager.this.C);
                                }
                                i29++;
                            }
                            i28 = i27;
                            c16 = 0;
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", 2, "sendMultuMsgSeperaterFromLocal sendMsg cost = " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    SessionInfo sessionInfo4 = this.f251542d;
                    String str2 = sessionInfo4.f179557e;
                    int i38 = sessionInfo4.f179555d;
                    ChatMessage chatMessage2 = (ChatMessage) this.f251543e.get(0);
                    if (chatMessage2 != null) {
                        i16 = chatMessage2.istroop;
                    } else {
                        i16 = 0;
                    }
                    if (i16 == 0) {
                        i17 = 1;
                    } else if (i16 == 3000) {
                        i17 = 2;
                    } else if (i16 == 1) {
                        i17 = 3;
                    } else {
                        i17 = 4;
                    }
                    if (i38 == 0) {
                        i18 = 1;
                    } else if (i38 == 3000) {
                        i18 = 2;
                    } else if (i38 == 1) {
                        i18 = 3;
                    } else {
                        i18 = 4;
                    }
                    ReportController.o(this.f251544f, "CliOper", "", str2, "0X8004876", "0X8004876", 0, 0, i17 + "", i18 + "", "" + this.f251543e.size(), "" + i28 + "");
                    if (i38 != 0) {
                        if (i38 != 3000 && i38 != 1) {
                            if (i38 != 1000 && i38 != 1004) {
                                if (ChatActivityUtils.N(this.f251544f, this.f251542d)) {
                                    i19 = 4;
                                }
                            } else {
                                i19 = 3;
                            }
                        } else {
                            i19 = 2;
                        }
                        int size = this.f251543e.size();
                        it = this.f251543e.iterator();
                        int i39 = 0;
                        int i46 = 0;
                        while (it.hasNext()) {
                            int i47 = ((MessageRecord) it.next()).msgtype;
                            if (i47 == -2022) {
                                i39++;
                            } else if (i47 == -2005 || i47 == -2017) {
                                i46++;
                            }
                        }
                        ReportController.o(this.f251544f, "CliOper", "", str2, "0X8009ABF", "0X8009ABF", i19, 0, size + "", size + "", "" + i39, "" + i46);
                        i.q("report_0X8009ABF:fromType:%d,msgCount:%d,msgSize:%d,videoMsgCount:%d,fileMsgCount:%d", Integer.valueOf(i19), Integer.valueOf(size), Integer.valueOf(size), Integer.valueOf(i39), Integer.valueOf(i46));
                    }
                    i19 = 1;
                    int size2 = this.f251543e.size();
                    it = this.f251543e.iterator();
                    int i392 = 0;
                    int i462 = 0;
                    while (it.hasNext()) {
                    }
                    ReportController.o(this.f251544f, "CliOper", "", str2, "0X8009ABF", "0X8009ABF", i19, 0, size2 + "", size2 + "", "" + i392, "" + i462);
                    i.q("report_0X8009ABF:fromType:%d,msgCount:%d,msgSize:%d,videoMsgCount:%d,fileMsgCount:%d", Integer.valueOf(i19), Integer.valueOf(size2), Integer.valueOf(size2), Integer.valueOf(i392), Integer.valueOf(i462));
                }
            });
        }
    }

    public void Y(List<ChatMessage> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) list);
        } else if (list != null && list.size() > 0) {
            Collections.sort(list, Q);
        }
    }

    protected boolean p(ChatMessage chatMessage, boolean z16, SessionInfo sessionInfo, QQAppInterface qQAppInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, chatMessage, Boolean.valueOf(z16), sessionInfo, qQAppInterface, Integer.valueOf(i3))).booleanValue();
        }
        w.a("MultiMsgManager.checkSendSysAniStickerMsg");
        return false;
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
        } else {
            this.J.clear();
        }
    }

    @Override // java.util.Comparator
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public int compare(ChatMessage chatMessage, ChatMessage chatMessage2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Integer) iPatchRedirector.redirect((short) 41, (Object) this, (Object) chatMessage, (Object) chatMessage2)).intValue();
        }
        int i3 = chatMessage.istroop;
        if (i3 != 1 && i3 != 3000) {
            long j3 = chatMessage.time;
            long j16 = chatMessage2.time;
            if (j3 == j16) {
                if (chatMessage.getId() > chatMessage2.getId()) {
                    return 1;
                }
                if (chatMessage.getId() >= chatMessage2.getId()) {
                    return 0;
                }
                return -1;
            }
            if (j3 <= j16) {
                return -1;
            }
            return 1;
        }
        long j17 = chatMessage.shmsgseq;
        long j18 = chatMessage2.shmsgseq;
        if (j17 == j18) {
            if (chatMessage.getId() > chatMessage2.getId()) {
                return 1;
            }
            if (chatMessage.getId() >= chatMessage2.getId()) {
                return 0;
            }
            return -1;
        }
        if (j17 <= j18) {
            return -1;
        }
        return 1;
    }

    public int u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        int i3 = 0;
        for (ChatMessage chatMessage : this.J.keySet()) {
            if (this.J.get(chatMessage).booleanValue()) {
                i3 += y(chatMessage);
            }
        }
        i.p("checkMap.size = %d,count= %d", Integer.valueOf(this.J.size()), Integer.valueOf(i3));
        return i3;
    }

    public List<ChatMessage> v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (List) iPatchRedirector.redirect((short) 45, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<ChatMessage, Boolean> entry : this.J.entrySet()) {
            if (entry.getValue().booleanValue()) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    public int x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.H;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String z(String str, long j3, QQAppInterface qQAppInterface) {
        List<MultiMsgNick> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, this, str, Long.valueOf(j3), qQAppInterface);
        }
        if (!TextUtils.isEmpty(str) && j3 != 0) {
            if (this.I.size() > 0 && (list = this.I.get(Long.valueOf(j3))) != null && list.size() > 0) {
                for (MultiMsgNick multiMsgNick : list) {
                    if (multiMsgNick != null && str.equals(multiMsgNick.uin) && j3 == multiMsgNick.uniseq) {
                        return multiMsgNick.nick;
                    }
                }
            }
            this.I.clear();
            List<? extends Entity> query = qQAppInterface.getEntityManagerFactory().createEntityManager().query(MultiMsgNick.class, new MultiMsgNick().getTableName(), false, "uniseq = ?", new String[]{String.valueOf(j3)}, (String) null, (String) null, (String) null, (String) null);
            if (query != null && query.size() > 0) {
                this.I.put(Long.valueOf(j3), query);
                Iterator<? extends Entity> it = query.iterator();
                while (it.hasNext()) {
                    MultiMsgNick multiMsgNick2 = (MultiMsgNick) it.next();
                    if (multiMsgNick2 != null && str.equals(multiMsgNick2.uin) && j3 == multiMsgNick2.uniseq) {
                        return multiMsgNick2.nick;
                    }
                }
            }
        }
        return null;
    }
}
