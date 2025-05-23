package com.tencent.ttpic.videoshelf.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ttpic.baseutils.encrypt.MD5Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class HttpRequestUtils {
    private static String DEFAULT_FONTNAME = "default";
    private static final String TAG = "HttpRequestUtils";

    private String getToken(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("agreeStr", "9eZCXk4t9HCSFmO61h9WvIgww9zZMscE");
        hashMap.put("content", str);
        hashMap.put("font_name", str2);
        hashMap.entrySet().iterator();
        ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<String, String>>() { // from class: com.tencent.ttpic.videoshelf.ui.HttpRequestUtils.1
            @Override // java.util.Comparator
            public int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
                return entry.getKey().compareTo(entry2.getKey());
            }
        });
        String str3 = "";
        int i3 = 0;
        for (Map.Entry entry : arrayList) {
            if (i3 == 0) {
                str3 = str3 + ((String) entry.getKey()) + ContainerUtils.KEY_VALUE_DELIMITER + ((String) entry.getValue());
            } else {
                str3 = str3 + ContainerUtils.FIELD_DELIMITER + ((String) entry.getKey()) + ContainerUtils.KEY_VALUE_DELIMITER + ((String) entry.getValue());
            }
            i3++;
        }
        return MD5Util.GetMD5Code(str3);
    }

    private static boolean isValidFontName(String str) {
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        return false;
    }

    private String parseFontname(Context context, String str) {
        if (context == null) {
            return "";
        }
        String str2 = context.getFilesDir().getAbsolutePath() + File.separator + "temp.ttf";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        writeBytesToFile(context, Base64.decode(str, 0));
        return str2;
    }

    public static void writeBytesToFile(Context context, byte[] bArr) {
        FileOutputStream fileOutputStream;
        if (context == null) {
            return;
        }
        String str = context.getFilesDir().getAbsolutePath() + File.separator + "temp.ttf";
        if (bArr == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(new File(str));
            } catch (IOException unused) {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
            } catch (IOException unused2) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception unused4) {
        }
    }

    public JSONObject getJsonData(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = DEFAULT_FONTNAME;
                }
                jSONObject.put("font_name", str2);
                jSONObject.put("content", str);
                jSONObject.put("token", getToken(str, str2));
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String uploadText(Context context, String str, String str2, String str3) {
        JSONObject jsonData;
        if (context == null || TextUtils.isEmpty(str3)) {
            return "";
        }
        try {
            HttpPost httpPost = new HttpPost(str3);
            if (isValidFontName(str2)) {
                jsonData = getJsonData(str, str2);
            } else {
                jsonData = getJsonData(str, DEFAULT_FONTNAME);
            }
            httpPost.setEntity(new StringEntity(jsonData.toString(), "UTF-8"));
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            defaultHttpClient.getParams().setParameter("http.connection.timeout", 3000);
            defaultHttpClient.getParams().setParameter("http.socket.timeout", 3000);
            JSONObject jSONObject = new JSONObject(EntityUtils.toString(defaultHttpClient.execute(httpPost).getEntity()));
            if (!jSONObject.has("retcode")) {
                return "";
            }
            String obj = jSONObject.get("retcode").toString();
            Log.d(TAG, "ret: " + obj);
            if (Integer.parseInt(obj) != 0) {
                return "";
            }
            return parseFontname(context, jSONObject.getJSONObject("retdata").get("font_data").toString());
        } catch (IOException e16) {
            Log.w(TAG, "upload error = ", e16);
            return "";
        } catch (JSONException e17) {
            Log.w(TAG, "upload error = ", e17);
            return "";
        }
    }
}
