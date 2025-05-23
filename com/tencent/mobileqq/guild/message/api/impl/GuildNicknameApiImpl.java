package com.tencent.mobileqq.guild.message.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildNicknameApi;
import com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNode;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildNicknameApiImpl implements IGuildNicknameApi {
    private static final int GET_NAME_FROM_MR_LIMIT_TIME = 30;
    private static final String OMIT_DOT = "...";
    private static String TAG = "GuildNicknameApiImpl";
    private WeakReference<AppRuntime> appRuntimeWR;

    private static String getCutOffStr(ArrayList<String> arrayList, int i3) {
        String str = "";
        for (int i16 = 0; i16 < arrayList.size() && i16 < i3; i16++) {
            str = str + arrayList.get(i16);
        }
        return str;
    }

    private String getDirectMessageNickName(String str) {
        DirectMessageNode D = DirectMessageNodeRepository.D(str);
        if (D == null) {
            return "";
        }
        String nickName = D.getSource().getNickName();
        String remarkName = D.getSource().getRemarkName();
        if (!TextUtils.isEmpty(remarkName)) {
            return remarkName;
        }
        return nickName;
    }

    private static boolean is4CharsEmoji(String str, int i3, int i16) {
        int i17;
        int codePointAt;
        if (i3 <= 65535 || str.length() <= (i17 = i16 + 2) || (codePointAt = str.codePointAt(i17)) <= 65535 || EmotcationConstants.getDoubleEmoji(i3, codePointAt) == -1) {
            return false;
        }
        return true;
    }

    private boolean isCanGetDisplayNameFromMR(String str, MessageRecord messageRecord) {
        if (!TextUtils.isEmpty(str) && messageRecord != null && str.equals(messageRecord.senderuin)) {
            if (NetConnInfoCenter.getServerTime() - messageRecord.time >= 30) {
                return false;
            }
            return true;
        }
        QLog.d(TAG, 1, "isCanGetDisplayNameFromMR args error.");
        return false;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildNicknameApi
    public int emojiCount(String str) {
        int length = str.length();
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt == 20) {
                i3 += 2;
                if (i3 > length) {
                    break;
                }
                i16++;
            } else if (EmotcationConstants.EMOJI_MAP.get(codePointAt, -1) >= 0) {
                if (codePointAt > 65535) {
                    i3 += 2;
                    if (i3 > length) {
                        break;
                    }
                } else {
                    i3++;
                }
                i16++;
            } else if (is4CharsEmoji(str, codePointAt, i3)) {
                i3 += 4;
                if (i3 > length) {
                    break;
                }
                i16++;
            } else {
                i3++;
            }
        }
        return i16;
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildNicknameApi
    public String getCutoffCompatibleEmoji(String str, int i3) {
        int i16;
        if (str.length() <= i3) {
            return str;
        }
        ArrayList arrayList = new ArrayList();
        int i17 = 0;
        int i18 = 0;
        while (i17 < i3 + 1) {
            try {
                if (i18 >= str.length()) {
                    break;
                }
                int codePointAt = str.codePointAt(i18);
                if (codePointAt == 20) {
                    i16 = i18 + 2;
                    arrayList.add(str.substring(i18, i16));
                } else if (EmotcationConstants.EMOJI_MAP.get(codePointAt, -1) >= 0) {
                    if (codePointAt > 65535) {
                        i16 = i18 + 2;
                        arrayList.add(str.substring(i18, i16));
                    } else {
                        i16 = i18 + 1;
                        arrayList.add(str.substring(i18, i16));
                    }
                } else if (is4CharsEmoji(str, codePointAt, i18)) {
                    i16 = i18 + 4;
                    arrayList.add(str.substring(i18, i16));
                } else {
                    i16 = i18 + 1;
                    arrayList.add(str.substring(i18, i16));
                }
                i17++;
                i18 = i16;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "e:" + e16);
            }
        }
        if (arrayList.size() <= i3) {
            return getCutOffStr(arrayList, i3);
        }
        return getCutOffStr(arrayList, i3 - 1) + "...";
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildNicknameApi
    public String getDisplayName(AppRuntime appRuntime, String str, String str2, MessageRecord messageRecord) {
        DirectMessageNode D;
        if (appRuntime != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            IGPSService iGPSService = (IGPSService) appRuntime.getRuntimeService(IGPSService.class, "");
            if (TextUtils.equals(appRuntime.getCurrentAccountUin(), str2)) {
                str2 = iGPSService.getSelfTinyId();
            }
            if (messageRecord != null && su1.c.c(messageRecord) && (D = DirectMessageNodeRepository.D(str)) != null) {
                str = D.getSource().getGuildId();
            }
            if (isCanGetDisplayNameFromMR(str2, messageRecord)) {
                IGuildMessageUtilsApi iGuildMessageUtilsApi = (IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class);
                String msgGuildMemberNameFromMR = iGuildMessageUtilsApi.getMsgGuildMemberNameFromMR(messageRecord);
                if (TextUtils.isEmpty(msgGuildMemberNameFromMR)) {
                    msgGuildMemberNameFromMR = iGuildMessageUtilsApi.getNickNameFromMR(messageRecord);
                }
                if (!TextUtils.isEmpty(msgGuildMemberNameFromMR)) {
                    return msgGuildMemberNameFromMR;
                }
            }
            return iGPSService.getGuildUserDisplayName(str, str2);
        }
        QLog.e(TAG, 1, "getDisplayName args error!");
        return "";
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildNicknameApi
    public String getDisplayNameForSummary(AppRuntime appRuntime, String str, String str2, MessageRecord messageRecord) {
        DirectMessageNode D;
        String str3 = "";
        if (appRuntime == null) {
            QLog.e(TAG, 1, "app is null while getDisplayName");
            return "";
        }
        if (!StringUtil.isEmpty(str) && !StringUtil.isEmpty(str2)) {
            IGPSService iGPSService = (IGPSService) appRuntime.getRuntimeService(IGPSService.class, "");
            if (TextUtils.equals(appRuntime.getCurrentAccountUin(), str2)) {
                str2 = iGPSService.getSelfTinyId();
            }
            if (messageRecord != null && su1.c.c(messageRecord) && (D = DirectMessageNodeRepository.D(str)) != null) {
                str = D.getSource().getGuildId();
            }
            if (messageRecord != null && !TextUtils.isEmpty(str2) && str2.equals(messageRecord.senderuin)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "getGuildMemberName is empty tid: " + str2 + ", guildId: " + str);
                }
                str3 = ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getMsgGuildMemberNameFromMR(messageRecord);
            }
            if (TextUtils.isEmpty(str3) && messageRecord != null && !TextUtils.isEmpty(str2) && str2.equals(messageRecord.senderuin)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 1, "getGuildUserNick is empty tid: " + str2 + ", guildId: " + str);
                }
                str3 = ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getNickNameFromMR(messageRecord);
            }
            if (TextUtils.isEmpty(str3)) {
                return iGPSService.getGuildUserDisplayName(str, str2);
            }
            return str3;
        }
        QLog.e(TAG, 1, String.format("getDisplayName failed while guildId or tid is null", new Object[0]));
        return "";
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildNicknameApi
    public String removeIncompleteEmoji(String str, int i3) {
        int i16;
        int min = Math.min(str.length(), i3);
        int i17 = 0;
        while (i17 < min) {
            int codePointAt = str.codePointAt(i17);
            if (codePointAt == 20) {
                i16 = i17 + 2;
                if (i16 > min) {
                    break;
                }
                i17 = i16;
            } else if (EmotcationConstants.EMOJI_MAP.get(codePointAt, -1) >= 0) {
                if (codePointAt > 65535) {
                    i16 = i17 + 2;
                    if (i16 > min) {
                        break;
                    }
                    i17 = i16;
                } else {
                    i17++;
                }
            } else if (is4CharsEmoji(str, codePointAt, i17)) {
                i16 = i17 + 4;
                if (i16 > min) {
                    break;
                }
                i17 = i16;
            } else {
                i17++;
            }
        }
        return str.substring(0, i17);
    }
}
