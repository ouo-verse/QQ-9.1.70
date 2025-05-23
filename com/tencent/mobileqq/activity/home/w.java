package com.tencent.mobileqq.activity.home;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public interface w {
    void A();

    void a(FrameFragment frameFragment);

    void b(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, com.tencent.mobileqq.activity.home.impl.d dVar);

    void c(FrameFragment frameFragment);

    void d(FrameFragment frameFragment);

    void e(Context context, HashMap<String, View> hashMap);

    void f(TianshuRedTouch tianshuRedTouch, FrameFragment frameFragment, int i3, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, IRedTouchManager iRedTouchManager);

    String getKey();

    boolean h(com.tencent.mobileqq.activity.home.impl.d dVar, FrameFragment frameFragment);

    void i(RedTouch redTouch, FrameFragment frameFragment, int i3, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, IRedTouchManager iRedTouchManager);

    void j(FrameFragment frameFragment);

    void k(HashMap<String, View> hashMap, boolean z16);

    void l(FrameFragment frameFragment);

    void m(FrameFragment frameFragment);

    void n(AppRuntime appRuntime, SparseArray<TabDragAnimationView> sparseArray, int i3);

    boolean o(FrameFragment frameFragment);

    void onFragmentDrawerClosed(FrameFragment frameFragment, int i3, int i16);

    void onFragmentDrawerInit(boolean z16);

    void p(FrameFragment frameFragment);

    void q(FrameFragment frameFragment);

    void r(com.tencent.mobileqq.activity.home.impl.d dVar);

    void s(FrameFragment frameFragment, int i3, String str);

    void setIntent(Intent intent, FrameFragment frameFragment);

    boolean t(AppRuntime appRuntime);

    void u();

    void v(FrameFragment frameFragment, String str);

    void w(FrameFragment frameFragment, String str);

    void x(FrameFragment frameFragment, FrameFragment.DragViewTouchListener dragViewTouchListener);

    void y(FrameFragment frameFragment, int i3, be beVar, int i16);

    void z(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, com.tencent.mobileqq.activity.home.impl.d dVar);
}
