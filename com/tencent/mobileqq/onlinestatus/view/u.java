package com.tencent.mobileqq.onlinestatus.view;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: P */
/* loaded from: classes16.dex */
public class u {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    u.a(view, 1.0f);
                    return false;
                }
                return false;
            }
            u.a(view, 0.5f);
            return false;
        }
    }

    @TargetApi(11)
    public static void a(View view, float f16) {
        view.setAlpha(f16);
    }
}
