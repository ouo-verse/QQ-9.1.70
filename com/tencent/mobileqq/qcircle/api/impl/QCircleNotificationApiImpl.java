package com.tencent.mobileqq.qcircle.api.impl;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.IQCircleNotificationApi;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \"2\u00020\u0001:\u0002#$B\u0007\u00a2\u0006\u0004\b \u0010!J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0017J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/impl/QCircleNotificationApiImpl;", "Lcom/tencent/mobileqq/qcircle/api/IQCircleNotificationApi;", "", "tag", "", "id", "Landroid/app/Notification;", "noti", WadlProxyConsts.CHANNEL, "", "showNotification", "cancelNotification", "", "useCache", "areAllEnabled", "channelId", "isChannelEnabled", "getQCircleCommonNotifyId", "getHideBadgeChannel", "getOtherChannel", "Lcom/tencent/mobileqq/qcircle/api/impl/QCircleNotificationApiImpl$b;", "allVisitInfo", "Lcom/tencent/mobileqq/qcircle/api/impl/QCircleNotificationApiImpl$b;", "Ljava/util/concurrent/ConcurrentHashMap;", "channelVisitMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/app/NotificationManager;", "nm$delegate", "Lkotlin/Lazy;", "getNm", "()Landroid/app/NotificationManager;", "nm", "<init>", "()V", "Companion", "a", "b", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QCircleNotificationApiImpl implements IQCircleNotificationApi {
    private static final int ALL_ENABLE_VISIT_LIMIT = 60000;
    private static final int CHANNEL_ENABLE_VISIT_LIMIT = 60000;

    @NotNull
    public static final String TAG = "QCircleNotificationApiImpl";

    @NotNull
    private final VisitInfo allVisitInfo = new VisitInfo(0, false);

    @NotNull
    private final ConcurrentHashMap<String, VisitInfo> channelVisitMap = new ConcurrentHashMap<>();

    /* renamed from: nm$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy nm;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0011\u001a\u0004\b\n\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/impl/QCircleNotificationApiImpl$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "b", "()J", "d", "(J)V", "lastVisitTime", "Z", "()Z", "c", "(Z)V", "enable", "<init>", "(JZ)V", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qcircle.api.impl.QCircleNotificationApiImpl$b, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class VisitInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private long lastVisitTime;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean enable;

        public VisitInfo(long j3, boolean z16) {
            this.lastVisitTime = j3;
            this.enable = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getEnable() {
            return this.enable;
        }

        /* renamed from: b, reason: from getter */
        public final long getLastVisitTime() {
            return this.lastVisitTime;
        }

        public final void c(boolean z16) {
            this.enable = z16;
        }

        public final void d(long j3) {
            this.lastVisitTime = j3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VisitInfo)) {
                return false;
            }
            VisitInfo visitInfo = (VisitInfo) other;
            if (this.lastVisitTime == visitInfo.lastVisitTime && this.enable == visitInfo.enable) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int a16 = androidx.fragment.app.a.a(this.lastVisitTime) * 31;
            boolean z16 = this.enable;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return a16 + i3;
        }

        @NotNull
        public String toString() {
            return "VisitInfo(lastVisitTime=" + this.lastVisitTime + ", enable=" + this.enable + ')';
        }
    }

    public QCircleNotificationApiImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<NotificationManager>() { // from class: com.tencent.mobileqq.qcircle.api.impl.QCircleNotificationApiImpl$nm$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final NotificationManager invoke() {
                Object systemService = BaseApplication.context.getSystemService("notification");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                return (NotificationManager) systemService;
            }
        });
        this.nm = lazy;
    }

    private final NotificationManager getNm() {
        return (NotificationManager) this.nm.getValue();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleNotificationApi
    public boolean areAllEnabled(boolean useCache) {
        if (!useCache) {
            boolean areNotificationsEnabled = QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplication.context);
            com.tencent.xaction.log.b.a(TAG, 1, "[areAllEnabled] no use cache, enabled=" + areNotificationsEnabled);
            return areNotificationsEnabled;
        }
        if (System.currentTimeMillis() - this.allVisitInfo.getLastVisitTime() < 60000) {
            return this.allVisitInfo.getEnable();
        }
        this.allVisitInfo.d(System.currentTimeMillis());
        this.allVisitInfo.c(QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplication.context));
        com.tencent.xaction.log.b.a(TAG, 1, "[areAllEnabled] enabled=" + this.allVisitInfo.getEnable() + ", cost=" + (System.currentTimeMillis() - this.allVisitInfo.getLastVisitTime()));
        return this.allVisitInfo.getEnable();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleNotificationApi
    public void cancelNotification(@NotNull String tag, int id5) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        QQNotificationManager.getInstance().cancelUseTag(tag, tag, id5);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleNotificationApi
    @NotNull
    public String getHideBadgeChannel() {
        return QQNotificationManager.CHANNEL_ID_HIDE_BADGE;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleNotificationApi
    @NotNull
    public String getOtherChannel() {
        return QQNotificationManager.CHANNEL_ID_OTHER;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleNotificationApi
    public int getQCircleCommonNotifyId() {
        return NotificationUtil.Constants.NOTIFY_ID_QCIRCLE_COMMEN;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
    
        r10 = getNm().getNotificationChannel(r9);
     */
    @Override // com.tencent.mobileqq.qcircle.api.IQCircleNotificationApi
    @TargetApi(26)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isChannelEnabled(@NotNull String channelId, boolean useCache) {
        Object orDefault;
        NotificationChannel notificationChannel;
        int importance;
        boolean z16;
        NotificationChannel notificationChannel2;
        int importance2;
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        boolean z17 = false;
        if (!areAllEnabled(useCache)) {
            return false;
        }
        if (useCache || notificationChannel2 == null) {
            orDefault = this.channelVisitMap.getOrDefault(channelId, new VisitInfo(0L, false));
            Intrinsics.checkNotNullExpressionValue(orDefault, "channelVisitMap.getOrDef\u2026lId, VisitInfo(0, false))");
            VisitInfo visitInfo = (VisitInfo) orDefault;
            if (System.currentTimeMillis() - visitInfo.getLastVisitTime() < 60000) {
                return visitInfo.getEnable();
            }
            long currentTimeMillis = System.currentTimeMillis();
            visitInfo.d(currentTimeMillis);
            try {
                notificationChannel = getNm().getNotificationChannel(channelId);
            } catch (Exception e16) {
                com.tencent.xaction.log.b.c(TAG, 1, "[areChannelEnabled] ", e16);
            }
            if (notificationChannel != null) {
                importance = notificationChannel.getImportance();
                if (importance != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                visitInfo.c(z16);
                com.tencent.xaction.log.b.a(TAG, 1, "[areChannelEnabled] enable=" + z16 + ", cost=" + (System.currentTimeMillis() - currentTimeMillis));
                this.channelVisitMap.put(channelId, visitInfo);
                return z16;
            }
            com.tencent.xaction.log.b.a(TAG, 1, "[areChannelEnabled] invalid channel id: " + channelId);
            return false;
        }
        importance2 = notificationChannel2.getImportance();
        if (importance2 != 0) {
            z17 = true;
        }
        com.tencent.xaction.log.b.a(TAG, 1, "[areChannelEnabled] no use cache, enable=" + z17);
        return z17;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleNotificationApi
    public void showNotification(@NotNull String tag, int id5, @NotNull Notification noti, @NotNull String channel) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(noti, "noti");
        Intrinsics.checkNotNullParameter(channel, "channel");
        isBlank = StringsKt__StringsJVMKt.isBlank(channel);
        if (!isBlank) {
            QQNotificationManager.addChannelIfNeed(noti, channel);
        }
        QQNotificationManager.getInstance().notifyUseTag(tag, tag, noti, QQNotificationManager.getInstance().createNotifyBundle(id5, "", -1));
    }
}
