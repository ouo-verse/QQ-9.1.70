package com.tencent.mobileqq.intervideo.now;

import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.intervideo.IBaseApplicationImplUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b implements Manager {

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f238334d;

    public b(AppInterface appInterface) {
        this.f238334d = appInterface;
    }

    public void a(String str) {
        int i3;
        int i16 = 0;
        if (StringUtil.isEmpty(str)) {
            SharedPreferences sharedPreferences = ((IBaseApplicationImplUtil) QRoute.api(IBaseApplicationImplUtil.class)).getContext().getSharedPreferences("now_download_config", 4);
            sharedPreferences.edit().putInt("key_now_download_engine", 0).commit();
            sharedPreferences.edit().putInt("key_now_channel", 0).commit();
            QLog.e("NowGeneralConfigManager", 4, "NowGeneralConfigManager----parseJson---downloadEngine = 0");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("now_download_engine")) {
                i3 = jSONObject.getInt("now_download_engine");
            } else {
                i3 = 0;
            }
            if (jSONObject.has("now_channel")) {
                i16 = jSONObject.getInt("now_channel");
            }
            QLog.e("NowGeneralConfigManager", 4, "NowGeneralConfigManager----parseJson---downloadEngine = " + i3 + ", nowChannel = " + i16);
            SharedPreferences sharedPreferences2 = ((IBaseApplicationImplUtil) QRoute.api(IBaseApplicationImplUtil.class)).getContext().getSharedPreferences("now_download_config", 4);
            sharedPreferences2.edit().putInt("key_now_download_engine", i3).commit();
            sharedPreferences2.edit().putInt("key_now_channel", i16).commit();
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }
}
