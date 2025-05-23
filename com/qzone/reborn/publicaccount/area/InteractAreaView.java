package com.qzone.reborn.publicaccount.area;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.reborn.publicaccount.i;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$InteractionInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/publicaccount/area/InteractAreaView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "", "template", "", "b", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$InteractionInfo;", "info", "a", "d", "Landroid/content/Context;", "mContext", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mLookIconView", "f", "mCommentIconView", h.F, "mLikeIconView", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mLookTextView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mCommentTextView", BdhLogUtil.LogTag.Tag_Conn, "mLikeTextView", "<init>", "(Landroid/content/Context;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class InteractAreaView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mLikeTextView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mLookIconView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mCommentIconView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mLikeIconView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mLookTextView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mCommentTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractAreaView(Context context, int i3) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        b(context, i3);
    }

    private final void b(Context context, int template) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.cnj, this);
        View findViewById = findViewById(R.id.kbl);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.icon_first_area)");
        this.mLookIconView = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.kdw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.icon_second_area)");
        this.mCommentIconView = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.f162740ke0);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.icon_third_area)");
        this.mLikeIconView = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.ngp);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.text_first_area)");
        this.mLookTextView = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.ngr);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.text_second_area)");
        this.mCommentTextView = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.ngs);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.text_third_area)");
        this.mLikeTextView = (TextView) findViewById6;
        i iVar = i.f58780a;
        TextView textView = null;
        if (iVar.c(template)) {
            ImageView imageView = this.mLookIconView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLookIconView");
                imageView = null;
            }
            imageView.setImageDrawable(getContext().getDrawable(R.drawable.f16546_));
            ImageView imageView2 = this.mCommentIconView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentIconView");
                imageView2 = null;
            }
            imageView2.setImageDrawable(getContext().getDrawable(R.drawable.qui_comment_icon_white));
            ImageView imageView3 = this.mLikeIconView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLikeIconView");
                imageView3 = null;
            }
            imageView3.setImageDrawable(getContext().getDrawable(R.drawable.f165268));
            TextView textView2 = this.mLookTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLookTextView");
                textView2 = null;
            }
            textView2.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_allwhite_primary));
            TextView textView3 = this.mCommentTextView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentTextView");
                textView3 = null;
            }
            textView3.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_allwhite_primary));
            TextView textView4 = this.mLikeTextView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLikeTextView");
            } else {
                textView = textView4;
            }
            textView.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_allwhite_primary));
            return;
        }
        if (iVar.d(template)) {
            ImageView imageView4 = this.mLookIconView;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLookIconView");
                imageView4 = null;
            }
            imageView4.setImageDrawable(getContext().getDrawable(R.drawable.f165369));
            ImageView imageView5 = this.mCommentIconView;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentIconView");
                imageView5 = null;
            }
            imageView5.setImageDrawable(getContext().getDrawable(R.drawable.qui_comment_icon_secondary));
            ImageView imageView6 = this.mLikeIconView;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLikeIconView");
                imageView6 = null;
            }
            imageView6.setImageDrawable(getContext().getDrawable(R.drawable.f165167));
            TextView textView5 = this.mLookTextView;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLookTextView");
                textView5 = null;
            }
            textView5.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_secondary));
            TextView textView6 = this.mCommentTextView;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentTextView");
                textView6 = null;
            }
            textView6.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_secondary));
            TextView textView7 = this.mLikeTextView;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLikeTextView");
            } else {
                textView = textView7;
            }
            textView.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_secondary));
        }
    }

    public final void a(QZoneOfficialAccountBase$InteractionInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        TextView textView = this.mLookTextView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLookTextView");
            textView = null;
        }
        i iVar = i.f58780a;
        textView.setText(iVar.b(info.view_count.get()));
        TextView textView3 = this.mCommentTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentTextView");
            textView3 = null;
        }
        textView3.setText(iVar.b(info.comment_count.get()));
        TextView textView4 = this.mLikeTextView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLikeTextView");
        } else {
            textView2 = textView4;
        }
        textView2.setText(iVar.b(info.like_count.get()));
    }
}
