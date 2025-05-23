package com.tencent.mobileqq.main.api.impl;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.main.api.IMainUIHelperApi;
import com.tencent.mobileqq.main.api.b;
import com.tencent.mobileqq.main.api.c;
import com.tencent.mobileqq.main.api.d;
import com.tencent.mobileqq.resconfig.MainResourceConfig;
import g72.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/main/api/impl/MainUIHelperApiImpl;", "Lcom/tencent/mobileqq/main/api/IMainUIHelperApi;", "Lcom/tencent/mobileqq/app/Frame;", AIInput.KEY_FRAME, "Landroid/widget/RelativeLayout;", "titleArea", "Lcom/tencent/mobileqq/resconfig/MainResourceConfig;", "resConfig", "", "updateHeight", "", "updateTitleBar", "Lcom/tencent/mobileqq/main/api/d;", "proxy", "", "Lcom/tencent/mobileqq/main/api/c;", "list", "Lcom/tencent/mobileqq/main/api/b;", "getFrameHost", "Lcom/tencent/mobileqq/main/api/a;", "param", "updateAccessibilitySeq", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MainUIHelperApiImpl implements IMainUIHelperApi {
    @Override // com.tencent.mobileqq.main.api.IMainUIHelperApi
    public b getFrameHost(d proxy, List<? extends c> list) {
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(list, "list");
        return new a(proxy, list);
    }

    @Override // com.tencent.mobileqq.main.api.IMainUIHelperApi
    public void updateAccessibilitySeq(com.tencent.mobileqq.main.api.a param) {
        Intrinsics.checkNotNullParameter(param, "param");
        View a16 = param.a();
        int id5 = a16 != null ? a16.getId() : 0;
        View c16 = param.c();
        int id6 = c16 != null ? c16.getId() : 0;
        View e16 = param.e();
        int id7 = e16 != null ? e16.getId() : 0;
        View d16 = param.d();
        int id8 = d16 != null ? d16.getId() : 0;
        View b16 = param.b();
        int id9 = b16 != null ? b16.getId() : 0;
        View a17 = param.a();
        if (a17 != null) {
            a17.setAccessibilityTraversalAfter(id9);
        }
        View d17 = param.d();
        if (d17 != null) {
            d17.setAccessibilityTraversalAfter(id5);
        }
        View e17 = param.e();
        if (e17 != null) {
            e17.setAccessibilityTraversalAfter(id8);
        }
        View c17 = param.c();
        if (c17 != null) {
            c17.setAccessibilityTraversalAfter(id7);
        }
        View b17 = param.b();
        if (b17 != null) {
            b17.setAccessibilityTraversalAfter(id6);
        }
        View b18 = param.b();
        if (b18 != null) {
            b18.setAccessibilityTraversalBefore(id5);
        }
        View a18 = param.a();
        if (a18 != null) {
            a18.setAccessibilityTraversalBefore(id8);
        }
        View d18 = param.d();
        if (d18 != null) {
            d18.setAccessibilityTraversalBefore(id7);
        }
        View e18 = param.e();
        if (e18 != null) {
            e18.setAccessibilityTraversalBefore(id6);
        }
        View c18 = param.c();
        if (c18 == null) {
            return;
        }
        c18.setAccessibilityTraversalBefore(id9);
    }

    @Override // com.tencent.mobileqq.main.api.IMainUIHelperApi
    public void updateTitleBar(Frame frame, RelativeLayout titleArea, MainResourceConfig resConfig, boolean updateHeight) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        Intrinsics.checkNotNullParameter(titleArea, "titleArea");
        Intrinsics.checkNotNullParameter(resConfig, "resConfig");
        if (frame.getActivity() == null) {
            return;
        }
        QBaseActivity activity = frame.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "frame.activity");
        titleArea.setBackground(resConfig.p(activity, titleArea.getBackground()));
        if (updateHeight) {
            QBaseActivity activity2 = frame.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity2, "frame.activity");
            int q16 = resConfig.q(activity2);
            if (titleArea.getLayoutParams() == null) {
                titleArea.setLayoutParams(new FrameLayout.LayoutParams(-1, q16));
            } else {
                titleArea.getLayoutParams().height = q16;
            }
        }
    }
}
