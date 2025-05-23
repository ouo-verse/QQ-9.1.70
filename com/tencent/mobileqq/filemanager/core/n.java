package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class n extends f {

    /* renamed from: b, reason: collision with root package name */
    String f207664b;

    /* renamed from: c, reason: collision with root package name */
    String f207665c;

    /* renamed from: d, reason: collision with root package name */
    FMObserver f207666d = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends FMObserver {
        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0089 A[Catch: all -> 0x00be, TryCatch #0 {, blocks: (B:4:0x0004, B:8:0x002d, B:10:0x0035, B:13:0x0045, B:17:0x005e, B:18:0x0078, B:21:0x0080, B:23:0x0089, B:24:0x008e, B:25:0x0094, B:27:0x009b, B:31:0x00ac, B:33:0x00b2, B:36:0x001d, B:39:0x0028), top: B:3:0x0004 }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x009b A[Catch: all -> 0x00be, TryCatch #0 {, blocks: (B:4:0x0004, B:8:0x002d, B:10:0x0035, B:13:0x0045, B:17:0x005e, B:18:0x0078, B:21:0x0080, B:23:0x0089, B:24:0x008e, B:25:0x0094, B:27:0x009b, B:31:0x00ac, B:33:0x00b2, B:36:0x001d, B:39:0x0028), top: B:3:0x0004 }] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00ac A[Catch: all -> 0x00be, TryCatch #0 {, blocks: (B:4:0x0004, B:8:0x002d, B:10:0x0035, B:13:0x0045, B:17:0x005e, B:18:0x0078, B:21:0x0080, B:23:0x0089, B:24:0x008e, B:25:0x0094, B:27:0x009b, B:31:0x00ac, B:33:0x00b2, B:36:0x001d, B:39:0x0028), top: B:3:0x0004 }] */
        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected synchronized void R(boolean z16, int i3, String str, String str2, String str3, String str4, String str5, int i16, String str6, Bundle bundle) {
            String str7;
            String valueOf;
            Bundle bundle2;
            b bVar;
            if (((IFMConfig) QRoute.api(IFMConfig.class)).getUserHarCodeIp()) {
                str7 = "183.61.37.13";
                valueOf = "443";
            } else {
                if (str4 != null && str4.length() > 0) {
                    str7 = str4;
                } else {
                    str7 = str5;
                }
                valueOf = String.valueOf(i16);
            }
            String str8 = str7;
            String str9 = valueOf;
            QQAppInterface f16 = n.this.f();
            if (f16 != null && ((IFMConfig) QRoute.api(IFMConfig.class)).isEnableHttpsDownload4C2C(f16) && bundle != null) {
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
                    if (QFileUtils.f0() && bundle != null) {
                        String string2 = bundle.getString("IPv6Dns");
                        if (bundle2 == null) {
                            bundle2 = new Bundle();
                        }
                        bundle2.putString("ipv6domain", string2);
                    }
                    Bundle bundle3 = bundle2;
                    n nVar = n.this;
                    bVar = nVar.f207649a;
                    if (bVar == null) {
                        bVar.a(z16, str8, str9, i3, str, str3, str2, nVar.f207664b, bundle3);
                    } else if (QLog.isColorLevel()) {
                        QLog.e("OfflinePreviewController<FileAssistant>", 2, " callback is null");
                    }
                }
            }
            bundle2 = null;
            if (QFileUtils.f0()) {
                String string22 = bundle.getString("IPv6Dns");
                if (bundle2 == null) {
                }
                bundle2.putString("ipv6domain", string22);
            }
            Bundle bundle32 = bundle2;
            n nVar2 = n.this;
            bVar = nVar2.f207649a;
            if (bVar == null) {
            }
        }
    }

    public n(QQAppInterface qQAppInterface, String str, String str2) {
        this.f207664b = str;
        this.f207665c = str2;
        if (TextUtils.isEmpty(str)) {
            QLog.e("OfflinePreviewController<FileAssistant>", 1, " init OfflinePreviewController error,uuid is null,stack:" + FileManagerUtil.printStack());
        }
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QQAppInterface f() {
        return (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    @Override // com.tencent.mobileqq.filemanager.core.f
    public void a() {
        QQAppInterface f16 = f();
        if (this.f207666d != null && f16 != null) {
            f16.getFileManagerNotifyCenter().deleteObserver(this.f207666d);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.core.f
    public int b() {
        return 1;
    }

    @Override // com.tencent.mobileqq.filemanager.core.f
    public boolean c() {
        if (TextUtils.isEmpty(this.f207664b)) {
            QLog.e("OfflinePreviewController<FileAssistant>", 1, " init OfflinePreviewController error,uuid is null,stack:" + FileManagerUtil.printStack());
            b bVar = this.f207649a;
            if (bVar != null) {
                bVar.a(false, "", "", -100005L, "", "", null, this.f207664b, null);
            }
            return false;
        }
        QQAppInterface f16 = f();
        if (f16 == null) {
            return false;
        }
        f16.getFileManagerEngine().S(this.f207664b, this.f207665c);
        return true;
    }

    public void g() {
        this.f207666d = new a();
        QQAppInterface f16 = f();
        if (f16 == null) {
            return;
        }
        f16.getFileManagerNotifyCenter().addObserver(this.f207666d);
    }
}
