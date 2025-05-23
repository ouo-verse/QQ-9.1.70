package com.tencent.autotemplate.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class StickerPosition {
    static IPatchRedirector $redirector_;

    @SerializedName(HippyTKDListViewAdapter.X)
    public float centerX;

    @SerializedName("y")
    public float centerY;

    public StickerPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.centerX = 0.5f;
            this.centerY = 0.5f;
        }
    }
}
