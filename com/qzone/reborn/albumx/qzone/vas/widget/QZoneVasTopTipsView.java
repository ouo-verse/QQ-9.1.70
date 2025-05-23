package com.qzone.reborn.albumx.qzone.vas.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.reborn.albumx.qzone.vas.widget.QZoneVasTopTipsView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qzone.picload.c;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import j33.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010.\u001a\u00020\u0002\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fR\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010)\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$\u00a8\u00061"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/vas/widget/QZoneVasTopTipsView;", "Landroid/widget/FrameLayout;", "", "drawableRes", "", "setIcon", "", "actionText", "setActionText", "content", "setContent", "Landroid/view/View$OnClickListener;", "onClickListener", "setJumpListener", "setCloseListener", "", "isVisible", "setActionTextVisible", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "getTvContent", "()Landroid/widget/TextView;", "setTvContent", "(Landroid/widget/TextView;)V", "tvContent", "e", "getTvAction", "setTvAction", "tvAction", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "getIvClose", "()Landroid/widget/ImageView;", "setIvClose", "(Landroid/widget/ImageView;)V", "ivClose", h.F, "getIvIcon", "setIvIcon", "ivIcon", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneVasTopTipsView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView tvContent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvAction;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView ivClose;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView ivIcon;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneVasTopTipsView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(QZoneVasTopTipsView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setVisibility(8);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(View.OnClickListener onClickListener, QZoneVasTopTipsView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(onClickListener, "$onClickListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        onClickListener.onClick(view);
        this$0.setVisibility(8);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void setActionText(String actionText) {
        Intrinsics.checkNotNullParameter(actionText, "actionText");
        this.tvAction.setText(actionText);
        setActionTextVisible(true);
    }

    public final void setActionTextVisible(boolean isVisible) {
        this.tvAction.setVisibility(isVisible ? 0 : 8);
    }

    public final void setCloseListener(final View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.ivClose.setOnClickListener(new View.OnClickListener() { // from class: pa.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneVasTopTipsView.d(onClickListener, this, view);
            }
        });
    }

    public final void setContent(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.tvContent.setText(content);
    }

    public final void setIcon(int drawableRes) {
        this.ivIcon.setImageResource(drawableRes);
    }

    public final void setIvClose(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivClose = imageView;
    }

    public final void setIvIcon(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivIcon = imageView;
    }

    public final void setJumpListener(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.tvAction.setOnClickListener(onClickListener);
    }

    public final void setTvAction(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvAction = textView;
    }

    public final void setTvContent(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvContent = textView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneVasTopTipsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QZoneVasTopTipsView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneVasTopTipsView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.hla, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(co\u2026degrade_tip_layout, this)");
        a aVar = a.f409200a;
        inflate.setBackgroundColor(aVar.b());
        View findViewById = inflate.findViewById(R.id.f69033hn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "tipsContainer.findViewBy\u2026o_degrade_tip_close_icon)");
        this.ivClose = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.f69053hp);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "tipsContainer.findViewBy\u2026e_photo_degrade_tip_icon)");
        this.ivIcon = (ImageView) findViewById2;
        c.a().m(this.ivClose, aVar.f());
        View findViewById3 = inflate.findViewById(R.id.f69023hm);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "tipsContainer.findViewBy\u2026_degrade_tip_action_text)");
        TextView textView = (TextView) findViewById3;
        this.tvAction = textView;
        textView.setTextColor(aVar.f());
        View findViewById4 = inflate.findViewById(R.id.f69043ho);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "tipsContainer.findViewBy\u2026degrade_tip_content_text)");
        TextView textView2 = (TextView) findViewById4;
        this.tvContent = textView2;
        textView2.setTextColor(aVar.g());
        fo.c.q(this.ivClose, "em_qz_notice_strip_close", null);
        this.ivClose.setOnClickListener(new View.OnClickListener() { // from class: pa.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneVasTopTipsView.c(QZoneVasTopTipsView.this, view);
            }
        });
        fo.c.n(this.tvAction, "em_qz_notice_strip");
    }
}
