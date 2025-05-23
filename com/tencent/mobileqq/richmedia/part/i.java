package com.tencent.mobileqq.richmedia.part;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.delegate.outer.IMediaProvider;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/richmedia/part/i;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "v", NodeProps.ON_CLICK, "Landroid/widget/ImageButton;", "d", "Landroid/widget/ImageButton;", "mSaveBtn", "<init>", "()V", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class i extends RFWLayerBasePart implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageButton mSaveBtn;

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo;
        com.tencent.mobileqq.richmedia.depend.a aVar;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.zvg && (rFWLayerItemMediaInfo = this.mCurrentSelectedItem) != null) {
            View decorView = getActivity().getWindow().getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
            IMediaProvider mediaProvider = RFWLayerIOCUtil.getMediaProvider(decorView);
            if (mediaProvider != null) {
                mediaProvider.saveToAlbum(rFWLayerItemMediaInfo);
            }
            View findViewById = getPartRootView().findViewById(R.id.zve);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026nt_gallery_scene_raw_btn)");
            ((TextView) findViewById).setVisibility(8);
            if (!TextUtils.isEmpty(rFWLayerItemMediaInfo.getMediaId())) {
                com.tencent.mobileqq.richmedia.e eVar = com.tencent.mobileqq.richmedia.e.f281568a;
                String name = com.tencent.mobileqq.richmedia.depend.a.class.getName();
                Intrinsics.checkNotNullExpressionValue(name, "ICommonLayerOperationReport::class.java.name");
                com.tencent.mobileqq.richmedia.depend.c d16 = eVar.d(name);
                if (d16 instanceof com.tencent.mobileqq.richmedia.depend.a) {
                    aVar = (com.tencent.mobileqq.richmedia.depend.a) d16;
                } else {
                    aVar = null;
                }
                if (aVar != null) {
                    String mediaId = rFWLayerItemMediaInfo.getMediaId();
                    Intrinsics.checkNotNull(mediaId);
                    aVar.b6(mediaId);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.mSaveBtn = (ImageButton) rootView.findViewById(R.id.zvg);
        if (!getActivity().getIntent().getBooleanExtra("hide_save_button", false)) {
            ImageButton imageButton = this.mSaveBtn;
            if (imageButton != null) {
                imageButton.setVisibility(0);
            }
            ImageButton imageButton2 = this.mSaveBtn;
            if (imageButton2 != null) {
                imageButton2.setOnClickListener(this);
            }
        }
    }
}
