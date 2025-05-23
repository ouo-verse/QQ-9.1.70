package com.tencent.mqpsdk.secsrv;

import android.text.TextUtils;
import com.tencent.ims.intchk$AppInfo;
import com.tencent.ims.intchk$CheckItem;
import com.tencent.ims.intchk$CheckResult;
import com.tencent.ims.intchk$FetchCheckConfigReq;
import com.tencent.ims.intchk$FetchCheckConfigRsp;
import com.tencent.ims.intchk$ReportCheckResultReq;
import com.tencent.ims.intchk$ReportCheckResultRsp;
import com.tencent.ims.intchk$ReportStrikeResultReq;
import com.tencent.ims.intchk$ReqBody;
import com.tencent.ims.intchk$RspBody;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mqp.app.sec.MQPSecUtil;
import com.tencent.mqpsdk.a;
import com.tencent.thumbplayer.report.reportv1.TPReportParams;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b implements com.tencent.mqpsdk.secsrv.a, a.b {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private static int f336139g;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mqpsdk.b f336140a;

    /* renamed from: b, reason: collision with root package name */
    private String f336141b;

    /* renamed from: c, reason: collision with root package name */
    private Map<Integer, a> f336142c;

    /* renamed from: d, reason: collision with root package name */
    private int f336143d;

    /* renamed from: e, reason: collision with root package name */
    private int f336144e;

    /* renamed from: f, reason: collision with root package name */
    private int f336145f;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface a {
        void exec(String str, com.tencent.mqpsdk.secsrv.a aVar);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77447);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f336139g = 1;
        }
    }

    public b(com.tencent.mqpsdk.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            return;
        }
        this.f336140a = null;
        this.f336141b = null;
        this.f336142c = null;
        this.f336143d = 0;
        this.f336144e = 65535;
        this.f336145f = 0;
        com.tencent.mqpsdk.a aVar = bVar.f336137b;
        if (aVar != null) {
            aVar.setNetTransportEventListener("intchk", this);
        }
        this.f336140a = bVar;
    }

    private intchk$AppInfo d() {
        String str;
        intchk$AppInfo intchk_appinfo = new intchk$AppInfo();
        intchk_appinfo.uint32_platform_type.set(1);
        intchk_appinfo.bytes_package_name.set(ByteStringMicro.copyFromUtf8(this.f336140a.f336136a.getPackageName()));
        if (TextUtils.isEmpty(this.f336141b)) {
            str = "1.0";
        } else {
            str = this.f336141b;
        }
        intchk_appinfo.bytes_app_version.set(ByteStringMicro.copyFromUtf8(str));
        intchk_appinfo.uint32_intchk_module_version.set(f336139g);
        int b16 = com.tencent.mqpsdk.util.a.b(this.f336140a.f336136a);
        int i3 = 4;
        int i16 = 3;
        if (b16 != 1) {
            if (b16 != 2) {
                if (b16 != 3) {
                    if (b16 == 4) {
                        i16 = 7;
                    }
                } else {
                    i16 = 6;
                }
            }
            i16 = 5;
        }
        String a16 = com.tencent.mqpsdk.util.a.a(this.f336140a.f336136a);
        if (a16 == null || !a16.contains("wap")) {
            i3 = i16;
        }
        intchk_appinfo.uint32_net_type.set(i3);
        return intchk_appinfo;
    }

    private void e(intchk$RspBody intchk_rspbody) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        if (intchk_rspbody.uint32_result.has()) {
            i3 = intchk_rspbody.uint32_result.get();
        } else {
            i3 = 2;
        }
        if (i3 != 1 || !intchk_rspbody.msg_check_config_rsp.has()) {
            return;
        }
        intchk$FetchCheckConfigRsp intchk_fetchcheckconfigrsp = intchk_rspbody.msg_check_config_rsp.get();
        if (intchk_fetchcheckconfigrsp.uint32_need_intchk.has()) {
            i16 = intchk_fetchcheckconfigrsp.uint32_need_intchk.get();
        } else {
            i16 = 2;
        }
        if (i16 != 1 || !intchk_fetchcheckconfigrsp.rpt_msg_check_item.has()) {
            return;
        }
        if (intchk_fetchcheckconfigrsp.uint32_intchk_id.has()) {
            i17 = intchk_fetchcheckconfigrsp.uint32_intchk_id.get();
        } else {
            i17 = 0;
        }
        intchk$ReportCheckResultReq intchk_reportcheckresultreq = new intchk$ReportCheckResultReq();
        intchk_reportcheckresultreq.uint32_intchk_id.set(i17);
        List<intchk$CheckItem> list = intchk_fetchcheckconfigrsp.rpt_msg_check_item.get();
        for (int i27 = 0; i27 < list.size(); i27++) {
            intchk$CheckItem intchk_checkitem = list.get(i27);
            if (intchk_checkitem.uint32_check_item_id.has()) {
                i18 = intchk_checkitem.uint32_check_item_id.get();
            } else {
                i18 = 0;
            }
            if (intchk_checkitem.uint32_check_type.has()) {
                i19 = intchk_checkitem.uint32_check_type.get();
            } else {
                i19 = 1;
            }
            intchk$CheckResult intchk_checkresult = new intchk$CheckResult();
            intchk_checkresult.uint32_check_item_id.set(i18);
            intchk_checkresult.uint32_check_type.set(i19);
            if (i19 != 1) {
                if (i19 == 2) {
                    String bytes2HexStr = HexUtil.bytes2HexStr(g(intchk_checkitem));
                    if (bytes2HexStr == null) {
                        bytes2HexStr = "";
                    }
                    intchk_checkresult.bytes_memreport_result.set(ByteStringMicro.copyFromUtf8(bytes2HexStr));
                }
            } else {
                if (f(intchk_checkitem)) {
                    i26 = 1;
                } else {
                    i26 = 2;
                }
                intchk_checkresult.uint32_memchk_result.set(i26);
            }
            intchk_reportcheckresultreq.rpt_msg_check_result.add(intchk_checkresult);
        }
        intchk$ReqBody intchk_reqbody = new intchk$ReqBody();
        intchk_reqbody.uint32_subcmd.set(2);
        intchk_reqbody.msg_app_info.set(d());
        intchk_reqbody.msg_report_check_result_req.set(intchk_reportcheckresultreq);
        com.tencent.mqpsdk.a aVar = this.f336140a.f336137b;
        if (aVar == null) {
            return;
        }
        Object byteArray = intchk_reqbody.toByteArray();
        a.InterfaceC9207a codec = aVar.getCodec("intchk");
        if (codec != null) {
            byteArray = codec.encode(byteArray);
        }
        aVar.send(byteArray);
    }

    private boolean f(intchk$CheckItem intchk_checkitem) {
        int i3;
        int i16;
        String str;
        if (intchk_checkitem.uint32_start_offset.has()) {
            i3 = intchk_checkitem.uint32_start_offset.get();
        } else {
            i3 = 0;
        }
        if (intchk_checkitem.uint32_end_offset.has()) {
            i16 = intchk_checkitem.uint32_end_offset.get();
        } else {
            i16 = 0;
        }
        if (i16 <= i3) {
            return false;
        }
        String str2 = "";
        if (!intchk_checkitem.bytes_module_name.has()) {
            str = "";
        } else {
            str = intchk_checkitem.bytes_module_name.get().toStringUtf8();
        }
        if (TextUtils.isEmpty(str.trim())) {
            return false;
        }
        if (intchk_checkitem.bytes_match_pattern.has()) {
            str2 = intchk_checkitem.bytes_match_pattern.get().toStringUtf8();
        }
        if (TextUtils.isEmpty(str2.trim())) {
            return false;
        }
        try {
            return MQPSecUtil.memchk(str, i3, i16, HexUtil.hexStr2Bytes(str2));
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    private byte[] g(intchk$CheckItem intchk_checkitem) {
        int i3;
        String str;
        int i16 = 0;
        if (intchk_checkitem.uint32_start_offset.has()) {
            i3 = intchk_checkitem.uint32_start_offset.get();
        } else {
            i3 = 0;
        }
        if (intchk_checkitem.uint32_end_offset.has()) {
            i16 = intchk_checkitem.uint32_end_offset.get();
        }
        if (i16 <= i3) {
            return null;
        }
        if (intchk_checkitem.bytes_module_name.has()) {
            str = intchk_checkitem.bytes_module_name.get().toStringUtf8();
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str.trim())) {
            return null;
        }
        try {
            return MQPSecUtil.memreport(str, i3, i16);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    private void h(intchk$RspBody intchk_rspbody) {
        int i3;
        int i16 = 2;
        if (intchk_rspbody.uint32_result.has()) {
            i3 = intchk_rspbody.uint32_result.get();
        } else {
            i3 = 2;
        }
        if (i3 != 1 || !intchk_rspbody.msg_report_check_result_rsp.has()) {
            return;
        }
        intchk$ReportCheckResultRsp intchk_reportcheckresultrsp = intchk_rspbody.msg_report_check_result_rsp.get();
        if (intchk_reportcheckresultrsp.uint32_need_strike.has()) {
            i16 = intchk_reportcheckresultrsp.uint32_need_strike.get();
        }
        if (i16 != 1 || !intchk_reportcheckresultrsp.bytes_strike_config.has()) {
            return;
        }
        if (intchk_reportcheckresultrsp.uint32_intchk_id.has()) {
            this.f336143d = intchk_reportcheckresultrsp.uint32_intchk_id.get();
        }
        i(intchk_reportcheckresultrsp.bytes_strike_config.get().toStringUtf8());
    }

    private void i(String str) {
        a aVar;
        Map<Integer, a> map;
        if (TextUtils.isEmpty(str.trim())) {
            return;
        }
        try {
            Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(str.getBytes())).getDocumentElement();
            this.f336144e = 0;
            String attribute = documentElement.getAttribute("type");
            if (attribute.trim().length() > 0) {
                this.f336144e = Integer.parseInt(attribute);
            }
            int i3 = this.f336144e;
            a aVar2 = null;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3 && (map = this.f336142c) != null) {
                        if (map.containsKey(3)) {
                            aVar2 = this.f336142c.get(3);
                        }
                        if (aVar2 != null) {
                            NodeList elementsByTagName = documentElement.getElementsByTagName("package");
                            if (elementsByTagName.getLength() == 0) {
                                return;
                            }
                            String attribute2 = ((Element) elementsByTagName.item(0)).getAttribute(TPReportParams.JSON_KEY_VAL);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("launch_package_name", attribute2);
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                            aVar2.exec(jSONObject.toString(), this);
                            return;
                        }
                        return;
                    }
                    return;
                }
                Map<Integer, a> map2 = this.f336142c;
                if (map2 != null) {
                    if (map2.containsKey(2)) {
                        aVar = this.f336142c.get(2);
                    } else {
                        aVar = null;
                    }
                    if (aVar != null) {
                        aVar.exec(null, this);
                        return;
                    }
                    return;
                }
                return;
            }
            Map<Integer, a> map3 = this.f336142c;
            if (map3 != null) {
                if (map3.containsKey(1)) {
                    aVar2 = this.f336142c.get(1);
                }
                if (aVar2 != null) {
                    try {
                        DOMSource dOMSource = new DOMSource(documentElement);
                        StringWriter stringWriter = new StringWriter();
                        TransformerFactory.newInstance().newTransformer().transform(dOMSource, new StreamResult(stringWriter));
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("toast_config", stringWriter.toString());
                        } catch (Exception e17) {
                            e17.printStackTrace();
                        }
                        aVar2.exec(jSONObject2.toString(), this);
                        return;
                    } catch (Exception e18) {
                        e18.printStackTrace();
                        return;
                    }
                }
                return;
            }
            return;
        } catch (Exception e19) {
            e19.printStackTrace();
        }
        e19.printStackTrace();
    }

    @Override // com.tencent.mqpsdk.a.b
    public void a(Object obj, Object obj2) {
        com.tencent.mqpsdk.a aVar;
        byte[] bArr;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, obj, obj2);
            return;
        }
        com.tencent.mqpsdk.b bVar = this.f336140a;
        if (bVar != null && (aVar = bVar.f336137b) != null) {
            a.InterfaceC9207a codec = aVar.getCodec("intchk");
            if (codec != null) {
                bArr = (byte[]) codec.decode(obj2);
            } else {
                bArr = null;
            }
            if (bArr == null) {
                return;
            }
            intchk$RspBody intchk_rspbody = new intchk$RspBody();
            try {
                intchk_rspbody.mergeFrom(bArr);
                if (intchk_rspbody.uint32_subcmd.has()) {
                    i3 = intchk_rspbody.uint32_subcmd.get();
                } else {
                    i3 = 0;
                }
                if (i3 != 1) {
                    if (i3 == 2) {
                        h(intchk_rspbody);
                        return;
                    }
                    return;
                }
                e(intchk_rspbody);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mqpsdk.secsrv.a
    public void b(String str) {
        com.tencent.mqpsdk.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("strike_result")) {
                this.f336145f = jSONObject.getInt("strike_result");
                intchk$ReportStrikeResultReq intchk_reportstrikeresultreq = new intchk$ReportStrikeResultReq();
                intchk_reportstrikeresultreq.uint32_intchk_id.set(this.f336143d);
                intchk_reportstrikeresultreq.uint32_strike_type.set(this.f336144e);
                intchk_reportstrikeresultreq.uint32_strike_result.set(this.f336145f);
                intchk$ReqBody intchk_reqbody = new intchk$ReqBody();
                intchk_reqbody.uint32_subcmd.set(3);
                intchk_reqbody.msg_app_info.set(d());
                intchk_reqbody.msg_report_strike_result_req.set(intchk_reportstrikeresultreq);
                com.tencent.mqpsdk.b bVar = this.f336140a;
                if (bVar == null || (aVar = bVar.f336137b) == null) {
                    return;
                }
                Object byteArray = intchk_reqbody.toByteArray();
                a.InterfaceC9207a codec = aVar.getCodec("intchk");
                if (codec != null) {
                    byteArray = codec.encode(byteArray);
                }
                aVar.send(byteArray);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void c(int i3, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) aVar);
        } else {
            if (aVar == null) {
                return;
            }
            if (this.f336142c == null) {
                this.f336142c = new LinkedHashMap();
            }
            this.f336142c.put(Integer.valueOf(i3), aVar);
        }
    }

    public void j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        this.f336141b = str;
        intchk$FetchCheckConfigReq intchk_fetchcheckconfigreq = new intchk$FetchCheckConfigReq();
        intchk_fetchcheckconfigreq.uint32_reserved.set(0);
        intchk$ReqBody intchk_reqbody = new intchk$ReqBody();
        intchk_reqbody.uint32_subcmd.set(1);
        intchk_reqbody.msg_app_info.set(d());
        intchk_reqbody.msg_check_config_req.set(intchk_fetchcheckconfigreq);
        com.tencent.mqpsdk.a aVar = this.f336140a.f336137b;
        if (aVar == null) {
            return;
        }
        Object byteArray = intchk_reqbody.toByteArray();
        a.InterfaceC9207a codec = aVar.getCodec("intchk");
        if (codec != null) {
            byteArray = codec.encode(byteArray);
        }
        aVar.send(byteArray);
    }
}
