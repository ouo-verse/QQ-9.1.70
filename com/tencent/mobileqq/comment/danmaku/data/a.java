package com.tencent.mobileqq.comment.danmaku.data;

import android.text.TextUtils;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f201777a;

    /* renamed from: b, reason: collision with root package name */
    public String f201778b;

    /* renamed from: c, reason: collision with root package name */
    public String f201779c;

    /* renamed from: d, reason: collision with root package name */
    public String f201780d;

    /* renamed from: e, reason: collision with root package name */
    public long f201781e;

    /* renamed from: f, reason: collision with root package name */
    public long f201782f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f201783g;

    /* renamed from: h, reason: collision with root package name */
    public String f201784h;

    /* renamed from: i, reason: collision with root package name */
    public int f201785i;

    public a(DanmuItemBean danmuItemBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) danmuItemBean);
            return;
        }
        this.f201777a = danmuItemBean.f201730e;
        this.f201778b = String.valueOf(danmuItemBean.f201729d);
        this.f201779c = danmuItemBean.f201733i;
        this.f201780d = danmuItemBean.f201732h;
        this.f201781e = danmuItemBean.f201734m;
        this.f201782f = danmuItemBean.f201731f;
        this.f201783g = danmuItemBean.C;
        this.f201784h = danmuItemBean.D;
        this.f201785i = danmuItemBean.E;
    }

    public String a() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (this.f201783g) {
            str = this.f201784h;
        } else {
            str = this.f201779c;
        }
        stringBuffer.append(str);
        stringBuffer.append(ProgressTracer.SEPARATOR);
        stringBuffer.append(this.f201780d);
        return stringBuffer.toString();
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f201777a != aVar.f201777a || this.f201781e != aVar.f201781e || this.f201782f != aVar.f201782f || TextUtils.isEmpty(this.f201778b) || TextUtils.isEmpty(aVar.f201778b) || !this.f201778b.equals(aVar.f201778b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return String.valueOf(this.f201777a).hashCode();
    }
}
