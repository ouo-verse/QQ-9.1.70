package com.tencent.mobileqq.guild.feed.util;

import androidx.core.internal.view.SupportMenu;
import com.tencent.guild.api.msg.impl.GuildMsgElementApiImpl;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype33;
import tencent.im.msg.im_msg_body$CommonElem;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes13.dex */
public class o {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class a extends com.tencent.mobileqq.service.message.y {
        a(AppRuntime appRuntime, StringBuilder sb5, long j3, com.tencent.mobileqq.troop.data.c cVar, ArrayList<AtTroopMemberInfo> arrayList, AtTroopMemberInfo atTroopMemberInfo, AtTroopMemberInfo atTroopMemberInfo2, byte[] bArr, StringBuilder sb6, boolean z16, im_msg_body$Elem im_msg_body_elem, long j16) {
            super(appRuntime, sb5, j3, cVar, arrayList, atTroopMemberInfo, atTroopMemberInfo2, bArr, sb6, z16, im_msg_body_elem, j16);
        }

        private boolean k() {
            int i3;
            if (QLog.isColorLevel()) {
                this.f286352a.append("elemType: bankcode_ctrlinfo;\n");
            }
            byte[] byteArray = this.f286362k.bankcode_ctrl_info.get().toByteArray();
            byte b16 = byteArray[0];
            byte b17 = byteArray[byteArray.length - 1];
            if (b16 == 40 && b17 == 41) {
                if (ByteBuffer.wrap(byteArray, 2, 2).getShort() != 29786 || (i3 = ByteBuffer.wrap(byteArray, 4, 2).getShort()) <= 0) {
                    return true;
                }
                byte[] bArr = new byte[i3];
                this.f286359h = bArr;
                System.arraycopy(byteArray, 6, bArr, 0, i3);
                return false;
            }
            if (QLog.isColorLevel()) {
                this.f286352a.append("elemType: bankcode_ctrlinfo buffer error;\n");
            }
            return true;
        }

        private void l() {
            int convertToLocal;
            if (QLog.isColorLevel()) {
                this.f286352a.append("elemType:Face;\n");
            }
            if (!this.f286362k.f435954face.get().index.has() || (convertToLocal = QQSysFaceUtil.convertToLocal(this.f286362k.f435954face.get().index.get())) < 0) {
                return;
            }
            this.f286360i.append((char) 20);
            this.f286360i.append((char) convertToLocal);
        }

        private void m() {
            if (QLog.isColorLevel()) {
                this.f286352a.append("elemType:NewSysFaceMsg;\n");
            }
            this.f286360i.append(o(this.f286362k.common_elem.get()));
        }

        private void n() {
            if (QLog.isColorLevel()) {
                this.f286352a.append("elemType:OnlineImage;\n");
            }
            this.f286360i.append(GuildMsgElementApiImpl.DESC_ELEMENT_PIC);
        }

        private String o(im_msg_body$CommonElem im_msg_body_commonelem) {
            if (im_msg_body_commonelem == null || !im_msg_body_commonelem.bytes_pb_elem.has()) {
                return "";
            }
            try {
                hummer_commelem$MsgElemInfo_servtype33 hummer_commelem_msgeleminfo_servtype33 = new hummer_commelem$MsgElemInfo_servtype33();
                hummer_commelem_msgeleminfo_servtype33.mergeFrom(im_msg_body_commonelem.bytes_pb_elem.get().toByteArray());
                if (hummer_commelem_msgeleminfo_servtype33.bytes_text.has()) {
                    hummer_commelem_msgeleminfo_servtype33.bytes_text.get().toStringUtf8();
                }
                int convertToLocal = QQSysFaceUtil.convertToLocal(hummer_commelem_msgeleminfo_servtype33.uint32_index.get());
                if (convertToLocal < 0) {
                    return "";
                }
                return QQSysFaceUtil.getFaceString(convertToLocal);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                return "";
            }
        }

        private void p() {
            if (QLog.isColorLevel()) {
                this.f286352a.append("elemType:small_emoji;\n");
            }
            if (!this.f286362k.small_emoji.get().packIdSum.has()) {
                return;
            }
            int i3 = (this.f286362k.small_emoji.get().packIdSum.get() & SupportMenu.CATEGORY_MASK) >> 16;
            int i16 = this.f286362k.small_emoji.get().packIdSum.get() & 65535;
            char[] k3 = com.tencent.mobileqq.emosm.e.k(i3, i16);
            if (this.f286362k.small_emoji.get().imageType.has() && (65535 & this.f286362k.small_emoji.get().imageType.get()) == 2) {
                k3[3] = '\u01ff';
                if (QLog.isColorLevel()) {
                    QLog.d("GuildAnnounceFeedPbParser", 2, "get apng epid = " + i3 + " eid = " + i16);
                }
            }
            this.f286360i.append((char) 20);
            this.f286360i.append(k3[3]);
            this.f286360i.append(k3[2]);
            this.f286360i.append(k3[1]);
            this.f286360i.append(k3[0]);
            this.f286361j = true;
        }

