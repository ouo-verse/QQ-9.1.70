package com.tencent.mobileqq.search.config;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SearchConfig {
    public static final String ENGINE_CREATE_DISCUSSION = "create_discussion";
    public static final String ENGINE_FAVORITE = "favorite";
    public static final String ENGINE_FILE = "file";
    public static final String ENGINE_FTS_MESSAGE_NT = "fts_message_nt";
    public static final String ENGINE_FUNCTION = "function";
    public static final String ENGINE_LOCAL_INFO = "local_info";
    public static final String ENGINE_MINIPROGRAM = "miniprogram";
    public static final String ENGINE_NET_SEARCH = "net_search";
    public static final String ENGINE_PEOPLE = "people";
    public static final String ENGINE_PUBLIC_ACCOUNT = "public_account";
    public static int contactSearchFieldBaseBit = 24;
    public static int contactSearchIndexBaseBit = 48;
    public static int contactSearchPinyinBaseBit = 58;
    public static int contactSearchRecentBaseBit = 40;
    public static int contactSearchTypeBaseBit = 32;
    public static int engineOrderFavorite = 3;
    public static int engineOrderFeature = 6;
    public static int engineOrderFile = 2;
    public static int engineOrderFunction = 0;
    public static int engineOrderMessage = 5;
    public static int engineOrderNetSearch = 1;
    public static int engineOrderPeople = 7;
    public static int engineOrderPublicAccount = 4;
    public static long fieldAlias = 3;
    public static long fieldDiscussionMemberRemark = 7;
    public static long fieldInteRemark = 6;
    public static long fieldMobileNo = 1;
    public static long fieldNewTroopCard = 8;
    public static long fieldNewTroopNickName = 8;
    public static long fieldNewTroopRemark = 9;
    public static long fieldNickName = 5;
    public static long fieldPhoneContactName = 4;
    public static long fieldPublicAccountDisplayName = 9;
    public static long fieldPublicAccountMark = 11;
    public static long fieldPublicAccountName = 12;
    public static long fieldPublicAccountSummary = 10;
    public static long fieldRemark = 8;
    public static long fieldTroopCard = 6;
    public static long fieldTroopName = 8;
    public static long fieldUin = 2;
    public static long filedDiscussionName = 8;
    public static long indexEqual = 10;
    public static long indexMiddle = 1;
    public static long indexSegmentHit = 4;
    public static long indexSegmentStartHit = 2;
    public static long indexStart = 3;
    public static long indexStartSegmentHit = 5;
    public static volatile boolean isConfigLoaded = false;
    public static int mStructMsgPicSwitch = 0;
    public static long recentTrue = 1;
    public static long stringOrigin = 2;
    public static long stringPinyin = 1;
    public static int troopDurationUnderNotWifi = 72;
    public static int troopDurationUnderWifi = 24;
    public static int troopMemberLimit = 70;
    public static long typeCircleContact = 1;
    public static long typeDiscussion = 7;
    public static long typeDiscussionConversation = 15;
    public static long typeDiscussionConversationMatchMember = 8;
    public static long typeDiscussionConversationMatchTitle = 15;
    public static long typeDiscussionMatchMemberFull = 9;
    public static long typeDiscussionMember = 11;
    public static long typeFriend = 13;
    public static long typeFriendConversation = 15;
    public static long typeFriendNotOftenContact = 12;
    public static long typeFriendSpecialCare = 14;
    public static long typeGameMsgBox = 0;
    public static long typeGlobalTroop = 7;
    public static long typeGlobalTroopConversation = 8;
    public static long typeGlobalTroopMember = 9;
    public static long typeNewTroop = 8;
    public static long typeNewTroopMember = 12;
    public static long typePhoneContact = 10;
    public static long typePublicAccount = 3;
    public static long typePublicAccountConversation = 4;
    public static long typeQidianMaster = 6;
    public static long typeTool = 4;
    public static long typeTroop = 7;
    public static long typeTroopConversation = 15;
    public static long typeTroopMember = 6;
    public static long typeUnbindPhoneContact = 2;
    public static Map<String, Integer> searchEngineOrder = new HashMap();
    public static int voiceSearchSwitch = 0;
    public static int sReduceDiscussionWeight = 1;
    public static boolean needSeparate = false;
    public static String troopMemberUpdateConfigStr = "0|100|2|6,101|500|15|30";
    public static ArrayList<a> troopMemberUpdateConfigs = a("0|100|2|6,101|500|15|30");

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f283100a;

        /* renamed from: b, reason: collision with root package name */
        public int f283101b;

        /* renamed from: c, reason: collision with root package name */
        public int f283102c;

        /* renamed from: d, reason: collision with root package name */
        public int f283103d;

        public String toString() {
            return "TroopMemberSetting{min=" + this.f283100a + ", max=" + this.f283101b + ", wifiLimit=" + this.f283102c + ", xgLimit=" + this.f283103d + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ArrayList<a> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList<>();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        ArrayList<a> arrayList = new ArrayList<>();
        try {
            String[] split = str.split(",");
            if (split != null && split.length > 0) {
                for (String str2 : split) {
                    String[] split2 = str2.trim().split("\\|");
                    if (split2 != null && split2.length == 4) {
                        a aVar = new a();
                        aVar.f283100a = Integer.valueOf(split2[0]).intValue();
                        aVar.f283101b = Integer.valueOf(split2[1]).intValue();
                        aVar.f283102c = Integer.valueOf(split2[2]).intValue() * 24;
                        aVar.f283103d = Integer.valueOf(split2[3]).intValue() * 24;
                        arrayList.add(aVar);
                    }
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("SearchConfigManager", 2, "parseTroopMemberUpdateSetting error: ", e16);
            }
            if (!str.equals("0|100|2|6,101|500|15|30")) {
                return a("0|100|2|6,101|500|15|30");
            }
        }
        QLog.e("SearchConfigManager", 1, "parseTroopMemberUpdateSetting: timeCost = " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms");
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b() {
        engineOrderPeople = 6;
        engineOrderMessage = 5;
        engineOrderPublicAccount = 4;
        engineOrderFavorite = 3;
        engineOrderFile = 2;
        engineOrderNetSearch = 1;
        contactSearchPinyinBaseBit = 58;
        contactSearchRecentBaseBit = 40;
        contactSearchIndexBaseBit = 48;
        contactSearchTypeBaseBit = 32;
        contactSearchFieldBaseBit = 24;
        stringOrigin = 2L;
        stringPinyin = 1L;
        recentTrue = 1L;
        indexEqual = 10L;
        indexStartSegmentHit = 5L;
        indexSegmentHit = 4L;
        indexStart = 3L;
        indexSegmentStartHit = 2L;
        indexMiddle = 1L;
        fieldPublicAccountName = 12L;
        fieldPublicAccountMark = 11L;
        fieldPublicAccountSummary = 10L;
        fieldPublicAccountDisplayName = 9L;
        filedDiscussionName = 8L;
        fieldTroopName = 8L;
        fieldRemark = 8L;
        fieldNewTroopNickName = 8L;
        fieldNewTroopCard = 8L;
        fieldDiscussionMemberRemark = 7L;
        fieldInteRemark = 6L;
        fieldNickName = 5L;
        fieldPhoneContactName = 4L;
        fieldAlias = 3L;
        fieldUin = 2L;
        fieldMobileNo = 1L;
        fieldTroopCard = 6L;
        typeFriendConversation = 15L;
        typeTroopConversation = 15L;
        typeDiscussionConversationMatchTitle = 15L;
        typeDiscussionConversation = 15L;
        typeFriendSpecialCare = 14L;
        typeFriend = 13L;
        typeFriendNotOftenContact = 12L;
        typeNewTroopMember = 12L;
        typeDiscussionMember = 11L;
        typePhoneContact = 10L;
        typeDiscussionMatchMemberFull = 9L;
        typeDiscussionConversationMatchMember = 8L;
        typeNewTroop = 8L;
        typeDiscussion = 7L;
        typeTroop = 7L;
        typeTroopMember = 6L;
        typeTool = 4L;
        typePublicAccountConversation = 4L;
        typePublicAccount = 3L;
        typeUnbindPhoneContact = 2L;
        typeCircleContact = 1L;
        typeGlobalTroopMember = 9L;
        typeGlobalTroop = 7L;
        typeGlobalTroopConversation = 8L;
        troopMemberLimit = 70;
        troopDurationUnderWifi = 24;
        troopDurationUnderNotWifi = 72;
        sReduceDiscussionWeight = 1;
        troopMemberUpdateConfigStr = "0|100|2|6,101|500|15|30";
        troopMemberUpdateConfigs = a("0|100|2|6,101|500|15|30");
        searchEngineOrder = new HashMap();
        voiceSearchSwitch = 0;
        needSeparate = false;
    }
}
