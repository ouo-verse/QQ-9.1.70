package com.tencent.mobileqq.reminder.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.reminder.api.IQQReminderBlessingApi;
import com.tencent.mobileqq.reminder.handler.QQReminderBirthdayBlessingHandler;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J*\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\tH\u0016R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/reminder/api/impl/QQReminderBlessingApiImpl;", "Lcom/tencent/mobileqq/reminder/api/IQQReminderBlessingApi;", "", "", "uins", "", "source", "Lcm2/b;", "callback", "", "sendBlessingTimedMessage", "key", "", "removeCallback", "Lcom/tencent/mobileqq/reminder/handler/QQReminderBirthdayBlessingHandler;", "getBirthdayBlessingHandler", "()Lcom/tencent/mobileqq/reminder/handler/QQReminderBirthdayBlessingHandler;", "birthdayBlessingHandler", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class QQReminderBlessingApiImpl implements IQQReminderBlessingApi {
    static IPatchRedirector $redirector_;

    public QQReminderBlessingApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final QQReminderBirthdayBlessingHandler getBirthdayBlessingHandler() {
        AppInterface appInterface;
        BusinessHandler businessHandler;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            businessHandler = appInterface.getBusinessHandler(QQReminderBirthdayBlessingHandler.class.getName());
        } else {
            businessHandler = null;
        }
        if (!(businessHandler instanceof QQReminderBirthdayBlessingHandler)) {
            return null;
        }
        return (QQReminderBirthdayBlessingHandler) businessHandler;
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderBlessingApi
    public void removeCallback(@NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) key);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        QQReminderBirthdayBlessingHandler birthdayBlessingHandler = getBirthdayBlessingHandler();
        if (birthdayBlessingHandler != null) {
            birthdayBlessingHandler.I2(key);
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderBlessingApi
    @Nullable
    public String sendBlessingTimedMessage(@NotNull List<Long> uins, int source, @Nullable cm2.b callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, this, uins, Integer.valueOf(source), callback);
        }
        Intrinsics.checkNotNullParameter(uins, "uins");
        QQReminderBirthdayBlessingHandler birthdayBlessingHandler = getBirthdayBlessingHandler();
        if (birthdayBlessingHandler != null) {
            return birthdayBlessingHandler.K2(uins, source, callback);
        }
        return null;
    }
}
