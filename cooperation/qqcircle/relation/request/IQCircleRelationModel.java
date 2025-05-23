package cooperation.qqcircle.relation.request;

import cooperation.qqcircle.relation.entitys.NewRelationInfo;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface IQCircleRelationModel {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface OnLoadAtRelationListener {
        void onLoadAtRelationFail(int i3, long j3, String str);

        void onLoadAtRelationFinish(int i3, Map<String, List<NewRelationInfo>> map, long j3);
    }

    void loadRelationData(int i3);

    void setOnLoadAtRelationListener(OnLoadAtRelationListener onLoadAtRelationListener);
}
