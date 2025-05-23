package com.qzone.reborn.layer.part;

import android.graphics.drawable.Drawable;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import com.tencent.richframework.gallery.delegate.outer.ErrorUIConfig;
import com.tencent.richframework.gallery.delegate.outer.InnerErrorInfo;
import com.tencent.richframework.gallery.part.QQMediaStrategyPart;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/qzone/reborn/layer/part/co;", "Lcom/tencent/richframework/gallery/part/QQMediaStrategyPart;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "itemInfo", "Lcom/tencent/richframework/gallery/delegate/outer/InnerErrorInfo;", "innerErrorInfo", "Lcom/tencent/richframework/gallery/delegate/outer/ErrorUIConfig;", "needShowErrorUI", "<init>", "()V", "d", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class co extends QQMediaStrategyPart {
    @Override // com.tencent.richframework.gallery.part.QQMediaStrategyPart, com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
    public ErrorUIConfig needShowErrorUI(RFWLayerItemMediaInfo itemInfo, InnerErrorInfo innerErrorInfo) {
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        if (itemInfo.isVideo() && innerErrorInfo != null && innerErrorInfo.getErrorCode() == 11022003) {
            int i3 = RFWLog.USR;
            RFWLayerVideoInfo layerVideoInfo = itemInfo.getLayerVideoInfo();
            RFWLog.i("QZoneLocalMediaStrategyPart", i3, "[needShowErrorUI] error video path: " + (layerVideoInfo != null ? layerVideoInfo.getCurrentVideoUrl() : null));
            Drawable errorDrawable = getErrorDrawable(R.drawable.qui_caution_circle_icon_secondary);
            String string = getActivity().getResources().getString(R.string.f238297jd);
            Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026R.string.video_rendering)");
            return new ErrorUIConfig(errorDrawable, string);
        }
        return super.needShowErrorUI(itemInfo, innerErrorInfo);
    }
}
