package com.tencent.gamematrix.gmcg.webrtc;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;

/* compiled from: P */
/* loaded from: classes6.dex */
public class FloatingManager {
    private static FloatingManager mInstance;
    private Context mContext;
    private WindowManager mWindowManager;

    FloatingManager(Context context) {
        this.mContext = context;
        this.mWindowManager = (WindowManager) context.getSystemService("window");
    }

    public static FloatingManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new FloatingManager(context);
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean addView(View view, WindowManager.LayoutParams layoutParams) {
        try {
            this.mWindowManager.addView(view, layoutParams);
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean removeView(View view) {
        try {
            this.mWindowManager.removeView(view);
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean updateView(View view, WindowManager.LayoutParams layoutParams) {
        try {
            this.mWindowManager.updateViewLayout(view, layoutParams);
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }
}
