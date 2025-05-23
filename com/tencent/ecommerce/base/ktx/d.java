package com.tencent.ecommerce.base.ktx;

import android.widget.EditText;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"Landroid/widget/EditText;", "", "text", "", "a", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class d {
    public static final void a(EditText editText, String str) {
        editText.setText(str);
        editText.setSelection(str.length());
    }
}
