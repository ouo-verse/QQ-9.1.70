package jl1;

import com.tencent.richframework.data.idata.IDataConverter;
import com.tencent.richframework.data.idata.IDataWeakSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0011"}, d2 = {"Ljl1/d;", "Lcom/tencent/richframework/data/idata/IDataConverter;", "Ljl1/e;", "Lcom/tencent/richframework/data/idata/IDataWeakSupport;", "fromObj", "", "b", "oldObj", "latestObj", "", "c", "preObj", "a", "", "isSupportWeakData", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d implements IDataConverter<CommentRankingTypeData>, IDataWeakSupport {
    @Override // com.tencent.richframework.data.idata.IDataConverter
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CommentRankingTypeData cloneConvertData(@Nullable CommentRankingTypeData preObj) {
        if (preObj == null) {
            return new CommentRankingTypeData("", 0);
        }
        return preObj;
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getObserverKey(@Nullable CommentRankingTypeData fromObj) {
        String feedId;
        if (fromObj == null || (feedId = fromObj.getFeedId()) == null) {
            return "";
        }
        return feedId;
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(@NotNull CommentRankingTypeData oldObj, @NotNull CommentRankingTypeData latestObj) {
        Intrinsics.checkNotNullParameter(oldObj, "oldObj");
        Intrinsics.checkNotNullParameter(latestObj, "latestObj");
        oldObj.c(latestObj.getType());
    }

    @Override // com.tencent.richframework.data.idata.IDataWeakSupport
    public boolean isSupportWeakData() {
        return true;
    }
}
