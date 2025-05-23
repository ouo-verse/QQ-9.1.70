package d7;

import com.qzone.common.event.Observable;
import com.qzone.homepage.business.model.CmActionListData;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends Observable {
    public static void C(long j3, CmActionListData cmActionListData) {
        if (cmActionListData != null && cmActionListData.m2DActionList != null && cmActionListData.m3DActionList != null) {
            try {
                new ArrayList().add(String.valueOf(j3));
                int size = cmActionListData.m2DActionList.size() + cmActionListData.m3DActionList.size();
                int[] iArr = new int[size];
                int i3 = 0;
                int i16 = 0;
                while (i3 < size) {
                    iArr[i3] = Integer.parseInt(cmActionListData.m2DActionList.get(i16).strItemId);
                    iArr[i3 + 1] = Integer.parseInt(cmActionListData.m3DActionList.get(i16).strItemId);
                    i3 += 2;
                    i16++;
                }
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                QZLog.e("QzoneCmTrackManager", 1, "preloadCmActionData exception = " + e16.getMessage());
                return;
            }
        }
        QZLog.e("QzoneCmTrackManager", 1, "preloadCmActionData data = null");
    }
}
