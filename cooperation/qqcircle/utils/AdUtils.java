package cooperation.qqcircle.utils;

import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes28.dex */
public class AdUtils {
    private static final String AD_POS_ID = "3073335280629598";
    private static final String BIZ_ID = "d61533";
    private static final String ELDER_MODEL_KEY = "elderly";
    private static final String TAG = "AdUtils";
    private static final String TEENAGER_MODEL_KEY = "teenager";
    private static qq_ad_get.QQAdGet.DeviceInfo mDeviceInfo;

    private static access.AdGetReq createAdReq(int i3) {
        access.AdGetReq adGetReq = new access.AdGetReq();
        qq_ad_get.QQAdGet qQAdGet = new qq_ad_get.QQAdGet();
        try {
            adGetReq.busi_type.set(i3);
            adGetReq.client_mod.set(getModelString());
            qq_ad_get.QQAdGet.PositionInfo positionInfo = new qq_ad_get.QQAdGet.PositionInfo();
            positionInfo.pos_id.set(AD_POS_ID);
            positionInfo.ad_count.set(1);
            qq_ad_get.QQAdGet.PositionInfo.PositionExt positionExt = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
            positionExt.deep_link_version.set(1);
            positionInfo.pos_ext.set(positionExt);
            qQAdGet.position_info.add(positionInfo);
            if (mDeviceInfo == null) {
                mDeviceInfo = getDeviceInfo();
            }
            qq_ad_get.QQAdGet.DeviceInfo deviceInfo = mDeviceInfo;
            if (deviceInfo != null) {
                qQAdGet.device_info.set(deviceInfo);
            }
            qQAdGet.support_https.set(true);
            qQAdGet.user_info.set(new qq_ad_get.QQAdGet.UserInfo());
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "create ad req failed " + th5);
        }
        adGetReq.qq_ad_get.set(qQAdGet);
        return adGetReq;
    }

    public static ByteStringMicro getAdReqByte(int i3) {
        return ByteStringMicro.copyFrom(createAdReq(i3).toByteArray());
    }

    private static qq_ad_get.QQAdGet.DeviceInfo getDeviceInfo() {
        GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(BaseApplication.getContext(), new GdtDeviceInfoHelper.Params());
        if (create != null) {
            return create.deviceInfo;
        }
        return null;
    }

    private static String getModelString() {
        String str;
        if (SimpleUIUtil.isNowElderMode()) {
            str = "elderly";
        } else {
            str = "default";
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return "teenager";
        }
        return str;
    }
}
