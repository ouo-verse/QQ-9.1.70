package com.tencent.mobileqq.nearbypro.map.debug;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bB\u001b\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\u001a\u0010\u001eB#\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b\u001a\u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u001a\u0010\f\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\nR\u0016\u0010\b\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/debug/DebugMockEditView;", "Landroid/widget/RelativeLayout;", "", "b", "", "title", "setTitle", "", "editText", "setEditText", "Lkotlin/Function1;", "block", "setSureTextClick", "Landroid/widget/EditText;", "d", "Landroid/widget/EditText;", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "titleTexView", "Landroid/widget/Button;", "f", "Landroid/widget/Button;", "sureTextView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class DebugMockEditView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private EditText editText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView titleTexView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Button sureTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugMockEditView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.fmz, (ViewGroup) this, true);
        b();
    }

    private final void b() {
        View findViewById = findViewById(R.id.ueq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.debug_edit)");
        this.editText = (EditText) findViewById;
        View findViewById2 = findViewById(R.id.uey);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.debug_title)");
        this.titleTexView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.uex);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.debug_text_sure)");
        this.sureTextView = (Button) findViewById3;
    }

    public final void setEditText(@NotNull CharSequence editText) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        EditText editText2 = this.editText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            editText2 = null;
        }
        editText2.setText(editText);
    }

    public final void setSureTextClick(@NotNull final Function1<? super String, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Button button = this.sureTextView;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sureTextView");
            button = null;
        }
        final long j3 = 200;
        final Button button2 = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.map.debug.DebugMockEditView$setSureTextClick$$inlined$setSingleClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EditText editText;
                EventCollector.getInstance().onViewClickedBefore(it);
                button2.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                editText = this.editText;
                if (editText == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editText");
                    editText = null;
                }
                String obj = editText.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    block.invoke(obj);
                }
                final View view = button2;
                view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.map.debug.DebugMockEditView$setSureTextClick$$inlined$setSingleClickListener$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
    }

    public final void setTitle(@NotNull String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        TextView textView = this.titleTexView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTexView");
            textView = null;
        }
        textView.setText(title);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugMockEditView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.fmz, (ViewGroup) this, true);
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugMockEditView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.fmz, (ViewGroup) this, true);
        b();
    }
}
