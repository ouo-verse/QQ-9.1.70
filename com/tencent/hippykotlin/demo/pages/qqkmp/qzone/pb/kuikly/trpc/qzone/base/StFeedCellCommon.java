package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base;

import c45.a;
import c45.b;
import c45.f;
import c45.h;
import c45.j;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import s4.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0099\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0011\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0010\b\u0002\u0010\"\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`!\u0012\u0010\b\u0002\u0010$\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b6\u00107J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u001e\u0010\u0016\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\fR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0013R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0013R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010\"\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`!8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\fR\u001e\u0010$\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`#8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\fR\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010+\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\fR\u0018\u0010,\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010\fR\u0018\u0010-\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010\fR\u0018\u0010.\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010\u0010R\u0018\u0010/\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010\u0010R\u0018\u00100\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010\u0013R \u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u000202018VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b3\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellCommon;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "appId", "Ljava/lang/Integer;", "subId", "", "time", "Ljava/lang/Long;", "", "feedId", "Ljava/lang/String;", "curLikeKey", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/BizID;", "bizId", "clientKey", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/BytesEntry;", "extendInfo", "Ljava/util/List;", c.UGCKEY, "unusedStr", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AccessPermission;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AccessPermission;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/FeedType;", "feedType", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/FeedSubType;", "feedSubType", "Lc45/a;", "extInfo", "Lc45/a;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/UnionID;", CommonConstant.KEY_UNION_ID, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/UnionID;", "feedBizType", "featureFlag", "operateMask", "utime", "selfDeleteTime", "cellId", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AccessPermission;Ljava/lang/Integer;Ljava/lang/Integer;Lc45/a;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/UnionID;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class StFeedCellCommon extends j {
    public Integer appId;
    public Integer bizId;
    public String cellId;
    public String clientKey;
    public String curLikeKey;
    public a extInfo;
    public final List<BytesEntry> extendInfo;
    public Integer featureFlag;
    public Integer feedBizType;
    public String feedId;
    public Integer feedSubType;
    public Integer feedType;
    public Integer operateMask;
    public AccessPermission permission;
    public Long selfDeleteTime;
    public Integer subId;
    public Long time;
    public String ugckey;
    public UnionID unionId;
    public String unusedStr;
    public Long utime;

    public StFeedCellCommon() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new StFeedCellCommon(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0 == true ? 1 : 0, null, null, null, null, null, 2097151, null));
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        switch (fieldNumber) {
            case 1:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
                this.appId = (Integer) v3;
                return;
            case 2:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
                this.subId = (Integer) v3;
                return;
            case 3:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.time = (Long) v3;
                return;
            case 4:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.feedId = (String) v3;
                return;
            case 5:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.curLikeKey = (String) v3;
                return;
            case 6:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int{ com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.Biz_idKt.BizID }");
                this.bizId = (Integer) v3;
                return;
            case 7:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.clientKey = (String) v3;
                return;
            case 8:
                List<BytesEntry> list = this.extendInfo;
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.BytesEntry>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) v3);
                return;
            case 9:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.ugckey = (String) v3;
                return;
            case 10:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.unusedStr = (String) v3;
                return;
            case 11:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.AccessPermission");
                this.permission = (AccessPermission) v3;
                return;
            case 12:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int{ com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.MetaKt.FeedType }");
                this.feedType = (Integer) v3;
                return;
            case 13:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int{ com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.MetaKt.FeedSubType }");
                this.feedSubType = (Integer) v3;
                return;
            case 14:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type pbandk.ByteArr");
                this.extInfo = (a) v3;
                return;
            case 15:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.UnionID");
                this.unionId = (UnionID) v3;
                return;
            case 16:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
                this.feedBizType = (Integer) v3;
                return;
            case 17:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
                this.featureFlag = (Integer) v3;
                return;
            case 18:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
                this.operateMask = (Integer) v3;
                return;
            case 19:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.utime = (Long) v3;
                return;
            case 20:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.selfDeleteTime = (Long) v3;
                return;
            case 21:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.cellId = (String) v3;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ StFeedCellCommon(Integer num, Integer num2, Long l3, String str, String str2, Integer num3, String str3, List list, String str4, String str5, AccessPermission accessPermission, Integer num4, Integer num5, a aVar, UnionID unionID, Integer num6, Integer num7, Integer num8, Long l16, Long l17, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : num2, (i3 & 4) != 0 ? null : l3, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : str2, (i3 & 32) != 0 ? null : num3, (i3 & 64) != 0 ? null : str3, (i3 & 128) != 0 ? new ArrayList() : list, (i3 & 256) != 0 ? null : str4, (i3 & 512) != 0 ? null : str5, (i3 & 1024) != 0 ? null : accessPermission, (i3 & 2048) != 0 ? null : num4, (i3 & 4096) != 0 ? null : num5, (i3 & 8192) != 0 ? null : aVar, (i3 & 16384) != 0 ? null : unionID, (i3 & 32768) != 0 ? null : num6, (i3 & 65536) != 0 ? null : num7, (i3 & 131072) != 0 ? null : num8, (i3 & 262144) != 0 ? null : l16, (i3 & 524288) != 0 ? null : l17, (i3 & 1048576) != 0 ? null : str6);
    }

    public StFeedCellCommon(Integer num, Integer num2, Long l3, String str, String str2, Integer num3, String str3, List<BytesEntry> list, String str4, String str5, AccessPermission accessPermission, Integer num4, Integer num5, a aVar, UnionID unionID, Integer num6, Integer num7, Integer num8, Long l16, Long l17, String str6) {
        this.appId = num;
        this.subId = num2;
        this.time = l3;
        this.feedId = str;
        this.curLikeKey = str2;
        this.bizId = num3;
        this.clientKey = str3;
        this.extendInfo = list;
        this.ugckey = str4;
        this.unusedStr = str5;
        this.permission = accessPermission;
        this.feedType = num4;
        this.feedSubType = num5;
        this.extInfo = aVar;
        this.unionId = unionID;
        this.feedBizType = num6;
        this.featureFlag = num7;
        this.operateMask = num8;
        this.utime = l16;
        this.selfDeleteTime = l17;
        this.cellId = str6;
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.appId, new b.e.C0168e(true))), TuplesKt.to(2, new h(2, this.subId, new b.e.C0168e(true))), TuplesKt.to(3, new h(3, this.time, new b.e.f(true))), TuplesKt.to(4, new h(4, this.feedId, new b.e.g(true))), TuplesKt.to(5, new h(5, this.curLikeKey, new b.e.g(true))), TuplesKt.to(6, new h(6, this.bizId, new b.a(false))), TuplesKt.to(7, new h(7, this.clientKey, new b.e.g(true))), TuplesKt.to(8, new h(8, this.extendInfo, new b.f(new b.d(new BytesEntry(null, null, 3, null)), false))), TuplesKt.to(9, new h(9, this.ugckey, new b.e.g(true))), TuplesKt.to(10, new h(10, this.unusedStr, new b.e.g(true))), TuplesKt.to(11, new h(11, this.permission, new b.d(new AccessPermission(null, 1, null)))), TuplesKt.to(12, new h(12, this.feedType, new b.a(false))), TuplesKt.to(13, new h(13, this.feedSubType, new b.a(false))), TuplesKt.to(14, new h(14, this.extInfo, new b.e.C0167b(true))), TuplesKt.to(15, new h(15, this.unionId, new b.d(new UnionID(null, null, null, null, null, 31, null)))), TuplesKt.to(16, new h(16, this.feedBizType, new b.e.h(true))), TuplesKt.to(17, new h(17, this.featureFlag, new b.e.C0168e(true))), TuplesKt.to(18, new h(18, this.operateMask, new b.e.C0168e(true))), TuplesKt.to(19, new h(19, this.utime, new b.e.f(true))), TuplesKt.to(20, new h(20, this.selfDeleteTime, new b.e.f(true))), TuplesKt.to(21, new h(21, this.cellId, new b.e.g(true))));
        return mapOf;
    }
}
