package com.tencent.sqshow.zootopia.guide;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.PopupWindow;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/sqshow/zootopia/guide/g;", "Landroid/widget/PopupWindow;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g extends PopupWindow {
    public g(Context context) {
        super(context);
        setOutsideTouchable(false);
        setFocusable(false);
        setHeight(-2);
        setWidth(-2);
        setBackgroundDrawable(new ColorDrawable(0));
    }
}
