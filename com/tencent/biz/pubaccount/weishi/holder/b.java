package com.tencent.biz.pubaccount.weishi.holder;

import UserGrowth.stFeed;
import android.view.ViewGroup;
import com.tencent.widget.pull2refresh.BaseViewHolder;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {
    public static BaseViewHolder<stFeed> a(int i3, ViewGroup viewGroup, com.tencent.biz.pubaccount.weishi.f fVar) {
        if (i3 == 1) {
            return c.c(viewGroup, fVar);
        }
        if (i3 == 2) {
            return WSFollowFeedHolder.J(viewGroup, fVar);
        }
        if (i3 == 4) {
            return a.e(viewGroup, fVar);
        }
        if (i3 == 101) {
            return d.c(viewGroup, fVar);
        }
        if (i3 != 102) {
            return WSFollowFeedHolder.J(viewGroup, fVar);
        }
        return e.c(viewGroup, fVar);
    }
}
