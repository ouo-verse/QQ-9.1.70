package com.tencent.mobileqq.ad.schedule;

import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\tR\u001a\u0010\f\u001a\u00020\u00068\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/ad/schedule/b;", "", "", "appName", "", "c", "", "b", "I", "()I", "BANNER_ID", "getSCHEDULE_BANNER_MSG_TYPE", "SCHEDULE_BANNER_MSG_TYPE", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f186936a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int BANNER_ID;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int SCHEDULE_BANNER_MSG_TYPE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28258);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f186936a = new b();
        BANNER_ID = com.tencent.mobileqq.banner.d.N;
        SCHEDULE_BANNER_MSG_TYPE = 3012;
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String str) {
        boolean z16;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("AdScheduleDownloadBannerManager", 1, "appName is null");
            return;
        }
        Message message = new Message();
        message.obj = str;
        message.what = SCHEDULE_BANNER_MSG_TYPE;
        BannerManager.l().O(BANNER_ID, 2, message);
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return BANNER_ID;
    }

    public final void c(@Nullable final String appName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appName);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ad.schedule.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.d(appName);
                }
            }, 16, null, false);
        }
    }
}
