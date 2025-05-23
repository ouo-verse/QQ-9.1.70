package com.qzone.reborn.layer.part;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.libra.request.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.QQLayerUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.part.QQMediaStrategyPart;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/layer/part/cq;", "Lcom/tencent/richframework/gallery/part/QQMediaStrategyPart;", "", "x9", "Landroid/content/Context;", "context", "z9", "isSupportMagnifyLongPic", "Lcom/tencent/libra/request/Option;", "option", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "itemInfo", "isSupportRegionScale", "useBitmapConfig8888", "enableAutoMagnifyExternalSmallPic", "<init>", "()V", "d", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class cq extends QQMediaStrategyPart {
    private final boolean x9() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_IS_AUTO_ZOOM_LONG_PIC, 1) == 1;
    }

    @Override // com.tencent.richframework.gallery.part.QQMediaStrategyPart, com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
    public boolean enableAutoMagnifyExternalSmallPic() {
        return com.qzone.reborn.configx.g.f53821a.b().v();
    }

    @Override // com.tencent.richframework.gallery.part.QQMediaStrategyPart, com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
    /* renamed from: isSupportMagnifyLongPic */
    public boolean getIsSupportMagnifyLongPic() {
        return x9() && !z9(getContext());
    }

    @Override // com.tencent.richframework.gallery.part.QQMediaStrategyPart, com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
    public boolean isSupportRegionScale(Option option, RFWLayerItemMediaInfo itemInfo) {
        Intrinsics.checkNotNullParameter(option, "option");
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        Pair<Integer, Integer> currentPicWidthAndHeight = QQLayerUtil.INSTANCE.getCurrentPicWidthAndHeight(option, itemInfo);
        int intValue = currentPicWidthAndHeight.getFirst().intValue();
        int intValue2 = currentPicWidthAndHeight.getSecond().intValue();
        QLog.i("QZoneMediaStrategyPart", 2, "width is " + intValue + ", height is " + intValue2);
        return tk.h.m(intValue, intValue2);
    }

    @Override // com.tencent.richframework.gallery.part.QQMediaStrategyPart, com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
    /* renamed from: useBitmapConfig8888 */
    public boolean getUseRGB8888() {
        return com.qzone.reborn.configx.g.f53821a.b().u0();
    }

    private final boolean z9(Context context) {
        Resources resources;
        Configuration configuration = (context == null || (resources = context.getResources()) == null) ? null : resources.getConfiguration();
        return configuration != null && configuration.orientation == 2;
    }
}
