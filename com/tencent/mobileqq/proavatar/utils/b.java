package com.tencent.mobileqq.proavatar.utils;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/proavatar/utils/b;", "", "", "tag", "Landroid/view/View;", "view", "Landroid/graphics/drawable/Drawable;", "drawable", "", "a", "", "J", "lastPrintLogTime", "<init>", "()V", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long lastPrintLogTime;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull String tag, @NotNull View view, @Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, tag, view, drawable);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(view, "view");
        if (drawable == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastPrintLogTime < 3000) {
            return;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        Rect bounds = drawable.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "drawable.bounds");
        if (bounds.width() < width || bounds.height() < height) {
            QLog.i(tag, 1, "checkDrawableBounds: [" + bounds + "] view size:[" + width + ", " + height + "]");
        }
        if (drawable instanceof URLDrawable) {
            Drawable currDrawable = ((URLDrawable) drawable).getCurrDrawable();
            if (currDrawable instanceof ApngDrawable) {
                ApngImage image = ((ApngDrawable) currDrawable).getImage();
                if (image != null) {
                    int i3 = image.width;
                    if (i3 < width || image.height < height) {
                        QLog.i(tag, 1, "checkDrawableBounds apngImage: " + i3 + ", " + image.height + ", view size: [" + width + ", " + height + "]");
                    }
                } else {
                    QLog.i(tag, 1, "checkDrawableBounds apngImage is null");
                }
            }
        }
        this.lastPrintLogTime = currentTimeMillis;
    }
}
