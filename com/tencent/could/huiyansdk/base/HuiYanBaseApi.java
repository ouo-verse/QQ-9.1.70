package com.tencent.could.huiyansdk.base;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.could.component.common.ai.log.AiLog;
import com.tencent.could.component.common.ai.log.AiLogConfig;
import com.tencent.could.component.common.ai.log.AiLogger;
import com.tencent.could.huiyansdk.common.a;
import com.tencent.could.huiyansdk.entity.HuiYanBaseConfig;
import com.tencent.could.huiyansdk.enums.HuiYanLiveMode;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.utils.l;
import com.tencent.could.huiyansdk.utils.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class HuiYanBaseApi {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public WeakReference<Context> f100027a;

    /* renamed from: b, reason: collision with root package name */
    public HuiYanBaseCallBack f100028b;

    /* renamed from: c, reason: collision with root package name */
    public HuiYanBaseConfig f100029c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f100030d;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final HuiYanBaseApi f100031a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16921);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f100031a = new HuiYanBaseApi(null);
            }
        }
    }

    public /* synthetic */ HuiYanBaseApi(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
    }

    public final void a(Context context) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
            return;
        }
        this.f100027a = new WeakReference<>(context.getApplicationContext());
        Context a16 = b.f100031a.a();
        this.f100030d = a16 == null ? false : m.a(a16, m.f100311b);
        l lVar = l.a.f100309a;
        if (!lVar.f100308b) {
            lVar.f100308b = true;
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(externalFilesDir);
                String str2 = File.separator;
                sb5.append(str2);
                sb5.append("cloud-huiyan");
                sb5.append(str2);
                sb5.append("log");
                str = sb5.toString();
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(context.getFilesDir());
                String str3 = File.separator;
                sb6.append(str3);
                sb6.append("cloud-huiyan");
                sb6.append(str3);
                sb6.append("log");
                str = sb6.toString();
            }
            AiLog.init(new AiLogger(context, new AiLogConfig.AiLogConfigBuilder().setDirLog(str).setLogCat(true).setLogName("huiyan-log").setMinLevel(3).setDefaultTag("[hy-sdk-log]").setOpen(true).setFileOutTime(259200000L).create()));
        }
        k.a.f100197a.a(1, "HuiYanBaseApi", "call huiyan init");
        a.C1019a.f100038a.f100033b = "v1.0.9.31";
    }

    public HuiYanLiveMode b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HuiYanLiveMode) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        HuiYanBaseConfig huiYanBaseConfig = this.f100029c;
        if (huiYanBaseConfig == null) {
            return HuiYanLiveMode.ACTION_REFLECT_MODE;
        }
        return huiYanBaseConfig.getHuiYanLiveMode();
    }

    HuiYanBaseApi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f100030d = false;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public Context a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Context) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        WeakReference<Context> weakReference = this.f100027a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
