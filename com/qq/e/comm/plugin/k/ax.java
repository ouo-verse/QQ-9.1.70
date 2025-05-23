package com.qq.e.comm.plugin.k;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.RoundRectUtil;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ax {

    /* renamed from: a, reason: collision with root package name */
    private static Toast f39637a;

    /* renamed from: b, reason: collision with root package name */
    private static TextView f39638b;

    public static synchronized void a(String str) {
        synchronized (ax.class) {
            a(GDTADManager.getInstance().getAppContext(), str);
            Toast toast = f39637a;
            if (toast != null) {
                toast.setDuration(0);
                f39637a.show();
            }
        }
    }

    private static void a(Context context, String str) {
        if (f39638b == null || f39637a == null) {
            a(context);
        }
        TextView textView = f39638b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    private static void a(Context context) {
        TextView textView = new TextView(context);
        f39638b = textView;
        textView.setPadding(ak.a(context, 20), ak.a(context, 12), ak.a(context, 20), ak.a(context, 12));
        f39638b.setTextColor(-1);
        f39638b.setTextSize(2, 16.0f);
        f39638b.setBackgroundDrawable(RoundRectUtil.createRoundRectDrawable(60.0f, -16777216, 100));
        Toast toast = new Toast(context);
        f39637a = toast;
        toast.setGravity(17, 0, 0);
        f39637a.setView(f39638b);
    }
}
