package com.tencent.mobileqq.perf.memory.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FileTreeWalk;
import kotlin.io.FilesKt__FileTreeWalkKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002J\u001c\u0010\f\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u0007\u001a\u00020\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/util/ZipUtil;", "", "", "filePath", "Ljava/io/File;", "a", "fileDir", "zipFilePath", "", "c", "", "files", "b", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class ZipUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ZipUtil f257789a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30449);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f257789a = new ZipUtil();
        }
    }

    ZipUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final File a(String filePath) {
        File file = new File(filePath);
        File parentFile = file.getParentFile();
        Intrinsics.checkNotNull(parentFile);
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    public final void b(@NotNull List<? extends File> files, @NotNull String zipFilePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) files, (Object) zipFilePath);
            return;
        }
        Intrinsics.checkNotNullParameter(files, "files");
        Intrinsics.checkNotNullParameter(zipFilePath, "zipFilePath");
        if (files.isEmpty()) {
            return;
        }
        byte[] bArr = new byte[1024];
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(a(zipFilePath)));
        try {
            for (File file : files) {
                if (file.exists()) {
                    zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                    FileInputStream fileInputStream = new FileInputStream(file);
                    while (true) {
                        try {
                            int read = fileInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            } else {
                                zipOutputStream.write(bArr, 0, read);
                            }
                        } finally {
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileInputStream, null);
                    zipOutputStream.closeEntry();
                }
            }
            Unit unit2 = Unit.INSTANCE;
            CloseableKt.closeFinally(zipOutputStream, null);
        } finally {
        }
    }

    public final void c(@NotNull String fileDir, @NotNull String zipFilePath) {
        FileTreeWalk walk$default;
        Sequence filter;
        List<? extends File> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fileDir, (Object) zipFilePath);
            return;
        }
        Intrinsics.checkNotNullParameter(fileDir, "fileDir");
        Intrinsics.checkNotNullParameter(zipFilePath, "zipFilePath");
        File file = new File(fileDir);
        if (file.exists() && file.isDirectory()) {
            walk$default = FilesKt__FileTreeWalkKt.walk$default(file, null, 1, null);
            filter = SequencesKt___SequencesKt.filter(walk$default, ZipUtil$zipByFolder$1.INSTANCE);
            list = SequencesKt___SequencesKt.toList(filter);
            f257789a.b(list, zipFilePath);
        }
    }
}
