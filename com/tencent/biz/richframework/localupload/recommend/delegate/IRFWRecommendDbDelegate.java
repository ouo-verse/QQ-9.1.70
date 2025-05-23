package com.tencent.biz.richframework.localupload.recommend.delegate;

import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H&\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH&J\b\u0010\u000e\u001a\u00020\nH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005H&J\u0016\u0010\u0011\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\fH&JA\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H&\u00a2\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\fH&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendDbDelegate;", "", "count", "", "whereClause", "", "whereArgs", "", "(Ljava/lang/String;[Ljava/lang/String;)I", "delete", "", "needDeleteList", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "deleteAll", "getUploadHistorySize", "classifyId", "insertMediaInfo", "mediaInfos", "query", "selection", "selectionArgs", "orderBy", "limit", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "updateMediaInfo", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface IRFWRecommendDbDelegate {
    int count(@NotNull String whereClause, @NotNull String[] whereArgs);

    void delete(@NotNull List<RFWMediaInfo> needDeleteList);

    void deleteAll();

    int getUploadHistorySize(@NotNull String classifyId);

    void insertMediaInfo(@NotNull List<RFWMediaInfo> mediaInfos);

    @NotNull
    List<RFWMediaInfo> query(@Nullable String selection, @Nullable String[] selectionArgs, @Nullable String orderBy, @Nullable String limit);

    void updateMediaInfo(@NotNull List<RFWMediaInfo> mediaInfos);
}
