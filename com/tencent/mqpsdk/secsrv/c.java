package com.tencent.mqpsdk.secsrv;

import com.tencent.ims.signature$SignatureReport;
import com.tencent.ims.signature$SignatureResult;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mqpsdk.a;
import common.config.service.QzoneConfig;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes21.dex */
public class c implements a.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mqpsdk.b f336146a;

    /* renamed from: b, reason: collision with root package name */
    private a f336147b;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface a {
        void a(String str);
    }

    public c(com.tencent.mqpsdk.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            return;
        }
        this.f336146a = null;
        this.f336147b = null;
        com.tencent.mqpsdk.a aVar = bVar.f336137b;
        if (aVar != null) {
            aVar.setNetTransportEventListener("sig_check", this);
        }
        this.f336146a = bVar;
    }

    @Override // com.tencent.mqpsdk.a.b
    public void a(Object obj, Object obj2) {
        com.tencent.mqpsdk.b bVar;
        com.tencent.mqpsdk.a aVar;
        a.InterfaceC9207a codec;
        byte[] bArr;
        int i3;
        String str;
        String str2;
        String str3;
        String str4;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, obj, obj2);
            return;
        }
        if (this.f336147b == null || (bVar = this.f336146a) == null || (aVar = bVar.f336137b) == null || (codec = aVar.getCodec("sig_check")) == null || (bArr = (byte[]) codec.decode(obj2)) == null) {
            return;
        }
        signature$SignatureResult signature_signatureresult = new signature$SignatureResult();
        try {
            signature_signatureresult.mergeFrom(bArr);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (signature_signatureresult.u32_check_result.has()) {
            i3 = signature_signatureresult.u32_check_result.get();
        } else {
            i3 = -1;
        }
        String str5 = "";
        if (!signature_signatureresult.str_title.has()) {
            str = "";
        } else {
            str = signature_signatureresult.str_title.get();
        }
        if (!signature_signatureresult.str_content.has()) {
            str2 = "";
        } else {
            str2 = signature_signatureresult.str_content.get();
        }
        if (!signature_signatureresult.str_left_button.has()) {
            str3 = "";
        } else {
            str3 = signature_signatureresult.str_left_button.get();
        }
        if (!signature_signatureresult.str_right_button.has()) {
            str4 = "";
        } else {
            str4 = signature_signatureresult.str_right_button.get();
        }
        if (signature_signatureresult.str_url.has()) {
            str5 = signature_signatureresult.str_url.get();
        }
        if (signature_signatureresult.u32_cache_time.has()) {
            i16 = signature_signatureresult.u32_cache_time.get();
        } else {
            i16 = QzoneConfig.DefaultValue.QZONESETTINGS_AIO_FEEDS_MIN_REFRESH_TIME;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("dialog_title", str);
            jSONObject.put("dialog_content", str2);
            jSONObject.put("dialog_left_button", str3);
            jSONObject.put("dialog_right_button", str4);
            jSONObject.put("url", str5);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("sig_check_result", i3);
            jSONObject2.put("dialog_config", jSONObject);
            jSONObject2.put("cache_time", i16);
            this.f336147b.a(jSONObject2.toString());
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    public void b(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.f336147b = aVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(String str) {
        String str2;
        String str3;
        String str4;
        int i3;
        int i16;
        signature$SignatureReport signature_signaturereport;
        com.tencent.mqpsdk.b bVar;
        com.tencent.mqpsdk.a aVar;
        a.InterfaceC9207a codec;
        JSONObject jSONObject;
        String str5 = "";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        int i17 = 0;
        long j3 = 0;
        try {
            jSONObject = new JSONObject(str);
            if (jSONObject.has("uin")) {
                j3 = jSONObject.getLong("uin");
            }
            if (jSONObject.has(AudienceReportConst.CLIENT_TYPE)) {
                i16 = jSONObject.getInt(AudienceReportConst.CLIENT_TYPE);
            } else {
                i16 = 0;
            }
            try {
                if (jSONObject.has("is_repack")) {
                    i17 = jSONObject.getInt("is_repack");
                }
                if (!jSONObject.has("package_name")) {
                    str4 = "";
                } else {
                    str4 = jSONObject.getString("package_name");
                }
                try {
                    if (!jSONObject.has("package_version")) {
                        str3 = "";
                    } else {
                        str3 = jSONObject.getString("package_version");
                    }
                    try {
                        if (!jSONObject.has("package_md5")) {
                            str2 = "";
                        } else {
                            str2 = jSONObject.getString("package_md5");
                        }
                    } catch (Exception e16) {
                        e = e16;
                        str2 = "";
                    }
                } catch (Exception e17) {
                    e = e17;
                    str2 = "";
                    str3 = str2;
                }
            } catch (Exception e18) {
                e = e18;
                str2 = "";
                str3 = str2;
                str4 = str3;
            }
        } catch (Exception e19) {
            e = e19;
            str2 = "";
            str3 = str2;
            str4 = str3;
            i3 = 0;
        }
        try {
            if (jSONObject.has("package_signature")) {
                str5 = jSONObject.getString("package_signature");
            }
        } catch (Exception e26) {
            e = e26;
            int i18 = i17;
            i17 = i16;
            e = e;
            i3 = i18;
            e.printStackTrace();
            i16 = i17;
            i17 = i3;
            signature_signaturereport = new signature$SignatureReport();
            signature_signaturereport.u64_uin.set(j3);
            signature_signaturereport.u32_client_type.set(i16);
            signature_signaturereport.u32_is_repack.set(i17);
            signature_signaturereport.str_packname.set(str4);
            signature_signaturereport.str_version.set(str3);
            signature_signaturereport.str_md5.set(str2);
            signature_signaturereport.str_signature.set(str5);
            bVar = this.f336146a;
            if (bVar != null) {
                return;
            }
            Object byteArray = signature_signaturereport.toByteArray();
            codec = aVar.getCodec("sig_check");
            if (codec != null) {
            }
            aVar.send(byteArray);
        }
        signature_signaturereport = new signature$SignatureReport();
        signature_signaturereport.u64_uin.set(j3);
        signature_signaturereport.u32_client_type.set(i16);
        signature_signaturereport.u32_is_repack.set(i17);
        signature_signaturereport.str_packname.set(str4);
        signature_signaturereport.str_version.set(str3);
        signature_signaturereport.str_md5.set(str2);
        signature_signaturereport.str_signature.set(str5);
        bVar = this.f336146a;
        if (bVar != null || (aVar = bVar.f336137b) == null) {
            return;
        }
        Object byteArray2 = signature_signaturereport.toByteArray();
        codec = aVar.getCodec("sig_check");
        if (codec != null) {
            byteArray2 = codec.encode(byteArray2);
        }
        aVar.send(byteArray2);
    }
}
