package com.tencent.autotemplate.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.tencent.autotemplate.parse.RhythmDataBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/* compiled from: P */
/* loaded from: classes3.dex */
public class JsonUtils {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_BGM = "bgm";
    public static final String KEY_EFFECTS = "effects";
    public static final String KEY_FILTERS = "filters";
    public static final String KEY_FONTS = "fonts";
    public static final String KEY_IMAGE_DURATIONS = "imageDurations";
    public static final String KEY_OVERLAYS = "overlays";
    public static final String KEY_TRANSITIONS = "transitions";
    public static final String KEY_VOLUME_EFFECTS = "volumeEffects";
    public static final String TAG = "JsonUtils";

    public JsonUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void confirmValueIsArray(JsonObject jsonObject, String str) {
        JsonElement jsonElement;
        if (jsonObject == null || str == null || (jsonElement = jsonObject.get(str)) == null || jsonElement.isJsonArray()) {
            return;
        }
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(jsonElement);
        jsonObject.remove(str);
        jsonObject.add(str, jsonArray);
    }

    public static String encodeObjectToJsonString(Object obj) {
        if (obj == null) {
            return null;
        }
        return new GsonBuilder().create().toJson(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x009b A[Catch: IOException -> 0x0097, TRY_LEAVE, TryCatch #0 {IOException -> 0x0097, blocks: (B:58:0x0093, B:51:0x009b), top: B:57:0x0093 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String loadJsonString(Context context, String str) {
        InputStream inputStream;
        BufferedReader bufferedReader;
        InputStream fileInputStream;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3 = null;
        try {
            if (str.startsWith("assets://") && context != null) {
                fileInputStream = context.getAssets().open(str.substring(9));
            } else {
                fileInputStream = new FileInputStream(str);
            }
            if (fileInputStream == null) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                }
                return null;
            }
            try {
                bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream, Charset.forName("UTF-8")));
            } catch (IOException e17) {
                bufferedReader = null;
                inputStream = fileInputStream;
                e = e17;
            } catch (Throwable th5) {
                inputStream = fileInputStream;
                th = th5;
            }
            try {
                StringBuilder sb5 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb5.append(readLine);
                }
                String sb6 = sb5.toString();
                try {
                    bufferedReader2.close();
                    fileInputStream.close();
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
                return sb6;
            } catch (IOException e19) {
                inputStream = fileInputStream;
                e = e19;
                bufferedReader = bufferedReader2;
                try {
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e26) {
                            e26.printStackTrace();
                            return null;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return null;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedReader3 = bufferedReader;
                    if (bufferedReader3 != null) {
                        try {
                            bufferedReader3.close();
                        } catch (IOException e27) {
                            e27.printStackTrace();
                            throw th;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th7) {
                inputStream = fileInputStream;
                th = th7;
                bufferedReader3 = bufferedReader2;
                if (bufferedReader3 != null) {
                }
                if (inputStream != null) {
                }
                throw th;
            }
        } catch (IOException e28) {
            e = e28;
            inputStream = null;
            bufferedReader = null;
        } catch (Throwable th8) {
            th = th8;
            inputStream = null;
        }
    }

    public static Object parseObjectFromFile(Context context, String str, Class cls) {
        String loadJsonString = loadJsonString(context, str);
        if (loadJsonString != null && !TextUtils.isEmpty(loadJsonString)) {
            JsonObject asJsonObject = new JsonParser().parse(loadJsonString).getAsJsonObject();
            confirmValueIsArray(asJsonObject, "fonts");
            confirmValueIsArray(asJsonObject, KEY_IMAGE_DURATIONS);
            confirmValueIsArray(asJsonObject, KEY_VOLUME_EFFECTS);
            confirmValueIsArray(asJsonObject, KEY_TRANSITIONS);
            JsonElement jsonElement = asJsonObject.get(KEY_BGM);
            if (jsonElement != null && jsonElement.isJsonObject()) {
                confirmValueIsArray(jsonElement.getAsJsonObject(), KEY_VOLUME_EFFECTS);
                asJsonObject.remove(KEY_BGM);
                asJsonObject.add(KEY_BGM, jsonElement);
            }
            JsonElement jsonElement2 = asJsonObject.get(KEY_EFFECTS);
            if (jsonElement2 != null && jsonElement2.isJsonObject()) {
                confirmValueIsArray(jsonElement2.getAsJsonObject(), "filters");
                confirmValueIsArray(jsonElement2.getAsJsonObject(), KEY_OVERLAYS);
                asJsonObject.remove(KEY_EFFECTS);
                asJsonObject.add(KEY_EFFECTS, jsonElement2);
            }
            try {
                return new GsonBuilder().create().fromJson(asJsonObject.toString(), cls);
            } catch (JsonSyntaxException e16) {
                e16.printStackTrace();
                return null;
            }
        }
        Log.e(TAG, "parseObjectFromFile: get json string failed");
        return null;
    }

    public static Object parseObjectFromJsonString(String str, Class cls) {
        try {
            return new GsonBuilder().create().fromJson(str, cls);
        } catch (JsonSyntaxException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static RhythmDataBean parseRhythmTemplate(Context context, String str) {
        String loadJsonString = loadJsonString(context, str);
        if (loadJsonString != null && !TextUtils.isEmpty(loadJsonString)) {
            try {
                return (RhythmDataBean) new GsonBuilder().create().fromJson(loadJsonString, RhythmDataBean.class);
            } catch (JsonSyntaxException e16) {
                e16.printStackTrace();
                return null;
            }
        }
        Log.e(TAG, "parseObjectFromFile: get json string failed");
        return null;
    }
}
