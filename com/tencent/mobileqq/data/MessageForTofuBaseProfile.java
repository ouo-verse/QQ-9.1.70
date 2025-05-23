package com.tencent.mobileqq.data;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class MessageForTofuBaseProfile extends ChatMessage {
    public String[] lines = new String[3];
    public int linesCnt = 0;

    public MessageForTofuBaseProfile() {
        this.msgtype = -7010;
        this.mNeedTimeStamp = false;
    }

    private String line(int i3, String str) {
        return "\u00b7 " + BaseApplicationImpl.getApplication().getResources().getString(i3) + "\uff1a" + str;
    }

    @NotNull
    private String parseLine(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("key_type", 0);
        String str = "";
        if (optInt != 20002) {
            if (optInt != 20011) {
                if (optInt != 20019) {
                    if (optInt != 24002) {
                        if (optInt != 24008) {
                            if (optInt != 27037) {
                                if (optInt != 27264) {
                                    if (optInt != 20031) {
                                        if (optInt != 20032) {
                                            return "";
                                        }
                                        return line(R.string.d28, jSONObject.optString("key_profile_location_desc", ""));
                                    }
                                    int optInt2 = jSONObject.optInt("key_profile_birthday", 0);
                                    return line(R.string.d0p, String.format(Locale.getDefault(), "%d-%d-%d", Integer.valueOf(((-65536) & optInt2) >>> 16), Integer.valueOf((65280 & optInt2) >>> 8), Integer.valueOf(optInt2 & 255)));
                                }
                                return line(R.string.d0r, jSONObject.optString("key_profile_education", ""));
                            }
                            int optInt3 = jSONObject.optInt("key_profile_occupation", -1);
                            String[] strArr = NearbyProfileUtil.f306397f;
                            if (optInt3 < strArr.length - 1 && optInt3 > 0) {
                                str = strArr[optInt3];
                            }
                            return line(R.string.d2y, str);
                        }
                        return line(R.string.f171191d11, jSONObject.optString("key_profile_company", ""));
                    }
                    return line(R.string.f171197d25, jSONObject.optString("key_profile_location_desc", ""));
                }
                return line(R.string.d2t, jSONObject.optString("key_profile_introduction", ""));
            }
            return line(R.string.d1x, jSONObject.optString("key_profile_email", ""));
        }
        return line(R.string.d2_, jSONObject.optString("key_profile_nickname", ""));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
    
        r8.linesCnt = r5 + 1;
     */
    @Override // com.tencent.mobileqq.data.ChatMessage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doParse() {
        try {
            JSONArray jSONArray = new JSONArray(this.f203106msg);
            int i3 = 0;
            while (true) {
                if (i3 >= jSONArray.length()) {
                    break;
                }
                int i16 = this.linesCnt;
                if (i16 >= 3) {
                    break;
                }
                String parseLine = parseLine(jSONArray.optJSONObject(i3));
                String[] strArr = this.lines;
                int i17 = this.linesCnt;
                strArr[i17] = parseLine;
                this.linesCnt = i17 + 1;
                i3++;
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.i("MessageForTofuBaseProfile", 2, "doParse JSONException", e16);
            }
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.i("MessageForTofuBaseProfile", 2, "doParse Exception", e17);
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("MessageForTofuBaseProfile", 4, "lineCnt=" + this.linesCnt + " doParse:" + this.f203106msg);
        }
        this.isread = true;
    }
}
