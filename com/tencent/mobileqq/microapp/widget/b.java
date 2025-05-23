package com.tencent.mobileqq.microapp.widget;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.smtt.sdk.TbsReaderView;
import java.io.File;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class b implements TbsReaderView.ReaderCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private TbsReaderView f246107a;

    /* renamed from: b, reason: collision with root package name */
    private Context f246108b;

    public b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f246107a = new TbsReaderView(context, this);
            this.f246108b = context;
        }
    }

    public void a(FrameLayout frameLayout, FrameLayout.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) frameLayout, (Object) layoutParams);
        } else {
            if (frameLayout == null) {
                return;
            }
            frameLayout.addView(this.f246107a, layoutParams);
        }
    }

    @Override // com.tencent.smtt.sdk.TbsReaderView.ReaderCallback
    public void onCallBackAction(Integer num, Object obj, Object obj2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, num, obj, obj2);
        }
    }

    public void a(FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) frameLayout);
        } else {
            if (frameLayout == null) {
                return;
            }
            frameLayout.removeView(this.f246107a);
        }
    }

    public TbsReaderView a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? new TbsReaderView(context, this) : (TbsReaderView) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
    }

    public void a(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) file);
            return;
        }
        if (file == null || StringUtil.isEmpty(file.toString())) {
            return;
        }
        File file2 = new File(com.tencent.mobileqq.microapp.appbrand.b.b.a().a(""));
        if (!file2.exists()) {
            file2.mkdir();
        }
        Bundle bundle = new Bundle();
        bundle.putString("filePath", file.toString());
        bundle.putString("tempPath", file2.getAbsolutePath());
        if (this.f246107a == null) {
            this.f246107a = a(this.f246108b);
        }
        if (this.f246107a.preOpen(a(file.toString()), false)) {
            this.f246107a.openFile(bundle);
        }
    }

    private String a(String str) {
        int lastIndexOf;
        return (!StringUtil.isEmpty(str) && (lastIndexOf = str.lastIndexOf(46)) > -1) ? str.substring(lastIndexOf + 1) : "";
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        TbsReaderView tbsReaderView = this.f246107a;
        if (tbsReaderView != null) {
            tbsReaderView.onStop();
        }
    }
}
