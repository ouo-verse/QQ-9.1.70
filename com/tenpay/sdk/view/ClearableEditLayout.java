package com.tenpay.sdk.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.sdk.view.ClearableEditLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0012B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tenpay/sdk/view/ClearableEditLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "clearBtn", "Landroid/widget/ImageButton;", "<set-?>", "Lcom/tenpay/sdk/view/ClearableEditLayout$DelegateEditText;", "innerEditText", "getInnerEditText", "()Lcom/tenpay/sdk/view/ClearableEditLayout$DelegateEditText;", "initClearButton", "", "initEditText", "manageClearButton", "DelegateEditText", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class ClearableEditLayout extends LinearLayout {

    @NotNull
    private final ImageButton clearBtn;

    @NotNull
    private DelegateEditText innerEditText;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tenpay/sdk/view/ClearableEditLayout$DelegateEditText;", "Lcom/tenpay/sdk/view/TenpayEditText;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "customFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "customTextWatcher", "Landroid/text/TextWatcher;", "observerStateChange", "Lkotlin/Function0;", "", "getObserverStateChange", "()Lkotlin/jvm/functions/Function0;", "setObserverStateChange", "(Lkotlin/jvm/functions/Function0;)V", "addTextChangedListener", "watcher", "setOnFocusChangeListener", "listener", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class DelegateEditText extends TenpayEditText {

        @Nullable
        private View.OnFocusChangeListener customFocusChangeListener;

        @Nullable
        private TextWatcher customTextWatcher;

        @Nullable
        private Function0<Unit> observerStateChange;

        public /* synthetic */ DelegateEditText(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, (i3 & 2) != 0 ? null : attributeSet);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$0(DelegateEditText this$0, View view, boolean z16) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Function0<Unit> function0 = this$0.observerStateChange;
            if (function0 != null) {
                function0.invoke();
            }
            View.OnFocusChangeListener onFocusChangeListener = this$0.customFocusChangeListener;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(view, z16);
            }
        }

        @Override // android.widget.TextView
        public void addTextChangedListener(@Nullable TextWatcher watcher) {
            this.customTextWatcher = watcher;
        }

        @Nullable
        public final Function0<Unit> getObserverStateChange() {
            return this.observerStateChange;
        }

        public final void setObserverStateChange(@Nullable Function0<Unit> function0) {
            this.observerStateChange = function0;
        }

        @Override // android.view.View
        public void setOnFocusChangeListener(@Nullable View.OnFocusChangeListener listener) {
            this.customFocusChangeListener = listener;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DelegateEditText(@NotNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            Intrinsics.checkNotNullParameter(context, "context");
            super.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tenpay.sdk.view.b
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z16) {
                    ClearableEditLayout.DelegateEditText._init_$lambda$0(ClearableEditLayout.DelegateEditText.this, view, z16);
                }
            });
            super.addTextChangedListener(new TextWatcher() { // from class: com.tenpay.sdk.view.ClearableEditLayout.DelegateEditText.2
                @Override // android.text.TextWatcher
                public void afterTextChanged(@Nullable Editable s16) {
                    TextWatcher textWatcher = DelegateEditText.this.customTextWatcher;
                    if (textWatcher != null) {
                        textWatcher.afterTextChanged(s16);
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
                    TextWatcher textWatcher = DelegateEditText.this.customTextWatcher;
                    if (textWatcher != null) {
                        textWatcher.beforeTextChanged(s16, start, count, after);
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
                    Function0<Unit> observerStateChange = DelegateEditText.this.getObserverStateChange();
                    if (observerStateChange != null) {
                        observerStateChange.invoke();
                    }
                    TextWatcher textWatcher = DelegateEditText.this.customTextWatcher;
                    if (textWatcher != null) {
                        textWatcher.onTextChanged(s16, start, before, count);
                    }
                }
            });
        }
    }

    public /* synthetic */ ClearableEditLayout(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    private final void initClearButton() {
        this.clearBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClearableEditLayout.initClearButton$lambda$3(ClearableEditLayout.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClearButton$lambda$3(ClearableEditLayout this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.innerEditText.setText("");
        view.setVisibility(8);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initEditText() {
        this.innerEditText.setObserverStateChange(new Function0<Unit>() { // from class: com.tenpay.sdk.view.ClearableEditLayout$initEditText$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ClearableEditLayout.this.manageClearButton();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void manageClearButton() {
        boolean z16;
        if (this.innerEditText.getText().toString().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && this.innerEditText.isFocused()) {
            this.clearBtn.setVisibility(0);
        } else {
            this.clearBtn.setVisibility(8);
        }
    }

    @NotNull
    public final DelegateEditText getInnerEditText() {
        return this.innerEditText;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClearableEditLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(0);
        setGravity(16);
        DelegateEditText delegateEditText = new DelegateEditText(context, attributeSet);
        this.innerEditText = delegateEditText;
        addView(delegateEditText);
        ViewGroup.LayoutParams layoutParams = this.innerEditText.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.width = 0;
        layoutParams2.weight = 1.0f;
        ImageButton imageButton = new ImageButton(context);
        imageButton.setImageResource(R.drawable.dw_);
        imageButton.setBackgroundResource(0);
        imageButton.setContentDescription(imageButton.getResources().getString(R.string.iwp));
        this.clearBtn = imageButton;
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMarginEnd(15);
        addView(imageButton, layoutParams3);
        initEditText();
        initClearButton();
    }
}
