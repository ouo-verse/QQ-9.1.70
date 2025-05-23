package com.tencent.mobileqq.reminder.util;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a,\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a8\u0006\b"}, d2 = {"Landroid/widget/ImageView;", "", "url", "Landroid/graphics/drawable/Drawable;", "drawable", "failedDrawable", "", "b", "qqreminder-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class e {
    public static final void b(@NotNull ImageView imageView, @Nullable String str, @Nullable Drawable drawable, @Nullable Drawable drawable2) {
        boolean z16;
        String str2;
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            imageView.setTag(R.id.xiv, str);
            imageView.setImageDrawable(drawable);
            return;
        }
        Object tag = imageView.getTag(R.id.xiv);
        if (tag instanceof String) {
            str2 = (String) tag;
        } else {
            str2 = null;
        }
        if (Intrinsics.areEqual(str, str2)) {
            return;
        }
        imageView.setTag(R.id.xiv, str);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = drawable2;
        obtain.mLoadingDrawable = new ColorDrawable(0);
        final URLDrawable drawable3 = URLDrawable.getDrawable(str, obtain);
        if (drawable3.getStatus() != 1 && drawable3.getStatus() != 4) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.reminder.util.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.d(URLDrawable.this);
                }
            }, 64, null, true);
        }
        imageView.setImageDrawable(drawable3);
    }

    public static /* synthetic */ void c(ImageView imageView, String str, Drawable drawable, Drawable drawable2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            drawable = null;
        }
        if ((i3 & 4) != 0) {
            drawable2 = null;
        }
        b(imageView, str, drawable, drawable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(URLDrawable uRLDrawable) {
        uRLDrawable.downloadImediatly();
    }
}
