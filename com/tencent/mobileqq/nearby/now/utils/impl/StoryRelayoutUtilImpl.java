package com.tencent.mobileqq.nearby.now.utils.impl;

import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.IStoryRelayoutUtil;
import com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.h;
import com.tencent.mobileqq.nearby.now.view.widget.FitXImageView;
import q92.e;

/* compiled from: P */
/* loaded from: classes33.dex */
public class StoryRelayoutUtilImpl implements IStoryRelayoutUtil {
    @Override // com.tencent.mobileqq.nearby.now.utils.IStoryRelayoutUtil
    public boolean dynamicChangeStoryContainerView(Object obj, float f16, float f17) {
        return e.a((h.b) obj, f16, f17);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IStoryRelayoutUtil
    public boolean dynamicLayoutStoryImageContainerView(Object obj, float f16, float f17, Object obj2, Object obj3) {
        return e.b((h.b) obj, f16, f17, (VideoData) obj2, (IShortVideoCommentsView) obj3);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IStoryRelayoutUtil
    public boolean isSameHeight(View view, Rect rect) {
        return e.c(view, rect);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IStoryRelayoutUtil
    public boolean reLayoutPreBkg(Object obj, int i3, int i16) {
        return e.d((FitXImageView) obj, i3, i16);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IStoryRelayoutUtil
    public boolean updateLayoutForTxtFeeds(Object obj) {
        return e.e((h.b) obj);
    }
}
