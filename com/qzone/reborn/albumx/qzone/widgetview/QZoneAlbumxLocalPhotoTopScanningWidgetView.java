package com.qzone.reborn.albumx.qzone.widgetview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010B\u001b\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u000f\u0010\u0013J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0014R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/widgetview/QZoneAlbumxLocalPhotoTopScanningWidgetView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "", "", "getLayoutId", "objData", c.G, "", "bindData", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mLoadingIv", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAlbumxLocalPhotoTopScanningWidgetView extends QZoneBaseWidgetView<Object> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ImageView mLoadingIv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAlbumxLocalPhotoTopScanningWidgetView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.mq8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_\u2026top_scanning_loading_img)");
        ImageView imageView = (ImageView) findViewById;
        this.mLoadingIv = imageView;
        imageView.setImageDrawable(LoadingUtil.getLoadingDrawable(getContext(), 2));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f129145_;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAlbumxLocalPhotoTopScanningWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.mq8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_\u2026top_scanning_loading_img)");
        ImageView imageView = (ImageView) findViewById;
        this.mLoadingIv = imageView;
        imageView.setImageDrawable(LoadingUtil.getLoadingDrawable(getContext(), 2));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object objData, int pos) {
    }
}
