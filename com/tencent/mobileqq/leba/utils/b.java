package com.tencent.mobileqq.leba.utils;

import android.content.Context;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/leba/utils/b;", "", "", WadlProxyConsts.PARAM_FILENAME, "content", "", "e", "d", "Ljava/io/File;", "a", "c", "Ljava/util/concurrent/locks/ReadWriteLock;", "b", "", "Ljava/util/Map;", "lockMap", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f240766a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, ReadWriteLock> lockMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19150);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f240766a = new b();
            lockMap = new LinkedHashMap();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final File a(String fileName) {
        String str;
        File c16 = c();
        if (c16 == null) {
            QLog.e("LebaConfigFileUtils", 1, "getConfigFile getLebaConfigDir null");
            return null;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            QLog.e("LebaConfigFileUtils", 1, "getConfigFile getConfigFile uin null:");
            return null;
        }
        return new File(c16, "leba_" + str + "_" + fileName);
    }

    private final ReadWriteLock b(String fileName) {
        ReadWriteLock readWriteLock;
        Map<String, ReadWriteLock> map = lockMap;
        synchronized (map) {
            ReadWriteLock readWriteLock2 = map.get(fileName);
            if (readWriteLock2 == null) {
                readWriteLock2 = new ReentrantReadWriteLock();
                map.put(fileName, readWriteLock2);
            }
            readWriteLock = readWriteLock2;
        }
        return readWriteLock;
    }

    private final File c() {
        File filesDir;
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        if (applicationContext == null || (filesDir = applicationContext.getFilesDir()) == null) {
            return null;
        }
        File file = new File(filesDir, "lebaUserConfig");
        if (file.exists()) {
            if (!file.isDirectory()) {
                QLog.e("LebaConfigFileUtils", 1, "getLebaConfigDir but is file, delete it");
                file.delete();
                file.mkdirs();
            }
        } else {
            file.mkdirs();
        }
        if (file.isDirectory()) {
            return file;
        }
        QLog.e("LebaConfigFileUtils", 1, "getLebaConfigDir but not directory");
        return null;
    }

    @JvmStatic
    @Nullable
    public static final String d(@NotNull String fileName) {
        Boolean bool;
        Boolean bool2;
        String readText$default;
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        b bVar = f240766a;
        File a16 = bVar.a(fileName);
        if (a16 != null && a16.isFile() && a16.exists()) {
            String name = a16.getName();
            Intrinsics.checkNotNullExpressionValue(name, "file.name");
            Lock readLock = bVar.b(name).readLock();
            readLock.lock();
            try {
                readText$default = FilesKt__FileReadWriteKt.readText$default(a16, null, 1, null);
                QLog.i("LebaConfigFileUtils", 1, "readFromFile readText: [" + fileName + "] " + readText$default.length());
                return readText$default;
            } catch (Exception e16) {
                QLog.e("LebaConfigFileUtils", 1, "readFromFile exception: ", e16);
                return null;
            } finally {
                readLock.unlock();
            }
        }
        if (a16 != null) {
            bool = Boolean.valueOf(a16.isFile());
        } else {
            bool = null;
        }
        if (a16 != null) {
            bool2 = Boolean.valueOf(a16.exists());
        } else {
            bool2 = null;
        }
        QLog.e("LebaConfigFileUtils", 1, "readFromFile file error: " + bool + ", " + bool2);
        return null;
    }

    @JvmStatic
    public static final void e(@NotNull String fileName, @NotNull String content) {
        boolean isBlank;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(content, "content");
        isBlank = StringsKt__StringsJVMKt.isBlank(fileName);
        if (!isBlank) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(content);
            if (!isBlank2) {
                b bVar = f240766a;
                File a16 = bVar.a(fileName);
                if (a16 == null) {
                    QLog.e("LebaConfigFileUtils", 1, "writeToFile getConfigFile null");
                    return;
                }
                String name = a16.getName();
                Intrinsics.checkNotNullExpressionValue(name, "file.name");
                Lock writeLock = bVar.b(name).writeLock();
                writeLock.lock();
                try {
                    try {
                        if (!a16.exists()) {
                            a16.createNewFile();
                        }
                        FilesKt__FileReadWriteKt.writeText$default(a16, content, null, 2, null);
                        QLog.i("LebaConfigFileUtils", 1, "writeToFile success: [" + a16.getPath() + "] " + a16.length() + " ");
                    } catch (Exception e16) {
                        QLog.e("LebaConfigFileUtils", 1, "writeToFile exception: ", e16);
                    }
                    return;
                } finally {
                    writeLock.unlock();
                }
            }
        }
        QLog.e("LebaConfigFileUtils", 1, "writeToFile check error fileName=" + fileName + ", content=" + content);
    }
}
