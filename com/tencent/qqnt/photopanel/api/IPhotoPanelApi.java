package com.tencent.qqnt.photopanel.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.aio.api.runtime.a;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H&J \u0010\u0015\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/photopanel/api/IPhotoPanelApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "selectMedias", "", "isHighQuality", "", "onEditBtnClicked", "Landroid/content/Intent;", "intent", "fillIntentForJumpAlbum", "fillIntentForJumpPreview", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "comment", "Lcom/tencent/qqnt/qbasealbum/preview/fragment/a;", "listener", "onUp", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IPhotoPanelApi extends QRouteApi {
    void fillIntentForJumpAlbum(@NotNull Intent intent, @NotNull a aioContext);

    void fillIntentForJumpPreview(@NotNull Intent intent, @NotNull a aioContext);

    void onEditBtnClicked(@NotNull a aioContext, @NotNull List<LocalMediaInfo> selectMedias, boolean isHighQuality);

    void onUp(@NotNull Activity activity, @NotNull String comment, @NotNull com.tencent.qqnt.qbasealbum.preview.fragment.a listener);
}
