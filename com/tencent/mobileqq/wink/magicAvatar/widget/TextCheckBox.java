package com.tencent.mobileqq.wink.magicAvatar.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.magicAvatar.widget.TextCheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmetersdk.export.config.TuxQuestionType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bR?\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/widget/TextCheckBox;", "Landroid/widget/LinearLayout;", "", "b", "", "d", "checked", "setChecked", "", "text", IECSearchBar.METHOD_SET_TEXT, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isChecked", "Lkotlin/jvm/functions/Function1;", "getOnClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onClickListener", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "e", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "getCheckbox", "()Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "setCheckbox", "(Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;)V", TuxQuestionType.QUESTION_OPTION_CHECKBOX, "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "textView", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class TextCheckBox extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super Boolean, Unit> onClickListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUICheckBox checkbox;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView textView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TextCheckBox(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    private final void b() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.i4x, (ViewGroup) this, true);
        this.checkbox = (QUICheckBox) inflate.findViewById(R.id.tum);
        this.textView = (TextView) inflate.findViewById(R.id.jfb);
        setOnClickListener(new View.OnClickListener() { // from class: k83.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextCheckBox.c(TextCheckBox.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(TextCheckBox this$0, View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUICheckBox qUICheckBox = this$0.checkbox;
        if (qUICheckBox != null) {
            z16 = qUICheckBox.isChecked();
        } else {
            z16 = false;
        }
        QUICheckBox qUICheckBox2 = this$0.checkbox;
        if (qUICheckBox2 != null) {
            qUICheckBox2.setChecked(!z16);
        }
        Function1<? super Boolean, Unit> function1 = this$0.onClickListener;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(!z16));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final boolean d() {
        QUICheckBox qUICheckBox = this.checkbox;
        if (qUICheckBox != null) {
            return qUICheckBox.isChecked();
        }
        return false;
    }

    public final void setCheckbox(@Nullable QUICheckBox qUICheckBox) {
        this.checkbox = qUICheckBox;
    }

    public final void setChecked(boolean checked) {
        QUICheckBox qUICheckBox = this.checkbox;
        if (qUICheckBox != null) {
            qUICheckBox.setChecked(checked);
        }
    }

    public final void setOnClickListener(@Nullable Function1<? super Boolean, Unit> function1) {
        this.onClickListener = function1;
    }

    public final void setText(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        TextView textView = this.textView;
        if (textView != null) {
            textView.setText(text);
        }
    }

    public final void setTextView(@Nullable TextView textView) {
        this.textView = textView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TextCheckBox(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ TextCheckBox(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TextCheckBox(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        setOrientation(0);
        b();
    }
}
