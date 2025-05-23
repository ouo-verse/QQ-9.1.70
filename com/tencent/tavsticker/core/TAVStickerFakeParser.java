package com.tencent.tavsticker.core;

import android.text.TextUtils;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavsticker.TAVStickerHelper;
import com.tencent.tavsticker.model.TAVStickerLayerInfo;
import com.tencent.tavsticker.model.TAVStickerLayerType;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes26.dex */
public class TAVStickerFakeParser {
    private static final String DURATION_TIME = "duration";
    private static final String ID = "id";
    private static final String IMAGE_EFFECTS = "imageEffects";
    private static final String JSON_FILE_NAME = "template.json";
    private static final String LAYER = "layer";
    private static final String LOOP = "loop";
    private static final String NAME = "name";
    private static final String SPEED = "speed";
    private static final String START_TIME = "start";
    private static final String TIME_EFFECTS = "timeEffects";
    private static final String USER_DATA = "userData";
    private static final String USER_DATA_TAG = "#userData";

    /* JADX WARN: Removed duplicated region for block: B:27:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<TAVStickerLayerInfo> fakeDataFromJson() {
        InputStream inputStream;
        Throwable th5;
        try {
            inputStream = TAVStickerHelper.getContext().getAssets().open("template.json");
        } catch (Exception e16) {
            e = e16;
            inputStream = null;
        } catch (Throwable th6) {
            inputStream = null;
            th5 = th6;
            if (inputStream != null) {
            }
            throw th5;
        }
        try {
            try {
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                List<TAVStickerLayerInfo> parse = parse(new String(bArr, "UTF-8"));
                try {
                    inputStream.close();
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                return parse;
            } catch (Throwable th7) {
                th5 = th7;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e18) {
                        e18.printStackTrace();
                    }
                }
                throw th5;
            }
        } catch (Exception e19) {
            e = e19;
            e.printStackTrace();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e26) {
                    e26.printStackTrace();
                }
            }
            return null;
        }
    }

    private static List<TAVStickerLayerInfo> parse(String str) throws JSONException {
        if (!TextUtils.isEmpty(str)) {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3).optJSONObject(LAYER);
                Object opt = optJSONObject.opt(TIME_EFFECTS);
                Object opt2 = optJSONObject.opt(IMAGE_EFFECTS);
                Object opt3 = optJSONObject.opt(USER_DATA);
                arrayList.add(new TAVStickerLayerInfo(0, TAVStickerLayerType.Image, CMTimeRange.CMTimeRangeInvalid, parseTimeEffects(opt), parseImageEffects(opt2), parseUserDataList(opt3)));
            }
            return arrayList;
        }
        return null;
    }

    private static List<TAVStickerLayerInfo.TAVStickerImageEffect> parseImageEffects(Object obj) {
        ArrayList arrayList = new ArrayList();
        double d16 = 0.0d;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            float optDouble = (float) jSONObject.optDouble("start", 0.0d);
            float optDouble2 = (float) jSONObject.optDouble("duration", 0.0d);
            arrayList.add(new TAVStickerLayerInfo.TAVStickerImageEffect(new CMTimeRange(new CMTime(optDouble), new CMTime(optDouble2)), jSONObject.optString("id", ""), jSONObject.optString("name", "")));
        } else if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            int i3 = 0;
            while (i3 < length) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                float optDouble3 = (float) optJSONObject.optDouble("start", d16);
                float optDouble4 = (float) optJSONObject.optDouble("duration", d16);
                arrayList.add(new TAVStickerLayerInfo.TAVStickerImageEffect(new CMTimeRange(new CMTime(optDouble3), new CMTime(optDouble4)), optJSONObject.optString("id", ""), optJSONObject.optString("name", "")));
                i3++;
                d16 = 0.0d;
            }
        }
        return arrayList;
    }

    private static List<TAVStickerLayerInfo.TAVStickerTimeEffect> parseTimeEffects(Object obj) {
        ArrayList arrayList = new ArrayList();
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            arrayList.add(new TAVStickerLayerInfo.TAVStickerTimeEffect(new CMTimeRange(new CMTime((float) jSONObject.optDouble("start", 0.0d)), new CMTime((float) jSONObject.optDouble("duration", 0.0d))), CMTimeRange.CMTimeRangeInvalid, false));
        } else if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                arrayList.add(new TAVStickerLayerInfo.TAVStickerTimeEffect(new CMTimeRange(new CMTime((float) optJSONObject.optDouble("start", 0.0d)), new CMTime((float) optJSONObject.optDouble("duration", 0.0d))), CMTimeRange.CMTimeRangeInvalid, false));
            }
        }
        return arrayList;
    }

    private static List<TAVStickerLayerInfo.TAVStickerUserData> parseUserDataList(Object obj) {
        ArrayList arrayList = new ArrayList();
        if (obj instanceof JSONObject) {
            arrayList.add(new TAVStickerLayerInfo.TAVStickerUserData(CMTimeRange.CMTimeRangeInvalid, "#userData\r" + ((JSONObject) obj).toString()));
        } else if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                arrayList.add(new TAVStickerLayerInfo.TAVStickerUserData(CMTimeRange.CMTimeRangeInvalid, "#userData\r" + optJSONObject.toString()));
            }
        }
        return arrayList;
    }
}
