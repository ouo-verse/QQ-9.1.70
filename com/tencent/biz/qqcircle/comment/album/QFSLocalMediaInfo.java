package com.tencent.biz.qqcircle.comment.album;

import com.heytap.databaseengine.model.UserInfo;
import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001d\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u000e\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/biz/qqcircle/comment/album/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "a", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "()Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "localMediaInfo", "b", "Z", "d", "()Z", "isRec", "c", "I", "()I", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "", UserInfo.SEX_FEMALE, "getSimilarity", "()F", "similarity", "e", LocalPhotoFaceInfo.SCORE, "<init>", "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;ZIFF)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.comment.album.k, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class QFSLocalMediaInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final LocalMediaInfo localMediaInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isRec;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int strategy;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final float similarity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final float score;

    public QFSLocalMediaInfo(@NotNull LocalMediaInfo localMediaInfo, boolean z16, int i3, float f16, float f17) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        this.localMediaInfo = localMediaInfo;
        this.isRec = z16;
        this.strategy = i3;
        this.similarity = f16;
        this.score = f17;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final LocalMediaInfo getLocalMediaInfo() {
        return this.localMediaInfo;
    }

    /* renamed from: b, reason: from getter */
    public final float getScore() {
        return this.score;
    }

    /* renamed from: c, reason: from getter */
    public final int getStrategy() {
        return this.strategy;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsRec() {
        return this.isRec;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QFSLocalMediaInfo)) {
            return false;
        }
        QFSLocalMediaInfo qFSLocalMediaInfo = (QFSLocalMediaInfo) other;
        if (Intrinsics.areEqual(this.localMediaInfo, qFSLocalMediaInfo.localMediaInfo) && this.isRec == qFSLocalMediaInfo.isRec && this.strategy == qFSLocalMediaInfo.strategy && Float.compare(this.similarity, qFSLocalMediaInfo.similarity) == 0 && Float.compare(this.score, qFSLocalMediaInfo.score) == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.localMediaInfo.hashCode() * 31;
        boolean z16 = this.isRec;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((((hashCode + i3) * 31) + this.strategy) * 31) + Float.floatToIntBits(this.similarity)) * 31) + Float.floatToIntBits(this.score);
    }

    @NotNull
    public String toString() {
        return "QFSLocalMediaInfo(localMediaInfo=" + this.localMediaInfo + ", isRec=" + this.isRec + ", strategy=" + this.strategy + ", similarity=" + this.similarity + ", score=" + this.score + ")";
    }

    public /* synthetic */ QFSLocalMediaInfo(LocalMediaInfo localMediaInfo, boolean z16, int i3, float f16, float f17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(localMediaInfo, z16, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? 0.0f : f16, (i16 & 16) != 0 ? 0.0f : f17);
    }
}
