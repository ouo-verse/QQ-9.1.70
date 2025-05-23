package com.tencent.mobileqq.springhb.preload;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
@Keep
/* loaded from: classes18.dex */
public class SpringHbZipMappingBean implements Serializable {
    static IPatchRedirector $redirector_;

    @SerializedName("resName")
    String resName;

    @SerializedName("url")
    String url;

    @SerializedName("zipResId")
    String zipResId;

    public SpringHbZipMappingBean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
