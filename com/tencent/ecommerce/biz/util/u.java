package com.tencent.ecommerce.biz.util;

import android.graphics.Typeface;
import android.widget.TextView;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"Landroid/widget/TextView;", "", "fontFamilyId", "", "a", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class u {
    public static final void a(TextView textView, int i3) {
        textView.setTypeface(Typeface.create(textView.getContext().getResources().getString(i3), 0));
    }
}
