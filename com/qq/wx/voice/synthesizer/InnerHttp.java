package com.qq.wx.voice.synthesizer;

import com.qq.wx.voice.util.Common;
import com.qq.wx.voice.util.LogTool;
import com.qq.wx.voice.util.ManagerDataStore;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class InnerHttp implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private boolean f41078a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f41080c;

    /* renamed from: d, reason: collision with root package name */
    private long f41081d;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f41082e;

    /* renamed from: f, reason: collision with root package name */
    private int f41083f;

    /* renamed from: h, reason: collision with root package name */
    private String f41085h;

    /* renamed from: b, reason: collision with root package name */
    private boolean f41079b = false;

    /* renamed from: g, reason: collision with root package name */
    private int f41084g = 1;

    /* renamed from: i, reason: collision with root package name */
    private DefaultHttpClient f41086i = new DefaultHttpClient();

    /* renamed from: j, reason: collision with root package name */
    private int f41087j = 3000;

    /* renamed from: k, reason: collision with root package name */
    private int f41088k = 3000;

    /* renamed from: l, reason: collision with root package name */
    private int f41089l = 2;

    /* renamed from: m, reason: collision with root package name */
    private int f41090m = 0;

    /* renamed from: n, reason: collision with root package name */
    private int f41091n = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InnerHttp(String str) {
        this.f41078a = false;
        this.f41080c = false;
        this.f41081d = ManagerDataStore.NULLNUM;
        this.f41082e = null;
        this.f41083f = 0;
        this.f41085h = "";
        byte[] bytes = str.getBytes();
        this.f41083f = 0;
        this.f41082e = bytes;
        try {
            byte[] compress = Common.compress(bytes);
            this.f41082e = compress;
            if (compress.length < bytes.length) {
                this.f41083f = 1;
            } else {
                this.f41083f = 0;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (this.f41083f == 0) {
            this.f41082e = bytes;
        }
        this.f41086i.getParams().setParameter("http.connection.timeout", Integer.valueOf(this.f41087j));
        this.f41086i.getParams().setParameter("http.socket.timeout", Integer.valueOf(this.f41088k));
        long deltaTime = InfoSynthesizer.f41071d.getDeltaTime();
        this.f41081d = deltaTime;
        if (deltaTime != ManagerDataStore.NULLNUM) {
            this.f41080c = true;
        }
        LogTool.d("mDeltaTime = " + this.f41081d + " mIsAuthorized = " + this.f41080c);
        this.f41078a = false;
        this.f41085h = Common.genVoiceId(InfoSynthesizer.f41070c.getGuid());
    }

    private byte[] b() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("appid=");
            sb5.append(InfoSynthesizer.f41068a);
            sb5.append("&timestamp=");
            sb5.append((System.currentTimeMillis() / 1000) - this.f41081d);
            sb5.append("&device_info=");
            sb5.append(InfoSynthesizer.f41070c.getDeviceInfo());
            sb5.append("&guid=");
            sb5.append(InfoSynthesizer.f41070c.getGuid());
            sb5.append("&android_signature=");
            sb5.append(InfoSynthesizer.f41070c.getAndroid_signature());
            sb5.append("&android_package_name=");
            sb5.append(InfoSynthesizer.f41070c.getAndroid_package_name());
            sb5.append("&tts_format=");
            sb5.append(InfoSynthesizer.f41075h);
            sb5.append("&text_length=");
            sb5.append(this.f41082e.length);
            sb5.append("&offset=0");
            sb5.append("&comp=");
            sb5.append(this.f41083f);
            sb5.append("&volume=");
            sb5.append(InfoSynthesizer.f41076i);
            if (InfoSynthesizer.f41072e.isNeedUpdate() && InfoSynthesizer.f41077j) {
                sb5.append(InfoSynthesizer.f41072e.getRecordStr());
                this.f41079b = true;
            }
            LogTool.d(sb5.toString());
            byteArrayOutputStream.write(sb5.toString().getBytes());
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(this.f41082e);
            byteArrayOutputStream.flush();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            byteArrayOutputStream2.write(InfoSynthesizer.f41074g);
            byteArrayOutputStream2.write(Common.AES(byteArrayOutputStream.toByteArray()));
            byteArrayOutputStream2.flush();
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            byteArrayOutputStream2.close();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e16) {
            e16.printStackTrace();
            b(-204);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        this.f41078a = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        String a16;
        byte[] b16;
        int i3 = 0;
        loop0: do {
            int i16 = 0;
            while (!this.f41078a) {
                int i17 = this.f41090m;
                int i18 = this.f41089l;
                if (i17 >= i18 || this.f41091n >= i18) {
                    break loop0;
                }
                if (!this.f41080c) {
                    this.f41084g = 1;
                    a16 = a(1);
                    b16 = new byte[0];
                    this.f41090m++;
                } else {
                    this.f41084g = 11;
                    a16 = a(11);
                    b16 = b();
                    this.f41091n++;
                }
                LogTool.d(a16);
                LogTool.d("post data length = " + b16.length + " post times = " + this.f41091n);
                byte[] a17 = a(a16, b16);
                if (a17 == null) {
                    InfoSynthesizer.f41072e.add(false, InfoSynthesizer.f41070c.getNetType());
                    i16 = -201;
                } else {
                    if (this.f41079b) {
                        InfoSynthesizer.f41072e.clear();
                        this.f41079b = false;
                    }
                    InfoSynthesizer.f41072e.add(true, InfoSynthesizer.f41070c.getNetType());
                    i16 = a(a17, this.f41084g);
                    if (i16 != 0) {
                        if (this.f41084g == 11 && i16 == 20105) {
                            this.f41080c = false;
                            this.f41081d = ManagerDataStore.NULLNUM;
                            this.f41091n = 0;
                        }
                    }
                }
            }
            i3 = i16;
            break loop0;
        } while (this.f41084g != 11);
        if (i3 != 0) {
            b(i3);
        }
    }

    private String a(int i3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("http://" + InfoSynthesizer.Domain + InfoSynthesizer.Uri + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (i3 == 1) {
            sb5.append("cmd=");
            sb5.append(i3);
            sb5.append("&appid=");
            sb5.append(InfoSynthesizer.f41068a);
        }
        if (i3 == 11) {
            sb5.append("version=1.0");
            sb5.append("&cmd=");
            sb5.append(i3);
            sb5.append("&appid=");
            sb5.append(InfoSynthesizer.f41068a);
            sb5.append("&tts_id=");
            sb5.append(this.f41085h);
            sb5.append("&os=");
            sb5.append(InfoSynthesizer.f41070c.getOs());
            sb5.append("&sdk_src=0");
            sb5.append("&osver=");
            sb5.append(InfoSynthesizer.f41070c.getOsver());
            sb5.append("&net=");
            sb5.append(InfoSynthesizer.f41070c.getNetTypeNum());
            sb5.append("&sdk_ver=1.17");
            sb5.append("&encrypt_aes_mode=CBC");
        }
        return sb5.toString();
    }

    private void b(int i3) {
        if (this.f41078a) {
            return;
        }
        InfoSynthesizer.f41069b.a(i3);
    }

    private byte[] a(String str, byte[] bArr) {
        try {
            HttpPost httpPost = new HttpPost(str);
            httpPost.setEntity(new ByteArrayEntity(bArr));
            HttpResponse execute = this.f41086i.execute(httpPost);
            if (execute.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toByteArray(execute.getEntity());
            }
            return null;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private int a(byte[] bArr, int i3) {
        try {
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8"));
                LogTool.d(jSONObject.toString());
                try {
                    if (!jSONObject.has("ret")) {
                        return -203;
                    }
                    int i16 = jSONObject.getInt("ret");
                    if (i16 != 0) {
                        return i16;
                    }
                    if (i3 == 1) {
                        if (!a(jSONObject)) {
                            return -205;
                        }
                        this.f41080c = true;
                        LogTool.d("mDeltaTime = " + this.f41081d + " mIsAuthorized = " + this.f41080c);
                    }
                    if (i3 == 11) {
                        int i17 = 0;
                        while (true) {
                            if (i17 >= bArr.length) {
                                i17 = -1;
                                break;
                            }
                            if (bArr[i17] == 0) {
                                break;
                            }
                            i17++;
                        }
                        if (i17 != -1 && (bArr.length - i17) - 1 > 0) {
                            int length = (bArr.length - i17) - 1;
                            byte[] bArr2 = new byte[length];
                            System.arraycopy(bArr, i17 + 1, bArr2, 0, length);
                            if (!a(jSONObject, bArr2)) {
                                return -206;
                            }
                            SpeechSynthesizerResult speechSynthesizerResult = new SpeechSynthesizerResult();
                            byte[] bArr3 = new byte[length];
                            speechSynthesizerResult.speech = bArr3;
                            System.arraycopy(bArr2, 0, bArr3, 0, length);
                            if (!this.f41078a) {
                                InfoSynthesizer.f41069b.a(speechSynthesizerResult);
                            }
                        } else {
                            LogTool.d("splitOffset = " + i17);
                            return -203;
                        }
                    }
                    return 0;
                } catch (JSONException e16) {
                    e16.printStackTrace();
                    LogTool.d("json = " + jSONObject.toString());
                    return -203;
                }
            } catch (JSONException e17) {
                e17.printStackTrace();
                return -202;
            }
        } catch (UnsupportedEncodingException e18) {
            e18.printStackTrace();
            return -203;
        }
    }

    private boolean a(JSONObject jSONObject) {
        try {
            if (!jSONObject.has("timestamp")) {
                return false;
            }
            long currentTimeMillis = (System.currentTimeMillis() / 1000) - jSONObject.getLong("timestamp");
            this.f41081d = currentTimeMillis;
            InfoSynthesizer.f41071d.setDeltaTime(currentTimeMillis);
            return true;
        } catch (JSONException e16) {
            e16.printStackTrace();
            LogTool.d("json = " + jSONObject.toString());
            return false;
        }
    }

    private boolean a(JSONObject jSONObject, byte[] bArr) {
        try {
            if (jSONObject.has("tts_id") && !jSONObject.getString("tts_id").equals(this.f41085h)) {
                return false;
            }
            if (!jSONObject.has("length")) {
                return true;
            }
            int i3 = jSONObject.getInt("length");
            LogTool.d("TTS response para length = " + i3);
            LogTool.d("TTS response real length = " + bArr.length);
            return i3 == bArr.length;
        } catch (JSONException e16) {
            e16.printStackTrace();
            LogTool.d("json = " + jSONObject.toString());
            return false;
        }
    }
}
