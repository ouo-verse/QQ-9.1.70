package com.tencent.mobileqq.gamecenter.qa.metadream;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\b\u001a\u00020\u0006R$\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/metadream/b;", "", "Landroid/view/ViewGroup;", "parentView", "Landroid/view/View$OnClickListener;", "listener", "", "b", "a", "Landroid/view/View;", "Landroid/view/View;", "getMRootView", "()Landroid/view/View;", "setMRootView", "(Landroid/view/View;)V", "mRootView", "<init>", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mRootView;

    public final void a() {
        View view = this.mRootView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public final void b(@NotNull ViewGroup parentView, @Nullable View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        ViewParent viewParent = null;
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(parentView.getContext()).inflate(R.layout.fhb, (ViewGroup) null);
        }
        View view = this.mRootView;
        if (view != null) {
            view.setOnClickListener(listener);
        }
        View view2 = this.mRootView;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = this.mRootView;
        if (view3 != null) {
            viewParent = view3.getParent();
        }
        if (Intrinsics.areEqual(viewParent, parentView)) {
            return;
        }
        parentView.addView(this.mRootView, new ViewGroup.LayoutParams(-1, -1));
    }
}
