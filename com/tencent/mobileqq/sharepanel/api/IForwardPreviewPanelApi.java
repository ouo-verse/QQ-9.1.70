package com.tencent.mobileqq.sharepanel.api;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.sharepanel.forward.f;
import com.tencent.mobileqq.sharepanel.forward.g;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u000b\u001a\u00020\nH&J0\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u000b\u001a\u00020\nH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/api/IForwardPreviewPanelApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "enable", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "Lkotlin/collections/ArrayList;", "targetList", "Lcom/tencent/mobileqq/sharepanel/forward/f;", "uiControl", "Lcom/tencent/mobileqq/sharepanel/forward/g;", OperateCustomButton.OPERATE_CREATE, "createV2", "qq-sharepanel-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IForwardPreviewPanelApi extends QRouteApi {
    @NotNull
    g create(@NotNull FragmentActivity activity, @NotNull ArrayList<SharePanelContactItem> targetList, @NotNull f uiControl);

    @NotNull
    g createV2(@NotNull FragmentActivity activity, @NotNull ArrayList<SharePanelContactItem> targetList, @NotNull f uiControl);

    boolean enable();
}
