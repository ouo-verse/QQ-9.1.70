package com.qq.wx.voice.recognizer;

import com.qq.wx.voice.recognizer.VoiceRecognizerResult;
import com.qq.wx.voice.util.Common;
import com.qq.wx.voice.util.LogTool;
import com.qq.wx.voice.util.ManagerDataStore;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class InnerHttp implements Runnable {
    public static long mDeltaTime = ManagerDataStore.NULLNUM;
    public static boolean mIsAuthorized = false;

    /* renamed from: a, reason: collision with root package name */
    private boolean f40999a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f41000b = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f41001c = false;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f41002d = null;

    /* renamed from: e, reason: collision with root package name */
    private int f41003e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f41004f = 1;

    /* renamed from: g, reason: collision with root package name */
    private String f41005g = null;

    /* renamed from: h, reason: collision with root package name */
    private int f41006h = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f41007i = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f41008j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f41009k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f41010l = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f41011m = 0;

    /* renamed from: n, reason: collision with root package name */
    private DefaultHttpClient f41012n = new DefaultHttpClient();

    /* renamed from: o, reason: collision with root package name */
    private int f41013o = 3000;

    /* renamed from: p, reason: collision with root package name */
    private int f41014p = 3000;

    /* renamed from: q, reason: collision with root package name */
    private int f41015q = 2;

    /* renamed from: r, reason: collision with root package name */
    private int f41016r = 0;

    /* renamed from: s, reason: collision with root package name */
    private int f41017s = 0;

    private byte[] f() {
        int i3;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("&appid=");
            sb5.append(InfoRecognizer.f40971a);
            sb5.append("&timestamp=");
            sb5.append((System.currentTimeMillis() / 1000) - mDeltaTime);
            sb5.append("&seq=");
            sb5.append(this.f41006h);
            sb5.append("&len=");
            sb5.append(this.f41003e);
            sb5.append("&samples_per_sec=");
            sb5.append(InfoRecorder.f40987a);
            sb5.append("&bits_per_sample=16&result_type=");
            sb5.append(InfoHttp.f40966c);
            sb5.append("&max_result_count=");
            sb5.append(InfoHttp.f40965b);
            sb5.append("&end=");
            sb5.append(String.valueOf(this.f41008j));
            sb5.append("&device_info=");
            sb5.append(InfoRecognizer.f40973c.getDeviceInfo());
            sb5.append("&guid=");
            sb5.append(InfoRecognizer.f40973c.getGuid());
            sb5.append("&android_signature=");
            sb5.append(InfoRecognizer.f40973c.getAndroid_signature());
            sb5.append("&android_package_name=");
            sb5.append(InfoRecognizer.f40973c.getAndroid_package_name());
            sb5.append("&vr_domain=");
            sb5.append(InfoHttp.f40968e);
            sb5.append("&cont_res=");
            sb5.append(InfoHttp.f40969f);
            sb5.append("&language_type=0&voice_file_type=");
            int i16 = 6;
            if (InfoRecognizer.f40981k) {
                i3 = 6;
            } else {
                i3 = 1;
            }
            sb5.append(i3);
            sb5.append("&voice_encode_type=");
            if (!InfoRecognizer.f40981k) {
                i16 = 1;
            }
            sb5.append(i16);
            if ((InfoHttp.f40966c & 4) > 0) {
                sb5.append("&semantic_category=");
                sb5.append(InfoHttp.f40967d);
            }
            if (InfoRecognizer.f40975e.isNeedUpdate() && this.f41008j == 1 && InfoHttp.f40970g) {
                sb5.append(InfoRecognizer.f40975e.getRecordStr());
                this.f41001c = true;
            }
            LogTool.d(sb5.toString());
            byteArrayOutputStream.write(sb5.toString().getBytes());
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(this.f41002d);
            byteArrayOutputStream.flush();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            byteArrayOutputStream2.write(InfoHttp.f40964a);
            byteArrayOutputStream2.write(Common.AES(byteArrayOutputStream.toByteArray()));
            byteArrayOutputStream2.flush();
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            byteArrayOutputStream2.close();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e16) {
            e16.printStackTrace();
            d(-204);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        this.f41012n.getParams().setParameter("http.connection.timeout", Integer.valueOf(this.f41013o));
        this.f41012n.getParams().setParameter("http.socket.timeout", Integer.valueOf(this.f41014p));
        long deltaTime = InfoRecognizer.f40974d.getDeltaTime();
        mDeltaTime = deltaTime;
        if (deltaTime != ManagerDataStore.NULLNUM) {
            mIsAuthorized = true;
        }
        LogTool.d("mDeltaTime = " + mDeltaTime + " mIsAuthorized = " + mIsAuthorized);
        this.f40999a = false;
        this.f41000b = false;
        this.f41001c = false;
        this.f41005g = Common.genVoiceId(InfoRecognizer.f40973c.getGuid());
        this.f41006h = 0;
        this.f41007i = 0;
        this.f41008j = 0;
        this.f41009k = 0;
        this.f41010l = 0;
        this.f41011m = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        this.f41000b = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        this.f41009k = 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean d() {
        return this.f40999a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e() {
        if (!mIsAuthorized) {
            this.f41004f = 1;
            String c16 = c(1);
            this.f41016r++;
            a(new byte[0], c16);
            return;
        }
        this.f41004f = 6;
        String c17 = c(6);
        byte[] f16 = f();
        this.f41017s++;
        a(f16, c17);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a0, code lost:
    
        if (r7.f41004f != 6) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a2, code lost:
    
        r1 = 0;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        int i3;
        String c16;
        byte[] f16;
        loop0: while (true) {
            i3 = 0;
            while (true) {
                if (!this.f41000b) {
                    int i16 = this.f41016r;
                    int i17 = this.f41015q;
                    if (i16 >= i17 || this.f41017s >= i17) {
                        break loop0;
                    }
                    if (!mIsAuthorized) {
                        this.f41004f = 1;
                        c16 = c(1);
                        f16 = new byte[0];
                        this.f41016r++;
                    } else {
                        this.f41004f = 6;
                        c16 = c(6);
                        f16 = f();
                        this.f41017s++;
                    }
                    LogTool.d(c16);
                    LogTool.d("post data length = " + f16.length + " seq = " + this.f41006h + " isEnd = " + this.f41008j + " post times = " + this.f41017s);
                    String a16 = a(c16, f16);
                    if (a16 == null) {
                        InfoRecognizer.f40975e.add(false, InfoRecognizer.f40973c.getNetType());
                        i3 = -201;
                    } else {
                        if (this.f41001c) {
                            InfoRecognizer.f40975e.clear();
                            this.f41001c = false;
                        }
                        InfoRecognizer.f40975e.add(true, InfoRecognizer.f40973c.getNetType());
                        i3 = a(a16, this.f41004f);
                        if (i3 == 0) {
                            break;
                        }
                        if (this.f41004f == 6 && i3 == 20105) {
                            mIsAuthorized = false;
                            mDeltaTime = ManagerDataStore.NULLNUM;
                            this.f41017s = 0;
                        }
                    }
                } else {
                    break loop0;
                }
            }
        }
        if (i3 != 0) {
            d(i3);
        } else {
            this.f40999a = false;
        }
    }

    private String c(int i3) {
        StringBuilder sb5 = new StringBuilder();
        if (!InfoRecognizer.f40984n) {
            sb5.append("http://" + InfoSender.Domain + InfoSender.Uri + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        }
        if (i3 == 1) {
            sb5.append("cmd=");
            sb5.append(i3);
            sb5.append("&appid=");
            sb5.append(InfoRecognizer.f40971a);
        }
        if (i3 == 6) {
            sb5.append("version=2.0");
            sb5.append("&cmd=");
            sb5.append(i3);
            sb5.append("&appid=");
            sb5.append(InfoRecognizer.f40971a);
            sb5.append("&voice_id=");
            sb5.append(this.f41005g);
            sb5.append("&os=");
            sb5.append(InfoRecognizer.f40973c.getOs());
            sb5.append("&sdk_src=0");
            sb5.append("&osver=");
            sb5.append(InfoRecognizer.f40973c.getOsver());
            sb5.append("&net=");
            sb5.append(InfoRecognizer.f40973c.getNetTypeNum());
            sb5.append("&sdk_ver=1.17");
            sb5.append("&voice_end=");
            sb5.append(this.f41008j);
            sb5.append("&encrypt_aes_mode=CBC");
            String str = InfoRecognizer.f40985o;
            if (str != null) {
                sb5.append(str);
            }
        }
        return sb5.toString();
    }

    private void d(int i3) {
        if (this.f41000b) {
            return;
        }
        InfoRecognizer.f40972b.b(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(int i3) {
        this.f41011m = i3;
    }

    private boolean b(JSONObject jSONObject) {
        int i3;
        try {
            if (jSONObject.has(QzoneCameraConst.Tag.ARG_PARAM_VOICE_ID) && !jSONObject.getString(QzoneCameraConst.Tag.ARG_PARAM_VOICE_ID).equals(this.f41005g)) {
                return false;
            }
            if (this.f41008j != 0 || !jSONObject.has("ack_offset") || (i3 = jSONObject.getInt("ack_offset")) > this.f41006h) {
                return true;
            }
            LogTool.d("seq = " + this.f41006h + " len = " + this.f41003e + " ack_offset = " + i3);
            return false;
        } catch (JSONException e16) {
            e16.printStackTrace();
            LogTool.d("json = " + jSONObject.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(byte[] bArr, int i3, int i16) {
        this.f41002d = bArr;
        this.f41003e = i3;
        int i17 = this.f41007i;
        this.f41006h = i17;
        this.f41007i = i17 + i3;
        this.f41008j = i16;
        this.f40999a = true;
        this.f41016r = 0;
        this.f41017s = 0;
    }

    private VoiceRecognizerResult c(JSONObject jSONObject) {
        VoiceRecognizerResult voiceRecognizerResult = new VoiceRecognizerResult(this.f41008j == 1);
        try {
            voiceRecognizerResult.httpRes = jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
        if (InfoRecognizer.f40986p) {
            voiceRecognizerResult.type = 1;
            return voiceRecognizerResult;
        }
        try {
            if (!jSONObject.has("res")) {
                return null;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("res");
            if (!jSONObject2.has("sentences")) {
                return null;
            }
            JSONArray jSONArray = jSONObject2.getJSONArray("sentences");
            int length = jSONArray.length();
            if (length > 0) {
                voiceRecognizerResult.words = new ArrayList();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                    if (jSONObject3 != null) {
                        VoiceRecognizerResult.Word word = new VoiceRecognizerResult.Word();
                        word.text = jSONObject3.getString("text");
                        if (jSONObject3.has("semantic")) {
                            word.semanticJsonObject = jSONObject3.getJSONObject("semantic");
                        }
                        voiceRecognizerResult.words.add(word);
                    }
                }
                if (!voiceRecognizerResult.words.isEmpty()) {
                    voiceRecognizerResult.text = ((VoiceRecognizerResult.Word) voiceRecognizerResult.words.get(0)).text;
                }
            }
            return voiceRecognizerResult;
        } catch (JSONException e17) {
            e17.printStackTrace();
            LogTool.d("json = " + jSONObject.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i3) {
        this.f41010l = i3;
    }

    private String a(String str, byte[] bArr) {
        String str2 = null;
        try {
            HttpPost httpPost = new HttpPost(str);
            httpPost.setEntity(new ByteArrayEntity(bArr));
            HttpResponse execute = this.f41012n.execute(httpPost);
            if (execute.getStatusLine().getStatusCode() != 200) {
                return null;
            }
            String str3 = new String(EntityUtils.toByteArray(execute.getEntity()), "UTF-8");
            try {
                LogTool.d(str3);
                return str3;
            } catch (Exception e16) {
                e = e16;
                str2 = str3;
                e.printStackTrace();
                return str2;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    private int a(String str, int i3) {
        try {
            JSONObject jSONObject = new JSONObject(str);
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
                    mIsAuthorized = true;
                    LogTool.d("mDeltaTime = " + mDeltaTime + " mIsAuthorized = " + mIsAuthorized);
                }
                if (i3 == 6) {
                    if (!b(jSONObject)) {
                        return -206;
                    }
                    int i17 = InfoHttp.f40969f;
                    if ((i17 == 0 && this.f41008j == 1) || i17 == 1) {
                        VoiceRecognizerResult c16 = c(jSONObject);
                        if (c16 == null) {
                            return -206;
                        }
                        if (!this.f41000b) {
                            if (InfoRecognizer.f40977g) {
                                c16.voiceRecordPCMData = InfoRecognizer.f40982l.toByteArray();
                            }
                            if (InfoRecognizer.f40977g) {
                                c16.voiceSpeexData = InfoRecognizer.f40983m.toByteArray();
                            }
                            c16.startTime = ((this.f41010l / 32.0d) - InfoRecorder.f40992f) / 1000.0d;
                            if (this.f41008j == 1) {
                                c16.stopTime = ((this.f41011m / 32.0d) - InfoRecorder.f40989c) / 1000.0d;
                            }
                            if (this.f41009k == 1) {
                                c16.isAllEnd = true;
                            }
                            InfoRecognizer.f40972b.a(c16);
                        }
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
    }

    private static boolean a(JSONObject jSONObject) {
        try {
            if (!jSONObject.has("timestamp")) {
                return false;
            }
            mDeltaTime = (System.currentTimeMillis() / 1000) - jSONObject.getLong("timestamp");
            InfoRecognizer.f40974d.setDeltaTime(mDeltaTime);
            return true;
        } catch (JSONException e16) {
            e16.printStackTrace();
            LogTool.d("json = " + jSONObject.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            str = null;
        }
        if (str == null) {
            InfoRecognizer.f40975e.add(false, InfoRecognizer.f40973c.getNetType());
            int i3 = this.f41004f;
            if (i3 == 1 && this.f41016r >= this.f41015q) {
                d(-201);
                return;
            } else if (i3 == 6 && this.f41017s >= this.f41015q) {
                d(-201);
                return;
            } else {
                e();
                return;
            }
        }
        if (this.f41001c) {
            InfoRecognizer.f40975e.clear();
            this.f41001c = false;
        }
        InfoRecognizer.f40975e.add(true, InfoRecognizer.f40973c.getNetType());
        int a16 = a(str, this.f41004f);
        if (a16 == 0) {
            int i16 = this.f41004f;
            if (i16 == 1) {
                e();
                return;
            } else {
                if (i16 == 6) {
                    this.f40999a = false;
                    return;
                }
                return;
            }
        }
        int i17 = this.f41004f;
        if (i17 == 6 && a16 == 20105) {
            mIsAuthorized = false;
            mDeltaTime = ManagerDataStore.NULLNUM;
            this.f41017s = 0;
            e();
            return;
        }
        if (i17 == 1 && this.f41016r >= this.f41015q) {
            d(a16);
        } else if (i17 == 6 && this.f41017s >= this.f41015q) {
            d(a16);
        } else {
            e();
        }
    }

    private void a(byte[] bArr, String str) {
        if (this.f41000b) {
            return;
        }
        InfoRecognizer.f40972b.a(bArr, str);
    }
}
