package cooperation.qzone.widget;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QzoneEmotionUtils {
    public static final String EMO_PREFIX = "[em]";
    public static final String EMO_TAIL = "[/em]";
    public static final String SIGN_ICON_URL_END = ".gif";
    public static final String SIGN_ICON_URL_PREFIX = "https://qzonestyle.gtimg.cn/qzone/em/";
    public static final String TAG = "QzoneEmotionUtils";
    public static final Pattern SMILEY_PATTERN = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]", 2);
    private static final String regSpecialEmo = "\\[/\u7f8e\u5973\\]|\\[/\u94b1\\]";
    public static final Pattern patternSpecialEmo = Pattern.compile(regSpecialEmo);
    private static boolean bInit = false;
    private static Pattern pattern = null;
    private static Pattern friendRefPattern = Pattern.compile("@\\{uin:.*?,\\s*nick:.*?\\}");
    private static Pattern qzoneEmoPattern = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]");
    private static final String[] lowPriorityFace = {"/\u5403"};

    public static String EmoCode2Text(String str) {
        Matcher matcher = SMILEY_PATTERN.matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            String description = getDescription(group);
            if (!TextUtils.isEmpty(description)) {
                str = str.replace(group, description);
            }
        }
        return str;
    }

    public static String emCodeToQQcode(String str) {
        int localIdFromEMCode;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            localIdFromEMCode = QQSysFaceUtil.getLocalIdFromEMCode(str);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        if (localIdFromEMCode != -1) {
            return QQSysFaceUtil.getFaceString(localIdFromEMCode);
        }
        int localIdFromEMCode2 = QQEmojiUtil.getLocalIdFromEMCode(str);
        if (localIdFromEMCode2 != -1) {
            return QQSysAndEmojiResMgr.getInstance().getResImpl(2).getQSid(localIdFromEMCode2);
        }
        return null;
    }

    public static String emCodesToQQcodes(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Matcher matcher = qzoneEmoPattern.matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            String emCodeToQQcode = emCodeToQQcode(group);
            if (emCodeToQQcode != null) {
                str = str.replace(group, emCodeToQQcode);
            }
        }
        return str;
    }

    public static String emoCode2Text(String str) {
        try {
            Matcher matcher = SMILEY_PATTERN.matcher(str);
            while (matcher.find()) {
                String group = matcher.group();
                String prueFaceDescription = QQSysFaceUtil.getPrueFaceDescription(getDescription(group));
                if (!TextUtils.isEmpty(prueFaceDescription)) {
                    str = str.replace(group, prueFaceDescription);
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        return str;
    }

    public static String emoToWechatEmo(String str) {
        Matcher matcher = qzoneEmoPattern.matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            String description = getDescription(group);
            if (!TextUtils.isEmpty(description)) {
                str = str.replace(group, "[" + description.substring(1) + "]");
            }
        }
        return str;
    }

    public static String getDescription(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (QQSysFaceUtil.getLocalIdFromEMCode(str) != -1) {
            return QQSysFaceUtil.getFaceDescription(QQSysFaceUtil.getLocalIdFromEMCode(str));
        }
        if (QQEmojiUtil.getLocalIdFromEMCode(str) == -1) {
            return null;
        }
        return QQEmojiUtil.getEmojiDescription(QQEmojiUtil.getLocalIdFromEMCode(str));
    }

    public static Drawable getDrawable(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (QQSysFaceUtil.getLocalIdFromEMCode(str) != -1) {
            return QQSysFaceUtil.getFaceDrawable(QQSysFaceUtil.getLocalIdFromEMCode(str));
        }
        if (QQEmojiUtil.getLocalIdFromEMCode(str) == -1) {
            return null;
        }
        return QQEmojiUtil.getEmojiDrawable(QQEmojiUtil.getLocalIdFromEMCode(str));
    }

    public static int getEmoCount(String str) {
        int i3 = 0;
        while (SMILEY_PATTERN.matcher(str).find()) {
            i3++;
        }
        return i3;
    }

    public static String getEmoUrlFromConfig(String str) throws Exception {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_GET_EMOTIONURL, QzoneConfig.DefaultValue.GET_EMOTIONURL).replace("$id", str);
    }

    private static synchronized void init() {
        synchronized (QzoneEmotionUtils.class) {
            ArrayList<Integer> fullFaceCodeList = QQSysFaceUtil.getFullFaceCodeList();
            if (fullFaceCodeList != null && fullFaceCodeList.size() > 0) {
                StringBuilder sb5 = new StringBuilder();
                List asList = Arrays.asList(lowPriorityFace);
                StringBuilder sb6 = new StringBuilder("(" + QQSysFaceUtil.getFaceDescription(fullFaceCodeList.get(0).intValue()) + ")");
                for (int i3 = 1; i3 < fullFaceCodeList.size(); i3++) {
                    if (fullFaceCodeList.get(i3) != null) {
                        String faceDescription = QQSysFaceUtil.getFaceDescription(fullFaceCodeList.get(i3).intValue());
                        String str = "|(" + faceDescription + ")";
                        if (asList.contains(faceDescription)) {
                            sb5.append(str);
                        } else {
                            sb6.append(str);
                        }
                    }
                }
                sb6.append((CharSequence) sb5);
                pattern = Pattern.compile(sb6.toString());
            }
            bInit = true;
        }
    }

    public static String replaceEmoCode(String str, String str2) {
        Matcher matcher = SMILEY_PATTERN.matcher(str);
        while (matcher.find()) {
            str = str.replace(matcher.group(), str2);
        }
        return str;
    }

    private static String replaceSlashCode(String str) {
        String replace;
        String qqStr = HardCodeUtil.qqStr(R.string.f2192465w);
        if (str.contains("/chigua")) {
            str = str.replace("/chigua", qqStr);
        }
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            if (group != null) {
                if (group.contains(qqStr)) {
                    group = group.replace(qqStr, "/chigua");
                    str = str.replace(qqStr, "/chigua");
                }
                String eMCode = QQSysFaceUtil.getEMCode(group);
                if (eMCode != null && (replace = str.replace(group, eMCode)) != null) {
                    str = replace;
                }
            }
        }
        return str;
    }

    public static String splash2Emo(String str) {
        if (!bInit) {
            init();
        }
        if (pattern != null && str != null) {
            StringBuilder sb5 = new StringBuilder(str.length());
            Matcher matcher = friendRefPattern.matcher(str);
            int i3 = 0;
            while (matcher.find()) {
                if (matcher.start() >= i3) {
                    sb5.append(replaceSlashCode(str.substring(i3, matcher.start())));
                    sb5.append(str.substring(matcher.start(), matcher.end()));
                }
                i3 = matcher.end();
            }
            sb5.append(replaceSlashCode(str.substring(i3, str.length())));
            return sb5.toString();
        }
        return str;
    }

    public static void loadEmoDrawable() {
    }
}
