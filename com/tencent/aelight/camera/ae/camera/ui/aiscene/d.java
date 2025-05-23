package com.tencent.aelight.camera.ae.camera.ui.aiscene;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.ae.camera.ui.aiscene.c;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d implements c {

    /* renamed from: b, reason: collision with root package name */
    private static final Double f62437b = Double.valueOf(0.005d);

    /* renamed from: c, reason: collision with root package name */
    private static final Double f62438c = Double.valueOf(0.01d);

    /* renamed from: d, reason: collision with root package name */
    private static final Double f62439d = Double.valueOf(0.35d);

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f62440a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f62441a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f62442b = false;

        /* renamed from: c, reason: collision with root package name */
        public double f62443c = 0.0d;

        a() {
        }
    }

    private a b(Bitmap bitmap, ArrayList<c.a> arrayList) {
        a aVar = new a();
        if (bitmap != null && arrayList != null) {
            double width = bitmap.getWidth() * bitmap.getHeight();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                c.a aVar2 = arrayList.get(i3);
                double d16 = aVar.f62443c + ((aVar2.f62436b * aVar2.f62435a) / width);
                aVar.f62443c = d16;
                if (d16 > f62437b.doubleValue()) {
                    aVar.f62441a = true;
                }
            }
            if (arrayList.size() > 1 && aVar.f62443c > f62438c.doubleValue()) {
                aVar.f62442b = true;
            }
        }
        return aVar;
    }

    private ps.c c(JSONArray jSONArray) {
        ps.c cVar = new ps.c();
        if (jSONArray.length() > 0) {
            double d16 = -1.0d;
            double d17 = -1.0d;
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                String optString = optJSONObject.optString("label");
                double optDouble = optJSONObject.optDouble("confidence");
                ps.c d18 = d(optString);
                if (d18 != null && d18.f427073b != -1) {
                    if (d18.f427072a == 3 && optDouble > f62439d.doubleValue() && optDouble > d16) {
                        cVar = d18;
                        d16 = optDouble;
                    }
                    if (optDouble > d17 && d16 <= 0.0d) {
                        cVar = d18;
                        d17 = optDouble;
                    }
                }
            }
        }
        return cVar;
    }

    private String f(String str) {
        int length = str.length();
        int i3 = length / 2;
        return e(str.substring(i3, ((int) (length * 0.1d)) + i3) + "9996ef4aa4fb4378826bc1f1a8409dd7");
    }

    private JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            return new JSONObject(FileUtils.readStringFromAsset("video_story_aiSceneParams.json"));
        } catch (Exception e16) {
            e16.printStackTrace();
            return jSONObject;
        }
    }

    private JSONObject h(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("raw_base64", str);
            jSONObject2.put("only_gender", 0);
            jSONObject2.put("token", f(str));
            return b.b("https://tu.qq.com/cgi-bin/qq/get_face_detail.fcg", jSONObject2.toString());
        } catch (Exception e16) {
            e16.printStackTrace();
            return jSONObject;
        }
    }

    private JSONObject i(String str) {
        String str2 = String.valueOf(System.currentTimeMillis() / 1000).hashCode() + "";
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("request_id", str2);
            jSONObject2.put("appid", "10301");
            jSONObject2.put("raw_base64", str);
            jSONObject2.put(QCircleAlphaUserReporter.KEY_USER, "PTU");
            jSONObject2.put("token", f(str));
            return b.b("https://tu.qq.com/cgi-bin/qq/do_image_classify.fcg", jSONObject2.toString());
        } catch (Exception e16) {
            e16.printStackTrace();
            return jSONObject;
        }
    }

    private String j(Bitmap bitmap, int i3) {
        if (Math.min(bitmap.getWidth(), bitmap.getHeight()) > i3) {
            Bitmap h16 = com.tencent.mobileqq.olympic.utils.a.h(bitmap, Math.min(r0, 720) / i3);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            h16.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            return com.tencent.aelight.camera.ae.camera.ui.aiscene.a.a(byteArrayOutputStream.toByteArray());
        }
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream2);
        return com.tencent.aelight.camera.ae.camera.ui.aiscene.a.a(byteArrayOutputStream2.toByteArray());
    }

    public String e(String str) {
        try {
            return String.format("%032x", new BigInteger(1, MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str.getBytes())));
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.aiscene.c
    public void a(Bitmap bitmap, ArrayList<c.a> arrayList, c.b bVar) {
        ps.c d16;
        if (bitmap != null && !bitmap.isRecycled()) {
            long currentTimeMillis = System.currentTimeMillis();
            ps.c cVar = new ps.c();
            a b16 = b(bitmap, arrayList);
            String j3 = j(bitmap, 256);
            if (b16.f62441a) {
                if (b16.f62442b) {
                    cVar = d(HardCodeUtil.qqStr(R.string.us9));
                } else {
                    JSONObject h16 = h(j3);
                    if (h16 != null && !h16.isNull("retcode")) {
                        if (h16.has("retcode") && h16.optInt("retcode") == 0) {
                            JSONObject optJSONObject = h16.optJSONObject("retdata");
                            int optInt = optJSONObject.optInt("age");
                            int optInt2 = optJSONObject.optInt("gender");
                            if (optInt <= 5) {
                                d16 = d(HardCodeUtil.qqStr(R.string.usb));
                            } else if (optInt2 < 50) {
                                d16 = d(HardCodeUtil.qqStr(R.string.us_));
                            } else {
                                d16 = d(HardCodeUtil.qqStr(R.string.us7));
                            }
                        } else {
                            d16 = d(HardCodeUtil.qqStr(R.string.usa));
                        }
                        cVar = d16;
                    } else {
                        bVar.onFail("network error");
                        b.a(System.currentTimeMillis() - currentTimeMillis, 1);
                        return;
                    }
                }
            } else {
                JSONObject i3 = i(j3);
                if (i3 != null && !i3.isNull("retcode")) {
                    if (i3.has("retcode") && i3.optInt("retcode") == 0) {
                        JSONObject optJSONObject2 = i3.optJSONObject("retdata");
                        if (optJSONObject2.has("message") && optJSONObject2.optString("message").equals(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS)) {
                            cVar = c(optJSONObject2.optJSONObject("data").optJSONArray(ComicCancelRedPointPopItemData.JSON_KEY_TAGS));
                        }
                    }
                } else {
                    bVar.onFail("network error");
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    b.a(currentTimeMillis2, 1);
                    VSReporter.q("record_smart_filter", VSReporter.e(1L, currentTimeMillis2));
                    return;
                }
            }
            if (cVar == null) {
                bVar.onFail("unknown error");
                b.a(System.currentTimeMillis() - currentTimeMillis, 1);
                return;
            } else {
                bVar.a(cVar);
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                b.a(currentTimeMillis3, 0);
                VSReporter.q("record_smart_filter", VSReporter.e(0L, currentTimeMillis3));
                return;
            }
        }
        bVar.onFail("image is null");
    }

    private ps.c d(String str) {
        ps.c cVar = new ps.c();
        if (str == null) {
            return null;
        }
        if (this.f62440a == null) {
            JSONObject g16 = g();
            this.f62440a = g16;
            if (g16 == null) {
                return null;
            }
        }
        JSONArray optJSONArray = this.f62440a.optJSONArray("sceneList");
        int i3 = 0;
        while (i3 < optJSONArray.length()) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("sceneLvTwoList");
            int i16 = 0;
            while (true) {
                if (i16 < optJSONArray2.length()) {
                    JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i16);
                    if (optJSONObject2.optString("sceneName").equals(str)) {
                        cVar.f427072a = optJSONObject.optInt("sceneLvOne");
                        cVar.f427073b = optJSONObject2.optInt("sceneLvTwo");
                        cVar.f427074c = optJSONObject2.optString("sceneName");
                        cVar.f427075d = optJSONObject2.optString("sceneFilterID");
                        cVar.f427076e = optJSONObject2.optDouble("sceneFilterPercent");
                        cVar.f427077f = optJSONObject2.optString("sceneFilterIDForV7");
                        cVar.f427078g = optJSONObject2.optDouble("sceneFilterPercentV7");
                        break;
                    }
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("sceneLabels");
                    JSONArray jSONArray = optJSONArray;
                    int length = optJSONArray3.length();
                    JSONArray jSONArray2 = optJSONArray2;
                    String[] strArr = new String[length];
                    int i17 = i3;
                    int i18 = i16;
                    for (int i19 = 0; i19 < optJSONArray3.length(); i19++) {
                        strArr[i19] = optJSONArray3.optString(i19);
                    }
                    int i26 = 0;
                    while (true) {
                        if (i26 >= length) {
                            break;
                        }
                        if (strArr[i26].equals(str)) {
                            cVar.f427072a = optJSONObject.optInt("sceneLvOne");
                            cVar.f427073b = optJSONObject2.optInt("sceneLvTwo");
                            cVar.f427074c = optJSONObject2.optString("sceneName");
                            cVar.f427075d = optJSONObject2.optString("sceneFilterID");
                            cVar.f427076e = optJSONObject2.optDouble("sceneFilterPercent");
                            cVar.f427077f = optJSONObject2.optString("sceneFilterIDForV7");
                            cVar.f427078g = optJSONObject2.optDouble("sceneFilterPercentV7");
                            break;
                        }
                        i26++;
                    }
                    i16 = i18 + 1;
                    optJSONArray = jSONArray;
                    optJSONArray2 = jSONArray2;
                    i3 = i17;
                }
            }
            i3++;
            optJSONArray = optJSONArray;
        }
        return cVar;
    }
}
