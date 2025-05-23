package com.tencent.tuxmetersdk.impl.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.export.config.TuxQuestionType;
import com.tencent.tuxmetersdk.model.Question;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxQuestionUtils {
    static IPatchRedirector $redirector_;

    public TuxQuestionUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean checkIsStarStarStyle(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!"emoji".equals(str) && !"star".equals(str)) {
            return false;
        }
        return true;
    }

    public static boolean checkIsStarTextStyle(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "text".equals(str);
    }

    public static boolean isMatrixCheckbox(Question question) {
        return TuxQuestionType.QUESTION_MATRIX_CHECKBOX.equals(question.getSubType());
    }

    public static boolean isMatrixRadio(Question question) {
        return TuxQuestionType.QUESTION_MATRIX_RADIO.equals(question.getSubType());
    }

    public static boolean isOptionCheckBox(Question question) {
        String subType = question.getSubType();
        if (TuxQuestionType.QUESTION_OPTION_CHECKBOX.equals(subType)) {
            return true;
        }
        if (TextUtils.isEmpty(subType) && "option".equals(question.getType()) && parseOptionRenderMax(question) != 1) {
            return true;
        }
        return false;
    }

    public static boolean isOptionRadio(Question question) {
        String subType = question.getSubType();
        if ("radio".equals(subType)) {
            return true;
        }
        if (TextUtils.isEmpty(subType) && "option".equals(question.getType()) && parseOptionRenderMax(question) == 1) {
            return true;
        }
        return false;
    }

    public static boolean isOptionTime(Question question) {
        String subType = question.getSubType();
        if (TuxQuestionType.QUESTION_TIME_OPTION.equals(subType)) {
            return true;
        }
        if (TextUtils.isEmpty(subType)) {
            return "time".equals(question.getType());
        }
        return false;
    }

    public static boolean isSensitiveInput(Question question) {
        String subType = question.getSubType();
        if ("sensitive_input".equals(subType)) {
            return true;
        }
        if (TextUtils.isEmpty(subType)) {
            return "sensitive_input".equals(question.getType());
        }
        return false;
    }

    public static boolean isStarStar(Question question) {
        String subType = question.getSubType();
        if (TuxQuestionType.QUESTION_STAR_STAR.equals(subType)) {
            return true;
        }
        if (TextUtils.isEmpty(subType) && "star".equals(question.getType())) {
            return checkIsStarStarStyle(parseStarRenderStyle(question));
        }
        return false;
    }

    public static boolean isStarText(Question question) {
        String subType = question.getSubType();
        if (TuxQuestionType.QUESTION_STAR_TEXT.equals(subType)) {
            return true;
        }
        if (TextUtils.isEmpty(subType) && "star".equals(question.getType())) {
            return checkIsStarTextStyle(parseStarRenderStyle(question));
        }
        return false;
    }

    public static boolean isTextArea(Question question) {
        if (question == null) {
            return false;
        }
        String subType = question.getSubType();
        if (TuxQuestionType.QUESTION_TEXT_TEXTAREA.equals(subType)) {
            return true;
        }
        if (!TextUtils.isEmpty(subType)) {
            return false;
        }
        return "text".equals(question.getType());
    }

    public static boolean isTextSingleLine(Question question) {
        if (question == null) {
            return false;
        }
        return "text".equals(question.getSubType());
    }

    public static int parseOptionRenderMax(Question question) {
        if (question == null) {
            return -1;
        }
        String style = question.getStyle();
        if (TextUtils.isEmpty(style)) {
            return -1;
        }
        try {
            return new JSONObject(style).optInt("max", -1);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static String parseStarRenderStyle(Question question) {
        if (question == null) {
            return "";
        }
        String style = question.getStyle();
        if (TextUtils.isEmpty(style)) {
            return "";
        }
        try {
            return new JSONObject(style).optString(TuxQuestionType.STAR_QUESTION_RENDER_STYLE, "");
        } catch (Exception unused) {
            return "";
        }
    }
}
