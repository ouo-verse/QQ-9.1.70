package com.tencent.mobileqq.aio.reserve1.navigation;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.reserve1.navigation.d;
import com.tencent.mobileqq.aio.reserve1.navigation.view.AioNavAnimView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/mobileqq/aio/reserve1/navigation/view/AioNavAnimView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class NavigationVB$navBar$2 extends Lambda implements Function0<AioNavAnimView> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ NavigationVB this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavigationVB$navBar$2(NavigationVB navigationVB) {
        super(0);
        this.this$0 = navigationVB;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) navigationVB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(NavigationVB this$0, View view) {
        long j3;
        HashMap hashMap;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long currentTimeMillis = System.currentTimeMillis();
        j3 = this$0.lastClickTime;
        if (currentTimeMillis - j3 > 500) {
            QLog.d("NavigationVB", 1, "navBar onClick");
            this$0.sendIntent(d.a.f193324d);
            this$0.lastClickTime = currentTimeMillis;
        }
        hashMap = this$0.currentReportParams;
        if (hashMap != null) {
            com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_small_ears", hashMap);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final AioNavAnimView invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AioNavAnimView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        AioNavAnimView aioNavAnimView = new AioNavAnimView(this.this$0.getMContext());
        final NavigationVB navigationVB = this.this$0;
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.topToBottom = R.id.f100035re;
        layoutParams.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = aioNavAnimView.getContext().getResources().getDimensionPixelSize(R.dimen.f158238c02);
        aioNavAnimView.setLayoutParams(layoutParams);
        aioNavAnimView.setId(R.id.siz);
        aioNavAnimView.setVisibility(8);
        aioNavAnimView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.reserve1.navigation.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NavigationVB$navBar$2.b(NavigationVB.this, view);
            }
        });
        aioNavAnimView.setFrom(1);
        return aioNavAnimView;
    }
}
