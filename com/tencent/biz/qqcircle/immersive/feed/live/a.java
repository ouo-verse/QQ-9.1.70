package com.tencent.biz.qqcircle.immersive.feed.live;

import android.view.View;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/live/a;", "", "", "isNewStyle", "", "a", "Landroid/view/View;", "Landroid/view/View;", "topMask", "b", "bottomMask", "<init>", "(Landroid/view/View;Landroid/view/View;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View topMask;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View bottomMask;

    public a(@NotNull View topMask, @NotNull View bottomMask) {
        Intrinsics.checkNotNullParameter(topMask, "topMask");
        Intrinsics.checkNotNullParameter(bottomMask, "bottomMask");
        this.topMask = topMask;
        this.bottomMask = bottomMask;
    }

    public final void a(boolean isNewStyle) {
        if (isNewStyle) {
            this.topMask.setVisibility(8);
            this.bottomMask.getLayoutParams().height = ViewUtils.dip2px(308.0f);
            View view = this.bottomMask;
            view.setBackground(ContextCompat.getDrawable(view.getContext(), R.drawable.kka));
            return;
        }
        this.topMask.setVisibility(0);
        this.bottomMask.getLayoutParams().height = ViewUtils.dip2px(240.0f);
        View view2 = this.bottomMask;
        view2.setBackground(ContextCompat.getDrawable(view2.getContext(), R.drawable.kjh));
    }
}
