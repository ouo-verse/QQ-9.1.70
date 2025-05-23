package com.tencent.mobileqq.data;

import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.constant.AnonymousConstant;
import com.tencent.mobileqq.relationx.icebreaking.bean.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd;
import cooperation.qqcircle.report.QCircleLpReportDc05494;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class MessageForTofuAioMiniProfile extends ChatMessage {
    public static final String TAG = "MessageForTofuAioMiniProfile";
    public com.tencent.mobileqq.relationx.icebreaking.bean.a miniCard;

    public MessageForTofuAioMiniProfile() {
        this.msgtype = -7012;
        this.mNeedTimeStamp = false;
    }

    private AnonymousQuestion getAskAnonymously(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            optJSONObject = null;
        } else {
            optJSONObject = jSONObject.optJSONObject(AnonymousConstant.KEY_ASK_ANONYMOUSLY);
        }
        if (optJSONObject == null) {
            return null;
        }
        AnonymousQuestion anonymousQuestion = new AnonymousQuestion();
        anonymousQuestion.mId = optJSONObject.optString(AnonymousConstant.KEY_Q_ID, "");
        anonymousQuestion.mQuest = optJSONObject.optString(AnonymousConstant.KEY_Q_STR, "");
        anonymousQuestion.mQuestTime = optJSONObject.optLong(AnonymousConstant.KEY_Q_TIME, 0L);
        anonymousQuestion.mQuestUin = optJSONObject.optLong(AnonymousConstant.KEY_Q_UIN, 0L);
        anonymousQuestion.mAnswer = optJSONObject.optString(AnonymousConstant.KEY_A_STR, "");
        return anonymousQuestion;
    }

    private a.C8501a getBaseProfile(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            optJSONObject = null;
        } else {
            optJSONObject = jSONObject.optJSONObject("field_baseprofile");
        }
        if (optJSONObject == null) {
            return null;
        }
        a.C8501a c8501a = new a.C8501a();
        c8501a.f280813a = optJSONObject.optInt("age", -1);
        c8501a.f280814b = optJSONObject.optInt("gender", -1);
        c8501a.f280815c = optJSONObject.optString(QCircleLpReportDc05494.KEY_PLACE, "");
        c8501a.f280816d = optJSONObject.optString("addfrd_src", "");
        c8501a.f280817e = optJSONObject.optInt("commfrd_num", -1);
        return c8501a;
    }

    private List<a.b> getNicePics(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            optJSONArray = null;
        } else {
            optJSONArray = jSONObject.optJSONArray("field_nicepics");
        }
        if (optJSONArray != null && optJSONArray.length() != 0) {
            ArrayList arrayList = new ArrayList(optJSONArray.length());
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                a.b bVar = new a.b();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                bVar.f280818a = optJSONObject.optString("ori", "");
                bVar.f280819b = optJSONObject.optString("medium", "");
                arrayList.add(bVar);
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    private List<String> getPersonalLabels(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            optJSONArray = null;
        } else {
            optJSONArray = jSONObject.optJSONArray("field_personal_labels");
        }
        if (optJSONArray != null && optJSONArray.length() != 0) {
            ArrayList arrayList = new ArrayList(optJSONArray.length());
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                arrayList.add(optJSONArray.optString(i3, ""));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    private a.c getQZoneInfo(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            optJSONObject = null;
        } else {
            optJSONObject = jSONObject.optJSONObject("field_qzone");
        }
        if (optJSONObject == null) {
            return null;
        }
        a.c cVar = new a.c();
        cVar.f280820a = optJSONObject.optString("space_name", "");
        cVar.f280821b = optJSONObject.optString("update_content", "");
        JSONArray optJSONArray = optJSONObject.optJSONArray("img_urls");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList(optJSONArray.length());
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                arrayList.add(optJSONArray.optString(i3));
            }
            cVar.f280822c.addAll(arrayList);
        }
        return cVar;
    }

    private a.d getSign(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            optJSONObject = null;
        } else {
            optJSONObject = jSONObject.optJSONObject("sign");
        }
        if (optJSONObject == null) {
            return null;
        }
        a.d dVar = new a.d();
        dVar.f280823a = optJSONObject.optInt("actionId", 0);
        dVar.f280824b = optJSONObject.optString(IMiniCardBeancurd.SIGN_ACTION_DATA, "");
        dVar.f280825c = optJSONObject.optString(IMiniCardBeancurd.SIGN_PLAIN_TEXT, "");
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        try {
            JSONObject jSONObject = new JSONObject(this.f203106msg);
            com.tencent.mobileqq.relationx.icebreaking.bean.a aVar = new com.tencent.mobileqq.relationx.icebreaking.bean.a();
            this.miniCard = aVar;
            aVar.f280807a = getBaseProfile(jSONObject);
            this.miniCard.f280808b.addAll(getPersonalLabels(jSONObject));
            this.miniCard.f280809c = getQZoneInfo(jSONObject);
            this.miniCard.f280810d.addAll(getNicePics(jSONObject));
            this.miniCard.f280811e = getSign(jSONObject);
            this.miniCard.f280812f = getAskAnonymously(jSONObject);
        } catch (Exception e16) {
            QLog.d(TAG, 1, "doParse", e16);
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, String.format("doParse %s", this.miniCard));
        }
        this.isread = true;
    }
}
