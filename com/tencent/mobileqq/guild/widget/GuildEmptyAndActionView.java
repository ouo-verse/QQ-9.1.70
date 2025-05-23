package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b#\u0010$J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildEmptyAndActionView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "tips", "", "setTips", "actionText", "setActionTv", "Landroid/graphics/drawable/Drawable;", "drawable", "setActionIcon", "Landroid/view/View$OnClickListener;", "l", "setActionListener", "setActionBg", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "tipsTv", "e", "actionTv", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "actionContainer", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "actionIv", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildEmptyAndActionView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView tipsTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView actionTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout actionContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView actionIv;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildEmptyAndActionView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(View.OnClickListener l3, GuildEmptyAndActionView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(l3, "$l");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l3.onClick(this$0.actionContainer);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void setActionBg(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.actionContainer.setBackground(drawable);
    }

    public final void setActionIcon(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.actionIv.setImageDrawable(drawable);
    }

    public final void setActionListener(@NotNull final View.OnClickListener l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.actionContainer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.widget.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildEmptyAndActionView.A0(l3, this, view);
            }
        });
    }

    public final void setActionTv(@NotNull String actionText) {
        Intrinsics.checkNotNullParameter(actionText, "actionText");
        this.actionTv.setText(actionText);
    }

    public final void setTips(@NotNull String tips) {
        Intrinsics.checkNotNullParameter(tips, "tips");
        this.tipsTv.setText(tips);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildEmptyAndActionView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildEmptyAndActionView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildEmptyAndActionView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.emf, this);
        setBackgroundResource(R.drawable.guild_empty_and_action_bg);
        View findViewById = findViewById(R.id.jnf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tips_tv)");
        this.tipsTv = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.s_7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.action_tv)");
        this.actionTv = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.s9f);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.action_ll)");
        this.actionContainer = (LinearLayout) findViewById3;
        View findViewById4 = findViewById(R.id.s9e);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.action_img)");
        this.actionIv = (ImageView) findViewById4;
        this.actionContainer.setBackground(GuildUIUtils.f235378a.l(context.getColor(R.color.qui_button_bg_secondary_default), kotlin.g.a(context.getColor(R.color.qui_button_bg_secondary_default), 15), 100.0f));
    }
}
