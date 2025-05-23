package com.tencent.tmdownloader.f.b;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.BatchReportConfig;
import com.tencent.tmassistant.common.jce.NewQqCenterConfig;
import com.tencent.tmassistant.common.jce.ShareUrlConfig;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.Settings;
import com.tencent.tmassistantbase.util.e;
import com.tencent.tmassistantbase.util.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static volatile b f380645c;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, JceStruct> f380646a;

    /* renamed from: b, reason: collision with root package name */
    private ShareUrlConfig f380647b;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f380648a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ byte[] f380649b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Class f380650c;

        a(String str, byte[] bArr, Class cls) {
            this.f380648a = str;
            this.f380649b = bArr;
            this.f380650c = cls;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, str, bArr, cls);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] bArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (!TextUtils.isEmpty(this.f380648a) && (bArr = this.f380649b) != null) {
                try {
                    JceStruct bytes2JceObj = ProtocolPackage.bytes2JceObj(bArr, this.f380650c);
                    if (bytes2JceObj != null) {
                        b.this.f380646a.put(this.f380648a, bytes2JceObj);
                        Settings.getInstance().setBlob(this.f380648a, this.f380649b);
                    }
                } catch (Exception unused) {
                    r.a("JceCacheManager", "<save> type cast error!");
                }
            }
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f380646a = new ConcurrentHashMap();
        }
    }

    public void b(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            Settings.getInstance().setBlob("key_new_app_center_config", bArr);
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bArr);
        }
    }

    public void c(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            Settings.getInstance().setBlob("key_report_config", bArr);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
        }
    }

    public static b a() {
        if (f380645c == null) {
            synchronized (b.class) {
                if (f380645c == null) {
                    f380645c = new b();
                }
            }
        }
        return f380645c;
    }

    public NewQqCenterConfig b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (NewQqCenterConfig) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        byte[] blob = Settings.getInstance().getBlob("key_new_app_center_config");
        if (blob != null) {
            return (NewQqCenterConfig) ProtocolPackage.bytes2JceObj(blob, NewQqCenterConfig.class);
        }
        return null;
    }

    public BatchReportConfig c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BatchReportConfig) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        byte[] blob = Settings.getInstance().getBlob("key_report_config");
        if (blob != null) {
            return (BatchReportConfig) ProtocolPackage.bytes2JceObj(blob, BatchReportConfig.class);
        }
        return null;
    }

    public void a(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr);
            return;
        }
        try {
            ShareUrlConfig shareUrlConfig = (ShareUrlConfig) ProtocolPackage.bytes2JceObj(bArr, ShareUrlConfig.class);
            if (shareUrlConfig != null) {
                Objects.toString(shareUrlConfig.blackList);
                this.f380647b = shareUrlConfig;
            }
            Settings.getInstance().setBlob("key_filter_config", bArr);
        } catch (Exception e16) {
            e16.getMessage();
        }
    }

    public List<String> a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        }
        if (GlobalUtil.getInstance().getContext() == null) {
            GlobalUtil.getInstance().setContext(context.getApplicationContext());
        }
        ShareUrlConfig shareUrlConfig = this.f380647b;
        if (shareUrlConfig != null) {
            return shareUrlConfig.blackList;
        }
        byte[] blob = Settings.getInstance().getBlob("key_filter_config");
        if (blob != null) {
            try {
                ShareUrlConfig shareUrlConfig2 = (ShareUrlConfig) ProtocolPackage.bytes2JceObj(blob, ShareUrlConfig.class);
                StringBuilder sb5 = new StringBuilder();
                Iterator<String> it = shareUrlConfig2.blackList.iterator();
                while (it.hasNext()) {
                    sb5.append(it.next());
                }
                this.f380647b = shareUrlConfig2;
                return shareUrlConfig2.blackList;
            } catch (Exception e16) {
                r.a("JceCacheManager", "<getFilterConfig> decode ShareUrlConfig error!!! error = " + e16.getMessage());
            }
        }
        return new ArrayList();
    }

    public <T extends JceStruct> T a(String str, Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (T) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) cls);
        }
        if (this.f380646a.containsKey(str)) {
            try {
                return (T) this.f380646a.get(str);
            } catch (Exception unused) {
                r.a("JceCacheManager", "<get> type cast error!");
                return null;
            }
        }
        byte[] blob = Settings.getInstance().getBlob(str);
        if (blob == null) {
            return null;
        }
        try {
            T t16 = (T) ProtocolPackage.bytes2JceObj(blob, cls);
            if (t16 == null) {
                return null;
            }
            this.f380646a.put(str, t16);
            return t16;
        } catch (Exception unused2) {
            r.a("JceCacheManager", "<get> type cast error!");
            return null;
        }
    }

    public <T extends JceStruct> void a(String str, byte[] bArr, Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            e.a().post(new a(str, bArr, cls));
        } else {
            iPatchRedirector.redirect((short) 9, this, str, bArr, cls);
        }
    }
}
