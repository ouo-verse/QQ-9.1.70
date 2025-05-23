package com.tencent.qqnt.qbasealbum.urldrawable;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.io.File;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/urldrawable/a;", "Lcom/tencent/image/ProtocolDownloader$Adapter;", "Lcom/tencent/image/DownloadParams;", DownloadInfo.spKey_Config, "", "hasDiskFile", "Lcom/tencent/image/URLDrawableHandler;", "handler", "Ljava/io/File;", "loadImageFile", "f", "Landroid/graphics/Bitmap;", "a", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends ProtocolDownloader.Adapter {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ac A[Catch: NumberFormatException -> 0x00b4, TRY_LEAVE, TryCatch #0 {NumberFormatException -> 0x00b4, blocks: (B:12:0x0043, B:14:0x004b, B:15:0x004f, B:17:0x0053, B:20:0x005d, B:21:0x0098, B:23:0x00ac, B:26:0x0063, B:29:0x006d, B:30:0x0073, B:33:0x007d, B:34:0x0083, B:37:0x008d, B:38:0x0093), top: B:11:0x0043 }] */
    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    @Nullable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap decodeFile(@NotNull File f16, @NotNull DownloadParams config, @NotNull URLDrawableHandler handler) throws Exception {
        c thumbDecoder;
        Bitmap j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap) iPatchRedirector.redirect((short) 4, this, f16, config, handler);
        }
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Context a16 = com.tencent.qqnt.qbasealbum.inject.a.f361230a.a();
        if (LocalMediaInfo.class.isInstance(config.tag)) {
            Object obj = config.tag;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.qqnt.qbasealbum.model.LocalMediaInfo");
            LocalMediaInfo localMediaInfo = (LocalMediaInfo) obj;
            try {
                String ref = config.url.getRef();
                if (ref != null) {
                    switch (ref.hashCode()) {
                        case 81665115:
                            if (!ref.equals("VIDEO")) {
                                break;
                            } else {
                                thumbDecoder = new i(a16, localMediaInfo);
                                break;
                            }
                        case 1252735133:
                            if (!ref.equals("APP_VIDEO")) {
                                break;
                            } else {
                                thumbDecoder = new b(a16, localMediaInfo);
                                break;
                            }
                        case 2098289828:
                            if (!ref.equals("IMAGE_PREVIEW")) {
                                break;
                            } else {
                                thumbDecoder = new ImagePreviewDecoder(localMediaInfo);
                                break;
                            }
                        case 2147416933:
                            if (!ref.equals("FLOW_THUMB")) {
                                break;
                            } else {
                                thumbDecoder = new FlowThumbDecoder(a16, localMediaInfo);
                                break;
                            }
                    }
                    AlbumThumbManager e16 = AlbumThumbManager.INSTANCE.e(a16);
                    URL url = config.url;
                    Intrinsics.checkNotNullExpressionValue(url, "config.url");
                    j3 = e16.j(url, thumbDecoder, config);
                    if (j3 != null) {
                        localMediaInfo.setThumbSize(j3.getByteCount());
                    }
                    return j3;
                }
                thumbDecoder = new ThumbDecoder(localMediaInfo);
                AlbumThumbManager e162 = AlbumThumbManager.INSTANCE.e(a16);
                URL url2 = config.url;
                Intrinsics.checkNotNullExpressionValue(url2, "config.url");
                j3 = e162.j(url2, thumbDecoder, config);
                if (j3 != null) {
                }
                return j3;
            } catch (NumberFormatException unused) {
                throw new RuntimeException("Decode type is invalid");
            }
        }
        throw new RuntimeException("Decode info is invalid");
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public boolean hasDiskFile(@NotNull DownloadParams config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) config)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(config, "config");
        return true;
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    @NotNull
    public File loadImageFile(@NotNull DownloadParams config, @NotNull URLDrawableHandler handler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (File) iPatchRedirector.redirect((short) 3, (Object) this, (Object) config, (Object) handler);
        }
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(handler, "handler");
        return new File("");
    }
}
