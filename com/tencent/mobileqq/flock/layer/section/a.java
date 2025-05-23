package com.tencent.mobileqq.flock.layer.section;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends Section<RFWLayerItemMediaInfo> {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[0];
    }

    /* renamed from: onBindData, reason: avoid collision after fix types in other method */
    protected void onBindData2(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, int i3, List<Object> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, this, rFWLayerItemMediaInfo, Integer.valueOf(i3), list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            return;
        }
        View view2 = new View(view.getContext());
        view2.setBackground(ResourcesCompat.getDrawable(view.getResources(), R.drawable.jmk, null));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ImmersiveUtils.dpToPx(200.0f));
        layoutParams.gravity = 80;
        ((ViewGroup) view).addView(view2, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public /* bridge */ /* synthetic */ void onBindData(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, int i3, List list) {
        onBindData2(rFWLayerItemMediaInfo, i3, (List<Object>) list);
    }
}
