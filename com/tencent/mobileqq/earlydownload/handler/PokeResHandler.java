package com.tencent.mobileqq.earlydownload.handler;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.earlydownload.xmldata.PokeResData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

/* loaded from: classes5.dex */
public class PokeResHandler extends b {
    static IPatchRedirector $redirector_;
    private boolean E;

    public PokeResHandler(QQAppInterface qQAppInterface) {
        super("qq.android.poke.res_0625", qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.E = false;
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (!this.E) {
            this.E = BaseApplication.getContext().getSharedPreferences("vasPokeConfig", 0).getBoolean("ready", false);
        }
        return super.A() & this.E;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void I(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            super.I(z16);
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.earlydownload.handler.PokeResHandler.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PokeResHandler.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        com.tencent.mobileqq.activity.aio.item.l.c(PokeResHandler.this.f203921f, null);
                    }
                }
            });
        }
    }

    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            BaseApplication.getContext().getSharedPreferences("vasPokeConfig", 0).edit().putBoolean("ready", true);
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PokeResHandler_0625", 2, "doOnDownloadSuccess:" + str);
        }
        if (!new File(str).exists()) {
            if (QLog.isColorLevel()) {
                QLog.d("PokeResHandler_0625", 2, "doOnDownloadSuccess sorse not exists");
                return;
            }
            return;
        }
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(com.tencent.mobileqq.activity.aio.item.l.j());
        if (QLog.isColorLevel()) {
            QLog.d("PokeResHandler_0625", 2, "doOnDownloadSuccess imagePath=" + sDKPrivatePath);
        }
        ThreadManagerV2.post(new Runnable(sDKPrivatePath, str) { // from class: com.tencent.mobileqq.earlydownload.handler.PokeResHandler.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f203917d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f203918e;

            {
                this.f203917d = sDKPrivatePath;
                this.f203918e = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, PokeResHandler.this, sDKPrivatePath, str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (!TextUtils.isEmpty(this.f203917d)) {
                    try {
                        FileUtils.delete(this.f203917d, false);
                        FileUtils.uncompressZip(this.f203918e, this.f203917d, false);
                        com.tencent.mobileqq.activity.photo.album.j.a(this.f203917d);
                    } catch (IOException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("PokeResHandler_0625", 2, e16.toString());
                        }
                    }
                }
                com.tencent.mobileqq.activity.aio.item.l.b(this.f203917d);
            }
        }, 8, null, true);
        super.i(str);
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 10044;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public Class<? extends XmlData> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return PokeResData.class;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public String t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "PokeResHandler_0625";
    }
}
