package com.tencent.state.template.push;

import com.tencent.imsdk.BuildConfig;
import com.tencent.state.common.push.PullMsgResponse;
import com.tencent.state.common.push.PushBasic;
import com.tencent.state.common.push.PushMessage;
import com.tencent.state.data.UserCommon;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.template.data.CommonDataParserKt;
import com.tencent.state.template.data.User;
import ct4.b;
import fs4.u;
import gs4.a;
import gs4.c;
import gs4.d;
import gs4.e;
import gs4.f;
import gs4.g;
import gs4.h;
import gs4.i;
import gs4.j;
import gs4.k;
import gs4.l;
import gs4.m;
import gs4.n;
import gs4.o;
import gs4.q;
import gs4.r;
import gs4.s;
import gs4.t;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0002\u001a\u00020\u0004*\u00020\u0003\u001a\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0003H\u0002\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020\n*\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020\f*\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020\u000e*\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020\u0010*\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020\u0012*\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020\u0014*\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020\u0016*\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020\u0018*\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020\u001a*\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020\u001c*\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020\u001e*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020 *\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020\"*\u00020!2\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020$*\u00020#2\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020&*\u00020%2\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020(*\u00020'2\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020**\u00020)2\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020,*\u00020+2\u0006\u0010\u0005\u001a\u00020\u0003\"\u0014\u0010.\u001a\u00020-8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00060"}, d2 = {"Lct4/b;", "Lcom/tencent/state/common/push/PullMsgResponse;", "parse", "Lgs4/o;", "Lcom/tencent/state/common/push/PushMessage;", "msg", "parseMessage", "Lcom/tencent/state/common/push/PushBasic;", BuildConfig.FLAVOR, "Lgs4/f;", "Lcom/tencent/state/template/push/RoomEnterRoomMessage;", "Lgs4/n;", "Lcom/tencent/state/template/push/RoomLeaveRoomMessage;", "Lgs4/m;", "Lcom/tencent/state/template/push/RoomKickOutRoomMessage;", "Lgs4/g;", "Lcom/tencent/state/template/push/RoomFocusMessage;", "Lgs4/b;", "Lcom/tencent/state/template/push/RoomCancelFocusMessage;", "Lgs4/r;", "Lcom/tencent/state/template/push/RoomSwitchTableMessage;", "Lgs4/t;", "Lcom/tencent/state/template/push/RoomUserRefreshMessage;", "Lgs4/d;", "Lcom/tencent/state/template/push/RoomReenterRoomMessage;", "Lgs4/e;", "Lcom/tencent/state/template/push/RoomSwitchRoomMessage;", "Lgs4/k;", "Lcom/tencent/state/template/push/RoomInteractionReceiveInviteMessage;", "Lgs4/i;", "Lcom/tencent/state/template/push/RoomInteractionCancelInviteMessage;", "Lgs4/h;", "Lcom/tencent/state/template/push/RoomInteractionAgreeInviteMessage;", "Lgs4/l;", "Lcom/tencent/state/template/push/RoomInteractionUserRefreshMessage;", "Lgs4/j;", "Lcom/tencent/state/template/push/RoomInteractionEndInteractionMessage;", "Lgs4/q;", "Lcom/tencent/state/template/push/RoomRefreshThemeMessage;", "Lgs4/a;", "Lcom/tencent/state/template/push/BubbleMessage;", "Lgs4/c;", "Lcom/tencent/state/template/push/ChoosePKTagMessage;", "Lgs4/s;", "Lcom/tencent/state/template/push/TaskDoneMessage;", "", "TAG", "Ljava/lang/String;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class RoomPushMessageParserKt {
    private static final String TAG = "RoomPushMessageParser";

    public static final PushBasic basic(o basic) {
        Intrinsics.checkNotNullParameter(basic, "$this$basic");
        return new PushBasic(basic.f403318a, basic.f403319b, basic.f403320c);
    }

    public static final PullMsgResponse parse(b parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        byte[] bArr = parse.f391837a;
        Intrinsics.checkNotNullExpressionValue(bArr, "this.offset");
        int i3 = parse.f391838b;
        long j3 = parse.f391840d;
        o[] oVarArr = parse.f391839c;
        Intrinsics.checkNotNullExpressionValue(oVarArr, "this.msgs");
        ArrayList arrayList = new ArrayList(oVarArr.length);
        for (o it : oVarArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(parse(it));
        }
        return new PullMsgResponse(bArr, i3, j3, arrayList);
    }

    private static final PushMessage parseMessage(o oVar) {
        int i3 = oVar.f403321d;
        if (i3 == 1) {
            f c16 = f.c(oVar.f403322e);
            Intrinsics.checkNotNullExpressionValue(c16, "EnterRoomMsg.parseFrom(msg.payload)");
            return parse(c16, oVar);
        }
        if (i3 == 2) {
            n c17 = n.c(oVar.f403322e);
            Intrinsics.checkNotNullExpressionValue(c17, "LeaveRoomMsg.parseFrom(msg.payload)");
            return parse(c17, oVar);
        }
        if (i3 == 3) {
            m c18 = m.c(oVar.f403322e);
            Intrinsics.checkNotNullExpressionValue(c18, "KickOutRoomMsg.parseFrom(msg.payload)");
            return parse(c18, oVar);
        }
        if (i3 == 4) {
            g c19 = g.c(oVar.f403322e);
            Intrinsics.checkNotNullExpressionValue(c19, "FocusMsg.parseFrom(msg.payload)");
            return parse(c19, oVar);
        }
        if (i3 == 5) {
            gs4.b c26 = gs4.b.c(oVar.f403322e);
            Intrinsics.checkNotNullExpressionValue(c26, "CancelFocusMsg.parseFrom(msg.payload)");
            return parse(c26, oVar);
        }
        if (i3 == 300) {
            d c27 = d.c(oVar.f403322e);
            Intrinsics.checkNotNullExpressionValue(c27, "CmdReEnterRoomMsg.parseFrom(msg.payload)");
            return parse(c27, oVar);
        }
        if (i3 != 301) {
            switch (i3) {
                case 7:
                    t c28 = t.c(oVar.f403322e);
                    Intrinsics.checkNotNullExpressionValue(c28, "UserInfoRefreshMsg.parseFrom(msg.payload)");
                    return parse(c28, oVar);
                case 8:
                    k c29 = k.c(oVar.f403322e);
                    Intrinsics.checkNotNullExpressionValue(c29, "InterReceiveInviteMsg.parseFrom(msg.payload)");
                    return parse(c29, oVar);
                case 9:
                    i c36 = i.c(oVar.f403322e);
                    Intrinsics.checkNotNullExpressionValue(c36, "InterCancelInviteMsg.parseFrom(msg.payload)");
                    return parse(c36, oVar);
                case 10:
                    h c37 = h.c(oVar.f403322e);
                    Intrinsics.checkNotNullExpressionValue(c37, "InterAgreeInviteMsg.parseFrom(msg.payload)");
                    return parse(c37, oVar);
                case 11:
                    l c38 = l.c(oVar.f403322e);
                    Intrinsics.checkNotNullExpressionValue(c38, "InterUserInfoRefreshMsg.parseFrom(msg.payload)");
                    return parse(c38, oVar);
                case 12:
                    j c39 = j.c(oVar.f403322e);
                    Intrinsics.checkNotNullExpressionValue(c39, "InterEndInteractionMsg.parseFrom(msg.payload)");
                    return parse(c39, oVar);
                case 13:
                    q c46 = q.c(oVar.f403322e);
                    Intrinsics.checkNotNullExpressionValue(c46, "RoomThemeRefreshMsg.parseFrom(msg.payload)");
                    return parse(c46, oVar);
                case 14:
                    a c47 = a.c(oVar.f403322e);
                    Intrinsics.checkNotNullExpressionValue(c47, "BubbleMsg.parseFrom(msg.payload)");
                    return parse(c47, oVar);
                case 15:
                    c c48 = c.c(oVar.f403322e);
                    Intrinsics.checkNotNullExpressionValue(c48, "ChooseMsg.parseFrom(msg.payload)");
                    return parse(c48, oVar);
                case 16:
                    r c49 = r.c(oVar.f403322e);
                    Intrinsics.checkNotNullExpressionValue(c49, "SwitchTableMsg.parseFrom(msg.payload)");
                    return parse(c49, oVar);
                case 17:
                    s c56 = s.c(oVar.f403322e);
                    Intrinsics.checkNotNullExpressionValue(c56, "TaskDoneMsg.parseFrom(msg.payload)");
                    return parse(c56, oVar);
                default:
                    return new UnknownMessage(0, basic(oVar));
            }
        }
        e c57 = e.c(oVar.f403322e);
        Intrinsics.checkNotNullExpressionValue(c57, "CmdSwitchRoomMsg.parseFrom(msg.payload)");
        return parse(c57, oVar);
    }

    public static final PushMessage parse(o parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        try {
            return parseMessage(parse);
        } catch (Throwable th5) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "parse Msg failed: " + th5.getMessage(), null, 4, null);
            return new UnknownMessage(0, basic(parse));
        }
    }

    public static final EnterRoomMessage parse(f parse, o msg2) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        PushBasic basic = basic(msg2);
        long j3 = parse.f403290b;
        u profile = parse.f403291c;
        Intrinsics.checkNotNullExpressionValue(profile, "profile");
        return new EnterRoomMessage(1, basic, j3, CommonDataParserKt.parse(profile, parse.f403289a));
    }

    public static final LeaveRoomMessage parse(n parse, o msg2) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return new LeaveRoomMessage(2, basic(msg2), parse.f403316b, parse.f403315a);
    }

    public static final KickOutRoomMessage parse(m parse, o msg2) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return new KickOutRoomMessage(3, basic(msg2), parse.f403314b, parse.f403313a);
    }

    public static final RoomMessage parse(g parse, o msg2) {
        fs4.d dVar;
        hs4.s sVar;
        fs4.d dVar2;
        hs4.s sVar2;
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        fs4.t tVar = parse.f403295d;
        if (((tVar == null || (dVar2 = tVar.f400585e) == null || (sVar2 = dVar2.f400510f) == null) ? null : sVar2.f406207g) == null) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "\u7740\u88c5\u4fe1\u606f\u4e3a\u7a7a", null, 4, null);
            fs4.t tVar2 = parse.f403295d;
            if (tVar2 != null && (dVar = tVar2.f400585e) != null && (sVar = dVar.f400510f) != null) {
                hs4.u uVar = new hs4.u();
                uVar.f406219a = String.valueOf(parse.f403295d.f400581a);
                Unit unit = Unit.INSTANCE;
                sVar.f406207g = uVar;
            }
        }
        PushBasic basic = basic(msg2);
        long j3 = parse.f403293b;
        fs4.t user = parse.f403295d;
        Intrinsics.checkNotNullExpressionValue(user, "user");
        User parse2 = CommonDataParserKt.parse(user);
        long j16 = parse.f403294c;
        fs4.d dVar3 = parse.f403295d.f400585e;
        Intrinsics.checkNotNullExpressionValue(dVar3, "user.focus");
        return new RoomMessage(4, basic, j3, parse2, j16, CommonDataParserKt.parse(dVar3));
    }

    public static final CancelPrayMessage parse(gs4.b parse, o msg2) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return new CancelPrayMessage(5, basic(msg2), parse.f403283b, parse.f403282a, parse.f403284c, parse.f403285d);
    }

    public static final SwitchTableMessage parse(r parse, o msg2) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        PushBasic basic = basic(msg2);
        long j3 = parse.f403333b;
        long j16 = parse.f403332a;
        long j17 = parse.f403334c;
        fs4.t user = parse.f403335d;
        Intrinsics.checkNotNullExpressionValue(user, "user");
        return new SwitchTableMessage(16, basic, j3, j16, j17, CommonDataParserKt.parse(user));
    }

    public static final UserRefreshMessage parse(t parse, o msg2) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        PushBasic basic = basic(msg2);
        fs4.t user = parse.f403339a;
        Intrinsics.checkNotNullExpressionValue(user, "user");
        return new UserRefreshMessage(7, basic, CommonDataParserKt.parse(user));
    }

    public static final ReenterRoomMessage parse(d parse, o msg2) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return new ReenterRoomMessage(300, basic(msg2));
    }

    public static final SwitchRoomMessage parse(e parse, o msg2) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return new SwitchRoomMessage(301, basic(msg2));
    }

    public static final RoomInteractionReceiveInviteMessage parse(k parse, o msg2) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        PushBasic basic = basic(msg2);
        String billNo = parse.f403304a;
        Intrinsics.checkNotNullExpressionValue(billNo, "billNo");
        long j3 = parse.f403305b;
        u profile = parse.f403306c;
        Intrinsics.checkNotNullExpressionValue(profile, "profile");
        UserCommon parse2 = CommonDataParserKt.parse(profile, parse.f403305b);
        long j16 = parse.f403307d;
        String motionName = parse.f403308e;
        Intrinsics.checkNotNullExpressionValue(motionName, "motionName");
        return new RoomInteractionReceiveInviteMessage(8, basic, billNo, j3, parse2, j16, motionName);
    }

    public static final RoomInteractionCancelInviteMessage parse(i parse, o msg2) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        PushBasic basic = basic(msg2);
        String billNo = parse.f403299a;
        Intrinsics.checkNotNullExpressionValue(billNo, "billNo");
        return new RoomInteractionCancelInviteMessage(9, basic, billNo, parse.f403300b);
    }

    public static final RoomInteractionAgreeInviteMessage parse(h parse, o msg2) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        PushBasic basic = basic(msg2);
        String billNo = parse.f403296a;
        Intrinsics.checkNotNullExpressionValue(billNo, "billNo");
        long j3 = parse.f403297b;
        String tips = parse.f403298c;
        Intrinsics.checkNotNullExpressionValue(tips, "tips");
        return new RoomInteractionAgreeInviteMessage(10, basic, billNo, j3, tips);
    }

    public static final RoomInteractionUserRefreshMessage parse(l parse, o msg2) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        PushBasic basic = basic(msg2);
        String billNo = parse.f403309a;
        Intrinsics.checkNotNullExpressionValue(billNo, "billNo");
        return new RoomInteractionUserRefreshMessage(11, basic, billNo, parse.f403310b, parse.f403311c, RefreshType.INSTANCE.fromValue(parse.f403312d));
    }

    public static final RoomInteractionEndInteractionMessage parse(j parse, o msg2) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        PushBasic basic = basic(msg2);
        String billNo = parse.f403301a;
        Intrinsics.checkNotNullExpressionValue(billNo, "billNo");
        long j3 = parse.f403302b;
        u profile = parse.f403303c;
        Intrinsics.checkNotNullExpressionValue(profile, "profile");
        return new RoomInteractionEndInteractionMessage(12, basic, billNo, j3, CommonDataParserKt.parse(profile, parse.f403302b));
    }

    public static final RoomRefreshThemeMessage parse(q parse, o msg2) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        PushBasic basic = basic(msg2);
        fs4.s theme = parse.f403331a;
        Intrinsics.checkNotNullExpressionValue(theme, "theme");
        return new RoomRefreshThemeMessage(13, basic, CommonDataParserKt.parse(theme));
    }

    public static final BubbleMessage parse(a parse, o msg2) {
        String decodeToString;
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        byte[] bArr = yr4.e.c(parse.f403279b).f451110d;
        Intrinsics.checkNotNullExpressionValue(bArr, "TextMsgInfo.parseFrom(body).text");
        decodeToString = StringsKt__StringsJVMKt.decodeToString(bArr);
        PushBasic basic = basic(msg2);
        String templateId = parse.f403278a;
        Intrinsics.checkNotNullExpressionValue(templateId, "templateId");
        return new BubbleMessage(14, basic, templateId, parse.f403281d, decodeToString, parse.f403280c);
    }

    public static final ChoosePKTagMessage parse(c parse, o msg2) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return new ChoosePKTagMessage(15, basic(msg2), parse.f403286a, parse.f403287b, parse.f403288c);
    }

    public static final TaskDoneMessage parse(s parse, o msg2) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return new TaskDoneMessage(17, basic(msg2), parse.f403337a, parse.f403338b);
    }
}
