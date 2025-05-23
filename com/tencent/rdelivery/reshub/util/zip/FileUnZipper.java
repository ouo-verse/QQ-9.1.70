package com.tencent.rdelivery.reshub.util.zip;

import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J,\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u000bH\u0002J$\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u000bH\u0002J(\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004H\u0002\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/rdelivery/reshub/util/zip/FileUnZipper;", "", "Ljava/io/File;", "zip", "", QzoneZipCacheHelper.DIR, "", "c", "Ljava/util/zip/ZipEntry;", "zipEntry", "a", "Lkotlin/Function1;", "Ljava/io/OutputStream;", "writeAction", "e", "tmpFile", "d", "tmpPath", "targetFile", "targetPath", "b", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class FileUnZipper {

    /* renamed from: a, reason: collision with root package name */
    public static final FileUnZipper f364605a = new FileUnZipper();

    FileUnZipper() {
    }

    private final String a(String dir, ZipEntry zipEntry) {
        return dir + File.separator + c.f(zipEntry.getName());
    }

    private final void b(File tmpFile, String tmpPath, File targetFile, String targetPath) {
        if (tmpFile.renameTo(targetFile)) {
            return;
        }
        jz3.d.c("FileUnZipper", "Rename File Failed: " + tmpPath);
        boolean e16 = jz3.c.e(tmpFile, targetFile);
        jz3.c.f(tmpFile, true);
        if (e16) {
            return;
        }
        throw new Exception("Copy Failed: " + tmpPath + " --> " + targetPath);
    }

    @JvmStatic
    public static final void c(@NotNull File zip, @NotNull String dir) {
        Iterator it;
        Intrinsics.checkParameterIsNotNull(zip, "zip");
        Intrinsics.checkParameterIsNotNull(dir, "dir");
        final ZipFile zipFile = new ZipFile(zip);
        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            Intrinsics.checkExpressionValueIsNotNull(entries, "zipFile.entries()");
            it = CollectionsKt__IteratorsJVMKt.iterator(entries);
            while (it.hasNext()) {
                final ZipEntry entry = (ZipEntry) it.next();
                FileUnZipper fileUnZipper = f364605a;
                Intrinsics.checkExpressionValueIsNotNull(entry, "entry");
                fileUnZipper.e(entry, dir, new Function1<OutputStream, Unit>() { // from class: com.tencent.rdelivery.reshub.util.zip.FileUnZipper$unzip$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(OutputStream outputStream) {
                        invoke2(outputStream);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull OutputStream it5) {
                        Intrinsics.checkParameterIsNotNull(it5, "it");
                        InputStream inputStream = zipFile.getInputStream(entry);
                        Intrinsics.checkExpressionValueIsNotNull(inputStream, "zipFile.getInputStream(entry)");
                        ByteStreamsKt.copyTo$default(inputStream, it5, 0, 2, null);
                    }
                });
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(zipFile, null);
        } finally {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.Closeable, java.lang.Object, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r4v7 */
    private final void d(File tmpFile, Function1<? super OutputStream, Unit> writeAction) {
        FileOutputStream fileOutputStream;
        ?? r46;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(tmpFile);
        } catch (Exception e16) {
            e = e16;
            r46 = 0;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
        }
        try {
            r46 = new BufferedOutputStream(fileOutputStream);
            try {
                writeAction.invoke(r46);
                r46.flush();
                jz3.c.p(r46);
                jz3.c.p(fileOutputStream);
            } catch (Exception e17) {
                e = e17;
                fileOutputStream2 = fileOutputStream;
                r46 = r46;
                try {
                    jz3.d.d("FileUnZipper", "Unzip File Exception", e);
                    throw e;
                } catch (Throwable th6) {
                    th = th6;
                    fileOutputStream = fileOutputStream2;
                    fileOutputStream2 = r46;
                    jz3.c.p(fileOutputStream2);
                    jz3.c.p(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                fileOutputStream2 = r46;
                jz3.c.p(fileOutputStream2);
                jz3.c.p(fileOutputStream);
                throw th;
            }
        } catch (Exception e18) {
            e = e18;
            r46 = 0;
        } catch (Throwable th8) {
            th = th8;
            jz3.c.p(fileOutputStream2);
            jz3.c.p(fileOutputStream);
            throw th;
        }
    }

    private final void e(ZipEntry zipEntry, String dir, Function1<? super OutputStream, Unit> writeAction) {
        String targetPath = c.f(a(dir, zipEntry));
        File file = new File(targetPath);
        String str = targetPath + System.currentTimeMillis();
        File file2 = new File(str);
        if (zipEntry.isDirectory()) {
            file.mkdirs();
            return;
        }
        jz3.c.n(file2.getAbsolutePath());
        d(file2, writeAction);
        Intrinsics.checkExpressionValueIsNotNull(targetPath, "targetPath");
        b(file2, str, file, targetPath);
    }
}
