package com.tencent.mobileqq.filemanageraux.core;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.f;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends f {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    String f209561b;

    /* renamed from: c, reason: collision with root package name */
    QQAppInterface f209562c;

    /* renamed from: d, reason: collision with root package name */
    String f209563d;

    /* renamed from: e, reason: collision with root package name */
    String f209564e;

    /* renamed from: f, reason: collision with root package name */
    FMObserver f209565f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanageraux.core.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C7589a extends FMObserver {
        static IPatchRedirector $redirector_;

        C7589a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x00c1 A[Catch: all -> 0x00fa, TryCatch #0 {, blocks: (B:4:0x0007, B:6:0x000d, B:8:0x0014, B:12:0x004a, B:16:0x007a, B:19:0x008e, B:23:0x00a6, B:25:0x00c1, B:27:0x00cd, B:28:0x00d2, B:30:0x00d8, B:31:0x00de, B:33:0x00e6, B:38:0x0063, B:40:0x0069, B:43:0x0075), top: B:3:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00e6 A[Catch: all -> 0x00fa, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0007, B:6:0x000d, B:8:0x0014, B:12:0x004a, B:16:0x007a, B:19:0x008e, B:23:0x00a6, B:25:0x00c1, B:27:0x00cd, B:28:0x00d2, B:30:0x00d8, B:31:0x00de, B:33:0x00e6, B:38:0x0063, B:40:0x0069, B:43:0x0075), top: B:3:0x0007 }] */
        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected synchronized void Q(boolean z16, int i3, String str, String str2, String str3, String str4, String str5, int i16, String str6, Bundle bundle) {
            String valueOf;
            Bundle bundle2;
            com.tencent.mobileqq.filemanager.core.b bVar;
            String str7 = str4;
            synchronized (this) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, str2, str3, str7, str5, Integer.valueOf(i16), str6, bundle);
                    return;
                }
                if (((IFMConfig) QRoute.api(IFMConfig.class)).getUserHarCodeIp()) {
                    str7 = "183.61.37.13";
                    valueOf = "443";
                } else {
                    if (str7 == null || str4.length() <= 0 || str7.equalsIgnoreCase("0.0.0.0")) {
                        str7 = str5;
                    }
                    valueOf = String.valueOf(i16);
                }
                String str8 = str7;
                String str9 = valueOf;
                if (((IFMConfig) QRoute.api(IFMConfig.class)).isEnableHttpsDownload4Disc(a.this.f209562c) && bundle != null) {
                    String string = bundle.getString("strHttpsDomain");
                    short s16 = bundle.getShort("httpsPort", (short) 0);
                    if (!TextUtils.isEmpty(string)) {
                        if (s16 == 0) {
                            s16 = 443;
                        }
                        bundle2 = new Bundle();
                        bundle2.putBoolean("ishttps", true);
                        bundle2.putString("httpsdomain", string);
                        bundle2.putShort("httpsport", s16);
                        if (bundle != null) {
                            String string2 = bundle.getString("IPv6Dns", "");
                            if (bundle2 == null) {
                                bundle2 = new Bundle();
                            }
                            if (!TextUtils.isEmpty(string2)) {
                                bundle2.putString("ipv6domain", string2);
                            }
                        }
                        Bundle bundle3 = bundle2;
                        a aVar = a.this;
                        bVar = aVar.f207649a;
                        if (bVar != null) {
                            bVar.a(z16, str8, str9, i3, str, str3, str2, aVar.f209563d, bundle3);
                        }
                    }
                }
                bundle2 = null;
                if (bundle != null) {
                }
                Bundle bundle32 = bundle2;
                a aVar2 = a.this;
                bVar = aVar2.f207649a;
                if (bVar != null) {
                }
            }
        }
    }

    public a(QQAppInterface qQAppInterface, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, str, str2);
            return;
        }
        this.f209561b = "DiscOfflinePreviewController<FileAssistant>";
        this.f209565f = null;
        this.f209562c = qQAppInterface;
        this.f209563d = str;
        this.f209564e = str2;
        e();
    }

    @Override // com.tencent.mobileqq.filemanager.core.f
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (this.f209565f != null) {
            this.f209562c.getFileManagerNotifyCenter().deleteObserver(this.f209565f);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.core.f
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.filemanager.core.f
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (TextUtils.isEmpty(this.f209563d)) {
            QLog.e(this.f209561b, 1, " init OfflinePreviewController error,uuid is null,stack:" + FileManagerUtil.printStack());
            com.tencent.mobileqq.filemanager.core.b bVar = this.f207649a;
            if (bVar != null) {
                bVar.a(false, "", "", -100005L, "", "", null, this.f209563d, null);
                return false;
            }
            return false;
        }
        this.f209562c.getFileManagerEngine().L(this.f209564e, this.f209563d);
        return true;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f209565f = new C7589a();
            this.f209562c.getFileManagerNotifyCenter().addObserver(this.f209565f);
        }
    }
}
