package com.tencent.state.square.like;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.state.square.Square;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import qt4.e;
import qt4.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b$\u0010%J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 \u00a8\u0006'"}, d2 = {"Lcom/tencent/state/square/like/LikeData;", "", "Lqt4/h;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "parse", "", "head", "Ljava/lang/String;", "getHead", "()Ljava/lang/String;", "setHead", "(Ljava/lang/String;)V", "nick", "getNick", "setNick", "", "time", "J", "getTime", "()J", "setTime", "(J)V", "uin", "getUin", "setUin", "", "scene", "I", "getScene", "()I", "setScene", "(I)V", "type", "getType", "setType", "<init>", "()V", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class LikeData {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int TYPE_DOG = 5;
    public static final int TYPE_EYE = 4;
    public static final int TYPE_GOOD = 2;
    public static final int TYPE_HEART = 1;
    private static final Map<Integer, Integer> TYPE_IMG_RES;
    public static final int TYPE_SOLUTE = 3;
    private String head = "";
    private String nick = "";
    private int scene;
    private long time;
    private int type;
    private long uin;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/square/like/LikeData$Companion;", "", "()V", "TYPE_DOG", "", "TYPE_EYE", "TYPE_GOOD", "TYPE_HEART", "TYPE_IMG_RES", "", "getTYPE_IMG_RES", "()Ljava/util/Map;", "TYPE_SOLUTE", "getIconFromType", "type", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final int getIconFromType(int type) {
            Integer num = LikeData.INSTANCE.getTYPE_IMG_RES().get(Integer.valueOf(type));
            return num != null ? num.intValue() : R.drawable.iag;
        }

        public final Map<Integer, Integer> getTYPE_IMG_RES() {
            return LikeData.TYPE_IMG_RES;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Map<Integer, Integer> mapOf;
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to(1, Integer.valueOf(R.drawable.iag));
        pairArr[1] = TuplesKt.to(2, Integer.valueOf(R.drawable.iab));
        pairArr[2] = TuplesKt.to(3, Integer.valueOf(R.drawable.iae));
        pairArr[3] = TuplesKt.to(4, Integer.valueOf(Square.INSTANCE.getConfig().getCommonUtils().isLikeIconUseHug() ? R.drawable.iad : R.drawable.iaf));
        pairArr[4] = TuplesKt.to(5, Integer.valueOf(R.drawable.iac));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        TYPE_IMG_RES = mapOf;
    }

    public final String getHead() {
        return this.head;
    }

    public final String getNick() {
        return this.nick;
    }

    public final int getScene() {
        return this.scene;
    }

    public final long getTime() {
        return this.time;
    }

    public final int getType() {
        return this.type;
    }

    public final long getUin() {
        return this.uin;
    }

    public final void parse(h item) {
        Object orNull;
        Intrinsics.checkNotNullParameter(item, "item");
        String str = item.f429557g;
        Intrinsics.checkNotNullExpressionValue(str, "item.head");
        this.head = str;
        byte[] bArr = item.f429556f;
        int i3 = 0;
        if (bArr != null) {
            Intrinsics.checkNotNullExpressionValue(bArr, "item.nick");
            if (!(bArr.length == 0)) {
                byte[] bArr2 = item.f429556f;
                Intrinsics.checkNotNullExpressionValue(bArr2, "item.nick");
                this.nick = new String(bArr2, Charsets.UTF_8);
            }
        }
        this.time = item.f429553c;
        this.uin = item.f429552b;
        this.scene = item.f429555e;
        e[] eVarArr = item.f429554d;
        if (eVarArr != null) {
            orNull = ArraysKt___ArraysKt.getOrNull(eVarArr, 0);
            e eVar = (e) orNull;
            if (eVar != null) {
                i3 = eVar.f429539a;
            }
        }
        this.type = i3;
    }

    public final void setHead(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.head = str;
    }

    public final void setNick(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nick = str;
    }

    public final void setScene(int i3) {
        this.scene = i3;
    }

    public final void setTime(long j3) {
        this.time = j3;
    }

    public final void setType(int i3) {
        this.type = i3;
    }

    public final void setUin(long j3) {
        this.uin = j3;
    }
}
