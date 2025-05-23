package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J(\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/section/b;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/section/a;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", "data", "", "position", "", "", "payload", "w", "d", "Landroid/view/View;", "divider", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b extends a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View divider;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.ojo);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColorStateList(containerView.getContext(), R.color.qui_common_bg_bottom_standard));
        findViewById.setBackground(gradientDrawable);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026)\n            }\n        }");
        this.divider = findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void onBindData(FeedPB$Feed data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        View view = this.divider;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("divider");
            view = null;
        }
        view.setVisibility(position == 0 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }
}
