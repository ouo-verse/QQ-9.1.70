package com.tencent.biz.pubaccount.weishi.net;

import NS_KING_INTERFACE.stDelCommentReplyRsp;
import NS_KING_INTERFACE.stDeleteFeedCommentRsp;
import NS_KING_INTERFACE.stGetCommentReplyListRsp;
import NS_KING_INTERFACE.stPostCommentDingRsp;
import NS_KING_INTERFACE.stPostFeedDingRsp;
import NS_KING_PUBLIC.stReqHeader;
import NS_KING_PUBLIC.stRspHeader;
import QMF_PROTOCAL.QmfBusiControl;
import QMF_PROTOCAL.QmfDownstream;
import QMF_PROTOCAL.QmfServerInfo;
import QMF_PROTOCAL.RetryInfo;
import UserGrowth.cnst.sMapExtKeyABTest;
import UserGrowth.stBlockRecommPersonRsp;
import UserGrowth.stCompressedData;
import UserGrowth.stFollowFeedsRsp;
import UserGrowth.stFollowRsp;
import UserGrowth.stFriendFeedRsp;
import UserGrowth.stGetAIOFeedDetailRsp;
import UserGrowth.stGetAllABTestPolicyRsp;
import UserGrowth.stGetCollectionRsp;
import UserGrowth.stGetFeedIconOpRsp;
import UserGrowth.stGetPersonalFeedListRsp;
import UserGrowth.stGetTabsRsp;
import UserGrowth.stNotificationRsp;
import UserGrowth.stPostCommentReplyV2Rsp;
import UserGrowth.stPostFeedCommentV2Rsp;
import UserGrowth.stPublisherRsp;
import UserGrowth.stQQGetFeedCommentListV2Rsp;
import UserGrowth.stQQGroupDetailRsp;
import UserGrowth.stRedDotRsp;
import UserGrowth.stReportItem;
import UserGrowth.stSimpleGetFeedDetailRsp;
import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stUserConfigRsp;
import UserGrowth.stWeishiDengtaReportRsp;
import UserGrowth.stWeishiReportReq;
import UserGrowth.stWeishiReportRsp;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.jce.wup.UniAttribute;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceStruct;
import com.qzone.app.ParamConstants;
import com.tencent.biz.pubaccount.weishi.s;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.p;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QzoneExternalRequest;
import cooperation.qzone.WNSStream;
import cooperation.qzone.statistic.serverip.WebAppIpManager;
import cooperation.qzone.util.JceUtils;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.WnsError;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
@Deprecated
/* loaded from: classes32.dex */
public class j<T1> extends QzoneExternalRequest implements a {
    public static String X = "QzoneNewService.";
    public static Map<Integer, Map<String, String>> Y = new HashMap();
    public String C;
    protected boolean D;
    protected volatile boolean E;
    public long F;
    public long G;
    public long H;
    public long I;
    public long J;
    private int K;
    private boolean L;
    private long M;
    protected transient b N;
    private String P;
    public f Q;
    private boolean R;
    protected int S;
    protected long T;
    private boolean U;
    private boolean V;
    public int W;

    /* renamed from: d, reason: collision with root package name */
    private String f80979d;

    /* renamed from: e, reason: collision with root package name */
    private String f80980e;

    /* renamed from: f, reason: collision with root package name */
    protected HashMap<Object, Object> f80981f;

    /* renamed from: h, reason: collision with root package name */
    private final com.tencent.biz.pubaccount.weishi.net.common.c f80982h;

    /* renamed from: i, reason: collision with root package name */
    private String f80983i;

    /* renamed from: m, reason: collision with root package name */
    public JceStruct f80984m;

    public j(String str) {
        this("WeishiGZH.", str, false);
        this.P = str;
    }

