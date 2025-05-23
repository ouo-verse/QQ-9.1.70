package ke3;

import android.os.Bundle;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.qphone.base.util.QLog;
import k74.i;

/* compiled from: P */
/* loaded from: classes38.dex */
public class f implements com.tencent.mobileqq.activity.miniaio.a {
    @Override // com.tencent.mobileqq.activity.miniaio.a
    public void a(Bundle bundle) {
        if (bundle == null) {
            QLog.d("ZPlanMiniAioObserver", 1, "notifyJumpToAio bundle is null");
        } else if (bundle.getInt(MiniChatConstants.KEY_MINI_MSGTAB_BUSINAME) == 30) {
            ((a) i.f(a.class)).notifyOpenAIO();
        }
    }

    @Override // com.tencent.mobileqq.activity.miniaio.a
    public void b(Bundle bundle) {
        if (bundle == null) {
            QLog.d("ZPlanMiniAioObserver", 1, "notifyJumpToAio bundle is null");
        } else if (bundle.getInt(MiniChatConstants.KEY_MINI_MSGTAB_BUSINAME) == 30) {
            ((a) i.f(a.class)).notifyCloseMiniAIO();
        }
    }
}
