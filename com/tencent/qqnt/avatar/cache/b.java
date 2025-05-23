package com.tencent.qqnt.avatar.cache;

import android.content.Context;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.avatar.disklrucache.a;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\t\u001a\b\u0018\u00010\bR\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/avatar/cache/b;", "", "Lcom/tencent/qqnt/avatar/disklrucache/a;", "e", "", "key", "Ljava/io/File;", "c", "Lcom/tencent/qqnt/avatar/disklrucache/a$c;", "d", "a", "Ljava/io/File;", "directory", "b", "Lcom/tencent/qqnt/avatar/disklrucache/a;", "diskCache", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private static volatile b f352700d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final File directory;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.avatar.disklrucache.a diskCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/avatar/cache/b$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/avatar/cache/b;", "a", "", "MAX_SIZE", "J", "", AEEditorConstants.PATH, "Ljava/lang/String;", "TAG", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/qqnt/avatar/cache/b;", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.avatar.cache.b$a, reason: from kotlin metadata */
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
        public final b a(@NotNull Context context) {
            b bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            b bVar2 = b.f352700d;
            if (bVar2 != null) {
                return bVar2;
            }
            synchronized (Reflection.getOrCreateKotlinClass(a.class)) {
                if (b.f352700d == null) {
                    b.f352700d = new b(context, null);
                }
                bVar = b.f352700d;
                Intrinsics.checkNotNull(bVar);
            }
            return bVar;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38971);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ b(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) defaultConstructorMarker);
    }

    private final com.tencent.qqnt.avatar.disklrucache.a e() {
        com.tencent.qqnt.avatar.disklrucache.a aVar;
        int i3 = 0;
        while (true) {
            try {
                aVar = com.tencent.qqnt.avatar.disklrucache.a.t(this.directory, 1, 1, GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV);
            } catch (IOException e16) {
                com.tencent.qqnt.avatar.util.d.f352991a.c("AvatarDownloadDiskCache", "disk cache open error " + i3 + " ,directory exists:" + this.directory.exists() + " - isDirectory:" + this.directory.isDirectory(), e16);
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

    @Nullable
    public final synchronized File c(@NotNull String key) {
        a.e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, (Object) this, (Object) key);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        File file = null;
        try {
            com.tencent.qqnt.avatar.disklrucache.a aVar = this.diskCache;
            if (aVar != null) {
                eVar = aVar.r(key);
            } else {
                eVar = null;
            }
            if (eVar != null) {
                file = eVar.a(0);
            }
        } catch (IOException e16) {
            com.tencent.qqnt.avatar.util.d.f352991a.c("AvatarDownloadDiskCache", "get from disk cache error:", e16);
        }
        return file;
    }

    @Nullable
    public final synchronized a.c d(@NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a.c) iPatchRedirector.redirect((short) 3, (Object) this, (Object) key);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        a.c cVar = null;
        try {
            com.tencent.qqnt.avatar.disklrucache.a aVar = this.diskCache;
            if (aVar != null) {
                cVar = aVar.o(key);
            }
            return cVar;
        } catch (IOException e16) {
            com.tencent.qqnt.avatar.util.d.f352991a.c("AvatarDownloadDiskCache", "get getEditor error:", e16);
            return null;
        }
    }

    b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.directory = new File(context.getCacheDir(), "proavatar_download_disk_cache");
            this.diskCache = e();
        }
    }
}
