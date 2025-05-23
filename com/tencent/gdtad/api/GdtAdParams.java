package com.tencent.gdtad.api;

import com.tencent.gdtad.aditem.GdtHandler;
import tencent.gdt.qq_ad_get;

/* loaded from: classes6.dex */
public abstract class GdtAdParams {
    public GdtHandler.Params clickParams;
    public qq_ad_get.QQAdGet requestParams;

    public boolean isValid() {
        if (this.clickParams != null) {
            return true;
        }
        return false;
    }
}
