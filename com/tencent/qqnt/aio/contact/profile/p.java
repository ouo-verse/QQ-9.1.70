package com.tencent.qqnt.aio.contact.profile;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.profile.api.IRobotProfileCardApi;
import h44.OpenRobotProfileCardArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/contact/profile/p;", "Lcom/tencent/qqnt/aio/contact/profile/f;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class p implements f {
    static IPatchRedirector $redirector_;

    public p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.contact.profile.f
    public boolean a(@NotNull Context context, @NotNull AIOMsgItem msgItem) {
        QQAppInterface qQAppInterface;
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem.getMsgRecord().chatType != 2) {
            return false;
        }
        AppRuntime peekAppRuntime = BaseApplicationImpl.sApplication.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return true;
        }
        IRuntimeService runtimeService = qQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026ava, ProcessConstant.ALL)");
        ITroopRobotService iTroopRobotService = (ITroopRobotService) runtimeService;
        try {
            long j3 = msgItem.getMsgRecord().senderUin;
            String valueOf = String.valueOf(msgItem.getMsgRecord().peerUin);
            if (iTroopRobotService.isRobotUin(j3)) {
                ((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).openRobotProfileCard(new OpenRobotProfileCardArgs(context, String.valueOf(j3), valueOf, 10, 0, null, 48, null));
                return true;
            }
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopProfileInterceptor", 2, "parseLong error: messageRecord.senderuin = " + msgItem.getMsgRecord().senderUin);
            }
        }
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            com.tencent.mobileqq.profile.l.d(qQAppInterface, context, String.valueOf(msgItem.getMsgRecord().peerUin), String.valueOf(msgItem.getMsgRecord().senderUin), 0, 2000);
        }
        return true;
    }
}
