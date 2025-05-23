package com.tencent.qqnt.avatar.cache;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.avatar.disklrucache.a;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\nJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0016R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/avatar/cache/a;", "Lcom/tencent/qqnt/avatar/cache/d;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Ljava/io/File;", "file", "", "d", "Lcom/tencent/qqnt/avatar/disklrucache/a;", "g", "", "key", "e", "f", "resource", "highPriority", "", h.F, "a", "Ljava/io/File;", "directory", "b", "Lcom/tencent/qqnt/avatar/disklrucache/a;", "diskCache", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "c", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a implements d<Bitmap> {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private static volatile a f352696d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final File directory;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.avatar.disklrucache.a diskCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/avatar/cache/a$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/avatar/cache/a;", "a", "", "MAX_SIZE", "J", "", AEEditorConstants.PATH, "Ljava/lang/String;", "TAG", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/qqnt/avatar/cache/a;", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.avatar.cache.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes23.dex */
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
        public final a a(@NotNull Context context) {
            a aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            a aVar2 = a.f352696d;
            if (aVar2 != null) {
                return aVar2;
            }
            synchronized (Reflection.getOrCreateKotlinClass(a.class)) {
                if (a.f352696d == null) {
                    a.f352696d = new a(context, null);
                }
                aVar = a.f352696d;
                Intrinsics.checkNotNull(aVar);
            }
            return aVar;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38964);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ a(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) defaultConstructorMarker);
    }

    private final boolean d(Bitmap bitmap, File file) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    boolean compress = bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream2);
                    try {
                        bufferedOutputStream2.close();
                        return compress;
                    } catch (IOException unused) {
                        return compress;
                    }
                } catch (Exception e16) {
                    e = e16;
                    bufferedOutputStream = bufferedOutputStream2;
                    com.tencent.qqnt.avatar.util.d.f352991a.c("AvatarDiskCache", "compressToPng error:", e);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    private final com.tencent.qqnt.avatar.disklrucache.a g() {
        com.tencent.qqnt.avatar.disklrucache.a aVar;
        int i3 = 0;
        while (true) {
            try {
                aVar = com.tencent.qqnt.avatar.disklrucache.a.t(this.directory, 1, 1, GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV);
            } catch (IOException e16) {
                com.tencent.qqnt.avatar.util.d.f352991a.c("AvatarDiskCache", "disk cache open error " + i3 + " ,directory exists:" + this.directory.exists() + " - isDirectory:" + this.directory.isDirectory(), e16);
                aVar = null;
            }
            if (aVar != null) {
                return aVar;
            }
            if (i3 == 2) {
                return null;
            }
            i3++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x007a, code lost:
    
        if (r0 == null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0069, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0067, code lost:
    
        if (r0 == null) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized Bitmap e(@NotNull String key) {
        File file;
        FileInputStream fileInputStream;
        a.e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) key);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        InputStream inputStream = null;
        InputStream inputStream2 = null;
        try {
            com.tencent.qqnt.avatar.disklrucache.a aVar = this.diskCache;
            if (aVar != null) {
                eVar = aVar.r(key);
            } else {
                eVar = null;
            }
        } catch (IOException e16) {
            com.tencent.qqnt.avatar.util.d.f352991a.c("AvatarDiskCache", "get from disk cache error:", e16);
        }
        try {
            if (eVar != null) {
                file = eVar.a(0);
                if (file != null && file.exists()) {
                    inputStream = 1;
                }
                if (inputStream != null) {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (IOException e17) {
                        e = e17;
                        fileInputStream = null;
                    } catch (OutOfMemoryError e18) {
                        e = e18;
                        fileInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                    try {
                        Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                        return decodeStream;
                    } catch (IOException e19) {
                        e = e19;
                        com.tencent.qqnt.avatar.util.d.f352991a.c("AvatarDiskCache", "decode bitmap error:", e);
                    } catch (OutOfMemoryError e26) {
                        e = e26;
                        com.tencent.qqnt.avatar.util.d.f352991a.c("AvatarDiskCache", "decode bitmap oom:", e);
                    }
                }
                return null;
            }
            if (inputStream != null) {
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
            inputStream2 = inputStream;
        }
        file = null;
        if (file != null) {
            inputStream = 1;
        }
    }

    @Nullable
    public final synchronized File f(@NotNull String key) {
        File file;
        a.e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (File) iPatchRedirector.redirect((short) 3, (Object) this, (Object) key);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            com.tencent.qqnt.avatar.disklrucache.a aVar = this.diskCache;
            if (aVar != null) {
                eVar = aVar.r(key);
            } else {
                eVar = null;
            }
        } catch (IOException e16) {
            com.tencent.qqnt.avatar.util.d.f352991a.c("AvatarDiskCache", "getFile from disk cache error:", e16);
        }
        if (eVar != null) {
            file = eVar.a(0);
            if (file != null || !file.exists() || file.length() <= 0) {
                return null;
            }
            return file;
        }
        file = null;
        if (file != null) {
        }
        return null;
    }

    @Override // com.tencent.qqnt.avatar.cache.d
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public synchronized void a(@NotNull String key, @NotNull Bitmap resource, boolean highPriority) {
        com.tencent.qqnt.avatar.util.d dVar;
        String str;
        String str2;
        a.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, key, resource, Boolean.valueOf(highPriority));
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(resource, "resource");
        a.c cVar2 = null;
        File f16 = null;
        cVar2 = null;
        try {
            try {
                com.tencent.qqnt.avatar.disklrucache.a aVar = this.diskCache;
                if (aVar != null) {
                    cVar = aVar.o(key);
                } else {
                    cVar = null;
                }
                if (cVar != null) {
                    try {
                        f16 = cVar.f(0);
                    } catch (Exception e16) {
                        e = e16;
                        cVar2 = cVar;
                        com.tencent.qqnt.avatar.util.d.f352991a.c("AvatarDiskCache", "put to disk cache error:", e);
                        if (cVar2 != null) {
                            try {
                                cVar2.d();
                            } catch (IllegalStateException e17) {
                                e = e17;
                                dVar = com.tencent.qqnt.avatar.util.d.f352991a;
                                str = "AvatarDiskCache";
                                str2 = "abortUnlessCommitted";
                                dVar.c(str, str2, e);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th5) {
                        th = th5;
                        cVar2 = cVar;
                        if (cVar2 != null) {
                            try {
                                cVar2.d();
                            } catch (IllegalStateException e18) {
                                com.tencent.qqnt.avatar.util.d.f352991a.c("AvatarDiskCache", "abortUnlessCommitted", e18);
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e19) {
            e = e19;
        }
        if (f16 == null) {
            com.tencent.qqnt.avatar.util.d.d(com.tencent.qqnt.avatar.util.d.f352991a, "AvatarDiskCache", "get file is null", null, 4, null);
            if (cVar != null) {
                try {
                    cVar.d();
                } catch (IllegalStateException e26) {
                    com.tencent.qqnt.avatar.util.d.f352991a.c("AvatarDiskCache", "abortUnlessCommitted", e26);
                }
            }
            return;
        }
        boolean d16 = d(resource, f16);
        if (!d16) {
            com.tencent.qqnt.avatar.util.d.d(com.tencent.qqnt.avatar.util.d.f352991a, "AvatarDiskCache", key + " compressToPng fail", null, 4, null);
        }
        if (d16 && cVar != null) {
            cVar.e();
        }
        if (cVar != null) {
            try {
                cVar.d();
            } catch (IllegalStateException e27) {
                e = e27;
                dVar = com.tencent.qqnt.avatar.util.d.f352991a;
                str = "AvatarDiskCache";
                str2 = "abortUnlessCommitted";
                dVar.c(str, str2, e);
                return;
            }
        }
        return;
    }

    a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.directory = new File(context.getCacheDir(), "proavatar_disk_cache");
            this.diskCache = g();
        }
    }
}
