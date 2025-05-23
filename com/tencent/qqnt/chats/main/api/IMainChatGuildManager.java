package com.tencent.qqnt.chats.main.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u00020\u00032#\u0010\u0004\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00030\u0005H&J\b\u0010\n\u001a\u00020\u0003H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/chats/main/api/IMainChatGuildManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "findGuildHelper", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "Lkotlin/ParameterName;", "name", "result", "scrollToGuildHelper", "chats_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes24.dex */
public interface IMainChatGuildManager extends QRouteApi {
    void findGuildHelper(@NotNull Function1<? super RecentContactInfo, Unit> callback);

    void scrollToGuildHelper();
}
