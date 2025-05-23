package com.tencent.qqnt.qbasealbum.urldrawable;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/urldrawable/i;", "Lcom/tencent/qqnt/qbasealbum/urldrawable/c;", "Ljava/net/URL;", "url", "Landroid/graphics/Bitmap;", "getBitmap", "Landroid/content/Context;", "a", "Landroid/content/Context;", "mContext", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "b", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "mLocalMediaInfo", "<init>", "(Landroid/content/Context;Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class i implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Context mContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LocalMediaInfo mLocalMediaInfo;

    public i(@NotNull Context mContext, @NotNull LocalMediaInfo mLocalMediaInfo) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mLocalMediaInfo, "mLocalMediaInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mContext, (Object) mLocalMediaInfo);
        } else {
            this.mContext = mContext;
            this.mLocalMediaInfo = mLocalMediaInfo;
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.urldrawable.c
    @Nullable
    public Bitmap getBitmap(@NotNull URL url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        String path = this.mLocalMediaInfo.getPath();
        if (path != null) {
            return f11.c.m(path);
        }
        return null;
    }
}
