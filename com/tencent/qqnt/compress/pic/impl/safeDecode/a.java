package com.tencent.qqnt.compress.pic.impl.safeDecode;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\fB\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/compress/pic/impl/safeDecode/a;", "", "", "g", "", "path", "Ljava/nio/MappedByteBuffer;", "j", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "i", h.F, "a", "Ljava/nio/MappedByteBuffer;", "mMappedBuffer", "b", "Ljava/lang/String;", "<init>", "()V", "c", "compress_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final byte[] f355738d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private static a f355739e;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MappedByteBuffer mMappedBuffer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String path;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/compress/pic/impl/safeDecode/a$a;", "", "", "path", "Lcom/tencent/qqnt/compress/pic/impl/safeDecode/a;", "a", "", "FIND_RESULT_FAILURE", "I", "FIND_RESULT_FIND", "FIND_RESULT_SAVE", "HEAD_BYTE", "HEAD_START_POSITION", "HEAD_VALID_POSITION", "MAX_ENTRY", "PER_ENTRY_BYTE", "TAG", "Ljava/lang/String;", "", "TYPE", "[B", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/qqnt/compress/pic/impl/safeDecode/a;", "<init>", "()V", "compress_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.compress.pic.impl.safeDecode.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final a a(@NotNull String path) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) path);
            }
            Intrinsics.checkNotNullParameter(path, "path");
            if (a.f355739e == null) {
                synchronized (a.class) {
                    if (a.f355739e == null) {
                        a.f355739e = new a(null);
                        a aVar = a.f355739e;
                        Intrinsics.checkNotNull(aVar);
                        a aVar2 = a.f355739e;
                        Intrinsics.checkNotNull(aVar2);
                        aVar.mMappedBuffer = aVar2.j(path);
                        a aVar3 = a.f355739e;
                        Intrinsics.checkNotNull(aVar3);
                        aVar3.path = path;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            a aVar4 = a.f355739e;
            Intrinsics.checkNotNull(aVar4);
            if (!Intrinsics.areEqual(path, aVar4.path)) {
                synchronized (a.class) {
                    a aVar5 = a.f355739e;
                    Intrinsics.checkNotNull(aVar5);
                    a aVar6 = a.f355739e;
                    Intrinsics.checkNotNull(aVar6);
                    aVar5.mMappedBuffer = aVar6.j(path);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
            a aVar7 = a.f355739e;
            Intrinsics.checkNotNull(aVar7);
            return aVar7;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39535);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
            f355738d = new byte[]{77, 67};
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
    }

    private final void g() {
        MappedByteBuffer mappedByteBuffer = this.mMappedBuffer;
        if (mappedByteBuffer == null) {
            return;
        }
        Intrinsics.checkNotNull(mappedByteBuffer);
        mappedByteBuffer.position(0);
        MappedByteBuffer mappedByteBuffer2 = this.mMappedBuffer;
        Intrinsics.checkNotNull(mappedByteBuffer2);
        byte[] bArr = f355738d;
        mappedByteBuffer2.put(bArr[0]);
        MappedByteBuffer mappedByteBuffer3 = this.mMappedBuffer;
        Intrinsics.checkNotNull(mappedByteBuffer3);
        mappedByteBuffer3.put(bArr[1]);
        MappedByteBuffer mappedByteBuffer4 = this.mMappedBuffer;
        Intrinsics.checkNotNull(mappedByteBuffer4);
        mappedByteBuffer4.putInt(0);
        MappedByteBuffer mappedByteBuffer5 = this.mMappedBuffer;
        Intrinsics.checkNotNull(mappedByteBuffer5);
        mappedByteBuffer5.putInt(0);
        MappedByteBuffer mappedByteBuffer6 = this.mMappedBuffer;
        Intrinsics.checkNotNull(mappedByteBuffer6);
        mappedByteBuffer6.putInt(500);
        MappedByteBuffer mappedByteBuffer7 = this.mMappedBuffer;
        Intrinsics.checkNotNull(mappedByteBuffer7);
        mappedByteBuffer7.force();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MappedByteBuffer j(String path) throws IOException {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(path, "rw");
        } catch (FileNotFoundException unused) {
            File file = new File(path);
            File file2 = new File(file.getParent());
            if (!file2.exists()) {
                file2.mkdirs();
            }
            file.createNewFile();
            randomAccessFile = new RandomAccessFile(path, "rw");
            this.mMappedBuffer = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, 8030L);
            g();
        }
        if (this.mMappedBuffer == null) {
            this.mMappedBuffer = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, 8030L);
        }
        randomAccessFile.close();
        return this.mMappedBuffer;
    }

    public final synchronized void h(@NotNull String item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        byte[] d16 = com.tencent.qqnt.util.string.b.f362987a.d(item);
        if (d16 == null) {
            return;
        }
        MappedByteBuffer mappedByteBuffer = this.mMappedBuffer;
        if (mappedByteBuffer == null) {
            return;
        }
        Intrinsics.checkNotNull(mappedByteBuffer);
        mappedByteBuffer.position(0);
        MappedByteBuffer mappedByteBuffer2 = this.mMappedBuffer;
        Intrinsics.checkNotNull(mappedByteBuffer2);
        byte b16 = mappedByteBuffer2.get();
        byte[] bArr = f355738d;
        if (b16 == bArr[0]) {
            MappedByteBuffer mappedByteBuffer3 = this.mMappedBuffer;
            Intrinsics.checkNotNull(mappedByteBuffer3);
            if (mappedByteBuffer3.get() == bArr[1]) {
                MappedByteBuffer mappedByteBuffer4 = this.mMappedBuffer;
                Intrinsics.checkNotNull(mappedByteBuffer4);
                mappedByteBuffer4.position(2);
                MappedByteBuffer mappedByteBuffer5 = this.mMappedBuffer;
                Intrinsics.checkNotNull(mappedByteBuffer5);
                int i3 = mappedByteBuffer5.getInt();
                MappedByteBuffer mappedByteBuffer6 = this.mMappedBuffer;
                Intrinsics.checkNotNull(mappedByteBuffer6);
                int i16 = mappedByteBuffer6.getInt();
                MappedByteBuffer mappedByteBuffer7 = this.mMappedBuffer;
                Intrinsics.checkNotNull(mappedByteBuffer7);
                int i17 = mappedByteBuffer7.getInt();
                if (i17 >= 0 && i17 >= i3 && i17 >= i16) {
                    byte[] bArr2 = new byte[16];
                    int i18 = i16 - 1;
                    int i19 = i18;
                    while (true) {
                        if (-1 >= i19) {
                            break;
                        }
                        int i26 = (i3 + i19) % i17;
                        MappedByteBuffer mappedByteBuffer8 = this.mMappedBuffer;
                        Intrinsics.checkNotNull(mappedByteBuffer8);
                        mappedByteBuffer8.position((i26 * 16) + 14);
                        MappedByteBuffer mappedByteBuffer9 = this.mMappedBuffer;
                        Intrinsics.checkNotNull(mappedByteBuffer9);
                        mappedByteBuffer9.get(bArr2, 0, 16);
                        if (Arrays.equals(bArr2, d16)) {
                            if (QLog.isColorLevel()) {
                                QLog.d("SafeBitmapFactory", 2, "deleteItem() \u627e\u5230\u4e86,pos:" + i26);
                            }
                            for (int i27 = i19 + 1; i27 < i18; i27++) {
                                int i28 = (i3 + i27) % i17;
                                MappedByteBuffer mappedByteBuffer10 = this.mMappedBuffer;
                                Intrinsics.checkNotNull(mappedByteBuffer10);
                                mappedByteBuffer10.position((i28 * 16) + 14);
                                MappedByteBuffer mappedByteBuffer11 = this.mMappedBuffer;
                                Intrinsics.checkNotNull(mappedByteBuffer11);
                                mappedByteBuffer11.get(bArr2, 0, 16);
                                int i29 = i28 == 0 ? i17 - 1 : i28 - 1;
                                MappedByteBuffer mappedByteBuffer12 = this.mMappedBuffer;
                                Intrinsics.checkNotNull(mappedByteBuffer12);
                                mappedByteBuffer12.position((i29 * 16) + 14);
                                MappedByteBuffer mappedByteBuffer13 = this.mMappedBuffer;
                                Intrinsics.checkNotNull(mappedByteBuffer13);
                                mappedByteBuffer13.put(bArr2);
                            }
                            if (i16 > 0) {
                                MappedByteBuffer mappedByteBuffer14 = this.mMappedBuffer;
                                Intrinsics.checkNotNull(mappedByteBuffer14);
                                mappedByteBuffer14.position(6);
                                MappedByteBuffer mappedByteBuffer15 = this.mMappedBuffer;
                                Intrinsics.checkNotNull(mappedByteBuffer15);
                                mappedByteBuffer15.putInt(i18);
                            }
                        } else {
                            i19--;
                        }
                    }
                    MappedByteBuffer mappedByteBuffer16 = this.mMappedBuffer;
                    Intrinsics.checkNotNull(mappedByteBuffer16);
                    mappedByteBuffer16.force();
                    return;
                }
                g();
                return;
            }
        }
        g();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
    
        if (r2.get() != r4[1]) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized int i(@Nullable String item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) item)).intValue();
        }
        byte[] d16 = com.tencent.qqnt.util.string.b.f362987a.d(item);
        if (d16 == null) {
            return -1;
        }
        MappedByteBuffer mappedByteBuffer = this.mMappedBuffer;
        if (mappedByteBuffer == null) {
            return -1;
        }
        Intrinsics.checkNotNull(mappedByteBuffer);
        mappedByteBuffer.position(0);
        MappedByteBuffer mappedByteBuffer2 = this.mMappedBuffer;
        Intrinsics.checkNotNull(mappedByteBuffer2);
        byte b16 = mappedByteBuffer2.get();
        byte[] bArr = f355738d;
        if (b16 == bArr[0]) {
            MappedByteBuffer mappedByteBuffer3 = this.mMappedBuffer;
            Intrinsics.checkNotNull(mappedByteBuffer3);
        }
        g();
        MappedByteBuffer mappedByteBuffer4 = this.mMappedBuffer;
        Intrinsics.checkNotNull(mappedByteBuffer4);
        mappedByteBuffer4.position(2);
        MappedByteBuffer mappedByteBuffer5 = this.mMappedBuffer;
        Intrinsics.checkNotNull(mappedByteBuffer5);
        int i3 = mappedByteBuffer5.getInt();
        MappedByteBuffer mappedByteBuffer6 = this.mMappedBuffer;
        Intrinsics.checkNotNull(mappedByteBuffer6);
        int i16 = mappedByteBuffer6.getInt();
        MappedByteBuffer mappedByteBuffer7 = this.mMappedBuffer;
        Intrinsics.checkNotNull(mappedByteBuffer7);
        int i17 = mappedByteBuffer7.getInt();
        if (QLog.isColorLevel()) {
            QLog.d("SafeBitmapFactory", 2, "findOrAddItem() start:" + i3 + "\uff0cvalid:" + i16 + "\uff0cmax:" + i17);
        }
        if (i17 < 0 || i17 < i3 || i17 < i16) {
            g();
        }
        byte[] bArr2 = new byte[16];
        for (int i18 = i16 - 1; -1 < i18; i18--) {
            MappedByteBuffer mappedByteBuffer8 = this.mMappedBuffer;
            Intrinsics.checkNotNull(mappedByteBuffer8);
            mappedByteBuffer8.position((((i3 + i18) % i17) * 16) + 14);
            MappedByteBuffer mappedByteBuffer9 = this.mMappedBuffer;
            Intrinsics.checkNotNull(mappedByteBuffer9);
            mappedByteBuffer9.get(bArr2, 0, 16);
            if (Arrays.equals(bArr2, d16)) {
                return 1;
            }
        }
        MappedByteBuffer mappedByteBuffer10 = this.mMappedBuffer;
        Intrinsics.checkNotNull(mappedByteBuffer10);
        mappedByteBuffer10.position((((i3 + i16) % i17) * 16) + 14);
        MappedByteBuffer mappedByteBuffer11 = this.mMappedBuffer;
        Intrinsics.checkNotNull(mappedByteBuffer11);
        mappedByteBuffer11.put(d16);
        if (i16 < i17) {
            int i19 = i16 + 1;
            MappedByteBuffer mappedByteBuffer12 = this.mMappedBuffer;
            Intrinsics.checkNotNull(mappedByteBuffer12);
            mappedByteBuffer12.position(6);
            MappedByteBuffer mappedByteBuffer13 = this.mMappedBuffer;
            Intrinsics.checkNotNull(mappedByteBuffer13);
            mappedByteBuffer13.putInt(i19);
            if (QLog.isColorLevel()) {
                QLog.d("SafeBitmapFactory", 2, "findOrAddItem() \u6ca1\u627e\u5230 \uff0c\u603b\u6570\u672a\u6ee1\u8ddf\u65b0 valid:" + i19);
            }
        } else {
            int i26 = (i3 + 1) % i17;
            MappedByteBuffer mappedByteBuffer14 = this.mMappedBuffer;
            Intrinsics.checkNotNull(mappedByteBuffer14);
            mappedByteBuffer14.position(2);
            MappedByteBuffer mappedByteBuffer15 = this.mMappedBuffer;
            Intrinsics.checkNotNull(mappedByteBuffer15);
            mappedByteBuffer15.putInt(i26);
            if (QLog.isColorLevel()) {
                QLog.d("SafeBitmapFactory", 2, "findOrAddItem() \u6ca1\u627e\u5230 \uff0c\u603b\u6570\u5df2\u6ee1\u8ddf\u65b0 start:" + i26);
            }
        }
        MappedByteBuffer mappedByteBuffer16 = this.mMappedBuffer;
        Intrinsics.checkNotNull(mappedByteBuffer16);
        mappedByteBuffer16.force();
        return 0;
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.path = "";
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
