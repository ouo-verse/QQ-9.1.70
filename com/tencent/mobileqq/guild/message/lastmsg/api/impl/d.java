package com.tencent.mobileqq.guild.message.lastmsg.api.impl;

import com.tencent.mobileqq.guild.message.lastmsg.LastMessage;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qqnt.kernelpublic.nativeinterface.CalendarElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ju1.ScheduleExtra;
import ju1.a;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/message/lastmsg/api/impl/d;", "", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MsgAbstract;", "msgAbstract", "Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;", "b", "c", "Lju1/a;", "e", "", "status", "Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage$SendState;", h.F, "", "d", "", "g", "f", "from", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f230639a = new d();

    d() {
    }

    private final LastMessage b(MsgAbstract msgAbstract) {
        String str = msgAbstract.peer.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "msgAbstract.peer.guildId");
        String str2 = msgAbstract.peer.peerUid;
        Intrinsics.checkNotNullExpressionValue(str2, "msgAbstract.peer.peerUid");
        return new LastMessage(str, str2, 0, 0, "", "", "", LastMessage.SendState.SEND_SUCCESS, 0L, a.C10614a.f410956a);
    }

    private final LastMessage c(MsgAbstract msgAbstract) {
        Object first;
        Object first2;
        String str = msgAbstract.peer.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "msgAbstract.peer.guildId");
        String str2 = msgAbstract.peer.peerUid;
        Intrinsics.checkNotNullExpressionValue(str2, "msgAbstract.peer.peerUid");
        ArrayList<MsgAbstractElement> arrayList = msgAbstract.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgAbstract.elements");
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
        int i3 = ((MsgAbstractElement) first).elementType;
        ArrayList<MsgAbstractElement> arrayList2 = msgAbstract.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "msgAbstract.elements");
        first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList2);
        return new LastMessage(str, str2, i3, ((MsgAbstractElement) first2).elementSubType, f(msgAbstract), g(msgAbstract), d(msgAbstract), h(msgAbstract.sendStatus), msgAbstract.abstractTime, e(msgAbstract));
    }

    @JvmStatic
    @NotNull
    public static final CharSequence d(@NotNull MsgAbstract msgAbstract) {
        String selfTinyId;
        boolean z16;
        Intrinsics.checkNotNullParameter(msgAbstract, "msgAbstract");
        if (at.c()) {
            selfTinyId = ((IGPSService) ch.R0(IGPSService.class)).getSelfTinyId();
        } else {
            selfTinyId = "";
        }
        iu1.b bVar = iu1.b.f408754a;
        Intrinsics.checkNotNullExpressionValue(selfTinyId, "selfTinyId");
        CharSequence b16 = bVar.b(msgAbstract, selfTinyId);
        if (b16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            String str = "getContent is empty: " + msgAbstract;
            if (str instanceof String) {
                bVar2.a().add(str);
            }
            Iterator<T> it = bVar2.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildLastMsgUtils", 1, (String) it.next(), null);
            }
        }
        return b16;
    }

    private final ju1.a e(MsgAbstract msgAbstract) {
        Object first;
        CalendarElement calendarElement;
        ArrayList<MsgAbstractElement> arrayList = msgAbstract.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgAbstract.elements");
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
        MsgAbstractElement msgAbstractElement = (MsgAbstractElement) first;
        if (msgAbstractElement.elementType == 19 && (calendarElement = msgAbstractElement.calendarElement) != null) {
            Intrinsics.checkNotNullExpressionValue(calendarElement, "msg.calendarElement");
            Integer num = msgAbstractElement.elementSubType;
            Intrinsics.checkNotNullExpressionValue(num, "msg.elementSubType");
            return new ScheduleExtra(calendarElement, num.intValue());
        }
        return a.C10614a.f410956a;
    }

    private final String f(MsgAbstract msgAbstract) {
        Object first;
        Object first2;
        Object first3;
        Long l3;
        Object first4;
        if (msgAbstract.elements.isEmpty()) {
            return "";
        }
        ArrayList<MsgAbstractElement> arrayList = msgAbstract.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgAbstract.elements");
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
        if (((MsgAbstractElement) first).elementType == 8) {
            ArrayList<MsgAbstractElement> arrayList2 = msgAbstract.elements;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "msgAbstract.elements");
            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList2);
            Integer num = ((MsgAbstractElement) first2).elementSubType;
            if (num != null && num.intValue() == 6) {
                ArrayList<MsgAbstractElement> arrayList3 = msgAbstract.elements;
                Intrinsics.checkNotNullExpressionValue(arrayList3, "msgAbstract.elements");
                first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList3);
                MsgAbstractElement msgAbstractElement = (MsgAbstractElement) first3;
                if (msgAbstractElement == null || (l3 = msgAbstractElement.tinyId) == null) {
                    return "";
                }
                l3.longValue();
                ArrayList<MsgAbstractElement> arrayList4 = msgAbstract.elements;
                Intrinsics.checkNotNullExpressionValue(arrayList4, "msgAbstract.elements");
                first4 = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList4);
                return String.valueOf(((MsgAbstractElement) first4).tinyId);
            }
        }
        String str = msgAbstract.senderUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgAbstract.senderUid");
        return str;
    }

    private final String g(MsgAbstract msgAbstract) {
        boolean z16;
        String str = msgAbstract.sendMemberName;
        Intrinsics.checkNotNullExpressionValue(str, "msgAbstract.sendMemberName");
        boolean z17 = true;
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String str2 = msgAbstract.sendMemberName;
            Intrinsics.checkNotNullExpressionValue(str2, "msgAbstract.sendMemberName");
            return str2;
        }
        String str3 = msgAbstract.sendNickName;
        Intrinsics.checkNotNullExpressionValue(str3, "msgAbstract.sendNickName");
        if (str3.length() <= 0) {
            z17 = false;
        }
        if (z17) {
            String str4 = msgAbstract.sendNickName;
            Intrinsics.checkNotNullExpressionValue(str4, "msgAbstract.sendNickName");
            return str4;
        }
        return "";
    }

    private final LastMessage.SendState h(int status) {
        if (status != 0) {
            if (status != 1) {
                if (status != 3) {
                    return LastMessage.SendState.SEND_SUCCESS;
                }
                return LastMessage.SendState.SEND_SUCCESS_NOSEQ;
            }
            return LastMessage.SendState.SENDING;
        }
        return LastMessage.SendState.SEND_FAILED;
    }

    @Nullable
    public final LastMessage a(@NotNull MsgAbstract msgAbstract, @NotNull String from) {
        Intrinsics.checkNotNullParameter(msgAbstract, "msgAbstract");
        Intrinsics.checkNotNullParameter(from, "from");
        if (msgAbstract.msgType == 1) {
            return b(msgAbstract);
        }
        Intrinsics.checkNotNullExpressionValue(msgAbstract.elements, "msgAbstract.elements");
        if (!r0.isEmpty()) {
            return c(msgAbstract);
        }
        Logger.a d16 = Logger.f235387a.d();
        d16.w("GuildLastMsgUtils " + from, 1, "abstractInfoTrans elements is empty: " + msgAbstract);
        return null;
    }
}
