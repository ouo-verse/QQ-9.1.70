package com.tencent.mobileqq.multimsg;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pic.ac;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.m;
import com.tencent.mobileqq.pic.p;
import com.tencent.mobileqq.pic.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import tencent.im.msg.im_msg_body$CustomFace;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$NotOnlineImage;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes15.dex */
public class j extends com.tencent.mobileqq.multimsg.a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static final String f251641b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a extends ac.b {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        ArrayList<Integer> f251642d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f251643e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ HashMap f251644f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ MessageRecord f251645h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ d f251646i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ h f251647m;

        a(ArrayList arrayList, HashMap hashMap, MessageRecord messageRecord, d dVar, h hVar) {
            this.f251643e = arrayList;
            this.f251644f = hashMap;
            this.f251645h = messageRecord;
            this.f251646i = dVar;
            this.f251647m = hVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, j.this, arrayList, hashMap, messageRecord, dVar, hVar);
            } else {
                this.f251642d = null;
            }
        }

        private void a(int i3) {
            if (this.f251642d == null) {
                this.f251642d = new ArrayList<>();
            }
            this.f251642d.add(Integer.valueOf(i3));
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0171  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x019d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int h(MessageForPic messageForPic, q qVar) {
            boolean z16;
            String stringUtf8;
            im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
            im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
            Object obj = qVar.f258793d;
            int i3 = 0;
            if (obj != null) {
                z16 = true;
                String str = "";
                if (obj instanceof im_msg_body$NotOnlineImage) {
                    im_msg_body_elem.not_online_image.set((im_msg_body$NotOnlineImage) obj);
                    PicMessageExtraData picMessageExtraData = messageForPic.picExtraData;
                    if (picMessageExtraData != null) {
                        im_msg_body_elem.not_online_image.bytes_pb_reserve.set(ByteStringMicro.copyFrom(picMessageExtraData.getOfflineImageResvAttr().get().toByteArray()), true);
                    }
                    if (qVar.f258795f) {
                        if (im_msg_body_elem.not_online_image.res_id.has()) {
                            stringUtf8 = im_msg_body_elem.not_online_image.res_id.get().toStringUtf8();
                        } else {
                            if (im_msg_body_elem.not_online_image.download_path.has()) {
                                stringUtf8 = im_msg_body_elem.not_online_image.download_path.get().toStringUtf8();
                            }
                            messageForPic.uuid = str;
                            messageForPic.path = str;
                            messageForPic.md5 = FileUtils.calcMd5(MultiMsgManager.N);
                            messageForPic.thumbMsgUrl = im_msg_body_elem.not_online_image.str_thumb_url.get();
                            messageForPic.thumbHeight = im_msg_body_elem.not_online_image.uint32_thumb_height.get();
                            messageForPic.thumbWidth = im_msg_body_elem.not_online_image.uint32_thumb_width.get();
                            messageForPic.msgData = messageForPic.getSerialPB().toByteArray();
                        }
                        str = stringUtf8;
                        messageForPic.uuid = str;
                        messageForPic.path = str;
                        messageForPic.md5 = FileUtils.calcMd5(MultiMsgManager.N);
                        messageForPic.thumbMsgUrl = im_msg_body_elem.not_online_image.str_thumb_url.get();
                        messageForPic.thumbHeight = im_msg_body_elem.not_online_image.uint32_thumb_height.get();
                        messageForPic.thumbWidth = im_msg_body_elem.not_online_image.uint32_thumb_width.get();
                        messageForPic.msgData = messageForPic.getSerialPB().toByteArray();
                    }
                    QLog.i("PicMultiMsgProcessor", 1, "add not_online_image, istroop=" + messageForPic.istroop + ", uuid=" + str + "md5 = " + messageForPic.md5);
                } else if (obj instanceof im_msg_body$CustomFace) {
                    im_msg_body_elem.custom_face.set((im_msg_body$CustomFace) obj);
                    PicMessageExtraData picMessageExtraData2 = messageForPic.picExtraData;
                    if (picMessageExtraData2 != null) {
                        im_msg_body_elem.custom_face.bytes_pb_reserve.set(ByteStringMicro.copyFrom(picMessageExtraData2.getCustomFaceResvAttr().get().toByteArray()), true);
                    }
                    if (qVar.f258795f) {
                        if (im_msg_body_elem.custom_face.str_file_path.has()) {
                            str = im_msg_body_elem.custom_face.str_file_path.get();
                        }
                        messageForPic.uuid = str;
                        messageForPic.path = str;
                        messageForPic.md5 = FileUtils.calcMd5(MultiMsgManager.N);
                        messageForPic.msgData = messageForPic.getSerialPB().toByteArray();
                    }
                    QLog.i("PicMultiMsgProcessor", 2, "add custom_face, istroop=" + messageForPic.istroop + ", uuid=" + str + "md5 = " + messageForPic.md5);
                } else {
                    QLog.w("PicMultiMsgProcessor", 1, "WTF, picResult.mExtraObj is " + qVar.f258793d.getClass().getSimpleName());
                }
                if (!z16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("PicMultiMsgProcessor", 2, "updateMessageForPic success");
                    }
                    im_msg_body_richtext.elems.add(im_msg_body_elem);
                    if (qVar.f258790a != 0) {
                        m.a aVar = qVar.f258791b;
                        if (aVar != null) {
                            i3 = aVar.f258738c;
                        } else {
                            i3 = -1;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.e("PicMultiMsgProcessor", 2, "[requestUploadPics] Bad picture element");
                        }
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.e("PicMultiMsgProcessor", 2, "updateMessageForPic failed, add empty element");
                    }
                    i3 = -1;
                }
                messageForPic.richText = im_msg_body_richtext;
                return i3;
            }
            z16 = false;
            if (!z16) {
            }
            messageForPic.richText = im_msg_body_richtext;
            return i3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
        
            if ((r16.getSourceMessage() instanceof com.tencent.mobileqq.data.MessageForPic) != false) goto L145;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0074, code lost:
        
            if ((r11.getSourceMessage() instanceof com.tencent.mobileqq.data.MessageForMixedMsg) != false) goto L109;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0094, code lost:
        
            if (r19.getSourceMessage().msgtype == (-1036)) goto L70;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00af, code lost:
        
            if ((r2.getSourceMessage() instanceof com.tencent.mobileqq.data.MessageForMixedMsg) != false) goto L44;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean j(ArrayList<q> arrayList) {
            MessageForPic messageForPic;
            boolean z16;
            boolean z17;
            MessageForMixedMsg messageForMixedMsg;
            a aVar;
            String str;
            String str2;
            boolean z18;
            MessageForLongMsg messageForLongMsg;
            Iterator<MessageRecord> it;
            MessageForStructing messageForStructing;
            AbsStructMsg absStructMsg;
            com.tencent.mobileqq.structmsg.view.e firstImageElement;
            MessageForPic messageForPic2;
            int i3;
            a aVar2 = this;
            boolean z19 = false;
            int i16 = 0;
            boolean z26 = false;
            for (int i17 = 0; i17 < aVar2.f251643e.size(); i17++) {
                MessageRecord messageRecord = (MessageRecord) aVar2.f251643e.get(i17);
                if (i16 < arrayList.size() && arrayList.get(i16).f258795f) {
                    z19 = true;
                }
                if (!(messageRecord instanceof MessageForPic)) {
                    boolean z27 = messageRecord instanceof MessageForReplyText;
                    if (z27) {
                        MessageForReplyText messageForReplyText = (MessageForReplyText) messageRecord;
                        if (messageForReplyText.getSourceMessage() != null) {
                        }
                    }
                    String str3 = ", resultIndex[";
                    boolean z28 = z19;
                    String str4 = "updateMessageForPic for MessageForMixedMsg, MsgIndex[";
                    if (!(messageRecord instanceof MessageForMixedMsg)) {
                        if (z27) {
                            MessageForReplyText messageForReplyText2 = (MessageForReplyText) messageRecord;
                            if (messageForReplyText2.getSourceMessage() != null) {
                            }
                        }
                        if (messageRecord.msgtype != -1036) {
                            boolean z29 = messageRecord instanceof MessageForReplyText;
                            if (z29) {
                                MessageForReplyText messageForReplyText3 = (MessageForReplyText) messageRecord;
                                if (messageForReplyText3.getSourceMessage() != null) {
                                    z18 = z26;
                                }
                            }
                            z18 = z26;
                            if (!(messageRecord instanceof MessageForStructing)) {
                                if (z29) {
                                    MessageForReplyText messageForReplyText4 = (MessageForReplyText) messageRecord;
                                    if (messageForReplyText4.getSourceMessage() != null) {
                                    }
                                }
                                z19 = z28;
                                z26 = z18;
                            }
                            if (z29) {
                                messageForStructing = (MessageForStructing) ((MessageForReplyText) messageRecord).getSourceMessage();
                                absStructMsg = messageForStructing.structingMsg;
                            } else {
                                messageForStructing = (MessageForStructing) messageRecord;
                                absStructMsg = messageForStructing.structingMsg;
                            }
                            if (absStructMsg != null && (absStructMsg instanceof StructMsgForImageShare) && (firstImageElement = ((StructMsgForImageShare) absStructMsg).getFirstImageElement()) != null && (messageForPic2 = firstImageElement.f290638c1) != null) {
                                if (QLog.isColorLevel()) {
                                    i3 = 2;
                                    QLog.d("PicMultiMsgProcessor", 2, "updateMessageForPic for MessageForPic, MsgIndex[" + i17 + "], resultIndex[" + i16 + "]");
                                } else {
                                    i3 = 2;
                                }
                                if (messageForStructing.isHotPicsStruct()) {
                                    PicMessageExtraData picMessageExtraData = new PicMessageExtraData();
                                    picMessageExtraData.imageBizType = i3;
                                    messageForPic2.picExtraData = picMessageExtraData;
                                }
                                int h16 = aVar2.h(messageForPic2, arrayList.get(i16));
                                if (h16 != 0) {
                                    aVar2.a(h16);
                                    if (j.this.b(h16)) {
                                        z26 = true;
                                        i16++;
                                        z19 = z28;
                                    }
                                }
                                z26 = z18;
                                i16++;
                                z19 = z28;
                            }
                            z19 = z28;
                            z26 = z18;
                        } else {
                            z18 = z26;
                        }
                        if (messageRecord instanceof MessageForReplyText) {
                            messageForLongMsg = (MessageForLongMsg) ((MessageForReplyText) messageRecord).getSourceMessage();
                        } else {
                            messageForLongMsg = (MessageForLongMsg) messageRecord;
                        }
                        Iterator<MessageRecord> it5 = messageForLongMsg.longMsgFragmentList.iterator();
                        while (it5.hasNext()) {
                            MessageRecord next = it5.next();
                            if (next instanceof MessageForMixedMsg) {
                                MessageForMixedMsg messageForMixedMsg2 = (MessageForMixedMsg) next;
                                if (messageForMixedMsg2.msgElemList != null) {
                                    int i18 = 0;
                                    while (i18 < messageForMixedMsg2.msgElemList.size()) {
                                        MessageRecord messageRecord2 = messageForMixedMsg2.msgElemList.get(i18);
                                        if (messageRecord2 instanceof MessageForPic) {
                                            if (i16 >= arrayList.size() && QLog.isColorLevel()) {
                                                QLog.e("PicMultiMsgProcessor", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
                                            }
                                            MessageForPic messageForPic3 = (MessageForPic) messageRecord2;
                                            if (QLog.isColorLevel()) {
                                                QLog.d("PicMultiMsgProcessor", 2, "updateMessageForPic for MessageForMixedMsg, MsgIndex[" + i17 + "], subMsgIndex[" + i18 + ", resultIndex[" + i16 + "]");
                                            }
                                            int h17 = aVar2.h(messageForPic3, arrayList.get(i16));
                                            if (h17 != 0) {
                                                aVar2.a(h17);
                                                if (j.this.b(h17)) {
                                                    it = it5;
                                                    z18 = true;
                                                } else {
                                                    it = it5;
                                                    MessageRecord c16 = j.this.f251587a.getMultiMessageProxy().c(messageForPic3, HardCodeUtil.qqStr(R.string.p6s), false);
                                                    messageForMixedMsg2.msgElemList.set(i18, c16);
                                                    if (QLog.isColorLevel()) {
                                                        QLog.e("PicMultiMsgProcessor", 2, String.format("updateMessageForLongMsg errCode:%d, uniseq:%d", Integer.valueOf(h17), Long.valueOf(c16.uniseq)));
                                                    }
                                                    z28 = true;
                                                }
                                            } else {
                                                it = it5;
                                            }
                                            i16++;
                                        } else {
                                            it = it5;
                                        }
                                        i18++;
                                        aVar2 = this;
                                        it5 = it;
                                    }
                                }
                            }
                            aVar2 = this;
                            it5 = it5;
                        }
                        aVar2 = this;
                        z19 = z28;
                        z26 = z18;
                    }
                    boolean z36 = z26;
                    if (z27) {
                        messageForMixedMsg = (MessageForMixedMsg) ((MessageForReplyText) messageRecord).getSourceMessage();
                    } else {
                        messageForMixedMsg = (MessageForMixedMsg) messageRecord;
                    }
                    if (messageForMixedMsg.msgElemList != null) {
                        z26 = z36;
                        int i19 = 0;
                        while (i19 < messageForMixedMsg.msgElemList.size()) {
                            MessageRecord messageRecord3 = messageForMixedMsg.msgElemList.get(i19);
                            if (messageRecord3 instanceof MessageForPic) {
                                if (i16 >= arrayList.size() && QLog.isColorLevel()) {
                                    QLog.e("PicMultiMsgProcessor", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
                                }
                                MessageForPic messageForPic4 = (MessageForPic) messageRecord3;
                                if (QLog.isColorLevel()) {
                                    QLog.d("PicMultiMsgProcessor", 2, str4 + i17 + "], subMsgIndex[" + i19 + str3 + i16 + "]");
                                }
                                int h18 = h(messageForPic4, arrayList.get(i16));
                                if (h18 != 0) {
                                    a(h18);
                                    if (j.this.b(h18)) {
                                        str = str3;
                                        str2 = str4;
                                        z26 = true;
                                    } else {
                                        str = str3;
                                        str2 = str4;
                                        MessageRecord c17 = j.this.f251587a.getMultiMessageProxy().c(messageForPic4, HardCodeUtil.qqStr(R.string.p6r), false);
                                        messageForMixedMsg.msgElemList.set(i19, c17);
                                        if (QLog.isColorLevel()) {
                                            QLog.e("PicMultiMsgProcessor", 2, String.format("updateMessageForMixedMsg errCode:%d, uniseq:%d", Integer.valueOf(h18), Long.valueOf(c17.uniseq)));
                                        }
                                        z28 = true;
                                    }
                                } else {
                                    str = str3;
                                    str2 = str4;
                                }
                                i16++;
                            } else {
                                str = str3;
                                str2 = str4;
                            }
                            i19++;
                            str3 = str;
                            str4 = str2;
                        }
                        aVar = this;
                        z19 = z28;
                    } else {
                        aVar = this;
                        z19 = z28;
                        z26 = z36;
                    }
                    aVar2 = aVar;
                }
                boolean z37 = z19;
                boolean z38 = z26;
                if (i16 >= arrayList.size() && QLog.isColorLevel()) {
                    QLog.e("PicMultiMsgProcessor", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
                }
                if (messageRecord instanceof MessageForReplyText) {
                    messageForPic = (MessageForPic) ((MessageForReplyText) messageRecord).getSourceMessage();
                } else {
                    messageForPic = (MessageForPic) messageRecord;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("PicMultiMsgProcessor", 2, "updateMessageForPic for MessageForPic, MsgIndex[" + i17 + "], resultIndex[" + i16 + "]");
                }
                int h19 = aVar2.h(messageForPic, arrayList.get(i16));
                if (h19 != 0) {
                    aVar2.a(h19);
                    if (j.this.b(h19)) {
                        z16 = z37;
                        z26 = true;
                        i16++;
                        z19 = z16;
                    } else {
                        MessageRecord c18 = j.this.f251587a.getMultiMessageProxy().c(messageForPic, j.f251641b, false);
                        c18.setId(messageForPic.getId());
                        c18.setStatus(messageForPic.getStatus());
                        aVar2.f251643e.set(i17, c18);
                        boolean C = j.this.f251587a.getMultiMessageProxy().C(aVar2.f251644f, c18);
                        if (QLog.isColorLevel()) {
                            z17 = true;
                            QLog.e("PicMultiMsgProcessor", 2, String.format("updateMessageForPic errCode:%d, update:%s, uniseq:%d", Integer.valueOf(h19), Boolean.valueOf(C), Long.valueOf(c18.uniseq)));
                        } else {
                            z17 = true;
                        }
                        z16 = z17;
                    }
                } else {
                    z16 = z37;
                }
                z26 = z38;
                i16++;
                z19 = z16;
            }
            boolean z39 = z26;
            if (z19) {
                if (aVar2.f251645h.isReMultiMsg) {
                    ReportController.n(j.this.f251587a, "CliOper", "", "", "0X800662B", "0X800662B", 0, 1, 0, "", "", "", "");
                }
                if (QLog.isColorLevel()) {
                    QLog.e("PicMultiMsgProcessor", 2, "requestUploadPics isPicMsgModify");
                }
                j.this.f251587a.getProxyManager().k().O(aVar2.f251643e, null);
            }
            if (aVar2.f251645h.isReMultiMsg) {
                ReportController.n(j.this.f251587a, "CliOper", "", "", "0X800662A", "0X800662A", 0, 1, 0, "", "", "", "");
            }
            return z39;
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
            boolean z17;
            boolean z18;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) arrayList);
                return;
            }
            if (i3 == 0 && arrayList != null && arrayList.size() > 0) {
                QLog.i("PicMultiMsgProcessor", 1, "onForwardMultiMsgPicsUpload success[" + arrayList.size() + "]");
                z17 = j(arrayList);
                if (QLog.isColorLevel()) {
                    QLog.d("PicMultiMsgProcessor", 2, "updateMsgRecords done, goto onPackAndSendMsg");
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("totalCount", String.valueOf(arrayList.size()));
                ArrayList<Integer> arrayList2 = this.f251642d;
                if (arrayList2 != null) {
                    hashMap.put("errCount", String.valueOf(arrayList2.size()));
                    hashMap.put("errCodeStr", Arrays.asList(this.f251642d).toString());
                    hashMap.put("errCode", String.valueOf(this.f251642d.get(0)));
                } else {
                    hashMap.put("errCount", "0");
                    hashMap.put("errCode", "0");
                }
                StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
                if (this.f251642d == null) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                statisticCollector.collectPerformance(null, "MultiMsgPicSendResult", z18, 0L, arrayList.size(), hashMap, null);
            } else {
                QLog.w("PicMultiMsgProcessor", 1, "onForwardMultiMsgPicsUpload failed");
                StatisticCollector statisticCollector2 = StatisticCollector.getInstance(BaseApplication.getContext());
                if (i3 == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                statisticCollector2.collectPerformance(null, "MultiMsgPicSendFail", z16, 0L, 0L, null, null);
                z17 = true;
            }
            if (z17) {
                this.f251646i.c(1, 1, this.f251647m);
            } else {
                this.f251646i.c(0, 1, this.f251647m);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73189);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f251641b = HardCodeUtil.qqStr(R.string.p6t);
        }
    }

    public j(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        }
    }

    private void d(HashMap<String, ArrayList<MessageRecord>> hashMap, MessageRecord messageRecord, ArrayList<MessageRecord> arrayList, ArrayList<com.tencent.mobileqq.pic.l> arrayList2, int i3, h hVar, d dVar) {
        p createPicReq = ((IPicBus) QRoute.api(IPicBus.class)).createPicReq(8, 7);
        createPicReq.c(arrayList2);
        createPicReq.g(new a(arrayList, hashMap, messageRecord, dVar, hVar));
        ((IPicBus) QRoute.api(IPicBus.class)).launch(createPicReq);
    }

    private void e(h hVar, MessageRecord messageRecord, ArrayList<com.tencent.mobileqq.pic.l> arrayList, ArrayList<MessageRecord> arrayList2, int i3, String str, String str2, int i16) {
        MessageRecord sourceMessage;
        int i17;
        StructMsgForImageShare structMsgForImageShare;
        com.tencent.mobileqq.structmsg.view.e firstImageElement;
        ArrayList<com.tencent.mobileqq.pic.l> createForwardPicInfos;
        if (messageRecord instanceof MessageForPic) {
            com.tencent.mobileqq.pic.l createForwardPicInfo = ((IPicBus) QRoute.api(IPicBus.class)).createForwardPicInfo(7, (MessageForPic) messageRecord, i3, str, str2, this.f251587a.getAccount());
            if (createForwardPicInfo != null) {
                arrayList.add(createForwardPicInfo);
                arrayList2.add(messageRecord);
                return;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.e("PicMultiMsgProcessor", 2, "[requestSendMultiMsg]createForwardPicInfo from MessageForPic failed");
                    return;
                }
                return;
            }
        }
        if (messageRecord instanceof MessageForMixedMsg) {
            ArrayList<com.tencent.mobileqq.pic.l> createForwardPicInfos2 = ((IPicBus) QRoute.api(IPicBus.class)).createForwardPicInfos(7, (MessageForMixedMsg) messageRecord, i3, str, str2, this.f251587a.getAccount());
            if (createForwardPicInfos2 != null) {
                arrayList.addAll(createForwardPicInfos2);
                arrayList2.add(messageRecord);
                return;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.e("PicMultiMsgProcessor", 2, "[requestSendMultiMsg]createForwardPicInfos from MessageForMixedMsg failed");
                    return;
                }
                return;
            }
        }
        if (messageRecord.msgtype == -1036) {
            for (MessageRecord messageRecord2 : ((MessageForLongMsg) messageRecord).longMsgFragmentList) {
                if ((messageRecord2 instanceof MessageForMixedMsg) && (createForwardPicInfos = ((IPicBus) QRoute.api(IPicBus.class)).createForwardPicInfos(7, (MessageForMixedMsg) messageRecord2, i3, str, str2, this.f251587a.getAccount())) != null) {
                    arrayList.addAll(createForwardPicInfos);
                    arrayList2.add(messageRecord);
                }
            }
            return;
        }
        if (messageRecord instanceof MessageForStructing) {
            AbsStructMsg absStructMsg = ((MessageForStructing) messageRecord).structingMsg;
            if (absStructMsg != null && (absStructMsg instanceof StructMsgForImageShare) && (firstImageElement = (structMsgForImageShare = (StructMsgForImageShare) absStructMsg).getFirstImageElement()) != null) {
                if (firstImageElement.f290638c1 == null) {
                    if (firstImageElement.f290637b1 == null) {
                        firstImageElement.f290637b1 = structMsgForImageShare;
                    }
                    firstImageElement.f290638c1 = firstImageElement.m();
                }
                com.tencent.mobileqq.pic.l createForwardPicInfo2 = ((IPicBus) QRoute.api(IPicBus.class)).createForwardPicInfo(7, firstImageElement.f290638c1, i16, str, str2, this.f251587a.getAccount());
                if (createForwardPicInfo2 != null) {
                    arrayList.add(createForwardPicInfo2);
                    arrayList2.add(messageRecord);
                    return;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.e("PicMultiMsgProcessor", 2, "[requestSendMultiMsg]createForwardPicInfo from MessageForPic failed");
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if ((messageRecord instanceof MessageForReplyText) && (sourceMessage = ((MessageForReplyText) messageRecord).getSourceMessage()) != null) {
            if ((sourceMessage instanceof MessageForPic) || (sourceMessage instanceof MessageForMixedMsg) || (sourceMessage instanceof MessageForStructing) || sourceMessage.msgtype == -1036) {
                if (QLog.isColorLevel()) {
                    QLog.e("PicMultiMsgProcessor", 2, "[requestSendMultiMsg] MessageForReplyText add to list");
                }
                if (hVar.f251625i == 2) {
                    i17 = 0;
                } else {
                    i17 = sourceMessage.istroop;
                }
                e(hVar, sourceMessage, arrayList, arrayList2, i17, sourceMessage.selfuin, sourceMessage.frienduin, sourceMessage.istroop);
            }
        }
    }

    @Override // com.tencent.mobileqq.multimsg.a, com.tencent.mobileqq.multimsg.c
    public void a(h hVar, HashMap<String, ArrayList<MessageRecord>> hashMap, d dVar) {
        j jVar;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, hVar, hashMap, dVar);
            return;
        }
        ArrayList<com.tencent.mobileqq.pic.l> arrayList = new ArrayList<>();
        ArrayList<MessageRecord> arrayList2 = new ArrayList<>();
        if (hVar.f251625i == 2) {
            jVar = this;
            i3 = 0;
        } else {
            jVar = this;
            i3 = hVar.f251617a.f179555d;
        }
        String account = jVar.f251587a.getAccount();
        SessionInfo sessionInfo = hVar.f251617a;
        String str = sessionInfo.f179557e;
        int i16 = sessionInfo.f179555d;
        Iterator<String> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            Iterator<MessageRecord> it5 = hashMap.get(it.next()).iterator();
            while (it5.hasNext()) {
                int i17 = i16;
                e(hVar, it5.next(), arrayList, arrayList2, i3, account, str, i17);
                i16 = i17;
                str = str;
            }
        }
        if (arrayList.size() > 0 && arrayList2.size() > 0) {
            QLog.i("PicMultiMsgProcessor", 1, "[requestSendMultiMsg]Upload pictures, count is [" + arrayList.size() + "], goto requestUploadPics");
            d(hashMap, hVar.f251621e, arrayList2, arrayList, hVar.f251625i, hVar, dVar);
            return;
        }
        dVar.c(0, 1, hVar);
    }
}
