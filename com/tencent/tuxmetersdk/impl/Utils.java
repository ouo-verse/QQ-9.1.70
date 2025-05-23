package com.tencent.tuxmetersdk.impl;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tuxmetersdk.BuildConfig;
import com.tencent.tuxmetersdk.export.config.TuxConstants;
import com.tencent.tuxmetersdk.export.listener.ITuxTriggerFullListener;
import com.tencent.tuxmetersdk.export.listener.ITuxTriggerListener;
import com.tencent.tuxmetersdk.gsonadapter.StringDefaultAdapter;
import com.tencent.tuxmetersdk.impl.event.EventType;
import com.tencent.tuxmetersdk.impl.utils.TuxQuestionUtils;
import com.tencent.tuxmetersdk.jwt.JWT;
import com.tencent.tuxmetersdk.jwt.algorithms.Algorithm;
import com.tencent.tuxmetersdk.model.BeaconInfo;
import com.tencent.tuxmetersdk.model.Option;
import com.tencent.tuxmetersdk.model.Page;
import com.tencent.tuxmetersdk.model.Question;
import com.tencent.tuxmetersdk.model.Resource;
import com.tencent.tuxmetersdk.model.SignInfo;
import com.tencent.tuxmetersdk.model.SubTitle;
import com.tencent.tuxmetersdk.model.Survey;
import com.tencent.tuxmetersdk.model.SurveyConfig;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Utils {
    static IPatchRedirector $redirector_;
    public static String TAG;
    public static String TIME_FORMAT_TEMPLATE;
    public static Random random;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11141);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        TAG = "TuxUtils";
        TIME_FORMAT_TEMPLATE = "yyyy-MM-dd HH:mm:ss";
        random = new Random(System.currentTimeMillis());
    }

    public Utils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Date convertTime(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_FORMAT_TEMPLATE, Locale.CHINA);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(str2));
        try {
            Date parse = simpleDateFormat.parse(str);
            if (parse == null) {
                return null;
            }
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(TIME_FORMAT_TEMPLATE, Locale.CHINA);
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone(str3));
            return simpleDateFormat2.parse(simpleDateFormat2.format(parse));
        } catch (Exception unused) {
            return null;
        }
    }

    public static Gson createGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(String.class, new StringDefaultAdapter());
        gsonBuilder.serializeNulls();
        return gsonBuilder.create();
    }

    public static double diffDays(Date date, Date date2) throws Exception {
        if (date != null && date2 != null) {
            return ((date.getTime() - date2.getTime()) * 1.0d) / 8.64E7d;
        }
        throw new Exception(String.format("diffDays\u5165\u53c2\u4e0d\u6b63\u786e, current: %s, before: %s", date, date2));
    }

    public static double diffHours(Date date, Date date2) throws Exception {
        if (date != null && date2 != null) {
            return ((date.getTime() - date2.getTime()) * 1.0d) / 3600000.0d;
        }
        throw new Exception(String.format("diffHours\u5165\u53c2\u4e0d\u6b63\u786e, current: %s, before: %s", date, date2));
    }

    public static void doTriggerIfFailure(ITuxTriggerListener iTuxTriggerListener, String str) {
        if (iTuxTriggerListener instanceof ITuxTriggerFullListener) {
            ((ITuxTriggerFullListener) iTuxTriggerListener).onFailure(str);
        }
    }

    private static void fisherYatesShuffle(List<Option> list) {
        for (int size = list.size() - 1; size > 0; size--) {
            int nextInt = random.nextInt(size + 1);
            Option option = list.get(size);
            list.set(size, list.get(nextInt));
            list.set(nextInt, option);
        }
    }

    public static String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_FORMAT_TEMPLATE, Locale.CHINA);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TuxConstants.BEIJING_TIMEZONE));
        return simpleDateFormat.format(date);
    }

    public static Map<String, String> generateBasicEventParams(SurveyConfig surveyConfig, TuxMeterSDKSetting tuxMeterSDKSetting) {
        TuxSurveyConfig tuxSurveyConfig = new TuxSurveyConfig();
        if (surveyConfig != null) {
            tuxSurveyConfig.setOpenId(surveyConfig.getOpenId());
            tuxSurveyConfig.setPosition(surveyConfig.getPosition());
            if (surveyConfig.getSurvey() != null) {
                Survey survey = new Survey();
                survey.setId(surveyConfig.getSurvey().getId());
                tuxSurveyConfig.setSurvey(survey);
            }
            if (surveyConfig.getResource() != null) {
                Resource resource = new Resource();
                resource.setSceneId(surveyConfig.getResource().getSceneId());
                resource.setComponentType(surveyConfig.getResource().getComponentType());
                tuxSurveyConfig.setResource(resource);
            }
        }
        return generateBasicEventParams(tuxSurveyConfig, tuxMeterSDKSetting);
    }

    public static int generateRandomNumber(int i3, int i16) {
        return random.nextInt((i16 - i3) + 1) + i3;
    }

    public static String generateToken(SignInfo signInfo, Date date) {
        if (signInfo == null) {
            return "";
        }
        try {
            return JWT.create().withIssuer(signInfo.getIssuer()).withExpiresAt(new Date(date.getTime() + signInfo.getMaxAge())).withIssuedAt(date).sign(Algorithm.hmac512(signInfo.getSecret()));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getTextWithCheckEmpty(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return str;
    }

    public static boolean isLessThan(double d16, double d17) {
        if (Math.abs(d16 - d17) >= 1.0E-6d && d16 >= d17) {
            return false;
        }
        return true;
    }

    public static boolean isStrEqual(String str, String str2) {
        if (str != null && str2 != null) {
            return str.equals(str2);
        }
        if (str == null && str2 == null) {
            return true;
        }
        return false;
    }

    public static boolean isValidBeaconInfo(BeaconInfo beaconInfo) {
        if (beaconInfo != null && beaconInfo.getAppkey() != null) {
            return !beaconInfo.getAppkey().trim().equals("");
        }
        return false;
    }

    public static boolean isValidSignInfo(SignInfo signInfo) {
        if (signInfo != null && signInfo.getIssuer() != null && signInfo.getSecret() != null) {
            return true;
        }
        return false;
    }

    public static boolean isValidSurveyConfig(SurveyConfig surveyConfig) {
        if (surveyConfig != null) {
            return true;
        }
        return false;
    }

    public static boolean isValidTuxSurveyConfig(TuxSurveyConfig tuxSurveyConfig) {
        if (tuxSurveyConfig != null) {
            return true;
        }
        return false;
    }

    public static String join(String str, List<String> list) {
        StringBuilder sb5 = new StringBuilder();
        if (str != null && list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (i3 == list.size() - 1) {
                    sb5.append(list.get(i3));
                } else {
                    sb5.append(list.get(i3));
                    sb5.append(str);
                }
            }
            return sb5.toString();
        }
        return sb5.toString();
    }

    public static double modifyPrecision(double d16, int i3) {
        return Math.round(d16 * r0) / Math.pow(10.0d, i3);
    }

    private static List<Option> randomOptions(List<Option> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Option option : list) {
                if (option.isFixed()) {
                    arrayList.add(option);
                } else {
                    arrayList2.add(option);
                }
            }
            fisherYatesShuffle(arrayList2);
            ArrayList arrayList3 = new ArrayList();
            Iterator<Option> it = list.iterator();
            int i3 = 0;
            int i16 = 0;
            while (it.hasNext()) {
                if (it.next().isFixed()) {
                    arrayList3.add((Option) arrayList.get(i16));
                    i16++;
                } else {
                    arrayList3.add((Option) arrayList2.get(i3));
                    i3++;
                }
            }
            return arrayList3;
        }
        return list;
    }

    private static List<SubTitle> randomSubTitles(List<SubTitle> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(list);
            Collections.shuffle(arrayList);
            return arrayList;
        }
        return list;
    }

    public static void randomTuxSurveyConfigServery(TuxSurveyConfig tuxSurveyConfig) {
        List<Page> pages;
        List<Question> questions;
        if (tuxSurveyConfig == null) {
            return;
        }
        try {
            Survey survey = tuxSurveyConfig.getSurvey();
            if (survey != null && (pages = survey.getPages()) != null && !pages.isEmpty()) {
                int size = pages.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Page page = pages.get(i3);
                    if (page != null && (questions = page.getQuestions()) != null && !questions.isEmpty()) {
                        int size2 = questions.size();
                        for (int i16 = 0; i16 < size2; i16++) {
                            Question question = questions.get(i16);
                            if (question != null && question.isRandom()) {
                                if (!TuxQuestionUtils.isOptionCheckBox(question) && !TuxQuestionUtils.isOptionRadio(question)) {
                                    if (TuxQuestionUtils.isMatrixRadio(question) || TuxQuestionUtils.isMatrixCheckbox(question)) {
                                        question.setSubTitles(randomSubTitles(question.getSubTitles()));
                                    }
                                }
                                question.setOptions(randomOptions(question.getOptions()));
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void report(TuxMeterSDKSetting tuxMeterSDKSetting, String str, String str2, Map<String, String> map) {
        if (tuxMeterSDKSetting != null && tuxMeterSDKSetting.getBeaconReporter() != null) {
            tuxMeterSDKSetting.getBeaconReporter().report(str, EventType.REALTIME, str2, map);
        }
    }

    public static double generateRandomNumber(double d16, double d17, int i3) {
        double nextDouble = (random.nextDouble() * (d17 - d16)) + d16;
        return Double.parseDouble(String.format(Locale.CHINA, "%." + i3 + "f", Double.valueOf(nextDouble)));
    }

    public static Map<String, String> generateBasicEventParams(TuxSurveyConfig tuxSurveyConfig, TuxMeterSDKSetting tuxMeterSDKSetting) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        str = "";
        if (tuxSurveyConfig != null) {
            String openId = tuxSurveyConfig.getOpenId() != null ? tuxSurveyConfig.getOpenId() : "";
            String position = tuxSurveyConfig.getPosition() != null ? tuxSurveyConfig.getPosition() : "";
            String id5 = (tuxSurveyConfig.getSurvey() == null || tuxSurveyConfig.getSurvey().getId() == null) ? "" : tuxSurveyConfig.getSurvey().getId();
            if (tuxSurveyConfig.getResource() != null) {
                str = tuxSurveyConfig.getResource().getSceneId() != null ? tuxSurveyConfig.getResource().getSceneId() : "";
                str6 = String.valueOf(tuxSurveyConfig.getResource().getComponentType());
            } else {
                str6 = "";
            }
            str2 = String.valueOf(tuxSurveyConfig.isWhite());
            String str7 = openId;
            str3 = str;
            str = id5;
            str5 = position;
            str4 = str7;
        } else {
            str2 = "false";
            str3 = "";
            str4 = str3;
            str5 = str4;
            str6 = str5;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("survey_id", str);
        hashMap.put("scene_id", str3);
        hashMap.put("tux_uuid", str4);
        hashMap.put("component_type", str6);
        hashMap.put("app_id", tuxMeterSDKSetting.getAppId());
        hashMap.put("source", "android");
        hashMap.put("tux_app_version", tuxMeterSDKSetting.getAppVersion());
        hashMap.put("tux_sdk_version", BuildConfig.VERSION);
        hashMap.put(MosaicConstants$JsProperty.PROP_ENV, tuxMeterSDKSetting.getEnvironment().toString());
        hashMap.put("tux_uid", tuxMeterSDKSetting.getUid());
        hashMap.put("position", str5);
        hashMap.put("tux_position", str5);
        hashMap.put("is_white", str2);
        hashMap.put("tux_zone_id", tuxMeterSDKSetting.getZoneId());
        return hashMap;
    }

    public static Map<String, String> generateBasicEventParams(TuxMeterSDKSetting tuxMeterSDKSetting) {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", tuxMeterSDKSetting.getAppId());
        hashMap.put("source", "android");
        hashMap.put("tux_app_version", tuxMeterSDKSetting.getAppVersion());
        hashMap.put("tux_sdk_version", BuildConfig.VERSION);
        hashMap.put(MosaicConstants$JsProperty.PROP_ENV, tuxMeterSDKSetting.getEnvironment().toString());
        hashMap.put("tux_uid", tuxMeterSDKSetting.getUid());
        hashMap.put("tux_zone_id", tuxMeterSDKSetting.getZoneId());
        return hashMap;
    }
}
