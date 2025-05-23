package com.tencent.mobileqq.guild.discoveryv2.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 /2\u00020\u0001:\u0001\u0005B'\b\u0007\u0012\u0006\u0010)\u001a\u00020(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010,\u001a\u00020\n\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0014\u0010\u0011\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fJ\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0014R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010'\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/widget/GuildLabelsView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildLabel;", "label", "Landroid/widget/TextView;", "a", "", "d", "", "b", "", "widthMeasureSpec", "heightMeasureSpec", "e", "c", "", "labels", "setLabels", "onMeasure", "", UserInfo.SEX_FEMALE, "textSize", "Landroid/content/res/ColorStateList;", "Landroid/content/res/ColorStateList;", "textColor", "", "f", "Z", "getEmphasizeNumber", "()Z", "setEmphasizeNumber", "(Z)V", "emphasizeNumber", h.F, "I", "getSepHorizontalPadding", "()I", "setSepHorizontalPadding", "(I)V", "sepHorizontalPadding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildLabelsView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float textSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ColorStateList textColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean emphasizeNumber;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int sepHorizontalPadding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildLabelsView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final TextView a(IGProGuildLabel label) {
        TextView textView = new TextView(getContext());
        textView.setText(d(label));
        textView.setTextSize(0, textView.getTextSize());
        textView.setTextColor(this.textColor);
        textView.setMaxLines(1);
        addView(textView);
        return textView;
    }

    private final void b() {
        TextView textView = new TextView(getContext());
        textView.setText("\u2022");
        textView.setTextSize(0, textView.getTextSize());
        textView.setTextColor(this.textColor);
        addView(textView);
        int i3 = this.sepHorizontalPadding;
        textView.setPadding(i3, 0, i3, 0);
    }

    private final void c(int widthMeasureSpec) {
        TextView textView;
        int coerceAtLeast;
        if (getChildCount() < 3) {
            return;
        }
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        View childAt = getChildAt(0);
        if (childAt instanceof TextView) {
            textView = (TextView) childAt;
        } else {
            textView = null;
        }
        TextView textView2 = textView;
        if (textView2 == null) {
            return;
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(size - (((getChildAt(1).getMeasuredWidth() + getChildAt(2).getMeasuredWidth()) + getPaddingStart()) + getPaddingEnd()), 0);
        textView2.setMaxWidth(coerceAtLeast);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        measureChildWithMargins(textView2, widthMeasureSpec, 0, 0, 0);
    }

    private final CharSequence d(IGProGuildLabel label) {
        byte[] labelName = label.getLabelName();
        Intrinsics.checkNotNullExpressionValue(labelName, "label.labelName");
        String str = new String(labelName, Charsets.UTF_8);
        GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String colorToken = label.getColorToken();
        Intrinsics.checkNotNullExpressionValue(colorToken, "label.colorToken");
        CharSequence f16 = guildUIUtils.f(context, str, colorToken);
        if (this.emphasizeNumber) {
            return guildUIUtils.s(f16);
        }
        return f16;
    }

    private final void e(int widthMeasureSpec, int heightMeasureSpec) {
        if (getChildCount() < 3) {
            return;
        }
        int childCount = getChildCount();
        for (int i3 = 1; i3 < childCount; i3++) {
            measureChildWithMargins(getChildAt(i3), widthMeasureSpec, 0, heightMeasureSpec, 0);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        e(widthMeasureSpec, heightMeasureSpec);
        c(widthMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public final void setEmphasizeNumber(boolean z16) {
        this.emphasizeNumber = z16;
    }

    public final void setLabels(@NotNull List<? extends IGProGuildLabel> labels) {
        int lastIndex;
        Intrinsics.checkNotNullParameter(labels, "labels");
        removeAllViews();
        if (labels.isEmpty()) {
            return;
        }
        int i3 = 0;
        if (labels.size() == 1) {
            a(labels.get(0)).setEllipsize(TextUtils.TruncateAt.END);
            return;
        }
        for (Object obj : labels) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            a((IGProGuildLabel) obj);
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(labels);
            if (i3 != lastIndex) {
                b();
            }
            i3 = i16;
        }
    }

    public final void setSepHorizontalPadding(int i3) {
        this.sepHorizontalPadding = i3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildLabelsView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildLabelsView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildLabelsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.textSize = 12.0f;
        this.sepHorizontalPadding = 10;
        setOrientation(0);
        setGravity(16);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.f439517h4);
        this.textSize = obtainStyledAttributes.getDimension(up1.a.f439530i4, 12.0f);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(up1.a.f439543j4);
        if (colorStateList == null) {
            colorStateList = context.getColorStateList(R.color.qui_common_text_primary);
            Intrinsics.checkNotNullExpressionValue(colorStateList, "context.getColorStateLis\u2026.qui_common_text_primary)");
        }
        this.textColor = colorStateList;
        obtainStyledAttributes.recycle();
    }
}
