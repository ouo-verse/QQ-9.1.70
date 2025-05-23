package com.tencent.qqnt.emotion.constant;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface d {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f356203a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f356204b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f356205c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f356206d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f356207e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f356208f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f356209g;

    /* renamed from: h, reason: collision with root package name */
    public static final String f356210h;

    /* renamed from: i, reason: collision with root package name */
    public static final String f356211i;

    /* renamed from: j, reason: collision with root package name */
    public static final String f356212j;

    /* renamed from: k, reason: collision with root package name */
    public static final String f356213k;

    /* renamed from: l, reason: collision with root package name */
    public static final String f356214l;

    /* renamed from: m, reason: collision with root package name */
    public static final String f356215m;

    /* renamed from: n, reason: collision with root package name */
    public static final String f356216n;

    /* renamed from: o, reason: collision with root package name */
    public static final String f356217o;

    /* renamed from: p, reason: collision with root package name */
    public static final String f356218p;

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(43989), (Class<?>) d.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
            return;
        }
        String str = AppConstants.SDCARD_EMOTICON_SAVE;
        f356203a = str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("[epId]");
        String str2 = File.separator;
        sb5.append(str2);
        String sb6 = sb5.toString();
        f356204b = sb6;
        f356205c = sb6 + "pngframe/";
        f356206d = sb6 + "[epId].zip";
        String str3 = sb6 + "h5magic" + str2;
        f356207e = str3;
        f356208f = str3 + "fileList";
        f356209g = str3 + "index.html";
        f356210h = sb6 + "h5_json.zip";
        f356211i = sb6 + "[eId]_apng";
        f356212j = sb6 + "[eId]";
        f356213k = sb6 + "[eId]";
        f356214l = sb6 + "[epId].jtmp";
        f356215m = sb6 + "[eId]_aio.png";
        f356216n = sb6 + "[eId]_thu.png";
        f356217o = sb6 + "[eId].amr";
        f356218p = AppConstants.SDCARD_GIFT_SAVE + "[epId]" + str2;
    }
}
