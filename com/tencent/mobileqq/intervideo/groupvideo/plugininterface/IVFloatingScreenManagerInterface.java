package com.tencent.mobileqq.intervideo.groupvideo.plugininterface;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.mediafocus.b;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface IVFloatingScreenManagerInterface {
    int abandonMediaFocus(b.c cVar);

    int enterFloatingScreen(Context context, View view);

    void quitFloatingScreen();

    int requestMediaFocus(int i3, b.c cVar);

    IVideoOuterStatusListener setFloatingVideoListener(IVideoInnerStatusListener iVideoInnerStatusListener);

    void setFullScreenListener(IFullScreenEnterListener iFullScreenEnterListener);
}
