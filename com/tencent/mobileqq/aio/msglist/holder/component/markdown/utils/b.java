package com.tencent.mobileqq.aio.msglist.holder.component.markdown.utils;

import android.graphics.drawable.Drawable;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.android.androidbypass.enhance.h;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J>\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/utils/b;", "", "Lcom/tencent/android/androidbypass/span/a;", TtmlNode.TAG_SPAN, "", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "mr", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "", "chatType", QQBrowserActivity.KEY_MSG_TYPE, "sendType", "subMsgType", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f191112a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61609);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f191112a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ MsgRecord b(b bVar, MsgRecord msgRecord, MsgElement msgElement, int i3, int i16, int i17, int i18, int i19, Object obj) {
        if ((i19 & 4) != 0) {
            i3 = msgRecord.chatType;
        }
        int i26 = i3;
        if ((i19 & 8) != 0) {
            i16 = msgRecord.msgType;
        }
        int i27 = i16;
        if ((i19 & 16) != 0) {
            i17 = msgRecord.sendType;
        }
        int i28 = i17;
        if ((i19 & 32) != 0) {
            i18 = msgRecord.subMsgType;
        }
        return bVar.a(msgRecord, msgElement, i26, i27, i28, i18);
    }

    @NotNull
    public final MsgRecord a(@NotNull MsgRecord mr5, @NotNull MsgElement msgElement, int chatType, int msgType, int sendType, int subMsgType) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MsgRecord) iPatchRedirector.redirect((short) 3, this, mr5, msgElement, Integer.valueOf(chatType), Integer.valueOf(msgType), Integer.valueOf(sendType), Integer.valueOf(subMsgType));
        }
        Intrinsics.checkNotNullParameter(mr5, "mr");
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(msgElement);
        return new MsgRecord(mr5.msgId, mr5.msgRandom, mr5.msgSeq, mr5.cntSeq, chatType, msgType, subMsgType, sendType, mr5.senderUid, mr5.peerUid, mr5.channelId, mr5.guildId, mr5.guildCode, mr5.fromUid, mr5.fromAppid, mr5.msgTime, mr5.msgMeta, 2, mr5.sendRemarkName, mr5.sendMemberName, mr5.sendNickName, mr5.guildName, mr5.channelName, arrayListOf, mr5.records, mr5.emojiLikesList, mr5.commentCnt, mr5.directMsgFlag, mr5.directMsgMembers, mr5.peerName, mr5.freqLimitInfo, mr5.editable, mr5.avatarMeta, mr5.avatarPendant, mr5.feedId, mr5.roleId, mr5.timeStamp, mr5.clientIdentityInfo, mr5.isImportMsg, mr5.atType, mr5.roleType, mr5.fromChannelRoleInfo, mr5.fromGuildRoleInfo, mr5.levelRoleInfo, mr5.recallTime, mr5.isOnlineMsg, mr5.generalFlags, mr5.clientSeq, mr5.fileGroupSize, mr5.foldingInfo, mr5.multiTransInfo, mr5.senderUin, mr5.peerUin, mr5.msgAttrs, mr5.anonymousExtInfo, mr5.nameType, mr5.avatarFlag, mr5.extInfoForUI, mr5.personalMedal, mr5.categoryManage, mr5.msgEventInfo);
    }

    @Nullable
    public final String c(@Nullable com.tencent.android.androidbypass.span.a span) {
        Drawable drawable;
        h.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) span);
        }
        if (span != null) {
            drawable = span.getDrawable();
        } else {
            drawable = null;
        }
        if (drawable instanceof h.a) {
            aVar = (h.a) drawable;
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return null;
        }
        return aVar.v();
    }
}
