package com.tencent.mobileqq.wink.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.ams.dsdk.monitor.metric.event.TagValue;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.wink.mosaic.model.MosaicLinePath;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0006H&JJ\u0010\u0015\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H&J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H&J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u0006H&J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u0006H&\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/wink/api/IWinkMosaicLayoutApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "Landroid/widget/RelativeLayout;", "getMosaicLayout", TagValue.MOSAIC, "Landroid/graphics/Bitmap;", "getMosaicBitmap", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/RectF;", "rectF", "", "degree", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mobileqq/wink/mosaic/model/MosaicLinePath;", "unDoPaintPath", "reDoPaintPath", "", "setData", "Lq83/a;", "mosaicPaintUpdateCallback", "setMosaicPaintUpdateCallback", "", "undo", "redo", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IWinkMosaicLayoutApi extends QRouteApi {
    @Nullable
    Bitmap getMosaicBitmap(@NotNull RelativeLayout mosaic);

    @NotNull
    RelativeLayout getMosaicLayout(@NotNull Context context, @Nullable AttributeSet attrs);

    boolean redo(@NotNull RelativeLayout mosaic);

    void setData(@NotNull RelativeLayout mosaic, @NotNull Bitmap bitmap, @Nullable RectF rectF, float degree, @Nullable CopyOnWriteArrayList<MosaicLinePath> unDoPaintPath, @Nullable CopyOnWriteArrayList<MosaicLinePath> reDoPaintPath);

    void setMosaicPaintUpdateCallback(@NotNull RelativeLayout mosaic, @NotNull q83.a mosaicPaintUpdateCallback);

    boolean undo(@NotNull RelativeLayout mosaic);
}