    private Object b(QmfDownstream qmfDownstream, Class cls) {
        if (cls == stSimpleGetFeedListRsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stSimpleGetFeedListRsp());
        }
        if (cls == stNotificationRsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stNotificationRsp());
        }
        if (cls == stQQGetFeedCommentListV2Rsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stQQGetFeedCommentListV2Rsp());
        }
        if (cls == stPostFeedCommentV2Rsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stPostFeedCommentV2Rsp());
        }
        if (cls == stPostCommentReplyV2Rsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stPostCommentReplyV2Rsp());
        }
        if (cls == stGetCommentReplyListRsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stGetCommentReplyListRsp());
        }
        if (cls == stDelCommentReplyRsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stDelCommentReplyRsp());
        }
        if (cls == stPostCommentDingRsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stPostCommentDingRsp());
        }
        if (cls == stDeleteFeedCommentRsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stDeleteFeedCommentRsp());
        }
        if (cls == stPostFeedDingRsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stPostFeedDingRsp());
        }
        if (cls == stWeishiReportRsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stWeishiReportRsp());
        }
        if (cls == stFollowFeedsRsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stFollowFeedsRsp());
        }
        if (cls == stRedDotRsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stRedDotRsp());
        }
        if (cls == stSimpleGetFeedDetailRsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stSimpleGetFeedDetailRsp());
        }
        if (cls == stBlockRecommPersonRsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stBlockRecommPersonRsp());
        }
        if (cls == stFollowRsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stFollowRsp());
        }
        if (cls == stPublisherRsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stPublisherRsp());
        }
        if (cls == stWeishiDengtaReportRsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stWeishiDengtaReportRsp());
        }
        if (cls == stUserConfigRsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stUserConfigRsp());
        }
        if (cls == stGetCollectionRsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stGetCollectionRsp());
        }
        if (cls == stFriendFeedRsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stFriendFeedRsp());
        }
        if (cls == stGetPersonalFeedListRsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stGetPersonalFeedListRsp());
        }
        if (cls == stQQGroupDetailRsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stQQGroupDetailRsp());
        }
        if (cls == stGetAIOFeedDetailRsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stGetAIOFeedDetailRsp());
        }
        if (cls == stGetAllABTestPolicyRsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stGetAllABTestPolicyRsp());
        }
        if (cls == stGetTabsRsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stGetTabsRsp());
        }
        if (cls == stGetFeedIconOpRsp.class) {
            return a(qmfDownstream.BusiBuff, o(), new stGetFeedIconOpRsp());
        }
        Log.e("weishi-Request", "response\u65e0\u6cd5\u5339\u914d");
        return null;
    }

    private d c(QmfDownstream qmfDownstream, int i3) {
        Map<String, String> map;
        stRspHeader strspheader = (stRspHeader) a(qmfDownstream.BusiBuff, "stRspHeader", new stRspHeader());
        d dVar = new d();
        if (strspheader != null && (map = strspheader.mapExt) != null) {
            dVar.f80962a = map;
            Y.put(Integer.valueOf(i3), map);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                Log.i("weishi-Request", o() + " \u5b58\u8fdb\u53bb \u300b\u300b\u300b key: " + entry.getKey() + ", value: " + entry.getValue());
            }
            String str = strspheader.mapExt.get(sMapExtKeyABTest.value);
            Log.i("weishi-Request", "stRspHeader: {iRet=" + strspheader.iRet + ", sErrMsg=" + strspheader.sErrmsg + ", scene=" + i3 + ", abTestId=" + str + "}");
            if ("SimpleGetFeedList".equals(m())) {
                LocalMultiProcConfig.putString4Uin("key_default_test_id", str, bb.o());
            }
            dVar.f80963b = str;
            com.tencent.biz.pubaccount.weishi.report.f.a(i3, str);
            String str2 = strspheader.mapExt.get("person_id");
            Log.d("weishi-Request", "stRspHeader: {personId=" + str2 + "}");
            if (!TextUtils.isEmpty(str2)) {
                bb.U(str2);
            }
            if (strspheader.iRet == -99 && t()) {
                s.h().o(2);
            }
        }
        return dVar;
    }

    private <T extends JceStruct> byte[] d(byte[] bArr) {
        long currentTimeMillis = System.currentTimeMillis();
        u(true);
        stCompressedData stcompresseddata = (stCompressedData) a(bArr, "stCompressedData", new stCompressedData());
        byte[] bArr2 = null;
        if (stcompresseddata == null) {
            x.j("weishi-Request", "[WSResponseDecoder.java][checkRspCompress] rsp is compress, but decodeJce failure");
            return null;
        }
        try {
            byte[] bArr3 = stcompresseddata.compressed;
            int length = bArr3.length;
            byte[] d16 = zb2.a.d(bArr3);
            int length2 = d16.length;
            bArr2 = Arrays.copyOfRange(d16, 1, length2);
            com.tencent.biz.pubaccount.weishi.net.common.c i3 = i();
            i3.d(length);
            i3.e(length2);
            i3.f(length / length2);
        } catch (Exception e16) {
            x.f("weishi-Request", "[WSResponseDecoder.java][checkRspCompress] exception:" + e16.getLocalizedMessage());
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[WSResponseDecoder.java][checkRspCompress] decompress and decodeJce success. dataSize:");
        sb5.append(bArr2 != null ? bArr2.length : 0);
        sb5.append(", cost:");
        sb5.append(System.currentTimeMillis() - currentTimeMillis);
        x.j("weishi-Request", sb5.toString());
        return bArr2;
    }

    private Map<String, String> h() {
        JceStruct jceStruct = this.f80984m;
        if (jceStruct instanceof stWeishiReportReq) {
            ArrayList<stReportItem> arrayList = ((stWeishiReportReq) jceStruct).report_list;
            if (arrayList.size() > 0) {
                stReportItem streportitem = arrayList.get(0);
                Log.i("weishi-Request", "\u4e0a\u62a5\u53d6 pageType: " + streportitem.pagetype);
                Map<String, String> map = Y.get(Integer.valueOf(streportitem.pagetype));
                if (map != null && map.size() > 0) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        Log.i("weishi-Request", "\u53d6\u51fa\u6765" + uniKey() + " --- key: " + entry.getKey() + ", value: " + entry.getValue());
                        if (sMapExtKeyABTest.value.equals(entry.getKey()) && streportitem.optype == 121) {
                            entry.setValue("");
                            Log.w("weishi-Request", "\u521d\u59cb\u5316\u4e0a\u62a5\uff0cqq_abtest");
                            Log.w("weishi-Request", "\u6e05\u7a7a\u540eqq_abtest\u7684\u503c\u662f" + entry.getValue());
                        }
                    }
                    return map;
                }
                Log.i("weishi-Request", "\u6ca1\u6709pageType\u4e3a" + streportitem.pagetype + "\u7684extMap");
                return new HashMap();
            }
        }
        return new HashMap();
    }

    private stReqHeader k() {
        stReqHeader streqheader = new stReqHeader();
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        streqheader.authInfo = s.h().i(account, "", t());
        streqheader.iChid = 0;
        streqheader.person_id = h.f80972a;
        streqheader.platform = "Android";
        streqheader.appversion = p.n(BaseApplication.getContext());
        streqheader.user_ip = p.d();
        streqheader.strQua = QUA.getQUA3();
        streqheader.device_info = p.e();
        x.b("weishi-810", "device_info:" + streqheader.device_info);
        streqheader.h265key = l();
        streqheader.appid = 1101083114;
        if ("stWeishiReportReq".equals(uniKey())) {
            streqheader.mapExt = h();
        } else {
            streqheader.mapExt = new HashMap();
        }
        Map<String, String> map = streqheader.mapExt;
        if (map != null) {
            map.put("iAuthType", "2");
            Map<String, String> map2 = streqheader.mapExt;
            if (account == null) {
                account = "";
            }
            map2.put("sUid", account);
            streqheader.mapExt.put("sSessionKey", "");
            String f16 = com.tencent.biz.pubaccount.weishi.report.a.f(BaseApplication.getContext());
            if (TextUtils.isEmpty(f16)) {
                f16 = "000000000000000";
            }
            streqheader.mapExt.put("imei", f16);
            String j3 = p.j();
            Map<String, String> map3 = streqheader.mapExt;
            if (j3 == null) {
                j3 = "";
            }
            map3.put(TVKLiveRequestBuilder.RequestParamKey.QIMEI36, j3);
            String k3 = p.k();
            streqheader.mapExt.put("qimei36", k3 != null ? k3 : "");
            streqheader.mapExt.put(TPDownloadProxyEnum.USER_SSID, p.r());
            streqheader.mapExt.put("ssid_ip", p.q());
            streqheader.mapExt.put("ab_policy_info", j());
            streqheader.mapExt.put("teen_mode", String.valueOf(com.tencent.biz.pubaccount.weishi.net.common.f.b()));
            streqheader.mapExt.put(QCircleDaTongConstant.ElementParamKey.XSJ_QQ_MODE, String.valueOf(com.tencent.biz.pubaccount.weishi.net.common.f.a()));
            x.j("weishi-Request", "[WeishiRequest.java][getHeader] mCmd:" + this.f80983i + ", mReqScene:" + this.S + ", header:" + streqheader.mapExt.toString());
        } else {
            x.i("weishi-Request", "header mapExt is null.");
        }
        streqheader.iAppVersion = p.a();
        return streqheader;
    }

    public static String l() {
        return (((((("" + DeviceInfoMonitor.getModel()) + ContainerUtils.FIELD_DELIMITER) + Build.VERSION.RELEASE) + ContainerUtils.FIELD_DELIMITER) + Build.VERSION.SDK_INT) + ContainerUtils.FIELD_DELIMITER) + p.h();
    }

    public final <T1> T1 a(byte[] bArr, String str, T1 t16) {
        UniPacket uniPacket = new UniPacket(true);
        try {
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(bArr);
            return (T1) uniPacket.getByClass(str, t16);
        } catch (Exception e16) {
            Log.e("weishi-Request", e16.getLocalizedMessage());
            return null;
        }
    }

    public void addParameter(Object obj, Object obj2) {
        this.f80981f.put(obj, obj2);
    }

    public boolean canRequestRetry() {
        return this.L;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public byte[] encode() {
        WNSStream wNSStream = new WNSStream(1000027, QUA.getQUA3(), getLoginUserId(), new byte[0], getDeviceInfo(), (RetryInfo) getRetryInfo());
        byte[] encodedUniParameter = getEncodedUniParameter();
        if (encodedUniParameter != null) {
            return fh.b(wNSStream.pack(MsfSdkUtils.getNextAppSeq(), getCmdString(), encodedUniParameter, this.D));
        }
        return null;
    }

    protected void f(Object obj, int i3, int i16, String str, boolean z16) {
        Log.i("weishi-request", "doSuccessCallback!!");
        b bVar = this.N;
        if (bVar != null) {
            bVar.a(obj, i3, i16, str, z16, null);
        }
    }

    protected void g(Object obj, int i3, int i16, String str, boolean z16, d dVar) {
        Log.i("weishi-request", "doSuccessCallback!!");
        b bVar = this.N;
        if (bVar != null) {
            bVar.a(obj, i3, i16, str, z16, dVar);
        }
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return this.f80980e + this.f80983i;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    protected byte[] getEncodedUniParameter() {
        stReqHeader k3 = k();
        try {
            if (k3 != null) {
                Log.d("weishi-Request", "encode, reqHeader = " + k3.toString());
            } else {
                Log.d("weishi-Request", "encode, reqHeader = null");
            }
        } catch (Exception e16) {
            Log.e("weishi-Request", "encode get header error, e = " + e16.toString());
        }
        f fVar = new f();
        this.Q = fVar;
        fVar.setRequestId(this.W);
        this.W++;
        this.Q.setServantName("king");
        this.Q.setFuncName(m());
        this.Q.setEncodeName("UTF-8");
        this.Q.put("stReqHeader", k3);
        this.Q.a(9999);
        if (this.f80984m != null && !TextUtils.isEmpty(getRequestCmd())) {
            this.Q.put("st" + m() + "Req", this.f80984m);
            Log.i("weishi-Request", "req\u540d :st" + m() + "Req");
        }
        return this.Q.encode();
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        return this.f80984m;
    }

    public String getRequestCmd() {
        return this.f80983i;
    }

    public long getRequestPkgId() {
        return this.M;
    }

    public int getRequestRetryCount() {
        return this.K;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public Object getRetryInfo() {
        return new RetryInfo(canRequestRetry() ? (short) 1 : (short) 0, (short) getRequestRetryCount(), getRequestPkgId());
    }

    public com.tencent.biz.pubaccount.weishi.net.common.c i() {
        return this.f80982h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String j() {
        String f16;
        return (!q() || (f16 = com.tencent.biz.pubaccount.weishi.config.experiment.b.h().f()) == null) ? "" : f16;
    }

    public String m() {
        return this.f80979d;
    }

    public int n() {
        return this.S;
    }

    protected boolean needClientRetry() {
        return false;
    }

    public String o() {
        return "st" + this.P + "Rsp";
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.a
    public void onDataResponse(FromServiceMsg fromServiceMsg) {
        String[] split;
        this.G = System.currentTimeMillis();
        if (fromServiceMsg != null) {
            Object attribute = fromServiceMsg.getAttribute(BaseConstants.Attribute_TAG_SOCKET_ADDRESS);
            boolean z16 = false;
            if (attribute != null && (split = attribute.toString().split(":")) != null && split.length > 1) {
                this.f80981f.put(ParamConstants.KEY_REQUEST_SERVER_IP, split[0]);
                this.f80981f.put(ParamConstants.KEY_REQUEST_SERVER_PORT, split[1]);
            }
            if (fromServiceMsg.getResultCode() == 1000) {
                byte[] wupBuffer = fromServiceMsg.getWupBuffer();
                if (wupBuffer != null) {
                    this.I = wupBuffer.length;
                }
                this.H = this.G - this.F;
                Log.w("weishi-Server", "old cost=" + this.H);
                Log.i("weishi-Server", "cmd=" + getRequestCmd() + ",response size=" + this.I + ",request size=" + this.J);
                decodeAndCallback(wupBuffer != null ? fh.a(wupBuffer) : null, fromServiceMsg);
                return;
            }
            Bundle bundle = fromServiceMsg.extraData;
            String businessFailMsg = fromServiceMsg.getBusinessFailMsg();
            Log.e("weishi-Request", "errMsg:" + businessFailMsg);
            addParameter(ParamConstants.KEY_REPORT_DETAIL_MSG, "errMsg:" + businessFailMsg);
            if (!this.E && needClientRetry() && bundle != null) {
                if (getTimestamp(bundle, "timestamp_msf2net_atMsfSite") > 0 && (fromServiceMsg.getResultCode() == 1002 || fromServiceMsg.getResultCode() == 1013)) {
                    z16 = true;
                }
                this.E = z16;
                Log.i("weishi-Request", "cmd=" + uniKey() + ", appSeq:" + fromServiceMsg.getAppSeq() + ", resultcode:" + fromServiceMsg.getResultCode() + " need retry send request");
            }
            e(null, fromServiceMsg.getResultCode() + 300000, fromServiceMsg.getResultCode() + 300000, null);
            return;
        }
        Log.e("weishi-Request", uniKey() + " MSF response is null");
        e(null, 1000000, 1000000, "");
    }

    public boolean p() {
        return this.U;
    }

    public boolean q() {
        return true;
    }

    public boolean r() {
        return this.V;
    }

    public void setRequestRetryCount(int i3) {
        this.K = i3;
    }

    public boolean t() {
        return true;
    }

    public void u(boolean z16) {
        this.U = z16;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "st" + this.P + "Req";
    }

    public void v(b bVar) {
        this.N = bVar;
    }

    private static boolean s(d dVar) {
        Map<String, String> map;
        if (dVar != null && (map = dVar.f80962a) != null) {
            if (map.containsKey("qq_compressed")) {
                return true;
            }
            x.j("weishi-Request", "[WSResponseDecoder.java][checkRspCompress] rsp is not compress");
            return false;
        }
        x.j("weishi-Request", "[WSResponseDecoder.java][checkRspCompress] rspHeader or mapExt is null");
        return false;
    }

    public void decodeAndCallback(byte[] bArr, FromServiceMsg fromServiceMsg) {
        Object b16;
        if (bArr == null) {
            QZLog.e(QZLog.TO_DEVICE_TAG, "cmd=" + uniKey() + " QZoneRequest decodeAndCallback() data is null");
            e(null, 1000003, 1000003, "");
            return;
        }
        try {
            QmfDownstream unpack = new WNSStream().unpack(bArr);
            e eVar = new e();
            if (unpack == null || unpack.WnsCode != 0) {
                if (unpack != null) {
                    QZLog.e(QZLog.TO_DEVICE_TAG, "cmd=" + uniKey() + " WeishiRequest decodeAndCallback wnscode=" + ((int) unpack.WnsCode) + ",msg=" + WnsError.getErrorMessage(unpack.WnsCode));
                    short s16 = unpack.WnsCode;
                    e(eVar, s16, s16, WnsError.getErrorMessage(s16));
                    return;
                }
                QZLog.e(QZLog.TO_DEVICE_TAG, "cmd=" + uniKey() + " WeishiRequest unpack error,result is null");
                e(eVar, 1000003, 1000003, "");
                return;
            }
            eVar.setEncodeName("utf-8");
            eVar.decode(unpack.Extra);
            QmfServerInfo qmfServerInfo = (QmfServerInfo) eVar.get("server_info");
            if (WebAppIpManager.isValidServerInfo(qmfServerInfo)) {
                WebAppIpManager.getInstance().addWebAppIpRecord(qmfServerInfo);
                this.f80981f.put(ParamConstants.KEY_REPORT_BUSI_SERVERIP, NetworkState.IntAddr2Ip(qmfServerInfo.ipWebapp.ClientIpv4));
            }
            QmfBusiControl qmfBusiControl = (QmfBusiControl) eVar.get("busiCompCtl");
            if (qmfBusiControl != null && 1 == qmfBusiControl.compFlag) {
                byte[] decompress = WNSStream.decompress(unpack.BusiBuff);
                if (decompress != null) {
                    unpack.BusiBuff = decompress;
                } else {
                    QZLog.e(QZLog.TO_DEVICE_TAG, "cmd=" + uniKey() + " WeishiRequest decompress error");
                    e(eVar, 1000002, 1000002, "");
                    return;
                }
            }
            ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
            if (parameterizedType != null) {
                d c16 = c(unpack, this.S);
                Class cls = (Class) parameterizedType.getActualTypeArguments()[0];
                if (s(c16)) {
                    byte[] d16 = d(unpack.BusiBuff);
                    if (d16 != null) {
                        b16 = JceUtils.decodeWup((Class<Object>) cls, d16);
                    } else {
                        e(eVar, 2000003, 2000003, "rsp gzip decompress error");
                        return;
                    }
                } else {
                    b16 = b(unpack, cls);
                }
                Object obj = b16;
                if (obj == null) {
                    Log.w("weishi-Request", "\u5fae\u89c6\u516c\u4f17\u53f7 \u89e3\u5305\u5931\u8d25!!");
                }
                Log.i("weishi-Request", "pageType scene\uff1a" + this.S);
                g(obj, fromServiceMsg.getResultCode(), fromServiceMsg.getResultCode(), fromServiceMsg.getBusinessFailMsg(), this.R, c16);
                return;
            }
            Log.w("weishi-Request", "\u6cdb\u578b\u5339\u914d\u9519\u8bef");
            short s17 = unpack.WnsCode;
            e(eVar, s17, s17, WnsError.getErrorMessage(s17));
        } catch (Throwable th5) {
            th5.printStackTrace();
            String stackTraceString = QZLog.getStackTraceString(th5);
            if (stackTraceString != null) {
                addParameter(ParamConstants.KEY_REPORT_DETAIL_MSG, stackTraceString);
            }
            QZLog.e(QZLog.TO_DEVICE_TAG, "cmd=" + uniKey() + " WeishiRequest decodeAndCallback occur exception. stack info:" + stackTraceString);
            e(null, 1000001, 1000001, "");
        }
    }

    public j(String str, int i3) {
        this("WeishiGZH.", str, false);
        this.P = str;
        this.S = i3;
    }

    public j(String str, String str2, boolean z16) {
        this.f80980e = X;
        this.f80981f = new HashMap<>();
        this.D = false;
        this.E = false;
        this.R = false;
        this.T = 30000L;
        this.W = 100000;
        this.f80979d = str2;
        this.f80983i = str + str2;
        this.L = z16;
        this.M = System.currentTimeMillis();
        this.f80982h = new com.tencent.biz.pubaccount.weishi.net.common.c();
        setLoginUserId(bb.o());
    }

    protected void e(UniAttribute uniAttribute, int i3, int i16, String str) {
        f(uniAttribute, i3, i16, str, true);
    }

    private long getTimestamp(Bundle bundle, String str) {
        if (bundle == null || str == null || !bundle.containsKey(str)) {
            return 0L;
        }
        return bundle.getLong(str);
    }
}
