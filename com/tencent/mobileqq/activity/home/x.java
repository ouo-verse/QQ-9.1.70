package com.tencent.mobileqq.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.widget.bn;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public interface x {
    void a(FrameFragment frameFragment, Intent intent, Bundle bundle, int i3);

    void b(QUIBadge qUIBadge, int i3, String str, int i16, int i17);

    void c(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, ArrayList<w> arrayList);

    void d(FrameFragment frameFragment, Intent intent);

    void e(FrameFragment frameFragment, int i3);

    com.tencent.mobileqq.activity.home.impl.d f(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, boolean z16, int i3);

    void g(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, View view);

    boolean h();

    boolean i(FrameFragment frameFragment);

    bn j(TabFrameControllerImpl tabFrameControllerImpl, LayoutInflater layoutInflater);

    int k(FrameFragment frameFragment);

    void l(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, int i3);

    int m(int i3);

    void n(FrameFragment frameFragment);

    boolean o(FrameFragment frameFragment);

    void p(boolean z16);
}
