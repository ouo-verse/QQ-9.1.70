package com.tencent.qqnt.qbasealbum.urldrawable;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/urldrawable/b;", "Lcom/tencent/qqnt/qbasealbum/urldrawable/c;", "Ljava/net/URL;", "url", "Landroid/graphics/Bitmap;", "getBitmap", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mContext", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "b", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "getLocalMediaInfo", "()Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "setLocalMediaInfo", "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;)V", "localMediaInfo", "<init>", "(Landroid/content/Context;Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Context mContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LocalMediaInfo localMediaInfo;

    public b(@NotNull Context mContext, @NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mContext, (Object) localMediaInfo);
        } else {
            this.mContext = mContext;
            this.localMediaInfo = localMediaInfo;
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.urldrawable.c
    @Nullable
    public Bitmap getBitmap(@NotNull URL url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bitmap) iPatchRedirector.redirect((short) 6, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        String path = this.localMediaInfo.getPath();
        Intrinsics.checkNotNull(path);
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(path, 1);
        Pair<Integer, Integer> a16 = DecoderUtil.f361588a.a(this.localMediaInfo);
        return ThumbnailUtils.extractThumbnail(createVideoThumbnail, a16.getFirst().intValue(), a16.getSecond().intValue());
    }
}
