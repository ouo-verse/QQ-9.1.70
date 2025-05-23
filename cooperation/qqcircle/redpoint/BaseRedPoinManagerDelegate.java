package cooperation.qqcircle.redpoint;

import java.util.List;
import qqcircle.QQCircleCounter$RedPointInfo;

/* loaded from: classes28.dex */
public interface BaseRedPoinManagerDelegate {
    void clearPedPoint();

    QQCircleCounter$RedPointInfo getFriendRedPointInfoByAppId(String str);

    QQCircleCounter$RedPointInfo getGalleryRedPointInfoByAppId(String str, int i3);

    QQCircleCounter$RedPointInfo getLastReceiveOuterEntranceRedPointInfoByAppid(String str);

    QQCircleCounter$RedPointInfo getNumRedPointInfotByAppid(String str);

    QQCircleCounter$RedPointInfo getOuterEntranceRedPointInfoByAppid(String str);

    QQCircleCounter$RedPointInfo getQQMainTabOuterEntranceRedPointInfoByAppId(String str);

    QQCircleCounter$RedPointInfo getSmallRedPointInfotByAppid(String str);

    void loadRedPointFromSP();

    void setFriendRedPointRead(String str, boolean z16);

    void setNumRedPointReaded(String str);

    void setOuterEntranceRedPointReaded(String str, List<Integer> list);

    void setSmallRedPointReaded(String str);
}
