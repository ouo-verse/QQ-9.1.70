package com.tencent.mobileqq.troop.filemanager.thumbnail;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloader;
import com.tencent.mobileqq.troop.filemanager.download.c;
import com.tencent.mobileqq.troop.filemanager.e;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends TroopFileDownloader {
    static IPatchRedirector $redirector_;

    /* renamed from: t, reason: collision with root package name */
    protected boolean f296012t;

    /* renamed from: u, reason: collision with root package name */
    protected boolean f296013u;

    /* renamed from: v, reason: collision with root package name */
    protected long f296014v;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.filemanager.thumbnail.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public interface InterfaceC8693a extends c {
        void a(int i3);
    }

    protected a(QQAppInterface qQAppInterface, long j3, String str, long j16, List<String> list, String str2, String str3, boolean z16, boolean z17, String str4) {
        super(qQAppInterface, j3, str, j16, list, str2, str3, z17, str4);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, Long.valueOf(j3), str, Long.valueOf(j16), list, str2, str3, Boolean.valueOf(z16), Boolean.valueOf(z17), str4);
            return;
        }
        this.f296013u = false;
        this.f296014v = 2000L;
        this.f296012t = z16;
    }

    public static a C(QQAppInterface qQAppInterface, long j3, String str, long j16, List<String> list, String str2, String str3, boolean z16, boolean z17, String str4) {
        String str5;
        if (str == null) {
            str5 = "strSavePath is null";
        } else if (str.length() == 0) {
            str5 = "strSavePath is empty";
        } else if (list == null) {
            str5 = "lstUrl is null";
        } else if (list.size() == 0) {
            str5 = "lstUrl is empty";
        } else if (str2 == null) {
            str5 = "urlParams is null";
        } else if (str2.length() == 0) {
            str5 = "urlParams is empty";
        } else {
            str5 = "";
        }
        if (!TextUtils.isEmpty(str5)) {
            e.b.b("TroopFileThumbDownloader", e.b.f295938b, "getFileDownloader " + str5);
            return null;
        }
        return new a(qQAppInterface, j3, str, j16, list, str2, str3, z16, z17, str4);
    }

    public void B(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.f295912p = z16;
        }
    }

    public void D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f295908l.h();
        }
    }

    public void E(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.f296013u = z16;
        }
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloader, com.tencent.mobileqq.troop.filemanager.TroopFileTransferRetryController.a
    public long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        long j3 = this.f296014v;
        if (j3 > 6000) {
            return 2000L;
        }
        this.f296014v = 2000 + j3;
        return j3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0062, code lost:
    
        r1 = java.lang.Integer.parseInt(r3[1]);
     */
    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloader, com.tencent.mobileqq.troop.filemanager.download.a.InterfaceC8691a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(HttpMsg httpMsg) {
        c cVar;
        String[] split;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) httpMsg);
            return;
        }
        if (!this.f296012t || this.f296013u) {
            return;
        }
        String responseProperty = httpMsg.getResponseProperty("Set-Cookie");
        int i3 = 0;
        try {
            if (!TextUtils.isEmpty(responseProperty) && responseProperty.contains("duration") && (split = responseProperty.trim().split(";")) != null && split.length > 0) {
                int i16 = 0;
                while (true) {
                    if (i16 < split.length) {
                        String[] split2 = split[i16].split(ContainerUtils.KEY_VALUE_DELIMITER);
                        if (split2 != null && split2.length == 2 && "duration".equals(split2[0])) {
                            break;
                        } else {
                            i16++;
                        }
                    } else {
                        break;
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (i3 != 0 && (cVar = this.f295910n) != null && (cVar instanceof InterfaceC8693a)) {
            ((InterfaceC8693a) cVar).a(i3);
        }
    }
}
