package com.etrump.mixlayout;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ETDIYConfig {

    /* renamed from: a, reason: collision with root package name */
    private static int f32602a = 32;

    /* compiled from: P */
    @Keep
    /* loaded from: classes2.dex */
    static class DiyFontJson {
        public int version = 65536;
        public int fontId = 0;
        public List<Record> records = new ArrayList();

        DiyFontJson() {
        }
    }

    /* compiled from: P */
    @Keep
    /* loaded from: classes2.dex */
    static class Record {
        public int origin = 0;
        public int format = 2;
        public String uuid = "";

        Record() {
        }
    }

    private int a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return 0;
        }
        try {
            jSONObject.getInt("version");
            jSONObject.getInt("font_id");
            int i3 = jSONObject.getInt("theme_style");
            int i16 = jSONObject.getInt("color_style");
            if (i3 >= 0 && i3 < 65535 && i16 >= 0 && i16 < 65535) {
                JSONArray jSONArray = jSONObject.getJSONArray("chars");
                int length = jSONArray.length();
                int i17 = (length * 8) + 32;
                if (length > 0) {
                    i17 += (length + 1) * 4;
                }
                return g(i17, jSONArray, length);
            }
            return 0;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    private boolean b(JSONObject jSONObject) throws JSONException {
        int i3 = jSONObject.getInt("unicode");
        int i16 = jSONObject.getInt("theme_style");
        int i17 = jSONObject.getInt("color_style");
        if (i3 < 19968 || i3 > 40869 || i16 < 0 || i16 >= 65535 || i17 < 0 || i17 >= 65535) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0072 A[Catch: JSONException -> 0x01b8, TRY_LEAVE, TryCatch #1 {JSONException -> 0x01b8, blocks: (B:3:0x000c, B:5:0x0020, B:7:0x002c, B:9:0x0036, B:10:0x003d, B:11:0x006e, B:13:0x0072), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0078 A[EDGE_INSN: B:15:0x0078->B:16:0x0078 BREAK  A[LOOP:0: B:11:0x006e->B:14:0x0074], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long c(ETFont eTFont, String str) {
        long j3;
        JSONArray jSONArray;
        int i3;
        int i16;
        int i17;
        String str2;
        int i18;
        String str3 = "theme_style";
        String str4 = "color_style";
        try {
            JSONObject jSONObject = new JSONObject(str);
            int a16 = new ETDIYConfig().a(jSONObject);
            if (a16 < f32602a) {
                return 0L;
            }
            byte[] bArr = new byte[a16];
            int[] iArr = new int[6];
            if (jSONObject.has("chars")) {
                jSONArray = jSONObject.getJSONArray("chars");
                if (jSONArray.length() > 0) {
                    i3 = jSONArray.length();
                    int i19 = jSONObject.getInt("version");
                    int i26 = jSONObject.getInt("font_id");
                    int i27 = jSONObject.getInt("color_style");
                    int i28 = jSONObject.getInt("theme_style");
                    h(bArr, 0, i19);
                    h(bArr, 4, i26);
                    i(bArr, 8, (short) i27);
                    i(bArr, 10, (short) i28);
                    i(bArr, 12, (short) i3);
                    i16 = 14;
                    while (true) {
                        i17 = f32602a;
                        if (i16 < i17) {
                            break;
                        }
                        bArr[i16] = 0;
                        i16 = i16 + 1 + 1;
                    }
                    if (i3 <= 0 && jSONArray != null) {
                        int i29 = i17 + (i3 * 8);
                        int i36 = ((i3 + 1) * 4) + i29;
                        if (i36 > a16) {
                            return 0L;
                        }
                        int i37 = 0;
                        int i38 = 0;
                        while (i37 < i3) {
                            try {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i37);
                                JSONArray jSONArray2 = jSONObject2.getJSONArray("components");
                                int i39 = jSONObject2.getInt("unicode");
                                int i46 = jSONObject2.getInt(str4);
                                int i47 = jSONObject2.getInt(str3);
                                if (jSONArray2.length() > 0) {
                                    str2 = str3;
                                    i18 = jSONArray2.length();
                                } else {
                                    str2 = str3;
                                    i18 = 0;
                                }
                                i(bArr, i16, (short) i39);
                                int i48 = i16 + 2;
                                i(bArr, i48, (short) i46);
                                int i49 = i48 + 2;
                                i(bArr, i49, (short) i47);
                                int i56 = i49 + 2;
                                i(bArr, i56, (short) i18);
                                i16 = i56 + 2;
                                h(bArr, i29, i38);
                                i29 += 4;
                                i38 += i18 * 26;
                                int i57 = 0;
                                while (i57 < i18) {
                                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i57);
                                    int i58 = jSONObject3.getInt(HippyQQConstants.URL_COMPONENT_NAME);
                                    int i59 = i18;
                                    String[] split = jSONObject3.getString("matrix").split(",");
                                    if (split != null) {
                                        String str5 = str4;
                                        if (split.length == 6) {
                                            iArr[0] = (int) (Float.parseFloat(split[0].trim()) * 65536.0f);
                                            iArr[1] = (int) (Float.parseFloat(split[1].trim()) * 65536.0f);
                                            iArr[2] = (int) (Float.parseFloat(split[2].trim()) * 65536.0f);
                                            iArr[3] = (int) (Float.parseFloat(split[3].trim()) * 65536.0f);
                                            iArr[4] = (int) (Float.parseFloat(split[4].trim()) * 64.0f);
                                            iArr[5] = (int) (Float.parseFloat(split[5].trim()) * 64.0f);
                                            if (i36 + 26 > a16) {
                                                return 0L;
                                            }
                                            i(bArr, i36, (short) i58);
                                            i36 += 2;
                                            for (int i65 = 0; i65 < 6; i65++) {
                                                h(bArr, i36, iArr[i65]);
                                                i36 += 4;
                                            }
                                            i57++;
                                            i18 = i59;
                                            str4 = str5;
                                        } else {
                                            return 0L;
                                        }
                                    } else {
                                        return 0L;
                                    }
                                }
                                i37++;
                                str3 = str2;
                                str4 = str4;
                            } catch (JSONException e16) {
                                e = e16;
                                j3 = 0;
                                QLog.e("ETDIYConfig", 1, "createNativeJsonHandle error: " + e.getMessage());
                                return j3;
                            }
                        }
                        j3 = 0;
                        try {
                            h(bArr, i29, i38);
                        } catch (JSONException e17) {
                            e = e17;
                            QLog.e("ETDIYConfig", 1, "createNativeJsonHandle error: " + e.getMessage());
                            return j3;
                        }
                    } else {
                        j3 = 0;
                    }
                    return ETEngine.getInstance().native_diyFontCreateNativeConfig(eTFont, bArr);
                }
            } else {
                jSONArray = null;
            }
            i3 = 0;
            int i192 = jSONObject.getInt("version");
            int i262 = jSONObject.getInt("font_id");
            int i272 = jSONObject.getInt("color_style");
            int i282 = jSONObject.getInt("theme_style");
            h(bArr, 0, i192);
            h(bArr, 4, i262);
            i(bArr, 8, (short) i272);
            i(bArr, 10, (short) i282);
            i(bArr, 12, (short) i3);
            i16 = 14;
            while (true) {
                i17 = f32602a;
                if (i16 < i17) {
                }
                i16 = i16 + 1 + 1;
            }
            if (i3 <= 0) {
            }
            j3 = 0;
            return ETEngine.getInstance().native_diyFontCreateNativeConfig(eTFont, bArr);
        } catch (JSONException e18) {
            e = e18;
            j3 = 0;
        }
    }

    public static void d(long j3) {
        if (0 != j3) {
            ETEngine.getInstance().native_diyFontDeleteNativeConfig(j3);
        }
    }

    public static String e(int i3, String str) {
        if (!TextUtils.isEmpty(str) && i3 != 0) {
            DiyFontJson diyFontJson = new DiyFontJson();
            diyFontJson.fontId = i3;
            diyFontJson.version = 65536;
            Record record = new Record();
            record.origin = 0;
            record.format = 2;
            record.uuid = str;
            diyFontJson.records.add(record);
            return new Gson().toJson(diyFontJson);
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    public static byte[] f(File file) {
        FileInputStream fileInputStream;
        ?? isFile = file.isFile();
        FileInputStream fileInputStream2 = null;
        try {
            if (isFile != 0) {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (IOException unused) {
                    fileInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e16) {
                            QLog.e("ETDIYConfig", 1, e16.getMessage());
                        }
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        fileInputStream.close();
                    } catch (IOException e17) {
                        QLog.e("ETDIYConfig", 1, e17.getMessage());
                    }
                    return byteArray;
                } catch (IOException unused2) {
                    QLog.e("ETDIYConfig", 1, " \u6587\u4ef6\u8bfb\u53d6\u9519\u8bef \uff1a" + file.getPath());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e18) {
                            QLog.e("ETDIYConfig", 1, e18.getMessage());
                        }
                    }
                    return null;
                }
            }
            QLog.e("ETDIYConfig", 1, " \u6587\u4ef6\u4e0d\u5b58\u5728 \uff1a" + file.getPath());
            return null;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = isFile;
        }
    }

    private static void h(byte[] bArr, int i3, int i16) {
        bArr[i3 + 0] = (byte) ((i16 >> 24) & 255);
        bArr[i3 + 1] = (byte) ((i16 >> 16) & 255);
        bArr[i3 + 2] = (byte) ((i16 >> 8) & 255);
        bArr[i3 + 3] = (byte) (i16 & 255);
    }

    private static void i(byte[] bArr, int i3, short s16) {
        bArr[i3 + 0] = (byte) ((s16 >> 8) & 255);
        bArr[i3 + 1] = (byte) (s16 & 255);
    }

    public int g(int i3, JSONArray jSONArray, int i16) throws JSONException {
        String[] split;
        for (int i17 = 0; i17 < i16; i17++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i17);
            if (b(jSONObject)) {
                return 0;
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray("components");
            int length = jSONArray2.length();
            for (int i18 = 0; i18 < length; i18++) {
                JSONObject jSONObject2 = jSONArray2.getJSONObject(i18);
                int i19 = jSONObject2.getInt(HippyQQConstants.URL_COMPONENT_NAME);
                if (i19 < 0 || i19 >= 65535 || (split = jSONObject2.getString("matrix").split(",")) == null || split.length != 6) {
                    return 0;
                }
                i3 += 26;
            }
        }
        return i3;
    }
}
