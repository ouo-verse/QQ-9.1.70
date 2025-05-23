package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.structmsg.view.y;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static WeakReference<String> f290401a;

    /* renamed from: b, reason: collision with root package name */
    private static WeakReference<String[]> f290402b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75476);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f290401a = null;
            f290402b = null;
        }
    }

    public static boolean a(AbsShareMsg absShareMsg) {
        List<AbsStructMsgElement> structMsgItemLists;
        ArrayList<AbsStructMsgElement> arrayList;
        if ((absShareMsg instanceof StructMsgForGeneralShare) && (structMsgItemLists = ((StructMsgForGeneralShare) absShareMsg).getStructMsgItemLists()) != null) {
            for (int i3 = 0; i3 < structMsgItemLists.size(); i3++) {
                AbsStructMsgElement absStructMsgElement = structMsgItemLists.get(i3);
                if ((absStructMsgElement instanceof y) && (arrayList = ((y) absStructMsgElement).U0) != null) {
                    for (int i16 = 0; i16 < arrayList.size(); i16++) {
                        if (arrayList.get(i16) instanceof StructMsgItemVideo) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static String b(String str) {
        try {
            String[] split = new URL(str).getHost().split("\\.");
            return split[split.length - 2] + "." + split[split.length - 1];
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0133  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(Context context, String str, String str2) {
        String b16;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8 = "";
        try {
            try {
                HttpResponse openRequest = HttpUtil.openRequest(context, String.format("https://cgi.connect.qq.com/qqconnectopen/get_urlinfoForQQV2?url=%2$s&uin=%1$s", str, URLEncoder.encode(str2)), null, "GET", null, null, 10000, 10000);
                if (openRequest != null && openRequest.getStatusLine().getStatusCode() == 200) {
                    str6 = HttpUtil.readHttpResponse(openRequest);
                } else {
                    str6 = null;
                }
            } catch (IOException e16) {
                e = e16;
            } catch (JSONException e17) {
                e = e17;
            } catch (Throwable th5) {
                th = th5;
                b16 = b(str2);
                if (!TextUtils.isEmpty(str8)) {
                }
                if (!TextUtils.isEmpty(b16)) {
                }
                throw th;
            }
            try {
                if (!TextUtils.isEmpty(str6)) {
                    str8 = new JSONObject(str6).getString("qsvideo");
                    if (TextUtils.isEmpty(str8) && QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("get video url fail:");
                        sb5.append(str2);
                        QLog.e("CGILoader", 2, sb5.toString());
                    }
                    String b17 = b(str2);
                    if (TextUtils.isEmpty(str8)) {
                        str7 = "0X8005F56";
                    } else {
                        str7 = "0X8005F55";
                    }
                    if (!TextUtils.isEmpty(b17)) {
                        ReportController.o(null, "CliOper", "", "", str7, str7, 0, 0, "", "", b17, "");
                    }
                    return str8;
                }
                throw new IOException();
            } catch (IOException e18) {
                e = e18;
                QLog.e("CGILoader", 1, "load video url from cgi fail", e);
                String b18 = b(str2);
                if (TextUtils.isEmpty(str8)) {
                    str5 = "0X8005F56";
                } else {
                    str5 = "0X8005F55";
                }
                if (!TextUtils.isEmpty(b18)) {
                    ReportController.o(null, "CliOper", "", "", str5, str5, 0, 0, "", "", b18, "");
                }
                return null;
            } catch (JSONException e19) {
                e = e19;
                QLog.e("CGILoader", 1, "load video url from cgi json fail", e);
                String b19 = b(str2);
                if (TextUtils.isEmpty(str8)) {
                    str4 = "0X8005F56";
                } else {
                    str4 = "0X8005F55";
                }
                if (!TextUtils.isEmpty(b19)) {
                    ReportController.o(null, "CliOper", "", "", str4, str4, 0, 0, "", "", b19, "");
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            b16 = b(str2);
            if (!TextUtils.isEmpty(str8)) {
                str3 = "0X8005F56";
            } else {
                str3 = "0X8005F55";
            }
            if (!TextUtils.isEmpty(b16)) {
                ReportController.o(null, "CliOper", "", "", str3, str3, 0, 0, "", "", b16, "");
            }
            throw th;
        }
    }

    public static int d(int i3) {
        if (i3 == 3000) {
            return 2;
        }
        if (i3 != 1) {
            return 1;
        }
        return 3;
    }

    public static boolean e(String str) {
        String featureValue;
        int length;
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        WeakReference<String> weakReference = f290401a;
        if (weakReference != null && weakReference.get() != null) {
            featureValue = f290401a.get();
        } else {
            featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.IsEnableVideoExtraction.name());
            f290401a = new WeakReference<>(featureValue);
        }
        if (!"1".equals(featureValue)) {
            return false;
        }
        WeakReference<String[]> weakReference2 = f290402b;
        if (weakReference2 != null && weakReference2.get() != null) {
            split = f290402b.get();
        } else {
            String featureValue2 = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.VideoWebsiteList.name());
            if (TextUtils.isEmpty(featureValue2)) {
                return false;
            }
            boolean startsWith = featureValue2.startsWith("{");
            if (featureValue2.endsWith("}")) {
                length = featureValue2.length() - 1;
            } else {
                length = featureValue2.length();
            }
            split = featureValue2.substring(startsWith ? 1 : 0, length).split("\\|");
            if (split != null && split.length != 0) {
                f290402b = new WeakReference<>(split);
            }
            return false;
        }
        if (split != null && split.length != 0) {
            for (String str2 : split) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
