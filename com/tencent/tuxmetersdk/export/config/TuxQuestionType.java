package com.tencent.tuxmetersdk.export.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxQuestionType {
    static IPatchRedirector $redirector_ = null;
    public static final String MATRIX = "matrix";
    public static final String MATRIX_DISPLAY_STYLE = "display_style";
    public static final String MATRIX_DISPLAY_STYLE_MATRIX = "matrix";
    public static final String MATRIX_DISPLAY_STYLE_OPTION = "option";
    public static final String OPTION = "option";
    public static final String OPTION_QUESTION_LINE_ITEMS = "line_items";
    public static final String OPTION_QUESTION_MAX = "max";
    public static final String QUESTION_MATRIX_CHECKBOX = "matrix_checkbox";
    public static final String QUESTION_MATRIX_RADIO = "matrix_radio";
    public static final String QUESTION_OPTION_CHECKBOX = "checkbox";
    public static final String QUESTION_OPTION_RADIO = "radio";
    public static final String QUESTION_SENSITIVE_INPUT = "sensitive_input";
    public static final String QUESTION_STAR_STAR = "star_star";
    public static final String QUESTION_STAR_TEXT = "star_text";
    public static final String QUESTION_TEXT_TEXT = "text";
    public static final String QUESTION_TEXT_TEXTAREA = "textarea";
    public static final String QUESTION_TIME_OPTION = "time_option";
    public static final String SENSITIVE_INPUT = "sensitive_input";
    public static final String STAR = "star";
    public static final String STAR_QUESTION_RENDER_STYLE = "star_question_render_style";
    public static final String STAR_STYLE_EMOJI = "emoji";
    public static final String STAR_STYLE_STAR = "star";
    public static final String STAR_STYLE_TEXT = "text";
    public static final String TEXT = "text";
    public static final String TIME = "time";

    public TuxQuestionType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
