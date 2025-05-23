package com.tencent.richframework.argus;

import androidx.fragment.app.Argus;
import com.tencent.richframework.argus.business.Monitor;
import com.tencent.richframework.argus.page.PageInfo;
import com.tencent.richframework.argus.page.PageInfoPO;
import com.tencent.richframework.argus.page.db.HistoryPageChange;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/richframework/argus/QQArgusManager;", "Landroidx/fragment/app/Argus$ComponentCallback;", "()V", "onPageChange", "", "fromPage", "Lcom/tencent/richframework/argus/page/PageInfo;", "fromPagePO", "Lcom/tencent/richframework/argus/page/PageInfoPO;", "newPage", "newPagePO", "groupPO", "mergeResult", "Landroidx/fragment/app/Argus$MergeResult;", "onPredictResult", "currentPageInfo", "historyPageChanges", "", "Lcom/tencent/richframework/argus/page/db/HistoryPageChange;", "qq-argus-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class QQArgusManager implements Argus.ComponentCallback {

    @NotNull
    public static final QQArgusManager INSTANCE = new QQArgusManager();

    QQArgusManager() {
    }

    @Override // androidx.fragment.app.Argus.ComponentCallback
    public void onPageChange(@Nullable PageInfo fromPage, @Nullable PageInfoPO fromPagePO, @NotNull PageInfo newPage, @NotNull PageInfoPO newPagePO, @Nullable PageInfoPO groupPO, @NotNull Argus.MergeResult mergeResult) {
        Intrinsics.checkNotNullParameter(newPage, "newPage");
        Intrinsics.checkNotNullParameter(newPagePO, "newPagePO");
        Intrinsics.checkNotNullParameter(mergeResult, "mergeResult");
        Monitor.INSTANCE.pageChanged(newPage);
    }

    @Override // androidx.fragment.app.Argus.ComponentCallback
    public void onPredictResult(@Nullable PageInfo currentPageInfo, @NotNull List<? extends HistoryPageChange> historyPageChanges) {
        Intrinsics.checkNotNullParameter(historyPageChanges, "historyPageChanges");
    }
}
