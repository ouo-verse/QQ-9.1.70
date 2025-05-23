package com.tencent.mobileqq.identification;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import cooperation.qqcircle.report.QCircleQualityReporter;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface l {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final List<String> f237969a;

    /* renamed from: b, reason: collision with root package name */
    public static final List<String> f237970b;

    /* renamed from: c, reason: collision with root package name */
    public static final List<String> f237971c;

    /* renamed from: d, reason: collision with root package name */
    public static final List<String> f237972d;

    /* renamed from: e, reason: collision with root package name */
    public static final List<String> f237973e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f237974f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f237975g;

    /* renamed from: h, reason: collision with root package name */
    public static final String f237976h;

    /* renamed from: i, reason: collision with root package name */
    public static final String f237977i;

    /* renamed from: j, reason: collision with root package name */
    public static final String f237978j;

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(33946), (Class<?>) l.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
            return;
        }
        f237969a = Arrays.asList("setFaceData", "changeSecureMobile", "deleteFace", QCircleQualityReporter.KEY_ID, "studyModeIdentify", "qwalletIdentify");
        f237970b = Arrays.asList("loginVerify", "identifyNoLogin");
        f237971c = Arrays.asList("loginVerify", "changeSecureMobile");
        f237972d = Arrays.asList(QCircleQualityReporter.KEY_ID, "identifyNoLogin", "studyModeIdentify", "qwalletIdentify");
        f237973e = Arrays.asList("loginVerify", QCircleQualityReporter.KEY_ID, "changeSecureMobile", "identifyNoLogin", "studyModeIdentify", "qwalletIdentify");
        f237974f = HardCodeUtil.qqStr(R.string.f213065p8);
        f237975g = HardCodeUtil.qqStr(R.string.f213055p7);
        f237976h = HardCodeUtil.qqStr(R.string.f213045p6);
        f237977i = HardCodeUtil.qqStr(R.string.f159491sg);
        f237978j = HardCodeUtil.qqStr(R.string.f159551sm);
    }
}
