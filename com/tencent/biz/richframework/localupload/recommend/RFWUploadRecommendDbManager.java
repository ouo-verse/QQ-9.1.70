package com.tencent.biz.richframework.localupload.recommend;

import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0014\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002JA\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0011\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010\u0012\u001a\u00020\u0005J#\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\n\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;", "", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "mediaInfos", "", "updateMediaInfo", "insertMediaInfo", "", "selection", "", "selectionArgs", "orderBy", "limit", "query", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "needDeleteList", "delete", "deleteAll", "whereClause", "whereArgs", "", "count", "(Ljava/lang/String;[Ljava/lang/String;)I", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "mContext", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "getMContext", "()Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "<init>", "(Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;)V", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class RFWUploadRecommendDbManager {

    @NotNull
    private final RecommendContext mContext;

    public RFWUploadRecommendDbManager(@NotNull RecommendContext mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
    }

    public final int count(@NotNull String whereClause, @NotNull String[] whereArgs) {
        Intrinsics.checkNotNullParameter(whereClause, "whereClause");
        Intrinsics.checkNotNullParameter(whereArgs, "whereArgs");
        return this.mContext.getDelegate().getDbDelegate().count(whereClause, whereArgs);
    }

    public final void delete(@NotNull List<RFWMediaInfo> needDeleteList) {
        Intrinsics.checkNotNullParameter(needDeleteList, "needDeleteList");
        this.mContext.getDelegate().getDbDelegate().delete(needDeleteList);
    }

    public final void deleteAll() {
        this.mContext.getDelegate().getDbDelegate().deleteAll();
    }

    public final void insertMediaInfo(@NotNull List<RFWMediaInfo> mediaInfos) {
        Intrinsics.checkNotNullParameter(mediaInfos, "mediaInfos");
        this.mContext.getDelegate().getDbDelegate().insertMediaInfo(mediaInfos);
    }

    @NotNull
    public final List<RFWMediaInfo> query(@Nullable String selection, @Nullable String[] selectionArgs, @Nullable String orderBy, @Nullable String limit) {
        return this.mContext.getDelegate().getDbDelegate().query(selection, selectionArgs, orderBy, limit);
    }

    public final void updateMediaInfo(@NotNull List<RFWMediaInfo> mediaInfos) {
        Intrinsics.checkNotNullParameter(mediaInfos, "mediaInfos");
        this.mContext.getDelegate().getDbDelegate().updateMediaInfo(mediaInfos);
    }
}
