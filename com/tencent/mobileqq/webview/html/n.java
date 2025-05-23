package com.tencent.mobileqq.webview.html;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.webview.util.t;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u0010\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004J\u0018\u0010\u001a\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u0004J\u0016\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004J\u0010\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020\u0010J\u0006\u0010#\u001a\u00020\"J\u0006\u0010$\u001a\u00020\"J\u0006\u0010\u0003\u001a\u00020\"J\u0006\u0010%\u001a\u00020\"J\u000e\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/webview/html/n;", "", "", "b", "", "o", "cacheDir", "", "fileNames", "", "a", "url", "suffix", "l", "Lcom/tencent/mobileqq/webview/html/SessionData;", "sessionData", "", "j", "content", tl.h.F, "contentBytes", "i", "g", "sessionId", "f", "targetSha1", "p", "text", "path", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/io/File;", "file", DomainData.DOMAIN_NAME, "k", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "d", "Landroid/content/Context;", "appContext", "e", "", "[C", "hexChar", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f313939a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final char[] hexChar;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40178);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            f313939a = new n();
            hexChar = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        }
    }

    n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final long a(String cacheDir, Set<String> fileNames) {
        File[] listFiles;
        boolean z16;
        File file = new File(cacheDir);
        long j3 = 0;
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            if (listFiles.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                for (File file2 : listFiles) {
                    j3 += file2.length();
                    String name = file2.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "file.name");
                    fileNames.add(name);
                }
            }
        }
        return j3;
    }

    private final String o(byte[] b16) {
        StringBuilder sb5 = new StringBuilder(b16.length * 2);
        for (byte b17 : b16) {
            char[] cArr = hexChar;
            sb5.append(cArr[(b17 & 240) >>> 4]);
            sb5.append(cArr[b17 & RegisterType.DOUBLE_HI]);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    public final void b() {
        String c16;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        c cVar = c.f313882a;
        d e16 = cVar.e();
        if (e16 != null && (c16 = e16.c()) != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            long a16 = a(c16, linkedHashSet);
            if (a16 > cVar.d().c() * cVar.d().e()) {
                double d16 = cVar.d().d() * cVar.d().e();
                List<SessionData> d17 = b.f313880a.d();
                if (d17 != null && (!d17.isEmpty())) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    Iterator<SessionData> it = d17.iterator();
                    long j3 = 0;
                    int i3 = 0;
                    while (true) {
                        if (it.hasNext()) {
                            SessionData next = it.next();
                            File file = new File(c16 + File.separator + next.sessionId);
                            try {
                                if (file.exists()) {
                                    long length = file.length();
                                    if (file.delete()) {
                                        i3++;
                                        j3 += length;
                                        b.f313880a.b(next.sessionId);
                                    }
                                } else {
                                    b.f313880a.b(next.sessionId);
                                }
                            } catch (IOException e17) {
                                c.f313882a.f("htmlAgent_SessionHelper", 5, "checkTrimSize exception. ", e17);
                            }
                            if (a16 - j3 <= d16) {
                                z17 = true;
                                break;
                            }
                        } else {
                            z17 = false;
                            break;
                        }
                    }
                    if (!z17) {
                        c.g(c.f313882a, "htmlAgent_SessionHelper", 5, "checkTrimSize trim but unsatisfied.", null, 8, null);
                        d();
                    }
                    c.g(c.f313882a, "htmlAgent_SessionHelper", 4, "checkTrimSize done trim:" + i3 + "," + (((float) j3) / 1024.0f) + "KB, files=" + linkedHashSet.size() + "," + (((float) a16) / 1024.0f) + "KB, sessionData:" + d17.size(), null, 8, null);
                    return;
                }
                c.g(cVar, "htmlAgent_SessionHelper", 4, "checkTrimSize query db error.", null, 8, null);
                d();
                return;
            }
            c.g(cVar, "htmlAgent_engine", 3, "checkTrimCache() no trim cacheSize=" + (a16 / 1024) + "kb", null, 8, null);
        }
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else if (k()) {
            b();
            m();
        }
    }

    public final void d() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        c cVar = c.f313882a;
        d e16 = cVar.e();
        if (e16 != null) {
            str = e16.c();
        } else {
            str = null;
        }
        if (str != null) {
            FileUtils.deleteFilesInDirectory(str);
        }
        c.g(cVar, "htmlAgent_engine", 3, "clearCache() done dropDbSuc:" + b.f313880a.a(), null, 8, null);
    }

    @NotNull
    public final String e(@NotNull Context appContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this, (Object) appContext);
        }
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        return appContext.getCacheDir().toString() + File.separator + "htmlAgent";
    }

    @NotNull
    public final String f(@NotNull String sessionId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) sessionId);
        }
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        d e16 = c.f313882a.e();
        Intrinsics.checkNotNull(e16);
        return e16.c() + File.separator + sessionId;
    }

    @NotNull
    public final String g(@NotNull String content) {
        byte[] digest;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) content);
        }
        Intrinsics.checkNotNullParameter(content, "content");
        if (!TextUtils.isEmpty(content)) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                Charset charset = Charsets.UTF_8;
                byte[] bytes = content.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                byte[] bytes2 = content.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                messageDigest.update(bytes, 0, bytes2.length);
                digest = messageDigest.digest();
                Intrinsics.checkNotNullExpressionValue(digest, "sha1.digest()");
            } catch (Exception unused) {
                return "";
            }
        }
        return o(digest);
    }

    @NotNull
    public final String h(@NotNull String content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) content);
        }
        Intrinsics.checkNotNullParameter(content, "content");
        if (TextUtils.isEmpty(content)) {
            return "";
        }
        byte[] bytes = content.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return i(bytes);
    }

    @NotNull
    public final String i(@Nullable byte[] contentBytes) {
        boolean z16;
        byte[] digest;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) contentBytes);
        }
        if (contentBytes == null) {
            return "";
        }
        if (contentBytes.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                messageDigest.update(contentBytes, 0, contentBytes.length);
                digest = messageDigest.digest();
                Intrinsics.checkNotNullExpressionValue(digest, "sha1.digest()");
            } catch (Exception unused) {
                return "";
            }
        }
        return o(digest);
    }

    public final boolean j(@NotNull SessionData sessionData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) sessionData)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(sessionData, "sessionData");
        if (sessionData.expiredTime > System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (SystemClock.elapsedRealtime() - ((Number) t.INSTANCE.a().b("key_check_trim_cache_time", 0L)).longValue() > c.f313882a.d().a() * 1000) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String l(@NotNull String url, @Nullable String suffix) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url, (Object) suffix);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        if (TextUtils.isEmpty(suffix)) {
            return g(url);
        }
        return g(url + "_" + suffix);
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            t.INSTANCE.a().d("key_check_trim_cache_time", Long.valueOf(SystemClock.elapsedRealtime())).g();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String n(@NotNull File file) {
        FileInputStream fileInputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) file);
        }
        Intrinsics.checkNotNullParameter(file, "file");
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (IOException e16) {
            e = e16;
            fileInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            if (fileInputStream2 != null) {
            }
            throw th;
        }
        try {
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                StringBuilder sb5 = new StringBuilder();
                char[] cArr = new char[2048];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read == -1) {
                        break;
                    }
                    sb5.append(cArr, 0, read);
                }
                String sb6 = sb5.toString();
                Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
                fileInputStream.close();
                try {
                    fileInputStream.close();
                } catch (Exception unused) {
                }
                return sb6;
            } catch (Throwable th6) {
                th = th6;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException e17) {
            e = e17;
            c.f313882a.f("htmlAgent_SessionHelper", 5, "readStringFromFile exception. ", e);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception unused3) {
                }
            }
            return null;
        }
    }

    public final boolean p(@Nullable String content, @NotNull String targetSha1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) content, (Object) targetSha1)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(targetSha1, "targetSha1");
        if (content != null) {
            return Intrinsics.areEqual(targetSha1, f313939a.h(content));
        }
        return false;
    }

    public final boolean q(@NotNull String text, @NotNull String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) text, (Object) path)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(path, "path");
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(path);
                if (!file.exists()) {
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bytes = text.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    fileOutputStream2.write(bytes);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    try {
                        fileOutputStream2.close();
                    } catch (Exception unused) {
                    }
                    c.g(c.f313882a, "htmlAgent_SessionHelper", 3, "writeStringToFile path:" + path, null, 8, null);
                    return true;
                } catch (IOException e16) {
                    e = e16;
                    fileOutputStream = fileOutputStream2;
                    c.f313882a.f("htmlAgent_SessionHelper", 5, "writeStringToFile exception. ", e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (Exception unused2) {
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e17) {
            e = e17;
        }
    }
}
