package com.tencent.mobileqq.dating;

import android.text.TextUtils;
import appoint.define.appoint_define$RichText;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f203432a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71479);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f203432a = Pattern.compile("\\{\\{(.\\d+):(.\\d?)\\}\\}", 2);
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.indexOf("/") == -1) {
            return str;
        }
        int i3 = 0;
        while (true) {
            try {
                String[] strArr = EmotcationConstants.SYS_EMOTICON_SYMBOL;
                if (i3 >= strArr.length) {
                    break;
                }
                if (str.indexOf((char) 20 + strArr[i3]) != -1) {
                    str = str.replace((char) 20 + strArr[i3], "\u0014" + ((char) i3));
                }
                i3++;
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("TextUtils:");
                    int i16 = 200;
                    if (str.length() <= 200) {
                        i16 = str.length() - 1;
                    }
                    sb5.append(str.substring(0, i16));
                    QLog.e("Q..msgbox.util", 2, sb5.toString());
                }
            }
        }
        int i17 = 0;
        while (true) {
            String[] strArr2 = EmotcationConstants.SYS_EMOTICON_SYMBOL;
            if (i17 >= strArr2.length) {
                break;
            }
            if (str.indexOf(strArr2[i17]) != -1) {
                str = str.replace(strArr2[i17], "\u0014" + ((char) i17));
            }
            i17++;
        }
        return str;
    }

    public static QQText b(appoint_define$RichText appoint_define_richtext) {
        return c(appoint_define_richtext, 16);
    }

    public static QQText c(appoint_define$RichText appoint_define_richtext, int i3) {
        return d(com.tencent.mobileqq.freshnews.a.a(appoint_define_richtext), i3);
    }

    public static QQText d(String str, int i3) {
        return new QQText(str, 5, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0129 A[LOOP:0: B:16:0x0123->B:18:0x0129, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e(String str) {
        String str2;
        Matcher matcher;
        if (str == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            str2 = jSONObject.optString("content");
            try {
                if (jSONObject.has("audio_list")) {
                    if (jSONObject.optJSONArray("audio_list").length() > 0) {
                        str2 = str2 + HardCodeUtil.qqStr(R.string.f172200oa1);
                    }
                } else if (jSONObject.has("video_list")) {
                    if (jSONObject.optJSONArray("video_list").length() > 0) {
                        str2 = str2 + HardCodeUtil.qqStr(R.string.f172201oa2);
                    }
                } else if (jSONObject.has("pic_list")) {
                    if (jSONObject.optJSONArray("pic_list").length() > 0) {
                        str2 = str2 + HardCodeUtil.qqStr(R.string.f172199oa0);
                    }
                } else if (jSONObject.has("post_array")) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("post_array");
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        String optString = optJSONArray.optJSONObject(i3).optString("type");
                        if (!TextUtils.isEmpty(optString)) {
                            if (optString.equals("qqmusic")) {
                                str2 = str2 + HardCodeUtil.qqStr(R.string.o_y);
                            } else if (optString.equals("audio")) {
                                str2 = str2 + HardCodeUtil.qqStr(R.string.o_z);
                            }
                        }
                    }
                }
            } catch (JSONException unused) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q..msgbox.util", 2, "getTribeJsonContent content:" + str);
                }
                matcher = f203432a.matcher(str2);
                while (matcher.find()) {
                }
                return str2;
            }
        } catch (JSONException unused2) {
            str2 = str;
        }
        matcher = f203432a.matcher(str2);
        while (matcher.find()) {
            str2 = str2.replace(matcher.group(0), matcher.group(1));
        }
        return str2;
    }

    public static boolean f(MessageRecord messageRecord) {
        boolean z16;
        AbsStructMsg absStructMsg;
        if (messageRecord == null) {
            return false;
        }
        if ((messageRecord instanceof MessageForStructing) && (absStructMsg = ((MessageForStructing) messageRecord).structingMsg) != null && absStructMsg.mMsgServiceID == 98) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && messageRecord.msgtype != -2070) {
            return false;
        }
        return true;
    }

    public static boolean g(int i3, String str) {
        if (i3 == -2053 && !str.equals(String.valueOf(AppConstants.NOW_LIVE_TIP_UIN_BASE + 1822701914)) && !str.equals("1822701914")) {
            return true;
        }
        return false;
    }

    public static boolean h() {
        return "0".equals(BaseApplication.getContext().getSharedPreferences("nearby_callback", 4).getString(AppConstants.Preferences.NEARBY_SETTINGS_GREETINGS_RECEIVE, "0"));
    }

    public static boolean i(int i3, int i16, boolean z16, String str) {
        if ((!h() || i3 != 1001 || g(i16, str)) && !z16) {
            return true;
        }
        return false;
    }

    public static boolean j(MessageRecord messageRecord) {
        return i(messageRecord.istroop, messageRecord.msgtype, f(messageRecord), messageRecord.senderuin);
    }
}
