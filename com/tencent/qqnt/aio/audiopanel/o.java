package com.tencent.qqnt.aio.audiopanel;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.voicetextpanel.IVoice2TxtApi;
import com.tencent.mobileqq.activity.aio.voicetextpanel.view.BaseVoicetoTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class o implements l61.e<BaseVoicetoTextView> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f349703a;

    /* renamed from: b, reason: collision with root package name */
    private a61.d f349704b;

    /* renamed from: c, reason: collision with root package name */
    private BaseVoicetoTextView f349705c;

    /* renamed from: d, reason: collision with root package name */
    private ViewGroup f349706d;

    /* renamed from: e, reason: collision with root package name */
    private ViewGroup f349707e;

    /* renamed from: f, reason: collision with root package name */
    private m f349708f;

    public o(a61.d dVar, QQAppInterface qQAppInterface, m mVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, dVar, qQAppInterface, mVar);
            return;
        }
        this.f349704b = dVar;
        this.f349703a = qQAppInterface;
        this.f349706d = (ViewGroup) dVar.h().findViewById(R.id.dmj);
        this.f349707e = (ViewGroup) dVar.h().findViewById(R.id.f2225038);
        this.f349708f = mVar;
    }

    @Override // l61.c
    public void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    @Override // l61.e
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 36;
    }

    @Override // l61.e
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // l61.e
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public BaseVoicetoTextView c(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BaseVoicetoTextView) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        long currentTimeMillis = System.currentTimeMillis();
        BaseVoicetoTextView voice2TxtView = ((IVoice2TxtApi) QRoute.api(IVoice2TxtApi.class)).getVoice2TxtView(context);
        this.f349705c = voice2TxtView;
        QQAppInterface qQAppInterface = this.f349703a;
        a61.d dVar = this.f349704b;
        voice2TxtView.a(qQAppInterface, dVar, dVar.d(), this.f349706d, this.f349707e);
        if (QLog.isColorLevel()) {
            QLog.d("OpenPanel", 2, "openVoiceTextEditPanel:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return this.f349705c;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        BaseVoicetoTextView baseVoicetoTextView = this.f349705c;
        if (baseVoicetoTextView != null) {
            baseVoicetoTextView.b();
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        BaseVoicetoTextView baseVoicetoTextView = this.f349705c;
        if (baseVoicetoTextView != null) {
            baseVoicetoTextView.c();
        }
    }

    public void g(String str, int i3, RecordParams.RecorderParam recorderParam, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, Integer.valueOf(i3), recorderParam, str2);
            return;
        }
        BaseVoicetoTextView baseVoicetoTextView = this.f349705c;
        if (baseVoicetoTextView != null) {
            baseVoicetoTextView.setParam(str, recorderParam, i3, str2);
        }
    }

    public ViewGroup h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f349706d;
    }

    public ViewGroup i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f349707e;
    }

    public void j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
        } else {
            this.f349708f.sendMessage(str);
        }
    }

    public void k(String str, float f16, ArrayList<Byte> arrayList, RecordParams.RecorderParam recorderParam, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, Float.valueOf(f16), arrayList, recorderParam, Boolean.valueOf(z16));
        } else {
            this.f349708f.Z(str, f16, arrayList, recorderParam, false, z16, 0);
        }
    }

    @Override // l61.c
    public void onPanelChanged(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }
}
