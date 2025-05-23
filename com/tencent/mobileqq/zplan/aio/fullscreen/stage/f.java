package com.tencent.mobileqq.zplan.aio.fullscreen.stage;

import android.graphics.drawable.Drawable;
import com.tencent.image.SharpDrawable;
import com.tencent.image.URLDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/image/URLDrawable;", "Lcom/tencent/image/SharpDrawable;", "a", "(Lcom/tencent/image/URLDrawable;)Lcom/tencent/image/SharpDrawable;", "shpDrawable", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class f {
    public static final SharpDrawable a(URLDrawable uRLDrawable) {
        Intrinsics.checkNotNullParameter(uRLDrawable, "<this>");
        Drawable currDrawable = uRLDrawable.getCurrDrawable();
        if (currDrawable instanceof SharpDrawable) {
            return (SharpDrawable) currDrawable;
        }
        return null;
    }
}
