package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.app.Activity;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.h6.k;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.lj.a;
import com.tencent.luggage.wxa.lj.j;
import com.tencent.luggage.wxa.qi.g;
import com.tencent.luggage.wxa.rj.q;
import com.tencent.luggage.wxa.ti.b;
import com.tencent.luggage.wxa.tk.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.uk.c0;
import com.tencent.luggage.wxa.xd.p;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.xweb.FileReaderHelper;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class JsApiOperateRecorder extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 295;
    public static final String NAME = "operateRecorder";

    /* renamed from: e, reason: collision with root package name */
    public static Vector f151981e = new Vector();

    /* renamed from: a, reason: collision with root package name */
    public OperateRecordTask f151982a;

    /* renamed from: b, reason: collision with root package name */
    public v f151983b;

    /* renamed from: c, reason: collision with root package name */
    public e.c f151984c;

    /* renamed from: d, reason: collision with root package name */
    public j.b f151985d;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class OperateRecordTask extends com.tencent.luggage.wxa.zd.a {
        public String H;
        public byte[] I;
        public int J;
        public boolean K;

        /* renamed from: c, reason: collision with root package name */
        public e.c f151986c;

        /* renamed from: d, reason: collision with root package name */
        public JsApiOperateRecorder f151987d;

        /* renamed from: e, reason: collision with root package name */
        public l f151988e;

        /* renamed from: f, reason: collision with root package name */
        public int f151989f;

        /* renamed from: h, reason: collision with root package name */
        public String f151991h;

        /* renamed from: i, reason: collision with root package name */
        public String f151992i;

        /* renamed from: l, reason: collision with root package name */
        public String f151995l;

        /* renamed from: m, reason: collision with root package name */
        public int f151996m;

        /* renamed from: g, reason: collision with root package name */
        public String f151990g = "";

        /* renamed from: j, reason: collision with root package name */
        public boolean f151993j = false;

        /* renamed from: k, reason: collision with root package name */
        public String f151994k = "";
        public String C = "";
        public int D = 0;
        public int E = 0;
        public String F = "";
        public String G = "";
        public final IListener L = new IListener<com.tencent.luggage.wxa.ti.b>(com.tencent.luggage.wxa.z8.b.f146383a) { // from class: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateRecorder.OperateRecordTask.1
            @Override // com.tencent.mm.sdk.event.IListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean callback(com.tencent.luggage.wxa.ti.b bVar) {
                int i3;
                String str;
                w.d("MicroMsg.Record.JsApiOperateRecorder", "mListener callback action : %d", Integer.valueOf(bVar.f141374d.f141375a));
                if (!OperateRecordTask.this.f151991h.equalsIgnoreCase(bVar.f141374d.f141384j)) {
                    w.b("MicroMsg.Record.JsApiOperateRecorder", "appId is diff, don't send event");
                    return false;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("state", bVar.f141374d.f141377c);
                OperateRecordTask.this.F = bVar.f141374d.f141377c;
                b.a aVar = bVar.f141374d;
                if (aVar.f141375a == 2) {
                    OperateRecordTask.this.C = aVar.f141378d;
                    OperateRecordTask.this.E = bVar.f141374d.f141376b;
                    OperateRecordTask.this.D = bVar.f141374d.f141379e;
                    com.tencent.luggage.wxa.qi.b.a(OperateRecordTask.this.f151991h);
                }
                b.a aVar2 = bVar.f141374d;
                if (aVar2.f141375a == 4) {
                    hashMap.put("errCode", Integer.valueOf(aVar2.f141382h));
                    if (!TextUtils.isEmpty(bVar.f141374d.f141383i)) {
                        str = bVar.f141374d.f141383i;
                    } else {
                        str = "";
                    }
                    hashMap.put("errMsg", str);
                }
                b.a aVar3 = bVar.f141374d;
                if (aVar3.f141375a == 5) {
                    byte[] bArr = aVar3.f141380f;
                    if (bArr != null && bArr.length > 819200) {
                        OperateRecordTask.this.a(bVar);
                    } else {
                        OperateRecordTask.this.I = bArr;
                    }
                    OperateRecordTask operateRecordTask = OperateRecordTask.this;
                    byte[] bArr2 = bVar.f141374d.f141380f;
                    if (bArr2 != null) {
                        i3 = bArr2.length;
                    } else {
                        i3 = 0;
                    }
                    operateRecordTask.J = i3;
                    OperateRecordTask.this.K = bVar.f141374d.f141381g;
                    w.d("MicroMsg.Record.JsApiOperateRecorder", "frameBufferSize:%d", Integer.valueOf(OperateRecordTask.this.J));
                }
                OperateRecordTask.this.f151995l = new JSONObject(hashMap).toString();
                OperateRecordTask operateRecordTask2 = OperateRecordTask.this;
                operateRecordTask2.f151996m = bVar.f141374d.f141375a;
                operateRecordTask2.b();
                return true;
            }
        };

        public OperateRecordTask(JsApiOperateRecorder jsApiOperateRecorder, l lVar, int i3) {
            this.f151987d = jsApiOperateRecorder;
            this.f151988e = lVar;
            this.f151989f = i3;
            i iVar = new i();
            if (lVar.getFileSystem().getTempDirectory(iVar) == com.tencent.luggage.wxa.rc.l.OK) {
                this.H = new com.tencent.luggage.wxa.cp.v((String) iVar.f141499a, "frameBuffer").g();
                return;
            }
            this.H = new com.tencent.luggage.wxa.cp.v(lVar.getContext().getCacheDir(), "frameBuffer_" + lVar.getAppId()).g();
        }

        @Override // com.tencent.luggage.wxa.zd.a
        public void b() {
            super.b();
            if (this.f151988e == null) {
                w.b("MicroMsg.Record.JsApiOperateRecorder", "service is null, don't callback");
                return;
            }
            if (this.f151996m == -1) {
                if (!this.f151993j) {
                    w.d("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder ok");
                    this.f151988e.a(this.f151989f, this.f151987d.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
                    return;
                }
                w.b("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder fail:%s", this.f151994k);
                this.f151988e.a(this.f151989f, this.f151987d.makeReturnJson("fail:" + this.f151994k));
                return;
            }
            d dVar = new d();
            int i3 = this.f151996m;
            if (i3 == 0 || i3 == 1) {
                this.f151987d.a(true);
                if (!JsApiOperateRecorder.f151981e.contains(this.f151991h)) {
                    e.a(this.f151991h, this.f151986c);
                    JsApiOperateRecorder.f151981e.add(this.f151991h);
                }
            } else if (i3 == 2 || i3 == 3 || i3 == 4) {
                this.f151987d.a(false);
                int i16 = this.f151996m;
                if (i16 == 2 || i16 == 4) {
                    e.b(this.f151991h, this.f151986c);
                    JsApiOperateRecorder.f151981e.remove(this.f151991h);
                }
            }
            if (this.f151996m == 2) {
                HashMap hashMap = new HashMap();
                hashMap.put("state", this.F);
                w.d("MicroMsg.Record.JsApiOperateRecorder", "filePath:%s, encodeFormat:%s", this.C, this.G);
                i iVar = new i();
                if (this.f151988e.getFileSystem().createTempFileFrom(new com.tencent.luggage.wxa.cp.v(this.C), g.a(this.G), true, iVar) == com.tencent.luggage.wxa.rc.l.OK) {
                    hashMap.put("tempFilePath", iVar.f141499a);
                } else {
                    w.b("MicroMsg.Record.JsApiOperateRecorder", "AppBrandLocalMediaObject obj is null");
                    hashMap.put("tempFilePath", "");
                }
                hashMap.put("duration", Integer.valueOf(this.E));
                hashMap.put("fileSize", Integer.valueOf(this.D));
                this.f151995l = new JSONObject(hashMap).toString();
            }
            if (this.f151996m == 5) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("state", this.F);
                hashMap2.put("isLastFrame", Boolean.valueOf(this.K));
                if (this.J > 819200) {
                    a(hashMap2);
                }
                byte[] bArr = this.I;
                if (bArr != null) {
                    hashMap2.put("frameBuffer", c0.a(bArr));
                } else {
                    w.b("MicroMsg.Record.JsApiOperateRecorder", "framBuffer is null, error");
                }
                c0.b a16 = c0.a(this.f151988e.getJsRuntime(), hashMap2, (c0.a) this.f151988e.a(c0.a.class));
                if (a16 == c0.b.OK) {
                    this.f151995l = new JSONObject(hashMap2).toString();
                } else if (a16 == c0.b.FAIL_SIZE_EXCEED_LIMIT) {
                    c0.a(this.f151988e, "onRecorderStateChange");
                    return;
                }
            }
            w.d("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", Integer.valueOf(this.f151996m), this.f151995l);
            dVar.setContext(this.f151988e).setData(this.f151995l).e();
        }

        @Override // com.tencent.luggage.wxa.zd.f
        public void a() {
            try {
                JSONObject jSONObject = new JSONObject(this.f151992i);
                String optString = jSONObject.optString("operationType");
                if (TextUtils.isEmpty(optString)) {
                    w.b("MicroMsg.Record.JsApiOperateRecorder", "operationType is null");
                    this.f151993j = true;
                    this.f151996m = -1;
                    this.f151994k = "operationType is null";
                    b();
                    return;
                }
                w.d("MicroMsg.Record.JsApiOperateRecorder", "operationType;%s", optString);
                this.f151993j = false;
                this.f151996m = -1;
                if (optString.equals("start")) {
                    int optInt = jSONObject.optInt("duration", 60000);
                    int optInt2 = jSONObject.optInt("sampleRate", 44100);
                    int optInt3 = jSONObject.optInt("numberOfChannels", 2);
                    int optInt4 = jSONObject.optInt("encodeBitRate", EncoderWriter.OUTPUT_AUDIO_BIT_RATE);
                    String optString2 = jSONObject.optString("format");
                    if (optString2.equals(FileReaderHelper.AAC_EXT)) {
                        w.b("MicroMsg.Record.JsApiOperateRecorder", "aac format doesn't support now!");
                        return;
                    }
                    double optDouble = jSONObject.optDouble("frameSize", 0.0d);
                    com.tencent.luggage.wxa.qi.a a16 = com.tencent.luggage.wxa.qi.a.a(jSONObject.optString("audioSource").toUpperCase(), com.tencent.luggage.wxa.qi.a.MIC);
                    com.tencent.luggage.wxa.qi.b.a(this.f151991h, this.L);
                    com.tencent.luggage.wxa.si.b bVar = new com.tencent.luggage.wxa.si.b();
                    bVar.f140371a = optInt;
                    bVar.f140372b = optInt2;
                    bVar.f140373c = optInt3;
                    bVar.f140374d = optInt4;
                    bVar.f140375e = optString2;
                    bVar.f140378h = optDouble;
                    bVar.f140376f = "" + System.currentTimeMillis();
                    bVar.f140379i = this.f151990g;
                    bVar.f140380j = this.f151991h;
                    bVar.f140381k = a16;
                    this.G = optString2;
                    com.tencent.luggage.wxa.qi.b.b();
                    if (com.tencent.luggage.wxa.qi.d.a(bVar)) {
                        w.d("MicroMsg.Record.JsApiOperateRecorder", "star record ok");
                        this.f151996m = -1;
                    } else if (com.tencent.luggage.wxa.qi.d.b()) {
                        this.f151993j = true;
                        this.f151994k = "audio is recording, don't start record again";
                    } else {
                        this.f151993j = true;
                        this.f151994k = "start record fail";
                    }
                } else if (optString.equals("resume")) {
                    if (com.tencent.luggage.wxa.qi.d.e()) {
                        this.f151996m = -1;
                        w.d("MicroMsg.Record.JsApiOperateRecorder", "resume record ok");
                    } else if (com.tencent.luggage.wxa.qi.d.b()) {
                        w.d("MicroMsg.Record.JsApiOperateRecorder", "audio is recording, don't resume record again");
                        this.f151994k = "";
                    } else {
                        this.f151993j = true;
                        this.f151994k = "resume record fail";
                    }
                } else if (optString.equals("pause")) {
                    if (com.tencent.luggage.wxa.qi.d.d()) {
                        this.f151996m = -1;
                        w.d("MicroMsg.Record.JsApiOperateRecorder", "pause record ok");
                    } else if (com.tencent.luggage.wxa.qi.d.a()) {
                        w.d("MicroMsg.Record.JsApiOperateRecorder", "audio is pause, don't pause record again");
                        this.f151994k = "";
                    } else {
                        this.f151993j = true;
                        this.f151994k = "pause record fail";
                    }
                } else if (optString.equals("stop")) {
                    if (com.tencent.luggage.wxa.qi.d.f()) {
                        this.f151996m = -1;
                        w.d("MicroMsg.Record.JsApiOperateRecorder", "stop record ok");
                    } else if (com.tencent.luggage.wxa.qi.d.c()) {
                        w.d("MicroMsg.Record.JsApiOperateRecorder", "audio is stop, don't stop record again");
                        this.f151994k = "";
                    } else {
                        this.f151993j = true;
                        this.f151994k = "stop record fail";
                    }
                } else {
                    w.b("MicroMsg.Record.JsApiOperateRecorder", "operationType is invalid");
                    this.f151993j = true;
                    this.f151994k = "operationType is invalid";
                }
                if (this.f151993j) {
                    w.b("MicroMsg.Record.JsApiOperateRecorder", this.f151994k);
                }
                b();
            } catch (JSONException e16) {
                w.b("MicroMsg.Record.JsApiOperateRecorder", "new json exists exception, data is invalid, dataStr:%s", this.f151992i);
                this.f151993j = true;
                this.f151996m = -1;
                this.f151994k = "parser data fail, data is invalid";
                w.b("MicroMsg.Record.JsApiOperateRecorder", "exception:%s" + e16.getMessage());
                b();
            }
        }

        public final void a(com.tencent.luggage.wxa.ti.b bVar) {
            long nanoTime = System.nanoTime();
            OutputStream outputStream = null;
            try {
                try {
                    try {
                        com.tencent.luggage.wxa.cp.v vVar = new com.tencent.luggage.wxa.cp.v(this.H);
                        w.a("MicroMsg.Record.JsApiOperateRecorder", "frameBufferPath:%s", this.H);
                        if (!vVar.e()) {
                            vVar.c();
                        }
                        outputStream = x.b(vVar);
                        outputStream.write(bVar.f141374d.f141380f);
                        outputStream.close();
                        try {
                            outputStream.close();
                        } catch (IOException e16) {
                            w.a("MicroMsg.Record.JsApiOperateRecorder", e16, "", new Object[0]);
                        }
                    } catch (FileNotFoundException e17) {
                        w.a("MicroMsg.Record.JsApiOperateRecorder", e17, "", new Object[0]);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e18) {
                                w.a("MicroMsg.Record.JsApiOperateRecorder", e18, "", new Object[0]);
                            }
                        }
                    }
                } catch (IOException e19) {
                    w.a("MicroMsg.Record.JsApiOperateRecorder", e19, "", new Object[0]);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e26) {
                            w.a("MicroMsg.Record.JsApiOperateRecorder", e26, "", new Object[0]);
                        }
                    }
                }
                w.a("MicroMsg.Record.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
            } catch (Throwable th5) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e27) {
                        w.a("MicroMsg.Record.JsApiOperateRecorder", e27, "", new Object[0]);
                    }
                }
                throw th5;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0096, code lost:
        
            if (r0 != 0) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0098, code lost:
        
            r6.d();
            r0 = r0;
            r5 = r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0079, code lost:
        
            if (r0 != 0) goto L51;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:56:0x00c7  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v13, types: [boolean] */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v15 */
        /* JADX WARN: Type inference failed for: r0v18 */
        /* JADX WARN: Type inference failed for: r0v19 */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v5, types: [boolean] */
        /* JADX WARN: Type inference failed for: r0v7, types: [boolean] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r5v16, types: [java.lang.Throwable, java.io.IOException] */
        /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Throwable, java.io.IOException] */
        /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Throwable, java.io.IOException] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a(Map map) {
            InputStream inputStream;
            IOException e16;
            com.tencent.luggage.wxa.cp.v vVar;
            FileNotFoundException e17;
            InputStream inputStream2;
            boolean z16;
            ?? r06 = "";
            long nanoTime = System.nanoTime();
            InputStream inputStream3 = null;
            InputStream inputStream4 = null;
            r5 = null;
            r5 = null;
            r5 = null;
            InputStream inputStream5 = null;
            com.tencent.luggage.wxa.cp.v vVar2 = null;
            try {
                try {
                    vVar = new com.tencent.luggage.wxa.cp.v(this.H);
                    try {
                    } catch (FileNotFoundException e18) {
                        e17 = e18;
                        w.a("MicroMsg.Record.JsApiOperateRecorder", e17, "", new Object[0]);
                        if (0 != 0) {
                            try {
                                inputStream3.close();
                            } catch (IOException e19) {
                                w.a("MicroMsg.Record.JsApiOperateRecorder", e19, "", new Object[0]);
                                inputStream5 = e19;
                            }
                        }
                        if (vVar != null) {
                            r06 = vVar.e();
                            z16 = r06;
                            inputStream2 = inputStream5;
                        }
                        w.b("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                        r06 = r06;
                        inputStream3 = inputStream5;
                        w.a("MicroMsg.Record.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                        return;
                    } catch (IOException e26) {
                        e16 = e26;
                        w.a("MicroMsg.Record.JsApiOperateRecorder", e16, "", new Object[0]);
                        if (0 != 0) {
                            try {
                                inputStream3.close();
                            } catch (IOException e27) {
                                w.a("MicroMsg.Record.JsApiOperateRecorder", e27, "", new Object[0]);
                                inputStream5 = e27;
                            }
                        }
                        if (vVar != null) {
                            r06 = vVar.e();
                            z16 = r06;
                            inputStream2 = inputStream5;
                        }
                        w.b("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                        r06 = r06;
                        inputStream3 = inputStream5;
                        w.a("MicroMsg.Record.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                        return;
                    } catch (Throwable th5) {
                        th = th5;
                        if (inputStream4 != null) {
                        }
                        if (vVar == null) {
                        }
                        w.b("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                        throw th;
                    }
                } catch (FileNotFoundException e28) {
                    e17 = e28;
                    vVar = null;
                } catch (IOException e29) {
                    e16 = e29;
                    vVar = null;
                } catch (Throwable th6) {
                    th = th6;
                    inputStream = null;
                    r06 = r06;
                    vVar = vVar2;
                    inputStream4 = inputStream;
                    if (inputStream4 != null) {
                    }
                    if (vVar == null) {
                    }
                    w.b("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                    throw th;
                }
                if (vVar.e()) {
                    InputStream a16 = x.a(vVar);
                    byte[] bArr = new byte[this.J];
                    this.I = bArr;
                    a16.read(bArr);
                    a16.close();
                    try {
                        a16.close();
                        inputStream5 = a16;
                    } catch (IOException e36) {
                        w.a("MicroMsg.Record.JsApiOperateRecorder", e36, "", new Object[0]);
                        inputStream5 = e36;
                    }
                    r06 = vVar.e();
                    if (r06 != 0) {
                        vVar.d();
                        w.a("MicroMsg.Record.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                        return;
                    }
                    w.b("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                    r06 = r06;
                    inputStream3 = inputStream5;
                    w.a("MicroMsg.Record.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                    return;
                }
                w.b("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, return");
                if (vVar.e()) {
                    vVar.d();
                } else {
                    w.b("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                }
            } catch (Throwable th7) {
                th = th7;
                inputStream = inputStream3;
                vVar2 = vVar;
                r06 = r06;
                vVar = vVar2;
                inputStream4 = inputStream;
                if (inputStream4 != null) {
                    try {
                        inputStream4.close();
                    } catch (IOException e37) {
                        w.a("MicroMsg.Record.JsApiOperateRecorder", e37, r06, new Object[0]);
                    }
                }
                if (vVar == null && vVar.e()) {
                    vVar.d();
                    throw th;
                }
                w.b("MicroMsg.Record.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                throw th;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f151998a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f151999b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f152000c;

        public a(String str, l lVar, int i3) {
            this.f151998a = str;
            this.f151999b = lVar;
            this.f152000c = i3;
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            w.d("MicroMsg.Record.JsApiOperateRecorder", "onDestroy, appId:%s", this.f151998a);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("operationType", "stop");
            } catch (JSONException e16) {
                w.a("MicroMsg.Record.JsApiOperateRecorder", e16, "", new Object[0]);
            }
            if (JsApiOperateRecorder.this.f151982a == null) {
                JsApiOperateRecorder jsApiOperateRecorder = JsApiOperateRecorder.this;
                jsApiOperateRecorder.f151982a = new OperateRecordTask(jsApiOperateRecorder, this.f151999b, this.f152000c);
            }
            JsApiOperateRecorder.this.f151982a.f151992i = jSONObject.toString();
            JsApiOperateRecorder.this.f151982a.f151991h = this.f151998a;
            JsApiOperateRecorder.this.f151982a.f151996m = -1;
            JsApiOperateRecorder.this.f151982a.d();
            e.b(this.f151998a, this);
            JsApiOperateRecorder.f151981e.remove(this.f151998a);
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onPause(e.d dVar) {
            w.d("MicroMsg.Record.JsApiOperateRecorder", "onPause, appId:%s", this.f151998a);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("operationType", "pause");
            } catch (JSONException e16) {
                w.a("MicroMsg.Record.JsApiOperateRecorder", e16, "", new Object[0]);
            }
            if (JsApiOperateRecorder.this.f151982a == null) {
                JsApiOperateRecorder jsApiOperateRecorder = JsApiOperateRecorder.this;
                jsApiOperateRecorder.f151982a = new OperateRecordTask(jsApiOperateRecorder, this.f151999b, this.f152000c);
            }
            JsApiOperateRecorder.this.f151982a.f151992i = jSONObject.toString();
            JsApiOperateRecorder.this.f151982a.f151991h = this.f151998a;
            JsApiOperateRecorder.this.f151982a.f151996m = -1;
            JsApiOperateRecorder.this.f151982a.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f152002a;

        public b(boolean z16) {
            this.f152002a = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            JsApiOperateRecorder.this.a(this.f152002a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements ActivityCompat.OnRequestPermissionsResultCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f152004a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f152005b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f152006c;

        public c(l lVar, JSONObject jSONObject, int i3) {
            this.f152004a = lVar;
            this.f152005b = jSONObject;
            this.f152006c = i3;
        }

        @Override // androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
        public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
            if (i3 != 116) {
                return;
            }
            if (iArr != null && iArr.length > 0 && iArr[0] == 0) {
                w.d("MicroMsg.Record.JsApiOperateRecorder", "PERMISSION_GRANTED, do invoke again");
                JsApiOperateRecorder.this.invoke(this.f152004a, this.f152005b, this.f152006c);
            } else {
                w.b("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, SYS_PERM_DENIED");
                this.f152004a.a(this.f152006c, JsApiOperateRecorder.this.makeReturnJson("fail:system permission denied"));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class d extends p {
        private static final int CTRL_INDEX = 296;
        private static final String NAME = "onRecorderStateChange";
    }

    public final boolean b(l lVar, JSONObject jSONObject, int i3) {
        Activity activity;
        q.a(lVar.getAppId(), new c(lVar, jSONObject, i3));
        if (lVar.getContext() instanceof Activity) {
            activity = (Activity) lVar.getContext();
        } else {
            activity = null;
        }
        Activity activity2 = activity;
        if (activity2 == null) {
            w.b("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, pageContext is null");
            lVar.a(i3, makeReturnJson("fail"));
            return false;
        }
        boolean a16 = k.a(activity2, lVar, QQPermissionConstants.Permission.RECORD_AUDIO, 116, "", "");
        if (a16) {
            q.a(lVar.getAppId());
        }
        return a16;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(l lVar, JSONObject jSONObject, int i3) {
        if (!b(lVar, jSONObject, i3)) {
            w.b("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, requestPermission fail");
            lVar.a(i3, makeReturnJson("fail:system permission denied"));
            return;
        }
        com.tencent.luggage.wxa.kj.p Y = lVar.getRuntime().Y();
        if (Y.getCurrentPage() != null && Y.getCurrentPage().getCurrentPageView() != null) {
            this.f151983b = Y.getCurrentPage().getCurrentPageView();
            if (jSONObject == null) {
                w.b("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, data is null");
                lVar.a(i3, makeReturnJson("fail:data is null"));
                return;
            }
            String appId = lVar.getAppId();
            w.d("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder appId:%s, data:%s", appId, jSONObject.toString());
            if (this.f151982a == null) {
                this.f151982a = new OperateRecordTask(this, lVar, i3);
            }
            OperateRecordTask operateRecordTask = this.f151982a;
            operateRecordTask.f151989f = i3;
            operateRecordTask.f151991h = appId;
            operateRecordTask.f151992i = jSONObject.toString();
            this.f151982a.f151990g = z.i();
            if (this.f151984c == null) {
                this.f151984c = new a(appId, lVar, i3);
            }
            OperateRecordTask operateRecordTask2 = this.f151982a;
            operateRecordTask2.f151986c = this.f151984c;
            operateRecordTask2.c();
            return;
        }
        lVar.a(i3, makeReturnJson("fail"));
    }

    public final void a(boolean z16) {
        if (!com.tencent.luggage.wxa.tn.c0.b()) {
            com.tencent.luggage.wxa.tn.c0.a(new b(z16));
            return;
        }
        v vVar = this.f151983b;
        if (vVar == null || vVar.getRuntime() == null) {
            return;
        }
        if (z16) {
            this.f151985d = a.b.a(this.f151983b.getRuntime()).a(a.c.VOICE);
            return;
        }
        j.b bVar = this.f151985d;
        if (bVar != null) {
            bVar.c();
            this.f151985d = null;
        }
    }
}
