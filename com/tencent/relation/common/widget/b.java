package com.tencent.relation.common.widget;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.ActionSheetHelper;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b extends ActionSheetHelper {
    static IPatchRedirector $redirector_;

    public static a a(Context context, View view) {
        a n06 = a.n0(context);
        n06.setActionContentView(view, new LinearLayout.LayoutParams(-1, -1));
        return n06;
    }
}
