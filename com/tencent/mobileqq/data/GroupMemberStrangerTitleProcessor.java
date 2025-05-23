package com.tencent.mobileqq.data;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.cache.api.Business;
import com.tencent.mobileqq.data.GroupMemberStrangerTitleProcessor;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.core.uievent.a;
import com.tencent.qqnt.chats.data.converter.f;
import com.tencent.qqnt.chats.data.converter.g;
import com.tencent.qqnt.chats.data.converter.k;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ?\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042#\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00180\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/data/GroupMemberStrangerTitleProcessor;", "Lcom/tencent/qqnt/chats/data/converter/g;", "", "groupCode", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "contact", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", CommonConstant.KEY_DISPLAY_NAME, "", "callback", "getDisplayTitle", "getDefaultTitle", "Lcom/tencent/qqnt/chats/data/converter/f;", "payload", "", "matchPayload", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "update", "Lcom/tencent/cache/api/collection/a;", "Lcom/tencent/mobileqq/data/GroupMemberStrangerTitleProcessor$TitleInfo;", "cacheTitleInfo", "Lcom/tencent/cache/api/collection/a;", "<init>", "()V", "Companion", "TitleInfo", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class GroupMemberStrangerTitleProcessor extends g {

    @NotNull
    private com.tencent.cache.api.collection.a<String, TitleInfo> cacheTitleInfo = new com.tencent.cache.api.collection.a<>(Business.Conversation, "TempChatInfo", 30);

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/data/GroupMemberStrangerTitleProcessor$TitleInfo;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatInfo;", "chatInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatInfo;", "getChatInfo", "()Lcom/tencent/qqnt/kernel/nativeinterface/TempChatInfo;", "nickName", "Ljava/lang/String;", "getNickName", "()Ljava/lang/String;", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/TempChatInfo;Ljava/lang/String;)V", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class TitleInfo {

        @NotNull
        private final TempChatInfo chatInfo;

        @NotNull
        private final String nickName;

        public TitleInfo(@NotNull TempChatInfo chatInfo, @NotNull String nickName) {
            Intrinsics.checkNotNullParameter(chatInfo, "chatInfo");
            Intrinsics.checkNotNullParameter(nickName, "nickName");
            this.chatInfo = chatInfo;
            this.nickName = nickName;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TitleInfo)) {
                return false;
            }
            TitleInfo titleInfo = (TitleInfo) other;
            if (Intrinsics.areEqual(this.chatInfo, titleInfo.chatInfo) && Intrinsics.areEqual(this.nickName, titleInfo.nickName)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final TempChatInfo getChatInfo() {
            return this.chatInfo;
        }

        @NotNull
        public final String getNickName() {
            return this.nickName;
        }

        public int hashCode() {
            return (this.chatInfo.hashCode() * 31) + this.nickName.hashCode();
        }

        @NotNull
        public String toString() {
            return "TitleInfo(chatInfo=" + this.chatInfo + ", nickName=" + this.nickName + ")";
        }
    }

    private final String getDefaultTitle(RecentContactInfo contact) {
        boolean z16;
        String str = contact.remark;
        Intrinsics.checkNotNullExpressionValue(str, "contact.remark");
        boolean z17 = true;
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String str2 = contact.remark;
            Intrinsics.checkNotNullExpressionValue(str2, "contact.remark");
            return str2;
        }
        String str3 = contact.peerName;
        Intrinsics.checkNotNullExpressionValue(str3, "contact.peerName");
        if (str3.length() <= 0) {
            z17 = false;
        }
        if (z17) {
            String str4 = contact.peerName;
            Intrinsics.checkNotNullExpressionValue(str4, "contact.peerName");
            return str4;
        }
        long j3 = contact.peerUin;
        if (j3 != 0) {
            return String.valueOf(j3);
        }
        return "";
    }

    private final String getDisplayTitle(String groupCode, final RecentContactInfo contact, final Function1<? super String, Unit> callback) {
        TroopMemberNickInfo troopMemberNickInfo;
        TroopMemberInfo troopMemberFromCacheOrFetchAsync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberFromCacheOrFetchAsync(groupCode, String.valueOf(contact.peerUin), null, "GroupMemberStrangerTitleProcessor", new com.tencent.qqnt.troopmemberlist.g() { // from class: com.tencent.mobileqq.data.b
            @Override // com.tencent.qqnt.troopmemberlist.g
            public final void a(TroopMemberInfo troopMemberInfo) {
                GroupMemberStrangerTitleProcessor.getDisplayTitle$lambda$3(Function1.this, this, contact, troopMemberInfo);
            }
        });
        if (troopMemberFromCacheOrFetchAsync != null && (troopMemberNickInfo = troopMemberFromCacheOrFetchAsync.nickInfo) != null) {
            return troopMemberNickInfo.getShowName();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDisplayTitle$lambda$3(Function1 function1, GroupMemberStrangerTitleProcessor this$0, RecentContactInfo contact, TroopMemberInfo troopMemberInfo) {
        TroopMemberNickInfo troopMemberNickInfo;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(contact, "$contact");
        if (troopMemberInfo != null) {
            troopMemberNickInfo = troopMemberInfo.nickInfo;
        } else {
            troopMemberNickInfo = null;
        }
        if (troopMemberNickInfo != null && !Intrinsics.areEqual(troopMemberInfo.nickInfo.getShowName(), troopMemberInfo.memberuin)) {
            if (function1 != null) {
                function1.invoke(troopMemberInfo.nickInfo.getShowName());
            }
        } else if (function1 != null) {
            function1.invoke(this$0.getDefaultTitle(contact));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void update$lambda$2$lambda$1(com.tencent.qqnt.chats.core.adapter.itemdata.g item, final GroupMemberStrangerTitleProcessor this$0, String peerUid, int i3, String str, final TempChatInfo tempChatInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(peerUid, "$peerUid");
        if (i3 == 0) {
            final String str2 = tempChatInfo.peerUid;
            final String groupCode = tempChatInfo.groupCode;
            final String str3 = tempChatInfo.fromNick;
            if (groupCode != null && groupCode.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && !Intrinsics.areEqual(groupCode, "0")) {
                Intrinsics.checkNotNullExpressionValue(groupCode, "groupCode");
                this$0.getDisplayTitle(groupCode, item.s(), new Function1<String, Unit>() { // from class: com.tencent.mobileqq.data.GroupMemberStrangerTitleProcessor$update$2$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str4) {
                        invoke2(str4);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull String it) {
                        com.tencent.cache.api.collection.a aVar;
                        Intrinsics.checkNotNullParameter(it, "it");
                        aVar = GroupMemberStrangerTitleProcessor.this.cacheTitleInfo;
                        String str4 = str2;
                        TempChatInfo tmpChatInfo = tempChatInfo;
                        Intrinsics.checkNotNullExpressionValue(tmpChatInfo, "tmpChatInfo");
                        aVar.f(str4, new GroupMemberStrangerTitleProcessor.TitleInfo(tmpChatInfo, it));
                        IChatsUtil iChatsUtil = (IChatsUtil) QRoute.api(IChatsUtil.class);
                        String uid = str2;
                        Intrinsics.checkNotNullExpressionValue(uid, "uid");
                        iChatsUtil.sendEventToChat(new a.x(uid, k.f355124a));
                        if (QLog.isDevelopLevel()) {
                            QLog.d("GroupMemberStrangerTitleProcessor", 4, "onGetTempChatInfo suc refresh title uid:" + str2 + " displayName:" + it + " groupCode:" + groupCode + " groupName:" + str3);
                        }
                    }
                });
            } else {
                QLog.e("GroupMemberStrangerTitleProcessor", 1, "update: group code null");
                item.w().i(this$0.getDefaultTitle(item.s()));
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("GroupMemberStrangerTitleProcessor", 4, "onGetTempChatInfo getTempChatInfo suc, wait get getDisplayTitle, uid:" + peerUid);
                return;
            }
            return;
        }
        QLog.e("GroupMemberStrangerTitleProcessor", 1, "onGetTempChatInfo fail:" + i3 + " refresh title part uid:" + peerUid + " msg:" + str);
        item.w().i(this$0.getDefaultTitle(item.s()));
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public boolean matchPayload(@NotNull f payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        return payload instanceof k;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a6, code lost:
    
        if (r6 == true) goto L32;
     */
    @Override // com.tencent.qqnt.chats.data.converter.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(@NotNull final com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull com.tencent.qqnt.chats.data.converter.c params) {
        boolean z16;
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(params, "params");
        if (item.n() != 100) {
            return;
        }
        String str = item.s().remark;
        Intrinsics.checkNotNullExpressionValue(str, "item.originData.remark");
        boolean z19 = true;
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            g.f w3 = item.w();
            String str2 = item.s().remark;
            Intrinsics.checkNotNullExpressionValue(str2, "item.originData.remark");
            w3.i(str2);
            if (QLog.isDevelopLevel()) {
                QLog.d("GroupMemberStrangerTitleProcessor", 4, "return remark:" + item.s().remark);
                return;
            }
            return;
        }
        final String k3 = item.k();
        int n3 = item.n();
        TitleInfo e16 = this.cacheTitleInfo.e(k3);
        if (e16 != null) {
            String nickName = e16.getNickName();
            if (nickName.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                String str3 = e16.getChatInfo().groupCode;
                Intrinsics.checkNotNullExpressionValue(str3, "info.chatInfo.groupCode");
                String displayTitle = getDisplayTitle(str3, item.s(), null);
                if (displayTitle != null) {
                    if (displayTitle.length() > 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                }
                z19 = false;
                if (z19) {
                    item.w().i(displayTitle);
                    this.cacheTitleInfo.f(k3, new TitleInfo(e16.getChatInfo(), displayTitle));
                } else {
                    item.w().i(nickName);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("GroupMemberStrangerTitleProcessor", 2, "update hit cache :" + e16 + ", nickName=" + item.w().e());
                    return;
                }
                return;
            }
            if (nickName.length() != 0) {
                z19 = false;
            }
            if (z19) {
                QLog.e("GroupMemberStrangerTitleProcessor", 2, "update: error nickNameCache null :" + e16);
            }
        }
        w msgService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService != null) {
            msgService.getTempChatInfo(n3, k3, new IGetTempChatInfoCallback() { // from class: com.tencent.mobileqq.data.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback
                public final void onResult(int i3, String str4, TempChatInfo tempChatInfo) {
                    GroupMemberStrangerTitleProcessor.update$lambda$2$lambda$1(com.tencent.qqnt.chats.core.adapter.itemdata.g.this, this, k3, i3, str4, tempChatInfo);
                }
            });
        }
    }
}
