package com.tencent.mobileqq.wink.api.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.ams.dsdk.monitor.metric.event.TagValue;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.wink.api.IWinkMosaicLayoutApi;
import com.tencent.mobileqq.wink.editor.mosaic.MosaicLayout;
import com.tencent.mobileqq.wink.mosaic.model.MosaicLinePath;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0006H\u0016JJ\u0010\u0015\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/api/impl/WinkMosaicLayoutApiImpl;", "Lcom/tencent/mobileqq/wink/api/IWinkMosaicLayoutApi;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "Landroid/widget/RelativeLayout;", "getMosaicLayout", TagValue.MOSAIC, "Landroid/graphics/Bitmap;", "getMosaicBitmap", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/RectF;", "rectF", "", "degree", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mobileqq/wink/mosaic/model/MosaicLinePath;", "unDoPaintPath", "reDoPaintPath", "", "setData", "Lq83/a;", "mosaicPaintUpdateCallback", "setMosaicPaintUpdateCallback", "", "undo", "redo", "<init>", "()V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMosaicLayoutApiImpl implements IWinkMosaicLayoutApi {

    @NotNull
    private static final String TAG = "WinkMosaicLayoutApiImpl";

    @Override // com.tencent.mobileqq.wink.api.IWinkMosaicLayoutApi
    @Nullable
    public Bitmap getMosaicBitmap(@NotNull RelativeLayout mosaic) {
        Intrinsics.checkNotNullParameter(mosaic, "mosaic");
        if (mosaic instanceof MosaicLayout) {
            return ((MosaicLayout) mosaic).f();
        }
        w53.b.g(TAG, "saveMosaicBitmap... layout is not MosaicLayout!!!");
        return null;
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkMosaicLayoutApi
    @NotNull
    public RelativeLayout getMosaicLayout(@NotNull Context context, @Nullable AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new MosaicLayout(context, attrs);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkMosaicLayoutApi
    public boolean redo(@NotNull RelativeLayout mosaic) {
        Intrinsics.checkNotNullParameter(mosaic, "mosaic");
        if (mosaic instanceof MosaicLayout) {
            return ((MosaicLayout) mosaic).j();
        }
        w53.b.g(TAG, "redo... layout is not MosaicLayout!!!");
        return false;
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkMosaicLayoutApi
    public void setData(@NotNull RelativeLayout mosaic, @NotNull Bitmap bitmap, @Nullable RectF rectF, float degree, @Nullable CopyOnWriteArrayList<MosaicLinePath> unDoPaintPath, @Nullable CopyOnWriteArrayList<MosaicLinePath> reDoPaintPath) {
        Intrinsics.checkNotNullParameter(mosaic, "mosaic");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (mosaic instanceof MosaicLayout) {
            ((MosaicLayout) mosaic).setData(bitmap, rectF, degree, unDoPaintPath, reDoPaintPath);
        } else {
            w53.b.g(TAG, "setData... layout is not MosaicLayout!!!");
        }
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkMosaicLayoutApi
    public void setMosaicPaintUpdateCallback(@NotNull RelativeLayout mosaic, @NotNull q83.a mosaicPaintUpdateCallback) {
        Intrinsics.checkNotNullParameter(mosaic, "mosaic");
        Intrinsics.checkNotNullParameter(mosaicPaintUpdateCallback, "mosaicPaintUpdateCallback");
        if (mosaic instanceof MosaicLayout) {
            ((MosaicLayout) mosaic).setMosaicPaintUpdateCallback(mosaicPaintUpdateCallback);
        } else {
            w53.b.g(TAG, "setMosaicPaintUpdateCallback... layout is not MosaicLayout!!!");
        }
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkMosaicLayoutApi
    public boolean undo(@NotNull RelativeLayout mosaic) {
        Intrinsics.checkNotNullParameter(mosaic, "mosaic");
        if (mosaic instanceof MosaicLayout) {
            return ((MosaicLayout) mosaic).m();
        }
        w53.b.g(TAG, "undo... layout is not MosaicLayout!!!");
        return false;
    }
}
