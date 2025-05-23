package com.tencent.richframework.gallery.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/richframework/gallery/api/IRichMediaDepend;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "saveToAlbum", "", "context", "Landroid/content/Context;", "itemInfo", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "qq-layer-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IRichMediaDepend extends QRouteApi {
    void saveToAlbum(@NotNull Context context, @NotNull RFWLayerItemMediaInfo itemInfo);
}
