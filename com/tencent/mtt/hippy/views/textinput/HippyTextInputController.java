package com.tencent.mtt.hippy.views.textinput;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.huawei.hms.hihealth.data.Value;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.dom.node.StyleNode;
import com.tencent.mtt.hippy.dom.node.TextExtra;
import com.tencent.mtt.hippy.dom.node.TextNode;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.LinkedList;

/* compiled from: P */
@HippyController(name = HippyTextInputController.CLASS_NAME)
/* loaded from: classes20.dex */
public class HippyTextInputController extends HippyViewController<HippyTextInput> {
    public static final String CLASS_NAME = "TextInput";
    private static final String CLEAR_FUNCTION = "clear";
    public static final String COMMAND_BLUR = "blurTextInput";
    public static final String COMMAND_FOCUS = "focusTextInput";
    public static final String COMMAND_IS_FOCUSED = "isFocused";
    public static final String COMMAND_KEYBOARD_DISMISS = "dissmiss";
    public static final String COMMAND_getValue = "getValue";
    public static final String COMMAND_setValue = "setValue";
    private static final InputFilter[] EMPTY_FILTERS = new InputFilter[0];
    private static final int INPUT_TYPE_KEYBOARD_NUMBERED = 12290;
    private static final String KEYBOARD_TYPE_EMAIL_ADDRESS = "email";
    private static final String KEYBOARD_TYPE_NUMERIC = "numeric";
    private static final String KEYBOARD_TYPE_PASS_WORD = "password";
    private static final String KEYBOARD_TYPE_PHONE_PAD = "phone-pad";
    private static final String TAG = "HippyTextInputControlle";

