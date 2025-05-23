package ho1;

import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes13.dex */
public class b {
    public static void a(boolean z16, View view) {
        if (view == null) {
            return;
        }
        if (z16) {
            view.setVisibility(0);
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102212", false);
            if (!isSwitchOn) {
                view.setVisibility(8);
            }
            QLog.d("GuildCommentUtil", 4, "setPicEmotionVisibly picEmoteSwitch = " + isSwitchOn);
        } else {
            view.setVisibility(8);
        }
        QLog.d("GuildCommentUtil", 4, "setPicEmotionVisibly isSupportCommentPic = " + z16);
    }
}
