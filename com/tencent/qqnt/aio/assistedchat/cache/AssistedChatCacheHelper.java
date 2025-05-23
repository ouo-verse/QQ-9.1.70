package com.tencent.qqnt.aio.assistedchat.cache;

import android.content.Context;
import com.jakewharton.disklrucache.DiskLruCache;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0010\u0018\u0000 \r2\u00020\u0001:\u0001\u0011B/\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0017\u00a2\u0006\u0004\b5\u00106J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\r\u001a\u0004\u0018\u00010\nJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010&\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010 \u001a\u0004\b$\u0010%R\"\u0010-\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00100\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010(\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R$\u00104\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\u0015\u001a\u0004\b1\u0010%\"\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/cache/AssistedChatCacheHelper;", "", "", "value", "", DomainData.DOMAIN_NAME, "l", "Ljava/io/Closeable;", "closeable", "f", "", "byteArray", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "Lcom/tencent/qqnt/aio/assistedchat/cache/a;", h.F, "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "b", "Ljava/lang/String;", "uin", "", "c", "I", "chatType", "d", "peerUid", "e", "scene", "Ljava/io/File;", "Lkotlin/Lazy;", "g", "()Ljava/io/File;", "cacheDir", "i", "()Ljava/lang/String;", "cacheKey", "", "J", "getExpiredTime", "()J", "setExpiredTime", "(J)V", "expiredTime", "getMaxSize", "setMaxSize", "maxSize", "j", "setCacheSubDir", "(Ljava/lang/String;)V", "cacheSubDir", "<init>", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;I)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AssistedChatCacheHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int chatType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String peerUid;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int scene;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy cacheDir;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy cacheKey;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long expiredTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long maxSize;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String cacheSubDir;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/cache/AssistedChatCacheHelper$a;", "", "", "DISK_CACHE_PATH", "Ljava/lang/String;", "", "SCENE_BOTTOM_BAR", "I", "SCENE_CONFIG", "SCENE_PANEL_TOPIC", "TAG", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.cache.AssistedChatCacheHelper$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58390);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AssistedChatCacheHelper(@NotNull Context context, @NotNull String uin, int i3, @NotNull String peerUid, int i16) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, uin, Integer.valueOf(i3), peerUid, Integer.valueOf(i16));
            return;
        }
        this.context = context;
        this.uin = uin;
        this.chatType = i3;
        this.peerUid = peerUid;
        this.scene = i16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<File>() { // from class: com.tencent.qqnt.aio.assistedchat.cache.AssistedChatCacheHelper$cacheDir$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssistedChatCacheHelper.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final File invoke() {
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (File) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context2 = AssistedChatCacheHelper.this.context;
                File file = new File(context2.getCacheDir(), "aioassistedchat");
                String j3 = AssistedChatCacheHelper.this.j();
                return j3 == null || j3.length() == 0 ? file : new File(file, AssistedChatCacheHelper.this.j());
            }
        });
        this.cacheDir = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.qqnt.aio.assistedchat.cache.AssistedChatCacheHelper$cacheKey$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssistedChatCacheHelper.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String str;
                int i17;
                String str2;
                int i18;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                str = AssistedChatCacheHelper.this.uin;
                i17 = AssistedChatCacheHelper.this.chatType;
                str2 = AssistedChatCacheHelper.this.peerUid;
                i18 = AssistedChatCacheHelper.this.scene;
                String str3 = str + "_" + i17 + "_" + str2 + "_" + i18;
                String md5 = MD5.toMD5(str3);
                if (md5 != null) {
                    String lowerCase = md5.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    if (lowerCase != null) {
                        return lowerCase;
                    }
                }
                String lowerCase2 = str3.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                return lowerCase2;
            }
        });
        this.cacheKey = lazy2;
        this.maxSize = 307200L;
    }

    private final void f(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                QLog.e("AssistedChatPanelCacheHelper", 1, "closeQuietly exception: ", e16);
            }
        }
    }

    private final File g() {
        return (File) this.cacheDir.getValue();
    }

    private final String i() {
        return (String) this.cacheKey.getValue();
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0042: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:67), block:B:30:0x0042 */
    private final synchronized String l() {
        DiskLruCache diskLruCache;
        DiskLruCache.Snapshot snapshot;
        Closeable closeable;
        String str;
        Closeable closeable2 = null;
        str = null;
        closeable2 = null;
        str = null;
        try {
            try {
                diskLruCache = DiskLruCache.open(g(), 1, 1, this.maxSize);
            } catch (IOException e16) {
                e = e16;
                diskLruCache = null;
                snapshot = null;
            } catch (Throwable th5) {
                th = th5;
                diskLruCache = null;
            }
            try {
                snapshot = diskLruCache.get(i());
                if (snapshot != null) {
                    try {
                        str = snapshot.getString(0);
                    } catch (IOException e17) {
                        e = e17;
                        QLog.e("AssistedChatPanelCacheHelper", 1, "getFromDiskCache exception: ", e);
                        f(snapshot);
                        f(diskLruCache);
                        return str;
                    }
                }
                f(snapshot);
            } catch (IOException e18) {
                e = e18;
                snapshot = null;
            } catch (Throwable th6) {
                th = th6;
                f(closeable2);
                f(diskLruCache);
                throw th;
            }
            f(diskLruCache);
        } catch (Throwable th7) {
            th = th7;
            closeable2 = closeable;
        }
        return str;
    }

    private final synchronized void n(String value) {
        DiskLruCache diskLruCache;
        Closeable closeable = null;
        r1 = null;
        DiskLruCache.Editor editor = null;
        try {
            try {
                diskLruCache = DiskLruCache.open(g(), 1, 1, this.maxSize);
            } catch (IOException e16) {
                e = e16;
                diskLruCache = null;
            } catch (Throwable th5) {
                th = th5;
                f(closeable);
                throw th;
            }
            try {
                editor = diskLruCache.edit(i());
                if (editor != null) {
                    editor.set(0, value);
                }
                if (editor != null) {
                    editor.commit();
                }
            } catch (IOException e17) {
                e = e17;
                QLog.e("AssistedChatPanelCacheHelper", 1, "putToDiskCache exception: ", e);
                if (editor != null) {
                    try {
                        editor.abort();
                    } catch (Exception e18) {
                        QLog.e("AssistedChatPanelCacheHelper", 1, "putToDiskCache editor abort exception: ", e18);
                    }
                }
                f(diskLruCache);
            }
            f(diskLruCache);
        } catch (Throwable th6) {
            th = th6;
            closeable = diskLruCache;
            f(closeable);
            throw th;
        }
    }

    @Nullable
    public final a h() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (a) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        String l3 = l();
        if (l3 != null && l3.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        return b.a(l3);
    }

    @Nullable
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.cacheSubDir;
    }

    @Nullable
    public final byte[] k() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (byte[]) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        a h16 = h();
        if (h16 == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.expiredTime > 0 && currentTimeMillis - h16.b() > this.expiredTime) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d("AssistedChatPanelCacheHelper", 2, "cache expired chatType=" + this.chatType + " peerUid=" + this.peerUid + " scene=" + this.scene);
            }
            return null;
        }
        return h16.a();
    }

    public final void m(@NotNull byte[] byteArray) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) byteArray);
            return;
        }
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        String b16 = b.b(new a(byteArray, System.currentTimeMillis()));
        if (b16 == null) {
            return;
        }
        if (b16.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            n(b16);
        }
    }
}
