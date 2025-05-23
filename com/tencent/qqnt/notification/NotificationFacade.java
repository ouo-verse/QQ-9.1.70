package com.tencent.qqnt.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;
import androidx.core.graphics.drawable.IconCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.beacon.NTBeaconReport;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.global.settings.api.IGlobalSettingsApi;
import com.tencent.qqnt.kernel.nativeinterface.NotificationCommonInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.notification.logic.INotifyCountService;
import com.tencent.qqnt.notification.logic.INotifySessionService;
import com.tencent.qqnt.notification.logic.NotificationBroadcastReceiver;
import com.tencent.qqnt.notification.logic.NotificationHandler;
import com.tencent.qqnt.notification.reply.ReplyReport;
import com.tencent.qqnt.notification.struct.NotificationElementBuilder;
import com.tencent.qqnt.notification.trace.INotifyTracker;
import com.tencent.qqnt.notification.util.i;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 62\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002DEB\t\b\u0002\u00a2\u0006\u0004\b\\\u0010]J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J>\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\tH\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\tH\u0002J0\u0010!\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001cH\u0002J\f\u0010\"\u001a\u00020\u0018*\u00020\tH\u0002J,\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J*\u0010'\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00052\u0006\u0010&\u001a\u00020$2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J \u0010*\u001a\u00020\u00072\u0006\u0010&\u001a\u00020$2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(H\u0002J\u001a\u0010.\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010-\u001a\u00020\u001aH\u0002J\u0010\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\rH\u0002J\u000e\u00103\u001a\u00020\u00072\u0006\u00102\u001a\u000201J\u001a\u00106\u001a\u0004\u0018\u0001052\u0006\u0010\n\u001a\u00020\t2\u0006\u00104\u001a\u00020\rH\u0016J\u0012\u00107\u001a\u0004\u0018\u0001052\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u00109\u001a\u0002082\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010;\u001a\u0002082\u0006\u0010:\u001a\u000208H\u0016J\u0010\u0010<\u001a\u0002082\u0006\u0010:\u001a\u000208H\u0016J\u001e\u0010=\u001a\u0004\u0018\u0001082\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010:\u001a\u0004\u0018\u000108H\u0016J\u0010\u0010>\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010?\u001a\u00020\rH\u0016J\u0010\u0010@\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u001aH\u0016J\u001e\u0010B\u001a\u0004\u0018\u0001052\b\u0010A\u001a\u0004\u0018\u0001052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010D\u001a\u00020\u00182\b\u0010C\u001a\u0004\u0018\u00010\u00182\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010E\u001a\u00020\rH\u0016J\u0018\u0010F\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010H\u001a\u00020\u00182\u0006\u0010G\u001a\u00020\u0018H\u0016J,\u0010I\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rJ\u0006\u0010J\u001a\u00020\u0007J\u000e\u0010L\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u001aJ\u001a\u0010O\u001a\u00020\u00072\b\u0010M\u001a\u0004\u0018\u00010\t2\b\u0010N\u001a\u0004\u0018\u00010\tR\u0016\u0010Q\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010PR\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010RR\u0016\u0010S\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010PR\u0016\u0010V\u001a\u00020T8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010UR\u001b\u0010[\u001a\u00020W8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010X\u001a\u0004\bY\u0010Z\u00a8\u0006^"}, d2 = {"Lcom/tencent/qqnt/notification/NotificationFacade;", "Lcom/tencent/qqnt/notification/inject/a;", "Lcom/tencent/qqnt/notification/inject/b;", "Lcom/tencent/qqnt/notification/inject/f;", "Lcom/tencent/qqnt/notification/inject/c;", "Lmqq/app/AppRuntime;", "app", "", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/NotificationCommonInfo;", "commonInfo", "", "forRevoke", "Lcom/tencent/qqnt/notification/trace/INotifyTracker;", "tracker", "Lcom/tencent/qqnt/global/settings/notification/a;", "notificationExtInfo", "J", "Landroid/content/Context;", "context", "recentContactInfo", HippyTKDListViewAdapter.X, "", "D", "", "chatType", "", "peerUin", "msgSeq", "clientC2CSeq", "msgRandom", "y", "B", "appRuntime", "Lcom/tencent/qqnt/notification/struct/d;", "H", DTConstants.TAG.ELEMENT, "G", "Landroidx/core/app/NotificationCompat$Builder;", "notificationBuilder", "v", "Landroid/app/Notification;", "notification", "notifyId", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "state", "N", "Lcom/tencent/qqnt/notification/a;", "injector", "E", "useSenderUid", "Landroid/graphics/Bitmap;", "f", "i", "Landroid/content/Intent;", "d", "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "e", "l", h.F, "g", "bmp", "c", "from", "a", "b", "j", "nickName", DomainData.DOMAIN_NAME, "K", "I", "id", "w", "refreshSessionInfo", "revokeSessionInfo", "M", "Z", "hasNotification", "Lcom/tencent/qqnt/notification/a;", "hasInit", "Lcom/tencent/qqnt/notification/logic/NotificationHandler;", "Lcom/tencent/qqnt/notification/logic/NotificationHandler;", "notificationHandler", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/Lazy;", BdhLogUtil.LogTag.Tag_Conn, "()Lkotlinx/coroutines/CoroutineDispatcher;", "notificationDispatcher", "<init>", "()V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class NotificationFacade implements com.tencent.qqnt.notification.inject.a, com.tencent.qqnt.notification.inject.b, com.tencent.qqnt.notification.inject.f, com.tencent.qqnt.notification.inject.c {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g, reason: collision with root package name */
    private static final boolean f359784g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Lazy<NotificationFacade> f359785h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean hasNotification;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private a injector;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean hasInit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private NotificationHandler notificationHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy notificationDispatcher;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\bR!\u0010\t\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/notification/NotificationFacade$a;", "", "Lcom/tencent/qqnt/notification/NotificationFacade;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/qqnt/notification/NotificationFacade;", "getInstance$annotations", "()V", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "FORCE_SHOW_NOTIFICATION", "Z", "", "NOTIFICATION_STATE_KEY", "Ljava/lang/String;", "TAG", "notificationRemoveDuplicatesEnabled", "<init>", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.notification.NotificationFacade$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final NotificationFacade a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (NotificationFacade) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (NotificationFacade) NotificationFacade.f359785h.getValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/notification/NotificationFacade$b;", "Ljava/util/concurrent/Executor;", "Ljava/lang/Runnable;", "command", "", "execute", "<init>", "()V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements Executor {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NotNull Runnable command) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) command);
            } else {
                Intrinsics.checkNotNullParameter(command, "command");
                ThreadManagerV2.executeOnSubThread(command);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/notification/NotificationFacade$c", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/a;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onQueryResult", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class c implements hx3.b<com.tencent.qqnt.ntrelation.otherinfo.bean.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ NotificationFacade$showMessageNotification$showFunc$1 f359791a;

        c(NotificationFacade$showMessageNotification$showFunc$1 notificationFacade$showMessageNotification$showFunc$1) {
            this.f359791a = notificationFacade$showMessageNotification$showFunc$1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) notificationFacade$showMessageNotification$showFunc$1);
            }
        }

        @Override // hx3.b
        public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.otherinfo.bean.a> responseData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) responseData);
                return;
            }
            com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar = null;
            if (responseData != null && responseData.a() == 0 && responseData.b() != null) {
                ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.a> b16 = responseData.b();
                Intrinsics.checkNotNull(b16);
                if (!b16.isEmpty()) {
                    ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.a> b17 = responseData.b();
                    if (b17 != null) {
                        aVar = b17.get(0);
                    }
                    this.f359791a.a(aVar);
                }
            }
            QLog.d("Notification.Facade", 1, "[showMessageNotification]: info is null");
            this.f359791a.a(aVar);
        }
    }

    static {
        Lazy<NotificationFacade> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41530);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
            return;
        }
        INSTANCE = new Companion(null);
        f359784g = FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("notification_remove_duplicate_enabled_8990_116467982", true);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) NotificationFacade$Companion$instance$2.INSTANCE);
        f359785h = lazy;
    }

    public /* synthetic */ NotificationFacade(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            return;
        }
        iPatchRedirector.redirect((short) 22, (Object) this, (Object) defaultConstructorMarker);
    }

    @NotNull
    public static final NotificationFacade A() {
        return INSTANCE.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String B(RecentContactInfo recentContactInfo) {
        return " msgId=" + recentContactInfo.msgId + ",msgSeq=" + recentContactInfo.msgSeq + ",chatType=" + recentContactInfo.chatType + ",peerUid=" + recentContactInfo.peerUid + ",unread=" + recentContactInfo.unreadCnt + ",shieldFlag:" + recentContactInfo.shieldFlag + ",isBlock=" + recentContactInfo.isBlock + ",msgDisturb=" + recentContactInfo.isMsgDisturb + ",onlineMsg=" + recentContactInfo.isOnlineMsg + ",specialCare=" + ((int) recentContactInfo.specialCareFlag);
    }

    private final String D(RecentContactInfo msgRecord) {
        return y(msgRecord.chatType, msgRecord.peerUin, msgRecord.msgSeq, msgRecord.c2cClientMsgSeq, msgRecord.msgRandom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(AppRuntime app) {
        i iVar = i.f359912a;
        Context applicationContext = app.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "app.applicationContext");
        HashMap<String, String> e16 = iVar.e(applicationContext);
        QLog.i("Notification.Facade", 1, "System Notification Settings: " + iVar.o(e16));
        Context applicationContext2 = app.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "app.applicationContext");
        QLog.i("Notification.Facade", 1, "Notification Channels:\n" + iVar.a(applicationContext2));
        NTBeaconReport.h("", "msg_notification_system_settings", e16);
    }

    private final void G(AppRuntime appRuntime, com.tencent.qqnt.notification.struct.d element, NotificationCommonInfo commonInfo, RecentContactInfo msgRecord) {
        int i3;
        Integer num;
        Bitmap e16 = element.e();
        if (e16 == null) {
            e16 = BitmapFactory.decodeResource(appRuntime.getApp().getResources(), R.mipmap.f169224y);
        }
        String m3 = element.m();
        String d16 = element.d();
        Intent f16 = element.f();
        String l3 = element.l();
        if (f16 != null) {
            i3 = f16.getIntExtra("KEY_NOTIFY_ID_FROM_PROCESSOR", -113);
        } else {
            i3 = -113;
        }
        long j3 = 0;
        if (f16 != null) {
            j3 = f16.getLongExtra("key_peerUin", 0L);
        }
        int k3 = element.k();
        String b16 = element.b();
        PendingIntent h16 = element.h();
        boolean g16 = element.g();
        NotificationHandler notificationHandler = this.notificationHandler;
        if (notificationHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationHandler");
            notificationHandler = null;
        }
        NotificationCompat.Builder smallIcon = notificationHandler.g(b16).setSmallIcon(k3);
        boolean z16 = true;
        int i16 = i3;
        NotificationCompat.Builder largeIcon = smallIcon.setAutoCancel(true).setWhen(System.currentTimeMillis()).setOngoing(g16).setContentTitle(m3).setContentText(d16).setContentIntent(h16).setLargeIcon(e16);
        Intrinsics.checkNotNullExpressionValue(largeIcon, "notificationHandler.getN\u2026      .setLargeIcon(icon)");
        if (l3 != null) {
            largeIcon.setTicker(l3);
        }
        if (((IGlobalSettingsApi) QRoute.api(IGlobalSettingsApi.class)).needNotificationLight()) {
            largeIcon.setLights(-16711936, 2000, 2000);
        }
        if (Build.VERSION.SDK_INT >= 24 || h()) {
            largeIcon.setPriority(1).setVibrate(new long[0]);
        }
        if (element.j()) {
            a aVar = this.injector;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("injector");
                aVar = null;
            }
            if (!aVar.b().isAppForeground()) {
                a aVar2 = this.injector;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("injector");
                    aVar2 = null;
                }
                if (!aVar2.b().isRobotUin(String.valueOf(msgRecord.peerUin))) {
                    v(element, appRuntime, largeIcon);
                }
            }
        }
        Notification build = largeIcon.build();
        Intrinsics.checkNotNullExpressionValue(build, "notificationBuilder.build()");
        NotificationBroadcastReceiver.Companion companion = NotificationBroadcastReceiver.INSTANCE;
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        build.deleteIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, companion.b(context, i16, j3), 335544320);
        if (f16 == null) {
            com.tencent.qqnt.notification.util.a.f359909a.c("Notification.Check", NotificationFacade$prepareNotification$2.INSTANCE);
            return;
        }
        a aVar3 = this.injector;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("injector");
            aVar3 = null;
        }
        com.tencent.qqnt.notification.inject.d e17 = aVar3.e();
        boolean g17 = g(i16);
        if (commonInfo != null) {
            num = Integer.valueOf((int) commonInfo.msgListUnreadCnt);
        } else {
            num = null;
        }
        e17.b(build, i16, g17, num);
        if (i16 == -113) {
            z16 = false;
        }
        if (z16) {
            z(build, i16);
            return;
        }
        NotificationHandler notificationHandler2 = this.notificationHandler;
        if (notificationHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationHandler");
            notificationHandler2 = null;
        }
        notificationHandler2.c(275);
        z(build, 265);
    }

    private final com.tencent.qqnt.notification.struct.d H(AppRuntime appRuntime, RecentContactInfo msgRecord, boolean forRevoke, com.tencent.qqnt.global.settings.notification.a notificationExtInfo) {
        com.tencent.qqnt.notification.struct.d c16 = new NotificationElementBuilder(appRuntime, msgRecord, forRevoke, notificationExtInfo).c();
        Intrinsics.checkNotNull(c16);
        return c16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean J(AppRuntime app, final RecentContactInfo msgRecord, NotificationCommonInfo commonInfo, boolean forRevoke, INotifyTracker tracker, com.tencent.qqnt.global.settings.notification.a notificationExtInfo) {
        a aVar = this.injector;
        a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("injector");
            aVar = null;
        }
        if (!aVar.b().f(app, msgRecord, tracker)) {
            if (tracker != null) {
                tracker.r(false);
            }
            return false;
        }
        if (f359784g) {
            Context applicationContext = app.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "app.applicationContext");
            if (x(applicationContext, msgRecord)) {
                QLog.i("Notification.Facade", 1, "[showBannerNotification] notification exists, do not show. msgId=" + msgRecord.msgId);
                if (tracker != null) {
                    tracker.r(false);
                }
                NTBeaconReport.f("offline_notification_avoid_duplication");
                return false;
            }
        }
        a aVar3 = this.injector;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("injector");
            aVar3 = null;
        }
        if (!aVar3.b().h(app, msgRecord, tracker)) {
            if (tracker != null) {
                tracker.r(false);
            }
            com.tencent.qqnt.notification.util.a.f359909a.a(new Function0<String>() { // from class: com.tencent.qqnt.notification.NotificationFacade$showBannerNotification$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecentContactInfo.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "[showBannerNotification] device state check failed, msgId=" + RecentContactInfo.this.msgId;
                }
            });
            return false;
        }
        a aVar4 = this.injector;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("injector");
            aVar4 = null;
        }
        aVar4.b().g(app, msgRecord);
        if (!forRevoke) {
            IRuntimeService runtimeService = app.getRuntimeService(INotifyCountService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IN\u2026va, ProcessConstant.MAIN)");
            INotifyCountService iNotifyCountService = (INotifyCountService) runtimeService;
            iNotifyCountService.updateMessageCount(msgRecord);
            iNotifyCountService.addMessage(msgRecord);
        }
        final boolean isGlobalShowPreview = ((IGlobalSettingsApi) QRoute.api(IGlobalSettingsApi.class)).isGlobalShowPreview();
        a aVar5 = this.injector;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("injector");
            aVar5 = null;
        }
        if (!aVar5.b().d(app, msgRecord, isGlobalShowPreview, tracker)) {
            com.tencent.qqnt.notification.util.a.f359909a.a(new Function0<String>(isGlobalShowPreview) { // from class: com.tencent.qqnt.notification.NotificationFacade$showBannerNotification$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $withPreview;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$withPreview = isGlobalShowPreview;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, RecentContactInfo.this, Boolean.valueOf(isGlobalShowPreview));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "do not show message notification, msgId=" + RecentContactInfo.this.msgId + " preview=" + this.$withPreview;
                }
            });
            if (tracker != null) {
                tracker.r(false);
            }
            return false;
        }
        com.tencent.qqnt.notification.util.a aVar6 = com.tencent.qqnt.notification.util.a.f359909a;
        aVar6.a(new Function0<String>(isGlobalShowPreview) { // from class: com.tencent.qqnt.notification.NotificationFacade$showBannerNotification$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean $withPreview;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$withPreview = isGlobalShowPreview;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, RecentContactInfo.this, Boolean.valueOf(isGlobalShowPreview));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "start show message notification, msgId=" + RecentContactInfo.this.msgId + " preview=" + this.$withPreview;
            }
        });
        a aVar7 = this.injector;
        if (aVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("injector");
            aVar7 = null;
        }
        aVar7.b().b();
        a aVar8 = this.injector;
        if (aVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("injector");
            aVar8 = null;
        }
        aVar8.b().e(app, isGlobalShowPreview);
        com.tencent.qqnt.notification.struct.d H = H(app, msgRecord, forRevoke, notificationExtInfo);
        if (H == null) {
            aVar6.a(new Function0<String>(isGlobalShowPreview) { // from class: com.tencent.qqnt.notification.NotificationFacade$showBannerNotification$4
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $withPreview;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$withPreview = isGlobalShowPreview;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, RecentContactInfo.this, Boolean.valueOf(isGlobalShowPreview));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "failed to prepare notification, msgId=" + RecentContactInfo.this.msgId + " preview=" + this.$withPreview;
                }
            });
            if (tracker != null) {
                tracker.r(false);
            }
            return false;
        }
        G(app, H, commonInfo, msgRecord);
        if (isGlobalShowPreview && ((IGlobalSettingsApi) QRoute.api(IGlobalSettingsApi.class)).needLockScreenNotification()) {
            a aVar9 = this.injector;
            if (aVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("injector");
            } else {
                aVar2 = aVar9;
            }
            com.tencent.qqnt.notification.inject.d e16 = aVar2.e();
            Intent f16 = H.f();
            Intrinsics.checkNotNull(f16);
            e16.a(msgRecord, f16);
        }
        com.tencent.qqnt.notification.report.a.f359850a.c(msgRecord.chatType);
        if (tracker != null) {
            tracker.r(true);
        }
        return true;
    }

    public static /* synthetic */ void L(NotificationFacade notificationFacade, AppRuntime appRuntime, RecentContactInfo recentContactInfo, NotificationCommonInfo notificationCommonInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            notificationCommonInfo = null;
        }
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        notificationFacade.K(appRuntime, recentContactInfo, notificationCommonInfo, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(boolean state) {
        if (this.hasNotification != state) {
            this.hasNotification = state;
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            from.encodeBool("nt_notification_state_key", this.hasNotification);
        }
    }

    private final void v(com.tencent.qqnt.notification.struct.d element, AppRuntime appRuntime, NotificationCompat.Builder notificationBuilder) {
        PendingIntent i3 = element.i();
        if (i3 == null) {
            QLog.w("Notification.Facade", 1, "[addReplyButton] replyPendingIntent is null");
            return;
        }
        a aVar = this.injector;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("injector");
            aVar = null;
        }
        if (!aVar.c().l(element.c())) {
            ReplyReport.f359849a.b();
            return;
        }
        try {
            String string = appRuntime.getApp().getString(R.string.f171372nk);
            Intrinsics.checkNotNullExpressionValue(string, "appRuntime.app.getString\u2026tification_reply_message)");
            NotificationCompat.Action build = new NotificationCompat.Action.Builder((IconCompat) null, string, i3).addRemoteInput(new RemoteInput.Builder("notification_reply_content").setLabel(string).build()).setAllowGeneratedReplies(true).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder(null, replyText,\u2026\n                .build()");
            notificationBuilder.addAction(build);
            ReplyReport.f359849a.d();
            QLog.i("Notification.Facade", 1, "[addReplyButton] add reply to notification, chatType=" + element.c() + " showPreview=" + element.j());
        } catch (Exception e16) {
            QLog.w("Notification.Facade", 1, "[addReplyButton] error=" + e16);
        }
    }

    private final boolean x(Context context, RecentContactInfo recentContactInfo) {
        int i3;
        int i16;
        String str;
        String str2;
        String str3 = "Notification.Facade";
        String D = D(recentContactInfo);
        try {
            StatusBarNotification[] activeNotifications = QQNotificationManager.getInstance().getActiveNotifications();
            Intrinsics.checkNotNullExpressionValue(activeNotifications, "activeNotifications");
            int i17 = 0;
            for (int length = activeNotifications.length; i17 < length; length = i3) {
                StatusBarNotification statusBarNotification = activeNotifications[i17];
                if (QLog.isColorLevel()) {
                    int id5 = statusBarNotification.getId();
                    String tag = statusBarNotification.getTag();
                    String key = statusBarNotification.getKey();
                    boolean isOngoing = statusBarNotification.isOngoing();
                    i3 = length;
                    String packageName = statusBarNotification.getPackageName();
                    i16 = i17;
                    Notification notification = statusBarNotification.getNotification();
                    str = " activeNotifications=";
                    StringBuilder sb5 = new StringBuilder();
                    str2 = " msgRandom=";
                    sb5.append("ongoing notification: id=");
                    sb5.append(id5);
                    sb5.append(",tag=");
                    sb5.append(tag);
                    sb5.append(",key=");
                    sb5.append(key);
                    sb5.append(",isOngoing=");
                    sb5.append(isOngoing);
                    sb5.append(",packageName=");
                    sb5.append(packageName);
                    sb5.append(",notification=");
                    sb5.append(notification);
                    QLog.i("Notification.Facade", 2, sb5.toString());
                } else {
                    i3 = length;
                    i16 = i17;
                    str = " activeNotifications=";
                    str2 = " msgRandom=";
                }
                if (Intrinsics.areEqual(String.valueOf(statusBarNotification.getId()), D)) {
                    QLog.i("Notification.Facade", 1, "[checkOfflineNotificationExisting] exist=true notifyId=" + D + " uin=" + recentContactInfo.peerUin + " clientSeq=" + recentContactInfo.c2cClientMsgSeq + " msgSeq=" + recentContactInfo.msgSeq + str2 + recentContactInfo.msgRandom + str + activeNotifications.length);
                    return true;
                }
                i17 = i16 + 1;
            }
            try {
                try {
                    QLog.i("Notification.Facade", 1, "[checkOfflineNotificationExisting] exist=false notifyId=" + D + " uin=" + recentContactInfo.peerUin + " clientSeq=" + recentContactInfo.c2cClientMsgSeq + " msgSeq=" + recentContactInfo.msgSeq + " msgRandom=" + recentContactInfo.msgRandom + " activeNotifications=" + activeNotifications.length);
                    return false;
                } catch (Exception e16) {
                    e = e16;
                    str3 = "Notification.Facade";
                    QLog.i(str3, 1, "[checkOfflineNotificationExisting] exc=" + e);
                    return false;
                }
            } catch (Exception e17) {
                e = e17;
                str3 = "Notification.Facade";
            }
        } catch (Exception e18) {
            e = e18;
        }
    }

    private final String y(int chatType, long peerUin, long msgSeq, long clientC2CSeq, long msgRandom) {
        if (chatType != 1) {
            if (chatType != 2) {
                if (QLog.isColorLevel()) {
                    QLog.i("Notification.Facade", 2, "[computeOfflineNotifyId] unsupported chat type (" + chatType + ")");
                }
                return "";
            }
            return com.tencent.qqnt.notification.util.b.f359910a.b(peerUin, msgSeq);
        }
        return com.tencent.qqnt.notification.util.b.f359910a.a(peerUin, clientC2CSeq, msgRandom);
    }

    private final void z(Notification notification, final int notifyId) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        NotificationHandler notificationHandler = null;
        if (!g(notifyId)) {
            booleanRef.element = true;
            NotificationHandler notificationHandler2 = this.notificationHandler;
            if (notificationHandler2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notificationHandler");
                notificationHandler2 = null;
            }
            notificationHandler2.c(notifyId);
        }
        com.tencent.qqnt.notification.util.a.f359909a.a(new Function0<String>(notifyId, booleanRef) { // from class: com.tencent.qqnt.notification.NotificationFacade$generateNotificationAfterCancel$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Ref.BooleanRef $cancelNotification;
            final /* synthetic */ int $notifyId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$notifyId = notifyId;
                this.$cancelNotification = booleanRef;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, notifyId, (Object) booleanRef);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "generateNotificationAfterCancel, notifyId:" + this.$notifyId + " cancel:" + this.$cancelNotification.element;
            }
        });
        NotificationHandler notificationHandler3 = this.notificationHandler;
        if (notificationHandler3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationHandler");
        } else {
            notificationHandler = notificationHandler3;
        }
        notificationHandler.h(notifyId, notification);
        N(true);
    }

    @NotNull
    public final CoroutineDispatcher C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (CoroutineDispatcher) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return (CoroutineDispatcher) this.notificationDispatcher.getValue();
    }

    public final void E(@NotNull a injector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) injector);
            return;
        }
        Intrinsics.checkNotNullParameter(injector, "injector");
        this.injector = injector;
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        this.notificationHandler = new NotificationHandler(context, b());
        this.hasInit = true;
    }

    public final void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else if (this.hasInit) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(C()), null, null, new NotificationFacade$removeNotification$1(this, null), 3, null);
        }
    }

    public final void K(@NotNull AppRuntime app, @NotNull RecentContactInfo msgRecord, @Nullable NotificationCommonInfo commonInfo, boolean forRevoke) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, app, msgRecord, commonInfo, Boolean.valueOf(forRevoke));
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        NotificationFacade$showMessageNotification$showFunc$1 notificationFacade$showMessageNotification$showFunc$1 = new NotificationFacade$showMessageNotification$showFunc$1(this, app, msgRecord, commonInfo, forRevoke);
        if (msgRecord.chatType == 1) {
            IOtherInfoService iOtherInfoService = (IOtherInfoService) QRoute.api(IOtherInfoService.class);
            String str = msgRecord.peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "msgRecord.peerUid");
            iOtherInfoService.getOtherInfoWithUid(str, "Notification.Facade", new c(notificationFacade$showMessageNotification$showFunc$1));
            return;
        }
        notificationFacade$showMessageNotification$showFunc$1.a(null);
    }

    public final void M(@Nullable RecentContactInfo refreshSessionInfo, @Nullable RecentContactInfo revokeSessionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) refreshSessionInfo, (Object) revokeSessionInfo);
            return;
        }
        AppRuntime appRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService runtimeService = appRuntime.getRuntimeService(INotifyCountService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        INotifyCountService iNotifyCountService = (INotifyCountService) runtimeService;
        final int size = iNotifyCountService.getInBackgroundMessages().size();
        final int b16 = INotifyCountService.a.b(iNotifyCountService, false, 1, null);
        com.tencent.qqnt.notification.util.a aVar = com.tencent.qqnt.notification.util.a.f359909a;
        aVar.b("Notification.Facade", new Function0<String>(size, b16) { // from class: com.tencent.qqnt.notification.NotificationFacade$showReadedMsgNotification$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $messagesCount;
            final /* synthetic */ int $messagesSize;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$messagesSize = size;
                this.$messagesCount = b16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, Integer.valueOf(size), Integer.valueOf(b16));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "showReadedMsgNotification, messageSize:" + this.$messagesSize + ", counter:" + this.$messagesCount;
            }
        });
        IRuntimeService runtimeService2 = appRuntime.getRuntimeService(INotifySessionService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService2, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        INotifySessionService iNotifySessionService = (INotifySessionService) runtimeService2;
        boolean isGlobalShowPreview = ((IGlobalSettingsApi) QRoute.api(IGlobalSettingsApi.class)).isGlobalShowPreview();
        if (refreshSessionInfo != null && size != 0 && b16 != 0) {
            if (!isGlobalShowPreview) {
                aVar.b("Notification.Facade", NotificationFacade$showReadedMsgNotification$3.INSTANCE);
                Intrinsics.checkNotNullExpressionValue(appRuntime, "appRuntime");
                K(appRuntime, refreshSessionInfo, null, true);
                return;
            }
            if (revokeSessionInfo == null) {
                aVar.b("Notification.Facade", NotificationFacade$showReadedMsgNotification$4.INSTANCE);
                Intrinsics.checkNotNullExpressionValue(appRuntime, "appRuntime");
                K(appRuntime, refreshSessionInfo, null, false);
                return;
            }
            if (!iNotifySessionService.isSeparateSessionMessage(revokeSessionInfo)) {
                aVar.b("Notification.Facade", NotificationFacade$showReadedMsgNotification$5.INSTANCE);
                Intrinsics.checkNotNullExpressionValue(appRuntime, "appRuntime");
                K(appRuntime, refreshSessionInfo, null, true);
                if (com.tencent.qqnt.notification.logic.a.d(revokeSessionInfo) <= 0) {
                    iNotifySessionService.cancelNotificationByUin(revokeSessionInfo.peerUin);
                    return;
                }
                return;
            }
            aVar.b("Notification.Facade", NotificationFacade$showReadedMsgNotification$6.INSTANCE);
            if (NotificationElementBuilder.INSTANCE.a()) {
                Intrinsics.checkNotNullExpressionValue(appRuntime, "appRuntime");
                K(appRuntime, revokeSessionInfo, null, true);
                return;
            } else if (com.tencent.qqnt.notification.logic.a.d(revokeSessionInfo) > 0) {
                Intrinsics.checkNotNullExpressionValue(appRuntime, "appRuntime");
                K(appRuntime, revokeSessionInfo, null, true);
                return;
            } else {
                iNotifySessionService.cancelNotificationByUin(revokeSessionInfo.peerUin);
                return;
            }
        }
        aVar.b("Notification.Facade", NotificationFacade$showReadedMsgNotification$2.INSTANCE);
        w(265);
        if (isGlobalShowPreview && revokeSessionInfo != null && com.tencent.qqnt.notification.logic.a.d(revokeSessionInfo) <= 0) {
            iNotifySessionService.cancelNotificationByUin(revokeSessionInfo.peerUin);
        }
        if (revokeSessionInfo != null && NotificationElementBuilder.INSTANCE.a()) {
            Intrinsics.checkNotNullExpressionValue(appRuntime, "appRuntime");
            K(appRuntime, revokeSessionInfo, null, true);
        }
    }

    @Override // com.tencent.qqnt.notification.inject.f
    @NotNull
    public String a(@Nullable String from, @Nullable RecentContactInfo msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, (Object) from, (Object) msgRecord);
        }
        a aVar = this.injector;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("injector");
            aVar = null;
        }
        return aVar.g().a(from, msgRecord);
    }

    @Override // com.tencent.qqnt.notification.inject.f
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        a aVar = this.injector;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("injector");
            aVar = null;
        }
        return aVar.g().b();
    }

    @Override // com.tencent.qqnt.notification.inject.f
    @Nullable
    public Bitmap c(@Nullable Bitmap bmp, @Nullable RecentContactInfo msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Bitmap) iPatchRedirector.redirect((short) 12, (Object) this, (Object) bmp, (Object) msgRecord);
        }
        a aVar = this.injector;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("injector");
            aVar = null;
        }
        return aVar.g().c(bmp, msgRecord);
    }

    @Override // com.tencent.qqnt.notification.inject.b
    @NotNull
    public Intent d(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Intent) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        }
        a aVar = this.injector;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("injector");
            aVar = null;
        }
        return aVar.c().d(context);
    }

    @Override // com.tencent.qqnt.notification.inject.b
    @Nullable
    public Intent e(@Nullable RecentContactInfo msgRecord, @Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Intent) iPatchRedirector.redirect((short) 8, (Object) this, (Object) msgRecord, (Object) intent);
        }
        a aVar = this.injector;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("injector");
            aVar = null;
        }
        return aVar.c().e(msgRecord, intent);
    }

    @Override // com.tencent.qqnt.notification.inject.a
    @Nullable
    public Bitmap f(@NotNull RecentContactInfo msgRecord, boolean useSenderUid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, this, msgRecord, Boolean.valueOf(useSenderUid));
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        a aVar = this.injector;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("injector");
            aVar = null;
        }
        return aVar.a().f(msgRecord, useSenderUid);
    }

    @Override // com.tencent.qqnt.notification.inject.f
    public boolean g(int notifyId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, notifyId)).booleanValue();
        }
        a aVar = this.injector;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("injector");
            aVar = null;
        }
        return aVar.g().g(notifyId);
    }

    @Override // com.tencent.qqnt.notification.inject.f
    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        a aVar = this.injector;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("injector");
            aVar = null;
        }
        return aVar.g().h();
    }

    @Override // com.tencent.qqnt.notification.inject.a
    @Nullable
    public Bitmap i(@NotNull RecentContactInfo msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap) iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgRecord);
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        a aVar = this.injector;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("injector");
            aVar = null;
        }
        return aVar.a().i(msgRecord);
    }

    @Override // com.tencent.qqnt.notification.inject.c
    @NotNull
    public String j(@NotNull AppRuntime appRuntime, @NotNull RecentContactInfo msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this, (Object) appRuntime, (Object) msgRecord);
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        a aVar = this.injector;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("injector");
            aVar = null;
        }
        return aVar.d().j(appRuntime, msgRecord);
    }

    @Override // com.tencent.qqnt.notification.inject.b
    @NotNull
    public Intent k(@NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Intent) iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        a aVar = this.injector;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("injector");
            aVar = null;
        }
        return aVar.c().k(intent);
    }

    @Override // com.tencent.qqnt.notification.inject.b
    public boolean l(int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, chatType)).booleanValue();
        }
        a aVar = this.injector;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("injector");
            aVar = null;
        }
        return aVar.c().l(chatType);
    }

    @Override // com.tencent.qqnt.notification.inject.b
    @NotNull
    public Intent m(@NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Intent) iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        a aVar = this.injector;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("injector");
            aVar = null;
        }
        return aVar.c().m(intent);
    }

    @Override // com.tencent.qqnt.notification.inject.c
    @NotNull
    public String n(@NotNull String nickName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this, (Object) nickName);
        }
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        a aVar = this.injector;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("injector");
            aVar = null;
        }
        return aVar.d().n(nickName);
    }

    public final void w(int id5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, id5);
            return;
        }
        NotificationHandler notificationHandler = this.notificationHandler;
        if (notificationHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationHandler");
            notificationHandler = null;
        }
        notificationHandler.c(id5);
    }

    NotificationFacade() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            lazy = LazyKt__LazyJVMKt.lazy(NotificationFacade$notificationDispatcher$2.INSTANCE);
            this.notificationDispatcher = lazy;
        }
    }
}
