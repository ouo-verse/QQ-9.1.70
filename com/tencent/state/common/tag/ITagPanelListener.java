package com.tencent.state.common.tag;

import com.tencent.state.template.data.SitDownTagParams;
import com.tencent.state.template.data.User;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/common/tag/ITagPanelListener;", "", "onFocusFailed", "", "isDueToRoomFull", "", "params", "Lcom/tencent/state/template/data/SitDownTagParams;", "onFocusSuccess", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface ITagPanelListener {
    void onFocusFailed(boolean isDueToRoomFull, SitDownTagParams params);

    void onFocusSuccess(User user);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class DefaultImpls {
        public static void onFocusFailed(ITagPanelListener iTagPanelListener, boolean z16, SitDownTagParams sitDownTagParams) {
        }
    }
}
