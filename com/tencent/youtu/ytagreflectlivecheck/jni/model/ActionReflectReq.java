package com.tencent.youtu.ytagreflectlivecheck.jni.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ActionReflectReq {
    static IPatchRedirector $redirector_;
    public String action_video;
    public String app_id;
    public String client_version;
    public String color_data;
    public YTImageInfo compare_image;
    public String encode_reflect_data;
    public YTImageInfo eye_image;
    public YTImageInfo live_image;
    public int mode;
    public YTImageInfo mouth_image;
    public int platform;
    public ReflectColorData reflect_data;
    public String reserve;
    public LiveStyleRequester.SeleceData select_data;
    public String session_id;

    public ActionReflectReq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.app_id = "";
        this.color_data = "";
        this.platform = 2;
        this.live_image = null;
        this.eye_image = null;
        this.mouth_image = null;
        this.compare_image = null;
        this.session_id = null;
        this.reflect_data = null;
        this.mode = 0;
        this.encode_reflect_data = null;
        this.reserve = null;
        this.action_video = null;
        this.client_version = null;
    }
}
