package com.tencent.biz.qqcircle.comment.recpic.sorter;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\tB=\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0013\u0010\u000bR#\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\r\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/biz/qqcircle/comment/recpic/sorter/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "id", "b", "I", "e", "()I", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "", "c", UserInfo.SEX_FEMALE, "d", "()F", LocalPhotoFaceInfo.SCORE, "path", "", "Ljava/util/Map;", "()Ljava/util/Map;", TtmlNode.TAG_METADATA, "<init>", "(Ljava/lang/String;IFLjava/lang/String;Ljava/util/Map;)V", "f", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.comment.recpic.sorter.c, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class StrategyImage {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int strategy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final float score;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String path;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Map<String, Object> metadata;

    public StrategyImage(@NotNull String id5, int i3, float f16, @NotNull String path, @NotNull Map<String, Object> metadata) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.id = id5;
        this.strategy = i3;
        this.score = f16;
        this.path = path;
        this.metadata = metadata;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final Map<String, Object> b() {
        return this.metadata;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: d, reason: from getter */
    public final float getScore() {
        return this.score;
    }

    /* renamed from: e, reason: from getter */
    public final int getStrategy() {
        return this.strategy;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StrategyImage)) {
            return false;
        }
        StrategyImage strategyImage = (StrategyImage) other;
        if (Intrinsics.areEqual(this.id, strategyImage.id) && this.strategy == strategyImage.strategy && Float.compare(this.score, strategyImage.score) == 0 && Intrinsics.areEqual(this.path, strategyImage.path) && Intrinsics.areEqual(this.metadata, strategyImage.metadata)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.strategy) * 31) + Float.floatToIntBits(this.score)) * 31) + this.path.hashCode()) * 31) + this.metadata.hashCode();
    }

    @NotNull
    public String toString() {
        return "StrategyImage(id=" + this.id + ", strategy=" + this.strategy + ", score=" + this.score + ", path=" + this.path + ", metadata=" + this.metadata + ")";
    }

    public /* synthetic */ StrategyImage(String str, int i3, float f16, String str2, Map map, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, f16, str2, (i16 & 16) != 0 ? new LinkedHashMap() : map);
    }
}
