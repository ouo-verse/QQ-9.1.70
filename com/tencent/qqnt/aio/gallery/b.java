package com.tencent.qqnt.aio.gallery;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\n\u001a\u00020\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/b;", "", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mediaInfo", "Lkotlin/Pair;", "", "", "a", "Landroid/graphics/drawable/Drawable;", "sourceDrawable", "color", "b", "<init>", "()V", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f349994a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22645);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f349994a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final Pair<Long, Integer> a(@NotNull RFWLayerItemMediaInfo mediaInfo) {
        boolean contains$default;
        int i3;
        long parseLong;
        List split$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Pair) iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaInfo);
        }
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        String mediaId = mediaInfo.getMediaId();
        Intrinsics.checkNotNull(mediaId);
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) mediaId, (CharSequence) "_", false, 2, (Object) null);
        if (contains$default) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) mediaId, new String[]{"_"}, false, 0, 6, (Object) null);
            Object[] array = split$default.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            if (strArr.length != 2) {
                return null;
            }
            parseLong = Long.parseLong(strArr[0]);
            i3 = Integer.parseInt(strArr[1]);
        } else {
            i3 = 0;
            parseLong = Long.parseLong(mediaId);
        }
        return new Pair<>(Long.valueOf(parseLong), Integer.valueOf(i3));
    }

    @Nullable
    public final Drawable b(@Nullable Drawable sourceDrawable, @ColorInt int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, (Object) this, (Object) sourceDrawable, color);
        }
        if (sourceDrawable != null && color != 0) {
            Drawable mutate = sourceDrawable.mutate();
            if (mutate instanceof SkinnableBitmapDrawable) {
                mutate = ((SkinnableBitmapDrawable) mutate).mutate2();
            }
            if (mutate != null) {
                mutate.setColorFilter(color, PorterDuff.Mode.SRC_IN);
            }
            return mutate;
        }
        return null;
    }
}
