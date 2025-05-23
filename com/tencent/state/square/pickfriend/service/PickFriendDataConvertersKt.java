package com.tencent.state.square.pickfriend.service;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ot4.h;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lot4/h;", "Lcom/tencent/state/square/pickfriend/service/PickFriendEntryInfoData;", "parse", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class PickFriendDataConvertersKt {
    public static final PickFriendEntryInfoData parse(h parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        String str = parse.f424057a;
        if (str == null) {
            str = "";
        }
        String str2 = parse.f424058b;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = parse.f424059c;
        return new PickFriendEntryInfoData(str, str2, str3 != null ? str3 : "");
    }
}
