package com.tencent.mobileqq.troop.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\u0011J\b\u0010\u0003\u001a\u00020\u0002H&J,\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/api/ITroopShareWxMiniProgramApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "enableShareAsMiniProgram", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/graphics/Bitmap;", "bmp", "", "troopName", "troopMemo", "getTroopPreviewBitmap", "troopUin", "Lcom/tencent/mobileqq/troop/api/ITroopShareWxMiniProgramApi$a;", "callback", "", "getTokenAndJoinGroupAuth", "a", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopShareWxMiniProgramApi extends QRouteApi {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/api/ITroopShareWxMiniProgramApi$a;", "", "", "isSuccess", "", "groupCode", "", "token", "joinGroupAuth", "", "a", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public interface a {
        void a(boolean isSuccess, long groupCode, @Nullable String token, @Nullable String joinGroupAuth);
    }

    boolean enableShareAsMiniProgram();

    void getTokenAndJoinGroupAuth(@NotNull String troopUin, @NotNull a callback);

    @Nullable
    Bitmap getTroopPreviewBitmap(@Nullable QBaseActivity activity, @NotNull Bitmap bmp, @NotNull String troopName, @NotNull String troopMemo);
}
