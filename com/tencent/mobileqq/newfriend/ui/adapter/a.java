package com.tencent.mobileqq.newfriend.ui.adapter;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.newfriend.ui.builder.d;
import com.tencent.mobileqq.newfriend.ui.view.SystemMsgListView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.XBaseAdapter;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class a extends XBaseAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public int f254100d;

    /* renamed from: e, reason: collision with root package name */
    public SystemMsgListView f254101e;

    public a(SystemMsgListView systemMsgListView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) systemMsgListView);
        } else {
            this.f254100d = -1;
            this.f254101e = systemMsgListView;
        }
    }

    public abstract int a();

    public abstract int b();

    public abstract Bitmap c(int i3, String str);

    public abstract IFaceDecoder d();

    public abstract int e();

    public abstract void f(int i3, int i16);

    public abstract void g();

    public abstract void h(long j3);

    public abstract void i(d dVar);
}
