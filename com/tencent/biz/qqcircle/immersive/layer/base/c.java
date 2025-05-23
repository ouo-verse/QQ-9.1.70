package com.tencent.biz.qqcircle.immersive.layer.base;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class c extends BasePreLoadTask {

    /* renamed from: a, reason: collision with root package name */
    protected QCircleInitBean f86510a;

    /* JADX INFO: Access modifiers changed from: protected */
    public String a() {
        HashMap<String, String> schemeAttrs;
        QCircleInitBean qCircleInitBean = this.f86510a;
        if (qCircleInitBean == null || qCircleInitBean.getSchemeAttrs() == null || (schemeAttrs = this.f86510a.getSchemeAttrs()) == null || !schemeAttrs.containsKey("xsj_custom_pgid")) {
            return "";
        }
        return schemeAttrs.get("xsj_custom_pgid");
    }

    public abstract String b();

    public void c(QCircleInitBean qCircleInitBean) {
        this.f86510a = qCircleInitBean;
    }
}
