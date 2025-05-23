package p60;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSTabFeedViewModel;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public interface b {
    QCircleTabInfo G();

    void a(@NonNull UIStateData<List<e30.b>> uIStateData);

    void b(String str);

    void c(@NonNull QFSTabFeedViewModel.c cVar);

    MutableLiveData<QFSTabFeedViewModel.c> d();
}