        @Override // com.tencent.mobileqq.service.message.y
        protected void d() {
            if (this.f286362k.f435954face.has()) {
                l();
                return;
            }
            if (this.f286362k.small_emoji.has()) {
                p();
                return;
            }
            if (has()) {
                n();
                return;
            }
            if (this.f286362k.bankcode_ctrl_info.has()) {
                k();
            } else if (this.f286362k.common_elem.has() && 33 == this.f286362k.common_elem.uint32_service_type.get()) {
                m();
            }
        }
    }

    private static com.tencent.mobileqq.service.message.y a(StringBuilder sb5, long j3, com.tencent.mobileqq.troop.data.c cVar, ArrayList<AtTroopMemberInfo> arrayList, AtTroopMemberInfo atTroopMemberInfo, AtTroopMemberInfo atTroopMemberInfo2, byte[] bArr, StringBuilder sb6, boolean z16, im_msg_body$Elem im_msg_body_elem, long j16) {
        return new a(((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).appInterface(), sb5, j3, cVar, arrayList, atTroopMemberInfo, atTroopMemberInfo2, bArr, sb6, z16, im_msg_body_elem, j16);
    }

    private static im_msg_body$RichText b(byte[] bArr) {
        try {
            return new im_msg_body$RichText().mergeFrom(bArr);
        } catch (Exception e16) {
            QLog.w("GuildAnnounceFeedPbParser", 1, "parsePb handleRichText: exception occurs while parsing the pb bytes.", e16);
            return null;
        }
    }

    private static ArrayList<AtTroopMemberInfo> c(com.tencent.mobileqq.service.message.aa aaVar, AtTroopMemberInfo atTroopMemberInfo, AtTroopMemberInfo atTroopMemberInfo2, byte[] bArr) {
        aaVar.f286172b = atTroopMemberInfo2;
        d(aaVar, atTroopMemberInfo, bArr);
        ArrayList<Object> arrayList = aaVar.f286171a;
        ArrayList<AtTroopMemberInfo> arrayList2 = new ArrayList<>(arrayList.size());
        Iterator<Object> it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof AtTroopMemberInfo) {
                arrayList2.add((AtTroopMemberInfo) next);
            }
        }
        return arrayList2;
    }

    private static void d(com.tencent.mobileqq.service.message.aa aaVar, AtTroopMemberInfo atTroopMemberInfo, byte[] bArr) {
        ArrayList<Object> arrayList = aaVar.f286171a;
        if (arrayList != null) {
            if (atTroopMemberInfo != null || bArr != null) {
                if (arrayList.isEmpty()) {
                    arrayList.add(atTroopMemberInfo);
                    arrayList.add(bArr);
                    return;
                }
                if (arrayList.size() != 2) {
                    return;
                }
                if (arrayList.get(0) != null && arrayList.get(1) != null) {
                    return;
                }
                Object obj = atTroopMemberInfo;
                if (arrayList.get(0) != null) {
                    obj = arrayList.get(0);
                }
                Object obj2 = bArr;
                if (arrayList.get(1) != null) {
                    obj2 = arrayList.get(1);
                }
                arrayList.clear();
                arrayList.add(obj);
                arrayList.add(obj2);
            }
        }
    }

    public static String e(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            im_msg_body$RichText b16 = b(bArr);
            if (b16 == null) {
                return "";
            }
            if (QLog.isColorLevel()) {
                QLog.i("GuildAnnounceFeedPbParser", 2, "convertPbToString:\n");
                QLog.i("GuildAnnounceFeedPbParser", 2, GuildDebugUtils.a(b16));
            }
            List<im_msg_body$Elem> list = b16.elems.get();
            com.tencent.mobileqq.service.message.aa aaVar = new com.tencent.mobileqq.service.message.aa();
            AtTroopMemberInfo atTroopMemberInfo = aaVar.f286172b;
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            Iterator<im_msg_body$Elem> it = list.iterator();
            AtTroopMemberInfo atTroopMemberInfo2 = atTroopMemberInfo;
            AtTroopMemberInfo atTroopMemberInfo3 = null;
            byte[] bArr2 = null;
            boolean z16 = false;
            while (it.hasNext()) {
                com.tencent.mobileqq.service.message.y i3 = a(sb6, 0L, null, new ArrayList(), atTroopMemberInfo3, atTroopMemberInfo2, bArr2, sb5, z16, it.next(), 0L).i();
                atTroopMemberInfo3 = i3.g();
                atTroopMemberInfo2 = i3.h();
                bArr2 = i3.e();
                z16 = i3.j();
            }
            if (QLog.isColorLevel()) {
                ArrayList<AtTroopMemberInfo> c16 = c(aaVar, atTroopMemberInfo3, atTroopMemberInfo2, bArr2);
                QLog.i("GuildAnnounceFeedPbParser", 2, "msg: " + sb5.toString());
                QLog.i("GuildAnnounceFeedPbParser", 2, "atInfoTempList: " + c16);
                QLog.i("GuildAnnounceFeedPbParser", 2, "logBuilder: " + sb6.toString());
            }
            return com.tencent.mobileqq.guild.util.az.a(sb5.toString());
        }
        QLog.w("GuildAnnounceFeedPbParser", 1, "parsePb pbArr length is 0!");
        return "";
    }
}
