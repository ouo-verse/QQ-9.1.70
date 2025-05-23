package com.tencent.qqnt.notification.logic;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.List;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Service(needUin = true, process = {"all"})
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0003H&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH&J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H&J\u0012\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H&J\u0012\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/notification/logic/INotifyCountService;", "Lmqq/app/api/IRuntimeService;", "addMessage", "", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "cancelNotificationWhenRevokeMessage", "oldMr", "clearMessageCount", "getCountBySession", "", "peerUin", "", "chatType", "getCountByType", "getInBackgroundMessages", "", "getNewConversationSizeWithoutPublicAccount", "ignoreSeparateSession", "", "getTotalCount", "removeNotification", "updateMessageCount", "notification_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public interface INotifyCountService extends IRuntimeService {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class a {
        public static /* synthetic */ int a(INotifyCountService iNotifyCountService, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = false;
                }
                return iNotifyCountService.getNewConversationSizeWithoutPublicAccount(z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNewConversationSizeWithoutPublicAccount");
        }

        public static /* synthetic */ int b(INotifyCountService iNotifyCountService, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = false;
                }
                return iNotifyCountService.getTotalCount(z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTotalCount");
        }
    }

    void addMessage(@NotNull RecentContactInfo msgRecord);

    void cancelNotificationWhenRevokeMessage(@NotNull RecentContactInfo oldMr);

    void clearMessageCount();

    int getCountBySession(long peerUin, int chatType);

    int getCountByType(int chatType);

    @NotNull
    List<RecentContactInfo> getInBackgroundMessages();

    int getNewConversationSizeWithoutPublicAccount(boolean ignoreSeparateSession);

    int getTotalCount(boolean ignoreSeparateSession);

    void removeNotification(long peerUin, int chatType);

    void updateMessageCount(@NotNull RecentContactInfo msgRecord);
}
