package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.ContentItem;
import com.tencent.mobileqq.widget.inputview.CharacterCountEditText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.QQToastUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J*\u0010\u000f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/g;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/BaseMediaEditSection;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/ContentItem;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "w", "Lcom/tencent/mobileqq/widget/inputview/CharacterCountEditText;", "f", "Lcom/tencent/mobileqq/widget/inputview/CharacterCountEditText;", "editText", tl.h.F, "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/ContentItem;", "curContentItem", "com/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/g$a", "i", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/g$a;", "editTextWatcher", "Ljava/lang/Runnable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Runnable;", "showInputMethodRun", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class g extends BaseMediaEditSection<ContentItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private CharacterCountEditText editText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ContentItem curContentItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a editTextWatcher;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable showInputMethodRun;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/g$a", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements TextWatcher {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                ContentItem contentItem = g.this.curContentItem;
                if (contentItem != null) {
                    if (s16 == null || (str = s16.toString()) == null) {
                        str = "";
                    }
                    contentItem.setContent(str);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) s16);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, s16, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                CharacterCountEditText characterCountEditText = g.this.editText;
                CharacterCountEditText characterCountEditText2 = null;
                if (characterCountEditText == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editText");
                    characterCountEditText = null;
                }
                int currentCount = characterCountEditText.getCurrentCount();
                CharacterCountEditText characterCountEditText3 = g.this.editText;
                if (characterCountEditText3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editText");
                    characterCountEditText3 = null;
                }
                if (currentCount > characterCountEditText3.getCharacterLimitCount()) {
                    CharacterCountEditText characterCountEditText4 = g.this.editText;
                    if (characterCountEditText4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("editText");
                    } else {
                        characterCountEditText2 = characterCountEditText4;
                    }
                    QQToastUtil.showQQToast(1, "\u6700\u591a\u53ef\u4ee5\u8f93\u5165" + characterCountEditText2.getCharacterLimitCount() + "\u5b57\u7b26");
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 3, this, s16, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.editTextWatcher = new a();
            this.showInputMethodRun = new Runnable() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.e
                @Override // java.lang.Runnable
                public final void run() {
                    g.y(g.this);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void x(g this$0) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        qs2.a q16 = this$0.q();
        if (q16 instanceof RecyclerView) {
            recyclerView = (RecyclerView) q16;
        } else {
            recyclerView = null;
        }
        if (recyclerView != null) {
            int height = recyclerView.getHeight();
            if (QLog.isColorLevel()) {
                QLog.i("HW.MediaEdit.", 2, "recyclerView height:" + ((RecyclerView) q16).getHeight());
            }
            q16.w(height);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CharacterCountEditText characterCountEditText = this$0.editText;
        CharacterCountEditText characterCountEditText2 = null;
        if (characterCountEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            characterCountEditText = null;
        }
        characterCountEditText.requestFocus();
        CharacterCountEditText characterCountEditText3 = this$0.editText;
        if (characterCountEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
        } else {
            characterCountEditText2 = characterCountEditText3;
        }
        InputMethodUtil.show(characterCountEditText2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{R.id.f1190975x};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.BaseMediaEditSection, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) containerView);
            return;
        }
        super.onInitView(containerView);
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.f165847xt1);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.item_content_et)");
            CharacterCountEditText characterCountEditText = (CharacterCountEditText) findViewById;
            this.editText = characterCountEditText;
            if (characterCountEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editText");
                characterCountEditText = null;
            }
            characterCountEditText.setGravity(8388611);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable ContentItem data, int position, @Nullable List<Object> payload) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
            return;
        }
        if (data == null) {
            return;
        }
        this.curContentItem = data;
        CharacterCountEditText characterCountEditText = this.editText;
        CharacterCountEditText characterCountEditText2 = null;
        if (characterCountEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            characterCountEditText = null;
        }
        characterCountEditText.setFocusableInTouchMode(data.isEditText());
        CharacterCountEditText characterCountEditText3 = this.editText;
        if (characterCountEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            characterCountEditText3 = null;
        }
        characterCountEditText3.setEnabled(data.isEditText());
        CharacterCountEditText characterCountEditText4 = this.editText;
        if (characterCountEditText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            characterCountEditText4 = null;
        }
        characterCountEditText4.setHint(data.getHintText());
        CharacterCountEditText characterCountEditText5 = this.editText;
        if (characterCountEditText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            characterCountEditText5 = null;
        }
        characterCountEditText5.setLimitCount(data.getMaxWordCount());
        CharacterCountEditText characterCountEditText6 = this.editText;
        if (characterCountEditText6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            characterCountEditText6 = null;
        }
        characterCountEditText6.setFilters(new InputFilter[0]);
        int paddingPx = data.getPaddingPx();
        CharacterCountEditText characterCountEditText7 = this.editText;
        if (characterCountEditText7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            characterCountEditText7 = null;
        }
        characterCountEditText7.setPadding(paddingPx, paddingPx, paddingPx, paddingPx);
        CharacterCountEditText characterCountEditText8 = this.editText;
        if (characterCountEditText8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            characterCountEditText8 = null;
        }
        ViewGroup.LayoutParams layoutParams = characterCountEditText8.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.bottomMargin = data.getMarginBottomPx();
        }
        int contentMinHeight = data.getContentMinHeight();
        CharacterCountEditText characterCountEditText9 = this.editText;
        if (characterCountEditText9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            characterCountEditText9 = null;
        }
        if (characterCountEditText9.getMinHeight() != contentMinHeight) {
            CharacterCountEditText characterCountEditText10 = this.editText;
            if (characterCountEditText10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editText");
                characterCountEditText10 = null;
            }
            characterCountEditText10.setMinHeight(contentMinHeight);
        }
        CharacterCountEditText characterCountEditText11 = this.editText;
        if (characterCountEditText11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            characterCountEditText11 = null;
        }
        characterCountEditText11.removeTextChangedListener(this.editTextWatcher);
        String content = data.getContent();
        CharacterCountEditText characterCountEditText12 = this.editText;
        if (characterCountEditText12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            characterCountEditText12 = null;
        }
        if (!Intrinsics.areEqual(content, characterCountEditText12.getText().toString())) {
            CharacterCountEditText characterCountEditText13 = this.editText;
            if (characterCountEditText13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editText");
                characterCountEditText13 = null;
            }
            characterCountEditText13.setText(data.getContent());
            CharacterCountEditText characterCountEditText14 = this.editText;
            if (characterCountEditText14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editText");
                characterCountEditText14 = null;
            }
            if (characterCountEditText14.isEnabled()) {
                CharacterCountEditText characterCountEditText15 = this.editText;
                if (characterCountEditText15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editText");
                    characterCountEditText15 = null;
                }
                CharacterCountEditText characterCountEditText16 = this.editText;
                if (characterCountEditText16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editText");
                    characterCountEditText16 = null;
                }
                characterCountEditText15.setSelection(characterCountEditText16.getText().length());
            }
        }
        CharacterCountEditText characterCountEditText17 = this.editText;
        if (characterCountEditText17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editText");
            characterCountEditText17 = null;
        }
        characterCountEditText17.addTextChangedListener(this.editTextWatcher);
        if (data.getNotifyContentHeightOnce()) {
            data.setNotifyContentHeightOnce(false);
            CharacterCountEditText characterCountEditText18 = this.editText;
            if (characterCountEditText18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editText");
                characterCountEditText18 = null;
            }
            characterCountEditText18.post(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.x(g.this);
                }
            });
        }
        if (data.isEditText() && data.isReqFocus() && data.getShowInputMethodOnce()) {
            CharacterCountEditText characterCountEditText19 = this.editText;
            if (characterCountEditText19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editText");
            } else {
                characterCountEditText2 = characterCountEditText19;
            }
            characterCountEditText2.postDelayed(this.showInputMethodRun, 300L);
            data.setShowInputMethodOnce(false);
        }
    }
}
