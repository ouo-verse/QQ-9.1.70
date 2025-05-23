package com.tencent.qqmini.sdk.widget;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class KeyboardLayout extends RelativeLayout {
    private static final String TAG = "KeyboardLayout";
    private Button mConfirmBT;
    private boolean mConfirmHold;
    private EditText mInputET;

    public KeyboardLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.mInputET = new EditText(getContext());
        this.mConfirmBT = new Button(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.leftMargin = DisplayUtil.dip2px(getContext(), 4.0f);
        layoutParams.rightMargin = DisplayUtil.dip2px(getContext(), 4.0f);
        layoutParams.topMargin = DisplayUtil.dip2px(getContext(), 2.0f);
        layoutParams.bottomMargin = DisplayUtil.dip2px(getContext(), 4.0f);
        this.mConfirmBT.setText(R.string.mini_sdk_keyboard_ok);
        this.mConfirmBT.setTextColor(-1);
        this.mConfirmBT.setBackgroundResource(R.drawable.mini_sdk_game_keyboard_confirm_btn_bg);
        this.mConfirmBT.setMinHeight(0);
        this.mConfirmBT.setMinimumHeight(0);
        this.mConfirmBT.setPadding(DisplayUtil.dip2px(getContext(), 10.0f), DisplayUtil.dip2px(getContext(), 5.0f), DisplayUtil.dip2px(getContext(), 10.0f), DisplayUtil.dip2px(getContext(), 5.0f));
        addView(this.mConfirmBT, layoutParams);
        this.mConfirmBT.setId(R.id.mini_game_keyboard_input);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(0, this.mConfirmBT.getId());
        layoutParams2.leftMargin = DisplayUtil.dip2px(getContext(), 6.0f);
        layoutParams2.topMargin = DisplayUtil.dip2px(getContext(), 4.0f);
        this.mInputET.setBackgroundResource(R.drawable.mini_sdk_game_keyboard_editext_bg);
        this.mInputET.setPadding(DisplayUtil.dip2px(getContext(), 4.0f), DisplayUtil.dip2px(getContext(), 5.0f), DisplayUtil.dip2px(getContext(), 4.0f), DisplayUtil.dip2px(getContext(), 5.0f));
        addView(this.mInputET, layoutParams2);
        setBackgroundColor(-1);
        setPadding(0, DisplayUtil.dip2px(getContext(), 5.0f), 0, DisplayUtil.dip2px(getContext(), 2.0f));
    }

    public Button getConfirmBT() {
        return this.mConfirmBT;
    }

    public EditText getInputET() {
        return this.mInputET;
    }

    public boolean isConfirmHold() {
        return this.mConfirmHold;
    }

    public void setPaddingBottom(int i3) {
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), i3);
    }

    public void setParam(String str) {
        int i3;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(RemoteHandleConst.PARAM_DEFAULT_VALUE, "");
                int optInt = jSONObject.optInt("maxLength", -1);
                boolean z16 = false;
                boolean optBoolean = jSONObject.optBoolean("multiple", false);
                boolean optBoolean2 = jSONObject.optBoolean("confirmHold", false);
                String optString2 = jSONObject.optString("confirmType");
                CharSequence text = getResources().getText(R.string.mini_sdk_keyboard_ok);
                if ("send".equals(optString2)) {
                    text = getResources().getText(R.string.mini_sdk_keyboard_send);
                    i3 = 4;
                } else if ("search".equals(optString2)) {
                    text = getResources().getText(R.string.mini_sdk_keyboard_search);
                    i3 = 3;
                } else if ("next".equals(optString2)) {
                    text = getResources().getText(R.string.mini_sdk_keyboard_next);
                    i3 = 5;
                } else if (ResourceAttributes.TelemetrySdkLanguageValues.GO.equals(optString2)) {
                    text = getResources().getText(R.string.mini_sdk_keyboard_go);
                    i3 = 2;
                } else {
                    i3 = 6;
                }
                this.mInputET.setText(optString);
                if (optInt >= 0) {
                    this.mInputET.setFilters(new InputFilter[]{new InputFilter.LengthFilter(optInt)});
                } else {
                    this.mInputET.setFilters(new InputFilter[0]);
                }
                EditText editText = this.mInputET;
                if (!optBoolean) {
                    z16 = true;
                }
                editText.setSingleLine(z16);
                this.mInputET.setImeOptions(i3 | 268435456 | 33554432);
                EditText editText2 = this.mInputET;
                editText2.setSelection(editText2.getText().length());
                this.mConfirmHold = optBoolean2;
                this.mConfirmBT.setText(text);
                return;
            } catch (JSONException e16) {
                QMLog.e(TAG, "setParam exception", e16);
                return;
            }
        }
        QMLog.e(TAG, "setParam no param ?");
    }
}
