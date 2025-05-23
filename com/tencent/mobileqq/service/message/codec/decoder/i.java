package com.tencent.mobileqq.service.message.codec.decoder;

import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.stt.ISttManagerApi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.cm;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import localpb.richMsg.RichMsg$PttRec;
import msf.msgcomm.msg_comm$Msg;
import org.jetbrains.annotations.Nullable;
import tencent.im.cs.ptt_reserve.ptt_reserve$ReserveStruct;
import tencent.im.cs.ptt_waveform.ptt_waveform$PttWaveform;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$Ptt;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes18.dex */
public class i implements d<MessageHandler> {
    static IPatchRedirector $redirector_;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean b(im_msg_body$RichText im_msg_body_richtext, im_msg_body$Ptt im_msg_body_ptt) {
        if (im_msg_body_richtext.ptt.has() && im_msg_body_ptt.uint32_file_type.has() && ((im_msg_body_ptt.uint32_file_type.get() == 4 || im_msg_body_ptt.uint32_file_type.get() == 6) && im_msg_body_ptt.bytes_file_uuid.has())) {
            if (QLog.isColorLevel()) {
                QLog.d("PTTDecoder", 2, "PTT_ROAM : decodeC2CMsgPkg_PTT. fileType : " + im_msg_body_ptt.uint32_file_type.get());
                return false;
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder("<---decodeC2CMsgPkg_PTT return null:");
            if (im_msg_body_ptt == null) {
                sb5.append(" ptt is null.");
            } else {
                sb5.append(" HasileType:");
                sb5.append(im_msg_body_ptt.uint32_file_type.has());
                sb5.append(" fileType:");
                sb5.append(im_msg_body_ptt.uint32_file_type.get());
                sb5.append(" hasUUID:");
                sb5.append(im_msg_body_ptt.bytes_file_uuid.has());
            }
            QLog.d("PTTDecoder", 2, sb5.toString());
            return true;
        }
        return true;
    }

    private void e(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, im_msg_body$RichText im_msg_body_richtext, MessageRecord messageRecord) {
        if (im_msg_body_richtext.elems.has()) {
            for (im_msg_body$Elem im_msg_body_elem : im_msg_body_richtext.elems.get()) {
                if (im_msg_body_elem.common_elem.has() && 21 == im_msg_body_elem.common_elem.uint32_service_type.get()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(messageRecord);
                    ConfessMsgUtil.k(msg_comm_msg, im_msg_body_elem, arrayList, messageHandler.Q);
                }
            }
        }
    }

    @Nullable
    private MessageForPtt f(msg_comm$Msg msg_comm_msg, MessageForPtt messageForPtt) {
        Integer valueOf;
        List<im_msg_body$Elem> list = msg_comm_msg.msg_body.get().rich_text.get().elems.get();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("<---decodePBMsgElems: elems: ");
            if (list == null) {
                valueOf = null;
            } else {
                valueOf = Integer.valueOf(list.size());
            }
            sb5.append(valueOf);
            QLog.d("PTTDecoder", 2, sb5.toString());
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.general_flags.has() && im_msg_body_elem.general_flags.bytes_pb_reserve.has()) {
                try {
                    generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
                    generalflags_resvattr.mergeFrom(im_msg_body_elem.general_flags.bytes_pb_reserve.get().toByteArray());
                    if (generalflags_resvattr.bytes_pb_ptt_waveform.has()) {
                        ptt_waveform$PttWaveform ptt_waveform_pttwaveform = new ptt_waveform$PttWaveform();
                        ptt_waveform_pttwaveform.mergeFrom(generalflags_resvattr.bytes_pb_ptt_waveform.get().toByteArray());
                        messageForPtt.waveformArray = cm.a(ptt_waveform_pttwaveform);
                        if (QLog.isColorLevel()) {
                            StringBuilder sb6 = new StringBuilder();
                            int[] iArr = messageForPtt.waveformArray;
                            if (iArr != null) {
                                for (int i3 : iArr) {
                                    sb6.append(i3);
                                    sb6.append(";");
                                }
                            }
                            QLog.d("PTTDecoder", 2, "decodeC2CMsgPkg_PTT, waveformArray = " + sb6.toString());
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        int[] iArr2 = messageForPtt.waveformArray;
        if (iArr2 == null || iArr2.length == 0) {
            messageForPtt.buileDefaultWaveform();
        }
        return messageForPtt;
    }

    private void g(long j3, String str, String str2) {
        String substring;
        try {
            if (!str2.contains("_")) {
                substring = str2.substring(0, str2.length() - 4);
            } else {
                substring = str2.substring(str2.lastIndexOf("_") + 1, str2.length() - 4);
            }
            String str3 = j3 + "_" + substring;
            if (QLog.isColorLevel()) {
                QLog.d("PTTDecoder", 2, "<---decodeC2CMsgPkg_PTT isPttSuffix offfile key\uff1a" + str3 + " fileUuid:" + str);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.service.message.codec.decoder.d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar) {
        im_msg_body$RichText im_msg_body_richtext;
        long j3;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        String str;
        int i26;
        ByteStringMicro byteStringMicro;
        byte[] byteArray;
        int i27;
        im_msg_body$RichText im_msg_body_richtext2;
        long j16;
        long j17;
        IPatchRedirector iPatchRedirector = $redirector_;
        byte b16 = 3;
        int i28 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, messageHandler, msg_comm_msg, list, aVar);
            return;
        }
        long j18 = msg_comm_msg.msg_head.get().from_uin.get();
        if (msg_comm_msg.msg_body.has() && msg_comm_msg.msg_body.get().rich_text.has()) {
            im_msg_body$RichText im_msg_body_richtext3 = msg_comm_msg.msg_body.get().rich_text.get();
            im_msg_body$Ptt im_msg_body_ptt = im_msg_body_richtext3.ptt.get();
            if (b(im_msg_body_richtext3, im_msg_body_ptt)) {
                return;
            }
            boolean sttAbility = ((ISttManagerApi) QRoute.api(ISttManagerApi.class)).getSttAbility(messageHandler.Q);
            String str2 = "";
            long j19 = -1;
            if (im_msg_body_ptt.bytes_reserve.has() && (byteArray = im_msg_body_ptt.bytes_reserve.get().toByteArray()) != null && byteArray.length > 1) {
                byte b17 = byteArray[0];
                int i29 = 1;
                int i36 = 0;
                int i37 = 0;
                int i38 = 0;
                int i39 = 0;
                int i46 = 0;
                String str3 = "";
                for (int i47 = 1; i29 < byteArray.length - i47; i47 = 1) {
                    byte b18 = byteArray[i29];
                    int i48 = i29 + 1;
                    int shortData = PkgTools.getShortData(byteArray, i48);
                    int i49 = i48 + i28;
                    if (b18 == b16) {
                        byte[] bArr = new byte[shortData];
                        PkgTools.copyData(bArr, 0, byteArray, i49, shortData);
                        long longData = PkgTools.getLongData(bArr, 0);
                        if (longData > 0) {
                            j16 = longData;
                        } else {
                            j16 = j19;
                        }
                        if (QLog.isColorLevel()) {
                            j17 = j16;
                            QLog.d("PTTDecoder", 2, "PTT_ROAM : TimeStamp in d0 :" + j16);
                        } else {
                            j17 = j16;
                        }
                        i27 = shortData;
                        j19 = j17;
                    } else if (b18 == 9) {
                        i27 = shortData;
                        byte[] bArr2 = new byte[i27];
                        PkgTools.copyData(bArr2, 0, byteArray, i49, i27);
                        i37 = d(Utils.O(PkgTools.getLongData(bArr2, 0)));
                    } else {
                        i27 = shortData;
                        if (b18 == 8) {
                            byte[] bArr3 = new byte[i27];
                            PkgTools.copyData(bArr3, 0, byteArray, i49, i27);
                            im_msg_body_richtext2 = im_msg_body_richtext3;
                            i36 = (int) PkgTools.getLongData(bArr3, 0);
                        } else {
                            im_msg_body_richtext2 = im_msg_body_richtext3;
                            if (b18 == 10) {
                                byte[] bArr4 = new byte[i27];
                                PkgTools.copyData(bArr4, 0, byteArray, i49, i27);
                                ptt_reserve$ReserveStruct ptt_reserve_reservestruct = new ptt_reserve$ReserveStruct();
                                try {
                                    ptt_reserve_reservestruct.mergeFrom(bArr4);
                                    i38 = ptt_reserve_reservestruct.uint32_change_voice.get();
                                    i39 = ptt_reserve_reservestruct.uint32_redpack_type.get();
                                    i46 = ptt_reserve_reservestruct.uint32_autototext_voice.get();
                                    str3 = ptt_reserve_reservestruct.bytes_voice_text_abs.get().toStringUtf8();
                                } catch (Exception unused) {
                                }
                            }
                        }
                        i29 = i49 + i27;
                        im_msg_body_richtext3 = im_msg_body_richtext2;
                        b16 = 3;
                        i28 = 2;
                    }
                    im_msg_body_richtext2 = im_msg_body_richtext3;
                    i29 = i49 + i27;
                    im_msg_body_richtext3 = im_msg_body_richtext2;
                    b16 = 3;
                    i28 = 2;
                }
                im_msg_body_richtext = im_msg_body_richtext3;
                j3 = j19;
                i3 = i36;
                i16 = i37;
                i17 = i38;
                i18 = i39;
                i19 = i46;
                str = str3;
            } else {
                im_msg_body_richtext = im_msg_body_richtext3;
                j3 = -1;
                i3 = 0;
                i16 = 0;
                i17 = 0;
                i18 = 0;
                i19 = 0;
                str = "";
            }
            if (im_msg_body_ptt.bytes_down_para.has() && (byteStringMicro = im_msg_body_ptt.bytes_down_para.get()) != null) {
                str2 = byteStringMicro.toStringUtf8();
            }
            if (TextUtils.isEmpty(str2)) {
                i26 = 1;
            } else {
                i26 = 2;
            }
            ReportController.o(messageHandler.Q, "CliOper", "", "", "0X80060E4", "0X80060E4", i26, 0, "", "", "", AppSetting.f99551k);
            String stringUtf8 = im_msg_body_ptt.bytes_file_uuid.get().toStringUtf8();
            long j26 = j3;
            String stringUtf82 = im_msg_body_ptt.bytes_file_name.get().toStringUtf8();
            String bytes2HexStr = HexUtil.bytes2HexStr(im_msg_body_ptt.bytes_file_md5.get().toByteArray());
            g(j18, stringUtf8, stringUtf82);
            RichMsg$PttRec richMsg$PttRec = new RichMsg$PttRec();
            richMsg$PttRec.localPath.set(stringUtf8);
            richMsg$PttRec.size.set(im_msg_body_ptt.uint32_file_size.get());
            richMsg$PttRec.type.set(2);
            richMsg$PttRec.uuid.set(stringUtf8);
            richMsg$PttRec.isRead.set(false);
            richMsg$PttRec.serverStorageSource.set("pttcenter");
            richMsg$PttRec.isReport.set(0);
            richMsg$PttRec.version.set(5);
            richMsg$PttRec.pttFlag.set(sttAbility ? 1 : 0);
            richMsg$PttRec.autototext_voice.set(i19);
            richMsg$PttRec.sttText.set(str);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long j27 = msg_comm_msg.msg_head.msg_time.get();
            richMsg$PttRec.msgRecTime.set(currentTimeMillis);
            richMsg$PttRec.msgTime.set(j27);
            richMsg$PttRec.voiceType.set(i3);
            richMsg$PttRec.voiceLength.set(i16);
            richMsg$PttRec.voiceChangeFlag.set(i17);
            richMsg$PttRec.redpack_type.set(i18);
            if (!TextUtils.isEmpty(bytes2HexStr)) {
                richMsg$PttRec.md5.set(bytes2HexStr);
            }
            if (QLog.isColorLevel()) {
                QLog.d("RecordParams", 2, "<---decodeC2CMsgPkg_PTT voiceType\uff1a" + i3 + " voiceLengh:" + i16);
            }
            richMsg$PttRec.longPttVipFlag.set(ff.n(messageHandler.Q, String.valueOf(j18)));
            richMsg$PttRec.directUrl.set(str2);
            MessageRecord d16 = q.d(-2002);
            d16.msgtype = -2002;
            d16.msgData = richMsg$PttRec.toByteArray();
            d16.time = j26;
            MessageForPtt f16 = f(msg_comm_msg, (MessageForPtt) d16);
            if (f16 == null) {
                return;
            }
            f16.parse();
            list.add(d16);
            e(messageHandler, msg_comm_msg, im_msg_body_richtext, d16);
        }
    }

    public int d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
        }
        return ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).getPttShowTime(i3);
    }
}
