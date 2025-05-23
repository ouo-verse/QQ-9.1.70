package com.tencent.qqnt.avatar.meta.transform;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.avatar.layer.c;
import com.tencent.qqnt.avatar.util.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J3\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u00a2\u0006\u0004\b\t\u0010\nJ-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/transform/a;", "", "Lcom/tencent/qqnt/avatar/meta/b;", "avatarBean", "", "Lcom/tencent/qqnt/avatar/meta/info/a;", "avatarInfoArr", "Landroid/graphics/Bitmap;", "bitmapArr", "b", "(Lcom/tencent/qqnt/avatar/meta/b;[Lcom/tencent/qqnt/avatar/meta/info/a;[Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Lcom/tencent/qqnt/avatar/layer/c;", "c", "(Lcom/tencent/qqnt/avatar/meta/b;[Lcom/tencent/qqnt/avatar/meta/info/a;Landroid/graphics/Bitmap;)Lcom/tencent/qqnt/avatar/layer/c;", "", "Lcom/tencent/qqnt/avatar/meta/transform/b;", "Ljava/util/List;", "a", "()Ljava/util/List;", "handlerList", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f352982a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<b> handlerList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40571);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f352982a = new a();
            handlerList = new ArrayList();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final List<b> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return handlerList;
    }

    @Nullable
    public final Bitmap b(@NotNull com.tencent.qqnt.avatar.meta.b avatarBean, @NotNull com.tencent.qqnt.avatar.meta.info.a[] avatarInfoArr, @NotNull Bitmap[] bitmapArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, this, avatarBean, avatarInfoArr, bitmapArr);
        }
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        Intrinsics.checkNotNullParameter(avatarInfoArr, "avatarInfoArr");
        Intrinsics.checkNotNullParameter(bitmapArr, "bitmapArr");
        for (b bVar : handlerList) {
            if (bVar.a(avatarBean, avatarInfoArr)) {
                try {
                    Bitmap b16 = bVar.b(avatarBean, avatarInfoArr, bitmapArr);
                    if (b16 != null) {
                        return b16;
                    }
                } catch (Throwable th5) {
                    d.f352991a.c("AvatarTransformHandlerManager", "transformAvatar catch exception", th5);
                }
            }
        }
        return null;
    }

    @Nullable
    public final c c(@NotNull com.tencent.qqnt.avatar.meta.b avatarBean, @NotNull com.tencent.qqnt.avatar.meta.info.a[] avatarInfoArr, @NotNull Bitmap bitmap) {
        c c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (c) iPatchRedirector.redirect((short) 4, this, avatarBean, avatarInfoArr, bitmap);
        }
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        Intrinsics.checkNotNullParameter(avatarInfoArr, "avatarInfoArr");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        for (b bVar : handlerList) {
            if (bVar.a(avatarBean, avatarInfoArr) && (c16 = bVar.c(avatarBean, avatarInfoArr, bitmap)) != null) {
                return c16;
            }
        }
        return null;
    }
}
