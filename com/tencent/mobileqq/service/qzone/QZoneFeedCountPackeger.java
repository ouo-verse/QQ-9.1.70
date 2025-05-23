package com.tencent.mobileqq.service.qzone;

import QMF_PROTOCAL.QmfBusiControl;
import QMF_PROTOCAL.QmfDownstream;
import QMF_PROTOCAL.mobile_get_config_req;
import QMF_PROTOCAL.mobile_get_config_rsp;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.QZoneNotifyServlet;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.WNSStream;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.text.Typography;
import mqq.app.MobileQQ;
import mqq.util.LogUtil;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes18.dex */
public class QZoneFeedCountPackeger {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f286381a;

    /* renamed from: b, reason: collision with root package name */
    private static AtomicInteger f286382b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75000);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f286381a = "hostuin";
            f286382b = new AtomicInteger(Math.abs(new Random(WebSocketProtocol.PAYLOAD_SHORT_MAX).nextInt()));
        }
    }

    public static JceStruct b(byte[] bArr, QQAppInterface qQAppInterface, String str) {
        try {
            QmfDownstream unpack = new WNSStream().unpack(fh.a(bArr));
            UniAttribute uniAttribute = new UniAttribute();
            if (unpack != null && unpack.WnsCode == 0) {
                uniAttribute.setEncodeName("utf-8");
                uniAttribute.decode(unpack.Extra);
                QmfBusiControl qmfBusiControl = (QmfBusiControl) uniAttribute.get("busiCompCtl");
                if (qmfBusiControl != null && 1 == qmfBusiControl.compFlag) {
                    byte[] decompress = WNSStream.decompress(unpack.BusiBuff);
                    if (decompress == null) {
                        return null;
                    }
                    unpack.BusiBuff = decompress;
                }
                UniAttribute uniAttribute2 = new UniAttribute();
                uniAttribute2.setEncodeName("utf-8");
                uniAttribute2.decode(unpack.BusiBuff);
                JceStruct jceStruct = (JceStruct) uniAttribute2.get(str);
                ThreadManagerV2.post(new Runnable(qQAppInterface) { // from class: com.tencent.mobileqq.service.qzone.QZoneFeedCountPackeger.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ QQAppInterface f286384e;

                    {
                        this.f286384e = qQAppInterface;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) UniAttribute.this, (Object) qQAppInterface);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            QZoneFeedCountPackeger.e(UniAttribute.this, this.f286384e);
                        } else {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                    }
                }, 8, null, true);
                return jceStruct;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static byte[] c(JceStruct jceStruct, String str, long j3, int i3, int i16, int i17) {
        String str2;
        String str3;
        JceStruct jceStruct2;
        int i18;
        try {
            QLog.d("UndealCount.QZoneFeedCountPackeger", 1, "encode uin: " + LogUtil.getSafePrintUin(String.valueOf(j3)));
            UniAttribute uniAttribute = new UniAttribute();
            uniAttribute.setEncodeName("utf8");
            uniAttribute.put(f286381a, Long.valueOf(j3));
            if (jceStruct != null && str != null && str.length() > 0) {
                uniAttribute.put(str, jceStruct);
            }
            byte[] encode = uniAttribute.encode();
            String str4 = "screen_width=" + i3 + "&screen_height=" + i16;
            StringBuilder sb5 = new StringBuilder();
            try {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
                sb5.append(PlatformInfor.g().getDeviceInfor());
            } catch (Exception unused) {
            }
            if (QZoneNotifyServlet.g(QzoneLbsConstant.BUSINESS_ID_QZONE_LITTLE_VIDEO_ENTER) == null) {
                if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("disable_silent_locate_for_in_qzone", true)) {
                    QZoneNotifyServlet.j(QzoneLbsConstant.BUSINESS_ID_QZONE_LITTLE_VIDEO_ENTER);
                } else if (QLog.isDevelopLevel()) {
                    QLog.e("QZoneRequest", 4, "disable silent locate in QZoneFeedCountPackeger");
                }
                str3 = "";
                str2 = "";
            } else {
                String valueOf = String.valueOf((r9.lat * 1.0d) / 1000000.0d);
                String valueOf2 = String.valueOf((r9.lon * 1.0d) / 1000000.0d);
                str2 = valueOf;
                str3 = valueOf2;
            }
            sb5.append(Typography.amp);
            sb5.append("longitude=");
            sb5.append(str3);
            sb5.append(Typography.amp);
            sb5.append("latitude=");
            sb5.append(str2);
            if (QZoneConfigHelper.g()) {
                boolean needShowQzoneFrame = QZoneApiProxy.needShowQzoneFrame(BaseApplication.getContext(), MobileQQ.sMobileQQ.peekAppRuntime());
                sb5.append(ContainerUtils.FIELD_DELIMITER);
                sb5.append("feed_in_tab=");
                if (needShowQzoneFrame) {
                    i18 = 1;
                } else {
                    i18 = 0;
                }
                sb5.append(i18);
            }
            if (!TextUtils.isEmpty(sb5.toString())) {
                str4 = str4 + sb5.toString();
            }
            WNSStream wNSStream = new WNSStream(1000027, QZoneHelper.getQUA(), j3, new byte[0], str4);
            if (encode != null) {
                try {
                    jceStruct2 = d(i17, j3);
                } catch (Error e16) {
                    QLog.e("UndealCount.QZoneFeedCountPackeger", 1, e16, new Object[0]);
                    jceStruct2 = null;
                }
                return fh.b(wNSStream.packForUndeal(f286382b.getAndIncrement(), "QzoneNewService." + str, encode, false, jceStruct2));
            }
        } catch (Throwable unused2) {
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JceStruct d(int i3, long j3) {
        String str;
        try {
            str = com.tencent.common.config.provider.b.b();
            try {
                QLog.d("UndealCount.QZoneFeedCountPackeger", 1, "getCongfigPacket cookies: " + str);
            } catch (Throwable th5) {
                th = th5;
                QLog.e("UndealCount.QZoneFeedCountPackeger", 1, th, new Object[0]);
                if (QLog.isDevelopLevel()) {
                }
                if (str == null) {
                }
                return new mobile_get_config_req(1000027, i3, str);
            }
        } catch (Throwable th6) {
            th = th6;
            str = null;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("GetUndealCountTag", 4, "config Scene=" + i3);
        }
        if (str == null) {
            str = "";
        }
        return new mobile_get_config_req(1000027, i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(UniAttribute uniAttribute, QQAppInterface qQAppInterface) {
        if (uniAttribute != null) {
            try {
                Object obj = uniAttribute.get("conf_info_rsp_len");
                if (obj == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("UndealCount.QZoneFeedCountPackeger", 2, "processConfig pack get conf_info_rsp_len is null ");
                        return;
                    }
                    return;
                }
                int intValue = ((Integer) obj).intValue();
                byte[] bArr = (byte[]) uniAttribute.get("conf_info_rsp");
                if (bArr != null && intValue != 0) {
                    bArr = WNSStream.decompress(bArr);
                }
                if (bArr != null) {
                    JceStruct decodeWup = WNSStream.decodeWup(mobile_get_config_rsp.class, bArr);
                    if (qQAppInterface != null && qQAppInterface.getApp() != null && decodeWup != null) {
                        f(qQAppInterface, (mobile_get_config_rsp) decodeWup);
                    }
                }
            } catch (Error e16) {
                e16.printStackTrace();
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
    }

    private static void f(QQAppInterface qQAppInterface, mobile_get_config_rsp mobile_get_config_rspVar) {
        Map<String, byte[]> map;
        if (mobile_get_config_rspVar != null && (map = mobile_get_config_rspVar.config) != null && !map.isEmpty()) {
            try {
                com.tencent.common.config.provider.a.b(mobile_get_config_rspVar.config, true);
            } catch (Exception unused) {
            }
            String packageName = BaseApplication.getContext().getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                packageName = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ConfigProvider", 2, "qq config update:" + packageName);
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("UndealCount.QZoneFeedCountPackeger", 4, "UndealCount.QZoneFeedCountPackeger saveConfigToProvider");
            }
            com.tencent.common.config.provider.b.i(mobile_get_config_rspVar.config, mobile_get_config_rspVar.cookies, packageName, qQAppInterface);
        }
    }
}
