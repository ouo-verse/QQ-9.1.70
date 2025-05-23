package com.tencent.cachedrawable.dynamicdrawable.cachedrawable.framecache;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.g;
import com.tencent.cachedrawable.dynamicdrawable.f;
import com.tencent.cachedrawable.dynamicdrawable.utils.d;
import com.tencent.cachedrawable.dynamicdrawable.utils.e;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0003J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0017J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0017J\b\u0010\u000f\u001a\u00020\u0002H\u0017R\u0014\u0010\u0011\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/framecache/a;", "Lcom/tencent/cachedrawable/dynamicdrawable/f;", "", "d", "", "isUseHardware", "e", "", "key", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/manager/b;", "frameAnimData", "a", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "b", "c", "Ljava/lang/String;", "mFilePath", "Z", "mIsUseHardware", "path", "<init>", "(Ljava/lang/String;)V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class a implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mFilePath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean mIsUseHardware;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/framecache/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.framecache.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10911);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) path);
        } else {
            this.mFilePath = path;
        }
    }

    @SuppressLint({"LongLogTag"})
    private final void d() {
        File file = new File(this.mFilePath);
        String str = file.getParent() + ((Object) File.separator) + "dynamic_cache/" + ((Object) file.getName());
        if (new File(str).exists()) {
            try {
                e.f99063a.a(str);
            } catch (Throwable th5) {
                com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("FrameFileCache", Intrinsics.stringPlus("removeFile", th5.getMessage()));
            }
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.f
    @SuppressLint({"LongLogTag"})
    public void a(@NotNull String key, @NotNull com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b frameAnimData) {
        FileOutputStream fileOutputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) key, (Object) frameAnimData);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(frameAnimData, "frameAnimData");
        if (d.f99062a.d()) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            File file = new File(key);
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
            } else {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            g.f99036a.d(frameAnimData, fileOutputStream);
            fileOutputStream.close();
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream2 = fileOutputStream;
            try {
                com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("FrameFileCache", "saveFrame file : " + key + TokenParser.SP + ((Object) th.getMessage()) + TokenParser.SP);
                d();
            } finally {
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            }
        }
        d();
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.f
    @SuppressLint({"LongLogTag"})
    @Nullable
    public com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b b(@NotNull String key, @Nullable Bitmap bitmap) {
        FileInputStream fileInputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b) iPatchRedirector.redirect((short) 4, (Object) this, (Object) key, (Object) bitmap);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        if (d.f99062a.d()) {
            return null;
        }
        File file = new File(key);
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
        }
        try {
            com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b b16 = g.f99036a.b(key, fileInputStream, bitmap, this.mIsUseHardware);
            try {
                fileInputStream.close();
            } catch (Exception e16) {
                com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("FrameFileCache", "fileInputStream?.close() file : " + key + TokenParser.SP + ((Object) e16.getMessage()));
            }
            return b16;
        } catch (Throwable th6) {
            th = th6;
            try {
                com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("FrameFileCache", "getFrame file : " + key + TokenParser.SP + ((Object) th.getMessage()));
                return null;
            } finally {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e17) {
                        com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("FrameFileCache", "fileInputStream?.close() file : " + key + TokenParser.SP + ((Object) e17.getMessage()));
                    }
                }
            }
        }
    }

    @SuppressLint({"LongLogTag"})
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        String stringPlus = Intrinsics.stringPlus(com.tencent.cachedrawable.dynamicdrawable.business.dynamicInit.a.f98862a.b(), this.mFilePath);
        if (new File(stringPlus).exists()) {
            try {
                e.f99063a.a(stringPlus);
            } catch (Throwable th5) {
                com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("FrameFileCache", Intrinsics.stringPlus("removeFile", th5.getMessage()));
            }
        }
    }

    public final void e(boolean isUseHardware) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, isUseHardware);
        } else {
            this.mIsUseHardware = isUseHardware;
        }
    }
}
