package com.tencent.mobileqq.unusedcodecheck.dexparse;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.RandomAccessFile;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0014\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/unusedcodecheck/dexparse/BufferedRandomByteReader;", "Lcom/tencent/mobileqq/unusedcodecheck/dexparse/c;", "", "offset", "", "a", "", "close", "Ljava/io/RandomAccessFile;", "e", "Lkotlin/Lazy;", "j", "()Ljava/io/RandomAccessFile;", "file", "f", "I", "seekPoint", "", h.F, "()[B", "buffer", "i", "bufferSize", "Ljava/io/File;", "srcFile", "<init>", "(Ljava/io/File;I)V", "dexparse"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes17.dex */
public final class BufferedRandomByteReader extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy file;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int seekPoint;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy buffer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int bufferSize;

    public BufferedRandomByteReader(@NotNull final File srcFile, int i3) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(srcFile, "srcFile");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) srcFile, i3);
            return;
        }
        this.bufferSize = i3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RandomAccessFile>(srcFile) { // from class: com.tencent.mobileqq.unusedcodecheck.dexparse.BufferedRandomByteReader$file$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ File $srcFile;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$srcFile = srcFile;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) srcFile);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RandomAccessFile invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) ? new RandomAccessFile(this.$srcFile, "r") : (RandomAccessFile) iPatchRedirector2.redirect((short) 1, (Object) this);
            }
        });
        this.file = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<byte[]>() { // from class: com.tencent.mobileqq.unusedcodecheck.dexparse.BufferedRandomByteReader$buffer$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) BufferedRandomByteReader.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final byte[] invoke() {
                int i16;
                RandomAccessFile j3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (byte[]) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
                i16 = BufferedRandomByteReader.this.bufferSize;
                byte[] bArr = new byte[i16];
                j3 = BufferedRandomByteReader.this.j();
                j3.read(bArr);
                return bArr;
            }
        });
        this.buffer = lazy2;
    }

    private final byte[] h() {
        return (byte[]) this.buffer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RandomAccessFile j() {
        return (RandomAccessFile) this.file.getValue();
    }

    @Override // com.tencent.mobileqq.unusedcodecheck.dexparse.c
    protected byte a(int offset) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Byte) iPatchRedirector.redirect((short) 1, (Object) this, offset)).byteValue();
        }
        int i3 = this.seekPoint;
        if (offset < i3 || offset >= i3 + this.bufferSize) {
            j().seek(offset);
            this.seekPoint = offset;
            j().read(h());
        }
        return h()[offset - this.seekPoint];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        RandomAccessFile j3 = j();
        try {
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(j3, null);
        } finally {
        }
    }
}
