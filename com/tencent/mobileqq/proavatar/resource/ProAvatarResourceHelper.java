package com.tencent.mobileqq.proavatar.resource;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.j;
import com.tencent.open.base.g;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J(\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J \u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u0004H\u0016R\u001b\u0010!\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/proavatar/resource/ProAvatarResourceHelper;", "Lcom/tencent/qqnt/avatar/meta/resource/b;", "Lcom/tencent/qqnt/avatar/meta/info/a;", "avatarInfo", "", "k", "Lcom/tencent/mobileqq/util/j$a;", "result", "Landroid/graphics/Bitmap;", "i", "filePath", "", "size", "g", "realWidth", "realHeight", "reqWidth", "reqHeight", "f", "", h.F, "url", "Ljava/io/File;", "file", "Lcom/tencent/qqnt/avatar/meta/resource/a;", "callback", "c", "b", "a", "Lcom/tencent/mobileqq/proavatar/resource/e;", "Lkotlin/Lazy;", "j", "()Lcom/tencent/mobileqq/proavatar/resource/e;", QDLog.TAG_DOWNLOAD, "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class ProAvatarResourceHelper implements com.tencent.qqnt.avatar.meta.resource.b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<File> f259669c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f259670d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy downloader;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/proavatar/resource/ProAvatarResourceHelper$a;", "", "Ljava/io/File;", "cacheDir$delegate", "Lkotlin/Lazy;", "c", "()Ljava/io/File;", "cacheDir", "", "downloadDirMigrateSwitch$delegate", "d", "()Z", "downloadDirMigrateSwitch", "", "CACHE_DIR_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.proavatar.resource.ProAvatarResourceHelper$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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

        /* JADX INFO: Access modifiers changed from: private */
        public final File c() {
            return (File) ProAvatarResourceHelper.f259669c.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d() {
            return ((Boolean) ProAvatarResourceHelper.f259670d.getValue()).booleanValue();
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
        Lazy<File> lazy;
        Lazy<Boolean> lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18158);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(ProAvatarResourceHelper$Companion$cacheDir$2.INSTANCE);
        f259669c = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(ProAvatarResourceHelper$Companion$downloadDirMigrateSwitch$2.INSTANCE);
        f259670d = lazy2;
    }

    public ProAvatarResourceHelper() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(ProAvatarResourceHelper$downloader$2.INSTANCE);
            this.downloader = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int f(int realWidth, int realHeight, int reqWidth, int reqHeight) {
        int i3 = 1;
        if (reqWidth <= 0 || realHeight <= 0) {
            return 1;
        }
        while (true) {
            if (realHeight / i3 <= reqHeight && realWidth / i3 <= reqWidth) {
                return i3;
            }
            i3 *= 2;
        }
    }

    private final j.a g(String filePath, int size) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = FaceConstant.HeadConfig.FACE_BITMAP_CONFIG;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        options.inSampleSize = f(options.outWidth, options.outHeight, size, size);
        int i3 = 0;
        options.inJustDecodeBounds = false;
        j.a aVar = new j.a();
        do {
            j.e(filePath, options, aVar);
            if (aVar.f306779b == 1) {
                h();
            }
            i3++;
            if (i3 >= 2) {
                break;
            }
        } while (aVar.f306779b == 1);
        return aVar;
    }

    private final void h() {
        ImageCacheHelper.f98636a.e();
    }

    private final Bitmap i(j.a result) {
        if (result.f306779b == 1) {
            QLog.e("ProAvatarResourceHelper", 1, "getBitmap android decode oom");
            return null;
        }
        return result.f306778a;
    }

    private final e j() {
        return (e) this.downloader.getValue();
    }

    private final String k(com.tencent.qqnt.avatar.meta.info.a avatarInfo) {
        boolean z16;
        String path = Uri.parse(avatarInfo.c()).getPath();
        if (path != null && path.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return avatarInfo.c();
        }
        return null;
    }

    @Override // com.tencent.qqnt.avatar.meta.resource.b
    @Nullable
    public File a(@NotNull String url) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (File) iPatchRedirector.redirect((short) 4, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Companion companion = INSTANCE;
        if (!companion.d()) {
            return null;
        }
        String d16 = g.d(url);
        if (d16 != null && d16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("ProAvatarResourceHelper", 1, "getDownloadFile but md5 is null or empty. url: " + url);
            return null;
        }
        File file = new File(companion.c(), d16);
        QLog.d("ProAvatarResourceHelper", 4, "getDownloadFile file exists:" + file.exists() + ", size:" + file.length());
        return file;
    }

    @Override // com.tencent.qqnt.avatar.meta.resource.b
    @Nullable
    public Bitmap b(@NotNull com.tencent.qqnt.avatar.meta.info.a avatarInfo, int size) {
        Integer num;
        String str;
        Long l3;
        long j3;
        Boolean bool;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, (Object) this, (Object) avatarInfo, size);
        }
        Intrinsics.checkNotNullParameter(avatarInfo, "avatarInfo");
        if (1 != MobileQQ.sProcessId) {
            QLog.e("ProAvatarResourceHelper", 2, "getBitmapFromOldDisk from non MAIN Process");
            return null;
        }
        Object b16 = avatarInfo.b("avatar_type");
        if (b16 instanceof Integer) {
            num = (Integer) b16;
        } else {
            num = null;
        }
        Object b17 = avatarInfo.b("uin");
        if (b17 instanceof String) {
            str = (String) b17;
        } else {
            str = null;
        }
        String k3 = k(avatarInfo);
        if (k3 == null) {
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQAvatarDataService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IQ\u2026va, ProcessConstant.MAIN)");
            IQQAvatarDataService iQQAvatarDataService = (IQQAvatarDataService) runtimeService;
            if (num == null) {
                return null;
            }
            num.intValue();
            if (str == null) {
                return null;
            }
            Object b18 = avatarInfo.b(FaceConstant.ZPLAN_OUT_BOUND_AVATAR_FLAG);
            if (b18 instanceof Boolean) {
                bool = (Boolean) b18;
            } else {
                bool = null;
            }
            if (bool != null) {
                z16 = bool.booleanValue();
            } else {
                z16 = false;
            }
            if (z16) {
                k3 = iQQAvatarDataService.getZplanAvatarFilePath(str, size);
            } else {
                k3 = iQQAvatarDataService.getCustomFaceFilePath(num.intValue(), str, 200, size);
            }
        }
        if (k3 == null) {
            QLog.i("ProAvatarResourceHelper", 2, "getBitmapFromOldDisk path is null");
            return null;
        }
        File file = new File(k3);
        Object b19 = avatarInfo.b(FaceConstant.AvatarInfoBuilderKeys.HEAD_IMG_TIMESTAMP);
        if (b19 instanceof Long) {
            l3 = (Long) b19;
        } else {
            l3 = null;
        }
        if (l3 != null) {
            j3 = l3.longValue();
        } else {
            j3 = 0;
        }
        if (file.exists() && file.lastModified() >= 1000 * j3) {
            j.a g16 = g(k3, size);
            QLog.i("ProAvatarResourceHelper", 2, "getFaceBitmap decodeFile, avatarType=" + num + " , uin=" + str + ", result=" + g16.f306779b + ", facePath=" + k3);
            return i(g16);
        }
        if (QLog.isDevelopLevel()) {
            QLog.e("ProAvatarResourceHelper", 2, "getBitmapFromOld return null. exist: " + file.exists() + ", time compare [" + file.lastModified() + ", " + j3 + "]");
        }
        return null;
    }

    @Override // com.tencent.qqnt.avatar.meta.resource.b
    public void c(@NotNull String url, @NotNull File file, @NotNull com.tencent.qqnt.avatar.meta.resource.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, url, file, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(callback, "callback");
        j().f(url, file, callback);
    }
}
