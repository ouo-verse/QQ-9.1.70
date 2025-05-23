package com.tencent.youtu.ytagreflectlivecheck.jni.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ReflectLiveReq {
    static IPatchRedirector $redirector_;
    public String app_id;
    public String client_version;
    public String color_data;
    public String compare_image;
    public String encode_reflect_data;
    public String live_image;
    public int platform;
    public ReflectColorData reflect_data;
    public String reserve;
    public LiveStyleRequester.SeleceData select_data;
    public String session_id;

    public ReflectLiveReq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.app_id = "";
        this.color_data = "";
        this.platform = 2;
        this.live_image = null;
        this.compare_image = null;
        this.session_id = null;
        this.reflect_data = null;
        this.encode_reflect_data = null;
        this.reserve = null;
        this.client_version = null;
    }
}
