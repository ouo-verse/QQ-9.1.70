package d7;

import com.qzone.homepage.business.model.FunnySpaceModel;
import com.qzone.homepage.business.model.QzoneCustomTrackData;
import com.qzone.homepage.ui.woo.wizard.StepOnZoneWizard;
import com.qzone.proxy.feedcomponent.util.j;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {
    public static void a(QzoneCustomTrackData qzoneCustomTrackData) {
        List<FunnySpaceModel> mergeToatalModels = QzoneCustomTrackData.mergeToatalModels(qzoneCustomTrackData, null);
        if (mergeToatalModels != null) {
            j.f("QzoneCustomTrackUtils", "preloadDownloadFeedsCustomTrack itemid" + qzoneCustomTrackData.iItemId);
            StepOnZoneWizard.h().j("QzoneCustomTrackLoadKey" + qzoneCustomTrackData.iItemId, mergeToatalModels, null, 1);
        }
    }
}
