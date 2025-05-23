package com.qzone.common.business.service;

import BOSSStrategyCenter.tAdvDesc;
import NS_MOBILE_FEEDS.mobile_video_layer_adv_rsp;
import NS_MOBILE_FEEDS.single_feed;
import NS_MOBILE_QBOSS_PROTO.MobileQbossAdvRsp;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.commoncode.module.videorecommend.model.QZoneEncourageAdvRequest;
import com.qzone.misc.network.qboss.protocol.QzoneQBossAdvRequest;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.component.app.common.ParcelableWrapper;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneAdvService implements IQZoneServiceListener {

    /* renamed from: d, reason: collision with root package name */
    private static QZoneAdvService f45589d;

    public static synchronized QZoneAdvService c() {
        QZoneAdvService qZoneAdvService;
        synchronized (QZoneAdvService.class) {
            if (f45589d == null) {
                f45589d = new QZoneAdvService();
            }
            qZoneAdvService = f45589d;
        }
        return qZoneAdvService;
    }

    private void e(QZoneTask qZoneTask, int i3) {
        JceStruct jceStruct;
        Map<Integer, ArrayList<tAdvDesc>> map;
        ArrayList<tAdvDesc> arrayList;
        JSONObject jSONObject;
        String str;
        if (qZoneTask == null) {
            QZLog.e("QZoneAdvService", "processTaskReponse task is null");
            return;
        }
        QZoneResult result = qZoneTask.getResult(i3);
        if (result.getReturnCode() != 0) {
            QZLog.d("QZoneAdvService", 1, "processAllTaskReponse  businessType:" + i3 + " fail code:" + qZoneTask.mResultCode);
            return;
        }
        QZoneRequest qZoneRequest = qZoneTask.mRequest;
        if ((qZoneRequest instanceof QzoneQBossAdvRequest) && (jceStruct = ((QzoneQBossAdvRequest) qZoneRequest).rsp) != null && (jceStruct instanceof MobileQbossAdvRsp) && (map = ((MobileQbossAdvRsp) jceStruct).mapAdv) != null && (arrayList = map.get(Integer.valueOf(i3))) != null && arrayList.size() > 0) {
            tAdvDesc tadvdesc = arrayList.get(0);
            try {
                jSONObject = new JSONObject(tadvdesc.res_data);
            } catch (JSONException e16) {
                QZLog.e("QZoneAdvService", "processAllTaskReponse failed JSONException:" + e16.getStackTrace());
                jSONObject = null;
            }
            if (jSONObject == null) {
                QZLog.e("QZoneAdvService", "processAllTaskReponse failed resData is null");
                result.setSucceed(false);
                return;
            }
            Bundle bundle = new Bundle();
            a(bundle, jSONObject);
            boolean z16 = i3 == 2572;
            if (!TextUtils.isEmpty(tadvdesc.res_traceinfo)) {
                if (z16) {
                    str = "trace_new_info";
                } else {
                    str = "trace_info";
                }
                bundle.putString(str, tadvdesc.res_traceinfo);
            }
            QZLog.d("QZoneAdvService", 1, "OnGetNamingAdvResponse success");
            result.setData(bundle);
            result.setSucceed(true);
            qZoneTask.sendResultMsg(result);
        }
    }

    public void b(Context context, HashMap<String, String> hashMap, Handler handler) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneEncourageAdvRequest(LoginData.getInstance().getUin(), hashMap), handler, this, 5));
    }

    public void g(Handler handler, int i3, int i16) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneQBossAdvRequest(LoginData.getInstance().getUin(), i16), handler, this, i3));
        QZLog.d("QZoneAdvService", 1, "requestOperateAdvContent localOpeType:" + i3 + " businessType:" + i16);
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask == null) {
            QZLog.e("QZoneAdvService", "onTaskResponse task is null");
            return;
        }
        int i3 = qZoneTask.mType;
        if (i3 == 1) {
            e(qZoneTask, 2541);
            return;
        }
        if (i3 == 2) {
            e(qZoneTask, 2542);
            return;
        }
        if (i3 == 3) {
            e(qZoneTask, 2540);
        } else if (i3 == 4) {
            e(qZoneTask, 2572);
        } else {
            if (i3 != 5) {
                return;
            }
            f(qZoneTask);
        }
    }

    private void f(QZoneTask qZoneTask) {
        ArrayList<single_feed> arrayList;
        QZoneResult result = qZoneTask.getResult(1000152);
        mobile_video_layer_adv_rsp mobile_video_layer_adv_rspVar = (mobile_video_layer_adv_rsp) ((QZoneEncourageAdvRequest) qZoneTask.mRequest).rsp;
        Bundle bundle = new Bundle();
        if (mobile_video_layer_adv_rspVar != null && (arrayList = mobile_video_layer_adv_rspVar.all_feeds_adv) != null && arrayList.size() > 0) {
            bundle.putParcelable("qzone_encourage_adv_bundle_id", ParcelableWrapper.obtain(BusinessFeedData.createFrom(mobile_video_layer_adv_rspVar.all_feeds_adv.get(0), 0)));
            result.setSucceed(true);
        } else {
            result.setSucceed(false);
        }
        result.setData(bundle);
        qZoneTask.sendResultMsg(result);
    }

    void d(JSONObject jSONObject, String str, Bundle bundle, String str2) {
        if (jSONObject == null || str == null || TextUtils.isEmpty(str) || str2 == null || TextUtils.isEmpty(str2)) {
            return;
        }
        String str3 = null;
        try {
            if (jSONObject.has(str)) {
                str3 = jSONObject.getString(str);
            }
        } catch (JSONException e16) {
            QZLog.e("QZoneAdvService", "OnGetNamingAdvResponse failed JSONException: " + e16.getStackTrace());
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        bundle.putString(str2, str3);
    }

    private void a(Bundle bundle, JSONObject jSONObject) {
        if (bundle == null || jSONObject == null) {
            return;
        }
        for (Map.Entry<String, String> entry : new HashMap<String, String>() { // from class: com.qzone.common.business.service.QZoneAdvService.1
            {
                put("jump_url", "jump_url");
                put("text_normal", "text_normal");
                put("logo_pic_normal", "logo_pic_normal");
                put("logo_pic_normal_md5", "logo_pic_normal_md5");
                put("text", "text");
                put("logo_pic", "logo_pic");
                put("logo_pic_md5", "logo_pic_md5");
                put("text_hd", "text_hd");
                put("logo_pic_hd", "logo_pic_hd");
                put("logo_pic_hd_md5", "logo_pic_hd_md5");
                put("out_logo_pic_normal", "out_logo_pic_normal");
                put("out_logo_pic_normal_md5", "out_logo_pic_normal_md5");
                put("out_logo_pic", "out_logo_pic");
                put("out_logo_pic_md5", "out_logo_pic_md5");
                put("out_logo_pic_hd", "out_logo_pic_hd");
                put("out_logo_pic_hd_md5", "out_logo_pic_hd_md5");
            }
        }.entrySet()) {
            d(jSONObject, entry.getKey(), bundle, entry.getValue());
        }
    }
}
