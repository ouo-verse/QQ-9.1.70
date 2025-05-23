package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import com.hihonor.honorid.core.data.UserInfo;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.action.PhoneNumberAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class TelephonyJsPlugin extends BaseJsPlugin {
    private static final String TAG = "TelephonyJsPlugin";
    private Map<Integer, String> mGetPhoneNumberMap = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public void doAddPhoneContact(String str, String str2, boolean z16) {
        Intent intent;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString(UserInfo.FIRSTNAME);
            String optString2 = jSONObject.optString("middleName");
            String optString3 = jSONObject.optString(UserInfo.LASTNAME);
            String optString4 = jSONObject.optString("nickName");
            String optString5 = jSONObject.optString("remark");
            String optString6 = jSONObject.optString("organization");
            String optString7 = jSONObject.optString("title");
            String optString8 = jSONObject.optString("email");
            String optString9 = jSONObject.optString("url");
            if (z16) {
                intent = new Intent("android.intent.action.INSERT");
                intent.setType("vnd.android.cursor.dir/raw_contact");
            } else {
                intent = new Intent("android.intent.action.INSERT_OR_EDIT");
                intent.setType("vnd.android.cursor.item/contact");
            }
            parseName(optString, optString2, optString3, intent);
            parsePhoneNumber(jSONObject, intent);
            intent.putExtra("notes", optString5);
            intent.putExtra(IProfileProtocolConst.KEY_COMPANY, optString6);
            intent.putExtra("job_title", optString7);
            intent.putExtra("email", optString8);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            parseNumber(jSONObject, arrayList);
            processAddress(jSONObject, arrayList);
            processWorkAddress(jSONObject, arrayList);
            processHomeAddress(jSONObject, arrayList);
            if (!TextUtils.isEmpty(optString9)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("mimetype", "vnd.android.cursor.item/website");
                contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA2, (Integer) 2);
                contentValues.put("data3", "\u7f51\u5740");
                contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA1, optString9);
                arrayList.add(contentValues);
            }
            if (!TextUtils.isEmpty(optString4)) {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("mimetype", "vnd.android.cursor.item/nickname");
                contentValues2.put(StepCounterConstants.BEACON_PARAM_KEY_DATA2, (Integer) 0);
                contentValues2.put("data3", "\u6635\u79f0");
                contentValues2.put(StepCounterConstants.BEACON_PARAM_KEY_DATA1, optString4);
                arrayList.add(contentValues2);
            }
            intent.putParcelableArrayListExtra("data", arrayList);
            if (this.mMiniAppContext.getAttachActivity() != null) {
                this.mMiniAppContext.getAttachActivity().startActivity(intent);
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, th5.getMessage(), th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getErrorMessage(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("retCode");
        if (this.mGetPhoneNumberMap.containsKey(Integer.valueOf(optInt))) {
            return this.mGetPhoneNumberMap.get(Integer.valueOf(optInt));
        }
        return jSONObject.optString("errMsg");
    }

    private void initGetPhoneNumberErrorMap() {
        this.mGetPhoneNumberMap.put(-101511001, this.mContext.getString(R.string.mini_get_phone_number_error_1));
        this.mGetPhoneNumberMap.put(-101511002, this.mContext.getString(R.string.mini_get_phone_number_error_2));
        this.mGetPhoneNumberMap.put(-101511003, this.mContext.getString(R.string.mini_get_phone_number_error_3));
        this.mGetPhoneNumberMap.put(-101511004, this.mContext.getString(R.string.mini_get_phone_number_error_4));
        this.mGetPhoneNumberMap.put(-101511005, this.mContext.getString(R.string.mini_get_phone_number_error_5));
        this.mGetPhoneNumberMap.put(-101511006, this.mContext.getString(R.string.mini_get_phone_number_error_6));
        this.mGetPhoneNumberMap.put(-101511007, this.mContext.getString(R.string.mini_get_phone_number_error_7));
        this.mGetPhoneNumberMap.put(-101511008, this.mContext.getString(R.string.mini_get_phone_number_error_8));
        this.mGetPhoneNumberMap.put(-101511009, this.mContext.getString(R.string.mini_get_phone_number_error_9));
        this.mGetPhoneNumberMap.put(-101511010, this.mContext.getString(R.string.mini_get_phone_number_error_10));
        this.mGetPhoneNumberMap.put(-101511011, this.mContext.getString(R.string.mini_get_phone_number_error_11));
        this.mGetPhoneNumberMap.put(-101511012, this.mContext.getString(R.string.mini_get_phone_number_error_12));
        this.mGetPhoneNumberMap.put(-101511013, this.mContext.getString(R.string.mini_get_phone_number_error_13));
        this.mGetPhoneNumberMap.put(-101511014, this.mContext.getString(R.string.mini_get_phone_number_error_14));
        this.mGetPhoneNumberMap.put(-101511015, this.mContext.getString(R.string.mini_get_phone_number_error_15));
        this.mGetPhoneNumberMap.put(-101511016, this.mContext.getString(R.string.mini_get_phone_number_error_16));
        this.mGetPhoneNumberMap.put(-101511017, this.mContext.getString(R.string.mini_get_phone_number_error_17));
        this.mGetPhoneNumberMap.put(-101511018, this.mContext.getString(R.string.mini_get_phone_number_error_18));
        this.mGetPhoneNumberMap.put(-101511019, this.mContext.getString(R.string.mini_get_phone_number_error_19));
        this.mGetPhoneNumberMap.put(-101511020, this.mContext.getString(R.string.mini_get_phone_number_error_20));
        this.mGetPhoneNumberMap.put(-101511021, this.mContext.getString(R.string.mini_get_phone_number_error_21));
        this.mGetPhoneNumberMap.put(-101511022, this.mContext.getString(R.string.mini_get_phone_number_error_22));
        this.mGetPhoneNumberMap.put(-101511023, this.mContext.getString(R.string.mini_get_phone_number_error_23));
        this.mGetPhoneNumberMap.put(-101511024, this.mContext.getString(R.string.mini_get_phone_number_error_24));
    }

    private void parseName(String str, String str2, String str3, Intent intent) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            if (!TextUtils.isEmpty(str2)) {
                str = str + " " + str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                str = str + " " + str3;
            }
            intent.putExtra("name", str.trim());
        }
    }

    private void parseNumber(JSONObject jSONObject, ArrayList<ContentValues> arrayList) {
        String optString = jSONObject.optString("hostNumber");
        if (!TextUtils.isEmpty(optString)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
            contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA2, (Integer) 0);
            contentValues.put("data3", "\u624b\u673a");
            contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA1, optString);
            arrayList.add(contentValues);
        }
        String optString2 = jSONObject.optString("photoFilePath");
        if (!TextUtils.isEmpty(optString2)) {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("mimetype", "vnd.android.cursor.item/photo");
            contentValues2.put("data15", optString2);
            arrayList.add(contentValues2);
        }
        String optString3 = jSONObject.optString("homeFaxNumber");
        if (!TextUtils.isEmpty(optString3)) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("mimetype", "vnd.android.cursor.item/phone_v2");
            contentValues3.put(StepCounterConstants.BEACON_PARAM_KEY_DATA2, (Integer) 0);
            contentValues3.put("data3", "\u4f4f\u5b85\u4f20\u771f");
            contentValues3.put(StepCounterConstants.BEACON_PARAM_KEY_DATA1, optString3);
            arrayList.add(contentValues3);
        }
        String optString4 = jSONObject.optString("workFaxNumber");
        if (!TextUtils.isEmpty(optString4)) {
            ContentValues contentValues4 = new ContentValues();
            contentValues4.put("mimetype", "vnd.android.cursor.item/phone_v2");
            contentValues4.put(StepCounterConstants.BEACON_PARAM_KEY_DATA2, (Integer) 0);
            contentValues4.put("data3", "\u5355\u4f4d\u4f20\u771f");
            contentValues4.put(StepCounterConstants.BEACON_PARAM_KEY_DATA1, optString4);
            arrayList.add(contentValues4);
        }
    }

    private void parsePhoneNumber(JSONObject jSONObject, Intent intent) {
        String optString = jSONObject.optString("mobilePhoneNumber");
        String optString2 = jSONObject.optString("workPhoneNumber");
        String optString3 = jSONObject.optString("homePhoneNumber");
        if (!TextUtils.isEmpty(optString)) {
            intent.putExtra("phone", optString);
            intent.putExtra("phone_type", "\u624b\u673a");
        }
        if (!TextUtils.isEmpty(optString3)) {
            intent.putExtra("secondary_phone", optString3);
            intent.putExtra("secondary_phone_type", "\u4f4f\u5b85");
        }
        if (!TextUtils.isEmpty(optString2)) {
            intent.putExtra("tertiary_phone", optString2);
            intent.putExtra("tertiary_phone_type", "\u5de5\u4f5c");
        }
    }

    private void processAddress(JSONObject jSONObject, ArrayList<ContentValues> arrayList) {
        jSONObject.optString("weChatNumber");
        String optString = jSONObject.optString("addressCountry");
        String optString2 = jSONObject.optString("addressState");
        String optString3 = jSONObject.optString("addressCity");
        String optString4 = jSONObject.optString("addressStreet");
        String optString5 = jSONObject.optString("addressPostalCode");
        if (!TextUtils.isEmpty(optString) || !TextUtils.isEmpty(optString2) || !TextUtils.isEmpty(optString3) || !TextUtils.isEmpty(optString4) || !TextUtils.isEmpty(optString5)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
            contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA2, (Integer) 1);
            contentValues.put("data3", "\u4f4f\u5b85");
            contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA1, optString + " " + optString2 + " " + optString3 + " " + optString4 + " " + optString5);
            arrayList.add(contentValues);
        }
    }

    private void processHomeAddress(JSONObject jSONObject, ArrayList<ContentValues> arrayList) {
        String optString = jSONObject.optString("homeAddressCountry");
        String optString2 = jSONObject.optString("homeAddressState");
        String optString3 = jSONObject.optString("homeAddressCity");
        String optString4 = jSONObject.optString("homeAddressStreet");
        String optString5 = jSONObject.optString("homeAddressPostalCode");
        if (!TextUtils.isEmpty(optString) || !TextUtils.isEmpty(optString2) || !TextUtils.isEmpty(optString3) || !TextUtils.isEmpty(optString4) || !TextUtils.isEmpty(optString5)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
            contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA2, (Integer) 1);
            contentValues.put("data3", "\u4f4f\u5b85");
            contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA1, optString + " " + optString2 + " " + optString3 + " " + optString4 + " " + optString5);
            arrayList.add(contentValues);
        }
    }

    private void processWorkAddress(JSONObject jSONObject, ArrayList<ContentValues> arrayList) {
        String optString = jSONObject.optString("workAddressCountry");
        String optString2 = jSONObject.optString("workAddressState");
        String optString3 = jSONObject.optString("workAddressCity");
        String optString4 = jSONObject.optString("workAddressStreet");
        String optString5 = jSONObject.optString("workAddressPostalCode");
        if (!TextUtils.isEmpty(optString) || !TextUtils.isEmpty(optString2) || !TextUtils.isEmpty(optString3) || !TextUtils.isEmpty(optString4) || !TextUtils.isEmpty(optString5)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
            contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA2, (Integer) 2);
            contentValues.put("data3", "\u5355\u4f4d");
            contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA1, optString + " " + optString2 + " " + optString3 + " " + optString4 + " " + optString5);
            arrayList.add(contentValues);
        }
    }

    @JsEvent({com.tencent.luggage.wxa.ve.b.NAME})
    public String addPhoneContact(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.TelephonyJsPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                final ActionSheet create = ActionSheet.create(((BaseJsPlugin) TelephonyJsPlugin.this).mMiniAppContext.getAttachActivity());
                create.addButton("\u521b\u5efa\u65b0\u8054\u7cfb\u4eba", 7);
                create.addButton("\u6dfb\u52a0\u5230\u73b0\u6709\u8054\u7cfb\u4eba", 7);
                create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqmini.sdk.plugins.TelephonyJsPlugin.2.1
                    @Override // com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet.OnButtonClickListener
                    public void onClick(View view, int i3) {
                        boolean z16;
                        try {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            TelephonyJsPlugin telephonyJsPlugin = TelephonyJsPlugin.this;
                            RequestEvent requestEvent2 = requestEvent;
                            String str = requestEvent2.event;
                            String str2 = requestEvent2.jsonParams;
                            if (i3 == 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            telephonyJsPlugin.doAddPhoneContact(str, str2, z16);
                            create.dismiss();
                        } catch (Exception e16) {
                            QMLog.e(TelephonyJsPlugin.TAG, requestEvent.event + " error.", e16);
                        }
                    }
                });
                create.show();
            }
        });
        return requestEvent.ok();
    }

    @JsEvent({"getPhoneNumber"})
    public void getPhoneNumber(final RequestEvent requestEvent) {
        try {
            JSONObject optJSONObject = new JSONObject(requestEvent.jsonParams).optJSONObject("data");
            String optString = optJSONObject.optString("api_name", "");
            optJSONObject.optBoolean("with_credentials", true);
            if ("webapi_getuserwxphone".equals(optString)) {
                initGetPhoneNumberErrorMap();
                ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getPhoneNumber(this.mMiniAppContext.getMiniAppInfo().appId, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.TelephonyJsPlugin.1
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                    public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                        JSONArray jSONArray;
                        final String str;
                        QMLog.d(TelephonyJsPlugin.TAG, "onCmdListener isSuccess = " + z16 + "; result = " + jSONObject);
                        JSONArray jSONArray2 = new JSONArray();
                        if (jSONObject != null) {
                            str = TelephonyJsPlugin.this.getErrorMessage(jSONObject);
                            jSONArray = jSONObject.optJSONArray("phoneLists");
                        } else {
                            jSONArray = jSONArray2;
                            str = "no binding Phone number";
                        }
                        if (z16) {
                            if (jSONArray != null && jSONArray.length() != 0) {
                                try {
                                    JSONObject jSONObject2 = new JSONObject(requestEvent.jsonParams);
                                    jSONObject2.put("getPhoneNumber", jSONObject);
                                    requestEvent.jsonParams = jSONObject2.toString();
                                    ((BaseJsPlugin) TelephonyJsPlugin.this).mMiniAppContext.performAction(PhoneNumberAction.obtain(requestEvent, new PhoneNumberAction.PhoneNumberActionCallback() { // from class: com.tencent.qqmini.sdk.plugins.TelephonyJsPlugin.1.1
                                        @Override // com.tencent.qqmini.sdk.action.PhoneNumberAction.PhoneNumberActionCallback
                                        public void onGetAuthDialogRet(boolean z17, JSONObject jSONObject3) {
                                            if (z17) {
                                                String account = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAccount();
                                                StorageUtil.getPreference().edit().putString(account + "_PhoneNumber", jSONObject3.optString("purePhoneNumber")).commit();
                                                jSONObject3.remove("countryCode");
                                                jSONObject3.remove("purePhoneNumber");
                                                QMLog.d(TelephonyJsPlugin.TAG, "getPhoneNumber ret : " + jSONObject3);
                                                requestEvent.ok(jSONObject3);
                                                return;
                                            }
                                            requestEvent.fail(str);
                                        }
                                    }));
                                    return;
                                } catch (Throwable th5) {
                                    QMLog.e(TelephonyJsPlugin.TAG, "getPhoneNumber error", th5);
                                    return;
                                }
                            }
                            requestEvent.fail(str);
                            return;
                        }
                        requestEvent.fail(str);
                    }
                });
            } else {
                requestEvent.fail();
            }
        } catch (JSONException e16) {
            QMLog.e(TAG, "handleNativeRequest", e16);
        }
    }

    @JsEvent({"makePhoneCall"})
    public void handleMakePhoneCall(RequestEvent requestEvent) {
        boolean z16 = false;
        if (!TextUtils.isEmpty(requestEvent.jsonParams)) {
            try {
                String optString = new JSONObject(requestEvent.jsonParams).optString(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER);
                if (!TextUtils.isEmpty(optString)) {
                    Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + optString));
                    if (!(this.mContext instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    this.mContext.startActivity(intent);
                    z16 = true;
                }
            } catch (Exception unused) {
            }
        }
        if (z16) {
            requestEvent.ok();
        } else {
            requestEvent.fail();
        }
    }
}
