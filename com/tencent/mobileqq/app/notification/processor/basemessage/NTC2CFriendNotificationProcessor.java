package com.tencent.mobileqq.app.notification.processor.basemessage;

import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.listentogether.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qqnt.global.settings.api.IGlobalSettingsApi;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.SpecificEventTypeInfoInMsgBox;
import com.tencent.qqnt.notification.NotificationFacade;
import com.tencent.qqnt.notification.logic.INotifyCountService;
import com.tencent.qqnt.notification.struct.b;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@KeepClassConstructor
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0019\b\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/app/notification/processor/basemessage/NTC2CFriendNotificationProcessor;", "Lcom/tencent/qqnt/notification/struct/b;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "u", "t", "Landroid/graphics/Bitmap;", "j", "", "r", "brief", "Lcom/tencent/qqnt/global/settings/notification/a;", "notificationExtInfo", h.F, "", "a", "Landroid/content/Intent;", "k", "Lmqq/app/AppRuntime;", "app", "msgRecord", "<init>", "(Lmqq/app/AppRuntime;Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class NTC2CFriendNotificationProcessor extends b {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected NTC2CFriendNotificationProcessor(@NotNull AppRuntime app, @NotNull RecentContactInfo msgRecord) {
        super(app, msgRecord);
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app, (Object) msgRecord);
        }
    }

    private final boolean t(RecentContactInfo item) {
        boolean z16;
        ArrayList<SpecificEventTypeInfoInMsgBox> arrayList = item.listOfSpecificEventTypeInfosInMsgBox;
        Object obj = null;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((SpecificEventTypeInfoInMsgBox) next).eventTypeInMsgBox == 1006) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    obj = next;
                    break;
                }
            }
            obj = (SpecificEventTypeInfoInMsgBox) obj;
        }
        if (obj != null) {
            return true;
        }
        return false;
    }

    private final boolean u(RecentContactInfo item) {
        if (item.specialCareFlag == 1 || t(item)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.notification.struct.c
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return e(d());
    }

    @Override // com.tencent.qqnt.notification.struct.BaseUinTypeProcessor
    @NotNull
    public String h(@NotNull String brief, @Nullable com.tencent.qqnt.global.settings.notification.a notificationExtInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) brief, (Object) notificationExtInfo);
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
        return NotificationFacade.INSTANCE.a().f(d(), false);
    }

    @Override // com.tencent.qqnt.notification.struct.BaseUinTypeProcessor
    @Nullable
    public Intent k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Intent) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        Intent k3 = super.k();
        g.c(d(), k3);
        if (k3 != null) {
            k3.putExtra(AppConstants.Key.KEY_NOTIFICATION_MSG_ID, d().msgId);
        }
        return k3;
    }

    @Override // com.tencent.qqnt.notification.struct.BaseUinTypeProcessor
    @NotNull
    public String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String r16 = super.r();
        if (u(d())) {
            return HardCodeUtil.qqStr(R.string.osx) + r16;
        }
        return r16;
    }
}
