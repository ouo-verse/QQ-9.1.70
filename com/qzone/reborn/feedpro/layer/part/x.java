package com.qzone.reborn.feedpro.layer.part;

import android.view.View;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.widget.RFWGalleryViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/qzone/reborn/feedpro/layer/part/x;", "Lcom/qzone/reborn/feedpro/layer/part/c;", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager$OnItemLongClickListener;", "", "I9", "J9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "", "position", "onItemLongClick", "onItemLongClickCancel", "onItemLongClickUp", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "shareIcon", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager;", "viewPagerRoot", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class x extends c implements RFWGalleryViewPager.OnItemLongClickListener {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView shareIcon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RFWGalleryViewPager viewPagerRoot;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(x this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void I9() {
        re.a aVar = (re.a) getViewModel(re.a.class);
        if (aVar == null) {
            return;
        }
        aVar.T1("qzone_commentpicture");
        ge.h hVar = new ge.h();
        hVar.d(new ge.i(this.mCurrentSelectedItem, x9()));
        ke.d dVar = (ke.d) getViewModel(ke.d.class);
        hVar.e(dVar != null ? dVar.getCommonFeed() : null);
        aVar.U1(hVar);
        aVar.O1().setValue(Boolean.TRUE);
    }

    private final void J9() {
        if (x9() != null) {
            RFWGalleryViewPager rFWGalleryViewPager = this.viewPagerRoot;
            if (rFWGalleryViewPager != null) {
                rFWGalleryViewPager.setOnItemLongClickListener(this);
                return;
            }
            return;
        }
        RFWGalleryViewPager rFWGalleryViewPager2 = this.viewPagerRoot;
        if (rFWGalleryViewPager2 != null) {
            rFWGalleryViewPager2.setOnItemLongClickListener(null);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        this.viewPagerRoot = rootView != null ? (RFWGalleryViewPager) rootView.findViewById(R.id.f73943ux) : null;
        ImageView imageView = rootView != null ? (ImageView) rootView.findViewById(R.id.f162840mx1) : null;
        this.shareIcon = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.layer.part.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    x.H9(x.this, view);
                }
            });
        }
    }

    @Override // com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClick(int position) {
        I9();
        tk.h.S(20L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.onLayerStateUpdate(layerState);
        J9();
    }

    @Override // com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClickCancel(int position) {
    }

    @Override // com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClickUp(int position) {
    }
}
