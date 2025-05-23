package com.tencent.biz.pubaccount.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\bg\u0018\u0000  2\u00020\u0001:\u0001!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\"\u0010\u000e\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH&J*\u0010\u0012\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H&J+\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&\u00a2\u0006\u0004\b\u0017\u0010\u0018J4\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u000bH&J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\""}, d2 = {"Lcom/tencent/biz/pubaccount/api/IPublicAccountReport;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "info", "", "reportItemShowOnConversation", "reportItemClickOnConversation", "reportItemShowOnServiceFolder", "reportItemClickOnServiceFolder", "", "uin", "", "from", "menuID", "reportMenuClickOnPublicAccountAIO", "type", "", "time", "reportStayTimeInPage", "action", "aioChatType", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "publicAccountAIOMsgReport", "(ILjava/lang/Integer;Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "position", "itemId", "triggleInfo", "actionAttr", "exePublicAccountTianshuReport", "reportPublicAccountADDuration", "uid", "Companion", "a", "qqpubaccount_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountReport extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f79357a;
    public static final int FROM_CONVERSATION_TAB = 1;
    public static final int FROM_PUBLIC_ACCOUNT_FOLDER = 2;

    @NotNull
    public static final String INTENT_KEY_FROM = "INTENT_KEY_FROM";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/biz/pubaccount/api/IPublicAccountReport$a;", "", "<init>", "()V", "qqpubaccount_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.pubaccount.api.IPublicAccountReport$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f79357a = new Companion();

        Companion() {
        }
    }

    void exePublicAccountTianshuReport(int action, int position, @Nullable String itemId, @Nullable String triggleInfo, int actionAttr);

    void publicAccountAIOMsgReport(int action, @Nullable Integer aioChatType, @Nullable MsgRecord msg2);

    void reportItemClickOnConversation(@NotNull RecentContactInfo info);

    void reportItemClickOnServiceFolder(@NotNull RecentContactInfo info);

    void reportItemShowOnConversation(@NotNull RecentContactInfo info);

    void reportItemShowOnServiceFolder(@NotNull RecentContactInfo info);

    void reportMenuClickOnPublicAccountAIO(@Nullable String uin, int from, int menuID);

    void reportPublicAccountADDuration(@NotNull RecentContactInfo info);

    void reportPublicAccountADDuration(@Nullable String uid);

    void reportStayTimeInPage(@Nullable String uin, int from, int type, long time);
}
