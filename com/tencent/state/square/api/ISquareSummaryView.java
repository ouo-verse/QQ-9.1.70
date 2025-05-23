package com.tencent.state.square.api;

import android.view.View;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0007H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/square/api/ISquareSummaryView;", "", "getSummaryMsgText", "", "getView", "Landroid/view/View;", "isContainerEmoji", "", "setSummaryData", "", "summaryData", "Lcom/tencent/state/square/api/SummaryData;", DownloadInfo.spKey_Config, "Lcom/tencent/state/square/api/SquareSummaryViewConfig;", "setSummaryMsgText", "text", "isContainEmoji", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface ISquareSummaryView {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void setSummaryData$default(ISquareSummaryView iSquareSummaryView, SummaryData summaryData, SquareSummaryViewConfig squareSummaryViewConfig, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    squareSummaryViewConfig = null;
                }
                iSquareSummaryView.setSummaryData(summaryData, squareSummaryViewConfig);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSummaryData");
        }
    }

    @NotNull
    String getSummaryMsgText();

    @NotNull
    View getView();

    boolean isContainerEmoji();

    void setSummaryData(@NotNull SummaryData summaryData, @Nullable SquareSummaryViewConfig config);

    void setSummaryMsgText(@NotNull String text, boolean isContainEmoji);
}
