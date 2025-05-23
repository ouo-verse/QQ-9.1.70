package nl;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.util.Utils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J(\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lnl/h;", "Lnl/b;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "Lkl/a;", "data", "", "position", "", "", "payload", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", tl.h.F, "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "mMessageTv", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "mLikeIv", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class h extends b {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneRichTextView mMessageTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mLikeIv;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void onBindData(kl.a data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        QZoneRichTextView qZoneRichTextView = this.mMessageTv;
        if (qZoneRichTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMessageTv");
            qZoneRichTextView = null;
        }
        qZoneRichTextView.setRichText(ll.a.d(ll.a.f414984a, data.getCom.tenpay.sdk.util.UinConfigManager.KEY_ADS java.lang.String().noticeMessage, null, 2, null));
        QZoneRichTextView qZoneRichTextView2 = this.mMessageTv;
        if (qZoneRichTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMessageTv");
            qZoneRichTextView2 = null;
        }
        QZoneRichTextView qZoneRichTextView3 = this.mMessageTv;
        if (qZoneRichTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMessageTv");
            qZoneRichTextView3 = null;
        }
        int n3 = Utils.n(4.0f, qZoneRichTextView3.getResources());
        ViewGroup.LayoutParams layoutParams = qZoneRichTextView2.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams2 = qZoneRichTextView2.getLayoutParams();
            int i3 = layoutParams2 != null ? layoutParams2.width : -2;
            ViewGroup.LayoutParams layoutParams3 = qZoneRichTextView2.getLayoutParams();
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i3, layoutParams3 != null ? layoutParams3.height : -2);
        }
        if (n3 != marginLayoutParams.leftMargin) {
            marginLayoutParams.leftMargin = n3;
            qZoneRichTextView2.setLayoutParams(marginLayoutParams);
        }
        ImageView imageView = this.mLikeIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLikeIv");
            imageView = null;
        }
        imageView.setVisibility(0);
        ImageView imageView2 = this.mLikeIv;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLikeIv");
            imageView2 = null;
        }
        imageView2.setImageDrawable(p().getResources().getDrawable(R.drawable.qui_like, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.n7r);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026(R.id.qzone_message_text)");
        this.mMessageTv = (QZoneRichTextView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.n7t);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026.qzone_message_text_icon)");
        this.mLikeIv = (ImageView) findViewById2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.n8o};
    }
}
