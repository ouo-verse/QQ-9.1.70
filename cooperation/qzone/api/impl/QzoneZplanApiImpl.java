package cooperation.qzone.api.impl;

import NS_MOBILE_FEEDS.s_picurl;
import NS_MOBILE_PHOTO.ChangePicURLRsp;
import android.text.TextUtils;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.app.QZoneRunInQQEnv;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QzoneChangePictureUrlrequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZplanQzoneApi;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.IQzoneZplanApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QzoneZplanApiImpl implements IQzoneZplanApi, IQZoneServiceListener {
    private static final String NEW_URL = "validUrl";
    private static final String OLD_URL = "invalidUrl";
    private static final String RESULT = "result";
    private static final String TAG = "QzoneZplanApiImpl";
    int mResult = -1;
    String mNewUrl = "";
    String mOldUrl = "";

    private String getValidUrl(Map<Integer, s_picurl> map) {
        if (map != null && !map.isEmpty()) {
            String validUrl = getValidUrl(map, 11);
            if (!TextUtils.isEmpty(validUrl)) {
                return validUrl;
            }
            String validUrl2 = getValidUrl(map, 1);
            if (!TextUtils.isEmpty(validUrl2)) {
                return validUrl2;
            }
            String validUrl3 = getValidUrl(map, 0);
            if (!TextUtils.isEmpty(validUrl3)) {
                return validUrl3;
            }
            QLog.e(TAG, 1, "getValidUrl failed,no correspond new url");
        }
        return "";
    }

    public JSONObject getQzoneChangedPictureUrl() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", this.mResult);
        if (this.mResult == 0) {
            jSONObject.put(OLD_URL, this.mOldUrl);
            jSONObject.put(NEW_URL, this.mNewUrl);
        }
        return jSONObject;
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask.mRequest instanceof QzoneChangePictureUrlrequest) {
            s c16 = s.c(qZoneTask.getResult(0));
            int i3 = qZoneTask.mResultCode;
            if (i3 != 0) {
                this.mResult = i3;
                c16.setSucceed(false);
            } else {
                ChangePicURLRsp changePicURLRsp = (ChangePicURLRsp) qZoneTask.mRequest.rsp;
                c16.setSucceed(true);
                this.mNewUrl = getNewUrl(changePicURLRsp);
                this.mResult = 0;
            }
            try {
                ((IZplanQzoneApi) QRoute.api(IZplanQzoneApi.class)).onGetValidUrl(getQzoneChangedPictureUrl());
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // cooperation.qzone.api.IQzoneZplanApi
    public boolean qzoneEnvInit(AppRuntime appRuntime) {
        return QZoneRunInQQEnv.init(appRuntime);
    }

    @Override // cooperation.qzone.api.IQzoneZplanApi
    public void sendChangePicUrlRequest(String str) {
        this.mOldUrl = str;
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneChangePictureUrlrequest(new ArrayList(Collections.singleton(this.mOldUrl)), 1), null, this, 0));
    }

    private String getNewUrl(ChangePicURLRsp changePicURLRsp) {
        Map<String, Map<Integer, s_picurl>> map;
        if (changePicURLRsp != null && (map = changePicURLRsp.urls) != null && !map.isEmpty()) {
            return getValidUrl(changePicURLRsp.urls.get(this.mOldUrl));
        }
        return "";
    }

    private String getValidUrl(Map<Integer, s_picurl> map, Integer num) {
        s_picurl s_picurlVar = map.get(num);
        return s_picurlVar != null ? s_picurlVar.url : "";
    }
}
