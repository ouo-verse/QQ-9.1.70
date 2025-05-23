package com.tencent.could.huiyansdk.utils;

import android.content.Context;
import com.tencent.could.huiyansdk.api.HuiYanSdk;
import com.tencent.could.huiyansdk.api.HuiYanSdkImp;
import com.tencent.could.huiyansdk.base.HuiYanBaseApi;
import com.tencent.could.huiyansdk.entity.CompareResult;
import com.tencent.could.huiyansdk.entity.HPCCompareResult;
import com.tencent.could.huiyansdk.entity.LiveTypeResult;
import com.tencent.could.huiyansdk.manager.d;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.operate.HuiYanOperateBody;
import com.tencent.could.huiyansdk.operate.c;
import com.tencent.mobileqq.R;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e {
    public static String a(Context context) {
        return System.getProperty("http.proxyHost");
    }

    public static int b(Context context) {
        try {
            return Integer.parseInt(System.getProperty("http.proxyPort"));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static boolean a(HPCCompareResult hPCCompareResult) {
        if (hPCCompareResult == null) {
            k.a.f100197a.a(2, "HuiYanSenderHelper", "get config error result is null!");
            return false;
        }
        if (hPCCompareResult.getErrorCode() == 0) {
            return true;
        }
        k.a.f100197a.a(2, "HuiYanSenderHelper", "get config error error code != 0");
        return false;
    }

    public static void b(String str) {
        d.b.f100161a.a("AuthCheckStage", "GetLiveTypeError", com.tencent.could.huiyansdk.manager.d.a(210L, str));
        com.tencent.could.huiyansdk.operate.c cVar = c.b.f100258a;
        cVar.a("GetLiveTypeDateUseTime", 2, true, str);
        HuiYanOperateBody huiYanOperateBody = cVar.f100252a;
        if (huiYanOperateBody != null) {
            huiYanOperateBody.updateInfo("GetLiveTypeData", 1, 0L, System.currentTimeMillis());
        }
    }

    public static void a(String str) {
        d.b.f100161a.a("AuthCheckStage", "GetLiveTypeError", com.tencent.could.huiyansdk.manager.d.a(210L, str));
        com.tencent.could.huiyansdk.operate.c cVar = c.b.f100258a;
        cVar.a("GetConfigDataUseTime", 2, true, str);
        HuiYanOperateBody huiYanOperateBody = cVar.f100252a;
        if (huiYanOperateBody != null) {
            huiYanOperateBody.updateInfo("GetConfigData", 1, 0L, System.currentTimeMillis());
        }
    }

    public static void a() {
        Context resContext = HuiYanSdkImp.getInstance().getResContext();
        if (resContext == null) {
            resContext = HuiYanBaseApi.b.f100031a.a();
        }
        HuiYanSdk.showErrorDialog(210, resContext.getString(R.string.txy_network_connect_error));
    }

    public static String a(LiveTypeResult liveTypeResult) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorcode", 0);
        jSONObject.put("type", 2);
        jSONObject.put("data", "0");
        jSONObject.put("errormsg", "OK");
        jSONObject.put("action_data", liveTypeResult.getActionData());
        jSONObject.put("color_data", liveTypeResult.getColorData());
        jSONObject.put("select_data", new JSONObject(liveTypeResult.getSelectData()));
        return jSONObject.toString();
    }

    public static void a(int i3, int i16) {
        Context resContext = HuiYanSdkImp.getInstance().getResContext();
        if (resContext == null) {
            resContext = HuiYanBaseApi.b.f100031a.a();
        }
        String string = resContext.getString(i16);
        CompareResult compareResult = new CompareResult();
        compareResult.setErrorCode(i3);
        compareResult.setErrorMsg(string);
        HYPCommonUtils.doResultCallBackResult(compareResult);
        HuiYanSdkImp.getInstance().closeCurrentUi();
    }
}
