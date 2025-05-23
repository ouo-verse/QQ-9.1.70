package com.tencent.dlsdk.yybutil.apkchannel.v1;

import com.tencent.commonsdk.soload.MyZipConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.RandomAccessFile;
import java.util.zip.ZipException;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final b f100550a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19685);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f100550a = new b(MyZipConstants.ENDSIG);
        }
    }

    private static byte[] a(RandomAccessFile randomAccessFile) {
        boolean z16;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] a16 = f100550a.a();
        int read = randomAccessFile.read();
        while (true) {
            z16 = false;
            if (read == -1) {
                break;
            }
            if (read == a16[0]) {
                z16 = true;
                if (randomAccessFile.read() == a16[1] && randomAccessFile.read() == a16[2] && randomAccessFile.read() == a16[3]) {
                    break;
                }
            }
            length--;
            randomAccessFile.seek(length);
            read = randomAccessFile.read();
        }
        if (z16) {
            randomAccessFile.seek(length + 16 + 4);
            byte[] bArr = new byte[2];
            randomAccessFile.readFully(bArr);
            int b16 = new c(bArr).b();
            if (b16 == 0) {
                return null;
            }
            byte[] bArr2 = new byte[b16];
            randomAccessFile.read(bArr2);
            return bArr2;
        }
        throw new ZipException("archive is not a ZIP archive");
    }

    public static byte[] b(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        if (randomAccessFile.length() == 0) {
            randomAccessFile.close();
            System.out.println("ERROR:[ZipEocdCommentTool]Your file length is zero!");
            return null;
        }
        byte[] a16 = a(randomAccessFile);
        randomAccessFile.close();
        return a16;
    }
}
