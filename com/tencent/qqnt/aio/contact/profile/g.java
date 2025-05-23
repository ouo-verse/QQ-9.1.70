package com.tencent.qqnt.aio.contact.profile;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr;
import com.tencent.mobileqq.matchfriend.bean.QQStrangerUserInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/contact/profile/g;", "Lcom/tencent/qqnt/aio/contact/profile/f;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "Lcom/tencent/mobileqq/matchfriend/bean/QQStrangerUserInfo;", "selfInfo", "", "b", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class g implements f {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b(QQAppInterface app, MsgRecord msg2, QQStrangerUserInfo selfInfo) {
        if (selfInfo == null) {
            return false;
        }
        if (!Intrinsics.areEqual(String.valueOf(msg2.senderUin), app.getCurrentUin()) && !Intrinsics.areEqual(msg2.senderUid, app.getCurrentUid()) && !Intrinsics.areEqual(msg2.senderUid, String.valueOf(selfInfo.tinyId))) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x007a, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    @Override // com.tencent.qqnt.aio.contact.profile.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(@NotNull Context context, @NotNull AIOMsgItem msgItem) {
        QQAppInterface qQAppInterface;
        long j3;
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        MsgRecord msgRecord = msgItem.getMsgRecord();
        AppRuntime peekAppRuntime = BaseApplicationImpl.sApplication.peekAppRuntime();
        Long l3 = null;
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null || msgRecord.chatType != 104) {
            return false;
        }
        if (msgRecord.peerUid.equals("256111111111111111") || Intrinsics.areEqual(msgRecord.peerUid, "144115227025205148")) {
            return true;
        }
        QQStrangerUserInfo selfUserInfo = ((IQQStrangerUserInfoMgr) qQAppInterface.getRuntimeService(IQQStrangerUserInfoMgr.class, "all")).getSelfUserInfo();
        if (b(qQAppInterface, msgRecord, selfUserInfo)) {
            Intrinsics.checkNotNull(selfUserInfo);
            j3 = selfUserInfo.tinyId;
        } else {
            String str = msgRecord.senderUid;
            if (str != null && longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                String str2 = msgRecord.peerUid;
                if (str2 != null) {
                    l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(str2);
                }
                if (l3 != null) {
                    j3 = l3.longValue();
                } else {
                    j3 = 0;
                }
            }
        }
        ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterProfileCard(qQAppInterface, context, j3, 0, 2);
        return true;
    }
}
