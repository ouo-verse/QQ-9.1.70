package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.j;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes19.dex */
public class BaseShortVideoUploadProcessor extends BaseUploadProcessor {
    static IPatchRedirector $redirector_;
    protected RandomAccessFile mThumbRaf;
    protected byte[] thumbFileMd5;

    public BaseShortVideoUploadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Throwable, java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.Throwable, java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.Throwable, java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.lang.Throwable, java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v35, types: [java.util.HashMap<java.lang.String, java.lang.String>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r1v36, types: [java.lang.Throwable, java.io.IOException] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x010c -> B:27:0x010f). Please report as a decompilation issue!!! */
    public String combineThumbAndVideo() {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        byte[] bArr = this.thumbFileMd5;
        byte[] bArr2 = new byte[bArr.length + this.mLocalMd5.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        byte[] bArr3 = this.mLocalMd5;
        System.arraycopy(bArr3, 0, bArr2, this.thumbFileMd5.length, bArr3.length);
        String str = j.k() + HexUtil.bytes2HexStr(bArr2) + ".cb";
        BufferedOutputStream bufferedOutputStream2 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        BufferedOutputStream bufferedOutputStream3 = null;
        bufferedOutputStream2 = null;
        BufferedOutputStream bufferedOutputStream4 = null;
        BufferedOutputStream bufferedOutputStream5 = null;
        try {
            try {
                try {
                    try {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        new File(str).delete();
                        File file = new File(str);
                        if (!file.exists()) {
                            try {
                                file.createNewFile();
                            } catch (IOException e16) {
                                e16.printStackTrace();
                            }
                        }
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            BufferedOutputStream bufferedOutputStream6 = new BufferedOutputStream(fileOutputStream);
                            try {
                                byte[] bArr4 = new byte[(int) this.mThumbRaf.length()];
                                this.mThumbRaf.read(bArr4);
                                bufferedOutputStream6.write(bArr4);
                                byte[] bArr5 = new byte[RFixConstants.MD5_FILE_BUF_LENGTH];
                                while (true) {
                                    int read = this.mRaf.read(bArr5);
                                    if (read == -1) {
                                        break;
                                    }
                                    bufferedOutputStream6.write(bArr5, 0, read);
                                }
                                long uptimeMillis2 = SystemClock.uptimeMillis();
                                ?? r16 = this.mProcessorReport.mReportInfo;
                                r16.put(ReportConstant.KEY_BDHGENERATE_COMBINE_FILE_TIME, String.valueOf(uptimeMillis2 - uptimeMillis));
                                try {
                                    bufferedOutputStream6.close();
                                    bufferedOutputStream = r16;
                                } catch (IOException e17) {
                                    e17.printStackTrace();
                                    bufferedOutputStream = e17;
                                }
                                fileOutputStream.close();
                                bufferedOutputStream2 = bufferedOutputStream;
                            } catch (FileNotFoundException e18) {
                                e = e18;
                                bufferedOutputStream4 = bufferedOutputStream6;
                                e.printStackTrace();
                                bufferedOutputStream2 = bufferedOutputStream4;
                                if (bufferedOutputStream4 != null) {
                                    try {
                                        bufferedOutputStream4.close();
                                        bufferedOutputStream2 = bufferedOutputStream4;
                                    } catch (IOException e19) {
                                        e19.printStackTrace();
                                        bufferedOutputStream2 = e19;
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                    bufferedOutputStream2 = bufferedOutputStream2;
                                }
                                return str;
                            } catch (IOException e26) {
                                e = e26;
                                bufferedOutputStream5 = bufferedOutputStream6;
                                e.printStackTrace();
                                bufferedOutputStream2 = bufferedOutputStream5;
                                if (bufferedOutputStream5 != null) {
                                    try {
                                        bufferedOutputStream5.close();
                                        bufferedOutputStream2 = bufferedOutputStream5;
                                    } catch (IOException e27) {
                                        e27.printStackTrace();
                                        bufferedOutputStream2 = e27;
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                    bufferedOutputStream2 = bufferedOutputStream2;
                                }
                                return str;
                            } catch (OutOfMemoryError e28) {
                                e = e28;
                                bufferedOutputStream3 = bufferedOutputStream6;
                                e.printStackTrace();
                                bufferedOutputStream2 = bufferedOutputStream3;
                                if (bufferedOutputStream3 != null) {
                                    try {
                                        bufferedOutputStream3.close();
                                        bufferedOutputStream2 = bufferedOutputStream3;
                                    } catch (IOException e29) {
                                        e29.printStackTrace();
                                        bufferedOutputStream2 = e29;
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                    bufferedOutputStream2 = bufferedOutputStream2;
                                }
                                return str;
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedOutputStream2 = bufferedOutputStream6;
                                if (bufferedOutputStream2 != null) {
                                    try {
                                        bufferedOutputStream2.close();
                                    } catch (IOException e36) {
                                        e36.printStackTrace();
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                        throw th;
                                    } catch (IOException e37) {
                                        e37.printStackTrace();
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                        } catch (FileNotFoundException e38) {
                            e = e38;
                        } catch (IOException e39) {
                            e = e39;
                        } catch (OutOfMemoryError e46) {
                            e = e46;
                        }
                    } catch (FileNotFoundException e47) {
                        e = e47;
                        fileOutputStream = null;
                    } catch (IOException e48) {
                        e = e48;
                        fileOutputStream = null;
                    }
                } catch (OutOfMemoryError e49) {
                    e = e49;
                    fileOutputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    fileOutputStream = null;
                }
            } catch (IOException e56) {
                e56.printStackTrace();
                bufferedOutputStream2 = e56;
            }
            return str;
        } catch (Throwable th7) {
            th = th7;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor
    public void recycleFD() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.recycleFD();
        RandomAccessFile randomAccessFile = this.mThumbRaf;
        if (randomAccessFile != null) {
            try {
                try {
                    randomAccessFile.close();
                } catch (IOException e16) {
                    QLog.e(BaseTransProcessor.TAG, 1, "recycleFD error!", e16);
                }
            } finally {
                this.mThumbRaf = null;
            }
        }
    }
}
