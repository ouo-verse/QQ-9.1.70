package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.util.LogUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J:\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J:\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016JB\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J2\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOStarterApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOStarterApi;", "Landroid/content/Context;", "context", "", "chatType", "", "uid", "nick", "", "uin", "Landroid/os/Bundle;", "data", "", "navigateToAIO", "navigateToAIOActivity", "activityFlag", "navigateToScaleAIO", "<init>", "()V", "Companion", "a", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOStarterApiNtImpl implements IAIOStarterApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "AIOStarterApiNtImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOStarterApiNtImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.adapter.api.impl.AIOStarterApiNtImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30921);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOStarterApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOStarterApi
    public void navigateToAIO(@NotNull Context context, int chatType, @NotNull String uid, @NotNull String nick, long uin, @Nullable Bundle data) {
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(chatType), uid, nick, Long.valueOf(uin), data);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(nick, "nick");
        QLog.i(TAG, 1, "navigateToAIO, uid is " + uid + ", nick is " + nick + ", chatType is " + chatType + ", uin is " + LogUtil.wrapLogUin(String.valueOf(uin)));
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(nick, "u_", false, 2, null);
        if (startsWith$default) {
            QLog.i(TAG, 1, "[navigateToAIO]: " + Log.getStackTraceString(new Throwable()));
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, "/base/main/aio");
        activityURIRequest.extra().putInt("key_chat_type", chatType);
        activityURIRequest.extra().putString("key_peerId", uid);
        activityURIRequest.extra().putString("key_chat_name", nick);
        activityURIRequest.extra().putLong("key_peerUin", uin);
        activityURIRequest.extra().putBoolean("key_need_show_unread_count", true);
        if (data != null) {
            activityURIRequest.extra().putAll(data);
        }
        QRoute.startUri(activityURIRequest);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOStarterApi
    public void navigateToAIOActivity(@NotNull Context context, int chatType, @NotNull String uid, @NotNull String nick, long uin, @Nullable Bundle data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Integer.valueOf(chatType), uid, nick, Long.valueOf(uin), data);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(nick, "nick");
        QLog.i(TAG, 1, "[navigateToAIOActivity]: uid is " + uid + ", nick is " + nick + ", chatType is " + chatType + ", uin is " + uin);
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, "/base/main/aio");
        activityURIRequest.extra().putInt("key_chat_type", chatType);
        activityURIRequest.extra().putString("key_peerId", uid);
        activityURIRequest.extra().putString("key_chat_name", nick);
        activityURIRequest.extra().putLong("key_peerUin", uin);
        if (data != null) {
            activityURIRequest.extra().putAll(data);
        }
        QRoute.startUri(activityURIRequest);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOStarterApi
    public void navigateToScaleAIO(@NotNull Context context, int chatType, @NotNull String uid, @NotNull String nick, @Nullable Bundle data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, Integer.valueOf(chatType), uid, nick, data);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(nick, "nick");
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, "/base/main/scaleaio");
        activityURIRequest.extra().putInt("key_chat_type", chatType);
        activityURIRequest.extra().putString("key_peerId", uid);
        activityURIRequest.extra().putString("key_chat_name", nick);
        activityURIRequest.extra().putBoolean("key_is_scale_chat", true);
        if (data != null) {
            activityURIRequest.extra().putAll(data);
        }
        QRoute.startUri(activityURIRequest);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOStarterApi
    public void navigateToAIOActivity(@NotNull Context context, int chatType, @NotNull String uid, @NotNull String nick, int activityFlag, long uin, @Nullable Bundle data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, Integer.valueOf(chatType), uid, nick, Integer.valueOf(activityFlag), Long.valueOf(uin), data);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(nick, "nick");
        QLog.i(TAG, 1, "[navigateToAIOActivity]: uid is " + uid + ", nick is " + nick + ", chatType is " + chatType + ", uin is " + uin);
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, "/base/main/aio");
        activityURIRequest.extra().putInt("key_chat_type", chatType);
        activityURIRequest.extra().putString("key_peerId", uid);
        activityURIRequest.extra().putString("key_chat_name", nick);
        activityURIRequest.extra().putLong("key_peerUin", uin);
        if (data != null) {
            activityURIRequest.extra().putAll(data);
        }
        activityURIRequest.setFlags(activityFlag);
        QRoute.startUri(activityURIRequest);
    }
}
