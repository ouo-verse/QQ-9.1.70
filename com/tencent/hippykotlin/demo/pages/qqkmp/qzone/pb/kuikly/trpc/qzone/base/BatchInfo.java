package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u00b1\u0001\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018\u0012\u0010\b\u0002\u0010!\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001` \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\rR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\rR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00188\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u001e\u0010!\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001` 8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u0010R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\rR \u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020)0(8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/BatchInfo;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "", "linkId", "Ljava/lang/Long;", "", "desc", "Ljava/lang/String;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StLBS;", "lbs", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StLBS;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMedia;", "medias", "Ljava/util/List;", "uploadNumber", "originUploadNumber", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/Entry;", "ext", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/ItemLinkType;", "linkType", "Ljava/lang/Integer;", QQWinkConstants.TAB_SUBTITLE, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/BatchInfoBanner;", "banner", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/BatchInfoBanner;", "dayTime", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StLBS;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/BatchInfoBanner;Ljava/lang/Long;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class BatchInfo extends j {
    public static final int $stable = 8;
    public BatchInfoBanner banner;
    public Long dayTime;
    public String desc;
    public final List<Entry> ext;
    public StLBS lbs;
    public Long linkId;
    public Integer linkType;
    public final List<StMedia> medias;
    public Long originUploadNumber;
    public String showTime;
    public String subTitle;
    public Long uploadNumber;
    public StUser user;

    public BatchInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, InitSkin.DRAWABLE_COUNT, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new BatchInfo(null, null, null, null, null, null, null, null, null, null, null, null, null, InitSkin.DRAWABLE_COUNT, null));
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        switch (fieldNumber) {
            case 1:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.linkId = (Long) v3;
                return;
            case 2:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.desc = (String) v3;
                return;
            case 3:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.showTime = (String) v3;
                return;
            case 4:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser");
                this.user = (StUser) v3;
                return;
            case 5:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StLBS");
                this.lbs = (StLBS) v3;
                return;
            case 6:
                List<StMedia> list = this.medias;
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) v3);
                return;
            case 7:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.uploadNumber = (Long) v3;
                return;
            case 8:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.originUploadNumber = (Long) v3;
                return;
            case 9:
                List<Entry> list2 = this.ext;
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.Entry>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) v3);
                return;
            case 10:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int{ com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.Album_metaKt.ItemLinkType }");
                this.linkType = (Integer) v3;
                return;
            case 11:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.subTitle = (String) v3;
                return;
            case 12:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.BatchInfoBanner");
                this.banner = (BatchInfoBanner) v3;
                return;
            case 13:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.dayTime = (Long) v3;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ BatchInfo(Long l3, String str, String str2, StUser stUser, StLBS stLBS, List list, Long l16, Long l17, List list2, Integer num, String str3, BatchInfoBanner batchInfoBanner, Long l18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : l3, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : stUser, (i3 & 16) != 0 ? null : stLBS, (i3 & 32) != 0 ? new ArrayList() : list, (i3 & 64) != 0 ? null : l16, (i3 & 128) != 0 ? null : l17, (i3 & 256) != 0 ? new ArrayList() : list2, (i3 & 512) != 0 ? null : num, (i3 & 1024) != 0 ? null : str3, (i3 & 2048) != 0 ? null : batchInfoBanner, (i3 & 4096) == 0 ? l18 : null);
    }

    public BatchInfo(Long l3, String str, String str2, StUser stUser, StLBS stLBS, List<StMedia> list, Long l16, Long l17, List<Entry> list2, Integer num, String str3, BatchInfoBanner batchInfoBanner, Long l18) {
        this.linkId = l3;
        this.desc = str;
        this.showTime = str2;
        this.user = stUser;
        this.lbs = stLBS;
        this.medias = list;
        this.uploadNumber = l16;
        this.originUploadNumber = l17;
        this.ext = list2;
        this.linkType = num;
        this.subTitle = str3;
        this.banner = batchInfoBanner;
        this.dayTime = l18;
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.linkId, new b.e.i(true))), TuplesKt.to(2, new h(2, this.desc, new b.e.g(true))), TuplesKt.to(3, new h(3, this.showTime, new b.e.g(true))), TuplesKt.to(4, new h(4, this.user, new b.d(new StUser(null, null, null, null, 0 == true ? 1 : 0, null, null, null, null, null, null, null, null, null, null, null, 65535, null)))), TuplesKt.to(5, new h(5, this.lbs, new b.d(new StLBS(null, null, null, null, 15, null)))), TuplesKt.to(6, new h(6, this.medias, new b.f(new b.d(new StMedia(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null)), false))), TuplesKt.to(7, new h(7, this.uploadNumber, new b.e.i(true))), TuplesKt.to(8, new h(8, this.originUploadNumber, new b.e.i(true))), TuplesKt.to(9, new h(9, this.ext, new b.f(new b.d(new Entry(null, null, null, null, 15, null)), false))), TuplesKt.to(10, new h(10, this.linkType, new b.a(false))), TuplesKt.to(11, new h(11, this.subTitle, new b.e.g(true))), TuplesKt.to(12, new h(12, this.banner, new b.d(new BatchInfoBanner(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0)))), TuplesKt.to(13, new h(13, this.dayTime, new b.e.i(true))));
        return mapOf;
    }
}
