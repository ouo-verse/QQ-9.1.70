package com.tencent.qqnt.notification.processor.basemessage;

import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qqnt.global.settings.api.IGlobalSettingsApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgBoxNecessaryMsgInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.SpecificEventTypeInfoInMsgBox;
import com.tencent.qqnt.notification.NotificationFacade;
import com.tencent.qqnt.notification.logic.INotifyCountService;
import com.tencent.qqnt.notification.logic.INotifySessionService;
import com.tencent.qqnt.notification.struct.b;
import ex3.a;
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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0019\b\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/notification/processor/basemessage/TroopNotificationProcessor;", "Lcom/tencent/qqnt/notification/struct/b;", "", "t", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "v", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "", "eventType", HippyTKDListViewAdapter.X, "w", "Landroid/graphics/Bitmap;", "j", "brief", "Lcom/tencent/qqnt/global/settings/notification/a;", "notificationExtInfo", h.F, "a", "Lmqq/app/AppRuntime;", "appRuntime", "msgRecord", "<init>", "(Lmqq/app/AppRuntime;Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;)V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class TroopNotificationProcessor extends b {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected TroopNotificationProcessor(@NotNull AppRuntime appRuntime, @NotNull RecentContactInfo msgRecord) {
        super(appRuntime, msgRecord);
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) msgRecord);
        }
    }

    private final String t() {
        String str;
        if (w(d(), 1004)) {
            str = "[@\u6211\u7684\u7ea2\u5305]";
        } else {
            str = "";
        }
        if (w(d(), 1007)) {
            str = "[\u6709\u7ea2\u5305]";
        }
        if (v(d())) {
            str = "[\u6709\u4eba@\u6211]";
        }
        if (u(d())) {
            str = "[@\u5168\u4f53\u6210\u5458]";
        }
        if (w(d(), 2003)) {
            str = "[\u6709\u65b0\u4f5c\u4e1a]";
        }
        if (w(d(), 1002)) {
            str = "[\u6709\u4eba\u56de\u590d\u6211]";
        }
        if (w(d(), 1005)) {
            return "[@\u6211\u7684\u793c\u7269]";
        }
        return str;
    }

    private final boolean u(RecentContactInfo item) {
        if ((item.atType & 1) != 0) {
            return true;
        }
        return false;
    }

    private final boolean v(RecentContactInfo item) {
        if ((item.atType & 4) != 0) {
            return true;
        }
        return false;
    }

    private final boolean w(RecentContactInfo item, int eventType) {
        SpecificEventTypeInfoInMsgBox specificEventTypeInfoInMsgBox;
        ArrayList<MsgBoxNecessaryMsgInfo> arrayList;
        boolean z16;
        Object obj;
        boolean z17;
        ArrayList<SpecificEventTypeInfoInMsgBox> arrayList2 = item.listOfSpecificEventTypeInfosInMsgBox;
        Object obj2 = null;
        if (arrayList2 != null) {
            Iterator<T> it = arrayList2.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((SpecificEventTypeInfoInMsgBox) obj).eventTypeInMsgBox == eventType) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            specificEventTypeInfoInMsgBox = (SpecificEventTypeInfoInMsgBox) obj;
        } else {
            specificEventTypeInfoInMsgBox = null;
        }
        if (specificEventTypeInfoInMsgBox != null && (arrayList = specificEventTypeInfoInMsgBox.msgInfos) != null) {
            Iterator<T> it5 = arrayList.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next = it5.next();
                if (((MsgBoxNecessaryMsgInfo) next).msgSeq == a.h(item)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    obj2 = next;
                    break;
                }
            }
            obj2 = (MsgBoxNecessaryMsgInfo) obj2;
        }
        if (obj2 != null) {
            return true;
        }
        return false;
    }

    private final boolean x(RecentContactInfo item, int eventType) {
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
                if (((SpecificEventTypeInfoInMsgBox) next).eventTypeInMsgBox == eventType) {
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

    private final boolean y(RecentContactInfo item) {
        IRuntimeService runtimeService = c().getRuntimeService(INotifySessionService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        INotifySessionService iNotifySessionService = (INotifySessionService) runtimeService;
        boolean w3 = w(item, 2006);
        if (w3) {
            iNotifySessionService.setSessionNeedPrefix(d().peerUin, 1);
        }
        boolean x16 = x(item, 2006);
        boolean sessionNeedPrefix = iNotifySessionService.getSessionNeedPrefix(d().peerUin, 2);
        if (w3) {
            return true;
        }
        if (x16 && sessionNeedPrefix) {
            return true;
        }
        return false;
    }

    private final boolean z(RecentContactInfo item) {
        IRuntimeService runtimeService = c().getRuntimeService(INotifySessionService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        INotifySessionService iNotifySessionService = (INotifySessionService) runtimeService;
        boolean w3 = w(item, 1006);
        if (w3) {
            iNotifySessionService.setSessionNeedPrefix(d().peerUin, 1);
        }
        boolean x16 = x(item, 1006);
        boolean sessionNeedPrefix = iNotifySessionService.getSessionNeedPrefix(d().peerUin, 1);
        if (w3) {
            return true;
        }
        if (x16 && sessionNeedPrefix) {
            return true;
        }
        return false;
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
    public String h(@NotNull String brief, @Nullable com.tencent.qqnt.global.settings.notification.a notificationExtInfo) {
        boolean z16;
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
        String t16 = t();
        String str = d().sendMemberName;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = d().sendNickName;
        }
        String str2 = t16 + ((Object) str) + MsgSummary.STR_COLON + brief;
        if (z(d())) {
            return "[\u7279\u522b\u5173\u5fc3]" + str2;
        }
        if (y(d())) {
            return "[\u5173\u952e\u8bcd\u63d0\u9192]" + str2;
        }
        return str2;
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
        boolean z16 = false;
        if (INotifyCountService.a.a((INotifyCountService) runtimeService, false, 1, null) > 1) {
            z16 = true;
        }
        IRuntimeService runtimeService2 = c().getRuntimeService(INotifySessionService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService2, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        boolean isSeparateSessionMessage = ((INotifySessionService) runtimeService2).isSeparateSessionMessage(d());
        if (z16 && isSeparateSessionMessage) {
            return NotificationFacade.INSTANCE.a().i(d());
        }
        return super.j();
    }
}
