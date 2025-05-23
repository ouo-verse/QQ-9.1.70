package com.tencent.mobileqq.zplan.emoticon.api;

import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.msg.data.g;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0004H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/api/IZPlanEmoticonInfoHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "emoInfo", "", "isZPlanEmoticonType", "", "getZPlanEmoPath", "Lcom/tencent/qqnt/msg/data/g;", "getZPlanPicExtBizInfo", "getZPlanEmoTextSummary", "pageName", "", "setEmoticonNextOpenPage", "getEmoticonNextOpenPage", "isShowing", "setIsShoppingCartShowing", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanEmoticonInfoHelper extends QRouteApi {
    @Nullable
    String getEmoticonNextOpenPage();

    @NotNull
    String getZPlanEmoPath(@Nullable EmoticonInfo emoInfo);

    @Nullable
    String getZPlanEmoTextSummary(@Nullable EmoticonInfo emoInfo);

    @Nullable
    g getZPlanPicExtBizInfo(@NotNull EmoticonInfo emoInfo);

    boolean isZPlanEmoticonType(@Nullable EmoticonInfo emoInfo);

    void setEmoticonNextOpenPage(@Nullable String pageName);

    void setIsShoppingCartShowing(boolean isShowing);
}
