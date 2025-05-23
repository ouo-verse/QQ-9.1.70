package com.tencent.mobileqq.qqlive.anchor.beauty.widget;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.anchor.beauty.model.CategoryItem;

/* compiled from: P */
/* loaded from: classes17.dex */
public class BeautyGroupEventor extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;
    public CategoryItem.a data;

    public BeautyGroupEventor(CategoryItem.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.data = aVar;
        }
    }
}
