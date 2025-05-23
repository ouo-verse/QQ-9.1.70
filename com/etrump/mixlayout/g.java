package com.etrump.mixlayout;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.data.MessageForRichState;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class g {
    private int a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return 0;
        }
        int i3 = 12;
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("records");
            int length = jSONArray.length();
            i3 = (length * 8) + 12;
            for (int i16 = 0; i16 < length; i16++) {
                i3 += jSONArray.getJSONObject(i16).getString("uuid").length() + 1;
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return i3;
    }

    public static long b(long j3) {
        if (j3 == 0) {
            return 0L;
        }
        return ETEngine.getInstance().native_CloneNativeSubstitutionConfig(j3);
    }

    public static long c(ETFont eTFont, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int a16 = new g().a(jSONObject);
            int i3 = 12;
            if (a16 < 12) {
                return 0L;
            }
            byte[] bArr = new byte[a16];
            int i16 = jSONObject.getInt("version");
            int i17 = jSONObject.getInt(MessageForRichState.SIGN_MSG_FONT_ID);
            if (i17 != eTFont.getId()) {
                return 0L;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("records");
            int length = jSONArray.length();
            f(bArr, 0, i16);
            f(bArr, 4, i17);
            f(bArr, 8, length);
            for (int i18 = 0; i18 < length; i18++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i18);
                int i19 = jSONObject2.getInt(TtmlNode.ATTR_TTS_ORIGIN);
                int i26 = jSONObject2.getInt("format");
                String string = jSONObject2.getString("uuid");
                int length2 = string.length();
                byte[] bytes = string.getBytes();
                f(bArr, i3, i26);
                int i27 = i3 + 4;
                f(bArr, i27, i19);
                int i28 = i27 + 4;
                for (int i29 = 0; i29 < length2; i29++) {
                    e(bArr, i28, bytes[i29]);
                    i28++;
                }
                e(bArr, i28, (byte) 0);
                i3 = i28 + 1;
            }
            return ETEngine.getInstance().native_CreateNativeSubstitutionConfig(eTFont, bArr);
        } catch (JSONException e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    public static void d(long j3) {
        if (0 != j3) {
            ETEngine.getInstance().native_DeleteNativeSubstitutionConfig(j3);
        }
    }

    private static void e(byte[] bArr, int i3, byte b16) {
        bArr[i3 + 0] = (byte) (b16 & 255);
    }

    private static void f(byte[] bArr, int i3, int i16) {
        bArr[i3 + 0] = (byte) ((i16 >> 24) & 255);
        bArr[i3 + 1] = (byte) ((i16 >> 16) & 255);
        bArr[i3 + 2] = (byte) ((i16 >> 8) & 255);
        bArr[i3 + 3] = (byte) (i16 & 255);
    }
}
