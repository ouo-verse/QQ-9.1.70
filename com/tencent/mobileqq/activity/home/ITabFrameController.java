package com.tencent.mobileqq.activity.home;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.mobileqq.widget.TabViewMap;
import com.tencent.mobileqq.widget.bn;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface ITabFrameController extends QRouteApi {
    void addFrame(FrameFragment frameFragment, View view, Class<? extends Frame> cls, View view2);

    void addFrameIndividual(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, com.tencent.mobileqq.activity.home.impl.d dVar);

    Frame buildFrame(FrameFragment frameFragment, String str);

    View buildSingleTabIcon(String str, FrameFragment frameFragment);

    TabViewMap buildTabIcon(Context context);

    void checkBusinessSwitch(com.tencent.mobileqq.activity.home.impl.d dVar);

    boolean checkFrameChanged(com.tencent.mobileqq.activity.home.impl.d dVar, FrameFragment frameFragment);

    void clearUselessBackground(View view);

    void doFramesPauseAfter(FrameFragment frameFragment);

    void doOnEntry(FrameFragment frameFragment, Intent intent);

    String getCurrentTabTag(FrameFragment.d dVar);

    com.tencent.mobileqq.activity.home.impl.c getFrameInfoByClazz(Class cls);

    com.tencent.mobileqq.activity.home.impl.c getFrameInfoByIndex(int i3);

    com.tencent.mobileqq.activity.home.impl.c getFrameInfoByKey(String str);

    int getTabIndexFromName(String str);

    String getTabNameFromTabIndex(int i3);

    void handleThemeChanged(FrameFragment frameFragment);

    boolean hasUnReadRedPacket(AppRuntime appRuntime);

    void initIconExtraListener(FrameFragment frameFragment);

    void initIconUnReadView(FrameFragment frameFragment);

    void initTabs(FrameFragment frameFragment, View view);

    boolean isFragmentNotMatch();

    int mainTabID2TabIndex(Bundle bundle);

    void onConfigurationChanged(Configuration configuration, FrameFragment frameFragment);

    void onDrawCompleteAfter(FrameFragment frameFragment);

    void onFragmentDrawerClosed(FrameFragment frameFragment, int i3, int i16);

    void onFragmentDrawerInit(boolean z16);

    void onResumeAfter(FrameFragment frameFragment);

    void onResumeUpdateSound(FrameFragment frameFragment);

    void onTouchDragChange(boolean z16);

    bn preLoadMainViews(LayoutInflater layoutInflater);

    void recoverUselessBackground(View view);

    void revertTabIconChange(FrameFragment frameFragment);

    void setCurrentIntentParams(FrameFragment frameFragment);

    com.tencent.mobileqq.activity.home.impl.d setFrames(FrameFragment frameFragment, boolean z16, int i3);

    void setIntent(Intent intent, FrameFragment frameFragment);

    void setSoundEffectsEnableForTab(View view, boolean z16);

    void updateFrames(FrameFragment frameFragment, int i3, int i16, Object obj);

    void updateRedBadge(FrameFragment frameFragment, int i3, TianshuRedTouch tianshuRedTouch, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo);

    void updateRedTouch(FrameFragment frameFragment, int i3, RedTouch redTouch, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo);

    void updateTabContentDescription(FrameFragment frameFragment, String str, String str2);

    void updateTabDefaultFocusIcon(AppRuntime appRuntime, boolean z16, SparseArray<TabDragAnimationView> sparseArray, int i3);

    void updateTabRedBadge(FrameFragment frameFragment, int i3, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo);

    void updateTabRedTouch(FrameFragment frameFragment, int i3, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo);

    void updateTabSelectStatusOnTabChange(FrameFragment frameFragment, int i3);

    void updateUIAfterTabChange(FrameFragment frameFragment, String str, String str2, be beVar);
}
