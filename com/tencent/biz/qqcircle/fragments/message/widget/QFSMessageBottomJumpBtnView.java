package com.tencent.biz.qqcircle.fragments.message.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m30.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017B\u001b\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u0016\u0010\u001aB#\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0016\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/biz/qqcircle/fragments/message/widget/QFSMessageBottomJumpBtnView;", "Landroid/widget/LinearLayout;", "", "d", "b", "a", "c", "", "drawableId", "setIconDrawable", "", "desc", "setDesc", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "iconView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "descView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "f", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSMessageBottomJumpBtnView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView iconView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView descView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QFSMessageBottomJumpBtnView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a() {
        TextView textView = null;
        this.descView = new TextView(getContext(), null, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginStart(cx.a(2.0f));
        TextView textView2 = this.descView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descView");
            textView2 = null;
        }
        textView2.setLayoutParams(layoutParams);
        TextView textView3 = this.descView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descView");
            textView3 = null;
        }
        textView3.setTextSize(1, 12.0f);
        TextView textView4 = this.descView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descView");
            textView4 = null;
        }
        textView4.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_primary, null));
        TextView textView5 = this.descView;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descView");
            textView5 = null;
        }
        textView5.setGravity(17);
        TextView textView6 = this.descView;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descView");
            textView6 = null;
        }
        textView6.setIncludeFontPadding(false);
        TextView textView7 = this.descView;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descView");
        } else {
            textView = textView7;
        }
        addView(textView);
    }

    private final void b() {
        ImageView imageView = null;
        ImageView imageView2 = new ImageView(getContext(), null, 0);
        this.iconView = imageView2;
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(cx.a(12.0f), cx.a(12.0f)));
        ImageView imageView3 = this.iconView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconView");
            imageView3 = null;
        }
        addView(imageView3);
        ImageView imageView4 = this.iconView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconView");
        } else {
            imageView = imageView4;
        }
        imageView.setColorFilter(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_primary));
    }

    private final void c() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = cx.a(10.0f);
        setLayoutParams(layoutParams);
        setGravity(17);
        setOrientation(0);
        setPadding(cx.a(12.0f), cx.a(6.0f), cx.a(12.0f), cx.a(6.0f));
        a.d(this);
    }

    private final void d() {
        c();
        b();
        a();
    }

    public final void setDesc(@NotNull String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        TextView textView = this.descView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descView");
            textView = null;
        }
        textView.setText(desc);
    }

    public final void setIconDrawable(int drawableId) {
        ImageView imageView = this.iconView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconView");
            imageView = null;
        }
        imageView.setImageDrawable(getContext().getResources().getDrawable(drawableId, null));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QFSMessageBottomJumpBtnView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSMessageBottomJumpBtnView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        d();
    }
}
