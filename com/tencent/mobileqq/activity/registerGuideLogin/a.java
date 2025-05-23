package com.tencent.mobileqq.activity.registerGuideLogin;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import common.config.service.QzoneConfig;
import fd0.a;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a implements a.b, a.c, a.e, a.d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f185725a;

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f185726b;

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f185727c;

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f185728d;

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f185729e;

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f185730f;

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f185731g;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69326);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        f185725a = new String[]{QzoneConfig.DefaultValue.DEFAULT_CATEGORY_SCANNER_FRONT_CAM_BLACKLIST, "ZTE A2015", "MI 1S", "GT-S7568I", "ZTE N909"};
        f185726b = new String[]{"SM-A7000", "HM NOTE 1S", "MI 2S"};
        f185727c = new String[]{"vivo X6D"};
        f185728d = new String[]{"MI 4"};
        f185729e = new String[]{"Nexus 5"};
        f185730f = new String[]{"Nexus 5"};
        f185731g = new String[]{"OPPO R7sm"};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void e(a aVar, boolean z16) {
        throw null;
    }
}
