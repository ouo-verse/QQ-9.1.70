package com.tencent.ams.mosaic.jsengine.common.download;

import com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b implements IMosaicDownloadManager.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final String f70877a;

    /* renamed from: b, reason: collision with root package name */
    private final String f70878b;

    /* renamed from: c, reason: collision with root package name */
    private final String f70879c;

    /* renamed from: d, reason: collision with root package name */
    private final String f70880d;

    /* renamed from: e, reason: collision with root package name */
    private final String f70881e;

    public b(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4);
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.b
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f70878b;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.b
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f70879c;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.b
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f70881e;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.b
    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f70880d;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.b
    public String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f70877a;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "DownloadRequest{url='" + this.f70877a + "', md5='" + this.f70878b + "', folder='" + this.f70879c + "', name='" + this.f70880d + "', extend='" + this.f70881e + '}';
    }

    public b(String str, String str2, String str3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, str5);
            return;
        }
        this.f70877a = str;
        this.f70878b = str2;
        this.f70879c = str3;
        this.f70880d = str4;
        this.f70881e = str5;
    }
}
