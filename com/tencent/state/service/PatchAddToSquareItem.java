package com.tencent.state.service;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import dt4.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/service/PatchAddToSquareItem;", "", "uin", "", "type", "", GdtGetUserInfoHandler.KEY_AREA, "rank", "(Ljava/lang/String;III)V", "getArea", "()I", "getRank", "getType", "getUin", "()Ljava/lang/String;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class PatchAddToSquareItem {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int area;
    private final int rank;
    private final int type;
    private final String uin;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/service/PatchAddToSquareItem$Companion;", "", "Lcom/tencent/state/service/PatchAddToSquareItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Ldt4/c;", "covertToUnit", "covertFromUnit", "<init>", "()V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final PatchAddToSquareItem covertFromUnit(c item) {
            Intrinsics.checkNotNullParameter(item, "item");
            return new PatchAddToSquareItem(String.valueOf(item.f394848b), item.f394847a, item.f394849c, item.f394850d);
        }

        public final c covertToUnit(PatchAddToSquareItem item) {
            Long longOrNull;
            Intrinsics.checkNotNullParameter(item, "item");
            c cVar = new c();
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(item.getUin());
            cVar.f394848b = longOrNull != null ? longOrNull.longValue() : -1L;
            cVar.f394847a = item.getType();
            cVar.f394849c = item.getArea();
            cVar.f394850d = item.getRank();
            return cVar;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PatchAddToSquareItem(String uin, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.type = i3;
        this.area = i16;
        this.rank = i17;
    }

    public final int getArea() {
        return this.area;
    }

    public final int getRank() {
        return this.rank;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUin() {
        return this.uin;
    }
}
