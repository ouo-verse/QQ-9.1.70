package com.tencent.mobileqq.app.utils;

import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes11.dex */
public class MessagePkgUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MessagePkgUtils";

    public MessagePkgUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static byte[] encodeMarketFace(MarkFaceMessage markFaceMessage, String str) {
        int i3;
        if (markFaceMessage == null) {
            return null;
        }
        byte[] bArr = new byte[47];
        bArr[0] = 2;
        PkgTools.word2Byte(bArr, 1, (short) 44);
        PkgTools.littleIndianDw2Byte(bArr, 3, markFaceMessage.dwMSGItemType);
        bArr[7] = (byte) markFaceMessage.cFaceInfo;
        PkgTools.word2Byte(bArr, 8, (short) markFaceMessage.wSize);
        byte[] bArr2 = markFaceMessage.sbufID;
        PkgTools.copyData(bArr, 10, bArr2, bArr2.length);
        PkgTools.dWord2Byte(bArr, 26, markFaceMessage.dwTabID);
        bArr[30] = (byte) markFaceMessage.cSubType;
        byte[] bArr3 = markFaceMessage.sbfKey;
        PkgTools.copyData(bArr, 31, bArr3, bArr3.length);
        byte[] bArr4 = new byte[50];
        bArr4[0] = 12;
        PkgTools.word2Byte(bArr4, 1, (short) 47);
        PkgTools.copyData(bArr4, 3, bArr, 47);
        byte[] convertUnicode2UTF8Byte = PkgTools.convertUnicode2UTF8Byte(str);
        if (convertUnicode2UTF8Byte != null) {
            i3 = convertUnicode2UTF8Byte.length + 1 + 2 + 50;
        } else {
            i3 = 50;
        }
        byte[] bArr5 = new byte[i3];
        PkgTools.copyData(bArr5, 0, bArr4, 50);
        if (convertUnicode2UTF8Byte != null) {
            bArr5[50] = 11;
            PkgTools.word2Byte(bArr5, 51, (short) convertUnicode2UTF8Byte.length);
            PkgTools.copyData(bArr5, 53, convertUnicode2UTF8Byte, convertUnicode2UTF8Byte.length);
        }
        return bArr5;
    }

    public static byte[] getBytesFromObject(Serializable serializable) throws Exception {
        if (serializable == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new ObjectOutputStream(byteArrayOutputStream).writeObject(serializable);
        return byteArrayOutputStream.toByteArray();
    }

    public static Object getObjectFromBytes(byte[] bArr) throws Exception {
        if (bArr != null && bArr.length != 0) {
            return new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject();
        }
        return null;
    }

    public static byte[] makeDisMarketFaceTlv(long j3, MarkFaceMessage markFaceMessage, String str) {
        byte[] makeValuePrefix = makeValuePrefix(2, j3);
        byte[] encodeMarketFace = encodeMarketFace(markFaceMessage, str);
        byte[] bArr = new byte[makeValuePrefix.length + 5 + encodeMarketFace.length];
        bArr[0] = 1;
        PkgTools.word2Byte(bArr, 1, (short) 119);
        PkgTools.word2Byte(bArr, 3, (short) (makeValuePrefix.length + encodeMarketFace.length));
        PkgTools.copyData(bArr, 5, makeValuePrefix, makeValuePrefix.length);
        PkgTools.copyData(bArr, 5 + makeValuePrefix.length, encodeMarketFace, encodeMarketFace.length);
        if (QLog.isColorLevel()) {
            QLog.d("", 2, "hex =" + PkgTools.toHexStr(bArr));
        }
        return bArr;
    }

    public static byte[] makeTroopMarketFaceTlv(long j3, MarkFaceMessage markFaceMessage, String str) {
        byte[] encodeMarketFace = encodeMarketFace(markFaceMessage, str);
        short length = (short) (encodeMarketFace.length + 8);
        byte[] bArr = new byte[length + 5];
        bArr[0] = 1;
        PkgTools.word2Byte(bArr, 1, (short) 4);
        PkgTools.word2Byte(bArr, 3, length);
        PkgTools.word2Byte(bArr, 5, (short) 2052);
        PkgTools.dWord2Byte(bArr, 7, j3);
        PkgTools.word2Byte(bArr, 11, (short) 2);
        PkgTools.copyData(bArr, 13, encodeMarketFace, encodeMarketFace.length);
        return bArr;
    }

    public static byte[] makeValuePrefix(int i3, long j3) {
        byte[] bArr = new byte[12];
        PkgTools.word2Byte(bArr, 0, (short) 2052);
        PkgTools.dWord2Byte(bArr, 2, 0L);
        PkgTools.dWord2Byte(bArr, 6, (int) j3);
        PkgTools.word2Byte(bArr, 10, (short) i3);
        return bArr;
    }
}
