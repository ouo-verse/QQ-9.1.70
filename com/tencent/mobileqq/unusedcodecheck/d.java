package com.tencent.mobileqq.unusedcodecheck;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/unusedcodecheck/d;", "Lcom/tencent/mobileqq/unusedcodecheck/f;", "", "nextElement", "", "release", "Ljava/io/FileInputStream;", "a", "Ljava/io/FileInputStream;", "fileStream", "Ljava/io/BufferedInputStream;", "b", "Ljava/io/BufferedInputStream;", "bufferedStream", "Ljava/io/DataInputStream;", "c", "Ljava/io/DataInputStream;", "dataStream", "Ljava/io/File;", "d", "Ljava/io/File;", "cacheFile", "", "e", "I", "fileBufferedSize", "<init>", "(Ljava/io/File;I)V", "unusedcode-check_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes17.dex */
public final class d implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private FileInputStream fileStream;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private BufferedInputStream bufferedStream;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private DataInputStream dataStream;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final File cacheFile;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int fileBufferedSize;

    public d(@NotNull File cacheFile, int i3) {
        Intrinsics.checkNotNullParameter(cacheFile, "cacheFile");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cacheFile, i3);
        } else {
            this.cacheFile = cacheFile;
            this.fileBufferedSize = i3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.unusedcodecheck.f
    @Nullable
    public String nextElement() throws IOException {
        BufferedInputStream bufferedInputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        try {
            if (this.dataStream == null) {
                FileInputStream fileInputStream = new FileInputStream(this.cacheFile);
                this.fileStream = fileInputStream;
                Intrinsics.checkNotNull(fileInputStream);
                int i3 = this.fileBufferedSize;
                if (fileInputStream instanceof BufferedInputStream) {
                    bufferedInputStream = (BufferedInputStream) fileInputStream;
                } else {
                    bufferedInputStream = new BufferedInputStream(fileInputStream, i3);
                }
                this.bufferedStream = bufferedInputStream;
                this.dataStream = new DataInputStream(this.bufferedStream);
            }
            DataInputStream dataInputStream = this.dataStream;
            Intrinsics.checkNotNull(dataInputStream);
            return dataInputStream.readUTF();
        } catch (EOFException unused) {
            return null;
        } catch (IOException e16) {
            b.f306127n.n().h("UnusedCodeCheck", "nextElement error", e16);
            throw e16;
        }
    }

    @Override // com.tencent.mobileqq.unusedcodecheck.f
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        DataInputStream dataInputStream = this.dataStream;
        if (dataInputStream != null) {
            try {
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(dataInputStream, null);
            } catch (Throwable th5) {
                try {
                    throw th5;
                } catch (Throwable th6) {
                    CloseableKt.closeFinally(dataInputStream, th5);
                    throw th6;
                }
            }
        }
        BufferedInputStream bufferedInputStream = this.bufferedStream;
        if (bufferedInputStream != null) {
            try {
                Unit unit2 = Unit.INSTANCE;
                CloseableKt.closeFinally(bufferedInputStream, null);
            } catch (Throwable th7) {
                try {
                    throw th7;
                } catch (Throwable th8) {
                    CloseableKt.closeFinally(bufferedInputStream, th7);
                    throw th8;
                }
            }
        }
        FileInputStream fileInputStream = this.fileStream;
        if (fileInputStream != null) {
            try {
                Unit unit3 = Unit.INSTANCE;
                CloseableKt.closeFinally(fileInputStream, null);
            } catch (Throwable th9) {
                try {
                    throw th9;
                } catch (Throwable th10) {
                    CloseableKt.closeFinally(fileInputStream, th9);
                    throw th10;
                }
            }
        }
    }
}
