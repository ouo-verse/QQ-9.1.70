package com.tencent.mobileqq.guild.discoveryv2.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u001d\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\u0006H\u0014J\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nR\u0016\u0010\u0011\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/widget/MiddleEllipSingleLineTextView;", "Landroid/widget/TextView;", "", "width", "", "reason", "", "b", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "", "name", "separator", "endText", IECSearchBar.METHOD_SET_TEXT, "d", "Ljava/lang/CharSequence;", "firstText", "e", "f", "Landroid/view/View$OnLayoutChangeListener;", h.F, "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChangeListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes13.dex */
public final class MiddleEllipSingleLineTextView extends TextView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CharSequence firstText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CharSequence endText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CharSequence separator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnLayoutChangeListener onLayoutChangeListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MiddleEllipSingleLineTextView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b(int width, String reason) {
        boolean z16;
        if (width > 0) {
            if (this.endText.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                CharSequence charSequence = this.separator;
                CharSequence charSequence2 = this.endText;
                StringBuilder sb5 = new StringBuilder();
                sb5.append((Object) charSequence);
                sb5.append((Object) charSequence2);
                setText(new SpannableStringBuilder().append(TextUtils.ellipsize(this.firstText, getPaint(), width - Layout.getDesiredWidth(sb5.toString(), getPaint()), TextUtils.TruncateAt.END)).append(this.separator).append(this.endText));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MiddleEllipSingleLineTextView this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i29 = i17 - i3;
        if (i29 != i27 - i19 && !o.c("MiddleEllipSingleLineTextView")) {
            this$0.b(i29, "OnLayoutChangeListener");
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        addOnLayoutChangeListener(this.onLayoutChangeListener);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        removeOnLayoutChangeListener(this.onLayoutChangeListener);
        super.onDetachedFromWindow();
    }

    public final void setText(@NotNull CharSequence name, @NotNull CharSequence separator, @NotNull CharSequence endText) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(endText, "endText");
        this.firstText = name;
        this.endText = endText;
        this.separator = separator;
        setText(new SpannableStringBuilder().append(name).append(separator).append(endText));
        b(getMeasuredWidth(), IECSearchBar.METHOD_SET_TEXT);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MiddleEllipSingleLineTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.firstText = "";
        this.endText = "";
        this.separator = " ";
        this.onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.widget.e
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                MiddleEllipSingleLineTextView.c(MiddleEllipSingleLineTextView.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        };
    }

    public /* synthetic */ MiddleEllipSingleLineTextView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}
