package com.tencent.qqnt.notification.processor.basemessage;

import android.graphics.Bitmap;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qqnt.global.settings.api.IGlobalSettingsApi;
import com.tencent.qqnt.global.settings.notification.a;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.notification.NotificationFacade;
import com.tencent.qqnt.notification.logic.INotifyCountService;
import com.tencent.qqnt.notification.logic.INotifySessionService;
import com.tencent.qqnt.notification.struct.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@KeepClassConstructor
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0019\b\u0004\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/notification/processor/basemessage/C2CFriendNotificationProcessor;", "Lcom/tencent/qqnt/notification/struct/b;", "Landroid/graphics/Bitmap;", "j", "", "brief", "Lcom/tencent/qqnt/global/settings/notification/a;", "notificationExtInfo", h.F, "", "a", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "msgRecord", "<init>", "(Lmqq/app/AppRuntime;Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;)V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class C2CFriendNotificationProcessor extends b {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected C2CFriendNotificationProcessor(@NotNull AppRuntime appRuntime, @NotNull RecentContactInfo msgRecord) {
        super(appRuntime, msgRecord);
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) msgRecord);
        }
    }

    @Override // com.tencent.qqnt.notification.struct.c
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return e(d());
    }

    @Override // com.tencent.qqnt.notification.struct.BaseUinTypeProcessor
    @NotNull
    public String h(@NotNull String brief, @Nullable a notificationExtInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) brief, (Object) notificationExtInfo);
        }
        Intrinsics.checkNotNullParameter(brief, "brief");
        if (!((IGlobalSettingsApi) QRoute.api(IGlobalSettingsApi.class)).isSessionShowPreview(d().peerUin, d().chatType, notificationExtInfo)) {
            String string = c().getApp().getString(R.string.f172180o32);
            Intrinsics.checkNotNullExpressionValue(string, "appRuntime.app.getString\u2026.qqstr_messagen_d049f4a8)");
            String string2 = c().getApp().getString(R.string.f172181o33);
            Intrinsics.checkNotNullExpressionValue(string2, "appRuntime.app.getString\u2026.qqstr_messagen_ed6e14aa)");
            IRuntimeService runtimeService = c().getRuntimeService(INotifyCountService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
            return string + ((INotifyCountService) runtimeService).getCountBySession(d().peerUin, d().chatType) + string2;
        }
        return super.h(brief, notificationExtInfo);
    }

    @Override // com.tencent.qqnt.notification.struct.BaseUinTypeProcessor
    @Nullable
    public Bitmap j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        IRuntimeService runtimeService = c().getRuntimeService(INotifyCountService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        int a16 = INotifyCountService.a.a((INotifyCountService) runtimeService, false, 1, null);
        IRuntimeService runtimeService2 = c().getRuntimeService(INotifySessionService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService2, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        INotifySessionService iNotifySessionService = (INotifySessionService) runtimeService2;
        if ((a16 > 1 && iNotifySessionService.isSeparateSessionMessage(d())) || a16 == 1) {
            return NotificationFacade.INSTANCE.a().f(d(), false);
        }
        return super.j();
    }
}
