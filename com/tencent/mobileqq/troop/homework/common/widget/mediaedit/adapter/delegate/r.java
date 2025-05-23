package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.google.android.flexbox.FlexboxLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quitagview.QUITagSize;
import com.tencent.biz.qui.quitagview.QUITagType;
import com.tencent.biz.qui.quitagview.QUITagView;
import com.tencent.biz.qui.quitagview.QUITagViewConfig;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.TitleItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.inputview.CharacterCountEditText;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.QQToastUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001(\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\u0018\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J*\u0010\u0013\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0014R\u0016\u0010\u0016\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/r;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/BaseMediaEditSection;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/TitleItem;", "", "", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "", "v", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "w", "f", "Landroid/view/View;", "showTitleLayout", "Lcom/tencent/mobileqq/widget/inputview/CharacterCountEditText;", tl.h.F, "Lcom/tencent/mobileqq/widget/inputview/CharacterCountEditText;", "titleEditText", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "titleTextView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "subTextView", "Lcom/google/android/flexbox/FlexboxLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/google/android/flexbox/FlexboxLayout;", "tagsFlexbox", "D", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/TitleItem;", "curTitleItem", "com/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/r$b", "E", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/r$b;", "editTextWatcher", "Ljava/lang/Runnable;", UserInfo.SEX_FEMALE, "Ljava/lang/Runnable;", "showInputMethodRun", "<init>", "()V", "G", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class r extends BaseMediaEditSection<TitleItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int H;

    /* renamed from: C, reason: from kotlin metadata */
    private FlexboxLayout tagsFlexbox;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TitleItem curTitleItem;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final b editTextWatcher;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Runnable showInputMethodRun;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View showTitleLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private CharacterCountEditText titleEditText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView titleTextView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView subTextView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/r$a;", "", "", "tagSpace", "I", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.r$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/r$b", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements TextWatcher {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) r.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                TitleItem titleItem = r.this.curTitleItem;
                if (titleItem != null) {
                    if (s16 == null || (str = s16.toString()) == null) {
                        str = "";
                    }
                    titleItem.setTitle(str);
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
                CharacterCountEditText characterCountEditText = r.this.titleEditText;
                CharacterCountEditText characterCountEditText2 = null;
                if (characterCountEditText == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleEditText");
                    characterCountEditText = null;
                }
                int currentCount = characterCountEditText.getCurrentCount();
                CharacterCountEditText characterCountEditText3 = r.this.titleEditText;
                if (characterCountEditText3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleEditText");
                    characterCountEditText3 = null;
                }
                if (currentCount > characterCountEditText3.getCharacterLimitCount()) {
                    CharacterCountEditText characterCountEditText4 = r.this.titleEditText;
                    if (characterCountEditText4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("titleEditText");
                        characterCountEditText4 = null;
                    }
                    int characterLimitCount = characterCountEditText4.getCharacterLimitCount();
                    CharacterCountEditText characterCountEditText5 = r.this.titleEditText;
                    if (characterCountEditText5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("titleEditText");
                    } else {
                        characterCountEditText2 = characterCountEditText5;
                    }
                    QQToastUtil.showQQToast(1, "\u6700\u591a\u586b\u5199" + characterLimitCount + "\u4e2a\u4e2d\u6587\u6216" + (characterCountEditText2.getCharacterLimitCount() * 2) + "\u4e2a\u82f1\u6587\u5b57\u7b26");
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 3, this, s16, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46664);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
            H = ViewUtils.dpToPx(6.0f);
        }
    }

    public r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.editTextWatcher = new b();
            this.showInputMethodRun = new Runnable() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.q
                @Override // java.lang.Runnable
                public final void run() {
                    r.x(r.this);
                }
            };
        }
    }

    private final void v(List<String> tags) {
        FlexboxLayout flexboxLayout = this.tagsFlexbox;
        if (flexboxLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagsFlexbox");
            flexboxLayout = null;
        }
        flexboxLayout.removeAllViews();
        if (tags != null) {
            for (String str : tags) {
                FlexboxLayout flexboxLayout2 = this.tagsFlexbox;
                if (flexboxLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tagsFlexbox");
                    flexboxLayout2 = null;
                }
                FlexboxLayout flexboxLayout3 = this.tagsFlexbox;
                if (flexboxLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tagsFlexbox");
                    flexboxLayout3 = null;
                }
                Context context = flexboxLayout3.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "tagsFlexbox.context");
                QUITagView qUITagView = new QUITagView(context, null, 2, null);
                qUITagView.setConfig(new QUITagViewConfig(QUITagType.FILL, QUITagSize.SMALL, null, str));
                FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(0, 0, H, 0);
                qUITagView.setLayoutParams(layoutParams);
                flexboxLayout2.addView(qUITagView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(r this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CharacterCountEditText characterCountEditText = this$0.titleEditText;
        CharacterCountEditText characterCountEditText2 = null;
        if (characterCountEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleEditText");
            characterCountEditText = null;
        }
        characterCountEditText.requestFocus();
        CharacterCountEditText characterCountEditText3 = this$0.titleEditText;
        if (characterCountEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleEditText");
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
        return new int[]{R.id.f1193376k};
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
            View findViewById = containerView.findViewById(R.id.f85224od);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.show_title_layout)");
            this.showTitleLayout = findViewById;
            View findViewById2 = containerView.findViewById(R.id.xxw);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.item_title_tv)");
            this.titleTextView = (TextView) findViewById2;
            View findViewById3 = containerView.findViewById(R.id.xxv);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.item_title_et)");
            this.titleEditText = (CharacterCountEditText) findViewById3;
            View findViewById4 = containerView.findViewById(R.id.xxq);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.item_sub_title_tv)");
            this.subTextView = (TextView) findViewById4;
            View findViewById5 = containerView.findViewById(R.id.xxr);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.item_tags_flexbox)");
            this.tagsFlexbox = (FlexboxLayout) findViewById5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable TitleItem data, int position, @Nullable List<Object> payload) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
            return;
        }
        if (data == null) {
            return;
        }
        this.curTitleItem = data;
        CharacterCountEditText characterCountEditText = this.titleEditText;
        TextView textView = null;
        if (characterCountEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleEditText");
            characterCountEditText = null;
        }
        characterCountEditText.setFocusableInTouchMode(data.isEditText());
        CharacterCountEditText characterCountEditText2 = this.titleEditText;
        if (characterCountEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleEditText");
            characterCountEditText2 = null;
        }
        characterCountEditText2.setEnabled(data.isEditText());
        TextView textView2 = this.subTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subTextView");
            textView2 = null;
        }
        textView2.setText(data.getSubTitleText());
        TextView textView3 = this.subTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subTextView");
            textView3 = null;
        }
        if (data.hasSubTitle()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView3.setVisibility(i3);
        if (!data.isEditText()) {
            CharacterCountEditText characterCountEditText3 = this.titleEditText;
            if (characterCountEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleEditText");
                characterCountEditText3 = null;
            }
            characterCountEditText3.setVisibility(8);
            View view = this.showTitleLayout;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showTitleLayout");
                view = null;
            }
            view.setVisibility(0);
            String title = data.getTitle();
            TextView textView4 = this.titleTextView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
                textView4 = null;
            }
            if (!Intrinsics.areEqual(title, textView4.getText().toString())) {
                TextView textView5 = this.titleTextView;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
                } else {
                    textView = textView5;
                }
                textView.setText(data.getTitle());
            }
            v(data.getTags());
            return;
        }
        CharacterCountEditText characterCountEditText4 = this.titleEditText;
        if (characterCountEditText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleEditText");
            characterCountEditText4 = null;
        }
        characterCountEditText4.setVisibility(0);
        View view2 = this.showTitleLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showTitleLayout");
            view2 = null;
        }
        view2.setVisibility(8);
        CharacterCountEditText characterCountEditText5 = this.titleEditText;
        if (characterCountEditText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleEditText");
            characterCountEditText5 = null;
        }
        characterCountEditText5.setHint(data.getHintText());
        CharacterCountEditText characterCountEditText6 = this.titleEditText;
        if (characterCountEditText6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleEditText");
            characterCountEditText6 = null;
        }
        characterCountEditText6.setFilters(new InputFilter[0]);
        CharacterCountEditText characterCountEditText7 = this.titleEditText;
        if (characterCountEditText7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleEditText");
            characterCountEditText7 = null;
        }
        characterCountEditText7.removeTextChangedListener(this.editTextWatcher);
        String title2 = data.getTitle();
        CharacterCountEditText characterCountEditText8 = this.titleEditText;
        if (characterCountEditText8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleEditText");
            characterCountEditText8 = null;
        }
        if (!Intrinsics.areEqual(title2, characterCountEditText8.getText().toString())) {
            CharacterCountEditText characterCountEditText9 = this.titleEditText;
            if (characterCountEditText9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleEditText");
                characterCountEditText9 = null;
            }
            characterCountEditText9.setText(data.getTitle());
            CharacterCountEditText characterCountEditText10 = this.titleEditText;
            if (characterCountEditText10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleEditText");
                characterCountEditText10 = null;
            }
            if (characterCountEditText10.isEnabled()) {
                CharacterCountEditText characterCountEditText11 = this.titleEditText;
                if (characterCountEditText11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleEditText");
                    characterCountEditText11 = null;
                }
                characterCountEditText11.setSelection(data.getTitle().length());
            }
        }
        CharacterCountEditText characterCountEditText12 = this.titleEditText;
        if (characterCountEditText12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleEditText");
            characterCountEditText12 = null;
        }
        characterCountEditText12.addTextChangedListener(this.editTextWatcher);
        CharacterCountEditText characterCountEditText13 = this.titleEditText;
        if (characterCountEditText13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleEditText");
            characterCountEditText13 = null;
        }
        characterCountEditText13.setLimitCount(data.getMaxWordCount());
        if (data.isEditText() && data.isReqFocus() && data.getShowInputMethodOnce()) {
            CharacterCountEditText characterCountEditText14 = this.titleEditText;
            if (characterCountEditText14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleEditText");
            } else {
                textView = characterCountEditText14;
            }
            textView.postDelayed(this.showInputMethodRun, 300L);
            data.setShowInputMethodOnce(false);
        }
    }
}
