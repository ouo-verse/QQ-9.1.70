package com.tencent.biz.pubaccount.weishi.net.common;

import NS_KING_PUBLIC.stRspHeader;
import QMF_PROTOCAL.QmfBusiControl;
import QMF_PROTOCAL.QmfDownstream;
import QMF_PROTOCAL.QmfServerInfo;
import UserGrowth.cnst.sMapExtKeyABTest;
import UserGrowth.stCompressedData;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceStruct;
import com.qzone.app.ParamConstants;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.WNSStream;
import cooperation.qzone.statistic.serverip.WebAppIpManager;
import cooperation.qzone.util.JceUtils;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.WnsError;
import java.util.Arrays;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class i<T extends JceStruct> {

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a<T> {
        void a(UniAttribute uniAttribute, int i3, String str);

        void b(T t16, int i3, String str, com.tencent.biz.pubaccount.weishi.net.d dVar);
    }

    private <P> P b(byte[] bArr, String str, P p16) {
        UniPacket uniPacket = new UniPacket(true);
        try {
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(bArr);
            return (P) uniPacket.getByClass(str, p16);
        } catch (Exception e16) {
            x.f("[WSService]", e16.getLocalizedMessage());
            return null;
        }
    }

    private com.tencent.biz.pubaccount.weishi.net.d c(g<T> gVar, stRspHeader strspheader) {
        Map<String, String> map;
        com.tencent.biz.pubaccount.weishi.net.d dVar = new com.tencent.biz.pubaccount.weishi.net.d();
        if (strspheader != null && (map = strspheader.mapExt) != null) {
            dVar.f80962a = map;
            int requestScene = gVar.getRequestScene();
            x.i("[WSService]", "[WSResponseDecoder.java][decodeAndCallback]pageType scene\uff1a" + requestScene);
            g.pageTypeExtMap.put(Integer.valueOf(requestScene), map);
            if (f.c()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    x.i("[WSService]", gVar.getRspUinKey() + " \u5b58\u8fdb\u53bb \u300b\u300b\u300b key:" + entry.getKey() + ", value:" + entry.getValue());
                }
            }
            String str = strspheader.mapExt.get(sMapExtKeyABTest.value);
            x.i("[WSService]", "[WSResponseDecoder.java][decodeAndCallback]stRspHeader: {iRet:" + strspheader.iRet + ", sErrMsg:" + strspheader.sErrmsg + ", scene:" + requestScene + ", abTestId:" + str + "}");
            if ("SimpleGetFeedList".equals(gVar.getOnlyCmd())) {
                LocalMultiProcConfig.putString4Uin("key_default_test_id", str, bb.o());
            }
            dVar.f80963b = str;
            com.tencent.biz.pubaccount.weishi.report.f.a(requestScene, str);
            String str2 = strspheader.mapExt.get("person_id");
            x.b("[WSService]", "[WSResponseDecoder.java][decodeAndCallback]stRspHeader: {personId:" + str2 + "}");
            if (!TextUtils.isEmpty(str2)) {
                bb.U(str2);
            }
        }
        gVar.getTimeRecord().n();
        return dVar;
    }

    private boolean d(QmfDownstream qmfDownstream, com.tencent.biz.pubaccount.weishi.net.e eVar) {
        eVar.setEncodeName("utf-8");
        eVar.decode(qmfDownstream.Extra);
        QmfBusiControl qmfBusiControl = (QmfBusiControl) eVar.get("busiCompCtl");
        if (qmfBusiControl != null && 1 == qmfBusiControl.compFlag) {
            byte[] decompress = WNSStream.decompress(qmfDownstream.BusiBuff);
            if (decompress == null) {
                return false;
            }
            qmfDownstream.BusiBuff = decompress;
        }
        return true;
    }

    private byte[] e(g<T> gVar, byte[] bArr) {
        long currentTimeMillis = System.currentTimeMillis();
        gVar.setGzipCompress(true);
        stCompressedData stcompresseddata = (stCompressedData) b(bArr, "stCompressedData", new stCompressedData());
        gVar.getTimeRecord().r();
        byte[] bArr2 = null;
        if (stcompresseddata == null) {
            x.j("[WSService]", "[WSResponseDecoder.java][checkRspCompress] rsp is compress, but decodeJce failure");
            return null;
        }
        try {
            byte[] bArr3 = stcompresseddata.compressed;
            int length = bArr3.length;
            byte[] d16 = com.tencent.biz.pubaccount.weishi.util.b.d(bArr3);
            int length2 = d16.length;
            bArr2 = Arrays.copyOfRange(d16, 1, length2);
            c compressInfo = gVar.getCompressInfo();
            compressInfo.d(length);
            compressInfo.e(length2);
            compressInfo.f(length / length2);
            gVar.getTimeRecord().q();
        } catch (Exception e16) {
            x.f("[WSService]", "[WSResponseDecoder.java][checkRspCompress] exception:" + e16.getLocalizedMessage());
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[WSResponseDecoder.java][checkRspCompress] decompress and decodeJce success. dataSize:");
        sb5.append(bArr2 != null ? bArr2.length : 0);
        sb5.append(", cost:");
        sb5.append(System.currentTimeMillis() - currentTimeMillis);
        x.j("[WSService]", sb5.toString());
        return bArr2;
    }

    private void j(g<T> gVar, com.tencent.biz.pubaccount.weishi.net.e eVar) {
        QmfServerInfo qmfServerInfo = (QmfServerInfo) eVar.get("server_info");
        if (WebAppIpManager.isValidServerInfo(qmfServerInfo)) {
            WebAppIpManager.getInstance().addWebAppIpRecord(qmfServerInfo);
            gVar.params.put(ParamConstants.KEY_REPORT_BUSI_SERVERIP, NetworkState.IntAddr2Ip(qmfServerInfo.ipWebapp.ClientIpv4));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(g<T> gVar, byte[] bArr, FromServiceMsg fromServiceMsg, a<T> aVar) {
        JceStruct jceStruct;
        String reqUniKey = gVar.getReqUniKey();
        if (f(bArr, aVar, reqUniKey)) {
            return;
        }
        try {
            QmfDownstream unpack = new WNSStream().unpack(bArr);
            gVar.getTimeRecord().p();
            com.tencent.biz.pubaccount.weishi.net.e eVar = new com.tencent.biz.pubaccount.weishi.net.e();
            if (h(aVar, reqUniKey, unpack, eVar)) {
                return;
            }
            j(gVar, eVar);
            if (!d(unpack, eVar)) {
                x.f("[WSService]", "[WSResponseDecoder.java][decodeAndCallback]cmd=" + reqUniKey + " WSRequest decompress error");
                aVar.a(eVar, 1000002, "decompress error");
                return;
            }
            gVar.getTimeRecord().m();
            stRspHeader strspheader = (stRspHeader) b(unpack.BusiBuff, "stRspHeader", new stRspHeader());
            if (g(aVar, eVar, strspheader)) {
                return;
            }
            com.tencent.biz.pubaccount.weishi.net.d c16 = c(gVar, strspheader);
            if (i(c16)) {
                byte[] e16 = e(gVar, unpack.BusiBuff);
                if (e16 == null) {
                    aVar.a(eVar, 2000003, "rsp gzip decompress error");
                    return;
                }
                jceStruct = JceUtils.decodeWup(gVar.getRspClass(), e16);
            } else {
                jceStruct = (JceStruct) b(unpack.BusiBuff, gVar.getRspUinKey(), gVar.getRspClass().newInstance());
            }
            gVar.getTimeRecord().o();
            int resultCode = fromServiceMsg.getResultCode();
            if (jceStruct == null) {
                x.f("[WSService]", "[WSResponseDecoder.java][decodeAndCallback] decode rsp failure!!");
                aVar.a(eVar, resultCode, "decode failure");
            } else {
                aVar.b(jceStruct, resultCode, fromServiceMsg.getBusinessFailMsg(), c16);
            }
        } catch (Throwable th5) {
            String g16 = x.g(th5);
            gVar.addParameter(ParamConstants.KEY_REPORT_DETAIL_MSG, g16);
            x.f("[WSService]", "[WSResponseDecoder.java][decodeAndCallback]cmd:" + reqUniKey + ", occur exception. stack info:" + g16);
            aVar.a(null, 1000001, "decodeAndCallback occur exception");
        }
    }

    private boolean h(a<T> aVar, String str, QmfDownstream qmfDownstream, com.tencent.biz.pubaccount.weishi.net.e eVar) {
        if (qmfDownstream == null) {
            x.f("[WSService]", "[WSResponseDecoder.java][decodeAndCallback]cmd=" + str + " WSRequest unpack error,result is null");
            aVar.a(eVar, 1000003, "unpack error");
            return true;
        }
        if (qmfDownstream.WnsCode == 0) {
            return false;
        }
        x.f("[WSService]", "[WSResponseDecoder.java][decodeAndCallback]cmd:" + str + ", wnsCode:" + ((int) qmfDownstream.WnsCode) + ", msg:" + WnsError.getErrorMessage(qmfDownstream.WnsCode));
        short s16 = qmfDownstream.WnsCode;
        aVar.a(eVar, s16, WnsError.getErrorMessage(s16));
        return true;
    }

    private boolean i(com.tencent.biz.pubaccount.weishi.net.d dVar) {
        Map<String, String> map;
        if (dVar != null && (map = dVar.f80962a) != null) {
            if (map.containsKey("qq_compressed")) {
                return true;
            }
            x.j("[WSService]", "[WSResponseDecoder.java][checkRspCompress] rsp is not compress");
            return false;
        }
        x.j("[WSService]", "[WSResponseDecoder.java][checkRspCompress] rspHeader or mapExt is null");
        return false;
    }

    private boolean f(byte[] bArr, a<T> aVar, String str) {
        if (bArr != null) {
            return false;
        }
        x.f("[WSService]", "[WSResponseDecoder.java][decodeAndCallback]cmd:" + str + ", decodeAndCallback() data is null");
        aVar.a(null, 1000003, "data is null");
        return true;
    }

    private boolean g(a<T> aVar, com.tencent.biz.pubaccount.weishi.net.e eVar, stRspHeader strspheader) {
        int i3;
        if (strspheader == null || (i3 = strspheader.iRet) == 0) {
            return false;
        }
        aVar.a(eVar, i3, strspheader.sErrmsg);
        return true;
    }
}
