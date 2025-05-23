package com.tencent.ad.tangram.views.form.textbox;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.views.form.AdFormError;
import com.tencent.ad.tangram.views.form.framework.AdFormErrorListener;
import com.tencent.ad.tangram.views.form.framework.AdFormItemData;
import com.tencent.ad.tangram.views.form.framework.AdFormItemView;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdFormItemTextBoxView extends AdFormItemView {
    private static final String TAG = "AdFormItemTextBoxView";
    private EditText editText;

    public AdFormItemTextBoxView(Context context, AdFormItemTextBoxData adFormItemTextBoxData, WeakReference<AdFormErrorListener> weakReference) {
        super(context, adFormItemTextBoxData, weakReference);
    }

    @NonNull
    private TextView.OnEditorActionListener createEditorActionListener() {
        return new TextView.OnEditorActionListener() { // from class: com.tencent.ad.tangram.views.form.textbox.AdFormItemTextBoxView.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                if (i3 == 6) {
                    AdLog.i(AdFormItemTextBoxView.TAG, "onEditorActionDone " + AdFormItemTextBoxView.this.getIndex());
                    AdFormItemTextBoxView.this.editText.clearFocus();
                    AdFormItemTextBoxView.hideSoftInput(textView);
                } else {
                    AdLog.i(AdFormItemTextBoxView.TAG, "onEditorAction " + i3 + " " + AdFormItemTextBoxView.this.getIndex());
                }
                EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
                return false;
            }
        };
    }

    @NonNull
    private View.OnFocusChangeListener createFocusChangeListener() {
        return new View.OnFocusChangeListener() { // from class: com.tencent.ad.tangram.views.form.textbox.AdFormItemTextBoxView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z16) {
                if (AdFormItemTextBoxView.this.getData() != null && AdFormItemTextBoxView.this.getData().isValid()) {
                    if (!z16) {
                        AdFormItemTextBoxView.this.validate();
                        return;
                    }
                    AdFormError adFormError = new AdFormError(2, -1, AdFormItemTextBoxView.this.getData().title.text);
                    adFormError.index = AdFormItemTextBoxView.this.getIndex();
                    AdFormItemTextBoxView.this.showError(adFormError);
                    return;
                }
                AdLog.i(AdFormItemTextBoxView.TAG, "onFocusChange error");
            }
        };
    }

    @NonNull
    private TextWatcher createTextChangedListener() {
        return new TextWatcher() { // from class: com.tencent.ad.tangram.views.form.textbox.AdFormItemTextBoxView.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                if (AdFormItemTextBoxView.this.getData() != null && AdFormItemTextBoxView.this.getData().isValid() && editable != null) {
                    AdLog.i(AdFormItemTextBoxView.TAG, "afterTextChanged " + editable.toString());
                    AdFormItemTextBoxView.this.getData().content.text = editable.toString();
                    return;
                }
                AdLog.e(AdFormItemTextBoxView.TAG, "afterTextChanged error");
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hideSoftInput(@Nullable TextView textView) {
        if (textView != null && textView.getContext() != null && textView.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD) != null && (textView.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD) instanceof InputMethodManager)) {
            try {
                ((InputMethodManager) InputMethodManager.class.cast(textView.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD))).hideSoftInputFromWindow(textView.getWindowToken(), 0);
                return;
            } catch (Throwable th5) {
                AdLog.e(TAG, "hideSoftInput", th5);
                return;
            }
        }
        AdLog.e(TAG, "hideSoftInput error");
    }

    @Override // com.tencent.ad.tangram.views.form.framework.AdFormItemView
    @Nullable
    protected View createContentView(Context context) {
        InputFilter[] inputFilterArr;
        if (getData() != null && getData().isValid()) {
            EditText editText = new EditText(context);
            this.editText = editText;
            boolean z16 = false;
            editText.setBackgroundColor(0);
            this.editText.setGravity(16);
            this.editText.setTextColor(getData().content.color);
            this.editText.setTextSize(0, getData().content.size);
            if (getData().placeholder != null) {
                this.editText.setHint(getData().placeholder.text);
                this.editText.setHintTextColor(getData().placeholder.color);
            }
            if (getData().content.lengthMax >= 0) {
                InputFilter.LengthFilter lengthFilter = new InputFilter.LengthFilter(getData().content.lengthMax);
                if (this.editText.getFilters() != null && this.editText.getFilters().length > 0) {
                    int length = this.editText.getFilters().length + 1;
                    inputFilterArr = new InputFilter[length];
                    System.arraycopy(this.editText.getFilters(), 0, inputFilterArr, 0, this.editText.getFilters().length);
                    inputFilterArr[length - 1] = lengthFilter;
                } else {
                    inputFilterArr = new InputFilter[]{lengthFilter};
                }
                this.editText.setFilters(inputFilterArr);
            }
            EditText editText2 = this.editText;
            if (getData().lines == 1) {
                z16 = true;
            }
            editText2.setSingleLine(z16);
            this.editText.setMinLines(getData().lines);
            this.editText.setMaxLines(getData().lines);
            this.editText.addTextChangedListener(createTextChangedListener());
            this.editText.setOnFocusChangeListener(createFocusChangeListener());
            this.editText.setOnEditorActionListener(createEditorActionListener());
            return this.editText;
        }
        AdLog.e(TAG, "createContentView error");
        return null;
    }

    @Override // com.tencent.ad.tangram.views.form.framework.AdFormItemView
    public void reset() {
        EditText editText = this.editText;
        if (editText == null) {
            AdLog.e(TAG, "reset error");
        } else {
            editText.setText((CharSequence) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ad.tangram.views.form.framework.AdFormItemView
    @Nullable
    public AdFormItemTextBoxData getData() {
        AdFormItemData data = super.getData();
        if (data instanceof AdFormItemTextBoxData) {
            return (AdFormItemTextBoxData) AdFormItemTextBoxData.class.cast(data);
        }
        return null;
    }
}
