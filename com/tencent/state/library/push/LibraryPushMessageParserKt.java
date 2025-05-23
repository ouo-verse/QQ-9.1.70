package com.tencent.state.library.push;

import bs4.j;
import com.tencent.imsdk.BuildConfig;
import com.tencent.state.common.push.PullMsgResponse;
import com.tencent.state.common.push.PushBasic;
import com.tencent.state.common.push.PushMessage;
import com.tencent.state.data.UserCommon;
import com.tencent.state.library.data.LibraryDataParserKt;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import ds4.a;
import ds4.c;
import ds4.d;
import ds4.e;
import ds4.f;
import ds4.g;
import ds4.h;
import ds4.i;
import ds4.k;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ps4.b;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0002\u001a\u00020\u0004*\u00020\u0003\u001a\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0003H\u0002\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020\n*\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020\f*\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020\u000e*\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020\u0010*\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020\u0012*\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020\u0014*\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020\u0016*\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020\u0018*\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0002\u001a\u00020\u001a*\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0003\"\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006\u001e"}, d2 = {"Lps4/b;", "Lcom/tencent/state/common/push/PullMsgResponse;", "parse", "Lds4/i;", "Lcom/tencent/state/common/push/PushMessage;", "msg", "parseMessage", "Lcom/tencent/state/common/push/PushBasic;", BuildConfig.FLAVOR, "Lds4/d;", "Lcom/tencent/state/library/push/EnterRoomMessage;", "Lds4/g;", "Lcom/tencent/state/library/push/LeaveRoomMessage;", "Lds4/f;", "Lcom/tencent/state/library/push/KickOutRoomMessage;", "Lds4/e;", "Lcom/tencent/state/library/push/FocusMessage;", "Lds4/a;", "Lcom/tencent/state/library/push/CancelFocusMessage;", "Lds4/h;", "Lcom/tencent/state/library/push/LikeMessage;", "Lds4/k;", "Lcom/tencent/state/library/push/UserRefreshMessage;", "Lds4/b;", "Lcom/tencent/state/library/push/ReenterRoomMessage;", "Lds4/c;", "Lcom/tencent/state/library/push/SwitchRoomMessage;", "", "TAG", "Ljava/lang/String;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryPushMessageParserKt {
    private static final String TAG = "LibraryPushMessageParser";

    public static final PushBasic basic(i basic) {
        Intrinsics.checkNotNullParameter(basic, "$this$basic");
        return new PushBasic(basic.f394784a, basic.f394785b, basic.f394786c);
    }

    public static final PullMsgResponse parse(b parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        byte[] bArr = parse.f427086a;
        Intrinsics.checkNotNullExpressionValue(bArr, "this.offset");
        int i3 = parse.f427087b;
        long j3 = parse.f427089d;
        i[] iVarArr = parse.f427088c;
        Intrinsics.checkNotNullExpressionValue(iVarArr, "this.msgs");
        ArrayList arrayList = new ArrayList(iVarArr.length);
        for (i it : iVarArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(parse(it));
        }
        return new PullMsgResponse(bArr, i3, j3, arrayList);
    }

    private static final PushMessage parseMessage(i iVar) {
        int i3 = iVar.f394787d;
        if (i3 == 300) {
            ds4.b c16 = ds4.b.c(iVar.f394788e);
            Intrinsics.checkNotNullExpressionValue(c16, "CmdReEnterRoomMsg.parseFrom(msg.payload)");
            return parse(c16, iVar);
        }
        if (i3 != 301) {
            switch (i3) {
                case 1:
                    d c17 = d.c(iVar.f394788e);
                    Intrinsics.checkNotNullExpressionValue(c17, "EnterRoomMsg.parseFrom(msg.payload)");
                    return parse(c17, iVar);
                case 2:
                    g c18 = g.c(iVar.f394788e);
                    Intrinsics.checkNotNullExpressionValue(c18, "LeaveRoomMsg.parseFrom(msg.payload)");
                    return parse(c18, iVar);
                case 3:
                    f c19 = f.c(iVar.f394788e);
                    Intrinsics.checkNotNullExpressionValue(c19, "KickOutRoomMsg.parseFrom(msg.payload)");
                    return parse(c19, iVar);
                case 4:
                    e c26 = e.c(iVar.f394788e);
                    Intrinsics.checkNotNullExpressionValue(c26, "FocusMsg.parseFrom(msg.payload)");
                    return parse(c26, iVar);
                case 5:
                    a c27 = a.c(iVar.f394788e);
                    Intrinsics.checkNotNullExpressionValue(c27, "CancelFocusMsg.parseFrom(msg.payload)");
                    return parse(c27, iVar);
                case 6:
                    h c28 = h.c(iVar.f394788e);
                    Intrinsics.checkNotNullExpressionValue(c28, "LikeMsg.parseFrom(msg.payload)");
                    return parse(c28, iVar);
                case 7:
                    k c29 = k.c(iVar.f394788e);
                    Intrinsics.checkNotNullExpressionValue(c29, "UserInfoRefreshMsg.parseFrom(msg.payload)");
                    return parse(c29, iVar);
                default:
                    return new UnknownMessage(0, basic(iVar));
            }
        }
        c c36 = c.c(iVar.f394788e);
        Intrinsics.checkNotNullExpressionValue(c36, "CmdSwitchRoomMsg.parseFrom(msg.payload)");
        return parse(c36, iVar);
    }

    public static final PushMessage parse(i parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        try {
            return parseMessage(parse);
        } catch (Throwable th5) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "parse Msg failed: " + th5.getMessage(), null, 4, null);
            return new UnknownMessage(0, basic(parse));
        }
    }

    public static final EnterRoomMessage parse(d parse, i msg2) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        PushBasic basic = basic(msg2);
        long j3 = parse.f394770b;
        bs4.k profile = parse.f394771c;
        Intrinsics.checkNotNullExpressionValue(profile, "profile");
        return new EnterRoomMessage(1, basic, j3, LibraryDataParserKt.parse(profile, parse.f394769a));
    }

    public static final LeaveRoomMessage parse(g parse, i msg2) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return new LeaveRoomMessage(2, basic(msg2), parse.f394779b, parse.f394778a);
    }

    public static final KickOutRoomMessage parse(f parse, i msg2) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return new KickOutRoomMessage(3, basic(msg2), parse.f394777b, parse.f394776a);
    }

    public static final FocusMessage parse(e parse, i msg2) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        PushBasic basic = basic(msg2);
        long j3 = parse.f394773b;
        bs4.k kVar = parse.f394775d.f29076b;
        Intrinsics.checkNotNullExpressionValue(kVar, "user.profile");
        UserCommon parse2 = LibraryDataParserKt.parse(kVar, parse.f394772a);
        long j16 = parse.f394774c;
        bs4.b bVar = parse.f394775d.f29079e;
        Intrinsics.checkNotNullExpressionValue(bVar, "user.focus");
        return new FocusMessage(4, basic, j3, parse2, j16, LibraryDataParserKt.parse(bVar));
    }

    public static final CancelFocusMessage parse(a parse, i msg2) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return new CancelFocusMessage(5, basic(msg2), parse.f394766b, parse.f394765a, parse.f394767c, parse.f394768d);
    }

    public static final LikeMessage parse(h parse, i msg2) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return new LikeMessage(6, basic(msg2), parse.f394780a, parse.f394781b, parse.f394782c);
    }

    public static final UserRefreshMessage parse(k parse, i msg2) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        PushBasic basic = basic(msg2);
        j user = parse.f394796a;
        Intrinsics.checkNotNullExpressionValue(user, "user");
        return new UserRefreshMessage(7, basic, LibraryDataParserKt.parse(user));
    }

    public static final ReenterRoomMessage parse(ds4.b parse, i msg2) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return new ReenterRoomMessage(300, basic(msg2));
    }

    public static final SwitchRoomMessage parse(c parse, i msg2) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return new SwitchRoomMessage(301, basic(msg2));
    }
}
