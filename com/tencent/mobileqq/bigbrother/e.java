package com.tencent.mobileqq.bigbrother;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e implements a, c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f200377a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private Object f200378b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, @Nullable a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) aVar);
        } else {
            this.f200377a = new WeakReference<>(context);
            this.f200378b = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z16, boolean z17, int i3, String str, String str2) {
        Context context;
        Activity topActivity;
        QLog.d("TeleScreenListenerWrapper", 1, "download | pass: " + z17 + ", errCode: " + i3 + ", errMsg: " + str);
        onDownload(z16, z17, i3, str, str2);
        Object obj = this.f200378b;
        if ((!(obj instanceof a) || ((a) obj).autoShowErrPage()) && (context = this.f200377a.get()) != null && z16 && !z17 && !TextUtils.isEmpty(str2)) {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str2);
            if (context instanceof Activity) {
                topActivity = (Activity) context;
            } else {
                topActivity = Foreground.getTopActivity();
            }
            if (topActivity == null) {
                intent.addFlags(268435456);
                context.startActivity(intent);
            } else {
                topActivity.startActivity(intent);
            }
        }
    }

    @Override // com.tencent.mobileqq.bigbrother.a
    public boolean autoShowErrPage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        Object obj = this.f200378b;
        if (obj instanceof a) {
            return ((a) obj).autoShowErrPage();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z16, int i3, int i16, String str) {
        QLog.d("TeleScreenListenerWrapper", 1, "jump | jump: " + i3 + ", errCode: " + i16 + ", errMsg: " + str);
        onJump(z16, i3, i16, str);
    }

    @Override // com.tencent.mobileqq.bigbrother.a
    public void onDownload(boolean z16, boolean z17, int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), str, str2);
            return;
        }
        Object obj = this.f200378b;
        if (obj instanceof a) {
            ((a) obj).onDownload(z16, z17, i3, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.bigbrother.c
    public void onJump(boolean z16, int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        Object obj = this.f200378b;
        if (obj instanceof c) {
            ((c) obj).onJump(z16, i3, i16, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, @Nullable c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) cVar);
        } else {
            this.f200377a = new WeakReference<>(context);
            this.f200378b = cVar;
        }
    }
}
