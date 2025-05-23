package com.tencent.state.template.map;

import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.state.common.tag.CommonTagInfo;
import com.tencent.state.map.IMapViewUpdater;
import com.tencent.state.template.data.User;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/template/map/ITemplateViewUpdater;", "Lcom/tencent/state/map/IMapViewUpdater;", "sitDown", "", "tableId", "", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "standUp", "uin", "updateDeskMateTag", "", "tag", "Lcom/tencent/state/common/tag/CommonTagInfo;", "updateUserLikeCount", MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT, "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface ITemplateViewUpdater extends IMapViewUpdater {
    void sitDown(long tableId, User user);

    void standUp(long tableId, long uin);

    void updateDeskMateTag(String uin, CommonTagInfo tag);

    void updateUserLikeCount(long uin, int likeCount);
}
