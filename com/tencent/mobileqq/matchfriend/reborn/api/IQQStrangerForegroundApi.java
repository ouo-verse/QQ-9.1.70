package com.tencent.mobileqq.matchfriend.reborn.api;

import android.graphics.Point;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.QQStrangerInteractiveMarkModel;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u001c\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/api/IQQStrangerForegroundApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;", "model", "showGainMutualMarkAnimatorView", "Landroid/graphics/Point;", "getAIOTitleMutualMarkLocation", "", "loadingDrawablePath", "updateAIOTitleMutualMark", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IQQStrangerForegroundApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class a {
        public static /* synthetic */ void a(IQQStrangerForegroundApi iQQStrangerForegroundApi, QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    str = null;
                }
                iQQStrangerForegroundApi.updateAIOTitleMutualMark(qQStrangerInteractiveMarkModel, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateAIOTitleMutualMark");
        }
    }

    @Nullable
    Point getAIOTitleMutualMarkLocation();

    void onCreate(@NotNull com.tencent.aio.api.runtime.a aioContext);

    void onDestroy();

    void showGainMutualMarkAnimatorView(@NotNull QQStrangerInteractiveMarkModel model);

    void updateAIOTitleMutualMark(@NotNull QQStrangerInteractiveMarkModel model, @Nullable String loadingDrawablePath);
}
