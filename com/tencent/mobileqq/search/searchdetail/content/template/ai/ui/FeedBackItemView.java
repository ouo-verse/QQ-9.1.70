package com.tencent.mobileqq.search.searchdetail.content.template.ai.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.searchdetail.multimedia.p;
import hp2.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/ui/FeedBackItemView;", "Landroid/widget/LinearLayout;", "", "a", "content", "", "setContent", "", "b", "checked", "setState", "Lhp2/m;", "d", "Lhp2/m;", "viewBinding", "e", "Z", "isChecked", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class FeedBackItemView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private m viewBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isChecked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedBackItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        m g16 = m.g(LayoutInflater.from(context), null, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), null, false)");
        this.viewBinding = g16;
        addView(g16.getRoot());
    }

    @NotNull
    public final String a() {
        return this.viewBinding.f405696b.getText().toString();
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }

    public final void setContent(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.viewBinding.f405696b.setText(content);
    }

    public final void setState(boolean checked) {
        this.isChecked = checked;
        if (checked) {
            this.viewBinding.getRoot().setBackgroundResource(R.drawable.f161143k42);
            m mVar = this.viewBinding;
            mVar.f405696b.setTextColor(mVar.getRoot().getResources().getColor(R.color.qui_common_brand_standard));
        } else {
            this.viewBinding.getRoot().setBackgroundResource(R.drawable.f161142k41);
            m mVar2 = this.viewBinding;
            mVar2.f405696b.setTextColor(mVar2.getRoot().getResources().getColor(R.color.qui_common_text_primary));
        }
        ImageView imageView = this.viewBinding.f405697c;
        Intrinsics.checkNotNullExpressionValue(imageView, "viewBinding.selectedIcon");
        p.b(imageView, checked);
    }
}
