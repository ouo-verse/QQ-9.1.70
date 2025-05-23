package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVFloatingScreenManagerInterface;
import com.tencent.mobileqq.mediafocus.b;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;

/* compiled from: P */
/* loaded from: classes33.dex */
public class IVFloatingScreenManager implements IVFloatingScreenManagerInterface {
    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVFloatingScreenManagerInterface
    public int abandonMediaFocus(b.c cVar) {
        return IVFloatingScreenManagerInterfaceImpl.getInstance().abandonMediaFocus(cVar);
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVFloatingScreenManagerInterface
    public int enterFloatingScreen(Context context, View view) {
        return IVFloatingScreenManagerInterfaceImpl.getInstance().enterFloatingScreen(context, view);
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVFloatingScreenManagerInterface
    public void quitFloatingScreen() {
        IVFloatingScreenManagerInterfaceImpl.getInstance().quitFloatingScreen();
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVFloatingScreenManagerInterface
    public int requestMediaFocus(int i3, b.c cVar) {
        return IVFloatingScreenManagerInterfaceImpl.getInstance().requestMediaFocus(i3, cVar);
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVFloatingScreenManagerInterface
    public IVideoOuterStatusListener setFloatingVideoListener(IVideoInnerStatusListener iVideoInnerStatusListener) {
        return IVFloatingScreenManagerInterfaceImpl.getInstance().setFloatingVideoListener(iVideoInnerStatusListener);
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVFloatingScreenManagerInterface
    public void setFullScreenListener(IFullScreenEnterListener iFullScreenEnterListener) {
        IVFloatingScreenManagerInterfaceImpl.getInstance().setFullScreenListener(iFullScreenEnterListener);
    }
}
