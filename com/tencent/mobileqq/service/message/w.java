package com.tencent.mobileqq.service.message;

import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBPrimitiveField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.service.message.api.IQMessageProtoCodecService;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.DeprecatedMethodInvokeReport;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import msf.msgcomm.msg_comm$ContentHead;
import msf.msgcomm.msg_comm$Msg;
import msf.msgsvc.msg_svc$PbDeleteMsgReq;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import msf.msgsvc.msg_svc$RoutingHead;
import msf.msgsvc.msg_svc$Trans0x211;
import msf.msgsvc.msg_svc$TransMsg;
import org.slf4j.Marker;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.hummer.resv1.TextMsgExtPb$ChannelInfo;
import tencent.im.msg.hummer.resv1.TextMsgExtPb$ResvAttr;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$GeneralFlags;
import tencent.im.msg.im_msg_body$MsgBody;
import tencent.im.msg.im_msg_body$RichText;
import tencent.im.msg.im_msg_body$Text;

/* compiled from: P */
/* loaded from: classes18.dex */
public class w {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Object f286341a;

    /* renamed from: b, reason: collision with root package name */
    private static final Comparator<? super com.tencent.imcore.message.core.codec.a> f286342b;

    /* renamed from: c, reason: collision with root package name */
    @ConfigInject(configPath = "IMCore/src/main/resources/Inject_IMCoreMessageProtoCodec.yml", version = 3)
    public static ArrayList<Class<? extends v>> f286343c;

