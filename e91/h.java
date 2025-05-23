package e91;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.ark.data.ArkAppElement;
import com.tencent.mobileqq.config.n;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class h extends g implements n<String> {

    /* renamed from: q, reason: collision with root package name */
    protected String f395986q = "";

    private void i(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("ark_download_ctrl_disable_list");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                String optString = optJSONArray.optString(i3);
                if (!TextUtils.isEmpty(optString)) {
                    this.f395985o.add(optString);
                }
            }
        }
        QLog.d("ArkApp.ArkPlatformConfig", 1, "ark.dctrl get config disable download ctrl apps=", this.f395985o.toString());
    }

    private void j(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("ark_force_update_app_list");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                String optString = optJSONArray.optString(i3);
                if (!TextUtils.isEmpty(optString)) {
                    this.f395971a.add(new ArkAppElement(optString, ""));
                    QLog.d("ArkApp.ArkPlatformConfig", 1, "get config update app=", optString);
                }
            }
        }
    }

    private void k(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("app_global_url_config");
        if (optJSONObject != null) {
            JSONArray optJSONArray = optJSONObject.optJSONArray("white");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i3 = 0; i3 < length; i3++) {
                    String optString = optJSONArray.optString(i3, "");
                    if (!TextUtils.isEmpty(optString)) {
                        QLog.d("ArkApp.ArkPlatformConfig", 1, "onParse white url = " + optString);
                        arrayList.add(optString);
                    }
                }
                QLog.d("ArkApp.ArkPlatformConfig", 1, "white list size =", Integer.valueOf(arrayList.size()));
                this.f395983m.put("white", arrayList);
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("black");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                ArrayList<String> arrayList2 = new ArrayList<>();
                for (int i16 = 0; i16 < length2; i16++) {
                    String optString2 = optJSONArray2.optString(i16, "");
                    if (!TextUtils.isEmpty(optString2)) {
                        QLog.d("ArkApp.ArkPlatformConfig", 1, "onParse black url = " + optString2);
                        arrayList2.add(optString2);
                    }
                }
                QLog.d("ArkApp.ArkPlatformConfig", 1, "black list size = " + arrayList2.size());
                this.f395983m.put("black", arrayList2);
            }
        }
        QLog.d("ArkApp.ArkPlatformConfig", 1, "mGlobalUrlConfig list size = " + this.f395983m.size());
    }

    private void l(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                String optString = jSONObject2.optString("app_name");
                int optInt = jSONObject2.optInt("preload");
                String optString2 = jSONObject2.optString(QQCustomArkDialogUtil.BIZ_SRC);
                if (!TextUtils.isEmpty(optString)) {
                    c91.d dVar = new c91.d();
                    dVar.f30469a = optString;
                    dVar.f30470b = optInt;
                    dVar.f30471c = optString2;
                    QLog.d("ArkApp.ArkPlatformConfig", 1, "onParse predownload_cfg_list name = " + optString + ", preload = " + optInt);
                    this.f395982l.put(optString, dVar);
                } else {
                    QLog.d("ArkApp.ArkPlatformConfig", 1, "onParse predownload_cfg_list app_name is empty");
                }
            }
        }
        QLog.d("ArkApp.ArkPlatformConfig", 1, "onParse mPreDownload list size =", Integer.valueOf(this.f395982l.size()));
    }

    private void m(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("ark_url_check_disable_apps");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                String optString = optJSONArray.optString(i3);
                if (!TextUtils.isEmpty(optString)) {
                    this.f395984n.add(optString);
                    QLog.d("ArkApp.ArkPlatformConfig", 1, "get config disable app=", optString);
                }
            }
        }
    }

    private void n(JSONObject jSONObject) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (jSONObject.optInt("ark_vip_report_enable", 1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f395974d = z16;
        if (jSONObject.optInt("back_to_file_scheme_enable", 1) == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.f395975e = z17;
        if (jSONObject.optInt("add_backslash_enable", 1) == 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        this.f395977g = z18;
        QLog.d("ArkApp.ArkPlatformConfig", 1, "ark VipReport enable=", Boolean.valueOf(c()), ", mIsBackToFileSchemeEnable=", Boolean.valueOf(d()), ", mAddBackslashEnable=", Boolean.valueOf(this.f395977g));
    }

    @Override // com.tencent.mobileqq.config.n
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onParse(String str) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        if (TextUtils.isEmpty(str)) {
            QLog.i("ArkApp.ArkPlatformConfig", 1, "onParse,fileOrRes is null");
            return;
        }
        this.f395986q = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            j(jSONObject);
            if (jSONObject.optInt("ark_url_check_enable", 1) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f395972b = z16;
            QLog.d("ArkApp.ArkPlatformConfig", 1, "mIsUrlCheckEnable = ", Boolean.valueOf(g()));
            if (jSONObject.optInt("debug_log_enabled", 0) == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.f395979i = z17;
            QLog.d("ArkApp.ArkPlatformConfig", 1, "mIsDebugLogEnabled = ", Boolean.valueOf(e()));
            m(jSONObject);
            if (jSONObject.optInt("ark_memory_optimize", 1) == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            this.f395973c = z18;
            QLog.d("ArkApp.ArkPlatformConfig", 1, "mIsOptimizeEnable = ", Boolean.valueOf(f()));
            if (jSONObject.optInt("ark_set_custom_font_enable", 1) == 1) {
                z19 = true;
            } else {
                z19 = false;
            }
            this.f395976f = z19;
            QLog.d("ArkApp.ArkPlatformConfig", 1, "mArkSetCustomFontEnable = ", Boolean.valueOf(b()));
            if (jSONObject.optInt("wt_url_new_rule", 1) == 1) {
                z26 = true;
            } else {
                z26 = false;
            }
            this.f395978h = z26;
            this.f395980j = jSONObject.optInt("max_view_height_in_aio", g.f395970p);
            String optString = jSONObject.optString("ark_toast_info_config", "");
            this.f395981k = optString;
            QLog.d("ArkApp.ArkPlatformConfig", 1, "mToastStr = ", optString);
            int i3 = Build.VERSION.SDK_INT;
            if (i3 < 28) {
                QLog.d("ArkApp.ArkPlatformConfig", 1, "parsePredownloadConfig below android9.0 version " + i3);
                l(jSONObject, "low_predownload_cfg_list");
            } else {
                l(jSONObject, "predownload_cfg_list");
            }
            k(jSONObject);
            i(jSONObject);
            n(jSONObject);
        } catch (JSONException e16) {
            QLog.e("ArkApp.ArkPlatformConfig", 1, "onParse error e = ", e16);
        }
    }
}
