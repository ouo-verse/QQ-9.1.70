package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.widget.comment.CommentEditText;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0007B\u0013\b\u0016\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017B\u001d\b\u0016\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u0016\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0016\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\n\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/weight/GuildFeedInputBarCompatExpand;", "Landroid/widget/RelativeLayout;", "", "onFinishInflate", "", "longText", "showingPrePic", "a", "Landroid/view/View;", "d", "Landroid/view/View;", "textLimitTip", "e", "btnLayoutView", "Lcom/tencent/mobileqq/guild/feed/widget/comment/CommentEditText;", "f", "Lcom/tencent/mobileqq/guild/feed/widget/comment/CommentEditText;", "inputView", h.F, "picPreContainer", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedInputBarCompatExpand extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View textLimitTip;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View btnLayoutView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private CommentEditText inputView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View picPreContainer;

    public GuildFeedInputBarCompatExpand(@Nullable Context context) {
        super(context);
    }

    public final void a(boolean longText, boolean showingPrePic) {
        int i3;
        QLog.d("GuildFeedInputBarCompatExpand", 1, "[changeTextInputStyle] longText=" + longText + " showingPicPreview=" + showingPrePic);
        View view = this.btnLayoutView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnLayoutView");
            view = null;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        CommentEditText commentEditText = this.inputView;
        if (commentEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputView");
            commentEditText = null;
        }
        ViewGroup.LayoutParams layoutParams3 = commentEditText.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        View view3 = this.textLimitTip;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textLimitTip");
            view3 = null;
        }
        ViewGroup.LayoutParams layoutParams5 = view3.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) layoutParams5;
        layoutParams2.removeRule(3);
        layoutParams2.removeRule(8);
        layoutParams2.removeRule(15);
        layoutParams6.removeRule(8);
        layoutParams6.removeRule(1);
        layoutParams6.removeRule(5);
        layoutParams4.height = -2;
        if (!longText && !showingPrePic) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        layoutParams4.bottomMargin = cx.a(i3);
        if (!longText && !showingPrePic) {
            layoutParams2.addRule(15);
        } else if (showingPrePic) {
            layoutParams2.addRule(8, R.id.u2d);
            layoutParams6.addRule(8, R.id.u2d);
            layoutParams6.addRule(1, R.id.u2d);
        } else {
            layoutParams2.addRule(3, R.id.jha);
            layoutParams6.addRule(8, R.id.uc_);
            layoutParams6.addRule(5, R.id.jha);
        }
        View view4 = this.btnLayoutView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnLayoutView");
            view4 = null;
        }
        view4.setLayoutParams(layoutParams2);
        CommentEditText commentEditText2 = this.inputView;
        if (commentEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputView");
            commentEditText2 = null;
        }
        commentEditText2.setLayoutParams(layoutParams4);
        View view5 = this.textLimitTip;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textLimitTip");
        } else {
            view2 = view5;
        }
        view2.setLayoutParams(layoutParams6);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.wfn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guild_feed_word_length)");
        this.textLimitTip = findViewById;
        View findViewById2 = findViewById(R.id.uc_);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.ctrl_layout)");
        this.btnLayoutView = findViewById2;
        View findViewById3 = findViewById(R.id.jha);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.text_input)");
        this.inputView = (CommentEditText) findViewById3;
        View findViewById4 = findViewById(R.id.u2d);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.comment_top_container)");
        this.picPreContainer = findViewById4;
    }

    public GuildFeedInputBarCompatExpand(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
