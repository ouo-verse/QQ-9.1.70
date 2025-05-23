package com.tencent.mobileqq.nearbypro.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/api/INearbyProAioUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkFavoriteBtnShow", "", "chatType", "", "handleGrayTipTacitAnswerInvite", "", "peerId", "", "grayTipContent", "", "handleMutualFollow", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INearbyProAioUtil extends QRouteApi {
    boolean checkFavoriteBtnShow(int chatType);

    void handleGrayTipTacitAnswerInvite(long peerId, @NotNull String grayTipContent);

    void handleMutualFollow(long peerId, @NotNull String grayTipContent);
}
