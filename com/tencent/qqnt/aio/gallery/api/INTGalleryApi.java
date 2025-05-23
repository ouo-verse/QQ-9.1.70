package com.tencent.qqnt.aio.gallery.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.richframework.gallery.RFWLayerFragment;
import com.tencent.richframework.preload.activity.BaseActivityResPreloadTask;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\nH&J\u0010\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\nH&J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/api/INTGalleryApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addDataList", "", "list", "", "", "getNTAIOLayerActivityPreloadTask", "Lcom/tencent/richframework/preload/activity/BaseActivityResPreloadTask;", "getNTAIOLayerGroupEmoticonFragment", "Ljava/lang/Class;", "Lcom/tencent/richframework/gallery/RFWLayerFragment;", "getNTGuildAIOLayerFragment", "getPicPath", "", "picElement", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface INTGalleryApi extends QRouteApi {
    void addDataList(@NotNull List<? extends Object> list);

    @NotNull
    BaseActivityResPreloadTask getNTAIOLayerActivityPreloadTask();

    @NotNull
    Class<? extends RFWLayerFragment> getNTAIOLayerGroupEmoticonFragment();

    @NotNull
    Class<? extends RFWLayerFragment> getNTGuildAIOLayerFragment();

    @Nullable
    String getPicPath(@Nullable PicElement picElement);
}
