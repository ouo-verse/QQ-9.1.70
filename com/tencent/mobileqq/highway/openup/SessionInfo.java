package com.tencent.mobileqq.highway.openup;

import com.tencent.mobileqq.highway.protocol.HwSessionInfoPersistentPB;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes9.dex */
public class SessionInfo {
    static IPatchRedirector $redirector_ = null;
    private static final String HW_SESSION_EXT_NAME = ".highways";
    private static final String HW_SESSION_INFO_DIRNAME = "highway_session_info_dir";
    private static final String HW_SESSION_INFO_FILENAME = "highway_session_info";
    private static volatile SessionInfo sessionInfo;
    private byte[] bytes_httpconn_sig_session;
    private byte[] bytes_session_key;
    private String mUin;

    SessionInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.bytes_httpconn_sig_session = null;
        this.bytes_session_key = null;
        this.mUin = str;
        loadFromDisk(str);
    }

    public static synchronized void clearOldSession() {
        synchronized (SessionInfo.class) {
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "SessionInfo.clearOldSession");
            BaseApplication context = BaseApplication.getContext();
            if (context == null) {
                return;
            }
            File file = new File(context.getFilesDir(), HW_SESSION_INFO_FILENAME);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static SessionInfo getInstance(String str) {
        synchronized (SessionInfo.class) {
            if (sessionInfo == null || sessionInfo.mUin == null || !sessionInfo.mUin.equals(str)) {
                sessionInfo = new SessionInfo(str);
                QLog.d(BdhLogUtil.Tag, 1, "SessionInfo getInstance:" + str);
            }
        }
        return sessionInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.ByteArrayOutputStream] */
    private void loadFromDisk(String str) {
        BaseApplication context;
        FileInputStream fileInputStream;
        if (str == null || (context = BaseApplication.getContext()) == null) {
            return;
        }
        QLog.d(BdhLogUtil.Tag, 1, "SessionInfo.loadFromDisk uin:" + str);
        File file = new File(new File(context.getFilesDir(), HW_SESSION_INFO_DIRNAME), str + HW_SESSION_EXT_NAME);
        boolean exists = file.exists();
        ?? r26 = file;
        if (!exists) {
            File file2 = new File(context.getFilesDir(), HW_SESSION_INFO_FILENAME);
            boolean exists2 = file2.exists();
            r26 = file2;
            if (!exists2) {
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "SessionInfo.loadFromDisk erro : file not exits");
                return;
            }
        }
        HwSessionInfoPersistentPB.HwSessionInfoPB hwSessionInfoPB = new HwSessionInfoPersistentPB.HwSessionInfoPB();
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream((File) r26);
                    try {
                        r26 = new ByteArrayOutputStream();
                    } catch (InvalidProtocolBufferMicroException e16) {
                        e = e16;
                        r26 = 0;
                    } catch (IOException e17) {
                        e = e17;
                        r26 = 0;
                    } catch (Throwable th5) {
                        th = th5;
                        r26 = 0;
                    }
                } catch (InvalidProtocolBufferMicroException e18) {
                    e = e18;
                    r26 = 0;
                } catch (IOException e19) {
                    e = e19;
                    r26 = 0;
                } catch (Throwable th6) {
                    th = th6;
                    r26 = 0;
                }
                try {
                    byte[] bArr = new byte[128];
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 128);
                        if (read == -1) {
                            break;
                        } else {
                            r26.write(bArr, 0, read);
                        }
                    }
                    r26.flush();
                    hwSessionInfoPB.mergeFrom(r26.toByteArray());
                    if (hwSessionInfoPB.bytes_httpconn_sig_session.has()) {
                        this.bytes_httpconn_sig_session = hwSessionInfoPB.bytes_httpconn_sig_session.get().toByteArray();
                    }
                    if (hwSessionInfoPB.bytes_session_key.has()) {
                        this.bytes_session_key = hwSessionInfoPB.bytes_session_key.get().toByteArray();
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException e26) {
                        BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, "SessionInfo.loadFromDisk erro ", e26);
                    }
                    r26.close();
                } catch (InvalidProtocolBufferMicroException e27) {
                    e = e27;
                    fileInputStream2 = fileInputStream;
                    r26 = r26;
                    BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, "SessionInfo.loadFromDisk erro ", e);
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e28) {
                            BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, "SessionInfo.loadFromDisk erro ", e28);
                        }
                    }
                    if (r26 != 0) {
                        r26.close();
                    }
                } catch (IOException e29) {
                    e = e29;
                    fileInputStream2 = fileInputStream;
                    r26 = r26;
                    BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, "SessionInfo.loadFromDisk erro ", e);
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e36) {
                            BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, "SessionInfo.loadFromDisk erro ", e36);
                        }
                    }
                    if (r26 != 0) {
                        r26.close();
                    }
                } catch (Throwable th7) {
                    th = th7;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e37) {
                            BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, "SessionInfo.loadFromDisk erro ", e37);
                        }
                    }
                    if (r26 != 0) {
                        try {
                            r26.close();
                            throw th;
                        } catch (IOException e38) {
                            BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, "SessionInfo.loadFromDisk erro ", e38);
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th8) {
                th = th8;
            }
        } catch (IOException e39) {
            BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, "SessionInfo.loadFromDisk erro ", e39);
        }
    }

    public static synchronized void updateSessionInfo(byte[] bArr, byte[] bArr2, String str) {
        synchronized (SessionInfo.class) {
            QLog.d(BdhLogUtil.Tag, 1, "updateSessionInfo:" + BdhUtils.bytes2HexStr(bArr) + " uin:" + str);
            if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0 && str != null) {
                clearOldSession();
                if (write2Disk(bArr, bArr2, str)) {
                    sessionInfo = null;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean write2Disk(byte[] bArr, byte[] bArr2, String str) {
        BaseApplication context = BaseApplication.getContext();
        boolean z16 = false;
        if (context == null) {
            return false;
        }
        File file = new File(context.getFilesDir(), HW_SESSION_INFO_DIRNAME);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file.getPath(), str + HW_SESSION_EXT_NAME);
        if (file2.exists()) {
            file2.delete();
        }
        FileOutputStream fileOutputStream = null;
        fileOutputStream = null;
        fileOutputStream = null;
        fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                    try {
                        HwSessionInfoPersistentPB.HwSessionInfoPB hwSessionInfoPB = new HwSessionInfoPersistentPB.HwSessionInfoPB();
                        hwSessionInfoPB.bytes_httpconn_sig_session.set(ByteStringMicro.copyFrom(bArr));
                        hwSessionInfoPB.bytes_session_key.set(ByteStringMicro.copyFrom(bArr2));
                        fileOutputStream2.write(hwSessionInfoPB.toByteArray());
                        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "SessionInfo.write2Disk Succeed.");
                        fileOutputStream2.close();
                        z16 = true;
                        fileOutputStream = hwSessionInfoPB;
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        fileOutputStream = fileOutputStream2;
                        BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, "SessionInfo.write2Disk erro", e);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                            fileOutputStream = fileOutputStream;
                        }
                        return z16;
                    } catch (IOException e17) {
                        e = e17;
                        fileOutputStream = fileOutputStream2;
                        BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, "SessionInfo.write2Disk erro", e);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                            fileOutputStream = fileOutputStream;
                        }
                        return z16;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e18) {
                                BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, "SessionInfo.write2Disk erro", e18);
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e19) {
                    e = e19;
                } catch (IOException e26) {
                    e = e26;
                }
            } catch (IOException e27) {
                BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, "SessionInfo.write2Disk erro", e27);
            }
            return z16;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public byte[] getHttpconn_sig_session() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.bytes_httpconn_sig_session;
    }

    public byte[] getSessionKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.bytes_session_key;
    }
}
