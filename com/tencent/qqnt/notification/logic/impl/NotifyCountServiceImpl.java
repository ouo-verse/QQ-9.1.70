package com.tencent.qqnt.notification.logic.impl;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.notification.NotificationFacade;
import com.tencent.qqnt.notification.logic.INotifyCountService;
import com.tencent.qqnt.notification.logic.INotifySessionService;
import com.tencent.qqnt.notification.logic.b;
import com.tencent.qqnt.notification.util.c;
import com.tencent.qqnt.notification.util.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\fH\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010 R$\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00020!j\b\u0012\u0004\u0012\u00020\u0002`\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/notification/logic/impl/NotifyCountServiceImpl;", "Lcom/tencent/qqnt/notification/logic/INotifyCountService;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "msgRecord", "findExistMsgRecord", "fst", "snd", "", "msgConversationEquals", "needAddMessage", "Lmqq/app/AppRuntime;", "appRuntime", "", "onCreate", "addMessage", "updateMessageCount", "ignoreSeparateSession", "", "getTotalCount", "chatType", "getCountByType", "", "peerUin", "getCountBySession", "getNewConversationSizeWithoutPublicAccount", "", "getInBackgroundMessages", "clearMessageCount", "removeNotification", "oldMr", "cancelNotificationWhenRevokeMessage", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lmqq/app/AppRuntime;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "messages", "Ljava/util/ArrayList;", "<init>", "()V", "Companion", "a", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class NotifyCountServiceImpl implements INotifyCountService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "Notification.Count";
    private static final boolean clearMsgCountInForeground;

    @Nullable
    private AppRuntime appRuntime;

    @NotNull
    private final ArrayList<RecentContactInfo> messages;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/notification/logic/impl/NotifyCountServiceImpl$a;", "", "", "TAG", "Ljava/lang/String;", "", "clearMsgCountInForeground", "Z", "<init>", "()V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.notification.logic.impl.NotifyCountServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43037);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
            clearMsgCountInForeground = FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("notification_clear_msg_count_in_foreground_900_117995399", true);
        }
    }

    public NotifyCountServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.messages = new ArrayList<>();
        }
    }

    private final RecentContactInfo findExistMsgRecord(RecentContactInfo msgRecord) {
        if (msgRecord == null) {
            return null;
        }
        synchronized (this.messages) {
            Iterator<RecentContactInfo> it = this.messages.iterator();
            while (it.hasNext()) {
                RecentContactInfo m3 = it.next();
                Intrinsics.checkNotNullExpressionValue(m3, "m");
                if (msgConversationEquals(m3, msgRecord)) {
                    return m3;
                }
            }
            Unit unit = Unit.INSTANCE;
            return null;
        }
    }

    private final boolean msgConversationEquals(RecentContactInfo fst, RecentContactInfo snd) {
        return Intrinsics.areEqual(fst.peerUin + ContainerUtils.FIELD_DELIMITER + fst.chatType, snd.peerUin + ContainerUtils.FIELD_DELIMITER + snd.chatType);
    }

    private final boolean needAddMessage() {
        return true;
    }

    @Override // com.tencent.qqnt.notification.logic.INotifyCountService
    public void addMessage(@NotNull RecentContactInfo msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgRecord);
            return;
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (!needAddMessage()) {
            return;
        }
        synchronized (this.messages) {
            RecentContactInfo findExistMsgRecord = findExistMsgRecord(msgRecord);
            if (findExistMsgRecord != null) {
                com.tencent.qqnt.notification.logic.a.g(msgRecord, com.tencent.qqnt.notification.logic.a.e(findExistMsgRecord));
                ArrayList<RecentContactInfo> arrayList = this.messages;
                arrayList.remove(arrayList.indexOf(findExistMsgRecord));
            }
            this.messages.add(msgRecord);
            if (com.tencent.qqnt.notification.logic.a.e(msgRecord) == null) {
                com.tencent.qqnt.notification.logic.a.g(msgRecord, new ArrayList());
            }
            ArrayList<RecentContactInfo> e16 = com.tencent.qqnt.notification.logic.a.e(msgRecord);
            Intrinsics.checkNotNull(e16);
            e16.add(msgRecord);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ec, code lost:
    
        if (r1 == false) goto L61;
     */
    @Override // com.tencent.qqnt.notification.logic.INotifyCountService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void cancelNotificationWhenRevokeMessage(@NotNull final RecentContactInfo oldMr) {
        boolean z16;
        boolean z17;
        RecentContactInfo recentContactInfo;
        Object obj;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) oldMr);
            return;
        }
        Intrinsics.checkNotNullParameter(oldMr, "oldMr");
        AppRuntime appRuntime = this.appRuntime;
        boolean z19 = false;
        if (appRuntime != null && appRuntime.isBackgroundPause) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && this.messages.size() != 0) {
            synchronized (this.messages) {
                RecentContactInfo findExistMsgRecord = findExistMsgRecord(oldMr);
                if (findExistMsgRecord != null) {
                    if (com.tencent.qqnt.notification.logic.a.e(findExistMsgRecord) != null && (!r4.isEmpty())) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        ArrayList<RecentContactInfo> e16 = com.tencent.qqnt.notification.logic.a.e(findExistMsgRecord);
                        RecentContactInfo recentContactInfo2 = null;
                        if (e16 != null) {
                            Iterator<T> it = e16.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    obj = it.next();
                                    if (((RecentContactInfo) obj).msgId == oldMr.msgId) {
                                        z18 = true;
                                    } else {
                                        z18 = false;
                                    }
                                    if (z18) {
                                        break;
                                    }
                                } else {
                                    obj = null;
                                    break;
                                }
                            }
                            recentContactInfo = (RecentContactInfo) obj;
                        } else {
                            recentContactInfo = null;
                        }
                        if (recentContactInfo == null) {
                            com.tencent.qqnt.notification.util.a.f359909a.b(TAG, NotifyCountServiceImpl$cancelNotificationWhenRevokeMessage$1$2.INSTANCE);
                            return;
                        }
                        ArrayList<RecentContactInfo> e17 = com.tencent.qqnt.notification.logic.a.e(findExistMsgRecord);
                        Intrinsics.checkNotNull(e17);
                        int indexOf = e17.indexOf(recentContactInfo);
                        ArrayList<RecentContactInfo> e18 = com.tencent.qqnt.notification.logic.a.e(findExistMsgRecord);
                        Intrinsics.checkNotNull(e18);
                        int size = e18.size();
                        if (size > 1 && indexOf == size - 1) {
                            ArrayList<RecentContactInfo> e19 = com.tencent.qqnt.notification.logic.a.e(findExistMsgRecord);
                            Intrinsics.checkNotNull(e19);
                            RecentContactInfo recentContactInfo3 = e19.get(size - 2);
                            Intrinsics.checkNotNullExpressionValue(recentContactInfo3, "revokeSessionInfo.msgInf\u2026st!![msgInfoListSize - 2]");
                            c.f359911a.a(recentContactInfo3, findExistMsgRecord);
                            com.tencent.qqnt.notification.util.a.f359909a.b(TAG, NotifyCountServiceImpl$cancelNotificationWhenRevokeMessage$1$3.INSTANCE);
                        }
                        ArrayList<RecentContactInfo> e26 = com.tencent.qqnt.notification.logic.a.e(findExistMsgRecord);
                        Intrinsics.checkNotNull(e26);
                        e26.remove(indexOf);
                        com.tencent.qqnt.notification.logic.a.f(findExistMsgRecord, com.tencent.qqnt.notification.logic.a.d(findExistMsgRecord) - 1);
                        if (com.tencent.qqnt.notification.logic.a.d(findExistMsgRecord) > 0) {
                            if (com.tencent.qqnt.notification.logic.a.e(findExistMsgRecord) != null && (!r4.isEmpty())) {
                                z19 = true;
                            }
                        }
                        this.messages.remove(findExistMsgRecord);
                        if (!this.messages.isEmpty()) {
                            ArrayList<RecentContactInfo> arrayList = this.messages;
                            recentContactInfo2 = arrayList.get(arrayList.size() - 1);
                        }
                        com.tencent.qqnt.notification.util.a.f359909a.b(TAG, new Function0<String>() { // from class: com.tencent.qqnt.notification.logic.impl.NotifyCountServiceImpl$cancelNotificationWhenRevokeMessage$1$4
                            static IPatchRedirector $redirector_;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecentContactInfo.this);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            @NotNull
                            public final String invoke() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
                                return "cancelNotificationWhenRevokeMessage, peerUin=" + j.f359913a.a(Long.valueOf(RecentContactInfo.this.peerUin)) + ", chatType=" + RecentContactInfo.this.chatType + " ";
                            }
                        });
                        NotificationFacade.INSTANCE.a().M(recentContactInfo2, findExistMsgRecord);
                        Unit unit = Unit.INSTANCE;
                        return;
                    }
                }
                com.tencent.qqnt.notification.util.a.f359909a.b(TAG, NotifyCountServiceImpl$cancelNotificationWhenRevokeMessage$1$1.INSTANCE);
            }
        }
    }

    @Override // com.tencent.qqnt.notification.logic.INotifyCountService
    public void clearMessageCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        synchronized (this.messages) {
            Iterator<RecentContactInfo> it = this.messages.iterator();
            while (it.hasNext()) {
                RecentContactInfo msg2 = it.next();
                Intrinsics.checkNotNullExpressionValue(msg2, "msg");
                com.tencent.qqnt.notification.logic.a.c(msg2);
            }
            this.messages.clear();
            b.f359848a.a();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.qqnt.notification.logic.INotifyCountService
    public int getCountBySession(long peerUin, int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, this, Long.valueOf(peerUin), Integer.valueOf(chatType))).intValue();
        }
        synchronized (this.messages) {
            Iterator<RecentContactInfo> it = this.messages.iterator();
            while (it.hasNext()) {
                RecentContactInfo msg2 = it.next();
                if (msg2.chatType == chatType && msg2.peerUin == peerUin) {
                    Intrinsics.checkNotNullExpressionValue(msg2, "msg");
                    return com.tencent.qqnt.notification.logic.a.d(msg2);
                }
            }
            return 0;
        }
    }

    @Override // com.tencent.qqnt.notification.logic.INotifyCountService
    public int getCountByType(int chatType) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, chatType)).intValue();
        }
        synchronized (this.messages) {
            Iterator<RecentContactInfo> it = this.messages.iterator();
            i3 = 0;
            while (it.hasNext()) {
                RecentContactInfo msg2 = it.next();
                if (msg2.chatType == chatType) {
                    Intrinsics.checkNotNullExpressionValue(msg2, "msg");
                    i3 += com.tencent.qqnt.notification.logic.a.d(msg2);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return i3;
    }

    @Override // com.tencent.qqnt.notification.logic.INotifyCountService
    @NotNull
    public List<RecentContactInfo> getInBackgroundMessages() {
        List<RecentContactInfo> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        synchronized (this.messages) {
            Object clone = this.messages.clone();
            Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo>");
            list = (List) clone;
        }
        return list;
    }

    @Override // com.tencent.qqnt.notification.logic.INotifyCountService
    public int getNewConversationSizeWithoutPublicAccount(boolean ignoreSeparateSession) {
        int i3;
        INotifySessionService iNotifySessionService;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, ignoreSeparateSession)).intValue();
        }
        synchronized (this.messages) {
            Iterator<RecentContactInfo> it = this.messages.iterator();
            i3 = 0;
            while (it.hasNext()) {
                RecentContactInfo next = it.next();
                int i16 = next.chatType;
                if (i16 != 1008 && i16 != 1044 && i16 != 1045) {
                    AppRuntime appRuntime = this.appRuntime;
                    if (appRuntime != null) {
                        iNotifySessionService = (INotifySessionService) appRuntime.getRuntimeService(INotifySessionService.class, "");
                    } else {
                        iNotifySessionService = null;
                    }
                    if (iNotifySessionService != null) {
                        boolean isSeparateSessionMessage = iNotifySessionService.isSeparateSessionMessage(next);
                        z16 = true;
                        if (isSeparateSessionMessage) {
                            if (z16 || !ignoreSeparateSession) {
                                i3++;
                            }
                        }
                    }
                    z16 = false;
                    if (z16) {
                    }
                    i3++;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return i3;
    }

    @Override // com.tencent.qqnt.notification.logic.INotifyCountService
    public int getTotalCount(boolean ignoreSeparateSession) {
        int i3;
        INotifySessionService iNotifySessionService;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, ignoreSeparateSession)).intValue();
        }
        synchronized (this.messages) {
            Iterator<RecentContactInfo> it = this.messages.iterator();
            i3 = 0;
            while (it.hasNext()) {
                RecentContactInfo msgRecord = it.next();
                int i16 = msgRecord.chatType;
                if (i16 != 1044 && i16 != 1045) {
                    AppRuntime appRuntime = this.appRuntime;
                    if (appRuntime != null) {
                        iNotifySessionService = (INotifySessionService) appRuntime.getRuntimeService(INotifySessionService.class, "");
                    } else {
                        iNotifySessionService = null;
                    }
                    if (iNotifySessionService != null) {
                        z16 = true;
                        if (iNotifySessionService.isSeparateSessionMessage(msgRecord)) {
                            if (z16 || !ignoreSeparateSession) {
                                Intrinsics.checkNotNullExpressionValue(msgRecord, "msgRecord");
                                i3 += com.tencent.qqnt.notification.logic.a.d(msgRecord);
                            }
                        }
                    }
                    z16 = false;
                    if (z16) {
                    }
                    Intrinsics.checkNotNullExpressionValue(msgRecord, "msgRecord");
                    i3 += com.tencent.qqnt.notification.logic.a.d(msgRecord);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return i3;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
            this.appRuntime = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            clearMessageCount();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v5, types: [com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo, T] */
    @Override // com.tencent.qqnt.notification.logic.INotifyCountService
    public void removeNotification(final long peerUin, final int chatType) {
        INotifySessionService iNotifySessionService;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Long.valueOf(peerUin), Integer.valueOf(chatType));
            return;
        }
        com.tencent.qqnt.notification.util.a.f359909a.b(TAG, new Function0<String>(peerUin, chatType) { // from class: com.tencent.qqnt.notification.logic.impl.NotifyCountServiceImpl$removeNotification$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $chatType;
            final /* synthetic */ long $peerUin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$peerUin = peerUin;
                this.$chatType = chatType;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, Long.valueOf(peerUin), Integer.valueOf(chatType));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "removeNotification, peerUin:" + j.f359913a.a(Long.valueOf(this.$peerUin)) + ", chatType:" + this.$chatType;
            }
        });
        if (this.messages.size() == 0) {
            return;
        }
        if (!clearMsgCountInForeground) {
            AppRuntime appRuntime = this.appRuntime;
            if (appRuntime != null && appRuntime.isBackgroundPause) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return;
            }
        }
        synchronized (this.messages) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            final Iterator<RecentContactInfo> it = this.messages.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "messages.iterator()");
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                RecentContactInfo next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                RecentContactInfo recentContactInfo = next;
                if (recentContactInfo.chatType == chatType && recentContactInfo.peerUin == peerUin) {
                    com.tencent.qqnt.notification.logic.a.f(recentContactInfo, 0);
                    it.remove();
                    booleanRef.element = true;
                    break;
                }
                objectRef.element = recentContactInfo;
            }
            com.tencent.qqnt.notification.util.a.f359909a.b(TAG, new Function0<String>(objectRef, it) { // from class: com.tencent.qqnt.notification.logic.impl.NotifyCountServiceImpl$removeNotification$2$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Iterator<RecentContactInfo> $iterator;
                final /* synthetic */ Ref.ObjectRef<RecentContactInfo> $preSessionInfo;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$preSessionInfo = objectRef;
                    this.$iterator = it;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, Ref.BooleanRef.this, objectRef, it);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "removeNotification remove:" + Ref.BooleanRef.this.element + ", preMsg is null:" + (this.$preSessionInfo.element == null) + ",iterator.hasNext():" + this.$iterator.hasNext();
                }
            });
            if (booleanRef.element) {
                if (objectRef.element == 0 && it.hasNext()) {
                    objectRef.element = it.next();
                }
                AppRuntime appRuntime2 = this.appRuntime;
                if (appRuntime2 != null) {
                    iNotifySessionService = (INotifySessionService) appRuntime2.getRuntimeService(INotifySessionService.class, "");
                } else {
                    iNotifySessionService = null;
                }
                if (iNotifySessionService == null || !iNotifySessionService.isSeparateSession(chatType, peerUin)) {
                    z17 = false;
                }
                if (z17) {
                    iNotifySessionService.cancelNotificationByUin(peerUin);
                } else {
                    NotificationFacade.INSTANCE.a().M((RecentContactInfo) objectRef.element, null);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.qqnt.notification.logic.INotifyCountService
    public void updateMessageCount(@NotNull RecentContactInfo msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgRecord);
            return;
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        int i3 = 0;
        if (msgRecord.chatType == 8) {
            RecentContactInfo findExistMsgRecord = findExistMsgRecord(msgRecord);
            if (findExistMsgRecord != null) {
                i3 = (int) findExistMsgRecord.unreadCnt;
            }
            com.tencent.qqnt.notification.logic.a.f(msgRecord, i3 + 1);
            return;
        }
        RecentContactInfo findExistMsgRecord2 = findExistMsgRecord(msgRecord);
        if (findExistMsgRecord2 != null) {
            i3 = com.tencent.qqnt.notification.logic.a.d(findExistMsgRecord2);
        }
        com.tencent.qqnt.notification.logic.a.f(msgRecord, i3 + 1);
    }
}
