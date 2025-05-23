package com.tencent.mobileqq.guild.message;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.af;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.ah;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.aq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import java.util.ArrayList;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.hummer.resv.videoFile$ResvAttr;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes33.dex */
public class o extends af {
    private void d(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar) {
        new com.tencent.mobileqq.service.message.o().Q0(list, list2, sb5, msg_comm_msg, cVar, false);
    }

    private void e(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar) {
        new com.tencent.mobileqq.service.message.o().n(list, list2, sb5, msg_comm_msg, cVar);
    }

    private void f(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar) {
        new aq().a(list, msg_comm_msg, list2, sb5, false, false, cVar, null, null);
    }

    private void h(List<MessageRecord> list, msg_comm$Msg msg_comm_msg, List<MessageRecord> list2, byte[] bArr, com.tencent.mobileqq.troop.data.c cVar, AtTroopMemberInfo atTroopMemberInfo) {
        if (m(msg_comm_msg, cVar)) {
            bArr = null;
        }
        MessageRecord G = com.tencent.mobileqq.service.message.p.G(list, bArr, cVar);
        list2.add(G);
        ((MessageForMixedMsg) G).mAtInfo = atTroopMemberInfo;
        list.clear();
    }

    private QQAppInterface i() {
        return (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
    }

    private boolean j(List<im_msg_body$Elem> list) {
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.video_file.has()) {
                videoFile$ResvAttr videofile_resvattr = new videoFile$ResvAttr();
                try {
                    videofile_resvattr.mergeFrom(im_msg_body_elem.video_file.bytes_pb_reserve.get().toByteArray());
                    if (videofile_resvattr.uint32_embed_video.has()) {
                        return videofile_resvattr.uint32_embed_video.get() != 0;
                    }
                    return false;
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                    return false;
                }
            }
        }
        return false;
    }

    private boolean l(im_msg_body$Elem im_msg_body_elem) {
        return im_msg_body_elem.custom_face.has() || im_msg_body_elem.not_online_image.has();
    }

    private boolean m(msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar) {
        if (!msg_comm_msg.msg_head.from_uin.has()) {
            return false;
        }
        long j3 = msg_comm_msg.msg_head.from_uin.get();
        if (TextUtils.equals(i().getCurrentAccountUin(), Long.toString(j3))) {
            return true;
        }
        if (cVar == null || cVar.f294892b != 10014) {
            return false;
        }
        return TextUtils.equals(((IGPSService) i().getRuntimeService(IGPSService.class, "")).getSelfTinyId(), Long.toString(j3));
    }

    private boolean n(im_msg_body$Elem im_msg_body_elem) {
        return ah.d(im_msg_body_elem).booleanValue();
    }

    private boolean o(im_msg_body$Elem im_msg_body_elem) {
        return im_msg_body_elem.video_file.has();
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.pbelement.af, com.tencent.imcore.message.core.codec.a
    public boolean a(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, List<MessageRecord> list2, StringBuilder sb5, boolean z16, boolean z17, com.tencent.mobileqq.troop.data.c cVar, com.tencent.mobileqq.service.message.ab abVar, com.tencent.mobileqq.service.message.a aVar) {
        boolean z18 = false;
        if (!k(aVar)) {
            return false;
        }
        boolean z19 = false;
        boolean z26 = false;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (!z19 && n(im_msg_body_elem)) {
                z19 = true;
            }
            if (!z26 && o(im_msg_body_elem)) {
                z26 = true;
            }
            if (!z18 && l(im_msg_body_elem)) {
                z18 = true;
            }
        }
        if (z18 && !z26) {
            d(list, list2, sb5, msg_comm_msg, cVar);
        } else if (z26 && !z18) {
            if (z19 && j(list)) {
                g(list, list2, sb5, msg_comm_msg, cVar);
            } else {
                f(list, list2, sb5, msg_comm_msg, cVar);
            }
        } else {
            e(list, list2, sb5, msg_comm_msg, cVar);
        }
        return true;
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public boolean b(im_msg_body$Elem im_msg_body_elem) {
        return im_msg_body_elem.video_file.has() || im_msg_body_elem.not_online_image.has() || im_msg_body_elem.custom_face.has();
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.pbelement.af, com.tencent.imcore.message.core.codec.a
    public int getPriority() {
        return 1001;
    }

    private boolean k(com.tencent.mobileqq.service.message.a aVar) {
        return aVar != null && aVar.f286163r == 10014;
    }

    private void g(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar) {
        byte[] bArr;
        AtTroopMemberInfo atTroopMemberInfo;
        List<MessageRecord> list3;
        int i3;
        com.tencent.mobileqq.service.message.aa aaVar;
        com.tencent.mobileqq.troop.data.c cVar2;
        List<MessageRecord> list4;
        int i16;
        int i17;
        List<MessageRecord> list5;
        com.tencent.mobileqq.troop.data.c cVar3 = cVar;
        com.tencent.mobileqq.service.message.aa aaVar2 = new com.tencent.mobileqq.service.message.aa();
        StringBuilder sb6 = new StringBuilder("");
        List<MessageRecord> arrayList = new ArrayList<>();
        int i18 = 2;
        ArrayList<AtTroopMemberInfo> arrayList2 = new ArrayList<>(2);
        int i19 = 0;
        StringBuilder sb7 = sb6;
        loop0: while (true) {
            int i26 = i19;
            for (im_msg_body$Elem im_msg_body_elem : list) {
                if (n(im_msg_body_elem)) {
                    if (i26 != 0) {
                        break;
                    }
                    int i27 = im_msg_body_elem.small_emoji.has() ? 1 : i26;
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(im_msg_body_elem);
                    list3 = arrayList;
                    aaVar = aaVar2;
                    sb7 = new com.tencent.mobileqq.service.message.o().t(sb7, arrayList3, sb5, msg_comm_msg.msg_head.msg_seq.get(), cVar, aaVar, arrayList2, msg_comm_msg.msg_head.msg_time.get());
                    i3 = i19;
                    cVar2 = cVar3;
                    i26 = i27;
                } else {
                    list3 = arrayList;
                    i3 = i19;
                    if (im_msg_body_elem.video_file.has()) {
                        if (sb7.length() > 0) {
                            MessageRecord messageRecord = (MessageForText) com.tencent.mobileqq.service.message.q.d(-1000);
                            messageRecord.msgtype = -1000;
                            messageRecord.f203106msg = sb7.toString();
                            messageRecord.atInfoList = arrayList2;
                            i16 = 2;
                            arrayList2 = new ArrayList<>(2);
                            list4 = list3;
                            list4.add(messageRecord);
                            sb7.delete(i3, sb7.length());
                        } else {
                            list4 = list3;
                            i16 = 2;
                        }
                        ArrayList<AtTroopMemberInfo> arrayList4 = arrayList2;
                        List<im_msg_body$Elem> arrayList5 = new ArrayList<>();
                        arrayList5.add(im_msg_body_elem);
                        i17 = i16;
                        list5 = list4;
                        aaVar = aaVar2;
                        cVar2 = cVar3;
                        f(arrayList5, list4, sb5, msg_comm_msg, cVar);
                        arrayList2 = arrayList4;
                        i18 = i17;
                        arrayList = list5;
                        aaVar2 = aaVar;
                        cVar3 = cVar2;
                        i19 = i3;
                    } else {
                        aaVar = aaVar2;
                        cVar2 = cVar3;
                    }
                }
                list5 = list3;
                i17 = 2;
                i18 = i17;
                arrayList = list5;
                aaVar2 = aaVar;
                cVar3 = cVar2;
                i19 = i3;
            }
        }
        int i28 = i18;
        List<MessageRecord> list6 = arrayList;
        com.tencent.mobileqq.service.message.aa aaVar3 = aaVar2;
        int i29 = i19;
        com.tencent.mobileqq.troop.data.c cVar4 = cVar3;
        if (sb7.length() > 0) {
            MessageForText messageForText = (MessageForText) com.tencent.mobileqq.service.message.q.d(-1000);
            messageForText.msgtype = -1000;
            messageForText.f203106msg = sb7.toString();
            messageForText.atInfoList = arrayList2;
            if (cVar4 != null) {
                com.tencent.mobileqq.troop.text.a.n(cVar4.f294892b, arrayList2, messageForText);
            }
            list6.add(messageForText);
            sb7.delete(i29, sb7.length());
        }
        ArrayList<Object> arrayList6 = aaVar3.f286171a;
        if (arrayList6 == null || arrayList6.size() != i28) {
            bArr = null;
            atTroopMemberInfo = null;
        } else {
            AtTroopMemberInfo atTroopMemberInfo2 = arrayList6.get(i29) != null ? (AtTroopMemberInfo) arrayList6.get(i29) : null;
            bArr = arrayList6.get(1) != null ? (byte[]) arrayList6.get(1) : null;
            atTroopMemberInfo = atTroopMemberInfo2;
        }
        h(list6, msg_comm_msg, list2, bArr, cVar, atTroopMemberInfo);
    }
}
