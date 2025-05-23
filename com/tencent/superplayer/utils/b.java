package com.tencent.superplayer.utils;

import android.view.WindowManager;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {
    public static int a() {
        if (SuperPlayerSDKMgr.getContext() != null) {
            WindowManager windowManager = (WindowManager) SuperPlayerSDKMgr.getContext().getSystemService("window");
            if (windowManager.getDefaultDisplay() != null) {
                return windowManager.getDefaultDisplay().getHeight();
            }
            return 0;
        }
        return 0;
    }

    public static int b() {
        if (SuperPlayerSDKMgr.getContext() != null) {
            WindowManager windowManager = (WindowManager) SuperPlayerSDKMgr.getContext().getSystemService("window");
            if (windowManager.getDefaultDisplay() != null) {
                return windowManager.getDefaultDisplay().getWidth();
            }
            return 0;
        }
        return 0;
    }
}
