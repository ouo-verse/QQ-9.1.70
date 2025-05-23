package com.tencent.mobileqq.springhb.prize;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.springhb.pack.PackInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\u0011\u0010\u0012J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/springhb/prize/d;", "Lcom/tencent/mobileqq/springhb/prize/SpringPrizeView;", "Lcom/tencent/mobileqq/springhb/pack/PackInfo;", "packInfo", "Landroid/view/View;", "prizeView", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "p", "Landroidx/fragment/app/FragmentActivity;", "i", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "d", "()I", "layoutId", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "j", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class d extends SpringPrizeView {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FragmentActivity activity;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/springhb/prize/d$a;", "", "", "CLICK_DELAY", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.prize.d$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61236);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull FragmentActivity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
        } else {
            this.activity = activity;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o(this$0.b().f289575j);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o(this$0.b().f289577l);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        h.i(this$0.b().f289566a);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.springhb.prize.SpringPrizeView
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.hqr;
    }

    @Override // com.tencent.mobileqq.springhb.prize.SpringPrizeView
    public void p(@NotNull PackInfo packInfo, @NotNull View prizeView, @NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, packInfo, prizeView, rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(packInfo, "packInfo");
        Intrinsics.checkNotNullParameter(prizeView, "prizeView");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.p(packInfo, prizeView, rootView);
        c().p((ImageView) prizeView.findViewById(R.id.vqw));
        if (!TextUtils.isEmpty(b().f289568c) && !TextUtils.isEmpty(b().f289575j) && !TextUtils.isEmpty(b().f289573h) && !TextUtils.isEmpty(b().f289574i)) {
            ((TextView) prizeView.findViewById(R.id.u2o)).setText(b().f289573h);
            ((TextView) prizeView.findViewById(R.id.f116636z_)).setText(b().f289574i);
            ((TextView) prizeView.findViewById(R.id.f27700gy)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.springhb.prize.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.v(d.this, view);
                }
            });
            ((TextView) prizeView.findViewById(R.id.sqj)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.springhb.prize.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.w(d.this, view);
                }
            });
            ((TextView) prizeView.findViewById(R.id.f27830ha)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.springhb.prize.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.x(d.this, view);
                }
            });
        } else {
            ((RelativeLayout) prizeView.findViewById(R.id.f165272ve2)).setVisibility(8);
        }
        ad.i("doudicard", true, null, 4, null);
    }
}
