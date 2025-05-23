package com.tencent.mobileqq.profilecard.crossend;

import ab1.a;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.data.CardCoverData;
import com.tencent.mobileqq.profilecard.ipc.ZanRankingIpcClient;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ZanRankingCrossEndHandler implements ZanRankingIpcClient.ICallback {
    private static final String KEY_COVER_TEXT = "text";
    private static final String KEY_COVER_TYPE = "type";
    private static final String KEY_UIN = "uin";
    private static final String KEY_UIN_LIST = "uinList";
    private static final String TAG = "ZanRankingCrossEndHandler";
    private static final AtomicInteger seqGetter = new AtomicInteger();
    private final Map<Integer, a> methodCallbackCache = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject buildJsCallback(int i3, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("code", i3);
            jSONObject2.put("data", jSONObject);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "JsCallback constructor error", e16);
        }
        return jSONObject2;
    }

    private void onFail(a aVar, String str) {
        QLog.e(TAG, 1, str);
        aVar.f(buildJsCallback(1, new JSONObject()));
    }

    private void onSuccess(final a aVar, final JSONObject jSONObject) {
        QBaseActivity.sTopActivity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.profilecard.crossend.ZanRankingCrossEndHandler.1
            @Override // java.lang.Runnable
            public void run() {
                aVar.f(ZanRankingCrossEndHandler.this.buildJsCallback(0, jSONObject));
            }
        });
    }

    @Override // com.tencent.mobileqq.profilecard.ipc.ZanRankingIpcClient.ICallback
    public void onGetCardCover(int i3, String str, boolean z16, CardCoverData cardCoverData) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format(Locale.getDefault(), "onGetCardCover seq=%d uin=%s fromCache=%b data=%s", Integer.valueOf(i3), str, Boolean.valueOf(z16), cardCoverData));
        }
        a remove = this.methodCallbackCache.remove(Integer.valueOf(i3));
        if (remove == null) {
            return;
        }
        try {
            if (cardCoverData == null) {
                onFail(remove, "CardCoverData is null");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", cardCoverData.type);
            jSONObject.put("text", cardCoverData.text);
            onSuccess(remove, jSONObject);
        } catch (JSONException e16) {
            onFail(remove, e16.getMessage());
        }
    }

    private void getCoverFromCacheCard(JSONObject jSONObject, a aVar) {
        getCoverInner(jSONObject, aVar, true);
    }

    private void getCoverFromSvrCard(JSONObject jSONObject, a aVar) {
        getCoverInner(jSONObject, aVar, false);
    }

    private void getCoverInner(JSONObject jSONObject, a aVar, boolean z16) {
        if (jSONObject == null) {
            onFail(aVar, "data is null");
            return;
        }
        try {
            String string = jSONObject.getString("uin");
            int incrementAndGet = seqGetter.incrementAndGet();
            this.methodCallbackCache.put(Integer.valueOf(incrementAndGet), aVar);
            ZanRankingIpcClient.getInstance().setCallback(this);
            ZanRankingIpcClient.getInstance().callGetCardCover(incrementAndGet, string, z16);
        } catch (JSONException e16) {
            onFail(aVar, e16.getMessage());
        }
    }

    private void getFriendsNickDict(JSONObject jSONObject, a aVar) {
        if (jSONObject == null) {
            onFail(aVar, "data is null");
            return;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("uinList");
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(jSONArray.optString(i3));
            }
            Map<String, String> frdNicks = ZanRankingIpcClient.getInstance().getFrdNicks(arrayList);
            if (frdNicks != null && frdNicks.keySet().size() != 0) {
                JSONObject jSONObject2 = new JSONObject();
                for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                    String optString = jSONArray.optString(i16);
                    if (frdNicks.containsKey(optString)) {
                        jSONObject2.put(optString, frdNicks.get(optString));
                    }
                }
                onSuccess(aVar, jSONObject2);
                return;
            }
            onFail(aVar, "nick result is empty");
        } catch (JSONException e16) {
            onFail(aVar, e16.getMessage());
        }
    }
}
