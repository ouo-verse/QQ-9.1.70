package com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.recyclerview.sections;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerLiteActionModel;
import com.tencent.mobileqq.matchfriend.reborn.utils.p;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J*\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/recyclerview/sections/k;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/recyclerview/sections/a;", "Landroid/view/View;", "mRootView", "", "onInitView", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "inputData", "", "position", "", "", "payload", "t", "", "getViewStubLayoutId", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "f", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "feedPicView", tl.h.F, "Landroid/view/View;", "feedTextViewRoot", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "feedTextView", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class k extends a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RoundCornerImageView feedPicView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View feedTextViewRoot;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView feedTextView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onBindData(QQStrangerLiteActionModel inputData, int position, List<Object> payload) {
        s(position);
        if (inputData == null) {
            return;
        }
        r(inputData);
        Resources resources = this.mRootView.getResources();
        if (resources == null) {
            return;
        }
        TextView textView = null;
        if (getData().getMsgInfo().getIsFeedDeleted()) {
            View view = this.feedTextViewRoot;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedTextViewRoot");
                view = null;
            }
            view.setVisibility(0);
            TextView textView2 = this.feedTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedTextView");
                textView2 = null;
            }
            textView2.setVisibility(0);
            RoundCornerImageView roundCornerImageView = this.feedPicView;
            if (roundCornerImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedPicView");
                roundCornerImageView = null;
            }
            roundCornerImageView.setVisibility(8);
            View view2 = this.feedTextViewRoot;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedTextViewRoot");
                view2 = null;
            }
            view2.setBackgroundResource(R.drawable.f7y);
            TextView textView3 = this.feedTextView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedTextView");
                textView3 = null;
            }
            textView3.setGravity(17);
            TextView textView4 = this.feedTextView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedTextView");
            } else {
                textView = textView4;
            }
            textView.setText("\u52a8\u6001\n\u5df2\u5220\u9664");
            return;
        }
        if (getData().getMsgInfo().getPic().length() == 0) {
            View view3 = this.feedTextViewRoot;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedTextViewRoot");
                view3 = null;
            }
            view3.setVisibility(0);
            TextView textView5 = this.feedTextView;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedTextView");
                textView5 = null;
            }
            textView5.setVisibility(0);
            RoundCornerImageView roundCornerImageView2 = this.feedPicView;
            if (roundCornerImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedPicView");
                roundCornerImageView2 = null;
            }
            roundCornerImageView2.setVisibility(8);
            View view4 = this.feedTextViewRoot;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedTextViewRoot");
                view4 = null;
            }
            view4.setBackground(null);
            TextView textView6 = this.feedTextView;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedTextView");
                textView6 = null;
            }
            textView6.setGravity(8388611);
            TextView textView7 = this.feedTextView;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedTextView");
            } else {
                textView = textView7;
            }
            textView.setText(((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(getData().getMsgInfo().getContent(), 16));
            return;
        }
        View view5 = this.feedTextViewRoot;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedTextViewRoot");
            view5 = null;
        }
        view5.setVisibility(8);
        TextView textView8 = this.feedTextView;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedTextView");
            textView8 = null;
        }
        textView8.setVisibility(8);
        RoundCornerImageView roundCornerImageView3 = this.feedPicView;
        if (roundCornerImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPicView");
            roundCornerImageView3 = null;
        }
        roundCornerImageView3.setVisibility(0);
        RoundCornerImageView roundCornerImageView4 = this.feedPicView;
        if (roundCornerImageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPicView");
            roundCornerImageView4 = null;
        }
        p.a(roundCornerImageView4, getData().getMsgInfo().getPic(), ResourcesCompat.getDrawable(resources, R.drawable.b9s, null), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View mRootView) {
        if (mRootView != null) {
            this.mRootView = mRootView;
            View findViewById = mRootView.findViewById(R.id.oo7);
            Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.qqs\u2026nger_lite_quote_pic_feed)");
            RoundCornerImageView roundCornerImageView = (RoundCornerImageView) findViewById;
            this.feedPicView = roundCornerImageView;
            RoundCornerImageView roundCornerImageView2 = null;
            if (roundCornerImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedPicView");
                roundCornerImageView = null;
            }
            roundCornerImageView.setBorder(false);
            RoundCornerImageView roundCornerImageView3 = this.feedPicView;
            if (roundCornerImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedPicView");
                roundCornerImageView3 = null;
            }
            roundCornerImageView3.setCorner(com.tencent.qqnt.aio.utils.l.b(4));
            RoundCornerImageView roundCornerImageView4 = this.feedPicView;
            if (roundCornerImageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedPicView");
                roundCornerImageView4 = null;
            }
            roundCornerImageView4.setScaleType(ImageView.ScaleType.CENTER_CROP);
            RoundCornerImageView roundCornerImageView5 = this.feedPicView;
            if (roundCornerImageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedPicView");
            } else {
                roundCornerImageView2 = roundCornerImageView5;
            }
            roundCornerImageView2.setBackgroundColor(0);
            View findViewById2 = mRootView.findViewById(R.id.oo8);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.qqs\u2026ger_lite_quote_text_feed)");
            this.feedTextViewRoot = findViewById2;
            View findViewById3 = mRootView.findViewById(R.id.oo9);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "it.findViewById(R.id.qqs\u2026_quote_text_feed_content)");
            this.feedTextView = (TextView) findViewById3;
        }
    }
}
