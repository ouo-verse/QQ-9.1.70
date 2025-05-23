package com.tencent.qqnt.chats.api;

import android.content.Context;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\f\bg\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H&J,\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H&J.\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\b0\u0006H&J\b\u0010\u000e\u001a\u00020\bH&J \u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002H&J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H&J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0016\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014H&J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H&J\u0012\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u0004H&J\b\u0010\u001b\u001a\u00020\bH&J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\fH&J\b\u0010\u001e\u001a\u00020\bH&J \u0010%\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H&J\u0018\u0010'\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004H&J\b\u0010(\u001a\u00020\u0007H&J\b\u0010)\u001a\u00020\u0007H&J\b\u0010*\u001a\u00020\u0002H&J\b\u0010+\u001a\u00020\u0007H&J \u0010-\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H&J \u0010.\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H&J \u0010/\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H&\u00a8\u00060"}, d2 = {"Lcom/tencent/qqnt/chats/api/IChatsUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "uid", "", "chatType", "Lkotlin/Function1;", "", "", "callback", "isTop", "isExist", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "findRecentContact", "clearAllUnreadCount", "guildId", "clearUnreadCount", "listType", "getUnreadCountByListType", "getUnreadCountNoiseByChatType", "", "getUnreadCountNoiseMap", "Lcom/tencent/qqnt/chats/core/uievent/b;", "event", "sendEventToChat", "mode", "triggerChatsNtFilter", "resetChatsNtFilter", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "isShowInMainChatList", "preReadCache", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "Landroid/content/Context;", "context", "Lmqq/app/AppRuntime;", "appRuntime", "", "buildMsgSummary", "option", "enterOrExitMsgList", "startupHitSnapshot", "isNightTheme", "getThemeId", "isDefaultTheme", "peerUid", "scrollToContact", "isInVisibleIndex", "chatsHighLightItem", "chats_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IChatsUtil extends QRouteApi {
    @NotNull
    CharSequence buildMsgSummary(@NotNull g item, @NotNull Context context, @NotNull AppRuntime appRuntime);

    void chatsHighLightItem(int chatType, @NotNull String peerUid, @NotNull String guildId);

    void clearAllUnreadCount();

    void clearUnreadCount(@NotNull String uid, int chatType, @NotNull String guildId);

    void enterOrExitMsgList(int listType, int option);

    void findRecentContact(@NotNull String uid, int chatType, @NotNull Function1<? super RecentContactInfo, Unit> callback);

    @NotNull
    String getThemeId();

    int getUnreadCountByListType(int listType);

    int getUnreadCountNoiseByChatType(int chatType);

    @Nullable
    Map<Integer, Integer> getUnreadCountNoiseMap();

    boolean isDefaultTheme();

    void isExist(@NotNull String uid, int chatType, @NotNull Function1<? super Boolean, Unit> callback);

    boolean isInVisibleIndex(int chatType, @NotNull String peerUid, @NotNull String guildId);

    boolean isNightTheme();

    boolean isShowInMainChatList(@NotNull RecentContactInfo item);

    void isTop(@NotNull String uid, int chatType, @NotNull Function1<? super Boolean, Unit> callback);

    void preReadCache();

    void resetChatsNtFilter();

    void scrollToContact(int chatType, @NotNull String peerUid, @NotNull String guildId);

    boolean sendEventToChat(@NotNull com.tencent.qqnt.chats.core.uievent.b event);

    boolean startupHitSnapshot();

    void triggerChatsNtFilter(int mode);
}
