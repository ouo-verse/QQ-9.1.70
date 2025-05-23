package com.tencent.tuxmeterqui.config;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.ColorInt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback;
import com.tencent.tuxmetersdk.impl.TuxSurveyConfig;
import com.tencent.tuxmetersdk.model.Page;
import com.tencent.tuxmetersdk.model.Question;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Utils {
    static IPatchRedirector $redirector_;

    public Utils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean canReportSurveyEvent(ITuxSurveyEventCallback iTuxSurveyEventCallback) {
        if (iTuxSurveyEventCallback != null) {
            return true;
        }
        return false;
    }

    public static boolean checkAndFormatSurveyConfig(TuxSurveyConfig tuxSurveyConfig) {
        if (tuxSurveyConfig == null || tuxSurveyConfig.getSurvey() == null || tuxSurveyConfig.getSurvey().getPages() == null) {
            return false;
        }
        List<Page> pages = tuxSurveyConfig.getSurvey().getPages();
        ArrayList arrayList = new ArrayList();
        for (Page page : pages) {
            if (page.getQuestions() != null && !page.getQuestions().isEmpty()) {
                arrayList.add(page);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        tuxSurveyConfig.getSurvey().setPages(arrayList);
        return true;
    }

    public static float dp2px(DisplayMetrics displayMetrics, float f16) {
        return TypedValue.applyDimension(1, f16, displayMetrics);
    }

    public static GradientDrawable generateGradientDrawable(@ColorInt int i3, float[] fArr) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        try {
            gradientDrawable.setColor(i3);
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadii(fArr);
        } catch (Exception unused) {
        }
        return gradientDrawable;
    }

    public static int getColor(int i3, float f16) {
        return (i3 & 16777215) | (Math.round(Color.alpha(i3) * f16) << 24);
    }

    public static float[] getConerRadii(DisplayMetrics displayMetrics, float f16, float f17, float f18, float f19) {
        return new float[]{dp2px(displayMetrics, f16), dp2px(displayMetrics, f16), dp2px(displayMetrics, f17), dp2px(displayMetrics, f17), dp2px(displayMetrics, f18), dp2px(displayMetrics, f18), dp2px(displayMetrics, f19), dp2px(displayMetrics, f19)};
    }

    public static boolean isValidNativeSurveyConfig(TuxSurveyConfig tuxSurveyConfig) {
        List<Page> pages;
        List<Question> questions;
        if (tuxSurveyConfig == null || tuxSurveyConfig.getSurvey() == null || (pages = tuxSurveyConfig.getSurvey().getPages()) == null || pages.isEmpty() || (questions = pages.get(0).getQuestions()) == null || questions.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean isValidWebViewSurveyConfig(TuxSurveyConfig tuxSurveyConfig) {
        if (tuxSurveyConfig == null || tuxSurveyConfig.getResource() == null || tuxSurveyConfig.getResource().getUrlOfParam() == null) {
            return false;
        }
        return true;
    }
}
