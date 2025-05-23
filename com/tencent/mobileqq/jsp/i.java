package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.frdsysmsg.FrdSysMsg$FriendSysMsg;
import tencent.im.s2c.frdsysmsg.FrdSysMsg$SchoolInfo;

/* compiled from: P */
/* loaded from: classes33.dex */
public class i extends WebViewPlugin {

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String[] f238878d;

        a(String[] strArr) {
            this.f238878d = strArr;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            int i3 = eIPCResult.data.getInt("KEY_SUCCESS");
            QLog.i("FriendApiPlugin", 1, "retCode is " + i3);
            String[] strArr = this.f238878d;
            if (strArr == null || strArr.length <= 0) {
                return;
            }
            try {
                String optString = new JSONObject(this.f238878d[0]).optString("callback");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", i3);
                QLog.i("FriendApiPlugin", 1, "result " + jSONObject);
                i.this.callJs(optString, jSONObject.toString());
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    private int p() {
        Activity a16 = this.mRuntime.a();
        return (a16 == null || !com.tencent.mobileqq.friends.a.a(a16.getIntent().getStringExtra("url"))) ? 999 : 127;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "friendApi";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        JSONObject optJSONObject;
        if (!"friendApi".equals(str2)) {
            return false;
        }
        if ("openProfile".equals(str3)) {
            if (strArr != null && strArr.length > 0) {
                if (QLog.isColorLevel()) {
                    QLog.w("FriendApiPlugin", 2, "open profile " + strArr[0]);
                }
                try {
                    JSONObject jSONObject = new JSONObject(strArr[0]);
                    String optString = jSONObject.optString("uin");
                    int optInt = jSONObject.optInt("from");
                    String optString2 = jSONObject.optString("uid");
                    if (!TextUtils.isEmpty(optString2)) {
                        ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).saveUidByUin(optString, optString2);
                    }
                    AllInOne allInOne = new AllInOne(optString, optInt);
                    allInOne.profileEntryType = p();
                    ProfileUtils.openProfileCard(this.mRuntime.a(), allInOne);
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.w("FriendApiPlugin", 2, "open profile error:" + e16.toString());
                    }
                }
            }
        } else {
            String str4 = "";
            r13 = null;
            byte[] bArr = null;
            if (QQFriendJsPlugin.API_ADD_FRIEND.equals(str3)) {
                if (strArr != null && strArr.length > 0) {
                    if (QLog.isColorLevel()) {
                        QLog.w("FriendApiPlugin", 2, "add friend " + strArr[0]);
                    }
                    try {
                        JSONObject jSONObject2 = new JSONObject(strArr[0]);
                        String optString3 = jSONObject2.optString("uin");
                        int optInt2 = jSONObject2.optInt("sourceId", 0);
                        int optInt3 = jSONObject2.optInt("subSourceId", 0);
                        String optString4 = jSONObject2.optString("message", "");
                        if (jSONObject2.has("schoolInfo") && (optJSONObject = jSONObject2.optJSONObject("schoolInfo")) != null) {
                            String optString5 = optJSONObject.optString("schoolId");
                            String optString6 = optJSONObject.optString("schoolName");
                            FrdSysMsg$SchoolInfo frdSysMsg$SchoolInfo = new FrdSysMsg$SchoolInfo();
                            frdSysMsg$SchoolInfo.str_school_id.set(optString5);
                            frdSysMsg$SchoolInfo.str_school_name.set(optString6);
                            FrdSysMsg$FriendSysMsg frdSysMsg$FriendSysMsg = new FrdSysMsg$FriendSysMsg();
                            frdSysMsg$FriendSysMsg.msg_school_info.set(frdSysMsg$SchoolInfo);
                            bArr = frdSysMsg$FriendSysMsg.toByteArray();
                        }
                        Activity a16 = this.mRuntime.a();
                        Intent startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(a16, 1, optString3, "", optInt2, optInt3, null, optString4, null, null, null);
                        if (bArr != null) {
                            Bundle bundleExtra = startAddFriend.getBundleExtra("flc_extra_param");
                            if (bundleExtra == null) {
                                bundleExtra = new Bundle();
                                startAddFriend.putExtra("flc_extra_param", bundleExtra);
                            }
                            bundleExtra.putByteArray("friend_src_desc", bArr);
                        }
                        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(a16, startAddFriend);
                    } catch (JSONException e17) {
                        if (QLog.isColorLevel()) {
                            QLog.w("FriendApiPlugin", 2, "add friend error:" + e17.toString());
                        }
                    }
                }
            } else if (IProfileProtocolConst.PARAM_IS_FRIEND.equals(str3)) {
                if (strArr != null && strArr.length > 0) {
                    try {
                        JSONObject jSONObject3 = new JSONObject(strArr[0]);
                        String optString7 = jSONObject3.optString("frd_uin");
                        Bundle bundle = new Bundle();
                        bundle.putString("KEY_UIN", optString7);
                        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "FriendQIPCModule", "ACTION_IS_FRIEND", bundle);
                        boolean z16 = callServer.isSuccess() ? callServer.data.getBoolean("KEY_IS_FRIEND", false) : false;
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("result", z16);
                        callJs(jSONObject3.optString("callback"), jSONObject4.toString());
                    } catch (JSONException e18) {
                        e18.printStackTrace();
                    }
                }
            } else if ("getPhoneNumber".equals(str3)) {
                if (strArr != null && strArr.length > 0) {
                    try {
                        JSONObject jSONObject5 = new JSONObject(strArr[0]);
                        String optString8 = jSONObject5.optString("frd_uin");
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("KEY_UIN", optString8);
                        EIPCResult callServer2 = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "FriendQIPCModule", "ACTION_GET_PHONE_NUMBER", bundle2);
                        String string = callServer2.isSuccess() ? callServer2.data.getString("PHONE_NUMBER", null) : null;
                        JSONObject jSONObject6 = new JSONObject();
                        if (!TextUtils.isEmpty(string) && !"0".equals(string)) {
                            str4 = string;
                        }
                        jSONObject6.put("PhoneNumber", str4);
                        callJs(jSONObject5.optString("callback"), jSONObject6.toString());
                    } catch (JSONException e19) {
                        e19.printStackTrace();
                    }
                }
            } else if ("deleteOneWayFriends".equals(str3)) {
                if (strArr != null && strArr.length > 0) {
                    try {
                        JSONArray optJSONArray = new JSONObject(strArr[0]).optJSONArray("uins");
                        ArrayList<String> arrayList = new ArrayList<>();
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                String optString9 = optJSONArray.optString(i3);
                                if (!TextUtils.isEmpty(optString9)) {
                                    arrayList.add(optString9);
                                }
                            }
                        }
                        QLog.d("FriendApiPlugin", 1, "delete single way friends: " + arrayList);
                        if (!arrayList.isEmpty()) {
                            Bundle bundle3 = new Bundle();
                            bundle3.putStringArrayList("KEY_BE_DELETE_SINGLE_WAY_FRIENDS", arrayList);
                            EIPCResult callServer3 = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "FriendQIPCModule", "ACTION_DELETE_SINGLE_WAY_FRIENDS", bundle3);
                            QLog.d("FriendApiPlugin", 1, "notify delete single way friend, isSuccess: " + (callServer3 != null ? callServer3.isSuccess() : false));
                        }
                    } catch (JSONException e26) {
                        e26.printStackTrace();
                    }
                }
            } else if ("showAccountMenu".equals(str3)) {
                QLog.i("FriendApiPlugin", 1, "showAccountMenu called");
                int i16 = -1;
                if (strArr != null && strArr.length > 0) {
                    try {
                        i16 = new JSONObject(strArr[0]).optInt("state", -1);
                    } catch (JSONException e27) {
                        e27.printStackTrace();
                    }
                }
                QLog.i("FriendApiPlugin", 2, "status is " + i16);
                Bundle bundle4 = new Bundle();
                bundle4.putInt("KEY_STATE", i16);
                QIPCClientHelper.getInstance().getClient().callServer("FriendQIPCModule", "ACTION_SET_ONLINE_STATUS", bundle4, new a(strArr));
            } else if ("shareRichState".equals(str3)) {
                QLog.i("FriendApiPlugin", 1, "shareRichState called");
                if (strArr != null && strArr.length > 0) {
                    try {
                        long optLong = new JSONObject(strArr[0]).optLong("rank");
                        if (QLog.isColorLevel()) {
                            QLog.i("FriendApiPlugin", 1, "shareRichState rank is " + optLong);
                        }
                        Intent intent = new Intent();
                        intent.putExtra("KEY_OLYMPIC_RANK", optLong);
                        ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).launchOlympicShareFragment(this.mRuntime.a(), intent);
                    } catch (JSONException e28) {
                        e28.printStackTrace();
                    }
                }
            }
        }
        return true;
    }
}
