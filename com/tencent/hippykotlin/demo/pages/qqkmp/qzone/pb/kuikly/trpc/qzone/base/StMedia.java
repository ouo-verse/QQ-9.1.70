package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
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
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u00f7\u0001\u0012\u0010\b\u0002\u0010\f\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u001b\u0012\u0012\b\u0002\u00100\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`/0)\u0012\u0010\b\u0002\u00102\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`1\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u00a2\u0006\u0004\b;\u0010<J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u001e\u0010\f\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\rR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010\u001dR\u0018\u0010.\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010\u001dR\u001e\u00100\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`/0)8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010,R\u001e\u00102\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`18\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010\rR\u0018\u00104\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R \u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u000207068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u00109\u00a8\u0006="}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMedia;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/MediaType;", "type", "Ljava/lang/Integer;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StImage;", "image", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StImage;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StVideo;", "video", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StVideo;", "", "desc", "Ljava/lang/String;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StLBS;", "lbs", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StLBS;", "uploader", "", "batchId", "Ljava/lang/Long;", PhotoCategorySinglePicInfo.UPLOAD_TIME, "uploadOrder", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMediaLike;", "like", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMediaLike;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMediaComment;", "comment", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMediaComment;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;", "uploadUser", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/Entry;", "ext", "Ljava/util/List;", "shootTime", "linkId", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/MediaOpMask;", "opMask", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/MediaLBSSource;", "lbsSource", "", "isLivePhoto", "Ljava/lang/Boolean;", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Ljava/lang/Integer;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StImage;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StVideo;Ljava/lang/String;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StLBS;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMediaLike;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMediaComment;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StUser;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class StMedia extends j {
    public static final int $stable = 8;
    public Long batchId;
    public StMediaComment comment;
    public String desc;
    public final List<Entry> ext;
    public StImage image;
    public Boolean isLivePhoto;
    public StLBS lbs;
    public Integer lbsSource;
    public StMediaLike like;
    public Long linkId;
    public final List<Integer> opMask;
    public Long shootTime;
    public Integer type;
    public Integer uploadOrder;
    public Long uploadTime;
    public StUser uploadUser;
    public String uploader;
    public StVideo video;

    public StMedia() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new StMedia(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0 == true ? 1 : 0, null, null, 262143, null));
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        switch (fieldNumber) {
            case 1:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int{ com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.MetaKt.MediaType }");
                this.type = (Integer) v3;
                return;
            case 2:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StImage");
                this.image = (StImage) v3;
                return;
            case 3:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StVideo");
                this.video = (StVideo) v3;
                return;
            case 4:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.desc = (String) v3;
                return;
            case 5:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StLBS");
                this.lbs = (StLBS) v3;
                return;
            case 6:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.uploader = (String) v3;
                return;
            case 7:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.batchId = (Long) v3;
                return;
            case 8:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.uploadTime = (Long) v3;
                return;
            case 9:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
                this.uploadOrder = (Integer) v3;
                return;
            case 10:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMediaLike");
                this.like = (StMediaLike) v3;
                return;
            case 11:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMediaComment");
                this.comment = (StMediaComment) v3;
                return;
            case 12:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser");
                this.uploadUser = (StUser) v3;
                return;
            case 13:
                List<Entry> list = this.ext;
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.Entry>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) v3);
                return;
            case 14:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.shootTime = (Long) v3;
                return;
            case 15:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.linkId = (Long) v3;
                return;
            case 16:
                List<Integer> list2 = this.opMask;
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.Int{ com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.MetaKt.MediaOpMask }>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) v3);
                return;
            case 17:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int{ com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.MetaKt.MediaLBSSource }");
                this.lbsSource = (Integer) v3;
                return;
            case 18:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
                this.isLivePhoto = (Boolean) v3;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ StMedia(Integer num, StImage stImage, StVideo stVideo, String str, StLBS stLBS, String str2, Long l3, Long l16, Integer num2, StMediaLike stMediaLike, StMediaComment stMediaComment, StUser stUser, List list, Long l17, Long l18, List list2, Integer num3, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : stImage, (i3 & 4) != 0 ? null : stVideo, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : stLBS, (i3 & 32) != 0 ? null : str2, (i3 & 64) != 0 ? null : l3, (i3 & 128) != 0 ? null : l16, (i3 & 256) != 0 ? null : num2, (i3 & 512) != 0 ? null : stMediaLike, (i3 & 1024) != 0 ? null : stMediaComment, (i3 & 2048) != 0 ? null : stUser, (i3 & 4096) != 0 ? new ArrayList() : list, (i3 & 8192) != 0 ? null : l17, (i3 & 16384) != 0 ? null : l18, (i3 & 32768) != 0 ? new ArrayList() : list2, (i3 & 65536) != 0 ? null : num3, (i3 & 131072) != 0 ? null : bool);
    }

    public StMedia(Integer num, StImage stImage, StVideo stVideo, String str, StLBS stLBS, String str2, Long l3, Long l16, Integer num2, StMediaLike stMediaLike, StMediaComment stMediaComment, StUser stUser, List<Entry> list, Long l17, Long l18, List<Integer> list2, Integer num3, Boolean bool) {
        this.type = num;
        this.image = stImage;
        this.video = stVideo;
        this.desc = str;
        this.lbs = stLBS;
        this.uploader = str2;
        this.batchId = l3;
        this.uploadTime = l16;
        this.uploadOrder = num2;
        this.like = stMediaLike;
        this.comment = stMediaComment;
        this.uploadUser = stUser;
        this.ext = list;
        this.shootTime = l17;
        this.linkId = l18;
        this.opMask = list2;
        this.lbsSource = num3;
        this.isLivePhoto = bool;
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        String str = null;
        String str2 = null;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.type, new b.a(false))), TuplesKt.to(2, new h(2, this.image, new b.d(new StImage(str, str2, null, null, null, null, null, null, 255, null)))), TuplesKt.to(3, new h(3, this.video, new b.d(new StVideo(str, str2, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, null, null, null, null, 511, null)))), TuplesKt.to(4, new h(4, this.desc, new b.e.g(true))), TuplesKt.to(5, new h(5, this.lbs, new b.d(new StLBS(null, null, null, null, 15, null)))), TuplesKt.to(6, new h(6, this.uploader, new b.e.g(true))), TuplesKt.to(7, new h(7, this.batchId, new b.e.i(true))), TuplesKt.to(8, new h(8, this.uploadTime, new b.e.i(true))), TuplesKt.to(9, new h(9, this.uploadOrder, new b.e.h(true))), TuplesKt.to(10, new h(10, this.like, new b.d(new StMediaLike(null, null, null, 7, null)))), TuplesKt.to(11, new h(11, this.comment, new b.d(new StMediaComment(null, 1, null)))), TuplesKt.to(12, new h(12, this.uploadUser, new b.d(new StUser(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null)))), TuplesKt.to(13, new h(13, this.ext, new b.f(new b.d(new Entry(null, null, null, null, 15, null)), false))), TuplesKt.to(14, new h(14, this.shootTime, new b.e.i(true))), TuplesKt.to(15, new h(15, this.linkId, new b.e.i(true))), TuplesKt.to(16, new h(16, this.opMask, new b.f(new b.a(false), false))), TuplesKt.to(17, new h(17, this.lbsSource, new b.a(false))), TuplesKt.to(18, new h(18, this.isLivePhoto, new b.e.a(true))));
        return mapOf;
    }
}
