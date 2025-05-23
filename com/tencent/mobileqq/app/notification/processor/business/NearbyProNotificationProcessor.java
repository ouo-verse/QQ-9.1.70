package com.tencent.mobileqq.app.notification.processor.business;

import android.content.Intent;
import com.tencent.mobileqq.nearbypro.api.INearbyProChatApi;
import com.tencent.mobileqq.nearbypro.utils.api.INearbyProToolApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@KeepClassConstructor
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 \u00122\u00020\u0001:\u0001\u000bB\u0019\b\u0004\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/app/notification/processor/business/NearbyProNotificationProcessor;", "Lcom/tencent/qqnt/notification/struct/a;", "", "r", "brief", "Lcom/tencent/qqnt/global/settings/notification/a;", "notificationExtInfo", tl.h.F, "Landroid/content/Intent;", "k", "", "a", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "msgRecord", "<init>", "(Lmqq/app/AppRuntime;Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;)V", "e", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class NearbyProNotificationProcessor extends com.tencent.qqnt.notification.struct.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/app/notification/processor/business/NearbyProNotificationProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.notification.processor.business.NearbyProNotificationProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54412);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected NearbyProNotificationProcessor(@NotNull AppRuntime app, @NotNull RecentContactInfo msgRecord) {
        super(app, msgRecord);
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app, (Object) msgRecord);
        }
    }

    @Override // com.tencent.qqnt.notification.struct.c
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return -113;
    }

    @Override // com.tencent.qqnt.notification.struct.BaseUinTypeProcessor
    @NotNull
    public String h(@NotNull String brief, @Nullable com.tencent.qqnt.global.settings.notification.a notificationExtInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) brief, (Object) notificationExtInfo);
        }
        Intrinsics.checkNotNullParameter(brief, "brief");
        return ((INearbyProChatApi) QRoute.api(INearbyProChatApi.class)).getNotificationContent();
    }

    @Override // com.tencent.qqnt.notification.struct.BaseUinTypeProcessor
    @Nullable
    public Intent k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Intent) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        BaseApplication baseApplication = BaseApplication.context;
        if (baseApplication == null) {
            QLog.e("NearbyProNotificationProcessor", 1, "prepareIntent context == null error!");
            return null;
        }
        INearbyProToolApi iNearbyProToolApi = (INearbyProToolApi) QRoute.api(INearbyProToolApi.class);
        String str = d().peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord.peerUid");
        return iNearbyProToolApi.getNotificationIntent(baseApplication, str);
    }

    @Override // com.tencent.qqnt.notification.struct.BaseUinTypeProcessor
    @NotNull
    public String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return ((INearbyProChatApi) QRoute.api(INearbyProChatApi.class)).getNotificationTitle();
    }
}
