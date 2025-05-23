package com.tencent.mobileqq.hermes.layer.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.avatar.meta.b;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/hermes/layer/part/b;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "d", "J", "ranking", "<init>", "()V", "hermes-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class b extends RFWLayerBasePart {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long ranking;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.ranking = Long.MIN_VALUE;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        if (this.ranking < 0) {
            return;
        }
        View findViewById = rootView.findViewById(R.id.x9n);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026lery_head_rank_container)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        linearLayout.setVisibility(0);
        View findViewById2 = linearLayout.findViewById(R.id.x9s);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "avatarAndRankContainer.f\u2026(R.id.hermes_head_avatar)");
        String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "sMobileQQ.peekAppRuntime().currentAccountUin");
        ((QQProAvatarView) findViewById2).A(new b.a(1, currentAccountUin, 140, true).b());
        View findViewById3 = linearLayout.findViewById(R.id.x9u);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "avatarAndRankContainer.f\u2026d.hermes_head_ranking_tv)");
        ((TextView) findViewById3).setText("NO." + com.tencent.mobileqq.hermes.util.a.f236827a.a(this.ranking));
    }

    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        this.ranking = com.tencent.mobileqq.hermes.util.a.f236827a.c();
    }
}
