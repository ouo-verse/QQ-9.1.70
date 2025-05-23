package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.ark.Constants;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RecommendCommonMessage extends ChatMessage {
    private static final String TAG = "Ark";
    public String arkServerExtraInfo;
    public String arkServerMsgId;
    public boolean atInfoParsed;
    public boolean isFromArkServer;
    public String mIconAppPath;
    public boolean mIsMsgParsedByAi;
    public ArkMsgAppInfo mOldAppInfo = new ArkMsgAppInfo();
    public ArrayList<ArkContextInfo> mContextList = new ArrayList<>();
    public boolean mIsShow = false;
    public boolean mHasReportShowIcon = false;
    public boolean mHasReportShowUnderline = false;
    public boolean mHasReportShowIconEach = false;
    public boolean mHasReportShowUnderlineEach = false;
    public int mEchoType = 0;
    public int mContextMatchType = 0;
    private ArrayList<Integer> atIndex = new ArrayList<>();
    private ArrayList<Integer> atLength = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class ArkContextInfo {
        public String context = "";
        public LinkedHashMap<String, String> semantic = new LinkedHashMap<>();
        public LinkedHashMap<String, String> rawSemantic = new LinkedHashMap<>();
        public String keyword = "";
        public boolean equalInputText = false;
        public int contextMatchType = 0;
        public LinkedList<ArkMsgAppInfo> contextAppInfoList = new LinkedList<>();
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class ArkMsgAppInfo {
        public com.tencent.mobileqq.activity.aio.item.b mArkContainer;
        public String appName = "";
        public String appView = "";
        public String bizSrc = "";
        public String appPath = "";
        public String appVer = Constants.DEFAULT_MIN_APP_VERSION;
        public String meta = "";
        public String keyword = "";
        public boolean equalInputText = false;
        public LinkedList<ArkMsgAppInfo> mOpenCardAppInfoList = new LinkedList<>();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ArkMsgAppInfo)) {
                return false;
            }
            ArkMsgAppInfo arkMsgAppInfo = (ArkMsgAppInfo) obj;
            if (this.appName.equals(arkMsgAppInfo.appName) && this.appPath.equals(arkMsgAppInfo.appPath) && this.appView.equals(arkMsgAppInfo.appView) && this.keyword.equals(arkMsgAppInfo.keyword) && this.equalInputText == arkMsgAppInfo.equalInputText && this.meta.equals(arkMsgAppInfo.meta)) {
                return true;
            }
            return false;
        }
    }

    public void addAtInfo(int i3, int i16) {
        this.atIndex.add(Integer.valueOf(i3));
        this.atLength.add(Integer.valueOf(i16));
    }

    public void clearAtInfo() {
        this.atIndex.clear();
        this.atLength.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        boolean z16;
        boolean z17;
        if (this.mIsMsgParsedByAi) {
            return;
        }
        this.mOldAppInfo.appName = getExtInfoFromExtStr("ark_ai_message_name");
        this.mOldAppInfo.appView = getExtInfoFromExtStr("ark_ai_message_view");
        this.mOldAppInfo.bizSrc = getExtInfoFromExtStr("ark_ai_message_bizsrc");
        this.mOldAppInfo.appVer = getExtInfoFromExtStr("ark_ai_message_ver");
        this.mOldAppInfo.meta = getExtInfoFromExtStr("ark_ai_message_meta");
        this.mOldAppInfo.keyword = getExtInfoFromExtStr("ark_ai_message_keyword");
        String extInfoFromExtStr = getExtInfoFromExtStr("ark_ai_message_data");
        boolean z18 = false;
        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
            try {
                JSONObject jSONObject = new JSONObject(extInfoFromExtStr);
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    ArkContextInfo arkContextInfo = new ArkContextInfo();
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                    arkContextInfo.context = jSONObject2.optString("context");
                    arkContextInfo.keyword = jSONObject2.optString("keyword");
                    String optString = jSONObject2.optString("equalInputText");
                    if (!TextUtils.isEmpty(optString) && optString.equals("1")) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    arkContextInfo.equalInputText = z17;
                    arkContextInfo.contextMatchType = jSONObject2.optInt("contextMatchType");
                    JSONObject jSONObject3 = (JSONObject) jSONObject2.get("sematic");
                    Iterator keys = jSONObject3.keys();
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        String optString2 = jSONObject3.optString(str);
                        if (!TextUtils.isEmpty(optString2)) {
                            arkContextInfo.semantic.put(str, optString2);
                        }
                    }
                    this.mContextList.add(arkContextInfo);
                }
                this.mIsShow = jSONObject.optBoolean("show");
                this.mHasReportShowIcon = jSONObject.optBoolean("reportIcon");
                this.mHasReportShowUnderline = jSONObject.optBoolean("reportUnderline");
                this.isFromArkServer = jSONObject.optBoolean("fromArkServer", false);
                this.arkServerMsgId = jSONObject.optString("msgId", null);
                this.arkServerExtraInfo = jSONObject.optString("extraInfo", null);
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "RecommendCommonMessage doParse json parse exception=" + e16);
                }
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "RecommendCommonMessage doParse exception=" + e17);
                }
            }
        }
        boolean z19 = !TextUtils.isEmpty(this.mOldAppInfo.appName);
        this.mIsMsgParsedByAi = z19;
        if (!z19) {
            if (this.mContextList.size() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mIsMsgParsedByAi = z16;
        }
        if (!this.mIsMsgParsedByAi) {
            String extInfoFromExtStr2 = getExtInfoFromExtStr("ark_ai_message_parsed");
            if (!TextUtils.isEmpty(extInfoFromExtStr2) && extInfoFromExtStr2.equals("1")) {
                z18 = true;
            }
            this.mIsMsgParsedByAi = z18;
        }
    }

    public int getAtLength(int i3) {
        int size = this.atIndex.size() - 1;
        int i16 = 0;
        while (i16 <= size) {
            int i17 = ((size - i16) / 2) + i16;
            int intValue = this.atIndex.get(i17).intValue();
            if (intValue <= i3 && this.atLength.get(i17).intValue() + intValue >= i3) {
                return this.atLength.get(i17).intValue();
            }
            if (intValue > i3) {
                size = i17 - 1;
            } else {
                i16 = i17 + 1;
            }
        }
        return -1;
    }

    public boolean hasAiData() {
        if (this.mContextList.size() <= 0 && TextUtils.isEmpty(this.mOldAppInfo.appName)) {
            return false;
        }
        return true;
    }

    public int isIncludedByAt(int i3, int i16) {
        int size = this.atIndex.size() - 1;
        int i17 = 0;
        while (i17 <= size) {
            int i18 = ((size - i17) / 2) + i17;
            int intValue = this.atIndex.get(i18).intValue();
            if (intValue <= i3 && this.atLength.get(i18).intValue() + intValue >= i3 + i16) {
                return intValue;
            }
            if (intValue > i3) {
                size = i18 - 1;
            } else {
                i17 = i18 + 1;
            }
        }
        return -1;
    }

    public void saveRecommendMsg(final WeakReference<QQAppInterface> weakReference, int i3, boolean z16) {
        Object obj;
        String str = "1";
        if (z16) {
            if (!this.mIsMsgParsedByAi) {
                str = "0";
            }
            saveExtInfoToExtStr("ark_ai_message_parsed", str);
        } else {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (int i16 = 0; i16 < this.mContextList.size(); i16++) {
                    JSONObject jSONObject2 = new JSONObject();
                    ArkContextInfo arkContextInfo = this.mContextList.get(i16);
                    jSONObject2.put("context", arkContextInfo.context);
                    jSONObject2.put("keyword", arkContextInfo.keyword);
                    if (arkContextInfo.equalInputText) {
                        obj = "1";
                    } else {
                        obj = "0";
                    }
                    jSONObject2.put("equalInputText", obj);
                    jSONObject2.put("contextMatchType", arkContextInfo.contextMatchType);
                    JSONObject jSONObject3 = new JSONObject();
                    for (String str2 : arkContextInfo.semantic.keySet()) {
                        String str3 = arkContextInfo.semantic.get(str2);
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject3.put(str2, str3);
                        }
                    }
                    jSONObject2.put("sematic", jSONObject3);
                    jSONArray.mo162put(jSONObject2);
                }
                jSONObject.put("data", jSONArray);
                jSONObject.put("show", this.mIsShow);
                jSONObject.put("reportIcon", this.mHasReportShowIcon);
                jSONObject.put("reportUnderline", this.mHasReportShowUnderline);
                jSONObject.put("fromArkServer", this.isFromArkServer);
                jSONObject.put("msgId", this.arkServerMsgId);
                jSONObject.put("extraInfo", this.arkServerExtraInfo);
                saveExtInfoToExtStr("ark_ai_message_data", jSONObject.toString());
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "RecommendCommonMessage saveRecommendMsg json parse exception=" + e16);
                }
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "RecommendCommonMessage saveRecommendMsg exception=" + e17);
                }
            }
        }
        if (weakReference != null && weakReference.get() != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.data.RecommendCommonMessage.1
                @Override // java.lang.Runnable
                public void run() {
                    QQAppInterface qQAppInterface = (QQAppInterface) weakReference.get();
                    if (qQAppInterface != null) {
                        QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
                        RecommendCommonMessage recommendCommonMessage = RecommendCommonMessage.this;
                        messageFacade.a1(recommendCommonMessage.frienduin, recommendCommonMessage.istroop, recommendCommonMessage.uniseq, AppConstants.Key.COLUMN_EXT_STR, recommendCommonMessage.extStr);
                    }
                }
            }, 32, null, false);
        }
    }
}
