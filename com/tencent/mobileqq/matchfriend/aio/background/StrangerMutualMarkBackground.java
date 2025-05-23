package com.tencent.mobileqq.matchfriend.aio.background;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.matchfriend.aio.api.IStrangerAIOBackgroundApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.api.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J&\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/background/StrangerMutualMarkBackground;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/qqnt/aio/api/b;", "", "type", "", "backgroundResume", "backgroundPause", "left", "top", "right", "bottom", "a", "Lc51/a;", "d", "Lc51/a;", "binding", "Landroid/content/Context;", "ctx", "<init>", "(Landroid/content/Context;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class StrangerMutualMarkBackground extends RelativeLayout implements com.tencent.qqnt.aio.api.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private c51.a binding;

    public StrangerMutualMarkBackground(Context context) {
        super(context);
        IStrangerAIOBackgroundApi iStrangerAIOBackgroundApi = (IStrangerAIOBackgroundApi) QRoute.api(IStrangerAIOBackgroundApi.class);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        addView(iStrangerAIOBackgroundApi.getDefaultAIOBackground(context2));
        if (getContext() != null) {
            c51.a g16 = c51.a.g(LayoutInflater.from(getContext()), this, true);
            ViewGroup.LayoutParams layoutParams = g16.getRoot().getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.addRule(14);
                layoutParams2.addRule(12);
            }
            this.binding = g16;
        }
    }

    public final void a(int left, int top, int right, int bottom) {
        ConstraintLayout root;
        c51.a aVar = this.binding;
        if (aVar == null || (root = aVar.getRoot()) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.bottomMargin = Math.max(getBottom() - bottom, 0);
            root.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void backgroundPause() {
        b.C9449b.a(this);
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void backgroundResume() {
        b.C9449b.b(this);
    }

    @Override // com.tencent.qqnt.aio.api.b
    public ColorStateList getBgTextColor() {
        return b.C9449b.c(this);
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void notifyBackgourndUpdate() {
        b.C9449b.d(this);
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void notifyInputHeightChange(int i3) {
        b.C9449b.e(this, i3);
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void setAdapterNavigationBarImmersive(boolean z16) {
        b.C9449b.f(this, z16);
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void setInfo(String str, int i3, boolean z16) {
        b.C9449b.g(this, str, i3, z16);
    }

    @Override // com.tencent.qqnt.aio.api.b
    public void setOnBackgroundChangedListener(b.c cVar) {
        b.C9449b.h(this, cVar);
    }

    @Override // com.tencent.qqnt.aio.api.b
    public int type() {
        return 5;
    }
}
