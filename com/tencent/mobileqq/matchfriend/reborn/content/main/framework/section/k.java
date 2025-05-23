package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J(\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/section/k;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/section/a;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", "data", "", "position", "", "", "payload", "w", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "textTv", "<init>", "()V", "e", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class k extends a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView textTv;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.ore);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.text)");
        this.textTv = (TextView) findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void onBindData(FeedPB$Feed data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        String d16 = u72.a.d(data);
        TextView textView = null;
        if (d16.length() == 0) {
            TextView textView2 = this.textTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textTv");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView3 = this.textTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textTv");
            textView3 = null;
        }
        textView3.setVisibility(0);
        TextView textView4 = this.textTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textTv");
        } else {
            textView = textView4;
        }
        textView.setText(com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.a.b(d16.toString(), p()).getTextContent());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.or9};
    }
}
