package com.tenpay.sdk.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.QwLog;
import com.tenpay.api.TTSUtil;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TenpayEditText extends EditText {
    private boolean enableAutoChangeColor;
    int mColor;

    public TenpayEditText(Context context) {
        super(context);
        this.enableAutoChangeColor = true;
        init(context);
    }

    private void init(Context context) {
        setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tenpay.sdk.view.TenpayEditText.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                InputMethodManager inputMethodManager;
                QwLog.i("onEditorAction:");
                if (keyEvent != null) {
                    QwLog.i("eventCode:" + keyEvent.getKeyCode());
                    if (keyEvent.getKeyCode() == 66) {
                        i3 = 6;
                    }
                }
                if (i3 == 6 && (inputMethodManager = (InputMethodManager) TenpayEditText.this.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)) != null) {
                    inputMethodManager.hideSoftInputFromWindow(TenpayEditText.this.getWindowToken(), 0);
                }
                EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
                return false;
            }
        });
        this.mColor = getCurrentTextColor();
        addTextChangedListener(new TextWatcher() { // from class: com.tenpay.sdk.view.TenpayEditText.2
            CharSequence stringBeforeDelete;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
                this.stringBeforeDelete = charSequence.toString();
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
                TenpayEditText.this.clearError();
                if (i17 < i16) {
                    TTSUtil.speak(TenpayEditText.this, ((Object) this.stringBeforeDelete.subSequence(i3, i3 + 1)) + "\u5df2\u5220\u9664");
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    public void clearError() {
        if (this.enableAutoChangeColor) {
            setTextColor(this.mColor);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QwLog.i(NodeProps.ON_DETACHED_FROM_WINDOW);
        TTSUtil.stop();
    }

    public void onError() {
        if (this.enableAutoChangeColor) {
            setTextColor(-2293760);
        }
    }

    public void setEnableAutoChangeColor(boolean z16) {
        this.enableAutoChangeColor = z16;
    }

    public TenpayEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.enableAutoChangeColor = true;
        init(context);
    }

    public TenpayEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.enableAutoChangeColor = true;
        init(context.getApplicationContext());
    }
}
