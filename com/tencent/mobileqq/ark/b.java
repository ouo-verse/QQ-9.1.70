package com.tencent.mobileqq.ark;

import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ark;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.api.INativeLibLoader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.cl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Deprecated
/* loaded from: classes11.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f199159a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f199160b = false;

    /* renamed from: c, reason: collision with root package name */
    public static String f199161c;

    /* renamed from: d, reason: collision with root package name */
    public static Map<String, List<c91.a>> f199162d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private static final List<String> f199163e = new ArrayList();

    public b() {
        d91.b arkAIKeyWordConfig = ((IArkConfig) QRoute.api(IArkConfig.class)).getArkAIKeyWordConfig();
        if (arkAIKeyWordConfig != null && arkAIKeyWordConfig.c() != null) {
            a(arkAIKeyWordConfig.c());
        }
    }

    public static void a(e91.i iVar) {
        String str;
        if (iVar == null) {
            QLog.i("ArkApp.AI", 1, String.format("updateDialogConfig,dialogConfig is null", new Object[0]));
            return;
        }
        if (((INativeLibLoader) QRoute.api(INativeLibLoader.class)).isArkLibraryLoaded()) {
            ark.SetUseAndroidHTTP(iVar.f395988b);
        }
        f199159a = iVar.f395989c;
        if (ArkEnvironmentManager.getInstance().isEGLSpecialDeviceLimited()) {
            f199159a = false;
            QLog.i("ArkApp.AI", 1, "EGLSpecialDeviceLimited. not support MultiThreadMode");
        }
        BaseApplication context = BaseApplication.getContext();
        if (f199159a) {
            str = "true";
        } else {
            str = "false";
        }
        cl.j(context, "ark_engine_multi_thread", str);
        f199161c = iVar.f395990d;
        if (((INativeLibLoader) QRoute.api(INativeLibLoader.class)).isArkLibraryLoaded()) {
            ArkEnvironmentManager.getInstance().setSingleThreadMode(!f199159a);
            ArkEnvironmentManager.getInstance().setThreadMode();
            try {
                ArkEnvironmentManager.getInstance().setHardwareDisableList(new JSONObject(f199161c));
            } catch (JSONException e16) {
                QLog.i("ArkApp.AI", 1, String.format("updateDialogConfig, parse json failed, err=%s", e16.getMessage()));
            }
        }
        f199160b = iVar.f395991e;
    }
}
