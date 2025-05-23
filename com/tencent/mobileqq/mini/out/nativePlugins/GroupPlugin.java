package com.tencent.mobileqq.mini.out.nativePlugins;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class GroupPlugin implements NativePlugin {
    public static final String GROUP_GETMULTIMEMLIST = "getMultiMemList";
    public static final String TAG = "GroupPlugin";
    JSContext mJsContext;
    MyActivityResultListener myActivityResultListener;

    private void gotoSelectMembers(String str, int i3, String str2) {
        JSContext jSContext = this.mJsContext;
        if (jSContext == null) {
            return;
        }
        if (this.myActivityResultListener == null) {
            this.myActivityResultListener = new MyActivityResultListener();
        }
        MiniAppController.getInstance().setActivityResultListener(this.myActivityResultListener);
        BaseActivity baseActivity = (BaseActivity) jSContext.getActivity();
        if (((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(str) != null) {
            gotoSelectMembers(i3, str2, baseActivity, str);
        } else {
            jSContext.evaluateCallback(false, new JSONObject(), HardCodeUtil.qqStr(R.string.f172075n54));
        }
    }

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onDestroy() {
        if (this.myActivityResultListener != null) {
            MiniAppController.getInstance().removeActivityResultListener(this.myActivityResultListener);
        }
    }

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onInvoke(JSONObject jSONObject, JSContext jSContext) {
        if (jSContext == null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "onInvoke jsContext is null return");
                return;
            }
            return;
        }
        try {
            this.mJsContext = jSContext;
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, jSONObject.toString());
            }
            if (GROUP_GETMULTIMEMLIST.equals(jSONObject.optString("api_name"))) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                String str = null;
                String optString = optJSONObject == null ? null : optJSONObject.optString("title");
                int optInt = optJSONObject == null ? 0 : optJSONObject.optInt("limitNum", 1);
                if (optJSONObject != null) {
                    str = optJSONObject.optString("listId");
                }
                int optInt2 = optJSONObject == null ? 0 : optJSONObject.optInt("type");
                if (!TextUtils.isEmpty(str) && optInt2 >= 1 && optInt2 <= 3) {
                    if (optInt2 == 1) {
                        gotoSelectMembers(str, optInt, optString);
                        return;
                    } else {
                        jSContext.evaluateCallback(false, new JSONObject(), HardCodeUtil.qqStr(R.string.f172076n55));
                        return;
                    }
                }
                jSContext.evaluateCallback(false, new JSONObject(), HardCodeUtil.qqStr(R.string.n56));
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "===>onInvoke exception", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes33.dex */
    public class MyActivityResultListener implements MiniAppController.ActivityResultListener {
        MyActivityResultListener() {
        }

        @Override // com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener
        public boolean doOnActivityResult(int i3, int i16, Intent intent) {
            boolean z16;
            if (i3 == 10) {
                JSONArray jSONArray = new JSONArray();
                if (intent == null || i16 != -1) {
                    z16 = false;
                } else {
                    ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET);
                    for (int i17 = 0; i17 < parcelableArrayListExtra.size(); i17++) {
                        ResultRecord resultRecord = (ResultRecord) parcelableArrayListExtra.get(i17);
                        try {
                            jSONArray.mo162put(new JSONObject().put("uin", resultRecord.uin).put("name", resultRecord.name));
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                        }
                    }
                    z16 = true;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("persons", jSONArray);
                } catch (JSONException e17) {
                    e17.printStackTrace();
                }
                JSContext jSContext = GroupPlugin.this.mJsContext;
                if (QLog.isColorLevel()) {
                    QLog.i(GroupPlugin.TAG, 2, String.format("evaluateCallback [ACTION_REQUEST_OPEN_GROUP_SELECTMEMBERS] %s", jSONObject));
                }
                if (jSContext != null) {
                    jSContext.evaluateCallback(z16, jSONObject, "errDesc");
                }
            }
            return false;
        }
    }

    private static void gotoSelectMembers(int i3, String str, BaseActivity baseActivity, String str2) {
        Intent intent = new Intent();
        intent.putExtra("param_type", 1);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 37);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 37);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_TROOP_MEMBER, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, i3);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_CONTACTS, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_TITLE, str);
        intent.putExtra("group_uin", str2);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_GROUPCODE, str2);
        intent.putExtra("group_name", str);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_EXIT_ANIMATION, 3);
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(baseActivity, intent, 10);
        baseActivity.overridePendingTransition(R.anim.f154454a3, 0);
    }
}
