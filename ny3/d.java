package ny3;

import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        static volatile d f421597a = new d();
    }

    public static d a() {
        return a.f421597a;
    }

    private void b() {
        ly3.c.h(View.class, "sThrowOnInvalidFloatProperties", Boolean.FALSE);
    }

    public void c() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("scale_illegal_argument_fix_switch", false);
        if (isSwitchOn) {
            b();
        }
        QLog.w("SetScaleIllegalArgumentIssueHelper", 1, "tryFixIssue bSwitch is " + isSwitchOn + " | fieldValue is " + ((Object) QzoneWebMusicJsPlugin.EVENT_UNKOWN));
    }
}
