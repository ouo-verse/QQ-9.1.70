package cooperation.qqcircle.relation.format;

import com.tencent.mobileqq.persistence.Entity;
import cooperation.qqcircle.relation.entitys.FriendsWrapper;
import cooperation.qqcircle.relation.entitys.QCircleFriendEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vd2.GroupInfo;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleFriendFormat {
    public static Map<GroupInfo, List<Entity>> format(List<QCircleFriendEntity> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (QCircleFriendEntity qCircleFriendEntity : list) {
            GroupInfo groupInfo = new GroupInfo(qCircleFriendEntity.mGroupId, qCircleFriendEntity.mGroupName);
            List list2 = (List) hashMap.get(groupInfo);
            if (list2 == null) {
                list2 = new ArrayList();
                hashMap.put(groupInfo, list2);
            }
            FriendsWrapper friendsWrapper = new FriendsWrapper();
            friendsWrapper.uin = String.valueOf(qCircleFriendEntity.mUin);
            friendsWrapper.name = qCircleFriendEntity.mName;
            friendsWrapper.remark = qCircleFriendEntity.mName;
            friendsWrapper.authType = qCircleFriendEntity.mAuthType;
            list2.add(friendsWrapper);
        }
        return hashMap;
    }
}
