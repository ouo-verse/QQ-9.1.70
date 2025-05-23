package bc1;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;

/* compiled from: P */
/* loaded from: classes12.dex */
public class g implements com.tencent.mobileqq.colornote.settings.h {
    @Override // com.tencent.mobileqq.colornote.settings.h
    public void a(View view, int i3) {
        if (view == null || i3 != 17039360) {
            return;
        }
        ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).openFileSelectorByColorNoteHistory(view.getContext());
        ReportController.o(null, "dc00898", "", "", "0X800AA81", "0X800AA81", 1, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.colornote.settings.h
    public String getTitle() {
        return HardCodeUtil.qqStr(R.string.fsd);
    }

    @Override // com.tencent.mobileqq.colornote.settings.h
    public int getType() {
        return 17039360;
    }
}
