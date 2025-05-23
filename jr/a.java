package jr;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements BusinessObserver {
    public void a(double d16, double d17) {
        if (QLog.isColorLevel()) {
            QLog.d("LbsPack", 2, "handleChangeMapViewAngle= " + d16 + "|" + d17);
        }
    }

    public void b(boolean z16, Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d("LbsPack", 2, "onGetLBSPoiList, isSuccess  = " + z16);
        }
    }

    public void e(boolean z16, Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d("LbsPack", 2, "onGetRedPackPage, isSuccess  = " + z16);
        }
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        ArrayList<String> arrayList;
        if (QLog.isColorLevel()) {
            QLog.d("LbsPack", 2, "onUpdata, type=", Integer.valueOf(i3), ", isSuccess=", Boolean.valueOf(z16));
        }
        switch (i3) {
            case 0:
                f(z16, bundle);
                return;
            case 1:
                d(z16, bundle);
                return;
            case 2:
                g(z16, bundle);
                return;
            case 3:
                h(z16, bundle);
                return;
            case 4:
                e(z16, bundle);
                return;
            case 5:
                b(z16, bundle);
                return;
            case 6:
                if (bundle != null) {
                    a(bundle.getDouble("latitude"), bundle.getDouble("longitude"));
                    return;
                }
                return;
            case 7:
                int i16 = -1;
                if (bundle != null) {
                    arrayList = bundle.getStringArrayList("key_lbs_template_ids");
                    i16 = bundle.getInt("key_lbs_template_cookie", -1);
                } else {
                    arrayList = null;
                }
                c(i16, z16, arrayList);
                return;
            default:
                return;
        }
    }

    public void d(boolean z16, Bundle bundle) {
    }

    public void f(boolean z16, Bundle bundle) {
    }

    public void g(boolean z16, Bundle bundle) {
    }

    public void h(boolean z16, Bundle bundle) {
    }

    public void c(int i3, boolean z16, ArrayList<String> arrayList) {
    }
}
