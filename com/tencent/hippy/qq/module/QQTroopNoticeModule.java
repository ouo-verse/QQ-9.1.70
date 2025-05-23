package com.tencent.hippy.qq.module;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoUrl;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = QQTroopNoticeModule.CLASSNAME)
/* loaded from: classes7.dex */
public class QQTroopNoticeModule extends QQBaseModule {
    static final String CLASSNAME = "QQTroopNoticeModule";
    private BroadcastReceiver mCallReceiver;

    public QQTroopNoticeModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    @HippyMethod(name = "showPicture")
    public void showPicture(String str, final Promise promise) {
        String jSONObject;
        PublicAccountShowPictureReport publicAccountShowPictureReport;
        ArrayList arrayList;
        ArrayList arrayList2;
        QBaseFragment fragment = getFragment();
        if (fragment == null) {
            QLog.e(CLASSNAME, 1, "showPicture fragment is null");
            return;
        }
        QBaseActivity qBaseActivity = fragment.getQBaseActivity();
        if (!(qBaseActivity instanceof QBaseActivity)) {
            QLog.e(CLASSNAME, 1, "showPicture activity isvnot QBaseActivity");
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            String optString = jSONObject2.optString("bigurl");
            if (!TextUtils.isEmpty(optString)) {
                String optString2 = jSONObject2.optString("videoID");
                String optString3 = jSONObject2.optString("videoURL");
                jSONObject2.optString("originalVideoURL");
                int optInt = jSONObject2.optInt("videoWidth");
                int optInt2 = jSONObject2.optInt("videoHeight");
                jSONObject2.optBoolean("isLike");
                QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                Bundle bundle = new Bundle();
                ArrayList arrayList3 = new ArrayList();
                PhotoInfo photoInfo = new PhotoInfo();
                photoInfo.bigUrl = optString;
                photoInfo.videoflag = 1;
                VideoInfo videoInfo = new VideoInfo();
                photoInfo.videodata = videoInfo;
                videoInfo.videoId = optString2;
                PictureUrl pictureUrl = new PictureUrl();
                pictureUrl.url = optString;
                photoInfo.videodata.coverUrl = pictureUrl;
                VideoUrl videoUrl = new VideoUrl();
                videoUrl.url = optString3;
                VideoInfo videoInfo2 = photoInfo.videodata;
                videoInfo2.videoId = optString2;
                videoInfo2.actionUrl = optString3;
                videoInfo2.videoUrl = videoUrl;
                videoInfo2.width = optInt;
                videoInfo2.height = optInt2;
                videoInfo2.videoStatus = 5;
                arrayList3.add(photoInfo);
                bundle.putSerializable("picturelist", arrayList3);
                bundle.putInt("curindex", 0);
                bundle.putInt("mode", 3);
                bundle.putBoolean("need_clear_cache", true);
                QZoneHelper.forwardToPictureViewer(qBaseActivity, userInfo, bundle, 6);
            }
            JSONArray optJSONArray = jSONObject2.optJSONArray("imageIDs");
            JSONArray optJSONArray2 = jSONObject2.optJSONArray("likes");
            JSONArray optJSONArray3 = jSONObject2.optJSONArray("descs");
            JSONArray optJSONArray4 = jSONObject2.optJSONArray("sourceIDs");
            JSONArray optJSONArray5 = jSONObject2.optJSONArray("sourceSize");
            boolean optBoolean = jSONObject2.optBoolean("needBottomBar");
            JSONObject optJSONObject = jSONObject2.optJSONObject("extra");
            if (optJSONObject == null) {
                jSONObject = "";
            } else {
                jSONObject = optJSONObject.toString();
            }
            int optInt3 = jSONObject2.optInt("index");
            String optString4 = jSONObject2.optString("srcID");
            if (Boolean.valueOf(jSONObject2.optBoolean("isReport")).booleanValue()) {
                publicAccountShowPictureReport = new PublicAccountShowPictureReport();
                publicAccountShowPictureReport.parse(jSONObject2);
            } else {
                publicAccountShowPictureReport = null;
            }
            boolean optBoolean2 = jSONObject2.optBoolean("isNotShowIndex", true);
            if (optJSONArray == null || optJSONArray.length() == 0 || getAppInterface() == null) {
                return;
            }
            ArrayList arrayList4 = new ArrayList();
            int length = optJSONArray.length();
            PublicAccountShowPictureReport publicAccountShowPictureReport2 = publicAccountShowPictureReport;
            int i3 = 0;
            while (i3 < length) {
                arrayList4.add(optJSONArray.get(i3).toString());
                i3++;
                optJSONArray = optJSONArray;
            }
            if (optJSONArray4 != null) {
                arrayList = new ArrayList();
                int length2 = optJSONArray4.length();
                int i16 = 0;
                while (i16 < length2) {
                    arrayList.add(optJSONArray4.get(i16).toString());
                    i16++;
                    optJSONArray4 = optJSONArray4;
                }
            } else {
                arrayList = null;
            }
            if (optJSONArray5 != null) {
                ArrayList arrayList5 = new ArrayList();
                int length3 = optJSONArray5.length();
                int i17 = 0;
                while (i17 < length3) {
                    arrayList5.add(optJSONArray5.get(i17).toString());
                    i17++;
                    optJSONArray5 = optJSONArray5;
                }
                arrayList2 = arrayList5;
            } else {
                arrayList2 = null;
            }
            boolean optBoolean3 = jSONObject2.optBoolean("showTitle", false);
            String encodeToString = PluginBaseInfoHelper.Base64Helper.encodeToString(jSONObject2.optString("title", "").getBytes(), 0);
            String optString5 = jSONObject2.optString("articleUrl", "");
            if (QLog.isColorLevel()) {
                QLog.d(CLASSNAME, 2, "KANDIAN Grid Image title: ", encodeToString, ", articleUrl: ", optString5, ", showTitle: ", Boolean.valueOf(optBoolean3));
            }
            if (optBoolean) {
                if (optJSONArray2 == null) {
                    return;
                }
                boolean[] zArr = new boolean[optJSONArray2.length()];
                for (int i18 = 0; i18 < optJSONArray2.length(); i18++) {
                    zArr[i18] = optJSONArray2.getBoolean(i18);
                }
                ArrayList arrayList6 = new ArrayList();
                if (optJSONArray3 != null && optJSONArray3.length() != 0) {
                    int length4 = optJSONArray3.length();
                    for (int i19 = 0; i19 < length4; i19++) {
                        arrayList6.add(optJSONArray3.get(i19).toString());
                    }
                }
                if (this.mCallReceiver == null) {
                    this.mCallReceiver = new BroadcastReceiver() { // from class: com.tencent.hippy.qq.module.QQTroopNoticeModule.1
                        @Override // android.content.BroadcastReceiver
                        public void onReceive(Context context, Intent intent) {
                            String stringExtra = intent.getStringExtra("callback");
                            QLog.d("TroopReceiver", 4, stringExtra);
                            promise.resolve(stringExtra);
                        }
                    };
                    qBaseActivity.registerReceiver(this.mCallReceiver, new IntentFilter("android.intent.action.WEBJSCALL"));
                }
                if (optBoolean3 && !TextUtils.isEmpty(encodeToString) && !TextUtils.isEmpty(optString5)) {
                    TroopNoticeJsHandler.A(qBaseActivity, optInt3, arrayList4, zArr, arrayList6, optBoolean, optBoolean2, optString4, 100, publicAccountShowPictureReport2, optString5, encodeToString, jSONObject);
                    return;
                } else {
                    TroopNoticeJsHandler.y(qBaseActivity, optInt3, arrayList4, zArr, arrayList6, optBoolean, optBoolean2, optString4, 100, publicAccountShowPictureReport2, arrayList, arrayList2, jSONObject, true);
                    return;
                }
            }
            if (optBoolean3 && !TextUtils.isEmpty(encodeToString) && !TextUtils.isEmpty(optString5)) {
                TroopNoticeJsHandler.A(qBaseActivity, optInt3, arrayList4, null, null, false, optBoolean2, optString4, 100, publicAccountShowPictureReport2, optString5, encodeToString, jSONObject);
            } else {
                TroopNoticeJsHandler.x(qBaseActivity, optInt3, arrayList4, null, null, false, optBoolean2, optString4, 100, publicAccountShowPictureReport2, jSONObject);
            }
        } catch (JSONException unused) {
        }
    }
}
