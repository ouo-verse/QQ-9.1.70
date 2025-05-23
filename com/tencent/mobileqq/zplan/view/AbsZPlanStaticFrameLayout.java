package com.tencent.mobileqq.zplan.view;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0001H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zplan/view/AbsZPlanStaticFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/widget/ImageView;", "a", "b", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class AbsZPlanStaticFrameLayout extends FrameLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsZPlanStaticFrameLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @NotNull
    public abstract ImageView a();

    @NotNull
    public abstract FrameLayout b();
}
