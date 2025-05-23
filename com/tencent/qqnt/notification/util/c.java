package com.tencent.qqnt.notification.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/notification/util/c;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "from", "to", "", "a", "<init>", "()V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f359911a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45686);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f359911a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull RecentContactInfo from, @NotNull RecentContactInfo to5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) from, (Object) to5);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to5, "to");
        to5.f359204id = from.f359204id;
        to5.contactId = from.contactId;
        to5.chatType = from.chatType;
        to5.senderUid = from.senderUid;
        to5.senderUin = from.senderUin;
        to5.peerUid = from.peerUid;
        to5.peerUin = from.peerUin;
        to5.msgTime = from.msgTime;
        to5.sendMemberName = from.sendMemberName;
        to5.sendNickName = from.sendNickName;
        to5.guildContactInfo = from.guildContactInfo;
        to5.peerName = from.peerName;
        to5.remark = from.remark;
        to5.avatarUrl = from.avatarUrl;
        to5.avatarPath = from.avatarPath;
        to5.abstractContent = from.abstractContent;
        to5.sendStatus = from.sendStatus;
        to5.topFlag = from.topFlag;
        to5.topFlagTime = from.topFlagTime;
        to5.draftFlag = from.draftFlag;
        to5.specialCareFlag = from.specialCareFlag;
        to5.sessionType = from.sessionType;
        to5.shieldFlag = from.shieldFlag;
        to5.atType = from.atType;
        to5.draft = from.draft;
        to5.hiddenFlag = from.hiddenFlag;
        to5.isMsgDisturb = from.isMsgDisturb;
        to5.nestedSortedContactList = from.nestedSortedContactList;
        to5.nestedChangedList = from.nestedChangedList;
        to5.unreadCnt = from.unreadCnt;
        to5.isBeat = from.isBeat;
        to5.isOnlineMsg = from.isOnlineMsg;
        to5.msgId = from.msgId;
        to5.notifiedType = from.notifiedType;
        to5.isBlock = from.isBlock;
        to5.listOfSpecificEventTypeInfosInMsgBox = from.listOfSpecificEventTypeInfosInMsgBox;
        to5.vasPersonalInfo = from.vasPersonalInfo;
        to5.vasMsgInfo = from.vasMsgInfo;
        to5.anonymousFlag = from.anonymousFlag;
        to5.extBuffer = from.extBuffer;
    }
}
