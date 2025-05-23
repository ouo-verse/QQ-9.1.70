package com.tencent.biz.pubaccount.weishi.recommend.holder;

import UserGrowth.stSimpleMetaFeed;
import android.view.ViewGroup;
import com.tencent.widget.pull2refresh.BaseViewHolder;

/* compiled from: P */
/* loaded from: classes32.dex */
public class n {
    public static BaseViewHolder<stSimpleMetaFeed> a(int i3, ViewGroup viewGroup, com.tencent.biz.pubaccount.weishi.t tVar) {
        if (i3 == 1) {
            return new ac(viewGroup, i3, tVar);
        }
        if (i3 != 3) {
            switch (i3) {
                case 6:
                    return new q(viewGroup, i3, tVar);
                case 7:
                    return new u(viewGroup, i3, tVar);
                case 8:
                    return new w(viewGroup, i3, tVar);
                case 9:
                    return new y(viewGroup, i3, tVar);
                case 10:
                    return new o(viewGroup, i3, tVar);
                case 11:
                    return new i(viewGroup, i3, tVar);
                case 12:
                    return new l(viewGroup, i3, tVar);
                case 13:
                    return new aa(viewGroup, i3, tVar);
                case 14:
                    return new d(viewGroup, i3, tVar);
                default:
                    return new ac(viewGroup, i3, tVar);
            }
        }
        return new s(viewGroup, i3, tVar);
    }
}
