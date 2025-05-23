package com.tencent.qqmini.sdk.plugins;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.widget.KeyboardLayout;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class InputJsPlugin extends BaseJsPlugin {
    public static final String EVENT_HIDE_KEY_BORAD = "hideKeyboard";
    public static final String EVENT_SHOW_KEY_BORAD = "showKeyboard";
    public static final String EVENT_SHOW_KEY_BORAD_VALUE = "setKeyboardValue";
    public static final String EVENT_UPDATE_INPUT = "updateInput";
    public static final String EVENT_UPDATE_KEYBOARD = "updateKeyboard";
    public static final String ON_KEYBOARD_COMPLETE_CALLBACK = "onKeyboardComplete";
    public static final String ON_KEYBOARD_CONFIRM_CALLBACK = "onKeyboardConfirm";
    public static final String ON_KEYBOARD_INPUT_CALLBACK = "onKeyboardInput";
    private static final String TAG = "InputJsPlugin";
    private long lastShowInputTime;
    private KeyboardLayout mKeyboardLayout;
    private SoftKeyboardStateHelper mSoftKeyboardStateHelper;
    private boolean hasNotifiedKeyboardClosedEvent = false;
    private SoftKeyboardStateHelper.SoftKeyboardStateListener mListener = new SoftKeyboardStateHelper.SoftKeyboardStateListener() { // from class: com.tencent.qqmini.sdk.plugins.InputJsPlugin.1
        @Override // com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardClosed() {
            if (!InputJsPlugin.this.hasNotifiedKeyboardClosedEvent) {
                InputJsPlugin.this.manuallyNotifySoftKeyBoardClosed();
            }
            if (InputJsPlugin.this.mKeyboardLayout != null && InputJsPlugin.this.mKeyboardLayout.getVisibility() == 0) {
                InputJsPlugin.this.mKeyboardLayout.setVisibility(8);
            }
            if (((BaseJsPlugin) InputJsPlugin.this).mMiniAppContext != null && ((BaseJsPlugin) InputJsPlugin.this).mMiniAppContext.getAttachActivity() != null) {
                DisplayUtil.setActivityFullScreen(((BaseJsPlugin) InputJsPlugin.this).mMiniAppContext.getAttachActivity());
            }
        }

        @Override // com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardOpened(int i3) {
            if (InputJsPlugin.this.mKeyboardLayout != null && InputJsPlugin.this.mKeyboardLayout.getVisibility() == 0) {
                InputJsPlugin.this.mKeyboardLayout.setPaddingBottom(i3);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class a implements View.OnKeyListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RequestEvent f348200d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ KeyboardLayout f348201e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f348202f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ EditText f348203h;

        a(RequestEvent requestEvent, KeyboardLayout keyboardLayout, Context context, EditText editText) {
            this.f348200d = requestEvent;
            this.f348201e = keyboardLayout;
            this.f348202f = context;
            this.f348203h = editText;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            if (i3 == 4) {
                InputJsPlugin.this.handleInputCompleteEvent(this.f348200d, this.f348201e, this.f348202f, this.f348203h);
                return true;
            }
            return false;
        }
    }

    private void addTextChangedListener(final RequestEvent requestEvent, EditText editText) {
        editText.addTextChangedListener(new TextWatcher() { // from class: com.tencent.qqmini.sdk.plugins.InputJsPlugin.6
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("value", editable.toString());
                    requestEvent.jsService.evaluateSubscribeJS(InputJsPlugin.ON_KEYBOARD_INPUT_CALLBACK, jSONObject.toString(), 0);
                } catch (JSONException e16) {
                    QMLog.e(InputJsPlugin.TAG, "afterTextChanged callback exception", e16);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }
        });
    }

    private String getInputValueOfInputET() {
        EditText inputET = getKeyboard().getInputET();
        if (inputET != null) {
            return inputET.getText().toString();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleHideKeyboard(RequestEvent requestEvent, KeyboardLayout keyboardLayout) {
        try {
            EditText inputET = keyboardLayout.getInputET();
            requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackOk("hideKeyboard", null).toString());
            if (keyboardLayout.getVisibility() != 8) {
                keyboardLayout.setVisibility(8);
            }
            hideSoftInput(keyboardLayout.getContext(), inputET);
        } catch (Exception e16) {
            QMLog.e(TAG, "hideKeyboard exception", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleInputCompleteEvent(RequestEvent requestEvent, KeyboardLayout keyboardLayout, Context context, EditText editText) {
        try {
            String obj = editText.getText().toString();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", obj);
            requestEvent.jsService.evaluateSubscribeJS(ON_KEYBOARD_CONFIRM_CALLBACK, jSONObject.toString(), 0);
            if (keyboardLayout.getVisibility() != 8) {
                keyboardLayout.setVisibility(8);
            }
            hideSoftInput(context, editText);
            requestEvent.jsService.evaluateSubscribeJS(ON_KEYBOARD_COMPLETE_CALLBACK, jSONObject.toString(), 0);
            this.hasNotifiedKeyboardClosedEvent = true;
            if (context instanceof Activity) {
                DisplayUtil.setActivityFullScreen((Activity) context);
            }
        } catch (JSONException e16) {
            QMLog.e(TAG, "onKeyboard complete callback exception", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleShowKeyboard(RequestEvent requestEvent, KeyboardLayout keyboardLayout) {
        try {
            this.hasNotifiedKeyboardClosedEvent = false;
            Context context = keyboardLayout.getContext();
            if (keyboardLayout.getVisibility() != 0) {
                keyboardLayout.setVisibility(0);
            }
            keyboardLayout.setParam(requestEvent.jsonParams);
            EditText inputET = keyboardLayout.getInputET();
            Button confirmBT = keyboardLayout.getConfirmBT();
            showSoftInput(context, inputET);
            addTextChangedListener(requestEvent, inputET);
            setOnEditorActionListener(requestEvent, keyboardLayout, context, inputET);
            setOnClickListener(requestEvent, keyboardLayout, context, inputET, confirmBT);
            setOnKeyBackListener(requestEvent, keyboardLayout, context, inputET);
            requestEvent.ok(ApiUtil.wrapCallbackOk("showKeyboard", null));
        } catch (Exception e16) {
            QMLog.e(TAG, "showKeyboard exception", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdateKeyboard(RequestEvent requestEvent, KeyboardLayout keyboardLayout) {
        try {
            EditText inputET = keyboardLayout.getInputET();
            inputET.setText(new JSONObject(requestEvent.jsonParams).optString("value", ""));
            inputET.setSelection(inputET.getText().length());
            requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackOk(EVENT_UPDATE_KEYBOARD, null).toString());
        } catch (Exception e16) {
            QMLog.e(TAG, "updateKeyboard exception", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideSoftInput(Context context, EditText editText) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
        editText.clearFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void manuallyNotifySoftKeyBoardClosed() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", getInputValueOfInputET());
            IMiniAppContext iMiniAppContext = this.mMiniAppContext;
            if (iMiniAppContext != null && ((BaseRuntime) iMiniAppContext).getJsService() != null) {
                ((BaseRuntime) this.mMiniAppContext).getJsService().evaluateSubscribeJS(ON_KEYBOARD_CONFIRM_CALLBACK, jSONObject.toString(), 0);
                ((BaseRuntime) this.mMiniAppContext).getJsService().evaluateSubscribeJS(ON_KEYBOARD_COMPLETE_CALLBACK, jSONObject.toString(), 0);
                this.hasNotifiedKeyboardClosedEvent = true;
            }
        } catch (JSONException e16) {
            QMLog.e(TAG, "softKeyBoard fold call exception", e16);
        }
    }

    private void setOnClickListener(final RequestEvent requestEvent, final KeyboardLayout keyboardLayout, final Context context, final EditText editText, Button button) {
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.plugins.InputJsPlugin.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                try {
                    String obj = editText.getText().toString();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("value", obj);
                    requestEvent.jsService.evaluateSubscribeJS(InputJsPlugin.ON_KEYBOARD_CONFIRM_CALLBACK, jSONObject.toString(), 0);
                    if (!keyboardLayout.isConfirmHold()) {
                        if (keyboardLayout.getVisibility() != 8) {
                            keyboardLayout.setVisibility(8);
                        }
                        InputJsPlugin.this.hideSoftInput(context, editText);
                    }
                    requestEvent.jsService.evaluateSubscribeJS(InputJsPlugin.ON_KEYBOARD_COMPLETE_CALLBACK, jSONObject.toString(), 0);
                    InputJsPlugin.this.hasNotifiedKeyboardClosedEvent = true;
                    Context context2 = context;
                    if (context2 instanceof Activity) {
                        DisplayUtil.setActivityFullScreen((Activity) context2);
                    }
                } catch (JSONException e16) {
                    QMLog.e(InputJsPlugin.TAG, "confirm button click callback exception", e16);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }

    private void setOnEditorActionListener(final RequestEvent requestEvent, final KeyboardLayout keyboardLayout, final Context context, final EditText editText) {
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tencent.qqmini.sdk.plugins.InputJsPlugin.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                boolean z16;
                if (i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5 || i3 == 6) {
                    InputJsPlugin.this.handleInputCompleteEvent(requestEvent, keyboardLayout, context, editText);
                    z16 = true;
                } else {
                    z16 = false;
                }
                EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
                return z16;
            }
        });
    }

    private void setOnKeyBackListener(RequestEvent requestEvent, KeyboardLayout keyboardLayout, Context context, EditText editText) {
        editText.setOnKeyListener(new a(requestEvent, keyboardLayout, context, editText));
    }

    private void showSoftInput(Context context, EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(editText, 2);
        }
    }

    public KeyboardLayout getKeyboard() {
        if (this.mKeyboardLayout == null) {
            IMiniAppContext iMiniAppContext = this.mMiniAppContext;
            if (iMiniAppContext != null && iMiniAppContext.getAttachActivity() != null) {
                ViewGroup viewGroup = (ViewGroup) this.mMiniAppContext.getAttachActivity().findViewById(R.id.content);
                new RelativeLayout(this.mMiniAppContext.getAttachActivity());
                this.mKeyboardLayout = new KeyboardLayout(this.mMiniAppContext.getAttachActivity());
                if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    viewGroup.addView(this.mKeyboardLayout, layoutParams);
                } else if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams2.addRule(12);
                    viewGroup.addView(this.mKeyboardLayout, layoutParams2);
                }
                SoftKeyboardStateHelper softKeyboardStateHelper = new SoftKeyboardStateHelper(viewGroup);
                this.mSoftKeyboardStateHelper = softKeyboardStateHelper;
                softKeyboardStateHelper.addSoftKeyboardStateListener(this.mListener);
            } else {
                return null;
            }
        }
        return this.mKeyboardLayout;
    }

    @JsEvent({"hideKeyboard"})
    public void hideKeyboard(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.InputJsPlugin.4
            @Override // java.lang.Runnable
            public void run() {
                KeyboardLayout keyboard = InputJsPlugin.this.getKeyboard();
                if (keyboard != null) {
                    InputJsPlugin.this.handleHideKeyboard(requestEvent, keyboard);
                } else {
                    requestEvent.fail();
                }
            }
        });
    }

    public void hideKeyboardUI() {
        Activity activity;
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null) {
            activity = iMiniAppContext.getAttachActivity();
        } else {
            activity = null;
        }
        KeyboardLayout keyboardLayout = this.mKeyboardLayout;
        if (keyboardLayout != null && keyboardLayout.getVisibility() == 0 && activity != null) {
            hideSoftInput(activity, this.mKeyboardLayout.getInputET());
            this.mKeyboardLayout.setVisibility(8);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.IJsPlugin
    public boolean onInterceptJsEvent(RequestEvent requestEvent) {
        if (!this.mIsMiniGame) {
            this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(requestEvent, 2));
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onPause() {
        hideKeyboardUI();
    }

    @JsEvent({"showKeyboard"})
    public void showKeyboard(final RequestEvent requestEvent) {
        if (System.currentTimeMillis() - this.lastShowInputTime > 1000) {
            this.lastShowInputTime = System.currentTimeMillis();
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.InputJsPlugin.2
                @Override // java.lang.Runnable
                public void run() {
                    KeyboardLayout keyboard = InputJsPlugin.this.getKeyboard();
                    if (keyboard != null) {
                        InputJsPlugin.this.handleShowKeyboard(requestEvent, keyboard);
                    } else {
                        requestEvent.fail();
                    }
                }
            });
        }
    }

    @JsEvent({EVENT_UPDATE_KEYBOARD})
    public void updateKeyboard(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.InputJsPlugin.3
            @Override // java.lang.Runnable
            public void run() {
                KeyboardLayout keyboard = InputJsPlugin.this.getKeyboard();
                if (keyboard != null) {
                    InputJsPlugin.this.handleUpdateKeyboard(requestEvent, keyboard);
                } else {
                    requestEvent.fail();
                }
            }
        });
    }

    @JsEvent({EVENT_SHOW_KEY_BORAD_VALUE})
    public void setKeyboardValue(RequestEvent requestEvent) {
    }

    @JsEvent({EVENT_UPDATE_INPUT})
    public void updateInput(RequestEvent requestEvent) {
    }
}
