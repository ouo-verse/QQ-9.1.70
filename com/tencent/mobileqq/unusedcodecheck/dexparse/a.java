package com.tencent.mobileqq.unusedcodecheck.dexparse;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.vivo.push.PushClientConstants;
import cooperation.qzone.patch.QZonePatchService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\f\u00126\u0010\u0017\u001a2\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00060\u0010\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eRD\u0010\u0017\u001a2\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/unusedcodecheck/dexparse/a;", "", "", "dexIndex", "", "a", "", "b", "Ljava/lang/String;", "apkPath", "I", "fileBufferedSize", "Ljava/io/File;", "c", "Ljava/io/File;", "tempFileDir", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", PushClientConstants.TAG_CLASS_NAME, "classIndex", "d", "Lkotlin/jvm/functions/Function2;", "onParse", "<init>", "(Ljava/lang/String;ILjava/io/File;Lkotlin/jvm/functions/Function2;)V", "dexparse"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String apkPath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int fileBufferedSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final File tempFileDir;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Function2<String, Integer, Unit> onParse;

    public a(@NotNull String apkPath, int i3, @NotNull File tempFileDir, @NotNull Function2<? super String, ? super Integer, Unit> onParse) {
        Intrinsics.checkNotNullParameter(apkPath, "apkPath");
        Intrinsics.checkNotNullParameter(tempFileDir, "tempFileDir");
        Intrinsics.checkNotNullParameter(onParse, "onParse");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, apkPath, Integer.valueOf(i3), tempFileDir, onParse);
            return;
        }
        this.apkPath = apkPath;
        this.fileBufferedSize = i3;
        this.tempFileDir = tempFileDir;
        this.onParse = onParse;
    }

    private final String a(int dexIndex) {
        Object valueOf;
        if (dexIndex == 1) {
            valueOf = "";
        } else {
            valueOf = Integer.valueOf(dexIndex);
        }
        return "classes" + valueOf + QZonePatchService.PATCH_SUFFIX_DEX;
    }

    public final void b() throws DexParseException, IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ZipFile zipFile = new ZipFile(this.apkPath);
        int i16 = 0;
        while (true) {
            try {
                String a16 = a(i3);
                ZipEntry entry = zipFile.getEntry(a16);
                if (entry != null) {
                    File file = new File(this.tempFileDir, a16);
                    file.delete();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        InputStream inputStream = zipFile.getInputStream(entry);
                        Intrinsics.checkNotNullExpressionValue(inputStream, "it.getInputStream(entry)");
                        ByteStreamsKt.copyTo(inputStream, fileOutputStream, this.fileBufferedSize);
                        CloseableKt.closeFinally(fileOutputStream, null);
                        BufferedRandomByteReader bufferedRandomByteReader = new BufferedRandomByteReader(file, this.fileBufferedSize);
                        try {
                            b bVar = new b(bufferedRandomByteReader);
                            try {
                                bVar.g();
                                while (bVar.e()) {
                                    this.onParse.invoke(bVar.h(), Integer.valueOf(i16));
                                    i16++;
                                }
                                Unit unit = Unit.INSTANCE;
                                CloseableKt.closeFinally(bVar, null);
                                CloseableKt.closeFinally(bufferedRandomByteReader, null);
                                file.delete();
                                i3++;
                            } finally {
                            }
                        } finally {
                        }
                    } finally {
                    }
                } else {
                    Unit unit2 = Unit.INSTANCE;
                    CloseableKt.closeFinally(zipFile, null);
                    return;
                }
            } finally {
            }
        }
    }
}
