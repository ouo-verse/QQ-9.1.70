package com.tencent.qqnt.chats.api.impl;

import android.content.Context;
import android.os.Looper;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.core.ui.IChatsListVBInterface;
import com.tencent.qqnt.chats.core.uievent.a;
import com.tencent.qqnt.chats.main.vm.datasource.filter.ChatsFilterUtil;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.EnterOrExitMsgListInfo;
import com.tencent.qqnt.kernel.nativeinterface.GuildContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\nH\u0016J,\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\nH\u0016J.\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00040\nH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J \u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000fH\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J \u0010(\u001a\u00020'2\u0006\u0010\u001f\u001a\u00020\"2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H\u0016J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010)\u001a\u00020\bH\u0016J\b\u0010+\u001a\u00020\u000bH\u0016J\b\u0010,\u001a\u00020\u000bH\u0016J\b\u0010-\u001a\u00020\u0006H\u0016J\b\u0010.\u001a\u00020\u000bH\u0016J \u00100\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J \u00101\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J \u00102\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0016\u00a8\u00065"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/ChatsUtilImpl;", "Lcom/tencent/qqnt/chats/api/IChatsUtil;", "Ljava/lang/Runnable;", "task", "", "checkRunOnSubThread", "", "uid", "", "chatType", "Lkotlin/Function1;", "", "callback", "isTop", "isExist", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "findRecentContact", "clearAllUnreadCount", "guildId", "clearUnreadCount", "listType", "getUnreadCountByListType", "getUnreadCountNoiseByChatType", "", "getUnreadCountNoiseMap", "Lcom/tencent/qqnt/chats/core/uievent/b;", "event", "sendEventToChat", "mode", "triggerChatsNtFilter", "resetChatsNtFilter", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "isShowInMainChatList", "preReadCache", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "Landroid/content/Context;", "context", "Lmqq/app/AppRuntime;", "appRuntime", "", "buildMsgSummary", "option", "enterOrExitMsgList", "startupHitSnapshot", "isNightTheme", "getThemeId", "isDefaultTheme", "peerUid", "scrollToContact", "isInVisibleIndex", "chatsHighLightItem", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ChatsUtilImpl implements IChatsUtil {
    static IPatchRedirector $redirector_;

    public ChatsUtilImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void checkRunOnSubThread(Runnable task) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            task.run();
        } else {
            ThreadManagerV2.excute(task, 16, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearUnreadCount$lambda$1(int i3, String str) {
        QLog.d("MsgExt", 2, "[clearUnreadCount] err=" + i3 + ", msg=" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enterOrExitMsgList$lambda$3(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("MsgExt", 1, "[enterOrExitMsgList] err=" + i3 + ", msg=" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void findRecentContact$lambda$0(Function1 callback, String uid, int i3, int i16, String str, ArrayList arrayList, ArrayList arrayList2) {
        RecentContactInfo recentContactInfo;
        Object orNull;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(uid, "$uid");
        if (arrayList != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, 0);
            recentContactInfo = (RecentContactInfo) orNull;
        } else {
            recentContactInfo = null;
        }
        callback.invoke(recentContactInfo);
        QLog.d("MsgExt", 2, "[findRecentContact] uid=" + uid + ", chatType=" + i3 + ", result=" + i16 + ", errMsg=" + str);
    }

    @Override // com.tencent.qqnt.chats.api.IChatsUtil
    @NotNull
    public CharSequence buildMsgSummary(@NotNull g item, @NotNull Context context, @NotNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (CharSequence) iPatchRedirector.redirect((short) 15, this, item, context, appRuntime);
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        CharSequence d16 = com.tencent.qqnt.chats.biz.summary.msg.b.f354415a.a(item, context, appRuntime).d(context);
        Intrinsics.checkNotNullExpressionValue(d16, "MsgSummaryUtil.buildMsgS\u2026untime).parseMsg(context)");
        return d16;
    }

    @Override // com.tencent.qqnt.chats.api.IChatsUtil
    public void chatsHighLightItem(int chatType, @NotNull String peerUid, @NotNull String guildId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(chatType), peerUid, guildId);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        ((IChatsListVBInterface) QRoute.api(IChatsListVBInterface.class)).chatListHighLightItem(chatType, peerUid, guildId);
    }

    @Override // com.tencent.qqnt.chats.api.IChatsUtil
    public void clearAllUnreadCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.qqnt.chats.main.vm.unread.b bVar = com.tencent.qqnt.chats.main.vm.unread.b.f355436a;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        bVar.b(peekAppRuntime);
    }

    @Override // com.tencent.qqnt.chats.api.IChatsUtil
    public void clearUnreadCount(@NotNull String uid, int chatType, @NotNull String guildId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, uid, Integer.valueOf(chatType), guildId);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.setMsgRead(new Contact(chatType, uid, guildId), new IOperateCallback() { // from class: com.tencent.qqnt.chats.api.impl.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    ChatsUtilImpl.clearUnreadCount$lambda$1(i3, str);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.api.IChatsUtil
    public void enterOrExitMsgList(int listType, int option) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(listType), Integer.valueOf(option));
            return;
        }
        aa recentContactService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getRecentContactService();
        if (recentContactService != null) {
            recentContactService.enterOrExitMsgList(new EnterOrExitMsgListInfo(listType, option), new IOperateCallback() { // from class: com.tencent.qqnt.chats.api.impl.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    ChatsUtilImpl.enterOrExitMsgList$lambda$3(i3, str);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.api.IChatsUtil
    public void findRecentContact(@NotNull final String uid, final int chatType, @NotNull final Function1<? super RecentContactInfo, Unit> callback) {
        aa recentContactService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, uid, Integer.valueOf(chatType), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IKernelService i3 = com.tencent.qqnt.msg.f.i();
        if (i3 != null && (recentContactService = i3.getRecentContactService()) != null) {
            recentContactService.F0(new Contact(chatType, uid, ""), new IGetContactsCallback() { // from class: com.tencent.qqnt.chats.api.impl.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback
                public final void onResult(int i16, String str, ArrayList arrayList, ArrayList arrayList2) {
                    ChatsUtilImpl.findRecentContact$lambda$0(Function1.this, uid, chatType, i16, str, arrayList, arrayList2);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.api.IChatsUtil
    @NotNull
    public String getThemeId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        String currentThemeId = QQTheme.getCurrentThemeId(true);
        Intrinsics.checkNotNullExpressionValue(currentThemeId, "getCurrentThemeId(true)");
        return currentThemeId;
    }

    @Override // com.tencent.qqnt.chats.api.IChatsUtil
    public int getUnreadCountByListType(int listType) {
        aa recentContactService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, listType)).intValue();
        }
        IKernelService i3 = com.tencent.qqnt.msg.f.i();
        if (i3 != null && (recentContactService = i3.getRecentContactService()) != null) {
            return recentContactService.getUnreadCountByListType(listType);
        }
        return 0;
    }

    @Override // com.tencent.qqnt.chats.api.IChatsUtil
    public int getUnreadCountNoiseByChatType(int chatType) {
        aa recentContactService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, chatType)).intValue();
        }
        IKernelService i3 = com.tencent.qqnt.msg.f.i();
        if (i3 != null && (recentContactService = i3.getRecentContactService()) != null) {
            return recentContactService.getUnreadCountNoiseByChatType(chatType);
        }
        return 0;
    }

    @Override // com.tencent.qqnt.chats.api.IChatsUtil
    @Nullable
    public Map<Integer, Integer> getUnreadCountNoiseMap() {
        aa recentContactService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Map) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        IKernelService i3 = com.tencent.qqnt.msg.f.i();
        if (i3 != null && (recentContactService = i3.getRecentContactService()) != null) {
            return recentContactService.getUnreadCountNoiseMap();
        }
        return null;
    }

    @Override // com.tencent.qqnt.chats.api.IChatsUtil
    public boolean isDefaultTheme() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return QQTheme.isDefaultTheme();
    }

    @Override // com.tencent.qqnt.chats.api.IChatsUtil
    public void isExist(@NotNull String uid, int chatType, @NotNull final Function1<? super Boolean, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, uid, Integer.valueOf(chatType), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(callback, "callback");
        findRecentContact(uid, chatType, new Function1<RecentContactInfo, Unit>(callback) { // from class: com.tencent.qqnt.chats.api.impl.ChatsUtilImpl$isExist$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function1<Boolean, Unit> $callback;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) callback);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RecentContactInfo recentContactInfo) {
                invoke2(recentContactInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable RecentContactInfo recentContactInfo) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    this.$callback.invoke(Boolean.valueOf(recentContactInfo != null));
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) recentContactInfo);
                }
            }
        });
    }

    @Override // com.tencent.qqnt.chats.api.IChatsUtil
    public boolean isInVisibleIndex(int chatType, @NotNull String peerUid, @NotNull String guildId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, this, Integer.valueOf(chatType), peerUid, guildId)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return ((IChatsListVBInterface) QRoute.api(IChatsListVBInterface.class)).chatListIsInVisibleIndex(chatType, peerUid, guildId);
    }

    @Override // com.tencent.qqnt.chats.api.IChatsUtil
    public boolean isNightTheme() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return QQTheme.isNowThemeIsNight();
    }

    @Override // com.tencent.qqnt.chats.api.IChatsUtil
    public boolean isShowInMainChatList(@NotNull RecentContactInfo item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) item)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Iterator<T> it = ChatsFilterUtil.f355413a.d().iterator();
        while (it.hasNext()) {
            if (((com.tencent.qqnt.chats.main.vm.datasource.filter.b) it.next()).a(item)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.api.IChatsUtil
    public void isTop(@NotNull String uid, int chatType, @NotNull final Function1<? super Boolean, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, uid, Integer.valueOf(chatType), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(callback, "callback");
        findRecentContact(uid, chatType, new Function1<RecentContactInfo, Unit>(callback) { // from class: com.tencent.qqnt.chats.api.impl.ChatsUtilImpl$isTop$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function1<Boolean, Unit> $callback;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) callback);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RecentContactInfo recentContactInfo) {
                invoke2(recentContactInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable RecentContactInfo recentContactInfo) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) recentContactInfo);
                    return;
                }
                Function1<Boolean, Unit> function1 = this.$callback;
                boolean z16 = false;
                if (recentContactInfo != null && 1 == recentContactInfo.topFlag) {
                    z16 = true;
                }
                function1.invoke(Boolean.valueOf(z16));
            }
        });
    }

    @Override // com.tencent.qqnt.chats.api.IChatsUtil
    public void preReadCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            try {
                com.tencent.qqnt.chats.data.persistent.c.f355136a.h();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.tencent.qqnt.chats.api.IChatsUtil
    public void resetChatsNtFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            ChatsFilterUtil.f355413a.e();
        }
    }

    @Override // com.tencent.qqnt.chats.api.IChatsUtil
    public void scrollToContact(int chatType, @NotNull String peerUid, @NotNull String guildId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(chatType), peerUid, guildId);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        RecentContactInfo recentContactInfo = new RecentContactInfo();
        recentContactInfo.chatType = chatType;
        recentContactInfo.peerUid = peerUid;
        GuildContactInfo guildContactInfo = new GuildContactInfo();
        recentContactInfo.guildContactInfo = guildContactInfo;
        guildContactInfo.guildId = guildId;
        sendEventToChat(new a.k(recentContactInfo));
    }

    @Override // com.tencent.qqnt.chats.api.IChatsUtil
    public boolean sendEventToChat(@NotNull com.tencent.qqnt.chats.core.uievent.b event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        return com.tencent.qqnt.chats.c.f354431a.b(event);
    }

    @Override // com.tencent.qqnt.chats.api.IChatsUtil
    public boolean startupHitSnapshot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return com.tencent.qqnt.chats.perf.a.f355516a.h();
    }

    @Override // com.tencent.qqnt.chats.api.IChatsUtil
    public void triggerChatsNtFilter(int mode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, mode);
        } else {
            ChatsFilterUtil.f355413a.h(mode);
        }
    }
}
