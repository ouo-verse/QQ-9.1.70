package com.tencent.mobileqq.structmsg.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photopreview.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class CountdownTextView extends TextView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.activity.photopreview.a f290698d;

    /* renamed from: e, reason: collision with root package name */
    private a.AbstractC7196a f290699e;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends a.AbstractC7196a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f290700d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j3, b bVar) {
            super(j3);
            this.f290700d = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, CountdownTextView.this, Long.valueOf(j3), bVar);
            }
        }

        @Override // com.tencent.mobileqq.activity.photopreview.a.AbstractC7196a
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            b bVar = this.f290700d;
            if (bVar != null) {
                bVar.onFinish();
            }
            CountdownTextView.this.b();
        }

        @Override // com.tencent.mobileqq.activity.photopreview.a.AbstractC7196a
        public void c(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
                return;
            }
            b bVar = this.f290700d;
            if (bVar != null) {
                bVar.a(j3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface b {
        void a(long j3);

        void onFinish();
    }

    public CountdownTextView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public void a(long j3, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), bVar);
            return;
        }
        com.tencent.mobileqq.activity.photopreview.a aVar = this.f290698d;
        if (aVar != null) {
            a aVar2 = new a(j3, bVar);
            this.f290699e = aVar2;
            aVar.a(aVar2);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        com.tencent.mobileqq.activity.photopreview.a aVar = this.f290698d;
        if (aVar != null) {
            aVar.f(this.f290699e);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onDetachedFromWindow();
            b();
        }
    }

    public CountdownTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public CountdownTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.f290698d = new com.tencent.mobileqq.activity.photopreview.a();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