    /* renamed from: d, reason: collision with root package name */
    private static v f286344d;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Comparator<com.tencent.imcore.message.core.codec.a> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.imcore.message.core.codec.a aVar, com.tencent.imcore.message.core.codec.a aVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, (Object) aVar2)).intValue();
            }
            return aVar2.getPriority() - aVar.getPriority();
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public im_msg_body$RichText f286345a;

        /* renamed from: b, reason: collision with root package name */
        public String f286346b;

        /* renamed from: c, reason: collision with root package name */
        private ArrayList<AtTroopMemberInfo> f286347c;

        /* renamed from: d, reason: collision with root package name */
        public int f286348d;

        /* renamed from: e, reason: collision with root package name */
        private int f286349e;

        /* renamed from: f, reason: collision with root package name */
        public StringBuilder f286350f;

        /* renamed from: g, reason: collision with root package name */
        public int f286351g;

        b(im_msg_body$RichText im_msg_body_richtext, String str, ArrayList<AtTroopMemberInfo> arrayList, int i3, int i16, StringBuilder sb5, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, im_msg_body_richtext, str, arrayList, Integer.valueOf(i3), Integer.valueOf(i16), sb5, Integer.valueOf(i17));
                return;
            }
            this.f286345a = im_msg_body_richtext;
            this.f286346b = str;
            this.f286347c = arrayList;
            this.f286348d = i3;
            this.f286349e = i16;
            this.f286350f = sb5;
            this.f286351g = i17;
        }

        private static void a(AtTroopMemberInfo atTroopMemberInfo, im_msg_body$Elem im_msg_body_elem) {
            if (atTroopMemberInfo != null) {
                if (!atTroopMemberInfo.isResvAttr) {
                    byte[] bArr = new byte[13];
                    PkgTools.word2Byte(bArr, 0, (short) 1);
                    atTroopMemberInfo.writeTo(bArr, 2);
                    im_msg_body_elem.text.attr_6_buf.set(ByteStringMicro.copyFrom(bArr));
                    return;
                }
                TextMsgExtPb$ResvAttr textMsgExtPb$ResvAttr = new TextMsgExtPb$ResvAttr();
                byte b16 = atTroopMemberInfo.flag;
                if (b16 == 2) {
                    textMsgExtPb$ResvAttr.at_type.set(4);
                    TextMsgExtPb$ChannelInfo textMsgExtPb$ChannelInfo = new TextMsgExtPb$ChannelInfo();
                    textMsgExtPb$ChannelInfo.guild_id.set(0L);
                    textMsgExtPb$ChannelInfo.channel_id.set(atTroopMemberInfo.channelId);
                    textMsgExtPb$ResvAttr.at_channel_info.set(textMsgExtPb$ChannelInfo);
                } else if (b16 == 1) {
                    textMsgExtPb$ResvAttr.at_type.set(1);
                } else {
                    textMsgExtPb$ResvAttr.at_type.set(2);
                }
                textMsgExtPb$ResvAttr.at_member_tinyid.set(atTroopMemberInfo.uin);
                im_msg_body_elem.text.bytes_pb_reserve.set(ByteStringMicro.copyFrom(textMsgExtPb$ResvAttr.toByteArray()));
            }
        }

        @Nullable
        private AtTroopMemberInfo c() {
            if (this.f286347c == null) {
                return null;
            }
            while (this.f286349e < this.f286347c.size()) {
                AtTroopMemberInfo atTroopMemberInfo = this.f286347c.get(this.f286349e);
                if (atTroopMemberInfo != null && atTroopMemberInfo.isValid()) {
                    return atTroopMemberInfo;
                }
                this.f286349e++;
            }
            return null;
        }

        private void f(AtTroopMemberInfo atTroopMemberInfo) {
            if (this.f286350f.length() > 0) {
                w.j(this.f286345a, this.f286350f.toString());
                StringBuilder sb5 = this.f286350f;
                sb5.delete(0, sb5.length());
                this.f286348d++;
            }
            String str = this.f286346b;
            short s16 = atTroopMemberInfo.startPos;
            im_msg_body$Elem j3 = w.j(this.f286345a, str.substring(s16, atTroopMemberInfo.textLen + s16));
            this.f286349e++;
            short s17 = atTroopMemberInfo.startPos;
            atTroopMemberInfo.startPos = (short) 0;
            a(atTroopMemberInfo, j3);
            atTroopMemberInfo.startPos = s17;
            StringBuilder sb6 = this.f286350f;
            sb6.delete(0, sb6.length());
            this.f286348d++;
            this.f286351g += atTroopMemberInfo.textLen - 1;
        }

        public int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f286349e;
        }

        public int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f286348d;
        }

        public int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.f286351g;
        }

        public b g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (b) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            AtTroopMemberInfo c16 = c();
            if (c16 != null && c16.startPos <= this.f286351g) {
                f(c16);
            } else if (((IQMessageProtoCodecService) QRoute.api(IQMessageProtoCodecService.class)).needProcessEmotion(this.f286346b, this.f286351g)) {
                ((IQMessageProtoCodecService) QRoute.api(IQMessageProtoCodecService.class)).processEmotion(this);
            } else {
                this.f286350f.append(this.f286346b.charAt(this.f286351g));
            }
            return this;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45152);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f286341a = new Object();
        f286342b = new a();
        ArrayList<Class<? extends v>> arrayList = new ArrayList<>();
        f286343c = arrayList;
        arrayList.add(o.class);
    }

    public static int A(int i3, AppInterface appInterface) {
        return ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "all")).getRoutingType(i3);
    }

    private static void a(List<im_msg_body$Elem> list, List<com.tencent.imcore.message.core.codec.a> list2, List<com.tencent.imcore.message.core.codec.a> list3) {
        for (im_msg_body$Elem im_msg_body_elem : list) {
            for (com.tencent.imcore.message.core.codec.a aVar : list3) {
                if (aVar != null && aVar.b(im_msg_body_elem)) {
                    list2.add(aVar);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00dc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static msg_svc$PbSendMsgReq b(AppInterface appInterface, int i3, String str, ac acVar, long j3, int i16) {
        long length;
        boolean z16;
        byte[] bArr = null;
        if (acVar == null) {
            return null;
        }
        short s16 = (short) j3;
        int i17 = 65535 & s16;
        if (i3 != 9 && i3 != 13) {
            length = 72057594037927936L | i16;
        } else {
            length = (acVar.f286178b.length << 16) | 166 | 144115188075855872L;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageProtoCodec", 2, "<PbSendMsg><S>--->createPbSendMsgReq: routingType:" + i3 + ",toUin:" + str + ",msgUid:" + length + ",msgSeq:" + j3 + ",uint32Seq:" + i17 + ",shortSeq:" + ((int) s16) + ",randomNum:" + i16 + ",msgContext:" + acVar);
        }
        e eVar = (e) appInterface.getMsgCache();
        msg_svc$RoutingHead msg_svc_routinghead = new msg_svc$RoutingHead();
        if (i3 != 9) {
            if (i3 != 13) {
                z16 = false;
                if (z16) {
                    return null;
                }
                msg_comm$ContentHead msg_comm_contenthead = new msg_comm$ContentHead();
                msg_comm_contenthead.pkg_num.set(1);
                msg_comm_contenthead.div_seq.set(s16);
                msg_comm_contenthead.pkg_index.set(0);
                im_msg_body$MsgBody im_msg_body_msgbody = new im_msg_body$MsgBody();
                im_msg_body_msgbody.msg_content.set(ByteStringMicro.copyFrom(acVar.f286178b));
                msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq = new msg_svc$PbSendMsgReq();
                msg_svc_pbsendmsgreq.routing_head.set(msg_svc_routinghead);
                msg_svc_pbsendmsgreq.content_head.set(msg_comm_contenthead);
                msg_svc_pbsendmsgreq.msg_body.set(im_msg_body_msgbody);
                msg_svc_pbsendmsgreq.msg_seq.set(i17);
                msg_svc_pbsendmsgreq.msg_rand.set(i16);
                if (eVar != null) {
                    bArr = eVar.F0();
                }
                if (bArr != null) {
                    msg_svc_pbsendmsgreq.sync_cookie.set(ByteStringMicro.copyFrom(bArr));
                }
                return msg_svc_pbsendmsgreq;
            }
            msg_svc$Trans0x211 msg_svc_trans0x211 = new msg_svc$Trans0x211();
            msg_svc_trans0x211.cc_cmd.set(acVar.f286177a);
            msg_svc_trans0x211.to_uin.set(com.tencent.av.utils.i.g(str.replace(Marker.ANY_NON_NULL_MARKER, "")));
            msg_svc_routinghead.trans_0x211.set(msg_svc_trans0x211);
        } else {
            msg_svc$TransMsg msg_svc_transmsg = new msg_svc$TransMsg();
            msg_svc_transmsg.c2c_cmd.set(acVar.f286177a);
            msg_svc_transmsg.to_uin.set(Long.valueOf(str).longValue());
            msg_svc_routinghead.trans_msg.set(msg_svc_transmsg);
        }
        z16 = true;
        if (z16) {
        }
    }

    public static msg_svc$PbSendMsgReq c(AppInterface appInterface, MessageRecord messageRecord, im_msg_body$RichText im_msg_body_richtext, int i3) {
        int A = A(messageRecord.istroop, appInterface);
        byte[] bArr = null;
        if (A == 9 || A == 13) {
            return null;
        }
        int i16 = ((short) messageRecord.msgseq) & 65535;
        int n3 = n(messageRecord.msgUid);
        e eVar = (e) appInterface.getMsgCache();
        msg_svc$RoutingHead msg_svc_routinghead = new msg_svc$RoutingHead();
        if (!y(appInterface, messageRecord, msg_svc_routinghead)) {
            return null;
        }
        msg_comm$ContentHead msg_comm_contenthead = new msg_comm$ContentHead();
        msg_comm_contenthead.pkg_num.set(messageRecord.longMsgCount);
        msg_comm_contenthead.div_seq.set(messageRecord.longMsgId);
        msg_comm_contenthead.pkg_index.set(messageRecord.longMsgIndex);
        im_msg_body$MsgBody im_msg_body_msgbody = new im_msg_body$MsgBody();
        im_msg_body_msgbody.rich_text.set(im_msg_body_richtext);
        msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq = new msg_svc$PbSendMsgReq();
        msg_svc_pbsendmsgreq.routing_head.set(msg_svc_routinghead);
        msg_svc_pbsendmsgreq.content_head.set(msg_comm_contenthead);
        msg_svc_pbsendmsgreq.msg_body.set(im_msg_body_msgbody);
        msg_svc_pbsendmsgreq.msg_seq.set(i16);
        msg_svc_pbsendmsgreq.msg_rand.set(n3);
        if (A != 2 && A != 4 && A != 21) {
            if (eVar != null) {
                bArr = eVar.F0();
            }
            if (bArr != null) {
                msg_svc_pbsendmsgreq.sync_cookie.set(ByteStringMicro.copyFrom(bArr));
                q(appInterface, bArr);
            }
        }
        msg_svc_pbsendmsgreq.msg_via.set(i3);
        return msg_svc_pbsendmsgreq;
    }

    public static int d(msg_comm$Msg msg_comm_msg) {
        generalflags$ResvAttr o16;
        im_msg_body$GeneralFlags m3 = m(msg_comm_msg);
        if (m3 == null || !m3.bytes_pb_reserve.has() || (o16 = o(m3)) == null || !o16.uint32_face_id.has()) {
            return 0;
        }
        int i3 = o16.uint32_face_id.get();
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageProtoCodec", 2, "decodeC2CMsgPkg_FaceID->" + i3);
        }
        return i3;
    }

    public static int e(msg_comm$Msg msg_comm_msg) {
        generalflags$ResvAttr o16;
        im_msg_body$GeneralFlags m3 = m(msg_comm_msg);
        if (m3 == null || !m3.bytes_pb_reserve.has() || (o16 = o(m3)) == null || !o16.uint32_req_font_effect_id.has()) {
            return 0;
        }
        return o16.uint32_req_font_effect_id.get();
    }

    public static int f(msg_comm$Msg msg_comm_msg) {
        generalflags$ResvAttr o16;
        im_msg_body$GeneralFlags m3 = m(msg_comm_msg);
        if (m3 == null || !m3.bytes_pb_reserve.has() || (o16 = o(m3)) == null || !o16.uint32_pendant_diy_id.has()) {
            return 0;
        }
        int i3 = o16.uint32_pendant_diy_id.get();
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageProtoCodec", 2, "decodeC2CMsgPkg_PendantDiyID->" + i3);
        }
        return i3;
    }

    private static void g(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, List<MessageRecord> list2, StringBuilder sb5, com.tencent.mobileqq.troop.data.c cVar) {
        try {
            if (f286344d == null) {
                synchronized (f286341a) {
                    if (f286344d == null) {
                        f286344d = f286343c.get(0).newInstance();
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.d("Q.msg.MessageProtoCodec", 1, th5, new Object[0]);
        }
        if (f286344d != null) {
            if (list2.isEmpty()) {
                f286344d.m(list, list2, sb5, msg_comm_msg, cVar);
            }
            if (list2.isEmpty()) {
                f286344d.n(list, list2, sb5, msg_comm_msg, cVar);
            }
        }
    }

    public static void h(AppRuntime appRuntime, List<MessageRecord> list, msg_comm$Msg msg_comm_msg, boolean z16, boolean z17, com.tencent.mobileqq.troop.data.c cVar, ab abVar, com.tencent.mobileqq.service.message.a aVar) {
        List<im_msg_body$Elem> list2 = msg_comm_msg.msg_body.get().rich_text.get().elems.get();
        if (list2 != null && list2.size() > 0) {
            s(list2);
            StringBuilder sb5 = new StringBuilder("<---decodePBMsgElems:");
            i(list2, msg_comm_msg, list, sb5, z17, z16, cVar, t(list2, (IMessageFacade) appRuntime.getRuntimeService(IMessageFacade.class, "all")), abVar, aVar);
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.msg.MessageProtoCodec", 4, sb5.toString());
            }
            DeprecatedMethodInvokeReport.d("Message", "QMessageProtoCodec.decodePBMsgElems", sb5.toString());
        }
    }

    private static void i(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, List<MessageRecord> list2, StringBuilder sb5, boolean z16, boolean z17, com.tencent.mobileqq.troop.data.c cVar, List<com.tencent.imcore.message.core.codec.a> list3, ab abVar, com.tencent.mobileqq.service.message.a aVar) {
        com.tencent.imcore.message.core.codec.a next;
        Iterator<com.tencent.imcore.message.core.codec.a> it = list3.iterator();
        while (it.hasNext() && ((next = it.next()) == null || !next.a(list, msg_comm_msg, list2, sb5, z16, z17, cVar, abVar, aVar))) {
        }
        g(list, msg_comm_msg, list2, sb5, cVar);
        u(list3);
        for (com.tencent.imcore.message.core.codec.a aVar2 : list3) {
            if (aVar2 != null) {
                aVar2.a(list, msg_comm_msg, list2, sb5, z16, z17, cVar, abVar, aVar);
            }
        }
    }

    public static im_msg_body$Elem j(im_msg_body$RichText im_msg_body_richtext, String str) {
        im_msg_body$Text im_msg_body_text = new im_msg_body$Text();
        im_msg_body_text.str.set(ByteStringMicro.copyFromUtf8(str));
        im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
        im_msg_body_elem.text.set(im_msg_body_text);
        im_msg_body_richtext.elems.add(im_msg_body_elem);
        return im_msg_body_elem;
    }

    public static int k(im_msg_body$RichText im_msg_body_richtext, String str, ArrayList<AtTroopMemberInfo> arrayList) {
        if (str == null) {
            str = "";
        }
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i17 < str.length()) {
            b g16 = new b(im_msg_body_richtext, str, arrayList, i3, i16, sb5, i17).g();
            i3 = g16.d();
            i16 = g16.b();
            i17 = g16.e() + 1;
        }
        if (sb5.length() > 0) {
            j(im_msg_body_richtext, sb5.toString());
            return i3 + 1;
        }
        return i3;
    }

    private static void l(List<com.tencent.imcore.message.core.codec.a> list, List<com.tencent.imcore.message.core.codec.a> list2) {
        for (com.tencent.imcore.message.core.codec.a aVar : list2) {
            if (aVar != null) {
                aVar.c(list);
            }
        }
    }

    @Nullable
    public static im_msg_body$GeneralFlags m(msg_comm$Msg msg_comm_msg) {
        if (msg_comm_msg.msg_body.has() && msg_comm_msg.msg_body.get().rich_text.has()) {
            for (im_msg_body$Elem im_msg_body_elem : msg_comm_msg.msg_body.get().rich_text.get().elems.get()) {
                if (im_msg_body_elem.general_flags.has()) {
                    return im_msg_body_elem.general_flags.get();
                }
            }
        }
        return null;
    }

    public static int n(long j3) {
        return (int) (j3 & (-1));
    }

    public static generalflags$ResvAttr o(im_msg_body$GeneralFlags im_msg_body_generalflags) {
        try {
            generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
            generalflags_resvattr.mergeFrom(im_msg_body_generalflags.bytes_pb_reserve.get().toByteArray());
            return generalflags_resvattr;
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("Q.msg.MessageProtoCodec", 1, "", e16);
            return null;
        }
    }

    public static im_msg_body$RichText p(String str, ArrayList<AtTroopMemberInfo> arrayList) {
        im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
        if (k(im_msg_body_richtext, str, arrayList) <= 0) {
            return null;
        }
        return im_msg_body_richtext;
    }

    private static void q(AppInterface appInterface, byte[] bArr) {
        if (AppSetting.B()) {
            ((IQMessageProtoCodecService) QRoute.api(IQMessageProtoCodecService.class)).recordCookie(appInterface, bArr);
        }
    }

    private static void r(StringBuilder sb5, im_msg_body$Elem im_msg_body_elem) {
        boolean z16 = true;
        for (Field field : im_msg_body_elem.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object obj = field.get(im_msg_body_elem);
                if ((obj instanceof PBPrimitiveField) && ((PBPrimitiveField) obj).has()) {
                    if (!z16) {
                        sb5.append(",");
                    }
                    sb5.append(field.getName());
                    z16 = false;
                }
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
            }
        }
    }

    private static void s(List<im_msg_body$Elem> list) {
        StringBuilder sb5 = new StringBuilder();
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (sb5.length() > 0) {
                sb5.append(";");
            }
            r(sb5, im_msg_body_elem);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.msg.MessageProtoCodec", 4, "printElem() called with: elements = [" + sb5.toString() + "]");
        }
    }

    private static List<com.tencent.imcore.message.core.codec.a> t(List<im_msg_body$Elem> list, IMessageFacade iMessageFacade) {
        ArrayList arrayList = new ArrayList();
        List pBMsgElemsDecoders = iMessageFacade.getPBMsgElemsDecoders();
        a(list, arrayList, pBMsgElemsDecoders);
        l(arrayList, pBMsgElemsDecoders);
        z(arrayList, pBMsgElemsDecoders);
        return arrayList;
    }

    private static void u(List<com.tencent.imcore.message.core.codec.a> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).getPriority() > -1000) {
                list.remove(size);
            }
        }
    }

    public static int v(int i3, AppInterface appInterface) {
        return ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "all")).getUinType(i3);
    }

    public static void w(AppInterface appInterface, long j3, int i3, long j16, int i16) {
        long j17;
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", appInterface.getCurrentAccountUin(), "MessageSvc.PbDeleteMsg");
        msg_svc$PbDeleteMsgReq msg_svc_pbdeletemsgreq = new msg_svc$PbDeleteMsgReq();
        msg_svc$PbDeleteMsgReq.MsgItem msgItem = new msg_svc$PbDeleteMsgReq.MsgItem();
        msgItem.from_uin.set(j3);
        msgItem.msg_seq.set(i3);
        msgItem.msg_uid.set(j16);
        try {
            j17 = Long.parseLong(appInterface.getCurrentAccountUin());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageProtoCodec", 2, e16.getMessage());
            }
            j17 = 0;
        }
        msgItem.to_uin.set(j17);
        msgItem.msg_type.set(i16);
        msg_svc_pbdeletemsgreq.msgItems.add(msgItem);
        toServiceMsg.putWupBuffer(msg_svc_pbdeletemsgreq.toByteArray());
        toServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
        appInterface.sendToService(toServiceMsg);
    }

    public static void x(AppInterface appInterface, long j3, int i3, long j16, int i16, byte[] bArr) {
        long j17;
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", appInterface.getCurrentAccountUin(), "MessageSvc.PbDeleteMsg");
        msg_svc$PbDeleteMsgReq msg_svc_pbdeletemsgreq = new msg_svc$PbDeleteMsgReq();
        msg_svc$PbDeleteMsgReq.MsgItem msgItem = new msg_svc$PbDeleteMsgReq.MsgItem();
        msgItem.from_uin.set(j3);
        msgItem.msg_seq.set(i3);
        msgItem.msg_uid.set(j16);
        try {
            j17 = Long.parseLong(appInterface.getCurrentAccountUin());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageProtoCodec", 2, e16.getMessage());
            }
            j17 = 0;
        }
        msgItem.to_uin.set(j17);
        msgItem.msg_type.set(i16);
        if (bArr != null && bArr.length > 0) {
            msgItem.sig.set(ByteStringMicro.copyFrom(bArr));
        }
        msg_svc_pbdeletemsgreq.msgItems.add(msgItem);
        toServiceMsg.putWupBuffer(msg_svc_pbdeletemsgreq.toByteArray());
        toServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
        appInterface.sendToService(toServiceMsg);
    }

    public static boolean y(AppInterface appInterface, MessageRecord messageRecord, msg_svc$RoutingHead msg_svc_routinghead) {
        if (msg_svc_routinghead == null) {
            return false;
        }
        return ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "all")).setRoutingHead(appInterface, A(messageRecord.istroop, appInterface), msg_svc_routinghead, messageRecord);
    }

    private static void z(List<com.tencent.imcore.message.core.codec.a> list, List<com.tencent.imcore.message.core.codec.a> list2) {
        Collections.sort(list, f286342b);
    }
}
