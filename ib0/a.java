package ib0;

import com.tencent.biz.qqcircle.beans.QFSPublishTempInfo;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSTabFeedViewModel;
import com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerFieldIdToLocalPath;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements IRFWPlayerFieldIdToLocalPath {
    @Override // com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerFieldIdToLocalPath
    public String getLocalPath(String str) {
        QFSPublishTempInfo qFSPublishTempInfo = QFSTabFeedViewModel.Y.get(str);
        if (qFSPublishTempInfo != null) {
            return qFSPublishTempInfo.getLocalPath();
        }
        return "";
    }
}
