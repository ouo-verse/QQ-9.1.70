package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import com.tencent.aelight.camera.constants.AEEditorConstants;
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
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001Bk\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0014R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 0\u001f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellMedia;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMedia;", "mediaItems", "Ljava/util/List;", "", AEEditorConstants.ALBUMNAME, "Ljava/lang/String;", "albumId", "uploadNum", "Ljava/lang/Integer;", "", "batchId", "Ljava/lang/Long;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StImage;", "albumCover", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StImage;", "albumUploadNum", "", "longPicsBrowsingMode", "Ljava/lang/Boolean;", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StImage;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class StFeedCellMedia extends j {
    public StImage albumCover;
    public String albumId;
    public String albumName;
    public Integer albumUploadNum;
    public Long batchId;
    public Boolean longPicsBrowsingMode;
    public final List<StMedia> mediaItems;
    public Integer uploadNum;

    public StFeedCellMedia() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new StFeedCellMedia(null, null, null, null, null, null, null, null, 255, null));
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        switch (fieldNumber) {
            case 1:
                List<StMedia> list = this.mediaItems;
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) v3);
                return;
            case 2:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.albumName = (String) v3;
                return;
            case 3:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.String");
                this.albumId = (String) v3;
                return;
            case 4:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
                this.uploadNum = (Integer) v3;
                return;
            case 5:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Long");
                this.batchId = (Long) v3;
                return;
            case 6:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StImage");
                this.albumCover = (StImage) v3;
                return;
            case 7:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
                this.albumUploadNum = (Integer) v3;
                return;
            case 8:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Boolean");
                this.longPicsBrowsingMode = (Boolean) v3;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ StFeedCellMedia(List list, String str, String str2, Integer num, Long l3, StImage stImage, Integer num2, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : list, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : num, (i3 & 16) != 0 ? null : l3, (i3 & 32) != 0 ? null : stImage, (i3 & 64) != 0 ? null : num2, (i3 & 128) == 0 ? bool : null);
    }

    public StFeedCellMedia(List<StMedia> list, String str, String str2, Integer num, Long l3, StImage stImage, Integer num2, Boolean bool) {
        this.mediaItems = list;
        this.albumName = str;
        this.albumId = str2;
        this.uploadNum = num;
        this.batchId = l3;
        this.albumCover = stImage;
        this.albumUploadNum = num2;
        this.longPicsBrowsingMode = bool;
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.mediaItems, new b.f(new b.d(new StMedia(null, null, null, null, null, null, 0 == true ? 1 : 0, null, null, null, null, null, null, null, null, null, null, null, 262143, null)), false))), TuplesKt.to(2, new h(2, this.albumName, new b.e.g(true))), TuplesKt.to(3, new h(3, this.albumId, new b.e.g(true))), TuplesKt.to(4, new h(4, this.uploadNum, new b.e.C0168e(true))), TuplesKt.to(5, new h(5, this.batchId, new b.e.i(true))), TuplesKt.to(6, new h(6, this.albumCover, new b.d(new StImage(null, null, null, null, null, null, null, null, 255, null)))), TuplesKt.to(7, new h(7, this.albumUploadNum, new b.e.C0168e(true))), TuplesKt.to(8, new h(8, this.longPicsBrowsingMode, new b.e.a(true))));
        return mapOf;
    }
}
