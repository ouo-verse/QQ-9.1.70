package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.os.Build;
import com.tencent.mobileqq.R;
import com.tencent.widget.ActionSheet;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends ActionSheet {
    public b(Context context) {
        super(context);
    }

    public static b n0(Context context) {
        b bVar = new b(context);
        if (Build.VERSION.SDK_INT != 23) {
            bVar.getWindow().setWindowAnimations(R.style.f173293c);
        }
        return bVar;
    }
}
