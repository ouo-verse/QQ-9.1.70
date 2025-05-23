package com.tencent.mobileqq.guild.feed.util;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes13.dex */
public class u {
    public static void a(rr1.a aVar) {
        ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).addGestureListener(aVar);
    }

    public static void b(FragmentActivity fragmentActivity, int i3) {
        Fragment findFragmentByTag = fragmentActivity.getSupportFragmentManager().findFragmentByTag("com.tencent.mobileqq.activity.home.MainFragment");
        if (findFragmentByTag == null) {
            return;
        }
        ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).guildCenterPanelInOrOut((FrameFragment) findFragmentByTag, i3, true);
    }

    public static void c(rr1.a aVar) {
        ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).removeGestureListener(aVar);
    }
}
