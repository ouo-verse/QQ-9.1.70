package com.tencent.mobileqq.profile.upload;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import mqq.app.AppRuntime;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.TicketManager;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.profile.upload.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    class C8246a implements MainTicketCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f260319a;

        C8246a(b bVar) {
            this.f260319a = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            }
        }

        @Override // mqq.manager.MainTicketCallback
        public void onFail(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            com.tencent.xaction.log.b.c("VipUploadUtils", 1, "getA2Bytes failure: " + i3 + str, null);
            this.f260319a.a(new byte[0]);
        }

        @Override // mqq.manager.MainTicketCallback
        public void onSuccess(MainTicketInfo mainTicketInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) mainTicketInfo);
            } else {
                com.tencent.xaction.log.b.d("VipUploadUtils", 1, "getA2Bytes success", null);
                this.f260319a.a(HexUtil.hexStr2Bytes(mainTicketInfo.getA2()));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface b {
        void a(byte[] bArr);
    }

    public static String a(String str) {
        String f16;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.length() < 204800) {
            f16 = g(file);
        } else {
            f16 = f(file);
        }
        if ("".equals(f16)) {
            return null;
        }
        return f16;
    }

    public static String b(AppInterface appInterface, String str) {
        return appInterface.getCurrentAccountUin() + System.currentTimeMillis();
    }

    public static void c(AppRuntime appRuntime, b bVar) {
        TicketManager ticketManager = (TicketManager) appRuntime.getManager(2);
        if (ticketManager.useAsyncTicketInterface()) {
            ticketManager.getA2(appRuntime.getLongAccountUin(), 16, new C8246a(bVar));
        } else {
            bVar.a(HexUtil.hexStr2Bytes(ticketManager.getA2(appRuntime.getCurrentAccountUin())));
        }
    }

    public static byte[] d(AppInterface appInterface) {
        return HexUtil.hexStr2Bytes(((TicketManager) appInterface.getManager(2)).getA2(appInterface.getCurrentAccountUin()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
    
        if (r3 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:
    
        if (r3 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap e(String str) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                } catch (Exception unused) {
                    bufferedInputStream = null;
                } catch (OutOfMemoryError unused2) {
                    bufferedInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream);
                    try {
                        bufferedInputStream.close();
                    } catch (Exception unused3) {
                    }
                    return decodeStream;
                } catch (Exception unused4) {
                } catch (OutOfMemoryError unused5) {
                } catch (Throwable th6) {
                    th = th6;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception unused6) {
                        }
                    }
                    throw th;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
    
        if (r4 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0052, code lost:
    
        if (r4 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x009f, code lost:
    
        if (r4 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x009b, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0099, code lost:
    
        if (r4 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a2, code lost:
    
        if (r4 == null) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String f(File file) {
        if (file != null && file.exists()) {
            long length = file.length();
            FileInputStream fileInputStream = null;
            try {
                if (length > 100) {
                    long j3 = length / 5;
                    byte[] bArr = new byte[32];
                    try {
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            fileInputStream2.skip(j3);
                            for (int i3 = 0; i3 < 4; i3++) {
                                fileInputStream2.read(bArr, i3 * 8, 8);
                                fileInputStream2.skip(j3 - 8);
                            }
                            String hexString = SecUtil.toHexString(bArr);
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused) {
                            }
                            return hexString;
                        } catch (FileNotFoundException unused2) {
                            fileInputStream = fileInputStream2;
                        } catch (IOException unused3) {
                            fileInputStream = fileInputStream2;
                        } catch (Throwable th5) {
                            th = th5;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused4) {
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException unused5) {
                    } catch (IOException unused6) {
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } else {
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                        messageDigest.reset();
                        FileInputStream fileInputStream3 = new FileInputStream(file);
                        try {
                            messageDigest.update(fileInputStream3.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, file.length()));
                            String hexString2 = SecUtil.toHexString(messageDigest.digest());
                            try {
                                fileInputStream3.close();
                            } catch (IOException unused7) {
                            }
                            return hexString2;
                        } catch (FileNotFoundException unused8) {
                            fileInputStream = fileInputStream3;
                        } catch (IOException unused9) {
                            fileInputStream = fileInputStream3;
                        } catch (NoSuchAlgorithmException unused10) {
                            fileInputStream = fileInputStream3;
                        } catch (Throwable th7) {
                            th = th7;
                            fileInputStream = fileInputStream3;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused11) {
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException unused12) {
                    } catch (IOException unused13) {
                    } catch (NoSuchAlgorithmException unused14) {
                    } catch (Throwable th8) {
                        th = th8;
                    }
                }
            } catch (IOException unused15) {
            }
        }
        return "";
    }

    private static String g(File file) {
        MessageDigest messageDigest;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.reset();
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException unused) {
        } catch (IOException unused2) {
        } catch (NoSuchAlgorithmException unused3) {
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            messageDigest.update(fileInputStream.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, file.length()));
            String hexString = SecUtil.toHexString(messageDigest.digest());
            try {
                fileInputStream.close();
            } catch (IOException unused4) {
            }
            return hexString;
        } catch (FileNotFoundException unused5) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 == null) {
                return "";
            }
            try {
                fileInputStream2.close();
            } catch (IOException unused6) {
                return "";
            }
        } catch (IOException unused7) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 == null) {
                return "";
            }
            fileInputStream2.close();
        } catch (NoSuchAlgorithmException unused8) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 == null) {
                return "";
            }
            fileInputStream2.close();
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused9) {
                }
            }
            throw th;
        }
    }
}
