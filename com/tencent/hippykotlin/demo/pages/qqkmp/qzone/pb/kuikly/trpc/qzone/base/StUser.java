package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u00c7\u0001\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\rR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\rR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\rR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\rR\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010$\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u0017R\u0018\u0010%\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u0017R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020'0&8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "", "uid", "Ljava/lang/String;", "nick", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/YellowInfo;", "yellowInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/YellowInfo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StarInfo;", "starInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StarInfo;", "", "isSweet", "Ljava/lang/Boolean;", "isSpecial", "isSuperLike", "customId", "polyId", "portrait", "canFollow", "Ljava/lang/Integer;", "isfollowed", "uin", "", "dittoUin", "Ljava/lang/Long;", "isAnonymous", "isNickGlint", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/YellowInfo;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StarInfo;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class StUser extends j {
    public static final int $stable = 8;
    public Integer canFollow;
    public String customId;
    public Long dittoUin;
    public Boolean isAnonymous;
    public Boolean isNickGlint;
    public Boolean isSpecial;
    public Boolean isSuperLike;
    public Boolean isSweet;
    public Integer isfollowed;
    public String nick;
    public String polyId;
    public String portrait;
    public StarInfo starInfo;
    public String uid;
    public String uin;
    public YellowInfo yellowInfo;

    public StUser() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        Boolean bool = null;
        return u16.g(new StUser(null, null, null, null, null, null, null, null, null, null, null, null, null, null, bool, bool, 65535, null));
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        switch (fieldNumber) {
            case 1:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.uid = (String) v3;
                return;
            case 2:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.nick = (String) v3;
                return;
            case 3:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.YellowInfo");
                this.yellowInfo = (YellowInfo) v3;
                return;
            case 4:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StarInfo");
                this.starInfo = (StarInfo) v3;
                return;
            case 5:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
                this.isSweet = (Boolean) v3;
                return;
            case 6:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
                this.isSpecial = (Boolean) v3;
                return;
            case 7:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
                this.isSuperLike = (Boolean) v3;
                return;
            case 8:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.customId = (String) v3;
                return;
            case 9:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.polyId = (String) v3;
                return;
            case 10:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.portrait = (String) v3;
                return;
            case 11:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
                this.canFollow = (Integer) v3;
                return;
            case 12:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
                this.isfollowed = (Integer) v3;
                return;
            case 13:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.uin = (String) v3;
                return;
            case 14:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.dittoUin = (Long) v3;
                return;
            case 15:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
                this.isAnonymous = (Boolean) v3;
                return;
            case 16:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
                this.isNickGlint = (Boolean) v3;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ StUser(String str, String str2, YellowInfo yellowInfo, StarInfo starInfo, Boolean bool, Boolean bool2, Boolean bool3, String str3, String str4, String str5, Integer num, Integer num2, String str6, Long l3, Boolean bool4, Boolean bool5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : yellowInfo, (i3 & 8) != 0 ? null : starInfo, (i3 & 16) != 0 ? null : bool, (i3 & 32) != 0 ? null : bool2, (i3 & 64) != 0 ? null : bool3, (i3 & 128) != 0 ? null : str3, (i3 & 256) != 0 ? null : str4, (i3 & 512) != 0 ? null : str5, (i3 & 1024) != 0 ? null : num, (i3 & 2048) != 0 ? null : num2, (i3 & 4096) != 0 ? null : str6, (i3 & 8192) != 0 ? null : l3, (i3 & 16384) != 0 ? null : bool4, (i3 & 32768) != 0 ? null : bool5);
    }

    public StUser(String str, String str2, YellowInfo yellowInfo, StarInfo starInfo, Boolean bool, Boolean bool2, Boolean bool3, String str3, String str4, String str5, Integer num, Integer num2, String str6, Long l3, Boolean bool4, Boolean bool5) {
        this.uid = str;
        this.nick = str2;
        this.yellowInfo = yellowInfo;
        this.starInfo = starInfo;
        this.isSweet = bool;
        this.isSpecial = bool2;
        this.isSuperLike = bool3;
        this.customId = str3;
        this.polyId = str4;
        this.portrait = str5;
        this.canFollow = num;
        this.isfollowed = num2;
        this.uin = str6;
        this.dittoUin = l3;
        this.isAnonymous = bool4;
        this.isNickGlint = bool5;
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        Integer num = null;
        Boolean bool = null;
        DefaultConstructorMarker defaultConstructorMarker = null;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.uid, new b.e.g(true))), TuplesKt.to(2, new h(2, this.nick, new b.e.g(true))), TuplesKt.to(3, new h(3, this.yellowInfo, new b.d(new YellowInfo(num, null, bool, 7, defaultConstructorMarker)))), TuplesKt.to(4, new h(4, this.starInfo, new b.d(new StarInfo(null, num, 0 == true ? 1 : 0, bool, 15, defaultConstructorMarker)))), TuplesKt.to(5, new h(5, this.isSweet, new b.e.a(true))), TuplesKt.to(6, new h(6, this.isSpecial, new b.e.a(true))), TuplesKt.to(7, new h(7, this.isSuperLike, new b.e.a(true))), TuplesKt.to(8, new h(8, this.customId, new b.e.g(true))), TuplesKt.to(9, new h(9, this.polyId, new b.e.g(true))), TuplesKt.to(10, new h(10, this.portrait, new b.e.g(true))), TuplesKt.to(11, new h(11, this.canFollow, new b.e.C0168e(true))), TuplesKt.to(12, new h(12, this.isfollowed, new b.e.C0168e(true))), TuplesKt.to(13, new h(13, this.uin, new b.e.g(true))), TuplesKt.to(14, new h(14, this.dittoUin, new b.e.i(true))), TuplesKt.to(15, new h(15, this.isAnonymous, new b.e.a(true))), TuplesKt.to(16, new h(16, this.isNickGlint, new b.e.a(true))));
        return mapOf;
    }
}
