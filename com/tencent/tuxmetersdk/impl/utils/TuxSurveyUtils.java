package com.tencent.tuxmetersdk.impl.utils;

import android.text.TextUtils;
import android.util.Log;
import com.google.gson.Gson;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tuxmetersdk.export.injector.log.ITuxLog;
import com.tencent.tuxmetersdk.impl.TuxSurveyConfig;
import com.tencent.tuxmetersdk.model.AnswerPage;
import com.tencent.tuxmetersdk.model.Group;
import com.tencent.tuxmetersdk.model.Option;
import com.tencent.tuxmetersdk.model.Page;
import com.tencent.tuxmetersdk.model.Question;
import com.tencent.tuxmetersdk.model.Sheet;
import com.tencent.tuxmetersdk.model.SubTitle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxSurveyUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TuxSurveyUtils";
    private static final Set<String> submitSurveyIdSets;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12208);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            submitSurveyIdSets = new HashSet();
        }
    }

    public TuxSurveyUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static Map<String, Question> createAnswerIdMap(List<Question> list) {
        HashMap hashMap = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (Question question : list) {
                hashMap.put(question.getId(), question);
            }
        }
        return hashMap;
    }

    private static void fillMatrixQuestionDisplays(LinkedHashSet<String> linkedHashSet, Question question, Question question2) {
        String[] displays;
        List<Group> groups = question.getGroups();
        if (groups != null && !groups.isEmpty()) {
            linkedHashSet.add(question.getId());
            HashSet hashSet = new HashSet();
            Iterator<Group> it = groups.iterator();
            while (it.hasNext()) {
                List<Option> options = it.next().getOptions();
                if (options != null) {
                    for (Option option : options) {
                        if (option.getStatus() == 0) {
                            hashSet.add(option.getId());
                        }
                    }
                }
            }
            List<Group> groups2 = question2.getGroups();
            if (groups2 != null && !groups2.isEmpty()) {
                Iterator<Group> it5 = groups2.iterator();
                while (it5.hasNext()) {
                    List<Option> options2 = it5.next().getOptions();
                    if (options2 != null) {
                        for (Option option2 : options2) {
                            if (hashSet.contains(option2.getId()) && (displays = option2.getDisplays()) != null) {
                                linkedHashSet.addAll(Arrays.asList(displays));
                            }
                        }
                    }
                }
            }
        }
    }

    private static void fillOptionQuestionDisplays(LinkedHashSet<String> linkedHashSet, Question question, Question question2) {
        String[] displays;
        List<Option> options = question.getOptions();
        if (options != null && !options.isEmpty()) {
            linkedHashSet.add(question.getId());
            HashSet hashSet = new HashSet();
            for (Option option : question.getOptions()) {
                if (option.getStatus() == 0) {
                    hashSet.add(option.getId());
                }
            }
            List<Option> options2 = question2.getOptions();
            if (options2 != null && !options2.isEmpty()) {
                for (Option option2 : options2) {
                    if (hashSet.contains(option2.getId()) && (displays = option2.getDisplays()) != null) {
                        linkedHashSet.addAll(Arrays.asList(displays));
                    }
                }
            }
        }
    }

    public static Sheet fillSheet(TuxSurveyConfig tuxSurveyConfig, Sheet sheet, ITuxLog iTuxLog) {
        Sheet sheet2;
        Gson gson;
        Question defaultAnswerByQuestion;
        try {
            gson = new Gson();
            sheet2 = sheet;
        } catch (Exception e16) {
            e = e16;
            sheet2 = sheet;
        }
        try {
            Sheet sheet3 = (Sheet) gson.fromJson(gson.toJson(sheet2), Sheet.class);
            List<Page> pages = tuxSurveyConfig.getSurvey().getPages();
            List<AnswerPage> answer = sheet.getAnswer();
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < pages.size(); i3++) {
                Page page = pages.get(i3);
                String id5 = page.getId();
                AnswerPage findAnswerPageByPageID = findAnswerPageByPageID(id5, answer);
                AnswerPage answerPage = new AnswerPage();
                answerPage.setQuestions(new ArrayList());
                answerPage.setId(id5);
                List<Question> questions = page.getQuestions();
                if (findAnswerPageByPageID != null) {
                    List<Question> questions2 = findAnswerPageByPageID.getQuestions();
                    Map<String, Question> createAnswerIdMap = createAnswerIdMap(questions2);
                    for (int i16 = 0; i16 < questions.size(); i16++) {
                        Question question = questions.get(i16);
                        String id6 = question.getId();
                        if (createAnswerIdMap.containsKey(id6)) {
                            Question question2 = createAnswerIdMap.get(id6);
                            if (question2 != null) {
                                answerPage.getQuestions().add(getFillAnswerByQuestion(question, question2));
                            } else {
                                answerPage.getQuestions().add(getDefaultAnswerByQuestion(question, true));
                            }
                        } else {
                            if (findAnswerPath(questions, questions2).contains(id6)) {
                                defaultAnswerByQuestion = getDefaultAnswerByQuestion(question, true);
                            } else {
                                defaultAnswerByQuestion = getDefaultAnswerByQuestion(question, false);
                            }
                            answerPage.getQuestions().add(defaultAnswerByQuestion);
                        }
                    }
                    arrayList.add(answerPage);
                }
            }
            sheet3.setAnswer(arrayList);
            return sheet3;
        } catch (Exception e17) {
            e = e17;
            if (iTuxLog != null) {
                iTuxLog.e(TAG, "\u586b\u5145\u7b54\u6848\u51fa\u73b0\u5f02\u5e38\uff0c\u9519\u8bef\u4fe1\u606f:" + e);
            } else {
                Log.e(TAG, "\u586b\u5145\u7b54\u6848\u51fa\u73b0\u5f02\u5e38\uff0c\u9519\u8bef\u4fe1\u606f:" + e);
            }
            return sheet2;
        }
    }

    private static void fillStarQuestionDisplays(LinkedHashSet<String> linkedHashSet, Question question, Question question2) {
        String[] strArr;
        linkedHashSet.add(question.getId());
        String text = question.getText();
        List<Option> options = question2.getOptions();
        if (options != null && !options.isEmpty()) {
            Iterator<Option> it = options.iterator();
            while (true) {
                if (it.hasNext()) {
                    Option next = it.next();
                    if (next.getText().equals(text)) {
                        strArr = next.getDisplays();
                        break;
                    }
                } else {
                    strArr = null;
                    break;
                }
            }
            if (strArr != null) {
                linkedHashSet.addAll(Arrays.asList(strArr));
            }
        }
    }

    private static AnswerPage findAnswerPageByPageID(String str, List<AnswerPage> list) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return null;
        }
        for (AnswerPage answerPage : list) {
            if (str.equals(answerPage.getId())) {
                return answerPage;
            }
        }
        return null;
    }

    public static LinkedHashSet<String> findAnswerPath(List<Question> list, List<Question> list2) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        if (list != null && list2 != null) {
            int size = list2.size();
            for (int i3 = 0; i3 < size; i3++) {
                Question question = list2.get(i3);
                String id5 = question.getId();
                Question findQuestionById = findQuestionById(list, id5);
                if (findQuestionById != null) {
                    if (!TuxQuestionUtils.isStarStar(findQuestionById) && !TuxQuestionUtils.isStarText(findQuestionById)) {
                        if (!TuxQuestionUtils.isOptionCheckBox(findQuestionById) && !TuxQuestionUtils.isOptionRadio(findQuestionById)) {
                            if (!TuxQuestionUtils.isMatrixCheckbox(findQuestionById) && !TuxQuestionUtils.isMatrixRadio(findQuestionById)) {
                                linkedHashSet.add(id5);
                            } else {
                                fillMatrixQuestionDisplays(linkedHashSet, question, findQuestionById);
                            }
                        } else {
                            fillOptionQuestionDisplays(linkedHashSet, question, findQuestionById);
                        }
                    } else {
                        fillStarQuestionDisplays(linkedHashSet, question, findQuestionById);
                    }
                }
            }
        }
        return linkedHashSet;
    }

    private static Question findQuestionById(List<Question> list, String str) {
        if (list == null || str == null) {
            return null;
        }
        for (Question question : list) {
            if (str.equals(question.getId())) {
                return question;
            }
        }
        return null;
    }

    private static Question getDefaultAnswerByQuestion(Question question, boolean z16) {
        int i3;
        int i16;
        Question question2 = new Question();
        if (question == null) {
            return question2;
        }
        question2.setId(question.getId());
        question2.setType(question.getType());
        question2.setSubType(question.getSubType());
        question2.setDim(question.getDim());
        if (!TuxQuestionUtils.isStarStar(question) && !TuxQuestionUtils.isStarText(question) && !TuxQuestionUtils.isTextSingleLine(question) && !TuxQuestionUtils.isTextArea(question) && !TuxQuestionUtils.isSensitiveInput(question)) {
            if (!TuxQuestionUtils.isOptionCheckBox(question) && !TuxQuestionUtils.isOptionRadio(question)) {
                if (TuxQuestionUtils.isMatrixCheckbox(question) || TuxQuestionUtils.isMatrixRadio(question)) {
                    ArrayList arrayList = new ArrayList();
                    List<Option> options = question.getOptions();
                    List<SubTitle> subTitles = question.getSubTitles();
                    if (subTitles != null && options != null) {
                        for (SubTitle subTitle : subTitles) {
                            Group group = new Group();
                            group.setId(subTitle.getId());
                            group.setText(subTitle.getText());
                            ArrayList arrayList2 = new ArrayList();
                            for (Option option : options) {
                                Option option2 = new Option();
                                option2.setId(option.getId());
                                option2.setText(option.getText());
                                option2.setDim(option.getDim());
                                option2.setOtherText(option.getOtherText());
                                if (z16) {
                                    i16 = 1;
                                } else {
                                    i16 = 2;
                                }
                                option2.setStatus(i16);
                                arrayList2.add(option2);
                            }
                            group.setOptions(arrayList2);
                            arrayList.add(group);
                        }
                    }
                    question2.setGroups(arrayList);
                }
            } else {
                ArrayList arrayList3 = new ArrayList();
                for (Option option3 : question.getOptions()) {
                    Option option4 = new Option();
                    option4.setId(option3.getId());
                    option4.setText(option3.getText());
                    option4.setDim(option3.getDim());
                    option4.setOtherText(option3.getOtherText());
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    option4.setStatus(i3);
                    arrayList3.add(option4);
                }
                question2.setOptions(arrayList3);
            }
        } else {
            question2.setText("");
        }
        return question2;
    }

    private static Question getFillAnswerByQuestion(Question question, Question question2) {
        if (question == null) {
            return question2;
        }
        if (question2 == null) {
            return getDefaultAnswerByQuestion(question, true);
        }
        question2.setType(question.getType());
        question2.setSubType(question.getSubType());
        question2.setDim(question.getDim());
        if (!TuxQuestionUtils.isOptionCheckBox(question) && !TuxQuestionUtils.isOptionRadio(question)) {
            if (TuxQuestionUtils.isMatrixCheckbox(question) || TuxQuestionUtils.isMatrixRadio(question)) {
                List<Group> groups = question2.getGroups();
                HashMap hashMap = new HashMap();
                if (groups != null) {
                    for (Group group : groups) {
                        HashSet hashSet = new HashSet();
                        Iterator<Option> it = group.getOptions().iterator();
                        while (it.hasNext()) {
                            hashSet.add(it.next().getId());
                        }
                        hashMap.put(group.getId(), hashSet);
                    }
                }
                ArrayList arrayList = new ArrayList();
                List<Option> options = question.getOptions();
                List<SubTitle> subTitles = question.getSubTitles();
                if (subTitles != null && options != null) {
                    for (SubTitle subTitle : subTitles) {
                        Group group2 = new Group();
                        group2.setId(subTitle.getId());
                        group2.setText(subTitle.getText());
                        ArrayList arrayList2 = new ArrayList();
                        for (Option option : options) {
                            Option option2 = new Option();
                            option2.setId(option.getId());
                            option2.setText(option.getText());
                            option2.setDim(option.getDim());
                            option2.setOtherText(option.getOtherText());
                            if (hashMap.containsKey(subTitle.getId())) {
                                Set set = (Set) hashMap.get(subTitle.getId());
                                if (set != null && set.contains(option.getId())) {
                                    option2.setStatus(0);
                                } else {
                                    option2.setStatus(1);
                                }
                            } else {
                                option2.setStatus(1);
                            }
                            arrayList2.add(option2);
                        }
                        group2.setOptions(arrayList2);
                        arrayList.add(group2);
                    }
                }
                question2.setGroups(arrayList);
            }
        } else {
            List<Option> options2 = question2.getOptions();
            HashSet hashSet2 = new HashSet();
            if (options2 != null) {
                Iterator<Option> it5 = options2.iterator();
                while (it5.hasNext()) {
                    hashSet2.add(it5.next().getId());
                }
            }
            ArrayList arrayList3 = new ArrayList();
            for (Option option3 : question.getOptions()) {
                Option option4 = new Option();
                option4.setId(option3.getId());
                option4.setText(option3.getText());
                option4.setDim(option3.getDim());
                option4.setOtherText(option3.getOtherText());
                if (hashSet2.contains(option3.getId())) {
                    option4.setStatus(0);
                } else {
                    option4.setStatus(1);
                }
                arrayList3.add(option4);
            }
            question2.setOptions(arrayList3);
        }
        return question2;
    }

    public static boolean inSubmitSurveySet(String str) {
        if (str == null) {
            return false;
        }
        return submitSurveyIdSets.contains(str);
    }

    public static void recordSubmitSurveySet(String str) {
        if (str == null) {
            return;
        }
        submitSurveyIdSets.add(str);
    }
}
