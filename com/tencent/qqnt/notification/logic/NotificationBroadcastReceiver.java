package com.tencent.qqnt.notification.logic;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.RemoteInput;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.notification.NotificationFacade;
import com.tencent.qqnt.notification.reply.ReplyReport;
import com.tencent.qqnt.notification.util.j;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import mqq.app.AppRuntime;
import mqq.app.QQBroadcastReceiver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J \u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/notification/logic/NotificationBroadcastReceiver;", "Lmqq/app/QQBroadcastReceiver;", "Lmqq/app/AppRuntime;", "app", "Landroid/content/Intent;", "intent", "", "d", "e", "f", "", "notifyId", "g", "Landroid/content/Context;", "context", "onReceive", "<init>", "()V", "a", "b", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class NotificationBroadcastReceiver extends QQBroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private static b f359840b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f359841c;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J.\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\nR\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/notification/logic/NotificationBroadcastReceiver$a;", "", "Landroid/content/Context;", "context", "", "notifyId", "", "peerUin", "Landroid/content/Intent;", "b", "", "peerUid", "chatType", "peerNickname", "c", "", "enableReplyNotificationAbility$delegate", "Lkotlin/Lazy;", "d", "()Z", "enableReplyNotificationAbility", "Lcom/tencent/qqnt/notification/logic/NotificationBroadcastReceiver$b;", "msgSender", "Lcom/tencent/qqnt/notification/logic/NotificationBroadcastReceiver$b;", "e", "()Lcom/tencent/qqnt/notification/logic/NotificationBroadcastReceiver$b;", "f", "(Lcom/tencent/qqnt/notification/logic/NotificationBroadcastReceiver$b;)V", "ACTION_DELETE", "Ljava/lang/String;", "ACTION_REPLY", "TAG", "<init>", "()V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.notification.logic.NotificationBroadcastReceiver$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d() {
            return ((Boolean) NotificationBroadcastReceiver.f359841c.getValue()).booleanValue();
        }

        @NotNull
        public final Intent b(@NotNull Context context, int notifyId, long peerUin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Intent) iPatchRedirector.redirect((short) 4, this, context, Integer.valueOf(notifyId), Long.valueOf(peerUin));
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) NotificationBroadcastReceiver.class);
            intent.setAction("com.tencent.mobileqq.notification.action.delete");
            intent.putExtra("key_peerUin", peerUin);
            intent.putExtra(QQNotificationManager.PARAM_NOTIFYID, notifyId);
            return intent;
        }

        @NotNull
        public final Intent c(@NotNull Context context, int notifyId, @NotNull String peerUid, int chatType, @NotNull String peerNickname) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Intent) iPatchRedirector.redirect((short) 5, this, context, Integer.valueOf(notifyId), peerUid, Integer.valueOf(chatType), peerNickname);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(peerUid, "peerUid");
            Intrinsics.checkNotNullParameter(peerNickname, "peerNickname");
            long currentTimeMillis = System.currentTimeMillis();
            Intent intent = new Intent(context, (Class<?>) NotificationBroadcastReceiver.class);
            intent.setAction("com.tencent.mobileqq.notification.action.reply");
            intent.putExtra("key_peerId", peerUid);
            intent.putExtra("key_chat_type", chatType);
            intent.putExtra("notification_reply_notify_id", notifyId);
            intent.putExtra("key_chat_name", peerNickname);
            intent.putExtra("key_notification_time", currentTimeMillis);
            intent.setData(new Uri.Builder().scheme("reply").path(chatType + "/" + peerUid).appendQueryParameter("key_chat_name", peerNickname).appendQueryParameter("key_notification_time", String.valueOf(currentTimeMillis)).appendQueryParameter("notification_reply_notify_id", String.valueOf(notifyId)).build());
            QLog.i("NotificationBroadcastReceiver", 1, "[createReplyIntent] notifyId=" + notifyId + " peerUid=" + peerUid + " chatType=" + chatType + " notifyTime=" + currentTimeMillis + " data=" + intent.getData());
            return intent;
        }

        @Nullable
        public final b e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return NotificationBroadcastReceiver.f359840b;
            }
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        public final void f(@Nullable b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                NotificationBroadcastReceiver.f359840b = bVar;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
            }
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
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/notification/logic/NotificationBroadcastReceiver$b;", "", "", "peerUid", "", "chatType", "replyContent", "", "sendText", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public interface b {
        void sendText(@NotNull String peerUid, int chatType, @NotNull String replyContent);
    }

    static {
        Lazy<Boolean> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42958);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(NotificationBroadcastReceiver$Companion$enableReplyNotificationAbility$2.INSTANCE);
        f359841c = lazy;
    }

    public NotificationBroadcastReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d(AppRuntime app, Intent intent) {
        final long longExtra = intent.getLongExtra("key_peerUin", 0L);
        boolean z16 = false;
        final int intExtra = intent.getIntExtra(QQNotificationManager.PARAM_NOTIFYID, 0);
        com.tencent.qqnt.notification.util.a.f359909a.b("NotificationBroadcastReceiver", new Function0<String>(intExtra, longExtra) { // from class: com.tencent.qqnt.notification.logic.NotificationBroadcastReceiver$handleDelete$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $notifyId;
            final /* synthetic */ long $peerUin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$notifyId = intExtra;
                this.$peerUin = longExtra;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Integer.valueOf(intExtra), Long.valueOf(longExtra));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "[handleDelete] notifyId: " + this.$notifyId + " peerUin: " + j.f359913a.a(Long.valueOf(this.$peerUin));
            }
        });
        if (512 <= intExtra && intExtra < 522) {
            z16 = true;
        }
        if (z16) {
            ((INotifySessionService) app.getRuntimeService(INotifySessionService.class, "")).clearSessionPrefix(longExtra);
        }
    }

    private final void e(AppRuntime app, Intent intent) {
        if (!INSTANCE.d()) {
            QLog.w("NotificationBroadcastReceiver", 1, "[handleReply] reply notification ability is disabled");
        } else {
            f(intent);
        }
    }

    private final void f(Intent intent) {
        boolean z16;
        String str;
        char first;
        Unit unit;
        String stringExtra = intent.getStringExtra("key_peerId");
        String stringExtra2 = intent.getStringExtra("key_peerUin");
        String stringExtra3 = intent.getStringExtra("key_chat_name");
        boolean z17 = false;
        int intExtra = intent.getIntExtra("key_chat_type", 0);
        int intExtra2 = intent.getIntExtra("notification_reply_notify_id", 0);
        long longExtra = intent.getLongExtra("key_notification_time", 0L);
        if (stringExtra != null && stringExtra.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && intExtra != 0) {
            Bundle resultsFromIntent = RemoteInput.getResultsFromIntent(intent);
            if (resultsFromIntent != null) {
                str = resultsFromIntent.getString("notification_reply_content");
            } else {
                str = null;
            }
            if (str == null || str.length() == 0) {
                z17 = true;
            }
            if (z17) {
                QLog.w("NotificationBroadcastReceiver", 1, "[onHandleReplyNotification] replyContent is null or empty, peerUin=" + stringExtra2 + " chatType=" + intExtra + " nick=" + stringExtra3 + " notifyId=" + intExtra2 + " notifyTime=" + longExtra);
                return;
            }
            g(intExtra2);
            first = StringsKt___StringsKt.first(str);
            String str2 = str;
            QLog.i("NotificationBroadcastReceiver", 1, "[onHandleReplyNotification] send reply. notifyId=" + intExtra2 + " notifyTime=" + longExtra + " peerUin=" + stringExtra2 + " peerUid=" + stringExtra + " chatType=" + intExtra + " nick=" + stringExtra3 + " replyContent=" + first + "|" + str.length() + " data=" + intent.getData());
            b bVar = f359840b;
            if (bVar != null) {
                bVar.sendText(stringExtra, intExtra, str2);
                ReplyReport.f359849a.c();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                QLog.w("NotificationBroadcastReceiver", 1, "[onHandleReplyNotification] msgSender is null");
                return;
            }
            return;
        }
        QLog.w("NotificationBroadcastReceiver", 1, "[onHandleReplyNotification] invalid arguments, peerUin=" + stringExtra2 + " peerUid=" + stringExtra + " chatType=" + intExtra);
    }

    private final void g(int notifyId) {
        NotificationFacade.INSTANCE.a().w(notifyId);
    }

    @Override // mqq.app.QQBroadcastReceiver
    public void onReceive(@NotNull AppRuntime app, @NotNull Context context, @NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, app, context, intent);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode != -1223645569) {
                if (hashCode == 320758966 && action.equals("com.tencent.mobileqq.notification.action.delete")) {
                    d(app, intent);
                    return;
                }
            } else if (action.equals("com.tencent.mobileqq.notification.action.reply")) {
                e(app, intent);
                return;
            }
        }
        QLog.w("NotificationBroadcastReceiver", 1, "[onReceive] unknown event type: " + intent.getAction());
    }
}
