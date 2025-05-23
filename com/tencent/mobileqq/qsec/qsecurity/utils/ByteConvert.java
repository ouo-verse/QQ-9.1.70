package com.tencent.mobileqq.qsec.qsecurity.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ByteConvert {
    static IPatchRedirector $redirector_;

    public ByteConvert() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int buf_to_int16(byte[] bArr, int i3) {
        return ((bArr[i3] << 8) & 65280) + ((bArr[i3 + 1] << 0) & 255);
    }

    public static int buf_to_int32(byte[] bArr, int i3) {
        return ((bArr[i3] << 24) & (-16777216)) + ((bArr[i3 + 1] << RegisterType.UNINIT_REF) & ITVKAsset.VOD_ASSET_MASK_BIT) + ((bArr[i3 + 2] << 8) & 65280) + ((bArr[i3 + 3] << 0) & 255);
    }

    public static long buf_to_int64(byte[] bArr, int i3) {
        return ((bArr[i3] << 56) & (-72057594037927936L)) + 0 + ((bArr[i3 + 1] << 48) & 71776119061217280L) + ((bArr[i3 + 2] << 40) & 280375465082880L) + ((bArr[i3 + 3] << 32) & 1095216660480L) + ((bArr[i3 + 4] << 24) & 4278190080L) + ((bArr[i3 + 5] << 16) & 16711680) + ((bArr[i3 + 6] << 8) & 65280) + ((bArr[i3 + 7] << 0) & 255);
    }

    public static int buf_to_int8(byte[] bArr, int i3) {
        return bArr[i3] & 255;
    }

    public static void int16_to_buf(byte[] bArr, int i3, int i16) {
        bArr[i3 + 1] = (byte) (i16 >> 0);
        bArr[i3 + 0] = (byte) (i16 >> 8);
    }

    public static void int32_to_buf(byte[] bArr, int i3, int i16) {
        bArr[i3 + 3] = (byte) (i16 >> 0);
        bArr[i3 + 2] = (byte) (i16 >> 8);
        bArr[i3 + 1] = (byte) (i16 >> 16);
        bArr[i3 + 0] = (byte) (i16 >> 24);
    }

    public static void int64_to_buf(byte[] bArr, int i3, long j3) {
        bArr[i3 + 7] = (byte) (j3 >> 0);
        bArr[i3 + 6] = (byte) (j3 >> 8);
        bArr[i3 + 5] = (byte) (j3 >> 16);
        bArr[i3 + 4] = (byte) (j3 >> 24);
        bArr[i3 + 3] = (byte) (j3 >> 32);
        bArr[i3 + 2] = (byte) (j3 >> 40);
        bArr[i3 + 1] = (byte) (j3 >> 48);
        bArr[i3 + 0] = (byte) (j3 >> 56);
    }

    public static void int64_to_buf32(byte[] bArr, int i3, long j3) {
        bArr[i3 + 3] = (byte) (j3 >> 0);
        bArr[i3 + 2] = (byte) (j3 >> 8);
        bArr[i3 + 1] = (byte) (j3 >> 16);
        bArr[i3 + 0] = (byte) (j3 >> 24);
    }

    public static void int8_to_buf(byte[] bArr, int i3, int i16) {
        bArr[i3 + 0] = (byte) (i16 >> 0);
    }
}
