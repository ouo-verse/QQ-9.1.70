package com.tencent.autotemplate.model.bean;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MaterialLimits {
    static IPatchRedirector $redirector_ = null;
    public static final int TYPE_ALL = 2;
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_VIDEO = 0;

    @SerializedName("material_type")
    public int materialType;

    @SerializedName("max_counts")
    public int maxCounts;

    @SerializedName("min_counts")
    public int minCounts;

    @SerializedName("min_duration_ms")
    public long minDurationMs;

    public MaterialLimits() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.materialType = 2;
        }
    }
}
