package com.tencent.qqnt.aio.contact.profile;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearbypro.api.INearbyProAssistantAdapterApi;
import com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter;
import com.tencent.mobileqq.nearbypro.utils.s;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/contact/profile/h;", "Lcom/tencent/qqnt/aio/contact/profile/f;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class h implements f {
    static IPatchRedirector $redirector_;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.contact.profile.f
    public boolean a(@NotNull Context context, @NotNull AIOMsgItem msgItem) {
        QQAppInterface qQAppInterface;
        long parseLong;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        MsgRecord msgRecord = msgItem.getMsgRecord();
        if (msgRecord.chatType != 119) {
            return false;
        }
        AppRuntime peekAppRuntime = BaseApplicationImpl.sApplication.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return false;
        }
        if (Intrinsics.areEqual(String.valueOf(msgRecord.senderUin), qQAppInterface.getCurrentUin())) {
            parseLong = s.a();
        } else {
            String str = msgRecord.peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "msg.peerUid");
            parseLong = Long.parseLong(str);
        }
        long j3 = parseLong;
        if (((INearbyProAssistantAdapterApi) QRoute.api(INearbyProAssistantAdapterApi.class)).isLittleAssistant(msgRecord.chatType, String.valueOf(j3))) {
            return true;
        }
        QRouteApi api = QRoute.api(INearbyProPageRouter.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(INearbyProPageRouter::class.java)");
        INearbyProPageRouter.a.b((INearbyProPageRouter) api, context, j3, false, 17, 4, null);
        return true;
    }
}
