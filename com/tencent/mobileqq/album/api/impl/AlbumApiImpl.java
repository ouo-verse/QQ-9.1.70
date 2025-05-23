package com.tencent.mobileqq.album.api.impl;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.album.api.IAlbumApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.filter.MediaFilter;
import com.tencent.qqnt.qbasealbum.inject.QBaseAlbumCustomize;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.utils.URLDrawableHelper;
import com.tencent.qqnt.qbasealbum.utils.f;
import com.tencent.qqprotect.singleupdate.a;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016JA\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00042'\u0010\u001e\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001a0\u0019\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00120\u0018H\u0016JA\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022'\u0010\u001e\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001a0\u0019\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00120\u0018H\u0016JA\u0010 \u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022'\u0010\u001e\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001a0\u0019\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00120\u0018H\u0016J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u001aH\u0016J\u0010\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020%H\u0016J \u0010-\u001a\u00020,2\u0006\u0010(\u001a\u00020\n2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\nH\u0016\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/album/api/impl/AlbumApiImpl;", "Lcom/tencent/mobileqq/album/api/IAlbumApi;", "", "chatType", "Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;", "getMediaFilterByChatType", "Ljava/io/InputStream;", "inputIO", "Ljava/io/OutputStream;", "outputIO", "", "copyFile", "Landroid/content/Context;", "context", "", "initUrlDrawable", "Lcom/tencent/qqnt/qbasealbum/inject/QBaseAlbumCustomize;", "customize", "", "initAlbum", "preloadMedia", "Lkotlinx/coroutines/CoroutineScope;", "vmScope", "mediaFilter", "Lkotlin/Function1;", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "Lkotlin/ParameterName;", "name", "data", "callback", "queryMediaTask", "queryMediaFromCache", "needToBlockVideo", "info", "Ljava/net/URL;", "generateAlbumThumbURL", "", "time", "formatTimeToString", "path", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "targetPath", "Lcom/tencent/mobileqq/album/media/a;", "copyMediaToInternal", "<init>", "()V", "Companion", "a", "album_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AlbumApiImpl implements IAlbumApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "IAlbumApi";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/album/api/impl/AlbumApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "album_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.album.api.impl.AlbumApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36106);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AlbumApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String copyFile(InputStream inputIO, OutputStream outputIO) {
        byte[] bArr = new byte[1024];
        MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
        while (true) {
            int read = inputIO.read(bArr);
            if (read != -1) {
                outputIO.write(bArr, 0, read);
                messageDigest.update(bArr, 0, read);
            } else {
                String b16 = a.b(messageDigest.digest());
                Intrinsics.checkNotNullExpressionValue(b16, "bufferToHex(md5.digest())");
                return b16;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MediaFilter getMediaFilterByChatType(int chatType) {
        if (needToBlockVideo(chatType)) {
            MediaFilter.Companion companion = MediaFilter.INSTANCE;
            MediaFilter.a aVar = new MediaFilter.a();
            aVar.g(-1);
            return aVar.a();
        }
        MediaFilter.Companion companion2 = MediaFilter.INSTANCE;
        return new MediaFilter.a().a();
    }

    @Override // com.tencent.mobileqq.album.api.IAlbumApi
    @NotNull
    public com.tencent.mobileqq.album.media.a copyMediaToInternal(@NotNull String path, @NotNull Uri uri, @NotNull String targetPath) {
        FileOutputStream fileOutputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.mobileqq.album.media.a) iPatchRedirector.redirect((short) 10, this, path, uri, targetPath);
        }
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(targetPath, "targetPath");
        String str = "";
        if (!TextUtils.isEmpty(path)) {
            try {
                if (new File(path).exists()) {
                    fileOutputStream = new FileOutputStream(targetPath);
                    try {
                        str = copyFile(new FileInputStream(path), fileOutputStream);
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileOutputStream, null);
                        return new com.tencent.mobileqq.album.media.a(true, str);
                    } finally {
                    }
                }
            } catch (Exception e16) {
                QLog.i(TAG, 1, "path cp exc=" + e16);
            }
        }
        try {
            InputStream openInputStream = BaseApplication.context.getContentResolver().openInputStream(uri);
            if (openInputStream != null) {
                try {
                    fileOutputStream = new FileOutputStream(targetPath);
                    try {
                        str = copyFile(openInputStream, fileOutputStream);
                        Unit unit2 = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileOutputStream, null);
                        CloseableKt.closeFinally(openInputStream, null);
                    } finally {
                    }
                } finally {
                }
            }
            return new com.tencent.mobileqq.album.media.a(true, str);
        } catch (Exception e17) {
            QLog.i(TAG, 1, "exc=" + e17);
            return new com.tencent.mobileqq.album.media.a(false, str);
        }
    }

    @Override // com.tencent.mobileqq.album.api.IAlbumApi
    @NotNull
    public String formatTimeToString(long time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, time);
        }
        return f.f361654a.b(time);
    }

    @Override // com.tencent.mobileqq.album.api.IAlbumApi
    @NotNull
    public URL generateAlbumThumbURL(@NotNull LocalMediaInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (URL) iPatchRedirector.redirect((short) 8, (Object) this, (Object) info);
        }
        Intrinsics.checkNotNullParameter(info, "info");
        URL a16 = URLDrawableHelper.f361631a.a(info, "FLOW_THUMB");
        Intrinsics.checkNotNull(a16);
        return a16;
    }

    @Override // com.tencent.mobileqq.album.api.IAlbumApi
    public void initAlbum(@NotNull Context context, boolean initUrlDrawable, @NotNull QBaseAlbumCustomize customize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(initUrlDrawable), customize);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customize, "customize");
        com.tencent.qqnt.qbasealbum.a.f360732a.h(context, initUrlDrawable, customize);
    }

    @Override // com.tencent.mobileqq.album.api.IAlbumApi
    public boolean needToBlockVideo(int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, chatType)).booleanValue();
        }
        if (chatType != 105 && chatType != 106 && chatType != 111) {
            switch (chatType) {
                case 100:
                case 101:
                case 102:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.album.api.IAlbumApi
    public void preloadMedia() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            com.tencent.qqnt.qbasealbum.a.f360732a.i();
        }
    }

    @Override // com.tencent.mobileqq.album.api.IAlbumApi
    public void queryMediaFromCache(@NotNull CoroutineScope vmScope, int chatType, @NotNull Function1<? super List<LocalMediaInfo>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, vmScope, Integer.valueOf(chatType), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(vmScope, "vmScope");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(vmScope, Dispatchers.getIO(), null, new AlbumApiImpl$queryMediaFromCache$1(this, chatType, callback, null), 2, null);
    }

    @Override // com.tencent.mobileqq.album.api.IAlbumApi
    public void queryMediaTask(@NotNull CoroutineScope vmScope, @NotNull MediaFilter mediaFilter, @NotNull Function1<? super List<LocalMediaInfo>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, vmScope, mediaFilter, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(vmScope, "vmScope");
        Intrinsics.checkNotNullParameter(mediaFilter, "mediaFilter");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(vmScope, Dispatchers.getIO(), null, new AlbumApiImpl$queryMediaTask$1(mediaFilter, callback, null), 2, null);
    }

    @Override // com.tencent.mobileqq.album.api.IAlbumApi
    public void queryMediaTask(@NotNull CoroutineScope vmScope, int chatType, @NotNull Function1<? super List<LocalMediaInfo>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, vmScope, Integer.valueOf(chatType), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(vmScope, "vmScope");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(vmScope, Dispatchers.getIO(), null, new AlbumApiImpl$queryMediaTask$2(this, chatType, callback, null), 2, null);
    }
}
