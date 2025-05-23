package com.tencent.mobileqq;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes9.dex */
public class av implements com.tencent.mobileqq.vip.api.j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<View> f199912a;

    public av(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
        } else {
            this.f199912a = new WeakReference<>(view);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.vip.api.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void changed(@NonNull VipData vipData, @Nullable VipData vipData2) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) vipData, (Object) vipData2);
            return;
        }
        View view = this.f199912a.get();
        if (view == null) {
            return;
        }
        VipData.VipNumberInfo[] vipNumberInfos = vipData.getVipNumberInfos();
        if (vipData2 == null) {
            if (vipNumberInfos.length > 0) {
                QLog.i("WeakVipDataChangedCallback", 1, "new vip number info is not empty");
                z16 = true;
                if (!z16) {
                    ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).setAvatarDrawable(view);
                    return;
                }
                return;
            }
            z16 = false;
            if (!z16) {
            }
        } else {
            VipData.VipNumberInfo[] vipNumberInfos2 = vipData2.getVipNumberInfos();
            if (vipNumberInfos.length != vipNumberInfos2.length) {
                QLog.i("WeakVipDataChangedCallback", 1, "new vip number info size not equal");
                z16 = true;
                if (!z16) {
                }
            } else {
                boolean z17 = false;
                for (VipData.VipNumberInfo vipNumberInfo : vipNumberInfos) {
                    boolean z18 = false;
                    for (VipData.VipNumberInfo vipNumberInfo2 : vipNumberInfos2) {
                        if (vipNumberInfo.getAppId() == vipNumberInfo2.getAppId() && vipNumberInfo.getItemId() == vipNumberInfo2.getItemId() && vipNumberInfo.getNumberItemId() == vipNumberInfo.getNumberItemId() && vipNumberInfo.getNumberIdx() == vipNumberInfo2.getNumberIdx() && vipNumberInfo.isLongNumber() == vipNumberInfo2.isLongNumber()) {
                            z18 = true;
                        }
                    }
                    if (!z18) {
                        QLog.i("WeakVipDataChangedCallback", 1, "number info is different");
                        z17 = true;
                    }
                }
                z16 = z17;
                if (!z16) {
                }
            }
        }
    }
}
