package com.tencent.qqnt.emotion.stickerrecommended.mvvm;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager;
import com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.StickerRecKeywordFrom;
import com.tencent.qqnt.emotion.stickerrecommended.impl.StickerRecManagerImpl;
import java.util.List;

/* compiled from: P */
/* loaded from: classes24.dex */
public class StickerRecRepository extends com.tencent.qqnt.emotion.stickerrecommended.mvvm.base.a implements IStickerRecManager.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private IStickerRecManager f356556a;

    /* renamed from: b, reason: collision with root package name */
    private g f356557b;

    public StickerRecRepository() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager.a
    public void a(List<com.tencent.qqnt.emotion.stickerrecommended.g> list, String str, String str2, int i3, String str3, StickerRecKeywordFrom stickerRecKeywordFrom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, list, str, str2, Integer.valueOf(i3), str3, stickerRecKeywordFrom);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecRepository", 2, "data=" + list.size());
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(str, new com.tencent.qqnt.emotion.stickerrecommended.mvvm.data.b(list, str, str2, i3, str3, stickerRecKeywordFrom)) { // from class: com.tencent.qqnt.emotion.stickerrecommended.mvvm.StickerRecRepository.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f356558d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.tencent.qqnt.emotion.stickerrecommended.mvvm.data.b f356559e;

            {
                this.f356558d = str;
                this.f356559e = r9;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, StickerRecRepository.this, str, r9);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                String value = StickerRecRepository.this.f356557b.O1().getValue();
                if (TextUtils.equals(this.f356558d, value)) {
                    StickerRecRepository.this.f356557b.Q1().setValue(this.f356559e);
                } else if (QLog.isColorLevel()) {
                    QLog.d("StickerRecRepository", 2, "[onImageUpdated] not match. usrText=", this.f356558d, ", inWordData=", value);
                }
            }
        });
    }

    public IStickerRecManager e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IStickerRecManager) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.f356556a == null) {
            this.f356556a = StickerRecManagerImpl.get();
        }
        return this.f356556a;
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f356556a == null) {
            this.f356556a = StickerRecManagerImpl.get();
        }
        if (!this.f356556a.hasInit()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.emotion.stickerrecommended.mvvm.StickerRecRepository.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StickerRecRepository.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        StickerRecRepository.this.f356556a.init();
                    }
                }
            }, 32, null, true);
        }
    }

    public void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        if (this.f356556a == null) {
            this.f356556a = StickerRecManagerImpl.get();
        }
        IStickerRecManager iStickerRecManager = this.f356556a;
        if (iStickerRecManager == null) {
            QLog.e("StickerRecRepository", 1, "[setDownloadListener] error, mStickerRecManager is null!");
        } else if (z16) {
            iStickerRecManager.setImgUpdateListener(this);
        } else {
            iStickerRecManager.setImgUpdateListener(null);
        }
    }

    public void h(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
        } else {
            this.f356557b = gVar;
        }
    }

    public void i(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appInterface);
        } else {
            this.f356556a = StickerRecManagerImpl.get(appInterface);
        }
    }
}
