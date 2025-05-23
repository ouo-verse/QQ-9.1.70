package com.tencent.mobileqq.search.fragment.searchentry.hippy;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.image.HippyTKDGifImageView;
import com.tencent.hippy.qq.view.tkd.image.HippyTKDGifImageViewController;
import com.tencent.hippy.qq.view.tkd.image.HippyTKDImageView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListView;
import com.tencent.hippy.qq.view.tkd.text.HippyTKDTextView;
import com.tencent.hippy.qq.view.tkd.view.HippyTKDViewGroup;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SearchHippyViewCreator implements HippyCustomViewCreator {
    @Override // com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator
    public View createCustomView(String str, Context context, HippyMap hippyMap) {
        if (TextUtils.equals("ListView", str)) {
            return new HippyTKDListView(context);
        }
        if (TextUtils.equals("Text", str)) {
            return new HippyTKDTextView(context);
        }
        if (TextUtils.equals("View", str)) {
            return new HippyTKDViewGroup(context);
        }
        if (TextUtils.equals("Image", str)) {
            return new HippyTKDImageView(context);
        }
        if (TextUtils.equals(HippyTKDGifImageViewController.CLASS_NAME, str)) {
            return new HippyTKDGifImageView(context);
        }
        return null;
    }
}
