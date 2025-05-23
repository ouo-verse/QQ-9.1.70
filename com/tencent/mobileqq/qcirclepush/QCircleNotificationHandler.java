package com.tencent.mobileqq.qcirclepush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import com.tencent.biz.qqcircle.debug.QFSShowNotificationEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qcircle.api.IQCircleNotificationReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleNativeSessionGenerator;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.s2c.msgtype0x210.submsgtype0x15e.submsgtype0x15e$SystemNotify;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001#\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J \u0010\u0010\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\f\u0010\u0014\u001a\u00020\t*\u00020\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u0016\u0010\u0019\u001a\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017H\u0002J\u001e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001e0\u001dH\u0016R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/qcirclepush/QCircleNotificationHandler;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "notifyId", "", "g", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/mobileqq/qcirclepush/a;", "info", "j", "", "isOnlineMsg", "Ltencent/im/s2c/msgtype0x210/submsgtype0x15e/submsgtype0x15e$SystemNotify;", "systemNotify", "c", "e", "pushType", "f", "k", "sceneType", "l", "Lkotlin/Function0;", TencentLocation.RUN_MODE, h.F, "d", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "notifiedIds", "com/tencent/mobileqq/qcirclepush/QCircleNotificationHandler$qqAccountLogoutReceiver$1", "Lcom/tencent/mobileqq/qcirclepush/QCircleNotificationHandler$qqAccountLogoutReceiver$1;", "qqAccountLogoutReceiver", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QCircleNotificationHandler implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final QCircleNotificationHandler f261745d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<Integer> notifiedIds;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final QCircleNotificationHandler$qqAccountLogoutReceiver$1 qqAccountLogoutReceiver;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.tencent.mobileqq.qcirclepush.QCircleNotificationHandler$qqAccountLogoutReceiver$1, android.content.BroadcastReceiver] */
    static {
        QCircleNotificationHandler qCircleNotificationHandler = new QCircleNotificationHandler();
        f261745d = qCircleNotificationHandler;
        notifiedIds = new CopyOnWriteArrayList<>();
        ?? r16 = new BroadcastReceiver() { // from class: com.tencent.mobileqq.qcirclepush.QCircleNotificationHandler$qqAccountLogoutReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                CopyOnWriteArrayList<Integer> copyOnWriteArrayList;
                CopyOnWriteArrayList copyOnWriteArrayList2;
                copyOnWriteArrayList = QCircleNotificationHandler.notifiedIds;
                for (Integer id5 : copyOnWriteArrayList) {
                    QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
                    Intrinsics.checkNotNullExpressionValue(id5, "id");
                    qQNotificationManager.cancel("QCirclePush.NotificationHandler", id5.intValue());
                }
                copyOnWriteArrayList2 = QCircleNotificationHandler.notifiedIds;
                copyOnWriteArrayList2.clear();
            }
        };
        qqAccountLogoutReceiver = r16;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_EXPIRED);
        intentFilter.addAction(NewIntent.ACTION_FORCE_LOGOUT);
        intentFilter.addAction(NewIntent.ACTION_LOGOUT);
        intentFilter.addAction("mqq.intent.action.EXIT_" + BaseApplicationImpl.getApplication().getPackageName());
        SimpleEventBus.getInstance().registerReceiver(qCircleNotificationHandler);
        BaseApplication.context.registerReceiver(r16, intentFilter);
    }

    QCircleNotificationHandler() {
    }

    private final boolean c(QQAppInterface app, boolean isOnlineMsg, submsgtype0x15e$SystemNotify systemNotify) {
        if (!isOnlineMsg && !systemNotify.bool_is_handle_offline.get()) {
            QLog.i("QCirclePush.NotificationHandler", 1, "canShowNotification false, not handle current offline msg");
            return false;
        }
        if (!QQNotificationManager.getInstance().areNotificationsEnabled(app.getApplication())) {
            QLog.i("QCirclePush.NotificationHandler", 1, "canShowNotification false, notification disable");
            return false;
        }
        if (e(app)) {
            QLog.i("QCirclePush.NotificationHandler", 1, "canShowNotification false, inNotDisturb");
            return false;
        }
        if (f(app, systemNotify.uint32_push_type.get())) {
            return true;
        }
        QLog.i("QCirclePush.NotificationHandler", 1, "canShowNotification false, not matchPushType, pushType=" + systemNotify.uint32_push_type.get() + ", isAppBackground=" + app.isBackgroundPause);
        return false;
    }

    private final boolean e(QQAppInterface app) {
        boolean z16;
        boolean c16 = FriendsStatusUtil.c(BaseApplication.context);
        IRuntimeService runtimeService = app.getRuntimeService(IOnlineStatusService.class);
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IO\u2026tatusService::class.java)");
        if (((IOnlineStatusService) runtimeService).getOnlineStatus() == AppRuntime.Status.dnd) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (c16 || z16) {
            return true;
        }
        return false;
    }

    private final boolean f(QQAppInterface app, int pushType) {
        if (pushType == 2) {
            return true;
        }
        if (pushType == 0) {
            return app.isBackgroundPause;
        }
        if (pushType == 1) {
            return !app.isBackgroundPause;
        }
        return false;
    }

    private final void g(int notifyId) {
        QLog.i("QCirclePush.NotificationHandler", 1, "revokeNotification, notifyId=" + notifyId);
        QQNotificationManager.getInstance().cancel("QCirclePush.NotificationHandler", notifyId);
    }

    private final void h(final Function0<Unit> run) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qcirclepush.d
                @Override // java.lang.Runnable
                public final void run() {
                    QCircleNotificationHandler.i(Function0.this);
                }
            }, 16, null, true);
        } else {
            run.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function0 run) {
        Intrinsics.checkNotNullParameter(run, "$run");
        run.invoke();
    }

    private final void j(final QQAppInterface app, final NotificationInfo info) {
        bb0.b.i().d(info.getJumpUrl(), info.getPushId());
        final String generateShortSession = QCircleNativeSessionGenerator.generateShortSession();
        QLog.i("QCirclePush.NotificationHandler", 1, "showNotification, info=" + info + ", , pushSession= " + generateShortSession + ", isMainThread=" + Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()));
        h(new Function0<Unit>() { // from class: com.tencent.mobileqq.qcirclepush.QCircleNotificationHandler$showNotification$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CopyOnWriteArrayList copyOnWriteArrayList;
                QLog.i("QCirclePush.NotificationHandler", 1, "final show notification");
                c cVar = new c();
                BaseApplication context = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                NotificationInfo notificationInfo = NotificationInfo.this;
                String pushSession = generateShortSession;
                Intrinsics.checkNotNullExpressionValue(pushSession, "pushSession");
                QQNotificationManager.getInstance().notify("QCirclePush.NotificationHandler", NotificationInfo.this.getNotifyId(), cVar.a(context, notificationInfo, pushSession));
                copyOnWriteArrayList = QCircleNotificationHandler.notifiedIds;
                copyOnWriteArrayList.addIfAbsent(Integer.valueOf(NotificationInfo.this.getNotifyId()));
                app.vibratorAndAudio();
                ((IQCircleNotificationReporter) QRoute.api(IQCircleNotificationReporter.class)).reportExposure(NotificationInfo.this.getPushId(), generateShortSession, NotificationInfo.this.getExtInfo());
            }
        });
    }

    private final NotificationInfo k(submsgtype0x15e$SystemNotify submsgtype0x15e_systemnotify) {
        int l3 = l(submsgtype0x15e_systemnotify.uint32_scene_type.get());
        String str = submsgtype0x15e_systemnotify.str_push_id.get();
        Intrinsics.checkNotNullExpressionValue(str, "str_push_id.get()");
        String valueOf = String.valueOf(submsgtype0x15e_systemnotify.msg_content.uint64_from_uin.get());
        String str2 = submsgtype0x15e_systemnotify.msg_content.str_title.get();
        Intrinsics.checkNotNullExpressionValue(str2, "msg_content.str_title.get()");
        String str3 = submsgtype0x15e_systemnotify.msg_content.str_desc.get();
        Intrinsics.checkNotNullExpressionValue(str3, "msg_content.str_desc.get()");
        String str4 = submsgtype0x15e_systemnotify.msg_content.str_icon.get();
        Intrinsics.checkNotNullExpressionValue(str4, "msg_content.str_icon.get()");
        String str5 = submsgtype0x15e_systemnotify.msg_content.str_forword.get();
        Intrinsics.checkNotNullExpressionValue(str5, "msg_content.str_forword.get()");
        String stringUtf8 = submsgtype0x15e_systemnotify.bytes_ext_data.get().toStringUtf8();
        Intrinsics.checkNotNullExpressionValue(stringUtf8, "bytes_ext_data.get().toStringUtf8()");
        return new NotificationInfo(l3, str, valueOf, str2, str3, str4, str5, stringUtf8);
    }

    private final int l(int sceneType) {
        if (sceneType != 1) {
            if (sceneType != 2) {
                if (sceneType != 3) {
                    if (sceneType != 4) {
                        if (sceneType != 5) {
                            return NotificationUtil.Constants.NOTIFY_ID_QCIRCLE_COMMEN;
                        }
                        return NotificationUtil.Constants.NOTIFY_ID_QCIRCLE_RECOMMEND;
                    }
                    return NotificationUtil.Constants.NOTIFY_ID_QCIRCLE_PUSH;
                }
                return NotificationUtil.Constants.NOTIFY_ID_QCIRCLE_SECRET;
            }
            return NotificationUtil.Constants.NOTIFY_ID_QCIRCIE_LIKE;
        }
        return NotificationUtil.Constants.NOTIFY_ID_QCIRCLE_COM;
    }

    public final void d(@NotNull QQAppInterface app, @NotNull submsgtype0x15e$SystemNotify systemNotify, boolean isOnlineMsg) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(systemNotify, "systemNotify");
        if (systemNotify.bool_is_recall.get()) {
            g(l(systemNotify.uint32_scene_type.get()));
        } else {
            if (!c(app, isOnlineMsg, systemNotify)) {
                return;
            }
            submsgtype0x15e$SystemNotify submsgtype0x15e_systemnotify = systemNotify.get();
            Intrinsics.checkNotNullExpressionValue(submsgtype0x15e_systemnotify, "systemNotify.get()");
            j(app, k(submsgtype0x15e_systemnotify));
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QFSShowNotificationEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof QFSShowNotificationEvent) {
            String str = ((QFSShowNotificationEvent) event).jumpUrl;
            Intrinsics.checkNotNullExpressionValue(str, "event.jumpUrl");
            NotificationInfo notificationInfo = new NotificationInfo(NotificationUtil.Constants.NOTIFY_ID_QCIRCLE_PUSH, "", "111", "test", "test", "", str, "");
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            AppRuntime appRuntime = mobileQQ.getAppRuntime(mobileQQ.peekAppRuntime().getAccount());
            Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            j((QQAppInterface) appRuntime, notificationInfo);
        }
    }
}
