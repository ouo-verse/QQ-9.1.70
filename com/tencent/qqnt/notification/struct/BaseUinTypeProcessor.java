package com.tencent.qqnt.notification.struct;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.global.settings.api.IGlobalSettingsApi;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.notification.NotificationFacade;
import com.tencent.qqnt.notification.logic.INotifyCountService;
import com.tencent.qqnt.notification.logic.INotifySessionService;
import com.tencent.qqnt.notification.logic.NotificationBroadcastReceiver;
import common.config.service.QzoneConfig;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 -2\u00020\u0001:\u0001'B\u0019\b\u0004\u0012\u0006\u0010+\u001a\u00020&\u0012\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J2\u0010\u001f\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0004J\b\u0010 \u001a\u00020\u0002H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010$\u001a\u00020#H\u0004R\u001a\u0010+\u001a\u00020&8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010$\u001a\u00020#8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u001f\u0010,\u001a\u0004\b-\u0010.R\u0014\u00101\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/qqnt/notification/struct/BaseUinTypeProcessor;", "Lcom/tencent/qqnt/notification/struct/c;", "", "f", "title", "content", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", ReportConstant.COSTREPORT_PREFIX, "brief", "Lcom/tencent/qqnt/global/settings/notification/a;", "notificationExtInfo", h.F, "i", "Landroid/content/Intent;", "k", "l", "Landroid/graphics/Bitmap;", "j", "", "p", "notifyId", "intent", "Landroid/app/PendingIntent;", DomainData.DOMAIN_NAME, "o", "Landroid/content/Context;", "context", "chatType", "peerUid", "peerNickname", "b", "g", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "msgRecord", "e", "Lmqq/app/AppRuntime;", "a", "Lmqq/app/AppRuntime;", "c", "()Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "d", "()Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "nextRequestCode", "<init>", "(Lmqq/app/AppRuntime;Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;)V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class BaseUinTypeProcessor implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppRuntime appRuntime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecentContactInfo msgRecord;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicInteger nextRequestCode;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/notification/struct/BaseUinTypeProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.notification.struct.BaseUinTypeProcessor$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45543);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseUinTypeProcessor(@NotNull AppRuntime appRuntime, @NotNull RecentContactInfo msgRecord) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) msgRecord);
            return;
        }
        this.appRuntime = appRuntime;
        this.msgRecord = msgRecord;
        this.nextRequestCode = new AtomicInteger(1);
    }

    @Nullable
    protected final PendingIntent b(@NotNull Context context, int notifyId, int chatType, @NotNull String peerUid, @NotNull String peerNickname) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (PendingIntent) iPatchRedirector.redirect((short) 16, this, context, Integer.valueOf(notifyId), Integer.valueOf(chatType), peerUid, peerNickname);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(peerNickname, "peerNickname");
        try {
            if (notifyId == 0) {
                QLog.i("BaseUinTypeProcessor", 1, "[createReplyPendingIntent] notifyId is 0, chatType=" + chatType + ", peerUid=" + peerUid);
                return null;
            }
            NotificationBroadcastReceiver.Companion companion = NotificationBroadcastReceiver.INSTANCE;
            if (companion.e() == null) {
                QLog.w("BaseUinTypeProcessor", 1, "[createReplyPendingIntent] msgSender is null");
                return null;
            }
            return PendingIntent.getBroadcast(context, this.nextRequestCode.getAndIncrement(), companion.c(context, notifyId, peerUid, chatType, peerNickname), 33554432);
        } catch (Exception e16) {
            QLog.w("BaseUinTypeProcessor", 1, "[createReplyPendingIntent] error=" + e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final AppRuntime c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.appRuntime;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final RecentContactInfo d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RecentContactInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.msgRecord;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int e(@NotNull RecentContactInfo msgRecord) {
        final int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this, (Object) msgRecord)).intValue();
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        boolean isGlobalShowPreview = ((IGlobalSettingsApi) QRoute.api(IGlobalSettingsApi.class)).isGlobalShowPreview();
        long j3 = msgRecord.peerUin;
        IRuntimeService runtimeService = this.appRuntime.getRuntimeService(INotifySessionService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        INotifySessionService iNotifySessionService = (INotifySessionService) runtimeService;
        if (iNotifySessionService.isSeparateSessionMessage(msgRecord)) {
            if (isGlobalShowPreview) {
                i3 = iNotifySessionService.uniqueNotifyIdByUin(j3);
            } else {
                i3 = 265;
            }
        } else {
            i3 = -113;
        }
        com.tencent.qqnt.notification.util.a.f359909a.b("Notification.Session", new Function0<String>(i3) { // from class: com.tencent.qqnt.notification.struct.BaseUinTypeProcessor$getSeparateSessionNotifyId$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $notifyId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$notifyId = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, i3);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "getSeparateSessionNotifyId: " + this.$notifyId;
            }
        });
        return i3;
    }

    @NotNull
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return NotificationFacade.INSTANCE.a().j(this.appRuntime, this.msgRecord);
    }

    @NotNull
    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return QQNotificationManager.CHANNEL_ID_SHOW_BADGE;
    }

    @NotNull
    public String h(@NotNull String brief, @Nullable com.tencent.qqnt.global.settings.notification.a notificationExtInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) brief, (Object) notificationExtInfo);
        }
        Intrinsics.checkNotNullParameter(brief, "brief");
        return brief;
    }

    @NotNull
    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        IRuntimeService runtimeService = this.appRuntime.getRuntimeService(INotifyCountService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        StringBuffer stringBuffer = new StringBuffer(this.appRuntime.getApp().getString(R.string.cl8));
        int totalCount = ((INotifyCountService) runtimeService).getTotalCount(false);
        if (totalCount > 1000) {
            stringBuffer.append(this.appRuntime.getApp().getString(R.string.ckx));
        } else {
            stringBuffer.append(totalCount);
            stringBuffer.append(this.appRuntime.getApp().getString(R.string.cip));
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "sb.toString()");
        return stringBuffer2;
    }

    @Nullable
    public Bitmap j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Bitmap) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return BitmapFactory.decodeResource(this.appRuntime.getApp().getResources(), R.mipmap.f169224y);
    }

    @Nullable
    public Intent k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Intent) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        NotificationFacade.Companion companion = NotificationFacade.INSTANCE;
        Intent d16 = companion.a().d(this.appRuntime.getApp());
        d16.putExtra("key_peerId", this.msgRecord.peerUid);
        d16.putExtra("key_peerUin", this.msgRecord.peerUin);
        d16.putExtra("key_chat_type", this.msgRecord.chatType);
        d16.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 6);
        d16.putExtra(AppConstants.Key.KEY_NOTIFICATION_CLICK_ACTION, true);
        d16.putExtra("key_chat_name", companion.a().n(r()));
        companion.a().m(d16);
        return companion.a().e(this.msgRecord, d16);
    }

    @Nullable
    public Intent l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Intent) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        IRuntimeService runtimeService = this.appRuntime.getRuntimeService(INotifyCountService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        if (INotifyCountService.a.a((INotifyCountService) runtimeService, false, 1, null) == 1) {
            Intent k3 = k();
            Intrinsics.checkNotNull(k3);
            return k3;
        }
        NotificationFacade.Companion companion = NotificationFacade.INSTANCE;
        Intent d16 = companion.a().d(this.appRuntime.getApp());
        d16.addFlags(335544320);
        companion.a().k(d16);
        companion.a().e(this.msgRecord, d16);
        return d16;
    }

    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        int i3 = this.msgRecord.chatType;
        if (i3 != 1030 && i3 != 1035 && i3 != 1041 && i3 != 1042 && ((IGlobalSettingsApi) QRoute.api(IGlobalSettingsApi.class)).isOpenNoClearNotification()) {
            return true;
        }
        return false;
    }

    @NotNull
    public PendingIntent n(int notifyId, @NotNull Intent intent) throws NullPointerException {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (PendingIntent) iPatchRedirector.redirect((short) 14, (Object) this, notifyId, (Object) intent);
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (512 <= notifyId && notifyId < 523) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = 134217728;
        } else {
            i3 = 268435456;
        }
        int i16 = i3 | 67108864;
        if (!z16) {
            notifyId = 0;
        }
        if (intent.getBooleanExtra("is_broadcast_notification", false)) {
            PendingIntent broadcast = PendingIntent.getBroadcast(BaseApplication.getContext(), notifyId, intent, i16);
            Intrinsics.checkNotNullExpressionValue(broadcast, "{\n            // \u8fd9\u91cc\u6709\u4e0a\u62a5\u8fd4\u56de\u2026, intent, flag)\n        }");
            return broadcast;
        }
        PendingIntent activity = PendingIntent.getActivity(BaseApplication.getContext(), notifyId, intent, i16);
        Intrinsics.checkNotNullExpressionValue(activity, "{\n            getActivit\u2026, intent, flag)\n        }");
        return activity;
    }

    @Nullable
    public PendingIntent o(int notifyId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (PendingIntent) iPatchRedirector.redirect((short) 15, (Object) this, notifyId);
        }
        Context applicationContext = this.appRuntime.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "appRuntime.applicationContext");
        RecentContactInfo recentContactInfo = this.msgRecord;
        int i3 = recentContactInfo.chatType;
        String str = recentContactInfo.peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord.peerUid");
        return b(applicationContext, notifyId, i3, str, NotificationFacade.INSTANCE.a().n(r()));
    }

    public int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return R.mipmap.f130921;
    }

    @NotNull
    public String q(@NotNull String title, @NotNull String content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) title, (Object) content);
        }
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        return title + MsgSummary.STR_COLON + content;
    }

    @NotNull
    public String r() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        String str = this.msgRecord.remark;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = this.msgRecord.peerName;
        }
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord.remark.ifEmpty { msgRecord.peerName }");
        return str;
    }

    @NotNull
    public String s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        String string = this.appRuntime.getApp().getResources().getString(R.string.notification_title);
        Intrinsics.checkNotNullExpressionValue(string, "appRuntime.app.resources\u2026tring.notification_title)");
        return string;
    }
}
