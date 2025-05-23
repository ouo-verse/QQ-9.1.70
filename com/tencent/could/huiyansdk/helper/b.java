package com.tencent.could.huiyansdk.helper;

import android.content.Context;
import com.tencent.could.huiyansdk.base.HuiYanBaseApi;
import com.tencent.could.huiyansdk.base.HuiYanBaseCallBack;
import com.tencent.could.huiyansdk.common.a;
import com.tencent.could.huiyansdk.exception.AuthException;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.utils.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.youtu.liveness.YTCommonInterface;
import com.tencent.youtu.sdkkitframework.common.FileUtils;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFrameworkTool;
import java.io.File;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public JSONObject f100120a;

    /* renamed from: b, reason: collision with root package name */
    public YtSDKKitFramework.IYtSDKKitNetResponseParser f100121b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f100122c;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final b f100123a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18487);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f100123a = new b();
            }
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f100122c = false;
        }
    }

    public final void b(final Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            q.a.f100321a.a(new Runnable() { // from class: com.tencent.could.huiyansdk.helper.c
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.a(context);
                }
            });
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
    }

    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        int ordinal = HuiYanBaseApi.b.f100031a.b().ordinal();
        return ordinal != 0 ? ordinal != 1 ? "action+reflect_settings" : "silent_settings" : "action_settings";
    }

    public final YtSDKKitFramework.YtSDKKitFrameworkWorkMode b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (YtSDKKitFramework.YtSDKKitFrameworkWorkMode) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        int ordinal = HuiYanBaseApi.b.f100031a.b().ordinal();
        if (ordinal == 0) {
            return YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTION_TYPE;
        }
        if (ordinal != 1) {
            return YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE;
        }
        return YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_SILENT_TYPE;
    }

    public static void a(String str, String str2) {
        k.a.f100197a.a(1, "YouTuSdkHelper", "YT_TAG: " + str + ", Msg: " + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        try {
            this.f100120a = new JSONObject(FileUtils.readAssetFile(context, "configs/TxyHyYtSDKSettings.json").toString()).getJSONObject("sdk_settings");
            Context a16 = HuiYanBaseApi.b.f100031a.a();
            if (a16 != null) {
                try {
                    b(QzoneCameraConst.Tag.ARG_PARAM_VIDEO_PATH, a16.getCacheDir().getCanonicalPath() + File.separator + "temp.mp4");
                } catch (IOException unused) {
                    k.a.f100197a.a(2, "YouTuSdkHelper", "failed to get cache path.");
                }
            }
            HuiYanBaseCallBack huiYanBaseCallBack = HuiYanBaseApi.b.f100031a.f100028b;
            if (huiYanBaseCallBack != null) {
                huiYanBaseCallBack.onYouTuConfigLoadSuccess();
            }
        } catch (JSONException unused2) {
            k.a.f100197a.a(2, "YouTuSdkHelper", "init youtu sdk config error!");
        }
    }

    public int b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).intValue();
        }
        Context a16 = HuiYanBaseApi.b.f100031a.a();
        if (a16 != null) {
            int initAuthByAssets = YTCommonInterface.initAuthByAssets(str, "");
            if (initAuthByAssets == 0) {
                b(a16);
                return initAuthByAssets;
            }
            throw new AuthException(211, "init youtu init auth return code : " + initAuthByAssets);
        }
        AuthException authException = new AuthException("init youtu with null context");
        authException.f100039a = 211;
        throw authException;
    }

    public void b(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (this.f100120a == null) {
            return;
        }
        String a16 = a();
        if (this.f100120a.has(a16)) {
            JSONObject jSONObject = this.f100120a.getJSONObject(a16);
            jSONObject.put(str, str2);
            this.f100120a.put(a16, jSONObject);
        }
    }

    public void a(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16));
            return;
        }
        if (this.f100120a == null) {
            return;
        }
        String a16 = a();
        if (this.f100120a.has(a16)) {
            JSONObject jSONObject = this.f100120a.getJSONObject(a16);
            jSONObject.put(str, z16);
            this.f100120a.put(a16, jSONObject);
        }
    }

    public void a(String str, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Float.valueOf(f16));
            return;
        }
        if (this.f100120a == null) {
            return;
        }
        String a16 = a();
        if (this.f100120a.has(a16)) {
            JSONObject jSONObject = this.f100120a.getJSONObject(a16);
            jSONObject.put(str, f16);
            this.f100120a.put(a16, jSONObject);
        }
    }

    public void a(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Long.valueOf(j3));
            return;
        }
        if (this.f100120a == null) {
            return;
        }
        String a16 = a();
        if (this.f100120a.has(a16)) {
            JSONObject jSONObject = this.f100120a.getJSONObject(a16);
            jSONObject.put(str, j3);
            this.f100120a.put(a16, jSONObject);
        }
    }

    public void a(String str, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) iArr);
            return;
        }
        if (this.f100120a == null) {
            return;
        }
        String a16 = a();
        if (!this.f100120a.has(a16) || iArr.length <= 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i3 : iArr) {
            jSONArray.put(i3);
        }
        JSONObject jSONObject = this.f100120a.getJSONObject(a16);
        jSONObject.put(str, jSONArray);
        this.f100120a.put(a16, jSONObject);
    }

    public final void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.has("event_id") ? jSONObject.getString("event_id") : "";
            if ("".equals(string)) {
                k.a.f100197a.a(2, "YouTuSdkHelper", "get a empty action");
                return;
            }
            int i3 = jSONObject.has("Done") ? jSONObject.getInt("Done") : 1;
            long j3 = jSONObject.has("value") ? jSONObject.getLong("value") : 0L;
            String string2 = jSONObject.has("info") ? jSONObject.getString("info") : "";
            HuiYanBaseCallBack huiYanBaseCallBack = HuiYanBaseApi.b.f100031a.f100028b;
            if (huiYanBaseCallBack != null) {
                huiYanBaseCallBack.updateOperateInfo(string, i3, j3, string2);
            }
        } catch (NullPointerException | JSONException e16) {
            k.a.f100197a.a(2, "YouTuSdkHelper", "decodeOperateInfo error: " + e16.getLocalizedMessage());
            e16.printStackTrace();
        }
    }

    public final int a(YtSDKKitFramework.YtSDKPlatformContext ytSDKPlatformContext, YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode, YtSDKKitFramework.IYtSDKKitFrameworkEventListener iYtSDKKitFrameworkEventListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, ytSDKPlatformContext, ytSDKKitFrameworkWorkMode, iYtSDKKitFrameworkEventListener)).intValue();
        }
        com.tencent.could.huiyansdk.common.a aVar = a.C1019a.f100038a;
        YtSDKKitFrameworkTool.setHuiYanVersion(aVar.f100033b);
        k kVar = k.a.f100197a;
        kVar.a(1, "YouTuSdkHelper", "[huiyan version]: " + aVar.f100033b);
        kVar.a(1, "YouTuSdkHelper", "[yt version]: " + YtSDKKitFramework.getInstance().version());
        if (aVar.f100037f) {
            YtLogger.setLogLevel(-1000);
        } else if (this.f100122c) {
            YtLogger.setLogLevel(4);
        } else {
            YtLogger.setLogLevel(0);
        }
        YtLogger.setLoggerListener(new YtLogger.IYtLoggerListener() { // from class: com.tencent.could.huiyansdk.helper.d
            @Override // com.tencent.youtu.sdkkitframework.common.YtLogger.IYtLoggerListener
            public final void log(String str, String str2) {
                b.a(str, str2);
            }
        });
        return YtSDKKitFramework.getInstance().init(ytSDKPlatformContext, YtSDKKitConfigHelper.getSDKConfig(ytSDKKitFrameworkWorkMode, this.f100120a), ytSDKKitFrameworkWorkMode, YtSDKKitConfigHelper.getPipleStateNames(ytSDKKitFrameworkWorkMode), iYtSDKKitFrameworkEventListener);
    }
}
