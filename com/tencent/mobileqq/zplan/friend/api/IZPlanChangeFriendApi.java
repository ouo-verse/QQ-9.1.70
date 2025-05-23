package com.tencent.mobileqq.zplan.friend.api;

import android.app.Activity;
import androidx.annotation.MainThread;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.friend.o;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001JF\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u000b\u001a\u00020\u0004H'J\u001c\u0010\u0011\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/api/IZPlanChangeFriendApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "maxSelectNum", "", "templateID", "", "preselection", "preselectionSex", "requestCode", "", "showChangeRoleFragment", "uin", "Lcom/tencent/mobileqq/zplan/friend/o;", "callback", "getUserAvatar", "requestPlayerSuits", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanChangeFriendApi extends QRouteApi {
    void getUserAvatar(@Nullable String uin, @Nullable o callback);

    void requestPlayerSuits(@NotNull String uin);

    @MainThread
    void showChangeRoleFragment(@NotNull Activity activity, int maxSelectNum, @Nullable String templateID, @NotNull List<String> preselection, @NotNull List<Integer> preselectionSex, int requestCode);
}