    private static int parseFontWeight(String str) {
        if (str.length() == 3 && str.endsWith("00") && str.charAt(0) <= '9' && str.charAt(0) >= '1') {
            return (str.charAt(0) - '0') * 100;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public StyleNode createNode(boolean z16) {
        return new TextInputNode(z16);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new HippyTextInput(context);
    }

    @HippyControllerProps(defaultNumber = Value.DOUBLE_DEFAULT_VALUE_FROM_PARCLE, defaultType = "number", name = NodeProps.LETTER_SPACING)
    public void letterSpacing(HippyTextInput hippyTextInput, float f16) {
        if (f16 != -1.0f) {
            hippyTextInput.setLetterSpacing(PixelUtil.dp2px(f16));
        }
    }

    @HippyControllerProps(defaultNumber = 2.147483647E9d, defaultType = "number", name = "maxLength")
    public void maxLength(HippyTextInput hippyTextInput, int i3) {
        InputFilter[] filters = hippyTextInput.getFilters();
        InputFilter[] inputFilterArr = EMPTY_FILTERS;
        if (i3 == -1) {
            if (filters.length > 0) {
                LinkedList linkedList = new LinkedList();
                for (InputFilter inputFilter : filters) {
                    if (!(inputFilter instanceof InputFilter.LengthFilter)) {
                        linkedList.add(inputFilter);
                    }
                }
                if (!linkedList.isEmpty()) {
                    inputFilterArr = (InputFilter[]) linkedList.toArray(new InputFilter[linkedList.size()]);
                }
            }
        } else if (filters.length > 0) {
            boolean z16 = false;
            for (int i16 = 0; i16 < filters.length; i16++) {
                if (filters[i16] instanceof InputFilter.LengthFilter) {
                    filters[i16] = new InputFilter.LengthFilter(i3);
                    z16 = true;
                }
            }
            if (!z16) {
                InputFilter[] inputFilterArr2 = new InputFilter[filters.length + 1];
                System.arraycopy(filters, 0, inputFilterArr2, 0, filters.length);
                inputFilterArr2[filters.length] = new InputFilter.LengthFilter(i3);
                filters = inputFilterArr2;
            }
            inputFilterArr = filters;
        } else {
            inputFilterArr = new InputFilter[]{new InputFilter.LengthFilter(i3)};
        }
        hippyTextInput.setFilters(inputFilterArr);
    }

    @HippyControllerProps(defaultBoolean = true, defaultType = HippyControllerProps.BOOLEAN, name = "multiline")
    public void multiLine(HippyTextInput hippyTextInput, boolean z16) {
        int i3;
        int inputType = hippyTextInput.getInputType();
        if (z16) {
            i3 = inputType | 131072;
        } else {
            i3 = inputType & (-131073);
        }
        hippyTextInput.setInputType(i3);
        if (z16) {
            hippyTextInput.setGravityVertical(48);
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "placeholder")
    public void placeHolder(HippyTextInput hippyTextInput, String str) {
        hippyTextInput.setHint(str);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "onBlur")
    public void setBlur(HippyTextInput hippyTextInput, boolean z16) {
        hippyTextInput.setBlurOrOnFocus(z16);
    }

    @HippyControllerProps(defaultString = "simple", defaultType = HippyControllerProps.STRING, name = NodeProps.BREAK_STRATEGY)
    public void setBreakStrategy(HippyTextInput hippyTextInput, String str) {
        int i3;
        if (!TextUtils.isEmpty(str) && !"simple".equals(str)) {
            if (TextNode.STRATEGY_HIGH_QUALITY.equals(str)) {
                i3 = 1;
            } else if (TextNode.STRATEGY_BALANCED.equals(str)) {
                i3 = 2;
            } else {
                throw new RuntimeException("Invalid breakStrategy: " + str);
            }
        } else {
            i3 = 0;
        }
        hippyTextInput.setBreakStrategy(i3);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "caret-color")
    public void setCaretColor(HippyTextInput hippyTextInput, int i3) {
        hippyTextInput.setCursorColor(i3);
    }

    @HippyControllerProps(defaultType = "number", name = "color")
    public void setColor(HippyTextInput hippyTextInput, int i3) {
        hippyTextInput.setTextColor(i3);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = RemoteHandleConst.PARAM_DEFAULT_VALUE)
    public void setDefaultValue(HippyTextInput hippyTextInput, String str) {
        if (!TextUtils.equals(hippyTextInput.getText().toString(), str)) {
            hippyTextInput.setText(str);
            if (!TextUtils.isEmpty(str)) {
                hippyTextInput.setSelection(str.length());
            }
        }
    }

    @HippyControllerProps(defaultBoolean = true, defaultType = HippyControllerProps.BOOLEAN, name = "editable")
    public void setEditable(HippyTextInput hippyTextInput, boolean z16) {
        hippyTextInput.setEnabled(z16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "onEndEditing")
    public void setEndEditing(HippyTextInput hippyTextInput, boolean z16) {
        hippyTextInput.setOnEndEditingListener(z16);
    }

    @HippyControllerProps(defaultString = "normal", defaultType = HippyControllerProps.STRING, name = "fontFamily")
    public void setFontFamily(HippyTextInput hippyTextInput, String str) {
        int i3;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (hippyTextInput.getTypeface() != null) {
            i3 = hippyTextInput.getTypeface().getStyle();
        } else {
            i3 = 0;
        }
        hippyTextInput.setTypeface(Typeface.create(str, i3));
    }

    @HippyControllerProps(defaultNumber = 14.0d, defaultType = "number", name = "fontSize")
    public void setFontSize(HippyTextInput hippyTextInput, float f16) {
        hippyTextInput.setTextSize(0, (int) Math.ceil(PixelUtil.dp2px(f16)));
    }

    @HippyControllerProps(defaultString = "normal", defaultType = HippyControllerProps.STRING, name = "fontStyle")
    public void setFontStyle(HippyTextInput hippyTextInput, String str) {
        int i3;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("italic".equals(str)) {
            i3 = 2;
        } else if ("normal".equals(str)) {
            i3 = 0;
        } else {
            i3 = -1;
        }
        Typeface typeface = hippyTextInput.getTypeface();
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        if (i3 != typeface.getStyle()) {
            hippyTextInput.setTypeface(typeface, i3);
        }
    }

    @HippyControllerProps(defaultString = "normal", defaultType = HippyControllerProps.STRING, name = "fontWeight")
    public void setFontWeight(HippyTextInput hippyTextInput, String str) {
        int i3;
        int i16 = -1;
        if (str != null) {
            i3 = parseFontWeight(str);
        } else {
            i3 = -1;
        }
        if (i3 < 500 && !"bold".equals(str)) {
            if ("normal".equals(str) || (i3 != -1 && i3 < 500)) {
                i16 = 0;
            }
        } else {
            i16 = 1;
        }
        Typeface typeface = hippyTextInput.getTypeface();
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        if (i16 != typeface.getStyle()) {
            hippyTextInput.setTypeface(typeface, i16);
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "keyboardType")
    public void setKeyboardType(HippyTextInput hippyTextInput, String str) {
        int i3;
        if (KEYBOARD_TYPE_NUMERIC.equalsIgnoreCase(str)) {
            i3 = 12290;
        } else if ("email".equalsIgnoreCase(str)) {
            i3 = 33;
        } else if (KEYBOARD_TYPE_PHONE_PAD.equalsIgnoreCase(str)) {
            i3 = 3;
        } else if ("password".equalsIgnoreCase(str)) {
            hippyTextInput.setTransformationMethod(PasswordTransformationMethod.getInstance());
            i3 = 129;
        } else {
            i3 = 1;
        }
        hippyTextInput.setInputType(i3);
    }

    @HippyControllerProps(defaultNumber = 2.147483647E9d, defaultType = "number", name = NodeProps.NUMBER_OF_LINES)
    public void setMaxLines(HippyTextInput hippyTextInput, int i3) {
        hippyTextInput.setMaxLines(i3);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "onChangeText")
    public void setOnChangeText(HippyTextInput hippyTextInput, boolean z16) {
        hippyTextInput.setOnChangeListener(z16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "onContentSizeChange")
    public void setOnContentSizeChange(HippyTextInput hippyTextInput, boolean z16) {
        hippyTextInput.setOnContentSizeChange(z16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "onFocus")
    public void setOnFocus(HippyTextInput hippyTextInput, boolean z16) {
        hippyTextInput.setBlurOrOnFocus(z16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "onSelectionChange")
    public void setOnSelectionChange(HippyTextInput hippyTextInput, boolean z16) {
        hippyTextInput.setOnSelectListener(z16);
    }

    @HippyControllerProps(name = "returnKeyType")
    public void setReturnKeyType(HippyTextInput hippyTextInput, String str) {
        int i3 = 6;
        if (str != null) {
            char c16 = '\uffff';
            switch (str.hashCode()) {
                case -1273775369:
                    if (str.equals("previous")) {
                        c16 = 0;
                        break;
                    }
                    break;
                case -906336856:
                    if (str.equals("search")) {
                        c16 = 1;
                        break;
                    }
                    break;
                case 3304:
                    if (str.equals(ResourceAttributes.TelemetrySdkLanguageValues.GO)) {
                        c16 = 2;
                        break;
                    }
                    break;
                case 3089282:
                    if (str.equals("done")) {
                        c16 = 3;
                        break;
                    }
                    break;
                case 3377907:
                    if (str.equals("next")) {
                        c16 = 4;
                        break;
                    }
                    break;
                case 3387192:
                    if (str.equals("none")) {
                        c16 = 5;
                        break;
                    }
                    break;
                case 3526536:
                    if (str.equals("send")) {
                        c16 = 6;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    hippyTextInput.setSingleLine(true);
                    i3 = 7;
                    break;
                case 1:
                    hippyTextInput.setSingleLine(true);
                    i3 = 3;
                    break;
                case 2:
                    i3 = 2;
                    break;
                case 3:
                    hippyTextInput.setSingleLine(true);
                    break;
                case 4:
                    hippyTextInput.setSingleLine(true);
                    i3 = 5;
                    break;
                case 5:
                    i3 = 1;
                    break;
                case 6:
                    hippyTextInput.setSingleLine(true);
                    i3 = 4;
                    break;
            }
        }
        hippyTextInput.setImeOptions(33554432 | i3);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "textAlign")
    public void setTextAlign(HippyTextInput hippyTextInput, String str) {
        int i3;
        if (str != null && !"auto".equals(str)) {
            if (!"left".equals(str)) {
                if ("right".equals(str)) {
                    i3 = 5;
                } else if ("center".equals(str)) {
                    i3 = 1;
                } else if (!"justify".equals(str)) {
                    return;
                }
            }
            hippyTextInput.setGravityHorizontal(3);
            return;
        }
        i3 = 0;
        hippyTextInput.setGravityHorizontal(i3);
    }

    @HippyControllerProps(name = NodeProps.TEXT_ALIGN_VERTICAL)
    public void setTextAlignVertical(HippyTextInput hippyTextInput, String str) {
        int i3;
        if (str != null && !"auto".equals(str)) {
            if ("top".equals(str)) {
                i3 = 48;
            } else if ("bottom".equals(str)) {
                i3 = 80;
            } else if ("center".equals(str)) {
                i3 = 16;
            } else {
                return;
            }
        } else {
            i3 = 0;
        }
        hippyTextInput.setGravityVertical(i3);
    }

    @HippyControllerProps(defaultNumber = -7829368.0d, defaultType = "number", name = "placeholderTextColor")
    public void setTextHitColor(HippyTextInput hippyTextInput, int i3) {
        hippyTextInput.setHintTextColor(i3);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "underlineColorAndroid")
    public void setUnderlineColor(HippyTextInput hippyTextInput, Integer num) {
        Drawable background = hippyTextInput.getBackground();
        if (num == null) {
            background.clearColorFilter();
        } else {
            background.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "validator")
    public void setValidator(HippyTextInput hippyTextInput, String str) {
        hippyTextInput.setValidator(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void updateExtra(View view, Object obj) {
        super.updateExtra(view, obj);
        if (obj instanceof TextExtra) {
            TextExtra textExtra = (TextExtra) obj;
            ((HippyTextInput) view).setPadding((int) Math.ceil(textExtra.mLeftPadding), (int) Math.ceil(textExtra.mTopPadding), (int) Math.ceil(textExtra.mRightPadding), (int) Math.ceil(textExtra.mBottomPadding));
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "value")
    public void value(HippyTextInput hippyTextInput, String str) {
        int selectionStart = hippyTextInput.getSelectionStart();
        int selectionEnd = hippyTextInput.getSelectionEnd();
        LogUtils.d(TAG, String.format("setText: selectionStart:%s sEnd:%s", Integer.valueOf(selectionStart), Integer.valueOf(selectionEnd)));
        Editable editableText = hippyTextInput.getEditableText();
        if (editableText == null) {
            return;
        }
        String obj = editableText.toString();
        String substring = obj.substring(0, selectionStart);
        String substring2 = obj.substring(selectionEnd);
        LogUtils.d(TAG, String.format("setText: sub1:[%s]  sub2:[%s]", substring, substring2));
        if (selectionStart == selectionEnd && str.length() > obj.length() && str.startsWith(substring) && str.endsWith(substring2)) {
            String substring3 = str.substring(selectionStart, str.length() - substring2.length());
            LogUtils.d(TAG, String.format("setText: InsertStr: [%s]", substring3));
            editableText.insert(selectionStart, substring3);
        } else if (selectionStart < selectionEnd && str.startsWith(substring) && str.endsWith(substring2)) {
            String substring4 = str.substring(selectionStart, str.length() - substring2.length());
            LogUtils.d(TAG, String.format("setText: ReplaceStr: [%s]", substring4));
            editableText.replace(selectionStart, selectionEnd, substring4);
        } else if (selectionStart == selectionEnd && str.length() < obj.length() && str.endsWith(substring2) && str.startsWith(substring.substring(0, selectionStart - (obj.length() - str.length())))) {
            editableText.delete(selectionEnd - (obj.length() - str.length()), selectionEnd);
        } else {
            editableText.replace(0, editableText.length(), str);
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(final HippyTextInput hippyTextInput, String str, final HippyArray hippyArray) {
        str.hashCode();
        int i3 = 0;
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1699362314:
                if (str.equals(COMMAND_BLUR)) {
                    c16 = 0;
                    break;
                }
                break;
            case 94746189:
                if (str.equals("clear")) {
                    c16 = 1;
                    break;
                }
                break;
            case 287889441:
                if (str.equals(COMMAND_KEYBOARD_DISMISS)) {
                    c16 = 2;
                    break;
                }
                break;
            case 1406685743:
                if (str.equals(COMMAND_setValue)) {
                    c16 = 3;
                    break;
                }
                break;
            case 1690703013:
                if (str.equals(COMMAND_FOCUS)) {
                    c16 = 4;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                ViewParent parent = hippyTextInput.getParent();
                while (parent != null && !(parent instanceof HippyRootView)) {
                    parent = parent.getParent();
                }
                boolean z16 = parent instanceof HippyRootView;
                if (z16) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    i3 = viewGroup.getDescendantFocusability();
                    viewGroup.setDescendantFocusability(393216);
                }
                hippyTextInput.hideInputMethod();
                hippyTextInput.clearFocus();
                if (z16) {
                    ((ViewGroup) parent).setDescendantFocusability(i3);
                    break;
                }
                break;
            case 1:
                hippyTextInput.jsSetValue("", 0);
                break;
            case 2:
                hippyTextInput.hideInputMethod();
                break;
            case 3:
                if (hippyArray != null && hippyArray.getString(0) != null) {
                    int i16 = hippyArray.getInt(1);
                    if (hippyArray.size() < 2) {
                        i16 = hippyArray.getString(0).length();
                    }
                    hippyTextInput.jsSetValue(hippyArray.getString(0), i16);
                    break;
                }
                break;
            case 4:
                hippyTextInput.setFocusableInTouchMode(true);
                Looper.getMainLooper();
                Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.tencent.mtt.hippy.views.textinput.HippyTextInputController.1
                    @Override // android.os.MessageQueue.IdleHandler
                    public boolean queueIdle() {
                        boolean requestFocusFromTouch = hippyTextInput.requestFocusFromTouch();
                        LogUtils.d("InputText", " requestFocusFromTouch result:" + requestFocusFromTouch);
                        if (!requestFocusFromTouch) {
                            LogUtils.d("InputText", "requestFocus result:" + hippyTextInput.requestFocus());
                        }
                        if (hippyArray.getObject(0) == null || hippyArray.getBoolean(0)) {
                            hippyTextInput.showInputMethodManager();
                        }
                        return false;
                    }
                });
                break;
        }
        super.dispatchFunction((HippyTextInputController) hippyTextInput, str, hippyArray);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyTextInput hippyTextInput, String str, HippyArray hippyArray, Promise promise) {
        HippyMap jsIsFocused;
        if (COMMAND_getValue.equals(str)) {
            if (promise == null) {
                return;
            } else {
                jsIsFocused = hippyTextInput.jsGetValue();
            }
        } else if (!COMMAND_IS_FOCUSED.equals(str) || promise == null) {
            return;
        } else {
            jsIsFocused = hippyTextInput.jsIsFocused();
        }
        promise.resolve(jsIsFocused);
    }
}
