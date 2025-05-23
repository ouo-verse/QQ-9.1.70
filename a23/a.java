package a23;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.k;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$GeneralFlags;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {
    private static String a(QQAppInterface qQAppInterface) {
        if (qQAppInterface != null) {
            String currentNickname = qQAppInterface.getCurrentNickname();
            if (TextUtils.isEmpty(currentNickname)) {
                return "\u4eb2\u7231\u7684\u7528\u6237";
            }
            return currentNickname;
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SpannableString b(QQAppInterface qQAppInterface, Message message, boolean z16) {
        String str;
        String str2;
        String str3;
        String optString;
        String str4 = "";
        JSONObject jSONObject = message.mExJsonObject;
        if (jSONObject != null) {
            int i3 = 0;
            int i16 = -1;
            try {
                optString = jSONObject.optString(QQHealthReportApiImpl.REPORT_KEY_BYTES_OAC_MSG_EXTEND, "");
            } catch (JSONException unused) {
            }
            try {
                JSONObject jSONObject2 = new JSONObject(new JSONObject(optString).optString("sp_brief", ""));
                String optString2 = jSONObject2.optString("brief", null);
                try {
                    str2 = jSONObject2.optString("color", "#ff0000");
                    try {
                        if (TextUtils.isEmpty(optString2)) {
                            optString2 = null;
                        }
                        JSONObject optJSONObject = jSONObject2.optJSONObject(DownloaderConstant.KEY_RANGE);
                        if (optJSONObject != null) {
                            i16 = optJSONObject.optInt("location", -1);
                            i3 = optJSONObject.optInt("length", 0);
                        }
                        str3 = optString2;
                    } catch (JSONException unused2) {
                        str = optString2;
                        str4 = optString;
                        QLog.e(VasUtils.f307364a, 1, "json error:" + str4);
                        str3 = str;
                        int i17 = i3;
                        int i18 = i16;
                        String str5 = str2;
                        String a16 = a(qQAppInterface);
                        if (str3 != null) {
                        }
                        return null;
                    }
                } catch (JSONException unused3) {
                    str2 = null;
                }
            } catch (JSONException unused4) {
                str4 = optString;
                str = null;
                str2 = null;
                QLog.e(VasUtils.f307364a, 1, "json error:" + str4);
                str3 = str;
                int i172 = i3;
                int i182 = i16;
                String str52 = str2;
                String a162 = a(qQAppInterface);
                if (str3 != null) {
                }
                return null;
            }
            int i1722 = i3;
            int i1822 = i16;
            String str522 = str2;
            String a1622 = a(qQAppInterface);
            if (str3 != null) {
                return d(z16, str3, str522, i1822, i1722, a1622);
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005f, code lost:
    
        if (android.text.TextUtils.isEmpty(r7) != false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a0 A[Catch: UnsupportedEncodingException -> 0x00d8, TRY_LEAVE, TryCatch #0 {UnsupportedEncodingException -> 0x00d8, blocks: (B:23:0x008e, B:25:0x00a0), top: B:22:0x008e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] c(byte[] bArr, im_msg_body$GeneralFlags im_msg_body_generalflags, int i3) {
        String str;
        AppRuntime runtime;
        String str2;
        if (im_msg_body_generalflags != null && im_msg_body_generalflags.bytes_pb_reserve.has()) {
            generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
            try {
                generalflags_resvattr.mergeFrom(im_msg_body_generalflags.bytes_pb_reserve.get().toByteArray());
                if (generalflags_resvattr.bytes_oac_msg_extend.has()) {
                    String stringUtf8 = generalflags_resvattr.bytes_oac_msg_extend.get().toStringUtf8();
                    if (stringUtf8.contains("sp_brief")) {
                        JSONObject jSONObject = new JSONObject(new JSONObject(stringUtf8).optString("sp_brief", ""));
                        str = jSONObject.optString("title", jSONObject.optString("brief", null));
                        try {
                        } catch (Exception e16) {
                            e = e16;
                            QLog.e(VasUtils.f307364a, 1, e, new Object[0]);
                            if (str != null) {
                                runtime = BaseApplicationImpl.getApplication().getRuntime();
                                if (runtime instanceof QQAppInterface) {
                                }
                                try {
                                    str2 = new String(k.i(bArr, i3), "utf-8");
                                    if (str2.contains("<title>")) {
                                    }
                                } catch (UnsupportedEncodingException e17) {
                                    e17.printStackTrace();
                                }
                            }
                            return null;
                        }
                    }
                }
            } catch (Exception e18) {
                e = e18;
                str = null;
            }
        }
        str = null;
        if (str != null && bArr.length > 0) {
            runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                str = str.replace("[nick]", a((QQAppInterface) runtime));
            }
            str2 = new String(k.i(bArr, i3), "utf-8");
            if (str2.contains("<title>")) {
                QLog.i(VasUtils.f307364a, 1, "replacedXMLBuff to " + str);
                return str2.replaceFirst("<title>.*</title>", "<title>" + str + "</title>").getBytes();
            }
        }
        return null;
    }

    @NotNull
    private static SpannableString d(boolean z16, String str, String str2, int i3, int i16, String str3) {
        int indexOf = str.indexOf("[nick]");
        int length = str3.length() + indexOf;
        String replace = str.replace("[nick]", str3);
        if (indexOf > -1) {
            SpannableString spannableString = new SpannableString(replace);
            if (str2 != null && z16) {
                try {
                    spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(str2)), indexOf, length, 18);
                } catch (IllegalArgumentException e16) {
                    e16.printStackTrace();
                }
            }
            return spannableString;
        }
        if (z16 && i3 > -1 && i16 > 0) {
            try {
                if (!TextUtils.isEmpty(replace) && !TextUtils.isEmpty(str2)) {
                    SpannableString spannableString2 = new SpannableString(replace);
                    spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor(str2)), i3, i16, 33);
                    return spannableString2;
                }
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
        return new SpannableString(replace);
    }
}
