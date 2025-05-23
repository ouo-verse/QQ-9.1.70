package com.tencent.mobileqq.matchfriend.utils;

import android.graphics.Rect;
import com.tencent.mobileqq.matchfriend.widget.MatchFriendSmallScreen;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.relation.common.api.IRelationFloatWindow;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a {
    public static com.tencent.relation.common.window.a a(boolean z16) {
        com.tencent.mobileqq.matchfriend.widget.a aVar = (com.tencent.mobileqq.matchfriend.widget.a) com.tencent.relation.common.window.b.d().c(com.tencent.mobileqq.matchfriend.widget.a.CLASS_NAME);
        com.tencent.relation.common.window.a aVar2 = new com.tencent.relation.common.window.a();
        aVar2.f364881c = ViewUtils.dip2px(z16 ? 32.0f : 1000.0f);
        aVar2.f364882d = ViewUtils.dip2px(z16 ? 1000.0f : 32.0f);
        if (aVar != null) {
            Rect o06 = aVar.o0();
            aVar2.f364879a = (o06.left + o06.right) / 2;
            aVar2.f364880b = (o06.top + o06.bottom) / 2;
        }
        if (!z16 && Math.abs((ViewUtils.getScreenWidth() / 2) - aVar2.f364879a) < 100) {
            aVar2.f364879a = ViewUtils.dip2px(330.0f);
            aVar2.f364880b = ViewUtils.dip2px(662.0f);
        }
        return aVar2;
    }

    public static void b() {
        ((IRelationFloatWindow) QRoute.api(IRelationFloatWindow.class)).hideRelationFloatWindow(com.tencent.mobileqq.matchfriend.widget.a.CLASS_NAME);
    }

    public static boolean c(boolean z16) {
        MatchFriendSmallScreen matchFriendSmallScreen = new MatchFriendSmallScreen(MobileQQ.sMobileQQ.getApplicationContext());
        matchFriendSmallScreen.setShowImmediately(z16);
        return ((IRelationFloatWindow) QRoute.api(IRelationFloatWindow.class)).showRelationFloatWindow(matchFriendSmallScreen, com.tencent.mobileqq.matchfriend.widget.a.CLASS_NAME, 64.0f, 64.0f);
    }
}
