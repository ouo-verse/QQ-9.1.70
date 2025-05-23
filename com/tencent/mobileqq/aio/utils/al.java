package com.tencent.mobileqq.aio.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqnt.aio.nick.api.INickNameApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0007\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\b\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\t\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\n\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u000b\u001a\u00020\u0003*\u00020\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "", "i", "", "g", "a", "b", "c", tl.h.F, "f", "d", "e", "aio_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class al {
    @NotNull
    public static final CharSequence a(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        CharSequence i3 = i(msgRecord);
        QRouteApi api = QRoute.api(INickNameApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(INickNameApi::class.java)");
        return INickNameApi.a.a((INickNameApi) api, i3, false, 2, null);
    }

    public static final boolean b(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.anonymousExtInfo != null) {
            return true;
        }
        return false;
    }

    public static final boolean c(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType == 11 && msgRecord.subMsgType == 7) {
            return true;
        }
        return false;
    }

    public static final boolean d(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType == 1) {
            return true;
        }
        return false;
    }

    public static final boolean e(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType != 5) {
            return false;
        }
        Iterator<MsgElement> it = msgRecord.elements.iterator();
        while (it.hasNext()) {
            GrayTipElement grayTipElement = it.next().grayTipElement;
            if (grayTipElement != null && grayTipElement.revokeElement != null) {
                return true;
            }
        }
        return false;
    }

    public static final boolean f(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (!d(msgRecord) && !e(msgRecord)) {
            return false;
        }
        return true;
    }

    public static final boolean g(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        int i3 = msgRecord.sendType;
        if (i3 == 1 || i3 == 2 || i3 == 4 || TextUtils.equals(MobileQQ.sMobileQQ.waitAppRuntime().getCurrentUin(), msgRecord.senderUid) || TextUtils.equals(MobileQQ.sMobileQQ.waitAppRuntime().getCurrentUid(), msgRecord.senderUid)) {
            return true;
        }
        return false;
    }

    public static final boolean h(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType == 7) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final CharSequence i(@NotNull MsgRecord msgRecord) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (b(msgRecord)) {
            String str = msgRecord.anonymousExtInfo.anonymousNick;
            Intrinsics.checkNotNullExpressionValue(str, "anonymousExtInfo.anonymousNick");
            return str;
        }
        String str2 = "";
        boolean z26 = true;
        if (aq.f194114a.a()) {
            String sendRemarkName = msgRecord.sendRemarkName;
            Intrinsics.checkNotNullExpressionValue(sendRemarkName, "sendRemarkName");
            if (sendRemarkName.length() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                String str3 = msgRecord.sendRemarkName;
                Intrinsics.checkNotNullExpressionValue(str3, "{\n                sendRemarkName\n            }");
                return str3;
            }
            String sendMemberName = msgRecord.sendMemberName;
            Intrinsics.checkNotNullExpressionValue(sendMemberName, "sendMemberName");
            if (sendMemberName.length() > 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z19) {
                String str4 = msgRecord.sendMemberName;
                Intrinsics.checkNotNullExpressionValue(str4, "{\n                sendMemberName\n            }");
                return str4;
            }
            String sendNickName = msgRecord.sendNickName;
            Intrinsics.checkNotNullExpressionValue(sendNickName, "sendNickName");
            if (sendNickName.length() <= 0) {
                z26 = false;
            }
            if (z26) {
                String str5 = msgRecord.sendNickName;
                Intrinsics.checkNotNullExpressionValue(str5, "{\n                sendNickName\n            }");
                return str5;
            }
            long j3 = msgRecord.senderUin;
            if (j3 != 0) {
                str2 = String.valueOf(j3);
            }
            return str2;
        }
        String sendMemberName2 = msgRecord.sendMemberName;
        Intrinsics.checkNotNullExpressionValue(sendMemberName2, "sendMemberName");
        if (sendMemberName2.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String str6 = msgRecord.sendMemberName;
            Intrinsics.checkNotNullExpressionValue(str6, "{\n                sendMemberName\n            }");
            return str6;
        }
        String sendRemarkName2 = msgRecord.sendRemarkName;
        Intrinsics.checkNotNullExpressionValue(sendRemarkName2, "sendRemarkName");
        if (sendRemarkName2.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            String str7 = msgRecord.sendRemarkName;
            Intrinsics.checkNotNullExpressionValue(str7, "{\n                sendRemarkName\n            }");
            return str7;
        }
        String sendNickName2 = msgRecord.sendNickName;
        Intrinsics.checkNotNullExpressionValue(sendNickName2, "sendNickName");
        if (sendNickName2.length() <= 0) {
            z26 = false;
        }
        if (z26) {
            String str8 = msgRecord.sendNickName;
            Intrinsics.checkNotNullExpressionValue(str8, "{\n                sendNickName\n            }");
            return str8;
        }
        long j16 = msgRecord.senderUin;
        if (j16 != 0) {
            str2 = String.valueOf(j16);
        }
        return str2;
    }
}
