package com.tencent.qqnt.markdown.api.impl;

import android.content.Context;
import com.tencent.mobileqq.markdown.multipic.MultiPicLayerFragment;
import com.tencent.qqnt.markdown.api.IMultiPicApi;
import com.tencent.richframework.gallery.QQGalleryActivity;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0002J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\f\u001a\u00020\rH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/markdown/api/impl/MultiPicApiImpl;", "Lcom/tencent/qqnt/markdown/api/IMultiPicApi;", "()V", "generateMediaInfoList", "", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "urlList", "", "openPreview", "", "context", "Landroid/content/Context;", "currentIndex", "", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class MultiPicApiImpl implements IMultiPicApi {
    private final List<RFWLayerItemMediaInfo> generateMediaInfoList(List<String> urlList) {
        ArrayList arrayList = new ArrayList();
        for (String str : urlList) {
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo.setUrl(str);
            rFWPicInfo.setLocalPath(null);
            RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
            rFWLayerPicInfo.setPicId(rFWPicInfo.getUrl());
            rFWLayerPicInfo.setOriginPicInfo(rFWPicInfo);
            rFWLayerPicInfo.setCurrentPicInfo(rFWPicInfo);
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
            rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
            arrayList.add(rFWLayerItemMediaInfo);
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.markdown.api.IMultiPicApi
    public void openPreview(Context context, List<String> urlList, int currentIndex) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(urlList, "urlList");
        RFWLayerLaunchUtil.jumpToGallery$default(context, null, generateMediaInfoList(urlList), currentIndex, QQGalleryActivity.class, MultiPicLayerFragment.class, null, 0, 128, null);
    }
}
