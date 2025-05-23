package com.tencent.mobileqq.search.tux;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00198F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/search/tux/k;", "Lsn2/d;", "Landroid/view/View;", "getView", "view", "", "a", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", "getParentView", "()Landroid/view/ViewGroup;", "parentView", "Lcom/tencent/mobileqq/search/tux/i;", "e", "Lcom/tencent/mobileqq/search/tux/i;", "l", "()Lcom/tencent/mobileqq/search/tux/i;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/search/tux/i;)V", "tuxItem", "Landroid/widget/FrameLayout;", "f", "Landroid/widget/FrameLayout;", "contentView", "Landroid/app/Activity;", "j", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/view/ViewGroup;)V", tl.h.F, "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class k implements sn2.d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup parentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private i tuxItem;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout contentView;

    public k(@NotNull ViewGroup parentView) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        this.parentView = parentView;
    }

    public final void a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        FrameLayout frameLayout = this.contentView;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        FrameLayout frameLayout2 = this.contentView;
        if (frameLayout2 != null) {
            frameLayout2.addView(view, new ViewGroup.LayoutParams(-1, -2));
        }
    }

    @Override // sn2.d
    @NotNull
    public View getView() {
        FrameLayout frameLayout = this.contentView;
        if (frameLayout != null) {
            Intrinsics.checkNotNull(frameLayout);
            return frameLayout;
        }
        FrameLayout frameLayout2 = new FrameLayout(this.parentView.getContext());
        ViewExtKt.f(frameLayout2, jy2.f.f411169a.f(8));
        FrameLayout frameLayout3 = new FrameLayout(this.parentView.getContext());
        frameLayout3.setBackgroundColor(this.parentView.getContext().getColor(R.color.qui_common_fill_light_primary));
        this.contentView = frameLayout3;
        frameLayout2.addView(frameLayout3, new FrameLayout.LayoutParams(-1, -2));
        return frameLayout2;
    }

    @Nullable
    public final Activity j() {
        Context context = this.parentView.getContext();
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    @Nullable
    /* renamed from: l, reason: from getter */
    public final i getTuxItem() {
        return this.tuxItem;
    }

    public final void m(@Nullable i iVar) {
        this.tuxItem = iVar;
    }
}
