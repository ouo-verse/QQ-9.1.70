package com.tencent.qqmini.nativePlugins;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.out.nativePlugins.GroupPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin(secondary = true)
/* loaded from: classes34.dex */
public class n extends BaseJsPlugin {
    private static void c(int i3, String str, BaseActivity baseActivity, String str2) {
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
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(baseActivity, intent, 20001);
        baseActivity.overridePendingTransition(R.anim.f154454a3, 0);
    }

    private void d(RequestEvent requestEvent, String str, int i3, String str2) {
        ((IActivityResultManager) this.mMiniAppContext.getManager(IActivityResultManager.class)).addActivityResultListener(new a(requestEvent));
        BaseActivity baseActivity = (BaseActivity) this.mMiniAppContext.getAttachActivity();
        if (((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(str) != null) {
            c(i3, str2, baseActivity, str);
        } else {
            requestEvent.fail(HardCodeUtil.qqStr(R.string.f172075n54));
        }
    }

    @JsEvent({GroupPlugin.GROUP_GETMULTIMEMLIST})
    public void getMultiMemList(RequestEvent requestEvent) {
        try {
            JSONObject optJSONObject = new JSONObject(requestEvent.jsonParams).optJSONObject("data");
            String str = null;
            String optString = optJSONObject == null ? null : optJSONObject.optString("title");
            int i3 = 0;
            int optInt = optJSONObject == null ? 0 : optJSONObject.optInt("limitNum", 1);
            if (optJSONObject != null) {
                str = optJSONObject.optString("listId");
            }
            if (optJSONObject != null) {
                i3 = optJSONObject.optInt("type");
            }
            if (!TextUtils.isEmpty(str) && i3 >= 1 && i3 <= 3) {
                if (i3 == 1) {
                    d(requestEvent, str, optInt, optString);
                    return;
                } else {
                    requestEvent.fail(HardCodeUtil.qqStr(R.string.f172076n55));
                    return;
                }
            }
            requestEvent.fail(HardCodeUtil.qqStr(R.string.n56));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(GroupPlugin.TAG, 2, "===>onInvoke exception", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class a implements IActivityResultListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f347058a;

        a(RequestEvent requestEvent) {
            this.f347058a = requestEvent;
        }

        @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
        public boolean doOnActivityResult(int i3, int i16, Intent intent) {
            boolean z16;
            if (i3 == 20001) {
                ((IActivityResultManager) ((BaseJsPlugin) n.this).mMiniAppContext.getManager(IActivityResultManager.class)).removeActivityResultListener(this);
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
                if (QLog.isColorLevel()) {
                    QLog.i(GroupPlugin.TAG, 2, String.format("evaluateCallback [ACTION_REQUEST_OPEN_GROUP_SELECTMEMBERS] %s", jSONObject));
                }
                if (z16) {
                    this.f347058a.ok(jSONObject);
                } else {
                    this.f347058a.fail(jSONObject, "errDesc");
                }
            }
            return false;
        }
    }
}
