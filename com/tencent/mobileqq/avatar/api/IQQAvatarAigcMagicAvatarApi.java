package com.tencent.mobileqq.avatar.api;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u001c\u0010\u000b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J \u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/avatar/api/IQQAvatarAigcMagicAvatarApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkIsMagicAvatar", "", "jsonObj", "Lorg/json/JSONObject;", "enableAigcMagicAvatar", "handleActionSheetItemClick", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "handleAigcMagicAvatarBannerClick", "updateEntryRedTouch", "view", "Landroid/view/View;", "showRedPoint", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IQQAvatarAigcMagicAvatarApi extends QRouteApi {
    boolean checkIsMagicAvatar(@Nullable JSONObject jsonObj);

    boolean enableAigcMagicAvatar();

    void handleActionSheetItemClick(@Nullable Activity activity);

    boolean handleAigcMagicAvatarBannerClick(@Nullable Activity activity, @Nullable JSONObject jsonObj);

    void updateEntryRedTouch(@NotNull Activity activity, @NotNull View view, boolean showRedPoint);
}
