package ka1;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.data.ColorNoteHandler;
import com.tencent.mobileqq.colornote.settings.g;
import com.tencent.mobileqq.statistics.ReportController;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements g {
    @Override // com.tencent.mobileqq.colornote.settings.g
    public void a(boolean z16) {
        int i3;
        ((ColorNoteHandler) ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getBusinessHandler(BusinessHandlerFactory.COLOR_NOTE_HANDLER)).I2(z16);
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        ReportController.o(null, "dc00898", "", "", "0X800A8B0", "0X800A8B0", i3, 0, "", "", "", "");
    }
}
