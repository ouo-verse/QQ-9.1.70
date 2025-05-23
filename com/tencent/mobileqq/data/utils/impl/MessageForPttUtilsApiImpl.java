package com.tencent.mobileqq.data.utils.impl;

import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.utils.IMessageForPttUtilsApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import tencent.im.cs.ptt_reserve.ptt_reserve$ReserveStruct;
import tencent.im.cs.ptt_waveform.ptt_waveform$PttWaveform;

/* loaded from: classes10.dex */
public class MessageForPttUtilsApiImpl implements IMessageForPttUtilsApi {
    @Override // com.tencent.mobileqq.data.utils.IMessageForPttUtilsApi
    public byte[] c2cConstructPTTExtraInfo(MessageForPtt messageForPtt) {
        byte[] c2cConstructPttReserveInfo = c2cConstructPttReserveInfo(messageForPtt);
        byte[] bArr = new byte[c2cConstructPttReserveInfo.length + 3 + 15];
        bArr[0] = 3;
        bArr[1] = 8;
        byte[] shortToHL = PkgTools.shortToHL((short) 4);
        System.arraycopy(shortToHL, 0, bArr, 2, shortToHL.length);
        int length = shortToHL.length + 2;
        byte[] intToHL = PkgTools.intToHL(messageForPtt.voiceType);
        System.arraycopy(intToHL, 0, bArr, length, intToHL.length);
        int length2 = length + intToHL.length;
        bArr[length2] = 9;
        int i3 = length2 + 1;
        byte[] shortToHL2 = PkgTools.shortToHL((short) 4);
        System.arraycopy(shortToHL2, 0, bArr, i3, 2);
        int length3 = i3 + shortToHL2.length;
        byte[] intToHL2 = PkgTools.intToHL(Utils.O(messageForPtt.voiceLength));
        System.arraycopy(intToHL2, 0, bArr, length3, intToHL2.length);
        int length4 = length3 + intToHL2.length;
        bArr[length4] = 10;
        int i16 = length4 + 1;
        byte[] shortToHL3 = PkgTools.shortToHL((short) c2cConstructPttReserveInfo.length);
        System.arraycopy(shortToHL3, 0, bArr, i16, 2);
        System.arraycopy(c2cConstructPttReserveInfo, 0, bArr, i16 + shortToHL3.length, c2cConstructPttReserveInfo.length);
        return bArr;
    }

    @Override // com.tencent.mobileqq.data.utils.IMessageForPttUtilsApi
    public byte[] c2cConstructPttReserveInfo(MessageForPtt messageForPtt) {
        ptt_reserve$ReserveStruct ptt_reserve_reservestruct = new ptt_reserve$ReserveStruct();
        ptt_reserve_reservestruct.uint32_change_voice.set(messageForPtt.voiceChangeFlag);
        ptt_reserve_reservestruct.uint32_autototext_voice.set(messageForPtt.autoToText);
        if (messageForPtt.hasSttTxt()) {
            ptt_reserve_reservestruct.bytes_voice_text_abs.set(ByteStringMicro.copyFrom(messageForPtt.sttText.getBytes()));
        }
        return ptt_reserve_reservestruct.toByteArray();
    }

    @Override // com.tencent.mobileqq.data.utils.IMessageForPttUtilsApi
    public byte[] changeWaveformToPb(int[] iArr) {
        ptt_waveform$PttWaveform ptt_waveform_pttwaveform = new ptt_waveform$PttWaveform();
        if (iArr != null && iArr.length > 0) {
            ptt_waveform_pttwaveform.uin32_size.set(iArr.length);
            byte[] bArr = new byte[iArr.length];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                int i16 = iArr[i3];
                if (i16 < 0) {
                    i16 = 0;
                } else if (i16 > 255) {
                    i16 = 255;
                }
                bArr[i3] = (byte) (i16 & 255);
            }
            ptt_waveform_pttwaveform.bytes_amplitudes.set(ByteStringMicro.copyFrom(bArr));
        }
        return ptt_waveform_pttwaveform.toByteArray();
    }

    public int getRedPackTypeForPtt(MessageForPtt messageForPtt) {
        return 0;
    }

    @Override // com.tencent.mobileqq.data.utils.IMessageForPttUtilsApi
    public byte[] groupConstructPTTExtraInfo(MessageForPtt messageForPtt) {
        ptt_reserve$ReserveStruct ptt_reserve_reservestruct = new ptt_reserve$ReserveStruct();
        if (messageForPtt != null) {
            ptt_reserve_reservestruct.uint32_change_voice.set(messageForPtt.voiceChangeFlag);
            ptt_reserve_reservestruct.uint32_autototext_voice.set(messageForPtt.autoToText);
            if (messageForPtt.hasSttTxt()) {
                ptt_reserve_reservestruct.bytes_voice_text_abs.set(ByteStringMicro.copyFrom(messageForPtt.sttText.getBytes()));
            }
        }
        byte[] byteArray = ptt_reserve_reservestruct.toByteArray();
        if (QLog.isColorLevel() && messageForPtt != null) {
            QLog.d("pttchangevoice", 2, "change flag is " + messageForPtt.voiceChangeFlag);
        }
        return byteArray;
    }
}
