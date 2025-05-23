package com.tencent.mobileqq.qqfloatingwindow;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import gh2.d;
import java.util.ArrayList;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQFloatingWindow extends QRouteApi {
    int enterCustomFloatingScreen(Context context, View view, FloatingScreenParams floatingScreenParams, String str, int i3);

    int enterFloatingScreen(Context context, View view, FloatingScreenParams floatingScreenParams, int i3);

    int enterFloatingScreen(Context context, View view, FloatingScreenParams floatingScreenParams, int i3, String str);

    int enterLocationFloatingScreen(Context context, View view, FloatingScreenParams floatingScreenParams, String str);

    int enterWatchTogetherFloatingScreen(Context context, View view, FloatingScreenParams floatingScreenParams, String str);

    ArrayList<a> getExistFloatingWrappers();

    a getFloatingProxyWrapper(Context context, String str);

    void quitFloatingScreen();

    void quitFloatingScreen(String str);

    void saveFloatingCenter(int i3, int i16);

    IVideoOuterStatusListener setFloatingVideoListener(IVideoInnerStatusListener iVideoInnerStatusListener);

    IVideoOuterStatusListener setFloatingVideoListener(IVideoInnerStatusListener iVideoInnerStatusListener, String str);

    @Deprecated
    void setFullScreenListener(IFullScreenEnterListener iFullScreenEnterListener);

    void setFullScreenViewClickListener(gh2.c cVar);

    void setWindowClickListener(String str, d dVar);

    void updateFloatingWindowLocation(int i3, int i16, String str);

    void updateFloatingWindowRatio(float f16, String str);

    void updateFloatingWindowShape(int i3, String str);

    void updateFloatingWindowSize(int i3, int i16, String str);
}
