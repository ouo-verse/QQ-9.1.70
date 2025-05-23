package com.tencent.mobileqq.widget.inputview;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.inputview.QUIMultiLineInputView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import h53.i;
import h53.k;
import h53.n;
import jj2.b;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0014J\b\u0010\n\u001a\u00020\u0004H\u0014J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\u000e\u001a\u00020\u0004H\u0016R$\u0010\u0015\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00168\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/widget/inputview/QUIMultiLineInputView;", "Lcom/tencent/mobileqq/widget/inputview/QUIBaseInputView;", "Landroid/content/Context;", "context", "", "E", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "H", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "p", "Lh53/n;", "Lh53/n;", "D", "()Lh53/n;", "setInputViewWatcher", "(Lh53/n;)V", "inputViewWatcher", "", "value", "I", "Z", "getEnableQQEmojiKeyboard", "()Z", "setEnableQQEmojiKeyboard", "(Z)V", "enableQQEmojiKeyboard", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QUIMultiLineInputView extends QUIBaseInputView {

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private n inputViewWatcher;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean enableQQEmojiKeyboard;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/widget/inputview/QUIMultiLineInputView$a", "Lh53/k;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements k {
        a() {
        }

        @Override // h53.k
        public void afterTextChanged(@Nullable Editable s16) {
            QUIMultiLineInputView.this.A();
            n inputViewWatcher = QUIMultiLineInputView.this.getInputViewWatcher();
            if (inputViewWatcher != null) {
                inputViewWatcher.afterTextChanged(s16);
            }
        }

        @Override // h53.k
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            n inputViewWatcher = QUIMultiLineInputView.this.getInputViewWatcher();
            if (inputViewWatcher != null) {
                inputViewWatcher.beforeTextChanged(s16, start, count, after);
            }
        }

        @Override // h53.k
        public void f8(boolean z16) {
            k.a.a(this, z16);
        }

        @Override // h53.k
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            n inputViewWatcher = QUIMultiLineInputView.this.getInputViewWatcher();
            if (inputViewWatcher != null) {
                inputViewWatcher.onTextChanged(s16, start, before, count);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUIMultiLineInputView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void E(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hg5, this);
        View findViewById = findViewById(R.id.zi7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.multi_input_content)");
        v(findViewById);
        View findViewById2 = findViewById(R.id.zi9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.multi_input_desc)");
        x((TextView) findViewById2);
        View findViewById3 = findViewById(R.id.zi8);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.multi_input_count)");
        w((TextView) findViewById3);
        View findViewById4 = findViewById(R.id.zi_);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.multi_input_editor)");
        u((CharacterCountEditText) findViewById4);
        g().setInputViewWatcher(new a());
        g().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: h53.o
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                QUIMultiLineInputView.F(QUIMultiLineInputView.this, view, z16);
            }
        });
        g().setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: h53.p
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                boolean G;
                G = QUIMultiLineInputView.G(QUIMultiLineInputView.this, textView, i3, keyEvent);
                return G;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(QUIMultiLineInputView this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.enableQQEmojiKeyboard) {
            if (z16) {
                i.f404358a.s(this$0.g(), this$0.getThemeId());
            } else {
                i.f404358a.t(this$0.g());
            }
        }
        n nVar = this$0.inputViewWatcher;
        if (nVar != null) {
            nVar.f8(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean G(QUIMultiLineInputView this$0, TextView textView, int i3, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i();
        return false;
    }

    private final void H(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, b.M5);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026le.QUIMultiLineInputView)");
        setColorMode(obtainStyledAttributes.getInt(b.O5, 0));
        setStyle(obtainStyledAttributes.getInt(b.V5, 0));
        setContentText(obtainStyledAttributes.getString(b.P5));
        setPromptText(obtainStyledAttributes.getString(b.T5));
        setMaxWordCount(obtainStyledAttributes.getInt(b.S5, -1));
        setShowWordCount(obtainStyledAttributes.getBoolean(b.U5, true));
        setHint(obtainStyledAttributes.getString(b.R5));
        setEnableQQEmojiKeyboard(obtainStyledAttributes.getBoolean(b.Q5, false));
        setThemeId(obtainStyledAttributes.getInt(b.W5, getThemeId()));
        setImeOptions(obtainStyledAttributes.getInt(b.N5, 0));
        obtainStyledAttributes.recycle();
    }

    @Nullable
    /* renamed from: D, reason: from getter */
    public final n getInputViewWatcher() {
        return this.inputViewWatcher;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.enableQQEmojiKeyboard) {
            i iVar = i.f404358a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            iVar.p(context);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@Nullable Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (this.enableQQEmojiKeyboard) {
            i.f404358a.q(newConfig);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.enableQQEmojiKeyboard) {
            i iVar = i.f404358a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            iVar.r(context);
        }
    }

    @Override // com.tencent.mobileqq.widget.inputview.QUIBaseInputView
    public void p() {
        super.p();
        if (this.enableQQEmojiKeyboard) {
            i iVar = i.f404358a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            iVar.n(context);
        }
    }

    public final void setEnableQQEmojiKeyboard(boolean z16) {
        if (this.enableQQEmojiKeyboard == z16) {
            return;
        }
        this.enableQQEmojiKeyboard = z16;
        if (z16) {
            i iVar = i.f404358a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            iVar.p(context);
            return;
        }
        i iVar2 = i.f404358a;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        iVar2.r(context2);
    }

    public final void setInputViewWatcher(@Nullable n nVar) {
        this.inputViewWatcher = nVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUIMultiLineInputView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QUIMultiLineInputView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUIMultiLineInputView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        E(context);
        H(context, attributeSet);
    }
}
