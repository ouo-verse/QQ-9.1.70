package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.widget.pull2refresh.BaseViewHolder;

/* compiled from: P */
/* loaded from: classes32.dex */
public class g {
    public static BaseViewHolder<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> a(ViewGroup viewGroup, int i3, WSVerticalPageFragment wSVerticalPageFragment) {
        if (i3 == 1) {
            return new ao(viewGroup, i3, wSVerticalPageFragment);
        }
        if (i3 == 2) {
            return new an(viewGroup, i3, wSVerticalPageFragment);
        }
        if (i3 == 4) {
            return new am(viewGroup, i3, wSVerticalPageFragment);
        }
        if (i3 == 5) {
            return new as(viewGroup, i3, wSVerticalPageFragment);
        }
        if (i3 != 1002) {
            return new d(viewGroup, i3, wSVerticalPageFragment);
        }
        return new com.tencent.biz.pubaccount.weishi.verticalvideo.vas.d(viewGroup, i3, wSVerticalPageFragment);
    }
}
