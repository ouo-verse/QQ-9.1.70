package com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002J*\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/manager/g;", "", "Ljava/io/FileOutputStream;", "outputStream", "", "data", "", "c", "Ljava/io/FileInputStream;", "inputStream", "a", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/manager/b;", "frameData", "out", "d", "", "key", "fileInputStream", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "isUseHardware", "b", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f99036a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11252);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f99036a = new g();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int a(FileInputStream inputStream) {
        return (inputStream.read() & 255) | (inputStream.read() << 24) | (inputStream.read() << 16) | (inputStream.read() << 8);
    }

    private final void c(FileOutputStream outputStream, int data) {
        outputStream.write(data >> 24);
        outputStream.write(data >> 16);
        outputStream.write(data >> 8);
        outputStream.write(data >> 0);
    }

    @Nullable
    public final b b(@NotNull String key, @NotNull FileInputStream fileInputStream, @Nullable Bitmap bitmap, boolean isUseHardware) {
        byte[] bArr;
        Bitmap bitmap2;
        Bitmap decodeStream;
        Bitmap.Config config;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, this, key, fileInputStream, bitmap, Boolean.valueOf(isUseHardware));
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(fileInputStream, "fileInputStream");
        int a16 = a(fileInputStream);
        int a17 = a(fileInputStream);
        int a18 = a(fileInputStream);
        int a19 = a(fileInputStream);
        int a26 = a(fileInputStream);
        if (a26 > 0) {
            bArr = new byte[a26];
            fileInputStream.read(bArr);
        } else {
            bArr = null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            if (bitmap != null) {
                options.inBitmap = bitmap;
                options.inMutable = true;
            } else if (Build.VERSION.SDK_INT >= 26 && isUseHardware) {
                config = Bitmap.Config.HARDWARE;
                options.inPreferredConfig = config;
            }
            decodeStream = BitmapFactory.decodeStream(fileInputStream, new Rect(0, 0, a18, a19), options);
        } catch (OutOfMemoryError unused) {
            com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("FrameDataManager", Intrinsics.stringPlus("readAnimData_1 : OutOfMemoryError key : ", key));
            com.tencent.cachedrawable.dynamicdrawable.api.b.f98854a.a();
            try {
                decodeStream = BitmapFactory.decodeStream(fileInputStream);
            } catch (OutOfMemoryError unused2) {
                com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("FrameDataManager", Intrinsics.stringPlus("readAnimData_2 : OutOfMemoryError key : ", key));
                bitmap2 = null;
            }
        }
        bitmap2 = decodeStream;
        if (bitmap2 == null) {
            return null;
        }
        b bVar = new b(bitmap2, a16, a17, a18, a19);
        bVar.k(bArr);
        return bVar;
    }

    public final void d(@NotNull b frameData, @NotNull FileOutputStream out) {
        int length;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) frameData, (Object) out);
            return;
        }
        Intrinsics.checkNotNullParameter(frameData, "frameData");
        Intrinsics.checkNotNullParameter(out, "out");
        c(out, frameData.c());
        c(out, frameData.d());
        c(out, frameData.h());
        c(out, frameData.e());
        byte[] f16 = frameData.f();
        if (f16 == null) {
            length = 0;
        } else {
            length = f16.length;
        }
        c(out, length);
        if (length > 0) {
            out.write(f16);
        }
        com.tencent.cachedrawable.dynamicdrawable.utils.c.f99061a.a(frameData.a(), out);
    }
}
