package com.tencent.mobileqq.scribble;

import com.tencent.libra.trace.LibraTraceConst;
import com.tencent.mobileqq.jsonconverter.Alias;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @Alias("resType")
    public int f282546a;

    /* renamed from: b, reason: collision with root package name */
    @Alias("sourceId")
    public int f282547b;

    /* renamed from: c, reason: collision with root package name */
    @Alias("sourceUrl")
    public String f282548c;

    /* renamed from: d, reason: collision with root package name */
    @Alias("sourceMd5")
    public String f282549d;

    /* renamed from: e, reason: collision with root package name */
    @Alias("name")
    public String f282550e;

    /* renamed from: f, reason: collision with root package name */
    @Alias("predownload")
    public int f282551f;

    /* renamed from: g, reason: collision with root package name */
    @Alias(LibraTraceConst.Node.IMAGE_DOWNLOADING)
    public boolean f282552g;

    /* renamed from: h, reason: collision with root package name */
    @Alias(ViewStickEventHelper.IS_SHOW)
    public int f282553h;

    /* renamed from: i, reason: collision with root package name */
    @Alias("showInApp")
    public int f282554i;

    /* renamed from: j, reason: collision with root package name */
    @Alias("orderIndex")
    public int f282555j;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f282546a = 0;
        this.f282547b = 0;
        this.f282548c = "";
        this.f282549d = "";
        this.f282550e = "";
        this.f282551f = 1;
        this.f282552g = false;
        this.f282553h = 1;
        this.f282555j = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a(c cVar) {
        c cVar2 = new c();
        cVar2.f282546a = cVar.f282546a;
        cVar2.f282547b = cVar.f282547b;
        cVar2.f282548c = cVar.f282548c;
        cVar2.f282549d = cVar.f282549d;
        cVar2.f282550e = cVar.f282550e;
        cVar2.f282551f = cVar.f282551f;
        cVar2.f282552g = cVar.f282552g;
        cVar2.f282553h = cVar.f282553h;
        cVar2.f282554i = cVar.f282554i;
        cVar2.f282555j = cVar.f282555j;
        return cVar2;
    }
}
