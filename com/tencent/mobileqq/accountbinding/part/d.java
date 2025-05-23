package com.tencent.mobileqq.accountbinding.part;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.register.bean.WechatInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/accountbinding/part/d;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "d", "Lcom/tencent/mobileqq/register/bean/WechatInfo;", "getWechatInfo", "()Lcom/tencent/mobileqq/register/bean/WechatInfo;", "wechatInfo", "<init>", "(Lcom/tencent/mobileqq/register/bean/WechatInfo;)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class d extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WechatInfo wechatInfo;

    public d(@NotNull WechatInfo wechatInfo) {
        Intrinsics.checkNotNullParameter(wechatInfo, "wechatInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) wechatInfo);
        } else {
            this.wechatInfo = wechatInfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z9(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.a47);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.accountbinding.part.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.z9(d.this, view);
                }
            });
        }
        TextView textView = (TextView) rootView.findViewById(R.id.f1062968b);
        TextView textView2 = (TextView) rootView.findViewById(R.id.f1063068c);
        String f16 = this.wechatInfo.f();
        if (f16 != null && f16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            textView.setText(R.string.f200964tj);
            textView2.setText(R.string.f200974tk);
        } else {
            textView.setText(R.string.f200934tg);
            textView2.setText(R.string.f200944th);
        }
    }
}
