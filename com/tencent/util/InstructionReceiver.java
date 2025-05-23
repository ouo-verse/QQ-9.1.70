package com.tencent.util;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.log.encrypt.XorKey;
import com.tencent.qphone.base.util.log.processor.XOREncryption;
import com.tencent.qphone.base.util.log.utils.MappedLogWriter;
import com.tencent.qphone.base.util.log.utils.MmapUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes27.dex */
public class InstructionReceiver {
    static IPatchRedirector $redirector_ = null;
    private static final int BUFFER_SIZE = 1024;
    private static final int COOKIE_PRINT = 1;
    private static final int FILELIST_PRINT = 4;
    private static final int FILE_COPY = 2;
    private static final int FILE_DELETE = 3;
    private static final String LOG_PATH;
    private static final int MB_IN_BYTE = 1048576;
    private static final int MMAP_BUFFER_SIZE = 8192;
    private static final String TAG = "InstructionReceiver";
    private static final int TEN_MINUTES_IN_MS = 600000;
    private static CmdHandler handler;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class CmdHandler extends Handler {
        static IPatchRedirector $redirector_;

        public CmdHandler(@NonNull @NotNull Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull @NotNull Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            HashMap hashMap = new HashMap((Map) message.obj);
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (QLog.isColorLevel()) {
                                QLog.d(InstructionReceiver.TAG, 1, "invalid cmd");
                                return;
                            }
                            return;
                        }
                        ThreadManagerV2.excute(new Runnable(hashMap) { // from class: com.tencent.util.InstructionReceiver.CmdHandler.4
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ Map f383948d;

                            {
                                this.f383948d = hashMap;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CmdHandler.this, (Object) hashMap);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                    InstructionReceiver.printFileList(this.f383948d);
                                } else {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
                            }
                        }, 64, null, false);
                        return;
                    }
                    ThreadManagerV2.excute(new Runnable(hashMap) { // from class: com.tencent.util.InstructionReceiver.CmdHandler.3
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ Map f383947d;

                        {
                            this.f383947d = hashMap;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CmdHandler.this, (Object) hashMap);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            String str = (String) this.f383947d.get("file_name");
                            if (str != null) {
                                InstructionReceiver.deleteFile(new File(str));
                            } else if (QLog.isColorLevel()) {
                                QLog.d(InstructionReceiver.TAG, 1, "filePath is null");
                            }
                        }
                    }, 64, null, false);
                    return;
                }
                ThreadManagerV2.excute(new Runnable(hashMap) { // from class: com.tencent.util.InstructionReceiver.CmdHandler.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Map f383946d;

                    {
                        this.f383946d = hashMap;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CmdHandler.this, (Object) hashMap);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        String str = (String) this.f383946d.get("file_name");
                        if (str != null) {
                            InstructionReceiver.copyFileToLogPathWithEncryption(str, this.f383946d);
                        } else if (QLog.isColorLevel()) {
                            QLog.d(InstructionReceiver.TAG, 1, "filePath is null");
                        }
                    }
                }, 64, null, false);
                return;
            }
            ThreadManagerV2.excute(new Runnable(hashMap) { // from class: com.tencent.util.InstructionReceiver.CmdHandler.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Map f383945d;

                {
                    this.f383945d = hashMap;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CmdHandler.this, (Object) hashMap);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        InstructionReceiver.printCookies(this.f383945d);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 64, null, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class Innerclass {
        static IPatchRedirector $redirector_;
        private static final InstructionReceiver INSTRUCTION_RECEIVER;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44127);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                INSTRUCTION_RECEIVER = new InstructionReceiver();
            }
        }

        Innerclass() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44128);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        LOG_PATH = QLog.getLogExternalPath(BaseApplication.context) + "/tencent/msflogs/com/tencent/mobileqq/";
    }

    InstructionReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            handler = new CmdHandler(Looper.getMainLooper());
        }
    }

    private static void checkSizeAndDelete(Map<String, String> map, String str, String str2) {
        File file = new File(str);
        if (map.get("max_size") != null) {
            if (file.length() >= Integer.parseInt(r3) * 1048576) {
                QLog.e(TAG, 1, "\u8d85\u8fc7\u5927\u5c0f\u9650\u5236");
            }
        }
        deleteFile(new File(str2));
        deleteFileLater(file);
    }

    private static void closeStream(MappedLogWriter mappedLogWriter, FileInputStream fileInputStream) {
        if (mappedLogWriter != null) {
            try {
                mappedLogWriter.close();
            } catch (IOException unused) {
                QLog.e(TAG, 1, "close stream failed");
                return;
            }
        }
        if (fileInputStream != null) {
            fileInputStream.close();
        }
    }

    static void copyFileToLogPathWithEncryption(String str, Map<String, String> map) {
        FileInputStream fileInputStream;
        MappedLogWriter mappedLogWriter = null;
        try {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                String xorKey = XOREncryption.getXorKey();
                String encryptedKey = XorKey.encryptedKey(xorKey);
                if (!TextUtils.isEmpty(xorKey) && !TextUtils.isEmpty(encryptedKey)) {
                    StringBuilder sb5 = new StringBuilder();
                    String str2 = LOG_PATH;
                    sb5.append(str2);
                    sb5.append(getFileName(file));
                    String sb6 = sb5.toString();
                    File file2 = new File(sb6);
                    if (file2.exists()) {
                        deleteFile(file2);
                        QLog.e(TAG, 1, "targetFile had exist\uff0cdelete and return\uff01");
                        closeStream(null, null);
                        return;
                    }
                    String str3 = str2 + file2.getName() + ".mmapCacheLog.log";
                    Charset charset = XOREncryption.charset;
                    byte[] bytes = encryptedKey.getBytes(charset);
                    byte[] bytes2 = xorKey.getBytes(charset);
                    MappedByteBuffer mmapFileByPath = MmapUtil.getMmapFileByPath(str3, 8192);
                    mmapFileByPath.putInt(bytes.length);
                    mmapFileByPath.put(bytes);
                    mmapFileByPath.flip();
                    MappedLogWriter mappedLogWriter2 = new MappedLogWriter(sb6);
                    try {
                        mappedLogWriter2.writeThroughMmapBuffer(mmapFileByPath);
                        fileInputStream = new FileInputStream(file);
                    } catch (Exception e16) {
                        e = e16;
                        fileInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = null;
                    }
                    try {
                        encryptionWriteToTargetFile(mappedLogWriter2, fileInputStream, bytes2);
                        QLog.d(TAG, 1, "copy file " + file.getName() + " -- succeed");
                        checkSizeAndDelete(map, sb6, str3);
                        closeStream(mappedLogWriter2, fileInputStream);
                        return;
                    } catch (Exception e17) {
                        e = e17;
                        mappedLogWriter = mappedLogWriter2;
                        try {
                            QLog.e(TAG, 1, "copy file:" + str + "-- failed", e);
                            closeStream(mappedLogWriter, fileInputStream);
                            return;
                        } catch (Throwable th6) {
                            th = th6;
                            closeStream(mappedLogWriter, fileInputStream);
                            throw th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        mappedLogWriter = mappedLogWriter2;
                        closeStream(mappedLogWriter, fileInputStream);
                        throw th;
                    }
                }
                closeStream(null, null);
                return;
            }
            QLog.e(TAG, 1, "open file error ,filePath:" + str);
            closeStream(null, null);
        } catch (Exception e18) {
            e = e18;
            fileInputStream = null;
        } catch (Throwable th8) {
            th = th8;
            fileInputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void deleteFile(File file) {
        try {
            if ((!file.exists() || !file.isFile()) && QLog.isColorLevel()) {
                QLog.d(TAG, 1, "file has been deleted or");
            }
            if (file.delete()) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 1, "delete file " + file.getName() + " -- succeed");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "delete file " + file.getName() + " -- fail");
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.toString());
        }
    }

    private static void deleteFileLater(File file) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, Long.valueOf(System.currentTimeMillis()));
        }
        handler.postDelayed(new Runnable(file) { // from class: com.tencent.util.InstructionReceiver.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ File f383944d;

            {
                this.f383944d = file;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) file);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(InstructionReceiver.TAG, 1, Long.valueOf(System.currentTimeMillis()));
                }
                InstructionReceiver.deleteFile(this.f383944d);
            }
        }, 600000L);
    }

    private static void encryptionWriteToTargetFile(MappedLogWriter mappedLogWriter, FileInputStream fileInputStream, byte[] bArr) throws IOException {
        byte[] bArr2 = new byte[1024];
        int i3 = 0;
        while (true) {
            int read = fileInputStream.read(bArr2);
            if (-1 != read) {
                int i16 = 0;
                while (i16 < read) {
                    if (i3 == bArr.length) {
                        i3 = 0;
                    }
                    bArr2[i16] = (byte) (bArr[i3] ^ bArr2[i16]);
                    i16++;
                    i3++;
                }
                if (read < 1024) {
                    byte[] bArr3 = new byte[read];
                    for (int i17 = 0; i17 < read; i17++) {
                        bArr3[i17] = bArr2[i17];
                    }
                    mappedLogWriter.writeThroughByteArray(bArr3);
                } else {
                    mappedLogWriter.writeThroughByteArray(bArr2);
                }
            } else {
                return;
            }
        }
    }

    private static String getFileName(File file) {
        String name = file.getName();
        QLog.i(TAG, 1, "origin fileName:" + name);
        if (!name.startsWith(QLog.getPackageName())) {
            if (!name.contains(".")) {
                name = name + ".log";
            }
            String str = QLog.getPackageName() + ".instruction_upload." + name;
            String substring = str.substring(0, str.lastIndexOf("."));
            String substring2 = str.substring(str.lastIndexOf("."));
            Calendar calendar = Calendar.getInstance();
            calendar.set(calendar.get(1), (calendar.get(2) + 1) - 1, calendar.get(5), calendar.get(11), 0, 0);
            name = substring + "." + QLog.getLogFileFormatter().format(Long.valueOf(calendar.getTimeInMillis())) + substring2;
        }
        if (!name.endsWith(".log") && !name.endsWith(".log.zip") && !name.endsWith(".qlog")) {
            String str2 = name.substring(0, name.lastIndexOf(".")) + ".log";
            QLog.i(TAG, 1, "after transform fileName:" + str2);
            return str2;
        }
        QLog.i(TAG, 1, "after transform fileName:" + name);
        return name;
    }

    public static InstructionReceiver getInstance() {
        return Innerclass.INSTRUCTION_RECEIVER;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"DefaultLocale"})
    public static void printFileList(Map<String, String> map) {
        double d16;
        if (map == null) {
            QLog.e(TAG, 1, "paramMap is null");
            return;
        }
        String str = map.get("file_dir");
        if (str == null) {
            QLog.e(TAG, 1, "dir is null");
            return;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            try {
                QLog.i(TAG, 1, "fileListPrint at " + str + ":");
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        try {
                            d16 = file2.length();
                        } catch (Exception e16) {
                            QLog.e(TAG, 1, e16.toString());
                            d16 = 0.0d;
                        }
                        QLog.i(TAG, 1, "\t" + file2.getName() + " -- fileSize: " + String.format("%.4f", Double.valueOf(d16 / 1048576.0d)) + "MB");
                    }
                    return;
                }
                return;
            } catch (Exception e17) {
                QLog.e(TAG, 1, e17.toString());
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "dir not exist");
        }
    }

    public void analyzeInstruction(int i3, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) map);
        } else {
            if (map == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 1, "params is null");
                    return;
                }
                return;
            }
            Message.obtain(handler, i3, map).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void printCookies(Map<String, String> map) {
    }
}
