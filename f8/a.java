package f8;

import NS_MOBILE_COMM.yellow_info;
import NS_MOBILE_EXTRA.DeviceInfo;
import NS_MOBILE_EXTRA.GetDeviceInfoRsp;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.personalize.phonetail.protocol.QZoneGetDeviceInfoRequest;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements IQZoneServiceListener {

    /* renamed from: d, reason: collision with root package name */
    public static String f397982d = "PHONE_LABEL_KEY";

    /* renamed from: e, reason: collision with root package name */
    public static String f397983e = "PHONE_LABEL_ICON";

    /* renamed from: f, reason: collision with root package name */
    public static String f397984f = "PHONE_LABEL_MODEL";

    /* renamed from: h, reason: collision with root package name */
    private static String f397985h = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhoneLabelNotShow", "\u4e0d\u663e\u793a");

    /* renamed from: i, reason: collision with root package name */
    private static String f397986i = "";

    public static String b() {
        String h06 = u5.b.h0(f397982d + "_" + LoginData.getInstance().getUin(), f397986i);
        if (TextUtils.isEmpty(h06)) {
            return h06;
        }
        String h07 = u5.b.h0(f397984f + "_" + LoginData.getInstance().getUin(), "");
        if (TextUtils.isEmpty(h07) || h07.equals(ah.F())) {
            return h06;
        }
        QZLog.i("QZoneGetDeviceInfoService", "model in sp: " + h07 + " current model is :" + ah.F());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(f397982d);
        sb5.append("_");
        sb5.append(LoginData.getInstance().getUin());
        u5.b.v0(sb5.toString(), f397986i);
        return f397986i;
    }

    public void a(long j3, int i3, Handler handler) {
        QZoneTask qZoneTask = new QZoneTask(new QZoneGetDeviceInfoRequest(j3), handler, this, 0);
        qZoneTask.addParameter(RemoteHandleConst.WEBPLUGIN_SERVICE_REQUEST_ID, Integer.valueOf(i3));
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        QZoneRequest qZoneRequest;
        JceStruct jceStruct;
        GetDeviceInfoRsp getDeviceInfoRsp;
        if (qZoneTask == null || qZoneTask.getHandler() == null || (qZoneRequest = qZoneTask.mRequest) == null || (jceStruct = qZoneRequest.rsp) == null || !(jceStruct instanceof GetDeviceInfoRsp) || (getDeviceInfoRsp = (GetDeviceInfoRsp) jceStruct) == null) {
            return;
        }
        yellow_info yellow_infoVar = getDeviceInfoRsp.user_yellow_info;
        if (yellow_infoVar != null) {
            LoginData.getInstance().updateVipInfos(yellow_infoVar.iYellowType, yellow_infoVar.iYellowLevel, yellow_infoVar.isAnnualVip);
        }
        ArrayList<DeviceInfo> arrayList = getDeviceInfoRsp.vecDeviceInfo;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        DeviceInfo deviceInfo = arrayList.get(arrayList.size() - 1);
        if ("".equals(deviceInfo.strDeviceTail)) {
            deviceInfo.strDeviceTail = f397985h;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<DeviceInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            DeviceInfo next = it.next();
            if (next != null) {
                String str = next.strDiyMemo;
                if (str != null) {
                    next.strDiyMemo = str.trim();
                }
                arrayList2.add(next.toJSON().toString());
            }
        }
        Integer num = (Integer) qZoneTask.getParameter(RemoteHandleConst.WEBPLUGIN_SERVICE_REQUEST_ID);
        Handler handler = qZoneTask.getHandler();
        Bundle bundle = new Bundle();
        Message obtainMessage = handler.obtainMessage(num.intValue());
        if (obtainMessage == null || arrayList2.size() <= 0) {
            return;
        }
        bundle.putString(RemoteHandleConst.PARAM_DEVICE_INFOS, arrayList2.toString());
        obtainMessage.obj = bundle;
        handler.sendMessage(obtainMessage);
    }
}
