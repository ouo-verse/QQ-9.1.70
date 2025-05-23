package com.tencent.mobileqq.intervideo.singtogether;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import javax.annotation.Nullable;
import tr2.f;
import tr2.g;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d implements ur2.a {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f238443a;

    public d(QQAppInterface qQAppInterface) {
        this.f238443a = qQAppInterface;
    }

    private boolean h(boolean z16, Bundle bundle, String str, Context context, int i3) {
        if (z16 && i3 > 0) {
            String e16 = ((FetchOpenIdManager) this.f238443a.getManager(QQManagerFactory.FETCH_OPENID_MANAGER)).e(Long.parseLong(str), i3, true);
            if (TextUtils.isEmpty(e16)) {
                QQToast.makeText(context, "\u52a0\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\u3002", 1).show();
                return false;
            }
            bundle.putString("TOGETHER_BUNDLE_KEY_C2C_FRIEND_OPENID", e16);
        }
        return true;
    }

    private void j(String str, int i3) {
        tr2.b bVar = (tr2.b) this.f238443a.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
        if (i3 == 4) {
            ReportController.o(this.f238443a, "dc00899", "c2c_AIO", "", "sing_tab", "clk_join_suc", 0, 1, str, "", "", "");
            return;
        }
        if (i3 == 9) {
            ReportController.o(this.f238443a, "dc00899", "c2c_AIO", "", "sing_tab", "clk_singark_suc", 0, 1, str, "", "", "");
        } else if (i3 == 1) {
            bVar.N("sing_tab", "clk_join_suc", 0, str);
        } else if (i3 == 8) {
            bVar.N("sing_tab", "clk_setsing_suc", 0, str);
        }
    }

    @Override // ur2.a
    public QQCustomDialog b() {
        return null;
    }

    @Override // ur2.a
    public boolean e(Context context, String str, int i3, int i16, @Nullable Map<String, f> map, @Nullable Bundle bundle) {
        i(i3, str, context, i16, map, bundle);
        return false;
    }

    @Override // ur2.a
    public boolean f(Context context, String str, int i3, int i16, @Nullable Map<String, f> map, @Nullable Bundle bundle) {
        i(i3, str, context, i16, map, bundle);
        return false;
    }

    @Override // ur2.a
    public boolean g(Context context, String str, int i3, int i16, boolean z16, Map<String, f> map, @Nullable Bundle bundle) {
        return true;
    }

    @Override // ur2.a
    public String getBusinessName() {
        return "\u4e00\u8d77K\u6b4c";
    }

    public int i(int i3, String str, Context context, int i16, Map<String, f> map, Bundle bundle) {
        int i17;
        boolean z16;
        String b16;
        j(str, i16);
        String str2 = "4_" + i3 + "_" + str;
        if (QLog.isColorLevel()) {
            QLog.d("TogetherSingDelegate", 2, "TogetherSingDelegate start SCHEMA=" + str2 + " from=" + i16);
        }
        if (i3 == 2) {
            i17 = 2080;
        } else {
            i17 = 2081;
        }
        int i18 = i17;
        if ((i16 == 4 || i16 == 1 || i16 == 9 || i16 == 8) && map != null && map.get(str2) != null) {
            SingTogetherSession singTogetherSession = (SingTogetherSession) map.get(str2);
            if (!TextUtils.isEmpty(singTogetherSession.Q)) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(context, singTogetherSession.Q, i18, null);
                return 1;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TogetherSingDelegate", 2, "TogetherSingDelegate start SCHEMA is empty");
            }
        }
        if (TextUtils.isEmpty("")) {
            if (i3 == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!h(z16, bundle, str, context, 1109995692)) {
                return 0;
            }
            if (i3 == 1) {
                b16 = g.c("mqqapi://miniapp/open?_atype=0&_mappid=1109995692&_mvid=&_path=%2Fpages%2Findex%2Fmain&_vt=3&_sig=87d212c596d5dd75907b38e2a96705ec4d7eef6a557f4cbba1f69df0d0d991fc", bundle);
            } else {
                b16 = g.b("mqqapi://miniapp/open?_atype=0&_mappid=1109995692&_mvid=&_path=%2Fpages%2Findex%2Fmain&_vt=3&_sig=87d212c596d5dd75907b38e2a96705ec4d7eef6a557f4cbba1f69df0d0d991fc", bundle);
            }
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(context, b16, i18, null);
            if (QLog.isColorLevel()) {
                QLog.d("TogetherSingDelegate", 2, "TogetherSingDelegate start SCHEMA=" + b16);
                return 3;
            }
            return 3;
        }
        return -1;
    }

    @Override // ur2.a
    public void onDestroy() {
    }

    @Override // ur2.a
    public void d(Context context, String str, int i3, int i16, Bundle bundle) {
    }

    @Override // ur2.a
    public void a(Context context, int i3, int i16, int i17, @Nullable Map<String, f> map, @Nullable Bundle bundle) {
    }

    @Override // ur2.a
    public void c(f fVar, int i3, String str, long j3, long j16, Object obj) {
    }
}
