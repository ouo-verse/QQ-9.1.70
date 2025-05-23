package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base;

import c45.a;
import c45.b;
import c45.f;
import c45.h;
import c45.j;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u00a9\u0001\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\rR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\rR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\rR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\rR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\rR \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001f0\u001e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StPolyLike;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "", "polyLikeId", "Ljava/lang/String;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/ArticleType;", "articleType", "Ljava/lang/Integer;", "polyName", "polySource", "polyIconUrl", "polyUnderPicUrl", "price", "Lc45/a;", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "Lc45/a;", "fullScreenUrl", "fullScreenUrlAnd", "polyTxtColor", "polyUnderColor", "dynamicPicUrl", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lc45/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class StPolyLike extends j {
    public Integer articleType;
    public a busiData;
    public String dynamicPicUrl;
    public String fullScreenUrl;
    public String fullScreenUrlAnd;
    public String polyIconUrl;
    public String polyLikeId;
    public String polyName;
    public String polySource;
    public String polyTxtColor;
    public String polyUnderColor;
    public String polyUnderPicUrl;
    public Integer price;

    public StPolyLike() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, InitSkin.DRAWABLE_COUNT, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new StPolyLike(null, null, null, null, null, null, null, null, null, null, null, null, null, InitSkin.DRAWABLE_COUNT, null));
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        switch (fieldNumber) {
            case 1:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.polyLikeId = (String) v3;
                return;
            case 2:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int{ com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.MetaKt.ArticleType }");
                this.articleType = (Integer) v3;
                return;
            case 3:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.polyName = (String) v3;
                return;
            case 4:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.polySource = (String) v3;
                return;
            case 5:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.polyIconUrl = (String) v3;
                return;
            case 6:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.polyUnderPicUrl = (String) v3;
                return;
            case 7:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
                this.price = (Integer) v3;
                return;
            case 8:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type pbandk.ByteArr");
                this.busiData = (a) v3;
                return;
            case 9:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.fullScreenUrl = (String) v3;
                return;
            case 10:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.fullScreenUrlAnd = (String) v3;
                return;
            case 11:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.polyTxtColor = (String) v3;
                return;
            case 12:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.polyUnderColor = (String) v3;
                return;
            case 13:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.dynamicPicUrl = (String) v3;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ StPolyLike(String str, Integer num, String str2, String str3, String str4, String str5, Integer num2, a aVar, String str6, String str7, String str8, String str9, String str10, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : str3, (i3 & 16) != 0 ? null : str4, (i3 & 32) != 0 ? null : str5, (i3 & 64) != 0 ? null : num2, (i3 & 128) != 0 ? null : aVar, (i3 & 256) != 0 ? null : str6, (i3 & 512) != 0 ? null : str7, (i3 & 1024) != 0 ? null : str8, (i3 & 2048) != 0 ? null : str9, (i3 & 4096) == 0 ? str10 : null);
    }

    public StPolyLike(String str, Integer num, String str2, String str3, String str4, String str5, Integer num2, a aVar, String str6, String str7, String str8, String str9, String str10) {
        this.polyLikeId = str;
        this.articleType = num;
        this.polyName = str2;
        this.polySource = str3;
        this.polyIconUrl = str4;
        this.polyUnderPicUrl = str5;
        this.price = num2;
        this.busiData = aVar;
        this.fullScreenUrl = str6;
        this.fullScreenUrlAnd = str7;
        this.polyTxtColor = str8;
        this.polyUnderColor = str9;
        this.dynamicPicUrl = str10;
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.polyLikeId, new b.e.g(true))), TuplesKt.to(2, new h(2, this.articleType, new b.a(false))), TuplesKt.to(3, new h(3, this.polyName, new b.e.g(true))), TuplesKt.to(4, new h(4, this.polySource, new b.e.g(true))), TuplesKt.to(5, new h(5, this.polyIconUrl, new b.e.g(true))), TuplesKt.to(6, new h(6, this.polyUnderPicUrl, new b.e.g(true))), TuplesKt.to(7, new h(7, this.price, new b.e.h(true))), TuplesKt.to(8, new h(8, this.busiData, new b.e.C0167b(true))), TuplesKt.to(9, new h(9, this.fullScreenUrl, new b.e.g(true))), TuplesKt.to(10, new h(10, this.fullScreenUrlAnd, new b.e.g(true))), TuplesKt.to(11, new h(11, this.polyTxtColor, new b.e.g(true))), TuplesKt.to(12, new h(12, this.polyUnderColor, new b.e.g(true))), TuplesKt.to(13, new h(13, this.dynamicPicUrl, new b.e.g(true))));
        return mapOf;
    }
}
