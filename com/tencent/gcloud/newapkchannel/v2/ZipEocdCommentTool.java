package com.tencent.gcloud.newapkchannel.v2;

import com.tencent.commonsdk.soload.MyZipConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.ZipException;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class ZipEocdCommentTool {
    static IPatchRedirector $redirector_ = null;
    private static final int CFD_LOCATOR_OFFSET = 16;
    private static final ZipLong EOCD_SIG;
    private static final int MIN_EOCD_SIZE = 22;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20147);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            EOCD_SIG = new ZipLong(MyZipConstants.ENDSIG);
        }
    }

    public ZipEocdCommentTool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static byte[] readComment(String str) throws IOException {
        if (str == null || str.length() <= 0) {
            return null;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        if (randomAccessFile.length() == 0) {
            randomAccessFile.close();
            System.out.println("ERROR:[ZipEocdCommentTool]Your file length is zero!");
            return null;
        }
        byte[] readComment = readComment(randomAccessFile);
        randomAccessFile.close();
        return readComment;
    }

    public static boolean updateComment(String str, byte[] bArr) throws Exception {
        int i3 = 0;
        if (bArr == null || str == null || str.length() <= 0) {
            return false;
        }
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "rw");
            try {
                if (randomAccessFile2.length() != 0) {
                    byte[] readComment = readComment(randomAccessFile2);
                    if (readComment != null) {
                        i3 = readComment.length;
                    }
                    long j3 = i3;
                    long length = (randomAccessFile2.length() - j3) + bArr.length;
                    randomAccessFile2.seek((randomAccessFile2.length() - 2) - j3);
                    randomAccessFile2.write(new ZipShort(bArr.length).getBytes());
                    randomAccessFile2.write(bArr);
                    randomAccessFile2.setLength(length);
                    randomAccessFile2.close();
                    return true;
                }
                randomAccessFile2.close();
                throw new Exception("Your file length is zero !!");
            } catch (Throwable th5) {
                th = th5;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private static byte[] readComment(RandomAccessFile randomAccessFile) throws IOException {
        boolean z16;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] bytes = EOCD_SIG.getBytes();
        int read = randomAccessFile.read();
        while (true) {
            z16 = false;
            if (read != -1) {
                if (read == bytes[0] && randomAccessFile.read() == bytes[1] && randomAccessFile.read() == bytes[2] && randomAccessFile.read() == bytes[3]) {
                    z16 = true;
                    break;
                }
                length--;
                if (length < 0) {
                    break;
                }
                randomAccessFile.seek(length);
                read = randomAccessFile.read();
            } else {
                break;
            }
        }
        if (z16) {
            randomAccessFile.seek(length + 16 + 4);
            byte[] bArr = new byte[2];
            randomAccessFile.readFully(bArr);
            int value = new ZipShort(bArr).getValue();
            if (value == 0) {
                return null;
            }
            byte[] bArr2 = new byte[value];
            randomAccessFile.read(bArr2);
            return bArr2;
        }
        throw new ZipException("archive is not a ZIP archive");
    }
}
