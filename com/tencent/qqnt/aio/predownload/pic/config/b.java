package com.tencent.qqnt.aio.predownload.pic.config;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pic.api.IAvifConfigApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.adapter.api.IAIOTofuApi;
import com.tencent.qqnt.aio.adapter.api.IDataLineConfigApi;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.UIConfig;
import com.tencent.qqnt.msg.f;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/aio/predownload/pic/config/b;", "", "", "g", "", "e", "d", "c", "f", "b", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f351799a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65581);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f351799a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h() {
        HashMap hashMap = new HashMap();
        UIConfig uIConfig = UIConfig.KAUTODOWNLOADPICCFG;
        b bVar = f351799a;
        hashMap.put(uIConfig, bVar.e());
        hashMap.put(UIConfig.KAIOPICCFG, bVar.d());
        hashMap.put(UIConfig.KGIFCFG, bVar.c());
        hashMap.put(UIConfig.KXGAUTODOWNLOADPIC, bVar.f());
        hashMap.put(UIConfig.KAVIFDOWNLOADCFG, bVar.b());
        UIConfig uIConfig2 = UIConfig.KDATALINEAUTODOWNLOADCFG;
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        hashMap.put(uIConfig2, ((IDataLineConfigApi) companion.a(IDataLineConfigApi.class)).getAutoDownload());
        hashMap.put(UIConfig.KTOFUCFG, ((IAIOTofuApi) companion.a(IAIOTofuApi.class)).getTofuConfig());
        if (QLog.isColorLevel()) {
            QLog.d("[NT][AIO_PRE_DOWNLOAD]PicPreDownloadConfig", 2, "[initConfig] " + hashMap);
        }
        IQQNTWrapperSession k3 = f.k();
        if (k3 != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) entry.getValue())) {
                    k3.onUIConfigUpdate((UIConfig) entry.getKey(), (String) entry.getValue());
                }
            }
        }
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return ((IAvifConfigApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAvifConfigApi.class)).getAvifConfigForNative();
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return FreesiaWrapperImpl.INSTANCE.b().loadConfigAsString("100311", "");
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return FreesiaWrapperImpl.INSTANCE.b().loadConfigAsString("100318", "");
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return FreesiaWrapperImpl.INSTANCE.b().loadConfigAsString("100276", "");
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        BaseApplication baseApplication = BaseApplication.context;
        boolean readValue = SettingCloneUtil.readValue((Context) baseApplication, (String) null, baseApplication.getString(R.string.czu), AppConstants.QQSETTING_AUTO_RECEIVE_PIC_KEY, true);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("xg_auto_download", readValue);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "configJSON.toString()");
        return jSONObject2;
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.predownload.pic.config.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.h();
                }
            }, 64, null, false);
        }
    }
}
