package com.tencent.ams.dynamicwidget.xjpage;

import android.annotation.SuppressLint;
import com.tencent.ams.dynamicwidget.BaseDynamicView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ams/dynamicwidget/xjpage/XJPageView;", "Lcom/tencent/ams/dynamicwidget/BaseDynamicView;", "Lcom/tencent/ams/mosaic/i;", "", NodeProps.ON_DETACHED_FROM_WINDOW, "", "templateId", "", ReportConstant.COSTREPORT_PREFIX, "lib_release"}, k = 1, mv = {1, 4, 0})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class XJPageView extends BaseDynamicView {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.dynamicwidget.BaseDynamicView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        com.tencent.ams.dynamicwidget.utils.b.f70218a.c(z(), NodeProps.ON_DETACHED_FROM_WINDOW);
        t();
        super.onDetachedFromWindow();
    }

    @Override // com.tencent.ams.dynamicwidget.BaseDynamicView
    public final boolean s(@Nullable String templateId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) templateId)).booleanValue();
        }
        return b.f70229c.a(templateId);
    }
}
