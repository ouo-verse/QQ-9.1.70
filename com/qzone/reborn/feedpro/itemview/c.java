package com.qzone.reborn.feedpro.itemview;

import android.view.View;
import android.view.ViewGroup;
import com.qzone.reborn.feedx.itemview.QZoneEmptyItemView;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import jo.h;

/* compiled from: P */
/* loaded from: classes37.dex */
public class c {
    public static int a(CommonFeed commonFeed, int i3) {
        return b.f().h(commonFeed, i3);
    }

    public static View b(ViewGroup viewGroup, int i3) {
        QzoneBaseFeedProItemView g16 = b.f().g(i3, viewGroup.getContext());
        g16.setParentView(viewGroup);
        g16.setViewType(i3);
        try {
            h hVar = h.f410717a;
            hVar.g("item_view_init").f(g16);
            g16.initView();
            hVar.g("item_view_init").a(g16);
            return g16;
        } catch (Throwable th5) {
            if (lm.a.f414989a.p(g16)) {
                xe.b.f447841a.d(th5);
                return new QZoneEmptyItemView(viewGroup.getContext());
            }
            throw th5;
        }
    }
}
