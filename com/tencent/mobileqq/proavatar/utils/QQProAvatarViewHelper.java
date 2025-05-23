package com.tencent.mobileqq.proavatar.utils;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0002R\u001b\u0010\n\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/proavatar/utils/QQProAvatarViewHelper;", "", "Lcom/tencent/qqnt/avatar/layer/d;", "layer", "Lcom/tencent/qqnt/avatar/layer/b;", "a", "", "b", "Lkotlin/Lazy;", "()Z", "bitmapDrawableSwitch", "<init>", "()V", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QQProAvatarViewHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QQProAvatarViewHelper f259708a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy bitmapDrawableSwitch;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33966);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f259708a = new QQProAvatarViewHelper();
        lazy = LazyKt__LazyJVMKt.lazy(QQProAvatarViewHelper$bitmapDrawableSwitch$2.INSTANCE);
        bitmapDrawableSwitch = lazy;
    }

    QQProAvatarViewHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b() {
        return ((Boolean) bitmapDrawableSwitch.getValue()).booleanValue();
    }

    @Nullable
    public final com.tencent.qqnt.avatar.layer.b a(@NotNull com.tencent.qqnt.avatar.layer.d<? extends Object> layer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.avatar.layer.b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) layer);
        }
        Intrinsics.checkNotNullParameter(layer, "layer");
        com.tencent.qqnt.avatar.layer.c cVar = null;
        if (!b()) {
            return null;
        }
        Object d16 = layer.d();
        if (!(d16 instanceof Bitmap)) {
            return null;
        }
        Bitmap bitmap = (Bitmap) d16;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        com.tencent.qqnt.avatar.layer.c c16 = layer.c();
        if (c16 != null) {
            Rect c17 = c16.c();
            if (c17 == null) {
                c17 = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            }
            cVar = new com.tencent.qqnt.avatar.layer.c(c16.b(), c16.a(), c17);
        }
        return new com.tencent.qqnt.avatar.layer.b(layer.b(), bitmapDrawable, cVar);
    }
}
