package com.tencent.mobileqq.onlinestatus.utils;

import androidx.core.internal.view.SupportMenu;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.Inflater;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype33;
import tencent.im.msg.im_msg_body$CommonElem;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$Text;

/* compiled from: P */
/* loaded from: classes16.dex */
public class q {
    public static byte[] b(byte[] bArr) {
        Inflater inflater = new Inflater();
        inflater.reset();
        inflater.setInput(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            try {
                byte[] bArr2 = new byte[1024];
                while (!inflater.finished()) {
                    byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
                }
                bArr = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Exception e17) {
                e17.printStackTrace();
                byteArrayOutputStream.close();
            }
            inflater.end();
            return bArr;
        } catch (Throwable th5) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e18) {
                e18.printStackTrace();
            }
            throw th5;
        }
    }

    public String a(List<im_msg_body$Elem> list) {
        int convertToLocal;
        StringBuilder sb5 = new StringBuilder("");
        int size = list.size();
        boolean z16 = false;
        for (int i3 = 0; i3 < size; i3++) {
            im_msg_body$Elem im_msg_body_elem = list.get(i3);
            if (im_msg_body_elem.text.has()) {
                if (z16) {
                    z16 = false;
                } else {
                    QLog.isColorLevel();
                    sb5.length();
                    im_msg_body$Text im_msg_body_text = im_msg_body_elem.text.get();
                    if (im_msg_body_text.str.has()) {
                        sb5.append(com.tencent.mobileqq.service.message.s.c(im_msg_body_text.str.get().toStringUtf8(), false));
                    }
                }
            } else if (im_msg_body_elem.f435954face.has()) {
                QLog.isColorLevel();
                if (im_msg_body_elem.f435954face.get().index.has() && (convertToLocal = QQSysFaceUtil.convertToLocal(im_msg_body_elem.f435954face.get().index.get())) >= 0) {
                    sb5.append((char) 20);
                    sb5.append((char) convertToLocal);
                }
            } else if (im_msg_body_elem.small_emoji.has()) {
                QLog.isColorLevel();
                if (im_msg_body_elem.small_emoji.get().packIdSum.has()) {
                    int i16 = (im_msg_body_elem.small_emoji.get().packIdSum.get() & SupportMenu.CATEGORY_MASK) >> 16;
                    int i17 = im_msg_body_elem.small_emoji.get().packIdSum.get() & 65535;
                    char[] k3 = com.tencent.mobileqq.emosm.e.k(i16, i17);
                    if (im_msg_body_elem.small_emoji.get().imageType.has() && (im_msg_body_elem.small_emoji.get().imageType.get() & 65535) == 2) {
                        k3[3] = '\u01ff';
                        if (QLog.isColorLevel()) {
                            QLog.d("MessagePBElemDecoder", 2, "get apng epid = " + i16 + " eid = " + i17);
                        }
                    }
                    sb5.append((char) 20);
                    sb5.append(k3[3]);
                    sb5.append(k3[2]);
                    z16 = true;
                    sb5.append(k3[1]);
                    sb5.append(k3[0]);
                }
            } else if (im_msg_body_elem.common_elem.has() && 33 == im_msg_body_elem.common_elem.uint32_service_type.get()) {
                QLog.isColorLevel();
                sb5.append(c(im_msg_body_elem.common_elem.get()));
            }
        }
        return sb5.toString();
    }

    public String c(im_msg_body$CommonElem im_msg_body_commonelem) {
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
}
