package com.tencent.tuxmeterqui.config;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.tuxmeterqui.question.ITuxQuestionView;
import com.tencent.tuxmeterqui.question.TuxQuestionViewFactory;
import com.tencent.tuxmeterqui.question.TuxSensitiveInputView;
import com.tencent.tuxmeterqui.question.matrix.TuxMatrixCommonView;
import com.tencent.tuxmeterqui.question.option.TuxOptionCommonView;
import com.tencent.tuxmeterqui.question.text.TuxTextView;
import com.tencent.tuxmetersdk.impl.TuxSurveyConfig;
import com.tencent.tuxmetersdk.model.AnswerPage;
import com.tencent.tuxmetersdk.model.Option;
import com.tencent.tuxmetersdk.model.Page;
import com.tencent.tuxmetersdk.model.Question;
import com.tencent.tuxmetersdk.model.Sheet;
import com.tencent.tuxmetersdk.model.Survey;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxUIUtils {
    static IPatchRedirector $redirector_;

    public TuxUIUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String addQueryParameterToUri(String str, String str2, String str3) {
        if (str != null && str2 != null && str3 != null) {
            StringBuilder sb5 = new StringBuilder(str);
            if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            } else {
                sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            }
            sb5.append(str2);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(str3);
            return sb5.toString();
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Question checkAndGetNoAnswerQuestion(@NonNull LinearLayout linearLayout) {
        ITuxQuestionView iTuxQuestionView;
        Question question;
        int childCount = linearLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = linearLayout.getChildAt(i3);
            if (childAt.getVisibility() == 0 && (childAt instanceof ITuxQuestionView) && (question = (iTuxQuestionView = (ITuxQuestionView) childAt).getQuestion()) != null && !iTuxQuestionView.hasAnsweredInRequired()) {
                return question;
            }
        }
        return null;
    }

    private static void checkImmersiveStatusBar(Window window) {
        try {
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        } catch (Exception unused) {
        }
    }

    public static boolean checkQuestionInShowQuestionOptions(HashMap<String, List<String>> hashMap, String str) {
        if (str == null || hashMap == null) {
            return false;
        }
        Iterator<String> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            List<String> list = hashMap.get(it.next());
            if (list != null && list.contains(str)) {
                return true;
            }
        }
        return false;
    }

    public static void clearCoverForStatus(Window window, boolean z16) {
        if (z16) {
            String str = Build.MANUFACTURER + DeviceInfoMonitor.getModel();
            if (str != null && (str.equals("MeizuPRO 7-S") || str.equalsIgnoreCase("MeizuM711C"))) {
                setTranslucentStatus(window);
            } else {
                checkImmersiveStatusBar(window);
            }
        }
    }

    public static void clearQuestionViewFocus(LinearLayout linearLayout) {
        if (linearLayout == null) {
            return;
        }
        int childCount = linearLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = linearLayout.getChildAt(i3);
            if (childAt.getVisibility() == 0 && ((childAt instanceof TuxTextView) || (childAt instanceof TuxSensitiveInputView))) {
                childAt.clearFocus();
            }
        }
    }

    public static Question createSimpleQuestion(Question question) {
        Question question2 = new Question();
        if (question != null) {
            question2.setId(question.getId());
            question2.setType(question.getType());
            question2.setSubType(question.getSubType());
        }
        return question2;
    }

    public static int dpToPx(Context context, int i3) {
        return Math.round(i3 * context.getResources().getDisplayMetrics().density);
    }

    public static Set<String> findDisplayQuestionIDs(List<Question> list) {
        HashSet hashSet = new HashSet();
        if (list == null) {
            return hashSet;
        }
        Iterator<Question> it = list.iterator();
        while (it.hasNext()) {
            List<Option> options = it.next().getOptions();
            if (options != null) {
                Iterator<Option> it5 = options.iterator();
                while (it5.hasNext()) {
                    String[] displays = it5.next().getDisplays();
                    if (displays != null) {
                        hashSet.addAll(Arrays.asList(displays));
                    }
                }
            }
        }
        return hashSet;
    }

    public static int findMatrixReferNumber(LinearLayout linearLayout, Question question) {
        if (linearLayout != null && question != null) {
            int childCount = linearLayout.getChildCount();
            String refer = question.getRefer();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = linearLayout.getChildAt(i3);
                if (childAt instanceof TuxOptionCommonView) {
                    TuxOptionCommonView tuxOptionCommonView = (TuxOptionCommonView) childAt;
                    if (refer.equals(((Question) childAt.getTag()).getId())) {
                        return tuxOptionCommonView.getQuestionNumber();
                    }
                }
            }
        }
        return -1;
    }

    public static String formatQuestionNumber(int i3) {
        if (i3 >= 0 && i3 < 10) {
            return String.format(Locale.getDefault(), "%02d", Integer.valueOf(i3));
        }
        return String.valueOf(i3);
    }

    public static Sheet generateAnswer(@NonNull LinearLayout linearLayout, @NonNull TuxSurveyConfig tuxSurveyConfig) {
        Question createQuestionAnswer;
        Sheet sheet = new Sheet();
        sheet.setOpenid(tuxSurveyConfig.getOpenId());
        Survey survey = tuxSurveyConfig.getSurvey();
        if (survey == null) {
            return sheet;
        }
        List<Page> pages = survey.getPages();
        if (pages != null && !pages.isEmpty()) {
            Page page = pages.get(0);
            if (page == null) {
                return sheet;
            }
            List<Question> questions = page.getQuestions();
            if (questions != null && !questions.isEmpty()) {
                AnswerPage answerPage = new AnswerPage();
                answerPage.setId(page.getId());
                ArrayList arrayList = new ArrayList();
                int childCount = linearLayout.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = linearLayout.getChildAt(i3);
                    if (childAt.getVisibility() == 0 && (createQuestionAnswer = TuxQuestionViewFactory.createQuestionAnswer(childAt)) != null) {
                        arrayList.add(createQuestionAnswer);
                    }
                }
                answerPage.setQuestions(arrayList);
                sheet.setAnswer(Collections.singletonList(answerPage));
            }
        }
        return sheet;
    }

    public static Set<String> getPreShowQuestionAnswerSet(String str, LinearLayout linearLayout, HashMap<String, List<String>> hashMap) {
        HashSet hashSet = new HashSet();
        if (linearLayout != null && str != null) {
            int childCount = linearLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = linearLayout.getChildAt(i3);
                Object tag = childAt.getTag();
                if (childAt.getVisibility() == 0 && (tag instanceof Question)) {
                    String id5 = ((Question) tag).getId();
                    if (id5.equals(str)) {
                        break;
                    }
                    hashSet.addAll(hashMap.get(id5));
                }
            }
        }
        return hashSet;
    }

    public static int getScreenWidthPx(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static boolean isVivoAndLOLLIPOP() {
        if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO.equalsIgnoreCase(Build.MANUFACTURER)) {
            return true;
        }
        return false;
    }

    public static int pxToDp(Context context, int i3) {
        return Math.round(i3 / context.getResources().getDisplayMetrics().density);
    }

    public static void setTranslucentStatus(Window window) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Field declaredField = Class.forName("com.android.internal.policy.DecorView").getDeclaredField("mSemiTransparentStatusBarColor");
                declaredField.setAccessible(true);
                declaredField.setInt(window.getDecorView(), 0);
            } catch (Exception unused) {
            }
        }
    }

    public static void updateLinkMatrix(LinearLayout linearLayout, TuxOptionCommonView tuxOptionCommonView, List<Option> list) {
        if (linearLayout != null && tuxOptionCommonView != null && list != null && !list.isEmpty()) {
            Question question = (Question) tuxOptionCommonView.getTag();
            int questionNumber = tuxOptionCommonView.getQuestionNumber();
            int childCount = linearLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = linearLayout.getChildAt(i3);
                if (childAt instanceof TuxMatrixCommonView) {
                    String refer = ((Question) childAt.getTag()).getRefer();
                    if (!TextUtils.isEmpty(refer) && refer.equals(question.getId())) {
                        ((TuxMatrixCommonView) childAt).updateLinkReferInfo(questionNumber, list);
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void updateQuestionListNumber(LinearLayout linearLayout) {
        if (linearLayout == null) {
            return;
        }
        int childCount = linearLayout.getChildCount();
        int i3 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = linearLayout.getChildAt(i16);
            if (childAt.getVisibility() == 0 && (childAt instanceof ITuxQuestionView)) {
                i3++;
            }
        }
        int i17 = 1;
        if (i3 > 1) {
            for (int i18 = 0; i18 < childCount; i18++) {
                View childAt2 = linearLayout.getChildAt(i18);
                if (childAt2.getVisibility() == 0 && (childAt2 instanceof ITuxQuestionView)) {
                    ((ITuxQuestionView) childAt2).updateQuestionNumber(i17);
                    i17++;
                }
            }
        }
    }
}
