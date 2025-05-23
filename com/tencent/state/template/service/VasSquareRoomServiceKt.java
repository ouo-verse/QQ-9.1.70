package com.tencent.state.template.service;

import android.util.Size;
import com.tencent.state.template.data.CommonDataParserKt;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.RoomConfig;
import fs4.n;
import fs4.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wt4.f;
import wt4.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\n\u001a\u00020\t*\u00020\u00002\u001e\u0010\u0006\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001j\u0002`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u001a4\u0010\n\u001a\u00020\t*\u00020\u000b2\u001e\u0010\u0006\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001j\u0002`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a8\u0006\f"}, d2 = {"Lwt4/f;", "Lkotlin/Function1;", "", "Lfs4/r;", "Lcom/tencent/state/template/data/RoomConfig;", "Lcom/tencent/state/template/data/RoomConfParser;", "roomConfParser", "Landroid/util/Size;", "mapSize", "Lcom/tencent/state/template/data/EnterRoomInfo;", "parse", "Lwt4/o;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasSquareRoomServiceKt {
    public static final EnterRoomInfo parse(f parse, Function1<? super r[], RoomConfig> roomConfParser, Size size) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(roomConfParser, "roomConfParser");
        byte[] bArr = parse.f446509b;
        Intrinsics.checkNotNullExpressionValue(bArr, "this.msgOffset");
        n nVar = parse.f446508a;
        Intrinsics.checkNotNullExpressionValue(nVar, "this.room");
        return new EnterRoomInfo(bArr, CommonDataParserKt.parse(nVar, roomConfParser, size), parse.f446510c);
    }

    public static final EnterRoomInfo parse(o parse, Function1<? super r[], RoomConfig> roomConfParser, Size size) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(roomConfParser, "roomConfParser");
        byte[] bArr = parse.f446524b;
        Intrinsics.checkNotNullExpressionValue(bArr, "this.msgOffset");
        n nVar = parse.f446523a;
        Intrinsics.checkNotNullExpressionValue(nVar, "this.room");
        return new EnterRoomInfo(bArr, CommonDataParserKt.parse(nVar, roomConfParser, size), false);
    }
}
