package com.tencent.mobileqq.config;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.mini.share.MiniShareQuicklySendPanelFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class DeepCleanConfigProcessor extends l<a> {

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f202202a = 0;

        /* renamed from: b, reason: collision with root package name */
        private String f202203b = "";

        /* renamed from: c, reason: collision with root package name */
        private String f202204c = "";

        /* renamed from: d, reason: collision with root package name */
        private String f202205d = "";

        /* renamed from: e, reason: collision with root package name */
        private String f202206e = "";

        public static a f(String str) {
            a aVar = new a();
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("deep_clean_switch")) {
                        aVar.f202202a = jSONObject.optInt("deep_clean_switch");
                    }
                    if (jSONObject.has("already_installed_tip")) {
                        aVar.f202203b = jSONObject.optString("already_installed_tip");
                    }
                    if (jSONObject.has("first_not_installed_tip")) {
                        aVar.f202204c = jSONObject.optString("first_not_installed_tip");
                    }
                    if (jSONObject.has("second_not_installed_tip")) {
                        aVar.f202205d = jSONObject.optString("second_not_installed_tip");
                    }
                    if (jSONObject.has("third_not_installed_tip")) {
                        aVar.f202206e = jSONObject.optString("third_not_installed_tip");
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                if (QLog.isColorLevel()) {
                    QLog.i("DeepCleanConfigProcessor", 2, "parse DeepCleanConfigBean: " + str);
                }
            }
            return aVar;
        }

        public boolean e() {
            if (this.f202202a == 1) {
                return true;
            }
            return false;
        }
    }

    public static String a(Context context, boolean z16) {
        a aVar = (a) am.s().x(MiniShareQuicklySendPanelFragment.QUCIKLY_SHARE_REQUEST_CODE);
        String str = "";
        if (aVar != null) {
            if (z16) {
                str = aVar.f202203b;
            } else if (h(context)) {
                str = aVar.f202204c;
            } else {
                int intValue = ((Integer) com.tencent.mobileqq.utils.p.b(context, "", AppConstants.Preferences.KEY_DEEP_CLEAN_SHOW_TIME, 0)).intValue();
                f(context, intValue);
                str = intValue != 0 ? intValue != 1 ? aVar.f202206e : aVar.f202205d : aVar.f202204c;
            }
        }
        if (TextUtils.isEmpty(str)) {
            return context.getString(R.string.zqm);
        }
        return str;
    }

    public static boolean e() {
        a aVar = (a) am.s().x(MiniShareQuicklySendPanelFragment.QUCIKLY_SHARE_REQUEST_CODE);
        if (aVar != null && aVar.e()) {
            return true;
        }
        return false;
    }

    private static void f(Context context, int i3) {
        if (i3 < 2) {
            com.tencent.mobileqq.utils.p.g(context, "", true, AppConstants.Preferences.KEY_DEEP_CLEAN_SHOW_TIME, Integer.valueOf(i3 + 1));
        }
    }

    public static void g() {
        com.tencent.mobileqq.utils.p.g(BaseApplication.getContext(), "", true, AppConstants.Preferences.KEY_DEEP_CLEAN_USER_CLICK, Boolean.TRUE);
    }

    private static boolean h(Context context) {
        return ((Boolean) com.tencent.mobileqq.utils.p.b(context, "", AppConstants.Preferences.KEY_DEEP_CLEAN_USER_CLICK, Boolean.FALSE)).booleanValue();
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a onParsed(ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d("DeepCleanConfigProcessor", 2, "onParsed");
        }
        if (aiVarArr != null && aiVarArr.length > 0) {
            String str = aiVarArr[0].f202268b;
            if (QLog.isColorLevel()) {
                QLog.d("DeepCleanConfigProcessor", 2, "onParsed, content:" + str);
            }
            return a.f(str);
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a> clazz() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
        com.tencent.mobileqq.utils.p.g(BaseApplication.getContext(), "", true, AppConstants.Preferences.KEY_DEEP_CLEAN_SHOW_TIME, 0);
        com.tencent.mobileqq.utils.p.g(BaseApplication.getContext(), "", true, AppConstants.Preferences.KEY_DEEP_CLEAN_USER_CLICK, Boolean.FALSE);
        if (QLog.isColorLevel()) {
            QLog.d("DeepCleanConfigProcessor", 2, "DeepCleanConfigProcessor onUpdate");
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isAccountRelated() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return MiniShareQuicklySendPanelFragment.QUCIKLY_SHARE_REQUEST_CODE;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
