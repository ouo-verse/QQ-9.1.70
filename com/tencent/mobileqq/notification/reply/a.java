package com.tencent.mobileqq.notification.reply;

import android.os.Build;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0001\u0003B-\b\u0000\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/notification/reply/a;", "Lcom/tencent/freesia/IConfigData;", "", "a", "", "chatType", "b", "", "toString", "d", "I", "minApiLevel", "", "Lcom/tencent/mobileqq/notification/reply/b;", "e", "Ljava/util/List;", "deviceBlackList", "f", "chatTypeWhiteList", "<init>", "(ILjava/util/List;Ljava/util/List;)V", h.F, "qq_notification_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class a implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int minApiLevel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<b> deviceBlackList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> chatTypeWhiteList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000f\u0010\u0007\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/notification/reply/a$a;", "", "", "chatType", "", "b", "Lcom/tencent/mobileqq/notification/reply/a;", "a", "()Lcom/tencent/mobileqq/notification/reply/a;", "", "CONFIG_GROUP", "Ljava/lang/String;", "INVALID_API_LEVEL", "I", "TAG", "<init>", "()V", "qq_notification_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.notification.reply.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes8.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final a a() {
            List emptyList;
            List emptyList2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                return new a(0, emptyList, emptyList2);
            }
            return (a) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        public final boolean b(int chatType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, chatType)).booleanValue();
            }
            a aVar = (a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("notification_msg_reply_config");
            if (aVar == null) {
                return false;
            }
            return aVar.b(chatType);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24456);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(int i3, @NotNull List<b> deviceBlackList, @NotNull List<Integer> chatTypeWhiteList) {
        Intrinsics.checkNotNullParameter(deviceBlackList, "deviceBlackList");
        Intrinsics.checkNotNullParameter(chatTypeWhiteList, "chatTypeWhiteList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), deviceBlackList, chatTypeWhiteList);
            return;
        }
        this.minApiLevel = i3;
        this.deviceBlackList = deviceBlackList;
        this.chatTypeWhiteList = chatTypeWhiteList;
    }

    private final boolean a() {
        if (this.minApiLevel != 0) {
            return true;
        }
        return false;
    }

    public final boolean b(int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, chatType)).booleanValue();
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 24) {
            QLog.i("MsgReply.Config", 1, "[isDeviceMatched] api level is not matched, version: " + i3);
            return false;
        }
        if (!a()) {
            QLog.i("MsgReply.Config", 1, "[isDeviceMatched] config is not valid");
            return false;
        }
        if (i3 < this.minApiLevel) {
            QLog.i("MsgReply.Config", 1, "[isDeviceMatched] api level lower than minimum requirement, version: " + i3);
            return false;
        }
        if (!this.chatTypeWhiteList.contains(Integer.valueOf(chatType))) {
            QLog.i("MsgReply.Config", 1, "[isDeviceMatched] chatType is not in white list, chatType=" + chatType);
            return false;
        }
        String MODEL = DeviceInfoMonitor.getModel();
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        String lowerCase = MODEL.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        String lowerCase2 = MANUFACTURER.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
        for (b bVar : this.deviceBlackList) {
            if (bVar.a(lowerCase2, lowerCase, i3)) {
                QLog.i("MsgReply.Config", 1, "[isDeviceMatched] device is in black list, model=" + lowerCase + " apiLevel=" + i3 + " manufacturer=" + lowerCase2 + " black=" + bVar);
                return false;
            }
        }
        return true;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "MsgReplyConfig(minApiLevel=" + this.minApiLevel + ",deviceBlackList=" + this.deviceBlackList + ",chatTypeWhiteList=" + this.chatTypeWhiteList + ")";
    }
}
