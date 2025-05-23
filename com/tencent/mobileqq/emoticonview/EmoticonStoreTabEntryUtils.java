package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmoticonStoreTabEntryUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY_HAS_SHOWED_EMO_STORY_TITLE_GUIDE = "key_has_showed_emo_story_title_guide";
    private static final String KEY_SHOW_EMOTICON_STORY_TAB_GUIDE = "key_show_emoticon_story_tab_guide";
    public static String URL_NEED_REPLEACE_BODY;
    public static String URL_REPLEACE_BODY;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45439);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            URL_NEED_REPLEACE_BODY = "_wv=553648128&_cwv=8&_wwv=129";
            URL_REPLEACE_BODY = "_wwv=128";
        }
    }

    public EmoticonStoreTabEntryUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean checkIsNeedShowGuide() {
        return ((Boolean) com.tencent.mobileqq.core.util.b.a(KEY_SHOW_EMOTICON_STORY_TAB_GUIDE, Boolean.TRUE)).booleanValue();
    }

    public static boolean checkTabListCanShowGuide(List<EmotionPanelInfo> list) {
        if (list == null || list.size() == 0 || list.get(0).type != 13) {
            return false;
        }
        return true;
    }

    public static boolean checkURLIsEmoStore(String str, String str2) {
        if (!StringUtil.isEmpty(str) && !StringUtil.isEmpty(str2)) {
            boolean startsWith = str.startsWith(str2);
            if (!startsWith && QLog.isColorLevel()) {
                QLog.d("emoStore", 2, "checkURLIsEmoStore, url not equles compareURL = " + str + "  \n orginEmotionStoreURL = " + str2);
            }
            return startsWith;
        }
        return false;
    }

    public static boolean disableRecommendTab() {
        return true;
    }

    public static void doOnStoryGuideShowed() {
        com.tencent.mobileqq.core.util.b.d(KEY_SHOW_EMOTICON_STORY_TAB_GUIDE, Boolean.FALSE);
    }

    public static boolean isHasShowedTitleGuide() {
        return ((Boolean) com.tencent.mobileqq.core.util.b.a(KEY_HAS_SHOWED_EMO_STORY_TITLE_GUIDE, Boolean.FALSE)).booleanValue();
    }

    public static String processEmoStoreHomeUrl(String str) {
        if (StringUtil.isEmpty(str)) {
            return "";
        }
        return str.replace(URL_NEED_REPLEACE_BODY, URL_REPLEACE_BODY);
    }

    public static void removeDisSelectedDataByType(List<EmotionPanelInfo> list, int i3) {
        if (list != null && !list.isEmpty()) {
            int i16 = 0;
            while (true) {
                if (i16 < list.size()) {
                    if (list.get(i16).type == i3) {
                        break;
                    } else {
                        i16++;
                    }
                } else {
                    i16 = -1;
                    break;
                }
            }
            if (i16 != -1) {
                list.remove(i16);
            }
        }
    }

    public static boolean removeEmotionPanelInfoByType(List<EmotionPanelInfo> list, int i3) {
        if (list != null && list.size() != 0) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size).type == i3) {
                    list.remove(size);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean removeSettingAndRecommendEntry(List<EmotionPanelInfo> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        EmotionPanelInfo emotionPanelInfo = null;
        EmotionPanelInfo emotionPanelInfo2 = null;
        for (int i3 = 0; i3 < list.size(); i3++) {
            EmotionPanelInfo emotionPanelInfo3 = list.get(i3);
            int i16 = emotionPanelInfo3.type;
            if (i16 == 14) {
                emotionPanelInfo = emotionPanelInfo3;
            } else if (i16 == 8) {
                emotionPanelInfo2 = emotionPanelInfo3;
            }
        }
        if (emotionPanelInfo != null) {
            list.remove(emotionPanelInfo);
        }
        if (disableRecommendTab() && emotionPanelInfo2 != null) {
            list.remove(emotionPanelInfo2);
            return true;
        }
        return true;
    }

    public static void reverseTabOrderOfRedHeartAndSuperEmoji(List<EmotionPanelInfo> list) {
        if (list != null && list.size() != 0) {
            int i3 = -1;
            int i16 = -1;
            for (int i17 = 0; i17 < list.size(); i17++) {
                int i18 = list.get(i17).type;
                if (i18 == 19) {
                    i3 = i17;
                } else if (i18 == 4) {
                    i16 = i17;
                }
                if (i3 >= 0 && i16 >= 0) {
                    break;
                }
            }
            if (i16 >= 0 && i3 >= 0) {
                Collections.swap(list, i16, i3);
            }
        }
    }

    public static void savaHasTitleGuideShowed() {
        com.tencent.mobileqq.core.util.b.d(KEY_HAS_SHOWED_EMO_STORY_TITLE_GUIDE, Boolean.TRUE);
    }
}
