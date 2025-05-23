package com.tencent.mobileqq.zplan.aio;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!R\u0014\u0010\u0004\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR*\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u00168F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/ZPlanAioAvatarBubbleView;", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "contentView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "textView", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "emotionView", "", "value", h.F, "I", "getEmotion", "()I", "setEmotion", "(I)V", "emotion", "", "getText", "()Ljava/lang/CharSequence;", IECSearchBar.METHOD_SET_TEXT, "(Ljava/lang/CharSequence;)V", "text", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanAioAvatarBubbleView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout contentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final TextView textView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ImageView emotionView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int emotion;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanAioAvatarBubbleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        View findViewById = LayoutInflater.from(context).inflate(R.layout.d9u, this).findViewById(R.id.p_y);
        Intrinsics.checkNotNullExpressionValue(findViewById, "from(context).inflate(R.\u2026d(R.id.aio_avatar_bubble)");
        this.contentView = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R.id.f163284pa2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.aio_avatar_text)");
        this.textView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.p_z);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.aio_avatar_bubble_emotion)");
        this.emotionView = (ImageView) findViewById3;
    }

    public final void setText(CharSequence value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.textView.setText(value);
    }

    public final void setEmotion(int i3) {
        if (i3 == 0) {
            this.emotionView.setVisibility(8);
        } else if (i3 == 1) {
            this.emotionView.setImageResource(R.drawable.idy);
            this.emotionView.setVisibility(0);
        }
        this.emotion = i3;
    }
}
