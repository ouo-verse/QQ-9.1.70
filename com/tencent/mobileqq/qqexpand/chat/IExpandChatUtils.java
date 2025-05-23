package com.tencent.mobileqq.qqexpand.chat;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001e\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u001c\u0010\f\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J.\u0010\u000f\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\u001c\u0010\u0016\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0018\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J$\u0010\u0019\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020\rH&J6\u0010\u001b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J\u001c\u0010\u001f\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\tH&\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qqexpand/chat/IExpandChatUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "bNeedShowLimitChatInTitleEntrance", "", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "clearAllMatchChatLocalData", "", "getInstance", "Lcom/tencent/mobileqq/qqexpand/bean/chat/ExpandFriendData;", "matchUin", "", "getLastMatchChatGrayTipsSection", "", "getMatchAlgorithmId", "handlePreLoadDataForIcebreakerTopic", "uinType", "data", "", "isMiniProfileCard", "message", "Lcom/tencent/mobileqq/data/MessageRecord;", "markEnterAio", "needShowLimitChatOnPlus", "reportInSubThread", "setLastMatchChatGrayTipsSection", "section", "showIcebreakerTopic", "matchSrc", "extendObserver", "Lcom/tencent/mobileqq/app/BusinessObserver;", "updateInstance", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IExpandChatUtils extends QRouteApi {
    boolean bNeedShowLimitChatInTitleEntrance(@Nullable BaseQQAppInterface app);

    void clearAllMatchChatLocalData(@Nullable BaseQQAppInterface app);

    @Nullable
    ExpandFriendData getInstance(@Nullable BaseQQAppInterface app, @Nullable String matchUin);

    int getLastMatchChatGrayTipsSection(@Nullable BaseQQAppInterface app, @Nullable String matchUin);

    @Nullable
    String getMatchAlgorithmId(@Nullable BaseQQAppInterface app, @Nullable String matchUin);

    void handlePreLoadDataForIcebreakerTopic(@Nullable BaseQQAppInterface app, @Nullable String matchUin, int uinType, @Nullable Object data);

    boolean isMiniProfileCard(@Nullable MessageRecord message);

    void markEnterAio(@Nullable BaseQQAppInterface app, @Nullable String matchUin);

    boolean needShowLimitChatOnPlus(@Nullable BaseQQAppInterface app);

    void reportInSubThread(@Nullable String matchUin);

    void setLastMatchChatGrayTipsSection(@Nullable BaseQQAppInterface app, @Nullable String matchUin, int section);

    void showIcebreakerTopic(@Nullable BaseQQAppInterface app, @Nullable String matchUin, int uinType, int matchSrc, @Nullable BusinessObserver extendObserver);

    void updateInstance(@Nullable BaseQQAppInterface app, @Nullable ExpandFriendData data);
}
