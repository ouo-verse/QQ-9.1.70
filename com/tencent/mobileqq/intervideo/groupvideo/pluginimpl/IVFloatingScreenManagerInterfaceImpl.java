package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.mediafocus.b;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes33.dex */
public class IVFloatingScreenManagerInterfaceImpl {
    private static final String TAG = "IVFloatingScreenManagerInterfaceImpl";
    private static final IVFloatingScreenManagerInterfaceImpl sInstance = new IVFloatingScreenManagerInterfaceImpl();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IVFloatingScreenManagerInterfaceImpl getInstance() {
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int abandonMediaFocus(b.c cVar) {
        return b.i().d(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int enterFloatingScreen(Context context, View view) {
        return ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).enterFloatingScreen(context, view, new FloatingScreenParams.FloatingBuilder().setIsHorizontal(false).setCanMove(true).setCanZoom(false).build(), 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void quitFloatingScreen() {
        ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int requestMediaFocus(int i3, b.c cVar) {
        return b.i().l(i3, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IVideoOuterStatusListener setFloatingVideoListener(IVideoInnerStatusListener iVideoInnerStatusListener) {
        return ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).setFloatingVideoListener(iVideoInnerStatusListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFullScreenListener(IFullScreenEnterListener iFullScreenEnterListener) {
        ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).setFullScreenListener(iFullScreenEnterListener);
    }
}
