package com.tencent.mobileqq.flock.feedlist.part;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.api.FlockConstants$FlockListScene;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/flock/feedlist/part/h;", "Lcom/tencent/mobileqq/flock/feedcommon/part/d;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;", "e", "Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;", "getType", "()Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;", "type", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "ivBack", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "tvTitle", "i", "tvHomePage", "<init>", "(Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;)V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class h extends com.tencent.mobileqq.flock.feedcommon.part.d implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FlockConstants$FlockListScene type;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView ivBack;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView tvTitle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView tvHomePage;

    public h(@NotNull FlockConstants$FlockListScene type) {
        Intrinsics.checkNotNullParameter(type, "type");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) type);
        } else {
            this.type = type;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.du6) {
                getActivity().finish();
            } else if (num != null && num.intValue() == R.id.f108706du) {
                com.tencent.mobileqq.flock.a aVar = com.tencent.mobileqq.flock.a.f209993a;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                aVar.h(context);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.part.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.du6);
            ImageView imageView = (ImageView) findViewById;
            imageView.setOnClickListener(this);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<ImageView>(\u2026tTitlePart)\n            }");
            this.ivBack = imageView;
            View findViewById2 = rootView.findViewById(R.id.kbs);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_title)");
            TextView textView = (TextView) findViewById2;
            this.tvTitle = textView;
            FlockConstants$FlockListScene flockConstants$FlockListScene = this.type;
            if (flockConstants$FlockListScene == FlockConstants$FlockListScene.RECOM || flockConstants$FlockListScene == FlockConstants$FlockListScene.ACTIVITY) {
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
                    textView = null;
                }
                textView.setText("\u611f\u5174\u8da3\u7684\u642d\u5b50");
                View findViewById3 = rootView.findViewById(R.id.f108706du);
                TextView textView2 = (TextView) findViewById3;
                textView2.setVisibility(0);
                textView2.setOnClickListener(this);
                com.tencent.mobileqq.flock.datong.c.c(textView2, "em_bas_search_partner_mine");
                Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<TextView>(R\u2026      )\n                }");
                this.tvHomePage = textView2;
            }
        }
    }
}
