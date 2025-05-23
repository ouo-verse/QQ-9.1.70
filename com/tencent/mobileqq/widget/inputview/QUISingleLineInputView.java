package com.tencent.mobileqq.widget.inputview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import h53.k;
import h53.q;
import jj2.b;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010>\u001a\u00020\u0014\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0014J\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010#R$\u0010+\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b\u0018\u0010(\"\u0004\b)\u0010*R*\u00101\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\"8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010#\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R(\u00105\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u00102\"\u0004\b3\u00104R(\u00108\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b6\u00102\"\u0004\b7\u00104R$\u0010=\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00148F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "Lcom/tencent/mobileqq/widget/inputview/QUIBaseInputView;", "Landroid/content/Context;", "context", "", "K", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/content/res/ColorStateList;", "I", "Landroid/graphics/drawable/Drawable;", "G", "", "errorTips", "y", ReportConstant.COSTREPORT_PREFIX, "r", "setEditTextRequestFocused", "", "value", "setAllowMaxWord", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "titleTextView", "Landroid/view/View;", "Landroid/view/View;", "line", "Landroid/widget/ImageView;", "J", "Landroid/widget/ImageView;", "clearButton", "", "Z", "isLinkTitle", "Lh53/q;", "L", "Lh53/q;", "()Lh53/q;", "setInputViewWatcher", "(Lh53/q;)V", "inputViewWatcher", "M", "getShowBottomLine", "()Z", "setShowBottomLine", "(Z)V", "showBottomLine", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "title", "getLinkTitle", "setLinkTitle", "linkTitle", "getInputType", "()I", "setInputType", "(I)V", RemoteMessageConst.INPUT_TYPE, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QUISingleLineInputView extends QUIBaseInputView {

    /* renamed from: H, reason: from kotlin metadata */
    private TextView titleTextView;

    /* renamed from: I, reason: from kotlin metadata */
    private View line;

    /* renamed from: J, reason: from kotlin metadata */
    private ImageView clearButton;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isLinkTitle;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private q inputViewWatcher;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean showBottomLine;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/widget/inputview/QUISingleLineInputView$a", "Lh53/k;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements k {
        a() {
        }

        @Override // h53.k
        public void afterTextChanged(@Nullable Editable s16) {
            QUISingleLineInputView.this.A();
            QUISingleLineInputView.this.Q();
            q inputViewWatcher = QUISingleLineInputView.this.getInputViewWatcher();
            if (inputViewWatcher != null) {
                inputViewWatcher.afterTextChanged(s16);
            }
        }

        @Override // h53.k
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            q inputViewWatcher = QUISingleLineInputView.this.getInputViewWatcher();
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
            q inputViewWatcher = QUISingleLineInputView.this.getInputViewWatcher();
            if (inputViewWatcher != null) {
                inputViewWatcher.onTextChanged(s16, start, before, count);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUISingleLineInputView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Drawable G() {
        Drawable p16 = ie0.a.f().p(getContext(), R.drawable.qui_input_view_clear, R.color.qui_common_icon_secondary, getThemeId());
        Intrinsics.checkNotNullExpressionValue(p16, "getInstances().getQuiTok\u2026_icon_secondary, themeId)");
        return p16;
    }

    private final ColorStateList I() {
        return new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[0]}, new int[]{c(R.color.qui_common_text_link_pressed), c(R.color.qui_common_text_link)});
    }

    private final void K(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hg8, this);
        View findViewById = findViewById(R.id.f85574pb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.single_input_content)");
        v(findViewById);
        View findViewById2 = findViewById(R.id.f85624pg);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.single_input_title)");
        this.titleTextView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f85594pd);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.single_input_desc)");
        x((TextView) findViewById3);
        View findViewById4 = findViewById(R.id.f85584pc);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.single_input_count)");
        w((TextView) findViewById4);
        View findViewById5 = findViewById(R.id.f85604pe);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.single_input_editor)");
        u((CharacterCountEditText) findViewById5);
        View findViewById6 = findViewById(R.id.f85614pf);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.single_input_line)");
        this.line = findViewById6;
        View findViewById7 = findViewById(R.id.f85564pa);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.single_input_clear)");
        this.clearButton = (ImageView) findViewById7;
        TextView textView = this.titleTextView;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: h53.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QUISingleLineInputView.L(QUISingleLineInputView.this, view);
            }
        });
        g().setInputViewWatcher(new a());
        g().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: h53.s
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                QUISingleLineInputView.M(QUISingleLineInputView.this, view, z16);
            }
        });
        g().setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: h53.t
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView2, int i3, KeyEvent keyEvent) {
                boolean N;
                N = QUISingleLineInputView.N(QUISingleLineInputView.this, textView2, i3, keyEvent);
                return N;
            }
        });
        ImageView imageView2 = this.clearButton;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clearButton");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: h53.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QUISingleLineInputView.O(QUISingleLineInputView.this, view);
            }
        });
        View view = this.line;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("line");
            view = null;
        }
        view.setBackgroundColor(c(R.color.qui_common_border_standard));
        ImageView imageView3 = this.clearButton;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clearButton");
        } else {
            imageView = imageView3;
        }
        imageView.setImageDrawable(G());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(QUISingleLineInputView this$0, View view) {
        q qVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isLinkTitle && (qVar = this$0.inputViewWatcher) != null) {
            qVar.A4(this$0.J());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(QUISingleLineInputView this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q();
        q qVar = this$0.inputViewWatcher;
        if (qVar != null) {
            qVar.f8(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean N(QUISingleLineInputView this$0, TextView textView, int i3, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(QUISingleLineInputView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setContentText(null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void P(Context context, AttributeSet attrs) {
        boolean z16;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, b.f410117l6);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026e.QUISingleLineInputView)");
        setColorMode(obtainStyledAttributes.getInt(b.f410139n6, 0));
        setStyle(obtainStyledAttributes.getInt(b.f410241w6, 0));
        String string = obtainStyledAttributes.getString(b.f410263y6);
        String string2 = obtainStyledAttributes.getString(b.f410187r6);
        if (string2 != null && string2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            setLinkTitle(string2);
        } else {
            setTitle(string);
        }
        setContentText(obtainStyledAttributes.getString(b.f410151o6));
        setPromptText(obtainStyledAttributes.getString(b.f410210t6));
        setMaxWordCount(obtainStyledAttributes.getInt(b.f410199s6, -1));
        setInputType(obtainStyledAttributes.getInt(b.f410175q6, 1));
        setHint(obtainStyledAttributes.getString(b.f410163p6));
        setShowWordCount(obtainStyledAttributes.getBoolean(b.f410231v6, true));
        setShowBottomLine(obtainStyledAttributes.getBoolean(b.f410221u6, true));
        setThemeId(obtainStyledAttributes.getInt(b.f410252x6, getThemeId()));
        setImeOptions(obtainStyledAttributes.getInt(b.f410128m6, 0));
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q() {
        boolean z16;
        CharSequence d16 = d();
        if (d16 != null && d16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        ImageView imageView = null;
        if (!z16 && g().isFocused()) {
            ImageView imageView2 = this.clearButton;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clearButton");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(0);
            return;
        }
        ImageView imageView3 = this.clearButton;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clearButton");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(8);
    }

    @Nullable
    /* renamed from: H, reason: from getter */
    public final q getInputViewWatcher() {
        return this.inputViewWatcher;
    }

    @Nullable
    public final String J() {
        TextView textView = this.titleTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            textView = null;
        }
        return textView.getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.inputview.QUIBaseInputView
    public void r() {
        super.r();
        View view = this.line;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("line");
            view = null;
        }
        view.setBackgroundColor(c(R.color.qui_common_border_standard));
        ImageView imageView = this.clearButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clearButton");
            imageView = null;
        }
        imageView.setImageDrawable(G());
        if (this.isLinkTitle) {
            TextView textView2 = this.titleTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            } else {
                textView = textView2;
            }
            textView.setTextColor(I());
            return;
        }
        TextView textView3 = this.titleTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
        } else {
            textView = textView3;
        }
        textView.setTextColor(c(R.color.qui_common_text_primary));
    }

    @Override // com.tencent.mobileqq.widget.inputview.QUIBaseInputView
    public void s() {
        super.s();
        View view = this.line;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("line");
            view = null;
        }
        view.setBackgroundColor(c(R.color.qui_common_border_standard));
        if (this.isLinkTitle) {
            TextView textView2 = this.titleTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            } else {
                textView = textView2;
            }
            textView.setTextColor(I());
            return;
        }
        TextView textView3 = this.titleTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
        } else {
            textView = textView3;
        }
        textView.setTextColor(c(R.color.qui_common_text_primary));
    }

    public final void setAllowMaxWord(int value) {
        int i3;
        String sb5;
        TextView k3 = k();
        if (getShowWordCount()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        k3.setVisibility(i3);
        if (g().getCurrentCount() > 0) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(g().getCurrentCount());
            sb6.append('/');
            sb6.append(value);
            sb6.append('\u5b57');
            sb5 = sb6.toString();
        } else {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(value);
            sb7.append('\u5b57');
            sb5 = sb7.toString();
        }
        if (g().getCurrentCount() == value) {
            g().setLimitCount(value);
        }
        k().setText(sb5);
        if (g().getCurrentCount() >= value) {
            k().setTextColor(c(R.color.qui_common_feedback_error));
        } else {
            k().setTextColor(c(R.color.qui_common_text_secondary));
        }
    }

    public final void setEditTextRequestFocused() {
        int i3;
        g().setFocusable(true);
        g().setFocusableInTouchMode(true);
        g().requestFocus();
        CharacterCountEditText g16 = g();
        Editable text = g().getText();
        if (text != null) {
            i3 = text.length();
        } else {
            i3 = 0;
        }
        g16.setSelection(i3);
        InputMethodUtil.show(g());
    }

    public final void setInputType(int i3) {
        g().setInputType(i3);
    }

    public final void setInputViewWatcher(@Nullable q qVar) {
        this.inputViewWatcher = qVar;
    }

    public final void setLinkTitle(@Nullable String str) {
        boolean z16 = true;
        setClickable(true);
        this.isLinkTitle = true;
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        TextView textView = null;
        if (z16) {
            TextView textView2 = this.titleTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView3 = this.titleTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            textView3 = null;
        }
        textView3.setVisibility(0);
        TextView textView4 = this.titleTextView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            textView4 = null;
        }
        textView4.setTextColor(I());
        TextView textView5 = this.titleTextView;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
        } else {
            textView = textView5;
        }
        textView.setText(str);
    }

    public final void setShowBottomLine(boolean z16) {
        int i3;
        this.showBottomLine = z16;
        View view = this.line;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("line");
            view = null;
        }
        if (this.showBottomLine) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    public final void setTitle(@Nullable String str) {
        boolean z16;
        setClickable(false);
        this.isLinkTitle = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        TextView textView = null;
        if (z16) {
            TextView textView2 = this.titleTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView3 = this.titleTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            textView3 = null;
        }
        textView3.setVisibility(0);
        TextView textView4 = this.titleTextView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            textView4 = null;
        }
        textView4.setTextColor(getResources().getColor(R.color.qui_common_text_primary));
        TextView textView5 = this.titleTextView;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
        } else {
            textView = textView5;
        }
        textView.setText(str);
    }

    @Override // com.tencent.mobileqq.widget.inputview.QUIBaseInputView
    public void y(@NotNull String errorTips) {
        Intrinsics.checkNotNullParameter(errorTips, "errorTips");
        super.y(errorTips);
        View view = this.line;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("line");
            view = null;
        }
        view.setBackgroundColor(c(R.color.qui_common_feedback_error));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUISingleLineInputView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QUISingleLineInputView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUISingleLineInputView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.showBottomLine = true;
        K(context);
        P(context, attributeSet);
    }
}
