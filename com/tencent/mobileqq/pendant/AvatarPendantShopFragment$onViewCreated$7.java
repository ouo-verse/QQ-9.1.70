package com.tencent.mobileqq.pendant;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "itemId", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
final class AvatarPendantShopFragment$onViewCreated$7 extends Lambda implements Function1<String, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ AppRuntime $app;
    final /* synthetic */ ImageView $redDot;
    final /* synthetic */ View $view;
    final /* synthetic */ AvatarPendantShopFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarPendantShopFragment$onViewCreated$7(AvatarPendantShopFragment avatarPendantShopFragment, AppRuntime appRuntime, View view, ImageView imageView) {
        super(1);
        this.this$0 = avatarPendantShopFragment;
        this.$app = appRuntime;
        this.$view = view;
        this.$redDot = imageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, avatarPendantShopFragment, appRuntime, view, imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ImageView redDot) {
        Intrinsics.checkNotNullParameter(redDot, "$redDot");
        redDot.setVisibility(0);
        redDot.setImageDrawable(ResourcesCompat.getDrawable(BaseApplication.getContext().getResources(), R.drawable.kf6, null));
        ViewGroup.LayoutParams layoutParams = redDot.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).topMargin = ViewUtils.dpToPx(8.0f) * (-1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull String itemId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) itemId);
            return;
        }
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        this.this$0.reportZPlanEntranceRedDotItemId = itemId;
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).reportAvatarEditEntranceRedDotData(this.$app, itemId, 101, 2);
        View view = this.$view;
        final ImageView imageView = this.$redDot;
        view.post(new Runnable() { // from class: com.tencent.mobileqq.pendant.j
            @Override // java.lang.Runnable
            public final void run() {
                AvatarPendantShopFragment$onViewCreated$7.b(imageView);
            }
        });
    }
}
