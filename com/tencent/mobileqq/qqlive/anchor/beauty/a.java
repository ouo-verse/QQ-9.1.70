package com.tencent.mobileqq.qqlive.anchor.beauty;

import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static a f270398b;

    /* renamed from: a, reason: collision with root package name */
    private IAegisLogApi f270399a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f270399a = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        }
    }

    private void a() {
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(AEResInfo.LIGHT_RES_BUNDLE_VIDEO_FILTER.agentType);
    }

    private void b() {
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(AEResInfo.AGENT_TYPE_FILAMENT);
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).peakRequestAEBaseRes();
    }

    private void c() {
        for (Map.Entry<AEResInfo, Boolean> entry : f.a().entrySet()) {
            if (!entry.getValue().booleanValue()) {
                ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(entry.getKey().agentType);
            }
        }
    }

    public static a e() {
        if (f270398b == null) {
            f270398b = new a();
        }
        return f270398b;
    }

    private boolean f(int i3, int i16) {
        if (((i3 & i16) ^ i16) > 0) {
            return true;
        }
        return false;
    }

    public void d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        if (f(i3, 4096)) {
            this.f270399a.i("[qq-live]BeautyDownloader", 1, "Beauty download BASE started!");
            b();
        }
        if (f(i3, 256)) {
            this.f270399a.i("[qq-live]BeautyDownloader", 1, "Beauty download BUNDLE started!");
            c();
        }
        if (f(i3, 16)) {
            this.f270399a.i("[qq-live]BeautyDownloader", 1, "Beauty download ASSERT started!");
            a();
        }
    }
}
