package com.tencent.qqnt.aio.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u001a\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002J,\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J4\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0019\u001a\u00020\u0018J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/aio/utils/ah;", "", "", "uin", WadlProxyConsts.PARAM_FILENAME, "", TagName.FILE_TYPE, "", "md5", "Lcom/tencent/qqnt/aio/utils/ah$a;", "a", "fileInfo", "", "b", "e", "g", "Landroid/text/format/Time;", "t", "f", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "targetPath", "c", tl.h.F, "", "needCreate", "i", "voiceType", "filePath", "d", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ah {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ah f352287a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B#\b\u0000\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\t\u0010\u0005\"\u0004\b\r\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/utils/ah$a;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "fileDir", "b", "c", "f", "suffix", "e", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String fileDir;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String suffix;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String name;

        public a(@NotNull String fileDir, @Nullable String str, @NotNull String name) {
            Intrinsics.checkNotNullParameter(fileDir, "fileDir");
            Intrinsics.checkNotNullParameter(name, "name");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, fileDir, str, name);
                return;
            }
            this.fileDir = fileDir;
            this.suffix = str;
            this.name = name;
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.fileDir;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.name;
        }

        @Nullable
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.suffix;
        }

        public final void d(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.fileDir = str;
            }
        }

        public final void e(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.name = str;
            }
        }

        public final void f(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            } else {
                this.suffix = str;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47964);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f352287a = new ah();
        }
    }

    ah() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final a a(String uin, String fileName, int fileType, byte[] md5) {
        a aVar = new a(AppConstants.SDCARD_PATH + uin + "/", null, "");
        if (fileType == 2) {
            b(fileName, aVar);
        }
        return aVar;
    }

    private final void b(String fileName, a fileInfo) {
        fileInfo.d(fileInfo.a() + FileMsg.FILE_PTT_DIR + e() + "/");
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(fileInfo.a());
        Intrinsics.checkNotNullExpressionValue(sDKPrivatePath, "getSDKPrivatePath(fileInfo.fileDir)");
        fileInfo.d(sDKPrivatePath);
        fileInfo.f(".amr");
        if (fileName == null) {
            if (QLog.isColorLevel()) {
                QLog.i("TransFileUtils", 2, "pttdown,33333");
            }
            fileInfo.e("stream_" + g());
            if (QLog.isColorLevel()) {
                QLog.i("TransFileUtils", 2, "pttdown,name = " + fileInfo.b());
            }
        }
    }

    private final String e() {
        Time time = new Time();
        time.setToNow();
        return f(time);
    }

    private final String f(Time t16) {
        StringBuilder sb5;
        int i3 = t16.month;
        int i16 = i3 + 1;
        int i17 = i3 + 1;
        if (i16 > 9) {
            sb5 = new StringBuilder();
        } else {
            sb5 = new StringBuilder();
            sb5.append("0");
        }
        sb5.append(i17);
        String sb6 = sb5.toString();
        return t16.year + sb6 + "/" + t16.monthDay;
    }

    private final synchronized String g() {
        String format;
        try {
            LockMethodProxy.sleep(1L);
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
        format = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date(System.currentTimeMillis()));
        Intrinsics.checkNotNullExpressionValue(format, "sdfTimeb.format(d)");
        return format;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ad A[Catch: IOException -> 0x00a9, TRY_LEAVE, TryCatch #0 {IOException -> 0x00a9, blocks: (B:60:0x00a5, B:51:0x00ad), top: B:59:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String c(@Nullable Uri uri, @Nullable String targetPath) {
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uri, (Object) targetPath);
        }
        if (uri == null || TextUtils.isEmpty(targetPath)) {
            return "";
        }
        InputStream inputStream2 = null;
        r3 = null;
        r3 = null;
        String str = null;
        try {
            try {
                inputStream = BaseApplication.getContext().getContentResolver().openInputStream(uri);
            } catch (IOException e16) {
                e = e16;
                inputStream = null;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
            }
        } catch (IOException e17) {
            QLog.e("TransFileUtils", 1, "copyFileFromInputStreamUri exception", e17);
        }
        if (inputStream == null) {
            return "";
        }
        try {
            File file = new File(targetPath);
            if (file.exists()) {
                file.delete();
            }
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
                fileOutputStream2.flush();
                str = file.getPath();
                inputStream.close();
                fileOutputStream2.close();
            } catch (IOException e18) {
                fileOutputStream = fileOutputStream2;
                e = e18;
                try {
                    QLog.e("TransFileUtils", 1, "copyFileFromInputStreamUri exception", e);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return str;
                } catch (Throwable th6) {
                    th = th6;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e19) {
                            QLog.e("TransFileUtils", 1, "copyFileFromInputStreamUri exception", e19);
                            throw th;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                        throw th;
                    }
                    throw th;
                }
            } catch (Throwable th7) {
                inputStream2 = inputStream;
                fileOutputStream = fileOutputStream2;
                th = th7;
                if (inputStream2 != null) {
                }
                if (fileOutputStream != null) {
                }
            }
        } catch (IOException e26) {
            e = e26;
            fileOutputStream = null;
        } catch (Throwable th8) {
            th = th8;
            fileOutputStream = null;
            inputStream2 = inputStream;
            if (inputStream2 != null) {
            }
            if (fileOutputStream != null) {
            }
        }
        return str;
    }

    @Nullable
    public final String d(int voiceType, @Nullable String filePath) {
        boolean endsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, voiceType, (Object) filePath);
        }
        if (TextUtils.isEmpty(filePath)) {
            return null;
        }
        if (voiceType == 1) {
            Intrinsics.checkNotNull(filePath);
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(filePath, ".amr", false, 2, null);
            if (endsWith$default) {
                String substring = filePath.substring(0, filePath.length() - 4);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                filePath = substring + ".slk";
            }
        }
        return VFSAssistantUtils.getSDKPrivatePath(filePath);
    }

    @Nullable
    public final String h(@NotNull String uin, @Nullable String fileName, int fileType, @Nullable byte[] md5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, uin, fileName, Integer.valueOf(fileType), md5);
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        return i(uin, fileName, fileType, md5, true);
    }

    @Nullable
    public final String i(@NotNull String uin, @Nullable String fileName, int fileType, @Nullable byte[] md5, boolean needCreate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, this, uin, fileName, Integer.valueOf(fileType), md5, Boolean.valueOf(needCreate));
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        a a16 = a(uin, fileName, fileType, md5);
        if (QLog.isColorLevel()) {
            QLog.d("TransFileUtils", 2, "getTransferFilePath dir: " + a16.a());
        }
        File file = new File(a16.a());
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(a16.a() + a16.b() + a16.c());
        if (needCreate && !file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException unused) {
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TransFileUtils", 2, "getTransferFilePath : " + file2.getAbsoluteFile());
        }
        return file2.getAbsoluteFile().toString();
    }
}
