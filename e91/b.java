package e91;

import android.text.TextUtils;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.config.n;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b extends a implements n<String> {
    private void b(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("ark_module_api_frequency");
        int i3 = 1;
        if (optJSONArray != null) {
            int i16 = 0;
            while (i16 < optJSONArray.length()) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i16);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("module");
                    String optString2 = optJSONObject.optString(DTConstants.TAG.API);
                    long optLong = optJSONObject.optLong(Element.ELEMENT_NAME_TIMES, -1L);
                    long optLong2 = optJSONObject.optLong("period", -1L);
                    Object[] objArr = new Object[8];
                    objArr[0] = "onParse ark_module_api_frequency module = ";
                    objArr[i3] = optString;
                    objArr[2] = "api = ";
                    objArr[3] = optString2;
                    objArr[4] = "times = ";
                    objArr[5] = Long.valueOf(optLong);
                    objArr[6] = "period = ";
                    objArr[7] = Long.valueOf(optLong2);
                    QLog.d("AiKeywordConfig", i3, objArr);
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && optLong != -1 && optLong2 != -1) {
                        this.f395942c.add(new c91.c(optString, optString2, optLong, optLong2));
                    }
                }
                i16++;
                i3 = 1;
            }
        }
        QLog.d("AiKeywordConfig", 1, "onParse,mArkModuleApiFrequencyList list size =", Integer.valueOf(this.f395942c.size()));
    }

    private void c(JSONObject jSONObject) {
        this.f395944e = jSONObject.optInt("singlecontext_singleapp_card_limit", 5);
        this.f395945f = jSONObject.optInt("ark_app_limit", 3);
        this.f395946g = jSONObject.optInt("ark_each_app_card_limit", 1);
        this.f395947h = jSONObject.optInt("ark_input_apps_limit", 3);
        this.f395948i = jSONObject.optInt("ark_input_each_context_apps_limit", 3);
        this.f395949j = jSONObject.optInt("ark_babyq_card_limit_total", 10);
        this.f395950k = jSONObject.optInt("ark_babyq_card_limit_per_app", 1);
        this.f395951l = jSONObject.optInt("ark_babyq_guide_count_limit_per_day", 1);
        this.f395952m = jSONObject.optInt("ark_babyq_guide_day_limit_total", 3);
        this.f395953n = jSONObject.optString("ark_babyq_guide_hint_text");
        this.f395954o = jSONObject.optLong("ark_babyq_bubble_disappear_duration", 10000L);
    }

    private void d(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("ark_babyq_input_hint_text_list");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String optString = optJSONArray.optString(i3);
                if (!TextUtils.isEmpty(optString)) {
                    QLog.d("AiKeywordConfig", 1, "onParse ark_babyq_input_hint_text_list itemStr = ", optString);
                    this.f395955p.add(optString);
                }
            }
        }
        QLog.d("AiKeywordConfig", 1, "onParse mArkBabyqInputHintTextList list size =", Integer.valueOf(this.f395955p.size()));
    }

    private void e(JSONObject jSONObject) {
        this.f395956q = jSONObject.optString("ark_babyq_no_result_recommend_title");
        JSONArray optJSONArray = jSONObject.optJSONArray("ark_babyq_no_result_recommend_items");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                String optString = optJSONArray.optString(i3);
                if (!TextUtils.isEmpty(optString)) {
                    QLog.d("AiKeywordConfig", 1, "onParse ark_babyq_no_result_recommend_items itemStr = ", optString);
                    this.f395957r.add(optString);
                }
            }
        }
        QLog.d("AiKeywordConfig", 1, "onParse mArkBabyqNoResultRecommendItems list size =", Integer.valueOf(this.f395957r.size()));
    }

    private void f(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("ark_jsdebugger_download");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("jscmd5");
                    String optString2 = optJSONObject.optString("url");
                    String optString3 = optJSONObject.optString("md5");
                    QLog.d("AiKeywordConfig", 1, "onParse jscomd5 = ", optString, "ur = ", optString2, "md5 = ", optString3);
                    if (optString != null && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString2)) {
                        this.f395943d.add(new c91.b(optString, optString2, optString3));
                    }
                }
            }
        }
    }

    private void g(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("ark_navi_msg_appnames");
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                String optString = optJSONArray.optString(i3);
                if (!TextUtils.isEmpty(optString) && !this.f395941b.contains(optString)) {
                    QLog.d("AiKeywordConfig", 1, "onParse ark_navi_msg_appnames appName = ", optString);
                    this.f395941b.add(optString);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.config.n
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onParse(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("AiKeywordConfig", 1, "onParse,fileOrRes is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f395940a = jSONObject.optString("ark_ai_match_graytips_visibility");
            g(jSONObject);
            b(jSONObject);
            f(jSONObject);
            QLog.e("AiKeywordConfig", 1, "mArkJsdebuggerDownloadList list size =", Integer.valueOf(this.f395943d.size()));
            c(jSONObject);
            d(jSONObject);
            e(jSONObject);
            QLog.i("AiKeywordConfig", 1, "onParse ark_ai_match_graytips_visibility=" + this.f395940a + ", singlecontext_singleapp_card_limit=" + this.f395944e + ", ark_app_limit=" + this.f395945f + ", ark_each_app_card_limit=" + this.f395946g + ", ark_input_apps_limit=" + this.f395947h + ", ark_input_each_context_apps_limit=" + this.f395948i + ", ark_babyq_card_limit_total=" + this.f395949j + ", ark_babyq_card_limit_total=" + this.f395950k + ", ark_babyq_guide_count_limit_per_day=" + this.f395951l + ", ark_babyq_guide_hint_text=" + this.f395953n + ", ark_babyq_bubble_disappear_duration=" + this.f395954o + ", ark_babyq_no_result_recommend_title=" + this.f395956q);
        } catch (JSONException e16) {
            QLog.i("AiKeywordConfig", 1, String.format("onParse AiKeywordConfig onParse, parse json failed, err=%s", e16.getMessage()));
        }
    }
}
