package com.tencent.state.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.LeadingMarginSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.bubblesetting.SquareBubbleColor;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.databinding.VasSquareItemBubbleEditableMainContainerBinding;
import com.tencent.state.utils.ColorFormatUtils;
import com.tencent.state.utils.RegexUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0015H\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001e\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0011H\u0016J\u0012\u0010$\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010%\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J$\u0010&\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010'\u001a\u0004\u0018\u00010\u00152\u0006\u0010(\u001a\u00020\u0011H\u0016J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0016R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/tencent/state/view/EditableBubbleMainContainer;", "Landroid/widget/LinearLayout;", "Lcom/tencent/state/view/IDetailBubbleMainContainer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareItemBubbleEditableMainContainerBinding;", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareItemBubbleEditableMainContainerBinding;", "isClearDraft", "", "listener", "Lcom/tencent/state/view/BubbleEditListener;", "showText", "", "addSpaceSpan", "", "isHit", "clearText", "getAddViewLayoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "getTextString", "getTrulyText", "init", "onlineStatus", "Lcom/tencent/state/square/data/OnlineStatus;", "setBubbleEditListener", "setFocus", NodeProps.FOCUSABLE, "showChangeStatusView", "showCommonView", "showEditedView", "draftText", "needIcon", "updateBubbleSkin", "bubbleInfo", "Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;", "updateStatusIcon", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class EditableBubbleMainContainer extends LinearLayout implements IDetailBubbleMainContainer {
    private final VasSquareItemBubbleEditableMainContainerBinding binding;
    private boolean isClearDraft;
    private BubbleEditListener listener;
    private String showText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditableBubbleMainContainer(Context context) {
        super(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareItemBubbleEditableMainContainerBinding inflate = VasSquareItemBubbleEditableMainContainerBinding.inflate(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareItemBubbleEdita\u2026ater.from(context), this)");
        this.binding = inflate;
        this.showText = "";
        inflate.bubbleEditText.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.view.EditableBubbleMainContainer.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BubbleEditListener bubbleEditListener;
                EditText editText = EditableBubbleMainContainer.this.getBinding().bubbleEditText;
                Intrinsics.checkNotNullExpressionValue(editText, "binding.bubbleEditText");
                if (editText.isActivated() || (bubbleEditListener = EditableBubbleMainContainer.this.listener) == null) {
                    return;
                }
                bubbleEditListener.enterEdit();
            }
        });
        EditText editText = inflate.bubbleEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.bubbleEditText");
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.state.view.EditableBubbleMainContainer.2
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                if (z16) {
                    BubbleEditListener bubbleEditListener = EditableBubbleMainContainer.this.listener;
                    if (bubbleEditListener != null) {
                        bubbleEditListener.enterEdit();
                        return;
                    }
                    return;
                }
                EditableBubbleMainContainer editableBubbleMainContainer = EditableBubbleMainContainer.this;
                EditText editText2 = editableBubbleMainContainer.getBinding().bubbleEditText;
                Intrinsics.checkNotNullExpressionValue(editText2, "binding.bubbleEditText");
                editableBubbleMainContainer.showText = editText2.getText().toString();
            }
        });
        inflate.bubbleEditText.addTextChangedListener(new TextWatcher() { // from class: com.tencent.state.view.EditableBubbleMainContainer.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s16, int start, int before, int count) {
                OnlineStatusBubbleViewHelper onlineStatusBubbleViewHelper = OnlineStatusBubbleViewHelper.INSTANCE;
                EditText editText2 = EditableBubbleMainContainer.this.getBinding().bubbleEditText;
                Intrinsics.checkNotNullExpressionValue(editText2, "binding.bubbleEditText");
                int editTextLength = onlineStatusBubbleViewHelper.getEditTextLength(editText2.getText().toString()) - 32;
                if (editTextLength < 0) {
                    editTextLength = 0;
                }
                if (editTextLength > 0) {
                    Editable editable = (Editable) (!(s16 instanceof Editable) ? null : s16);
                    if (editable != null) {
                        int i3 = start + count;
                        editable.delete(i3 - editTextLength, i3);
                    }
                }
                int i16 = count - editTextLength;
                if (i16 < 1) {
                    return;
                }
                for (int i17 = i16 - 1; i17 <= 0; i17++) {
                    Integer valueOf = s16 != null ? Integer.valueOf(s16.charAt(i17 + start)) : null;
                    if ((valueOf != null && valueOf.intValue() == 10) || (valueOf != null && valueOf.intValue() == 13)) {
                        Editable editable2 = (Editable) (!(s16 instanceof Editable) ? null : s16);
                        if (editable2 != null) {
                            int i18 = start + i17;
                            editable2.delete(i18, i18 + 1);
                        }
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s16) {
                if (s16 == null || s16.length() == 0) {
                    EditableBubbleMainContainer.this.isClearDraft = true;
                }
                BubbleEditListener bubbleEditListener = EditableBubbleMainContainer.this.listener;
                if (bubbleEditListener != null) {
                    bubbleEditListener.onEditTextChange();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s16, int start, int count, int after) {
            }
        });
        SquareImageView squareImageView = inflate.bubblePenIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.bubblePenIcon");
        squareImageView.setVisibility(0);
    }

    private final void addSpaceSpan(boolean isHit) {
        CharSequence text;
        LeadingMarginSpan.Standard standard = new LeadingMarginSpan.Standard(ViewExtensionsKt.dip((Context) Square.INSTANCE.getApplication(), 20), 0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (isHit) {
            EditText editText = this.binding.bubbleEditText;
            Intrinsics.checkNotNullExpressionValue(editText, "binding.bubbleEditText");
            text = editText.getHint();
            if (text == null) {
                text = getResources().getString(R.string.xeb);
                Intrinsics.checkNotNullExpressionValue(text, "resources.getString(R.st\u2026_square_status_edit_hint)");
            }
        } else {
            EditText editText2 = this.binding.bubbleEditText;
            Intrinsics.checkNotNullExpressionValue(editText2, "binding.bubbleEditText");
            text = editText2.getText();
        }
        spannableStringBuilder.append(text);
        spannableStringBuilder.setSpan(standard, 0, 0, 17);
        if (isHit) {
            EditText editText3 = this.binding.bubbleEditText;
            Intrinsics.checkNotNullExpressionValue(editText3, "binding.bubbleEditText");
            editText3.setHint(spannableStringBuilder);
        } else {
            EditText editText4 = this.binding.bubbleEditText;
            Intrinsics.checkNotNullExpressionValue(editText4, "binding.bubbleEditText");
            editText4.setText(spannableStringBuilder);
        }
    }

    @Override // com.tencent.state.view.IDetailBubbleMainContainer
    public void clearText() {
        EditText editText = this.binding.bubbleEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.bubbleEditText");
        editText.setText((CharSequence) null);
        addSpaceSpan(false);
    }

    @Override // com.tencent.state.view.IDetailBubbleMainContainer
    public LinearLayout.LayoutParams getAddViewLayoutParams() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public final VasSquareItemBubbleEditableMainContainerBinding getBinding() {
        return this.binding;
    }

    @Override // com.tencent.state.view.IDetailBubbleMainContainer
    public String getTextString() {
        EditText editText = this.binding.bubbleEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.bubbleEditText");
        return editText.getText().toString();
    }

    @Override // com.tencent.state.view.IDetailBubbleMainContainer
    /* renamed from: getTrulyText, reason: from getter */
    public String getShowText() {
        return this.showText;
    }

    public final void setBubbleEditListener(BubbleEditListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // com.tencent.state.view.IDetailBubbleMainContainer
    public void setFocus(boolean focusable) {
        FrameLayout frameLayout = this.binding.editableBubbleMainContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.editableBubbleMainContainer");
        frameLayout.setFocusable(true);
        FrameLayout frameLayout2 = this.binding.editableBubbleMainContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.editableBubbleMainContainer");
        frameLayout2.setFocusableInTouchMode(true);
    }

    @Override // com.tencent.state.view.IDetailBubbleMainContainer
    public void showChangeStatusView(OnlineStatus onlineStatus) {
        EditText editText = this.binding.bubbleEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.bubbleEditText");
        editText.setActivated(false);
        SquareImageView squareImageView = this.binding.bubblePenIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.bubblePenIcon");
        squareImageView.setVisibility(0);
        this.binding.bubbleEditText.setText(this.showText);
        addSpaceSpan(false);
        EditText editText2 = this.binding.bubbleEditText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.bubbleEditText");
        editText2.setHint(getResources().getString(R.string.xeb));
        addSpaceSpan(true);
    }

    @Override // com.tencent.state.view.IDetailBubbleMainContainer
    public void showCommonView(final OnlineStatus onlineStatus) {
        EditText editText = this.binding.bubbleEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.bubbleEditText");
        editText.setActivated(false);
        SquareImageView squareImageView = this.binding.bubblePenIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.bubblePenIcon");
        squareImageView.setVisibility(0);
        if (onlineStatus != null) {
            SquareBaseKt.getSquareThread().postOnSubThread(new Function0<Unit>() { // from class: com.tencent.state.view.EditableBubbleMainContainer$showCommonView$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    final Drawable iconDrawable$default = OnlineStatusBubbleViewHelper.getIconDrawable$default(OnlineStatusBubbleViewHelper.INSTANCE, OnlineStatus.this, true, null, 4, null);
                    SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.view.EditableBubbleMainContainer$showCommonView$$inlined$let$lambda$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            this.getBinding().bubbleEditIcon.setImageDrawable(iconDrawable$default);
                        }
                    });
                }
            });
            String bubbleMainText = OnlineStatusBubbleViewHelper.INSTANCE.getBubbleMainText(true, true, onlineStatus);
            if (bubbleMainText.length() > 0) {
                this.binding.bubbleEditText.setText(bubbleMainText);
                addSpaceSpan(false);
            }
        }
        EditText editText2 = this.binding.bubbleEditText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.bubbleEditText");
        editText2.setHint(getResources().getString(R.string.xeb));
        addSpaceSpan(true);
    }

    @Override // com.tencent.state.view.IDetailBubbleMainContainer
    public void showEditedView(final OnlineStatus onlineStatus, String draftText, boolean needIcon) {
        Object systemService = getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (!(systemService instanceof InputMethodManager)) {
            systemService = null;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this.binding.bubbleEditText, 0);
        }
        EditText editText = this.binding.bubbleEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.bubbleEditText");
        editText.setActivated(true);
        SquareImageView squareImageView = this.binding.bubblePenIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.bubblePenIcon");
        squareImageView.setVisibility(8);
        if (needIcon) {
            SquareImageView squareImageView2 = this.binding.bubblePenIcon;
            Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.bubblePenIcon");
            squareImageView2.setVisibility(0);
            if (onlineStatus != null) {
                SquareBaseKt.getSquareThread().postOnSubThread(new Function0<Unit>() { // from class: com.tencent.state.view.EditableBubbleMainContainer$showEditedView$$inlined$let$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        final Drawable iconDrawable$default = OnlineStatusBubbleViewHelper.getIconDrawable$default(OnlineStatusBubbleViewHelper.INSTANCE, onlineStatus, true, null, 4, null);
                        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.view.EditableBubbleMainContainer$showEditedView$$inlined$let$lambda$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                EditableBubbleMainContainer.this.getBinding().bubbleEditIcon.setImageDrawable(iconDrawable$default);
                            }
                        });
                    }
                });
            }
        }
        if (onlineStatus != null) {
            if (!this.isClearDraft) {
                if (draftText != null) {
                    if (draftText.length() == 0) {
                        draftText = onlineStatus.getCustomText();
                    }
                } else {
                    draftText = null;
                }
            }
            if (draftText == null) {
                draftText = this.showText;
            }
            this.binding.bubbleEditText.setText(draftText);
            addSpaceSpan(false);
            this.binding.bubbleEditText.setSelection(draftText.length());
        }
        EditText editText2 = this.binding.bubbleEditText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.bubbleEditText");
        editText2.setHint(getResources().getString(R.string.xeb));
        addSpaceSpan(true);
    }

    @Override // com.tencent.state.view.IDetailBubbleMainContainer
    public void updateBubbleSkin(SquareBubbleInfo bubbleInfo) {
        Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
        ColorFormatUtils colorFormatUtils = ColorFormatUtils.INSTANCE;
        SquareBubbleColor color = bubbleInfo.getColor();
        Integer parse = colorFormatUtils.parse(color != null ? color.getFontColor() : null);
        if (parse != null) {
            this.binding.bubbleEditText.setTextColor(parse.intValue());
            SquareBubbleColor color2 = bubbleInfo.getColor();
            Integer parse2 = colorFormatUtils.parse(color2 != null ? color2.getIconColor() : null);
            if (parse2 != null) {
                parse2.intValue();
                this.binding.bubblePenIcon.setColorFilter(parse2.intValue());
            }
        }
    }

    @Override // com.tencent.state.view.IDetailBubbleMainContainer
    public void updateStatusIcon(final OnlineStatus onlineStatus) {
        Intrinsics.checkNotNullParameter(onlineStatus, "onlineStatus");
        if (OnlineStatusBubbleViewHelperKt.isBatteryStatus(onlineStatus)) {
            SquareBaseKt.getSquareThread().postOnSubThread(new Function0<Unit>() { // from class: com.tencent.state.view.EditableBubbleMainContainer$updateStatusIcon$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    final Drawable iconDrawable$default = OnlineStatusBubbleViewHelper.getIconDrawable$default(OnlineStatusBubbleViewHelper.INSTANCE, onlineStatus, true, null, 4, null);
                    SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.view.EditableBubbleMainContainer$updateStatusIcon$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            EditableBubbleMainContainer.this.getBinding().bubbleEditIcon.setImageDrawable(iconDrawable$default);
                        }
                    });
                }
            });
            return;
        }
        String bigIcon = onlineStatus.getBigIcon();
        URLDrawable uRLDrawable = null;
        if (RegexUtils.isValidUrl$default(RegexUtils.INSTANCE, bigIcon, false, 2, null)) {
            URLDrawable.URLDrawableOptions urlDrawableOptions$default = SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null);
            urlDrawableOptions$default.mPlayGifImage = true;
            urlDrawableOptions$default.mUseApngImage = true;
            urlDrawableOptions$default.mUseMemoryCache = true;
            uRLDrawable = URLDrawable.getDrawable(bigIcon, urlDrawableOptions$default);
        }
        this.binding.bubbleEditIcon.setImageDrawable(uRLDrawable);
    }

    @Override // com.tencent.state.view.IDetailBubbleMainContainer
    public void init(OnlineStatus onlineStatus) {
        String str;
        if (onlineStatus == null || (str = onlineStatus.getCustomText()) == null) {
            str = "";
        }
        this.showText = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditableBubbleMainContainer(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        VasSquareItemBubbleEditableMainContainerBinding inflate = VasSquareItemBubbleEditableMainContainerBinding.inflate(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareItemBubbleEdita\u2026ater.from(context), this)");
        this.binding = inflate;
        this.showText = "";
        inflate.bubbleEditText.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.view.EditableBubbleMainContainer.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BubbleEditListener bubbleEditListener;
                EditText editText = EditableBubbleMainContainer.this.getBinding().bubbleEditText;
                Intrinsics.checkNotNullExpressionValue(editText, "binding.bubbleEditText");
                if (editText.isActivated() || (bubbleEditListener = EditableBubbleMainContainer.this.listener) == null) {
                    return;
                }
                bubbleEditListener.enterEdit();
            }
        });
        EditText editText = inflate.bubbleEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.bubbleEditText");
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.state.view.EditableBubbleMainContainer.2
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                if (z16) {
                    BubbleEditListener bubbleEditListener = EditableBubbleMainContainer.this.listener;
                    if (bubbleEditListener != null) {
                        bubbleEditListener.enterEdit();
                        return;
                    }
                    return;
                }
                EditableBubbleMainContainer editableBubbleMainContainer = EditableBubbleMainContainer.this;
                EditText editText2 = editableBubbleMainContainer.getBinding().bubbleEditText;
                Intrinsics.checkNotNullExpressionValue(editText2, "binding.bubbleEditText");
                editableBubbleMainContainer.showText = editText2.getText().toString();
            }
        });
        inflate.bubbleEditText.addTextChangedListener(new TextWatcher() { // from class: com.tencent.state.view.EditableBubbleMainContainer.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s16, int start, int before, int count) {
                OnlineStatusBubbleViewHelper onlineStatusBubbleViewHelper = OnlineStatusBubbleViewHelper.INSTANCE;
                EditText editText2 = EditableBubbleMainContainer.this.getBinding().bubbleEditText;
                Intrinsics.checkNotNullExpressionValue(editText2, "binding.bubbleEditText");
                int editTextLength = onlineStatusBubbleViewHelper.getEditTextLength(editText2.getText().toString()) - 32;
                if (editTextLength < 0) {
                    editTextLength = 0;
                }
                if (editTextLength > 0) {
                    Editable editable = (Editable) (!(s16 instanceof Editable) ? null : s16);
                    if (editable != null) {
                        int i3 = start + count;
                        editable.delete(i3 - editTextLength, i3);
                    }
                }
                int i16 = count - editTextLength;
                if (i16 < 1) {
                    return;
                }
                for (int i17 = i16 - 1; i17 <= 0; i17++) {
                    Integer valueOf = s16 != null ? Integer.valueOf(s16.charAt(i17 + start)) : null;
                    if ((valueOf != null && valueOf.intValue() == 10) || (valueOf != null && valueOf.intValue() == 13)) {
                        Editable editable2 = (Editable) (!(s16 instanceof Editable) ? null : s16);
                        if (editable2 != null) {
                            int i18 = start + i17;
                            editable2.delete(i18, i18 + 1);
                        }
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s16) {
                if (s16 == null || s16.length() == 0) {
                    EditableBubbleMainContainer.this.isClearDraft = true;
                }
                BubbleEditListener bubbleEditListener = EditableBubbleMainContainer.this.listener;
                if (bubbleEditListener != null) {
                    bubbleEditListener.onEditTextChange();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s16, int start, int count, int after) {
            }
        });
        SquareImageView squareImageView = inflate.bubblePenIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.bubblePenIcon");
        squareImageView.setVisibility(0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditableBubbleMainContainer(Context context, AttributeSet attrs, int i3) {
        super(context, attrs, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        VasSquareItemBubbleEditableMainContainerBinding inflate = VasSquareItemBubbleEditableMainContainerBinding.inflate(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareItemBubbleEdita\u2026ater.from(context), this)");
        this.binding = inflate;
        this.showText = "";
        inflate.bubbleEditText.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.view.EditableBubbleMainContainer.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BubbleEditListener bubbleEditListener;
                EditText editText = EditableBubbleMainContainer.this.getBinding().bubbleEditText;
                Intrinsics.checkNotNullExpressionValue(editText, "binding.bubbleEditText");
                if (editText.isActivated() || (bubbleEditListener = EditableBubbleMainContainer.this.listener) == null) {
                    return;
                }
                bubbleEditListener.enterEdit();
            }
        });
        EditText editText = inflate.bubbleEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.bubbleEditText");
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.state.view.EditableBubbleMainContainer.2
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                if (z16) {
                    BubbleEditListener bubbleEditListener = EditableBubbleMainContainer.this.listener;
                    if (bubbleEditListener != null) {
                        bubbleEditListener.enterEdit();
                        return;
                    }
                    return;
                }
                EditableBubbleMainContainer editableBubbleMainContainer = EditableBubbleMainContainer.this;
                EditText editText2 = editableBubbleMainContainer.getBinding().bubbleEditText;
                Intrinsics.checkNotNullExpressionValue(editText2, "binding.bubbleEditText");
                editableBubbleMainContainer.showText = editText2.getText().toString();
            }
        });
        inflate.bubbleEditText.addTextChangedListener(new TextWatcher() { // from class: com.tencent.state.view.EditableBubbleMainContainer.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s16, int start, int before, int count) {
                OnlineStatusBubbleViewHelper onlineStatusBubbleViewHelper = OnlineStatusBubbleViewHelper.INSTANCE;
                EditText editText2 = EditableBubbleMainContainer.this.getBinding().bubbleEditText;
                Intrinsics.checkNotNullExpressionValue(editText2, "binding.bubbleEditText");
                int editTextLength = onlineStatusBubbleViewHelper.getEditTextLength(editText2.getText().toString()) - 32;
                if (editTextLength < 0) {
                    editTextLength = 0;
                }
                if (editTextLength > 0) {
                    Editable editable = (Editable) (!(s16 instanceof Editable) ? null : s16);
                    if (editable != null) {
                        int i36 = start + count;
                        editable.delete(i36 - editTextLength, i36);
                    }
                }
                int i16 = count - editTextLength;
                if (i16 < 1) {
                    return;
                }
                for (int i17 = i16 - 1; i17 <= 0; i17++) {
                    Integer valueOf = s16 != null ? Integer.valueOf(s16.charAt(i17 + start)) : null;
                    if ((valueOf != null && valueOf.intValue() == 10) || (valueOf != null && valueOf.intValue() == 13)) {
                        Editable editable2 = (Editable) (!(s16 instanceof Editable) ? null : s16);
                        if (editable2 != null) {
                            int i18 = start + i17;
                            editable2.delete(i18, i18 + 1);
                        }
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s16) {
                if (s16 == null || s16.length() == 0) {
                    EditableBubbleMainContainer.this.isClearDraft = true;
                }
                BubbleEditListener bubbleEditListener = EditableBubbleMainContainer.this.listener;
                if (bubbleEditListener != null) {
                    bubbleEditListener.onEditTextChange();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s16, int start, int count, int after) {
            }
        });
        SquareImageView squareImageView = inflate.bubblePenIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.bubblePenIcon");
        squareImageView.setVisibility(0);
    }
}
