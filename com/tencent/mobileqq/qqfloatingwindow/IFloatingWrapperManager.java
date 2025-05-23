package com.tencent.mobileqq.qqfloatingwindow;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import gh2.d;
import gh2.f;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IFloatingWrapperManager extends QRouteApi {
    void addRootLayoutToFloatingWidgetWrapper(ViewGroup.LayoutParams layoutParams);

    void addScreenStatusReceiver(int i3, f fVar);

    void addViewToFloatingWidgetWrapper(View view, ViewGroup.LayoutParams layoutParams);

    void changeContainerLayoutParams(boolean z16, int i3, int i16, boolean z17);

    boolean checkPermission(Context context);

    int enterWindowFloat(FloatingScreenParams floatingScreenParams, View view, fh2.b bVar, fh2.a aVar);

    void enterWindowFloatWithWidgetWrapper(FloatingScreenParams floatingScreenParams);

    void floatingContainerEnterFullScreen();

    void floatingContainerQuitFullScreen();

    View getCloseView();

    boolean getContainerIsFloating();

    boolean getContainerIsSmallFloating();

    int getFloatWindowShapeType();

    int getFloatingContainerCenterX();

    int getFloatingContainerCenterY();

    boolean getFloatingContainerIsNull();

    int getFloatingContainerVisibility();

    Context getFloatingContext();

    boolean getFloatingIsFullScreen();

    String getFloatingVideoWrapperName();

    boolean getIsInterceptWindowClick(int i3, int i16);

    boolean getIsWindowClickListenerNull();

    View getRootLayout();

    View getViewById(int i3);

    void initStatusReceiver();

    void initViews(Context context, View.OnClickListener onClickListener);

    void initWidgetWrapper(View view);

    boolean isFloatWindowHasZoomed();

    void onViewClick(View view, fh2.b bVar);

    void quitWindowFloat(int i3);

    void removeFloatingWidgetWrapperViews();

    void removeParent(View view);

    void removeRootLayoutParent();

    void removeWidgetWrapperParent();

    void resetFloatWindowScale();

    void resetWindowSize();

    void restoreLastCenterPosition(FloatingScreenParams floatingScreenParams);

    void setCloseBtnContentDescription(String str);

    void setContainerClipToOutline(boolean z16);

    IVideoOuterStatusListener setDuplexVideoStatusListener(IVideoInnerStatusListener iVideoInnerStatusListener);

    void setFloatingCloseBtnVisibility(boolean z16);

    void setFloatingContainerBackPressListener(gh2.a aVar);

    void setFloatingContainerBackground(Drawable drawable);

    void setFloatingContainerBackgroundRes(int i3);

    void setFloatingContainerDragListener(gh2.b bVar);

    void setFloatingContainerOrientation(boolean z16);

    void setFloatingContainerPadding(int i3, int i16, int i17, int i18);

    void setFloatingContainerVisibility(boolean z16);

    void setFloatingWidgetBackground(Drawable drawable);

    void setFloatingWidgetClipToOutLine(boolean z16);

    void setFullScreenEnterListener(IFullScreenEnterListener iFullScreenEnterListener);

    void setFullScreenViewClickListener(gh2.c cVar);

    void setRootLayoutAlpha(float f16);

    void setRootLayoutBackgroundColor(int i3);

    void setRootLayoutBackgroundRes(int i3);

    void setRootLayoutContentDescription(String str);

    void setRootLayoutVisible();

    void setRoundCorners(int i3, int i16);

    void setVideoWrapperBackground();

    void setViewEnabled(boolean z16, View... viewArr);

    void setViewsClick(View.OnClickListener onClickListener, View... viewArr);

    void setViewsVisibility(boolean z16, View... viewArr);

    void setWindowClickListener(d dVar);

    void updateFloatingView();

    void updateLocation(int i3, int i16);

    void updateRatio(float f16);

    void updateShapeType(int i3);

    void updateSize(int i3, int i16);
}
