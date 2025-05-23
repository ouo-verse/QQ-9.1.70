package com.tencent.rmonitor.common.util;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.bugly.common.privacy.PrivacyInformation;
import com.tencent.bugly.common.utils.MD5Utils;
import com.tencent.bugly.common.utils.ProcessUtil;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.rmonitor.common.logger.Logger;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/rmonitor/common/util/FileUtil;", "", "d", "Companion", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class FileUtil {

    /* renamed from: b, reason: collision with root package name */
    private static String f365516b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private static Application f365517c;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    private static String f365515a = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b9\u0010:J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0007J$\u0010\u000b\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0007J$\u0010\r\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0007J\u001c\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u0002H\u0007J\u001a\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0007J\u001a\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0007J\u001a\u0010#\u001a\u0004\u0018\u00010\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0010H\u0007J\u0016\u0010&\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u001bJ*\u0010+\u001a\u00020\u00062\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010'2\u0006\u0010)\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u0006H\u0007J\u0010\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0002H\u0007R$\u0010/\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0016\u00105\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u00107\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00106R\u0014\u00108\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b8\u00106\u00a8\u0006;"}, d2 = {"Lcom/tencent/rmonitor/common/util/FileUtil$Companion;", "", "", h.F, "f", "filePath", "", "b", "fileStr", "text", "isAppend", "p", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/io/BufferedOutputStream;", "g", "Ljava/io/File;", "file", "", "c", "i", "j", "prefix", "suffix", "l", "Ljava/io/InputStream;", "inputStream", "", "bufferSize", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/io/InputStreamReader;", "inputStreamReader", DomainData.DOMAIN_NAME, TtmlNode.ATTR_TTS_ORIGIN, "dist", "a", QzoneZipCacheHelper.DIR, "time", "d", "", "allFiles", "outputPath", "isGzip", "r", "soPath", "k", "Landroid/app/Application;", "app", "Landroid/app/Application;", "e", "()Landroid/app/Application;", "o", "(Landroid/app/Application;)V", "RMONITOR_ROOT", "Ljava/lang/String;", "SDPath", "TAG", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        private final String f() {
            File file;
            Context applicationContext;
            File file2;
            String str;
            Context applicationContext2;
            if (!TextUtils.isEmpty(FileUtil.f365516b)) {
                return FileUtil.f365516b;
            }
            String str2 = null;
            try {
                Application e16 = e();
                if (e16 != null && (applicationContext2 = e16.getApplicationContext()) != null) {
                    file2 = applicationContext2.getExternalFilesDir("/Tencent/RMonitor");
                } else {
                    file2 = null;
                }
                if (file2 != null) {
                    str = file2.getAbsolutePath();
                } else {
                    str = null;
                }
                FileUtil.f365516b = str;
            } catch (Throwable th5) {
                Logger.f365497g.c("RMonitor_common_FileUtil", th5);
            }
            try {
                if (FileUtil.f365516b == null) {
                    Application e17 = e();
                    if (e17 != null && (applicationContext = e17.getApplicationContext()) != null) {
                        file = applicationContext.getDir("Tencent_RMonitor", 0);
                    } else {
                        file = null;
                    }
                    if (file != null) {
                        str2 = file.getAbsolutePath();
                    }
                    FileUtil.f365516b = str2;
                }
            } catch (Throwable th6) {
                Logger.f365497g.c("RMonitor_common_FileUtil", th6);
            }
            FileUtil.f365516b = Intrinsics.stringPlus(FileUtil.f365516b, File.separator + h());
            String c16 = a.INSTANCE.c(e());
            Logger.f365497g.i("RMonitor_common_FileUtil", "Process: " + c16 + " ,SDPath: " + FileUtil.f365516b);
            String str3 = FileUtil.f365516b;
            if (str3 == null) {
                return "";
            }
            return str3;
        }

        private final String h() {
            boolean contains$default;
            int lastIndexOf$default;
            try {
                if (e() == null || ProcessUtil.INSTANCE.isMainProcess(e())) {
                    return "main";
                }
                String c16 = a.INSTANCE.c(e());
                Charset charset = Charsets.UTF_8;
                if (c16 != null) {
                    byte[] bytes = c16.getBytes(charset);
                    Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                    String md5 = MD5Utils.getMD5(bytes);
                    if (md5 == null) {
                        contains$default = StringsKt__StringsKt.contains$default((CharSequence) c16, (CharSequence) ":", false, 2, (Object) null);
                        if (!contains$default) {
                            return "main";
                        }
                        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) c16, ":", 0, false, 6, (Object) null);
                        String substring = c16.substring(lastIndexOf$default + 1);
                        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                        return substring;
                    }
                    return md5;
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            } catch (Throwable th5) {
                Logger.f365497g.c("RMonitor_common_FileUtil", th5);
                return "main";
            }
        }

        @JvmStatic
        @Nullable
        public final File a(@NotNull File origin, @NotNull File dist) {
            Intrinsics.checkParameterIsNotNull(origin, "origin");
            Intrinsics.checkParameterIsNotNull(dist, "dist");
            try {
                return FilesKt.copyTo$default(origin, dist, true, 0, 4, null);
            } catch (Exception e16) {
                Logger.f365497g.c("RMonitor_common_FileUtil", e16);
                return null;
            }
        }

        @JvmStatic
        public final boolean b(@Nullable String filePath) {
            boolean z16;
            if (filePath == null) {
                return false;
            }
            File file = new File(filePath);
            if (file.exists()) {
                return true;
            }
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null && (parentFile.exists() || parentFile.mkdirs())) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    return false;
                }
                if (!file.createNewFile()) {
                    return false;
                }
                return true;
            } catch (IOException e16) {
                Logger.f365497g.c("RMonitor_common_FileUtil", e16);
                return false;
            }
        }

        @JvmStatic
        public final void c(@Nullable File file) {
            File[] fileArr;
            if (file == null || !file.exists()) {
                return;
            }
            if (file.isFile()) {
                try {
                    file.delete();
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            try {
                fileArr = file.listFiles();
            } catch (Throwable unused2) {
                fileArr = null;
            }
            if (fileArr != null) {
                for (File file2 : fileArr) {
                    FileUtil.INSTANCE.c(file2);
                }
            }
            try {
                file.delete();
            } catch (Throwable unused3) {
            }
        }

        public final void d(@NotNull String dir, int time) {
            Sequence<File> filter;
            Intrinsics.checkParameterIsNotNull(dir, "dir");
            try {
                if (!TextUtils.isEmpty(dir) && new File(dir).exists()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    filter = SequencesKt___SequencesKt.filter(FilesKt.walk$default(new File(dir), null, 1, null), new Function1<File, Boolean>() { // from class: com.tencent.rmonitor.common.util.FileUtil$Companion$deleteOvertimeFiles$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(File file) {
                            return Boolean.valueOf(invoke2(file));
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final boolean invoke2(@NotNull File it) {
                            Intrinsics.checkParameterIsNotNull(it, "it");
                            return it.isFile();
                        }
                    });
                    for (File file : filter) {
                        if (currentTimeMillis - file.lastModified() > time) {
                            file.delete();
                        }
                    }
                }
            } catch (Throwable th5) {
                Logger.f365497g.c("RMonitor_common_FileUtil", th5);
            }
        }

        @Nullable
        public final Application e() {
            return FileUtil.f365517c;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
        
            r0 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(r7, r8), 8192);
         */
        @JvmStatic
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final synchronized BufferedOutputStream g(@Nullable String fileStr, boolean isAppend) {
            boolean z16;
            BufferedOutputStream bufferedOutputStream = null;
            if (fileStr == null) {
                return null;
            }
            try {
                File file = new File(fileStr);
                File parentFile = file.getParentFile();
                boolean z17 = true;
                if (parentFile != null && (parentFile.exists() || parentFile.mkdirs())) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if ((!z16 || !file.exists()) && !file.createNewFile()) {
                    z17 = false;
                }
                return bufferedOutputStream;
            } catch (IOException e16) {
                Logger.f365497g.b("RMonitor_common_FileUtil", "write file " + fileStr + " error. ", e16);
                return null;
            }
        }

        @JvmStatic
        @NotNull
        public final String i() {
            boolean z16;
            if (FileUtil.f365515a.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                String f16 = f();
                if (f16 == null) {
                    f16 = "";
                }
                FileUtil.f365515a = f16;
            }
            return FileUtil.f365515a;
        }

        @JvmStatic
        @NotNull
        public final String j() {
            boolean endsWith$default;
            String i3 = i();
            String str = File.separator;
            Intrinsics.checkExpressionValueIsNotNull(str, "File.separator");
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(i3, str, false, 2, null);
            if (endsWith$default) {
                return i3 + FaceUtil.IMG_TEMP + str;
            }
            return i3 + str + FaceUtil.IMG_TEMP + str;
        }

        @JvmStatic
        public final boolean k(@NotNull String soPath) {
            Intrinsics.checkParameterIsNotNull(soPath, "soPath");
            PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
            if (privacyInformation.isX86CPU()) {
                return false;
            }
            try {
                System.loadLibrary(soPath);
                return true;
            } catch (Throwable th5) {
                Logger.f365497g.c("RMonitor_common_FileUtil", th5);
                return false;
            }
        }

        @JvmStatic
        @NotNull
        public final String l(@NotNull String prefix, @NotNull String suffix) {
            Intrinsics.checkParameterIsNotNull(prefix, "prefix");
            Intrinsics.checkParameterIsNotNull(suffix, "suffix");
            return prefix + util.base64_pad_url + System.currentTimeMillis() + util.base64_pad_url + Random.INSTANCE.nextInt(0, 1000) + '.' + suffix;
        }

        @JvmStatic
        @NotNull
        public final String m(@NotNull InputStream inputStream, int bufferSize) {
            Intrinsics.checkParameterIsNotNull(inputStream, "inputStream");
            return n(new InputStreamReader(inputStream), bufferSize);
        }

        @JvmStatic
        @NotNull
        public final String n(@NotNull InputStreamReader inputStreamReader, int bufferSize) {
            Intrinsics.checkParameterIsNotNull(inputStreamReader, "inputStreamReader");
            StringBuffer stringBuffer = new StringBuffer(1024);
            try {
                Iterator<T> it = TextStreamsKt.readLines(new BufferedReader(inputStreamReader, bufferSize)).iterator();
                while (it.hasNext()) {
                    stringBuffer.append((String) it.next());
                    stringBuffer.append("\n");
                }
            } catch (Throwable th5) {
                Logger.f365497g.c("RMonitor_common_FileUtil", th5);
            }
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkExpressionValueIsNotNull(stringBuffer2, "sb.toString()");
            return stringBuffer2;
        }

        public final void o(@Nullable Application application) {
            FileUtil.f365517c = application;
        }

        @JvmStatic
        public final boolean p(@Nullable String fileStr, @Nullable String text, boolean isAppend) {
            if (text != null) {
                Companion companion = FileUtil.INSTANCE;
                byte[] bytes = text.getBytes(Charsets.UTF_8);
                Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                return companion.q(fileStr, bytes, isAppend);
            }
            return false;
        }

        @JvmStatic
        public final synchronized boolean q(@Nullable String fileStr, @Nullable byte[] text, boolean isAppend) {
            boolean z16;
            try {
                BufferedOutputStream g16 = g(fileStr, isAppend);
                if (g16 != null) {
                    if (text != null) {
                        try {
                            g16.write(text);
                            Unit unit = Unit.INSTANCE;
                        } finally {
                        }
                    }
                    CloseableKt.closeFinally(g16, null);
                }
                z16 = true;
            } catch (IOException e16) {
                Logger.f365497g.b("RMonitor_common_FileUtil", "write file " + fileStr + " error. ", e16);
                z16 = false;
            }
            return z16;
        }

        @JvmStatic
        public final boolean r(@Nullable List<String> allFiles, @NotNull String outputPath, boolean isGzip) {
            DeflaterOutputStream zipOutputStream;
            DeflaterOutputStream deflaterOutputStream;
            DeflaterOutputStream deflaterOutputStream2;
            Intrinsics.checkParameterIsNotNull(outputPath, "outputPath");
            try {
                File file = new File(outputPath);
                FileUtil.INSTANCE.b(file.getAbsolutePath());
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                if (isGzip) {
                    zipOutputStream = new GZIPOutputStream(new BufferedOutputStream(fileOutputStream));
                } else {
                    zipOutputStream = new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
                }
                if (allFiles != null) {
                    try {
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : allFiles) {
                            if (new File((String) obj).exists()) {
                                arrayList.add(obj);
                            }
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            File file2 = new File((String) it.next());
                            if (!isGzip) {
                                if (!(zipOutputStream instanceof ZipOutputStream)) {
                                    deflaterOutputStream2 = null;
                                } else {
                                    deflaterOutputStream2 = zipOutputStream;
                                }
                                ZipOutputStream zipOutputStream2 = (ZipOutputStream) deflaterOutputStream2;
                                if (zipOutputStream2 != null) {
                                    zipOutputStream2.putNextEntry(new ZipEntry(file2.getName()));
                                }
                            }
                            FileInputStream fileInputStream = new FileInputStream(file2);
                            try {
                                ByteStreamsKt.copyTo(fileInputStream, zipOutputStream, 20480);
                                CloseableKt.closeFinally(fileInputStream, null);
                                zipOutputStream.flush();
                                if (!isGzip) {
                                    if (!(zipOutputStream instanceof ZipOutputStream)) {
                                        deflaterOutputStream = null;
                                    } else {
                                        deflaterOutputStream = zipOutputStream;
                                    }
                                    ZipOutputStream zipOutputStream3 = (ZipOutputStream) deflaterOutputStream;
                                    if (zipOutputStream3 != null) {
                                        zipOutputStream3.closeEntry();
                                    }
                                }
                            } finally {
                            }
                        }
                        CloseableKt.closeFinally(zipOutputStream, null);
                        return true;
                    } finally {
                    }
                } else {
                    CloseableKt.closeFinally(zipOutputStream, null);
                    return false;
                }
            } catch (IOException e16) {
                Logger.f365497g.b("RMonitor_common_FileUtil", "outputPath: " + outputPath, e16);
                return false;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmStatic
    @Nullable
    public static final File g(@NotNull File file, @NotNull File file2) {
        return INSTANCE.a(file, file2);
    }

    @JvmStatic
    public static final boolean h(@Nullable String str) {
        return INSTANCE.b(str);
    }

    @JvmStatic
    public static final void i(@Nullable File file) {
        INSTANCE.c(file);
    }

    @JvmStatic
    @NotNull
    public static final String j() {
        return INSTANCE.i();
    }

    @JvmStatic
    public static final boolean k(@NotNull String str) {
        return INSTANCE.k(str);
    }

    @JvmStatic
    public static final boolean l(@Nullable List<String> list, @NotNull String str, boolean z16) {
        return INSTANCE.r(list, str, z16);
    }
}
