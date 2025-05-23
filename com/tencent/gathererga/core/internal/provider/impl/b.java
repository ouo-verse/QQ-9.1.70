package com.tencent.gathererga.core.internal.provider.impl;

import android.content.Context;
import android.os.Build;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.gathererga.core.AndroidInfoProvider;
import com.tencent.gathererga.core.f;
import com.tencent.gathererga.core.internal.provider.InfoID;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b implements AndroidInfoProvider {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Context f108249a;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f108249a = null;
        }
    }

    @Override // com.tencent.gathererga.core.AndroidInfoProvider
    @InfoID(id = 410)
    public f getBuildId(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (f) iPatchRedirector.redirect((short) 10, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, Build.ID);
    }

    @Override // com.tencent.gathererga.core.AndroidInfoProvider
    @InfoID(id = 408)
    public f getChromeVersionName(com.tencent.gathererga.core.e eVar, com.tencent.gathererga.core.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (f) iPatchRedirector.redirect((short) 8, (Object) this, (Object) eVar, (Object) aVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, com.tencent.gathererga.core.internal.util.c.b(this.f108249a, aVar));
    }

    @Override // com.tencent.gathererga.core.AndroidInfoProvider
    @InfoID(id = 405)
    public f getKernelVersion(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (f) iPatchRedirector.redirect((short) 7, (Object) this, (Object) eVar);
        }
        return null;
    }

    @Override // com.tencent.gathererga.core.AndroidInfoProvider
    @InfoID(id = 414)
    public f getManufacturerOSVersion(com.tencent.gathererga.core.e eVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (f) iPatchRedirector.redirect((short) 14, (Object) this, (Object) eVar);
        }
        try {
            str = com.tencent.gathererga.core.internal.util.b.a();
        } catch (Throwable th5) {
            com.tencent.gathererga.core.internal.util.d.b("getManufacturerOSVersion" + th5.getMessage());
            str = "";
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, str);
    }

    @Override // com.tencent.gathererga.core.AndroidInfoProvider
    @InfoID(id = 403)
    public f getOsVersion(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f) iPatchRedirector.redirect((short) 3, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, Build.VERSION.RELEASE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.tencent.mobileqq.qfix.redirect.IPatchRedirector] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.RandomAccessFile] */
    @Override // com.tencent.gathererga.core.AndroidInfoProvider
    @InfoID(id = 404)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f getProcVersion(com.tencent.gathererga.core.e eVar) {
        Throwable th5;
        RandomAccessFile randomAccessFile;
        int i3;
        ?? r16 = $redirector_;
        if (r16 != 0 && r16.hasPatch((short) 6)) {
            return (f) r16.redirect((short) 6, this, eVar);
        }
        try {
            try {
                randomAccessFile = new RandomAccessFile("/proc/version", "r");
            } catch (FileNotFoundException e16) {
                e = e16;
                randomAccessFile = null;
            } catch (IOException e17) {
                e = e17;
                randomAccessFile = null;
            } catch (Throwable th6) {
                r16 = 0;
                th5 = th6;
                if (r16 != 0) {
                }
                throw th5;
            }
            try {
                com.tencent.gathererga.core.internal.provider.c cVar = new com.tencent.gathererga.core.internal.provider.c(0, randomAccessFile.readLine());
                try {
                    randomAccessFile.close();
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
                return cVar;
            } catch (FileNotFoundException e19) {
                e = e19;
                com.tencent.gathererga.core.internal.util.d.a("getProcVersion Exception:" + e.getMessage());
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e26) {
                        e26.printStackTrace();
                    }
                }
                i3 = ErrorCode.WX_TTS_ERROR_UNINIT;
                return new com.tencent.gathererga.core.internal.provider.c(i3, null);
            } catch (IOException e27) {
                e = e27;
                com.tencent.gathererga.core.internal.util.d.a("getProcVersion Exception:" + e.getMessage());
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e28) {
                        e28.printStackTrace();
                    }
                }
                i3 = ErrorCode.WX_TTS_ERROR_TEXT_NULL;
                return new com.tencent.gathererga.core.internal.provider.c(i3, null);
            }
        } catch (Throwable th7) {
            th5 = th7;
            if (r16 != 0) {
                try {
                    r16.close();
                } catch (IOException e29) {
                    e29.printStackTrace();
                }
            }
            throw th5;
        }
    }

    @Override // com.tencent.gathererga.core.AndroidInfoProvider
    @InfoID(id = 402)
    public f getUUID(com.tencent.gathererga.core.e eVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (f) iPatchRedirector.redirect((short) 4, (Object) this, (Object) eVar, (Object) str);
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, null);
    }

    @Override // com.tencent.gathererga.core.AndroidInfoProvider
    @InfoID(id = 409)
    public f getVersionCodeName(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (f) iPatchRedirector.redirect((short) 9, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, Build.VERSION.CODENAME);
    }

    @Override // com.tencent.gathererga.core.AndroidInfoProvider
    @InfoID(id = 412)
    public f getVersionIncremental(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (f) iPatchRedirector.redirect((short) 12, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, Build.VERSION.INCREMENTAL);
    }

    @Override // com.tencent.gathererga.core.AndroidInfoProvider
    @InfoID(id = 411)
    public f getVersionReleaseOrCodename(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (f) iPatchRedirector.redirect((short) 11, (Object) this, (Object) eVar);
        }
        String str = Build.VERSION.RELEASE;
        try {
            if (com.tencent.gathererga.core.internal.util.b.b() >= 30) {
                str = Build.VERSION.RELEASE_OR_CODENAME;
            }
        } catch (Exception e16) {
            com.tencent.gathererga.core.internal.util.d.b("getVersionReleaseOrCodename error: " + e16.getMessage());
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, str);
    }

    @Override // com.tencent.gathererga.core.AndroidInfoProvider
    @InfoID(id = 413)
    public f getVmVersion(com.tencent.gathererga.core.e eVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (f) iPatchRedirector.redirect((short) 13, (Object) this, (Object) eVar);
        }
        try {
            str = System.getProperty("java.vm.version");
        } catch (Exception e16) {
            com.tencent.gathererga.core.internal.util.d.b("getVmVersion Exception:" + e16.getMessage());
            str = "";
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, str);
    }

    @Override // com.tencent.gathererga.core.AndroidInfoProvider, com.tencent.gathererga.core.internal.c
    public void onInit(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            this.f108249a = context;
        }
    }

    @Override // com.tencent.gathererga.core.AndroidInfoProvider
    @InfoID(id = 406)
    public f sdCardFreeSpace(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (f) iPatchRedirector.redirect((short) 5, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(-400L, 0);
    }
}
