package com.tencent.tdf.keyboard;

import android.util.SparseIntArray;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class KeyboardConfiguration {
    static IPatchRedirector $redirector_;
    private static final SparseIntArray KEYBOARD_ACTION;
    public String actionLabel;
    public boolean autoCorrect;
    public boolean enableSuggestions;
    public int inputAction;
    public InputType inputType;
    public boolean obscureText;
    public int textCapitalization;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class EditingState {
        static IPatchRedirector $redirector_;
        public int composingBase;
        public int composingExtent;
        public int selectionBase;
        public int selectionExtent;
        public String text;

        public EditingState(String str, int i3, int i16, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            this.text = str;
            this.selectionBase = i3;
            this.selectionExtent = i16;
            this.composingBase = i17;
            this.composingExtent = i18;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class InputType {
        static IPatchRedirector $redirector_ = null;
        public static final int DATE_TIME = 4;
        public static final int EMAIL_ADDRESS = 5;
        public static final int MULTI_LINE = 1;
        public static final int NUMBER = 2;
        public static final int PASSWORD = 7;
        public static final int PHONE = 3;
        public static final int TEXT = 0;
        public static final int URL = 6;
        public int index;
        public boolean isDecimal;
        public boolean isSigned;

        public InputType(int i3, boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            this.index = i3;
            this.isSigned = z16;
            this.isDecimal = z17;
        }

        public static InputType fromMap(Map<String, Object> map) {
            boolean z16;
            int intValue = ((Integer) map.get("index")).intValue();
            boolean z17 = false;
            if (map.containsKey("signed")) {
                z16 = ((Boolean) map.get("signed")).booleanValue();
            } else {
                z16 = false;
            }
            if (map.containsKey("decimal")) {
                z17 = ((Boolean) map.get("decimal")).booleanValue();
            }
            return new InputType(intValue, z16, z17);
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface KeyboardAction {
        public static final int CONTINUE_ACTION = 7;
        public static final int COPY = 14;
        public static final int CUT = 15;
        public static final int DELETE = 13;
        public static final int DONE = 11;
        public static final int EMERGENCY_CALL = 10;
        public static final int GO = 2;
        public static final int JOIN = 8;
        public static final int NEW_LINE = 12;
        public static final int NEXT = 5;
        public static final int NONE = 0;
        public static final int PASTE = 16;
        public static final int PREVIOUS = 6;
        public static final int ROUTE = 9;
        public static final int SEARCH = 3;
        public static final int SELECTALL = 17;
        public static final int SEND = 4;
        public static final int UNSPECIFIED = 1;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface TextCapitalization {
        public static final int CHARACTERS = 3;
        public static final int NONE = 0;
        public static final int SENTENCES = 2;
        public static final int WORDS = 1;
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15299);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        SparseIntArray sparseIntArray = new SparseIntArray();
        KEYBOARD_ACTION = sparseIntArray;
        sparseIntArray.put(0, 1);
        sparseIntArray.put(1, 0);
        sparseIntArray.put(11, 6);
        sparseIntArray.put(2, 2);
        sparseIntArray.put(3, 3);
        sparseIntArray.put(4, 4);
        sparseIntArray.put(5, 5);
        sparseIntArray.put(6, 7);
        sparseIntArray.put(12, 1);
    }

    public KeyboardConfiguration(boolean z16, boolean z17, boolean z18, int i3, InputType inputType, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i3), inputType, Integer.valueOf(i16), str);
            return;
        }
        this.obscureText = z16;
        this.autoCorrect = z17;
        this.textCapitalization = i3;
        this.inputAction = i16;
        this.actionLabel = str;
        this.enableSuggestions = z18;
        this.inputType = inputType;
    }

    public static KeyboardConfiguration fromMap(Map<String, Object> map) {
        boolean z16;
        boolean z17;
        boolean z18;
        int i3;
        InputType inputType;
        String str;
        int editAction = getEditAction(((Integer) map.get("inputAction")).intValue());
        if (map.containsKey("obscureText")) {
            z16 = ((Boolean) map.get("obscureText")).booleanValue();
        } else {
            z16 = false;
        }
        if (map.containsKey("autoCorrect")) {
            z17 = ((Boolean) map.get("autoCorrect")).booleanValue();
        } else {
            z17 = true;
        }
        boolean z19 = z17;
        if (map.containsKey("enableSuggestions")) {
            z18 = ((Boolean) map.get("enableSuggestions")).booleanValue();
        } else {
            z18 = false;
        }
        if (map.containsKey("textCapitalization")) {
            i3 = ((Integer) map.get("textCapitalization")).intValue();
        } else {
            i3 = 0;
        }
        if (map.containsKey(RemoteMessageConst.INPUT_TYPE)) {
            inputType = InputType.fromMap((Map) map.get(RemoteMessageConst.INPUT_TYPE));
        } else {
            inputType = null;
        }
        if (map.containsKey("actionLabel")) {
            str = (String) map.get("actionLabel");
        } else {
            str = null;
        }
        return new KeyboardConfiguration(z16, z19, z18, i3, inputType, editAction, str);
    }

    public static int getEditAction(int i3) {
        int i16 = KEYBOARD_ACTION.get(i3, -1);
        if (i16 == -1) {
            return 0;
        }
        return i16;
    }
}
