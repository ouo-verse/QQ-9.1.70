package com.tencent.mobileqq.flock.homepage.part;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/flock/homepage/part/d;", "Lcom/tencent/mobileqq/flock/feedcommon/part/d;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "v", NodeProps.ON_CLICK, "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "ivBack", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "tvTitle", h.F, "tvHomePage", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class d extends com.tencent.mobileqq.flock.feedcommon.part.d implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView ivBack;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tvTitle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView tvHomePage;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.du6) {
                getActivity().finish();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.part.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.du6);
            ImageView imageView = (ImageView) findViewById;
            imageView.setOnClickListener(this);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<ImageView>(\u2026eTitlePart)\n            }");
            this.ivBack = imageView;
            View findViewById2 = rootView.findViewById(R.id.kbs);
            TextView textView = (TextView) findViewById2;
            textView.setText("\u6211\u7684\u642d\u5b50");
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<TextView?>(\u2026xt = \"\u6211\u7684\u642d\u5b50\"\n            }");
            this.tvTitle = textView;
            View findViewById3 = rootView.findViewById(R.id.f108706du);
            TextView textView2 = (TextView) findViewById3;
            textView2.setVisibility(8);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<TextView>(R\u2026= View.GONE\n            }");
            this.tvHomePage = textView2;
        }
    }
}
