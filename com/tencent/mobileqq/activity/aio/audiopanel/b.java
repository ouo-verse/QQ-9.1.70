package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ch;
import com.tencent.mobileqq.widget.QQToast;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f178314a = false;

    public static void a(Context context, boolean z16, boolean z17, boolean z18) {
        int a16 = ch.a(z16, z17, z18);
        if (a16 > 0) {
            QQToast.makeText(context, a16, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
    }
}
