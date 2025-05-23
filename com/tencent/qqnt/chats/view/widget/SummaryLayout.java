package com.tencent.qqnt.chats.view.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.chats.utils.ChatsColorCache;
import com.tencent.qqnt.chats.view.a;
import com.tencent.qqnt.chats.view.api.ISummaryApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u00101\u001a\u000200\u00a2\u0006\u0004\b2\u00103B\u001b\b\u0016\u0012\u0006\u00101\u001a\u000200\u0012\b\u00105\u001a\u0004\u0018\u000104\u00a2\u0006\u0004\b2\u00106B#\b\u0016\u0012\u0006\u00101\u001a\u000200\u0012\b\u00105\u001a\u0004\u0018\u000104\u0012\u0006\u00107\u001a\u00020\u0013\u00a2\u0006\u0004\b2\u00108J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0013H\u0016J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0019\u0010\u0019\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001dH\u0016R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0014\u0010'\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\"R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010\"R\u0014\u0010/\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010*\u00a8\u00069"}, d2 = {"Lcom/tencent/qqnt/chats/view/widget/SummaryLayout;", "Landroid/widget/LinearLayout;", "Lcom/tencent/qqnt/chats/view/a;", "", "c", "", "nick", "setSummaryNick", "content", "setSummaryContent", "Landroid/graphics/drawable/Drawable;", "drawable", "setSummaryStatus", "", "prefix", "setSummaryPrefix", "Landroid/content/res/ColorStateList;", "color", "setSummaryPrefixColor", "", "setSummaryTextColor", "Landroid/graphics/Shader;", "shader", "setSummaryContentShader", "sendStatus", "setSummarySendStatus", "(Ljava/lang/Integer;)V", "Landroid/graphics/Paint;", "a", "", "resetSummary", "b", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "nickView", "e", "contentView", "f", "colonView", "Landroid/widget/ImageView;", h.F, "Landroid/widget/ImageView;", "stateImageView", "i", "highLightView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "sendStateView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class SummaryLayout extends LinearLayout implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView nickView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView contentView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView colonView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView stateImageView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView highLightView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView sendStateView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SummaryLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        ISummaryApi iSummaryApi = (ISummaryApi) companion.a(ISummaryApi.class);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        TextView summartContentTextView = iSummaryApi.getSummartContentTextView(context2);
        summartContentTextView.setTextColor(summartContentTextView.getContext().getResources().getColor(R.color.qui_common_text_secondary));
        summartContentTextView.setTextSize(14.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        summartContentTextView.setLayoutParams(layoutParams);
        summartContentTextView.setMaxLines(1);
        summartContentTextView.setEllipsize(TextUtils.TruncateAt.END);
        summartContentTextView.setGravity(16);
        summartContentTextView.setIncludeFontPadding(false);
        this.nickView = summartContentTextView;
        ISummaryApi iSummaryApi2 = (ISummaryApi) companion.a(ISummaryApi.class);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        TextView summartContentTextView2 = iSummaryApi2.getSummartContentTextView(context3);
        summartContentTextView2.setTextColor(summartContentTextView2.getContext().getResources().getColor(R.color.qui_common_text_secondary));
        summartContentTextView2.setTextSize(14.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        summartContentTextView2.setLayoutParams(layoutParams2);
        summartContentTextView2.setMaxLines(1);
        summartContentTextView2.setEllipsize(TextUtils.TruncateAt.END);
        summartContentTextView2.setGravity(16);
        summartContentTextView2.setIncludeFontPadding(false);
        this.contentView = summartContentTextView2;
        TextView textView = new TextView(getContext());
        textView.setTextColor(textView.getContext().getResources().getColor(R.color.qui_common_text_secondary));
        textView.setTextSize(14.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        textView.setLayoutParams(layoutParams3);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(16);
        textView.setIncludeFontPadding(false);
        this.colonView = textView;
        ImageView imageView = new ImageView(getContext());
        int dpToPx = ViewUtils.dpToPx(16.0f);
        int dpToPx2 = ViewUtils.dpToPx(2.0f);
        int i3 = dpToPx + (dpToPx2 * 2);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i3, i3);
        layoutParams4.gravity = 16;
        imageView.setLayoutParams(layoutParams4);
        imageView.setPadding(dpToPx2, dpToPx2, dpToPx2, dpToPx2);
        this.stateImageView = imageView;
        TextView textView2 = new TextView(getContext());
        textView2.setTextColor(textView2.getContext().getResources().getColor(R.color.qui_common_text_secondary));
        textView2.setTextSize(14.0f);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        textView2.setLayoutParams(layoutParams5);
        textView2.setMaxLines(1);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setGravity(16);
        textView2.setIncludeFontPadding(false);
        this.highLightView = textView2;
        ImageView imageView2 = new ImageView(getContext());
        int dpToPx3 = ViewUtils.dpToPx(16.0f);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(dpToPx3, dpToPx3);
        layoutParams6.gravity = 16;
        layoutParams6.setMargins(0, 0, ViewUtils.dpToPx(2.0f), 0);
        imageView2.setLayoutParams(layoutParams6);
        this.sendStateView = imageView2;
        c();
    }

    private final void c() {
        addView(this.stateImageView);
        addView(this.highLightView);
        addView(this.nickView);
        addView(this.colonView);
        addView(this.sendStateView);
        addView(this.contentView);
    }

    @Override // com.tencent.qqnt.chats.view.a
    @NotNull
    public Paint a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Paint) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        TextPaint paint = this.contentView.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "contentView.paint");
        return paint;
    }

    @Override // com.tencent.qqnt.chats.view.a
    public void b(boolean resetSummary) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, resetSummary);
            return;
        }
        ChatsColorCache chatsColorCache = ChatsColorCache.f355526a;
        Context context = this.highLightView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "highLightView.context");
        ColorStateList g16 = chatsColorCache.g(context);
        this.highLightView.setTextColor(g16);
        this.highLightView.setText("");
        if (resetSummary) {
            this.contentView.setText("");
        }
        this.contentView.setTextColor(g16);
        this.nickView.setText("");
        this.nickView.setTextColor(g16);
        this.colonView.setText("");
        this.colonView.setTextColor(g16);
        this.stateImageView.setVisibility(8);
        this.sendStateView.setVisibility(8);
    }

    @Override // com.tencent.qqnt.chats.view.a
    public void setSummaryAllContent(@NotNull CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) charSequence);
        } else {
            a.C9601a.b(this, charSequence);
        }
    }

    @Override // com.tencent.qqnt.chats.view.a
    public void setSummaryContent(@NotNull CharSequence content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) content);
        } else {
            Intrinsics.checkNotNullParameter(content, "content");
            this.contentView.setText(content);
        }
    }

    @Override // com.tencent.qqnt.chats.view.a
    public void setSummaryContentShader(@Nullable Shader shader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) shader);
        } else {
            this.contentView.getPaint().setShader(shader);
        }
    }

    @Override // com.tencent.qqnt.chats.view.a
    public void setSummaryNick(@NotNull CharSequence nick) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) nick);
            return;
        }
        Intrinsics.checkNotNullParameter(nick, "nick");
        this.nickView.setText(((ISummaryApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(ISummaryApi.class)).getSummaryNick(nick));
        if (nick.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.colonView.setText(MsgSummary.STR_COLON);
            this.colonView.setVisibility(0);
        } else {
            this.colonView.setText("");
            this.colonView.setVisibility(8);
        }
    }

    public void setSummaryPrefix(@NotNull String prefix) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) prefix);
        } else {
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            this.highLightView.setText(prefix);
        }
    }

    public void setSummaryPrefixColor(@NotNull ColorStateList color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) color);
        } else {
            Intrinsics.checkNotNullParameter(color, "color");
            this.highLightView.setTextColor(color);
        }
    }

    @Override // com.tencent.qqnt.chats.view.a
    public void setSummarySendStatus(@Nullable Integer sendStatus) {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) sendStatus);
            return;
        }
        if (sendStatus != null) {
            Drawable c16 = com.tencent.qqnt.chats.biz.summary.msg.a.c(this.sendStateView.getContext().getResources(), sendStatus.intValue());
            if (c16 != null) {
                this.sendStateView.setImageDrawable(c16);
                this.sendStateView.setVisibility(0);
            } else {
                this.sendStateView.setImageDrawable(null);
                this.sendStateView.setVisibility(8);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.sendStateView.setImageDrawable(null);
            this.sendStateView.setVisibility(8);
        }
    }

    @Override // com.tencent.qqnt.chats.view.a
    public void setSummaryStatus(@Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) drawable);
            return;
        }
        this.stateImageView.setImageDrawable(drawable);
        if (drawable == null) {
            this.stateImageView.setVisibility(8);
        } else {
            this.stateImageView.setVisibility(0);
        }
    }

    @Override // com.tencent.qqnt.chats.view.a
    public void setSummaryTextColor(int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, color);
            return;
        }
        this.contentView.setTextColor(color);
        this.nickView.setTextColor(color);
        this.colonView.setTextColor(color);
    }

    @Override // com.tencent.qqnt.chats.view.a
    public void setSummaryPrefix(@NotNull CharSequence prefix) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) prefix);
        } else {
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            this.highLightView.setText(prefix);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SummaryLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        ISummaryApi iSummaryApi = (ISummaryApi) companion.a(ISummaryApi.class);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        TextView summartContentTextView = iSummaryApi.getSummartContentTextView(context2);
        summartContentTextView.setTextColor(summartContentTextView.getContext().getResources().getColor(R.color.qui_common_text_secondary));
        summartContentTextView.setTextSize(14.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        summartContentTextView.setLayoutParams(layoutParams);
        summartContentTextView.setMaxLines(1);
        summartContentTextView.setEllipsize(TextUtils.TruncateAt.END);
        summartContentTextView.setGravity(16);
        summartContentTextView.setIncludeFontPadding(false);
        this.nickView = summartContentTextView;
        ISummaryApi iSummaryApi2 = (ISummaryApi) companion.a(ISummaryApi.class);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        TextView summartContentTextView2 = iSummaryApi2.getSummartContentTextView(context3);
        summartContentTextView2.setTextColor(summartContentTextView2.getContext().getResources().getColor(R.color.qui_common_text_secondary));
        summartContentTextView2.setTextSize(14.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        summartContentTextView2.setLayoutParams(layoutParams2);
        summartContentTextView2.setMaxLines(1);
        summartContentTextView2.setEllipsize(TextUtils.TruncateAt.END);
        summartContentTextView2.setGravity(16);
        summartContentTextView2.setIncludeFontPadding(false);
        this.contentView = summartContentTextView2;
        TextView textView = new TextView(getContext());
        textView.setTextColor(textView.getContext().getResources().getColor(R.color.qui_common_text_secondary));
        textView.setTextSize(14.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        textView.setLayoutParams(layoutParams3);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(16);
        textView.setIncludeFontPadding(false);
        this.colonView = textView;
        ImageView imageView = new ImageView(getContext());
        int dpToPx = ViewUtils.dpToPx(16.0f);
        int dpToPx2 = ViewUtils.dpToPx(2.0f);
        int i3 = dpToPx + (dpToPx2 * 2);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i3, i3);
        layoutParams4.gravity = 16;
        imageView.setLayoutParams(layoutParams4);
        imageView.setPadding(dpToPx2, dpToPx2, dpToPx2, dpToPx2);
        this.stateImageView = imageView;
        TextView textView2 = new TextView(getContext());
        textView2.setTextColor(textView2.getContext().getResources().getColor(R.color.qui_common_text_secondary));
        textView2.setTextSize(14.0f);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        textView2.setLayoutParams(layoutParams5);
        textView2.setMaxLines(1);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setGravity(16);
        textView2.setIncludeFontPadding(false);
        this.highLightView = textView2;
        ImageView imageView2 = new ImageView(getContext());
        int dpToPx3 = ViewUtils.dpToPx(16.0f);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(dpToPx3, dpToPx3);
        layoutParams6.gravity = 16;
        layoutParams6.setMargins(0, 0, ViewUtils.dpToPx(2.0f), 0);
        imageView2.setLayoutParams(layoutParams6);
        this.sendStateView = imageView2;
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SummaryLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        ISummaryApi iSummaryApi = (ISummaryApi) companion.a(ISummaryApi.class);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        TextView summartContentTextView = iSummaryApi.getSummartContentTextView(context2);
        summartContentTextView.setTextColor(summartContentTextView.getContext().getResources().getColor(R.color.qui_common_text_secondary));
        summartContentTextView.setTextSize(14.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        summartContentTextView.setLayoutParams(layoutParams);
        summartContentTextView.setMaxLines(1);
        summartContentTextView.setEllipsize(TextUtils.TruncateAt.END);
        summartContentTextView.setGravity(16);
        summartContentTextView.setIncludeFontPadding(false);
        this.nickView = summartContentTextView;
        ISummaryApi iSummaryApi2 = (ISummaryApi) companion.a(ISummaryApi.class);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        TextView summartContentTextView2 = iSummaryApi2.getSummartContentTextView(context3);
        summartContentTextView2.setTextColor(summartContentTextView2.getContext().getResources().getColor(R.color.qui_common_text_secondary));
        summartContentTextView2.setTextSize(14.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        summartContentTextView2.setLayoutParams(layoutParams2);
        summartContentTextView2.setMaxLines(1);
        summartContentTextView2.setEllipsize(TextUtils.TruncateAt.END);
        summartContentTextView2.setGravity(16);
        summartContentTextView2.setIncludeFontPadding(false);
        this.contentView = summartContentTextView2;
        TextView textView = new TextView(getContext());
        textView.setTextColor(textView.getContext().getResources().getColor(R.color.qui_common_text_secondary));
        textView.setTextSize(14.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        textView.setLayoutParams(layoutParams3);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(16);
        textView.setIncludeFontPadding(false);
        this.colonView = textView;
        ImageView imageView = new ImageView(getContext());
        int dpToPx = ViewUtils.dpToPx(16.0f);
        int dpToPx2 = ViewUtils.dpToPx(2.0f);
        int i16 = dpToPx + (dpToPx2 * 2);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i16, i16);
        layoutParams4.gravity = 16;
        imageView.setLayoutParams(layoutParams4);
        imageView.setPadding(dpToPx2, dpToPx2, dpToPx2, dpToPx2);
        this.stateImageView = imageView;
        TextView textView2 = new TextView(getContext());
        textView2.setTextColor(textView2.getContext().getResources().getColor(R.color.qui_common_text_secondary));
        textView2.setTextSize(14.0f);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        textView2.setLayoutParams(layoutParams5);
        textView2.setMaxLines(1);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setGravity(16);
        textView2.setIncludeFontPadding(false);
        this.highLightView = textView2;
        ImageView imageView2 = new ImageView(getContext());
        int dpToPx3 = ViewUtils.dpToPx(16.0f);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(dpToPx3, dpToPx3);
        layoutParams6.gravity = 16;
        layoutParams6.setMargins(0, 0, ViewUtils.dpToPx(2.0f), 0);
        imageView2.setLayoutParams(layoutParams6);
        this.sendStateView = imageView2;
        c();
    }
}
