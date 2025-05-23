package com.tencent.videocut.utils;

import android.content.res.Resources;
import android.util.Log;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/videocut/utils/p;", "", "", "a", "I", "FAKE_STATUS_BAR_VIEW_ID", "b", "FAKE_TRANSLUCENT_VIEW_ID", "c", "statusBarHeight", "<init>", "()V", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class p {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final int FAKE_STATUS_BAR_VIEW_ID;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int FAKE_TRANSLUCENT_VIEW_ID;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int statusBarHeight;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final p f384261d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9551);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 27)) {
            redirector.redirect((short) 27);
            return;
        }
        f384261d = new p();
        FAKE_STATUS_BAR_VIEW_ID = R.id.f88344wt;
        FAKE_TRANSLUCENT_VIEW_ID = R.id.f88354wu;
        statusBarHeight = -1;
    }

    p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        }
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        if (statusBarHeight == -1) {
            try {
                statusBarHeight = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
            } catch (Resources.NotFoundException e16) {
                Log.e("StatusBarUtil", "NotFoundException:" + e16.getMessage());
            } catch (NullPointerException e17) {
                Log.e("StatusBarUtil", "NullPointerException:" + e17.getMessage());
            }
        }
        return statusBarHeight;
    }
}
