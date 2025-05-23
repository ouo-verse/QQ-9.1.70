package com.tencent.qqnt.aio.assistedchat.aiservice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.CapabilityInjector;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u001a\u0010\u0013\u001a\u00020\u00068\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u00148\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/aiservice/AIServiceListItem;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "visibility", "", "setIconVisibility", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "text", "f", "desc", tl.h.F, "z0", "()Landroid/widget/ImageView;", "question", "Landroid/widget/CompoundButton;", "i", "Landroid/widget/CompoundButton;", "A0", "()Landroid/widget/CompoundButton;", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIServiceListItem extends ConstraintLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView icon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView text;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView desc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView question;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CompoundButton switch;

    public /* synthetic */ AIServiceListItem(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    @NotNull
    public final CompoundButton A0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CompoundButton) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.switch;
    }

    public final void setIconVisibility(int visibility) {
        ConstraintLayout.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, visibility);
            return;
        }
        this.icon.setVisibility(visibility);
        ViewGroup.LayoutParams layoutParams2 = this.text.getLayoutParams();
        if (layoutParams2 instanceof ConstraintLayout.LayoutParams) {
            layoutParams = (ConstraintLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            if (visibility == 8) {
                layoutParams.leftToLeft = 0;
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = 0;
            } else {
                layoutParams.leftToRight = this.icon.getId();
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = com.tencent.qqnt.aio.utils.l.b(12);
            }
            this.text.setLayoutParams(layoutParams);
        }
    }

    @NotNull
    public final ImageView z0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ImageView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.question;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIServiceListItem(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        ImageView imageView = new ImageView(context);
        imageView.setId(R.id.f66173_x);
        int dimensionPixelSize = imageView.getResources().getDimensionPixelSize(R.dimen.dac);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.leftToLeft = 0;
        layoutParams.topToTop = R.id.f66203a0;
        layoutParams.bottomToBottom = R.id.f66203a0;
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(R.drawable.qui_ai_chat);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.icon = imageView;
        TextView textView = new TextView(context);
        textView.setId(R.id.f66203a0);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams2.leftToRight = R.id.f66173_x;
        layoutParams2.topToTop = 0;
        layoutParams2.bottomToTop = R.id.f66163_w;
        layoutParams2.verticalChainStyle = 2;
        textView.setLayoutParams(layoutParams2);
        textView.setTextSize(0, textView.getResources().getDimension(R.dimen.dag));
        textView.setTextColor(ContextCompat.getColorStateList(context, R.color.qui_common_text_primary));
        textView.setText("AI\u670d\u52a1");
        this.text = textView;
        TextView textView2 = new TextView(context);
        textView2.setId(R.id.f66163_w);
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams3.leftToLeft = R.id.f66203a0;
        layoutParams3.topToBottom = R.id.f66203a0;
        layoutParams3.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = com.tencent.qqnt.aio.utils.l.b(4);
        textView2.setLayoutParams(layoutParams3);
        textView2.setTextSize(0, textView2.getResources().getDimension(R.dimen.da_));
        textView2.setTextColor(ContextCompat.getColorStateList(context, R.color.qui_common_text_secondary));
        textView2.setText("\u5c06\u4e3a\u4f60\u63d0\u4f9b\u56de\u590d\u63a8\u8350\u7b49\u670d\u52a1");
        this.desc = textView2;
        ImageView imageView2 = new ImageView(context);
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(com.tencent.qqnt.aio.utils.l.b(14), com.tencent.qqnt.aio.utils.l.b(14));
        layoutParams4.leftToRight = R.id.f66163_w;
        layoutParams4.topToTop = R.id.f66163_w;
        layoutParams4.bottomToBottom = R.id.f66163_w;
        ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = com.tencent.qqnt.aio.utils.l.b(2);
        imageView2.setLayoutParams(layoutParams4);
        imageView2.setImageResource(R.drawable.qui_question_mark_circle_icon_secondary);
        imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.question = imageView2;
        CompoundButton invoke = CapabilityInjector.f316927a.b().invoke(context);
        invoke.setId(R.id.f66283a8);
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams5.rightToRight = 0;
        layoutParams5.topToTop = 0;
        layoutParams5.bottomToBottom = 0;
        invoke.setLayoutParams(layoutParams5);
        this.switch = invoke;
        setPadding(com.tencent.qqnt.aio.utils.l.b(16), 0, com.tencent.qqnt.aio.utils.l.b(16), 0);
        addView(imageView);
        addView(textView);
        addView(textView2);
        addView(imageView2);
        addView(invoke);
        int b16 = com.tencent.qqnt.aio.utils.l.b(12);
        AIOUtil.f194084a.e(imageView2, b16, b16, b16, b16);
    }
}
