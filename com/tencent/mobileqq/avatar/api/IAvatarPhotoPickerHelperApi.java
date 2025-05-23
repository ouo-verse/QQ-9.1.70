package com.tencent.mobileqq.avatar.api;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/avatar/api/IAvatarPhotoPickerHelperApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "needInsertVasShoppingPageInfo", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "startPhotoPicker", "", "bundle", "Landroid/os/Bundle;", "useNewPhotoPicker", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IAvatarPhotoPickerHelperApi extends QRouteApi {
    boolean needInsertVasShoppingPageInfo(@Nullable Activity activity);

    void startPhotoPicker(@NotNull Activity activity, @NotNull Bundle bundle);

    boolean useNewPhotoPicker();
}
