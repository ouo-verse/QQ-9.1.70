package com.tencent.mobileqq.onlinestatus.api.impl;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.api.impl.AvatarStatusPreviewCache;
import com.tencent.mobileqq.onlinestatus.networkhandler.d;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00072\u00020\u0001:\u0002\u0018$B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J6\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004R\u001b\u0010\u001c\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/api/impl/AvatarStatusPreviewCache;", "", "Lcom/tencent/mobileqq/onlinestatus/api/impl/AvatarStatusPreviewCache$Key;", "key", "", "g", "", "c", "filePath", "md5", "sha1", "", "d", "previewPath", "l", "i", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "k", "url", "Lcom/tencent/mobileqq/onlinestatus/api/impl/q;", "listener", "needCheck", "e", "a", "Lkotlin/Lazy;", tl.h.F, "()Ljava/lang/String;", "cacheDir", "Landroid/content/SharedPreferences;", "b", "j", "()Landroid/content/SharedPreferences;", "sp", "<init>", "()V", "Key", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class AvatarStatusPreviewCache {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Lazy<AvatarStatusPreviewCache> f255425d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy cacheDir;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy sp;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001b\u0010\u0017\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0013\u0010\f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/api/impl/AvatarStatusPreviewCache$Key;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "uin", "b", "I", "d", "()I", "onlineStatus", "c", "actionKey", "dressKey", "Lkotlin/Lazy;", "keyValue", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final /* data */ class Key {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String uin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int onlineStatus;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String actionKey;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String dressKey;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy keyValue;

        public Key(@NotNull String uin, int i3, @NotNull String actionKey, @NotNull String dressKey) {
            Lazy lazy;
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(actionKey, "actionKey");
            Intrinsics.checkNotNullParameter(dressKey, "dressKey");
            this.uin = uin;
            this.onlineStatus = i3;
            this.actionKey = actionKey;
            this.dressKey = dressKey;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.AvatarStatusPreviewCache$Key$keyValue$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    return AvatarStatusPreviewCache.Key.this.getOnlineStatus() + "_" + AvatarStatusPreviewCache.Key.this.getActionKey() + "_" + AvatarStatusPreviewCache.Key.this.getDressKey();
                }
            });
            this.keyValue = lazy;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getActionKey() {
            return this.actionKey;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getDressKey() {
            return this.dressKey;
        }

        @NotNull
        public final String c() {
            return (String) this.keyValue.getValue();
        }

        /* renamed from: d, reason: from getter */
        public final int getOnlineStatus() {
            return this.onlineStatus;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getUin() {
            return this.uin;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Key)) {
                return false;
            }
            Key key = (Key) other;
            if (Intrinsics.areEqual(this.uin, key.uin) && this.onlineStatus == key.onlineStatus && Intrinsics.areEqual(this.actionKey, key.actionKey) && Intrinsics.areEqual(this.dressKey, key.dressKey)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.uin.hashCode() * 31) + this.onlineStatus) * 31) + this.actionKey.hashCode()) * 31) + this.dressKey.hashCode();
        }

        @NotNull
        public String toString() {
            return "Key(uin=" + this.uin + ", onlineStatus=" + this.onlineStatus + ", actionKey=" + this.actionKey + ", dressKey=" + this.dressKey + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\bR!\u0010\t\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/api/impl/AvatarStatusPreviewCache$a;", "", "Lcom/tencent/mobileqq/onlinestatus/api/impl/AvatarStatusPreviewCache;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/onlinestatus/api/impl/AvatarStatusPreviewCache;", "getInstance$annotations", "()V", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "NAME_AVATAR_PREVIEW_DIR", "Ljava/lang/String;", "SP_NAME", "TAG", "<init>", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.onlinestatus.api.impl.AvatarStatusPreviewCache$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AvatarStatusPreviewCache a() {
            return (AvatarStatusPreviewCache) AvatarStatusPreviewCache.f255425d.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<AvatarStatusPreviewCache> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AvatarStatusPreviewCache>() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.AvatarStatusPreviewCache$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AvatarStatusPreviewCache invoke() {
                return new AvatarStatusPreviewCache();
            }
        });
        f255425d = lazy;
    }

    public AvatarStatusPreviewCache() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.AvatarStatusPreviewCache$cacheDir$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return BaseApplication.context.getCacheDir().getAbsolutePath() + File.separator + "online_status/avatar/preview_cache";
            }
        });
        this.cacheDir = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<SharedPreferences>() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.AvatarStatusPreviewCache$sp$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPreferences invoke() {
                return QMMKV.fromSpAdapter(BaseApplication.context, "com.tencent.mobileqq.onlinestatus.api.impl.AvatarStatusPreviewCache", "common_mmkv_configurations");
            }
        });
        this.sp = lazy2;
    }

    private final void c() {
        File file = new File(h());
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    private final boolean d(String filePath, String md5, String sha1) {
        boolean equals;
        boolean equals2;
        d.a a16 = com.tencent.mobileqq.onlinestatus.networkhandler.d.f256083a.a(filePath);
        boolean z16 = false;
        if (a16 == null) {
            return false;
        }
        String bytes2HexStr = HexUtil.bytes2HexStr(a16.getMd5());
        String bytes2HexStr2 = HexUtil.bytes2HexStr(a16.getSha1());
        equals = StringsKt__StringsJVMKt.equals(md5, bytes2HexStr, true);
        if (equals) {
            equals2 = StringsKt__StringsJVMKt.equals(sha1, bytes2HexStr2, true);
            if (equals2) {
                z16 = true;
            }
        }
        QLog.i("OnlineStatusAvatar.PreviewCache", 1, "checkMd5AndSha1 result: " + z16);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(AvatarStatusPreviewCache this$0, Key key, String url, q listener, boolean z16, String md5, String sha1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(key, "$key");
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(md5, "$md5");
        Intrinsics.checkNotNullParameter(sha1, "$sha1");
        try {
            String i3 = this$0.i(key);
            File file = new File(this$0.g(key));
            this$0.c();
            boolean download = HttpDownloadUtil.download(MobileQQ.sMobileQQ.peekAppRuntime(), url, file);
            QLog.i("OnlineStatusAvatar.PreviewCache", 1, "[downloadPreview]: result is " + download + ", key is " + key);
            if (!download) {
                listener.a(null);
                if (file.exists()) {
                    file.delete();
                }
            } else {
                if (z16) {
                    String absolutePath = file.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                    if (!this$0.d(absolutePath, md5, sha1)) {
                        QLog.i("OnlineStatusAvatar.PreviewCache", 1, "[downloadPreview]: need check but check fail");
                        listener.a(null);
                        file.delete();
                    }
                }
                listener.a(file.getAbsolutePath());
                String absolutePath2 = file.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath2, "file.absolutePath");
                this$0.l(key, absolutePath2);
                if (i3 != null) {
                    File file2 = new File(i3);
                    if (file2.exists()) {
                        file2.delete();
                    }
                }
            }
        } catch (Error e16) {
            listener.a(null);
            QLog.i("OnlineStatusAvatar.PreviewCache", 1, "[downloadPreview] error=" + e16 + " key=" + key);
        } catch (Exception e17) {
            listener.a(null);
            QLog.i("OnlineStatusAvatar.PreviewCache", 1, "[downloadPreview] exception=" + e17 + " key=" + key);
        }
    }

    private final String g(Key key) {
        return h() + "/" + key.c() + "-" + System.currentTimeMillis() + ".png";
    }

    private final SharedPreferences j() {
        Object value = this.sp.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-sp>(...)");
        return (SharedPreferences) value;
    }

    public final void e(@NotNull final String url, @NotNull final Key key, @NotNull final q listener, final boolean needCheck, @NotNull final String md5, @NotNull final String sha1) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(md5, "md5");
        Intrinsics.checkNotNullParameter(sha1, "sha1");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                AvatarStatusPreviewCache.f(AvatarStatusPreviewCache.this, key, url, listener, needCheck, md5, sha1);
            }
        }, 128, null, true);
    }

    @NotNull
    public final String h() {
        return (String) this.cacheDir.getValue();
    }

    @Nullable
    public final String i(@NotNull Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String string = j().getString(key.c(), null);
        if (QLog.isColorLevel()) {
            QLog.i("OnlineStatusAvatar.PreviewCache", 2, "[getPreview] key=" + key.c() + ", cache=" + string);
        }
        return string;
    }

    public final void k(@NotNull Key key, @NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        try {
            String i3 = i(key);
            String g16 = g(key);
            c();
            FileOutputStream fileOutputStream = new FileOutputStream(g16);
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                QLog.i("OnlineStatusAvatar.PreviewCache", 1, "[savePreview] key=" + key.c() + ", path=" + g16);
                l(key, g16);
                if (i3 != null) {
                    File file = new File(i3);
                    if (file.exists()) {
                        file.delete();
                    }
                    Unit unit = Unit.INSTANCE;
                }
                CloseableKt.closeFinally(fileOutputStream, null);
            } catch (Throwable th5) {
                try {
                    throw th5;
                } catch (Throwable th6) {
                    CloseableKt.closeFinally(fileOutputStream, th5);
                    throw th6;
                }
            }
        } catch (Error e16) {
            QLog.i("OnlineStatusAvatar.PreviewCache", 1, "[savePreview] error=" + e16 + " key=" + key.c());
        } catch (Exception e17) {
            QLog.i("OnlineStatusAvatar.PreviewCache", 1, "[savePreview] exception=" + e17 + " key=" + key.c());
        }
    }

    public final void l(@NotNull Key key, @NotNull String previewPath) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(previewPath, "previewPath");
        j().edit().putString(key.c(), previewPath).apply();
    }
}
