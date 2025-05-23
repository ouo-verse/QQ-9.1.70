package com.tencent.mobileqq.vas.tianshu;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.VasConstant;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TianshuWebManagerImpl implements ITianshuWebManager {
    public static String a() {
        QLog.i("TianshuWebManagerImpl", 1, "getLastClickTraceInfoJson:");
        return VasMMKV.getTianShu(BaseApplication.getContext(), VasConstant.SP_TIANSHU).getString(VasConstant.SP_TIANSHU, "{}");
    }

    @Override // com.tencent.mobileqq.vas.api.IVasManager
    @NotNull
    public String getManagerName() {
        return getClass().getName();
    }

    @Override // com.tencent.mobileqq.vas.tianshu.ITianshuWebManager
    @NotNull
    public String getTraceInfoOfLastClick() {
        return a();
    }

    @Override // com.tencent.mobileqq.vas.tianshu.ITianshuWebManager
    public void setTraceInfoOfLastClick(@NotNull final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.tianshu.TianshuWebManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.i("TianshuWebManagerImpl", 1, "setTraceInfoOfLastClick:" + str);
                SharedPreferences.Editor edit = VasMMKV.getTianShu(BaseApplication.getContext(), VasConstant.SP_TIANSHU).edit();
                edit.putString(VasConstant.SP_TIANSHU, str);
                edit.apply();
            }
        }, 64, null, true);
    }
}
