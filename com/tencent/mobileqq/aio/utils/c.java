package com.tencent.mobileqq.aio.utils;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqnt.aio.nick.api.INickNameApi;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a\f\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0004\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "", "a", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "d", "aio_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c {
    @NotNull
    public static final CharSequence a(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        CharSequence c16 = c(aIOMsgItem);
        QRouteApi api = QRoute.api(INickNameApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(INickNameApi::class.java)");
        return INickNameApi.a.a((INickNameApi) api, c16, false, 2, null);
    }

    @Nullable
    public static final String b(@NotNull MemberInfo memberInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(memberInfo, "<this>");
        String cardName = memberInfo.cardName;
        Intrinsics.checkNotNullExpressionValue(cardName, "cardName");
        boolean z17 = true;
        if (cardName.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return memberInfo.cardName;
        }
        String nick = memberInfo.nick;
        Intrinsics.checkNotNullExpressionValue(nick, "nick");
        if (nick.length() <= 0) {
            z17 = false;
        }
        if (z17) {
            return memberInfo.nick;
        }
        return null;
    }

    private static final CharSequence c(AIOMsgItem aIOMsgItem) {
        String str;
        MemberInfo K = aIOMsgItem.K();
        if (K != null) {
            str = b(K);
        } else {
            str = null;
        }
        if (str == null) {
            return d(aIOMsgItem.getMsgRecord());
        }
        return str;
    }

    @NotNull
    public static final CharSequence d(@NotNull MsgRecord msgRecord) {
        boolean z16;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (al.b(msgRecord)) {
            String str = msgRecord.anonymousExtInfo.anonymousNick;
            Intrinsics.checkNotNullExpressionValue(str, "anonymousExtInfo.anonymousNick");
            return str;
        }
        String sendMemberName = msgRecord.sendMemberName;
        Intrinsics.checkNotNullExpressionValue(sendMemberName, "sendMemberName");
        boolean z17 = true;
        if (sendMemberName.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String str2 = msgRecord.sendMemberName;
            Intrinsics.checkNotNullExpressionValue(str2, "{\n            sendMemberName\n        }");
            return str2;
        }
        String sendNickName = msgRecord.sendNickName;
        Intrinsics.checkNotNullExpressionValue(sendNickName, "sendNickName");
        if (sendNickName.length() <= 0) {
            z17 = false;
        }
        if (z17) {
            String str3 = msgRecord.sendNickName;
            Intrinsics.checkNotNullExpressionValue(str3, "{\n            sendNickName\n        }");
            return str3;
        }
        long j3 = msgRecord.senderUin;
        if (j3 == 0) {
            return "";
        }
        return String.valueOf(j3);
    }
}
