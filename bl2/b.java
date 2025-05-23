package bl2;

import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.hb.HbInfo;
import com.tencent.mobileqq.qwallet.hb.panel.RedPacketManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    public static int a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.replaceAll("[\\u4e00-\\u9fa5]", "aa").length() - str.length();
        }
        return 0;
    }

    public static String b(int i3, HbInfo.a aVar, String str) {
        int i16 = 2;
        if (aVar != null) {
            i16 = x05.c.j(aVar.bus_type, 2);
            if (!StringUtil.isEmpty(aVar.biz_params)) {
                try {
                    String optString = new JSONObject(aVar.biz_params).optString("memo", "");
                    if (a(optString) >= 18) {
                        optString = optString.substring(0, 18) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                    }
                    if (!StringUtil.isEmpty(optString)) {
                        return optString;
                    }
                } catch (Exception e16) {
                    QLog.e("HbBusiUtils", 1, "error msg in qqpay-impl module: ", e16);
                }
            }
        }
        return d(i3, i16, str);
    }

    public static String c(EditText editText) {
        String charSequence;
        String obj = editText.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            CharSequence hint = editText.getHint();
            if (TextUtils.isEmpty(hint)) {
                charSequence = editText.getResources().getString(R.string.e8q);
            } else {
                charSequence = hint.toString();
            }
            return charSequence;
        }
        return obj;
    }

    private static String d(int i3, int i16, String str) {
        JSONObject f16 = RedPacketManager.f(HbInfo.b(i3, i16));
        if (f16 == null) {
            return str;
        }
        JSONArray optJSONArray = f16.optJSONArray("hints");
        QLog.i("HbBusiUtils", 2, "channel: " + i3 + ", hints array: " + optJSONArray);
        if (optJSONArray != null && optJSONArray.length() != 0) {
            return optJSONArray.optString(0, str);
        }
        return str;
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replaceAll("[\\u4e00-\\u9fa5,\uff0c\u3002\u3001 ]", "");
    }
}
