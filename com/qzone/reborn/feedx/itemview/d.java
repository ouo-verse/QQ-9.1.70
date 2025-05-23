package com.qzone.reborn.feedx.itemview;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import jo.h;

/* compiled from: P */
/* loaded from: classes37.dex */
public class d {
    public static int a(BusinessFeedData businessFeedData, int i3) {
        return b.e().g(businessFeedData, i3);
    }

    public static int b(BusinessFeedData businessFeedData) {
        if (!businessFeedData.isVideo() || businessFeedData.getVideoInfo() == null) {
            return businessFeedData.getPictureInfo() != null ? 2 : 0;
        }
        return 1;
    }

    public static boolean d(BusinessFeedData businessFeedData) {
        if (c(businessFeedData)) {
            return true;
        }
        return (businessFeedData == null || !businessFeedData.isForwardFeed() || businessFeedData.getOriginalInfo() == null || TextUtils.isEmpty(businessFeedData.getOriginalInfo().getIdInfo().cellId)) ? false : true;
    }

    public static View f(ViewGroup viewGroup, int i3) {
        QZoneBaseFeedItemView f16 = b.e().f(i3, viewGroup.getContext());
        f16.setParentView(viewGroup);
        f16.setViewType(i3);
        try {
            h hVar = h.f410717a;
            hVar.g("item_view_init").f(f16);
            f16.initView();
            hVar.g("item_view_init").a(f16);
            return f16;
        } catch (Throwable th5) {
            if (lm.a.f414989a.p(f16)) {
                xe.b.f447841a.d(th5);
                return new QZoneEmptyItemView(viewGroup.getContext());
            }
            throw th5;
        }
    }

    public static boolean c(BusinessFeedData businessFeedData) {
        return businessFeedData != null && businessFeedData.getFeedCommInfo() != null && businessFeedData.getFeedCommInfo().appid == 7035 && businessFeedData.cellVideoInfo == null && businessFeedData.cellPictureInfo == null && businessFeedData.getOriginalInfo() != null;
    }

    public static boolean e(BusinessFeedData businessFeedData) {
        return (businessFeedData == null || !businessFeedData.isForwardFeed() || businessFeedData.getOriginalInfo() == null) ? false : true;
    }
}
