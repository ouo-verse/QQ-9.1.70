package com.tencent.luggage.wxa.g6;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\b"}, d2 = {"Lcom/tencent/luggage/wxa/g6/o;", "Lcom/tencent/luggage/wxa/g6/r;", "", "b", "Lcom/tencent/luggage/wxa/g6/t;", "controller", "<init>", "(Lcom/tencent/luggage/wxa/g6/t;)V", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public abstract class o extends r {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@NotNull t controller) {
        super(controller);
        Intrinsics.checkNotNullParameter(controller, "controller");
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void b() {
        super.b();
        if (getContext() instanceof Activity) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            Activity activity = (Activity) context;
            activity.overridePendingTransition(0, 0);
            View decorView = activity.getWindow().getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
            decorView.setSystemUiVisibility(1280);
            activity.getWindow().setStatusBarColor(activity.getResources().getColor(17170445));
        }
    }
}
