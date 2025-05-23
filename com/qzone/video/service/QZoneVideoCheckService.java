package com.qzone.video.service;

import NS_MOBILE_VIDEO.UrlInput;
import NS_MOBILE_VIDEO.UrlRsp;
import NS_MOBILE_VIDEO.change_vkey_rsp;
import NS_MOBILE_VIDEO.check_video_illegal_rsp;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.album.protocol.QZoneChangeVideoVkeyRequest;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.commoncode.module.videorecommend.model.VideoClientReportRequest;
import com.qzone.proxy.feedcomponent.manager.QZoneVideoLoader;
import com.qzone.util.ToastUtil;
import com.qzone.util.al;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.mobileqq.qzoneplayer.video.u;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneVideoCheckService implements IQZoneServiceListener {
    public static final String TAG = "QZoneVideoCheckService";
    public static final int TASK_TYPE_VIDEO_LEGALITY = 128;
    private static final int TYPE_CHANGE_VKEY = 3;
    private static final int TYPE_REDPOCKET_REPORT = 5;
    private static final int TYPE_VIDEO_VISIBILITY_REPORT = 4;
    private static al<QZoneVideoCheckService, Void> sSingleton = new a();
    private u illegalCallback;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends al<QZoneVideoCheckService, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QZoneVideoCheckService a(Void r16) {
            return new QZoneVideoCheckService();
        }
    }

    public static QZoneVideoCheckService get() {
        return sSingleton.get(null);
    }

    private void onCheckFinish(QZoneTask qZoneTask) {
        QZoneRequest qZoneRequest;
        Map<String, UrlRsp> map;
        Map.Entry<String, UrlRsp> next;
        if (qZoneTask != null && (qZoneRequest = qZoneTask.mRequest) != null && qZoneRequest.rsp != null && qZoneTask.succeeded()) {
            check_video_illegal_rsp check_video_illegal_rspVar = (check_video_illegal_rsp) qZoneTask.mRequest.rsp;
            if (check_video_illegal_rspVar == null || (map = check_video_illegal_rspVar.video_urls) == null || map.isEmpty()) {
                return;
            }
            if (QZLog.isDevelopLevel()) {
                QZLog.d(TAG, 4, "[QZ_Video]return code = " + check_video_illegal_rspVar.ret + ", map = " + check_video_illegal_rspVar.video_urls + ", illegal msg = " + check_video_illegal_rspVar.illegal_msg);
            }
            Iterator<Map.Entry<String, UrlRsp>> it = check_video_illegal_rspVar.video_urls.entrySet().iterator();
            ArrayList<com.qzone.proxy.feedcomponent.model.u> arrayList = new ArrayList<>();
            while (it.hasNext() && (next = it.next()) != null) {
                UrlRsp value = next.getValue();
                String key = next.getKey();
                int i3 = value != null ? value.code : 0;
                if (QZLog.isDevelopLevel()) {
                    QZLog.d(TAG, 4, "[QZ_Video]video vid = " + key + ", code = " + i3);
                }
                if (value != null) {
                    arrayList.add(new com.qzone.proxy.feedcomponent.model.u(key, i3, check_video_illegal_rspVar.illegal_msg));
                    if (i3 == -3 && this.illegalCallback != null) {
                        if (!TextUtils.isEmpty(check_video_illegal_rspVar.illegal_msg)) {
                            ToastUtil.r(check_video_illegal_rspVar.illegal_msg);
                        }
                        this.illegalCallback.a(key, i3, check_video_illegal_rspVar.illegal_msg);
                    }
                }
            }
            if (arrayList.size() > 0) {
                QZoneVideoLoader.l().g(arrayList);
                return;
            }
            return;
        }
        QZLog.i(TAG, 1, "[QZ_Video]failed to get response from server");
    }

    public void changeVideoVkey(String str, Handler handler) {
        QZoneTask qZoneTask = new QZoneTask(new QZoneChangeVideoVkeyRequest(str), handler, this, 3);
        qZoneTask.addParameter("url", str);
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
    }

    public void check(ArrayList<UrlInput> arrayList, u uVar) {
        String str;
        if (QZLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[QZ_Video]now check vid : ");
            if (arrayList != null && !arrayList.isEmpty()) {
                str = arrayList.get(0).url_detail;
            } else {
                str = "empty vid";
            }
            sb5.append(str);
            QZLog.d(TAG, 4, sb5.toString());
        }
        this.illegalCallback = uVar;
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new com.qzone.commoncode.module.videorecommend.model.QZoneVideoLegalityRequest(arrayList), null, this, 128));
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        int i3 = qZoneTask.mType;
        if (i3 == 3) {
            onChangeVideoVkey(qZoneTask);
        } else if (i3 == 4) {
            onSendVideoVisibilityReport(qZoneTask);
        } else {
            if (i3 != 128) {
                return;
            }
            onCheckFinish(qZoneTask);
        }
    }

    public void sendRedPocketReport(ArrayList<Map<String, String>> arrayList, Handler handler) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new VideoClientReportRequest(arrayList, 35), handler, this, 5));
    }

    private void onChangeVideoVkey(QZoneTask qZoneTask) {
        String str;
        QZoneResult result = qZoneTask.getResult(1000110);
        QZoneChangeVideoVkeyRequest qZoneChangeVideoVkeyRequest = (QZoneChangeVideoVkeyRequest) qZoneTask.mRequest;
        String str2 = (String) qZoneTask.getParameter("url");
        Bundle bundle = new Bundle();
        bundle.putString("oldUrl", str2);
        change_vkey_rsp resp = qZoneChangeVideoVkeyRequest.getResp();
        if (resp != null) {
            result.setSucceed(resp.ret == 0 && resp.video_urls != null);
            Map<String, UrlRsp> map = resp.video_urls;
            if (map != null) {
                UrlRsp urlRsp = map.get(str2);
                if (urlRsp != null && urlRsp.code == 0 && !TextUtils.isEmpty(urlRsp.url)) {
                    String str3 = urlRsp.url;
                    QZLog.i(TAG, 1, "oldUrl=" + str2 + " newUrl=" + str3);
                    bundle.putString("retryUrl", str3);
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("change vkey error! old url = ");
                    sb5.append(str2);
                    if (urlRsp == null) {
                        str = "";
                    } else {
                        str = " resultCode=" + urlRsp.code;
                    }
                    sb5.append(str);
                    QZLog.e(TAG, sb5.toString());
                    result.setSucceed(false);
                }
            }
        }
        result.setData(bundle);
        Message obtain = Message.obtain();
        obtain.obj = str2;
        obtain.what = 1000110;
        Bundle bundle2 = new Bundle();
        ParcelableWrapper.putDataToBundle(bundle2, "result", result);
        obtain.setData(bundle2);
        Handler handler = qZoneTask.getHandler();
        if (handler != null) {
            handler.sendMessage(obtain);
        }
    }

    private void onSendVideoVisibilityReport(QZoneTask qZoneTask) {
        QZLog.i(TAG, 1, "send video visibility report succeed=" + qZoneTask.getResult(1000123).getSucceed());
    }

    public void changeVideoVkey(String str, IQZoneServiceListener iQZoneServiceListener) {
        QZoneTask qZoneTask = new QZoneTask(new QZoneChangeVideoVkeyRequest(str), null, iQZoneServiceListener, 3);
        qZoneTask.addParameter("url", str);
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
    }

    public void sendVideoVisibilityReport(ArrayList<Map<String, String>> arrayList, Handler handler, boolean z16) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new VideoClientReportRequest(arrayList, z16 ? 36 : 2), handler, this, 4));
    }
}
