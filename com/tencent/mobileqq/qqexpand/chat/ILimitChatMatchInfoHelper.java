package com.tencent.mobileqq.qqexpand.chat;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import expand.common.MatchedInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/chat/ILimitChatMatchInfoHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "", "uin", "Lcom/tencent/mobileqq/qqexpand/network/d;", "callback", "", "getMatchInfoRequest", "Lexpand/common/MatchedInfo;", "matchedInfo", "", "getIceBreakAioType", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface ILimitChatMatchInfoHelper extends QRouteApi {
    int getIceBreakAioType(@Nullable MatchedInfo matchedInfo);

    void getMatchInfoRequest(@Nullable BaseQQAppInterface app, @Nullable String uin, @Nullable com.tencent.mobileqq.qqexpand.network.d callback);
}
