package com.tencent.gamecenter.wadl.util;

import com.tencent.gamecenter.wadl.util.ApkSignatureSchemeV2Verifier;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.ProtocolException;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {
    public static String a(String str) throws IOException {
        g b16 = b(str);
        if (b16 == null) {
            return null;
        }
        return b16.b().getProperty("channelId");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0038 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static g b(String str) throws IOException {
        byte[] d16;
        boolean b16 = b.b(str);
        boolean a16 = b.a(str);
        if (a16 || b16) {
            try {
                d16 = b.d(str);
            } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e16) {
                e16.printStackTrace();
            }
            if (d16 == null) {
                d16 = l.b(str);
                if (a16 && d16 != null) {
                    QLog.i("ApkChannelTool", 2, "you are use v2 signature but use v1 channel modle");
                } else if (b16 && d16 != null) {
                    QLog.i("ApkChannelTool", 2, "you are use v3 signature but use v1 channel modle");
                }
            }
            if (d16 != null) {
                return null;
            }
            g gVar = new g();
            try {
                gVar.a(d16);
                return gVar;
            } catch (ProtocolException e17) {
                e17.printStackTrace();
                return null;
            }
        }
        d16 = null;
        if (d16 == null) {
        }
        if (d16 != null) {
        }
    }
}
