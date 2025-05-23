package com.tencent.mobileqq.flock.publish.part;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/part/l;", "Lcom/tencent/mobileqq/flock/base/d;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "E9", "onInitView", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class l extends com.tencent.mobileqq.flock.base.d {
    static IPatchRedirector $redirector_;

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void E9(View rootView) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.e8v, (ViewGroup) null);
        ((ImageView) inflate.findViewById(R.id.du6)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.publish.part.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l.F9(l.this, view);
            }
        });
        ((ImageView) inflate.findViewById(R.id.f165918y20)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.publish.part.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l.G9(l.this, view);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        layoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getContext()) + cx.a(16.0f);
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) rootView).addView(inflate, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(l this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getActivity().onBackPressed();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(l this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        activity.setResult(101, activity.getIntent());
        activity.finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.flock.base.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
        } else {
            super.onInitView(rootView);
            E9(rootView);
        }
    }
}
