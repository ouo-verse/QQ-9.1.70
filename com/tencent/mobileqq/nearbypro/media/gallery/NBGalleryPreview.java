package com.tencent.mobileqq.nearbypro.media.gallery;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.qqui.widget.RoundBubbleImageView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.richframework.gallery.QQGalleryActivity;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0014\u0010\r\u001a\u00020\f*\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J.\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000e2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015J4\u0010\u0019\u001a\u00020\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/media/gallery/NBGalleryPreview;", "", "Landroid/view/View;", "view", "Landroid/widget/ImageView;", "d", "", "Lcom/tencent/mobileqq/nearbypro/media/gallery/a;", "richMediaInfo", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "f", QAdVrReportParams.ParamKey.MEDIA, "", "e", "", "filePath", "", "g", "path", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "a", "richMediaList", "b", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NBGalleryPreview {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NBGalleryPreview f253611a = new NBGalleryPreview();

    NBGalleryPreview() {
    }

    public static /* synthetic */ void c(NBGalleryPreview nBGalleryPreview, List list, View view, Context context, Bundle bundle, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            view = null;
        }
        if ((i3 & 8) != 0) {
            bundle = null;
        }
        nBGalleryPreview.b(list, view, context, bundle);
    }

    private final ImageView d(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                Intrinsics.checkNotNullExpressionValue(childAt, "view.getChildAt(i)");
                ImageView d16 = d(childAt);
                if (d16 != null) {
                    return d16;
                }
            }
            return null;
        }
        if (view instanceof RoundBubbleImageView) {
            return (ImageView) view;
        }
        return null;
    }

    private final void e(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, NBGalleryImageData nBGalleryImageData) {
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        rFWLayerPicInfo.setPicId(nBGalleryImageData.getId());
        NBGalleryPreview nBGalleryPreview = f253611a;
        if (nBGalleryPreview.g(nBGalleryImageData.getSmallImage().getPicUrl())) {
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo.setUrl(nBGalleryImageData.getSmallImage().getPicUrl());
            rFWPicInfo.setHeight(nBGalleryImageData.getSmallImage().getHeight());
            rFWPicInfo.setWidth(nBGalleryImageData.getSmallImage().getWidth());
            rFWPicInfo.setLocalPath(nBGalleryImageData.getSmallImage().getPicUrl());
            rFWLayerPicInfo.setSmallPicInfo(rFWPicInfo);
            RFWLayerPicInfo.RFWPicInfo smallPicInfo = rFWLayerPicInfo.getSmallPicInfo();
            Intrinsics.checkNotNull(smallPicInfo, "null cannot be cast to non-null type com.tencent.richframework.gallery.bean.RFWLayerPicInfo.RFWPicInfo");
            rFWLayerPicInfo.setCurrentPicInfo(smallPicInfo);
        }
        if (nBGalleryPreview.g(nBGalleryImageData.getLargeImage().getPicUrl())) {
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo2 = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo2.setUrl(nBGalleryImageData.getLargeImage().getPicUrl());
            rFWPicInfo2.setHeight(nBGalleryImageData.getLargeImage().getHeight());
            rFWPicInfo2.setWidth(nBGalleryImageData.getLargeImage().getWidth());
            rFWPicInfo2.setLocalPath(nBGalleryImageData.getLargeImage().getPicUrl());
            rFWLayerPicInfo.setBigPicInfo(rFWPicInfo2);
            RFWLayerPicInfo.RFWPicInfo bigPicInfo = rFWLayerPicInfo.getBigPicInfo();
            Intrinsics.checkNotNull(bigPicInfo, "null cannot be cast to non-null type com.tencent.richframework.gallery.bean.RFWLayerPicInfo.RFWPicInfo");
            rFWLayerPicInfo.setCurrentPicInfo(bigPicInfo);
        }
        rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
    }

    private final List<RFWLayerItemMediaInfo> f(List<NBGalleryImageData> richMediaInfo) {
        int collectionSizeOrDefault;
        List<NBGalleryImageData> list = richMediaInfo;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (NBGalleryImageData nBGalleryImageData : list) {
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
            rFWLayerItemMediaInfo.setMediaId(nBGalleryImageData.getId());
            f253611a.e(rFWLayerItemMediaInfo, nBGalleryImageData);
            arrayList.add(rFWLayerItemMediaInfo);
        }
        return arrayList;
    }

    private final boolean g(String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return false;
        }
        return true;
    }

    public final void a(@NotNull String path, @Nullable View view, @NotNull Context context, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(context, "context");
        BuildersKt__Builders_commonKt.launch$default(fa2.a.a(), null, null, new NBGalleryPreview$enterToGallery$1(path, context, bundle, null), 3, null);
    }

    public final void b(@NotNull List<NBGalleryImageData> richMediaList, @Nullable View view, @NotNull Context context, @Nullable Bundle bundle) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(richMediaList, "richMediaList");
        Intrinsics.checkNotNullParameter(context, "context");
        if (richMediaList.isEmpty()) {
            return;
        }
        if (view instanceof ImageView) {
            imageView = (ImageView) view;
        } else if (view instanceof ViewGroup) {
            imageView = d(view);
        } else {
            imageView = null;
        }
        RFWLayerLaunchUtil.jumpToGallery$default(context, imageView, f(richMediaList), 0, QQGalleryActivity.class, NBGalleryLayerFragment.class, bundle, 0, 128, null);
    }
}
