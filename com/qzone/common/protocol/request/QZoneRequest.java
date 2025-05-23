package com.qzone.common.protocol.request;

import QMF_PROTOCAL.QmfBusiControl;
import QMF_PROTOCAL.QmfDownstream;
import QMF_PROTOCAL.QmfServerInfo;
import QMF_PROTOCAL.RetryInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.app.ParamConstants;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.BaseFeedFragmentFeedImp;
import com.qzone.common.protocol.INetworkCallback;
import com.qzone.common.protocol.IQZoneProtocolListener;
import com.qzone.publish.business.publishqueue.c;
import com.qzone.reborn.configx.g;
import com.qzone.util.q;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.mobileqq.qcircle.api.IQFSPlayerStrategyApi;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzoneplayer.report.b;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QzoneExternalRequest;
import cooperation.qzone.WNSStream;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.statistic.serverip.WebAppIpManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.WnsError;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.TimeZone;
import kotlin.text.Typography;
import mqq.app.MobileQQ;
import org.slf4j.Marker;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class QZoneRequest extends QzoneExternalRequest implements INetworkCallback, SmartParcelable {
    public static String DEFAULT_COMMAND_PREFIX = "QzoneNewService.";
    public static final String FIELD_UIN = "hostuin";
    private static final String TIMESTAMP_MSF2NET_M = "timestamp_msf2net_atMsfSite";
    protected String TAG;
    public byte[] busiBuffer;

    @NeedParcel
    private boolean canRequestRetry;

    @NeedParcel
    public String contentCacheUnikey;

    @NeedParcel
    public long endTime;
    protected volatile boolean isRetry;

    @NeedParcel
    private String mCmd;
    private String mCommandPrefix;
    public transient IQZoneProtocolListener mListner;
    protected c mUploadQueueListener;

    @NeedParcel
    protected HashMap<Object, Object> params;

    @NeedParcel
    private long pkgId;

    @NeedParcel
    public JceStruct req;
    public int reqId;

    @NeedParcel
    public long reqSize;

    @NeedParcel
    private int requestRetryCount;

    @NeedParcel
    public long respSize;

    @NeedParcel
    public JceStruct rsp;

    @NeedParcel
    public long startTime;

    @NeedParcel
    public JceStruct universalRsp;

    public QZoneRequest() {
        this.TAG = "";
        this.mCommandPrefix = DEFAULT_COMMAND_PREFIX;
        this.params = new HashMap<>();
        this.isRetry = false;
    }

    private static void appendGdtDeviceInfo(StringBuilder sb5) {
        qq_ad_get.QQAdGet.DeviceInfo deviceInfo;
        BaseApplication context = BaseApplication.getContext();
        if (context == null || sb5 == null) {
            return;
        }
        try {
            GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(context, new GdtDeviceInfoHelper.Params());
            if (create == null || (deviceInfo = create.deviceInfo) == null || deviceInfo == null) {
                return;
            }
            sb5.append(Typography.amp);
            sb5.append("qadid=");
            sb5.append(deviceInfo.qadid.get());
            sb5.append(Typography.amp);
            sb5.append("md5_android_id=");
            sb5.append(deviceInfo.md5_android_id.get());
            sb5.append(Typography.amp);
            sb5.append("md5_mac=");
            sb5.append(deviceInfo.md5_mac.get());
            sb5.append(Typography.amp);
            sb5.append("client_ipv4=");
            sb5.append(deviceInfo.client_ipv4.get());
            sb5.append(Typography.amp);
            sb5.append("aid_ticket=");
            sb5.append(deviceInfo.aid_ticket.get());
            sb5.append(Typography.amp);
            sb5.append("taid_ticket=");
            sb5.append(deviceInfo.taid_ticket.get());
            sb5.append(Typography.amp);
            sb5.append("muid=");
            sb5.append(deviceInfo.muid.get());
            sb5.append(Typography.amp);
            sb5.append("muid_type=");
            sb5.append(deviceInfo.muid_type.get());
            if (!TextUtils.isEmpty(deviceInfo.device_ext.get())) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
                sb5.append("device_ext=");
                sb5.append(URLEncoder.encode(deviceInfo.device_ext.get(), "UTF-8"));
            }
            sb5.append(Typography.amp);
            sb5.append("video_auto_play=");
            sb5.append(i.H().m() ? 1 : 0);
            sb5.append(Typography.amp);
            sb5.append("sound_auto_play=");
            sb5.append(0);
        } catch (Exception e16) {
            QLog.e("QzoneExternalRequest", 1, "appendGdtDeviceInfo exception", e16);
        }
    }

    public static String getDeiviceInfoDetail(boolean z16) {
        return getDeiviceInfoDetailInner(z16);
    }

    public static String getDeiviceInfoDetailInner(boolean z16) {
        String valueOf;
        String valueOf2;
        StringBuilder sb5;
        StringBuilder sb6 = new StringBuilder(PlatformInfor.g().getDeviceInfor());
        NetworkState.isWifiConn();
        if (BaseFeedFragmentFeedImp.q() == 1) {
            sb6.append(Typography.amp);
            sb6.append("big=1");
        }
        if (z16) {
            appendGdtDeviceInfo(sb6);
        }
        String str = "";
        if (com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_REQUEST_SERVER).a() == null) {
            if (!g.f53821a.b().p()) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.common.protocol.request.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        QZoneRequest.lambda$getDeiviceInfoDetailInner$0();
                    }
                });
            } else {
                QLog.e("QZoneRequest", 2, "disable silent locate");
            }
            valueOf2 = "";
            valueOf = valueOf2;
        } else {
            valueOf = String.valueOf((r13.lat * 1.0d) / 1000000.0d);
            valueOf2 = String.valueOf((r13.lon * 1.0d) / 1000000.0d);
        }
        sb6.append(ContainerUtils.FIELD_DELIMITER);
        sb6.append("qimei=");
        sb6.append(o.b());
        sb6.append(Typography.amp);
        sb6.append("longitude=");
        sb6.append(valueOf2);
        sb6.append(Typography.amp);
        sb6.append("latitude=");
        sb6.append(valueOf);
        sb6.append(Typography.amp);
        sb6.append("coordtype=");
        sb6.append(0);
        if (QZLog.isColorLevel()) {
            QZLog.d(QZLog.TO_DEVICE_TAG, 2, "QZoneRequest\t" + sb6.toString());
        }
        String e16 = q.e();
        if (!TextUtils.isEmpty(e16)) {
            sb6.append(Typography.amp);
            sb6.append("localdns=");
            sb6.append(e16);
        }
        String c16 = q.c();
        if (!TextUtils.isEmpty(c16)) {
            sb6.append(Typography.amp);
            sb6.append("userip=");
            sb6.append(c16);
        }
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        sb6.append(Typography.amp);
        sb6.append("timezone=");
        if (rawOffset > 0) {
            sb5 = new StringBuilder();
            str = Marker.ANY_NON_NULL_MARKER;
        } else {
            sb5 = new StringBuilder();
        }
        sb5.append(str);
        sb5.append(rawOffset);
        sb6.append(sb5.toString());
        sb6.append(",id:" + TimeZone.getDefault().getID());
        float b16 = b.c().b();
        if (b16 != 0.0f) {
            sb6.append(Typography.amp);
            sb6.append("videospeed=");
            sb6.append(String.valueOf(b16));
        }
        boolean t16 = StudyModeManager.t();
        sb6.append(ContainerUtils.FIELD_DELIMITER);
        sb6.append("is_teenager_mod=");
        sb6.append(t16 ? 1 : 0);
        boolean isNowElderMode = SimpleUIUtil.isNowElderMode();
        sb6.append(ContainerUtils.FIELD_DELIMITER);
        sb6.append("is_care_mod=");
        sb6.append(isNowElderMode ? 1 : 0);
        sb6.append(ContainerUtils.FIELD_DELIMITER);
        sb6.append("feeds_new_style=");
        sb6.append(1);
        if (km.a.f412646a.a()) {
            boolean needShowQzoneFrame = QZoneApiProxy.needShowQzoneFrame(BaseApplication.getContext(), MobileQQ.sMobileQQ.peekAppRuntime());
            sb6.append(ContainerUtils.FIELD_DELIMITER);
            sb6.append("feed_in_tab=");
            sb6.append(needShowQzoneFrame ? 1 : 0);
        }
        if (QZoneConfigHelper.h()) {
            sb6.append(ContainerUtils.FIELD_DELIMITER);
            sb6.append("AV1=");
            sb6.append(((IQFSPlayerStrategyApi) QRoute.api(IQFSPlayerStrategyApi.class)).getAV1Flag());
            sb6.append(ContainerUtils.FIELD_DELIMITER);
            sb6.append("hwlevel=");
            sb6.append(QCircleVideoDeviceInfoUtils.getVideoDeviceLevel());
        }
        return sb6.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getDeiviceInfoDetailInner$0() {
        com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_REQUEST_SERVER).f();
    }

    public void addParameter(Object obj, Object obj2) {
        this.params.put(obj, obj2);
    }

    public boolean canRequestRetry() {
        return this.canRequestRetry;
    }

    public void decodeAndCallback(byte[] bArr, FromServiceMsg fromServiceMsg) {
        int i3;
        if (bArr == null) {
            QZLog.e(QZLog.TO_DEVICE_TAG, "cmd=" + uniKey() + " QZoneRequest decodeAndCallback() data is null");
            doCallback(null, 1000003, 1000003, "");
            return;
        }
        try {
            QmfDownstream unpack = new WNSStream().unpack(bArr);
            UniAttribute uniAttribute = new UniAttribute();
            if (unpack != null && unpack.WnsCode == 0) {
                uniAttribute.setEncodeName("utf-8");
                uniAttribute.decode(unpack.Extra);
                QmfServerInfo qmfServerInfo = (QmfServerInfo) uniAttribute.get("server_info");
                if (WebAppIpManager.isValidServerInfo(qmfServerInfo)) {
                    WebAppIpManager.getInstance().addWebAppIpRecord(qmfServerInfo);
                    this.params.put(ParamConstants.KEY_REPORT_BUSI_SERVERIP, NetworkState.IntAddr2Ip(qmfServerInfo.ipWebapp.ClientIpv4));
                }
                QmfBusiControl qmfBusiControl = (QmfBusiControl) uniAttribute.get("busiCompCtl");
                if (qmfBusiControl != null && 1 == qmfBusiControl.compFlag) {
                    byte[] decompress = WNSStream.decompress(unpack.BusiBuff);
                    if (decompress != null) {
                        unpack.BusiBuff = decompress;
                    } else {
                        QZLog.e(QZLog.TO_DEVICE_TAG, "cmd=" + uniKey() + " QZoneRequest decompress error");
                        doCallback(uniAttribute, 1000002, 1000002, "");
                        return;
                    }
                }
                UniAttribute uniAttribute2 = new UniAttribute();
                uniAttribute2.setEncodeName("utf-8");
                uniAttribute2.decode(unpack.BusiBuff);
                this.busiBuffer = unpack.BusiBuff;
                this.rsp = (JceStruct) uniAttribute2.get(uniKey());
                this.universalRsp = (JceStruct) uniAttribute2.get("commInteractive");
                if (this.rsp == null) {
                    QZLog.e(QZLog.TO_DEVICE_TAG, uniKey() + " decode rsp is null!");
                }
                short s16 = unpack.BizCode;
                Object obj = uniAttribute2.get("ret", Short.valueOf(s16));
                if (obj instanceof Short) {
                    i3 = ((Short) obj).intValue();
                } else {
                    i3 = s16;
                    if (obj instanceof Integer) {
                        i3 = ((Integer) obj).intValue();
                    }
                }
                String str = (String) uniAttribute2.get("msg", "");
                QZLog.i(QZLog.TO_DEVICE_TAG, 1, "cmd=" + uniKey() + ", appSeq:" + fromServiceMsg.getAppSeq() + ", pkgId:" + getRequestPkgId());
                doCallback(uniAttribute2, i3, i3, str);
                return;
            }
            if (unpack == null || unpack.WnsCode == 0) {
                if (unpack == null) {
                    QZLog.e(QZLog.TO_DEVICE_TAG, "cmd=" + uniKey() + " QZoneRequest unpack error,result is null");
                    doCallback(uniAttribute, 1000003, 1000003, "");
                    return;
                }
                return;
            }
            QZLog.e(QZLog.TO_DEVICE_TAG, "cmd=" + uniKey() + " QZoneRequest decodeAndCallback wnscode=" + ((int) unpack.WnsCode) + ",msg=" + WnsError.getErrorMessage(unpack.WnsCode));
            int i16 = unpack.WnsCode;
            doCallback(uniAttribute, i16, i16, WnsError.getErrorMessage(i16));
        } catch (Throwable th5) {
            th5.printStackTrace();
            String stackTraceString = QLog.getStackTraceString(th5);
            if (stackTraceString != null) {
                addParameter(ParamConstants.KEY_REPORT_DETAIL_MSG, stackTraceString);
            }
            QZLog.e(QZLog.TO_DEVICE_TAG, "cmd=" + uniKey() + " QZoneRequest decodeAndCallback occur exeception. stack info:" + stackTraceString);
            doCallback(null, 1000001, 1000001, "");
        }
    }

    protected void doCallback(UniAttribute uniAttribute, int i3, int i16, String str) {
        doCallback(uniAttribute, i3, i16, str, false);
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return this.mCommandPrefix + this.mCmd;
    }

    public String getContentCacheUnikey() {
        return this.contentCacheUnikey;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getDeviceInfo() {
        return getDeiviceInfoDetail(needAppendGdtInfo());
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getDeviceTail() {
        return f8.a.b();
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    protected long getHostUin() {
        return LoginData.getInstance().getUin();
    }

    public String getLocalIpAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkMonitor.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = NetworkMonitor.getInetAddresses(networkInterfaces.nextElement());
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        return nextElement.getHostAddress().toString();
                    }
                }
            }
            return null;
        } catch (SocketException e16) {
            QZLog.e(QZLog.TO_DEVICE_TAG, e16.toString());
            return null;
        }
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public long getLoginUserId() {
        return LoginData.getInstance().getUin();
    }

    public Object getParameter(Object obj) {
        return this.params.get(obj);
    }

    public abstract String getReportEventName();

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        return this.req;
    }

    public String getRequestCmd() {
        return this.mCmd;
    }

    public long getRequestPkgId() {
        return this.pkgId;
    }

    public int getRequestRetryCount() {
        return this.requestRetryCount;
    }

    public String getRequestType() {
        return "";
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public Object getRetryInfo() {
        return new RetryInfo(canRequestRetry() ? (short) 1 : (short) 0, (short) getRequestRetryCount(), getRequestPkgId());
    }

    public boolean isWriteOperation() {
        return false;
    }

    protected boolean needAppendGdtInfo() {
        return true;
    }

    protected boolean needClientRetry() {
        return false;
    }

    public boolean needReport() {
        return true;
    }

    @Override // com.qzone.common.protocol.INetworkCallback
    public void onDataResponse(FromServiceMsg fromServiceMsg) {
        String[] split;
        this.endTime = System.currentTimeMillis();
        if (fromServiceMsg != null) {
            Object attribute = fromServiceMsg.getAttribute(BaseConstants.Attribute_TAG_SOCKET_ADDRESS);
            boolean z16 = false;
            if (attribute != null && (split = attribute.toString().split(":")) != null && split.length > 1) {
                this.params.put(ParamConstants.KEY_REQUEST_SERVER_IP, split[0]);
                this.params.put(ParamConstants.KEY_REQUEST_SERVER_PORT, split[1]);
            }
            if (fromServiceMsg.getResultCode() == 1000) {
                byte[] wupBuffer = fromServiceMsg.getWupBuffer();
                if (wupBuffer != null) {
                    this.respSize = wupBuffer.length;
                }
                if (QZLog.isColorLevel()) {
                    QZLog.d("QzoneRequestCost", 2, "old cost=" + (this.endTime - this.startTime));
                }
                if (QZLog.isDevelopLevel()) {
                    QZLog.d("ProtocolFlowTest", 4, "cmd=" + getRequestCmd() + ",response size=" + this.respSize + ",request size=" + this.reqSize);
                }
                decodeAndCallback(wupBuffer != null ? fh.a(wupBuffer) : null, fromServiceMsg);
                return;
            }
            Bundle bundle = fromServiceMsg.extraData;
            String businessFailMsg = fromServiceMsg.getBusinessFailMsg();
            QZLog.e(QZLog.TO_DEVICE_TAG, "errMsg:" + businessFailMsg);
            addParameter(ParamConstants.KEY_REPORT_DETAIL_MSG, "errMsg:" + businessFailMsg);
            if (!this.isRetry && needClientRetry() && bundle != null) {
                if (getTimestamp(bundle, TIMESTAMP_MSF2NET_M) > 0 && (fromServiceMsg.getResultCode() == 1002 || fromServiceMsg.getResultCode() == 1013)) {
                    z16 = true;
                }
                this.isRetry = z16;
                QZLog.i(QZLog.TO_DEVICE_TAG, 1, "cmd=" + uniKey() + ", appSeq:" + fromServiceMsg.getAppSeq() + ", resultcode:" + fromServiceMsg.getResultCode() + " need retry send request");
            }
            doCallback(null, fromServiceMsg.getResultCode() + 300000, fromServiceMsg.getResultCode() + 300000, null, z16);
            return;
        }
        QZLog.e(QZLog.TO_DEVICE_TAG, uniKey() + " MSF response is null");
        doCallback(null, 1000000, 1000000, "");
    }

    public void setCmdString(String str) {
        this.mCmd = str;
    }

    public void setCommandPrefix(String str) {
        this.mCommandPrefix = str;
    }

    public void setListner(IQZoneProtocolListener iQZoneProtocolListener) {
        this.mListner = iQZoneProtocolListener;
    }

    public void setRequestRetryCount(int i3) {
        this.requestRetryCount = i3;
    }

    public void setUploadQueueListener(c cVar) {
        this.mUploadQueueListener = cVar;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public abstract String uniKey();

    protected void doCallback(UniAttribute uniAttribute, int i3, int i16, String str, boolean z16) {
        IQZoneProtocolListener iQZoneProtocolListener = this.mListner;
        if (iQZoneProtocolListener != null) {
            iQZoneProtocolListener.onProtocolResponse(uniAttribute, i3, i3, str, z16);
        }
    }

    public QZoneRequest(String str) {
        this(str, false);
        this.TAG = getClass().getSimpleName();
    }

    public QZoneRequest(String str, boolean z16) {
        this.TAG = "";
        this.mCommandPrefix = DEFAULT_COMMAND_PREFIX;
        this.params = new HashMap<>();
        this.isRetry = false;
        this.mCmd = str;
        this.canRequestRetry = z16;
        this.pkgId = System.currentTimeMillis();
        this.TAG = getClass().getSimpleName();
    }

    private long getTimestamp(Bundle bundle, String str) {
        if (bundle == null || str == null || !bundle.containsKey(str)) {
            return 0L;
        }
        return bundle.getLong(str);
    }
}
