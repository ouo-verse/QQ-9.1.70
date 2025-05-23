package com.qzone.reborn.repair.part.layer;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.delegate.inner.IGalleryPageProvider;
import com.tencent.richframework.widget.drag.RFWDragLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R(\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/repair/part/layer/m;", "Lcom/qzone/reborn/layer/part/y;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "getExtPicSections", "()Ljava/util/List;", "extPicSections", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class m extends com.qzone.reborn.layer.part.y {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void z9(View rootView) {
        RFWDragLayout dragLayout;
        Intrinsics.checkNotNullParameter(rootView, "$rootView");
        IGalleryPageProvider galleryPageProvider = RFWLayerIOCUtil.getGalleryPageProvider(rootView);
        if (galleryPageProvider == null || (dragLayout = galleryPageProvider.getDragLayout()) == null) {
            return;
        }
        dragLayout.setFeatureEnable(false);
        dragLayout.setEnableDragVertical(false);
        dragLayout.setEnableDragHorizontal(false);
        dragLayout.setOnDragListener((RFWDragLayout.OnDragListener) null);
    }

    @Override // com.qzone.reborn.layer.part.y, com.tencent.biz.richframework.part.Part
    public void onInitView(final View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        rootView.postDelayed(new Runnable() { // from class: com.qzone.reborn.repair.part.layer.l
            @Override // java.lang.Runnable
            public final void run() {
                m.z9(rootView);
            }
        }, 500L);
    }

    @Override // com.qzone.reborn.layer.part.y, com.tencent.richframework.gallery.delegate.outer.IDelegateAndSectionProvider
    public List<Class<? extends Section<RFWLayerItemMediaInfo>>> getExtPicSections() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(sk.b.class, sk.a.class);
        return arrayListOf;
    }
}
