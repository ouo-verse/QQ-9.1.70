package ea1;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b implements BusinessObserver {
    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        if (i3 != 1) {
            if (i3 == 2 && QLog.isColorLevel()) {
                QLog.d("ColorNoteObserver", 2, "onUpdate: TYPE_REQ_SET_COLOR_NOTE_RECENT_SWITCH");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ColorNoteObserver", 2, "onUpdate: TYPE_REQ_GET_COLOR_NOTE_RECENT_SWITCH");
        }
    }
}
