package com.tencent.qqnt.global.settings.api.impl;

import android.content.Context;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.nt.adapter.session.c;
import com.tencent.qqnt.global.settings.api.IGlobalSettingsApi;
import com.tencent.qqnt.global.settings.notification.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import su3.b;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\"\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/global/settings/api/impl/GlobalSettingsApiImpl;", "Lcom/tencent/qqnt/global/settings/api/IGlobalSettingsApi;", "", "chatType", "convertChatType", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "onEnterChat", "", "isNewMessageNotificationShow", "isAioTopNotificationShow", "needNotificationLight", "isGlobalShowPreview", "needLockScreenNotification", "isOpenNoClearNotification", "", "uin", "Lcom/tencent/qqnt/global/settings/notification/a;", "notificationExtInfo", "isSessionShowPreview", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class GlobalSettingsApiImpl implements IGlobalSettingsApi {
    static IPatchRedirector $redirector_;

    public GlobalSettingsApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int convertChatType(int chatType) {
        return c.c(chatType);
    }

    @Override // com.tencent.qqnt.global.settings.api.IGlobalSettingsApi
    public boolean isAioTopNotificationShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qqnt.global.settings.api.IGlobalSettingsApi
    public boolean isGlobalShowPreview() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return true;
        }
        String string = peekAppRuntime.getApp().getString(R.string.f173079h50);
        Intrinsics.checkNotNullExpressionValue(string, "app.app.getString(R.stri\u2026_QQMsgNotify_ShowContent)");
        return SettingCloneUtil.readValue((Context) peekAppRuntime.getApp(), peekAppRuntime.getCurrentUin(), string, AppConstants.QQSETTING_NOTIFY_SHOWCONTENT_KEY, true);
    }

    @Override // com.tencent.qqnt.global.settings.api.IGlobalSettingsApi
    public boolean isNewMessageNotificationShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return true;
        }
        return SettingCloneUtil.readValue((Context) peekAppRuntime.getApp(), peekAppRuntime.getCurrentUin(), (String) null, AppConstants.NEW_MSG_NOTIFICATION_KEY, true);
    }

    @Override // com.tencent.qqnt.global.settings.api.IGlobalSettingsApi
    public boolean isOpenNoClearNotification() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        return ((QQAppInterface) peekAppRuntime).isOpenNoClearNotification();
    }

    @Override // com.tencent.qqnt.global.settings.api.IGlobalSettingsApi
    public boolean isSessionShowPreview(long uin, int chatType, @Nullable a notificationExtInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, Long.valueOf(uin), Integer.valueOf(chatType), notificationExtInfo)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        return MessageNotificationSettingManager.l((QQAppInterface) peekAppRuntime).h(String.valueOf(uin), convertChatType(chatType), notificationExtInfo);
    }

    @Override // com.tencent.qqnt.global.settings.api.IGlobalSettingsApi
    public boolean needLockScreenNotification() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return true;
        }
        String string = peekAppRuntime.getApp().getString(R.string.f171097c62);
        Intrinsics.checkNotNullExpressionValue(string, "app.app.getString(R.string.lock_screen_msg)");
        return SettingCloneUtil.readValue((Context) peekAppRuntime.getApp(), peekAppRuntime.getCurrentUin(), string, AppConstants.QQSETTING_LOCKSCREENMSG_WHENEXIST_KEY, true);
    }

    @Override // com.tencent.qqnt.global.settings.api.IGlobalSettingsApi
    public boolean needNotificationLight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return true;
        }
        String string = peekAppRuntime.getApp().getString(R.string.h4s);
        Intrinsics.checkNotNullExpressionValue(string, "app.app.getString(R.stri\u2026QMsgNotify_BLNControlPro)");
        return SettingCloneUtil.readValue((Context) peekAppRuntime.getApp(), peekAppRuntime.getCurrentUin(), string, AppConstants.QQSETTING_NOTIFY_BLNCONTROL_KEY, true);
    }

    @Override // com.tencent.qqnt.global.settings.api.IGlobalSettingsApi
    public void onEnterChat(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aioContext);
            return;
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        SessionInfo sessionInfo = new SessionInfo();
        AIOParam g16 = aioContext.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        sessionInfo.f179555d = b.a(g16).f179555d;
        AIOParam g17 = aioContext.g();
        Intrinsics.checkNotNullExpressionValue(g17, "aioContext.aioParam");
        sessionInfo.f179557e = b.a(g17).f179557e;
        sessionInfo.f178172i0 = aioContext.g().r().c().j();
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.managers.TempMsgManager");
        ((TempMsgManager) manager).P(sessionInfo, null, aioContext);
    }
}
