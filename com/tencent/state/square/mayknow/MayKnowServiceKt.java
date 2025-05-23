package com.tencent.state.square.mayknow;

import at4.f;
import com.tencent.state.square.SquareBase;
import es4.b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0003\u00a8\u0006\u0006"}, d2 = {"Lat4/f;", "Lcom/tencent/state/square/mayknow/MayKnowUser;", "formatMayKnowUser", "Les4/b;", "Lcom/tencent/state/square/mayknow/MayKnowLabel;", "formatMayKnowLabel", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MayKnowServiceKt {
    public static final MayKnowLabel formatMayKnowLabel(b formatMayKnowLabel) {
        Intrinsics.checkNotNullParameter(formatMayKnowLabel, "$this$formatMayKnowLabel");
        String name = formatMayKnowLabel.f397094a;
        Intrinsics.checkNotNullExpressionValue(name, "name");
        return new MayKnowLabel(name, formatMayKnowLabel.f397097d);
    }

    public static final MayKnowUser formatMayKnowUser(f formatMayKnowUser) {
        String str;
        Intrinsics.checkNotNullParameter(formatMayKnowUser, "$this$formatMayKnowUser");
        long j3 = formatMayKnowUser.f26933a;
        byte[] nick = formatMayKnowUser.f26934b;
        Intrinsics.checkNotNullExpressionValue(nick, "nick");
        int i3 = 0;
        if (nick.length == 0) {
            str = String.valueOf(formatMayKnowUser.f26933a);
        } else {
            byte[] nick2 = formatMayKnowUser.f26934b;
            Intrinsics.checkNotNullExpressionValue(nick2, "nick");
            str = new String(nick2, Charsets.UTF_8);
        }
        Integer valueOf = Integer.valueOf(formatMayKnowUser.f26935c);
        Integer valueOf2 = Integer.valueOf(formatMayKnowUser.f26936d);
        String str2 = formatMayKnowUser.f26937e;
        String str3 = formatMayKnowUser.f26938f;
        String str4 = formatMayKnowUser.f26939g;
        String str5 = formatMayKnowUser.f26940h;
        String str6 = formatMayKnowUser.f26941i;
        ArrayList arrayList = new ArrayList();
        b[] bVarArr = formatMayKnowUser.f26942j;
        if (bVarArr != null) {
            int length = bVarArr.length;
            while (i3 < length) {
                b it = bVarArr[i3];
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(formatMayKnowLabel(it));
                i3++;
                bVarArr = bVarArr;
            }
        }
        Unit unit = Unit.INSTANCE;
        return new MayKnowUser(j3, str, valueOf, valueOf2, str2, str3, str4, str5, str6, arrayList, SquareBase.INSTANCE.getConfig().getCommonUtils().hasSendFriendRequest(String.valueOf(formatMayKnowUser.f26933a)));
    }
}
