package com.tencent.mobileqq.startup.task;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.preference.PreferenceManager;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.miniaio.MiniMsgHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.mobileqq.app.notification.QQNotifiableChecker;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.notification.api.INotificationReplyApi;
import com.tencent.mobileqq.notification.api.ISystemNotificationApi;
import com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.aio.api.IMsgSendHelper;
import com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi;
import com.tencent.qqnt.aio.utils.CustomWithRawUtil;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.IKernelSetter;
import com.tencent.qqnt.kernel.nativeinterface.NotificationCommonInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.notification.NotificationFacade;
import com.tencent.qqnt.notification.a;
import com.tencent.qqnt.notification.logic.NotificationBroadcastReceiver;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.BadgeUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0007*\u0005\u0012\u0016\u0019\u001d \u0018\u0000 \u000f2\u00020\u0001:\u0002\u0013%B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u001c\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0006R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/startup/task/NotificationInitTask;", "", "", "e", "i", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "appRef", tl.h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "msgRecord", "app", "Lcom/tencent/imcore/message/Message;", "b", "d", "f", "", "g", "com/tencent/mobileqq/startup/task/NotificationInitTask$c", "a", "Lcom/tencent/mobileqq/startup/task/NotificationInitTask$c;", "qAvatarProcessor", "com/tencent/mobileqq/startup/task/NotificationInitTask$qIntentProcessor$1", "Lcom/tencent/mobileqq/startup/task/NotificationInitTask$qIntentProcessor$1;", "qIntentProcessor", "com/tencent/mobileqq/startup/task/NotificationInitTask$e", "c", "Lcom/tencent/mobileqq/startup/task/NotificationInitTask$e;", "qSettingProcessor", "com/tencent/mobileqq/startup/task/NotificationInitTask$qNotifyProcessor$1", "Lcom/tencent/mobileqq/startup/task/NotificationInitTask$qNotifyProcessor$1;", "qNotifyProcessor", "com/tencent/mobileqq/startup/task/NotificationInitTask$d", "Lcom/tencent/mobileqq/startup/task/NotificationInitTask$d;", "qMsgBriefProcessor", "<init>", "()V", "ExpandNotificationListener", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NotificationInitTask {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c qAvatarProcessor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final NotificationInitTask$qIntentProcessor$1 qIntentProcessor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e qSettingProcessor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final NotificationInitTask$qNotifyProcessor$1 qNotifyProcessor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d qMsgBriefProcessor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/startup/task/NotificationInitTask$ExpandNotificationListener;", "Lcom/tencent/qqnt/kernel/invorker/c;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/NotificationCommonInfo;", "commonInfo", "", "c", "", "b", "", "seq", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class ExpandNotificationListener implements com.tencent.qqnt.kernel.invorker.c {
        static IPatchRedirector $redirector_;

        public ExpandNotificationListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private final String b(QQAppInterface app) {
            try {
                StringBuilder sb5 = new StringBuilder();
                Manager manager = app.getManager(QQManagerFactory.NEW_MSG_NOTIFICATION_MANAGER);
                Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.message.newmsg.NewMsgNotificationManager");
                sb5.append("globalSwitch:" + ((com.tencent.mobileqq.message.newmsg.a) manager).g() + ",");
                sb5.append("noClearNotification:" + app.isOpenNoClearNotification() + ",");
                sb5.append("canPlaySound:" + app.canPlaySound() + ",");
                sb5.append("canVibrate:" + app.canVibrator() + ",");
                sb5.append("noDisturbMode:" + com.tencent.mobileqq.util.az.b(app.getApplicationContext()) + ",");
                sb5.append("onlineStatusNoDisturb:" + QQNotifiableChecker.INSTANCE.d(app) + ",");
                sb5.append("isMiui:" + CommonBadgeUtilImpl.isMIUI6());
                String sb6 = sb5.toString();
                Intrinsics.checkNotNullExpressionValue(sb6, "{\n                String\u2026.toString()\n            }");
                return sb6;
            } catch (Throwable th5) {
                return String.valueOf(th5);
            }
        }

        private final void c(QQAppInterface app, RecentContactInfo msgRecord, NotificationCommonInfo commonInfo) {
            if (!app.isLogin()) {
                return;
            }
            ((IAppBadgeService) app.getRuntimeService(IAppBadgeService.class)).refreshAppBadge((int) commonInfo.msgListUnreadCnt);
            int i3 = msgRecord.chatType;
            if (i3 != 16 && i3 != 4) {
                if (msgRecord.unreadCnt == 0) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(NotificationFacade.INSTANCE.a().C()), null, null, new NotificationInitTask$ExpandNotificationListener$handleMsgReceive$2(app, msgRecord, null), 3, null);
                    QLog.i("Notification.InitTask", 1, "handle readed, chatType:" + msgRecord.chatType + " uid=" + msgRecord.peerUid + " msgSeq=" + msgRecord.msgSeq + " msgId=" + msgRecord.msgId + " msgTime=" + msgRecord.msgTime);
                    return;
                }
                if (msgRecord.notifiedType != 2) {
                    return;
                }
                QLog.i("Notification.InitTask", 1, "QQ Notification Settings:" + b(app));
                app.messageNotifiableChecker = new com.tencent.mobileqq.app.bq(app, 1, true, true);
                NotificationFacade.L(NotificationFacade.INSTANCE.a(), app, msgRecord, commonInfo, false, 8, null);
                com.tencent.gamecenter.common.util.l.q(new Contact(msgRecord.chatType, msgRecord.peerUid.toString(), ""), String.valueOf(msgRecord.peerUin), msgRecord.msgId);
                BusinessHandler businessHandler = app.getBusinessHandler(BusinessHandlerFactory.MINIMSG_HANDLER);
                Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.activity.miniaio.MiniMsgHandler");
                ((MiniMsgHandler) businessHandler).F2(String.valueOf(msgRecord.peerUin), com.tencent.nt.adapter.session.c.c(msgRecord.chatType), msgRecord.chatType);
                return;
            }
            ox3.a.a("Notification.InitTask", NotificationInitTask$ExpandNotificationListener$handleMsgReceive$1.INSTANCE);
        }

        @Override // com.tencent.qqnt.kernel.invorker.c
        public void a(@NotNull RecentContactInfo msgRecord, @NotNull NotificationCommonInfo commonInfo, int seq) {
            QQAppInterface qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, msgRecord, commonInfo, Integer.valueOf(seq));
                return;
            }
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof QQAppInterface) {
                qQAppInterface = (QQAppInterface) peekAppRuntime;
            } else {
                qQAppInterface = null;
            }
            if (qQAppInterface != null) {
                c(qQAppInterface, msgRecord, commonInfo);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/startup/task/NotificationInitTask$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.startup.task.NotificationInitTask$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/startup/task/NotificationInitTask$b", "Lcom/tencent/qqnt/notification/logic/NotificationBroadcastReceiver$b;", "", "peerUid", "", "chatType", "replyContent", "", "sendText", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements NotificationBroadcastReceiver.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.notification.logic.NotificationBroadcastReceiver.b
        public void sendText(@NotNull String peerUid, int chatType, @NotNull String replyContent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, peerUid, Integer.valueOf(chatType), replyContent);
                return;
            }
            Intrinsics.checkNotNullParameter(peerUid, "peerUid");
            Intrinsics.checkNotNullParameter(replyContent, "replyContent");
            ((IMsgSendHelper) QRoute.api(IMsgSendHelper.class)).sendText(peerUid, chatType, replyContent);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/startup/task/NotificationInitTask$c", "Lcom/tencent/qqnt/notification/inject/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "msgRecord", "Landroid/graphics/Bitmap;", "i", "", "useSenderUid", "f", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements com.tencent.qqnt.notification.inject.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.notification.inject.a
        @Nullable
        public Bitmap f(@NotNull RecentContactInfo msgRecord, boolean useSenderUid) {
            QQAppInterface qQAppInterface;
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Bitmap) iPatchRedirector.redirect((short) 3, this, msgRecord, Boolean.valueOf(useSenderUid));
            }
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof QQAppInterface) {
                qQAppInterface = (QQAppInterface) peekAppRuntime;
            } else {
                qQAppInterface = null;
            }
            if (qQAppInterface == null) {
                return null;
            }
            if (useSenderUid) {
                j3 = msgRecord.senderUin;
            } else {
                j3 = msgRecord.peerUin;
            }
            return qQAppInterface.getFaceBitmap(String.valueOf(j3), true);
        }

        @Override // com.tencent.qqnt.notification.inject.a
        @Nullable
        public Bitmap i(@NotNull RecentContactInfo msgRecord) {
            QQAppInterface qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgRecord);
            }
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            Bitmap troopFaceBitmap = ((IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class)).getTroopFaceBitmap(String.valueOf(msgRecord.peerUin));
            if (troopFaceBitmap != null) {
                return troopFaceBitmap;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof QQAppInterface) {
                qQAppInterface = (QQAppInterface) peekAppRuntime;
            } else {
                qQAppInterface = null;
            }
            if (qQAppInterface == null) {
                return null;
            }
            return qQAppInterface.getTroopFaceBitmap(String.valueOf(msgRecord.peerUin), (byte) 3, false, false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/startup/task/NotificationInitTask$d", "Lcom/tencent/qqnt/notification/inject/c;", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "msgRecord", "", "j", "nickName", DomainData.DOMAIN_NAME, "content", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class d implements com.tencent.qqnt.notification.inject.c {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final String a(@NotNull String content) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) content);
            }
            Intrinsics.checkNotNullParameter(content, "content");
            return ((IQQTextApi) QRoute.api(IQQTextApi.class)).getQQTextPurePlainText(content, 16).toString();
        }

        @Override // com.tencent.qqnt.notification.inject.c
        @NotNull
        public String j(@NotNull AppRuntime appRuntime, @NotNull RecentContactInfo msgRecord) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime, (Object) msgRecord);
            }
            Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            ArrayList<MsgAbstractElement> arrayList = msgRecord.abstractContent;
            if (msgRecord.chatType == 131) {
                if (arrayList != null && !arrayList.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    spannableStringBuilder.append((CharSequence) arrayList.get(0).content);
                }
                String spannableStringBuilder2 = spannableStringBuilder.toString();
                Intrinsics.checkNotNullExpressionValue(spannableStringBuilder2, "content.toString()");
                return a(spannableStringBuilder2);
            }
            String tryParse = ((IMarkdownFeatureCompatApi) QRoute.api(IMarkdownFeatureCompatApi.class)).tryParse(arrayList);
            if (tryParse != null) {
                String spannableStringBuilder3 = spannableStringBuilder.append((CharSequence) tryParse).toString();
                Intrinsics.checkNotNullExpressionValue(spannableStringBuilder3, "content.append(it).toString()");
                return spannableStringBuilder3;
            }
            if (arrayList != null) {
                for (MsgAbstractElement msgAbstractElement : arrayList) {
                    int i3 = msgAbstractElement.elementType;
                    if (i3 == 21) {
                        com.tencent.qqnt.aio.videochat.a aVar = com.tencent.qqnt.aio.videochat.a.f352344a;
                        Context applicationContext = appRuntime.getApplicationContext();
                        Integer num = msgAbstractElement.elementSubType;
                        Intrinsics.checkNotNullExpressionValue(num, "it.elementSubType");
                        int intValue = num.intValue();
                        String str = msgAbstractElement.content;
                        Intrinsics.checkNotNullExpressionValue(str, "it.content");
                        CharSequence a16 = aVar.a(applicationContext, appRuntime, intValue, str);
                        if (!TextUtils.isEmpty(a16)) {
                            spannableStringBuilder.append(a16);
                        }
                    } else if (i3 == 23) {
                        spannableStringBuilder.append((CharSequence) "[\u5728\u7ebf\u6587\u4ef6]").append((CharSequence) msgAbstractElement.fileName);
                    } else if (msgRecord.chatType == 2 && i3 == 3) {
                        spannableStringBuilder.append((CharSequence) "[\u7fa4\u6587\u4ef6]");
                    } else {
                        spannableStringBuilder.append((CharSequence) msgAbstractElement.content);
                    }
                }
            }
            String spannableStringBuilder4 = spannableStringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilder4, "content.toString()");
            return a(spannableStringBuilder4);
        }

        @Override // com.tencent.qqnt.notification.inject.c
        @NotNull
        public String n(@NotNull String nickName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) nickName);
            }
            Intrinsics.checkNotNullParameter(nickName, "nickName");
            return a(nickName);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"com/tencent/mobileqq/startup/task/NotificationInitTask$e", "Lcom/tencent/qqnt/notification/inject/f;", "", "b", "", "from", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "msgRecord", "a", "Landroid/graphics/Bitmap;", "bmp", "c", tl.h.F, "", "notifyId", "g", "Z", "isHeadsUpNotifyInited", "()Z", "setHeadsUpNotifyInited", "(Z)V", "getHeadsUpSwitch", "setHeadsUpSwitch", "headsUpSwitch", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class e implements com.tencent.qqnt.notification.inject.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isHeadsUpNotifyInited;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean headsUpSwitch;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.headsUpSwitch = true;
            }
        }

        @Override // com.tencent.qqnt.notification.inject.f
        @NotNull
        public String a(@Nullable String from, @Nullable RecentContactInfo msgRecord) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) from, (Object) msgRecord);
            }
            String string = BaseApplicationImpl.sApplication.getString(R.string.notification_title);
            Intrinsics.checkNotNullExpressionValue(string, "sApplication.getString(R\u2026tring.notification_title)");
            return string;
        }

        @Override // com.tencent.qqnt.notification.inject.f
        public boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.qqnt.notification.inject.f
        @Nullable
        public Bitmap c(@Nullable Bitmap bmp, @Nullable RecentContactInfo msgRecord) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Bitmap) iPatchRedirector.redirect((short) 8, (Object) this, (Object) bmp, (Object) msgRecord);
            }
            return null;
        }

        @Override // com.tencent.qqnt.notification.inject.f
        public boolean g(int notifyId) {
            QQAppInterface qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, notifyId)).booleanValue();
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof QQAppInterface) {
                qQAppInterface = (QQAppInterface) peekAppRuntime;
            } else {
                qQAppInterface = null;
            }
            if (qQAppInterface == null) {
                return false;
            }
            return BadgeUtils.h(notifyId, qQAppInterface);
        }

        @Override // com.tencent.qqnt.notification.inject.f
        public boolean h() {
            QQAppInterface qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
            }
            if (this.isHeadsUpNotifyInited) {
                return this.headsUpSwitch;
            }
            this.isHeadsUpNotifyInited = true;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof QQAppInterface) {
                qQAppInterface = (QQAppInterface) peekAppRuntime;
            } else {
                qQAppInterface = null;
            }
            if (qQAppInterface == null) {
                return true;
            }
            boolean z16 = PreferenceManager.getDefaultSharedPreferences(qQAppInterface.getApp()).getBoolean(qQAppInterface.getAccount() + "_heads_up_notify_switch", true);
            this.headsUpSwitch = z16;
            return z16;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61556);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.tencent.mobileqq.startup.task.NotificationInitTask$qIntentProcessor$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.tencent.mobileqq.startup.task.NotificationInitTask$qNotifyProcessor$1] */
    public NotificationInitTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.qAvatarProcessor = new c();
        this.qIntentProcessor = new com.tencent.qqnt.notification.inject.b() { // from class: com.tencent.mobileqq.startup.task.NotificationInitTask$qIntentProcessor$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NotificationInitTask.this);
                }
            }

            @Override // com.tencent.qqnt.notification.inject.b
            @NotNull
            public Intent d(@Nullable Context context) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Intent) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context);
                }
                Intent aliasIntent = SplashActivity.getAliasIntent(BaseApplicationImpl.sApplication);
                Intrinsics.checkNotNullExpressionValue(aliasIntent, "getAliasIntent(BaseApplicationImpl.sApplication)");
                return aliasIntent;
            }

            @Override // com.tencent.qqnt.notification.inject.b
            @Nullable
            public Intent e(@Nullable RecentContactInfo msgRecord, @Nullable Intent intent) {
                QQAppInterface qQAppInterface;
                com.tencent.mobileqq.app.bq bqVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    return (Intent) iPatchRedirector2.redirect((short) 5, (Object) this, (Object) msgRecord, (Object) intent);
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime instanceof QQAppInterface) {
                    qQAppInterface = (QQAppInterface) peekAppRuntime;
                } else {
                    qQAppInterface = null;
                }
                if (qQAppInterface == null) {
                    ox3.a.a("Notification.InitTask", NotificationInitTask$qIntentProcessor$1$handleIntentForMiniAio$1.INSTANCE);
                }
                if (msgRecord != null && msgRecord.peerUin != 0 && !TextUtils.isEmpty(msgRecord.peerUid)) {
                    ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).saveUidByUin(String.valueOf(msgRecord.peerUin), msgRecord.peerUid);
                }
                if (qQAppInterface != null && (bqVar = qQAppInterface.messageNotifiableChecker) != null) {
                    NotificationInitTask notificationInitTask = NotificationInitTask.this;
                    Intrinsics.checkNotNull(msgRecord);
                    Intent d16 = bqVar.d(NotificationInitTask.c(notificationInitTask, msgRecord, null, 2, null), intent);
                    if (d16 != null) {
                        return d16;
                    }
                    return intent;
                }
                return intent;
            }

            @Override // com.tencent.qqnt.notification.inject.b
            @NotNull
            public Intent k(@NotNull Intent intent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    return (Intent) iPatchRedirector2.redirect((short) 4, (Object) this, (Object) intent);
                }
                Intrinsics.checkNotNullParameter(intent, "intent");
                intent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
                return intent;
            }

            @Override // com.tencent.qqnt.notification.inject.b
            public boolean l(int chatType) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 6, (Object) this, chatType)).booleanValue();
                }
                return ((INotificationReplyApi) QRoute.api(INotificationReplyApi.class)).isReplyNotificationEnabled(chatType);
            }

            @Override // com.tencent.qqnt.notification.inject.b
            @NotNull
            public Intent m(@NotNull Intent intent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return (Intent) iPatchRedirector2.redirect((short) 3, (Object) this, (Object) intent);
                }
                Intrinsics.checkNotNullParameter(intent, "intent");
                BaseAIOUtils.m(intent, new int[]{2});
                intent.setAction("com.tencent.mobileqq.action.MAINACTIVITY");
                return intent;
            }
        };
        this.qSettingProcessor = new e();
        this.qNotifyProcessor = new com.tencent.qqnt.notification.inject.d() { // from class: com.tencent.mobileqq.startup.task.NotificationInitTask$qNotifyProcessor$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NotificationInitTask.this);
                }
            }

            private final int d(QQAppInterface app, Integer unreadCnt, int id5, boolean ignoreCancel) {
                com.tencent.mobileqq.service.d dVar;
                int e16 = e(unreadCnt, app);
                MobileQQServiceBase mobileQQService = app.getMobileQQService();
                if (mobileQQService instanceof com.tencent.mobileqq.service.d) {
                    dVar = (com.tencent.mobileqq.service.d) mobileQQService;
                } else {
                    dVar = null;
                }
                if (dVar != null) {
                    return dVar.u(id5, app.getMessageFacade(), e16, ignoreCancel);
                }
                return e16;
            }

            private final int e(Integer unreadCnt, QQAppInterface app) {
                int i3;
                IAppBadgeService iAppBadgeService = (IAppBadgeService) app.getRuntimeService(IAppBadgeService.class);
                if (unreadCnt != null) {
                    i3 = unreadCnt.intValue();
                } else {
                    i3 = -1;
                }
                return iAppBadgeService.getAppBadgeCount(i3);
            }

            @Override // com.tencent.qqnt.notification.inject.d
            public void a(@NotNull RecentContactInfo msgRecord, @NotNull Intent intent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) msgRecord, (Object) intent);
                } else {
                    Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
                    Intrinsics.checkNotNullParameter(intent, "intent");
                }
            }

            @Override // com.tencent.qqnt.notification.inject.d
            public void b(@NotNull final Notification notification, int id5, boolean ignoreCancel, @Nullable Integer unreadCnt) {
                QQAppInterface qQAppInterface;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, notification, Integer.valueOf(id5), Boolean.valueOf(ignoreCancel), unreadCnt);
                    return;
                }
                Intrinsics.checkNotNullParameter(notification, "notification");
                if (!CommonBadgeUtilImpl.isMIUI6()) {
                    return;
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime instanceof QQAppInterface) {
                    qQAppInterface = (QQAppInterface) peekAppRuntime;
                } else {
                    qQAppInterface = null;
                }
                if (qQAppInterface == null) {
                    QLog.w("Notification.InitTask", 1, "setBadgeForMiuiNotification, app==null");
                    return;
                }
                final int d16 = d(qQAppInterface, unreadCnt, id5, ignoreCancel);
                BadgeUtils.p(qQAppInterface.getApplicationContext(), d16, notification);
                ox3.a.c("Notification.InitTask", new Function0<String>(d16, notification) { // from class: com.tencent.mobileqq.startup.task.NotificationInitTask$qNotifyProcessor$1$setBadgeForMiuiNotification$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int $msgUnread;
                    final /* synthetic */ Notification $notification;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$msgUnread = d16;
                        this.$notification = notification;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, d16, (Object) notification);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            return (String) iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                        return "notification unread:" + this.$msgUnread + " number:" + this.$notification.number;
                    }
                });
            }

            @Override // com.tencent.qqnt.notification.inject.d
            public void c(@NotNull RecentContactInfo msgRecord) {
                QQAppInterface qQAppInterface;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) msgRecord);
                    return;
                }
                Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
                QLog.i("Notification.InitTask", 1, "vibratorAndAudioForMsg msgId=" + msgRecord.msgId);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime instanceof QQAppInterface) {
                    qQAppInterface = (QQAppInterface) peekAppRuntime;
                } else {
                    qQAppInterface = null;
                }
                if (qQAppInterface == null) {
                    QLog.w("Notification.InitTask", 1, "vibratorAndAudioForMsg, app==null, msgId=" + msgRecord.msgId);
                    return;
                }
                qQAppInterface.soundAndVibrateUtils.r(NotificationInitTask.c(NotificationInitTask.this, msgRecord, null, 2, null), true);
            }
        };
        this.qMsgBriefProcessor = new d();
    }

    private final Message b(RecentContactInfo msgRecord, QQAppInterface app) {
        QQMessageFacade messageFacade;
        MsgNotifyManager msgNotifyManager;
        Message existedMsg;
        Message message = new Message();
        message.istroop = com.tencent.nt.adapter.session.c.c(msgRecord.chatType);
        int i3 = 0;
        message.msgtype = 0;
        message.senderuin = String.valueOf(msgRecord.senderUin);
        message.frienduin = String.valueOf(msgRecord.peerUin);
        message.uniseq = msgRecord.msgId;
        if (app != null && (messageFacade = app.getMessageFacade()) != null && (msgNotifyManager = messageFacade.f116353m) != null && (existedMsg = msgNotifyManager.getExistedMsg(message)) != null) {
            i3 = existedMsg.counter;
        }
        message.counter = i3;
        return message;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Message c(NotificationInitTask notificationInitTask, RecentContactInfo recentContactInfo, QQAppInterface qQAppInterface, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            qQAppInterface = null;
        }
        return notificationInitTask.b(recentContactInfo, qQAppInterface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(QQAppInterface app, RecentContactInfo msgRecord) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(NotificationFacade.INSTANCE.a().C()), null, null, new NotificationInitTask$handleRevoke$1(app, msgRecord, null), 3, null);
    }

    private final void e() {
        NotificationBroadcastReceiver.INSTANCE.f(new b());
    }

    private final void h(WeakReference<QQAppInterface> appRef) {
        FlowKt.launchIn(FlowKt.onEach(((IMsgService) QRoute.api(IMsgService.class)).registerMsgStatusUpdateNotificationFlow(), new NotificationInitTask$setMsgRevokeListener$1(this, appRef, null)), CoroutineScopeKt.CoroutineScope(NotificationFacade.INSTANCE.a().C()));
    }

    private final void i() {
        BaseApplication baseApplication = BaseApplication.context;
        if (baseApplication != null && SettingCloneUtil.readValue((Context) baseApplication, (String) null, baseApplication.getResources().getString(R.string.hhh), AppConstants.QQSETTING_NOTIFY_ICON_KEY, false) && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("notification_turn_off_ongoing_notification_switch_9015", false)) {
            if (QLog.isColorLevel()) {
                QLog.i("Notification.InitTask", 2, "turn off notify icon switch");
            }
            ReportController.o(null, "dc00898", "", "", "0X800C5CF", "0X800C5CF", 0, 0, "", "", "", "");
            SettingCloneUtil.writeValue((Context) baseApplication, (String) null, baseApplication.getResources().getString(R.string.hhh), AppConstants.QQSETTING_NOTIFY_ICON_KEY, false);
        }
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        NotificationFacade a16 = NotificationFacade.INSTANCE.a();
        a.Companion companion = com.tencent.qqnt.notification.a.INSTANCE;
        a.C9661a c9661a = new a.C9661a();
        c9661a.i(this.qAvatarProcessor);
        c9661a.k(this.qIntentProcessor);
        c9661a.o(this.qSettingProcessor);
        c9661a.m(this.qNotifyProcessor);
        c9661a.l(this.qMsgBriefProcessor);
        c9661a.j(QQNotifiableChecker.INSTANCE.b());
        c9661a.n(new com.tencent.mobileqq.app.notification.processor.common.d());
        a16.E(c9661a.a());
        CustomWithRawUtil.f352256a.g();
        i();
        e();
        QRoute.api(ISystemNotificationApi.class);
    }

    public final boolean g(@NotNull QQAppInterface app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) app)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(app, "app");
        IRuntimeService runtimeService = app.getRuntimeService(IKernelService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IK\u2026va, ProcessConstant.MAIN)");
        com.tencent.qqnt.kernel.api.aa recentContactService = ((IKernelService) runtimeService).getRecentContactService();
        if (recentContactService == null) {
            QLog.w("Notification.InitTask", 1, "registerMessageNotification, recentContactService == null");
            return false;
        }
        recentContactService.e0(new ExpandNotificationListener());
        ((IKernelSetter) QRoute.api(IKernelSetter.class)).setServletKernelInit();
        h(new WeakReference<>(app));
        ox3.a.a("Notification.InitTask", NotificationInitTask$registerMessageNotification$1.INSTANCE);
        return true;
    }
}
