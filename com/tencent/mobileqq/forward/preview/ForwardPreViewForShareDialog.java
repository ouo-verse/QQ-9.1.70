package com.tencent.mobileqq.forward.preview;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.o;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.util.TokenResUtils;
import com.tencent.widget.MaxHeightRelativelayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010-\u001a\u00020,\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u00100\u001a\u00020\u0006\u00a2\u0006\u0004\b1\u00102J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004J\u0010\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0015J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0006J\u0016\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006R\u0014\u0010\"\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010$R\u0014\u0010(\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/forward/preview/ForwardPreViewForShareDialog;", "Lcom/tencent/mobileqq/forward/preview/ForwardPreView;", "Landroid/view/View;", "preView", "", "a", "", "height", "setContentViewHeight", "Landroid/view/View$OnClickListener;", "listener", "setOnClickListenerForPreView", "Landroid/widget/EditText;", "i", "Landroid/widget/ImageView;", "g", "Landroid/widget/LinearLayout;", h.F, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setQzoneTextBuilder", "", "value", "setInitInputValue", "", "hide", "k", "j", "max", "setMaxLength", "imageResource", "tag", "setEmoButtonImageResourceATag", "Landroid/widget/EditText;", "inputTextView", "Lcom/tencent/widget/MaxHeightRelativelayout;", "Lcom/tencent/widget/MaxHeightRelativelayout;", "previewLayout", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "mViewEmoBtn", "D", "Landroid/widget/LinearLayout;", "mInputContainer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ForwardPreViewForShareDialog extends ForwardPreView {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ImageView mViewEmoBtn;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout mInputContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EditText inputTextView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MaxHeightRelativelayout previewLayout;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/forward/preview/ForwardPreViewForShareDialog$a", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "before", "count", "", "onTextChanged", "after", "beforeTextChanged", "Landroid/text/Editable;", "afterTextChanged", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f211058e;

        a(int i3) {
            this.f211058e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardPreViewForShareDialog.this, i3);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable s16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) s16);
            } else {
                Intrinsics.checkNotNullParameter(s16, "s");
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@NotNull CharSequence s16, int start, int count, int after) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, s16, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
            } else {
                Intrinsics.checkNotNullParameter(s16, "s");
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@NotNull CharSequence s16, int start, int before, int count) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, s16, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
                return;
            }
            Intrinsics.checkNotNullParameter(s16, "s");
            int length = ForwardPreViewForShareDialog.this.inputTextView.getText().length();
            int i3 = this.f211058e;
            if (length == i3 && s16.charAt(i3 - 1) == 20) {
                ForwardPreViewForShareDialog.this.inputTextView.setText(s16.subSequence(0, this.f211058e - 1));
                ForwardPreViewForShareDialog.this.inputTextView.setSelection(this.f211058e - 1);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ForwardPreViewForShareDialog(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            return;
        }
        iPatchRedirector.redirect((short) 20, (Object) this, (Object) context);
    }

    @Override // com.tencent.mobileqq.forward.preview.ForwardPreView
    public void a(@Nullable View preView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) preView);
            return;
        }
        setPreView(preView);
        if (preView != null) {
            this.previewLayout.addView(preView);
        }
    }

    @NotNull
    public final ImageView g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ImageView) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mViewEmoBtn;
    }

    @NotNull
    public final LinearLayout h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (LinearLayout) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mInputContainer;
    }

    @NotNull
    public EditText i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (EditText) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.inputTextView;
    }

    @NotNull
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.inputTextView.getText().toString();
    }

    public final void k(boolean hide) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, hide);
        } else if (hide) {
            this.mInputContainer.setVisibility(8);
        } else {
            this.mInputContainer.setVisibility(0);
        }
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.mViewEmoBtn.setImageResource(R.drawable.qui_emoticon);
        }
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.inputTextView.setEditableFactory(QQTextBuilder.getCustomSizeEditableFactory(16));
        this.inputTextView.setSingleLine(false);
        this.inputTextView.setMaxLines(2);
        if (Build.VERSION.SDK_INT >= 29 && TokenResUtils.useTokenRes2()) {
            this.inputTextView.setTextCursorDrawable(R.drawable.qui_input_cursor);
        }
        Resources resources = getContext().getResources();
        if (resources != null) {
            setMaxLength(resources.getInteger(R.integer.f167158k));
        }
    }

    public final void setContentViewHeight(int height) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, height);
        } else {
            this.previewLayout.setMaxHeight(BaseAIOUtils.f(height, getContext().getResources()));
        }
    }

    public final void setEmoButtonImageResourceATag(int imageResource, int tag) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(imageResource), Integer.valueOf(tag));
            return;
        }
        this.mViewEmoBtn.setImageResource(imageResource);
        this.mViewEmoBtn.setTag(Integer.valueOf(tag));
        if (tag == R.drawable.forward_dialog_new_edit_keyboard) {
            str = "\u6253\u5f00\u952e\u76d8";
        } else {
            str = "\u6253\u5f00\u8868\u60c5\u9762\u677f";
        }
        this.mViewEmoBtn.setContentDescription(str);
    }

    public final void setInitInputValue(@Nullable String value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) value);
        } else {
            this.inputTextView.setText(value);
        }
    }

    public final void setMaxLength(int max) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, max);
        } else {
            this.inputTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(max)});
            this.inputTextView.addTextChangedListener(new a(max));
        }
    }

    @Override // com.tencent.mobileqq.forward.preview.ForwardPreView
    public void setOnClickListenerForPreView(@NotNull View.OnClickListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        View d16 = d();
        if (d16 != null) {
            d16.setOnClickListener(listener);
        }
    }

    public final void setQzoneTextBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.inputTextView.setEditableFactory(o.f292704d);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ForwardPreViewForShareDialog(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            return;
        }
        iPatchRedirector.redirect((short) 19, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ ForwardPreViewForShareDialog(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ForwardPreViewForShareDialog(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        LayoutInflater.from(context).inflate(R.layout.e9i, this);
        View findViewById = findViewById(R.id.input);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.input)");
        this.inputTextView = (EditText) findViewById;
        View findViewById2 = findViewById(R.id.f166799ic3);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.rl_content)");
        this.previewLayout = (MaxHeightRelativelayout) findViewById2;
        View findViewById3 = findViewById(R.id.emo_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.emo_btn)");
        this.mViewEmoBtn = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.dmo);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.input_container)");
        this.mInputContainer = (LinearLayout) findViewById4;
        m();
        l();
    }
}
