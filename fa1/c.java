package fa1;

import android.R;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c implements b {
    private int a(String str) {
        if (str != null && str.contains("\u6700\u8fd1\u6d4f\u89c8")) {
            return 1132;
        }
        return 1131;
    }

    private void b(Context context, String str, String str2, String str3, int i3) {
        String standardEntryPath = SimpleMiniAppConfig.SimpleLaunchParam.standardEntryPath(str3);
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startAppByAppid(context, str, standardEntryPath, str2, i3, null);
        if (QLog.isColorLevel()) {
            QLog.d("MiniAppLauncher_colorNote", 2, "startMiniApp, appId: " + str + ", entryPath: " + standardEntryPath + ", versionType: " + str2 + ", colorSignScene: " + i3);
        }
    }

    private void c(Context context, String str) {
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startAppByAppid(context, str, "", "", 1131, null);
        if (QLog.isColorLevel()) {
            QLog.d("MiniAppLauncher_colorNote", 2, "startMiniAppByAppId, appId: " + str);
        }
    }

    @Override // fa1.b
    public int getType() {
        return R.attr.theme;
    }

    @Override // fa1.b
    public void launch(Context context, ColorNote colorNote) {
        String str;
        String str2;
        if (colorNote.getServiceType() != 16842752) {
            return;
        }
        int a16 = a(colorNote.getSubTitle());
        String subType = colorNote.getSubType();
        if (subType.contains("#@#")) {
            String[] split = subType.split("#@#");
            if (split.length == 2) {
                String str3 = split[0];
                String str4 = split[1];
                byte[] reserve = colorNote.getReserve();
                if (reserve != null && reserve.length > 0) {
                    str2 = new String(reserve);
                } else {
                    str2 = null;
                }
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportColorSignClickAndStartMiniApp(context, str3, str2, str4, a16);
                return;
            }
            return;
        }
        if (subType.contains("###")) {
            String[] split2 = subType.split("###");
            if (split2.length == 2) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportColorSignClickAndStartMiniApp(context, split2[0], null, split2[1], a16);
                return;
            }
            return;
        }
        if (subType.contains(".")) {
            String[] split3 = subType.split("\\.");
            if (split3.length == 2) {
                String str5 = split3[0];
                String str6 = split3[1];
                byte[] reserve2 = colorNote.getReserve();
                if (reserve2 != null && reserve2.length > 0) {
                    str = new String(reserve2);
                } else {
                    str = null;
                }
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportColorSignClickWithNoAppInfo(a16);
                b(context, str5, str6, str, a16);
                return;
            }
            return;
        }
        c(context, subType);
    }

    @Override // fa1.b
    public void onCreate(Context context, ColorNote colorNote, Bundle bundle) {
    }
}
