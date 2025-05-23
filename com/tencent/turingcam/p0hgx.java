package com.tencent.turingcam;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class p0hgx {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f382335a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f382336b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19804);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f382335a = new int[0];
            f382336b = new byte[]{72, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, 73, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, 33, PublicAccountH5AbilityPluginImpl.OPENIMG, 77, 42, 52, 100, 52, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 99, 68, 102, 94};
        }
    }
}
